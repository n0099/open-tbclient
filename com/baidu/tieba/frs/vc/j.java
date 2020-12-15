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
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private com.baidu.tieba.frs.smartsort.a iTt;
    private CustomMessageListener ivF;
    private boolean ivy;
    private boolean jxt;
    private HashMap<Integer, ac> jxu;
    private final CustomMessageListener jxv;
    private final CustomMessageListener jxw;
    private final CustomMessageListener jxx;
    private final CustomMessageListener jxy;
    private at jxz;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jxt = false;
        this.ivy = false;
        this.ivF = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.ivy = false;
                        return;
                    }
                    j.this.ivy = true;
                    j.this.jrm.cCd().cLp();
                }
            }
        };
        this.jxv = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.iSX != null) {
                    j.this.iSX.startPullRefresh();
                }
            }
        };
        this.jxw = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac)) {
                    j.this.iSX.bSm();
                    ac acVar = (ac) customResponsedMessage.getData();
                    if (acVar.iXi != null) {
                        j.this.a(acVar.tabId, acVar.iXi);
                    } else if (acVar.tabId == 1) {
                        j.this.a(acVar.tabId, j.this.jxz);
                    } else {
                        j.this.a(acVar.tabId, (at) null);
                    }
                    j.this.BN(acVar.tabId);
                }
            }
        };
        this.jxx = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac)) {
                    ac acVar = (ac) customResponsedMessage.getData();
                    j.this.U(acVar.tabId, acVar.fbE);
                }
            }
        };
        this.jxy = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    u uVar = (u) customResponsedMessage.getData();
                    j.this.V(uVar.tabId, uVar.fVi);
                }
            }
        };
        this.jxz = new at() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.at
            public void bvq() {
                j.this.jxt = true;
                if (j.this.iSX != null && j.this.jsx != null && j.this.iTq != null && j.this.jrm != null && j.this.jrm.isAdded()) {
                    if (j.this.iSX != null && j.this.iSX.cDj() != null) {
                        j.this.iSX.cDj().cPi();
                    }
                    j.this.jrm.pU(false);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.iSX.cDa() != null && j.this.jsx != null && j.this.iSX.cDa().getVisibility() != 0) {
                                j.this.jsx.bGI();
                            }
                        }
                    }, 110L);
                    j.this.iSX.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.jrm.refresh();
                        j.this.jrm.pU(true);
                    } else {
                        j.this.jrm.cCi();
                    }
                    TiebaStatic.log(new ar("c11749").dY("fid", j.this.jrm.getFid()).dY("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.at
            public void bvr() {
                if (j.this.jrm != null && j.this.jrm.isAdded()) {
                    if (j.this.jxt && j.this.jrm.cCd() != null) {
                        if (!j.this.ivy && !j.this.cKZ()) {
                            j.this.jrm.cCd().cLo();
                        }
                        j.this.jxt = false;
                    }
                    if (j.this.iTt != null && j.this.jrm.cCf() != null && j.this.jrm.cCf().cDl() != null && !j.this.jrm.cCf().cDl().cKA()) {
                        j.this.iTt.cJE();
                    }
                    if (j.this.iSX != null && j.this.jsx != null && j.this.iTq != null && j.this.iTt != null) {
                        j.this.iSX.cDj().a(0, 0, true, true);
                        j.this.jrm.cCu();
                        j.this.jrm.pU(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.jrm.cCf() != null) {
                            j.this.jrm.cCf().Q(1, false);
                        }
                        j.this.iTq.cKK();
                        if (!TbadkCoreApplication.isLogin() || j.this.jrm.bvQ().getVisibility() != 0 || y.isEmpty(j.this.jrm.cCK().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.iTt = frsFragment.cBZ();
        this.jxu = new HashMap<>();
        this.iSX.zY(1);
        frsFragment.registerListener(this.jxv);
        frsFragment.registerListener(this.jxw);
        frsFragment.registerListener(this.jxx);
        frsFragment.registerListener(this.jxy);
        frsFragment.registerListener(this.ivF);
    }

    public void cKY() {
        if (this.iSX != null) {
            if ((this.jsw instanceof FrsTabViewController) && ((FrsTabViewController) this.jsw).cLn() != null && (((FrsTabViewController) this.jsw).cLn().fragment instanceof at)) {
                FrsTabViewController.b cLn = ((FrsTabViewController) this.jsw).cLn();
                a(cLn.tabId, (at) cLn.fragment);
                BN(cLn.tabId);
                return;
            }
            this.iSX.a(this.jxz);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.ivF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKZ() {
        if (this.jrm.cCK() == null || this.jrm.cCK().getUserData() == null || this.jrm.cCK().forumRule == null || this.jrm.cCK().getForum() == null || !this.jrm.cCK().getForum().getIsShowRule()) {
            return false;
        }
        return this.jrm.cCK().getUserData().getIs_manager() == 1 ? this.jrm.cCK().forumRule.has_forum_rule.intValue() != 1 && this.jrm.cCK().forumRule.audit_status.intValue() == 0 && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.jrm.cCK().forumRule.has_forum_rule.intValue() == 1 && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_forum_rule_first_show_frs", 0) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN(int i) {
        ac acVar;
        if (this.iSX != null && (acVar = this.jxu.get(Integer.valueOf(i))) != null) {
            this.iSX.zY(i);
            this.iSX.a(acVar.iXi);
            this.iSX.qd(acVar.fbE);
            if (acVar.iXi == null) {
                this.iSX.qd(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, at atVar) {
        ac acVar = this.jxu.get(Integer.valueOf(i));
        if (acVar == null) {
            ac acVar2 = new ac();
            acVar2.tabId = i;
            acVar2.iXi = atVar;
            this.jxu.put(Integer.valueOf(i), acVar2);
        } else {
            acVar.iXi = atVar;
        }
        if (this.iSX != null) {
            this.iSX.a(atVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        ac acVar = this.jxu.get(Integer.valueOf(i));
        if (acVar == null) {
            ac acVar2 = new ac();
            acVar2.tabId = i;
            acVar2.fbE = z;
            this.jxu.put(Integer.valueOf(i), acVar2);
        } else {
            acVar.fbE = z;
        }
        if (this.iSX != null) {
            this.iSX.qd(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.iSX != null) {
            this.iSX.Q(i, z);
        }
    }
}
