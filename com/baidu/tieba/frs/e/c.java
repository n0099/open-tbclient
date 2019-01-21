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
    public static int eeQ;
    private static c eeT;
    private a eeR;
    private SparseArray<HashSet<String>> eeS;
    private CustomMessageListener aoI = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.eeS != null) {
                c.this.eeS.clear();
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
                        aVar.eeW = false;
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
        public long eeV;
        public boolean eeW;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.eeW = false;
        }
    }

    public c() {
        eeQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.aoI);
    }

    public static c aHW() {
        if (eeT == null) {
            synchronized (v.class) {
                if (eeT == null) {
                    eeT = new c();
                }
            }
        }
        return eeT;
    }

    private boolean aHX() {
        if (this.eeR == null) {
            this.eeR = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.eeR.eeW) {
            return true;
        }
        if (this.eeR.isRunning) {
            this.eeR.count++;
            if (currentTimeMillis - this.eeR.eeV < 120000) {
                if (this.eeR.count >= eeQ) {
                    this.eeR.eeW = true;
                    a(this.eeR);
                    return true;
                }
            } else {
                this.eeR.isRunning = false;
                this.eeR.count = 0;
            }
        } else {
            this.eeR.isRunning = true;
            this.eeR.eeV = currentTimeMillis;
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
            amVar.aB("obj_param1", bbVar.avA);
            amVar.y("obj_locate", 1);
            amVar.aB("tid", bbVar.getTid());
            v.aqP().a(amVar);
        }
    }

    public void a(b bVar, bb bbVar) {
        if (bVar != null && bVar.eeK && bbVar != null && bbVar.getTid() != null) {
            if (this.eeS == null) {
                this.eeS = new SparseArray<>();
            }
            if (this.eeS.get(bVar.eeN) == null) {
                this.eeS.put(bVar.eeN, new HashSet<>());
            }
            HashSet<String> hashSet = this.eeS.get(bVar.eeN);
            String tid = bbVar.getTid();
            if (bVar.eeO >= 0) {
                tid = tid + BaseRequestAction.SPLITE + bVar.eeO;
            }
            if (!hashSet.contains(tid) && !aHX()) {
                hashSet.add(tid);
                am amVar = new am("c11439");
                amVar.aB(ImageViewerConfig.FORUM_ID, bVar.eeM);
                amVar.y("obj_locate", a(bVar));
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar.aB("obj_param2", bbVar.mRecomWeight);
                amVar.aB("obj_param1", bbVar.mRecomAbTag);
                amVar.aB("obj_param3", bbVar.avA);
                amVar.aB("tid", bbVar.getTid());
                amVar.y(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.i("exposure_time", System.currentTimeMillis());
                if (bVar.eeN >= 0) {
                    amVar.y(MyBookrackActivityConfig.TAB_ID, bVar.eeN);
                }
                if (bbVar.awk >= 0) {
                    amVar.y("obj_floor", bbVar.awk);
                }
                boolean z = (bbVar.Bk() == null || (bbVar.Bk().bEU() == null && bbVar.Bk().SF() == null)) ? false : true;
                if (z && bbVar.Bk().bEU() != null && bbVar.Bk().bEU().Sx() != null && bbVar.Bk().bEU().Sx().size() > 0) {
                    amVar.y("obj_name", bbVar.Bk().hqj ? 3 : 2);
                } else {
                    amVar.y("obj_name", z ? 1 : 0);
                }
                boolean z2 = bbVar.getType() == bb.atS;
                amVar.y("thread_type", z2 ? 2 : 1);
                if (z2 && bbVar.zT() != null && !StringUtils.isNull(bbVar.zT().getName_show())) {
                    amVar.aB("obj_name", bbVar.zT().getName_show());
                }
                v.aqP().a(amVar);
                if (bbVar.AH()) {
                    am amVar2 = new am("c12099");
                    amVar2.aB(ImageViewerConfig.FORUM_ID, bVar.eeM);
                    amVar2.y("obj_locate", a(bVar));
                    amVar2.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                    amVar2.aB("obj_param2", bbVar.mRecomWeight);
                    amVar2.aB("obj_param1", bbVar.mRecomAbTag);
                    amVar2.aB("obj_param3", bbVar.avA);
                    amVar2.aB("tid", bbVar.getTid());
                    amVar2.y(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                    amVar2.aB("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aqP().a(amVar2);
                }
                if (bbVar.zY()) {
                    am amVar3 = new am("c13169");
                    amVar3.aB(ImageViewerConfig.FORUM_ID, bVar.eeM);
                    amVar3.aB("tid", bbVar.getTid());
                    amVar3.aB("uid", TbadkCoreApplication.getCurrentAccount());
                    v.aqP().a(amVar3);
                }
                if (bVar.eeN == 501) {
                    am amVar4 = new am("c13259");
                    amVar4.aB(ImageViewerConfig.FORUM_ID, bVar.eeM);
                    amVar4.aB("tid", bbVar.getTid());
                    v.aqP().a(amVar4);
                }
            }
        }
    }

    public void a(b bVar, bb bbVar, int i) {
        if (bVar != null && bVar.eeK && bbVar != null && bbVar.getTid() != null) {
            v.aqP().fy(true);
            am amVar = new am("c11438");
            amVar.aB(ImageViewerConfig.FORUM_ID, bVar.eeM);
            amVar.y("obj_locate", a(bVar));
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
            amVar.aB("obj_param2", bbVar.mRecomWeight);
            amVar.aB("obj_param1", bbVar.mRecomAbTag);
            amVar.aB("obj_param3", bbVar.avA);
            amVar.aB("tid", bbVar.getTid());
            amVar.y("obj_type", i);
            amVar.y(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
            amVar.aB("obj_to", ae(bbVar));
            if (bVar.eeN >= 0) {
                amVar.y(MyBookrackActivityConfig.TAB_ID, bVar.eeN);
            }
            if (bbVar.awk >= 0) {
                amVar.y("obj_floor", bbVar.awk);
            }
            amVar.y("thread_type", bbVar.getType() == bb.atS ? 2 : 1);
            TiebaStatic.log(amVar);
            if (bbVar.AH()) {
                am amVar2 = new am("c12098");
                amVar2.aB(ImageViewerConfig.FORUM_ID, bVar.eeM);
                amVar2.y("obj_locate", a(bVar));
                amVar2.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mRecomSource);
                amVar2.aB("obj_param2", bbVar.mRecomWeight);
                amVar2.aB("obj_param1", bbVar.mRecomAbTag);
                amVar2.aB("obj_param3", bbVar.avA);
                amVar2.aB("tid", bbVar.getTid());
                amVar2.y("obj_type", i);
                amVar2.y(VideoPlayActivityConfig.OBJ_ID, R(bbVar));
                amVar2.aB("obj_to", ae(bbVar));
                TiebaStatic.log(amVar2);
            }
            if (bVar.eeN == 501) {
                am amVar3 = new am("c13260");
                amVar3.aB(ImageViewerConfig.FORUM_ID, bVar.eeM);
                amVar3.aB("tid", bbVar.getTid());
                v.aqP().a(amVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.eeP > 0) {
            return bVar.eeP;
        }
        int i = bVar.eeL;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bb bbVar, int i) {
        if (bVar != null && bVar.eeK && bbVar != null && bbVar.getTid() != null && bbVar.zY()) {
            am amVar = new am("c13170");
            amVar.aB(ImageViewerConfig.FORUM_ID, bVar.eeM);
            amVar.y("obj_locate", i);
            amVar.aB("tid", bbVar.getTid());
            TiebaStatic.log(amVar);
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.bhx() != null && lVar.hmQ == 1) {
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
        return bbVar.avB ? String.valueOf(bbVar.AT()) : String.valueOf(4);
    }
}
