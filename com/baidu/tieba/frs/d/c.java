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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.r;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class c {
    public static int gEc;
    private static c gEf;
    private a gEd;
    private SparseArray<HashSet<String>> gEe;
    private CustomMessageListener cHq = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.gEe != null) {
                c.this.gEe.clear();
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
                        aVar.gEi = false;
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
    /* loaded from: classes6.dex */
    public class a {
        public int count;
        public long gEh;
        public boolean gEi;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.gEi = false;
        }
    }

    public c() {
        gEc = com.baidu.tbadk.core.sharedPref.b.aCY().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.cHq);
    }

    public static c bHd() {
        if (gEf == null) {
            synchronized (r.class) {
                if (gEf == null) {
                    gEf = new c();
                }
            }
        }
        return gEf;
    }

    private boolean bHe() {
        if (this.gEd == null) {
            this.gEd = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.gEd.gEi) {
            return true;
        }
        if (this.gEd.isRunning) {
            this.gEd.count++;
            if (currentTimeMillis - this.gEd.gEh < 120000) {
                if (this.gEd.count >= gEc) {
                    this.gEd.gEi = true;
                    a(this.gEd);
                    return true;
                }
            } else {
                this.gEd.isRunning = false;
                this.gEd.count = 0;
            }
        } else {
            this.gEd.isRunning = true;
            this.gEd.gEh = currentTimeMillis;
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
        if (bjVar != null && bjVar.azi()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bjVar.getTid() != null && !hashSet.contains(bjVar.getTid())) {
                hashSet.add(bjVar.getTid());
                r.bsy().c(new an("c11662").Z("obj_param1", 1).cp("post_id", bjVar.getTid()));
            }
        }
    }

    public void a(bj bjVar, boolean z) {
        if (bjVar != null) {
            r.bsy().c(new an("c12125").cp("tid", bjVar.getId()).Z("obj_locate", z ? 2 : 1).s("obj_id", bjVar.azX() != null ? bjVar.azX().live_id : -1L).Z("obj_type", 1));
        }
    }

    public void aq(bj bjVar) {
        if (bjVar != null && bjVar.aAL()) {
            an anVar = new an("c11717");
            anVar.s("fid", bjVar.getFid());
            anVar.cp("obj_source", bjVar.mRecomSource);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cp("obj_param1", bjVar.cPj);
            anVar.Z("obj_locate", 1);
            anVar.cp("tid", bjVar.getTid());
            r.bsy().c(anVar);
        }
    }

    public void a(b bVar, bj bjVar) {
        if (bVar != null && bVar.gDW && bjVar != null && bjVar.getTid() != null) {
            if (this.gEe == null) {
                this.gEe = new SparseArray<>();
            }
            if (this.gEe.get(bVar.gDZ) == null) {
                this.gEe.put(bVar.gDZ, new HashSet<>());
            }
            HashSet<String> hashSet = this.gEe.get(bVar.gDZ);
            String tid = bjVar.getTid();
            if (bVar.gEa >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.gEa;
            }
            if (!hashSet.contains(tid) && !bHe()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.cp("fid", bVar.gDY);
                anVar.Z("obj_locate", a(bVar));
                anVar.cp("obj_source", bjVar.mRecomSource);
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar.cp("obj_param1", bjVar.mRecomAbTag);
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cPj);
                anVar.cp("tid", bjVar.getTid());
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.gDZ >= 0) {
                    anVar.Z("tab_id", bVar.gDZ);
                }
                if (bjVar.cLr >= 0) {
                    anVar.Z("obj_floor", bjVar.cLr);
                }
                boolean z = (bjVar.aBe() == null || (bjVar.aBe().cIv() == null && bjVar.aBe().aRn() == null)) ? false : true;
                if (z && bjVar.aBe().cIv() != null && bjVar.aBe().cIv().aRf() != null && bjVar.aBe().cIv().aRf().size() > 0) {
                    anVar.Z("obj_name", bjVar.aBe().kcq ? 3 : 2);
                } else {
                    anVar.Z("obj_name", z ? 1 : 0);
                }
                boolean z2 = bjVar.getType() == bj.cNu;
                anVar.Z("thread_type", z2 ? 2 : 1);
                if (z2 && bjVar.azE() != null && !StringUtils.isNull(bjVar.azE().getName_show())) {
                    anVar.cp("obj_name", bjVar.azE().getName_show());
                }
                if (bjVar.aBz() || bjVar.aBB()) {
                    anVar.Z("obj_type", 14);
                } else if (bjVar.ays()) {
                    anVar.Z("obj_type", 13);
                }
                r.bsy().c(anVar);
                if (bjVar.aAE()) {
                    an anVar2 = new an("c12099");
                    anVar2.cp("fid", bVar.gDY);
                    anVar2.Z("obj_locate", a(bVar));
                    anVar2.cp("obj_source", bjVar.mRecomSource);
                    anVar2.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                    anVar2.cp("obj_param1", bjVar.mRecomAbTag);
                    anVar2.cp(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cPj);
                    anVar2.cp("tid", bjVar.getTid());
                    anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bsy().c(anVar2);
                }
                if (bjVar.azI()) {
                    an anVar3 = new an("c13169");
                    anVar3.cp("fid", bVar.gDY);
                    anVar3.cp("tid", bjVar.getTid());
                    anVar3.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bsy().c(anVar3);
                }
                if (bVar.gDZ == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.cp("fid", bVar.gDY);
                    anVar4.cp("tid", bjVar.getTid());
                    r.bsy().c(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gDW && bjVar != null && bjVar.getTid() != null) {
            r.bsy().kc(true);
            an anVar = new an("c11438");
            anVar.cp("fid", bVar.gDY);
            anVar.Z("obj_locate", a(bVar));
            anVar.cp("obj_source", bjVar.mRecomSource);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cp("obj_param1", bjVar.mRecomAbTag);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cPj);
            anVar.cp("tid", bjVar.getTid());
            if (bjVar.aBz() || bjVar.aBB()) {
                anVar.Z("obj_type", 14);
            } else if (bjVar.ays()) {
                anVar.Z("obj_type", 13);
            } else {
                anVar.Z("obj_type", i);
            }
            anVar.cp(TiebaInitialize.Params.OBJ_TO, ar(bjVar));
            if (bVar.gDZ >= 0) {
                anVar.Z("tab_id", bVar.gDZ);
            }
            if (bjVar.cLr >= 0) {
                anVar.Z("obj_floor", bjVar.cLr);
            }
            anVar.Z("thread_type", bjVar.getType() == bj.cNu ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bjVar.aAE()) {
                an anVar2 = new an("c12098");
                anVar2.cp("fid", bVar.gDY);
                anVar2.Z("obj_locate", a(bVar));
                anVar2.cp("obj_source", bjVar.mRecomSource);
                anVar2.cp(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar2.cp("obj_param1", bjVar.mRecomAbTag);
                anVar2.cp(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cPj);
                anVar2.cp("tid", bjVar.getTid());
                anVar2.Z("obj_type", i);
                anVar2.cp(TiebaInitialize.Params.OBJ_TO, ar(bjVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.gDZ == 501) {
                an anVar3 = new an("c13260");
                anVar3.cp("fid", bVar.gDY);
                anVar3.cp("tid", bjVar.getTid());
                r.bsy().c(anVar3);
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.gEb > 0) {
            return bVar.gEb;
        }
        int i = bVar.gDX;
        if (i == 8) {
            i = 9;
        }
        if (bVar.gDZ == 504) {
            return 11;
        }
        return i;
    }

    public void b(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gDW && bjVar != null && bjVar.getTid() != null && bjVar.azI()) {
            an anVar = new an("c13170");
            anVar.cp("fid", bVar.gDY);
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

    private String ar(bj bjVar) {
        return bjVar.cPm ? String.valueOf(bjVar.aAQ()) : String.valueOf(4);
    }
}
