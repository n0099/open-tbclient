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
/* loaded from: classes16.dex */
public class c {
    public static int ira;
    private static c ird;
    private a irb;
    private SparseArray<HashSet<String>> irc;
    private CustomMessageListener dUB = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.irc != null) {
                c.this.irc.clear();
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
                        aVar.irg = false;
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
        public long irf;
        public boolean irg;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.irg = false;
        }
    }

    public c() {
        ira = com.baidu.tbadk.core.sharedPref.b.bik().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.dUB);
    }

    public static c csu() {
        if (ird == null) {
            synchronized (s.class) {
                if (ird == null) {
                    ird = new c();
                }
            }
        }
        return ird;
    }

    private boolean csv() {
        if (this.irb == null) {
            this.irb = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.irb.irg) {
            return true;
        }
        if (this.irb.isRunning) {
            this.irb.count++;
            if (currentTimeMillis - this.irb.irf < 120000) {
                if (this.irb.count >= ira) {
                    this.irb.irg = true;
                    a(this.irb);
                    return true;
                }
            } else {
                this.irb.isRunning = false;
                this.irb.count = 0;
            }
        } else {
            this.irb.isRunning = true;
            this.irb.irf = currentTimeMillis;
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
        if (bwVar != null && bwVar.bej()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (bwVar.getTid() != null && !hashSet.contains(bwVar.getTid())) {
                hashSet.add(bwVar.getTid());
                s.cbX().e(new aq("c11662").ai("obj_param1", 1).dD("post_id", bwVar.getTid()));
            }
        }
    }

    public void a(bw bwVar, boolean z) {
        if (bwVar != null) {
            s.cbX().e(new aq("c12125").dD("tid", bwVar.getId()).ai("obj_locate", z ? 2 : 1).u("obj_id", bwVar.beY() != null ? bwVar.beY().live_id : -1L).ai("obj_type", 1));
        }
    }

    public void av(bw bwVar) {
        if (bwVar != null && bwVar.bfN()) {
            aq aqVar = new aq("c11717");
            aqVar.u("fid", bwVar.getFid());
            aqVar.dD("obj_source", bwVar.mRecomSource);
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dD("obj_param1", bwVar.edk);
            aqVar.ai("obj_locate", 1);
            aqVar.dD("tid", bwVar.getTid());
            s.cbX().e(aqVar);
        }
    }

    public void a(b bVar, bw bwVar) {
        if (bVar != null && bVar.iqT && bwVar != null && bwVar.getTid() != null) {
            if (this.irc == null) {
                this.irc = new SparseArray<>();
            }
            if (this.irc.get(bVar.iqW) == null) {
                this.irc.put(bVar.iqW, new HashSet<>());
            }
            HashSet<String> hashSet = this.irc.get(bVar.iqW);
            String tid = bwVar.getTid();
            if (bVar.iqX >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.iqX;
            }
            if (!hashSet.contains(tid) && !csv()) {
                hashSet.add(tid);
                aq aqVar = new aq("c11439");
                aqVar.dD("fid", bVar.iqV);
                aqVar.ai("obj_locate", a(bVar));
                aqVar.dD("obj_source", bwVar.mRecomSource);
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar.dD("obj_param1", bwVar.mRecomAbTag);
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM3, bwVar.edk);
                aqVar.dD("tid", bwVar.getTid());
                aqVar.dD("nid", bwVar.getNid());
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.u(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.iqW >= 0) {
                    aqVar.ai("tab_id", bVar.iqW);
                }
                if (bwVar.dZb >= 0) {
                    aqVar.ai("obj_floor", bwVar.dZb);
                }
                boolean z = (bwVar.bgh() == null || (bwVar.bgh().dwH() == null && bwVar.bgh().bxE() == null)) ? false : true;
                if (z && bwVar.bgh().dwH() != null && bwVar.bgh().dwH().bxw() != null && bwVar.bgh().dwH().bxw().size() > 0) {
                    aqVar.ai("obj_name", bwVar.bgh().mft ? 3 : 2);
                } else {
                    aqVar.ai("obj_name", z ? 1 : 0);
                }
                boolean z2 = bwVar.getType() == bw.ebx;
                aqVar.ai("thread_type", z2 ? 2 : 1);
                if (z2 && bwVar.beE() != null && !StringUtils.isNull(bwVar.beE().getName_show())) {
                    aqVar.dD("obj_name", bwVar.beE().getName_show());
                }
                if (bwVar.bdn() || bwVar.bgA()) {
                    aqVar.ai("obj_type", 14);
                } else if (bwVar.bdm()) {
                    aqVar.ai("obj_type", 13);
                }
                s.cbX().e(aqVar);
                if (bwVar.bdk()) {
                    aq aqVar2 = new aq("c12099");
                    aqVar2.dD("fid", bVar.iqV);
                    aqVar2.ai("obj_locate", a(bVar));
                    aqVar2.dD("obj_source", bwVar.mRecomSource);
                    aqVar2.dD(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                    aqVar2.dD("obj_param1", bwVar.mRecomAbTag);
                    aqVar2.dD(TiebaInitialize.Params.OBJ_PARAM3, bwVar.edk);
                    aqVar2.dD("tid", bwVar.getTid());
                    aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                    s.cbX().e(aqVar2);
                }
                if (bVar.iqW == 501) {
                    aq aqVar3 = new aq("c13259");
                    aqVar3.dD("fid", bVar.iqV);
                    aqVar3.dD("tid", bwVar.getTid());
                    s.cbX().e(aqVar3);
                }
            }
        }
    }

    public void a(b bVar, bw bwVar, int i) {
        if (bVar != null && bVar.iqT && bwVar != null && bwVar.getTid() != null) {
            s.cbX().nk(true);
            aq aqVar = new aq("c11438");
            aqVar.dD("fid", bVar.iqV);
            aqVar.ai("obj_locate", a(bVar));
            aqVar.dD("obj_source", bwVar.mRecomSource);
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
            aqVar.dD("obj_param1", bwVar.mRecomAbTag);
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM3, bwVar.edk);
            aqVar.dD("tid", bwVar.getTid());
            aqVar.dD("nid", bwVar.getNid());
            if (bwVar.bdn() || bwVar.bgA()) {
                aqVar.ai("obj_type", 14);
            } else if (bwVar.bdm()) {
                aqVar.ai("obj_type", 13);
            } else {
                aqVar.ai("obj_type", i);
            }
            aqVar.dD(TiebaInitialize.Params.OBJ_TO, aw(bwVar));
            if (bVar.iqW >= 0) {
                aqVar.ai("tab_id", bVar.iqW);
            }
            if (bwVar.dZb >= 0) {
                aqVar.ai("obj_floor", bwVar.dZb);
            }
            aqVar.ai("thread_type", bwVar.getType() == bw.ebx ? 2 : 1);
            TiebaStatic.log(aqVar);
            if (bwVar.bdk()) {
                aq aqVar2 = new aq("c12098");
                aqVar2.dD("fid", bVar.iqV);
                aqVar2.ai("obj_locate", a(bVar));
                aqVar2.dD("obj_source", bwVar.mRecomSource);
                aqVar2.dD(TiebaInitialize.Params.OBJ_PARAM2, bwVar.mRecomWeight);
                aqVar2.dD("obj_param1", bwVar.mRecomAbTag);
                aqVar2.dD(TiebaInitialize.Params.OBJ_PARAM3, bwVar.edk);
                aqVar2.dD("tid", bwVar.getTid());
                aqVar2.ai("obj_type", i);
                aqVar2.dD(TiebaInitialize.Params.OBJ_TO, aw(bwVar));
                TiebaStatic.log(aqVar2);
            }
            if (bVar.iqW == 501) {
                aq aqVar3 = new aq("c13260");
                aqVar3.dD("fid", bVar.iqV);
                aqVar3.dD("tid", bwVar.getTid());
                s.cbX().e(aqVar3);
            }
            if (bwVar.beE() != null && bwVar.beE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.beE().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    aq aqVar4 = new aq("c11850");
                    aqVar4.dD("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.iqY > 0) {
            if (bVar.iqW == 1120 || bVar.iqW == 1121) {
                return 15;
            }
            if (bVar.iqZ == 3) {
                return 13;
            }
            return bVar.iqY;
        }
        int i = bVar.iqU;
        if (i == 8) {
            i = 9;
        }
        if (bVar.iqW == 504) {
            i = 11;
        }
        if (bVar.iqW == 1120 || bVar.iqW == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            aq ai = new aq("c11440").dD("fid", frsViewData.getForum().getId()).ai("obj_locate", i).ai("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, ai);
            }
            TiebaStatic.log(ai);
        }
    }

    private String aw(bw bwVar) {
        return bwVar.edn ? String.valueOf(bwVar.bfS()) : String.valueOf(4);
    }
}
