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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.r;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class c {
    public static int gKJ;
    private static c gKM;
    private a gKK;
    private SparseArray<HashSet<String>> gKL;
    private CustomMessageListener cLS = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.gKL != null) {
                c.this.gKL.clear();
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
                        aVar.gKP = false;
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
        public long gKO;
        public boolean gKP;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.gKP = false;
        }
    }

    public c() {
        gKJ = com.baidu.tbadk.core.sharedPref.b.aFH().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.cLS);
    }

    public static c bJX() {
        if (gKM == null) {
            synchronized (r.class) {
                if (gKM == null) {
                    gKM = new c();
                }
            }
        }
        return gKM;
    }

    private boolean bJY() {
        if (this.gKK == null) {
            this.gKK = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.gKK.gKP) {
            return true;
        }
        if (this.gKK.isRunning) {
            this.gKK.count++;
            if (currentTimeMillis - this.gKK.gKO < 120000) {
                if (this.gKK.count >= gKJ) {
                    this.gKK.gKP = true;
                    a(this.gKK);
                    return true;
                }
            } else {
                this.gKK.isRunning = false;
                this.gKK.count = 0;
            }
        } else {
            this.gKK.isRunning = true;
            this.gKK.gKO = currentTimeMillis;
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

    public void a(bj bjVar, HashSet<String> hashSet) {
        if (bjVar != null && bjVar.aBW()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bjVar.getTid() != null && !hashSet.contains(bjVar.getTid())) {
                hashSet.add(bjVar.getTid());
                r.bvm().e(new an("c11662").X("obj_param1", 1).cx("post_id", bjVar.getTid()));
            }
        }
    }

    public void a(bj bjVar, boolean z) {
        if (bjVar != null) {
            r.bvm().e(new an("c12125").cx("tid", bjVar.getId()).X("obj_locate", z ? 2 : 1).s("obj_id", bjVar.aCK() != null ? bjVar.aCK().live_id : -1L).X("obj_type", 1));
        }
    }

    public void aw(bj bjVar) {
        if (bjVar != null && bjVar.aDx()) {
            an anVar = new an("c11717");
            anVar.s("fid", bjVar.getFid());
            anVar.cx("obj_source", bjVar.mRecomSource);
            anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cx("obj_param1", bjVar.cTK);
            anVar.X("obj_locate", 1);
            anVar.cx("tid", bjVar.getTid());
            r.bvm().e(anVar);
        }
    }

    public void a(b bVar, bj bjVar) {
        if (bVar != null && bVar.gKD && bjVar != null && bjVar.getTid() != null) {
            if (this.gKL == null) {
                this.gKL = new SparseArray<>();
            }
            if (this.gKL.get(bVar.gKG) == null) {
                this.gKL.put(bVar.gKG, new HashSet<>());
            }
            HashSet<String> hashSet = this.gKL.get(bVar.gKG);
            String tid = bjVar.getTid();
            if (bVar.gKH >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.gKH;
            }
            if (!hashSet.contains(tid) && !bJY()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.cx("fid", bVar.gKF);
                anVar.X("obj_locate", a(bVar));
                anVar.cx("obj_source", bjVar.mRecomSource);
                anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar.cx("obj_param1", bjVar.mRecomAbTag);
                anVar.cx(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTK);
                anVar.cx("tid", bjVar.getTid());
                anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.gKG >= 0) {
                    anVar.X("tab_id", bVar.gKG);
                }
                if (bjVar.cPT >= 0) {
                    anVar.X("obj_floor", bjVar.cPT);
                }
                boolean z = (bjVar.aDQ() == null || (bjVar.aDQ().cLx() == null && bjVar.aDQ().aUf() == null)) ? false : true;
                if (z && bjVar.aDQ().cLx() != null && bjVar.aDQ().cLx().aTX() != null && bjVar.aDQ().cLx().aTX().size() > 0) {
                    anVar.X("obj_name", bjVar.aDQ().kiQ ? 3 : 2);
                } else {
                    anVar.X("obj_name", z ? 1 : 0);
                }
                boolean z2 = bjVar.getType() == bj.cRW;
                anVar.X("thread_type", z2 ? 2 : 1);
                if (z2 && bjVar.aCr() != null && !StringUtils.isNull(bjVar.aCr().getName_show())) {
                    anVar.cx("obj_name", bjVar.aCr().getName_show());
                }
                if (bjVar.aBh() || bjVar.aEl()) {
                    anVar.X("obj_type", 14);
                } else if (bjVar.aBg()) {
                    anVar.X("obj_type", 13);
                }
                r.bvm().e(anVar);
                if (bjVar.aBe()) {
                    an anVar2 = new an("c12099");
                    anVar2.cx("fid", bVar.gKF);
                    anVar2.X("obj_locate", a(bVar));
                    anVar2.cx("obj_source", bjVar.mRecomSource);
                    anVar2.cx(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                    anVar2.cx("obj_param1", bjVar.mRecomAbTag);
                    anVar2.cx(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTK);
                    anVar2.cx("tid", bjVar.getTid());
                    anVar2.cx("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bvm().e(anVar2);
                }
                if (bjVar.aCv()) {
                    an anVar3 = new an("c13169");
                    anVar3.cx("fid", bVar.gKF);
                    anVar3.cx("tid", bjVar.getTid());
                    anVar3.cx("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bvm().e(anVar3);
                }
                if (bVar.gKG == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.cx("fid", bVar.gKF);
                    anVar4.cx("tid", bjVar.getTid());
                    r.bvm().e(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gKD && bjVar != null && bjVar.getTid() != null) {
            r.bvm().ku(true);
            an anVar = new an("c11438");
            anVar.cx("fid", bVar.gKF);
            anVar.X("obj_locate", a(bVar));
            anVar.cx("obj_source", bjVar.mRecomSource);
            anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cx("obj_param1", bjVar.mRecomAbTag);
            anVar.cx(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTK);
            anVar.cx("tid", bjVar.getTid());
            if (bjVar.aBh() || bjVar.aEl()) {
                anVar.X("obj_type", 14);
            } else if (bjVar.aBg()) {
                anVar.X("obj_type", 13);
            } else {
                anVar.X("obj_type", i);
            }
            anVar.cx(TiebaInitialize.Params.OBJ_TO, ax(bjVar));
            if (bVar.gKG >= 0) {
                anVar.X("tab_id", bVar.gKG);
            }
            if (bjVar.cPT >= 0) {
                anVar.X("obj_floor", bjVar.cPT);
            }
            anVar.X("thread_type", bjVar.getType() == bj.cRW ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bjVar.aBe()) {
                an anVar2 = new an("c12098");
                anVar2.cx("fid", bVar.gKF);
                anVar2.X("obj_locate", a(bVar));
                anVar2.cx("obj_source", bjVar.mRecomSource);
                anVar2.cx(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar2.cx("obj_param1", bjVar.mRecomAbTag);
                anVar2.cx(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTK);
                anVar2.cx("tid", bjVar.getTid());
                anVar2.X("obj_type", i);
                anVar2.cx(TiebaInitialize.Params.OBJ_TO, ax(bjVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.gKG == 501) {
                an anVar3 = new an("c13260");
                anVar3.cx("fid", bVar.gKF);
                anVar3.cx("tid", bjVar.getTid());
                r.bvm().e(anVar3);
            }
            if (bjVar.aCr() != null && bjVar.aCr().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aCr().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    an anVar4 = new an("c11850");
                    anVar4.cx("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(anVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.gKI > 0) {
            return bVar.gKI;
        }
        int i = bVar.gKE;
        if (i == 8) {
            i = 9;
        }
        if (bVar.gKG == 504) {
            return 11;
        }
        return i;
    }

    public void b(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gKD && bjVar != null && bjVar.getTid() != null && bjVar.aCv()) {
            an anVar = new an("c13170");
            anVar.cx("fid", bVar.gKF);
            anVar.X("obj_locate", i);
            anVar.cx("tid", bjVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            an X = new an("c11440").cx("fid", frsViewData.getForum().getId()).X("obj_locate", i).X("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, X);
            }
            TiebaStatic.log(X);
        }
    }

    private String ax(bj bjVar) {
        return bjVar.cTN ? String.valueOf(bjVar.aDC()) : String.valueOf(4);
    }
}
