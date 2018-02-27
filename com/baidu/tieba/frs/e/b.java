package com.baidu.tieba.frs.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.r;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b {
    public static int dTX;
    private static b dUa;
    private a dTY;
    private SparseArray<HashSet<String>> dTZ;
    private CustomMessageListener aJr = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dTZ != null) {
                b.this.dTZ.clear();
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
                        aVar.dUd = false;
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
        public long dUc;
        public boolean dUd;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dUd = false;
        }
    }

    public b() {
        dTX = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.aJr);
    }

    public static b azQ() {
        if (dUa == null) {
            synchronized (r.class) {
                if (dUa == null) {
                    dUa = new b();
                }
            }
        }
        return dUa;
    }

    private boolean azR() {
        if (this.dTY == null) {
            this.dTY = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dTY.dUd) {
            return true;
        }
        if (this.dTY.isRunning) {
            this.dTY.count++;
            if (currentTimeMillis - this.dTY.dUc < 120000) {
                if (this.dTY.count >= dTX) {
                    this.dTY.dUd = true;
                    a(this.dTY);
                    return true;
                }
            } else {
                this.dTY.isRunning = false;
                this.dTY.count = 0;
            }
        } else {
            this.dTY.isRunning = true;
            this.dTY.dUc = currentTimeMillis;
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

    public void U(bd bdVar) {
        if (bdVar != null && bdVar.Ae()) {
            ak akVar = new ak("c11717");
            akVar.f(ImageViewerConfig.FORUM_ID, bdVar.getFid());
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            akVar.ab("obj_param2", bdVar.mRecomWeight);
            akVar.ab("obj_param1", bdVar.aPR);
            akVar.s("obj_locate", 1);
            akVar.ab("tid", bdVar.getTid());
            r.als().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar) {
        if (aVar != null && aVar.dTS && bdVar != null && bdVar.getTid() != null) {
            if (this.dTZ == null) {
                this.dTZ = new SparseArray<>();
            }
            if (this.dTZ.get(aVar.dTV) == null) {
                this.dTZ.put(aVar.dTV, new HashSet<>());
            }
            HashSet<String> hashSet = this.dTZ.get(aVar.dTV);
            String tid = bdVar.getTid();
            if (aVar.dTW >= 0) {
                tid = tid + "_" + aVar.dTW;
            }
            if (!hashSet.contains(tid) && !azR()) {
                hashSet.add(tid);
                ak akVar = new ak("c11439");
                akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dTU);
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                akVar.ab("obj_param2", bdVar.mRecomWeight);
                akVar.ab("obj_param1", bdVar.mRecomAbTag);
                akVar.s("obj_locate", aVar.dTT);
                akVar.ab("tid", bdVar.getTid());
                akVar.ab("obj_param3", bdVar.aPR);
                akVar.s("obj_id", L(bdVar));
                akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                if (aVar.dTV >= 0) {
                    akVar.s(MyBookrackActivityConfig.TAB_ID, aVar.dTV);
                }
                boolean z = (bdVar.AA() == null || (bdVar.AA().bwW() == null && bdVar.AA().Rp() == null)) ? false : true;
                if (z && bdVar.AA().bwW() != null && bdVar.AA().bwW().Rh() != null && bdVar.AA().bwW().Rh().size() > 0) {
                    akVar.s("obj_name", bdVar.AA().hbg ? 3 : 2);
                } else {
                    akVar.s("obj_name", z ? 1 : 0);
                }
                r.als().a(akVar);
                if (bdVar.Aa()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ab(ImageViewerConfig.FORUM_ID, aVar.dTU);
                    akVar2.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                    akVar2.ab("obj_param2", bdVar.mRecomWeight);
                    akVar2.ab("obj_param1", bdVar.mRecomAbTag);
                    akVar2.s("obj_locate", aVar.dTT);
                    akVar2.ab("tid", bdVar.getTid());
                    akVar2.ab("obj_param3", bdVar.aPR);
                    akVar2.s("obj_id", L(bdVar));
                    akVar2.ab("uid", TbadkCoreApplication.getCurrentAccount());
                    r.als().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar, int i) {
        if (aVar != null && aVar.dTS && bdVar != null && bdVar.getTid() != null) {
            r.als().eO(true);
            ak akVar = new ak("c11438");
            akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dTU);
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            akVar.ab("obj_param2", bdVar.mRecomWeight);
            akVar.ab("obj_param1", bdVar.mRecomAbTag);
            akVar.s("obj_locate", aVar.dTT);
            akVar.ab("tid", bdVar.getTid());
            akVar.s("obj_type", i);
            akVar.ab("obj_param3", bdVar.aPR);
            akVar.s("obj_id", L(bdVar));
            akVar.ab("obj_to", V(bdVar));
            if (aVar.dTV >= 0) {
                akVar.s(MyBookrackActivityConfig.TAB_ID, aVar.dTV);
            }
            TiebaStatic.log(akVar);
            if (bdVar.Aa()) {
                ak akVar2 = new ak("c12098");
                akVar2.ab(ImageViewerConfig.FORUM_ID, aVar.dTU);
                akVar2.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                akVar2.ab("obj_param2", bdVar.mRecomWeight);
                akVar2.ab("obj_param1", bdVar.mRecomAbTag);
                akVar2.s("obj_locate", aVar.dTT);
                akVar2.ab("tid", bdVar.getTid());
                akVar2.s("obj_type", i);
                akVar2.ab("obj_param3", bdVar.aPR);
                akVar2.s("obj_id", L(bdVar));
                akVar2.ab("obj_to", V(bdVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.bar() != null && lVar.gYa == 1) {
            TiebaStatic.log(new ak("c11440").ab(ImageViewerConfig.FORUM_ID, lVar.bar().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }

    private int L(bd bdVar) {
        if (bdVar.Ao() == null || bdVar.Ao().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.Ao().channelId;
    }

    private String V(bd bdVar) {
        return bdVar.aPS ? String.valueOf(bdVar.Al()) : String.valueOf(4);
    }
}
