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
public class c {
    public static int eeP;
    private static c eeS;
    private a eeQ;
    private SparseArray<HashSet<String>> eeR;
    private CustomMessageListener aoH = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.eeR != null) {
                c.this.eeR.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.e.c.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.eeV = false;
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
        public long eeU;
        public boolean eeV;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.eeV = false;
        }
    }

    public c() {
        eeP = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.aoH);
    }

    public static c aHW() {
        if (eeS == null) {
            synchronized (v.class) {
                if (eeS == null) {
                    eeS = new c();
                }
            }
        }
        return eeS;
    }

    private boolean aHX() {
        if (this.eeQ == null) {
            this.eeQ = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.eeQ.eeV) {
            return true;
        }
        if (this.eeQ.isRunning) {
            this.eeQ.count++;
            if (currentTimeMillis - this.eeQ.eeU < 120000) {
                if (this.eeQ.count >= eeP) {
                    this.eeQ.eeV = true;
                    a(this.eeQ);
                    return true;
                }
            } else {
                this.eeQ.isRunning = false;
                this.eeQ.count = 0;
            }
        } else {
            this.eeQ.isRunning = true;
            this.eeQ.eeU = currentTimeMillis;
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
        if (bbVar != null && bbVar.AM()) {
            am amVar = new am("c11717");
            amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.aB("obj_param2", bbVar.mRecomWeight);
            amVar.aB("obj_param1", bbVar.avz);
            amVar.y("obj_locate", 1);
            amVar.aB("tid", bbVar.getTid());
            v.aqP().a(amVar);
        }
    }

    public void a(b bVar, bb bbVar) {
        if (bVar != null && bVar.eeJ && bbVar != null && bbVar.getTid() != null) {
            if (this.eeR == null) {
                this.eeR = new SparseArray<>();
            }
            if (this.eeR.get(bVar.eeM) == null) {
                this.eeR.put(bVar.eeM, new HashSet<>());
            }
            HashSet<String> hashSet = this.eeR.get(bVar.eeM);
            String tid = bbVar.getTid();
            if (bVar.eeN >= 0) {
                tid = tid + BaseRequestAction.SPLITE + bVar.eeN;
            }
            if (!hashSet.contains(tid) && !aHX()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.aB(ImageViewerConfig.FORUM_ID, bVar.eeL);
                amVar.y("obj_locate", a(bVar));
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar.aB("obj_param2", bbVar.mRecomWeight);
                amVar.aB("obj_param1", bbVar.mRecomAbTag);
                amVar.aB("obj_param3", bbVar.avz);
                amVar.aB("tid", bbVar.getTid());
                amVar.y(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.i("exposure_time", System.currentTimeMillis());
                if (bVar.eeM >= 0) {
                    amVar.y(MyBookrackActivityConfig.TAB_ID, bVar.eeM);
                }
                if (bbVar.awj >= 0) {
                    amVar.y("obj_floor", bbVar.awj);
                }
                boolean z = (bbVar.Bk() == null || (bbVar.Bk().bEU() == null && bbVar.Bk().SF() == null)) ? false : true;
                if (z && bbVar.Bk().bEU() != null && bbVar.Bk().bEU().Sx() != null && bbVar.Bk().bEU().Sx().size() > 0) {
                    amVar.y("obj_name", bbVar.Bk().hqi ? 3 : 2);
                } else {
                    amVar.y("obj_name", z ? 1 : 0);
                }
                boolean z2 = bbVar.getType() == bb.atR;
                amVar.y("thread_type", z2 ? 2 : 1);
                if (z2 && bbVar.zT() != null && !StringUtils.isNull(bbVar.zT().getName_show())) {
                    amVar.aB("obj_name", bbVar.zT().getName_show());
                }
                v.aqP().a(amVar);
                if (bbVar.AH()) {
                    am amVar2 = new am("c12099");
                    amVar2.aB(ImageViewerConfig.FORUM_ID, bVar.eeL);
                    amVar2.y("obj_locate", a(bVar));
                    amVar2.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                    amVar2.aB("obj_param2", bbVar.mRecomWeight);
                    amVar2.aB("obj_param1", bbVar.mRecomAbTag);
                    amVar2.aB("obj_param3", bbVar.avz);
                    amVar2.aB("tid", bbVar.getTid());
                    amVar2.y(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                    amVar2.aB("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aqP().a(amVar2);
                }
                if (bbVar.zY()) {
                    am amVar3 = new am("c13169");
                    amVar3.aB(ImageViewerConfig.FORUM_ID, bVar.eeL);
                    amVar3.aB("tid", bbVar.getTid());
                    amVar3.aB("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aqP().a(amVar3);
                }
                if (bVar.eeM == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.aB(ImageViewerConfig.FORUM_ID, bVar.eeL);
                    amVar4.aB("tid", bbVar.getTid());
                    v.aqP().a(amVar4);
                }
            }
        }
    }

    public void a(b bVar, bb bbVar, int i) {
        if (bVar != null && bVar.eeJ && bbVar != null && bbVar.getTid() != null) {
            v.aqP().fy(true);
            am amVar = new am("c11438");
            amVar.aB(ImageViewerConfig.FORUM_ID, bVar.eeL);
            amVar.y("obj_locate", a(bVar));
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.aB("obj_param2", bbVar.mRecomWeight);
            amVar.aB("obj_param1", bbVar.mRecomAbTag);
            amVar.aB("obj_param3", bbVar.avz);
            amVar.aB("tid", bbVar.getTid());
            amVar.y("obj_type", i);
            amVar.y(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
            amVar.aB("obj_to", ae(bbVar));
            if (bVar.eeM >= 0) {
                amVar.y(MyBookrackActivityConfig.TAB_ID, bVar.eeM);
            }
            if (bbVar.awj >= 0) {
                amVar.y("obj_floor", bbVar.awj);
            }
            amVar.y("thread_type", bbVar.getType() == bb.atR ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bbVar.AH()) {
                am amVar2 = new am("c12098");
                amVar2.aB(ImageViewerConfig.FORUM_ID, bVar.eeL);
                amVar2.y("obj_locate", a(bVar));
                amVar2.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar2.aB("obj_param2", bbVar.mRecomWeight);
                amVar2.aB("obj_param1", bbVar.mRecomAbTag);
                amVar2.aB("obj_param3", bbVar.avz);
                amVar2.aB("tid", bbVar.getTid());
                amVar2.y("obj_type", i);
                amVar2.y(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar2.aB("obj_to", ae(bbVar));
                TiebaStatic.log(amVar2);
            }
            if (bVar.eeM == 501) {
                am amVar3 = new am("c13260");
                amVar3.aB(ImageViewerConfig.FORUM_ID, bVar.eeL);
                amVar3.aB("tid", bbVar.getTid());
                v.aqP().a(amVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.eeO > 0) {
            return bVar.eeO;
        }
        int i = bVar.eeK;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bb bbVar, int i) {
        if (bVar != null && bVar.eeJ && bbVar != null && bbVar.getTid() != null && bbVar.zY()) {
            am amVar = new am("c13170");
            amVar.aB(ImageViewerConfig.FORUM_ID, bVar.eeL);
            amVar.y("obj_locate", i);
            amVar.aB("tid", bbVar.getTid());
            TiebaStatic.log(amVar);
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.bhx() != null && lVar.hmP == 1) {
            TiebaStatic.log(new am("c11440").aB(ImageViewerConfig.FORUM_ID, lVar.bhx().getId()).y("obj_locate", i).y("obj_type", i2));
        }
    }

    private int R(bb bbVar) {
        if (bbVar.AW() == null || bbVar.AW().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.AW().channelId;
    }

    private String ae(bb bbVar) {
        return bbVar.avA ? String.valueOf(bbVar.AT()) : String.valueOf(4);
    }
}
