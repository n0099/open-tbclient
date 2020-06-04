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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class c {
    public static int hJG;
    private static c hJJ;
    private a hJH;
    private SparseArray<HashSet<String>> hJI;
    private CustomMessageListener dzd = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.hJI != null) {
                c.this.hJI.clear();
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
                        aVar.hJM = false;
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
        public long hJL;
        public boolean hJM;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.hJM = false;
        }
    }

    public c() {
        hJG = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.dzd);
    }

    public static c caY() {
        if (hJJ == null) {
            synchronized (s.class) {
                if (hJJ == null) {
                    hJJ = new c();
                }
            }
        }
        return hJJ;
    }

    private boolean caZ() {
        if (this.hJH == null) {
            this.hJH = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hJH.hJM) {
            return true;
        }
        if (this.hJH.isRunning) {
            this.hJH.count++;
            if (currentTimeMillis - this.hJH.hJL < 120000) {
                if (this.hJH.count >= hJG) {
                    this.hJH.hJM = true;
                    a(this.hJH);
                    return true;
                }
            } else {
                this.hJH.isRunning = false;
                this.hJH.count = 0;
            }
        } else {
            this.hJH.isRunning = true;
            this.hJH.hJL = currentTimeMillis;
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

    public void a(bk bkVar, HashSet<String> hashSet) {
        if (bkVar != null && bkVar.aQc()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bkVar.getTid() != null && !hashSet.contains(bkVar.getTid())) {
                hashSet.add(bkVar.getTid());
                s.bLs().e(new an("c11662").ag("obj_param1", 1).dh("post_id", bkVar.getTid()));
            }
        }
    }

    public void a(bk bkVar, boolean z) {
        if (bkVar != null) {
            s.bLs().e(new an("c12125").dh("tid", bkVar.getId()).ag("obj_locate", z ? 2 : 1).s("obj_id", bkVar.aQS() != null ? bkVar.aQS().live_id : -1L).ag("obj_type", 1));
        }
    }

    public void ay(bk bkVar) {
        if (bkVar != null && bkVar.aRH()) {
            an anVar = new an("c11717");
            anVar.s("fid", bkVar.getFid());
            anVar.dh("obj_source", bkVar.mRecomSource);
            anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, bkVar.mRecomWeight);
            anVar.dh("obj_param1", bkVar.dGS);
            anVar.ag("obj_locate", 1);
            anVar.dh("tid", bkVar.getTid());
            s.bLs().e(anVar);
        }
    }

    public void a(b bVar, bk bkVar) {
        if (bVar != null && bVar.hJA && bkVar != null && bkVar.getTid() != null) {
            if (this.hJI == null) {
                this.hJI = new SparseArray<>();
            }
            if (this.hJI.get(bVar.hJD) == null) {
                this.hJI.put(bVar.hJD, new HashSet<>());
            }
            HashSet<String> hashSet = this.hJI.get(bVar.hJD);
            String tid = bkVar.getTid();
            if (bVar.hJE >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.hJE;
            }
            if (!hashSet.contains(tid) && !caZ()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.dh("fid", bVar.hJC);
                anVar.ag("obj_locate", a(bVar));
                anVar.dh("obj_source", bkVar.mRecomSource);
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, bkVar.mRecomWeight);
                anVar.dh("obj_param1", bkVar.mRecomAbTag);
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM3, bkVar.dGS);
                anVar.dh("tid", bkVar.getTid());
                anVar.dh("nid", bkVar.getNid());
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.hJD >= 0) {
                    anVar.ag("tab_id", bVar.hJD);
                }
                if (bkVar.dDb >= 0) {
                    anVar.ag("obj_floor", bkVar.dDb);
                }
                boolean z = (bkVar.aSb() == null || (bkVar.aSb().ddL() == null && bkVar.aSb().biA() == null)) ? false : true;
                if (z && bkVar.aSb().ddL() != null && bkVar.aSb().ddL().bis() != null && bkVar.aSb().ddL().bis().size() > 0) {
                    anVar.ag("obj_name", bkVar.aSb().lmA ? 3 : 2);
                } else {
                    anVar.ag("obj_name", z ? 1 : 0);
                }
                boolean z2 = bkVar.getType() == bk.dFe;
                anVar.ag("thread_type", z2 ? 2 : 1);
                if (z2 && bkVar.aQx() != null && !StringUtils.isNull(bkVar.aQx().getName_show())) {
                    anVar.dh("obj_name", bkVar.aQx().getName_show());
                }
                if (bkVar.aPn() || bkVar.aSw()) {
                    anVar.ag("obj_type", 14);
                } else if (bkVar.aPm()) {
                    anVar.ag("obj_type", 13);
                }
                s.bLs().e(anVar);
                if (bkVar.aPk()) {
                    an anVar2 = new an("c12099");
                    anVar2.dh("fid", bVar.hJC);
                    anVar2.ag("obj_locate", a(bVar));
                    anVar2.dh("obj_source", bkVar.mRecomSource);
                    anVar2.dh(TiebaInitialize.Params.OBJ_PARAM2, bkVar.mRecomWeight);
                    anVar2.dh("obj_param1", bkVar.mRecomAbTag);
                    anVar2.dh(TiebaInitialize.Params.OBJ_PARAM3, bkVar.dGS);
                    anVar2.dh("tid", bkVar.getTid());
                    anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    s.bLs().e(anVar2);
                }
                if (bkVar.aQB()) {
                    an anVar3 = new an("c13169");
                    anVar3.dh("fid", bVar.hJC);
                    anVar3.dh("tid", bkVar.getTid());
                    anVar3.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    s.bLs().e(anVar3);
                }
                if (bVar.hJD == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.dh("fid", bVar.hJC);
                    anVar4.dh("tid", bkVar.getTid());
                    s.bLs().e(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bk bkVar, int i) {
        if (bVar != null && bVar.hJA && bkVar != null && bkVar.getTid() != null) {
            s.bLs().lT(true);
            an anVar = new an("c11438");
            anVar.dh("fid", bVar.hJC);
            anVar.ag("obj_locate", a(bVar));
            anVar.dh("obj_source", bkVar.mRecomSource);
            anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, bkVar.mRecomWeight);
            anVar.dh("obj_param1", bkVar.mRecomAbTag);
            anVar.dh(TiebaInitialize.Params.OBJ_PARAM3, bkVar.dGS);
            anVar.dh("tid", bkVar.getTid());
            anVar.dh("nid", bkVar.getNid());
            if (bkVar.aPn() || bkVar.aSw()) {
                anVar.ag("obj_type", 14);
            } else if (bkVar.aPm()) {
                anVar.ag("obj_type", 13);
            } else {
                anVar.ag("obj_type", i);
            }
            anVar.dh(TiebaInitialize.Params.OBJ_TO, az(bkVar));
            if (bVar.hJD >= 0) {
                anVar.ag("tab_id", bVar.hJD);
            }
            if (bkVar.dDb >= 0) {
                anVar.ag("obj_floor", bkVar.dDb);
            }
            anVar.ag("thread_type", bkVar.getType() == bk.dFe ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bkVar.aPk()) {
                an anVar2 = new an("c12098");
                anVar2.dh("fid", bVar.hJC);
                anVar2.ag("obj_locate", a(bVar));
                anVar2.dh("obj_source", bkVar.mRecomSource);
                anVar2.dh(TiebaInitialize.Params.OBJ_PARAM2, bkVar.mRecomWeight);
                anVar2.dh("obj_param1", bkVar.mRecomAbTag);
                anVar2.dh(TiebaInitialize.Params.OBJ_PARAM3, bkVar.dGS);
                anVar2.dh("tid", bkVar.getTid());
                anVar2.ag("obj_type", i);
                anVar2.dh(TiebaInitialize.Params.OBJ_TO, az(bkVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.hJD == 501) {
                an anVar3 = new an("c13260");
                anVar3.dh("fid", bVar.hJC);
                anVar3.dh("tid", bkVar.getTid());
                s.bLs().e(anVar3);
            }
            if (bkVar.aQx() != null && bkVar.aQx().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bkVar.aQx().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    an anVar4 = new an("c11850");
                    anVar4.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(anVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.hJF > 0) {
            return bVar.hJF;
        }
        int i = bVar.hJB;
        if (i == 8) {
            i = 9;
        }
        if (bVar.hJD == 504) {
            return 11;
        }
        return i;
    }

    public void b(b bVar, bk bkVar, int i) {
        if (bVar != null && bVar.hJA && bkVar != null && bkVar.getTid() != null && bkVar.aQB()) {
            an anVar = new an("c13170");
            anVar.dh("fid", bVar.hJC);
            anVar.ag("obj_locate", i);
            anVar.dh("tid", bkVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            an ag = new an("c11440").dh("fid", frsViewData.getForum().getId()).ag("obj_locate", i).ag("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, ag);
            }
            TiebaStatic.log(ag);
        }
    }

    private String az(bk bkVar) {
        return bkVar.dGV ? String.valueOf(bkVar.aRM()) : String.valueOf(4);
    }
}
