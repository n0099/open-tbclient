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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.x MB;
    private BaseFragmentActivity aJl;
    private e aUk;
    private com.baidu.tieba.enterForum.c.c aUm;
    private boolean aUn;
    private String aUo;
    private long aUp;
    private boolean aUq;
    private long aUr;
    private com.baidu.tbadk.core.view.b aUt;
    private boolean aUv;
    private com.baidu.tbadk.core.dialog.a aUw;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.d.e aUl = null;
    private boolean aUu = true;
    private final CustomMessageListener aUx = new j(this, CmdConfigCustom.CMD_DISABLE_JUMP_IN_ENTER_FORUM);
    private final CustomMessageListener aJm = new t(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener aUy = new u(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener aUz = new v(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private com.baidu.adp.framework.listener.a aUA = new w(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aUB = new x(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g aUC = new y(this);
    private final c.b aUD = new z(this);
    private r.a ago = new aa(this);
    private ViewEventCenter aUs = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Kf();
    }

    public i(e eVar) {
        this.aUm = null;
        this.isFirst = true;
        this.aUn = false;
        this.aUp = -1L;
        this.aUk = eVar;
        this.aJl = eVar.getBaseFragmentActivity();
        this.aUs.addEventDelegate(this);
        this.aUp = System.currentTimeMillis();
        this.isFirst = true;
        this.aUn = false;
        this.aUo = "";
        this.aUm = new com.baidu.tieba.enterForum.c.c(this.aJl.getPageContext());
        this.aUr = this.aUm.KD();
        this.MB = new com.baidu.tieba.tbadkCore.x(this.aJl.getPageContext());
        this.MB.setLoadDataCallBack(this.aUC);
        this.aUm.a(this.aUD);
        com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.Ko().j(this.aUk.getFragmentActivity(), com.baidu.adp.lib.util.k.l(this.aUk.getFragmentActivity()));
        initUI();
        initListener();
    }

    private void initListener() {
        Ki();
        this.aUk.registerListener(this.aUB);
        this.aUk.registerListener(this.aUA);
        this.aUk.registerListener(this.aJm);
        this.aUk.registerListener(this.aUy);
        this.aUk.registerListener(this.aUz);
        this.aUk.registerListener(this.aUx);
    }

    private static void Kf() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kg() {
        return (this.aUm.c(this.aUl.KV(), this.aUl.KW()) && (this.aUl.KG() == this.aUl.KO())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.aUl.KU();
    }

    private void Ki() {
        this.aUk.registerListener(new k(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.aUk.registerListener(new l(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void Kj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aJl.getPageContext().getPageActivity());
        aVar.bG(n.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(n.j.enter_forum_cancel_change), new m(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(n.j.cancel), new n(this));
        aVar.b(this.aJl.getPageContext());
        aVar.tf();
    }

    private void Kk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aJl.getPageContext().getPageActivity());
        aVar.bG(n.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(n.j.hide), new o(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(n.j.cancel), new p(this));
        aVar.b(this.aJl.getPageContext());
        aVar.tf();
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (wVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aJl.getPageContext().getPageActivity());
            aVar.cF(String.format(this.aJl.getPageContext().getString(n.j.attention_cancel_dialog_content), wVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(n.j.confirm), new q(this, wVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(n.j.cancel), new r(this));
            aVar.b(this.aJl.getPageContext());
            aVar.tf();
        }
    }

    public void bZ(boolean z) {
        if (this.aUt == null) {
            Kl();
        }
        this.aUt.av(z);
    }

    private void Kl() {
        this.aUt = new com.baidu.tbadk.core.view.b(this.aJl.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aJl.getActivity()).inflate(n.h.enter_forum_view, (ViewGroup) null);
        this.aUl = new com.baidu.tieba.enterForum.d.e(this.aUk, this.mRootView, this.aUs);
        this.aUl.a(this.ago);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void ca(boolean z) {
        if (this.aUl != null && this.aUk != null) {
            if (z) {
                if (this.aUk.isPrimary() && this.aUk.isResumed()) {
                    this.aUl.nb();
                    return;
                } else {
                    this.aUl.KK();
                    return;
                }
            }
            this.aUl.KK();
        }
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            this.aJl.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.aUk.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.aUl != null) {
            Km();
            com.baidu.tieba.enterForum.b.d JT = bVar.JT();
            if (JT != null && JT.JW() != null) {
                if (this.aUu && this.aUn) {
                    int redirect = bVar.getRedirect();
                    if (redirect == 1) {
                        this.aJl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aJl.getActivity()).createNormalCfg(7)));
                    } else if (redirect == 2) {
                        this.aJl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aJl.getActivity()).createNormalCfg(2)));
                    }
                    this.aUu = false;
                }
                int size = JT.JW().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.aUl.cf(true);
                        } else {
                            this.aUl.cf(false);
                        }
                    } else {
                        this.aUl.cf(false);
                    }
                    boolean as = this.aUm.as(this.aUr);
                    List<com.baidu.tieba.enterForum.b.f> Ka = bVar.JS() != null ? bVar.JS().Ka() : null;
                    if (!as || Ka == null || Ka.isEmpty()) {
                        this.aUl.KY();
                    } else {
                        this.aUl.X(Ka);
                    }
                    if (!TbadkCoreApplication.isLogin() && Ka != null && !Ka.isEmpty()) {
                        this.aUl.X(Ka);
                    }
                } else {
                    this.aUl.KY();
                    this.aUl.cf(false);
                }
            }
            N(JT != null ? JT.JW() : null);
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.tJ().getString("hot_search_title", ""));
        }
    }

    private void Km() {
        if (com.baidu.adp.lib.c.e.gw().aj("ad_baichuan_open") != 0 && this.aUl != null) {
            View bannerView = this.aUl.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.aUl.E(bannerView2);
                    return;
                }
                return;
            }
            D(bannerView);
        }
    }

    private void D(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int K = com.baidu.adp.lib.util.k.K(this.aJl.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.a(this.aJl.getActivity(), this.aJl.getResources().getDimensionPixelSize(n.e.ds100), K, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.aUl.setSearchHint(str.trim());
        } else {
            this.aUl.setSearchHint(this.aJl.getActivity().getString(n.j.enter_forum_search_tip));
        }
    }

    private void N(List<com.baidu.tieba.tbadkCore.w> list) {
        if (list != null) {
            int fu = this.aUm.fu(0);
            if (fu == 0) {
                if (list.size() > 8) {
                    fu = 2;
                } else {
                    fu = 1;
                }
            }
            this.aUl.fz(fu);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aUl.aa(this.aUm.a(list, this.aUm.KC()));
        }
    }

    public void Kn() {
        if (this.aUl != null) {
            cb(false);
            if (!this.aUk.isPrimary() && this.aUw != null) {
                this.aUw.dismiss();
            }
        }
    }

    public void onDestroy() {
        CS();
        com.baidu.tieba.enterForum.c.a.Ko().destroy();
    }

    public void onChangeSkinType(int i) {
        if (this.aUl != null) {
            this.aUl.onChangeSkinType(i);
        }
    }

    public void CS() {
        if (this.aUm != null) {
            this.aUm.cancelLoadData();
        }
    }

    public void cb(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aUv && this.aUm != null && this.aUl != null) {
            String str = this.aUo;
            this.aUo = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aUo == null || this.aUo.equals(str)) {
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
                if (this.aUm != null && this.aUm.Ky() != null && this.aUm.Ky().JT() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.w> it = this.aUm.Ky().JT().JW().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.w next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.mS(1);
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
                    com.baidu.tieba.tbadkCore.util.m.mw(currentAccount);
                }
                this.aUl.notifyDataSetChanged();
            }
            if (z2 || z4) {
                CS();
                if (z4) {
                    this.aUl.nb();
                } else if (z2) {
                    this.aUm.ce(StringUtils.isNull(this.aUo) ? false : true);
                    this.aUl.nb();
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
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.w, Integer, String> {
        private com.baidu.tieba.tbadkCore.w aUI;
        private ab ahV = null;

        public a(com.baidu.tieba.tbadkCore.w wVar) {
            this.aUI = null;
            this.aUI = wVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.w... wVarArr) {
            com.baidu.tieba.tbadkCore.w wVar = this.aUI;
            if (wVar != null) {
                try {
                    if (wVar.getId() != null && wVar.getName() != null) {
                        this.ahV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.ahV.o(ImageViewerConfig.FORUM_ID, wVar.getId());
                        this.ahV.o("kw", wVar.getName());
                        this.ahV.uw().vp().mIsNeedTbs = true;
                        this.ahV.tV();
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
            i.this.bZ(false);
            if (this.ahV != null) {
                if (!this.ahV.uw().vq().qO()) {
                    if (i.this.aJl != null) {
                        if (StringUtils.isNull(this.ahV.getErrorString())) {
                            if (i.this.aUk.isAdded()) {
                                i.this.aJl.showToast(i.this.aJl.getActivity().getString(n.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        i.this.aJl.showToast(this.ahV.getErrorString());
                        return;
                    }
                    return;
                }
                i.this.aUq = true;
                if (i.this.aUk.isAdded() && i.this.aJl != null) {
                    i.this.aJl.showToast(i.this.aJl.getActivity().getString(n.j.delete_like_success));
                }
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                i.this.e(false, this.aUI.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.aUI.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.aUI.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                i.this.aUl.b(this.aUI);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            i.this.bZ(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ahV != null) {
                this.ahV.gL();
                this.ahV = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new s(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Dj = bVar.Dj();
        com.baidu.tbadk.mvc.b.a Dk = bVar.Dk();
        switch (Dj) {
            case 1:
                if (Dk instanceof com.baidu.tieba.tbadkCore.w) {
                    String name = ((com.baidu.tieba.tbadkCore.w) Dk).getName();
                    if (ax.aR(name)) {
                        TiebaStatic.eventStat(this.aJl.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aJl.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aJl.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("enter_forum_edit_mode", true);
                this.aUl.fx(Dk instanceof com.baidu.tieba.enterForum.b.e ? ((com.baidu.tieba.enterForum.b.e) Dk).getPosition() : 0);
                this.aUq = false;
                if (this.aUk.getView() != null && this.aUk.getView().getParent() != null) {
                    this.aUk.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Dk instanceof com.baidu.tieba.tbadkCore.w) {
                    a((com.baidu.tieba.tbadkCore.w) Dk);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aUl.KQ() != null) {
                    arrayList.addAll(this.aUl.KQ());
                }
                List<com.baidu.tieba.tbadkCore.w> P = this.aUm.P(this.aUl.KQ());
                if (!arrayList.isEmpty() && this.aUm.c(arrayList, P)) {
                    this.aJl.showToast(n.j.enter_forum_sort_already);
                } else {
                    this.aUl.W(P);
                }
                return true;
            case 7:
                this.aUl.KR();
                return true;
            case 8:
                Kk();
                return true;
            case 9:
                this.aUl.KX();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aJl.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Dk instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar = (com.baidu.tieba.enterForum.b.f) Dk;
                    String forumName = fVar.getForumName();
                    String valueOf = String.valueOf(fVar.getForumId());
                    if (ax.aR(forumName)) {
                        TiebaStatic.log(new av("c10358").aa(ImageViewerConfig.FORUM_ID, valueOf));
                        TiebaStatic.eventStat(this.aJl.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.MB.bc(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Dk instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar2 = (com.baidu.tieba.enterForum.b.f) Dk;
                    String forumName2 = fVar2.getForumName();
                    String valueOf2 = String.valueOf(fVar2.getForumId());
                    if (ax.aR(forumName2)) {
                        TiebaStatic.log(new av("c10357").aa(ImageViewerConfig.FORUM_ID, valueOf2));
                        TiebaStatic.eventStat(this.aJl.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aJl.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aJl.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aJl.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aJl.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aJl.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aJl.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aJl.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aJl.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean on() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aJl.getUniqueId();
    }

    public void cc(boolean z) {
        int i = 1;
        if (this.aUl != null && this.aUk != null) {
            boolean z2 = this.aUl.KS() && this.aUk.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
