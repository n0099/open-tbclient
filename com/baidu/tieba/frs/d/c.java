package com.baidu.tieba.frs.d;

import android.content.Context;
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
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes22.dex */
public class c {
    public static int iZL;
    private static c iZO;
    private a iZM;
    private SparseArray<HashSet<String>> iZN;
    private CustomMessageListener erp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.iZN != null) {
                c.this.iZN.clear();
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
                        aVar.iZR = false;
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
    /* loaded from: classes22.dex */
    public class a {
        public int count;
        public long iZQ;
        public boolean iZR;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.iZR = false;
        }
    }

    public c() {
        iZL = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.erp);
    }

    public static c cCo() {
        if (iZO == null) {
            synchronized (t.class) {
                if (iZO == null) {
                    iZO = new c();
                }
            }
        }
        return iZO;
    }

    private boolean cCp() {
        if (this.iZM == null) {
            this.iZM = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.iZM.iZR) {
            return true;
        }
        if (this.iZM.isRunning) {
            this.iZM.count++;
            if (currentTimeMillis - this.iZM.iZQ < 120000) {
                if (this.iZM.count >= iZL) {
                    this.iZM.iZR = true;
                    a(this.iZM);
                    return true;
                }
            } else {
                this.iZM.isRunning = false;
                this.iZM.count = 0;
            }
        } else {
            this.iZM.isRunning = true;
            this.iZM.iZQ = currentTimeMillis;
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

    public void a(bw bwVar, HashSet<String> hashSet) {
        if (bwVar != null && bwVar.bjF()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bwVar.getTid() != null && !hashSet.contains(bwVar.getTid())) {
                hashSet.add(bwVar.getTid());
                t.clQ().e(new aq("c11662").aj("obj_param1", 1).dR("post_id", bwVar.getTid()));
            }
        }
    }

    public void a(bw bwVar, boolean z) {
        if (bwVar != null) {
            t.clQ().e(new aq("c12125").dR("tid", bwVar.getId()).aj("obj_locate", z ? 2 : 1).w("obj_id", bwVar.bku() != null ? bwVar.bku().live_id : -1L).aj("obj_type", 1));
        }
    }

    public void aw(bw bwVar) {
        if (bwVar != null && bwVar.blj()) {
            aq aqVar = new aq("c11717");
            aqVar.w("fid", bwVar.getFid());
            aqVar.dR("obj_source", bwVar.mRecomSource);
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dR("obj_param1", bwVar.eAe);
            aqVar.aj("obj_locate", 1);
            aqVar.dR("tid", bwVar.getTid());
            t.clQ().e(aqVar);
        }
    }

    public void a(b bVar, bw bwVar) {
        if (bVar != null && bVar.iZE && bwVar != null && bwVar.getTid() != null) {
            if (this.iZN == null) {
                this.iZN = new SparseArray<>();
            }
            if (this.iZN.get(bVar.iZH) == null) {
                this.iZN.put(bVar.iZH, new HashSet<>());
            }
            HashSet<String> hashSet = this.iZN.get(bVar.iZH);
            String tid = bwVar.getTid();
            if (bVar.iZI >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.iZI;
            }
            if (!hashSet.contains(tid) && !cCp()) {
                hashSet.add(tid);
                aq aqVar = new aq("c11439");
                aqVar.dR("fid", bVar.iZG);
                aqVar.aj("obj_locate", a(bVar));
                aqVar.dR("obj_source", bwVar.mRecomSource);
                aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar.dR("obj_param1", bwVar.mRecomAbTag);
                aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, bwVar.eAe);
                aqVar.dR("tid", bwVar.getTid());
                aqVar.dR("nid", bwVar.getNid());
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.iZH >= 0) {
                    aqVar.aj("tab_id", bVar.iZH);
                }
                if (bwVar.evR >= 0) {
                    aqVar.aj("obj_floor", bwVar.evR);
                }
                boolean z = (bwVar.blD() == null || (bwVar.blD().dHz() == null && bwVar.blD().bDr() == null)) ? false : true;
                if (z && bwVar.blD().dHz() != null && bwVar.blD().dHz().bDj() != null && bwVar.blD().dHz().bDj().size() > 0) {
                    aqVar.aj("obj_name", bwVar.blD().mRu ? 3 : 2);
                } else {
                    aqVar.aj("obj_name", z ? 1 : 0);
                }
                boolean z2 = bwVar.getType() == bw.eyr;
                aqVar.aj("thread_type", z2 ? 2 : 1);
                if (z2 && bwVar.bka() != null && !StringUtils.isNull(bwVar.bka().getName_show())) {
                    aqVar.dR("obj_name", bwVar.bka().getName_show());
                }
                if (bwVar.biJ() || bwVar.blW()) {
                    aqVar.aj("obj_type", 14);
                } else if (bwVar.biI()) {
                    aqVar.aj("obj_type", 13);
                }
                t.clQ().e(aqVar);
                if (bwVar.biG()) {
                    aq aqVar2 = new aq("c12099");
                    aqVar2.dR("fid", bVar.iZG);
                    aqVar2.aj("obj_locate", a(bVar));
                    aqVar2.dR("obj_source", bwVar.mRecomSource);
                    aqVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                    aqVar2.dR("obj_param1", bwVar.mRecomAbTag);
                    aqVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, bwVar.eAe);
                    aqVar2.dR("tid", bwVar.getTid());
                    aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    t.clQ().e(aqVar2);
                }
                if (bVar.iZH == 501) {
                    aq aqVar3 = new aq("c13259");
                    aqVar3.dR("fid", bVar.iZG);
                    aqVar3.dR("tid", bwVar.getTid());
                    t.clQ().e(aqVar3);
                }
            }
        }
    }

    public void a(b bVar, bw bwVar, int i) {
        if (bVar != null && bVar.iZE && bwVar != null && bwVar.getTid() != null) {
            t.clQ().op(true);
            aq aqVar = new aq("c11438");
            aqVar.dR("fid", bVar.iZG);
            aqVar.aj("obj_locate", a(bVar));
            aqVar.dR("obj_source", bwVar.mRecomSource);
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dR("obj_param1", bwVar.mRecomAbTag);
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, bwVar.eAe);
            aqVar.dR("tid", bwVar.getTid());
            aqVar.dR("nid", bwVar.getNid());
            if (bwVar.biJ() || bwVar.blW()) {
                aqVar.aj("obj_type", 14);
            } else if (bwVar.biI()) {
                aqVar.aj("obj_type", 13);
            } else {
                aqVar.aj("obj_type", i);
            }
            aqVar.dR(TiebaInitialize.Params.OBJ_TO, ax(bwVar));
            if (bVar.iZH >= 0) {
                aqVar.aj("tab_id", bVar.iZH);
            }
            if (bwVar.evR >= 0) {
                aqVar.aj("obj_floor", bwVar.evR);
            }
            aqVar.aj("thread_type", bwVar.getType() == bw.eyr ? 2 : 1);
            TiebaStatic.log(aqVar);
            if (bwVar.biG()) {
                aq aqVar2 = new aq("c12098");
                aqVar2.dR("fid", bVar.iZG);
                aqVar2.aj("obj_locate", a(bVar));
                aqVar2.dR("obj_source", bwVar.mRecomSource);
                aqVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar2.dR("obj_param1", bwVar.mRecomAbTag);
                aqVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, bwVar.eAe);
                aqVar2.dR("tid", bwVar.getTid());
                aqVar2.aj("obj_type", i);
                aqVar2.dR(TiebaInitialize.Params.OBJ_TO, ax(bwVar));
                TiebaStatic.log(aqVar2);
            }
            if (bVar.iZH == 501) {
                aq aqVar3 = new aq("c13260");
                aqVar3.dR("fid", bVar.iZG);
                aqVar3.dR("tid", bwVar.getTid());
                t.clQ().e(aqVar3);
            }
            if (bwVar.bka() != null && bwVar.bka().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bka().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    aq aqVar4 = new aq("c11850");
                    aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.iZJ > 0) {
            if (bVar.iZH == 1120 || bVar.iZH == 1121) {
                return 15;
            }
            if (bVar.iZK == 3) {
                return 13;
            }
            return bVar.iZJ;
        }
        int i = bVar.iZF;
        if (i == 8) {
            i = 9;
        }
        if (bVar.iZH == 504) {
            i = 11;
        }
        if (bVar.iZH == 1120 || bVar.iZH == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            aq aj = new aq("c11440").dR("fid", frsViewData.getForum().getId()).aj("obj_locate", i).aj("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, aj);
            }
            TiebaStatic.log(aj);
        }
    }

    private String ax(bw bwVar) {
        return bwVar.eAh ? String.valueOf(bwVar.blo()) : String.valueOf(4);
    }
}
