package com.baidu.tieba.frs.vc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import java.util.HashMap;
/* loaded from: classes21.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private com.baidu.tieba.frs.smartsort.a iIA;
    private boolean ikD;
    private CustomMessageListener ikK;
    private boolean jjO;
    private HashMap<Integer, ad> jjP;
    private final CustomMessageListener jjQ;
    private final CustomMessageListener jjR;
    private final CustomMessageListener jjS;
    private final CustomMessageListener jjT;
    private au jjU;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jjO = false;
        this.ikD = false;
        this.ikK = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.ikD = false;
                        return;
                    }
                    j.this.ikD = true;
                    j.this.jdH.cxM().cFZ();
                }
            }
        };
        this.jjQ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.iId != null) {
                    j.this.iId.startPullRefresh();
                }
            }
        };
        this.jjR = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    j.this.iId.bOA();
                    ad adVar = (ad) customResponsedMessage.getData();
                    if (adVar.iMp != null) {
                        j.this.a(adVar.tabId, adVar.iMp);
                    } else if (adVar.tabId == 1) {
                        j.this.a(adVar.tabId, j.this.jjU);
                    } else {
                        j.this.a(adVar.tabId, (au) null);
                    }
                    j.this.AZ(adVar.tabId);
                }
            }
        };
        this.jjS = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    ad adVar = (ad) customResponsedMessage.getData();
                    j.this.U(adVar.tabId, adVar.eUh);
                }
            }
        };
        this.jjT = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    v vVar = (v) customResponsedMessage.getData();
                    j.this.V(vVar.tabId, vVar.fNx);
                }
            }
        };
        this.jjU = new au() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.au
            public void brR() {
                j.this.jjO = true;
                if (j.this.iId != null && j.this.jeS != null && j.this.iIx != null && j.this.jdH != null && j.this.jdH.isAdded()) {
                    if (j.this.iId != null && j.this.iId.cyR() != null) {
                        j.this.iId.cyR().cJS();
                    }
                    j.this.jdH.px(false);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.iId.cyI() != null && j.this.jeS != null && j.this.iId.cyI().getVisibility() != 0) {
                                j.this.jeS.bDh();
                            }
                        }
                    }, 110L);
                    j.this.iId.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.jdH.refresh();
                        j.this.jdH.px(true);
                    } else {
                        j.this.jdH.cxR();
                    }
                    TiebaStatic.log(new ar("c11749").dR("fid", j.this.jdH.getFid()).dR("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.au
            public void brS() {
                if (j.this.jdH != null && j.this.jdH.isAdded()) {
                    if (j.this.jjO && j.this.jdH.cxM() != null) {
                        if (!j.this.ikD) {
                            j.this.jdH.cxM().cFY();
                        }
                        j.this.jjO = false;
                    }
                    if (j.this.iIA != null && j.this.jdH.cxO() != null && j.this.jdH.cxO().cyT() != null && !j.this.jdH.cxO().cyT().cFk()) {
                        j.this.iIA.cEq();
                    }
                    if (j.this.iId != null && j.this.jeS != null && j.this.iIx != null && j.this.iIA != null) {
                        j.this.iId.cyR().a(0, 0, true, true);
                        j.this.jdH.cyd();
                        j.this.jdH.px(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.jdH.cxO() != null) {
                            j.this.jdH.cxO().Q(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.jdH.bsq().getVisibility() != 0 || y.isEmpty(j.this.jdH.cys().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.iIA = frsFragment.cxI();
        this.jjP = new HashMap<>();
        this.iId.zt(1);
        frsFragment.registerListener(this.jjQ);
        frsFragment.registerListener(this.jjR);
        frsFragment.registerListener(this.jjS);
        frsFragment.registerListener(this.jjT);
        frsFragment.registerListener(this.ikK);
    }

    public void cFI() {
        if (this.iId != null) {
            if ((this.jeR instanceof FrsTabViewController) && ((FrsTabViewController) this.jeR).cFX() != null && (((FrsTabViewController) this.jeR).cFX().fragment instanceof au)) {
                FrsTabViewController.b cFX = ((FrsTabViewController) this.jeR).cFX();
                a(cFX.tabId, (au) cFX.fragment);
                AZ(cFX.tabId);
                return;
            }
            this.iId.a(this.jjU);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.ikK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ(int i) {
        ad adVar;
        if (this.iId != null && (adVar = this.jjP.get(Integer.valueOf(i))) != null) {
            this.iId.zt(i);
            this.iId.a(adVar.iMp);
            this.iId.pG(adVar.eUh);
            if (adVar.iMp == null) {
                this.iId.pG(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar) {
        ad adVar = this.jjP.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.iMp = auVar;
            this.jjP.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.iMp = auVar;
        }
        if (this.iId != null) {
            this.iId.a(auVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        ad adVar = this.jjP.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.eUh = z;
            this.jjP.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.eUh = z;
        }
        if (this.iId != null) {
            this.iId.pG(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.iId != null) {
            this.iId.Q(i, z);
        }
    }
}
