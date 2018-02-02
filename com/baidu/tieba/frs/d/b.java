package com.baidu.tieba.frs.d;

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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b {
    public static int dQX;
    private static b dRa;
    private a dQY;
    private SparseArray<HashSet<String>> dQZ;
    private CustomMessageListener aIi = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dQZ != null) {
                b.this.dQZ.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.d.b.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.dRd = false;
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
        public long dRc;
        public boolean dRd;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dRd = false;
        }
    }

    public b() {
        dQX = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.aIi);
    }

    public static b ayP() {
        if (dRa == null) {
            synchronized (s.class) {
                if (dRa == null) {
                    dRa = new b();
                }
            }
        }
        return dRa;
    }

    private boolean ayQ() {
        if (this.dQY == null) {
            this.dQY = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dQY.dRd) {
            return true;
        }
        if (this.dQY.isRunning) {
            this.dQY.count++;
            if (currentTimeMillis - this.dQY.dRc < 120000) {
                if (this.dQY.count >= dQX) {
                    this.dQY.dRd = true;
                    a(this.dQY);
                    return true;
                }
            } else {
                this.dQY.isRunning = false;
                this.dQY.count = 0;
            }
        } else {
            this.dQY.isRunning = true;
            this.dQY.dRc = currentTimeMillis;
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

    public void R(bd bdVar) {
        if (bdVar != null && bdVar.zL()) {
            ak akVar = new ak("c11717");
            akVar.f(ImageViewerConfig.FORUM_ID, bdVar.getFid());
            akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            akVar.aa("obj_param2", bdVar.mRecomWeight);
            akVar.aa("obj_param1", bdVar.aOI);
            akVar.s("obj_locate", 1);
            akVar.aa("tid", bdVar.getTid());
            s.akK().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, bd bdVar) {
        if (aVar != null && aVar.dQS && bdVar != null && bdVar.getTid() != null) {
            if (this.dQZ == null) {
                this.dQZ = new SparseArray<>();
            }
            if (this.dQZ.get(aVar.dQV) == null) {
                this.dQZ.put(aVar.dQV, new HashSet<>());
            }
            HashSet<String> hashSet = this.dQZ.get(aVar.dQV);
            String tid = bdVar.getTid();
            if (aVar.dQW >= 0) {
                tid = tid + "_" + aVar.dQW;
            }
            if (!hashSet.contains(tid) && !ayQ()) {
                hashSet.add(tid);
                ak akVar = new ak("c11439");
                akVar.aa(ImageViewerConfig.FORUM_ID, aVar.dQU);
                akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                akVar.aa("obj_param2", bdVar.mRecomWeight);
                akVar.aa("obj_param1", bdVar.mRecomAbTag);
                akVar.s("obj_locate", aVar.dQT);
                akVar.aa("tid", bdVar.getTid());
                akVar.aa("obj_param3", bdVar.aOI);
                akVar.s("obj_id", I(bdVar));
                akVar.aa("uid", TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                if (aVar.dQV >= 0) {
                    akVar.s(MyBookrackActivityConfig.TAB_ID, aVar.dQV);
                }
                boolean z = (bdVar.Ah() == null || (bdVar.Ah().bvM() == null && bdVar.Ah().QL() == null)) ? false : true;
                if (z && bdVar.Ah().bvM() != null && bdVar.Ah().bvM().QD() != null && bdVar.Ah().bvM().QD().size() > 0) {
                    akVar.s("obj_name", bdVar.Ah().gZh ? 3 : 2);
                } else {
                    akVar.s("obj_name", z ? 1 : 0);
                }
                s.akK().a(akVar);
                if (bdVar.zG()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.aa(ImageViewerConfig.FORUM_ID, aVar.dQU);
                    akVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                    akVar2.aa("obj_param2", bdVar.mRecomWeight);
                    akVar2.aa("obj_param1", bdVar.mRecomAbTag);
                    akVar2.s("obj_locate", aVar.dQT);
                    akVar2.aa("tid", bdVar.getTid());
                    akVar2.aa("obj_param3", bdVar.aOI);
                    akVar2.s("obj_id", I(bdVar));
                    akVar2.aa("uid", TbadkCoreApplication.getCurrentAccount());
                    s.akK().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, bd bdVar, int i) {
        if (aVar != null && aVar.dQS && bdVar != null && bdVar.getTid() != null) {
            s.akK().eI(true);
            ak akVar = new ak("c11438");
            akVar.aa(ImageViewerConfig.FORUM_ID, aVar.dQU);
            akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            akVar.aa("obj_param2", bdVar.mRecomWeight);
            akVar.aa("obj_param1", bdVar.mRecomAbTag);
            akVar.s("obj_locate", aVar.dQT);
            akVar.aa("tid", bdVar.getTid());
            akVar.s("obj_type", i);
            akVar.aa("obj_param3", bdVar.aOI);
            akVar.s("obj_id", I(bdVar));
            akVar.aa("obj_to", S(bdVar));
            if (aVar.dQV >= 0) {
                akVar.s(MyBookrackActivityConfig.TAB_ID, aVar.dQV);
            }
            TiebaStatic.log(akVar);
            if (bdVar.zG()) {
                ak akVar2 = new ak("c12098");
                akVar2.aa(ImageViewerConfig.FORUM_ID, aVar.dQU);
                akVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                akVar2.aa("obj_param2", bdVar.mRecomWeight);
                akVar2.aa("obj_param1", bdVar.mRecomAbTag);
                akVar2.s("obj_locate", aVar.dQT);
                akVar2.aa("tid", bdVar.getTid());
                akVar2.s("obj_type", i);
                akVar2.aa("obj_param3", bdVar.aOI);
                akVar2.s("obj_id", I(bdVar));
                akVar2.aa("obj_to", S(bdVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.aYJ() != null && lVar.gVW == 1) {
            TiebaStatic.log(new ak("c11440").aa(ImageViewerConfig.FORUM_ID, lVar.aYJ().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }

    private int I(bd bdVar) {
        if (bdVar.zV() == null || bdVar.zV().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.zV().channelId;
    }

    private String S(bd bdVar) {
        return bdVar.aOJ ? String.valueOf(bdVar.zS()) : String.valueOf(4);
    }
}
