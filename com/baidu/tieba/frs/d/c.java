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
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes22.dex */
public class c {
    public static int jfI;
    private static c jfL;
    private a jfJ;
    private SparseArray<HashSet<String>> jfK;
    private CustomMessageListener exi = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.jfK != null) {
                c.this.jfK.clear();
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
                        aVar.jfO = false;
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
        public boolean isRunning;
        public long jfN;
        public boolean jfO;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jfO = false;
        }
    }

    public c() {
        jfI = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.exi);
    }

    public static c cEP() {
        if (jfL == null) {
            synchronized (t.class) {
                if (jfL == null) {
                    jfL = new c();
                }
            }
        }
        return jfL;
    }

    private boolean cEQ() {
        if (this.jfJ == null) {
            this.jfJ = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jfJ.jfO) {
            return true;
        }
        if (this.jfJ.isRunning) {
            this.jfJ.count++;
            if (currentTimeMillis - this.jfJ.jfN < 120000) {
                if (this.jfJ.count >= jfI) {
                    this.jfJ.jfO = true;
                    a(this.jfJ);
                    return true;
                }
            } else {
                this.jfJ.isRunning = false;
                this.jfJ.count = 0;
            }
        } else {
            this.jfJ.isRunning = true;
            this.jfJ.jfN = currentTimeMillis;
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
        if (bwVar != null && bwVar.bmf()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bwVar.getTid() != null && !hashSet.contains(bwVar.getTid())) {
                hashSet.add(bwVar.getTid());
                t.cor().e(new aq("c11662").al("obj_param1", 1).dR("post_id", bwVar.getTid()));
            }
        }
    }

    public void a(bw bwVar, boolean z) {
        if (bwVar != null) {
            t.cor().e(new aq("c12125").dR("tid", bwVar.getId()).al("obj_locate", z ? 2 : 1).w("obj_id", bwVar.bmU() != null ? bwVar.bmU().live_id : -1L).al("obj_type", 1));
        }
    }

    public void aw(bw bwVar) {
        if (bwVar != null && bwVar.bnJ()) {
            aq aqVar = new aq("c11717");
            aqVar.w("fid", bwVar.getFid());
            aqVar.dR("obj_source", bwVar.mRecomSource);
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dR("obj_param1", bwVar.eFT);
            aqVar.al("obj_locate", 1);
            aqVar.dR("tid", bwVar.getTid());
            t.cor().e(aqVar);
        }
    }

    public void a(b bVar, bw bwVar) {
        if (bVar != null && bVar.jfB && bwVar != null && bwVar.getTid() != null) {
            if (this.jfK == null) {
                this.jfK = new SparseArray<>();
            }
            if (this.jfK.get(bVar.jfE) == null) {
                this.jfK.put(bVar.jfE, new HashSet<>());
            }
            HashSet<String> hashSet = this.jfK.get(bVar.jfE);
            String tid = bwVar.getTid();
            if (bVar.jfF >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.jfF;
            }
            if (!hashSet.contains(tid) && !cEQ()) {
                hashSet.add(tid);
                aq aqVar = new aq("c11439");
                aqVar.dR("fid", bVar.jfD);
                aqVar.al("obj_locate", a(bVar));
                aqVar.dR("obj_source", bwVar.mRecomSource);
                aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar.dR("obj_param1", bwVar.mRecomAbTag);
                aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, bwVar.eFT);
                aqVar.dR("tid", bwVar.getTid());
                aqVar.dR("nid", bwVar.getNid());
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.jfE >= 0) {
                    aqVar.al("tab_id", bVar.jfE);
                }
                if (bwVar.eBK >= 0) {
                    aqVar.al("obj_floor", bwVar.eBK);
                }
                boolean z = (bwVar.bod() == null || (bwVar.bod().dKb() == null && bwVar.bod().bFQ() == null)) ? false : true;
                if (z && bwVar.bod().dKb() != null && bwVar.bod().dKb().bFI() != null && bwVar.bod().dKb().bFI().size() > 0) {
                    aqVar.al("obj_name", bwVar.bod().mXx ? 3 : 2);
                } else {
                    aqVar.al("obj_name", z ? 1 : 0);
                }
                boolean z2 = bwVar.getType() == bw.eEg;
                aqVar.al("thread_type", z2 ? 2 : 1);
                if (z2 && bwVar.bmA() != null && !StringUtils.isNull(bwVar.bmA().getName_show())) {
                    aqVar.dR("obj_name", bwVar.bmA().getName_show());
                }
                if (bwVar.blj() || bwVar.bow()) {
                    aqVar.al("obj_type", 14);
                } else if (bwVar.bli()) {
                    aqVar.al("obj_type", 13);
                }
                t.cor().e(aqVar);
                if (bwVar.blg()) {
                    aq aqVar2 = new aq("c12099");
                    aqVar2.dR("fid", bVar.jfD);
                    aqVar2.al("obj_locate", a(bVar));
                    aqVar2.dR("obj_source", bwVar.mRecomSource);
                    aqVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                    aqVar2.dR("obj_param1", bwVar.mRecomAbTag);
                    aqVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, bwVar.eFT);
                    aqVar2.dR("tid", bwVar.getTid());
                    aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    t.cor().e(aqVar2);
                }
                if (bVar.jfE == 501) {
                    aq aqVar3 = new aq("c13259");
                    aqVar3.dR("fid", bVar.jfD);
                    aqVar3.dR("tid", bwVar.getTid());
                    t.cor().e(aqVar3);
                }
            }
        }
    }

    public void a(b bVar, bw bwVar, int i) {
        if (bVar != null && bVar.jfB && bwVar != null && bwVar.getTid() != null) {
            t.cor().oy(true);
            aq aqVar = new aq("c11438");
            aqVar.dR("fid", bVar.jfD);
            aqVar.al("obj_locate", a(bVar));
            aqVar.dR("obj_source", bwVar.mRecomSource);
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dR("obj_param1", bwVar.mRecomAbTag);
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, bwVar.eFT);
            aqVar.dR("tid", bwVar.getTid());
            aqVar.dR("nid", bwVar.getNid());
            if (bwVar.blj() || bwVar.bow()) {
                aqVar.al("obj_type", 14);
            } else if (bwVar.bli()) {
                aqVar.al("obj_type", 13);
            } else {
                aqVar.al("obj_type", i);
            }
            aqVar.dR(TiebaInitialize.Params.OBJ_TO, ax(bwVar));
            if (bVar.jfE >= 0) {
                aqVar.al("tab_id", bVar.jfE);
            }
            if (bwVar.eBK >= 0) {
                aqVar.al("obj_floor", bwVar.eBK);
            }
            aqVar.al("thread_type", bwVar.getType() == bw.eEg ? 2 : 1);
            TiebaStatic.log(aqVar);
            if (bwVar.blg()) {
                aq aqVar2 = new aq("c12098");
                aqVar2.dR("fid", bVar.jfD);
                aqVar2.al("obj_locate", a(bVar));
                aqVar2.dR("obj_source", bwVar.mRecomSource);
                aqVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar2.dR("obj_param1", bwVar.mRecomAbTag);
                aqVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, bwVar.eFT);
                aqVar2.dR("tid", bwVar.getTid());
                aqVar2.al("obj_type", i);
                aqVar2.dR(TiebaInitialize.Params.OBJ_TO, ax(bwVar));
                TiebaStatic.log(aqVar2);
            }
            if (bVar.jfE == 501) {
                aq aqVar3 = new aq("c13260");
                aqVar3.dR("fid", bVar.jfD);
                aqVar3.dR("tid", bwVar.getTid());
                t.cor().e(aqVar3);
            }
            if (bwVar.bmA() != null && bwVar.bmA().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bmA().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    aq aqVar4 = new aq("c11850");
                    aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.jfG > 0) {
            if (bVar.jfE == 1120 || bVar.jfE == 1121) {
                return 15;
            }
            if (bVar.jfH == 3) {
                return 13;
            }
            return bVar.jfG;
        }
        int i = bVar.jfC;
        if (i == 8) {
            i = 9;
        }
        if (bVar.jfE == 504) {
            i = 11;
        }
        if (bVar.jfE == 1120 || bVar.jfE == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            aq al = new aq("c11440").dR("fid", frsViewData.getForum().getId()).al("obj_locate", i).al("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, al);
            }
            TiebaStatic.log(al);
        }
    }

    private String ax(bw bwVar) {
        return bwVar.eFW ? String.valueOf(bwVar.bnO()) : String.valueOf(4);
    }
}
