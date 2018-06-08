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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.v;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b {
    public static int dyI;
    private static b dyL;
    private a dyJ;
    private SparseArray<HashSet<String>> dyK;
    private CustomMessageListener acJ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dyK != null) {
                b.this.dyK.clear();
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
                        aVar.dyO = false;
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
        public long dyN;
        public boolean dyO;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dyO = false;
        }
    }

    public b() {
        dyI = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.acJ);
    }

    public static b ayQ() {
        if (dyL == null) {
            synchronized (v.class) {
                if (dyL == null) {
                    dyL = new b();
                }
            }
        }
        return dyL;
    }

    private boolean ayR() {
        if (this.dyJ == null) {
            this.dyJ = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dyJ.dyO) {
            return true;
        }
        if (this.dyJ.isRunning) {
            this.dyJ.count++;
            if (currentTimeMillis - this.dyJ.dyN < 120000) {
                if (this.dyJ.count >= dyI) {
                    this.dyJ.dyO = true;
                    a(this.dyJ);
                    return true;
                }
            } else {
                this.dyJ.isRunning = false;
                this.dyJ.count = 0;
            }
        } else {
            this.dyJ.isRunning = true;
            this.dyJ.dyN = currentTimeMillis;
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
        if (bdVar != null && bdVar.wc()) {
            am amVar = new am("c11717");
            amVar.f(ImageViewerConfig.FORUM_ID, bdVar.getFid());
            amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            amVar.ah("obj_param2", bdVar.mRecomWeight);
            amVar.ah("obj_param1", bdVar.ajv);
            amVar.r("obj_locate", 1);
            amVar.ah("tid", bdVar.getTid());
            v.ajh().a(amVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar) {
        if (aVar != null && aVar.dyD && bdVar != null && bdVar.getTid() != null) {
            if (this.dyK == null) {
                this.dyK = new SparseArray<>();
            }
            if (this.dyK.get(aVar.dyG) == null) {
                this.dyK.put(aVar.dyG, new HashSet<>());
            }
            HashSet<String> hashSet = this.dyK.get(aVar.dyG);
            String tid = bdVar.getTid();
            if (aVar.dyH >= 0) {
                tid = tid + "_" + aVar.dyH;
            }
            if (!hashSet.contains(tid) && !ayR()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.ah(ImageViewerConfig.FORUM_ID, aVar.dyF);
                amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                amVar.ah("obj_param2", bdVar.mRecomWeight);
                amVar.ah("obj_param1", bdVar.mRecomAbTag);
                amVar.r("obj_locate", aVar.dyE);
                amVar.ah("tid", bdVar.getTid());
                amVar.ah("obj_param3", bdVar.ajv);
                amVar.r(VideoPlayActivityConfig.OBJ_ID, M(bdVar));
                amVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.f("exposure_time", System.currentTimeMillis());
                if (aVar.dyG >= 0) {
                    amVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dyG);
                }
                boolean z = (bdVar.wy() == null || (bdVar.wy().bxb() == null && bdVar.wy().No() == null)) ? false : true;
                if (z && bdVar.wy().bxb() != null && bdVar.wy().bxb().Ng() != null && bdVar.wy().bxb().Ng().size() > 0) {
                    amVar.r("obj_name", bdVar.wy().gJA ? 3 : 2);
                } else {
                    amVar.r("obj_name", z ? 1 : 0);
                }
                boolean z2 = bdVar.getType() == bd.ahS;
                amVar.r("thread_type", z2 ? 2 : 1);
                if (z2 && bdVar.vm() != null && !StringUtils.isNull(bdVar.vm().getName_show())) {
                    amVar.ah("obj_name", bdVar.vm().getName_show());
                }
                v.ajh().a(amVar);
                if (bdVar.vX()) {
                    am amVar2 = new am("c12099");
                    amVar2.ah(ImageViewerConfig.FORUM_ID, aVar.dyF);
                    amVar2.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                    amVar2.ah("obj_param2", bdVar.mRecomWeight);
                    amVar2.ah("obj_param1", bdVar.mRecomAbTag);
                    amVar2.r("obj_locate", aVar.dyE);
                    amVar2.ah("tid", bdVar.getTid());
                    amVar2.ah("obj_param3", bdVar.ajv);
                    amVar2.r(VideoPlayActivityConfig.OBJ_ID, M(bdVar));
                    amVar2.ah("uid", TbadkCoreApplication.getCurrentAccount());
                    v.ajh().a(amVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar, int i) {
        if (aVar != null && aVar.dyD && bdVar != null && bdVar.getTid() != null) {
            v.ajh().ey(true);
            am amVar = new am("c11438");
            amVar.ah(ImageViewerConfig.FORUM_ID, aVar.dyF);
            amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            amVar.ah("obj_param2", bdVar.mRecomWeight);
            amVar.ah("obj_param1", bdVar.mRecomAbTag);
            amVar.r("obj_locate", aVar.dyE);
            amVar.ah("tid", bdVar.getTid());
            amVar.r("obj_type", i);
            amVar.ah("obj_param3", bdVar.ajv);
            amVar.r(VideoPlayActivityConfig.OBJ_ID, M(bdVar));
            amVar.ah("obj_to", W(bdVar));
            if (aVar.dyG >= 0) {
                amVar.r(MyBookrackActivityConfig.TAB_ID, aVar.dyG);
            }
            amVar.r("thread_type", bdVar.getType() == bd.ahS ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bdVar.vX()) {
                am amVar2 = new am("c12098");
                amVar2.ah(ImageViewerConfig.FORUM_ID, aVar.dyF);
                amVar2.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                amVar2.ah("obj_param2", bdVar.mRecomWeight);
                amVar2.ah("obj_param1", bdVar.mRecomAbTag);
                amVar2.r("obj_locate", aVar.dyE);
                amVar2.ah("tid", bdVar.getTid());
                amVar2.r("obj_type", i);
                amVar2.ah("obj_param3", bdVar.ajv);
                amVar2.r(VideoPlayActivityConfig.OBJ_ID, M(bdVar));
                amVar2.ah("obj_to", W(bdVar));
                TiebaStatic.log(amVar2);
            }
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.bam() != null && lVar.gGr == 1) {
            TiebaStatic.log(new am("c11440").ah(ImageViewerConfig.FORUM_ID, lVar.bam().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int M(bd bdVar) {
        if (bdVar.wm() == null || bdVar.wm().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.wm().channelId;
    }

    private String W(bd bdVar) {
        return bdVar.ajw ? String.valueOf(bdVar.wj()) : String.valueOf(4);
    }
}
