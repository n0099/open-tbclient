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
    public static int jJo;
    private static c jJr;
    private a jJp;
    private SparseArray<HashSet<String>> jJq;
    private CustomMessageListener eLa = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.jJq != null) {
                c.this.jJq.clear();
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
                        aVar.jJu = false;
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
        public long jJt;
        public boolean jJu;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jJu = false;
        }
    }

    public c() {
        jJo = com.baidu.tbadk.core.sharedPref.b.brR().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.eLa);
    }

    public static c cKr() {
        if (jJr == null) {
            synchronized (t.class) {
                if (jJr == null) {
                    jJr = new c();
                }
            }
        }
        return jJr;
    }

    private boolean cKs() {
        if (this.jJp == null) {
            this.jJp = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jJp.jJu) {
            return true;
        }
        if (this.jJp.isRunning) {
            this.jJp.count++;
            if (currentTimeMillis - this.jJp.jJt < 120000) {
                if (this.jJp.count >= jJo) {
                    this.jJp.jJu = true;
                    a(this.jJp);
                    return true;
                }
            } else {
                this.jJp.isRunning = false;
                this.jJp.count = 0;
            }
        } else {
            this.jJp.isRunning = true;
            this.jJp.jJt = currentTimeMillis;
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
        if (cbVar != null && cbVar.bnx()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (cbVar.getTid() != null && !hashSet.contains(cbVar.getTid())) {
                hashSet.add(cbVar.getTid());
                t.csH().e(new ar("c11662").aq("obj_param1", 1).dR("post_id", cbVar.getTid()));
            }
        }
    }

    public void a(cb cbVar, boolean z) {
        if (cbVar != null) {
            t.csH().e(new ar("c12125").dR("tid", cbVar.getId()).aq("obj_locate", z ? 2 : 1).v("obj_id", cbVar.bol() != null ? cbVar.bol().live_id : -1L).aq("obj_type", 1));
        }
    }

    public void az(cb cbVar) {
        if (cbVar != null && cbVar.bpc()) {
            ar arVar = new ar("c11717");
            arVar.v("fid", cbVar.getFid());
            arVar.dR("obj_source", cbVar.mRecomSource);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
            arVar.dR("obj_param1", cbVar.eUj);
            arVar.aq("obj_locate", 1);
            arVar.dR("tid", cbVar.getTid());
            t.csH().e(arVar);
        }
    }

    public void a(b bVar, cb cbVar) {
        if (bVar != null && bVar.jJh && cbVar != null && cbVar.getTid() != null) {
            if (this.jJq == null) {
                this.jJq = new SparseArray<>();
            }
            if (this.jJq.get(bVar.jJk) == null) {
                this.jJq.put(bVar.jJk, new HashSet<>());
            }
            HashSet<String> hashSet = this.jJq.get(bVar.jJk);
            String tid = cbVar.getTid();
            if (bVar.jJl >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.jJl;
            }
            if (!hashSet.contains(tid) && !cKs()) {
                hashSet.add(tid);
                ar arVar = new ar("c11439");
                arVar.dR("fid", bVar.jJj);
                arVar.aq("obj_locate", a(bVar));
                arVar.dR("obj_source", cbVar.mRecomSource);
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
                arVar.dR("obj_param1", cbVar.mRecomAbTag);
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, cbVar.eUj);
                arVar.dR("tid", cbVar.getTid());
                arVar.dR(IntentConfig.NID, cbVar.bmq());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.v(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.jJk >= 0) {
                    arVar.aq("tab_id", bVar.jJk);
                }
                if (cbVar.ePT >= 0) {
                    arVar.aq("obj_floor", cbVar.ePT);
                }
                boolean z = (cbVar.bpx() == null || (cbVar.bpx().dNQ() == null && cbVar.bpx().bHL() == null)) ? false : true;
                if (z && cbVar.bpx().dNQ() != null && cbVar.bpx().dNQ().bHD() != null && cbVar.bpx().dNQ().bHD().size() > 0) {
                    arVar.aq("obj_name", cbVar.bpx().nzJ ? 3 : 2);
                } else {
                    arVar.aq("obj_name", z ? 1 : 0);
                }
                boolean z2 = cbVar.getType() == cb.eSv;
                arVar.aq("thread_type", z2 ? 2 : 1);
                if (z2 && cbVar.bnS() != null && !StringUtils.isNull(cbVar.bnS().getName_show())) {
                    arVar.dR("obj_name", cbVar.bnS().getName_show());
                }
                if (cbVar.bmA() || cbVar.bpQ()) {
                    arVar.aq("obj_type", 14);
                } else if (cbVar.bmz()) {
                    arVar.aq("obj_type", 13);
                }
                t.csH().e(arVar);
                if (cbVar.bmx()) {
                    ar arVar2 = new ar("c12099");
                    arVar2.dR("fid", bVar.jJj);
                    arVar2.aq("obj_locate", a(bVar));
                    arVar2.dR("obj_source", cbVar.mRecomSource);
                    arVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
                    arVar2.dR("obj_param1", cbVar.mRecomAbTag);
                    arVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, cbVar.eUj);
                    arVar2.dR("tid", cbVar.getTid());
                    arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    t.csH().e(arVar2);
                }
                if (bVar.jJk == 501) {
                    ar arVar3 = new ar("c13259");
                    arVar3.dR("fid", bVar.jJj);
                    arVar3.dR("tid", cbVar.getTid());
                    t.csH().e(arVar3);
                }
            }
        }
    }

    public void a(b bVar, cb cbVar, int i) {
        if (bVar != null && bVar.jJh && cbVar != null && cbVar.getTid() != null) {
            t.csH().pB(true);
            ar arVar = new ar("c11438");
            arVar.dR("fid", bVar.jJj);
            arVar.aq("obj_locate", a(bVar));
            arVar.dR("obj_source", cbVar.mRecomSource);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
            arVar.dR("obj_param1", cbVar.mRecomAbTag);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, cbVar.eUj);
            arVar.dR("tid", cbVar.getTid());
            arVar.dR(IntentConfig.NID, cbVar.bmq());
            if (cbVar.bmA() || cbVar.bpQ()) {
                arVar.aq("obj_type", 14);
            } else if (cbVar.bmz()) {
                arVar.aq("obj_type", 13);
            } else {
                arVar.aq("obj_type", i);
            }
            arVar.dR(TiebaInitialize.Params.OBJ_TO, aA(cbVar));
            if (bVar.jJk >= 0) {
                arVar.aq("tab_id", bVar.jJk);
            }
            if (cbVar.ePT >= 0) {
                arVar.aq("obj_floor", cbVar.ePT);
            }
            arVar.aq("thread_type", cbVar.getType() == cb.eSv ? 2 : 1);
            TiebaStatic.log(arVar);
            if (cbVar.bmx()) {
                ar arVar2 = new ar("c12098");
                arVar2.dR("fid", bVar.jJj);
                arVar2.aq("obj_locate", a(bVar));
                arVar2.dR("obj_source", cbVar.mRecomSource);
                arVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, cbVar.mRecomWeight);
                arVar2.dR("obj_param1", cbVar.mRecomAbTag);
                arVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, cbVar.eUj);
                arVar2.dR("tid", cbVar.getTid());
                arVar2.aq("obj_type", i);
                arVar2.dR(TiebaInitialize.Params.OBJ_TO, aA(cbVar));
                TiebaStatic.log(arVar2);
            }
            if (bVar.jJk == 501) {
                ar arVar3 = new ar("c13260");
                arVar3.dR("fid", bVar.jJj);
                arVar3.dR("tid", cbVar.getTid());
                t.csH().e(arVar3);
            }
            if (cbVar.bnS() != null && cbVar.bnS().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = cbVar.bnS().getAlaUserData();
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
        if (bVar.jJm > 0) {
            if (bVar.jJk == 1120 || bVar.jJk == 1121) {
                return 15;
            }
            if (bVar.jJn == 3) {
                return 13;
            }
            return bVar.jJm;
        }
        int i = bVar.jJi;
        if (i == 8) {
            i = 9;
        }
        if (bVar.jJk == 504) {
            i = 11;
        }
        if (bVar.jJk == 1120 || bVar.jJk == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            ar aq = new ar("c11440").dR("fid", frsViewData.getForum().getId()).aq("obj_locate", i).aq("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, aq);
            }
            TiebaStatic.log(aq);
        }
    }

    private String aA(cb cbVar) {
        return cbVar.eUm ? String.valueOf(cbVar.bpi()) : String.valueOf(4);
    }
}
