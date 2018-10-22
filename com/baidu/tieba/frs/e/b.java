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
    public static int dTJ;
    private static b dTM;
    private a dTK;
    private SparseArray<HashSet<String>> dTL;
    private CustomMessageListener ajQ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dTL != null) {
                b.this.dTL.clear();
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
                        aVar.dTP = false;
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
        public long dTO;
        public boolean dTP;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dTP = false;
        }
    }

    public b() {
        dTJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.ajQ);
    }

    public static b aFC() {
        if (dTM == null) {
            synchronized (v.class) {
                if (dTM == null) {
                    dTM = new b();
                }
            }
        }
        return dTM;
    }

    private boolean aFD() {
        if (this.dTK == null) {
            this.dTK = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dTK.dTP) {
            return true;
        }
        if (this.dTK.isRunning) {
            this.dTK.count++;
            if (currentTimeMillis - this.dTK.dTO < 120000) {
                if (this.dTK.count >= dTJ) {
                    this.dTK.dTP = true;
                    a(this.dTK);
                    return true;
                }
            } else {
                this.dTK.isRunning = false;
                this.dTK.count = 0;
            }
        } else {
            this.dTK.isRunning = true;
            this.dTK.dTO = currentTimeMillis;
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
        if (bbVar != null && bbVar.zo()) {
            am amVar = new am("c11717");
            amVar.h(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.ax("obj_param2", bbVar.mRecomWeight);
            amVar.ax("obj_param1", bbVar.aqK);
            amVar.x("obj_locate", 1);
            amVar.ax("tid", bbVar.getTid());
            v.aop().a(amVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar) {
        if (aVar != null && aVar.dTD && bbVar != null && bbVar.getTid() != null) {
            if (this.dTL == null) {
                this.dTL = new SparseArray<>();
            }
            if (this.dTL.get(aVar.dTG) == null) {
                this.dTL.put(aVar.dTG, new HashSet<>());
            }
            HashSet<String> hashSet = this.dTL.get(aVar.dTG);
            String tid = bbVar.getTid();
            if (aVar.dTH >= 0) {
                tid = tid + BaseRequestAction.SPLITE + aVar.dTH;
            }
            if (!hashSet.contains(tid) && !aFD()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dTF);
                amVar.x("obj_locate", a(aVar));
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar.ax("obj_param2", bbVar.mRecomWeight);
                amVar.ax("obj_param1", bbVar.mRecomAbTag);
                amVar.ax("obj_param3", bbVar.aqK);
                amVar.ax("tid", bbVar.getTid());
                amVar.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.h("exposure_time", System.currentTimeMillis());
                if (aVar.dTG >= 0) {
                    amVar.x(MyBookrackActivityConfig.TAB_ID, aVar.dTG);
                }
                boolean z = (bbVar.zM() == null || (bbVar.zM().bCd() == null && bbVar.zM().QS() == null)) ? false : true;
                if (z && bbVar.zM().bCd() != null && bbVar.zM().bCd().QK() != null && bbVar.zM().bCd().QK().size() > 0) {
                    amVar.x("obj_name", bbVar.zM().hdB ? 3 : 2);
                } else {
                    amVar.x("obj_name", z ? 1 : 0);
                }
                boolean z2 = bbVar.getType() == bb.apb;
                amVar.x("thread_type", z2 ? 2 : 1);
                if (z2 && bbVar.yv() != null && !StringUtils.isNull(bbVar.yv().getName_show())) {
                    amVar.ax("obj_name", bbVar.yv().getName_show());
                }
                v.aop().a(amVar);
                if (bbVar.zj()) {
                    am amVar2 = new am("c12099");
                    amVar2.ax(ImageViewerConfig.FORUM_ID, aVar.dTF);
                    amVar2.x("obj_locate", a(aVar));
                    amVar2.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                    amVar2.ax("obj_param2", bbVar.mRecomWeight);
                    amVar2.ax("obj_param1", bbVar.mRecomAbTag);
                    amVar2.ax("obj_param3", bbVar.aqK);
                    amVar2.ax("tid", bbVar.getTid());
                    amVar2.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                    amVar2.ax("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aop().a(amVar2);
                }
                if (bbVar.yA()) {
                    am amVar3 = new am("c13169");
                    amVar3.ax(ImageViewerConfig.FORUM_ID, aVar.dTF);
                    amVar3.ax("tid", bbVar.getTid());
                    amVar3.ax("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aop().a(amVar3);
                }
                if (aVar.dTG == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.ax(ImageViewerConfig.FORUM_ID, aVar.dTF);
                    amVar4.ax("tid", bbVar.getTid());
                    v.aop().a(amVar4);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dTD && bbVar != null && bbVar.getTid() != null) {
            v.aop().fh(true);
            am amVar = new am("c11438");
            amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dTF);
            amVar.x("obj_locate", a(aVar));
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.ax("obj_param2", bbVar.mRecomWeight);
            amVar.ax("obj_param1", bbVar.mRecomAbTag);
            amVar.ax("obj_param3", bbVar.aqK);
            amVar.ax("tid", bbVar.getTid());
            amVar.x("obj_type", i);
            amVar.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
            amVar.ax("obj_to", ae(bbVar));
            if (aVar.dTG >= 0) {
                amVar.x(MyBookrackActivityConfig.TAB_ID, aVar.dTG);
            }
            amVar.x("thread_type", bbVar.getType() == bb.apb ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bbVar.zj()) {
                am amVar2 = new am("c12098");
                amVar2.ax(ImageViewerConfig.FORUM_ID, aVar.dTF);
                amVar2.x("obj_locate", a(aVar));
                amVar2.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar2.ax("obj_param2", bbVar.mRecomWeight);
                amVar2.ax("obj_param1", bbVar.mRecomAbTag);
                amVar2.ax("obj_param3", bbVar.aqK);
                amVar2.ax("tid", bbVar.getTid());
                amVar2.x("obj_type", i);
                amVar2.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar2.ax("obj_to", ae(bbVar));
                TiebaStatic.log(amVar2);
            }
            if (aVar.dTG == 501) {
                am amVar3 = new am("c13260");
                amVar3.ax(ImageViewerConfig.FORUM_ID, aVar.dTF);
                amVar3.ax("tid", bbVar.getTid());
                v.aop().a(amVar3);
            }
        }
    }

    private int a(com.baidu.tieba.frs.e.a aVar) {
        if (aVar == null) {
            return 5;
        }
        if (aVar.dTI > 0) {
            return aVar.dTI;
        }
        int i = aVar.dTE;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dTD && bbVar != null && bbVar.getTid() != null && bbVar.yA()) {
            am amVar = new am("c13170");
            amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dTF);
            amVar.x("obj_locate", i);
            amVar.ax("tid", bbVar.getTid());
            TiebaStatic.log(amVar);
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.beT() != null && lVar.haj == 1) {
            TiebaStatic.log(new am("c11440").ax(ImageViewerConfig.FORUM_ID, lVar.beT().getId()).x("obj_locate", i).x("obj_type", i2));
        }
    }

    private int R(bb bbVar) {
        if (bbVar.zy() == null || bbVar.zy().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.zy().channelId;
    }

    private String ae(bb bbVar) {
        return bbVar.aqL ? String.valueOf(bbVar.zv()) : String.valueOf(4);
    }
}
