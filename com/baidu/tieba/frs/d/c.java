package com.baidu.tieba.frs.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.t;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class c {
    public static int fQH;
    private static c fQK;
    private a fQI;
    private SparseArray<HashSet<String>> fQJ;
    private CustomMessageListener bVR = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.fQJ != null) {
                c.this.fQJ.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.d.c.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.fQN = false;
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
    /* loaded from: classes4.dex */
    public class a {
        public int count;
        public long fQM;
        public boolean fQN;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fQN = false;
        }
    }

    public c() {
        fQH = com.baidu.tbadk.core.sharedPref.b.alR().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.bVR);
    }

    public static c bpJ() {
        if (fQK == null) {
            synchronized (t.class) {
                if (fQK == null) {
                    fQK = new c();
                }
            }
        }
        return fQK;
    }

    private boolean bpK() {
        if (this.fQI == null) {
            this.fQI = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.fQI.fQN) {
            return true;
        }
        if (this.fQI.isRunning) {
            this.fQI.count++;
            if (currentTimeMillis - this.fQI.fQM < 120000) {
                if (this.fQI.count >= fQH) {
                    this.fQI.fQN = true;
                    a(this.fQI);
                    return true;
                }
            } else {
                this.fQI.isRunning = false;
                this.fQI.count = 0;
            }
        } else {
            this.fQI.isRunning = true;
            this.fQI.fQM = currentTimeMillis;
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

    public void a(bh bhVar, HashSet<String> hashSet) {
        if (bhVar != null && bhVar.ail()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bhVar.getTid() != null && !hashSet.contains(bhVar.getTid())) {
                hashSet.add(bhVar.getTid());
                t.baw().c(new an("c11662").O("obj_param1", 1).bS("post_id", bhVar.getTid()));
            }
        }
    }

    public void a(bh bhVar, boolean z) {
        if (bhVar != null) {
            t.baw().c(new an("c12125").bS("tid", bhVar.getId()).O("obj_locate", z ? 2 : 1).p("obj_id", bhVar.aiZ() != null ? bhVar.aiZ().live_id : -1L).O("obj_type", 1));
        }
    }

    public void ak(bh bhVar) {
        if (bhVar != null && bhVar.ajH()) {
            an anVar = new an("c11717");
            anVar.p("fid", bhVar.getFid());
            anVar.bS("obj_source", bhVar.mRecomSource);
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
            anVar.bS("obj_param1", bhVar.cdG);
            anVar.O("obj_locate", 1);
            anVar.bS("tid", bhVar.getTid());
            t.baw().c(anVar);
        }
    }

    public void a(b bVar, bh bhVar) {
        if (bVar != null && bVar.fQB && bhVar != null && bhVar.getTid() != null) {
            if (this.fQJ == null) {
                this.fQJ = new SparseArray<>();
            }
            if (this.fQJ.get(bVar.fQE) == null) {
                this.fQJ.put(bVar.fQE, new HashSet<>());
            }
            HashSet<String> hashSet = this.fQJ.get(bVar.fQE);
            String tid = bhVar.getTid();
            if (bVar.fQF >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.fQF;
            }
            if (!hashSet.contains(tid) && !bpK()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.bS("fid", bVar.fQD);
                anVar.O("obj_locate", a(bVar));
                anVar.bS("obj_source", bhVar.mRecomSource);
                anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
                anVar.bS("obj_param1", bhVar.mRecomAbTag);
                anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, bhVar.cdG);
                anVar.bS("tid", bhVar.getTid());
                anVar.O("obj_id", U(bhVar));
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.p(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.fQE >= 0) {
                    anVar.O("tab_id", bVar.fQE);
                }
                if (bhVar.cez >= 0) {
                    anVar.O("obj_floor", bhVar.cez);
                }
                boolean z = (bhVar.akd() == null || (bhVar.akd().cor() == null && bhVar.akd().azr() == null)) ? false : true;
                if (z && bhVar.akd().cor() != null && bhVar.akd().cor().azh() != null && bhVar.akd().cor().azh().size() > 0) {
                    anVar.O("obj_name", bhVar.akd().jiV ? 3 : 2);
                } else {
                    anVar.O("obj_name", z ? 1 : 0);
                }
                boolean z2 = bhVar.getType() == bh.cbO;
                anVar.O("thread_type", z2 ? 2 : 1);
                if (z2 && bhVar.aiG() != null && !StringUtils.isNull(bhVar.aiG().getName_show())) {
                    anVar.bS("obj_name", bhVar.aiG().getName_show());
                }
                t.baw().c(anVar);
                if (bhVar.ajA()) {
                    an anVar2 = new an("c12099");
                    anVar2.bS("fid", bVar.fQD);
                    anVar2.O("obj_locate", a(bVar));
                    anVar2.bS("obj_source", bhVar.mRecomSource);
                    anVar2.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
                    anVar2.bS("obj_param1", bhVar.mRecomAbTag);
                    anVar2.bS(TiebaInitialize.Params.OBJ_PARAM3, bhVar.cdG);
                    anVar2.bS("tid", bhVar.getTid());
                    anVar2.O("obj_id", U(bhVar));
                    anVar2.bS("uid", TbadkCoreApplication.getCurrentAccount());
                    t.baw().c(anVar2);
                }
                if (bhVar.aiK()) {
                    an anVar3 = new an("c13169");
                    anVar3.bS("fid", bVar.fQD);
                    anVar3.bS("tid", bhVar.getTid());
                    anVar3.bS("uid", TbadkCoreApplication.getCurrentAccount());
                    t.baw().c(anVar3);
                }
                if (bVar.fQE == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.bS("fid", bVar.fQD);
                    anVar4.bS("tid", bhVar.getTid());
                    t.baw().c(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bh bhVar, int i) {
        if (bVar != null && bVar.fQB && bhVar != null && bhVar.getTid() != null) {
            t.baw().iK(true);
            an anVar = new an("c11438");
            anVar.bS("fid", bVar.fQD);
            anVar.O("obj_locate", a(bVar));
            anVar.bS("obj_source", bhVar.mRecomSource);
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
            anVar.bS("obj_param1", bhVar.mRecomAbTag);
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, bhVar.cdG);
            anVar.bS("tid", bhVar.getTid());
            anVar.O("obj_type", i);
            anVar.O("obj_id", U(bhVar));
            anVar.bS(TiebaInitialize.Params.OBJ_TO, al(bhVar));
            if (bVar.fQE >= 0) {
                anVar.O("tab_id", bVar.fQE);
            }
            if (bhVar.cez >= 0) {
                anVar.O("obj_floor", bhVar.cez);
            }
            anVar.O("thread_type", bhVar.getType() == bh.cbO ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bhVar.ajA()) {
                an anVar2 = new an("c12098");
                anVar2.bS("fid", bVar.fQD);
                anVar2.O("obj_locate", a(bVar));
                anVar2.bS("obj_source", bhVar.mRecomSource);
                anVar2.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
                anVar2.bS("obj_param1", bhVar.mRecomAbTag);
                anVar2.bS(TiebaInitialize.Params.OBJ_PARAM3, bhVar.cdG);
                anVar2.bS("tid", bhVar.getTid());
                anVar2.O("obj_type", i);
                anVar2.O("obj_id", U(bhVar));
                anVar2.bS(TiebaInitialize.Params.OBJ_TO, al(bhVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.fQE == 501) {
                an anVar3 = new an("c13260");
                anVar3.bS("fid", bVar.fQD);
                anVar3.bS("tid", bhVar.getTid());
                t.baw().c(anVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.fQG > 0) {
            return bVar.fQG;
        }
        int i = bVar.fQC;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bh bhVar, int i) {
        if (bVar != null && bVar.fQB && bhVar != null && bhVar.getTid() != null && bhVar.aiK()) {
            an anVar = new an("c13170");
            anVar.bS("fid", bVar.fQD);
            anVar.O("obj_locate", i);
            anVar.bS("tid", bhVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            TiebaStatic.log(new an("c11440").bS("fid", frsViewData.getForum().getId()).O("obj_locate", i).O("obj_type", i2));
        }
    }

    private int U(bh bhVar) {
        if (bhVar.ajP() == null || bhVar.ajP().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.ajP().channelId;
    }

    private String al(bh bhVar) {
        return bhVar.cdH ? String.valueOf(bhVar.ajM()) : String.valueOf(4);
    }
}
