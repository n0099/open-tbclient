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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.y DR;
    private BaseFragmentActivity aNO;
    private long bvA;
    private boolean bvB;
    private long bvC;
    private com.baidu.tbadk.core.view.b bvD;
    private boolean bvE;
    private com.baidu.tbadk.core.dialog.a bvF;
    private e bvu;
    private com.baidu.tieba.enterForum.c.c bvw;
    private boolean bvx;
    private String bvy;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.view.e bvv = null;
    private boolean bvz = false;
    private final CustomMessageListener aNP = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener bvG = new v(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener bvH = new x(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bvI = new y(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bvJ = new ab(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bvK = new ac(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g bvL = new ad(this);
    private final c.b bvM = new ae(this);
    private final CustomMessageListener bvN = new af(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private t.b ado = new m(this);
    private ViewEventCenter bgJ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Iu();
    }

    public void gO(int i) {
        if (this.bvv != null && this.bvv.Tu() != null && this.bvv.Tu().getLayoutParams() != null) {
            this.bvv.Tu().getLayoutParams().height = i;
            this.bvv.Tu().setLayoutParams(this.bvv.Tu().getLayoutParams());
        }
    }

    public k(e eVar) {
        this.bvw = null;
        this.isFirst = true;
        this.bvx = false;
        this.bvA = -1L;
        this.bvu = eVar;
        this.aNO = eVar.getBaseFragmentActivity();
        this.bgJ.addEventDelegate(this);
        this.bvA = System.currentTimeMillis();
        this.isFirst = true;
        this.bvx = false;
        this.bvy = "";
        this.bvw = new com.baidu.tieba.enterForum.c.c(this.aNO.getPageContext());
        this.bvC = this.bvw.Tg();
        this.DR = new com.baidu.tieba.tbadkCore.y(this.aNO.getPageContext());
        this.DR.setLoadDataCallBack(this.bvL);
        this.bvw.a(this.bvM);
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.SS().i(this.bvu.getFragmentActivity(), com.baidu.adp.lib.util.k.i(this.bvu.getFragmentActivity()));
        initUI();
        PO();
    }

    private void PO() {
        SL();
        this.bvu.registerListener(this.bvK);
        this.bvu.registerListener(this.bvJ);
        this.bvu.registerListener(this.aNP);
        this.bvu.registerListener(this.bvG);
        this.bvu.registerListener(this.bvH);
        this.bvu.registerListener(this.bvI);
        this.bvu.registerListener(this.bvN);
    }

    private static void Iu() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SJ() {
        return (this.bvw.e(this.bvv.TA(), this.bvv.TB()) && (this.bvv.Tj() == this.bvv.Tp())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bvv.SP();
    }

    private void SL() {
        this.bvu.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bvu.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void SM() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aNO.getPageContext().getPageActivity());
        aVar.bM(u.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m10getInst().getString(u.j.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m10getInst().getString(u.j.cancel), new q(this));
        aVar.b(this.aNO.getPageContext());
        aVar.rS();
    }

    private void SN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aNO.getPageContext().getPageActivity());
        aVar.bM(u.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m10getInst().getString(u.j.hide), new r(this));
        aVar.b(TbadkCoreApplication.m10getInst().getString(u.j.cancel), new s(this));
        aVar.b(this.aNO.getPageContext());
        aVar.rS();
    }

    public void a(com.baidu.tieba.tbadkCore.x xVar) {
        if (xVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aNO.getPageContext().getPageActivity());
            aVar.cz(String.format(this.aNO.getPageContext().getString(u.j.attention_cancel_dialog_content), xVar.getName()));
            aVar.a(TbadkCoreApplication.m10getInst().getString(u.j.confirm), new t(this, xVar));
            aVar.b(TbadkCoreApplication.m10getInst().getString(u.j.cancel), new u(this));
            aVar.b(this.aNO.getPageContext());
            aVar.rS();
        }
    }

    public void cO(boolean z) {
        if (this.bvD == null) {
            SO();
        }
        this.bvD.aE(z);
    }

    private void SO() {
        this.bvD = new com.baidu.tbadk.core.view.b(this.aNO.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aNO.getActivity()).inflate(u.h.enter_forum_view, (ViewGroup) null);
        this.bvv = new com.baidu.tieba.enterForum.view.e(this.bvu, this.mRootView, this.bgJ);
        this.bvv.a(this.ado);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void cP(boolean z) {
        if (this.bvv != null && this.bvu != null) {
            if (z) {
                if (this.bvu.isPrimary() && this.bvu.isResumed()) {
                    this.bvv.jA();
                    return;
                } else {
                    this.bvv.Ty();
                    return;
                }
            }
            this.bvv.Ty();
        }
    }

    public void f(boolean z, String str) {
        if (!z && str != null) {
            this.aNO.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bvu.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.bvv != null) {
            c(bVar);
            d(bVar);
            b(bVar);
            com.baidu.tieba.enterForum.b.e Ss = bVar.Ss();
            if (Ss != null && Ss.Sx() != null) {
                int size = Ss.Sx().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bvv.cU(true);
                        } else {
                            this.bvv.cU(false);
                        }
                    } else {
                        this.bvv.cU(false);
                    }
                    boolean aJ = this.bvw.aJ(this.bvC);
                    List<com.baidu.tieba.enterForum.b.g> SB = bVar.So() != null ? bVar.So().SB() : null;
                    boolean z = aJ && !com.baidu.tbadk.core.util.y.t(SB);
                    if (z) {
                        this.bvv.al(SB);
                    } else {
                        this.bvv.TD();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.y.t(SB)) {
                        this.bvv.al(SB);
                    }
                } else {
                    this.bvv.TD();
                    this.bvv.cU(false);
                }
            }
            ag(Ss != null ? Ss.Sx() : null);
            if (TbadkCoreApplication.isLogin() && Ss != null && Ss.Sx() != null && Ss.Sx().size() > 0) {
                this.bvv.setAttentionTitleVisibililty(true);
            } else {
                this.bvv.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.sN().getString("hot_search_title", ""));
            this.bvv.TF();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.bvv != null) {
            this.bvv.g(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.c.e.cS().ab("ad_baichuan_open") != 0 && this.bvv != null) {
            View bannerView = this.bvv.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bvv.aa(bannerView2);
                    this.bvz = false;
                }
            } else if (this.bvz) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bvv.aa(bannerView3);
                    TiebaStatic.log(new ay("c10807"));
                    this.bvz = false;
                }
            } else {
                Y(bannerView);
            }
        }
    }

    private void d(com.baidu.tieba.enterForum.b.b bVar) {
        View togetherHiBannerView;
        if (com.baidu.tbadk.plugins.g.Fl() && this.bvv != null && this.bvv.getTogetherHiBannerView() == null && (togetherHiBannerView = getTogetherHiBannerView()) != null) {
            this.bvv.ab(togetherHiBannerView);
        }
    }

    private void Y(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int A = com.baidu.adp.lib.util.k.A(this.aNO.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.b(this.aNO.getActivity(), (int) ((0.16875f * A) + 0.5d), A, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    private View getTogetherHiBannerView() {
        int A = com.baidu.adp.lib.util.k.A(this.aNO.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_HI_GETENTERBANNER, View.class, new com.baidu.tbadk.coreExtra.data.n(this.aNO.getActivity(), this.aNO.getResources().getDimensionPixelSize(u.e.ds100), A, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bvv.setSearchHint(str.trim());
        } else {
            this.bvv.setSearchHint(this.aNO.getActivity().getString(u.j.enter_forum_search_tip));
        }
    }

    private void ag(List<com.baidu.tieba.tbadkCore.x> list) {
        if (list != null) {
            int gQ = this.bvw.gQ(0);
            if (gQ == 0) {
                if (list.size() > 8) {
                    gQ = 2;
                } else {
                    gQ = 1;
                }
            }
            this.bvv.gT(gQ);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bvv.ao(this.bvw.a(list, this.bvw.Tf()));
        }
    }

    public void MI() {
        if (this.bvv != null) {
            cQ(false);
            if (!this.bvu.isPrimary() && this.bvF != null) {
                this.bvF.dismiss();
            }
        }
    }

    public void onDestroy() {
        CV();
        com.baidu.tieba.enterForum.c.a.SS().destroy();
        if (this.bvv != null && this.bvv.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.bvv.getBannerView()), (Class) null);
        }
        if (this.bvv != null) {
            this.bvv.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bvv != null) {
            this.bvv.onChangeSkinType(i);
        }
    }

    public void CV() {
        if (this.bvw != null) {
            this.bvw.cancelLoadData();
        }
    }

    public void cQ(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bvE && this.bvw != null && this.bvv != null) {
            String str = this.bvy;
            this.bvy = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bvy == null || this.bvy.equals(str)) {
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = true;
            }
            if (TbadkCoreApplication.m10getInst().getLikeBarChanged()) {
                TbadkCoreApplication.m10getInst().setLikeBarChanged(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TbadkCoreApplication.m10getInst().signedForumCount() > 0) {
                if (this.bvw != null && this.bvw.Tc() != null && this.bvw.Tc().Ss() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.x> it = this.bvw.Tc().Ss().Sx().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.x next = it.next();
                        if (TbadkCoreApplication.m10getInst().hasSignedForum(next.getName())) {
                            next.ea(1);
                            int signLevelUpValue = TbadkCoreApplication.m10getInst().getSignLevelUpValue(next.getName());
                            if (signLevelUpValue > 0) {
                                next.setLevel(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.m10getInst().clearSignedForum();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.tbadkCore.util.m.qo(currentAccount);
                }
                this.bvv.notifyDataSetChanged();
            }
            if (z2 || z4) {
                CV();
                if (z4) {
                    this.bvv.jA();
                } else if (z2) {
                    this.bvw.cT(StringUtils.isNull(this.bvy) ? false : true);
                    this.bvv.jA();
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
        if (this.bvv != null && this.bvv.Tt() != null) {
            this.bvv.Tt().jz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.x, Integer, String> {
        private com.baidu.tbadk.core.util.ab afX = null;
        private com.baidu.tieba.tbadkCore.x bvV;

        public a(com.baidu.tieba.tbadkCore.x xVar) {
            this.bvV = null;
            this.bvV = xVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.x... xVarArr) {
            com.baidu.tieba.tbadkCore.x xVar = this.bvV;
            if (xVar != null) {
                try {
                    if (xVar.getId() != null && xVar.getName() != null) {
                        this.afX = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.afX.n("fid", xVar.getId());
                        this.afX.n("kw", xVar.getName());
                        this.afX.tx().uu().mIsNeedTbs = true;
                        this.afX.sZ();
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
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            k.this.cO(false);
            if (this.afX != null) {
                if (!this.afX.tx().uv().nJ()) {
                    if (k.this.aNO != null) {
                        if (StringUtils.isNull(this.afX.getErrorString())) {
                            if (k.this.bvu.isAdded()) {
                                k.this.aNO.showToast(k.this.aNO.getActivity().getString(u.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        k.this.aNO.showToast(this.afX.getErrorString());
                        return;
                    }
                    return;
                }
                k.this.bvB = true;
                if (k.this.bvu.isAdded() && k.this.aNO != null) {
                    k.this.aNO.showToast(k.this.aNO.getActivity().getString(u.j.delete_like_success));
                }
                TbadkCoreApplication.m10getInst().setLikeBarChanged(true);
                k.this.g(false, this.bvV.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bvV.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.bvV.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                k.this.bvv.b(this.bvV);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            k.this.cO(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afX != null) {
                this.afX.dl();
                this.afX = null;
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
        int Dr = bVar.Dr();
        com.baidu.tbadk.mvc.b.a Ds = bVar.Ds();
        switch (Dr) {
            case 1:
                if (Ds instanceof com.baidu.tieba.tbadkCore.x) {
                    String name = ((com.baidu.tieba.tbadkCore.x) Ds).getName();
                    if (ba.aM(name)) {
                        TiebaStatic.eventStat(this.aNO.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aNO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aNO.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, iC(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("enter_forum_edit_mode", true);
                this.bvv.gR(Ds instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) Ds).getPosition() : 0);
                this.bvB = false;
                if (this.bvu.getView() != null && this.bvu.getView().getParent() != null) {
                    this.bvu.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Ds instanceof com.baidu.tieba.tbadkCore.x) {
                    a((com.baidu.tieba.tbadkCore.x) Ds);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.bvv.Tr() != null) {
                    arrayList.addAll(this.bvv.Tr());
                }
                List<com.baidu.tieba.tbadkCore.x> ai = this.bvw.ai(this.bvv.Tr());
                if (!arrayList.isEmpty() && this.bvw.e(arrayList, ai)) {
                    this.aNO.showToast(u.j.enter_forum_sort_already);
                } else {
                    this.bvv.ak(ai);
                }
                return true;
            case 7:
                this.bvv.Ts();
                return true;
            case 8:
                SN();
                return true;
            case 9:
                this.bvv.TC();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aNO.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Ds instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) Ds;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (ba.aM(forumName)) {
                        TiebaStatic.log(new ay("c10358").ab("fid", valueOf));
                        TiebaStatic.eventStat(this.aNO.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.DR.bO(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Ds instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar2 = (com.baidu.tieba.enterForum.b.g) Ds;
                    String forumName2 = gVar2.getForumName();
                    String valueOf2 = String.valueOf(gVar2.getForumId());
                    if (ba.aM(forumName2)) {
                        TiebaStatic.log(new ay("c10357").ab("fid", valueOf2));
                        TiebaStatic.eventStat(this.aNO.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aNO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aNO.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aNO.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aNO.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aNO.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aNO.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aNO.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aNO.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean iC(String str) {
        if (this.bvw == null || this.bvw.Tc() == null || this.bvw.Tc().Sp() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> Su = this.bvw.Tc().Sp().Su();
        if (com.baidu.tbadk.core.util.y.t(Su)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : Su) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.y.t(eVar.AH());
            }
        }
        return false;
    }

    public void SP() {
        if (this.bvv != null) {
            this.bvv.Tw();
        }
    }

    public void SQ() {
        if (this.bvv != null) {
            this.bvv.Tx();
        }
    }

    public boolean SR() {
        if (this.bvv != null) {
            return this.bvv.SR();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kN() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aNO.getUniqueId();
    }

    public void cR(boolean z) {
        int i = 1;
        if (this.bvv != null && this.bvu != null) {
            boolean z2 = this.bvv.SR() && this.bvu.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
