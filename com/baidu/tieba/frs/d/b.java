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
    public static int dQC;
    private static b dQF;
    private a dQD;
    private SparseArray<HashSet<String>> dQE;
    private CustomMessageListener aIf = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dQE != null) {
                b.this.dQE.clear();
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
                        aVar.dQI = false;
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
        public long dQH;
        public boolean dQI;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dQI = false;
        }
    }

    public b() {
        dQC = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.aIf);
    }

    public static b ayK() {
        if (dQF == null) {
            synchronized (s.class) {
                if (dQF == null) {
                    dQF = new b();
                }
            }
        }
        return dQF;
    }

    private boolean ayL() {
        if (this.dQD == null) {
            this.dQD = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dQD.dQI) {
            return true;
        }
        if (this.dQD.isRunning) {
            this.dQD.count++;
            if (currentTimeMillis - this.dQD.dQH < 120000) {
                if (this.dQD.count >= dQC) {
                    this.dQD.dQI = true;
                    a(this.dQD);
                    return true;
                }
            } else {
                this.dQD.isRunning = false;
                this.dQD.count = 0;
            }
        } else {
            this.dQD.isRunning = true;
            this.dQD.dQH = currentTimeMillis;
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
        if (bdVar != null && bdVar.zK()) {
            ak akVar = new ak("c11717");
            akVar.f(ImageViewerConfig.FORUM_ID, bdVar.getFid());
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            akVar.ab("obj_param2", bdVar.mRecomWeight);
            akVar.ab("obj_param1", bdVar.aOF);
            akVar.s("obj_locate", 1);
            akVar.ab("tid", bdVar.getTid());
            s.akF().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, bd bdVar) {
        if (aVar != null && aVar.dQx && bdVar != null && bdVar.getTid() != null) {
            if (this.dQE == null) {
                this.dQE = new SparseArray<>();
            }
            if (this.dQE.get(aVar.dQA) == null) {
                this.dQE.put(aVar.dQA, new HashSet<>());
            }
            HashSet<String> hashSet = this.dQE.get(aVar.dQA);
            String tid = bdVar.getTid();
            if (aVar.dQB >= 0) {
                tid = tid + "_" + aVar.dQB;
            }
            if (!hashSet.contains(tid) && !ayL()) {
                hashSet.add(tid);
                ak akVar = new ak("c11439");
                akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dQz);
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                akVar.ab("obj_param2", bdVar.mRecomWeight);
                akVar.ab("obj_param1", bdVar.mRecomAbTag);
                akVar.s("obj_locate", aVar.dQy);
                akVar.ab("tid", bdVar.getTid());
                akVar.ab("obj_param3", bdVar.aOF);
                akVar.s("obj_id", I(bdVar));
                akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                if (aVar.dQA >= 0) {
                    akVar.s(MyBookrackActivityConfig.TAB_ID, aVar.dQA);
                }
                boolean z = (bdVar.Ag() == null || (bdVar.Ag().bvK() == null && bdVar.Ag().QJ() == null)) ? false : true;
                if (z && bdVar.Ag().bvK() != null && bdVar.Ag().bvK().QB() != null && bdVar.Ag().bvK().QB().size() > 0) {
                    akVar.s("obj_name", bdVar.Ag().gYN ? 3 : 2);
                } else {
                    akVar.s("obj_name", z ? 1 : 0);
                }
                s.akF().a(akVar);
                if (bdVar.zF()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ab(ImageViewerConfig.FORUM_ID, aVar.dQz);
                    akVar2.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                    akVar2.ab("obj_param2", bdVar.mRecomWeight);
                    akVar2.ab("obj_param1", bdVar.mRecomAbTag);
                    akVar2.s("obj_locate", aVar.dQy);
                    akVar2.ab("tid", bdVar.getTid());
                    akVar2.ab("obj_param3", bdVar.aOF);
                    akVar2.s("obj_id", I(bdVar));
                    akVar2.ab("uid", TbadkCoreApplication.getCurrentAccount());
                    s.akF().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, bd bdVar, int i) {
        if (aVar != null && aVar.dQx && bdVar != null && bdVar.getTid() != null) {
            s.akF().eF(true);
            ak akVar = new ak("c11438");
            akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dQz);
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
            akVar.ab("obj_param2", bdVar.mRecomWeight);
            akVar.ab("obj_param1", bdVar.mRecomAbTag);
            akVar.s("obj_locate", aVar.dQy);
            akVar.ab("tid", bdVar.getTid());
            akVar.s("obj_type", i);
            akVar.ab("obj_param3", bdVar.aOF);
            akVar.s("obj_id", I(bdVar));
            akVar.ab("obj_to", S(bdVar));
            if (aVar.dQA >= 0) {
                akVar.s(MyBookrackActivityConfig.TAB_ID, aVar.dQA);
            }
            TiebaStatic.log(akVar);
            if (bdVar.zF()) {
                ak akVar2 = new ak("c12098");
                akVar2.ab(ImageViewerConfig.FORUM_ID, aVar.dQz);
                akVar2.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.mRecomSource);
                akVar2.ab("obj_param2", bdVar.mRecomWeight);
                akVar2.ab("obj_param1", bdVar.mRecomAbTag);
                akVar2.s("obj_locate", aVar.dQy);
                akVar2.ab("tid", bdVar.getTid());
                akVar2.s("obj_type", i);
                akVar2.ab("obj_param3", bdVar.aOF);
                akVar2.s("obj_id", I(bdVar));
                akVar2.ab("obj_to", S(bdVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.aYE() != null && lVar.gVC == 1) {
            TiebaStatic.log(new ak("c11440").ab(ImageViewerConfig.FORUM_ID, lVar.aYE().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }

    private int I(bd bdVar) {
        if (bdVar.zU() == null || bdVar.zU().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.zU().channelId;
    }

    private String S(bd bdVar) {
        return bdVar.aOG ? String.valueOf(bdVar.zR()) : String.valueOf(4);
    }
}
