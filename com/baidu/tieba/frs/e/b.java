package com.baidu.tieba.frs.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.v;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class b {
    public static int dUP;
    private static b dUS;
    private a dUQ;
    private SparseArray<HashSet<String>> dUR;
    private CustomMessageListener akD = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dUR != null) {
                b.this.dUR.clear();
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
                        aVar.dUV = false;
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
    /* loaded from: classes6.dex */
    public class a {
        public int count;
        public long dUU;
        public boolean dUV;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dUV = false;
        }
    }

    public b() {
        dUP = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.akD);
    }

    public static b aEY() {
        if (dUS == null) {
            synchronized (v.class) {
                if (dUS == null) {
                    dUS = new b();
                }
            }
        }
        return dUS;
    }

    private boolean aEZ() {
        if (this.dUQ == null) {
            this.dUQ = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dUQ.dUV) {
            return true;
        }
        if (this.dUQ.isRunning) {
            this.dUQ.count++;
            if (currentTimeMillis - this.dUQ.dUU < 120000) {
                if (this.dUQ.count >= dUP) {
                    this.dUQ.dUV = true;
                    a(this.dUQ);
                    return true;
                }
            } else {
                this.dUQ.isRunning = false;
                this.dUQ.count = 0;
            }
        } else {
            this.dUQ.isRunning = true;
            this.dUQ.dUU = currentTimeMillis;
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

    public void ad(bb bbVar) {
        if (bbVar != null && bbVar.zv()) {
            am amVar = new am("c11717");
            amVar.h(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.ax("obj_param2", bbVar.mRecomWeight);
            amVar.ax("obj_param1", bbVar.arx);
            amVar.x("obj_locate", 1);
            amVar.ax("tid", bbVar.getTid());
            v.anQ().a(amVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar) {
        if (aVar != null && aVar.dUJ && bbVar != null && bbVar.getTid() != null) {
            if (this.dUR == null) {
                this.dUR = new SparseArray<>();
            }
            if (this.dUR.get(aVar.dUM) == null) {
                this.dUR.put(aVar.dUM, new HashSet<>());
            }
            HashSet<String> hashSet = this.dUR.get(aVar.dUM);
            String tid = bbVar.getTid();
            if (aVar.dUN >= 0) {
                tid = tid + BaseRequestAction.SPLITE + aVar.dUN;
            }
            if (!hashSet.contains(tid) && !aEZ()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dUL);
                amVar.x("obj_locate", a(aVar));
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar.ax("obj_param2", bbVar.mRecomWeight);
                amVar.ax("obj_param1", bbVar.mRecomAbTag);
                amVar.ax("obj_param3", bbVar.arx);
                amVar.ax("tid", bbVar.getTid());
                amVar.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.h("exposure_time", System.currentTimeMillis());
                if (aVar.dUM >= 0) {
                    amVar.x(MyBookrackActivityConfig.TAB_ID, aVar.dUM);
                }
                boolean z = (bbVar.zT() == null || (bbVar.zT().bBz() == null && bbVar.zT().Rb() == null)) ? false : true;
                if (z && bbVar.zT().bBz() != null && bbVar.zT().bBz().QT() != null && bbVar.zT().bBz().QT().size() > 0) {
                    amVar.x("obj_name", bbVar.zT().heY ? 3 : 2);
                } else {
                    amVar.x("obj_name", z ? 1 : 0);
                }
                boolean z2 = bbVar.getType() == bb.apP;
                amVar.x("thread_type", z2 ? 2 : 1);
                if (z2 && bbVar.yC() != null && !StringUtils.isNull(bbVar.yC().getName_show())) {
                    amVar.ax("obj_name", bbVar.yC().getName_show());
                }
                v.anQ().a(amVar);
                if (bbVar.zq()) {
                    am amVar2 = new am("c12099");
                    amVar2.ax(ImageViewerConfig.FORUM_ID, aVar.dUL);
                    amVar2.x("obj_locate", a(aVar));
                    amVar2.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                    amVar2.ax("obj_param2", bbVar.mRecomWeight);
                    amVar2.ax("obj_param1", bbVar.mRecomAbTag);
                    amVar2.ax("obj_param3", bbVar.arx);
                    amVar2.ax("tid", bbVar.getTid());
                    amVar2.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                    amVar2.ax("uid", TbadkCoreApplication.getCurrentAccount());
                    v.anQ().a(amVar2);
                }
                if (bbVar.yH()) {
                    am amVar3 = new am("c13169");
                    amVar3.ax(ImageViewerConfig.FORUM_ID, aVar.dUL);
                    amVar3.ax("tid", bbVar.getTid());
                    amVar3.ax("uid", TbadkCoreApplication.getCurrentAccount());
                    v.anQ().a(amVar3);
                }
                if (aVar.dUM == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.ax(ImageViewerConfig.FORUM_ID, aVar.dUL);
                    amVar4.ax("tid", bbVar.getTid());
                    v.anQ().a(amVar4);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dUJ && bbVar != null && bbVar.getTid() != null) {
            v.anQ().fs(true);
            am amVar = new am("c11438");
            amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dUL);
            amVar.x("obj_locate", a(aVar));
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.ax("obj_param2", bbVar.mRecomWeight);
            amVar.ax("obj_param1", bbVar.mRecomAbTag);
            amVar.ax("obj_param3", bbVar.arx);
            amVar.ax("tid", bbVar.getTid());
            amVar.x("obj_type", i);
            amVar.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
            amVar.ax("obj_to", ae(bbVar));
            if (aVar.dUM >= 0) {
                amVar.x(MyBookrackActivityConfig.TAB_ID, aVar.dUM);
            }
            amVar.x("thread_type", bbVar.getType() == bb.apP ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bbVar.zq()) {
                am amVar2 = new am("c12098");
                amVar2.ax(ImageViewerConfig.FORUM_ID, aVar.dUL);
                amVar2.x("obj_locate", a(aVar));
                amVar2.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar2.ax("obj_param2", bbVar.mRecomWeight);
                amVar2.ax("obj_param1", bbVar.mRecomAbTag);
                amVar2.ax("obj_param3", bbVar.arx);
                amVar2.ax("tid", bbVar.getTid());
                amVar2.x("obj_type", i);
                amVar2.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar2.ax("obj_to", ae(bbVar));
                TiebaStatic.log(amVar2);
            }
            if (aVar.dUM == 501) {
                am amVar3 = new am("c13260");
                amVar3.ax(ImageViewerConfig.FORUM_ID, aVar.dUL);
                amVar3.ax("tid", bbVar.getTid());
                v.anQ().a(amVar3);
            }
        }
    }

    private int a(com.baidu.tieba.frs.e.a aVar) {
        if (aVar == null) {
            return 5;
        }
        if (aVar.dUO > 0) {
            return aVar.dUO;
        }
        int i = aVar.dUK;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dUJ && bbVar != null && bbVar.getTid() != null && bbVar.yH()) {
            am amVar = new am("c13170");
            amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dUL);
            amVar.x("obj_locate", i);
            amVar.ax("tid", bbVar.getTid());
            TiebaStatic.log(amVar);
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.ber() != null && lVar.hbG == 1) {
            TiebaStatic.log(new am("c11440").ax(ImageViewerConfig.FORUM_ID, lVar.ber().getId()).x("obj_locate", i).x("obj_type", i2));
        }
    }

    private int R(bb bbVar) {
        if (bbVar.zF() == null || bbVar.zF().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.zF().channelId;
    }

    private String ae(bb bbVar) {
        return bbVar.ary ? String.valueOf(bbVar.zC()) : String.valueOf(4);
    }
}
