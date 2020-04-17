package com.baidu.tieba.frs.vc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.y;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private com.baidu.tieba.frs.smartsort.a gYK;
    private boolean hxr;
    private HashMap<Integer, y> hxs;
    private final CustomMessageListener hxt;
    private final CustomMessageListener hxu;
    private final CustomMessageListener hxv;
    private final CustomMessageListener hxw;
    private an hxx;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.hxr = false;
        this.hxt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.gYq != null) {
                    j.this.gYq.startPullRefresh();
                }
            }
        };
        this.hxu = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                    j.this.gYq.blz();
                    y yVar = (y) customResponsedMessage.getData();
                    if (yVar.hbN != null) {
                        j.this.a(yVar.tabId, yVar.hbN);
                    } else if (yVar.tabId == 1) {
                        j.this.a(yVar.tabId, j.this.hxx);
                    } else {
                        j.this.a(yVar.tabId, (an) null);
                    }
                    j.this.uS(yVar.tabId);
                }
            }
        };
        this.hxv = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                    y yVar = (y) customResponsedMessage.getData();
                    j.this.K(yVar.tabId, yVar.dGN);
                }
            }
        };
        this.hxw = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    j.this.L(sVar.tabId, sVar.etK);
                }
            }
        };
        this.hxx = new an() { // from class: com.baidu.tieba.frs.vc.j.5
            @Override // com.baidu.tieba.frs.an
            public void aQn() {
                j.this.hxr = true;
                if (j.this.gYq != null && j.this.hsw != null && j.this.gYH != null && j.this.hri != null && j.this.hri.isAdded()) {
                    if (j.this.gYq != null && j.this.gYq.bPv() != null) {
                        j.this.gYq.bPv().bZf();
                    }
                    j.this.hri.mr(false);
                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.gYq.bPm() != null && j.this.hsw != null && j.this.gYq.bPm().getVisibility() != 0) {
                                j.this.hsw.baA();
                            }
                        }
                    }, 110L);
                    j.this.gYq.H(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.hri.refresh();
                        j.this.hri.mr(true);
                    } else {
                        j.this.hri.bOA();
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11749").cI("fid", j.this.hri.getFid()).cI("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.an
            public void aQo() {
                if (j.this.hri != null && j.this.hri.isAdded()) {
                    if (j.this.hxr && j.this.hri.bOv() != null) {
                        j.this.hri.bOv().bVS();
                        j.this.hxr = false;
                    }
                    if (j.this.gYK != null && j.this.hri.bOx() != null && j.this.hri.bOx().bPx() != null && !j.this.hri.bOx().bPx().bVi()) {
                        j.this.gYK.bUq();
                    }
                    if (j.this.gYq != null && j.this.hsw != null && j.this.gYH != null && j.this.gYK != null) {
                        j.this.gYq.bPv().a(0, 0, true, true);
                        j.this.hri.bOL();
                        j.this.hri.mr(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.hri.bOx() != null) {
                            j.this.hri.bOx().H(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.hri.aQI().getVisibility() != 0 || v.isEmpty(j.this.hri.bOY().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.gYK = frsFragment.bOr();
        this.hxs = new HashMap<>();
        this.gYq.tr(1);
        frsFragment.registerListener(this.hxt);
        frsFragment.registerListener(this.hxu);
        frsFragment.registerListener(this.hxv);
        frsFragment.registerListener(this.hxw);
    }

    public void bVE() {
        if (this.gYq != null) {
            this.gYq.a(this.hxx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        y yVar;
        if (this.gYq != null && (yVar = this.hxs.get(Integer.valueOf(i))) != null) {
            this.gYq.tr(i);
            this.gYq.a(yVar.hbN);
            this.gYq.mA(yVar.dGN);
            if (yVar.hbN == null) {
                this.gYq.mA(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, an anVar) {
        y yVar = this.hxs.get(Integer.valueOf(i));
        if (yVar == null) {
            y yVar2 = new y();
            yVar2.tabId = i;
            yVar2.hbN = anVar;
            this.hxs.put(Integer.valueOf(i), yVar2);
        } else {
            yVar.hbN = anVar;
        }
        if (this.gYq != null) {
            this.gYq.a(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, boolean z) {
        y yVar = this.hxs.get(Integer.valueOf(i));
        if (yVar == null) {
            y yVar2 = new y();
            yVar2.tabId = i;
            yVar2.dGN = z;
            this.hxs.put(Integer.valueOf(i), yVar2);
        } else {
            yVar.dGN = z;
        }
        if (this.gYq != null) {
            this.gYq.mA(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, boolean z) {
        if (this.gYq != null) {
            this.gYq.H(i, z);
        }
    }
}
