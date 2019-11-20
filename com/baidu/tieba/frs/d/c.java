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
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class c {
    public static int fPQ;
    private static c fPT;
    private a fPR;
    private SparseArray<HashSet<String>> fPS;
    private CustomMessageListener bVa = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.fPS != null) {
                c.this.fPS.clear();
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
                        aVar.fPW = false;
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
        public long fPV;
        public boolean fPW;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.fPW = false;
        }
    }

    public c() {
        fPQ = com.baidu.tbadk.core.sharedPref.b.alP().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.bVa);
    }

    public static c bpH() {
        if (fPT == null) {
            synchronized (t.class) {
                if (fPT == null) {
                    fPT = new c();
                }
            }
        }
        return fPT;
    }

    private boolean bpI() {
        if (this.fPR == null) {
            this.fPR = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.fPR.fPW) {
            return true;
        }
        if (this.fPR.isRunning) {
            this.fPR.count++;
            if (currentTimeMillis - this.fPR.fPV < 120000) {
                if (this.fPR.count >= fPQ) {
                    this.fPR.fPW = true;
                    a(this.fPR);
                    return true;
                }
            } else {
                this.fPR.isRunning = false;
                this.fPR.count = 0;
            }
        } else {
            this.fPR.isRunning = true;
            this.fPR.fPV = currentTimeMillis;
        }
        return false;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mHandler.removeMessages(5);
        this.mHandler.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void a(bh bhVar, HashSet<String> hashSet) {
        if (bhVar != null && bhVar.aij()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bhVar.getTid() != null && !hashSet.contains(bhVar.getTid())) {
                hashSet.add(bhVar.getTid());
                t.bau().c(new an("c11662").O("obj_param1", 1).bS("post_id", bhVar.getTid()));
            }
        }
    }

    public void a(bh bhVar, boolean z) {
        if (bhVar != null) {
            t.bau().c(new an("c12125").bS("tid", bhVar.getId()).O("obj_locate", z ? 2 : 1).p("obj_id", bhVar.aiX() != null ? bhVar.aiX().live_id : -1L).O("obj_type", 1));
        }
    }

    public void ak(bh bhVar) {
        if (bhVar != null && bhVar.ajF()) {
            an anVar = new an("c11717");
            anVar.p("fid", bhVar.getFid());
            anVar.bS("obj_source", bhVar.mRecomSource);
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
            anVar.bS("obj_param1", bhVar.ccP);
            anVar.O("obj_locate", 1);
            anVar.bS("tid", bhVar.getTid());
            t.bau().c(anVar);
        }
    }

    public void a(b bVar, bh bhVar) {
        if (bVar != null && bVar.fPK && bhVar != null && bhVar.getTid() != null) {
            if (this.fPS == null) {
                this.fPS = new SparseArray<>();
            }
            if (this.fPS.get(bVar.fPN) == null) {
                this.fPS.put(bVar.fPN, new HashSet<>());
            }
            HashSet<String> hashSet = this.fPS.get(bVar.fPN);
            String tid = bhVar.getTid();
            if (bVar.fPO >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.fPO;
            }
            if (!hashSet.contains(tid) && !bpI()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.bS("fid", bVar.fPM);
                anVar.O("obj_locate", a(bVar));
                anVar.bS("obj_source", bhVar.mRecomSource);
                anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
                anVar.bS("obj_param1", bhVar.mRecomAbTag);
                anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, bhVar.ccP);
                anVar.bS("tid", bhVar.getTid());
                anVar.O("obj_id", U(bhVar));
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.p(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.fPN >= 0) {
                    anVar.O("tab_id", bVar.fPN);
                }
                if (bhVar.cdI >= 0) {
                    anVar.O("obj_floor", bhVar.cdI);
                }
                boolean z = (bhVar.akb() == null || (bhVar.akb().cop() == null && bhVar.akb().azp() == null)) ? false : true;
                if (z && bhVar.akb().cop() != null && bhVar.akb().cop().azf() != null && bhVar.akb().cop().azf().size() > 0) {
                    anVar.O("obj_name", bhVar.akb().jie ? 3 : 2);
                } else {
                    anVar.O("obj_name", z ? 1 : 0);
                }
                boolean z2 = bhVar.getType() == bh.caX;
                anVar.O("thread_type", z2 ? 2 : 1);
                if (z2 && bhVar.aiE() != null && !StringUtils.isNull(bhVar.aiE().getName_show())) {
                    anVar.bS("obj_name", bhVar.aiE().getName_show());
                }
                t.bau().c(anVar);
                if (bhVar.ajy()) {
                    an anVar2 = new an("c12099");
                    anVar2.bS("fid", bVar.fPM);
                    anVar2.O("obj_locate", a(bVar));
                    anVar2.bS("obj_source", bhVar.mRecomSource);
                    anVar2.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
                    anVar2.bS("obj_param1", bhVar.mRecomAbTag);
                    anVar2.bS(TiebaInitialize.Params.OBJ_PARAM3, bhVar.ccP);
                    anVar2.bS("tid", bhVar.getTid());
                    anVar2.O("obj_id", U(bhVar));
                    anVar2.bS("uid", TbadkCoreApplication.getCurrentAccount());
                    t.bau().c(anVar2);
                }
                if (bhVar.aiI()) {
                    an anVar3 = new an("c13169");
                    anVar3.bS("fid", bVar.fPM);
                    anVar3.bS("tid", bhVar.getTid());
                    anVar3.bS("uid", TbadkCoreApplication.getCurrentAccount());
                    t.bau().c(anVar3);
                }
                if (bVar.fPN == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.bS("fid", bVar.fPM);
                    anVar4.bS("tid", bhVar.getTid());
                    t.bau().c(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bh bhVar, int i) {
        if (bVar != null && bVar.fPK && bhVar != null && bhVar.getTid() != null) {
            t.bau().iK(true);
            an anVar = new an("c11438");
            anVar.bS("fid", bVar.fPM);
            anVar.O("obj_locate", a(bVar));
            anVar.bS("obj_source", bhVar.mRecomSource);
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
            anVar.bS("obj_param1", bhVar.mRecomAbTag);
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, bhVar.ccP);
            anVar.bS("tid", bhVar.getTid());
            anVar.O("obj_type", i);
            anVar.O("obj_id", U(bhVar));
            anVar.bS(TiebaInitialize.Params.OBJ_TO, al(bhVar));
            if (bVar.fPN >= 0) {
                anVar.O("tab_id", bVar.fPN);
            }
            if (bhVar.cdI >= 0) {
                anVar.O("obj_floor", bhVar.cdI);
            }
            anVar.O("thread_type", bhVar.getType() == bh.caX ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bhVar.ajy()) {
                an anVar2 = new an("c12098");
                anVar2.bS("fid", bVar.fPM);
                anVar2.O("obj_locate", a(bVar));
                anVar2.bS("obj_source", bhVar.mRecomSource);
                anVar2.bS(TiebaInitialize.Params.OBJ_PARAM2, bhVar.mRecomWeight);
                anVar2.bS("obj_param1", bhVar.mRecomAbTag);
                anVar2.bS(TiebaInitialize.Params.OBJ_PARAM3, bhVar.ccP);
                anVar2.bS("tid", bhVar.getTid());
                anVar2.O("obj_type", i);
                anVar2.O("obj_id", U(bhVar));
                anVar2.bS(TiebaInitialize.Params.OBJ_TO, al(bhVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.fPN == 501) {
                an anVar3 = new an("c13260");
                anVar3.bS("fid", bVar.fPM);
                anVar3.bS("tid", bhVar.getTid());
                t.bau().c(anVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.fPP > 0) {
            return bVar.fPP;
        }
        int i = bVar.fPL;
        if (i == 8) {
            return 9;
        }
        return i;
    }

    public void b(b bVar, bh bhVar, int i) {
        if (bVar != null && bVar.fPK && bhVar != null && bhVar.getTid() != null && bhVar.aiI()) {
            an anVar = new an("c13170");
            anVar.bS("fid", bVar.fPM);
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
        if (bhVar.ajN() == null || bhVar.ajN().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.ajN().channelId;
    }

    private String al(bh bhVar) {
        return bhVar.ccQ ? String.valueOf(bhVar.ajK()) : String.valueOf(4);
    }
}
