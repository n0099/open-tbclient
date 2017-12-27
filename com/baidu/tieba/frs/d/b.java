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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b {
    public static int dMa;
    private static b dMd;
    private a dMb;
    private SparseArray<HashSet<String>> dMc;
    private CustomMessageListener aIh = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dMc != null) {
                b.this.dMc.clear();
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
                        aVar.dMg = false;
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
        public long dMf;
        public boolean dMg;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.dMg = false;
        }
    }

    public b() {
        dMa = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.aIh);
    }

    public static b axH() {
        if (dMd == null) {
            synchronized (s.class) {
                if (dMd == null) {
                    dMd = new b();
                }
            }
        }
        return dMd;
    }

    private boolean axI() {
        if (this.dMb == null) {
            this.dMb = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dMb.dMg) {
            return true;
        }
        if (this.dMb.isRunning) {
            this.dMb.count++;
            if (currentTimeMillis - this.dMb.dMf < 120000) {
                if (this.dMb.count >= dMa) {
                    this.dMb.dMg = true;
                    a(this.dMb);
                    return true;
                }
            } else {
                this.dMb.isRunning = false;
                this.dMb.count = 0;
            }
        } else {
            this.dMb.isRunning = true;
            this.dMb.dMf = currentTimeMillis;
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

    public void R(be beVar) {
        if (beVar != null && beVar.zS()) {
            ak akVar = new ak("c11717");
            akVar.f(ImageViewerConfig.FORUM_ID, beVar.getFid());
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, beVar.mRecomSource);
            akVar.ab("obj_param2", beVar.mRecomWeight);
            akVar.ab("obj_param1", beVar.aOH);
            akVar.s("obj_locate", 1);
            akVar.ab("tid", beVar.getTid());
            s.ajC().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, be beVar) {
        if (aVar != null && aVar.dLV && beVar != null && beVar.getTid() != null) {
            if (this.dMc == null) {
                this.dMc = new SparseArray<>();
            }
            if (this.dMc.get(aVar.dLY) == null) {
                this.dMc.put(aVar.dLY, new HashSet<>());
            }
            HashSet<String> hashSet = this.dMc.get(aVar.dLY);
            String tid = beVar.getTid();
            if (aVar.dLZ >= 0) {
                tid = tid + "_" + aVar.dLZ;
            }
            if (!hashSet.contains(tid) && !axI()) {
                hashSet.add(tid);
                ak akVar = new ak("c11439");
                akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dLX);
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, beVar.mRecomSource);
                akVar.ab("obj_param2", beVar.mRecomWeight);
                akVar.ab("obj_param1", beVar.mRecomAbTag);
                akVar.s("obj_locate", aVar.dLW);
                akVar.ab("tid", beVar.getTid());
                akVar.ab("obj_param3", beVar.aOH);
                akVar.s("obj_id", I(beVar));
                akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                if (aVar.dLY >= 0) {
                    akVar.s(MyBookrackActivityConfig.TAB_ID, aVar.dLY);
                }
                boolean z = (beVar.Ao() == null || (beVar.Ao().bCo() == null && beVar.Ao().QV() == null)) ? false : true;
                if (z && beVar.Ao().bCo() != null && beVar.Ao().bCo().QN() != null && beVar.Ao().bCo().QN().size() > 0) {
                    akVar.s("obj_name", beVar.Ao().hjn ? 3 : 2);
                } else {
                    akVar.s("obj_name", z ? 1 : 0);
                }
                s.ajC().a(akVar);
                if (beVar.zK()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ab(ImageViewerConfig.FORUM_ID, aVar.dLX);
                    akVar2.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, beVar.mRecomSource);
                    akVar2.ab("obj_param2", beVar.mRecomWeight);
                    akVar2.ab("obj_param1", beVar.mRecomAbTag);
                    akVar2.s("obj_locate", aVar.dLW);
                    akVar2.ab("tid", beVar.getTid());
                    akVar2.ab("obj_param3", beVar.aOH);
                    akVar2.s("obj_id", I(beVar));
                    akVar2.ab("uid", TbadkCoreApplication.getCurrentAccount());
                    s.ajC().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, be beVar, int i) {
        if (aVar != null && aVar.dLV && beVar != null && beVar.getTid() != null) {
            s.ajC().eB(true);
            ak akVar = new ak("c11438");
            akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dLX);
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, beVar.mRecomSource);
            akVar.ab("obj_param2", beVar.mRecomWeight);
            akVar.ab("obj_param1", beVar.mRecomAbTag);
            akVar.s("obj_locate", aVar.dLW);
            akVar.ab("tid", beVar.getTid());
            akVar.s("obj_type", i);
            akVar.ab("obj_param3", beVar.aOH);
            akVar.s("obj_id", I(beVar));
            akVar.ab("obj_to", S(beVar));
            if (aVar.dLY >= 0) {
                akVar.s(MyBookrackActivityConfig.TAB_ID, aVar.dLY);
            }
            TiebaStatic.log(akVar);
            if (beVar.zK()) {
                ak akVar2 = new ak("c12098");
                akVar2.ab(ImageViewerConfig.FORUM_ID, aVar.dLX);
                akVar2.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, beVar.mRecomSource);
                akVar2.ab("obj_param2", beVar.mRecomWeight);
                akVar2.ab("obj_param1", beVar.mRecomAbTag);
                akVar2.s("obj_locate", aVar.dLW);
                akVar2.ab("tid", beVar.getTid());
                akVar2.s("obj_type", i);
                akVar2.ab("obj_param3", beVar.aOH);
                akVar2.s("obj_id", I(beVar));
                akVar2.ab("obj_to", S(beVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(l lVar, int i, int i2) {
        if (lVar != null && lVar.aYy() != null && lVar.hgc == 1) {
            TiebaStatic.log(new ak("c11440").ab(ImageViewerConfig.FORUM_ID, lVar.aYy().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }

    private int I(be beVar) {
        if (beVar.Ac() == null || beVar.Ac().channelId <= 0) {
            return 0;
        }
        return (int) beVar.Ac().channelId;
    }

    private String S(be beVar) {
        return beVar.aOI ? String.valueOf(beVar.zZ()) : String.valueOf(4);
    }
}
