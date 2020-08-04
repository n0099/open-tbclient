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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes16.dex */
public class c {
    public static int icS;
    private static c icV;
    private a icT;
    private SparseArray<HashSet<String>> icU;
    private CustomMessageListener dLt = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.icU != null) {
                c.this.icU.clear();
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
                        aVar.icY = false;
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
    /* loaded from: classes16.dex */
    public class a {
        public int count;
        public long icX;
        public boolean icY;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.icY = false;
        }
    }

    public c() {
        icS = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.dLt);
    }

    public static c chQ() {
        if (icV == null) {
            synchronized (s.class) {
                if (icV == null) {
                    icV = new c();
                }
            }
        }
        return icV;
    }

    private boolean chR() {
        if (this.icT == null) {
            this.icT = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.icT.icY) {
            return true;
        }
        if (this.icT.isRunning) {
            this.icT.count++;
            if (currentTimeMillis - this.icT.icX < 120000) {
                if (this.icT.count >= icS) {
                    this.icT.icY = true;
                    a(this.icT);
                    return true;
                }
            } else {
                this.icT.isRunning = false;
                this.icT.count = 0;
            }
        } else {
            this.icT.isRunning = true;
            this.icT.icX = currentTimeMillis;
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

    public void a(bv bvVar, HashSet<String> hashSet) {
        if (bvVar != null && bvVar.aVQ()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bvVar.getTid() != null && !hashSet.contains(bvVar.getTid())) {
                hashSet.add(bvVar.getTid());
                s.bRL().e(new ap("c11662").ah("obj_param1", 1).dn("post_id", bvVar.getTid()));
            }
        }
    }

    public void a(bv bvVar, boolean z) {
        if (bvVar != null) {
            s.bRL().e(new ap("c12125").dn("tid", bvVar.getId()).ah("obj_locate", z ? 2 : 1).t("obj_id", bvVar.aWF() != null ? bvVar.aWF().live_id : -1L).ah("obj_type", 1));
        }
    }

    public void av(bv bvVar) {
        if (bvVar != null && bvVar.aXu()) {
            ap apVar = new ap("c11717");
            apVar.t("fid", bvVar.getFid());
            apVar.dn("obj_source", bvVar.mRecomSource);
            apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, bvVar.mRecomWeight);
            apVar.dn("obj_param1", bvVar.dTO);
            apVar.ah("obj_locate", 1);
            apVar.dn("tid", bvVar.getTid());
            s.bRL().e(apVar);
        }
    }

    public void a(b bVar, bv bvVar) {
        if (bVar != null && bVar.icM && bvVar != null && bvVar.getTid() != null) {
            if (this.icU == null) {
                this.icU = new SparseArray<>();
            }
            if (this.icU.get(bVar.icP) == null) {
                this.icU.put(bVar.icP, new HashSet<>());
            }
            HashSet<String> hashSet = this.icU.get(bVar.icP);
            String tid = bvVar.getTid();
            if (bVar.icQ >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.icQ;
            }
            if (!hashSet.contains(tid) && !chR()) {
                hashSet.add(tid);
                ap apVar = new ap("c11439");
                apVar.dn("fid", bVar.icO);
                apVar.ah("obj_locate", a(bVar));
                apVar.dn("obj_source", bvVar.mRecomSource);
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, bvVar.mRecomWeight);
                apVar.dn("obj_param1", bvVar.mRecomAbTag);
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM3, bvVar.dTO);
                apVar.dn("tid", bvVar.getTid());
                apVar.dn("nid", bvVar.getNid());
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                apVar.t(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.icP >= 0) {
                    apVar.ah("tab_id", bVar.icP);
                }
                if (bvVar.dPI >= 0) {
                    apVar.ah("obj_floor", bvVar.dPI);
                }
                boolean z = (bvVar.aXO() == null || (bvVar.aXO().dlk() == null && bvVar.aXO().boR() == null)) ? false : true;
                if (z && bvVar.aXO().dlk() != null && bvVar.aXO().dlk().boJ() != null && bvVar.aXO().dlk().boJ().size() > 0) {
                    apVar.ah("obj_name", bvVar.aXO().lNJ ? 3 : 2);
                } else {
                    apVar.ah("obj_name", z ? 1 : 0);
                }
                boolean z2 = bvVar.getType() == bv.dSb;
                apVar.ah("thread_type", z2 ? 2 : 1);
                if (z2 && bvVar.aWl() != null && !StringUtils.isNull(bvVar.aWl().getName_show())) {
                    apVar.dn("obj_name", bvVar.aWl().getName_show());
                }
                if (bvVar.aUU() || bvVar.aYh()) {
                    apVar.ah("obj_type", 14);
                } else if (bvVar.aUT()) {
                    apVar.ah("obj_type", 13);
                }
                s.bRL().e(apVar);
                if (bvVar.aUR()) {
                    ap apVar2 = new ap("c12099");
                    apVar2.dn("fid", bVar.icO);
                    apVar2.ah("obj_locate", a(bVar));
                    apVar2.dn("obj_source", bvVar.mRecomSource);
                    apVar2.dn(TiebaInitialize.Params.OBJ_PARAM2, bvVar.mRecomWeight);
                    apVar2.dn("obj_param1", bvVar.mRecomAbTag);
                    apVar2.dn(TiebaInitialize.Params.OBJ_PARAM3, bvVar.dTO);
                    apVar2.dn("tid", bvVar.getTid());
                    apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
                    s.bRL().e(apVar2);
                }
                if (bVar.icP == 501) {
                    ap apVar3 = new ap("c13259");
                    apVar3.dn("fid", bVar.icO);
                    apVar3.dn("tid", bvVar.getTid());
                    s.bRL().e(apVar3);
                }
            }
        }
    }

    public void a(b bVar, bv bvVar, int i) {
        if (bVar != null && bVar.icM && bvVar != null && bvVar.getTid() != null) {
            s.bRL().mH(true);
            ap apVar = new ap("c11438");
            apVar.dn("fid", bVar.icO);
            apVar.ah("obj_locate", a(bVar));
            apVar.dn("obj_source", bvVar.mRecomSource);
            apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, bvVar.mRecomWeight);
            apVar.dn("obj_param1", bvVar.mRecomAbTag);
            apVar.dn(TiebaInitialize.Params.OBJ_PARAM3, bvVar.dTO);
            apVar.dn("tid", bvVar.getTid());
            apVar.dn("nid", bvVar.getNid());
            if (bvVar.aUU() || bvVar.aYh()) {
                apVar.ah("obj_type", 14);
            } else if (bvVar.aUT()) {
                apVar.ah("obj_type", 13);
            } else {
                apVar.ah("obj_type", i);
            }
            apVar.dn(TiebaInitialize.Params.OBJ_TO, aw(bvVar));
            if (bVar.icP >= 0) {
                apVar.ah("tab_id", bVar.icP);
            }
            if (bvVar.dPI >= 0) {
                apVar.ah("obj_floor", bvVar.dPI);
            }
            apVar.ah("thread_type", bvVar.getType() == bv.dSb ? 2 : 1);
            TiebaStatic.log(apVar);
            if (bvVar.aUR()) {
                ap apVar2 = new ap("c12098");
                apVar2.dn("fid", bVar.icO);
                apVar2.ah("obj_locate", a(bVar));
                apVar2.dn("obj_source", bvVar.mRecomSource);
                apVar2.dn(TiebaInitialize.Params.OBJ_PARAM2, bvVar.mRecomWeight);
                apVar2.dn("obj_param1", bvVar.mRecomAbTag);
                apVar2.dn(TiebaInitialize.Params.OBJ_PARAM3, bvVar.dTO);
                apVar2.dn("tid", bvVar.getTid());
                apVar2.ah("obj_type", i);
                apVar2.dn(TiebaInitialize.Params.OBJ_TO, aw(bvVar));
                TiebaStatic.log(apVar2);
            }
            if (bVar.icP == 501) {
                ap apVar3 = new ap("c13260");
                apVar3.dn("fid", bVar.icO);
                apVar3.dn("tid", bvVar.getTid());
                s.bRL().e(apVar3);
            }
            if (bvVar.aWl() != null && bvVar.aWl().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bvVar.aWl().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    ap apVar4 = new ap("c11850");
                    apVar4.dn("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(apVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.icR > 0) {
            return bVar.icR;
        }
        int i = bVar.icN;
        if (i == 8) {
            i = 9;
        }
        if (bVar.icP == 504) {
            return 11;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            ap ah = new ap("c11440").dn("fid", frsViewData.getForum().getId()).ah("obj_locate", i).ah("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, ah);
            }
            TiebaStatic.log(ah);
        }
    }

    private String aw(bv bvVar) {
        return bvVar.dTR ? String.valueOf(bvVar.aXz()) : String.valueOf(4);
    }
}
