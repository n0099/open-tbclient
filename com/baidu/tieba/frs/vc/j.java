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
    private com.baidu.tieba.frs.smartsort.a iTr;
    private CustomMessageListener ivD;
    private boolean ivw;
    private boolean jxr;
    private HashMap<Integer, ac> jxs;
    private final CustomMessageListener jxt;
    private final CustomMessageListener jxu;
    private final CustomMessageListener jxv;
    private final CustomMessageListener jxw;
    private at jxx;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jxr = false;
        this.ivw = false;
        this.ivD = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.ivw = false;
                        return;
                    }
                    j.this.ivw = true;
                    j.this.jrk.cCc().cLo();
                }
            }
        };
        this.jxt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.iSV != null) {
                    j.this.iSV.startPullRefresh();
                }
            }
        };
        this.jxu = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac)) {
                    j.this.iSV.bSl();
                    ac acVar = (ac) customResponsedMessage.getData();
                    if (acVar.iXg != null) {
                        j.this.a(acVar.tabId, acVar.iXg);
                    } else if (acVar.tabId == 1) {
                        j.this.a(acVar.tabId, j.this.jxx);
                    } else {
                        j.this.a(acVar.tabId, (at) null);
                    }
                    j.this.BN(acVar.tabId);
                }
            }
        };
        this.jxv = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac)) {
                    ac acVar = (ac) customResponsedMessage.getData();
                    j.this.U(acVar.tabId, acVar.fbE);
                }
            }
        };
        this.jxw = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    u uVar = (u) customResponsedMessage.getData();
                    j.this.V(uVar.tabId, uVar.fVi);
                }
            }
        };
        this.jxx = new at() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.at
            public void bvq() {
                j.this.jxr = true;
                if (j.this.iSV != null && j.this.jsv != null && j.this.iTo != null && j.this.jrk != null && j.this.jrk.isAdded()) {
                    if (j.this.iSV != null && j.this.iSV.cDi() != null) {
                        j.this.iSV.cDi().cPh();
                    }
                    j.this.jrk.pU(false);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.iSV.cCZ() != null && j.this.jsv != null && j.this.iSV.cCZ().getVisibility() != 0) {
                                j.this.jsv.bGI();
                            }
                        }
                    }, 110L);
                    j.this.iSV.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.jrk.refresh();
                        j.this.jrk.pU(true);
                    } else {
                        j.this.jrk.cCh();
                    }
                    TiebaStatic.log(new ar("c11749").dY("fid", j.this.jrk.getFid()).dY("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.at
            public void bvr() {
                if (j.this.jrk != null && j.this.jrk.isAdded()) {
                    if (j.this.jxr && j.this.jrk.cCc() != null) {
                        if (!j.this.ivw && !j.this.cKY()) {
                            j.this.jrk.cCc().cLn();
                        }
                        j.this.jxr = false;
                    }
                    if (j.this.iTr != null && j.this.jrk.cCe() != null && j.this.jrk.cCe().cDk() != null && !j.this.jrk.cCe().cDk().cKz()) {
                        j.this.iTr.cJD();
                    }
                    if (j.this.iSV != null && j.this.jsv != null && j.this.iTo != null && j.this.iTr != null) {
                        j.this.iSV.cDi().a(0, 0, true, true);
                        j.this.jrk.cCt();
                        j.this.jrk.pU(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.jrk.cCe() != null) {
                            j.this.jrk.cCe().Q(1, false);
                        }
                        j.this.iTo.cKJ();
                        if (!TbadkCoreApplication.isLogin() || j.this.jrk.bvQ().getVisibility() != 0 || y.isEmpty(j.this.jrk.cCJ().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.iTr = frsFragment.cBY();
        this.jxs = new HashMap<>();
        this.iSV.zY(1);
        frsFragment.registerListener(this.jxt);
        frsFragment.registerListener(this.jxu);
        frsFragment.registerListener(this.jxv);
        frsFragment.registerListener(this.jxw);
        frsFragment.registerListener(this.ivD);
    }

    public void cKX() {
        if (this.iSV != null) {
            if ((this.jsu instanceof FrsTabViewController) && ((FrsTabViewController) this.jsu).cLm() != null && (((FrsTabViewController) this.jsu).cLm().fragment instanceof at)) {
                FrsTabViewController.b cLm = ((FrsTabViewController) this.jsu).cLm();
                a(cLm.tabId, (at) cLm.fragment);
                BN(cLm.tabId);
                return;
            }
            this.iSV.a(this.jxx);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.ivD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKY() {
        if (this.jrk.cCJ() == null || this.jrk.cCJ().getUserData() == null || this.jrk.cCJ().forumRule == null || this.jrk.cCJ().getForum() == null || !this.jrk.cCJ().getForum().getIsShowRule()) {
            return false;
        }
        return this.jrk.cCJ().getUserData().getIs_manager() == 1 ? this.jrk.cCJ().forumRule.has_forum_rule.intValue() != 1 && this.jrk.cCJ().forumRule.audit_status.intValue() == 0 && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.jrk.cCJ().forumRule.has_forum_rule.intValue() == 1 && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_forum_rule_first_show_frs", 0) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN(int i) {
        ac acVar;
        if (this.iSV != null && (acVar = this.jxs.get(Integer.valueOf(i))) != null) {
            this.iSV.zY(i);
            this.iSV.a(acVar.iXg);
            this.iSV.qd(acVar.fbE);
            if (acVar.iXg == null) {
                this.iSV.qd(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, at atVar) {
        ac acVar = this.jxs.get(Integer.valueOf(i));
        if (acVar == null) {
            ac acVar2 = new ac();
            acVar2.tabId = i;
            acVar2.iXg = atVar;
            this.jxs.put(Integer.valueOf(i), acVar2);
        } else {
            acVar.iXg = atVar;
        }
        if (this.iSV != null) {
            this.iSV.a(atVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        ac acVar = this.jxs.get(Integer.valueOf(i));
        if (acVar == null) {
            ac acVar2 = new ac();
            acVar2.tabId = i;
            acVar2.fbE = z;
            this.jxs.put(Integer.valueOf(i), acVar2);
        } else {
            acVar.fbE = z;
        }
        if (this.iSV != null) {
            this.iSV.qd(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.iSV != null) {
            this.iSV.Q(i, z);
        }
    }
}
