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
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.z;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private boolean iKL;
    private CustomMessageListener iKS;
    private boolean jML;
    private HashMap<Integer, z> jMM;
    private final CustomMessageListener jMN;
    private final CustomMessageListener jMO;
    private final CustomMessageListener jMP;
    private final CustomMessageListener jMQ;
    private aq jMR;
    private com.baidu.tieba.frs.smartsort.a jiB;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jML = false;
        this.iKL = false;
        this.iKS = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.iKL = false;
                        return;
                    }
                    j.this.iKL = true;
                    j.this.jGE.cCF().cMc();
                }
            }
        };
        this.jMN = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.jif != null) {
                    j.this.jif.startPullRefresh();
                }
            }
        };
        this.jMO = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    j.this.jif.bRO();
                    z zVar = (z) customResponsedMessage.getData();
                    if (zVar.jms != null) {
                        j.this.a(zVar.tabId, zVar.jms);
                    } else if (zVar.tabId == 1) {
                        j.this.a(zVar.tabId, j.this.jMR);
                    } else {
                        j.this.a(zVar.tabId, (aq) null);
                    }
                    j.this.AE(zVar.tabId);
                }
            }
        };
        this.jMP = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    z zVar = (z) customResponsedMessage.getData();
                    j.this.U(zVar.tabId, zVar.fku);
                }
            }
        };
        this.jMQ = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    t tVar = (t) customResponsedMessage.getData();
                    j.this.V(tVar.tabId, tVar.gec);
                }
            }
        };
        this.jMR = new aq() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.aq
            public void bup() {
                j.this.jML = true;
                if (j.this.jif != null && j.this.jHN != null && j.this.jiy != null && j.this.jGE != null && j.this.jGE.isAdded()) {
                    if (j.this.jif != null && j.this.jif.cDL() != null) {
                        j.this.jif.cDL().cQI();
                    }
                    j.this.jGE.qx(false);
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.jif.cDC() != null && j.this.jHN != null && j.this.jif.cDC().getVisibility() != 0) {
                                j.this.jHN.bFH();
                            }
                        }
                    }, 110L);
                    j.this.jif.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.jGE.refresh();
                        j.this.jGE.qx(true);
                    } else {
                        j.this.jGE.cCK();
                    }
                    TiebaStatic.log(new ar("c11749").dR("fid", j.this.jGE.getFid()).dR("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.aq
            public void buq() {
                if (j.this.jGE != null && j.this.jGE.isAdded()) {
                    if (j.this.jML && j.this.jGE.cCF() != null) {
                        if (!j.this.iKL && !j.this.cLK()) {
                            j.this.jGE.cCF().cMb();
                        }
                        j.this.jML = false;
                    }
                    if (j.this.jiB != null && j.this.jGE.cCH() != null && j.this.jGE.cCH().cDN() != null && !j.this.jGE.cCH().cDN().cLj() && j.this.jGE.cCF() != null && !j.this.jGE.cCF().cLU()) {
                        j.this.jiB.cKn();
                    }
                    if (j.this.jif != null && j.this.jHN != null && j.this.jiy != null && j.this.jiB != null) {
                        j.this.jif.cDL().b(0, 0, true, true);
                        j.this.jGE.cCW();
                        j.this.jGE.qx(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.jGE.cCH() != null) {
                            j.this.jGE.cCH().Q(1, false);
                        }
                        j.this.jiy.cLu();
                        if (!TbadkCoreApplication.isLogin() || j.this.jGE.getListView().getVisibility() != 0 || y.isEmpty(j.this.jGE.cDm().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.jiB = frsFragment.cCB();
        this.jMM = new HashMap<>();
        this.jif.yP(1);
        frsFragment.registerListener(this.jMN);
        frsFragment.registerListener(this.jMO);
        frsFragment.registerListener(this.jMP);
        frsFragment.registerListener(this.jMQ);
        frsFragment.registerListener(this.iKS);
    }

    public void cLJ() {
        if (this.jif != null) {
            if ((this.jHM instanceof FrsTabViewController) && ((FrsTabViewController) this.jHM).cMa() != null && (((FrsTabViewController) this.jHM).cMa().fragment instanceof aq)) {
                FrsTabViewController.b cMa = ((FrsTabViewController) this.jHM).cMa();
                a(cMa.tabId, (aq) cMa.fragment);
                AE(cMa.tabId);
                return;
            }
            this.jif.a(this.jMR);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.iKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLK() {
        if (this.jGE.cDm() == null || this.jGE.cDm().getUserData() == null || this.jGE.cDm().forumRule == null || this.jGE.cDm().getForum() == null || !this.jGE.cDm().getForum().getIsShowRule()) {
            return false;
        }
        return this.jGE.cDm().getUserData().getIs_manager() == 1 ? this.jGE.cDm().forumRule.has_forum_rule.intValue() != 1 && this.jGE.cDm().forumRule.audit_status.intValue() == 0 && com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.jGE.cDm().forumRule.has_forum_rule.intValue() == 1 && com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_forum_rule_first_show_frs", 0) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE(int i) {
        z zVar;
        if (this.jif != null && (zVar = this.jMM.get(Integer.valueOf(i))) != null) {
            this.jif.yP(i);
            this.jif.a(zVar.jms);
            this.jif.qH(zVar.fku);
            if (zVar.jms == null) {
                this.jif.qH(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, aq aqVar) {
        z zVar = this.jMM.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.jms = aqVar;
            this.jMM.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.jms = aqVar;
        }
        if (this.jif != null) {
            this.jif.a(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        z zVar = this.jMM.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.fku = z;
            this.jMM.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.fku = z;
        }
        if (this.jif != null) {
            this.jif.qH(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.jif != null) {
            this.jif.Q(i, z);
        }
    }
}
