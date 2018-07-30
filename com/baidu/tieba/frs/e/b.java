package com.baidu.tieba.frs.e;

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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.v;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b {
    public static int dEI;
    private static b dEL;
    private a dEJ;
    private SparseArray<HashSet<String>> dEK;
    private CustomMessageListener acq = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dEK != null) {
                b.this.dEK.clear();
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
                        aVar.dEO = false;
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
        public long dEN;
        public boolean dEO;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dEO = false;
        }
    }

    public b() {
        dEI = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.acq);
    }

    public static b aAd() {
        if (dEL == null) {
            synchronized (v.class) {
                if (dEL == null) {
                    dEL = new b();
                }
            }
        }
        return dEL;
    }

    private boolean aAe() {
        if (this.dEJ == null) {
            this.dEJ = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dEJ.dEO) {
            return true;
        }
        if (this.dEJ.isRunning) {
            this.dEJ.count++;
            if (currentTimeMillis - this.dEJ.dEN < 120000) {
                if (this.dEJ.count >= dEI) {
                    this.dEJ.dEO = true;
                    a(this.dEJ);
                    return true;
                }
            } else {
                this.dEJ.isRunning = false;
                this.dEJ.count = 0;
            }
        } else {
            this.dEJ.isRunning = true;
            this.dEJ.dEN = currentTimeMillis;
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

    public void ac(bb bbVar) {
        if (bbVar != null && bbVar.wb()) {
            an anVar = new an("c11717");
            anVar.f(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            anVar.af("obj_param2", bbVar.mRecomWeight);
            anVar.af("obj_param1", bbVar.ajn);
            anVar.r("obj_locate", 1);
            anVar.af("tid", bbVar.getTid());
            v.aiY().a(anVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar) {
        if (aVar != null && aVar.dED && bbVar != null && bbVar.getTid() != null) {
            if (this.dEK == null) {
                this.dEK = new SparseArray<>();
            }
            if (this.dEK.get(aVar.dEG) == null) {
                this.dEK.put(aVar.dEG, new HashSet<>());
            }
            HashSet<String> hashSet = this.dEK.get(aVar.dEG);
            String tid = bbVar.getTid();
            if (aVar.dEH >= 0) {
                tid = tid + "_" + aVar.dEH;
            }
            if (!hashSet.contains(tid) && !aAe()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.af(ImageViewerConfig.FORUM_ID, aVar.dEF);
                anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                anVar.af("obj_param2", bbVar.mRecomWeight);
                anVar.af("obj_param1", bbVar.mRecomAbTag);
                anVar.r("obj_locate", aVar.dEE);
                anVar.af("tid", bbVar.getTid());
                anVar.af("obj_param3", bbVar.ajn);
                anVar.r(VideoPlayActivityConfig.OBJ_ID, Q(bbVar));
                anVar.af("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.f("exposure_time", System.currentTimeMillis());
                if (aVar.dEG >= 0) {
                    anVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dEG);
                }
                boolean z = (bbVar.wx() == null || (bbVar.wx().bwh() == null && bbVar.wx().NF() == null)) ? false : true;
                if (z && bbVar.wx().bwh() != null && bbVar.wx().bwh().Nx() != null && bbVar.wx().bwh().Nx().size() > 0) {
                    anVar.r("obj_name", bbVar.wx().gOz ? 3 : 2);
                } else {
                    anVar.r("obj_name", z ? 1 : 0);
                }
                boolean z2 = bbVar.getType() == bb.ahG;
                anVar.r("thread_type", z2 ? 2 : 1);
                if (z2 && bbVar.vk() != null && !StringUtils.isNull(bbVar.vk().getName_show())) {
                    anVar.af("obj_name", bbVar.vk().getName_show());
                }
                v.aiY().a(anVar);
                if (bbVar.vW()) {
                    an anVar2 = new an("c12099");
                    anVar2.af(ImageViewerConfig.FORUM_ID, aVar.dEF);
                    anVar2.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                    anVar2.af("obj_param2", bbVar.mRecomWeight);
                    anVar2.af("obj_param1", bbVar.mRecomAbTag);
                    anVar2.r("obj_locate", aVar.dEE);
                    anVar2.af("tid", bbVar.getTid());
                    anVar2.af("obj_param3", bbVar.ajn);
                    anVar2.r(VideoPlayActivityConfig.OBJ_ID, Q(bbVar));
                    anVar2.af("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aiY().a(anVar2);
                }
                if (bbVar.vp()) {
                    an anVar3 = new an("c13169");
                    anVar3.af(ImageViewerConfig.FORUM_ID, aVar.dEF);
                    anVar3.af("tid", bbVar.getTid());
                    anVar3.af("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aiY().a(anVar3);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dED && bbVar != null && bbVar.getTid() != null) {
            v.aiY().ey(true);
            an anVar = new an("c11438");
            anVar.af(ImageViewerConfig.FORUM_ID, aVar.dEF);
            anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            anVar.af("obj_param2", bbVar.mRecomWeight);
            anVar.af("obj_param1", bbVar.mRecomAbTag);
            anVar.r("obj_locate", aVar.dEE);
            anVar.af("tid", bbVar.getTid());
            anVar.r("obj_type", i);
            anVar.af("obj_param3", bbVar.ajn);
            anVar.r(VideoPlayActivityConfig.OBJ_ID, Q(bbVar));
            anVar.af("obj_to", ad(bbVar));
            if (aVar.dEG >= 0) {
                anVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dEG);
            }
            anVar.r("thread_type", bbVar.getType() == bb.ahG ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bbVar.vW()) {
                an anVar2 = new an("c12098");
                anVar2.af(ImageViewerConfig.FORUM_ID, aVar.dEF);
                anVar2.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                anVar2.af("obj_param2", bbVar.mRecomWeight);
                anVar2.af("obj_param1", bbVar.mRecomAbTag);
                anVar2.r("obj_locate", aVar.dEE);
                anVar2.af("tid", bbVar.getTid());
                anVar2.r("obj_type", i);
                anVar2.af("obj_param3", bbVar.ajn);
                anVar2.r(VideoPlayActivityConfig.OBJ_ID, Q(bbVar));
                anVar2.af("obj_to", ad(bbVar));
                TiebaStatic.log(anVar2);
            }
        }
    }

    public void b(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dED && bbVar != null && bbVar.getTid() != null && bbVar.vp()) {
            an anVar = new an("c13170");
            anVar.af(ImageViewerConfig.FORUM_ID, aVar.dEF);
            anVar.r("obj_locate", i);
            anVar.af("tid", bbVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.aZl() != null && lVar.gLj == 1) {
            TiebaStatic.log(new an("c11440").af(ImageViewerConfig.FORUM_ID, lVar.aZl().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int Q(bb bbVar) {
        if (bbVar.wl() == null || bbVar.wl().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.wl().channelId;
    }

    private String ad(bb bbVar) {
        return bbVar.ajo ? String.valueOf(bbVar.wi()) : String.valueOf(4);
    }
}
