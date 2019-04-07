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
    public static int fsS;
    private static c fsV;
    private a fsT;
    private SparseArray<HashSet<String>> fsU;
    private CustomMessageListener bvw = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.fsU != null) {
                c.this.fsU.clear();
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
                        aVar.fsY = false;
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
        public long fsX;
        public boolean fsY;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fsY = false;
        }
    }

    public c() {
        fsS = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.bvw);
    }

    public static c bij() {
        if (fsV == null) {
            synchronized (t.class) {
                if (fsV == null) {
                    fsV = new c();
                }
            }
        }
        return fsV;
    }

    private boolean bik() {
        if (this.fsT == null) {
            this.fsT = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.fsT.fsY) {
            return true;
        }
        if (this.fsT.isRunning) {
            this.fsT.count++;
            if (currentTimeMillis - this.fsT.fsX < 120000) {
                if (this.fsT.count >= fsS) {
                    this.fsT.fsY = true;
                    a(this.fsT);
                    return true;
                }
            } else {
                this.fsT.isRunning = false;
                this.fsT.count = 0;
            }
        } else {
            this.fsT.isRunning = true;
            this.fsT.fsX = currentTimeMillis;
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
        if (bgVar != null && bgVar.Yt()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bgVar.getTid() != null && !hashSet.contains(bgVar.getTid())) {
                hashSet.add(bgVar.getTid());
                t.aQD().b(new am("c11662").T("obj_param1", 1).bJ("post_id", bgVar.getTid()));
            }
        }
    }

    public void a(bg bgVar, boolean z) {
        if (bgVar != null) {
            t.aQD().b(new am("c12125").bJ("tid", bgVar.getId()).T("obj_locate", z ? 2 : 1).k(VideoPlayActivityConfig.OBJ_ID, bgVar.Zh() != null ? bgVar.Zh().live_id : -1L).T("obj_type", 1));
        }
    }

    public void ak(bg bgVar) {
        if (bgVar != null && bgVar.ZP()) {
            am amVar = new am("c11717");
            amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
            amVar.bJ("obj_param2", bgVar.mRecomWeight);
            amVar.bJ("obj_param1", bgVar.bDc);
            amVar.T("obj_locate", 1);
            amVar.bJ("tid", bgVar.getTid());
            t.aQD().b(amVar);
        }
    }

    public void a(b bVar, bg bgVar) {
        if (bVar != null && bVar.fsM && bgVar != null && bgVar.getTid() != null) {
            if (this.fsU == null) {
                this.fsU = new SparseArray<>();
            }
            if (this.fsU.get(bVar.fsP) == null) {
                this.fsU.put(bVar.fsP, new HashSet<>());
            }
            HashSet<String> hashSet = this.fsU.get(bVar.fsP);
            String tid = bgVar.getTid();
            if (bVar.fsQ >= 0) {
                tid = tid + "_" + bVar.fsQ;
            }
            if (!hashSet.contains(tid) && !bik()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.bJ(ImageViewerConfig.FORUM_ID, bVar.fsO);
                amVar.T("obj_locate", a(bVar));
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                amVar.bJ("obj_param2", bgVar.mRecomWeight);
                amVar.bJ("obj_param1", bgVar.mRecomAbTag);
                amVar.bJ("obj_param3", bgVar.bDc);
                amVar.bJ("tid", bgVar.getTid());
                amVar.T(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.k("exposure_time", System.currentTimeMillis());
                if (bVar.fsP >= 0) {
                    amVar.T(MyBookrackActivityConfig.TAB_ID, bVar.fsP);
                }
                if (bgVar.bDU >= 0) {
                    amVar.T("obj_floor", bgVar.bDU);
                }
                boolean z = (bgVar.aam() == null || (bgVar.aam().cer() == null && bgVar.aam().asC() == null)) ? false : true;
                if (z && bgVar.aam().cer() != null && bgVar.aam().cer().ast() != null && bgVar.aam().cer().ast().size() > 0) {
                    amVar.T("obj_name", bgVar.aam().iGr ? 3 : 2);
                } else {
                    amVar.T("obj_name", z ? 1 : 0);
                }
                boolean z2 = bgVar.getType() == bg.bBm;
                amVar.T("thread_type", z2 ? 2 : 1);
                if (z2 && bgVar.YO() != null && !StringUtils.isNull(bgVar.YO().getName_show())) {
                    amVar.bJ("obj_name", bgVar.YO().getName_show());
                }
                t.aQD().b(amVar);
                if (bgVar.ZI()) {
                    am amVar2 = new am("c12099");
                    amVar2.bJ(ImageViewerConfig.FORUM_ID, bVar.fsO);
                    amVar2.T("obj_locate", a(bVar));
                    amVar2.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                    amVar2.bJ("obj_param2", bgVar.mRecomWeight);
                    amVar2.bJ("obj_param1", bgVar.mRecomAbTag);
                    amVar2.bJ("obj_param3", bgVar.bDc);
                    amVar2.bJ("tid", bgVar.getTid());
                    amVar2.T(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
                    amVar2.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aQD().b(amVar2);
                }
                if (bgVar.YS()) {
                    am amVar3 = new am("c13169");
                    amVar3.bJ(ImageViewerConfig.FORUM_ID, bVar.fsO);
                    amVar3.bJ("tid", bgVar.getTid());
                    amVar3.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                    t.aQD().b(amVar3);
                }
                if (bVar.fsP == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.bJ(ImageViewerConfig.FORUM_ID, bVar.fsO);
                    amVar4.bJ("tid", bgVar.getTid());
                    t.aQD().b(amVar4);
                }
            }
        }
    }

    public void a(b bVar, bg bgVar, int i) {
        if (bVar != null && bVar.fsM && bgVar != null && bgVar.getTid() != null) {
            t.aQD().hQ(true);
            am amVar = new am("c11438");
            amVar.bJ(ImageViewerConfig.FORUM_ID, bVar.fsO);
            amVar.T("obj_locate", a(bVar));
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
            amVar.bJ("obj_param2", bgVar.mRecomWeight);
            amVar.bJ("obj_param1", bgVar.mRecomAbTag);
            amVar.bJ("obj_param3", bgVar.bDc);
            amVar.bJ("tid", bgVar.getTid());
            amVar.T("obj_type", i);
            amVar.T(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
            amVar.bJ("obj_to", al(bgVar));
            if (bVar.fsP >= 0) {
                amVar.T(MyBookrackActivityConfig.TAB_ID, bVar.fsP);
            }
            if (bgVar.bDU >= 0) {
                amVar.T("obj_floor", bgVar.bDU);
            }
            amVar.T("thread_type", bgVar.getType() == bg.bBm ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bgVar.ZI()) {
                am amVar2 = new am("c12098");
                amVar2.bJ(ImageViewerConfig.FORUM_ID, bVar.fsO);
                amVar2.T("obj_locate", a(bVar));
                amVar2.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bgVar.mRecomSource);
                amVar2.bJ("obj_param2", bgVar.mRecomWeight);
                amVar2.bJ("obj_param1", bgVar.mRecomAbTag);
                amVar2.bJ("obj_param3", bgVar.bDc);
                amVar2.bJ("tid", bgVar.getTid());
                amVar2.T("obj_type", i);
                amVar2.T(VideoPlayActivityConfig.OBJ_ID, U(bgVar));
                amVar2.bJ("obj_to", al(bgVar));
                TiebaStatic.log(amVar2);
            }
            if (bVar.fsP == 501) {
                am amVar3 = new am("c13260");
                amVar3.bJ(ImageViewerConfig.FORUM_ID, bVar.fsO);
                amVar3.bJ("tid", bgVar.getTid());
                t.aQD().b(amVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.fsR > 0) {
            return bVar.fsR;
        }
        int i = bVar.fsN;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bg bgVar, int i) {
        if (bVar != null && bVar.fsM && bgVar != null && bgVar.getTid() != null && bgVar.YS()) {
            am amVar = new am("c13170");
            amVar.bJ(ImageViewerConfig.FORUM_ID, bVar.fsO);
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

    private int U(bg bgVar) {
        if (bgVar.ZY() == null || bgVar.ZY().channelId <= 0) {
            return 0;
        }
        return (int) bgVar.ZY().channelId;
    }

    private String al(bg bgVar) {
        return bgVar.bDd ? String.valueOf(bgVar.ZV()) : String.valueOf(4);
    }
}
