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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.w MS;
    private BaseFragmentActivity aKq;
    private com.baidu.tbadk.core.view.b aWB;
    private boolean aWD;
    private com.baidu.tbadk.core.dialog.a aWE;
    private e aWr;
    private com.baidu.tieba.enterForum.c.c aWt;
    private boolean aWu;
    private String aWv;
    private long aWx;
    private boolean aWy;
    private long aWz;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.d.e aWs = null;
    private boolean aWw = false;
    private boolean aWC = true;
    private final CustomMessageListener aWF = new j(this, CmdConfigCustom.CMD_DISABLE_JUMP_IN_ENTER_FORUM);
    private final CustomMessageListener aKr = new t(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener aWG = new v(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener aWH = new w(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener aWI = new x(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a aWJ = new aa(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aWK = new ab(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g aWL = new ac(this);
    private final c.b aWM = new ad(this);
    private r.a ahc = new k(this);
    private ViewEventCenter aWA = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        LX();
    }

    public i(e eVar) {
        this.aWt = null;
        this.isFirst = true;
        this.aWu = false;
        this.aWx = -1L;
        this.aWr = eVar;
        this.aKq = eVar.getBaseFragmentActivity();
        this.aWA.addEventDelegate(this);
        this.aWx = System.currentTimeMillis();
        this.isFirst = true;
        this.aWu = false;
        this.aWv = "";
        this.aWt = new com.baidu.tieba.enterForum.c.c(this.aKq.getPageContext());
        this.aWz = this.aWt.Mu();
        this.MS = new com.baidu.tieba.tbadkCore.w(this.aKq.getPageContext());
        this.MS.setLoadDataCallBack(this.aWL);
        this.aWt.a(this.aWM);
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.Mf().h(this.aWr.getFragmentActivity(), com.baidu.adp.lib.util.k.l(this.aWr.getFragmentActivity()));
        qD();
        pm();
    }

    private void pm() {
        Ma();
        this.aWr.registerListener(this.aWK);
        this.aWr.registerListener(this.aWJ);
        this.aWr.registerListener(this.aKr);
        this.aWr.registerListener(this.aWG);
        this.aWr.registerListener(this.aWH);
        this.aWr.registerListener(this.aWF);
        this.aWr.registerListener(this.aWI);
    }

    private static void LX() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean LY() {
        return (this.aWt.c(this.aWs.MM(), this.aWs.MN()) && (this.aWs.Mx() == this.aWs.MF())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.aWs.ML();
    }

    private void Ma() {
        this.aWr.registerListener(new l(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.aWr.registerListener(new m(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void Mb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aKq.getPageContext().getPageActivity());
        aVar.bY(t.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(t.j.enter_forum_cancel_change), new n(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.cancel), new o(this));
        aVar.b(this.aKq.getPageContext());
        aVar.uj();
    }

    private void Mc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aKq.getPageContext().getPageActivity());
        aVar.bY(t.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(t.j.hide), new p(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.cancel), new q(this));
        aVar.b(this.aKq.getPageContext());
        aVar.uj();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aKq.getPageContext().getPageActivity());
            aVar.cE(String.format(this.aKq.getPageContext().getString(t.j.attention_cancel_dialog_content), vVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(t.j.confirm), new r(this, vVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.cancel), new s(this));
            aVar.b(this.aKq.getPageContext());
            aVar.uj();
        }
    }

    public void bX(boolean z) {
        if (this.aWB == null) {
            Md();
        }
        this.aWB.aw(z);
    }

    private void Md() {
        this.aWB = new com.baidu.tbadk.core.view.b(this.aKq.getPageContext());
    }

    private void qD() {
        this.mRootView = LayoutInflater.from(this.aKq.getActivity()).inflate(t.h.enter_forum_view, (ViewGroup) null);
        this.aWs = new com.baidu.tieba.enterForum.d.e(this.aWr, this.mRootView, this.aWA);
        this.aWs.a(this.ahc);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void bY(boolean z) {
        if (this.aWs != null && this.aWr != null) {
            if (z) {
                if (this.aWr.isPrimary() && this.aWr.isResumed()) {
                    this.aWs.ns();
                    return;
                } else {
                    this.aWs.MB();
                    return;
                }
            }
            this.aWs.MB();
        }
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            this.aKq.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.aWr.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.aWs != null) {
            b(bVar);
            com.baidu.tieba.enterForum.b.d LJ = bVar.LJ();
            if (LJ != null && LJ.LN() != null) {
                if (this.aWC && this.aWu) {
                    int redirect = bVar.getRedirect();
                    if (redirect == 1) {
                        this.aKq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aKq.getActivity()).createNormalCfg(7)));
                    } else if (redirect == 2) {
                        this.aKq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aKq.getActivity()).createNormalCfg(2)));
                    }
                    this.aWC = false;
                }
                int size = LJ.LN().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.aWs.cd(true);
                        } else {
                            this.aWs.cd(false);
                        }
                    } else {
                        this.aWs.cd(false);
                    }
                    boolean au = this.aWt.au(this.aWz);
                    List<com.baidu.tieba.enterForum.b.f> LR = bVar.LG() != null ? bVar.LG().LR() : null;
                    if (!au || LR == null || LR.isEmpty()) {
                        this.aWs.MQ();
                    } else {
                        this.aWs.U(LR);
                    }
                    if (!TbadkCoreApplication.isLogin() && LR != null && !LR.isEmpty()) {
                        this.aWs.U(LR);
                    }
                } else {
                    this.aWs.MQ();
                    this.aWs.cd(false);
                }
            }
            K(LJ != null ? LJ.LN() : null);
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.uO().getString("hot_search_title", ""));
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.c.e.gE().ai("ad_baichuan_open") != 0 && this.aWs != null) {
            View bannerView = this.aWs.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.aWs.S(bannerView2);
                    this.aWw = false;
                }
            } else if (this.aWw) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.aWs.S(bannerView3);
                    TiebaStatic.log(new au("c10807"));
                    this.aWw = false;
                }
            } else {
                Q(bannerView);
            }
        }
    }

    private void Q(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int K = com.baidu.adp.lib.util.k.K(this.aKq.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.a(this.aKq.getActivity(), this.aKq.getResources().getDimensionPixelSize(t.e.ds100), K, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.aWs.setSearchHint(str.trim());
        } else {
            this.aWs.setSearchHint(this.aKq.getActivity().getString(t.j.enter_forum_search_tip));
        }
    }

    private void K(List<com.baidu.tieba.tbadkCore.v> list) {
        if (list != null) {
            int fT = this.aWt.fT(0);
            if (fT == 0) {
                if (list.size() > 8) {
                    fT = 2;
                } else {
                    fT = 1;
                }
            }
            this.aWs.fY(fT);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aWs.X(this.aWt.a(list, this.aWt.Mt()));
        }
    }

    public void Me() {
        if (this.aWs != null) {
            bZ(false);
            if (!this.aWr.isPrimary() && this.aWE != null) {
                this.aWE.dismiss();
            }
        }
    }

    public void onDestroy() {
        Ej();
        com.baidu.tieba.enterForum.c.a.Mf().destroy();
        if (this.aWs != null && this.aWs.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.aWs.getBannerView()), (Class) null);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aWs != null) {
            this.aWs.onChangeSkinType(i);
        }
    }

    public void Ej() {
        if (this.aWt != null) {
            this.aWt.cancelLoadData();
        }
    }

    public void bZ(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aWD && this.aWt != null && this.aWs != null) {
            String str = this.aWv;
            this.aWv = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aWv == null || this.aWv.equals(str)) {
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
                if (this.aWt != null && this.aWt.Mp() != null && this.aWt.Mp().LJ() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.v> it = this.aWt.Mp().LJ().LN().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.v next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.od(1);
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
                    com.baidu.tieba.tbadkCore.util.m.mN(currentAccount);
                }
                this.aWs.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ej();
                if (z4) {
                    this.aWs.ns();
                } else if (z2) {
                    this.aWt.cc(StringUtils.isNull(this.aWv) ? false : true);
                    this.aWs.ns();
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
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.v, Integer, String> {
        private com.baidu.tieba.tbadkCore.v aWU;
        private com.baidu.tbadk.core.util.aa aiG = null;

        public a(com.baidu.tieba.tbadkCore.v vVar) {
            this.aWU = null;
            this.aWU = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.v... vVarArr) {
            com.baidu.tieba.tbadkCore.v vVar = this.aWU;
            if (vVar != null) {
                try {
                    if (vVar.getId() != null && vVar.getName() != null) {
                        this.aiG = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.aiG.p(ImageViewerConfig.FORUM_ID, vVar.getId());
                        this.aiG.p("kw", vVar.getName());
                        this.aiG.vB().wv().mIsNeedTbs = true;
                        this.aiG.uZ();
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
        /* renamed from: ek */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            i.this.bX(false);
            if (this.aiG != null) {
                if (!this.aiG.vB().ww().rl()) {
                    if (i.this.aKq != null) {
                        if (StringUtils.isNull(this.aiG.getErrorString())) {
                            if (i.this.aWr.isAdded()) {
                                i.this.aKq.showToast(i.this.aKq.getActivity().getString(t.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        i.this.aKq.showToast(this.aiG.getErrorString());
                        return;
                    }
                    return;
                }
                i.this.aWy = true;
                if (i.this.aWr.isAdded() && i.this.aKq != null) {
                    i.this.aKq.showToast(i.this.aKq.getActivity().getString(t.j.delete_like_success));
                }
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                i.this.f(false, this.aWU.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.aWU.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.aWU.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                i.this.aWs.b(this.aWU);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            i.this.bX(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiG != null) {
                this.aiG.gT();
                this.aiG = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new u(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int EE = bVar.EE();
        com.baidu.tbadk.mvc.b.a EF = bVar.EF();
        switch (EE) {
            case 1:
                if (EF instanceof com.baidu.tieba.tbadkCore.v) {
                    String name = ((com.baidu.tieba.tbadkCore.v) EF).getName();
                    if (aw.aQ(name)) {
                        TiebaStatic.eventStat(this.aKq.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aKq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aKq.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("enter_forum_edit_mode", true);
                this.aWs.fW(EF instanceof com.baidu.tieba.enterForum.b.e ? ((com.baidu.tieba.enterForum.b.e) EF).getPosition() : 0);
                this.aWy = false;
                if (this.aWr.getView() != null && this.aWr.getView().getParent() != null) {
                    this.aWr.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (EF instanceof com.baidu.tieba.tbadkCore.v) {
                    a((com.baidu.tieba.tbadkCore.v) EF);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aWs.MH() != null) {
                    arrayList.addAll(this.aWs.MH());
                }
                List<com.baidu.tieba.tbadkCore.v> M = this.aWt.M(this.aWs.MH());
                if (!arrayList.isEmpty() && this.aWt.c(arrayList, M)) {
                    this.aKq.showToast(t.j.enter_forum_sort_already);
                } else {
                    this.aWs.T(M);
                }
                return true;
            case 7:
                this.aWs.MI();
                return true;
            case 8:
                Mc();
                return true;
            case 9:
                this.aWs.MO();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aKq.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (EF instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar = (com.baidu.tieba.enterForum.b.f) EF;
                    String forumName = fVar.getForumName();
                    String valueOf = String.valueOf(fVar.getForumId());
                    if (aw.aQ(forumName)) {
                        TiebaStatic.log(new au("c10358").aa(ImageViewerConfig.FORUM_ID, valueOf));
                        TiebaStatic.eventStat(this.aKq.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.MS.bl(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (EF instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar2 = (com.baidu.tieba.enterForum.b.f) EF;
                    String forumName2 = fVar2.getForumName();
                    String valueOf2 = String.valueOf(fVar2.getForumId());
                    if (aw.aQ(forumName2)) {
                        TiebaStatic.log(new au("c10357").aa(ImageViewerConfig.FORUM_ID, valueOf2));
                        TiebaStatic.eventStat(this.aKq.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aKq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aKq.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aKq.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aKq.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aKq.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aKq.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aKq.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aKq.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oI() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aKq.getUniqueId();
    }

    public void ca(boolean z) {
        int i = 1;
        if (this.aWs != null && this.aWr != null) {
            boolean z2 = this.aWs.MJ() && this.aWr.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
