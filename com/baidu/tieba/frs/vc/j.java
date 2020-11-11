package com.baidu.tieba.frs.vc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private com.baidu.tieba.frs.smartsort.a iHM;
    private boolean ijP;
    private CustomMessageListener ijW;
    private boolean jjd;
    private HashMap<Integer, ad> jje;
    private final CustomMessageListener jjf;
    private final CustomMessageListener jjg;
    private final CustomMessageListener jjh;
    private final CustomMessageListener jji;
    private au jjj;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jjd = false;
        this.ijP = false;
        this.ijW = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.ijP = false;
                        return;
                    }
                    j.this.ijP = true;
                    j.this.jcU.cyj().cGu();
                }
            }
        };
        this.jjf = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.iHp != null) {
                    j.this.iHp.startPullRefresh();
                }
            }
        };
        this.jjg = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    j.this.iHp.bPh();
                    ad adVar = (ad) customResponsedMessage.getData();
                    if (adVar.iLC != null) {
                        j.this.a(adVar.tabId, adVar.iLC);
                    } else if (adVar.tabId == 1) {
                        j.this.a(adVar.tabId, j.this.jjj);
                    } else {
                        j.this.a(adVar.tabId, (au) null);
                    }
                    j.this.AB(adVar.tabId);
                }
            }
        };
        this.jjh = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    ad adVar = (ad) customResponsedMessage.getData();
                    j.this.U(adVar.tabId, adVar.eUZ);
                }
            }
        };
        this.jji = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    v vVar = (v) customResponsedMessage.getData();
                    j.this.V(vVar.tabId, vVar.fNU);
                }
            }
        };
        this.jjj = new au() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.au
            public void bsB() {
                j.this.jjd = true;
                if (j.this.iHp != null && j.this.jef != null && j.this.iHJ != null && j.this.jcU != null && j.this.jcU.isAdded()) {
                    if (j.this.iHp != null && j.this.iHp.czo() != null) {
                        j.this.iHp.czo().cKn();
                    }
                    j.this.jcU.pu(false);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.iHp.czf() != null && j.this.jef != null && j.this.iHp.czf().getVisibility() != 0) {
                                j.this.jef.bDQ();
                            }
                        }
                    }, 110L);
                    j.this.iHp.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.jcU.refresh();
                        j.this.jcU.pu(true);
                    } else {
                        j.this.jcU.cyo();
                    }
                    TiebaStatic.log(new aq("c11749").dR("fid", j.this.jcU.getFid()).dR("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.au
            public void bsC() {
                if (j.this.jcU != null && j.this.jcU.isAdded()) {
                    if (j.this.jjd && j.this.jcU.cyj() != null) {
                        if (!j.this.ijP) {
                            j.this.jcU.cyj().cGt();
                        }
                        j.this.jjd = false;
                    }
                    if (j.this.iHM != null && j.this.jcU.cyl() != null && j.this.jcU.cyl().czq() != null && !j.this.jcU.cyl().czq().cFF()) {
                        j.this.iHM.cEL();
                    }
                    if (j.this.iHp != null && j.this.jef != null && j.this.iHJ != null && j.this.iHM != null) {
                        j.this.iHp.czo().a(0, 0, true, true);
                        j.this.jcU.cyA();
                        j.this.jcU.pu(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.jcU.cyl() != null) {
                            j.this.jcU.cyl().Q(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.jcU.bta().getVisibility() != 0 || y.isEmpty(j.this.jcU.cyP().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.iHM = frsFragment.cyf();
        this.jje = new HashMap<>();
        this.iHp.yV(1);
        frsFragment.registerListener(this.jjf);
        frsFragment.registerListener(this.jjg);
        frsFragment.registerListener(this.jjh);
        frsFragment.registerListener(this.jji);
        frsFragment.registerListener(this.ijW);
    }

    public void cGd() {
        if (this.iHp != null) {
            if ((this.jee instanceof FrsTabViewController) && ((FrsTabViewController) this.jee).cGs() != null && (((FrsTabViewController) this.jee).cGs().fragment instanceof au)) {
                FrsTabViewController.b cGs = ((FrsTabViewController) this.jee).cGs();
                a(cGs.tabId, (au) cGs.fragment);
                AB(cGs.tabId);
                return;
            }
            this.iHp.a(this.jjj);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.ijW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AB(int i) {
        ad adVar;
        if (this.iHp != null && (adVar = this.jje.get(Integer.valueOf(i))) != null) {
            this.iHp.yV(i);
            this.iHp.a(adVar.iLC);
            this.iHp.pD(adVar.eUZ);
            if (adVar.iLC == null) {
                this.iHp.pD(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar) {
        ad adVar = this.jje.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.iLC = auVar;
            this.jje.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.iLC = auVar;
        }
        if (this.iHp != null) {
            this.iHp.a(auVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        ad adVar = this.jje.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.eUZ = z;
            this.jje.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.eUZ = z;
        }
        if (this.iHp != null) {
            this.iHp.pD(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.iHp != null) {
            this.iHp.Q(i, z);
        }
    }
}
