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
    public static int gJE;
    private static c gJH;
    private a gJF;
    private SparseArray<HashSet<String>> gJG;
    private CustomMessageListener cLH = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.gJG != null) {
                c.this.gJG.clear();
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
                        aVar.gJK = false;
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
        public long gJJ;
        public boolean gJK;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.gJK = false;
        }
    }

    public c() {
        gJE = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.cLH);
    }

    public static c bJK() {
        if (gJH == null) {
            synchronized (r.class) {
                if (gJH == null) {
                    gJH = new c();
                }
            }
        }
        return gJH;
    }

    private boolean bJL() {
        if (this.gJF == null) {
            this.gJF = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.gJF.gJK) {
            return true;
        }
        if (this.gJF.isRunning) {
            this.gJF.count++;
            if (currentTimeMillis - this.gJF.gJJ < 120000) {
                if (this.gJF.count >= gJE) {
                    this.gJF.gJK = true;
                    a(this.gJF);
                    return true;
                }
            } else {
                this.gJF.isRunning = false;
                this.gJF.count = 0;
            }
        } else {
            this.gJF.isRunning = true;
            this.gJF.gJJ = currentTimeMillis;
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
        if (bjVar != null && bjVar.aBT()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bjVar.getTid() != null && !hashSet.contains(bjVar.getTid())) {
                hashSet.add(bjVar.getTid());
                r.bvh().d(new an("c11662").X("obj_param1", 1).cy("post_id", bjVar.getTid()));
            }
        }
    }

    public void a(bj bjVar, boolean z) {
        if (bjVar != null) {
            r.bvh().d(new an("c12125").cy("tid", bjVar.getId()).X("obj_locate", z ? 2 : 1).s("obj_id", bjVar.aCH() != null ? bjVar.aCH().live_id : -1L).X("obj_type", 1));
        }
    }

    public void av(bj bjVar) {
        if (bjVar != null && bjVar.aDt()) {
            an anVar = new an("c11717");
            anVar.s("fid", bjVar.getFid());
            anVar.cy("obj_source", bjVar.mRecomSource);
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cy("obj_param1", bjVar.cTx);
            anVar.X("obj_locate", 1);
            anVar.cy("tid", bjVar.getTid());
            r.bvh().d(anVar);
        }
    }

    public void a(b bVar, bj bjVar) {
        if (bVar != null && bVar.gJy && bjVar != null && bjVar.getTid() != null) {
            if (this.gJG == null) {
                this.gJG = new SparseArray<>();
            }
            if (this.gJG.get(bVar.gJB) == null) {
                this.gJG.put(bVar.gJB, new HashSet<>());
            }
            HashSet<String> hashSet = this.gJG.get(bVar.gJB);
            String tid = bjVar.getTid();
            if (bVar.gJC >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.gJC;
            }
            if (!hashSet.contains(tid) && !bJL()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.cy("fid", bVar.gJA);
                anVar.X("obj_locate", a(bVar));
                anVar.cy("obj_source", bjVar.mRecomSource);
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar.cy("obj_param1", bjVar.mRecomAbTag);
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTx);
                anVar.cy("tid", bjVar.getTid());
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.gJB >= 0) {
                    anVar.X("tab_id", bVar.gJB);
                }
                if (bjVar.cPG >= 0) {
                    anVar.X("obj_floor", bjVar.cPG);
                }
                boolean z = (bjVar.aDM() == null || (bjVar.aDM().cLd() == null && bjVar.aDM().aUb() == null)) ? false : true;
                if (z && bjVar.aDM().cLd() != null && bjVar.aDM().cLd().aTT() != null && bjVar.aDM().cLd().aTT().size() > 0) {
                    anVar.X("obj_name", bjVar.aDM().khn ? 3 : 2);
                } else {
                    anVar.X("obj_name", z ? 1 : 0);
                }
                boolean z2 = bjVar.getType() == bj.cRJ;
                anVar.X("thread_type", z2 ? 2 : 1);
                if (z2 && bjVar.aCo() != null && !StringUtils.isNull(bjVar.aCo().getName_show())) {
                    anVar.cy("obj_name", bjVar.aCo().getName_show());
                }
                if (bjVar.aBe() || bjVar.aEh()) {
                    anVar.X("obj_type", 14);
                } else if (bjVar.aBd()) {
                    anVar.X("obj_type", 13);
                }
                r.bvh().d(anVar);
                if (bjVar.aBb()) {
                    an anVar2 = new an("c12099");
                    anVar2.cy("fid", bVar.gJA);
                    anVar2.X("obj_locate", a(bVar));
                    anVar2.cy("obj_source", bjVar.mRecomSource);
                    anVar2.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                    anVar2.cy("obj_param1", bjVar.mRecomAbTag);
                    anVar2.cy(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTx);
                    anVar2.cy("tid", bjVar.getTid());
                    anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bvh().d(anVar2);
                }
                if (bjVar.aCs()) {
                    an anVar3 = new an("c13169");
                    anVar3.cy("fid", bVar.gJA);
                    anVar3.cy("tid", bjVar.getTid());
                    anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bvh().d(anVar3);
                }
                if (bVar.gJB == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.cy("fid", bVar.gJA);
                    anVar4.cy("tid", bjVar.getTid());
                    r.bvh().d(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gJy && bjVar != null && bjVar.getTid() != null) {
            r.bvh().kp(true);
            an anVar = new an("c11438");
            anVar.cy("fid", bVar.gJA);
            anVar.X("obj_locate", a(bVar));
            anVar.cy("obj_source", bjVar.mRecomSource);
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cy("obj_param1", bjVar.mRecomAbTag);
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTx);
            anVar.cy("tid", bjVar.getTid());
            if (bjVar.aBe() || bjVar.aEh()) {
                anVar.X("obj_type", 14);
            } else if (bjVar.aBd()) {
                anVar.X("obj_type", 13);
            } else {
                anVar.X("obj_type", i);
            }
            anVar.cy(TiebaInitialize.Params.OBJ_TO, aw(bjVar));
            if (bVar.gJB >= 0) {
                anVar.X("tab_id", bVar.gJB);
            }
            if (bjVar.cPG >= 0) {
                anVar.X("obj_floor", bjVar.cPG);
            }
            anVar.X("thread_type", bjVar.getType() == bj.cRJ ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bjVar.aBb()) {
                an anVar2 = new an("c12098");
                anVar2.cy("fid", bVar.gJA);
                anVar2.X("obj_locate", a(bVar));
                anVar2.cy("obj_source", bjVar.mRecomSource);
                anVar2.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar2.cy("obj_param1", bjVar.mRecomAbTag);
                anVar2.cy(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTx);
                anVar2.cy("tid", bjVar.getTid());
                anVar2.X("obj_type", i);
                anVar2.cy(TiebaInitialize.Params.OBJ_TO, aw(bjVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.gJB == 501) {
                an anVar3 = new an("c13260");
                anVar3.cy("fid", bVar.gJA);
                anVar3.cy("tid", bjVar.getTid());
                r.bvh().d(anVar3);
            }
            if (bjVar.aCo() != null && bjVar.aCo().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aCo().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    an anVar4 = new an("c11850");
                    anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(anVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.gJD > 0) {
            return bVar.gJD;
        }
        int i = bVar.gJz;
        if (i == 8) {
            i = 9;
        }
        if (bVar.gJB == 504) {
            return 11;
        }
        return i;
    }

    public void b(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gJy && bjVar != null && bjVar.getTid() != null && bjVar.aCs()) {
            an anVar = new an("c13170");
            anVar.cy("fid", bVar.gJA);
            anVar.X("obj_locate", i);
            anVar.cy("tid", bjVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            an X = new an("c11440").cy("fid", frsViewData.getForum().getId()).X("obj_locate", i).X("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, X);
            }
            TiebaStatic.log(X);
        }
    }

    private String aw(bj bjVar) {
        return bjVar.cTA ? String.valueOf(bjVar.aDy()) : String.valueOf(4);
    }
}
