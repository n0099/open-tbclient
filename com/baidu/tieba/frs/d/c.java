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
    public static int jtY;
    private static c jub;
    private a jtZ;
    private SparseArray<HashSet<String>> jua;
    private CustomMessageListener eCA = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && c.this.jua != null) {
                c.this.jua.clear();
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
                        aVar.jue = false;
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
        public long jud;
        public boolean jue;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.jue = false;
        }
    }

    public c() {
        jtY = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.eCA);
    }

    public static c cJI() {
        if (jub == null) {
            synchronized (t.class) {
                if (jub == null) {
                    jub = new c();
                }
            }
        }
        return jub;
    }

    private boolean cJJ() {
        if (this.jtZ == null) {
            this.jtZ = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.jtZ.jue) {
            return true;
        }
        if (this.jtZ.isRunning) {
            this.jtZ.count++;
            if (currentTimeMillis - this.jtZ.jud < 120000) {
                if (this.jtZ.count >= jtY) {
                    this.jtZ.jue = true;
                    a(this.jtZ);
                    return true;
                }
            } else {
                this.jtZ.isRunning = false;
                this.jtZ.count = 0;
            }
        } else {
            this.jtZ.isRunning = true;
            this.jtZ.jud = currentTimeMillis;
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
                t.csh().e(new ar("c11662").al("obj_param1", 1).dY("post_id", byVar.getTid()));
            }
        }
    }

    public void a(by byVar, boolean z) {
        if (byVar != null) {
            t.csh().e(new ar("c12125").dY("tid", byVar.getId()).al("obj_locate", z ? 2 : 1).w("obj_id", byVar.bpj() != null ? byVar.bpj().live_id : -1L).al("obj_type", 1));
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
            t.csh().e(arVar);
        }
    }

    public void a(b bVar, by byVar) {
        if (bVar != null && bVar.jtR && byVar != null && byVar.getTid() != null) {
            if (this.jua == null) {
                this.jua = new SparseArray<>();
            }
            if (this.jua.get(bVar.jtU) == null) {
                this.jua.put(bVar.jtU, new HashSet<>());
            }
            HashSet<String> hashSet = this.jua.get(bVar.jtU);
            String tid = byVar.getTid();
            if (bVar.jtV >= 0) {
                tid = tid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.jtV;
            }
            if (!hashSet.contains(tid) && !cJJ()) {
                hashSet.add(tid);
                ar arVar = new ar("c11439");
                arVar.dY("fid", bVar.jtT);
                arVar.al("obj_locate", a(bVar));
                arVar.dY("obj_source", byVar.mRecomSource);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, byVar.mRecomWeight);
                arVar.dY("obj_param1", byVar.mRecomAbTag);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM3, byVar.eLn);
                arVar.dY("tid", byVar.getTid());
                arVar.dY("nid", byVar.getNid());
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
                if (bVar.jtU >= 0) {
                    arVar.al("tab_id", bVar.jtU);
                }
                if (byVar.eHa >= 0) {
                    arVar.al("obj_floor", byVar.eHa);
                }
                boolean z = (byVar.bqu() == null || (byVar.bqu().dPj() == null && byVar.bqu().bIK() == null)) ? false : true;
                if (z && byVar.bqu().dPj() != null && byVar.bqu().dPj().bIC() != null && byVar.bqu().dPj().bIC().size() > 0) {
                    arVar.al("obj_name", byVar.bqu().nmp ? 3 : 2);
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
                t.csh().e(arVar);
                if (byVar.bnv()) {
                    ar arVar2 = new ar("c12099");
                    arVar2.dY("fid", bVar.jtT);
                    arVar2.al("obj_locate", a(bVar));
                    arVar2.dY("obj_source", byVar.mRecomSource);
                    arVar2.dY(TiebaInitialize.Params.OBJ_PARAM2, byVar.mRecomWeight);
                    arVar2.dY("obj_param1", byVar.mRecomAbTag);
                    arVar2.dY(TiebaInitialize.Params.OBJ_PARAM3, byVar.eLn);
                    arVar2.dY("tid", byVar.getTid());
                    arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    t.csh().e(arVar2);
                }
                if (bVar.jtU == 501) {
                    ar arVar3 = new ar("c13259");
                    arVar3.dY("fid", bVar.jtT);
                    arVar3.dY("tid", byVar.getTid());
                    t.csh().e(arVar3);
                }
            }
        }
    }

    public void a(b bVar, by byVar, int i) {
        if (bVar != null && bVar.jtR && byVar != null && byVar.getTid() != null) {
            t.csh().oX(true);
            ar arVar = new ar("c11438");
            arVar.dY("fid", bVar.jtT);
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
            if (bVar.jtU >= 0) {
                arVar.al("tab_id", bVar.jtU);
            }
            if (byVar.eHa >= 0) {
                arVar.al("obj_floor", byVar.eHa);
            }
            arVar.al("thread_type", byVar.getType() == by.eJA ? 2 : 1);
            TiebaStatic.log(arVar);
            if (byVar.bnv()) {
                ar arVar2 = new ar("c12098");
                arVar2.dY("fid", bVar.jtT);
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
            if (bVar.jtU == 501) {
                ar arVar3 = new ar("c13260");
                arVar3.dY("fid", bVar.jtT);
                arVar3.dY("tid", byVar.getTid());
                t.csh().e(arVar3);
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
        if (bVar.jtW > 0) {
            if (bVar.jtU == 1120 || bVar.jtU == 1121) {
                return 15;
            }
            if (bVar.jtX == 3) {
                return 13;
            }
            return bVar.jtW;
        }
        int i = bVar.jtS;
        if (i == 8) {
            i = 9;
        }
        if (bVar.jtU == 504) {
            i = 11;
        }
        if (bVar.jtU == 1120 || bVar.jtU == 1121) {
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
