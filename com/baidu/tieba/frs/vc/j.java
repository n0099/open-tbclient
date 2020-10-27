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
    private com.baidu.tieba.frs.smartsort.a iBP;
    private boolean idS;
    private CustomMessageListener idZ;
    private boolean jdf;
    private HashMap<Integer, ad> jdg;
    private final CustomMessageListener jdh;
    private final CustomMessageListener jdi;
    private final CustomMessageListener jdj;
    private final CustomMessageListener jdk;
    private au jdl;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jdf = false;
        this.idS = false;
        this.idZ = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.idS = false;
                        return;
                    }
                    j.this.idS = true;
                    j.this.iWX.cvI().cDT();
                }
            }
        };
        this.jdh = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.iBs != null) {
                    j.this.iBs.startPullRefresh();
                }
            }
        };
        this.jdi = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    j.this.iBs.bMH();
                    ad adVar = (ad) customResponsedMessage.getData();
                    if (adVar.iFF != null) {
                        j.this.a(adVar.tabId, adVar.iFF);
                    } else if (adVar.tabId == 1) {
                        j.this.a(adVar.tabId, j.this.jdl);
                    } else {
                        j.this.a(adVar.tabId, (au) null);
                    }
                    j.this.Ao(adVar.tabId);
                }
            }
        };
        this.jdj = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    ad adVar = (ad) customResponsedMessage.getData();
                    j.this.U(adVar.tabId, adVar.ePk);
                }
            }
        };
        this.jdk = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    v vVar = (v) customResponsedMessage.getData();
                    j.this.V(vVar.tabId, vVar.fIe);
                }
            }
        };
        this.jdl = new au() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.au
            public void bqb() {
                j.this.jdf = true;
                if (j.this.iBs != null && j.this.iYi != null && j.this.iBM != null && j.this.iWX != null && j.this.iWX.isAdded()) {
                    if (j.this.iBs != null && j.this.iBs.cwN() != null) {
                        j.this.iBs.cwN().cHM();
                    }
                    j.this.iWX.pl(false);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.iBs.cwE() != null && j.this.iYi != null && j.this.iBs.cwE().getVisibility() != 0) {
                                j.this.iYi.bBr();
                            }
                        }
                    }, 110L);
                    j.this.iBs.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.iWX.refresh();
                        j.this.iWX.pl(true);
                    } else {
                        j.this.iWX.cvN();
                    }
                    TiebaStatic.log(new aq("c11749").dR("fid", j.this.iWX.getFid()).dR("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.au
            public void bqc() {
                if (j.this.iWX != null && j.this.iWX.isAdded()) {
                    if (j.this.jdf && j.this.iWX.cvI() != null) {
                        if (!j.this.idS) {
                            j.this.iWX.cvI().cDS();
                        }
                        j.this.jdf = false;
                    }
                    if (j.this.iBP != null && j.this.iWX.cvK() != null && j.this.iWX.cvK().cwP() != null && !j.this.iWX.cvK().cwP().cDe()) {
                        j.this.iBP.cCk();
                    }
                    if (j.this.iBs != null && j.this.iYi != null && j.this.iBM != null && j.this.iBP != null) {
                        j.this.iBs.cwN().a(0, 0, true, true);
                        j.this.iWX.cvZ();
                        j.this.iWX.pl(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.iWX.cvK() != null) {
                            j.this.iWX.cvK().Q(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.iWX.bqA().getVisibility() != 0 || y.isEmpty(j.this.iWX.cwo().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.iBP = frsFragment.cvE();
        this.jdg = new HashMap<>();
        this.iBs.yI(1);
        frsFragment.registerListener(this.jdh);
        frsFragment.registerListener(this.jdi);
        frsFragment.registerListener(this.jdj);
        frsFragment.registerListener(this.jdk);
        frsFragment.registerListener(this.idZ);
    }

    public void cDC() {
        if (this.iBs != null) {
            if ((this.iYh instanceof FrsTabViewController) && ((FrsTabViewController) this.iYh).cDR() != null && (((FrsTabViewController) this.iYh).cDR().fragment instanceof au)) {
                FrsTabViewController.b cDR = ((FrsTabViewController) this.iYh).cDR();
                a(cDR.tabId, (au) cDR.fragment);
                Ao(cDR.tabId);
                return;
            }
            this.iBs.a(this.jdl);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.idZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ao(int i) {
        ad adVar;
        if (this.iBs != null && (adVar = this.jdg.get(Integer.valueOf(i))) != null) {
            this.iBs.yI(i);
            this.iBs.a(adVar.iFF);
            this.iBs.pu(adVar.ePk);
            if (adVar.iFF == null) {
                this.iBs.pu(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar) {
        ad adVar = this.jdg.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.iFF = auVar;
            this.jdg.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.iFF = auVar;
        }
        if (this.iBs != null) {
            this.iBs.a(auVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        ad adVar = this.jdg.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.ePk = z;
            this.jdg.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.ePk = z;
        }
        if (this.iBs != null) {
            this.iBs.pu(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.iBs != null) {
            this.iBs.Q(i, z);
        }
    }
}
