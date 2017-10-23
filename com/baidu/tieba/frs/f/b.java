package com.baidu.tieba.frs.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.i;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cFJ;
    private static b cFM;
    private a cFK;
    private HashSet<String> cFL;
    private CustomMessageListener SH = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.f.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cFL != null) {
                b.this.cFL.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.f.b.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.cFP = false;
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
    /* loaded from: classes.dex */
    public class a {
        public long cFO;
        public boolean cFP;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cFP = false;
        }
    }

    public b() {
        cFJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.SH);
    }

    public static b alt() {
        if (cFM == null) {
            synchronized (u.class) {
                if (cFM == null) {
                    cFM = new b();
                }
            }
        }
        return cFM;
    }

    private boolean alu() {
        if (this.cFK == null) {
            this.cFK = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cFK.cFP) {
            return true;
        }
        if (this.cFK.isRunning) {
            this.cFK.count++;
            if (currentTimeMillis - this.cFK.cFO < 120000) {
                if (this.cFK.count >= cFJ) {
                    this.cFK.cFP = true;
                    a(this.cFK);
                    return true;
                }
            } else {
                this.cFK.isRunning = false;
                this.cFK.count = 0;
            }
        } else {
            this.cFK.isRunning = true;
            this.cFK.cFO = currentTimeMillis;
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

    public void L(bh bhVar) {
        if (bhVar != null && bhVar.si()) {
            ak akVar = new ak("c11717");
            akVar.f("fid", bhVar.getFid());
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.Zv);
            akVar.ac("obj_param2", bhVar.Zw);
            akVar.ac("obj_param1", bhVar.ZA);
            akVar.r("obj_locate", 1);
            akVar.ac("tid", bhVar.getTid());
            u.XN().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.f.a aVar, bh bhVar) {
        if (aVar != null && aVar.cFG && bhVar != null && bhVar.getTid() != null) {
            if (this.cFL == null) {
                this.cFL = new HashSet<>();
            }
            if (!this.cFL.contains(bhVar.getTid()) && !alu()) {
                this.cFL.add(bhVar.getTid());
                ak akVar = new ak("c11439");
                akVar.ac("fid", aVar.cFI);
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.Zv);
                akVar.ac("obj_param2", bhVar.Zw);
                akVar.ac("obj_param1", bhVar.Zx);
                akVar.r("obj_locate", aVar.cFH);
                akVar.ac("tid", bhVar.getTid());
                akVar.ac("obj_param3", bhVar.ZA);
                akVar.r("obj_id", z(bhVar));
                akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                boolean z = (bhVar.sE() == null || (bhVar.sE().aBY() == null && bhVar.sE().IF() == null)) ? false : true;
                if (z && bhVar.sE().aBY() != null && bhVar.sE().aBY().Ix() != null && bhVar.sE().aBY().Ix().size() > 0) {
                    akVar.r("obj_name", bhVar.sE().ghf ? 3 : 2);
                } else {
                    akVar.r("obj_name", z ? 1 : 0);
                }
                u.XN().a(akVar);
                if (bhVar.sb()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ac("fid", aVar.cFI);
                    akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.Zv);
                    akVar2.ac("obj_param2", bhVar.Zw);
                    akVar2.ac("obj_param1", bhVar.Zx);
                    akVar2.r("obj_locate", aVar.cFH);
                    akVar2.ac("tid", bhVar.getTid());
                    akVar2.ac("obj_param3", bhVar.ZA);
                    akVar2.r("obj_id", z(bhVar));
                    akVar2.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    u.XN().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.f.a aVar, bh bhVar, int i) {
        if (aVar != null && aVar.cFG && bhVar != null && bhVar.getTid() != null) {
            u.XN().dB(true);
            ak akVar = new ak("c11438");
            akVar.ac("fid", aVar.cFI);
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.Zv);
            akVar.ac("obj_param2", bhVar.Zw);
            akVar.ac("obj_param1", bhVar.Zx);
            akVar.r("obj_locate", aVar.cFH);
            akVar.ac("tid", bhVar.getTid());
            akVar.r("obj_type", i);
            akVar.ac("obj_param3", bhVar.ZA);
            akVar.r("obj_id", z(bhVar));
            akVar.ac("obj_to", M(bhVar));
            TiebaStatic.log(akVar);
            if (bhVar.sb()) {
                ak akVar2 = new ak("c12098");
                akVar2.ac("fid", aVar.cFI);
                akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.Zv);
                akVar2.ac("obj_param2", bhVar.Zw);
                akVar2.ac("obj_param1", bhVar.Zx);
                akVar2.r("obj_locate", aVar.cFH);
                akVar2.ac("tid", bhVar.getTid());
                akVar2.r("obj_type", i);
                akVar2.ac("obj_param3", bhVar.ZA);
                akVar2.r("obj_id", z(bhVar));
                akVar2.ac("obj_to", M(bhVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(i iVar, int i, int i2) {
        if (iVar != null && iVar.aMU() != null && iVar.gdW == 1) {
            TiebaStatic.log(new ak("c11440").ac("fid", iVar.aMU().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int z(bh bhVar) {
        if (bhVar.ss() == null || bhVar.ss().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.ss().channelId;
    }

    private String M(bh bhVar) {
        return bhVar.ZB ? String.valueOf(bhVar.sp()) : String.valueOf(4);
    }
}
