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
    private af LQ;
    private String aCM;
    private BaseFragmentActivity aCN;
    private boolean aCQ;
    private long aCR;
    private ViewEventCenter aCS;
    private boolean aCT;
    private AlertDialog aCU;
    private boolean aCW;
    private com.baidu.tbadk.core.dialog.a aCY;
    private com.baidu.tieba.enterForum.d.e aCJ = null;
    private com.baidu.tieba.enterForum.c.c aCK = null;
    private boolean isFirst = true;
    private boolean aCL = false;
    private long aCO = -1;
    private boolean aCP = false;
    private com.baidu.adp.framework.listener.a aCV = new b(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aCX = new k(this, 2007008);
    private com.baidu.adp.base.i aCZ = new l(this);
    private final com.baidu.tieba.enterForum.c.h aDa = new m(this);
    private ae YZ = new n(this);

    static {
        GH();
    }

    private static void GH() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GI() {
        return (this.aCK.b(this.aCJ.Hy(), this.aCJ.Hz()) && (this.aCJ.Hl() == this.aCJ.Hp())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, false));
        this.aCJ.bB(false);
    }

    private void GK() {
        registerListener(new o(this, 2007010));
        registerListener(new p(this, 2007011));
    }

    private void GL() {
        registerListener(new q(this, 2007012));
    }

    public void GM() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bx(y.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(y.enter_forum_cancel_change), new r(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(y.cancel), new c(this));
        aVar.b(this.aCN.getPageContext());
        aVar.re();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GN() {
        if (isPrimary() && !this.aCT) {
            if (this.aCJ != null && this.aCJ.Hy() != null && !this.aCJ.Hy().isEmpty()) {
                GP();
            }
            this.aCT = true;
            this.aCK.Hf();
        }
    }

    private void GO() {
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
            aVar.ca(String.format(this.aCN.getPageContext().getString(y.attention_cancel_dialog_content), aeVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(y.confirm), new f(this, aeVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(y.cancel), new g(this));
            aVar.b(getPageContext());
            aVar.re();
        }
    }

    public void GP() {
        this.aCY = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        this.aCY.bx(y.enter_forum_edit_guide);
        this.aCY.a(TbadkCoreApplication.m411getInst().getString(y.group_create_private_isee), new h(this));
        this.aCY.b(getPageContext());
        this.aCY.re();
    }

    public void bx(boolean z) {
        if (z) {
            if (this.aCU == null) {
                GQ();
            }
            com.baidu.adp.lib.g.k.a(this.aCU, getFragmentActivity());
            return;
        }
        com.baidu.adp.lib.g.k.b(this.aCU, getFragmentActivity());
    }

    private void GQ() {
        this.aCU = new AlertDialog.Builder(getFragmentActivity()).create();
        this.aCU.setCanceledOnTouchOutside(false);
        this.aCU.show();
        View inflate = LayoutInflater.from(getFragmentActivity()).inflate(w.custom_loading_toast, (ViewGroup) null);
        inflate.findViewById(v.custom_loading_text).setVisibility(8);
        this.aCU.getWindow().setContentView(inflate);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aCN = getBaseFragmentActivity();
        this.aCS = new ViewEventCenter();
        this.aCS.addEventDelegate(this);
        registerListener(this.aCX);
        GK();
        GL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return b(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.aCV);
        this.aCO = System.currentTimeMillis();
        initData(getArguments());
        initUI();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.aCT = this.aCK.Hg();
        com.baidu.tieba.enterForum.c.a.GR().i(getFragmentActivity(), com.baidu.adp.lib.util.n.l(getFragmentActivity()));
    }

    private View b(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(w.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aCJ = new com.baidu.tieba.enterForum.d.e(this, this.aCS);
        this.aCJ.a(this.YZ);
        this.aCJ.c(new i(this));
    }

    private void initData(Bundle bundle) {
        this.isFirst = true;
        this.aCL = false;
        this.aCM = "";
        this.aCK = new com.baidu.tieba.enterForum.c.c(this.aCN.getPageContext());
        this.aCK.a(this.aDa);
        this.aCR = this.aCK.Hi();
        this.LQ = new af(this.aCN.getPageContext());
        this.LQ.setLoadDataCallBack(this.aCZ);
        this.aCK.a(this.aDa);
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null) {
            if (bVar.Gy() != null && bVar.Gy().qB() != null && !bVar.Gy().qB().isEmpty()) {
                this.aCJ.a(getPageContext(), bVar.Gy().qB().get(0));
            }
            com.baidu.tieba.enterForum.b.c Gz = bVar.Gz();
            if (Gz != null && Gz.GC() != null) {
                int size = Gz.GC().size();
                if (size <= 10) {
                    if (size <= 0) {
                        this.aCJ.bC(true);
                    } else {
                        this.aCJ.bC(false);
                    }
                    boolean O = this.aCK.O(this.aCR);
                    List<com.baidu.tieba.enterForum.b.d> GG = bVar.Gx() != null ? bVar.Gx().GG() : null;
                    if (!O || GG == null || GG.isEmpty()) {
                        this.aCJ.HB();
                    } else {
                        this.aCJ.L(GG);
                    }
                } else {
                    this.aCJ.HB();
                    this.aCJ.bC(false);
                }
            }
            G(Gz == null ? null : Gz.GC());
        }
    }

    private void G(List<com.baidu.tieba.tbadkCore.ae> list) {
        if (list != null) {
            int ev = this.aCK.ev(0);
            if (ev == 0) {
                if (list.size() > 8) {
                    ev = 2;
                } else {
                    ev = 1;
                }
            }
            this.aCJ.ew(ev);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aCJ.O(this.aCK.a(list, this.aCK.Hh()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aCJ.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aCP = false;
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
        this.aCJ.onResume();
        by(false);
        if (this.aCJ.Hu()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Boolean.valueOf(isPrimary())));
        }
        if (!isPrimary() && this.aCY != null) {
            this.aCY.dismiss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        zG();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aCJ.onChangeSkinType(i);
    }

    public void zG() {
        this.aCK.cancelLoadData();
    }

    public void by(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aCW && this.aCK != null) {
            String str = this.aCM;
            this.aCM = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aCM == null || this.aCM.equals(str)) {
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
                if (this.aCK != null && this.aCK.Hb() != null && this.aCK.Hb().Gz() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.ae> it = this.aCK.Hb().Gz().GC().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.ae next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.io(1);
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
                    com.baidu.tieba.tbadkCore.util.j.iM(currentAccount);
                }
                this.aCJ.notifyDataSetChanged();
            }
            if (z2 || z4) {
                zG();
                if (z4) {
                    this.aCJ.mX();
                } else if (z2) {
                    this.aCK.bA(StringUtils.isNull(this.aCM) ? false : true);
                    this.aCJ.mX();
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
        int AF = bVar.AF();
        com.baidu.tbadk.mvc.b.a AG = bVar.AG();
        switch (AF) {
            case 1:
                if (AG instanceof com.baidu.tieba.tbadkCore.ae) {
                    String name = ((com.baidu.tieba.tbadkCore.ae) AG).getName();
                    if (bd.aK(name)) {
                        TiebaStatic.eventStat(this.aCN.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aCP = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aCN.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, true));
                this.aCJ.bB(true);
                this.aCQ = false;
                if (getView() != null && getView().getParent() != null) {
                    getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (AG instanceof com.baidu.tieba.tbadkCore.ae) {
                    a((com.baidu.tieba.tbadkCore.ae) AG);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aCJ.Hr() != null) {
                    arrayList.addAll(this.aCJ.Hr());
                }
                List<com.baidu.tieba.tbadkCore.ae> I = this.aCK.I(this.aCJ.Hr());
                if (!arrayList.isEmpty() && this.aCK.b(arrayList, I)) {
                    showToast(y.enter_forum_sort_already);
                } else {
                    this.aCJ.K(I);
                }
                return true;
            case 7:
                this.aCJ.Ht();
                return true;
            case 8:
                GO();
                return true;
            case 9:
                this.aCJ.HA();
                return true;
            case 10:
                if (AG instanceof com.baidu.tieba.enterForum.b.d) {
                    com.baidu.tieba.enterForum.b.d dVar = (com.baidu.tieba.enterForum.b.d) AG;
                    String forumName = dVar.getForumName();
                    String valueOf = String.valueOf(dVar.getForumId());
                    if (bd.aK(forumName)) {
                        TiebaStatic.eventStat(this.aCN.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.LQ.aV(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (AG instanceof com.baidu.tieba.enterForum.b.d) {
                    com.baidu.tieba.enterForum.b.d dVar2 = (com.baidu.tieba.enterForum.b.d) AG;
                    String forumName2 = dVar2.getForumName();
                    String valueOf2 = String.valueOf(dVar2.getForumId());
                    if (bd.aK(forumName2)) {
                        TiebaStatic.eventStat(this.aCN.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aCP = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aCN.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aCN.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.aCN.getPageContext().getPageActivity())));
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aCN.getPageContext().getPageActivity())));
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Aa() {
        return false;
    }
}
