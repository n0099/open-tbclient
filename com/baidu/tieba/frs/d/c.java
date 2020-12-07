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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.HashSet;
/* loaded from: classes22.dex */
public class c {
    public static int jtW;
    private static c jtZ;
    private a jtX;
    private SparseArray<HashSet<String>> jtY;
    private CustomMessageListener eCA = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.jtY != null) {
                c.this.jtY.clear();
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
                        aVar.juc = false;
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
        public long jub;
        public boolean juc;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.juc = false;
        }
    }

    public c() {
        jtW = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.eCA);
    }

    public static c cJH() {
        if (jtZ == null) {
            synchronized (t.class) {
                if (jtZ == null) {
                    jtZ = new c();
                }
            }
        }
        return jtZ;
    }

    private boolean cJI() {
        if (this.jtX == null) {
            this.jtX = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jtX.juc) {
            return true;
        }
        if (this.jtX.isRunning) {
            this.jtX.count++;
            if (currentTimeMillis - this.jtX.jub < 120000) {
                if (this.jtX.count >= jtW) {
                    this.jtX.juc = true;
                    a(this.jtX);
                    return true;
                }
            } else {
                this.jtX.isRunning = false;
                this.jtX.count = 0;
            }
        } else {
            this.jtX.isRunning = true;
            this.jtX.jub = currentTimeMillis;
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

    public void a(by byVar, HashSet<String> hashSet) {
        if (byVar != null && byVar.bou()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (byVar.getTid() != null && !hashSet.contains(byVar.getTid())) {
                hashSet.add(byVar.getTid());
                t.csg().e(new ar("c11662").al("obj_param1", 1).dY("post_id", byVar.getTid()));
            }
        }
    }

    public void a(by byVar, boolean z) {
        if (byVar != null) {
            t.csg().e(new ar("c12125").dY("tid", byVar.getId()).al("obj_locate", z ? 2 : 1).w("obj_id", byVar.bpj() != null ? byVar.bpj().live_id : -1L).al("obj_type", 1));
        }
    }

    public void ay(by byVar) {
        if (byVar != null && byVar.bqa()) {
            ar arVar = new ar("c11717");
            arVar.w("fid", byVar.getFid());
            arVar.dY("obj_source", byVar.mRecomSource);
            arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, byVar.mRecomWeight);
            arVar.dY("obj_param1", byVar.eLn);
            arVar.al("obj_locate", 1);
            arVar.dY("tid", byVar.getTid());
            t.csg().e(arVar);
        }
    }

    public void a(b bVar, by byVar) {
        if (bVar != null && bVar.jtP && byVar != null && byVar.getTid() != null) {
            if (this.jtY == null) {
                this.jtY = new SparseArray<>();
            }
            if (this.jtY.get(bVar.jtS) == null) {
                this.jtY.put(bVar.jtS, new HashSet<>());
            }
            HashSet<String> hashSet = this.jtY.get(bVar.jtS);
            String tid = byVar.getTid();
            if (bVar.jtT >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.jtT;
            }
            if (!hashSet.contains(tid) && !cJI()) {
                hashSet.add(tid);
                ar arVar = new ar("c11439");
                arVar.dY("fid", bVar.jtR);
                arVar.al("obj_locate", a(bVar));
                arVar.dY("obj_source", byVar.mRecomSource);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, byVar.mRecomWeight);
                arVar.dY("obj_param1", byVar.mRecomAbTag);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM3, byVar.eLn);
                arVar.dY("tid", byVar.getTid());
                arVar.dY("nid", byVar.getNid());
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.jtS >= 0) {
                    arVar.al("tab_id", bVar.jtS);
                }
                if (byVar.eHa >= 0) {
                    arVar.al("obj_floor", byVar.eHa);
                }
                boolean z = (byVar.bqu() == null || (byVar.bqu().dPi() == null && byVar.bqu().bIK() == null)) ? false : true;
                if (z && byVar.bqu().dPi() != null && byVar.bqu().dPi().bIC() != null && byVar.bqu().dPi().bIC().size() > 0) {
                    arVar.al("obj_name", byVar.bqu().nmn ? 3 : 2);
                } else {
                    arVar.al("obj_name", z ? 1 : 0);
                }
                boolean z2 = byVar.getType() == by.eJA;
                arVar.al("thread_type", z2 ? 2 : 1);
                if (z2 && byVar.boP() != null && !StringUtils.isNull(byVar.boP().getName_show())) {
                    arVar.dY("obj_name", byVar.boP().getName_show());
                }
                if (byVar.bny() || byVar.bqN()) {
                    arVar.al("obj_type", 14);
                } else if (byVar.bnx()) {
                    arVar.al("obj_type", 13);
                }
                t.csg().e(arVar);
                if (byVar.bnv()) {
                    ar arVar2 = new ar("c12099");
                    arVar2.dY("fid", bVar.jtR);
                    arVar2.al("obj_locate", a(bVar));
                    arVar2.dY("obj_source", byVar.mRecomSource);
                    arVar2.dY(TiebaInitialize.Params.OBJ_PARAM2, byVar.mRecomWeight);
                    arVar2.dY("obj_param1", byVar.mRecomAbTag);
                    arVar2.dY(TiebaInitialize.Params.OBJ_PARAM3, byVar.eLn);
                    arVar2.dY("tid", byVar.getTid());
                    arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    t.csg().e(arVar2);
                }
                if (bVar.jtS == 501) {
                    ar arVar3 = new ar("c13259");
                    arVar3.dY("fid", bVar.jtR);
                    arVar3.dY("tid", byVar.getTid());
                    t.csg().e(arVar3);
                }
            }
        }
    }

    public void a(b bVar, by byVar, int i) {
        if (bVar != null && bVar.jtP && byVar != null && byVar.getTid() != null) {
            t.csg().oX(true);
            ar arVar = new ar("c11438");
            arVar.dY("fid", bVar.jtR);
            arVar.al("obj_locate", a(bVar));
            arVar.dY("obj_source", byVar.mRecomSource);
            arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, byVar.mRecomWeight);
            arVar.dY("obj_param1", byVar.mRecomAbTag);
            arVar.dY(TiebaInitialize.Params.OBJ_PARAM3, byVar.eLn);
            arVar.dY("tid", byVar.getTid());
            arVar.dY("nid", byVar.getNid());
            if (byVar.bny() || byVar.bqN()) {
                arVar.al("obj_type", 14);
            } else if (byVar.bnx()) {
                arVar.al("obj_type", 13);
            } else {
                arVar.al("obj_type", i);
            }
            arVar.dY(TiebaInitialize.Params.OBJ_TO, az(byVar));
            if (bVar.jtS >= 0) {
                arVar.al("tab_id", bVar.jtS);
            }
            if (byVar.eHa >= 0) {
                arVar.al("obj_floor", byVar.eHa);
            }
            arVar.al("thread_type", byVar.getType() == by.eJA ? 2 : 1);
            TiebaStatic.log(arVar);
            if (byVar.bnv()) {
                ar arVar2 = new ar("c12098");
                arVar2.dY("fid", bVar.jtR);
                arVar2.al("obj_locate", a(bVar));
                arVar2.dY("obj_source", byVar.mRecomSource);
                arVar2.dY(TiebaInitialize.Params.OBJ_PARAM2, byVar.mRecomWeight);
                arVar2.dY("obj_param1", byVar.mRecomAbTag);
                arVar2.dY(TiebaInitialize.Params.OBJ_PARAM3, byVar.eLn);
                arVar2.dY("tid", byVar.getTid());
                arVar2.al("obj_type", i);
                arVar2.dY(TiebaInitialize.Params.OBJ_TO, az(byVar));
                TiebaStatic.log(arVar2);
            }
            if (bVar.jtS == 501) {
                ar arVar3 = new ar("c13260");
                arVar3.dY("fid", bVar.jtR);
                arVar3.dY("tid", byVar.getTid());
                t.csg().e(arVar3);
            }
            if (byVar.boP() != null && byVar.boP().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = byVar.boP().getAlaUserData();
                if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                    ar arVar4 = new ar("c11850");
                    arVar4.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar4);
                }
            }
        }
    }

    public int a(b bVar) {
        if (bVar == null) {
            return 5;
        }
        if (bVar.jtU > 0) {
            if (bVar.jtS == 1120 || bVar.jtS == 1121) {
                return 15;
            }
            if (bVar.jtV == 3) {
                return 13;
            }
            return bVar.jtU;
        }
        int i = bVar.jtQ;
        if (i == 8) {
            i = 9;
        }
        if (bVar.jtS == 504) {
            i = 11;
        }
        if (bVar.jtS == 1120 || bVar.jtS == 1121) {
            i = 15;
        }
        return i;
    }

    public static void a(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            ar al = new ar("c11440").dY("fid", frsViewData.getForum().getId()).al("obj_locate", i).al("obj_type", i2);
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, al);
            }
            TiebaStatic.log(al);
        }
    }

    private String az(by byVar) {
        return byVar.eLq ? String.valueOf(byVar.bqf()) : String.valueOf(4);
    }
}
