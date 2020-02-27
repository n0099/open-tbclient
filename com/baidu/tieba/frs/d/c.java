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
    public static int gJq;
    private static c gJt;
    private a gJr;
    private SparseArray<HashSet<String>> gJs;
    private CustomMessageListener cLF = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.gJs != null) {
                c.this.gJs.clear();
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
                        aVar.gJw = false;
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
        public long gJv;
        public boolean gJw;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.gJw = false;
        }
    }

    public c() {
        gJq = com.baidu.tbadk.core.sharedPref.b.aFB().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.cLF);
    }

    public static c bJH() {
        if (gJt == null) {
            synchronized (r.class) {
                if (gJt == null) {
                    gJt = new c();
                }
            }
        }
        return gJt;
    }

    private boolean bJI() {
        if (this.gJr == null) {
            this.gJr = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.gJr.gJw) {
            return true;
        }
        if (this.gJr.isRunning) {
            this.gJr.count++;
            if (currentTimeMillis - this.gJr.gJv < 120000) {
                if (this.gJr.count >= gJq) {
                    this.gJr.gJw = true;
                    a(this.gJr);
                    return true;
                }
            } else {
                this.gJr.isRunning = false;
                this.gJr.count = 0;
            }
        } else {
            this.gJr.isRunning = true;
            this.gJr.gJv = currentTimeMillis;
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
        if (bjVar != null && bjVar.aBR()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bjVar.getTid() != null && !hashSet.contains(bjVar.getTid())) {
                hashSet.add(bjVar.getTid());
                r.bve().d(new an("c11662").X("obj_param1", 1).cy("post_id", bjVar.getTid()));
            }
        }
    }

    public void a(bj bjVar, boolean z) {
        if (bjVar != null) {
            r.bve().d(new an("c12125").cy("tid", bjVar.getId()).X("obj_locate", z ? 2 : 1).s("obj_id", bjVar.aCF() != null ? bjVar.aCF().live_id : -1L).X("obj_type", 1));
        }
    }

    public void av(bj bjVar) {
        if (bjVar != null && bjVar.aDr()) {
            an anVar = new an("c11717");
            anVar.s("fid", bjVar.getFid());
            anVar.cy("obj_source", bjVar.mRecomSource);
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cy("obj_param1", bjVar.cTv);
            anVar.X("obj_locate", 1);
            anVar.cy("tid", bjVar.getTid());
            r.bve().d(anVar);
        }
    }

    public void a(b bVar, bj bjVar) {
        if (bVar != null && bVar.gJk && bjVar != null && bjVar.getTid() != null) {
            if (this.gJs == null) {
                this.gJs = new SparseArray<>();
            }
            if (this.gJs.get(bVar.gJn) == null) {
                this.gJs.put(bVar.gJn, new HashSet<>());
            }
            HashSet<String> hashSet = this.gJs.get(bVar.gJn);
            String tid = bjVar.getTid();
            if (bVar.gJo >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.gJo;
            }
            if (!hashSet.contains(tid) && !bJI()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.cy("fid", bVar.gJm);
                anVar.X("obj_locate", a(bVar));
                anVar.cy("obj_source", bjVar.mRecomSource);
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar.cy("obj_param1", bjVar.mRecomAbTag);
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTv);
                anVar.cy("tid", bjVar.getTid());
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.gJn >= 0) {
                    anVar.X("tab_id", bVar.gJn);
                }
                if (bjVar.cPE >= 0) {
                    anVar.X("obj_floor", bjVar.cPE);
                }
                boolean z = (bjVar.aDK() == null || (bjVar.aDK().cLa() == null && bjVar.aDK().aTY() == null)) ? false : true;
                if (z && bjVar.aDK().cLa() != null && bjVar.aDK().cLa().aTQ() != null && bjVar.aDK().cLa().aTQ().size() > 0) {
                    anVar.X("obj_name", bjVar.aDK().kgZ ? 3 : 2);
                } else {
                    anVar.X("obj_name", z ? 1 : 0);
                }
                boolean z2 = bjVar.getType() == bj.cRH;
                anVar.X("thread_type", z2 ? 2 : 1);
                if (z2 && bjVar.aCm() != null && !StringUtils.isNull(bjVar.aCm().getName_show())) {
                    anVar.cy("obj_name", bjVar.aCm().getName_show());
                }
                if (bjVar.aBc() || bjVar.aEf()) {
                    anVar.X("obj_type", 14);
                } else if (bjVar.aBb()) {
                    anVar.X("obj_type", 13);
                }
                r.bve().d(anVar);
                if (bjVar.aAZ()) {
                    an anVar2 = new an("c12099");
                    anVar2.cy("fid", bVar.gJm);
                    anVar2.X("obj_locate", a(bVar));
                    anVar2.cy("obj_source", bjVar.mRecomSource);
                    anVar2.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                    anVar2.cy("obj_param1", bjVar.mRecomAbTag);
                    anVar2.cy(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTv);
                    anVar2.cy("tid", bjVar.getTid());
                    anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bve().d(anVar2);
                }
                if (bjVar.aCq()) {
                    an anVar3 = new an("c13169");
                    anVar3.cy("fid", bVar.gJm);
                    anVar3.cy("tid", bjVar.getTid());
                    anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bve().d(anVar3);
                }
                if (bVar.gJn == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.cy("fid", bVar.gJm);
                    anVar4.cy("tid", bjVar.getTid());
                    r.bve().d(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gJk && bjVar != null && bjVar.getTid() != null) {
            r.bve().kp(true);
            an anVar = new an("c11438");
            anVar.cy("fid", bVar.gJm);
            anVar.X("obj_locate", a(bVar));
            anVar.cy("obj_source", bjVar.mRecomSource);
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cy("obj_param1", bjVar.mRecomAbTag);
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTv);
            anVar.cy("tid", bjVar.getTid());
            if (bjVar.aBc() || bjVar.aEf()) {
                anVar.X("obj_type", 14);
            } else if (bjVar.aBb()) {
                anVar.X("obj_type", 13);
            } else {
                anVar.X("obj_type", i);
            }
            anVar.cy(TiebaInitialize.Params.OBJ_TO, aw(bjVar));
            if (bVar.gJn >= 0) {
                anVar.X("tab_id", bVar.gJn);
            }
            if (bjVar.cPE >= 0) {
                anVar.X("obj_floor", bjVar.cPE);
            }
            anVar.X("thread_type", bjVar.getType() == bj.cRH ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bjVar.aAZ()) {
                an anVar2 = new an("c12098");
                anVar2.cy("fid", bVar.gJm);
                anVar2.X("obj_locate", a(bVar));
                anVar2.cy("obj_source", bjVar.mRecomSource);
                anVar2.cy(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar2.cy("obj_param1", bjVar.mRecomAbTag);
                anVar2.cy(TiebaInitialize.Params.OBJ_PARAM3, bjVar.cTv);
                anVar2.cy("tid", bjVar.getTid());
                anVar2.X("obj_type", i);
                anVar2.cy(TiebaInitialize.Params.OBJ_TO, aw(bjVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.gJn == 501) {
                an anVar3 = new an("c13260");
                anVar3.cy("fid", bVar.gJm);
                anVar3.cy("tid", bjVar.getTid());
                r.bve().d(anVar3);
            }
            if (bjVar.aCm() != null && bjVar.aCm().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aCm().getAlaUserData();
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
        if (bVar.gJp > 0) {
            return bVar.gJp;
        }
        int i = bVar.gJl;
        if (i == 8) {
            i = 9;
        }
        if (bVar.gJn == 504) {
            return 11;
        }
        return i;
    }

    public void b(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.gJk && bjVar != null && bjVar.getTid() != null && bjVar.aCq()) {
            an anVar = new an("c13170");
            anVar.cy("fid", bVar.gJm);
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
        return bjVar.cTy ? String.valueOf(bjVar.aDw()) : String.valueOf(4);
    }
}
