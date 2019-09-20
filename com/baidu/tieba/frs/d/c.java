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
    public static int fRo;
    private static c fRr;
    private a fRp;
    private SparseArray<HashSet<String>> fRq;
    private CustomMessageListener bDW = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.fRq != null) {
                c.this.fRq.clear();
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
                        aVar.fRu = false;
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
        public long fRt;
        public boolean fRu;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fRu = false;
        }
    }

    public c() {
        fRo = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.bDW);
    }

    public static c bsF() {
        if (fRr == null) {
            synchronized (t.class) {
                if (fRr == null) {
                    fRr = new c();
                }
            }
        }
        return fRr;
    }

    private boolean bsG() {
        if (this.fRp == null) {
            this.fRp = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.fRp.fRu) {
            return true;
        }
        if (this.fRp.isRunning) {
            this.fRp.count++;
            if (currentTimeMillis - this.fRp.fRt < 120000) {
                if (this.fRp.count >= fRo) {
                    this.fRp.fRu = true;
                    a(this.fRp);
                    return true;
                }
            } else {
                this.fRp.isRunning = false;
                this.fRp.count = 0;
            }
        } else {
            this.fRp.isRunning = true;
            this.fRp.fRt = currentTimeMillis;
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
        if (bhVar != null && bhVar.aeh()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bhVar.getTid() != null && !hashSet.contains(bhVar.getTid())) {
                hashSet.add(bhVar.getTid());
                t.bat().c(new an("c11662").P("obj_param1", 1).bT("post_id", bhVar.getTid()));
            }
        }
    }

    public void a(bh bhVar, boolean z) {
        if (bhVar != null) {
            t.bat().c(new an("c12125").bT("tid", bhVar.getId()).P("obj_locate", z ? 2 : 1).n(VideoPlayActivityConfig.OBJ_ID, bhVar.aeV() != null ? bhVar.aeV().live_id : -1L).P("obj_type", 1));
        }
    }

    public void am(bh bhVar) {
        if (bhVar != null && bhVar.afD()) {
            an anVar = new an("c11717");
            anVar.n("fid", bhVar.getFid());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
            anVar.bT("obj_param2", bhVar.mRecomWeight);
            anVar.bT("obj_param1", bhVar.bLX);
            anVar.P("obj_locate", 1);
            anVar.bT("tid", bhVar.getTid());
            t.bat().c(anVar);
        }
    }

    public void a(b bVar, bh bhVar) {
        if (bVar != null && bVar.fRi && bhVar != null && bhVar.getTid() != null) {
            if (this.fRq == null) {
                this.fRq = new SparseArray<>();
            }
            if (this.fRq.get(bVar.fRl) == null) {
                this.fRq.put(bVar.fRl, new HashSet<>());
            }
            HashSet<String> hashSet = this.fRq.get(bVar.fRl);
            String tid = bhVar.getTid();
            if (bVar.fRm >= 0) {
                tid = tid + "_" + bVar.fRm;
            }
            if (!hashSet.contains(tid) && !bsG()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.bT("fid", bVar.fRk);
                anVar.P("obj_locate", a(bVar));
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
                anVar.bT("obj_param2", bhVar.mRecomWeight);
                anVar.bT("obj_param1", bhVar.mRecomAbTag);
                anVar.bT("obj_param3", bhVar.bLX);
                anVar.bT("tid", bhVar.getTid());
                anVar.P(VideoPlayActivityConfig.OBJ_ID, W(bhVar));
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.n("exposure_time", System.currentTimeMillis());
                if (bVar.fRl >= 0) {
                    anVar.P(MyBookrackActivityConfig.TAB_ID, bVar.fRl);
                }
                if (bhVar.bMQ >= 0) {
                    anVar.P("obj_floor", bhVar.bMQ);
                }
                boolean z = (bhVar.aga() == null || (bhVar.aga().cqB() == null && bhVar.aga().azi() == null)) ? false : true;
                if (z && bhVar.aga().cqB() != null && bhVar.aga().cqB().ayZ() != null && bhVar.aga().cqB().ayZ().size() > 0) {
                    anVar.P("obj_name", bhVar.aga().jjh ? 3 : 2);
                } else {
                    anVar.P("obj_name", z ? 1 : 0);
                }
                boolean z2 = bhVar.getType() == bh.bKg;
                anVar.P("thread_type", z2 ? 2 : 1);
                if (z2 && bhVar.aeC() != null && !StringUtils.isNull(bhVar.aeC().getName_show())) {
                    anVar.bT("obj_name", bhVar.aeC().getName_show());
                }
                t.bat().c(anVar);
                if (bhVar.afw()) {
                    an anVar2 = new an("c12099");
                    anVar2.bT("fid", bVar.fRk);
                    anVar2.P("obj_locate", a(bVar));
                    anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
                    anVar2.bT("obj_param2", bhVar.mRecomWeight);
                    anVar2.bT("obj_param1", bhVar.mRecomAbTag);
                    anVar2.bT("obj_param3", bhVar.bLX);
                    anVar2.bT("tid", bhVar.getTid());
                    anVar2.P(VideoPlayActivityConfig.OBJ_ID, W(bhVar));
                    anVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    t.bat().c(anVar2);
                }
                if (bhVar.aeG()) {
                    an anVar3 = new an("c13169");
                    anVar3.bT("fid", bVar.fRk);
                    anVar3.bT("tid", bhVar.getTid());
                    anVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    t.bat().c(anVar3);
                }
                if (bVar.fRl == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.bT("fid", bVar.fRk);
                    anVar4.bT("tid", bhVar.getTid());
                    t.bat().c(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bh bhVar, int i) {
        if (bVar != null && bVar.fRi && bhVar != null && bhVar.getTid() != null) {
            t.bat().iH(true);
            an anVar = new an("c11438");
            anVar.bT("fid", bVar.fRk);
            anVar.P("obj_locate", a(bVar));
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
            anVar.bT("obj_param2", bhVar.mRecomWeight);
            anVar.bT("obj_param1", bhVar.mRecomAbTag);
            anVar.bT("obj_param3", bhVar.bLX);
            anVar.bT("tid", bhVar.getTid());
            anVar.P("obj_type", i);
            anVar.P(VideoPlayActivityConfig.OBJ_ID, W(bhVar));
            anVar.bT("obj_to", an(bhVar));
            if (bVar.fRl >= 0) {
                anVar.P(MyBookrackActivityConfig.TAB_ID, bVar.fRl);
            }
            if (bhVar.bMQ >= 0) {
                anVar.P("obj_floor", bhVar.bMQ);
            }
            anVar.P("thread_type", bhVar.getType() == bh.bKg ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bhVar.afw()) {
                an anVar2 = new an("c12098");
                anVar2.bT("fid", bVar.fRk);
                anVar2.P("obj_locate", a(bVar));
                anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.mRecomSource);
                anVar2.bT("obj_param2", bhVar.mRecomWeight);
                anVar2.bT("obj_param1", bhVar.mRecomAbTag);
                anVar2.bT("obj_param3", bhVar.bLX);
                anVar2.bT("tid", bhVar.getTid());
                anVar2.P("obj_type", i);
                anVar2.P(VideoPlayActivityConfig.OBJ_ID, W(bhVar));
                anVar2.bT("obj_to", an(bhVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.fRl == 501) {
                an anVar3 = new an("c13260");
                anVar3.bT("fid", bVar.fRk);
                anVar3.bT("tid", bhVar.getTid());
                t.bat().c(anVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.fRn > 0) {
            return bVar.fRn;
        }
        int i = bVar.fRj;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bh bhVar, int i) {
        if (bVar != null && bVar.fRi && bhVar != null && bhVar.getTid() != null && bhVar.aeG()) {
            an anVar = new an("c13170");
            anVar.bT("fid", bVar.fRk);
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

    private int W(bh bhVar) {
        if (bhVar.afM() == null || bhVar.afM().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.afM().channelId;
    }

    private String an(bh bhVar) {
        return bhVar.bLY ? String.valueOf(bhVar.afJ()) : String.valueOf(4);
    }
}
