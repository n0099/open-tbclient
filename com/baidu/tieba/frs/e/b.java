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
    public static int dTI;
    private static b dTL;
    private a dTJ;
    private SparseArray<HashSet<String>> dTK;
    private CustomMessageListener ajQ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dTK != null) {
                b.this.dTK.clear();
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
                        aVar.dTO = false;
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
        public long dTN;
        public boolean dTO;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dTO = false;
        }
    }

    public b() {
        dTI = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.ajQ);
    }

    public static b aFC() {
        if (dTL == null) {
            synchronized (v.class) {
                if (dTL == null) {
                    dTL = new b();
                }
            }
        }
        return dTL;
    }

    private boolean aFD() {
        if (this.dTJ == null) {
            this.dTJ = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dTJ.dTO) {
            return true;
        }
        if (this.dTJ.isRunning) {
            this.dTJ.count++;
            if (currentTimeMillis - this.dTJ.dTN < 120000) {
                if (this.dTJ.count >= dTI) {
                    this.dTJ.dTO = true;
                    a(this.dTJ);
                    return true;
                }
            } else {
                this.dTJ.isRunning = false;
                this.dTJ.count = 0;
            }
        } else {
            this.dTJ.isRunning = true;
            this.dTJ.dTN = currentTimeMillis;
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
            v.aoo().a(amVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar) {
        if (aVar != null && aVar.dTC && bbVar != null && bbVar.getTid() != null) {
            if (this.dTK == null) {
                this.dTK = new SparseArray<>();
            }
            if (this.dTK.get(aVar.dTF) == null) {
                this.dTK.put(aVar.dTF, new HashSet<>());
            }
            HashSet<String> hashSet = this.dTK.get(aVar.dTF);
            String tid = bbVar.getTid();
            if (aVar.dTG >= 0) {
                tid = tid + BaseRequestAction.SPLITE + aVar.dTG;
            }
            if (!hashSet.contains(tid) && !aFD()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dTE);
                amVar.x("obj_locate", a(aVar));
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar.ax("obj_param2", bbVar.mRecomWeight);
                amVar.ax("obj_param1", bbVar.mRecomAbTag);
                amVar.ax("obj_param3", bbVar.aqK);
                amVar.ax("tid", bbVar.getTid());
                amVar.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.h("exposure_time", System.currentTimeMillis());
                if (aVar.dTF >= 0) {
                    amVar.x(MyBookrackActivityConfig.TAB_ID, aVar.dTF);
                }
                boolean z = (bbVar.zM() == null || (bbVar.zM().bCd() == null && bbVar.zM().QS() == null)) ? false : true;
                if (z && bbVar.zM().bCd() != null && bbVar.zM().bCd().QK() != null && bbVar.zM().bCd().QK().size() > 0) {
                    amVar.x("obj_name", bbVar.zM().hdA ? 3 : 2);
                } else {
                    amVar.x("obj_name", z ? 1 : 0);
                }
                boolean z2 = bbVar.getType() == bb.apb;
                amVar.x("thread_type", z2 ? 2 : 1);
                if (z2 && bbVar.yv() != null && !StringUtils.isNull(bbVar.yv().getName_show())) {
                    amVar.ax("obj_name", bbVar.yv().getName_show());
                }
                v.aoo().a(amVar);
                if (bbVar.zj()) {
                    am amVar2 = new am("c12099");
                    amVar2.ax(ImageViewerConfig.FORUM_ID, aVar.dTE);
                    amVar2.x("obj_locate", a(aVar));
                    amVar2.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                    amVar2.ax("obj_param2", bbVar.mRecomWeight);
                    amVar2.ax("obj_param1", bbVar.mRecomAbTag);
                    amVar2.ax("obj_param3", bbVar.aqK);
                    amVar2.ax("tid", bbVar.getTid());
                    amVar2.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                    amVar2.ax("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aoo().a(amVar2);
                }
                if (bbVar.yA()) {
                    am amVar3 = new am("c13169");
                    amVar3.ax(ImageViewerConfig.FORUM_ID, aVar.dTE);
                    amVar3.ax("tid", bbVar.getTid());
                    amVar3.ax("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aoo().a(amVar3);
                }
                if (aVar.dTF == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.ax(ImageViewerConfig.FORUM_ID, aVar.dTE);
                    amVar4.ax("tid", bbVar.getTid());
                    v.aoo().a(amVar4);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dTC && bbVar != null && bbVar.getTid() != null) {
            v.aoo().fh(true);
            am amVar = new am("c11438");
            amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dTE);
            amVar.x("obj_locate", a(aVar));
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.ax("obj_param2", bbVar.mRecomWeight);
            amVar.ax("obj_param1", bbVar.mRecomAbTag);
            amVar.ax("obj_param3", bbVar.aqK);
            amVar.ax("tid", bbVar.getTid());
            amVar.x("obj_type", i);
            amVar.x(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
            amVar.ax("obj_to", ae(bbVar));
            if (aVar.dTF >= 0) {
                amVar.x(MyBookrackActivityConfig.TAB_ID, aVar.dTF);
            }
            amVar.x("thread_type", bbVar.getType() == bb.apb ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bbVar.zj()) {
                am amVar2 = new am("c12098");
                amVar2.ax(ImageViewerConfig.FORUM_ID, aVar.dTE);
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
            if (aVar.dTF == 501) {
                am amVar3 = new am("c13260");
                amVar3.ax(ImageViewerConfig.FORUM_ID, aVar.dTE);
                amVar3.ax("tid", bbVar.getTid());
                v.aoo().a(amVar3);
            }
        }
    }

    private int a(com.baidu.tieba.frs.e.a aVar) {
        if (aVar == null) {
            return 5;
        }
        if (aVar.dTH > 0) {
            return aVar.dTH;
        }
        int i = aVar.dTD;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dTC && bbVar != null && bbVar.getTid() != null && bbVar.yA()) {
            am amVar = new am("c13170");
            amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dTE);
            amVar.x("obj_locate", i);
            amVar.ax("tid", bbVar.getTid());
            TiebaStatic.log(amVar);
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.beT() != null && lVar.hai == 1) {
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
