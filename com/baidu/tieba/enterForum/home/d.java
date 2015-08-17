package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.SettingChangeMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseFragment implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.v LT;
    private BaseFragmentActivity aGD;
    private com.baidu.tbadk.core.dialog.a aMA;
    private String aMp;
    private boolean aMr;
    private long aMs;
    private ViewEventCenter aMt;
    private boolean aMu;
    private com.baidu.tbadk.core.view.a aMv;
    private boolean aMy;
    private com.baidu.tieba.enterForum.d.e aMm = null;
    private com.baidu.tieba.enterForum.c.c aMn = null;
    private boolean isFirst = true;
    private boolean aMo = false;
    private long aMq = -1;
    private final CustomMessageListener aGE = new e(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener aMw = new o(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private com.baidu.adp.framework.listener.a aMx = new p(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aMz = new q(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g aMB = new r(this);
    private final c.b aMC = new s(this);
    private x.a afb = new t(this);

    static {
        Iz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aMz);
        IC();
        ID();
        registerListener(this.aMx);
        registerListener(this.aGE);
        registerListener(this.aMw);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private static void Iz() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IA() {
        return (this.aMn.b(this.aMm.Jm(), this.aMm.Jn()) && (this.aMm.IZ() == this.aMm.Jd())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, false));
        this.aMm.Jk();
    }

    private void IC() {
        registerListener(new u(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        registerListener(new v(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    private void ID() {
        registerListener(new f(this, CmdConfigCustom.MAINTAB_TAB_SLIDINGMENU_CLOSED));
    }

    public void IE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bC(i.C0057i.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(i.C0057i.enter_forum_cancel_change), new g(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(i.C0057i.cancel), new h(this));
        aVar.b(this.aGD.getPageContext());
        aVar.sP();
    }

    private void IF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bC(i.C0057i.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(i.C0057i.hide), new i(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(i.C0057i.cancel), new j(this));
        aVar.b(getPageContext());
        aVar.sP();
    }

    public void a(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
            aVar.cn(String.format(this.aGD.getPageContext().getString(i.C0057i.attention_cancel_dialog_content), uVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(i.C0057i.confirm), new k(this, uVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(i.C0057i.cancel), new l(this));
            aVar.b(getPageContext());
            aVar.sP();
        }
    }

    public void bJ(boolean z) {
        if (this.aMv == null) {
            IG();
        }
        this.aMv.av(z);
    }

    private void IG() {
        this.aMv = new com.baidu.tbadk.core.view.a(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aGD = getBaseFragmentActivity();
        this.aMt = new ViewEventCenter();
        this.aMt.addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aMq = System.currentTimeMillis();
        initData(getArguments());
        initUI();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.aMu = this.aMn.hasShowForumEditGuide();
        com.baidu.tieba.enterForum.c.a.IH().j(getFragmentActivity(), com.baidu.adp.lib.util.k.l(getFragmentActivity()));
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(i.g.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aMm = new com.baidu.tieba.enterForum.d.e(this, this.aMt);
        this.aMm.a(this.afb);
        this.aMm.c(new m(this));
    }

    private void initData(Bundle bundle) {
        this.isFirst = true;
        this.aMo = false;
        this.aMp = "";
        this.aMn = new com.baidu.tieba.enterForum.c.c(this.aGD.getPageContext());
        this.aMs = this.aMn.IW();
        this.LT = new com.baidu.tieba.tbadkCore.v(this.aGD.getPageContext());
        this.LT.setLoadDataCallBack(this.aMB);
        this.aMn.a(this.aMC);
        com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("enter_forum_edit_mode", false);
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null) {
            if (bVar.Ip() != null && bVar.Ip().sk() != null && !bVar.Ip().sk().isEmpty()) {
                this.aMm.a(getPageContext(), bVar.Ip().sk().get(0));
            }
            com.baidu.tieba.enterForum.b.c Iq = bVar.Iq();
            if (Iq != null && Iq.Is() != null) {
                int size = Iq.Is().size();
                String str = "key_first_start_maintab_" + TbadkCoreApplication.getCurrentAccount();
                boolean z = com.baidu.tbadk.core.sharedPref.b.ts().getBoolean(str, true);
                if (!TbadkCoreApplication.m411getInst().isEnterRecommendFrs() && size < 5 && z && TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getActivity()).createNormalCfg(2)));
                }
                com.baidu.tbadk.core.sharedPref.b.ts().putBoolean(str, false);
                if (size <= 10) {
                    if (size <= 0) {
                        if (this.mIsLogin) {
                            this.aMm.bN(true);
                        } else {
                            this.aMm.bN(false);
                        }
                    } else {
                        this.aMm.bN(false);
                    }
                    boolean R = this.aMn.R(this.aMs);
                    List<com.baidu.tieba.enterForum.b.e> Iw = bVar.Io() != null ? bVar.Io().Iw() : null;
                    if (!R || Iw == null || Iw.isEmpty()) {
                        this.aMm.Jp();
                    } else {
                        this.aMm.N(Iw);
                    }
                    if (!this.mIsLogin && Iw != null && !Iw.isEmpty()) {
                        this.aMm.N(Iw);
                    }
                } else {
                    this.aMm.Jp();
                    this.aMm.bN(false);
                }
            }
            I(Iq == null ? null : Iq.Is());
        }
    }

    private void I(List<com.baidu.tieba.tbadkCore.u> list) {
        if (list != null) {
            int eN = this.aMn.eN(0);
            if (eN == 0) {
                if (list.size() > 8) {
                    eN = 2;
                } else {
                    eN = 1;
                }
            }
            this.aMm.eQ(eN);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aMm.Q(this.aMn.a(list, this.aMn.IV()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aMm.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!isShow()) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.aMm.onResume();
        bK(false);
        if (this.aMm.Ji()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Boolean.valueOf(isPrimary())));
        }
        if (!isPrimary() && this.aMA != null) {
            this.aMA.dismiss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        Cl();
        com.baidu.tieba.enterForum.c.a.IH().destroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aMm.onChangeSkinType(i);
    }

    public void Cl() {
        this.aMn.cancelLoadData();
    }

    public void bK(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aMy && this.aMn != null) {
            String str = this.aMp;
            this.aMp = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aMp == null || this.aMp.equals(str)) {
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
                if (this.aMn != null && this.aMn.IR() != null && this.aMn.IR().Iq() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.u> it = this.aMn.IR().Iq().Is().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.u next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.jF(1);
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
                    com.baidu.tieba.tbadkCore.util.k.kz(currentAccount);
                }
                this.aMm.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Cl();
                if (z4) {
                    this.aMm.ny();
                } else if (z2) {
                    this.aMn.bM(StringUtils.isNull(this.aMp) ? false : true);
                    this.aMm.ny();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.u, Integer, String> {
        private com.baidu.tieba.tbadkCore.u aMH;
        private com.baidu.tbadk.core.util.v afJ = null;

        public a(com.baidu.tieba.tbadkCore.u uVar) {
            this.aMH = null;
            this.aMH = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.u... uVarArr) {
            com.baidu.tieba.tbadkCore.u uVar = this.aMH;
            if (uVar != null) {
                try {
                    if (uVar.getId() != null && uVar.getName() != null) {
                        this.afJ = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.afJ.o(ImageViewerConfig.FORUM_ID, uVar.getId());
                        this.afJ.o("kw", uVar.getName());
                        this.afJ.ue().uV().mIsNeedTbs = true;
                        this.afJ.tD();
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            d.this.bJ(false);
            if (this.afJ != null) {
                if (!this.afJ.ue().uW().rb()) {
                    if (d.this.aGD != null) {
                        if (!StringUtils.isNull(this.afJ.getErrorString())) {
                            d.this.aGD.showToast(this.afJ.getErrorString());
                            return;
                        } else if (d.this.isAdded()) {
                            d.this.aGD.showToast(d.this.getString(i.C0057i.delete_like_fail));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                d.this.aMr = true;
                if (d.this.isAdded() && d.this.aGD != null) {
                    d.this.aGD.showToast(d.this.getString(i.C0057i.delete_like_success));
                }
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                d.this.f(false, this.aMH.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.aMH.getId()));
                d.this.aMm.b(this.aMH);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bJ(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afJ != null) {
                this.afJ.gM();
                this.afJ = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new n(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int CG = bVar.CG();
        com.baidu.tbadk.mvc.b.a CH = bVar.CH();
        switch (CG) {
            case 1:
                if (CH instanceof com.baidu.tieba.tbadkCore.u) {
                    String name = ((com.baidu.tieba.tbadkCore.u) CH).getName();
                    if (aq.aP(name)) {
                        TiebaStatic.eventStat(this.aGD.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aGD.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, true));
                com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("enter_forum_edit_mode", true);
                this.aMm.eO(CH instanceof com.baidu.tieba.enterForum.b.d ? ((com.baidu.tieba.enterForum.b.d) CH).getPosition() : 0);
                this.aMr = false;
                if (getView() != null && getView().getParent() != null) {
                    getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (CH instanceof com.baidu.tieba.tbadkCore.u) {
                    a((com.baidu.tieba.tbadkCore.u) CH);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aMm.Jf() != null) {
                    arrayList.addAll(this.aMm.Jf());
                }
                List<com.baidu.tieba.tbadkCore.u> K = this.aMn.K(this.aMm.Jf());
                if (!arrayList.isEmpty() && this.aMn.b(arrayList, K)) {
                    showToast(i.C0057i.enter_forum_sort_already);
                } else {
                    this.aMm.M(K);
                }
                return true;
            case 7:
                this.aMm.Jh();
                return true;
            case 8:
                IF();
                return true;
            case 9:
                this.aMm.Jo();
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aGD.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (CH instanceof com.baidu.tieba.enterForum.b.e) {
                    com.baidu.tieba.enterForum.b.e eVar = (com.baidu.tieba.enterForum.b.e) CH;
                    String forumName = eVar.getForumName();
                    String valueOf = String.valueOf(eVar.getForumId());
                    if (aq.aP(forumName)) {
                        TiebaStatic.eventStat(this.aGD.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.LT.ba(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (CH instanceof com.baidu.tieba.enterForum.b.e) {
                    com.baidu.tieba.enterForum.b.e eVar2 = (com.baidu.tieba.enterForum.b.e) CH;
                    String forumName2 = eVar2.getForumName();
                    String valueOf2 = String.valueOf(eVar2.getForumId());
                    if (aq.aP(forumName2)) {
                        TiebaStatic.eventStat(this.aGD.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aGD.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aGD.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!this.mIsLogin) {
                            TiebaStatic.eventStat(this.aGD.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aGD.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aGD.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aGD.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aGD.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oK() {
        return false;
    }
}
