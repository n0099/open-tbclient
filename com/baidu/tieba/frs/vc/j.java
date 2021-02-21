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
    private boolean iJc;
    private CustomMessageListener iJj;
    private boolean jLc;
    private HashMap<Integer, z> jLd;
    private final CustomMessageListener jLe;
    private final CustomMessageListener jLf;
    private final CustomMessageListener jLg;
    private final CustomMessageListener jLh;
    private aq jLi;
    private com.baidu.tieba.frs.smartsort.a jgR;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jLc = false;
        this.iJc = false;
        this.iJj = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.iJc = false;
                        return;
                    }
                    j.this.iJc = true;
                    j.this.jEV.cCz().cLW();
                }
            }
        };
        this.jLe = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.jgv != null) {
                    j.this.jgv.startPullRefresh();
                }
            }
        };
        this.jLf = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    j.this.jgv.bRI();
                    z zVar = (z) customResponsedMessage.getData();
                    if (zVar.jkI != null) {
                        j.this.a(zVar.tabId, zVar.jkI);
                    } else if (zVar.tabId == 1) {
                        j.this.a(zVar.tabId, j.this.jLi);
                    } else {
                        j.this.a(zVar.tabId, (aq) null);
                    }
                    j.this.AD(zVar.tabId);
                }
            }
        };
        this.jLg = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    z zVar = (z) customResponsedMessage.getData();
                    j.this.U(zVar.tabId, zVar.fiV);
                }
            }
        };
        this.jLh = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    t tVar = (t) customResponsedMessage.getData();
                    j.this.V(tVar.tabId, tVar.gcC);
                }
            }
        };
        this.jLi = new aq() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.aq
            public void bum() {
                j.this.jLc = true;
                if (j.this.jgv != null && j.this.jGe != null && j.this.jgO != null && j.this.jEV != null && j.this.jEV.isAdded()) {
                    if (j.this.jgv != null && j.this.jgv.cDF() != null) {
                        j.this.jgv.cDF().cQB();
                    }
                    j.this.jEV.qx(false);
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.jgv.cDw() != null && j.this.jGe != null && j.this.jgv.cDw().getVisibility() != 0) {
                                j.this.jGe.bFD();
                            }
                        }
                    }, 110L);
                    j.this.jgv.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.jEV.refresh();
                        j.this.jEV.qx(true);
                    } else {
                        j.this.jEV.cCE();
                    }
                    TiebaStatic.log(new ar("c11749").dR("fid", j.this.jEV.getFid()).dR("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.aq
            public void bun() {
                if (j.this.jEV != null && j.this.jEV.isAdded()) {
                    if (j.this.jLc && j.this.jEV.cCz() != null) {
                        if (!j.this.iJc && !j.this.cLE()) {
                            j.this.jEV.cCz().cLV();
                        }
                        j.this.jLc = false;
                    }
                    if (j.this.jgR != null && j.this.jEV.cCB() != null && j.this.jEV.cCB().cDH() != null && !j.this.jEV.cCB().cDH().cLd() && j.this.jEV.cCz() != null && !j.this.jEV.cCz().cLO()) {
                        j.this.jgR.cKh();
                    }
                    if (j.this.jgv != null && j.this.jGe != null && j.this.jgO != null && j.this.jgR != null) {
                        j.this.jgv.cDF().b(0, 0, true, true);
                        j.this.jEV.cCQ();
                        j.this.jEV.qx(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.jEV.cCB() != null) {
                            j.this.jEV.cCB().Q(1, false);
                        }
                        j.this.jgO.cLo();
                        if (!TbadkCoreApplication.isLogin() || j.this.jEV.getListView().getVisibility() != 0 || y.isEmpty(j.this.jEV.cDg().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.jgR = frsFragment.cCv();
        this.jLd = new HashMap<>();
        this.jgv.yO(1);
        frsFragment.registerListener(this.jLe);
        frsFragment.registerListener(this.jLf);
        frsFragment.registerListener(this.jLg);
        frsFragment.registerListener(this.jLh);
        frsFragment.registerListener(this.iJj);
    }

    public void cLD() {
        if (this.jgv != null) {
            if ((this.jGd instanceof FrsTabViewController) && ((FrsTabViewController) this.jGd).cLU() != null && (((FrsTabViewController) this.jGd).cLU().fragment instanceof aq)) {
                FrsTabViewController.b cLU = ((FrsTabViewController) this.jGd).cLU();
                a(cLU.tabId, (aq) cLU.fragment);
                AD(cLU.tabId);
                return;
            }
            this.jgv.a(this.jLi);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.iJj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLE() {
        if (this.jEV.cDg() == null || this.jEV.cDg().getUserData() == null || this.jEV.cDg().forumRule == null || this.jEV.cDg().getForum() == null || !this.jEV.cDg().getForum().getIsShowRule()) {
            return false;
        }
        return this.jEV.cDg().getUserData().getIs_manager() == 1 ? this.jEV.cDg().forumRule.has_forum_rule.intValue() != 1 && this.jEV.cDg().forumRule.audit_status.intValue() == 0 && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.jEV.cDg().forumRule.has_forum_rule.intValue() == 1 && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_forum_rule_first_show_frs", 0) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AD(int i) {
        z zVar;
        if (this.jgv != null && (zVar = this.jLd.get(Integer.valueOf(i))) != null) {
            this.jgv.yO(i);
            this.jgv.a(zVar.jkI);
            this.jgv.qH(zVar.fiV);
            if (zVar.jkI == null) {
                this.jgv.qH(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, aq aqVar) {
        z zVar = this.jLd.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.jkI = aqVar;
            this.jLd.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.jkI = aqVar;
        }
        if (this.jgv != null) {
            this.jgv.a(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        z zVar = this.jLd.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.fiV = z;
            this.jLd.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.fiV = z;
        }
        if (this.jgv != null) {
            this.jgv.qH(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.jgv != null) {
            this.jgv.Q(i, z);
        }
    }
}
