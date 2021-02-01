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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class c {
    public static int jHr;
    private static c jHu;
    private a jHs;
    private SparseArray<HashSet<String>> jHt;
    private CustomMessageListener eJz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.jHt != null) {
                c.this.jHt.clear();
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
                        aVar.jHx = false;
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
        public long jHw;
        public boolean jHx;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jHx = false;
        }
    }

    public c() {
        jHr = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.eJz);
    }

    public static c cKe() {
        if (jHu == null) {
            synchronized (t.class) {
                if (jHu == null) {
                    jHu = new c();
                }
            }
        }
        return jHu;
    }

    private boolean cKf() {
        if (this.jHs == null) {
            this.jHs = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jHs.jHx) {
            return true;
        }
        if (this.jHs.isRunning) {
            this.jHs.count++;
            if (currentTimeMillis - this.jHs.jHw < 120000) {
                if (this.jHs.count >= jHr) {
                    this.jHs.jHx = true;
                    a(this.jHs);
                    return true;
                }
            } else {
                this.jHs.isRunning = false;
                this.jHs.count = 0;
            }
        } else {
            this.jHs.isRunning = true;
            this.jHs.jHw = currentTimeMillis;
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

    public void a(cb cbVar, HashSet<String> hashSet) {
        if (cbVar != null && cbVar.bnv()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (cbVar.getTid() != null && !hashSet.contains(cbVar.getTid())) {
                hashSet.add(cbVar.getTid());
                t.csu().e(new ar("c11662").ap("obj_param1", 1).dR("post_id", cbVar.getTid()));
            }
        }
    }

    public void a(cb cbVar, boolean z) {
        if (cbVar != null) {
            t.csu().e(new ar("c12125").dR("tid", cbVar.getId()).ap("obj_locate", z ? 2 : 1).v("obj_id", cbVar.boj() != null ? cbVar.boj().live_id : -1L).ap("obj_type", 1));
        }
    }

    public void az(cb cbVar) {
        if (cbVar != null && cbVar.bpa()) {
            ar arVar = new ar("c11717");
            arVar.v("fid", cbVar.getFid());
            arVar.dR("obj_source", cbVar.mRecomSource);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
            arVar.dR("obj_param1", cbVar.eSI);
            arVar.ap("obj_locate", 1);
            arVar.dR("tid", cbVar.getTid());
            t.csu().e(arVar);
        }
    }

    public void a(b bVar, cb cbVar) {
        if (bVar != null && bVar.jHk && cbVar != null && cbVar.getTid() != null) {
            if (this.jHt == null) {
                this.jHt = new SparseArray<>();
            }
            if (this.jHt.get(bVar.jHn) == null) {
                this.jHt.put(bVar.jHn, new HashSet<>());
            }
            HashSet<String> hashSet = this.jHt.get(bVar.jHn);
            String tid = cbVar.getTid();
            if (bVar.jHo >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.jHo;
            }
            if (!hashSet.contains(tid) && !cKf()) {
                hashSet.add(tid);
                ar arVar = new ar("c11439");
                arVar.dR("fid", bVar.jHm);
                arVar.ap("obj_locate", a(bVar));
                arVar.dR("obj_source", cbVar.mRecomSource);
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
                arVar.dR("obj_param1", cbVar.mRecomAbTag);
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, cbVar.eSI);
                arVar.dR("tid", cbVar.getTid());
                arVar.dR(IntentConfig.NID, cbVar.bmo());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.v(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.jHn >= 0) {
                    arVar.ap("tab_id", bVar.jHn);
                }
                if (cbVar.eOs >= 0) {
                    arVar.ap("obj_floor", cbVar.eOs);
                }
                boolean z = (cbVar.bpv() == null || (cbVar.bpv().dNz() == null && cbVar.bpv().bHH() == null)) ? false : true;
                if (z && cbVar.bpv().dNz() != null && cbVar.bpv().dNz().bHz() != null && cbVar.bpv().dNz().bHz().size() > 0) {
                    arVar.ap("obj_name", cbVar.bpv().nxe ? 3 : 2);
                } else {
                    arVar.ap("obj_name", z ? 1 : 0);
                }
                boolean z2 = cbVar.getType() == cb.eQU;
                arVar.ap("thread_type", z2 ? 2 : 1);
                if (z2 && cbVar.bnQ() != null && !StringUtils.isNull(cbVar.bnQ().getName_show())) {
                    arVar.dR("obj_name", cbVar.bnQ().getName_show());
                }
                if (cbVar.bmy() || cbVar.bpO()) {
                    arVar.ap("obj_type", 14);
                } else if (cbVar.bmx()) {
                    arVar.ap("obj_type", 13);
                }
                t.csu().e(arVar);
                if (cbVar.bmv()) {
                    ar arVar2 = new ar("c12099");
                    arVar2.dR("fid", bVar.jHm);
                    arVar2.ap("obj_locate", a(bVar));
                    arVar2.dR("obj_source", cbVar.mRecomSource);
                    arVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
                    arVar2.dR("obj_param1", cbVar.mRecomAbTag);
                    arVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, cbVar.eSI);
                    arVar2.dR("tid", cbVar.getTid());
                    arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    t.csu().e(arVar2);
                }
                if (bVar.jHn == 501) {
                    ar arVar3 = new ar("c13259");
                    arVar3.dR("fid", bVar.jHm);
                    arVar3.dR("tid", cbVar.getTid());
                    t.csu().e(arVar3);
                }
            }
        }
    }

    public void a(b bVar, cb cbVar, int i) {
        if (bVar != null && bVar.jHk && cbVar != null && cbVar.getTid() != null) {
            t.csu().pB(true);
            ar arVar = new ar("c11438");
            arVar.dR("fid", bVar.jHm);
            arVar.ap("obj_locate", a(bVar));
            arVar.dR("obj_source", cbVar.mRecomSource);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
            arVar.dR("obj_param1", cbVar.mRecomAbTag);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, cbVar.eSI);
            arVar.dR("tid", cbVar.getTid());
            arVar.dR(IntentConfig.NID, cbVar.bmo());
            if (cbVar.bmy() || cbVar.bpO()) {
                arVar.ap("obj_type", 14);
            } else if (cbVar.bmx()) {
                arVar.ap("obj_type", 13);
            } else {
                arVar.ap("obj_type", i);
            }
            arVar.dR(TiebaInitialize.Params.OBJ_TO, aA(cbVar));
            if (bVar.jHn >= 0) {
                arVar.ap("tab_id", bVar.jHn);
            }
            if (cbVar.eOs >= 0) {
                arVar.ap("obj_floor", cbVar.eOs);
            }
            arVar.ap("thread_type", cbVar.getType() == cb.eQU ? 2 : 1);
            TiebaStatic.log(arVar);
            if (cbVar.bmv()) {
                ar arVar2 = new ar("c12098");
                arVar2.dR("fid", bVar.jHm);
                arVar2.ap("obj_locate", a(bVar));
                arVar2.dR("obj_source", cbVar.mRecomSource);
                arVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
                arVar2.dR("obj_param1", cbVar.mRecomAbTag);
                arVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, cbVar.eSI);
                arVar2.dR("tid", cbVar.getTid());
                arVar2.ap("obj_type", i);
                arVar2.dR(TiebaInitialize.Params.OBJ_TO, aA(cbVar));
                TiebaStatic.log(arVar2);
            }
            if (bVar.jHn == 501) {
                ar arVar3 = new ar("c13260");
                arVar3.dR("fid", bVar.jHm);
                arVar3.dR("tid", cbVar.getTid());
                t.csu().e(arVar3);
            }
            if (cbVar.bnQ() != null && cbVar.bnQ().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = cbVar.bnQ().getAlaUserData();
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
        if (bVar.jHp > 0) {
            if (bVar.jHn == 1120 || bVar.jHn == 1121) {
                return 15;
            }
            if (bVar.jHq == 3) {
                return 13;
            }
            return bVar.jHp;
        }
        int i = bVar.jHl;
        if (i == 8) {
            i = 9;
        }
        if (bVar.jHn == 504) {
            i = 11;
        }
        if (bVar.jHn == 1120 || bVar.jHn == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            ar ap = new ar("c11440").dR("fid", frsViewData.getForum().getId()).ap("obj_locate", i).ap("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, ap);
            }
            TiebaStatic.log(ap);
        }
    }

    private String aA(cb cbVar) {
        return cbVar.eSL ? String.valueOf(cbVar.bpg()) : String.valueOf(4);
    }
}
