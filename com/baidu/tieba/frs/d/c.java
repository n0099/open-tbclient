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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.t;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class c {
    public static int fJJ;
    private static c fJM;
    private a fJK;
    private SparseArray<HashSet<String>> fJL;
    private CustomMessageListener bCA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.fJL != null) {
                c.this.fJL.clear();
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
                        aVar.fJP = false;
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
        public long fJO;
        public boolean fJP;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fJP = false;
        }
    }

    public c() {
        fJJ = com.baidu.tbadk.core.sharedPref.b.agM().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.bCA);
    }

    public static c bpC() {
        if (fJM == null) {
            synchronized (t.class) {
                if (fJM == null) {
                    fJM = new c();
                }
            }
        }
        return fJM;
    }

    private boolean bpD() {
        if (this.fJK == null) {
            this.fJK = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.fJK.fJP) {
            return true;
        }
        if (this.fJK.isRunning) {
            this.fJK.count++;
            if (currentTimeMillis - this.fJK.fJO < 120000) {
                if (this.fJK.count >= fJJ) {
                    this.fJK.fJP = true;
                    a(this.fJK);
                    return true;
                }
            } else {
                this.fJK.isRunning = false;
                this.fJK.count = 0;
            }
        } else {
            this.fJK.isRunning = true;
            this.fJK.fJO = currentTimeMillis;
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
        if (bgVar != null && bgVar.ada()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bgVar.getTid() != null && !hashSet.contains(bgVar.getTid())) {
                hashSet.add(bgVar.getTid());
                t.aXP().b(new am("c11662").P("obj_param1", 1).bT("post_id", bgVar.getTid()));
            }
        }
    }

    public void a(bg bgVar, boolean z) {
        if (bgVar != null) {
            t.aXP().b(new am("c12125").bT("tid", bgVar.getId()).P("obj_locate", z ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bgVar.adO() != null ? bgVar.adO().live_id : -1L).P("obj_type", 1));
        }
    }

    public void ak(bg bgVar) {
        if (bgVar != null && bgVar.aew()) {
            am amVar = new am("c11717");
            amVar.l("fid", bgVar.getFid());
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
            amVar.bT("obj_param2", bgVar.mRecomWeight);
            amVar.bT("obj_param1", bgVar.bKt);
            amVar.P("obj_locate", 1);
            amVar.bT("tid", bgVar.getTid());
            t.aXP().b(amVar);
        }
    }

    public void a(b bVar, bg bgVar) {
        if (bVar != null && bVar.fJD && bgVar != null && bgVar.getTid() != null) {
            if (this.fJL == null) {
                this.fJL = new SparseArray<>();
            }
            if (this.fJL.get(bVar.fJG) == null) {
                this.fJL.put(bVar.fJG, new HashSet<>());
            }
            HashSet<String> hashSet = this.fJL.get(bVar.fJG);
            String tid = bgVar.getTid();
            if (bVar.fJH >= 0) {
                tid = tid + "_" + bVar.fJH;
            }
            if (!hashSet.contains(tid) && !bpD()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.bT("fid", bVar.fJF);
                amVar.P("obj_locate", a(bVar));
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                amVar.bT("obj_param2", bgVar.mRecomWeight);
                amVar.bT("obj_param1", bgVar.mRecomAbTag);
                amVar.bT("obj_param3", bgVar.bKt);
                amVar.bT("tid", bgVar.getTid());
                amVar.P(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.l("exposure_time", System.currentTimeMillis());
                if (bVar.fJG >= 0) {
                    amVar.P(MyBookrackActivityConfig.TAB_ID, bVar.fJG);
                }
                if (bgVar.bLm >= 0) {
                    amVar.P("obj_floor", bgVar.bLm);
                }
                boolean z = (bgVar.aeT() == null || (bgVar.aeT().cmy() == null && bgVar.aeT().axI() == null)) ? false : true;
                if (z && bgVar.aeT().cmy() != null && bgVar.aeT().cmy().axz() != null && bgVar.aeT().cmy().axz().size() > 0) {
                    amVar.P("obj_name", bgVar.aeT().iZj ? 3 : 2);
                } else {
                    amVar.P("obj_name", z ? 1 : 0);
                }
                boolean z2 = bgVar.getType() == bg.bIC;
                amVar.P("thread_type", z2 ? 2 : 1);
                if (z2 && bgVar.adv() != null && !StringUtils.isNull(bgVar.adv().getName_show())) {
                    amVar.bT("obj_name", bgVar.adv().getName_show());
                }
                t.aXP().b(amVar);
                if (bgVar.aep()) {
                    am amVar2 = new am("c12099");
                    amVar2.bT("fid", bVar.fJF);
                    amVar2.P("obj_locate", a(bVar));
                    amVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                    amVar2.bT("obj_param2", bgVar.mRecomWeight);
                    amVar2.bT("obj_param1", bgVar.mRecomAbTag);
                    amVar2.bT("obj_param3", bgVar.bKt);
                    amVar2.bT("tid", bgVar.getTid());
                    amVar2.P(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
                    amVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aXP().b(amVar2);
                }
                if (bgVar.adz()) {
                    am amVar3 = new am("c13169");
                    amVar3.bT("fid", bVar.fJF);
                    amVar3.bT("tid", bgVar.getTid());
                    amVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aXP().b(amVar3);
                }
                if (bVar.fJG == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.bT("fid", bVar.fJF);
                    amVar4.bT("tid", bgVar.getTid());
                    t.aXP().b(amVar4);
                }
            }
        }
    }

    public void a(b bVar, bg bgVar, int i) {
        if (bVar != null && bVar.fJD && bgVar != null && bgVar.getTid() != null) {
            t.aXP().iv(true);
            am amVar = new am("c11438");
            amVar.bT("fid", bVar.fJF);
            amVar.P("obj_locate", a(bVar));
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
            amVar.bT("obj_param2", bgVar.mRecomWeight);
            amVar.bT("obj_param1", bgVar.mRecomAbTag);
            amVar.bT("obj_param3", bgVar.bKt);
            amVar.bT("tid", bgVar.getTid());
            amVar.P("obj_type", i);
            amVar.P(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
            amVar.bT("obj_to", al(bgVar));
            if (bVar.fJG >= 0) {
                amVar.P(MyBookrackActivityConfig.TAB_ID, bVar.fJG);
            }
            if (bgVar.bLm >= 0) {
                amVar.P("obj_floor", bgVar.bLm);
            }
            amVar.P("thread_type", bgVar.getType() == bg.bIC ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bgVar.aep()) {
                am amVar2 = new am("c12098");
                amVar2.bT("fid", bVar.fJF);
                amVar2.P("obj_locate", a(bVar));
                amVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                amVar2.bT("obj_param2", bgVar.mRecomWeight);
                amVar2.bT("obj_param1", bgVar.mRecomAbTag);
                amVar2.bT("obj_param3", bgVar.bKt);
                amVar2.bT("tid", bgVar.getTid());
                amVar2.P("obj_type", i);
                amVar2.P(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
                amVar2.bT("obj_to", al(bgVar));
                TiebaStatic.log(amVar2);
            }
            if (bVar.fJG == 501) {
                am amVar3 = new am("c13260");
                amVar3.bT("fid", bVar.fJF);
                amVar3.bT("tid", bgVar.getTid());
                t.aXP().b(amVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.fJI > 0) {
            return bVar.fJI;
        }
        int i = bVar.fJE;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bg bgVar, int i) {
        if (bVar != null && bVar.fJD && bgVar != null && bgVar.getTid() != null && bgVar.adz()) {
            am amVar = new am("c13170");
            amVar.bT("fid", bVar.fJF);
            amVar.P("obj_locate", i);
            amVar.bT("tid", bgVar.getTid());
            TiebaStatic.log(amVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            TiebaStatic.log(new am("c11440").bT("fid", frsViewData.getForum().getId()).P("obj_locate", i).P("obj_type", i2));
        }
    }

    private int U(bg bgVar) {
        if (bgVar.aeF() == null || bgVar.aeF().channelId <= 0) {
            return 0;
        }
        return (int) bgVar.aeF().channelId;
    }

    private String al(bg bgVar) {
        return bgVar.bKu ? String.valueOf(bgVar.aeC()) : String.valueOf(4);
    }
}
