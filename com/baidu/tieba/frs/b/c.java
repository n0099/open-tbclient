package com.baidu.tieba.frs.b;

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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class c {
    public static int jBN;
    private static c jBQ;
    private a jBO;
    private SparseArray<HashSet<String>> jBP;
    private CustomMessageListener eHt = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.jBP != null) {
                c.this.jBP.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.b.c.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.jBT = false;
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
        public boolean isRunning;
        public long jBS;
        public boolean jBT;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jBT = false;
        }
    }

    public c() {
        jBN = com.baidu.tbadk.core.sharedPref.b.brx().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.eHt);
    }

    public static c cIR() {
        if (jBQ == null) {
            synchronized (s.class) {
                if (jBQ == null) {
                    jBQ = new c();
                }
            }
        }
        return jBQ;
    }

    private boolean cIS() {
        if (this.jBO == null) {
            this.jBO = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jBO.jBT) {
            return true;
        }
        if (this.jBO.isRunning) {
            this.jBO.count++;
            if (currentTimeMillis - this.jBO.jBS < 120000) {
                if (this.jBO.count >= jBN) {
                    this.jBO.jBT = true;
                    a(this.jBO);
                    return true;
                }
            } else {
                this.jBO.isRunning = false;
                this.jBO.count = 0;
            }
        } else {
            this.jBO.isRunning = true;
            this.jBO.jBS = currentTimeMillis;
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

    public void a(bz bzVar, HashSet<String> hashSet) {
        if (bzVar != null && bzVar.bnc()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bzVar.getTid() != null && !hashSet.contains(bzVar.getTid())) {
                hashSet.add(bzVar.getTid());
                s.crj().e(new aq("c11662").an("obj_param1", 1).dW("post_id", bzVar.getTid()));
            }
        }
    }

    public void a(bz bzVar, boolean z) {
        if (bzVar != null) {
            s.crj().e(new aq("c12125").dW("tid", bzVar.getId()).an("obj_locate", z ? 2 : 1).w("obj_id", bzVar.bnQ() != null ? bzVar.bnQ().live_id : -1L).an("obj_type", 1));
        }
    }

    public void ay(bz bzVar) {
        if (bzVar != null && bzVar.boI()) {
            aq aqVar = new aq("c11717");
            aqVar.w("fid", bzVar.getFid());
            aqVar.dW("obj_source", bzVar.mRecomSource);
            aqVar.dW(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
            aqVar.dW("obj_param1", bzVar.eQw);
            aqVar.an("obj_locate", 1);
            aqVar.dW("tid", bzVar.getTid());
            s.crj().e(aqVar);
        }
    }

    public void a(b bVar, bz bzVar) {
        if (bVar != null && bVar.jBG && bzVar != null && bzVar.getTid() != null) {
            if (this.jBP == null) {
                this.jBP = new SparseArray<>();
            }
            if (this.jBP.get(bVar.jBJ) == null) {
                this.jBP.put(bVar.jBJ, new HashSet<>());
            }
            HashSet<String> hashSet = this.jBP.get(bVar.jBJ);
            String tid = bzVar.getTid();
            if (bVar.jBK >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.jBK;
            }
            if (!hashSet.contains(tid) && !cIS()) {
                hashSet.add(tid);
                aq aqVar = new aq("c11439");
                aqVar.dW("fid", bVar.jBI);
                aqVar.an("obj_locate", a(bVar));
                aqVar.dW("obj_source", bzVar.mRecomSource);
                aqVar.dW(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
                aqVar.dW("obj_param1", bzVar.mRecomAbTag);
                aqVar.dW(TiebaInitialize.Params.OBJ_PARAM3, bzVar.eQw);
                aqVar.dW("tid", bzVar.getTid());
                aqVar.dW(IntentConfig.NID, bzVar.blV());
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.jBJ >= 0) {
                    aqVar.an("tab_id", bVar.jBJ);
                }
                if (bzVar.eMg >= 0) {
                    aqVar.an("obj_floor", bzVar.eMg);
                }
                boolean z = (bzVar.bpd() == null || (bzVar.bpd().dLo() == null && bzVar.bpd().bHn() == null)) ? false : true;
                if (z && bzVar.bpd().dLo() != null && bzVar.bpd().dLo().bHf() != null && bzVar.bpd().dLo().bHf().size() > 0) {
                    aqVar.an("obj_name", bzVar.bpd().nnt ? 3 : 2);
                } else {
                    aqVar.an("obj_name", z ? 1 : 0);
                }
                boolean z2 = bzVar.getType() == bz.eOI;
                aqVar.an("thread_type", z2 ? 2 : 1);
                if (z2 && bzVar.bnx() != null && !StringUtils.isNull(bzVar.bnx().getName_show())) {
                    aqVar.dW("obj_name", bzVar.bnx().getName_show());
                }
                if (bzVar.bmf() || bzVar.bpw()) {
                    aqVar.an("obj_type", 14);
                } else if (bzVar.bme()) {
                    aqVar.an("obj_type", 13);
                }
                s.crj().e(aqVar);
                if (bzVar.bmc()) {
                    aq aqVar2 = new aq("c12099");
                    aqVar2.dW("fid", bVar.jBI);
                    aqVar2.an("obj_locate", a(bVar));
                    aqVar2.dW("obj_source", bzVar.mRecomSource);
                    aqVar2.dW(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
                    aqVar2.dW("obj_param1", bzVar.mRecomAbTag);
                    aqVar2.dW(TiebaInitialize.Params.OBJ_PARAM3, bzVar.eQw);
                    aqVar2.dW("tid", bzVar.getTid());
                    aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    s.crj().e(aqVar2);
                }
                if (bVar.jBJ == 501) {
                    aq aqVar3 = new aq("c13259");
                    aqVar3.dW("fid", bVar.jBI);
                    aqVar3.dW("tid", bzVar.getTid());
                    s.crj().e(aqVar3);
                }
            }
        }
    }

    public void a(b bVar, bz bzVar, int i) {
        if (bVar != null && bVar.jBG && bzVar != null && bzVar.getTid() != null) {
            s.crj().pr(true);
            aq aqVar = new aq("c11438");
            aqVar.dW("fid", bVar.jBI);
            aqVar.an("obj_locate", a(bVar));
            aqVar.dW("obj_source", bzVar.mRecomSource);
            aqVar.dW(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
            aqVar.dW("obj_param1", bzVar.mRecomAbTag);
            aqVar.dW(TiebaInitialize.Params.OBJ_PARAM3, bzVar.eQw);
            aqVar.dW("tid", bzVar.getTid());
            aqVar.dW(IntentConfig.NID, bzVar.blV());
            if (bzVar.bmf() || bzVar.bpw()) {
                aqVar.an("obj_type", 14);
            } else if (bzVar.bme()) {
                aqVar.an("obj_type", 13);
            } else {
                aqVar.an("obj_type", i);
            }
            aqVar.dW(TiebaInitialize.Params.OBJ_TO, az(bzVar));
            if (bVar.jBJ >= 0) {
                aqVar.an("tab_id", bVar.jBJ);
            }
            if (bzVar.eMg >= 0) {
                aqVar.an("obj_floor", bzVar.eMg);
            }
            aqVar.an("thread_type", bzVar.getType() == bz.eOI ? 2 : 1);
            TiebaStatic.log(aqVar);
            if (bzVar.bmc()) {
                aq aqVar2 = new aq("c12098");
                aqVar2.dW("fid", bVar.jBI);
                aqVar2.an("obj_locate", a(bVar));
                aqVar2.dW("obj_source", bzVar.mRecomSource);
                aqVar2.dW(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
                aqVar2.dW("obj_param1", bzVar.mRecomAbTag);
                aqVar2.dW(TiebaInitialize.Params.OBJ_PARAM3, bzVar.eQw);
                aqVar2.dW("tid", bzVar.getTid());
                aqVar2.an("obj_type", i);
                aqVar2.dW(TiebaInitialize.Params.OBJ_TO, az(bzVar));
                TiebaStatic.log(aqVar2);
            }
            if (bVar.jBJ == 501) {
                aq aqVar3 = new aq("c13260");
                aqVar3.dW("fid", bVar.jBI);
                aqVar3.dW("tid", bzVar.getTid());
                s.crj().e(aqVar3);
            }
            if (bzVar.bnx() != null && bzVar.bnx().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bzVar.bnx().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    aq aqVar4 = new aq("c11850");
                    aqVar4.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.jBL > 0) {
            if (bVar.jBJ == 1120 || bVar.jBJ == 1121) {
                return 15;
            }
            if (bVar.jBM == 3) {
                return 13;
            }
            return bVar.jBL;
        }
        int i = bVar.jBH;
        if (i == 8) {
            i = 9;
        }
        if (bVar.jBJ == 504) {
            i = 11;
        }
        if (bVar.jBJ == 1120 || bVar.jBJ == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            aq an = new aq("c11440").dW("fid", frsViewData.getForum().getId()).an("obj_locate", i).an("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, an);
            }
            TiebaStatic.log(an);
        }
    }

    private String az(bz bzVar) {
        return bzVar.eQz ? String.valueOf(bzVar.boO()) : String.valueOf(4);
    }
}
