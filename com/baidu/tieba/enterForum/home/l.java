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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity aXf;
    private f bEH;
    private EnterForumModel bEJ;
    private boolean bEK;
    private String bEL;
    private long bEN;
    private boolean bEO;
    private long bEP;
    private com.baidu.tbadk.core.view.a bER;
    private boolean bES;
    private com.baidu.tbadk.core.dialog.a bET;
    private LikeModel brY;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.e bEI = null;
    private boolean bEM = false;
    private final CustomMessageListener aXg = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private CustomMessageListener bEU = new w(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bEV = new x(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bEW = new aa(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bEX = new ab(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.f bEY = new ac(this);
    private final EnterForumModel.b bEZ = new ad(this);
    private final CustomMessageListener bFa = new ae(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private ab.b ala = new af(this);
    private ViewEventCenter bEQ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        JJ();
    }

    public void hn(int i) {
        if (this.bEI != null && this.bEI.We() != null && this.bEI.We().getLayoutParams() != null) {
            this.bEI.We().getLayoutParams().height = i;
            this.bEI.We().setLayoutParams(this.bEI.We().getLayoutParams());
        }
    }

    public l(f fVar) {
        this.bEJ = null;
        this.isFirst = true;
        this.bEK = false;
        this.bEN = -1L;
        this.bEH = fVar;
        this.aXf = fVar.getBaseFragmentActivity();
        this.bEQ.addEventDelegate(this);
        this.bEN = System.currentTimeMillis();
        this.isFirst = true;
        this.bEK = false;
        this.bEL = "";
        this.bEJ = new EnterForumModel(this.aXf.getPageContext());
        this.bEP = this.bEJ.VQ();
        this.brY = new LikeModel(this.aXf.getPageContext());
        this.brY.setLoadDataCallBack(this.bEY);
        this.bEJ.a(this.bEZ);
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.VD().m(this.bEH.getFragmentActivity(), com.baidu.adp.lib.util.k.m(this.bEH.getFragmentActivity()));
        initUI();
        MV();
    }

    private void MV() {
        Vx();
        this.bEH.registerListener(this.bEX);
        this.bEH.registerListener(this.bEW);
        this.bEH.registerListener(this.aXg);
        this.bEH.registerListener(this.bEU);
        this.bEH.registerListener(this.bEV);
        this.bEH.registerListener(this.bFa);
    }

    private static void JJ() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vv() {
        return (this.bEJ.e(this.bEI.Wk(), this.bEI.Wl()) && (this.bEI.VT() == this.bEI.VZ())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bEI.Wg();
    }

    private void Vx() {
        this.bEH.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bEH.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void Vy() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXf.getPageContext().getPageActivity());
        aVar.bW(w.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new q(this));
        aVar.b(this.aXf.getPageContext());
        aVar.ts();
    }

    private void Vz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXf.getPageContext().getPageActivity());
        aVar.bW(w.l.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.hide), new r(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new s(this));
        aVar.b(this.aXf.getPageContext());
        aVar.ts();
    }

    public void a(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXf.getPageContext().getPageActivity());
            aVar.cx(String.format(this.aXf.getPageContext().getString(w.l.attention_cancel_dialog_content), uVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.confirm), new t(this, uVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new u(this));
            aVar.b(this.aXf.getPageContext());
            aVar.ts();
        }
    }

    public void dd(boolean z) {
        if (this.bER == null) {
            VA();
        }
        this.bER.aI(z);
    }

    private void VA() {
        this.bER = new com.baidu.tbadk.core.view.a(this.aXf.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aXf.getActivity()).inflate(w.j.enter_forum_view, (ViewGroup) null);
        this.bEI = new com.baidu.tieba.enterForum.c.e(this.bEH, this.mRootView, this.bEQ);
        this.bEI.a(this.ala);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void de(boolean z) {
        if (this.bEI != null && this.bEH != null) {
            if (z) {
                if (this.bEH.isPrimary() && this.bEH.isResumed()) {
                    this.bEI.startPullRefresh();
                    return;
                } else {
                    this.bEI.Wi();
                    return;
                }
            }
            this.bEI.Wi();
        }
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            this.aXf.showToast(str);
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_BANNER_NO_AD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bEH.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.bEI != null) {
            c(bVar);
            b(bVar);
            com.baidu.tieba.enterForum.b.e Vd = bVar.Vd();
            if (Vd != null && Vd.Vi() != null) {
                int size = Vd.Vi().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bEI.dj(true);
                        } else {
                            this.bEI.dj(false);
                        }
                    } else {
                        this.bEI.dj(false);
                    }
                    boolean aM = this.bEJ.aM(this.bEP);
                    List<com.baidu.tieba.enterForum.b.g> Vm = bVar.UZ() != null ? bVar.UZ().Vm() : null;
                    boolean z = aM && !com.baidu.tbadk.core.util.x.q(Vm);
                    if (z) {
                        this.bEI.ah(Vm);
                    } else {
                        this.bEI.Wn();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.x.q(Vm)) {
                        this.bEI.ah(Vm);
                    }
                } else {
                    this.bEI.Wn();
                    this.bEI.dj(false);
                }
            }
            ac(Vd != null ? Vd.Vi() : null);
            if (TbadkCoreApplication.isLogin() && Vd != null && Vd.Vi() != null && Vd.Vi().size() > 0) {
                this.bEI.setAttentionTitleVisibililty(true);
            } else {
                this.bEI.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.uo().getString("hot_search_title", ""));
            this.bEI.Wo();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.bEI != null) {
            this.bEI.f(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.b.e.eT().ab("ad_baichuan_open") != 0 && this.bEI != null) {
            View bannerView = this.bEI.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bEI.ae(bannerView2);
                    this.bEM = false;
                }
            } else if (this.bEM) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bEI.ae(bannerView3);
                    TiebaStatic.log(new as("c10807"));
                    this.bEM = false;
                }
            } else {
                ac(bannerView);
            }
        }
    }

    private void ac(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int ag = com.baidu.adp.lib.util.k.ag(this.aXf.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.e(this.aXf.getPageContext(), (int) ((0.16875f * ag) + 0.5d), ag, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bEI.setSearchHint(str.trim());
        } else {
            this.bEI.setSearchHint(this.aXf.getActivity().getString(w.l.enter_forum_search_tip));
        }
    }

    private void ac(List<com.baidu.tieba.tbadkCore.u> list) {
        if (list != null) {
            int hp = this.bEJ.hp(0);
            if (hp == 0) {
                if (list.size() > 8) {
                    hp = 2;
                } else {
                    hp = 1;
                }
            }
            this.bEI.hs(hp);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bEI.ak(this.bEJ.a(list, this.bEJ.VP()));
        }
    }

    public void NE() {
        if (this.bEI != null) {
            df(false);
            if (!this.bEH.isPrimary() && this.bET != null) {
                this.bET.dismiss();
            }
        }
    }

    public void onDestroy() {
        Er();
        com.baidu.tieba.enterForum.model.a.VD().destroy();
        if (this.bEI != null && this.bEI.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.bEI.getBannerView()), (Class) null);
        }
        if (this.bEI != null) {
            this.bEI.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bEI != null) {
            this.bEI.onChangeSkinType(i);
        }
    }

    public void Er() {
        if (this.bEJ != null) {
            this.bEJ.cancelLoadData();
        }
    }

    public void df(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bES && this.bEJ != null && this.bEI != null) {
            String str = this.bEL;
            this.bEL = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bEL == null || this.bEL.equals(str)) {
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
                if (this.bEJ != null && this.bEJ.VM() != null && this.bEJ.VM().Vd() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.u> it = this.bEJ.VM().Vd().Vi().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.u next = it.next();
                        if (TbadkCoreApplication.m9getInst().hasSignedForum(next.getName())) {
                            next.en(1);
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
                    com.baidu.tieba.tbadkCore.util.l.pP(currentAccount);
                }
                this.bEI.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Er();
                if (z4) {
                    this.bEI.startPullRefresh();
                } else if (z2) {
                    this.bEJ.di(StringUtils.isNull(this.bEL) ? false : true);
                    this.bEI.startPullRefresh();
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
        if (this.bEI != null && this.bEI.Wd() != null) {
            this.bEI.Wd().completePullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.u, Integer, String> {
        private com.baidu.tieba.tbadkCore.u bFi;
        private com.baidu.tbadk.core.util.z mNetwork = null;

        public a(com.baidu.tieba.tbadkCore.u uVar) {
            this.bFi = null;
            this.bFi = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.u... uVarArr) {
            com.baidu.tieba.tbadkCore.u uVar = this.bFi;
            if (uVar != null) {
                try {
                    if (uVar.getId() != null && uVar.getName() != null) {
                        this.mNetwork = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", uVar.getId());
                        this.mNetwork.n("kw", uVar.getName());
                        this.mNetwork.uZ().vS().mIsNeedTbs = true;
                        this.mNetwork.uB();
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
                if (!this.mNetwork.uZ().vT().isRequestSuccess()) {
                    if (l.this.aXf != null) {
                        if (StringUtils.isNull(this.mNetwork.getErrorString())) {
                            if (l.this.bEH.isAdded()) {
                                l.this.aXf.showToast(l.this.aXf.getActivity().getString(w.l.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        l.this.aXf.showToast(this.mNetwork.getErrorString());
                        return;
                    }
                    return;
                }
                l.this.bEO = true;
                if (l.this.bEH.isAdded() && l.this.aXf != null) {
                    l.this.aXf.showToast(l.this.aXf.getActivity().getString(w.l.unlike_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                l.this.f(false, this.bFi.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bFi.getId()));
                long c = com.baidu.adp.lib.g.b.c(this.bFi.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                l.this.bEI.b(this.bFi);
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
                this.mNetwork.fm();
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
        int EN = bVar.EN();
        com.baidu.tbadk.mvc.b.a EO = bVar.EO();
        switch (EN) {
            case 1:
                if (EO instanceof com.baidu.tieba.tbadkCore.u) {
                    String name = ((com.baidu.tieba.tbadkCore.u) EO).getName();
                    if (au.aG(name)) {
                        TiebaStatic.eventStat(this.aXf.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aXf.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aXf.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, ih(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("enter_forum_edit_mode", true);
                this.bEI.hq(EO instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) EO).getPosition() : 0);
                this.bEO = false;
                if (this.bEH.getView() != null && this.bEH.getView().getParent() != null) {
                    this.bEH.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (EO instanceof com.baidu.tieba.tbadkCore.u) {
                    a((com.baidu.tieba.tbadkCore.u) EO);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.bEI.Wb() != null) {
                    arrayList.addAll(this.bEI.Wb());
                }
                List<com.baidu.tieba.tbadkCore.u> ae = this.bEJ.ae(this.bEI.Wb());
                if (!arrayList.isEmpty() && this.bEJ.e(arrayList, ae)) {
                    this.aXf.showToast(w.l.enter_forum_sort_already);
                } else {
                    this.bEI.ag(ae);
                }
                return true;
            case 7:
                this.bEI.Wc();
                return true;
            case 8:
                Vz();
                return true;
            case 9:
                this.bEI.Wm();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXf.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (EO instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) EO;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (au.aG(forumName)) {
                        TiebaStatic.log(new as("c10358").Z("fid", valueOf));
                        TiebaStatic.eventStat(this.aXf.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.brY.bY(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (EO instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar2 = (com.baidu.tieba.enterForum.b.g) EO;
                    String forumName2 = gVar2.getForumName();
                    String valueOf2 = String.valueOf(gVar2.getForumId());
                    if (au.aG(forumName2)) {
                        TiebaStatic.log(new as("c10357").Z("fid", valueOf2));
                        TiebaStatic.eventStat(this.aXf.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aXf.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aXf.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aXf.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aXf.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aXf.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXf.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aXf.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXf.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean ih(String str) {
        if (this.bEJ == null || this.bEJ.VM() == null || this.bEJ.VM().Va() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> Vf = this.bEJ.VM().Va().Vf();
        if (com.baidu.tbadk.core.util.x.q(Vf)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : Vf) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.x.q(eVar.Cg());
            }
        }
        return false;
    }

    public void VB() {
        if (this.bEI != null) {
            this.bEI.Wh();
        }
    }

    public boolean VC() {
        if (this.bEI != null) {
            return this.bEI.VC();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EM() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aXf.getUniqueId();
    }

    public void dg(boolean z) {
        int i = 1;
        if (this.bEI != null && this.bEH != null) {
            boolean z2 = this.bEI.VC() && this.bEH.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
