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
    public static int hug;
    private static c huj;
    private a huh;
    private SparseArray<HashSet<String>> hui;
    private CustomMessageListener dld = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.hui != null) {
                c.this.hui.clear();
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
                        aVar.hum = false;
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
        public long hul;
        public boolean hum;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.hum = false;
        }
    }

    public c() {
        hug = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.dld);
    }

    public static c bUs() {
        if (huj == null) {
            synchronized (r.class) {
                if (huj == null) {
                    huj = new c();
                }
            }
        }
        return huj;
    }

    private boolean bUt() {
        if (this.huh == null) {
            this.huh = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.huh.hum) {
            return true;
        }
        if (this.huh.isRunning) {
            this.huh.count++;
            if (currentTimeMillis - this.huh.hul < 120000) {
                if (this.huh.count >= hug) {
                    this.huh.hum = true;
                    a(this.huh);
                    return true;
                }
            } else {
                this.huh.isRunning = false;
                this.huh.count = 0;
            }
        } else {
            this.huh.isRunning = true;
            this.huh.hul = currentTimeMillis;
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
        if (bjVar != null && bjVar.aKh()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bjVar.getTid() != null && !hashSet.contains(bjVar.getTid())) {
                hashSet.add(bjVar.getTid());
                r.bEW().e(new an("c11662").af("obj_param1", 1).cI("post_id", bjVar.getTid()));
            }
        }
    }

    public void a(bj bjVar, boolean z) {
        if (bjVar != null) {
            r.bEW().e(new an("c12125").cI("tid", bjVar.getId()).af("obj_locate", z ? 2 : 1).t("obj_id", bjVar.aKV() != null ? bjVar.aKV().live_id : -1L).af("obj_type", 1));
        }
    }

    public void ax(bj bjVar) {
        if (bjVar != null && bjVar.aLI()) {
            an anVar = new an("c11717");
            anVar.t("fid", bjVar.getFid());
            anVar.cI("obj_source", bjVar.mRecomSource);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cI("obj_param1", bjVar.dsY);
            anVar.af("obj_locate", 1);
            anVar.cI("tid", bjVar.getTid());
            r.bEW().e(anVar);
        }
    }

    public void a(b bVar, bj bjVar) {
        if (bVar != null && bVar.hua && bjVar != null && bjVar.getTid() != null) {
            if (this.hui == null) {
                this.hui = new SparseArray<>();
            }
            if (this.hui.get(bVar.hud) == null) {
                this.hui.put(bVar.hud, new HashSet<>());
            }
            HashSet<String> hashSet = this.hui.get(bVar.hud);
            String tid = bjVar.getTid();
            if (bVar.hue >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.hue;
            }
            if (!hashSet.contains(tid) && !bUt()) {
                hashSet.add(tid);
                an anVar = new an("c11439");
                anVar.cI("fid", bVar.huc);
                anVar.af("obj_locate", a(bVar));
                anVar.cI("obj_source", bjVar.mRecomSource);
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar.cI("obj_param1", bjVar.mRecomAbTag);
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, bjVar.dsY);
                anVar.cI("tid", bjVar.getTid());
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.t(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.hud >= 0) {
                    anVar.af("tab_id", bVar.hud);
                }
                if (bjVar.dpd >= 0) {
                    anVar.af("obj_floor", bjVar.dpd);
                }
                boolean z = (bjVar.aMc() == null || (bjVar.aMc().cWq() == null && bjVar.aMc().bcn() == null)) ? false : true;
                if (z && bjVar.aMc().cWq() != null && bjVar.aMc().cWq().bcf() != null && bjVar.aMc().cWq().bcf().size() > 0) {
                    anVar.af("obj_name", bjVar.aMc().kTa ? 3 : 2);
                } else {
                    anVar.af("obj_name", z ? 1 : 0);
                }
                boolean z2 = bjVar.getType() == bj.dri;
                anVar.af("thread_type", z2 ? 2 : 1);
                if (z2 && bjVar.aKC() != null && !StringUtils.isNull(bjVar.aKC().getName_show())) {
                    anVar.cI("obj_name", bjVar.aKC().getName_show());
                }
                if (bjVar.aJs() || bjVar.aMx()) {
                    anVar.af("obj_type", 14);
                } else if (bjVar.aJr()) {
                    anVar.af("obj_type", 13);
                }
                r.bEW().e(anVar);
                if (bjVar.aJp()) {
                    an anVar2 = new an("c12099");
                    anVar2.cI("fid", bVar.huc);
                    anVar2.af("obj_locate", a(bVar));
                    anVar2.cI("obj_source", bjVar.mRecomSource);
                    anVar2.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                    anVar2.cI("obj_param1", bjVar.mRecomAbTag);
                    anVar2.cI(TiebaInitialize.Params.OBJ_PARAM3, bjVar.dsY);
                    anVar2.cI("tid", bjVar.getTid());
                    anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bEW().e(anVar2);
                }
                if (bjVar.aKG()) {
                    an anVar3 = new an("c13169");
                    anVar3.cI("fid", bVar.huc);
                    anVar3.cI("tid", bjVar.getTid());
                    anVar3.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    r.bEW().e(anVar3);
                }
                if (bVar.hud == 501) {
                    an anVar4 = new an("c13259");
                    anVar4.cI("fid", bVar.huc);
                    anVar4.cI("tid", bjVar.getTid());
                    r.bEW().e(anVar4);
                }
            }
        }
    }

    public void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.hua && bjVar != null && bjVar.getTid() != null) {
            r.bEW().lx(true);
            an anVar = new an("c11438");
            anVar.cI("fid", bVar.huc);
            anVar.af("obj_locate", a(bVar));
            anVar.cI("obj_source", bjVar.mRecomSource);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
            anVar.cI("obj_param1", bjVar.mRecomAbTag);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, bjVar.dsY);
            anVar.cI("tid", bjVar.getTid());
            if (bjVar.aJs() || bjVar.aMx()) {
                anVar.af("obj_type", 14);
            } else if (bjVar.aJr()) {
                anVar.af("obj_type", 13);
            } else {
                anVar.af("obj_type", i);
            }
            anVar.cI(TiebaInitialize.Params.OBJ_TO, ay(bjVar));
            if (bVar.hud >= 0) {
                anVar.af("tab_id", bVar.hud);
            }
            if (bjVar.dpd >= 0) {
                anVar.af("obj_floor", bjVar.dpd);
            }
            anVar.af("thread_type", bjVar.getType() == bj.dri ? 2 : 1);
            TiebaStatic.log(anVar);
            if (bjVar.aJp()) {
                an anVar2 = new an("c12098");
                anVar2.cI("fid", bVar.huc);
                anVar2.af("obj_locate", a(bVar));
                anVar2.cI("obj_source", bjVar.mRecomSource);
                anVar2.cI(TiebaInitialize.Params.OBJ_PARAM2, bjVar.mRecomWeight);
                anVar2.cI("obj_param1", bjVar.mRecomAbTag);
                anVar2.cI(TiebaInitialize.Params.OBJ_PARAM3, bjVar.dsY);
                anVar2.cI("tid", bjVar.getTid());
                anVar2.af("obj_type", i);
                anVar2.cI(TiebaInitialize.Params.OBJ_TO, ay(bjVar));
                TiebaStatic.log(anVar2);
            }
            if (bVar.hud == 501) {
                an anVar3 = new an("c13260");
                anVar3.cI("fid", bVar.huc);
                anVar3.cI("tid", bjVar.getTid());
                r.bEW().e(anVar3);
            }
            if (bjVar.aKC() != null && bjVar.aKC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aKC().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    an anVar4 = new an("c11850");
                    anVar4.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(anVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.huf > 0) {
            return bVar.huf;
        }
        int i = bVar.hub;
        if (i == 8) {
            i = 9;
        }
        if (bVar.hud == 504) {
            return 11;
        }
        return i;
    }

    public void b(b bVar, bj bjVar, int i) {
        if (bVar != null && bVar.hua && bjVar != null && bjVar.getTid() != null && bjVar.aKG()) {
            an anVar = new an("c13170");
            anVar.cI("fid", bVar.huc);
            anVar.af("obj_locate", i);
            anVar.cI("tid", bjVar.getTid());
            TiebaStatic.log(anVar);
        }
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            an af = new an("c11440").cI("fid", frsViewData.getForum().getId()).af("obj_locate", i).af("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, af);
            }
            TiebaStatic.log(af);
        }
    }

    private String ay(bj bjVar) {
        return bjVar.dtb ? String.valueOf(bjVar.aLN()) : String.valueOf(4);
    }
}
