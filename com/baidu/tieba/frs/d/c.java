package com.baidu.tieba.frs.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.t;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class c {
    private static c fPA;
    public static int fPx;
    private a fPy;
    private SparseArray<HashSet<String>> fPz;
    private CustomMessageListener bDy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.fPz != null) {
                c.this.fPz.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.d.c.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fPD = false;
                        aVar.isRunning = false;
                        aVar.count = 0;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        public int count;
        public long fPC;
        public boolean fPD;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fPD = false;
        }
    }

    public c() {
        fPx = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.bDy);
    }

    public static c brS() {
        if (fPA == null) {
            synchronized (t.class) {
                if (fPA == null) {
                    fPA = new c();
                }
            }
        }
        return fPA;
    }

    private boolean brT() {
        if (this.fPy == null) {
            this.fPy = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.fPy.fPD) {
            return true;
        }
        if (this.fPy.isRunning) {
            this.fPy.count++;
            if (currentTimeMillis - this.fPy.fPC < 120000) {
                if (this.fPy.count >= fPx) {
                    this.fPy.fPD = true;
                    a(this.fPy);
                    return true;
                }
            } else {
                this.fPy.isRunning = false;
                this.fPy.count = 0;
            }
        } else {
            this.fPy.isRunning = true;
            this.fPy.fPC = currentTimeMillis;
        }
        return false;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mHandler.removeMessages(5);
        this.mHandler.sendMessageDelayed(obtainMessage, ReportUserInfoModel.TIME_INTERVAL);
    }

    public void a(bh bhVar, HashSet<String> hashSet) {
        if (bhVar != null && bhVar.aed()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bhVar.getTid() != null && !hashSet.contains(bhVar.getTid())) {
                hashSet.add(bhVar.getTid());
                t.aZP().c(new an("c11662").P("obj_param1", 1).bT("post_id", bhVar.getTid()));
            }
        }
    }

    public void a(bh bhVar, boolean z) {
        if (bhVar != null) {
            t.aZP().c(new an("c12125").bT("tid", bhVar.getId()).P("obj_locate", z ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bhVar.aeR() != null ? bhVar.aeR().live_id : -1L).P("obj_type", 1));
        }
    }

    public void al(bh bhVar) {
        if (bhVar != null && bhVar.afz()) {
            an anVar = new an("c11717");
            anVar.l("fid", bhVar.getFid());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
            anVar.bT("obj_param2", bhVar.mRecomWeight);
            anVar.bT("obj_param1", bhVar.bLz);
            anVar.P("obj_locate", 1);
            anVar.bT("tid", bhVar.getTid());
            t.aZP().c(anVar);
        }
    }

    public void a(b bVar, bh bhVar) {
        if (bVar != null && bVar.fPr && bhVar != null && bhVar.getTid() != null) {
            if (this.fPz == null) {
                this.fPz = new SparseArray<>();
            }
            if (this.fPz.get(bVar.fPu) == null) {
                this.fPz.put(bVar.fPu, new HashSet<>());
            }
            HashSet<String> hashSet = this.fPz.get(bVar.fPu);
            String tid = bhVar.getTid();
            if (bVar.fPv >= 0) {
                tid = tid + "_" + bVar.fPv;
            }
            if (!hashSet.contains(tid) && !brT()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.bT("fid", bVar.fPt);
                anVar.P("obj_locate", a(bVar));
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
                anVar.bT("obj_param2", bhVar.mRecomWeight);
                anVar.bT("obj_param1", bhVar.mRecomAbTag);
                anVar.bT("obj_param3", bhVar.bLz);
                anVar.bT("tid", bhVar.getTid());
                anVar.P(VideoPlayActivityConfig.OBJ_ID, V(bhVar));
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.l("exposure_time", System.currentTimeMillis());
                if (bVar.fPu >= 0) {
                    anVar.P(MyBookrackActivityConfig.TAB_ID, bVar.fPu);
                }
                if (bhVar.bMs >= 0) {
                    anVar.P("obj_floor", bhVar.bMs);
                }
                boolean z = (bhVar.afW() == null || (bhVar.afW().cpN() == null && bhVar.afW().ayW() == null)) ? false : true;
                if (z && bhVar.afW().cpN() != null && bhVar.afW().cpN().ayN() != null && bhVar.afW().cpN().ayN().size() > 0) {
                    anVar.P("obj_name", bhVar.afW().jgL ? 3 : 2);
                } else {
                    anVar.P("obj_name", z ? 1 : 0);
                }
                boolean z2 = bhVar.getType() == bh.bJI;
                anVar.P("thread_type", z2 ? 2 : 1);
                if (z2 && bhVar.aey() != null && !StringUtils.isNull(bhVar.aey().getName_show())) {
                    anVar.bT("obj_name", bhVar.aey().getName_show());
                }
                t.aZP().c(anVar);
                if (bhVar.afs()) {
                    an anVar2 = new an("c12099");
                    anVar2.bT("fid", bVar.fPt);
                    anVar2.P("obj_locate", a(bVar));
                    anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
                    anVar2.bT("obj_param2", bhVar.mRecomWeight);
                    anVar2.bT("obj_param1", bhVar.mRecomAbTag);
                    anVar2.bT("obj_param3", bhVar.bLz);
                    anVar2.bT("tid", bhVar.getTid());
                    anVar2.P(VideoPlayActivityConfig.OBJ_ID, V(bhVar));
                    anVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aZP().c(anVar2);
                }
                if (bhVar.aeC()) {
                    an anVar3 = new an("c13169");
                    anVar3.bT("fid", bVar.fPt);
                    anVar3.bT("tid", bhVar.getTid());
                    anVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aZP().c(anVar3);
                }
                if (bVar.fPu == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.bT("fid", bVar.fPt);
                    anVar4.bT("tid", bhVar.getTid());
                    t.aZP().c(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bh bhVar, int i) {
        if (bVar != null && bVar.fPr && bhVar != null && bhVar.getTid() != null) {
            t.aZP().iE(true);
            an anVar = new an("c11438");
            anVar.bT("fid", bVar.fPt);
            anVar.P("obj_locate", a(bVar));
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
            anVar.bT("obj_param2", bhVar.mRecomWeight);
            anVar.bT("obj_param1", bhVar.mRecomAbTag);
            anVar.bT("obj_param3", bhVar.bLz);
            anVar.bT("tid", bhVar.getTid());
            anVar.P("obj_type", i);
            anVar.P(VideoPlayActivityConfig.OBJ_ID, V(bhVar));
            anVar.bT("obj_to", am(bhVar));
            if (bVar.fPu >= 0) {
                anVar.P(MyBookrackActivityConfig.TAB_ID, bVar.fPu);
            }
            if (bhVar.bMs >= 0) {
                anVar.P("obj_floor", bhVar.bMs);
            }
            anVar.P("thread_type", bhVar.getType() == bh.bJI ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bhVar.afs()) {
                an anVar2 = new an("c12098");
                anVar2.bT("fid", bVar.fPt);
                anVar2.P("obj_locate", a(bVar));
                anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
                anVar2.bT("obj_param2", bhVar.mRecomWeight);
                anVar2.bT("obj_param1", bhVar.mRecomAbTag);
                anVar2.bT("obj_param3", bhVar.bLz);
                anVar2.bT("tid", bhVar.getTid());
                anVar2.P("obj_type", i);
                anVar2.P(VideoPlayActivityConfig.OBJ_ID, V(bhVar));
                anVar2.bT("obj_to", am(bhVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.fPu == 501) {
                an anVar3 = new an("c13260");
                anVar3.bT("fid", bVar.fPt);
                anVar3.bT("tid", bhVar.getTid());
                t.aZP().c(anVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.fPw > 0) {
            return bVar.fPw;
        }
        int i = bVar.fPs;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bh bhVar, int i) {
        if (bVar != null && bVar.fPr && bhVar != null && bhVar.getTid() != null && bhVar.aeC()) {
            an anVar = new an("c13170");
            anVar.bT("fid", bVar.fPt);
            anVar.P("obj_locate", i);
            anVar.bT("tid", bhVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            TiebaStatic.log(new an("c11440").bT("fid", frsViewData.getForum().getId()).P("obj_locate", i).P("obj_type", i2));
        }
    }

    private int V(bh bhVar) {
        if (bhVar.afI() == null || bhVar.afI().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.afI().channelId;
    }

    private String am(bh bhVar) {
        return bhVar.bLA ? String.valueOf(bhVar.afF()) : String.valueOf(4);
    }
}
