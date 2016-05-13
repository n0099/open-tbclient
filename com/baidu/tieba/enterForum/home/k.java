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
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.x Dp;
    private BaseFragmentActivity aJw;
    private e aXj;
    private com.baidu.tieba.enterForum.c.c aXl;
    private boolean aXm;
    private String aXn;
    private long aXp;
    private boolean aXq;
    private long aXr;
    private com.baidu.tbadk.core.view.b aXt;
    private boolean aXv;
    private com.baidu.tbadk.core.dialog.a aXw;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.e.e aXk = null;
    private boolean aXo = false;
    private boolean aXu = true;
    private final CustomMessageListener aXx = new l(this, CmdConfigCustom.CMD_DISABLE_JUMP_IN_ENTER_FORUM);
    private final CustomMessageListener aJx = new v(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener aXy = new x(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener aXz = new y(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener aXA = new z(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a aXB = new ac(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aXC = new ad(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g aXD = new ae(this);
    private final c.b aXE = new af(this);
    private t.b acj = new m(this);
    private ViewEventCenter aXs = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Mx();
    }

    public void fO(int i) {
        if (this.aXk != null && this.aXk.Nl() != null && this.aXk.Nl().getLayoutParams() != null) {
            this.aXk.Nl().getLayoutParams().height = i;
            this.aXk.Nl().setLayoutParams(this.aXk.Nl().getLayoutParams());
        }
    }

    public k(e eVar) {
        this.aXl = null;
        this.isFirst = true;
        this.aXm = false;
        this.aXp = -1L;
        this.aXj = eVar;
        this.aJw = eVar.getBaseFragmentActivity();
        this.aXs.addEventDelegate(this);
        this.aXp = System.currentTimeMillis();
        this.isFirst = true;
        this.aXm = false;
        this.aXn = "";
        this.aXl = new com.baidu.tieba.enterForum.c.c(this.aJw.getPageContext());
        this.aXr = this.aXl.MX();
        this.Dp = new com.baidu.tieba.tbadkCore.x(this.aJw.getPageContext());
        this.Dp.setLoadDataCallBack(this.aXD);
        this.aXl.a(this.aXE);
        com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.MI().i(this.aXj.getFragmentActivity(), com.baidu.adp.lib.util.k.g(this.aXj.getFragmentActivity()));
        nq();
        lr();
    }

    private void lr() {
        MA();
        this.aXj.registerListener(this.aXC);
        this.aXj.registerListener(this.aXB);
        this.aXj.registerListener(this.aJx);
        this.aXj.registerListener(this.aXy);
        this.aXj.registerListener(this.aXz);
        this.aXj.registerListener(this.aXx);
        this.aXj.registerListener(this.aXA);
    }

    private static void Mx() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean My() {
        return (this.aXl.c(this.aXk.Nr(), this.aXk.Ns()) && (this.aXk.Na() == this.aXk.Ng())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.aXk.MF();
    }

    private void MA() {
        this.aXj.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.aXj.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void MB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aJw.getPageContext().getPageActivity());
        aVar.bL(t.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m11getInst().getString(t.j.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m11getInst().getString(t.j.cancel), new q(this));
        aVar.b(this.aJw.getPageContext());
        aVar.rV();
    }

    private void MC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aJw.getPageContext().getPageActivity());
        aVar.bL(t.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m11getInst().getString(t.j.hide), new r(this));
        aVar.b(TbadkCoreApplication.m11getInst().getString(t.j.cancel), new s(this));
        aVar.b(this.aJw.getPageContext());
        aVar.rV();
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (wVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aJw.getPageContext().getPageActivity());
            aVar.cA(String.format(this.aJw.getPageContext().getString(t.j.attention_cancel_dialog_content), wVar.getName()));
            aVar.a(TbadkCoreApplication.m11getInst().getString(t.j.confirm), new t(this, wVar));
            aVar.b(TbadkCoreApplication.m11getInst().getString(t.j.cancel), new u(this));
            aVar.b(this.aJw.getPageContext());
            aVar.rV();
        }
    }

    public void cq(boolean z) {
        if (this.aXt == null) {
            MD();
        }
        this.aXt.aD(z);
    }

    private void MD() {
        this.aXt = new com.baidu.tbadk.core.view.b(this.aJw.getPageContext());
    }

    private void nq() {
        this.mRootView = LayoutInflater.from(this.aJw.getActivity()).inflate(t.h.enter_forum_view, (ViewGroup) null);
        this.aXk = new com.baidu.tieba.enterForum.e.e(this.aXj, this.mRootView, this.aXs);
        this.aXk.a(this.acj);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void cr(boolean z) {
        if (this.aXk != null && this.aXj != null) {
            if (z) {
                if (this.aXj.isPrimary() && this.aXj.isResumed()) {
                    this.aXk.jy();
                    return;
                } else {
                    this.aXk.Np();
                    return;
                }
            }
            this.aXk.Np();
        }
    }

    public void f(boolean z, String str) {
        if (!z && str != null) {
            this.aJw.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.aXj.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        boolean z = true;
        if (bVar != null && this.aXk != null) {
            b(bVar);
            c(bVar);
            com.baidu.tieba.enterForum.b.d Mi = bVar.Mi();
            if (Mi != null && Mi.Mm() != null) {
                if (this.aXu && this.aXm) {
                    if (TbadkCoreApplication.isLogin()) {
                        int redirect = bVar.getRedirect();
                        if (redirect == 1) {
                            this.aJw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aJw.getActivity()).createNormalCfg(2)));
                        } else if (redirect == 2) {
                            this.aJw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aJw.getActivity()).createNormalCfg(2)));
                        }
                    } else {
                        this.aJw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aJw.getActivity()).createNormalCfg(2)));
                    }
                    this.aXu = false;
                }
                int size = Mi.Mm().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.aXk.cw(true);
                        } else {
                            this.aXk.cw(false);
                        }
                    } else {
                        this.aXk.cw(false);
                    }
                    boolean ay = this.aXl.ay(this.aXr);
                    List<com.baidu.tieba.enterForum.b.f> Mp = bVar.Mf() != null ? bVar.Mf().Mp() : null;
                    if (!ay || com.baidu.tbadk.core.util.y.s(Mp)) {
                        z = false;
                    }
                    if (z) {
                        this.aXk.U(Mp);
                    } else {
                        this.aXk.Nu();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.y.s(Mp)) {
                        this.aXk.U(Mp);
                    }
                } else {
                    this.aXk.Nu();
                    this.aXk.cw(false);
                }
            }
            P(Mi != null ? Mi.Mm() : null);
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.sR().getString("hot_search_title", ""));
            this.aXk.Nw();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.c.e.cS().Z("ad_baichuan_open") != 0 && this.aXk != null) {
            View bannerView = this.aXk.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.aXk.Y(bannerView2);
                    this.aXo = false;
                }
            } else if (this.aXo) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.aXk.Y(bannerView3);
                    TiebaStatic.log(new aw("c10807"));
                    this.aXo = false;
                }
            } else {
                W(bannerView);
            }
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        View togetherHiBannerView;
        if (com.baidu.tbadk.plugins.g.Fd() && this.aXk != null && this.aXk.getTogetherHiBannerView() == null && (togetherHiBannerView = getTogetherHiBannerView()) != null) {
            this.aXk.Z(togetherHiBannerView);
        }
    }

    private void W(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int B = com.baidu.adp.lib.util.k.B(this.aJw.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.a(this.aJw.getActivity(), this.aJw.getResources().getDimensionPixelSize(t.e.ds100), B, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    private View getTogetherHiBannerView() {
        int B = com.baidu.adp.lib.util.k.B(this.aJw.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_HI_GETENTERBANNER, View.class, new com.baidu.tbadk.coreExtra.data.m(this.aJw.getActivity(), this.aJw.getResources().getDimensionPixelSize(t.e.ds100), B, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.aXk.setSearchHint(str.trim());
        } else {
            this.aXk.setSearchHint(this.aJw.getActivity().getString(t.j.enter_forum_search_tip));
        }
    }

    private void P(List<com.baidu.tieba.tbadkCore.w> list) {
        if (list != null) {
            int fQ = this.aXl.fQ(0);
            if (fQ == 0) {
                if (list.size() > 8) {
                    fQ = 2;
                } else {
                    fQ = 1;
                }
            }
            this.aXk.fT(fQ);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aXk.X(this.aXl.a(list, this.aXl.MW()));
        }
    }

    public void ME() {
        if (this.aXk != null) {
            cs(false);
            if (!this.aXj.isPrimary() && this.aXw != null) {
                this.aXw.dismiss();
            }
        }
    }

    public void onDestroy() {
        CO();
        com.baidu.tieba.enterForum.c.a.MI().destroy();
        if (this.aXk != null && this.aXk.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.aXk.getBannerView()), (Class) null);
        }
        if (this.aXk != null) {
            this.aXk.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aXk != null) {
            this.aXk.onChangeSkinType(i);
        }
    }

    public void CO() {
        if (this.aXl != null) {
            this.aXl.cancelLoadData();
        }
    }

    public void cs(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aXv && this.aXl != null && this.aXk != null) {
            String str = this.aXn;
            this.aXn = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aXn == null || this.aXn.equals(str)) {
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = true;
            }
            if (TbadkCoreApplication.m11getInst().getLikeBarChanged()) {
                TbadkCoreApplication.m11getInst().setLikeBarChanged(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TbadkCoreApplication.m11getInst().signedForumCount() > 0) {
                if (this.aXl != null && this.aXl.MS() != null && this.aXl.MS().Mi() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.w> it = this.aXl.MS().Mi().Mm().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.w next = it.next();
                        if (TbadkCoreApplication.m11getInst().hasSignedForum(next.getName())) {
                            next.ph(1);
                            int signLevelUpValue = TbadkCoreApplication.m11getInst().getSignLevelUpValue(next.getName());
                            if (signLevelUpValue > 0) {
                                next.setLevel(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.m11getInst().clearSignedForum();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.tbadkCore.util.m.nW(currentAccount);
                }
                this.aXk.notifyDataSetChanged();
            }
            if (z2 || z4) {
                CO();
                if (z4) {
                    this.aXk.jy();
                } else if (z2) {
                    this.aXl.cv(StringUtils.isNull(this.aXn) ? false : true);
                    this.aXk.jy();
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
        if (this.aXk != null && this.aXk.Nk() != null) {
            this.aXk.Nk().jx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.w, Integer, String> {
        private com.baidu.tieba.tbadkCore.w aXM;
        private com.baidu.tbadk.core.util.ab aeI = null;

        public a(com.baidu.tieba.tbadkCore.w wVar) {
            this.aXM = null;
            this.aXM = wVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.w... wVarArr) {
            com.baidu.tieba.tbadkCore.w wVar = this.aXM;
            if (wVar != null) {
                try {
                    if (wVar.getId() != null && wVar.getName() != null) {
                        this.aeI = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.aeI.n("fid", wVar.getId());
                        this.aeI.n("kw", wVar.getName());
                        this.aeI.tB().uv().mIsNeedTbs = true;
                        this.aeI.td();
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
        /* renamed from: eo */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            k.this.cq(false);
            if (this.aeI != null) {
                if (!this.aeI.tB().uw().nZ()) {
                    if (k.this.aJw != null) {
                        if (StringUtils.isNull(this.aeI.getErrorString())) {
                            if (k.this.aXj.isAdded()) {
                                k.this.aJw.showToast(k.this.aJw.getActivity().getString(t.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        k.this.aJw.showToast(this.aeI.getErrorString());
                        return;
                    }
                    return;
                }
                k.this.aXq = true;
                if (k.this.aXj.isAdded() && k.this.aJw != null) {
                    k.this.aJw.showToast(k.this.aJw.getActivity().getString(t.j.delete_like_success));
                }
                TbadkCoreApplication.m11getInst().setLikeBarChanged(true);
                k.this.g(false, this.aXM.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.aXM.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.aXM.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                k.this.aXk.b(this.aXM);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            k.this.cq(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
                this.aeI = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        new w(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Dk = bVar.Dk();
        com.baidu.tbadk.mvc.b.a Dl = bVar.Dl();
        switch (Dk) {
            case 1:
                if (Dl instanceof com.baidu.tieba.tbadkCore.w) {
                    String name = ((com.baidu.tieba.tbadkCore.w) Dl).getName();
                    if (ay.aL(name)) {
                        TiebaStatic.eventStat(this.aJw.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aJw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aJw.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("enter_forum_edit_mode", true);
                this.aXk.fR(Dl instanceof com.baidu.tieba.enterForum.b.e ? ((com.baidu.tieba.enterForum.b.e) Dl).getPosition() : 0);
                this.aXq = false;
                if (this.aXj.getView() != null && this.aXj.getView().getParent() != null) {
                    this.aXj.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Dl instanceof com.baidu.tieba.tbadkCore.w) {
                    a((com.baidu.tieba.tbadkCore.w) Dl);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aXk.Ni() != null) {
                    arrayList.addAll(this.aXk.Ni());
                }
                List<com.baidu.tieba.tbadkCore.w> R = this.aXl.R(this.aXk.Ni());
                if (!arrayList.isEmpty() && this.aXl.c(arrayList, R)) {
                    this.aJw.showToast(t.j.enter_forum_sort_already);
                } else {
                    this.aXk.T(R);
                }
                return true;
            case 7:
                this.aXk.Nj();
                return true;
            case 8:
                MC();
                return true;
            case 9:
                this.aXk.Nt();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aJw.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Dl instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar = (com.baidu.tieba.enterForum.b.f) Dl;
                    String forumName = fVar.getForumName();
                    String valueOf = String.valueOf(fVar.getForumId());
                    if (ay.aL(forumName)) {
                        TiebaStatic.log(new aw("c10358").ac("fid", valueOf));
                        TiebaStatic.eventStat(this.aJw.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.Dp.bH(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Dl instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar2 = (com.baidu.tieba.enterForum.b.f) Dl;
                    String forumName2 = fVar2.getForumName();
                    String valueOf2 = String.valueOf(fVar2.getForumId());
                    if (ay.aL(forumName2)) {
                        TiebaStatic.log(new aw("c10357").ac("fid", valueOf2));
                        TiebaStatic.eventStat(this.aJw.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aJw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aJw.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aJw.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aJw.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aJw.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aJw.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aJw.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aJw.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    public void MF() {
        if (this.aXk != null) {
            this.aXk.Nn();
        }
    }

    public void MG() {
        if (this.aXk != null) {
            this.aXk.No();
        }
    }

    public boolean MH() {
        if (this.aXk != null) {
            return this.aXk.MH();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kO() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aJw.getUniqueId();
    }

    public void ct(boolean z) {
        int i = 1;
        if (this.aXk != null && this.aXj != null) {
            boolean z2 = this.aXk.MH() && this.aXj.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
