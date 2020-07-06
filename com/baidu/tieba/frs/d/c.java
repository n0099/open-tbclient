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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class c {
    public static int hWS;
    private static c hWV;
    private a hWT;
    private SparseArray<HashSet<String>> hWU;
    private CustomMessageListener dFw = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.hWU != null) {
                c.this.hWU.clear();
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
                        aVar.hWY = false;
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
    /* loaded from: classes9.dex */
    public class a {
        public int count;
        public long hWX;
        public boolean hWY;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.hWY = false;
        }
    }

    public c() {
        hWS = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.dFw);
    }

    public static c cer() {
        if (hWV == null) {
            synchronized (s.class) {
                if (hWV == null) {
                    hWV = new c();
                }
            }
        }
        return hWV;
    }

    private boolean ces() {
        if (this.hWT == null) {
            this.hWT = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hWT.hWY) {
            return true;
        }
        if (this.hWT.isRunning) {
            this.hWT.count++;
            if (currentTimeMillis - this.hWT.hWX < 120000) {
                if (this.hWT.count >= hWS) {
                    this.hWT.hWY = true;
                    a(this.hWT);
                    return true;
                }
            } else {
                this.hWT.isRunning = false;
                this.hWT.count = 0;
            }
        } else {
            this.hWT.isRunning = true;
            this.hWT.hWX = currentTimeMillis;
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

    public void a(bu buVar, HashSet<String> hashSet) {
        if (buVar != null && buVar.aRU()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (buVar.getTid() != null && !hashSet.contains(buVar.getTid())) {
                hashSet.add(buVar.getTid());
                s.bOB().e(new ao("c11662").ag("obj_param1", 1).dk("post_id", buVar.getTid()));
            }
        }
    }

    public void a(bu buVar, boolean z) {
        if (buVar != null) {
            s.bOB().e(new ao("c12125").dk("tid", buVar.getId()).ag("obj_locate", z ? 2 : 1).s("obj_id", buVar.aSJ() != null ? buVar.aSJ().live_id : -1L).ag("obj_type", 1));
        }
    }

    public void ay(bu buVar) {
        if (buVar != null && buVar.aTy()) {
            ao aoVar = new ao("c11717");
            aoVar.s("fid", buVar.getFid());
            aoVar.dk("obj_source", buVar.mRecomSource);
            aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, buVar.mRecomWeight);
            aoVar.dk("obj_param1", buVar.dND);
            aoVar.ag("obj_locate", 1);
            aoVar.dk("tid", buVar.getTid());
            s.bOB().e(aoVar);
        }
    }

    public void a(b bVar, bu buVar) {
        if (bVar != null && bVar.hWM && buVar != null && buVar.getTid() != null) {
            if (this.hWU == null) {
                this.hWU = new SparseArray<>();
            }
            if (this.hWU.get(bVar.hWP) == null) {
                this.hWU.put(bVar.hWP, new HashSet<>());
            }
            HashSet<String> hashSet = this.hWU.get(bVar.hWP);
            String tid = buVar.getTid();
            if (bVar.hWQ >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.hWQ;
            }
            if (!hashSet.contains(tid) && !ces()) {
                hashSet.add(tid);
                ao aoVar = new ao("c11439");
                aoVar.dk("fid", bVar.hWO);
                aoVar.ag("obj_locate", a(bVar));
                aoVar.dk("obj_source", buVar.mRecomSource);
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, buVar.mRecomWeight);
                aoVar.dk("obj_param1", buVar.mRecomAbTag);
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM3, buVar.dND);
                aoVar.dk("tid", buVar.getTid());
                aoVar.dk("nid", buVar.getNid());
                aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                aoVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.hWP >= 0) {
                    aoVar.ag("tab_id", bVar.hWP);
                }
                if (buVar.dJw >= 0) {
                    aoVar.ag("obj_floor", buVar.dJw);
                }
                boolean z = (buVar.aTS() == null || (buVar.aTS().dib() == null && buVar.aTS().bkX() == null)) ? false : true;
                if (z && buVar.aTS().dib() != null && buVar.aTS().dib().bkP() != null && buVar.aTS().dib().bkP().size() > 0) {
                    aoVar.ag("obj_name", buVar.aTS().lGt ? 3 : 2);
                } else {
                    aoVar.ag("obj_name", z ? 1 : 0);
                }
                boolean z2 = buVar.getType() == bu.dLQ;
                aoVar.ag("thread_type", z2 ? 2 : 1);
                if (z2 && buVar.aSp() != null && !StringUtils.isNull(buVar.aSp().getName_show())) {
                    aoVar.dk("obj_name", buVar.aSp().getName_show());
                }
                if (buVar.aQY() || buVar.aUm()) {
                    aoVar.ag("obj_type", 14);
                } else if (buVar.aQX()) {
                    aoVar.ag("obj_type", 13);
                }
                s.bOB().e(aoVar);
                if (buVar.aQV()) {
                    ao aoVar2 = new ao("c12099");
                    aoVar2.dk("fid", bVar.hWO);
                    aoVar2.ag("obj_locate", a(bVar));
                    aoVar2.dk("obj_source", buVar.mRecomSource);
                    aoVar2.dk(TiebaInitialize.Params.OBJ_PARAM2, buVar.mRecomWeight);
                    aoVar2.dk("obj_param1", buVar.mRecomAbTag);
                    aoVar2.dk(TiebaInitialize.Params.OBJ_PARAM3, buVar.dND);
                    aoVar2.dk("tid", buVar.getTid());
                    aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                    s.bOB().e(aoVar2);
                }
                if (bVar.hWP == 501) {
                    ao aoVar3 = new ao("c13259");
                    aoVar3.dk("fid", bVar.hWO);
                    aoVar3.dk("tid", buVar.getTid());
                    s.bOB().e(aoVar3);
                }
            }
        }
    }

    public void a(b bVar, bu buVar, int i) {
        if (bVar != null && bVar.hWM && buVar != null && buVar.getTid() != null) {
            s.bOB().mc(true);
            ao aoVar = new ao("c11438");
            aoVar.dk("fid", bVar.hWO);
            aoVar.ag("obj_locate", a(bVar));
            aoVar.dk("obj_source", buVar.mRecomSource);
            aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, buVar.mRecomWeight);
            aoVar.dk("obj_param1", buVar.mRecomAbTag);
            aoVar.dk(TiebaInitialize.Params.OBJ_PARAM3, buVar.dND);
            aoVar.dk("tid", buVar.getTid());
            aoVar.dk("nid", buVar.getNid());
            if (buVar.aQY() || buVar.aUm()) {
                aoVar.ag("obj_type", 14);
            } else if (buVar.aQX()) {
                aoVar.ag("obj_type", 13);
            } else {
                aoVar.ag("obj_type", i);
            }
            aoVar.dk(TiebaInitialize.Params.OBJ_TO, az(buVar));
            if (bVar.hWP >= 0) {
                aoVar.ag("tab_id", bVar.hWP);
            }
            if (buVar.dJw >= 0) {
                aoVar.ag("obj_floor", buVar.dJw);
            }
            aoVar.ag("thread_type", buVar.getType() == bu.dLQ ? 2 : 1);
            TiebaStatic.log(aoVar);
            if (buVar.aQV()) {
                ao aoVar2 = new ao("c12098");
                aoVar2.dk("fid", bVar.hWO);
                aoVar2.ag("obj_locate", a(bVar));
                aoVar2.dk("obj_source", buVar.mRecomSource);
                aoVar2.dk(TiebaInitialize.Params.OBJ_PARAM2, buVar.mRecomWeight);
                aoVar2.dk("obj_param1", buVar.mRecomAbTag);
                aoVar2.dk(TiebaInitialize.Params.OBJ_PARAM3, buVar.dND);
                aoVar2.dk("tid", buVar.getTid());
                aoVar2.ag("obj_type", i);
                aoVar2.dk(TiebaInitialize.Params.OBJ_TO, az(buVar));
                TiebaStatic.log(aoVar2);
            }
            if (bVar.hWP == 501) {
                ao aoVar3 = new ao("c13260");
                aoVar3.dk("fid", bVar.hWO);
                aoVar3.dk("tid", buVar.getTid());
                s.bOB().e(aoVar3);
            }
            if (buVar.aSp() != null && buVar.aSp().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = buVar.aSp().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    ao aoVar4 = new ao("c11850");
                    aoVar4.dk("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aoVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.hWR > 0) {
            return bVar.hWR;
        }
        int i = bVar.hWN;
        if (i == 8) {
            i = 9;
        }
        if (bVar.hWP == 504) {
            return 11;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            ao ag = new ao("c11440").dk("fid", frsViewData.getForum().getId()).ag("obj_locate", i).ag("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, ag);
            }
            TiebaStatic.log(ag);
        }
    }

    private String az(bu buVar) {
        return buVar.dNG ? String.valueOf(buVar.aTD()) : String.valueOf(4);
    }
}
