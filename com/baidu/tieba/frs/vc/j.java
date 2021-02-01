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
    private boolean iIO;
    private CustomMessageListener iIV;
    private boolean jKO;
    private HashMap<Integer, z> jKP;
    private final CustomMessageListener jKQ;
    private final CustomMessageListener jKR;
    private final CustomMessageListener jKS;
    private final CustomMessageListener jKT;
    private aq jKU;
    private com.baidu.tieba.frs.smartsort.a jgD;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jKO = false;
        this.iIO = false;
        this.iIV = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.iIO = false;
                        return;
                    }
                    j.this.iIO = true;
                    j.this.jEH.cCs().cLP();
                }
            }
        };
        this.jKQ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.jgh != null) {
                    j.this.jgh.startPullRefresh();
                }
            }
        };
        this.jKR = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    j.this.jgh.bRB();
                    z zVar = (z) customResponsedMessage.getData();
                    if (zVar.jku != null) {
                        j.this.a(zVar.tabId, zVar.jku);
                    } else if (zVar.tabId == 1) {
                        j.this.a(zVar.tabId, j.this.jKU);
                    } else {
                        j.this.a(zVar.tabId, (aq) null);
                    }
                    j.this.AD(zVar.tabId);
                }
            }
        };
        this.jKS = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    z zVar = (z) customResponsedMessage.getData();
                    j.this.U(zVar.tabId, zVar.fiV);
                }
            }
        };
        this.jKT = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    t tVar = (t) customResponsedMessage.getData();
                    j.this.V(tVar.tabId, tVar.gcx);
                }
            }
        };
        this.jKU = new aq() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.aq
            public void bum() {
                j.this.jKO = true;
                if (j.this.jgh != null && j.this.jFQ != null && j.this.jgA != null && j.this.jEH != null && j.this.jEH.isAdded()) {
                    if (j.this.jgh != null && j.this.jgh.cDy() != null) {
                        j.this.jgh.cDy().cQu();
                    }
                    j.this.jEH.qx(false);
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.jgh.cDp() != null && j.this.jFQ != null && j.this.jgh.cDp().getVisibility() != 0) {
                                j.this.jFQ.bFD();
                            }
                        }
                    }, 110L);
                    j.this.jgh.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.jEH.refresh();
                        j.this.jEH.qx(true);
                    } else {
                        j.this.jEH.cCx();
                    }
                    TiebaStatic.log(new ar("c11749").dR("fid", j.this.jEH.getFid()).dR("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.aq
            public void bun() {
                if (j.this.jEH != null && j.this.jEH.isAdded()) {
                    if (j.this.jKO && j.this.jEH.cCs() != null) {
                        if (!j.this.iIO && !j.this.cLx()) {
                            j.this.jEH.cCs().cLO();
                        }
                        j.this.jKO = false;
                    }
                    if (j.this.jgD != null && j.this.jEH.cCu() != null && j.this.jEH.cCu().cDA() != null && !j.this.jEH.cCu().cDA().cKW() && j.this.jEH.cCs() != null && !j.this.jEH.cCs().cLH()) {
                        j.this.jgD.cKa();
                    }
                    if (j.this.jgh != null && j.this.jFQ != null && j.this.jgA != null && j.this.jgD != null) {
                        j.this.jgh.cDy().b(0, 0, true, true);
                        j.this.jEH.cCJ();
                        j.this.jEH.qx(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.jEH.cCu() != null) {
                            j.this.jEH.cCu().Q(1, false);
                        }
                        j.this.jgA.cLh();
                        if (!TbadkCoreApplication.isLogin() || j.this.jEH.getListView().getVisibility() != 0 || y.isEmpty(j.this.jEH.cCZ().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.jgD = frsFragment.cCo();
        this.jKP = new HashMap<>();
        this.jgh.yO(1);
        frsFragment.registerListener(this.jKQ);
        frsFragment.registerListener(this.jKR);
        frsFragment.registerListener(this.jKS);
        frsFragment.registerListener(this.jKT);
        frsFragment.registerListener(this.iIV);
    }

    public void cLw() {
        if (this.jgh != null) {
            if ((this.jFP instanceof FrsTabViewController) && ((FrsTabViewController) this.jFP).cLN() != null && (((FrsTabViewController) this.jFP).cLN().fragment instanceof aq)) {
                FrsTabViewController.b cLN = ((FrsTabViewController) this.jFP).cLN();
                a(cLN.tabId, (aq) cLN.fragment);
                AD(cLN.tabId);
                return;
            }
            this.jgh.a(this.jKU);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.iIV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLx() {
        if (this.jEH.cCZ() == null || this.jEH.cCZ().getUserData() == null || this.jEH.cCZ().forumRule == null || this.jEH.cCZ().getForum() == null || !this.jEH.cCZ().getForum().getIsShowRule()) {
            return false;
        }
        return this.jEH.cCZ().getUserData().getIs_manager() == 1 ? this.jEH.cCZ().forumRule.has_forum_rule.intValue() != 1 && this.jEH.cCZ().forumRule.audit_status.intValue() == 0 && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.jEH.cCZ().forumRule.has_forum_rule.intValue() == 1 && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_forum_rule_first_show_frs", 0) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AD(int i) {
        z zVar;
        if (this.jgh != null && (zVar = this.jKP.get(Integer.valueOf(i))) != null) {
            this.jgh.yO(i);
            this.jgh.a(zVar.jku);
            this.jgh.qH(zVar.fiV);
            if (zVar.jku == null) {
                this.jgh.qH(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, aq aqVar) {
        z zVar = this.jKP.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.jku = aqVar;
            this.jKP.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.jku = aqVar;
        }
        if (this.jgh != null) {
            this.jgh.a(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        z zVar = this.jKP.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.fiV = z;
            this.jKP.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.fiV = z;
        }
        if (this.jgh != null) {
            this.jgh.qH(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.jgh != null) {
            this.jgh.Q(i, z);
        }
    }
}
