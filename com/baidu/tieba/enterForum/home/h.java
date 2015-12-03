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
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.x Ml;
    private BaseFragmentActivity aHN;
    private long aQA;
    private com.baidu.tbadk.core.view.b aQC;
    private boolean aQE;
    private com.baidu.tbadk.core.dialog.a aQF;
    private e aQt;
    private com.baidu.tieba.enterForum.c.c aQv;
    private boolean aQw;
    private String aQx;
    private long aQy;
    private boolean aQz;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.d.e aQu = null;
    private boolean aQD = true;
    private final CustomMessageListener aQG = new i(this, CmdConfigCustom.CMD_DISABLE_JUMP_IN_ENTER_FORUM);
    private final CustomMessageListener aHO = new s(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener aQH = new t(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener aQI = new u(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private com.baidu.adp.framework.listener.a aQJ = new v(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aQK = new w(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g aQL = new x(this);
    private final c.b aQM = new y(this);
    private q.a afB = new z(this);
    private ViewEventCenter aQB = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        JM();
    }

    public h(e eVar) {
        this.aQv = null;
        this.isFirst = true;
        this.aQw = false;
        this.aQy = -1L;
        this.aQt = eVar;
        this.aHN = eVar.getBaseFragmentActivity();
        this.aQB.addEventDelegate(this);
        this.aQy = System.currentTimeMillis();
        this.isFirst = true;
        this.aQw = false;
        this.aQx = "";
        this.aQv = new com.baidu.tieba.enterForum.c.c(this.aHN.getPageContext());
        this.aQA = this.aQv.Kk();
        this.Ml = new com.baidu.tieba.tbadkCore.x(this.aHN.getPageContext());
        this.Ml.setLoadDataCallBack(this.aQL);
        this.aQv.a(this.aQM);
        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.JV().j(this.aQt.getFragmentActivity(), com.baidu.adp.lib.util.k.l(this.aQt.getFragmentActivity()));
        initUI();
        initListener();
    }

    private void initListener() {
        JP();
        this.aHN.registerListener(this.aQK);
        this.aHN.registerListener(this.aQJ);
        this.aHN.registerListener(this.aHO);
        this.aHN.registerListener(this.aQH);
        this.aHN.registerListener(this.aQI);
        this.aHN.registerListener(this.aQG);
    }

    private static void JM() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JN() {
        return (this.aQv.b(this.aQu.KC(), this.aQu.KD()) && (this.aQu.Kn() == this.aQu.Kv())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.aQu.KB();
    }

    private void JP() {
        this.aHN.registerListener(new j(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.aHN.registerListener(new k(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void JQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aHN.getPageContext().getPageActivity());
        aVar.bN(n.i.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(n.i.enter_forum_cancel_change), new l(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(n.i.cancel), new m(this));
        aVar.b(this.aHN.getPageContext());
        aVar.tv();
    }

    private void JR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aHN.getPageContext().getPageActivity());
        aVar.bN(n.i.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(n.i.hide), new n(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(n.i.cancel), new o(this));
        aVar.b(this.aHN.getPageContext());
        aVar.tv();
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (wVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aHN.getPageContext().getPageActivity());
            aVar.cC(String.format(this.aHN.getPageContext().getString(n.i.attention_cancel_dialog_content), wVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(n.i.confirm), new p(this, wVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(n.i.cancel), new q(this));
            aVar.b(this.aHN.getPageContext());
            aVar.tv();
        }
    }

    public void bY(boolean z) {
        if (this.aQC == null) {
            JS();
        }
        this.aQC.ay(z);
    }

    private void JS() {
        this.aQC = new com.baidu.tbadk.core.view.b(this.aHN.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aHN.getActivity()).inflate(n.g.enter_forum_view, (ViewGroup) null);
        this.aQu = new com.baidu.tieba.enterForum.d.e(this.aQt, this.mRootView, this.aQB);
        this.aQu.a(this.afB);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void bZ(boolean z) {
        if (this.aQu != null && this.aQt != null) {
            if (z) {
                if (this.aQt.isPrimary() && this.aQt.isResumed()) {
                    this.aQu.nD();
                    return;
                } else {
                    this.aQu.Kr();
                    return;
                }
            }
            this.aQu.Kr();
        }
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            this.aHN.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.aQt.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.aQu != null) {
            JT();
            com.baidu.tieba.enterForum.b.d JC = bVar.JC();
            if (JC != null && JC.JF() != null) {
                if (this.aQD && this.aQw) {
                    int redirect = bVar.getRedirect();
                    if (redirect == 1) {
                        this.aHN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aHN.getActivity()).createNormalCfg(7)));
                    } else if (redirect == 2) {
                        this.aHN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aHN.getActivity()).createNormalCfg(2)));
                    }
                    this.aQD = false;
                }
                int size = JC.JF().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.aQu.ce(true);
                        } else {
                            this.aQu.ce(false);
                        }
                    } else {
                        this.aQu.ce(false);
                    }
                    boolean ar = this.aQv.ar(this.aQA);
                    List<com.baidu.tieba.enterForum.b.f> JJ = bVar.JB() != null ? bVar.JB().JJ() : null;
                    if (!ar || JJ == null || JJ.isEmpty()) {
                        this.aQu.KF();
                    } else {
                        this.aQu.W(JJ);
                    }
                    if (!TbadkCoreApplication.isLogin() && JJ != null && !JJ.isEmpty()) {
                        this.aQu.W(JJ);
                    }
                } else {
                    this.aQu.KF();
                    this.aQu.ce(false);
                }
            }
            M(JC != null ? JC.JF() : null);
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.tZ().getString("hot_search_title", ""));
        }
    }

    private void JT() {
        if (com.baidu.adp.lib.c.e.gw().aj("ad_baichuan_open") != 0 && this.aQu != null) {
            View bannerView = this.aQu.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.aQu.D(bannerView2);
                    return;
                }
                return;
            }
            C(bannerView);
        }
    }

    private void C(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int K = com.baidu.adp.lib.util.k.K(this.aHN.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.a(this.aHN.getActivity(), this.aHN.getResources().getDimensionPixelSize(n.d.ds100), K, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.aQu.setSearchHint(str.trim());
        } else {
            this.aQu.setSearchHint(this.aHN.getActivity().getString(n.i.enter_forum_search_tip));
        }
    }

    private void M(List<com.baidu.tieba.tbadkCore.w> list) {
        if (list != null) {
            int fz = this.aQv.fz(0);
            if (fz == 0) {
                if (list.size() > 8) {
                    fz = 2;
                } else {
                    fz = 1;
                }
            }
            this.aQu.fE(fz);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aQu.Z(this.aQv.a(list, this.aQv.Kj()));
        }
    }

    public void JU() {
        if (this.aQu != null) {
            ca(false);
            if (!this.aQt.isPrimary() && this.aQF != null) {
                this.aQF.dismiss();
            }
        }
    }

    public void onDestroy() {
        Dd();
        com.baidu.tieba.enterForum.c.a.JV().destroy();
    }

    public void onChangeSkinType(int i) {
        if (this.aQu != null) {
            this.aQu.onChangeSkinType(i);
        }
    }

    public void Dd() {
        if (this.aQv != null) {
            this.aQv.cancelLoadData();
        }
    }

    public void ca(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aQE && this.aQv != null && this.aQu != null) {
            String str = this.aQx;
            this.aQx = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aQx == null || this.aQx.equals(str)) {
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
                if (this.aQv != null && this.aQv.Kf() != null && this.aQv.Kf().JC() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.w> it = this.aQv.Kf().JC().JF().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.w next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.mq(1);
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
                    com.baidu.tieba.tbadkCore.util.m.mz(currentAccount);
                }
                this.aQu.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Dd();
                if (z4) {
                    this.aQu.nD();
                } else if (z2) {
                    this.aQv.cd(StringUtils.isNull(this.aQx) ? false : true);
                    this.aQu.nD();
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
        private com.baidu.tieba.tbadkCore.w aQR;
        private ab agS = null;

        public a(com.baidu.tieba.tbadkCore.w wVar) {
            this.aQR = null;
            this.aQR = wVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.w... wVarArr) {
            com.baidu.tieba.tbadkCore.w wVar = this.aQR;
            if (wVar != null) {
                try {
                    if (wVar.getId() != null && wVar.getName() != null) {
                        this.agS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.agS.o(ImageViewerConfig.FORUM_ID, wVar.getId());
                        this.agS.o("kw", wVar.getName());
                        this.agS.uM().vF().mIsNeedTbs = true;
                        this.agS.ul();
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
            h.this.bY(false);
            if (this.agS != null) {
                if (!this.agS.uM().vG().rf()) {
                    if (h.this.aHN != null) {
                        if (StringUtils.isNull(this.agS.getErrorString())) {
                            if (h.this.aQt.isAdded()) {
                                h.this.aHN.showToast(h.this.aHN.getActivity().getString(n.i.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        h.this.aHN.showToast(this.agS.getErrorString());
                        return;
                    }
                    return;
                }
                h.this.aQz = true;
                if (h.this.aQt.isAdded() && h.this.aHN != null) {
                    h.this.aHN.showToast(h.this.aHN.getActivity().getString(n.i.delete_like_success));
                }
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                h.this.e(false, this.aQR.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.aQR.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.aQR.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                h.this.aQu.b(this.aQR);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            h.this.bY(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.agS != null) {
                this.agS.gL();
                this.agS = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new r(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Du = bVar.Du();
        com.baidu.tbadk.mvc.b.a Dv = bVar.Dv();
        switch (Du) {
            case 1:
                if (Dv instanceof com.baidu.tieba.tbadkCore.w) {
                    String name = ((com.baidu.tieba.tbadkCore.w) Dv).getName();
                    if (ax.aR(name)) {
                        TiebaStatic.eventStat(this.aHN.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aHN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aHN.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("enter_forum_edit_mode", true);
                this.aQu.fC(Dv instanceof com.baidu.tieba.enterForum.b.e ? ((com.baidu.tieba.enterForum.b.e) Dv).getPosition() : 0);
                this.aQz = false;
                if (this.aQt.getView() != null && this.aQt.getView().getParent() != null) {
                    this.aQt.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Dv instanceof com.baidu.tieba.tbadkCore.w) {
                    a((com.baidu.tieba.tbadkCore.w) Dv);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aQu.Kx() != null) {
                    arrayList.addAll(this.aQu.Kx());
                }
                List<com.baidu.tieba.tbadkCore.w> O = this.aQv.O(this.aQu.Kx());
                if (!arrayList.isEmpty() && this.aQv.b(arrayList, O)) {
                    this.aHN.showToast(n.i.enter_forum_sort_already);
                } else {
                    this.aQu.V(O);
                }
                return true;
            case 7:
                this.aQu.Ky();
                return true;
            case 8:
                JR();
                return true;
            case 9:
                this.aQu.KE();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aHN.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Dv instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar = (com.baidu.tieba.enterForum.b.f) Dv;
                    String forumName = fVar.getForumName();
                    String valueOf = String.valueOf(fVar.getForumId());
                    if (ax.aR(forumName)) {
                        TiebaStatic.log(new av("c10358").ab(ImageViewerConfig.FORUM_ID, valueOf));
                        TiebaStatic.eventStat(this.aHN.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.Ml.bg(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Dv instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar2 = (com.baidu.tieba.enterForum.b.f) Dv;
                    String forumName2 = fVar2.getForumName();
                    String valueOf2 = String.valueOf(fVar2.getForumId());
                    if (ax.aR(forumName2)) {
                        TiebaStatic.log(new av("c10357").ab(ImageViewerConfig.FORUM_ID, valueOf2));
                        TiebaStatic.eventStat(this.aHN.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aHN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aHN.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aHN.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aHN.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aHN.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aHN.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aHN.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aHN.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oP() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aHN.getUniqueId();
    }

    public void cb(boolean z) {
        int i = 1;
        if (this.aQu != null && this.aQt != null) {
            boolean z2 = this.aQu.Kz() && this.aQt.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
