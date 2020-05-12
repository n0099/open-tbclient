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
    private com.baidu.tieba.frs.smartsort.a gYQ;
    private final CustomMessageListener hxA;
    private final CustomMessageListener hxB;
    private final CustomMessageListener hxC;
    private an hxD;
    private boolean hxx;
    private HashMap<Integer, y> hxy;
    private final CustomMessageListener hxz;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.hxx = false;
        this.hxz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.gYw != null) {
                    j.this.gYw.startPullRefresh();
                }
            }
        };
        this.hxA = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                    j.this.gYw.blx();
                    y yVar = (y) customResponsedMessage.getData();
                    if (yVar.hbT != null) {
                        j.this.a(yVar.tabId, yVar.hbT);
                    } else if (yVar.tabId == 1) {
                        j.this.a(yVar.tabId, j.this.hxD);
                    } else {
                        j.this.a(yVar.tabId, (an) null);
                    }
                    j.this.uS(yVar.tabId);
                }
            }
        };
        this.hxB = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                    y yVar = (y) customResponsedMessage.getData();
                    j.this.K(yVar.tabId, yVar.dGR);
                }
            }
        };
        this.hxC = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    j.this.L(sVar.tabId, sVar.etP);
                }
            }
        };
        this.hxD = new an() { // from class: com.baidu.tieba.frs.vc.j.5
            @Override // com.baidu.tieba.frs.an
            public void aQk() {
                j.this.hxx = true;
                if (j.this.gYw != null && j.this.hsC != null && j.this.gYN != null && j.this.hro != null && j.this.hro.isAdded()) {
                    if (j.this.gYw != null && j.this.gYw.bPu() != null) {
                        j.this.gYw.bPu().bZe();
                    }
                    j.this.hro.mr(false);
                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.gYw.bPl() != null && j.this.hsC != null && j.this.gYw.bPl().getVisibility() != 0) {
                                j.this.hsC.bay();
                            }
                        }
                    }, 110L);
                    j.this.gYw.H(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.hro.refresh();
                        j.this.hro.mr(true);
                    } else {
                        j.this.hro.bOz();
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11749").cI("fid", j.this.hro.getFid()).cI("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.an
            public void aQl() {
                if (j.this.hro != null && j.this.hro.isAdded()) {
                    if (j.this.hxx && j.this.hro.bOu() != null) {
                        j.this.hro.bOu().bVR();
                        j.this.hxx = false;
                    }
                    if (j.this.gYQ != null && j.this.hro.bOw() != null && j.this.hro.bOw().bPw() != null && !j.this.hro.bOw().bPw().bVh()) {
                        j.this.gYQ.bUp();
                    }
                    if (j.this.gYw != null && j.this.hsC != null && j.this.gYN != null && j.this.gYQ != null) {
                        j.this.gYw.bPu().a(0, 0, true, true);
                        j.this.hro.bOK();
                        j.this.hro.mr(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.hro.bOw() != null) {
                            j.this.hro.bOw().H(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.hro.aQF().getVisibility() != 0 || v.isEmpty(j.this.hro.bOX().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.gYQ = frsFragment.bOq();
        this.hxy = new HashMap<>();
        this.gYw.tr(1);
        frsFragment.registerListener(this.hxz);
        frsFragment.registerListener(this.hxA);
        frsFragment.registerListener(this.hxB);
        frsFragment.registerListener(this.hxC);
    }

    public void bVD() {
        if (this.gYw != null) {
            this.gYw.a(this.hxD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        y yVar;
        if (this.gYw != null && (yVar = this.hxy.get(Integer.valueOf(i))) != null) {
            this.gYw.tr(i);
            this.gYw.a(yVar.hbT);
            this.gYw.mA(yVar.dGR);
            if (yVar.hbT == null) {
                this.gYw.mA(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, an anVar) {
        y yVar = this.hxy.get(Integer.valueOf(i));
        if (yVar == null) {
            y yVar2 = new y();
            yVar2.tabId = i;
            yVar2.hbT = anVar;
            this.hxy.put(Integer.valueOf(i), yVar2);
        } else {
            yVar.hbT = anVar;
        }
        if (this.gYw != null) {
            this.gYw.a(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, boolean z) {
        y yVar = this.hxy.get(Integer.valueOf(i));
        if (yVar == null) {
            y yVar2 = new y();
            yVar2.tabId = i;
            yVar2.dGR = z;
            this.hxy.put(Integer.valueOf(i), yVar2);
        } else {
            yVar.dGR = z;
        }
        if (this.gYw != null) {
            this.gYw.mA(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, boolean z) {
        if (this.gYw != null) {
            this.gYw.H(i, z);
        }
    }
}
