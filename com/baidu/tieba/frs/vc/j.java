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
    private boolean hRr;
    private CustomMessageListener hRy;
    private boolean iQJ;
    private HashMap<Integer, ad> iQK;
    private final CustomMessageListener iQL;
    private final CustomMessageListener iQM;
    private final CustomMessageListener iQN;
    private final CustomMessageListener iQO;
    private au iQP;
    private com.baidu.tieba.frs.smartsort.a ipt;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.iQJ = false;
        this.hRr = false;
        this.hRy = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.hRr = false;
                        return;
                    }
                    j.this.hRr = true;
                    j.this.iKB.csB().cAM();
                }
            }
        };
        this.iQL = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.ioW != null) {
                    j.this.ioW.startPullRefresh();
                }
            }
        };
        this.iQM = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    j.this.ioW.bKf();
                    ad adVar = (ad) customResponsedMessage.getData();
                    if (adVar.itj != null) {
                        j.this.a(adVar.tabId, adVar.itj);
                    } else if (adVar.tabId == 1) {
                        j.this.a(adVar.tabId, j.this.iQP);
                    } else {
                        j.this.a(adVar.tabId, (au) null);
                    }
                    j.this.zV(adVar.tabId);
                }
            }
        };
        this.iQN = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    ad adVar = (ad) customResponsedMessage.getData();
                    j.this.U(adVar.tabId, adVar.eGO);
                }
            }
        };
        this.iQO = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    v vVar = (v) customResponsedMessage.getData();
                    j.this.V(vVar.tabId, vVar.fzJ);
                }
            }
        };
        this.iQP = new au() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.au
            public void boi() {
                j.this.iQJ = true;
                if (j.this.ioW != null && j.this.iLM != null && j.this.ipq != null && j.this.iKB != null && j.this.iKB.isAdded()) {
                    if (j.this.ioW != null && j.this.ioW.ctG() != null) {
                        j.this.ioW.ctG().cEF();
                    }
                    j.this.iKB.oT(false);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.ioW.ctx() != null && j.this.iLM != null && j.this.ioW.ctx().getVisibility() != 0) {
                                j.this.iLM.bzy();
                            }
                        }
                    }, 110L);
                    j.this.ioW.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.iKB.refresh();
                        j.this.iKB.oT(true);
                    } else {
                        j.this.iKB.csG();
                    }
                    TiebaStatic.log(new aq("c11749").dK("fid", j.this.iKB.getFid()).dK("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.au
            public void boj() {
                if (j.this.iKB != null && j.this.iKB.isAdded()) {
                    if (j.this.iQJ && j.this.iKB.csB() != null) {
                        if (!j.this.hRr) {
                            j.this.iKB.csB().cAL();
                        }
                        j.this.iQJ = false;
                    }
                    if (j.this.ipt != null && j.this.iKB.csD() != null && j.this.iKB.csD().ctI() != null && !j.this.iKB.csD().ctI().czX()) {
                        j.this.ipt.czd();
                    }
                    if (j.this.ioW != null && j.this.iLM != null && j.this.ipq != null && j.this.ipt != null) {
                        j.this.ioW.ctG().a(0, 0, true, true);
                        j.this.iKB.csS();
                        j.this.iKB.oT(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.iKB.csD() != null) {
                            j.this.iKB.csD().Q(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.iKB.boH().getVisibility() != 0 || y.isEmpty(j.this.iKB.cth().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.ipt = frsFragment.csx();
        this.iQK = new HashMap<>();
        this.ioW.yp(1);
        frsFragment.registerListener(this.iQL);
        frsFragment.registerListener(this.iQM);
        frsFragment.registerListener(this.iQN);
        frsFragment.registerListener(this.iQO);
        frsFragment.registerListener(this.hRy);
    }

    public void cAv() {
        if (this.ioW != null) {
            if ((this.iLL instanceof FrsTabViewController) && ((FrsTabViewController) this.iLL).cAK() != null && (((FrsTabViewController) this.iLL).cAK().fragment instanceof au)) {
                FrsTabViewController.b cAK = ((FrsTabViewController) this.iLL).cAK();
                a(cAK.tabId, (au) cAK.fragment);
                zV(cAK.tabId);
                return;
            }
            this.ioW.a(this.iQP);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hRy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        ad adVar;
        if (this.ioW != null && (adVar = this.iQK.get(Integer.valueOf(i))) != null) {
            this.ioW.yp(i);
            this.ioW.a(adVar.itj);
            this.ioW.pc(adVar.eGO);
            if (adVar.itj == null) {
                this.ioW.pc(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar) {
        ad adVar = this.iQK.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.itj = auVar;
            this.iQK.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.itj = auVar;
        }
        if (this.ioW != null) {
            this.ioW.a(auVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        ad adVar = this.iQK.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.eGO = z;
            this.iQK.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.eGO = z;
        }
        if (this.ioW != null) {
            this.ioW.pc(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.ioW != null) {
            this.ioW.Q(i, z);
        }
    }
}
