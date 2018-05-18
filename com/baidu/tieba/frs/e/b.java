package com.baidu.tieba.frs.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.v;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b {
    public static int dpw;
    private static b dpz;
    private a dpx;
    private SparseArray<HashSet<String>> dpy;
    private CustomMessageListener UJ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dpy != null) {
                b.this.dpy.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.e.b.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.dpC = false;
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
    /* loaded from: classes2.dex */
    public class a {
        public int count;
        public long dpB;
        public boolean dpC;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dpC = false;
        }
    }

    public b() {
        dpw = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.UJ);
    }

    public static b auG() {
        if (dpz == null) {
            synchronized (v.class) {
                if (dpz == null) {
                    dpz = new b();
                }
            }
        }
        return dpz;
    }

    private boolean auH() {
        if (this.dpx == null) {
            this.dpx = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dpx.dpC) {
            return true;
        }
        if (this.dpx.isRunning) {
            this.dpx.count++;
            if (currentTimeMillis - this.dpx.dpB < 120000) {
                if (this.dpx.count >= dpw) {
                    this.dpx.dpC = true;
                    a(this.dpx);
                    return true;
                }
            } else {
                this.dpx.isRunning = false;
                this.dpx.count = 0;
            }
        } else {
            this.dpx.isRunning = true;
            this.dpx.dpB = currentTimeMillis;
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

    public void V(bd bdVar) {
        if (bdVar != null && bdVar.sF()) {
            al alVar = new al("c11717");
            alVar.f(ImageViewerConfig.FORUM_ID, bdVar.getFid());
            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            alVar.ac("obj_param2", bdVar.mRecomWeight);
            alVar.ac("obj_param1", bdVar.abr);
            alVar.r("obj_locate", 1);
            alVar.ac("tid", bdVar.getTid());
            v.afy().a(alVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar) {
        if (aVar != null && aVar.dpr && bdVar != null && bdVar.getTid() != null) {
            if (this.dpy == null) {
                this.dpy = new SparseArray<>();
            }
            if (this.dpy.get(aVar.dpu) == null) {
                this.dpy.put(aVar.dpu, new HashSet<>());
            }
            HashSet<String> hashSet = this.dpy.get(aVar.dpu);
            String tid = bdVar.getTid();
            if (aVar.dpv >= 0) {
                tid = tid + "_" + aVar.dpv;
            }
            if (!hashSet.contains(tid) && !auH()) {
                hashSet.add(tid);
                al alVar = new al("c11439");
                alVar.ac(ImageViewerConfig.FORUM_ID, aVar.dpt);
                alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                alVar.ac("obj_param2", bdVar.mRecomWeight);
                alVar.ac("obj_param1", bdVar.mRecomAbTag);
                alVar.r("obj_locate", aVar.dps);
                alVar.ac("tid", bdVar.getTid());
                alVar.ac("obj_param3", bdVar.abr);
                alVar.r(VideoPlayActivityConfig.OBJ_ID, M(bdVar));
                alVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
                alVar.f("exposure_time", System.currentTimeMillis());
                if (aVar.dpu >= 0) {
                    alVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dpu);
                }
                boolean z = (bdVar.tb() == null || (bdVar.tb().brZ() == null && bdVar.tb().JP() == null)) ? false : true;
                if (z && bdVar.tb().brZ() != null && bdVar.tb().brZ().JH() != null && bdVar.tb().brZ().JH().size() > 0) {
                    alVar.r("obj_name", bdVar.tb().gyb ? 3 : 2);
                } else {
                    alVar.r("obj_name", z ? 1 : 0);
                }
                alVar.r("thread_type", bdVar.getType() != bd.ZQ ? 1 : 2);
                v.afy().a(alVar);
                if (bdVar.sA()) {
                    al alVar2 = new al("c12099");
                    alVar2.ac(ImageViewerConfig.FORUM_ID, aVar.dpt);
                    alVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                    alVar2.ac("obj_param2", bdVar.mRecomWeight);
                    alVar2.ac("obj_param1", bdVar.mRecomAbTag);
                    alVar2.r("obj_locate", aVar.dps);
                    alVar2.ac("tid", bdVar.getTid());
                    alVar2.ac("obj_param3", bdVar.abr);
                    alVar2.r(VideoPlayActivityConfig.OBJ_ID, M(bdVar));
                    alVar2.ac("uid", TbadkCoreApplication.getCurrentAccount());
                    v.afy().a(alVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar, int i) {
        if (aVar != null && aVar.dpr && bdVar != null && bdVar.getTid() != null) {
            v.afy().eu(true);
            al alVar = new al("c11438");
            alVar.ac(ImageViewerConfig.FORUM_ID, aVar.dpt);
            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            alVar.ac("obj_param2", bdVar.mRecomWeight);
            alVar.ac("obj_param1", bdVar.mRecomAbTag);
            alVar.r("obj_locate", aVar.dps);
            alVar.ac("tid", bdVar.getTid());
            alVar.r("obj_type", i);
            alVar.ac("obj_param3", bdVar.abr);
            alVar.r(VideoPlayActivityConfig.OBJ_ID, M(bdVar));
            alVar.ac("obj_to", W(bdVar));
            if (aVar.dpu >= 0) {
                alVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dpu);
            }
            alVar.r("thread_type", bdVar.getType() == bd.ZQ ? 2 : 1);
            TiebaStatic.log(alVar);
            if (bdVar.sA()) {
                al alVar2 = new al("c12098");
                alVar2.ac(ImageViewerConfig.FORUM_ID, aVar.dpt);
                alVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                alVar2.ac("obj_param2", bdVar.mRecomWeight);
                alVar2.ac("obj_param1", bdVar.mRecomAbTag);
                alVar2.r("obj_locate", aVar.dps);
                alVar2.ac("tid", bdVar.getTid());
                alVar2.r("obj_type", i);
                alVar2.ac("obj_param3", bdVar.abr);
                alVar2.r(VideoPlayActivityConfig.OBJ_ID, M(bdVar));
                alVar2.ac("obj_to", W(bdVar));
                TiebaStatic.log(alVar2);
            }
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.aVq() != null && lVar.guT == 1) {
            TiebaStatic.log(new al("c11440").ac(ImageViewerConfig.FORUM_ID, lVar.aVq().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int M(bd bdVar) {
        if (bdVar.sP() == null || bdVar.sP().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.sP().channelId;
    }

    private String W(bd bdVar) {
        return bdVar.abt ? String.valueOf(bdVar.sM()) : String.valueOf(4);
    }
}
