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
    public static int dEF;
    private static b dEI;
    private a dEG;
    private SparseArray<HashSet<String>> dEH;
    private CustomMessageListener acr = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dEH != null) {
                b.this.dEH.clear();
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
                        aVar.dEL = false;
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
        public long dEK;
        public boolean dEL;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dEL = false;
        }
    }

    public b() {
        dEF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.acr);
    }

    public static b aAa() {
        if (dEI == null) {
            synchronized (v.class) {
                if (dEI == null) {
                    dEI = new b();
                }
            }
        }
        return dEI;
    }

    private boolean aAb() {
        if (this.dEG == null) {
            this.dEG = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dEG.dEL) {
            return true;
        }
        if (this.dEG.isRunning) {
            this.dEG.count++;
            if (currentTimeMillis - this.dEG.dEK < 120000) {
                if (this.dEG.count >= dEF) {
                    this.dEG.dEL = true;
                    a(this.dEG);
                    return true;
                }
            } else {
                this.dEG.isRunning = false;
                this.dEG.count = 0;
            }
        } else {
            this.dEG.isRunning = true;
            this.dEG.dEK = currentTimeMillis;
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
        if (bbVar != null && bbVar.wa()) {
            an anVar = new an("c11717");
            anVar.f(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            anVar.ae("obj_param2", bbVar.mRecomWeight);
            anVar.ae("obj_param1", bbVar.ajn);
            anVar.r("obj_locate", 1);
            anVar.ae("tid", bbVar.getTid());
            v.ajb().a(anVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar) {
        if (aVar != null && aVar.dEA && bbVar != null && bbVar.getTid() != null) {
            if (this.dEH == null) {
                this.dEH = new SparseArray<>();
            }
            if (this.dEH.get(aVar.dED) == null) {
                this.dEH.put(aVar.dED, new HashSet<>());
            }
            HashSet<String> hashSet = this.dEH.get(aVar.dED);
            String tid = bbVar.getTid();
            if (aVar.dEE >= 0) {
                tid = tid + "_" + aVar.dEE;
            }
            if (!hashSet.contains(tid) && !aAb()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.ae(ImageViewerConfig.FORUM_ID, aVar.dEC);
                anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                anVar.ae("obj_param2", bbVar.mRecomWeight);
                anVar.ae("obj_param1", bbVar.mRecomAbTag);
                anVar.r("obj_locate", aVar.dEB);
                anVar.ae("tid", bbVar.getTid());
                anVar.ae("obj_param3", bbVar.ajn);
                anVar.r(VideoPlayActivityConfig.OBJ_ID, Q(bbVar));
                anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.f("exposure_time", System.currentTimeMillis());
                if (aVar.dED >= 0) {
                    anVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dED);
                }
                boolean z = (bbVar.ww() == null || (bbVar.ww().bwi() == null && bbVar.ww().NE() == null)) ? false : true;
                if (z && bbVar.ww().bwi() != null && bbVar.ww().bwi().Nw() != null && bbVar.ww().bwi().Nw().size() > 0) {
                    anVar.r("obj_name", bbVar.ww().gOB ? 3 : 2);
                } else {
                    anVar.r("obj_name", z ? 1 : 0);
                }
                boolean z2 = bbVar.getType() == bb.ahG;
                anVar.r("thread_type", z2 ? 2 : 1);
                if (z2 && bbVar.vj() != null && !StringUtils.isNull(bbVar.vj().getName_show())) {
                    anVar.ae("obj_name", bbVar.vj().getName_show());
                }
                v.ajb().a(anVar);
                if (bbVar.vV()) {
                    an anVar2 = new an("c12099");
                    anVar2.ae(ImageViewerConfig.FORUM_ID, aVar.dEC);
                    anVar2.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                    anVar2.ae("obj_param2", bbVar.mRecomWeight);
                    anVar2.ae("obj_param1", bbVar.mRecomAbTag);
                    anVar2.r("obj_locate", aVar.dEB);
                    anVar2.ae("tid", bbVar.getTid());
                    anVar2.ae("obj_param3", bbVar.ajn);
                    anVar2.r(VideoPlayActivityConfig.OBJ_ID, Q(bbVar));
                    anVar2.ae("uid", TbadkCoreApplication.getCurrentAccount());
                    v.ajb().a(anVar2);
                }
                if (bbVar.vo()) {
                    an anVar3 = new an("c13169");
                    anVar3.ae(ImageViewerConfig.FORUM_ID, aVar.dEC);
                    anVar3.ae("tid", bbVar.getTid());
                    anVar3.ae("uid", TbadkCoreApplication.getCurrentAccount());
                    v.ajb().a(anVar3);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dEA && bbVar != null && bbVar.getTid() != null) {
            v.ajb().ey(true);
            an anVar = new an("c11438");
            anVar.ae(ImageViewerConfig.FORUM_ID, aVar.dEC);
            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            anVar.ae("obj_param2", bbVar.mRecomWeight);
            anVar.ae("obj_param1", bbVar.mRecomAbTag);
            anVar.r("obj_locate", aVar.dEB);
            anVar.ae("tid", bbVar.getTid());
            anVar.r("obj_type", i);
            anVar.ae("obj_param3", bbVar.ajn);
            anVar.r(VideoPlayActivityConfig.OBJ_ID, Q(bbVar));
            anVar.ae("obj_to", ad(bbVar));
            if (aVar.dED >= 0) {
                anVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dED);
            }
            anVar.r("thread_type", bbVar.getType() == bb.ahG ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bbVar.vV()) {
                an anVar2 = new an("c12098");
                anVar2.ae(ImageViewerConfig.FORUM_ID, aVar.dEC);
                anVar2.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                anVar2.ae("obj_param2", bbVar.mRecomWeight);
                anVar2.ae("obj_param1", bbVar.mRecomAbTag);
                anVar2.r("obj_locate", aVar.dEB);
                anVar2.ae("tid", bbVar.getTid());
                anVar2.r("obj_type", i);
                anVar2.ae("obj_param3", bbVar.ajn);
                anVar2.r(VideoPlayActivityConfig.OBJ_ID, Q(bbVar));
                anVar2.ae("obj_to", ad(bbVar));
                TiebaStatic.log(anVar2);
            }
        }
    }

    public void b(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dEA && bbVar != null && bbVar.getTid() != null && bbVar.vo()) {
            an anVar = new an("c13170");
            anVar.ae(ImageViewerConfig.FORUM_ID, aVar.dEC);
            anVar.r("obj_locate", i);
            anVar.ae("tid", bbVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.aZg() != null && lVar.gLl == 1) {
            TiebaStatic.log(new an("c11440").ae(ImageViewerConfig.FORUM_ID, lVar.aZg().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int Q(bb bbVar) {
        if (bbVar.wk() == null || bbVar.wk().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.wk().channelId;
    }

    private String ad(bb bbVar) {
        return bbVar.ajo ? String.valueOf(bbVar.wh()) : String.valueOf(4);
    }
}
