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
    public static int hua;
    private static c hud;
    private a hub;
    private SparseArray<HashSet<String>> huc;
    private CustomMessageListener dkZ = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.huc != null) {
                c.this.huc.clear();
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
                        aVar.hug = false;
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
        public long huf;
        public boolean hug;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.hug = false;
        }
    }

    public c() {
        hua = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.dkZ);
    }

    public static c bUu() {
        if (hud == null) {
            synchronized (r.class) {
                if (hud == null) {
                    hud = new c();
                }
            }
        }
        return hud;
    }

    private boolean bUv() {
        if (this.hub == null) {
            this.hub = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hub.hug) {
            return true;
        }
        if (this.hub.isRunning) {
            this.hub.count++;
            if (currentTimeMillis - this.hub.huf < 120000) {
                if (this.hub.count >= hua) {
                    this.hub.hug = true;
                    a(this.hub);
                    return true;
                }
            } else {
                this.hub.isRunning = false;
                this.hub.count = 0;
            }
        } else {
            this.hub.isRunning = true;
            this.hub.huf = currentTimeMillis;
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
        if (bjVar != null && bjVar.aKj()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bjVar.getTid() != null && !hashSet.contains(bjVar.getTid())) {
                hashSet.add(bjVar.getTid());
                r.bEY().e(new an("c11662").af("obj_param1", 1).cI("post_id", bjVar.getTid()));
            }
        }
    }

    public void a(bj bjVar, boolean z) {
        if (bjVar != null) {
            r.bEY().e(new an("c12125").cI("tid", bjVar.getId()).af("obj_locate", z ? 2 : 1).t("obj_id", bjVar.aKX() != null ? bjVar.aKX().live_id : -1L).af("obj_type", 1));
        }
    }

    public void ax(bj bjVar) {
        if (bjVar != null && bjVar.aLK()) {
            an anVar = new an("c11717");
            anVar.t("fid", bjVar.getFid());
            anVar.cI("obj_source", bjVar.mRecomSource);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cI("obj_param1", bjVar.dsU);
            anVar.af("obj_locate", 1);
            anVar.cI("tid", bjVar.getTid());
            r.bEY().e(anVar);
        }
    }

    public void a(b bVar, bj bjVar) {
        if (bVar != null && bVar.htU && bjVar != null && bjVar.getTid() != null) {
            if (this.huc == null) {
                this.huc = new SparseArray<>();
            }
            if (this.huc.get(bVar.htX) == null) {
                this.huc.put(bVar.htX, new HashSet<>());
            }
            HashSet<String> hashSet = this.huc.get(bVar.htX);
            String tid = bjVar.getTid();
            if (bVar.htY >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.htY;
            }
            if (!hashSet.contains(tid) && !bUv()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.cI("fid", bVar.htW);
                anVar.af("obj_locate", a(bVar));
                anVar.cI("obj_source", bjVar.mRecomSource);
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar.cI("obj_param1", bjVar.mRecomAbTag);
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, bjVar.dsU);
                anVar.cI("tid", bjVar.getTid());
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.t(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.htX >= 0) {
                    anVar.af("tab_id", bVar.htX);
                }
                if (bjVar.doZ >= 0) {
                    anVar.af("obj_floor", bjVar.doZ);
                }
                boolean z = (bjVar.aMe() == null || (bjVar.aMe().cWt() == null && bjVar.aMe().bcp() == null)) ? false : true;
                if (z && bjVar.aMe().cWt() != null && bjVar.aMe().cWt().bch() != null && bjVar.aMe().cWt().bch().size() > 0) {
                    anVar.af("obj_name", bjVar.aMe().kSW ? 3 : 2);
                } else {
                    anVar.af("obj_name", z ? 1 : 0);
                }
                boolean z2 = bjVar.getType() == bj.dre;
                anVar.af("thread_type", z2 ? 2 : 1);
                if (z2 && bjVar.aKE() != null && !StringUtils.isNull(bjVar.aKE().getName_show())) {
                    anVar.cI("obj_name", bjVar.aKE().getName_show());
                }
                if (bjVar.aJu() || bjVar.aMz()) {
                    anVar.af("obj_type", 14);
                } else if (bjVar.aJt()) {
                    anVar.af("obj_type", 13);
                }
                r.bEY().e(anVar);
                if (bjVar.aJr()) {
                    an anVar2 = new an("c12099");
                    anVar2.cI("fid", bVar.htW);
                    anVar2.af("obj_locate", a(bVar));
                    anVar2.cI("obj_source", bjVar.mRecomSource);
                    anVar2.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                    anVar2.cI("obj_param1", bjVar.mRecomAbTag);
                    anVar2.cI(TiebaInitialize.Params.OBJ_PARAM3, bjVar.dsU);
                    anVar2.cI("tid", bjVar.getTid());
                    anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bEY().e(anVar2);
                }
                if (bjVar.aKI()) {
                    an anVar3 = new an("c13169");
                    anVar3.cI("fid", bVar.htW);
                    anVar3.cI("tid", bjVar.getTid());
                    anVar3.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bEY().e(anVar3);
                }
                if (bVar.htX == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.cI("fid", bVar.htW);
                    anVar4.cI("tid", bjVar.getTid());
                    r.bEY().e(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.htU && bjVar != null && bjVar.getTid() != null) {
            r.bEY().lx(true);
            an anVar = new an("c11438");
            anVar.cI("fid", bVar.htW);
            anVar.af("obj_locate", a(bVar));
            anVar.cI("obj_source", bjVar.mRecomSource);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cI("obj_param1", bjVar.mRecomAbTag);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, bjVar.dsU);
            anVar.cI("tid", bjVar.getTid());
            if (bjVar.aJu() || bjVar.aMz()) {
                anVar.af("obj_type", 14);
            } else if (bjVar.aJt()) {
                anVar.af("obj_type", 13);
            } else {
                anVar.af("obj_type", i);
            }
            anVar.cI(TiebaInitialize.Params.OBJ_TO, ay(bjVar));
            if (bVar.htX >= 0) {
                anVar.af("tab_id", bVar.htX);
            }
            if (bjVar.doZ >= 0) {
                anVar.af("obj_floor", bjVar.doZ);
            }
            anVar.af("thread_type", bjVar.getType() == bj.dre ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bjVar.aJr()) {
                an anVar2 = new an("c12098");
                anVar2.cI("fid", bVar.htW);
                anVar2.af("obj_locate", a(bVar));
                anVar2.cI("obj_source", bjVar.mRecomSource);
                anVar2.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar2.cI("obj_param1", bjVar.mRecomAbTag);
                anVar2.cI(TiebaInitialize.Params.OBJ_PARAM3, bjVar.dsU);
                anVar2.cI("tid", bjVar.getTid());
                anVar2.af("obj_type", i);
                anVar2.cI(TiebaInitialize.Params.OBJ_TO, ay(bjVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.htX == 501) {
                an anVar3 = new an("c13260");
                anVar3.cI("fid", bVar.htW);
                anVar3.cI("tid", bjVar.getTid());
                r.bEY().e(anVar3);
            }
            if (bjVar.aKE() != null && bjVar.aKE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aKE().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    an anVar4 = new an("c11850");
                    anVar4.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(anVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.htZ > 0) {
            return bVar.htZ;
        }
        int i = bVar.htV;
        if (i == 8) {
            i = 9;
        }
        if (bVar.htX == 504) {
            return 11;
        }
        return i;
    }

    public void b(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.htU && bjVar != null && bjVar.getTid() != null && bjVar.aKI()) {
            an anVar = new an("c13170");
            anVar.cI("fid", bVar.htW);
            anVar.af("obj_locate", i);
            anVar.cI("tid", bjVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            an af = new an("c11440").cI("fid", frsViewData.getForum().getId()).af("obj_locate", i).af("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, af);
            }
            TiebaStatic.log(af);
        }
    }

    private String ay(bj bjVar) {
        return bjVar.dsX ? String.valueOf(bjVar.aLP()) : String.valueOf(4);
    }
}
