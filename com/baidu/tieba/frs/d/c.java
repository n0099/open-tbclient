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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
    public static int ftg;
    private static c ftj;
    private a fth;
    private SparseArray<HashSet<String>> fti;
    private CustomMessageListener bvt = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.fti != null) {
                c.this.fti.clear();
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
                        aVar.ftm = false;
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
        public long ftl;
        public boolean ftm;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.ftm = false;
        }
    }

    public c() {
        ftg = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.bvt);
    }

    public static c bil() {
        if (ftj == null) {
            synchronized (t.class) {
                if (ftj == null) {
                    ftj = new c();
                }
            }
        }
        return ftj;
    }

    private boolean bim() {
        if (this.fth == null) {
            this.fth = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.fth.ftm) {
            return true;
        }
        if (this.fth.isRunning) {
            this.fth.count++;
            if (currentTimeMillis - this.fth.ftl < 120000) {
                if (this.fth.count >= ftg) {
                    this.fth.ftm = true;
                    a(this.fth);
                    return true;
                }
            } else {
                this.fth.isRunning = false;
                this.fth.count = 0;
            }
        } else {
            this.fth.isRunning = true;
            this.fth.ftl = currentTimeMillis;
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
        if (bgVar != null && bgVar.Yw()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bgVar.getTid() != null && !hashSet.contains(bgVar.getTid())) {
                hashSet.add(bgVar.getTid());
                t.aQF().b(new am("c11662").T("obj_param1", 1).bJ("post_id", bgVar.getTid()));
            }
        }
    }

    public void b(bg bgVar, boolean z) {
        if (bgVar != null) {
            t.aQF().b(new am("c12125").bJ("tid", bgVar.getId()).T("obj_locate", z ? 2 : 1).k(VideoPlayActivityConfig.OBJ_ID, bgVar.Zk() != null ? bgVar.Zk().live_id : -1L).T("obj_type", 1));
        }
    }

    public void al(bg bgVar) {
        if (bgVar != null && bgVar.ZS()) {
            am amVar = new am("c11717");
            amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
            amVar.bJ("obj_param2", bgVar.mRecomWeight);
            amVar.bJ("obj_param1", bgVar.bCZ);
            amVar.T("obj_locate", 1);
            amVar.bJ("tid", bgVar.getTid());
            t.aQF().b(amVar);
        }
    }

    public void a(b bVar, bg bgVar) {
        if (bVar != null && bVar.fta && bgVar != null && bgVar.getTid() != null) {
            if (this.fti == null) {
                this.fti = new SparseArray<>();
            }
            if (this.fti.get(bVar.ftd) == null) {
                this.fti.put(bVar.ftd, new HashSet<>());
            }
            HashSet<String> hashSet = this.fti.get(bVar.ftd);
            String tid = bgVar.getTid();
            if (bVar.fte >= 0) {
                tid = tid + "_" + bVar.fte;
            }
            if (!hashSet.contains(tid) && !bim()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.bJ(ImageViewerConfig.FORUM_ID, bVar.ftc);
                amVar.T("obj_locate", a(bVar));
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                amVar.bJ("obj_param2", bgVar.mRecomWeight);
                amVar.bJ("obj_param1", bgVar.mRecomAbTag);
                amVar.bJ("obj_param3", bgVar.bCZ);
                amVar.bJ("tid", bgVar.getTid());
                amVar.T(VideoPlayActivityConfig.OBJ_ID, V(bgVar));
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.k("exposure_time", System.currentTimeMillis());
                if (bVar.ftd >= 0) {
                    amVar.T(MyBookrackActivityConfig.TAB_ID, bVar.ftd);
                }
                if (bgVar.bDR >= 0) {
                    amVar.T("obj_floor", bgVar.bDR);
                }
                boolean z = (bgVar.aap() == null || (bgVar.aap().cev() == null && bgVar.aap().asF() == null)) ? false : true;
                if (z && bgVar.aap().cev() != null && bgVar.aap().cev().asw() != null && bgVar.aap().cev().asw().size() > 0) {
                    amVar.T("obj_name", bgVar.aap().iGH ? 3 : 2);
                } else {
                    amVar.T("obj_name", z ? 1 : 0);
                }
                boolean z2 = bgVar.getType() == bg.bBj;
                amVar.T("thread_type", z2 ? 2 : 1);
                if (z2 && bgVar.YR() != null && !StringUtils.isNull(bgVar.YR().getName_show())) {
                    amVar.bJ("obj_name", bgVar.YR().getName_show());
                }
                t.aQF().b(amVar);
                if (bgVar.ZL()) {
                    am amVar2 = new am("c12099");
                    amVar2.bJ(ImageViewerConfig.FORUM_ID, bVar.ftc);
                    amVar2.T("obj_locate", a(bVar));
                    amVar2.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                    amVar2.bJ("obj_param2", bgVar.mRecomWeight);
                    amVar2.bJ("obj_param1", bgVar.mRecomAbTag);
                    amVar2.bJ("obj_param3", bgVar.bCZ);
                    amVar2.bJ("tid", bgVar.getTid());
                    amVar2.T(VideoPlayActivityConfig.OBJ_ID, V(bgVar));
                    amVar2.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aQF().b(amVar2);
                }
                if (bgVar.YV()) {
                    am amVar3 = new am("c13169");
                    amVar3.bJ(ImageViewerConfig.FORUM_ID, bVar.ftc);
                    amVar3.bJ("tid", bgVar.getTid());
                    amVar3.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aQF().b(amVar3);
                }
                if (bVar.ftd == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.bJ(ImageViewerConfig.FORUM_ID, bVar.ftc);
                    amVar4.bJ("tid", bgVar.getTid());
                    t.aQF().b(amVar4);
                }
            }
        }
    }

    public void a(b bVar, bg bgVar, int i) {
        if (bVar != null && bVar.fta && bgVar != null && bgVar.getTid() != null) {
            t.aQF().hQ(true);
            am amVar = new am("c11438");
            amVar.bJ(ImageViewerConfig.FORUM_ID, bVar.ftc);
            amVar.T("obj_locate", a(bVar));
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
            amVar.bJ("obj_param2", bgVar.mRecomWeight);
            amVar.bJ("obj_param1", bgVar.mRecomAbTag);
            amVar.bJ("obj_param3", bgVar.bCZ);
            amVar.bJ("tid", bgVar.getTid());
            amVar.T("obj_type", i);
            amVar.T(VideoPlayActivityConfig.OBJ_ID, V(bgVar));
            amVar.bJ("obj_to", am(bgVar));
            if (bVar.ftd >= 0) {
                amVar.T(MyBookrackActivityConfig.TAB_ID, bVar.ftd);
            }
            if (bgVar.bDR >= 0) {
                amVar.T("obj_floor", bgVar.bDR);
            }
            amVar.T("thread_type", bgVar.getType() == bg.bBj ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bgVar.ZL()) {
                am amVar2 = new am("c12098");
                amVar2.bJ(ImageViewerConfig.FORUM_ID, bVar.ftc);
                amVar2.T("obj_locate", a(bVar));
                amVar2.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                amVar2.bJ("obj_param2", bgVar.mRecomWeight);
                amVar2.bJ("obj_param1", bgVar.mRecomAbTag);
                amVar2.bJ("obj_param3", bgVar.bCZ);
                amVar2.bJ("tid", bgVar.getTid());
                amVar2.T("obj_type", i);
                amVar2.T(VideoPlayActivityConfig.OBJ_ID, V(bgVar));
                amVar2.bJ("obj_to", am(bgVar));
                TiebaStatic.log(amVar2);
            }
            if (bVar.ftd == 501) {
                am amVar3 = new am("c13260");
                amVar3.bJ(ImageViewerConfig.FORUM_ID, bVar.ftc);
                amVar3.bJ("tid", bgVar.getTid());
                t.aQF().b(amVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.ftf > 0) {
            return bVar.ftf;
        }
        int i = bVar.ftb;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bg bgVar, int i) {
        if (bVar != null && bVar.fta && bgVar != null && bgVar.getTid() != null && bgVar.YV()) {
            am amVar = new am("c13170");
            amVar.bJ(ImageViewerConfig.FORUM_ID, bVar.ftc);
            amVar.T("obj_locate", i);
            amVar.bJ("tid", bgVar.getTid());
            TiebaStatic.log(amVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            TiebaStatic.log(new am("c11440").bJ(ImageViewerConfig.FORUM_ID, frsViewData.getForum().getId()).T("obj_locate", i).T("obj_type", i2));
        }
    }

    private int V(bg bgVar) {
        if (bgVar.aab() == null || bgVar.aab().channelId <= 0) {
            return 0;
        }
        return (int) bgVar.aab().channelId;
    }

    private String am(bg bgVar) {
        return bgVar.bDa ? String.valueOf(bgVar.ZY()) : String.valueOf(4);
    }
}
