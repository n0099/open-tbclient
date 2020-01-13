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
/* loaded from: classes7.dex */
public class c {
    public static int gHr;
    private static c gHu;
    private a gHs;
    private SparseArray<HashSet<String>> gHt;
    private CustomMessageListener cHC = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.gHt != null) {
                c.this.gHt.clear();
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
                        aVar.gHx = false;
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
    /* loaded from: classes7.dex */
    public class a {
        public int count;
        public long gHw;
        public boolean gHx;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.gHx = false;
        }
    }

    public c() {
        gHr = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.cHC);
    }

    public static c bIf() {
        if (gHu == null) {
            synchronized (r.class) {
                if (gHu == null) {
                    gHu = new c();
                }
            }
        }
        return gHu;
    }

    private boolean bIg() {
        if (this.gHs == null) {
            this.gHs = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.gHs.gHx) {
            return true;
        }
        if (this.gHs.isRunning) {
            this.gHs.count++;
            if (currentTimeMillis - this.gHs.gHw < 120000) {
                if (this.gHs.count >= gHr) {
                    this.gHs.gHx = true;
                    a(this.gHs);
                    return true;
                }
            } else {
                this.gHs.isRunning = false;
                this.gHs.count = 0;
            }
        } else {
            this.gHs.isRunning = true;
            this.gHs.gHw = currentTimeMillis;
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
        if (bjVar != null && bjVar.azB()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bjVar.getTid() != null && !hashSet.contains(bjVar.getTid())) {
                hashSet.add(bjVar.getTid());
                r.btA().c(new an("c11662").Z("obj_param1", 1).cp("post_id", bjVar.getTid()));
            }
        }
    }

    public void a(bj bjVar, boolean z) {
        if (bjVar != null) {
            r.btA().c(new an("c12125").cp("tid", bjVar.getId()).Z("obj_locate", z ? 2 : 1).s("obj_id", bjVar.aAq() != null ? bjVar.aAq().live_id : -1L).Z("obj_type", 1));
        }
    }

    public void ar(bj bjVar) {
        if (bjVar != null && bjVar.aBe()) {
            an anVar = new an("c11717");
            anVar.s("fid", bjVar.getFid());
            anVar.cp("obj_source", bjVar.mRecomSource);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cp("obj_param1", bjVar.cPt);
            anVar.Z("obj_locate", 1);
            anVar.cp("tid", bjVar.getTid());
            r.btA().c(anVar);
        }
    }

    public void a(b bVar, bj bjVar) {
        if (bVar != null && bVar.gHl && bjVar != null && bjVar.getTid() != null) {
            if (this.gHt == null) {
                this.gHt = new SparseArray<>();
            }
            if (this.gHt.get(bVar.gHo) == null) {
                this.gHt.put(bVar.gHo, new HashSet<>());
            }
            HashSet<String> hashSet = this.gHt.get(bVar.gHo);
            String tid = bjVar.getTid();
            if (bVar.gHp >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.gHp;
            }
            if (!hashSet.contains(tid) && !bIg()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.cp("fid", bVar.gHn);
                anVar.Z("obj_locate", a(bVar));
                anVar.cp("obj_source", bjVar.mRecomSource);
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar.cp("obj_param1", bjVar.mRecomAbTag);
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cPt);
                anVar.cp("tid", bjVar.getTid());
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.gHo >= 0) {
                    anVar.Z("tab_id", bVar.gHo);
                }
                if (bjVar.cLB >= 0) {
                    anVar.Z("obj_floor", bjVar.cLB);
                }
                boolean z = (bjVar.aBx() == null || (bjVar.aBx().cJz() == null && bjVar.aBx().aRH() == null)) ? false : true;
                if (z && bjVar.aBx().cJz() != null && bjVar.aBx().cJz().aRz() != null && bjVar.aBx().cJz().aRz().size() > 0) {
                    anVar.Z("obj_name", bjVar.aBx().kfT ? 3 : 2);
                } else {
                    anVar.Z("obj_name", z ? 1 : 0);
                }
                boolean z2 = bjVar.getType() == bj.cNE;
                anVar.Z("thread_type", z2 ? 2 : 1);
                if (z2 && bjVar.azX() != null && !StringUtils.isNull(bjVar.azX().getName_show())) {
                    anVar.cp("obj_name", bjVar.azX().getName_show());
                }
                if (bjVar.aBS() || bjVar.aBU()) {
                    anVar.Z("obj_type", 14);
                } else if (bjVar.ayL()) {
                    anVar.Z("obj_type", 13);
                }
                r.btA().c(anVar);
                if (bjVar.aAX()) {
                    an anVar2 = new an("c12099");
                    anVar2.cp("fid", bVar.gHn);
                    anVar2.Z("obj_locate", a(bVar));
                    anVar2.cp("obj_source", bjVar.mRecomSource);
                    anVar2.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                    anVar2.cp("obj_param1", bjVar.mRecomAbTag);
                    anVar2.cp(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cPt);
                    anVar2.cp("tid", bjVar.getTid());
                    anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    r.btA().c(anVar2);
                }
                if (bjVar.aAb()) {
                    an anVar3 = new an("c13169");
                    anVar3.cp("fid", bVar.gHn);
                    anVar3.cp("tid", bjVar.getTid());
                    anVar3.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    r.btA().c(anVar3);
                }
                if (bVar.gHo == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.cp("fid", bVar.gHn);
                    anVar4.cp("tid", bjVar.getTid());
                    r.btA().c(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gHl && bjVar != null && bjVar.getTid() != null) {
            r.btA().kn(true);
            an anVar = new an("c11438");
            anVar.cp("fid", bVar.gHn);
            anVar.Z("obj_locate", a(bVar));
            anVar.cp("obj_source", bjVar.mRecomSource);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cp("obj_param1", bjVar.mRecomAbTag);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cPt);
            anVar.cp("tid", bjVar.getTid());
            if (bjVar.aBS() || bjVar.aBU()) {
                anVar.Z("obj_type", 14);
            } else if (bjVar.ayL()) {
                anVar.Z("obj_type", 13);
            } else {
                anVar.Z("obj_type", i);
            }
            anVar.cp(TiebaInitialize.Params.OBJ_TO, as(bjVar));
            if (bVar.gHo >= 0) {
                anVar.Z("tab_id", bVar.gHo);
            }
            if (bjVar.cLB >= 0) {
                anVar.Z("obj_floor", bjVar.cLB);
            }
            anVar.Z("thread_type", bjVar.getType() == bj.cNE ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bjVar.aAX()) {
                an anVar2 = new an("c12098");
                anVar2.cp("fid", bVar.gHn);
                anVar2.Z("obj_locate", a(bVar));
                anVar2.cp("obj_source", bjVar.mRecomSource);
                anVar2.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar2.cp("obj_param1", bjVar.mRecomAbTag);
                anVar2.cp(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cPt);
                anVar2.cp("tid", bjVar.getTid());
                anVar2.Z("obj_type", i);
                anVar2.cp(TiebaInitialize.Params.OBJ_TO, as(bjVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.gHo == 501) {
                an anVar3 = new an("c13260");
                anVar3.cp("fid", bVar.gHn);
                anVar3.cp("tid", bjVar.getTid());
                r.btA().c(anVar3);
            }
            if (bjVar.azX() != null && bjVar.azX().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.azX().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    an anVar4 = new an("c11850");
                    anVar4.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(anVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.gHq > 0) {
            return bVar.gHq;
        }
        int i = bVar.gHm;
        if (i == 8) {
            i = 9;
        }
        if (bVar.gHo == 504) {
            return 11;
        }
        return i;
    }

    public void b(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gHl && bjVar != null && bjVar.getTid() != null && bjVar.aAb()) {
            an anVar = new an("c13170");
            anVar.cp("fid", bVar.gHn);
            anVar.Z("obj_locate", i);
            anVar.cp("tid", bjVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            an Z = new an("c11440").cp("fid", frsViewData.getForum().getId()).Z("obj_locate", i).Z("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, Z);
            }
            TiebaStatic.log(Z);
        }
    }

    private String as(bj bjVar) {
        return bjVar.cPw ? String.valueOf(bjVar.aBj()) : String.valueOf(4);
    }
}
