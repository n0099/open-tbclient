package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseFragment implements com.baidu.tbadk.imageManager.d, com.baidu.tbadk.mvc.c.a {
    private af LO;
    private String aCE;
    private BaseFragmentActivity aCF;
    private boolean aCI;
    private long aCJ;
    private ViewEventCenter aCK;
    private boolean aCL;
    private AlertDialog aCM;
    private boolean aCO;
    private com.baidu.tbadk.core.dialog.a aCQ;
    private com.baidu.tieba.enterForum.d.e aCB = null;
    private com.baidu.tieba.enterForum.c.c aCC = null;
    private boolean isFirst = true;
    private boolean aCD = false;
    private long aCG = -1;
    private boolean aCH = false;
    private com.baidu.adp.framework.listener.a aCN = new b(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aCP = new k(this, 2007008);
    private com.baidu.adp.base.i aCR = new l(this);
    private final com.baidu.tieba.enterForum.c.h aCS = new m(this);
    private ae YX = new n(this);

    static {
        GB();
    }

    private static void GB() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GC() {
        return (this.aCC.b(this.aCB.Hs(), this.aCB.Ht()) && (this.aCB.Hf() == this.aCB.Hj())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, false));
        this.aCB.bB(false);
    }

    private void GE() {
        registerListener(new o(this, 2007010));
        registerListener(new p(this, 2007011));
    }

    private void GF() {
        registerListener(new q(this, 2007012));
    }

    public void GG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bx(y.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(y.enter_forum_cancel_change), new r(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(y.cancel), new c(this));
        aVar.b(this.aCF.getPageContext());
        aVar.re();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GH() {
        if (isPrimary() && !this.aCL) {
            if (this.aCB != null && this.aCB.Hs() != null && !this.aCB.Hs().isEmpty()) {
                GJ();
            }
            this.aCL = true;
            this.aCC.GZ();
        }
    }

    private void GI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bx(y.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(y.hide), new d(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(y.cancel), new e(this));
        aVar.b(getPageContext());
        aVar.re();
    }

    public void a(com.baidu.tieba.tbadkCore.ae aeVar) {
        if (aeVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
            aVar.ca(String.format(this.aCF.getPageContext().getString(y.attention_cancel_dialog_content), aeVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(y.confirm), new f(this, aeVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(y.cancel), new g(this));
            aVar.b(getPageContext());
            aVar.re();
        }
    }

    public void GJ() {
        this.aCQ = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        this.aCQ.bx(y.enter_forum_edit_guide);
        this.aCQ.a(TbadkCoreApplication.m411getInst().getString(y.group_create_private_isee), new h(this));
        this.aCQ.b(getPageContext());
        this.aCQ.re();
    }

    public void bx(boolean z) {
        if (z) {
            if (this.aCM == null) {
                GK();
            }
            com.baidu.adp.lib.g.k.a(this.aCM, getFragmentActivity());
            return;
        }
        com.baidu.adp.lib.g.k.b(this.aCM, getFragmentActivity());
    }

    private void GK() {
        this.aCM = new AlertDialog.Builder(getFragmentActivity()).create();
        this.aCM.setCanceledOnTouchOutside(false);
        this.aCM.show();
        View inflate = LayoutInflater.from(getFragmentActivity()).inflate(w.custom_loading_toast, (ViewGroup) null);
        inflate.findViewById(v.custom_loading_text).setVisibility(8);
        this.aCM.getWindow().setContentView(inflate);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aCF = getBaseFragmentActivity();
        this.aCK = new ViewEventCenter();
        this.aCK.addEventDelegate(this);
        registerListener(this.aCP);
        GE();
        GF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return b(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.aCN);
        this.aCG = System.currentTimeMillis();
        initData(getArguments());
        initUI();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.aCL = this.aCC.Ha();
        com.baidu.tieba.enterForum.c.a.GL().i(getFragmentActivity(), com.baidu.adp.lib.util.n.l(getFragmentActivity()));
    }

    private View b(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(w.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aCB = new com.baidu.tieba.enterForum.d.e(this, this.aCK);
        this.aCB.a(this.YX);
        this.aCB.c(new i(this));
    }

    private void initData(Bundle bundle) {
        this.isFirst = true;
        this.aCD = false;
        this.aCE = "";
        this.aCC = new com.baidu.tieba.enterForum.c.c(this.aCF.getPageContext());
        this.aCC.a(this.aCS);
        this.aCJ = this.aCC.Hc();
        this.LO = new af(this.aCF.getPageContext());
        this.LO.setLoadDataCallBack(this.aCR);
        this.aCC.a(this.aCS);
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null) {
            if (bVar.Gs() != null && bVar.Gs().qB() != null && !bVar.Gs().qB().isEmpty()) {
                this.aCB.a(getPageContext(), bVar.Gs().qB().get(0));
            }
            com.baidu.tieba.enterForum.b.c Gt = bVar.Gt();
            if (Gt != null && Gt.Gw() != null) {
                int size = Gt.Gw().size();
                if (size <= 10) {
                    if (size <= 0) {
                        this.aCB.bC(true);
                    } else {
                        this.aCB.bC(false);
                    }
                    boolean O = this.aCC.O(this.aCJ);
                    List<com.baidu.tieba.enterForum.b.d> GA = bVar.Gr() != null ? bVar.Gr().GA() : null;
                    if (!O || GA == null || GA.isEmpty()) {
                        this.aCB.Hv();
                    } else {
                        this.aCB.L(GA);
                    }
                } else {
                    this.aCB.Hv();
                    this.aCB.bC(false);
                }
            }
            G(Gt == null ? null : Gt.Gw());
        }
    }

    private void G(List<com.baidu.tieba.tbadkCore.ae> list) {
        if (list != null) {
            int ev = this.aCC.ev(0);
            if (ev == 0) {
                if (list.size() > 8) {
                    ev = 2;
                } else {
                    ev = 1;
                }
            }
            this.aCB.ew(ev);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aCB.O(this.aCC.a(list, this.aCC.Hb()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aCB.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aCH = false;
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(getActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            getActivity().finish();
        }
        if (!isShow()) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(getActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            getActivity().finish();
        }
        this.aCB.onResume();
        by(false);
        if (this.aCB.Ho()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Boolean.valueOf(isPrimary())));
        }
        if (!isPrimary() && this.aCQ != null) {
            this.aCQ.dismiss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        zA();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aCB.onChangeSkinType(i);
    }

    public void zA() {
        this.aCC.cancelLoadData();
    }

    public void by(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aCO && this.aCC != null) {
            String str = this.aCE;
            this.aCE = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aCE == null || this.aCE.equals(str)) {
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = true;
            }
            if (TbadkCoreApplication.m411getInst().getLikeBarChanged()) {
                TbadkCoreApplication.m411getInst().setLikeBarChanged(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TbadkCoreApplication.m411getInst().signedForumCount() > 0) {
                if (this.aCC != null && this.aCC.GV() != null && this.aCC.GV().Gt() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.ae> it = this.aCC.GV().Gt().Gw().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.ae next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.il(1);
                            int signLevelUpValue = TbadkCoreApplication.m411getInst().getSignLevelUpValue(next.getName());
                            if (signLevelUpValue > 0) {
                                next.setLevel(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.m411getInst().clearSignedForum();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.tbadkCore.util.j.iJ(currentAccount);
                }
                this.aCB.notifyDataSetChanged();
            }
            if (z2 || z4) {
                zA();
                if (z4) {
                    this.aCB.mX();
                } else if (z2) {
                    this.aCC.bA(StringUtils.isNull(this.aCE) ? false : true);
                    this.aCB.mX();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new j(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Az = bVar.Az();
        com.baidu.tbadk.mvc.b.a AA = bVar.AA();
        switch (Az) {
            case 1:
                if (AA instanceof com.baidu.tieba.tbadkCore.ae) {
                    String name = ((com.baidu.tieba.tbadkCore.ae) AA).getName();
                    if (bd.aK(name)) {
                        TiebaStatic.eventStat(this.aCF.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aCH = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aCF.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, true));
                this.aCB.bB(true);
                this.aCI = false;
                if (getView() != null && getView().getParent() != null) {
                    getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (AA instanceof com.baidu.tieba.tbadkCore.ae) {
                    a((com.baidu.tieba.tbadkCore.ae) AA);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aCB.Hl() != null) {
                    arrayList.addAll(this.aCB.Hl());
                }
                List<com.baidu.tieba.tbadkCore.ae> I = this.aCC.I(this.aCB.Hl());
                if (!arrayList.isEmpty() && this.aCC.b(arrayList, I)) {
                    showToast(y.enter_forum_sort_already);
                } else {
                    this.aCB.K(I);
                }
                return true;
            case 7:
                this.aCB.Hn();
                return true;
            case 8:
                GI();
                return true;
            case 9:
                this.aCB.Hu();
                return true;
            case 10:
                if (AA instanceof com.baidu.tieba.enterForum.b.d) {
                    com.baidu.tieba.enterForum.b.d dVar = (com.baidu.tieba.enterForum.b.d) AA;
                    String forumName = dVar.getForumName();
                    String valueOf = String.valueOf(dVar.getForumId());
                    if (bd.aK(forumName)) {
                        TiebaStatic.eventStat(this.aCF.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.LO.aV(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (AA instanceof com.baidu.tieba.enterForum.b.d) {
                    com.baidu.tieba.enterForum.b.d dVar2 = (com.baidu.tieba.enterForum.b.d) AA;
                    String forumName2 = dVar2.getForumName();
                    String valueOf2 = String.valueOf(dVar2.getForumId());
                    if (bd.aK(forumName2)) {
                        TiebaStatic.eventStat(this.aCF.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aCH = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aCF.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aCF.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.aCF.getPageContext().getPageActivity())));
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aCF.getPageContext().getPageActivity())));
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean zU() {
        return false;
    }
}
