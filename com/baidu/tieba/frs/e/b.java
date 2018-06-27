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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.v;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b {
    public static int dBW;
    private static b dBZ;
    private a dBX;
    private SparseArray<HashSet<String>> dBY;
    private CustomMessageListener acM = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dBY != null) {
                b.this.dBY.clear();
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
                        aVar.dCc = false;
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
        public long dCb;
        public boolean dCc;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dCc = false;
        }
    }

    public b() {
        dBW = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.acM);
    }

    public static b azw() {
        if (dBZ == null) {
            synchronized (v.class) {
                if (dBZ == null) {
                    dBZ = new b();
                }
            }
        }
        return dBZ;
    }

    private boolean azx() {
        if (this.dBX == null) {
            this.dBX = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dBX.dCc) {
            return true;
        }
        if (this.dBX.isRunning) {
            this.dBX.count++;
            if (currentTimeMillis - this.dBX.dCb < 120000) {
                if (this.dBX.count >= dBW) {
                    this.dBX.dCc = true;
                    a(this.dBX);
                    return true;
                }
            } else {
                this.dBX.isRunning = false;
                this.dBX.count = 0;
            }
        } else {
            this.dBX.isRunning = true;
            this.dBX.dCb = currentTimeMillis;
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

    public void aa(bc bcVar) {
        if (bcVar != null && bcVar.wm()) {
            an anVar = new an("c11717");
            anVar.f(ImageViewerConfig.FORUM_ID, bcVar.getFid());
            anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bcVar.mRecomSource);
            anVar.ah("obj_param2", bcVar.mRecomWeight);
            anVar.ah("obj_param1", bcVar.ajQ);
            anVar.r("obj_locate", 1);
            anVar.ah("tid", bcVar.getTid());
            v.aiz().a(anVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bc bcVar) {
        if (aVar != null && aVar.dBR && bcVar != null && bcVar.getTid() != null) {
            if (this.dBY == null) {
                this.dBY = new SparseArray<>();
            }
            if (this.dBY.get(aVar.dBU) == null) {
                this.dBY.put(aVar.dBU, new HashSet<>());
            }
            HashSet<String> hashSet = this.dBY.get(aVar.dBU);
            String tid = bcVar.getTid();
            if (aVar.dBV >= 0) {
                tid = tid + "_" + aVar.dBV;
            }
            if (!hashSet.contains(tid) && !azx()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.ah(ImageViewerConfig.FORUM_ID, aVar.dBT);
                anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bcVar.mRecomSource);
                anVar.ah("obj_param2", bcVar.mRecomWeight);
                anVar.ah("obj_param1", bcVar.mRecomAbTag);
                anVar.r("obj_locate", aVar.dBS);
                anVar.ah("tid", bcVar.getTid());
                anVar.ah("obj_param3", bcVar.ajQ);
                anVar.r(VideoPlayActivityConfig.OBJ_ID, O(bcVar));
                anVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.f("exposure_time", System.currentTimeMillis());
                if (aVar.dBU >= 0) {
                    anVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dBU);
                }
                boolean z = (bcVar.wI() == null || (bcVar.wI().bxE() == null && bcVar.wI().NH() == null)) ? false : true;
                if (z && bcVar.wI().bxE() != null && bcVar.wI().bxE().Nz() != null && bcVar.wI().bxE().Nz().size() > 0) {
                    anVar.r("obj_name", bcVar.wI().gNB ? 3 : 2);
                } else {
                    anVar.r("obj_name", z ? 1 : 0);
                }
                boolean z2 = bcVar.getType() == bc.aik;
                anVar.r("thread_type", z2 ? 2 : 1);
                if (z2 && bcVar.vw() != null && !StringUtils.isNull(bcVar.vw().getName_show())) {
                    anVar.ah("obj_name", bcVar.vw().getName_show());
                }
                v.aiz().a(anVar);
                if (bcVar.wh()) {
                    an anVar2 = new an("c12099");
                    anVar2.ah(ImageViewerConfig.FORUM_ID, aVar.dBT);
                    anVar2.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bcVar.mRecomSource);
                    anVar2.ah("obj_param2", bcVar.mRecomWeight);
                    anVar2.ah("obj_param1", bcVar.mRecomAbTag);
                    anVar2.r("obj_locate", aVar.dBS);
                    anVar2.ah("tid", bcVar.getTid());
                    anVar2.ah("obj_param3", bcVar.ajQ);
                    anVar2.r(VideoPlayActivityConfig.OBJ_ID, O(bcVar));
                    anVar2.ah("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aiz().a(anVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bc bcVar, int i) {
        if (aVar != null && aVar.dBR && bcVar != null && bcVar.getTid() != null) {
            v.aiz().ex(true);
            an anVar = new an("c11438");
            anVar.ah(ImageViewerConfig.FORUM_ID, aVar.dBT);
            anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bcVar.mRecomSource);
            anVar.ah("obj_param2", bcVar.mRecomWeight);
            anVar.ah("obj_param1", bcVar.mRecomAbTag);
            anVar.r("obj_locate", aVar.dBS);
            anVar.ah("tid", bcVar.getTid());
            anVar.r("obj_type", i);
            anVar.ah("obj_param3", bcVar.ajQ);
            anVar.r(VideoPlayActivityConfig.OBJ_ID, O(bcVar));
            anVar.ah("obj_to", ab(bcVar));
            if (aVar.dBU >= 0) {
                anVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dBU);
            }
            anVar.r("thread_type", bcVar.getType() == bc.aik ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bcVar.wh()) {
                an anVar2 = new an("c12098");
                anVar2.ah(ImageViewerConfig.FORUM_ID, aVar.dBT);
                anVar2.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bcVar.mRecomSource);
                anVar2.ah("obj_param2", bcVar.mRecomWeight);
                anVar2.ah("obj_param1", bcVar.mRecomAbTag);
                anVar2.r("obj_locate", aVar.dBS);
                anVar2.ah("tid", bcVar.getTid());
                anVar2.r("obj_type", i);
                anVar2.ah("obj_param3", bcVar.ajQ);
                anVar2.r(VideoPlayActivityConfig.OBJ_ID, O(bcVar));
                anVar2.ah("obj_to", ab(bcVar));
                TiebaStatic.log(anVar2);
            }
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.baT() != null && lVar.gKm == 1) {
            TiebaStatic.log(new an("c11440").ah(ImageViewerConfig.FORUM_ID, lVar.baT().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int O(bc bcVar) {
        if (bcVar.ww() == null || bcVar.ww().channelId <= 0) {
            return 0;
        }
        return (int) bcVar.ww().channelId;
    }

    private String ab(bc bcVar) {
        return bcVar.ajR ? String.valueOf(bcVar.wt()) : String.valueOf(4);
    }
}
