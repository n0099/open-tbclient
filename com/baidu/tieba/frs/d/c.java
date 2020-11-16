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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes21.dex */
public class c {
    public static int jgt;
    private static c jgw;
    private a jgu;
    private SparseArray<HashSet<String>> jgv;
    private CustomMessageListener evz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.jgv != null) {
                c.this.jgv.clear();
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
                        aVar.jgz = false;
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
    /* loaded from: classes21.dex */
    public class a {
        public int count;
        public boolean isRunning;
        public long jgy;
        public boolean jgz;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jgz = false;
        }
    }

    public c() {
        jgt = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.evz);
    }

    public static c cEu() {
        if (jgw == null) {
            synchronized (t.class) {
                if (jgw == null) {
                    jgw = new c();
                }
            }
        }
        return jgw;
    }

    private boolean cEv() {
        if (this.jgu == null) {
            this.jgu = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jgu.jgz) {
            return true;
        }
        if (this.jgu.isRunning) {
            this.jgu.count++;
            if (currentTimeMillis - this.jgu.jgy < 120000) {
                if (this.jgu.count >= jgt) {
                    this.jgu.jgz = true;
                    a(this.jgu);
                    return true;
                }
            } else {
                this.jgu.isRunning = false;
                this.jgu.count = 0;
            }
        } else {
            this.jgu.isRunning = true;
            this.jgu.jgy = currentTimeMillis;
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

    public void a(bx bxVar, HashSet<String> hashSet) {
        if (bxVar != null && bxVar.blh()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bxVar.getTid() != null && !hashSet.contains(bxVar.getTid())) {
                hashSet.add(bxVar.getTid());
                t.cnT().e(new ar("c11662").ak("obj_param1", 1).dR("post_id", bxVar.getTid()));
            }
        }
    }

    public void a(bx bxVar, boolean z) {
        if (bxVar != null) {
            t.cnT().e(new ar("c12125").dR("tid", bxVar.getId()).ak("obj_locate", z ? 2 : 1).w("obj_id", bxVar.blW() != null ? bxVar.blW().live_id : -1L).ak("obj_type", 1));
        }
    }

    public void ay(bx bxVar) {
        if (bxVar != null && bxVar.bmN()) {
            ar arVar = new ar("c11717");
            arVar.w("fid", bxVar.getFid());
            arVar.dR("obj_source", bxVar.mRecomSource);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, bxVar.mRecomWeight);
            arVar.dR("obj_param1", bxVar.eEl);
            arVar.ak("obj_locate", 1);
            arVar.dR("tid", bxVar.getTid());
            t.cnT().e(arVar);
        }
    }

    public void a(b bVar, bx bxVar) {
        if (bVar != null && bVar.jgm && bxVar != null && bxVar.getTid() != null) {
            if (this.jgv == null) {
                this.jgv = new SparseArray<>();
            }
            if (this.jgv.get(bVar.jgp) == null) {
                this.jgv.put(bVar.jgp, new HashSet<>());
            }
            HashSet<String> hashSet = this.jgv.get(bVar.jgp);
            String tid = bxVar.getTid();
            if (bVar.jgq >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.jgq;
            }
            if (!hashSet.contains(tid) && !cEv()) {
                hashSet.add(tid);
                ar arVar = new ar("c11439");
                arVar.dR("fid", bVar.jgo);
                arVar.ak("obj_locate", a(bVar));
                arVar.dR("obj_source", bxVar.mRecomSource);
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, bxVar.mRecomWeight);
                arVar.dR("obj_param1", bxVar.mRecomAbTag);
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, bxVar.eEl);
                arVar.dR("tid", bxVar.getTid());
                arVar.dR("nid", bxVar.getNid());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.jgp >= 0) {
                    arVar.ak("tab_id", bVar.jgp);
                }
                if (bxVar.eAb >= 0) {
                    arVar.ak("obj_floor", bxVar.eAb);
                }
                boolean z = (bxVar.bnh() == null || (bxVar.bnh().dJS() == null && bxVar.bnh().bFj() == null)) ? false : true;
                if (z && bxVar.bnh().dJS() != null && bxVar.bnh().dJS().bFb() != null && bxVar.bnh().dJS().bFb().size() > 0) {
                    arVar.ak("obj_name", bxVar.bnh().mYp ? 3 : 2);
                } else {
                    arVar.ak("obj_name", z ? 1 : 0);
                }
                boolean z2 = bxVar.getType() == bx.eCy;
                arVar.ak("thread_type", z2 ? 2 : 1);
                if (z2 && bxVar.blC() != null && !StringUtils.isNull(bxVar.blC().getName_show())) {
                    arVar.dR("obj_name", bxVar.blC().getName_show());
                }
                if (bxVar.bkl() || bxVar.bnA()) {
                    arVar.ak("obj_type", 14);
                } else if (bxVar.bkk()) {
                    arVar.ak("obj_type", 13);
                }
                t.cnT().e(arVar);
                if (bxVar.bki()) {
                    ar arVar2 = new ar("c12099");
                    arVar2.dR("fid", bVar.jgo);
                    arVar2.ak("obj_locate", a(bVar));
                    arVar2.dR("obj_source", bxVar.mRecomSource);
                    arVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, bxVar.mRecomWeight);
                    arVar2.dR("obj_param1", bxVar.mRecomAbTag);
                    arVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, bxVar.eEl);
                    arVar2.dR("tid", bxVar.getTid());
                    arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    t.cnT().e(arVar2);
                }
                if (bVar.jgp == 501) {
                    ar arVar3 = new ar("c13259");
                    arVar3.dR("fid", bVar.jgo);
                    arVar3.dR("tid", bxVar.getTid());
                    t.cnT().e(arVar3);
                }
            }
        }
    }

    public void a(b bVar, bx bxVar, int i) {
        if (bVar != null && bVar.jgm && bxVar != null && bxVar.getTid() != null) {
            t.cnT().oB(true);
            ar arVar = new ar("c11438");
            arVar.dR("fid", bVar.jgo);
            arVar.ak("obj_locate", a(bVar));
            arVar.dR("obj_source", bxVar.mRecomSource);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, bxVar.mRecomWeight);
            arVar.dR("obj_param1", bxVar.mRecomAbTag);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, bxVar.eEl);
            arVar.dR("tid", bxVar.getTid());
            arVar.dR("nid", bxVar.getNid());
            if (bxVar.bkl() || bxVar.bnA()) {
                arVar.ak("obj_type", 14);
            } else if (bxVar.bkk()) {
                arVar.ak("obj_type", 13);
            } else {
                arVar.ak("obj_type", i);
            }
            arVar.dR(TiebaInitialize.Params.OBJ_TO, az(bxVar));
            if (bVar.jgp >= 0) {
                arVar.ak("tab_id", bVar.jgp);
            }
            if (bxVar.eAb >= 0) {
                arVar.ak("obj_floor", bxVar.eAb);
            }
            arVar.ak("thread_type", bxVar.getType() == bx.eCy ? 2 : 1);
            TiebaStatic.log(arVar);
            if (bxVar.bki()) {
                ar arVar2 = new ar("c12098");
                arVar2.dR("fid", bVar.jgo);
                arVar2.ak("obj_locate", a(bVar));
                arVar2.dR("obj_source", bxVar.mRecomSource);
                arVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, bxVar.mRecomWeight);
                arVar2.dR("obj_param1", bxVar.mRecomAbTag);
                arVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, bxVar.eEl);
                arVar2.dR("tid", bxVar.getTid());
                arVar2.ak("obj_type", i);
                arVar2.dR(TiebaInitialize.Params.OBJ_TO, az(bxVar));
                TiebaStatic.log(arVar2);
            }
            if (bVar.jgp == 501) {
                ar arVar3 = new ar("c13260");
                arVar3.dR("fid", bVar.jgo);
                arVar3.dR("tid", bxVar.getTid());
                t.cnT().e(arVar3);
            }
            if (bxVar.blC() != null && bxVar.blC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bxVar.blC().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    ar arVar4 = new ar("c11850");
                    arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.jgr > 0) {
            if (bVar.jgp == 1120 || bVar.jgp == 1121) {
                return 15;
            }
            if (bVar.jgs == 3) {
                return 13;
            }
            return bVar.jgr;
        }
        int i = bVar.jgn;
        if (i == 8) {
            i = 9;
        }
        if (bVar.jgp == 504) {
            i = 11;
        }
        if (bVar.jgp == 1120 || bVar.jgp == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            ar ak = new ar("c11440").dR("fid", frsViewData.getForum().getId()).ak("obj_locate", i).ak("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, ak);
            }
            TiebaStatic.log(ak);
        }
    }

    private String az(bx bxVar) {
        return bxVar.eEo ? String.valueOf(bxVar.bmS()) : String.valueOf(4);
    }
}
