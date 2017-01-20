package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel Fq;
    private BaseFragmentActivity aQU;
    private f bxB;
    private EnterForumModel bxD;
    private boolean bxE;
    private String bxF;
    private long bxH;
    private boolean bxI;
    private long bxJ;
    private com.baidu.tbadk.core.view.a bxL;
    private boolean bxM;
    private com.baidu.tbadk.core.dialog.a bxN;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.e bxC = null;
    private boolean bxG = false;
    private final CustomMessageListener aQV = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private CustomMessageListener bxO = new w(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bxP = new x(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bxQ = new aa(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bxR = new ab(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.f bxS = new ac(this);
    private final EnterForumModel.b bxT = new ad(this);
    private final CustomMessageListener bxU = new ae(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private aa.b afI = new af(this);
    private ViewEventCenter bxK = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Je();
    }

    public void hr(int i) {
        if (this.bxC != null && this.bxC.Vg() != null && this.bxC.Vg().getLayoutParams() != null) {
            this.bxC.Vg().getLayoutParams().height = i;
            this.bxC.Vg().setLayoutParams(this.bxC.Vg().getLayoutParams());
        }
    }

    public l(f fVar) {
        this.bxD = null;
        this.isFirst = true;
        this.bxE = false;
        this.bxH = -1L;
        this.bxB = fVar;
        this.aQU = fVar.getBaseFragmentActivity();
        this.bxK.addEventDelegate(this);
        this.bxH = System.currentTimeMillis();
        this.isFirst = true;
        this.bxE = false;
        this.bxF = "";
        this.bxD = new EnterForumModel(this.aQU.getPageContext());
        this.bxJ = this.bxD.US();
        this.Fq = new LikeModel(this.aQU.getPageContext());
        this.Fq.setLoadDataCallBack(this.bxS);
        this.bxD.a(this.bxT);
        com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.UF().k(this.bxB.getFragmentActivity(), com.baidu.adp.lib.util.k.m(this.bxB.getFragmentActivity()));
        initUI();
        Mj();
    }

    private void Mj() {
        Uz();
        this.bxB.registerListener(this.bxR);
        this.bxB.registerListener(this.bxQ);
        this.bxB.registerListener(this.aQV);
        this.bxB.registerListener(this.bxO);
        this.bxB.registerListener(this.bxP);
        this.bxB.registerListener(this.bxU);
    }

    private static void Je() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ux() {
        return (this.bxD.d(this.bxC.Vm(), this.bxC.Vn()) && (this.bxC.UV() == this.bxC.Vb())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bxC.Vi();
    }

    private void Uz() {
        this.bxB.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bxB.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void UA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQU.getPageContext().getPageActivity());
        aVar.ca(r.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(r.l.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(r.l.cancel), new q(this));
        aVar.b(this.aQU.getPageContext());
        aVar.sV();
    }

    private void UB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQU.getPageContext().getPageActivity());
        aVar.ca(r.l.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m9getInst().getString(r.l.hide), new r(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(r.l.cancel), new s(this));
        aVar.b(this.aQU.getPageContext());
        aVar.sV();
    }

    public void a(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQU.getPageContext().getPageActivity());
            aVar.cE(String.format(this.aQU.getPageContext().getString(r.l.attention_cancel_dialog_content), uVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(r.l.confirm), new t(this, uVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(r.l.cancel), new u(this));
            aVar.b(this.aQU.getPageContext());
            aVar.sV();
        }
    }

    public void dd(boolean z) {
        if (this.bxL == null) {
            UC();
        }
        this.bxL.aJ(z);
    }

    private void UC() {
        this.bxL = new com.baidu.tbadk.core.view.a(this.aQU.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aQU.getActivity()).inflate(r.j.enter_forum_view, (ViewGroup) null);
        this.bxC = new com.baidu.tieba.enterForum.c.e(this.bxB, this.mRootView, this.bxK);
        this.bxC.a(this.afI);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void de(boolean z) {
        if (this.bxC != null && this.bxB != null) {
            if (z) {
                if (this.bxB.isPrimary() && this.bxB.isResumed()) {
                    this.bxC.startPullRefresh();
                    return;
                } else {
                    this.bxC.Vk();
                    return;
                }
            }
            this.bxC.Vk();
        }
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            this.aQU.showToast(str);
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_BANNER_NO_AD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bxB.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.bxC != null) {
            c(bVar);
            b(bVar);
            com.baidu.tieba.enterForum.b.e Uf = bVar.Uf();
            if (Uf != null && Uf.Uk() != null) {
                int size = Uf.Uk().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bxC.dj(true);
                        } else {
                            this.bxC.dj(false);
                        }
                    } else {
                        this.bxC.dj(false);
                    }
                    boolean aM = this.bxD.aM(this.bxJ);
                    List<com.baidu.tieba.enterForum.b.g> Uo = bVar.Ub() != null ? bVar.Ub().Uo() : null;
                    boolean z = aM && !com.baidu.tbadk.core.util.w.s(Uo);
                    if (z) {
                        this.bxC.ak(Uo);
                    } else {
                        this.bxC.Vp();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.w.s(Uo)) {
                        this.bxC.ak(Uo);
                    }
                } else {
                    this.bxC.Vp();
                    this.bxC.dj(false);
                }
            }
            af(Uf != null ? Uf.Uk() : null);
            if (TbadkCoreApplication.isLogin() && Uf != null && Uf.Uk() != null && Uf.Uk().size() > 0) {
                this.bxC.setAttentionTitleVisibililty(true);
            } else {
                this.bxC.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.tQ().getString("hot_search_title", ""));
            this.bxC.Vq();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.bxC != null) {
            this.bxC.f(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.b.e.dL().ac("ad_baichuan_open") != 0 && this.bxC != null) {
            View bannerView = this.bxC.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bxC.ag(bannerView2);
                    this.bxG = false;
                }
            } else if (this.bxG) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bxC.ag(bannerView3);
                    TiebaStatic.log(new ar("c10807"));
                    this.bxG = false;
                }
            } else {
                ae(bannerView);
            }
        }
    }

    private void ae(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int I = com.baidu.adp.lib.util.k.I(this.aQU.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.e(this.aQU.getPageContext(), (int) ((0.16875f * I) + 0.5d), I, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bxC.setSearchHint(str.trim());
        } else {
            this.bxC.setSearchHint(this.aQU.getActivity().getString(r.l.enter_forum_search_tip));
        }
    }

    private void af(List<com.baidu.tieba.tbadkCore.u> list) {
        if (list != null) {
            int ht = this.bxD.ht(0);
            if (ht == 0) {
                if (list.size() > 8) {
                    ht = 2;
                } else {
                    ht = 1;
                }
            }
            this.bxC.hw(ht);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bxC.an(this.bxD.a(list, this.bxD.UR()));
        }
    }

    public void MR() {
        if (this.bxC != null) {
            df(false);
            if (!this.bxB.isPrimary() && this.bxN != null) {
                this.bxN.dismiss();
            }
        }
    }

    public void onDestroy() {
        DY();
        com.baidu.tieba.enterForum.model.a.UF().destroy();
        if (this.bxC != null && this.bxC.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.bxC.getBannerView()), (Class) null);
        }
        if (this.bxC != null) {
            this.bxC.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bxC != null) {
            this.bxC.onChangeSkinType(i);
        }
    }

    public void DY() {
        if (this.bxD != null) {
            this.bxD.cancelLoadData();
        }
    }

    public void df(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bxM && this.bxD != null && this.bxC != null) {
            String str = this.bxF;
            this.bxF = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bxF == null || this.bxF.equals(str)) {
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = true;
            }
            if (TbadkCoreApplication.m9getInst().getLikeBarChanged()) {
                TbadkCoreApplication.m9getInst().setLikeBarChanged(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TbadkCoreApplication.m9getInst().signedForumCount() > 0) {
                if (this.bxD != null && this.bxD.UO() != null && this.bxD.UO().Uf() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.u> it = this.bxD.UO().Uf().Uk().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.u next = it.next();
                        if (TbadkCoreApplication.m9getInst().hasSignedForum(next.getName())) {
                            next.es(1);
                            int signLevelUpValue = TbadkCoreApplication.m9getInst().getSignLevelUpValue(next.getName());
                            if (signLevelUpValue > 0) {
                                next.setLevel(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().clearSignedForum();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.tbadkCore.util.l.qH(currentAccount);
                }
                this.bxC.notifyDataSetChanged();
            }
            if (z2 || z4) {
                DY();
                if (z4) {
                    this.bxC.startPullRefresh();
                } else if (z2) {
                    this.bxD.di(StringUtils.isNull(this.bxF) ? false : true);
                    this.bxC.startPullRefresh();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    public void onPause() {
        if (this.bxC != null && this.bxC.Vf() != null) {
            this.bxC.Vf().completePullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.u, Integer, String> {
        private com.baidu.tieba.tbadkCore.u byc;
        private com.baidu.tbadk.core.util.y mNetwork = null;

        public a(com.baidu.tieba.tbadkCore.u uVar) {
            this.byc = null;
            this.byc = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.u... uVarArr) {
            com.baidu.tieba.tbadkCore.u uVar = this.byc;
            if (uVar != null) {
                try {
                    if (uVar.getId() != null && uVar.getName() != null) {
                        this.mNetwork = new com.baidu.tbadk.core.util.y(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", uVar.getId());
                        this.mNetwork.n("kw", uVar.getName());
                        this.mNetwork.uC().vv().mIsNeedTbs = true;
                        this.mNetwork.ud();
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
            l.this.dd(false);
            if (this.mNetwork != null) {
                if (!this.mNetwork.uC().vw().isRequestSuccess()) {
                    if (l.this.aQU != null) {
                        if (StringUtils.isNull(this.mNetwork.getErrorString())) {
                            if (l.this.bxB.isAdded()) {
                                l.this.aQU.showToast(l.this.aQU.getActivity().getString(r.l.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        l.this.aQU.showToast(this.mNetwork.getErrorString());
                        return;
                    }
                    return;
                }
                l.this.bxI = true;
                if (l.this.bxB.isAdded() && l.this.aQU != null) {
                    l.this.aQU.showToast(l.this.aQU.getActivity().getString(r.l.unlike_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                l.this.f(false, this.byc.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.byc.getId()));
                long c = com.baidu.adp.lib.g.b.c(this.byc.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                l.this.bxC.b(this.byc);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            l.this.dd(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ee();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new v(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Es = bVar.Es();
        com.baidu.tbadk.mvc.b.a Et = bVar.Et();
        switch (Es) {
            case 1:
                if (Et instanceof com.baidu.tieba.tbadkCore.u) {
                    String name = ((com.baidu.tieba.tbadkCore.u) Et).getName();
                    if (at.aM(name)) {
                        TiebaStatic.eventStat(this.aQU.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aQU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aQU.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, ir(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("enter_forum_edit_mode", true);
                this.bxC.hu(Et instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) Et).getPosition() : 0);
                this.bxI = false;
                if (this.bxB.getView() != null && this.bxB.getView().getParent() != null) {
                    this.bxB.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Et instanceof com.baidu.tieba.tbadkCore.u) {
                    a((com.baidu.tieba.tbadkCore.u) Et);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.bxC.Vd() != null) {
                    arrayList.addAll(this.bxC.Vd());
                }
                List<com.baidu.tieba.tbadkCore.u> ah = this.bxD.ah(this.bxC.Vd());
                if (!arrayList.isEmpty() && this.bxD.d(arrayList, ah)) {
                    this.aQU.showToast(r.l.enter_forum_sort_already);
                } else {
                    this.bxC.aj(ah);
                }
                return true;
            case 7:
                this.bxC.Ve();
                return true;
            case 8:
                UB();
                return true;
            case 9:
                this.bxC.Vo();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aQU.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Et instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) Et;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (at.aM(forumName)) {
                        TiebaStatic.log(new ar("c10358").ab("fid", valueOf));
                        TiebaStatic.eventStat(this.aQU.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.Fq.ce(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Et instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar2 = (com.baidu.tieba.enterForum.b.g) Et;
                    String forumName2 = gVar2.getForumName();
                    String valueOf2 = String.valueOf(gVar2.getForumId());
                    if (at.aM(forumName2)) {
                        TiebaStatic.log(new ar("c10357").ab("fid", valueOf2));
                        TiebaStatic.eventStat(this.aQU.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aQU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aQU.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aQU.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aQU.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aQU.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aQU.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aQU.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aQU.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean ir(String str) {
        if (this.bxD == null || this.bxD.UO() == null || this.bxD.UO().Uc() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> Uh = this.bxD.UO().Uc().Uh();
        if (com.baidu.tbadk.core.util.w.s(Uh)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : Uh) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.w.s(eVar.BN());
            }
        }
        return false;
    }

    public void UD() {
        if (this.bxC != null) {
            this.bxC.Vj();
        }
    }

    public boolean UE() {
        if (this.bxC != null) {
            return this.bxC.UE();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lD() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aQU.getUniqueId();
    }

    public void dg(boolean z) {
        int i = 1;
        if (this.bxC != null && this.bxB != null) {
            boolean z2 = this.bxC.UE() && this.bxB.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
