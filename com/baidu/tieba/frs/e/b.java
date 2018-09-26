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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.v;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b {
    public static int dLN;
    private static b dLQ;
    private a dLO;
    private SparseArray<HashSet<String>> dLP;
    private CustomMessageListener aeT = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dLP != null) {
                b.this.dLP.clear();
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
                        aVar.dLT = false;
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
        public long dLS;
        public boolean dLT;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dLT = false;
        }
    }

    public b() {
        dLN = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.aeT);
    }

    public static b aCj() {
        if (dLQ == null) {
            synchronized (v.class) {
                if (dLQ == null) {
                    dLQ = new b();
                }
            }
        }
        return dLQ;
    }

    private boolean aCk() {
        if (this.dLO == null) {
            this.dLO = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dLO.dLT) {
            return true;
        }
        if (this.dLO.isRunning) {
            this.dLO.count++;
            if (currentTimeMillis - this.dLO.dLS < 120000) {
                if (this.dLO.count >= dLN) {
                    this.dLO.dLT = true;
                    a(this.dLO);
                    return true;
                }
            } else {
                this.dLO.isRunning = false;
                this.dLO.count = 0;
            }
        } else {
            this.dLO.isRunning = true;
            this.dLO.dLS = currentTimeMillis;
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
        if (bbVar != null && bbVar.xf()) {
            am amVar = new am("c11717");
            amVar.g(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.al("obj_param2", bbVar.mRecomWeight);
            amVar.al("obj_param1", bbVar.alP);
            amVar.w("obj_locate", 1);
            amVar.al("tid", bbVar.getTid());
            v.akM().a(amVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar) {
        if (aVar != null && aVar.dLH && bbVar != null && bbVar.getTid() != null) {
            if (this.dLP == null) {
                this.dLP = new SparseArray<>();
            }
            if (this.dLP.get(aVar.dLK) == null) {
                this.dLP.put(aVar.dLK, new HashSet<>());
            }
            HashSet<String> hashSet = this.dLP.get(aVar.dLK);
            String tid = bbVar.getTid();
            if (aVar.dLL >= 0) {
                tid = tid + "_" + aVar.dLL;
            }
            if (!hashSet.contains(tid) && !aCk()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.al(ImageViewerConfig.FORUM_ID, aVar.dLJ);
                amVar.w("obj_locate", a(aVar));
                amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar.al("obj_param2", bbVar.mRecomWeight);
                amVar.al("obj_param1", bbVar.mRecomAbTag);
                amVar.al("obj_param3", bbVar.alP);
                amVar.al("tid", bbVar.getTid());
                amVar.w(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.g("exposure_time", System.currentTimeMillis());
                if (aVar.dLK >= 0) {
                    amVar.w(MyBookrackActivityConfig.TAB_ID, aVar.dLK);
                }
                boolean z = (bbVar.xD() == null || (bbVar.xD().byO() == null && bbVar.xD().OX() == null)) ? false : true;
                if (z && bbVar.xD().byO() != null && bbVar.xD().byO().OP() != null && bbVar.xD().byO().OP().size() > 0) {
                    amVar.w("obj_name", bbVar.xD().gWf ? 3 : 2);
                } else {
                    amVar.w("obj_name", z ? 1 : 0);
                }
                boolean z2 = bbVar.getType() == bb.akg;
                amVar.w("thread_type", z2 ? 2 : 1);
                if (z2 && bbVar.wm() != null && !StringUtils.isNull(bbVar.wm().getName_show())) {
                    amVar.al("obj_name", bbVar.wm().getName_show());
                }
                v.akM().a(amVar);
                if (bbVar.xa()) {
                    am amVar2 = new am("c12099");
                    amVar2.al(ImageViewerConfig.FORUM_ID, aVar.dLJ);
                    amVar2.w("obj_locate", a(aVar));
                    amVar2.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                    amVar2.al("obj_param2", bbVar.mRecomWeight);
                    amVar2.al("obj_param1", bbVar.mRecomAbTag);
                    amVar2.al("obj_param3", bbVar.alP);
                    amVar2.al("tid", bbVar.getTid());
                    amVar2.w(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                    amVar2.al("uid", TbadkCoreApplication.getCurrentAccount());
                    v.akM().a(amVar2);
                }
                if (bbVar.wr()) {
                    am amVar3 = new am("c13169");
                    amVar3.al(ImageViewerConfig.FORUM_ID, aVar.dLJ);
                    amVar3.al("tid", bbVar.getTid());
                    amVar3.al("uid", TbadkCoreApplication.getCurrentAccount());
                    v.akM().a(amVar3);
                }
                if (aVar.dLK == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.al(ImageViewerConfig.FORUM_ID, aVar.dLJ);
                    amVar4.al("tid", bbVar.getTid());
                    v.akM().a(amVar4);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dLH && bbVar != null && bbVar.getTid() != null) {
            v.akM().eP(true);
            am amVar = new am("c11438");
            amVar.al(ImageViewerConfig.FORUM_ID, aVar.dLJ);
            amVar.w("obj_locate", a(aVar));
            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.al("obj_param2", bbVar.mRecomWeight);
            amVar.al("obj_param1", bbVar.mRecomAbTag);
            amVar.al("obj_param3", bbVar.alP);
            amVar.al("tid", bbVar.getTid());
            amVar.w("obj_type", i);
            amVar.w(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
            amVar.al("obj_to", ae(bbVar));
            if (aVar.dLK >= 0) {
                amVar.w(MyBookrackActivityConfig.TAB_ID, aVar.dLK);
            }
            amVar.w("thread_type", bbVar.getType() == bb.akg ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bbVar.xa()) {
                am amVar2 = new am("c12098");
                amVar2.al(ImageViewerConfig.FORUM_ID, aVar.dLJ);
                amVar2.w("obj_locate", a(aVar));
                amVar2.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar2.al("obj_param2", bbVar.mRecomWeight);
                amVar2.al("obj_param1", bbVar.mRecomAbTag);
                amVar2.al("obj_param3", bbVar.alP);
                amVar2.al("tid", bbVar.getTid());
                amVar2.w("obj_type", i);
                amVar2.w(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar2.al("obj_to", ae(bbVar));
                TiebaStatic.log(amVar2);
            }
            if (aVar.dLK == 501) {
                am amVar3 = new am("c13260");
                amVar3.al(ImageViewerConfig.FORUM_ID, aVar.dLJ);
                amVar3.al("tid", bbVar.getTid());
                v.akM().a(amVar3);
            }
        }
    }

    private int a(com.baidu.tieba.frs.e.a aVar) {
        if (aVar == null) {
            return 5;
        }
        if (aVar.dLM > 0) {
            return aVar.dLM;
        }
        int i = aVar.dLI;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(com.baidu.tieba.frs.e.a aVar, bb bbVar, int i) {
        if (aVar != null && aVar.dLH && bbVar != null && bbVar.getTid() != null && bbVar.wr()) {
            am amVar = new am("c13170");
            amVar.al(ImageViewerConfig.FORUM_ID, aVar.dLJ);
            amVar.w("obj_locate", i);
            amVar.al("tid", bbVar.getTid());
            TiebaStatic.log(amVar);
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.bbH() != null && lVar.gSN == 1) {
            TiebaStatic.log(new am("c11440").al(ImageViewerConfig.FORUM_ID, lVar.bbH().getId()).w("obj_locate", i).w("obj_type", i2));
        }
    }

    private int R(bb bbVar) {
        if (bbVar.xp() == null || bbVar.xp().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.xp().channelId;
    }

    private String ae(bb bbVar) {
        return bbVar.alQ ? String.valueOf(bbVar.xm()) : String.valueOf(4);
    }
}
