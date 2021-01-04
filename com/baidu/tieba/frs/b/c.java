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
    public static int jGt;
    private static c jGw;
    private a jGu;
    private SparseArray<HashSet<String>> jGv;
    private CustomMessageListener eMe = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.jGv != null) {
                c.this.jGv.clear();
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
                        aVar.jGz = false;
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
        public long jGy;
        public boolean jGz;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jGz = false;
        }
    }

    public c() {
        jGt = com.baidu.tbadk.core.sharedPref.b.bvq().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.eMe);
    }

    public static c cMI() {
        if (jGw == null) {
            synchronized (s.class) {
                if (jGw == null) {
                    jGw = new c();
                }
            }
        }
        return jGw;
    }

    private boolean cMJ() {
        if (this.jGu == null) {
            this.jGu = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jGu.jGz) {
            return true;
        }
        if (this.jGu.isRunning) {
            this.jGu.count++;
            if (currentTimeMillis - this.jGu.jGy < 120000) {
                if (this.jGu.count >= jGt) {
                    this.jGu.jGz = true;
                    a(this.jGu);
                    return true;
                }
            } else {
                this.jGu.isRunning = false;
                this.jGu.count = 0;
            }
        } else {
            this.jGu.isRunning = true;
            this.jGu.jGy = currentTimeMillis;
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
        if (bzVar != null && bzVar.bqV()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bzVar.getTid() != null && !hashSet.contains(bzVar.getTid())) {
                hashSet.add(bzVar.getTid());
                s.cva().e(new aq("c11662").an("obj_param1", 1).dX("post_id", bzVar.getTid()));
            }
        }
    }

    public void a(bz bzVar, boolean z) {
        if (bzVar != null) {
            s.cva().e(new aq("c12125").dX("tid", bzVar.getId()).an("obj_locate", z ? 2 : 1).w("obj_id", bzVar.brJ() != null ? bzVar.brJ().live_id : -1L).an("obj_type", 1));
        }
    }

    public void ay(bz bzVar) {
        if (bzVar != null && bzVar.bsB()) {
            aq aqVar = new aq("c11717");
            aqVar.w("fid", bzVar.getFid());
            aqVar.dX("obj_source", bzVar.mRecomSource);
            aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
            aqVar.dX("obj_param1", bzVar.eVh);
            aqVar.an("obj_locate", 1);
            aqVar.dX("tid", bzVar.getTid());
            s.cva().e(aqVar);
        }
    }

    public void a(b bVar, bz bzVar) {
        if (bVar != null && bVar.jGm && bzVar != null && bzVar.getTid() != null) {
            if (this.jGv == null) {
                this.jGv = new SparseArray<>();
            }
            if (this.jGv.get(bVar.jGp) == null) {
                this.jGv.put(bVar.jGp, new HashSet<>());
            }
            HashSet<String> hashSet = this.jGv.get(bVar.jGp);
            String tid = bzVar.getTid();
            if (bVar.jGq >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.jGq;
            }
            if (!hashSet.contains(tid) && !cMJ()) {
                hashSet.add(tid);
                aq aqVar = new aq("c11439");
                aqVar.dX("fid", bVar.jGo);
                aqVar.an("obj_locate", a(bVar));
                aqVar.dX("obj_source", bzVar.mRecomSource);
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
                aqVar.dX("obj_param1", bzVar.mRecomAbTag);
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM3, bzVar.eVh);
                aqVar.dX("tid", bzVar.getTid());
                aqVar.dX(IntentConfig.NID, bzVar.bpO());
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.jGp >= 0) {
                    aqVar.an("tab_id", bVar.jGp);
                }
                if (bzVar.eQR >= 0) {
                    aqVar.an("obj_floor", bzVar.eQR);
                }
                boolean z = (bzVar.bsW() == null || (bzVar.bsW().dPf() == null && bzVar.bsW().bLe() == null)) ? false : true;
                if (z && bzVar.bsW().dPf() != null && bzVar.bsW().dPf().bKW() != null && bzVar.bsW().dPf().bKW().size() > 0) {
                    aqVar.an("obj_name", bzVar.bsW().nsb ? 3 : 2);
                } else {
                    aqVar.an("obj_name", z ? 1 : 0);
                }
                boolean z2 = bzVar.getType() == bz.eTt;
                aqVar.an("thread_type", z2 ? 2 : 1);
                if (z2 && bzVar.brq() != null && !StringUtils.isNull(bzVar.brq().getName_show())) {
                    aqVar.dX("obj_name", bzVar.brq().getName_show());
                }
                if (bzVar.bpY() || bzVar.btp()) {
                    aqVar.an("obj_type", 14);
                } else if (bzVar.bpX()) {
                    aqVar.an("obj_type", 13);
                }
                s.cva().e(aqVar);
                if (bzVar.bpV()) {
                    aq aqVar2 = new aq("c12099");
                    aqVar2.dX("fid", bVar.jGo);
                    aqVar2.an("obj_locate", a(bVar));
                    aqVar2.dX("obj_source", bzVar.mRecomSource);
                    aqVar2.dX(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
                    aqVar2.dX("obj_param1", bzVar.mRecomAbTag);
                    aqVar2.dX(TiebaInitialize.Params.OBJ_PARAM3, bzVar.eVh);
                    aqVar2.dX("tid", bzVar.getTid());
                    aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    s.cva().e(aqVar2);
                }
                if (bVar.jGp == 501) {
                    aq aqVar3 = new aq("c13259");
                    aqVar3.dX("fid", bVar.jGo);
                    aqVar3.dX("tid", bzVar.getTid());
                    s.cva().e(aqVar3);
                }
            }
        }
    }

    public void a(b bVar, bz bzVar, int i) {
        if (bVar != null && bVar.jGm && bzVar != null && bzVar.getTid() != null) {
            s.cva().pv(true);
            aq aqVar = new aq("c11438");
            aqVar.dX("fid", bVar.jGo);
            aqVar.an("obj_locate", a(bVar));
            aqVar.dX("obj_source", bzVar.mRecomSource);
            aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
            aqVar.dX("obj_param1", bzVar.mRecomAbTag);
            aqVar.dX(TiebaInitialize.Params.OBJ_PARAM3, bzVar.eVh);
            aqVar.dX("tid", bzVar.getTid());
            aqVar.dX(IntentConfig.NID, bzVar.bpO());
            if (bzVar.bpY() || bzVar.btp()) {
                aqVar.an("obj_type", 14);
            } else if (bzVar.bpX()) {
                aqVar.an("obj_type", 13);
            } else {
                aqVar.an("obj_type", i);
            }
            aqVar.dX(TiebaInitialize.Params.OBJ_TO, az(bzVar));
            if (bVar.jGp >= 0) {
                aqVar.an("tab_id", bVar.jGp);
            }
            if (bzVar.eQR >= 0) {
                aqVar.an("obj_floor", bzVar.eQR);
            }
            aqVar.an("thread_type", bzVar.getType() == bz.eTt ? 2 : 1);
            TiebaStatic.log(aqVar);
            if (bzVar.bpV()) {
                aq aqVar2 = new aq("c12098");
                aqVar2.dX("fid", bVar.jGo);
                aqVar2.an("obj_locate", a(bVar));
                aqVar2.dX("obj_source", bzVar.mRecomSource);
                aqVar2.dX(TiebaInitialize.Params.OBJ_PARAM2, bzVar.mRecomWeight);
                aqVar2.dX("obj_param1", bzVar.mRecomAbTag);
                aqVar2.dX(TiebaInitialize.Params.OBJ_PARAM3, bzVar.eVh);
                aqVar2.dX("tid", bzVar.getTid());
                aqVar2.an("obj_type", i);
                aqVar2.dX(TiebaInitialize.Params.OBJ_TO, az(bzVar));
                TiebaStatic.log(aqVar2);
            }
            if (bVar.jGp == 501) {
                aq aqVar3 = new aq("c13260");
                aqVar3.dX("fid", bVar.jGo);
                aqVar3.dX("tid", bzVar.getTid());
                s.cva().e(aqVar3);
            }
            if (bzVar.brq() != null && bzVar.brq().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bzVar.brq().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    aq aqVar4 = new aq("c11850");
                    aqVar4.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.jGr > 0) {
            if (bVar.jGp == 1120 || bVar.jGp == 1121) {
                return 15;
            }
            if (bVar.jGs == 3) {
                return 13;
            }
            return bVar.jGr;
        }
        int i = bVar.jGn;
        if (i == 8) {
            i = 9;
        }
        if (bVar.jGp == 504) {
            i = 11;
        }
        if (bVar.jGp == 1120 || bVar.jGp == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            aq an = new aq("c11440").dX("fid", frsViewData.getForum().getId()).an("obj_locate", i).an("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, an);
            }
            TiebaStatic.log(an);
        }
    }

    private String az(bz bzVar) {
        return bzVar.eVk ? String.valueOf(bzVar.bsH()) : String.valueOf(4);
    }
}
