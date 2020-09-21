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
/* loaded from: classes21.dex */
public class c {
    public static int iyw;
    private static c iyz;
    private a iyx;
    private SparseArray<HashSet<String>> iyy;
    private CustomMessageListener dWP = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.iyy != null) {
                c.this.iyy.clear();
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
                        aVar.iyC = false;
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
    /* loaded from: classes21.dex */
    public class a {
        public int count;
        public boolean isRunning;
        public long iyB;
        public boolean iyC;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.iyC = false;
        }
    }

    public c() {
        iyw = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.dWP);
    }

    public static c cvK() {
        if (iyz == null) {
            synchronized (s.class) {
                if (iyz == null) {
                    iyz = new c();
                }
            }
        }
        return iyz;
    }

    private boolean cvL() {
        if (this.iyx == null) {
            this.iyx = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.iyx.iyC) {
            return true;
        }
        if (this.iyx.isRunning) {
            this.iyx.count++;
            if (currentTimeMillis - this.iyx.iyB < 120000) {
                if (this.iyx.count >= iyw) {
                    this.iyx.iyC = true;
                    a(this.iyx);
                    return true;
                }
            } else {
                this.iyx.isRunning = false;
                this.iyx.count = 0;
            }
        } else {
            this.iyx.isRunning = true;
            this.iyx.iyB = currentTimeMillis;
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
        if (bwVar != null && bwVar.bfd()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bwVar.getTid() != null && !hashSet.contains(bwVar.getTid())) {
                hashSet.add(bwVar.getTid());
                s.cfn().e(new aq("c11662").ai("obj_param1", 1).dF("post_id", bwVar.getTid()));
            }
        }
    }

    public void a(bw bwVar, boolean z) {
        if (bwVar != null) {
            s.cfn().e(new aq("c12125").dF("tid", bwVar.getId()).ai("obj_locate", z ? 2 : 1).u("obj_id", bwVar.bfS() != null ? bwVar.bfS().live_id : -1L).ai("obj_type", 1));
        }
    }

    public void aw(bw bwVar) {
        if (bwVar != null && bwVar.bgH()) {
            aq aqVar = new aq("c11717");
            aqVar.u("fid", bwVar.getFid());
            aqVar.dF("obj_source", bwVar.mRecomSource);
            aqVar.dF(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dF("obj_param1", bwVar.efy);
            aqVar.ai("obj_locate", 1);
            aqVar.dF("tid", bwVar.getTid());
            s.cfn().e(aqVar);
        }
    }

    public void a(b bVar, bw bwVar) {
        if (bVar != null && bVar.iyp && bwVar != null && bwVar.getTid() != null) {
            if (this.iyy == null) {
                this.iyy = new SparseArray<>();
            }
            if (this.iyy.get(bVar.iys) == null) {
                this.iyy.put(bVar.iys, new HashSet<>());
            }
            HashSet<String> hashSet = this.iyy.get(bVar.iys);
            String tid = bwVar.getTid();
            if (bVar.iyt >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.iyt;
            }
            if (!hashSet.contains(tid) && !cvL()) {
                hashSet.add(tid);
                aq aqVar = new aq("c11439");
                aqVar.dF("fid", bVar.iyr);
                aqVar.ai("obj_locate", a(bVar));
                aqVar.dF("obj_source", bwVar.mRecomSource);
                aqVar.dF(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar.dF("obj_param1", bwVar.mRecomAbTag);
                aqVar.dF(TiebaInitialize.Params.OBJ_PARAM3, bwVar.efy);
                aqVar.dF("tid", bwVar.getTid());
                aqVar.dF("nid", bwVar.getNid());
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.u(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.iys >= 0) {
                    aqVar.ai("tab_id", bVar.iys);
                }
                if (bwVar.ebp >= 0) {
                    aqVar.ai("obj_floor", bwVar.ebp);
                }
                boolean z = (bwVar.bhb() == null || (bwVar.bhb().dAF() == null && bwVar.bhb().byO() == null)) ? false : true;
                if (z && bwVar.bhb().dAF() != null && bwVar.bhb().dAF().byG() != null && bwVar.bhb().dAF().byG().size() > 0) {
                    aqVar.ai("obj_name", bwVar.bhb().mph ? 3 : 2);
                } else {
                    aqVar.ai("obj_name", z ? 1 : 0);
                }
                boolean z2 = bwVar.getType() == bw.edL;
                aqVar.ai("thread_type", z2 ? 2 : 1);
                if (z2 && bwVar.bfy() != null && !StringUtils.isNull(bwVar.bfy().getName_show())) {
                    aqVar.dF("obj_name", bwVar.bfy().getName_show());
                }
                if (bwVar.beh() || bwVar.bhu()) {
                    aqVar.ai("obj_type", 14);
                } else if (bwVar.beg()) {
                    aqVar.ai("obj_type", 13);
                }
                s.cfn().e(aqVar);
                if (bwVar.bee()) {
                    aq aqVar2 = new aq("c12099");
                    aqVar2.dF("fid", bVar.iyr);
                    aqVar2.ai("obj_locate", a(bVar));
                    aqVar2.dF("obj_source", bwVar.mRecomSource);
                    aqVar2.dF(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                    aqVar2.dF("obj_param1", bwVar.mRecomAbTag);
                    aqVar2.dF(TiebaInitialize.Params.OBJ_PARAM3, bwVar.efy);
                    aqVar2.dF("tid", bwVar.getTid());
                    aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    s.cfn().e(aqVar2);
                }
                if (bVar.iys == 501) {
                    aq aqVar3 = new aq("c13259");
                    aqVar3.dF("fid", bVar.iyr);
                    aqVar3.dF("tid", bwVar.getTid());
                    s.cfn().e(aqVar3);
                }
            }
        }
    }

    public void a(b bVar, bw bwVar, int i) {
        if (bVar != null && bVar.iyp && bwVar != null && bwVar.getTid() != null) {
            s.cfn().ns(true);
            aq aqVar = new aq("c11438");
            aqVar.dF("fid", bVar.iyr);
            aqVar.ai("obj_locate", a(bVar));
            aqVar.dF("obj_source", bwVar.mRecomSource);
            aqVar.dF(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dF("obj_param1", bwVar.mRecomAbTag);
            aqVar.dF(TiebaInitialize.Params.OBJ_PARAM3, bwVar.efy);
            aqVar.dF("tid", bwVar.getTid());
            aqVar.dF("nid", bwVar.getNid());
            if (bwVar.beh() || bwVar.bhu()) {
                aqVar.ai("obj_type", 14);
            } else if (bwVar.beg()) {
                aqVar.ai("obj_type", 13);
            } else {
                aqVar.ai("obj_type", i);
            }
            aqVar.dF(TiebaInitialize.Params.OBJ_TO, ax(bwVar));
            if (bVar.iys >= 0) {
                aqVar.ai("tab_id", bVar.iys);
            }
            if (bwVar.ebp >= 0) {
                aqVar.ai("obj_floor", bwVar.ebp);
            }
            aqVar.ai("thread_type", bwVar.getType() == bw.edL ? 2 : 1);
            TiebaStatic.log(aqVar);
            if (bwVar.bee()) {
                aq aqVar2 = new aq("c12098");
                aqVar2.dF("fid", bVar.iyr);
                aqVar2.ai("obj_locate", a(bVar));
                aqVar2.dF("obj_source", bwVar.mRecomSource);
                aqVar2.dF(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar2.dF("obj_param1", bwVar.mRecomAbTag);
                aqVar2.dF(TiebaInitialize.Params.OBJ_PARAM3, bwVar.efy);
                aqVar2.dF("tid", bwVar.getTid());
                aqVar2.ai("obj_type", i);
                aqVar2.dF(TiebaInitialize.Params.OBJ_TO, ax(bwVar));
                TiebaStatic.log(aqVar2);
            }
            if (bVar.iys == 501) {
                aq aqVar3 = new aq("c13260");
                aqVar3.dF("fid", bVar.iyr);
                aqVar3.dF("tid", bwVar.getTid());
                s.cfn().e(aqVar3);
            }
            if (bwVar.bfy() != null && bwVar.bfy().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bfy().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    aq aqVar4 = new aq("c11850");
                    aqVar4.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.iyu > 0) {
            if (bVar.iys == 1120 || bVar.iys == 1121) {
                return 15;
            }
            if (bVar.iyv == 3) {
                return 13;
            }
            return bVar.iyu;
        }
        int i = bVar.iyq;
        if (i == 8) {
            i = 9;
        }
        if (bVar.iys == 504) {
            i = 11;
        }
        if (bVar.iys == 1120 || bVar.iys == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            aq ai = new aq("c11440").dF("fid", frsViewData.getForum().getId()).ai("obj_locate", i).ai("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, ai);
            }
            TiebaStatic.log(ai);
        }
    }

    private String ax(bw bwVar) {
        return bwVar.efB ? String.valueOf(bwVar.bgM()) : String.valueOf(4);
    }
}
