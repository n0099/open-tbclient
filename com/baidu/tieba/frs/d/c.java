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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.t;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class c {
    public static int fOJ;
    private static c fOM;
    private a fOK;
    private SparseArray<HashSet<String>> fOL;
    private CustomMessageListener bDy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.fOL != null) {
                c.this.fOL.clear();
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
                        aVar.fOP = false;
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
        public long fOO;
        public boolean fOP;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fOP = false;
        }
    }

    public c() {
        fOJ = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.bDy);
    }

    public static c brF() {
        if (fOM == null) {
            synchronized (t.class) {
                if (fOM == null) {
                    fOM = new c();
                }
            }
        }
        return fOM;
    }

    private boolean brG() {
        if (this.fOK == null) {
            this.fOK = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.fOK.fOP) {
            return true;
        }
        if (this.fOK.isRunning) {
            this.fOK.count++;
            if (currentTimeMillis - this.fOK.fOO < 120000) {
                if (this.fOK.count >= fOJ) {
                    this.fOK.fOP = true;
                    a(this.fOK);
                    return true;
                }
            } else {
                this.fOK.isRunning = false;
                this.fOK.count = 0;
            }
        } else {
            this.fOK.isRunning = true;
            this.fOK.fOO = currentTimeMillis;
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

    public void a(bg bgVar, HashSet<String> hashSet) {
        if (bgVar != null && bgVar.aec()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bgVar.getTid() != null && !hashSet.contains(bgVar.getTid())) {
                hashSet.add(bgVar.getTid());
                t.aZN().c(new an("c11662").P("obj_param1", 1).bT("post_id", bgVar.getTid()));
            }
        }
    }

    public void a(bg bgVar, boolean z) {
        if (bgVar != null) {
            t.aZN().c(new an("c12125").bT("tid", bgVar.getId()).P("obj_locate", z ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bgVar.aeQ() != null ? bgVar.aeQ().live_id : -1L).P("obj_type", 1));
        }
    }

    public void ak(bg bgVar) {
        if (bgVar != null && bgVar.afy()) {
            an anVar = new an("c11717");
            anVar.l("fid", bgVar.getFid());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
            anVar.bT("obj_param2", bgVar.mRecomWeight);
            anVar.bT("obj_param1", bgVar.bLu);
            anVar.P("obj_locate", 1);
            anVar.bT("tid", bgVar.getTid());
            t.aZN().c(anVar);
        }
    }

    public void a(b bVar, bg bgVar) {
        if (bVar != null && bVar.fOD && bgVar != null && bgVar.getTid() != null) {
            if (this.fOL == null) {
                this.fOL = new SparseArray<>();
            }
            if (this.fOL.get(bVar.fOG) == null) {
                this.fOL.put(bVar.fOG, new HashSet<>());
            }
            HashSet<String> hashSet = this.fOL.get(bVar.fOG);
            String tid = bgVar.getTid();
            if (bVar.fOH >= 0) {
                tid = tid + "_" + bVar.fOH;
            }
            if (!hashSet.contains(tid) && !brG()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.bT("fid", bVar.fOF);
                anVar.P("obj_locate", a(bVar));
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                anVar.bT("obj_param2", bgVar.mRecomWeight);
                anVar.bT("obj_param1", bgVar.mRecomAbTag);
                anVar.bT("obj_param3", bgVar.bLu);
                anVar.bT("tid", bgVar.getTid());
                anVar.P(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.l("exposure_time", System.currentTimeMillis());
                if (bVar.fOG >= 0) {
                    anVar.P(MyBookrackActivityConfig.TAB_ID, bVar.fOG);
                }
                if (bgVar.bMn >= 0) {
                    anVar.P("obj_floor", bgVar.bMn);
                }
                boolean z = (bgVar.afV() == null || (bgVar.afV().cpr() == null && bgVar.afV().ayU() == null)) ? false : true;
                if (z && bgVar.afV().cpr() != null && bgVar.afV().cpr().ayL() != null && bgVar.afV().cpr().ayL().size() > 0) {
                    anVar.P("obj_name", bgVar.afV().jfE ? 3 : 2);
                } else {
                    anVar.P("obj_name", z ? 1 : 0);
                }
                boolean z2 = bgVar.getType() == bg.bJD;
                anVar.P("thread_type", z2 ? 2 : 1);
                if (z2 && bgVar.aex() != null && !StringUtils.isNull(bgVar.aex().getName_show())) {
                    anVar.bT("obj_name", bgVar.aex().getName_show());
                }
                t.aZN().c(anVar);
                if (bgVar.afr()) {
                    an anVar2 = new an("c12099");
                    anVar2.bT("fid", bVar.fOF);
                    anVar2.P("obj_locate", a(bVar));
                    anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                    anVar2.bT("obj_param2", bgVar.mRecomWeight);
                    anVar2.bT("obj_param1", bgVar.mRecomAbTag);
                    anVar2.bT("obj_param3", bgVar.bLu);
                    anVar2.bT("tid", bgVar.getTid());
                    anVar2.P(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
                    anVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aZN().c(anVar2);
                }
                if (bgVar.aeB()) {
                    an anVar3 = new an("c13169");
                    anVar3.bT("fid", bVar.fOF);
                    anVar3.bT("tid", bgVar.getTid());
                    anVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aZN().c(anVar3);
                }
                if (bVar.fOG == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.bT("fid", bVar.fOF);
                    anVar4.bT("tid", bgVar.getTid());
                    t.aZN().c(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bg bgVar, int i) {
        if (bVar != null && bVar.fOD && bgVar != null && bgVar.getTid() != null) {
            t.aZN().iE(true);
            an anVar = new an("c11438");
            anVar.bT("fid", bVar.fOF);
            anVar.P("obj_locate", a(bVar));
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
            anVar.bT("obj_param2", bgVar.mRecomWeight);
            anVar.bT("obj_param1", bgVar.mRecomAbTag);
            anVar.bT("obj_param3", bgVar.bLu);
            anVar.bT("tid", bgVar.getTid());
            anVar.P("obj_type", i);
            anVar.P(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
            anVar.bT("obj_to", al(bgVar));
            if (bVar.fOG >= 0) {
                anVar.P(MyBookrackActivityConfig.TAB_ID, bVar.fOG);
            }
            if (bgVar.bMn >= 0) {
                anVar.P("obj_floor", bgVar.bMn);
            }
            anVar.P("thread_type", bgVar.getType() == bg.bJD ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bgVar.afr()) {
                an anVar2 = new an("c12098");
                anVar2.bT("fid", bVar.fOF);
                anVar2.P("obj_locate", a(bVar));
                anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                anVar2.bT("obj_param2", bgVar.mRecomWeight);
                anVar2.bT("obj_param1", bgVar.mRecomAbTag);
                anVar2.bT("obj_param3", bgVar.bLu);
                anVar2.bT("tid", bgVar.getTid());
                anVar2.P("obj_type", i);
                anVar2.P(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
                anVar2.bT("obj_to", al(bgVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.fOG == 501) {
                an anVar3 = new an("c13260");
                anVar3.bT("fid", bVar.fOF);
                anVar3.bT("tid", bgVar.getTid());
                t.aZN().c(anVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.fOI > 0) {
            return bVar.fOI;
        }
        int i = bVar.fOE;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bg bgVar, int i) {
        if (bVar != null && bVar.fOD && bgVar != null && bgVar.getTid() != null && bgVar.aeB()) {
            an anVar = new an("c13170");
            anVar.bT("fid", bVar.fOF);
            anVar.P("obj_locate", i);
            anVar.bT("tid", bgVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            TiebaStatic.log(new an("c11440").bT("fid", frsViewData.getForum().getId()).P("obj_locate", i).P("obj_type", i2));
        }
    }

    private int U(bg bgVar) {
        if (bgVar.afH() == null || bgVar.afH().channelId <= 0) {
            return 0;
        }
        return (int) bgVar.afH().channelId;
    }

    private String al(bg bgVar) {
        return bgVar.bLv ? String.valueOf(bgVar.afE()) : String.valueOf(4);
    }
}
