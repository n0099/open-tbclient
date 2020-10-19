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
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes22.dex */
public class c {
    public static int iNp;
    private static c iNs;
    private a iNq;
    private SparseArray<HashSet<String>> iNr;
    private CustomMessageListener eiR = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.iNr != null) {
                c.this.iNr.clear();
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
                        aVar.iNv = false;
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
        public long iNu;
        public boolean iNv;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.iNv = false;
        }
    }

    public c() {
        iNp = com.baidu.tbadk.core.sharedPref.b.blO().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.eiR);
    }

    public static c czh() {
        if (iNs == null) {
            synchronized (s.class) {
                if (iNs == null) {
                    iNs = new c();
                }
            }
        }
        return iNs;
    }

    private boolean czi() {
        if (this.iNq == null) {
            this.iNq = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.iNq.iNv) {
            return true;
        }
        if (this.iNq.isRunning) {
            this.iNq.count++;
            if (currentTimeMillis - this.iNq.iNu < 120000) {
                if (this.iNq.count >= iNp) {
                    this.iNq.iNv = true;
                    a(this.iNq);
                    return true;
                }
            } else {
                this.iNq.isRunning = false;
                this.iNq.count = 0;
            }
        } else {
            this.iNq.isRunning = true;
            this.iNq.iNu = currentTimeMillis;
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
        if (bwVar != null && bwVar.bhM()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bwVar.getTid() != null && !hashSet.contains(bwVar.getTid())) {
                hashSet.add(bwVar.getTid());
                s.ciJ().e(new aq("c11662").aj("obj_param1", 1).dK("post_id", bwVar.getTid()));
            }
        }
    }

    public void a(bw bwVar, boolean z) {
        if (bwVar != null) {
            s.ciJ().e(new aq("c12125").dK("tid", bwVar.getId()).aj("obj_locate", z ? 2 : 1).u("obj_id", bwVar.biB() != null ? bwVar.biB().live_id : -1L).aj("obj_type", 1));
        }
    }

    public void aw(bw bwVar) {
        if (bwVar != null && bwVar.bjq()) {
            aq aqVar = new aq("c11717");
            aqVar.u("fid", bwVar.getFid());
            aqVar.dK("obj_source", bwVar.mRecomSource);
            aqVar.dK(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dK("obj_param1", bwVar.erE);
            aqVar.aj("obj_locate", 1);
            aqVar.dK("tid", bwVar.getTid());
            s.ciJ().e(aqVar);
        }
    }

    public void a(b bVar, bw bwVar) {
        if (bVar != null && bVar.iNi && bwVar != null && bwVar.getTid() != null) {
            if (this.iNr == null) {
                this.iNr = new SparseArray<>();
            }
            if (this.iNr.get(bVar.iNl) == null) {
                this.iNr.put(bVar.iNl, new HashSet<>());
            }
            HashSet<String> hashSet = this.iNr.get(bVar.iNl);
            String tid = bwVar.getTid();
            if (bVar.iNm >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.iNm;
            }
            if (!hashSet.contains(tid) && !czi()) {
                hashSet.add(tid);
                aq aqVar = new aq("c11439");
                aqVar.dK("fid", bVar.iNk);
                aqVar.aj("obj_locate", a(bVar));
                aqVar.dK("obj_source", bwVar.mRecomSource);
                aqVar.dK(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar.dK("obj_param1", bwVar.mRecomAbTag);
                aqVar.dK(TiebaInitialize.Params.OBJ_PARAM3, bwVar.erE);
                aqVar.dK("tid", bwVar.getTid());
                aqVar.dK("nid", bwVar.getNid());
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.u(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.iNl >= 0) {
                    aqVar.aj("tab_id", bVar.iNl);
                }
                if (bwVar.ens >= 0) {
                    aqVar.aj("obj_floor", bwVar.ens);
                }
                boolean z = (bwVar.bjK() == null || (bwVar.bjK().dEr() == null && bwVar.bjK().bBy() == null)) ? false : true;
                if (z && bwVar.bjK().dEr() != null && bwVar.bjK().dEr().bBq() != null && bwVar.bjK().dEr().bBq().size() > 0) {
                    aqVar.aj("obj_name", bwVar.bjK().mEN ? 3 : 2);
                } else {
                    aqVar.aj("obj_name", z ? 1 : 0);
                }
                boolean z2 = bwVar.getType() == bw.epQ;
                aqVar.aj("thread_type", z2 ? 2 : 1);
                if (z2 && bwVar.bih() != null && !StringUtils.isNull(bwVar.bih().getName_show())) {
                    aqVar.dK("obj_name", bwVar.bih().getName_show());
                }
                if (bwVar.bgQ() || bwVar.bkd()) {
                    aqVar.aj("obj_type", 14);
                } else if (bwVar.bgP()) {
                    aqVar.aj("obj_type", 13);
                }
                s.ciJ().e(aqVar);
                if (bwVar.bgN()) {
                    aq aqVar2 = new aq("c12099");
                    aqVar2.dK("fid", bVar.iNk);
                    aqVar2.aj("obj_locate", a(bVar));
                    aqVar2.dK("obj_source", bwVar.mRecomSource);
                    aqVar2.dK(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                    aqVar2.dK("obj_param1", bwVar.mRecomAbTag);
                    aqVar2.dK(TiebaInitialize.Params.OBJ_PARAM3, bwVar.erE);
                    aqVar2.dK("tid", bwVar.getTid());
                    aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    s.ciJ().e(aqVar2);
                }
                if (bVar.iNl == 501) {
                    aq aqVar3 = new aq("c13259");
                    aqVar3.dK("fid", bVar.iNk);
                    aqVar3.dK("tid", bwVar.getTid());
                    s.ciJ().e(aqVar3);
                }
            }
        }
    }

    public void a(b bVar, bw bwVar, int i) {
        if (bVar != null && bVar.iNi && bwVar != null && bwVar.getTid() != null) {
            s.ciJ().nX(true);
            aq aqVar = new aq("c11438");
            aqVar.dK("fid", bVar.iNk);
            aqVar.aj("obj_locate", a(bVar));
            aqVar.dK("obj_source", bwVar.mRecomSource);
            aqVar.dK(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dK("obj_param1", bwVar.mRecomAbTag);
            aqVar.dK(TiebaInitialize.Params.OBJ_PARAM3, bwVar.erE);
            aqVar.dK("tid", bwVar.getTid());
            aqVar.dK("nid", bwVar.getNid());
            if (bwVar.bgQ() || bwVar.bkd()) {
                aqVar.aj("obj_type", 14);
            } else if (bwVar.bgP()) {
                aqVar.aj("obj_type", 13);
            } else {
                aqVar.aj("obj_type", i);
            }
            aqVar.dK(TiebaInitialize.Params.OBJ_TO, ax(bwVar));
            if (bVar.iNl >= 0) {
                aqVar.aj("tab_id", bVar.iNl);
            }
            if (bwVar.ens >= 0) {
                aqVar.aj("obj_floor", bwVar.ens);
            }
            aqVar.aj("thread_type", bwVar.getType() == bw.epQ ? 2 : 1);
            TiebaStatic.log(aqVar);
            if (bwVar.bgN()) {
                aq aqVar2 = new aq("c12098");
                aqVar2.dK("fid", bVar.iNk);
                aqVar2.aj("obj_locate", a(bVar));
                aqVar2.dK("obj_source", bwVar.mRecomSource);
                aqVar2.dK(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar2.dK("obj_param1", bwVar.mRecomAbTag);
                aqVar2.dK(TiebaInitialize.Params.OBJ_PARAM3, bwVar.erE);
                aqVar2.dK("tid", bwVar.getTid());
                aqVar2.aj("obj_type", i);
                aqVar2.dK(TiebaInitialize.Params.OBJ_TO, ax(bwVar));
                TiebaStatic.log(aqVar2);
            }
            if (bVar.iNl == 501) {
                aq aqVar3 = new aq("c13260");
                aqVar3.dK("fid", bVar.iNk);
                aqVar3.dK("tid", bwVar.getTid());
                s.ciJ().e(aqVar3);
            }
            if (bwVar.bih() != null && bwVar.bih().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bih().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    aq aqVar4 = new aq("c11850");
                    aqVar4.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.iNn > 0) {
            if (bVar.iNl == 1120 || bVar.iNl == 1121) {
                return 15;
            }
            if (bVar.iNo == 3) {
                return 13;
            }
            return bVar.iNn;
        }
        int i = bVar.iNj;
        if (i == 8) {
            i = 9;
        }
        if (bVar.iNl == 504) {
            i = 11;
        }
        if (bVar.iNl == 1120 || bVar.iNl == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            aq aj = new aq("c11440").dK("fid", frsViewData.getForum().getId()).aj("obj_locate", i).aj("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, aj);
            }
            TiebaStatic.log(aj);
        }
    }

    private String ax(bw bwVar) {
        return bwVar.erH ? String.valueOf(bwVar.bjv()) : String.valueOf(4);
    }
}
