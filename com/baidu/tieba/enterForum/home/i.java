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
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.w MY;
    private BaseFragmentActivity aNm;
    private e bba;
    private com.baidu.tieba.enterForum.c.c bbc;
    private boolean bbd;
    private String bbe;
    private long bbg;
    private boolean bbh;
    private long bbi;
    private com.baidu.tbadk.core.view.b bbk;
    private boolean bbm;
    private com.baidu.tbadk.core.dialog.a bbn;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.d.e bbb = null;
    private boolean bbf = false;
    private boolean bbl = true;
    private final CustomMessageListener bbo = new j(this, CmdConfigCustom.CMD_DISABLE_JUMP_IN_ENTER_FORUM);
    private final CustomMessageListener aNn = new t(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener bbp = new v(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener bbq = new w(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bbr = new x(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bbs = new aa(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bbt = new ab(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g bbu = new ac(this);
    private final c.b bbv = new ad(this);
    private s.a agD = new k(this);
    private ViewEventCenter bbj = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        NL();
    }

    public i(e eVar) {
        this.bbc = null;
        this.isFirst = true;
        this.bbd = false;
        this.bbg = -1L;
        this.bba = eVar;
        this.aNm = eVar.getBaseFragmentActivity();
        this.bbj.addEventDelegate(this);
        this.bbg = System.currentTimeMillis();
        this.isFirst = true;
        this.bbd = false;
        this.bbe = "";
        this.bbc = new com.baidu.tieba.enterForum.c.c(this.aNm.getPageContext());
        this.bbi = this.bbc.Oi();
        this.MY = new com.baidu.tieba.tbadkCore.w(this.aNm.getPageContext());
        this.MY.setLoadDataCallBack(this.bbu);
        this.bbc.a(this.bbv);
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.NT().h(this.bba.getFragmentActivity(), com.baidu.adp.lib.util.k.g(this.bba.getFragmentActivity()));
        pU();
        pf();
    }

    private void pf() {
        NO();
        this.bba.registerListener(this.bbt);
        this.bba.registerListener(this.bbs);
        this.bba.registerListener(this.aNn);
        this.bba.registerListener(this.bbp);
        this.bba.registerListener(this.bbq);
        this.bba.registerListener(this.bbo);
        this.bba.registerListener(this.bbr);
    }

    private static void NL() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean NM() {
        return (this.bbc.c(this.bbb.OA(), this.bbb.OB()) && (this.bbb.Ol() == this.bbb.Ot())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bbb.Oz();
    }

    private void NO() {
        this.bba.registerListener(new l(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bba.registerListener(new m(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void NP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aNm.getPageContext().getPageActivity());
        aVar.ca(t.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(t.j.enter_forum_cancel_change), new n(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.cancel), new o(this));
        aVar.b(this.aNm.getPageContext());
        aVar.up();
    }

    private void NQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aNm.getPageContext().getPageActivity());
        aVar.ca(t.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(t.j.hide), new p(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.cancel), new q(this));
        aVar.b(this.aNm.getPageContext());
        aVar.up();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aNm.getPageContext().getPageActivity());
            aVar.cC(String.format(this.aNm.getPageContext().getString(t.j.attention_cancel_dialog_content), vVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(t.j.confirm), new r(this, vVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.cancel), new s(this));
            aVar.b(this.aNm.getPageContext());
            aVar.up();
        }
    }

    public void cj(boolean z) {
        if (this.bbk == null) {
            NR();
        }
        this.bbk.ay(z);
    }

    private void NR() {
        this.bbk = new com.baidu.tbadk.core.view.b(this.aNm.getPageContext());
    }

    private void pU() {
        this.mRootView = LayoutInflater.from(this.aNm.getActivity()).inflate(t.h.enter_forum_view, (ViewGroup) null);
        this.bbb = new com.baidu.tieba.enterForum.d.e(this.bba, this.mRootView, this.bbj);
        this.bbb.a(this.agD);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void ck(boolean z) {
        if (this.bbb != null && this.bba != null) {
            if (z) {
                if (this.bba.isPrimary() && this.bba.isResumed()) {
                    this.bbb.nk();
                    return;
                } else {
                    this.bbb.Op();
                    return;
                }
            }
            this.bbb.Op();
        }
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            this.aNm.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bba.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.bbb != null) {
            b(bVar);
            com.baidu.tieba.enterForum.b.d Nx = bVar.Nx();
            if (Nx != null && Nx.NB() != null) {
                if (this.bbl && this.bbd) {
                    int redirect = bVar.getRedirect();
                    if (redirect == 1) {
                        this.aNm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aNm.getActivity()).createNormalCfg(2)));
                    } else if (redirect == 2) {
                        this.aNm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aNm.getActivity()).createNormalCfg(2)));
                    }
                    this.bbl = false;
                }
                int size = Nx.NB().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bbb.cp(true);
                        } else {
                            this.bbb.cp(false);
                        }
                    } else {
                        this.bbb.cp(false);
                    }
                    boolean ay = this.bbc.ay(this.bbi);
                    List<com.baidu.tieba.enterForum.b.f> NF = bVar.Nu() != null ? bVar.Nu().NF() : null;
                    if (!ay || NF == null || NF.isEmpty()) {
                        this.bbb.OD();
                    } else {
                        this.bbb.Y(NF);
                    }
                    if (!TbadkCoreApplication.isLogin() && NF != null && !NF.isEmpty()) {
                        this.bbb.Y(NF);
                    }
                } else {
                    this.bbb.OD();
                    this.bbb.cp(false);
                }
            }
            O(Nx != null ? Nx.NB() : null);
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.vk().getString("hot_search_title", ""));
            this.bbb.OF();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.c.e.gE().ai("ad_baichuan_open") != 0 && this.bbb != null) {
            View bannerView = this.bbb.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bbb.W(bannerView2);
                    this.bbf = false;
                }
            } else if (this.bbf) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bbb.W(bannerView3);
                    TiebaStatic.log(new aw("c10807"));
                    this.bbf = false;
                }
            } else {
                U(bannerView);
            }
        }
    }

    private void U(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int B = com.baidu.adp.lib.util.k.B(this.aNm.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.a(this.aNm.getActivity(), this.aNm.getResources().getDimensionPixelSize(t.e.ds100), B, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bbb.setSearchHint(str.trim());
        } else {
            this.bbb.setSearchHint(this.aNm.getActivity().getString(t.j.enter_forum_search_tip));
        }
    }

    private void O(List<com.baidu.tieba.tbadkCore.v> list) {
        if (list != null) {
            int gj = this.bbc.gj(0);
            if (gj == 0) {
                if (list.size() > 8) {
                    gj = 2;
                } else {
                    gj = 1;
                }
            }
            this.bbb.go(gj);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bbb.ab(this.bbc.a(list, this.bbc.Oh()));
        }
    }

    public void NS() {
        if (this.bbb != null) {
            cl(false);
            if (!this.bba.isPrimary() && this.bbn != null) {
                this.bbn.dismiss();
            }
        }
    }

    public void onDestroy() {
        EU();
        com.baidu.tieba.enterForum.c.a.NT().destroy();
        if (this.bbb != null && this.bbb.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.bbb.getBannerView()), (Class) null);
        }
        if (this.bbb != null) {
            this.bbb.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bbb != null) {
            this.bbb.onChangeSkinType(i);
        }
    }

    public void EU() {
        if (this.bbc != null) {
            this.bbc.cancelLoadData();
        }
    }

    public void cl(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bbm && this.bbc != null && this.bbb != null) {
            String str = this.bbe;
            this.bbe = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bbe == null || this.bbe.equals(str)) {
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
                if (this.bbc != null && this.bbc.Od() != null && this.bbc.Od().Nx() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.v> it = this.bbc.Od().Nx().NB().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.v next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.pm(1);
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
                    com.baidu.tieba.tbadkCore.util.m.nZ(currentAccount);
                }
                this.bbb.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EU();
                if (z4) {
                    this.bbb.nk();
                } else if (z2) {
                    this.bbc.co(StringUtils.isNull(this.bbe) ? false : true);
                    this.bbb.nk();
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
        private com.baidu.tbadk.core.util.ab aiW = null;
        private com.baidu.tieba.tbadkCore.v bbD;

        public a(com.baidu.tieba.tbadkCore.v vVar) {
            this.bbD = null;
            this.bbD = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.v... vVarArr) {
            com.baidu.tieba.tbadkCore.v vVar = this.bbD;
            if (vVar != null) {
                try {
                    if (vVar.getId() != null && vVar.getName() != null) {
                        this.aiW = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.aiW.p("fid", vVar.getId());
                        this.aiW.p("kw", vVar.getName());
                        this.aiW.vU().wO().mIsNeedTbs = true;
                        this.aiW.vw();
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
            i.this.cj(false);
            if (this.aiW != null) {
                if (!this.aiW.vU().wP().qC()) {
                    if (i.this.aNm != null) {
                        if (StringUtils.isNull(this.aiW.getErrorString())) {
                            if (i.this.bba.isAdded()) {
                                i.this.aNm.showToast(i.this.aNm.getActivity().getString(t.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        i.this.aNm.showToast(this.aiW.getErrorString());
                        return;
                    }
                    return;
                }
                i.this.bbh = true;
                if (i.this.bba.isAdded() && i.this.aNm != null) {
                    i.this.aNm.showToast(i.this.aNm.getActivity().getString(t.j.delete_like_success));
                }
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                i.this.f(false, this.bbD.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bbD.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.bbD.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                i.this.bbb.b(this.bbD);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            i.this.cj(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiW != null) {
                this.aiW.gX();
                this.aiW = null;
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
        int Fr = bVar.Fr();
        com.baidu.tbadk.mvc.b.a Fs = bVar.Fs();
        switch (Fr) {
            case 1:
                if (Fs instanceof com.baidu.tieba.tbadkCore.v) {
                    String name = ((com.baidu.tieba.tbadkCore.v) Fs).getName();
                    if (ay.aS(name)) {
                        TiebaStatic.eventStat(this.aNm.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aNm.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aNm.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("enter_forum_edit_mode", true);
                this.bbb.gm(Fs instanceof com.baidu.tieba.enterForum.b.e ? ((com.baidu.tieba.enterForum.b.e) Fs).getPosition() : 0);
                this.bbh = false;
                if (this.bba.getView() != null && this.bba.getView().getParent() != null) {
                    this.bba.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Fs instanceof com.baidu.tieba.tbadkCore.v) {
                    a((com.baidu.tieba.tbadkCore.v) Fs);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.bbb.Ov() != null) {
                    arrayList.addAll(this.bbb.Ov());
                }
                List<com.baidu.tieba.tbadkCore.v> Q = this.bbc.Q(this.bbb.Ov());
                if (!arrayList.isEmpty() && this.bbc.c(arrayList, Q)) {
                    this.aNm.showToast(t.j.enter_forum_sort_already);
                } else {
                    this.bbb.X(Q);
                }
                return true;
            case 7:
                this.bbb.Ow();
                return true;
            case 8:
                NQ();
                return true;
            case 9:
                this.bbb.OC();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aNm.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Fs instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar = (com.baidu.tieba.enterForum.b.f) Fs;
                    String forumName = fVar.getForumName();
                    String valueOf = String.valueOf(fVar.getForumId());
                    if (ay.aS(forumName)) {
                        TiebaStatic.log(new aw("c10358").ac("fid", valueOf));
                        TiebaStatic.eventStat(this.aNm.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.MY.bC(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Fs instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar2 = (com.baidu.tieba.enterForum.b.f) Fs;
                    String forumName2 = fVar2.getForumName();
                    String valueOf2 = String.valueOf(fVar2.getForumId());
                    if (ay.aS(forumName2)) {
                        TiebaStatic.log(new aw("c10357").ac("fid", valueOf2));
                        TiebaStatic.eventStat(this.aNm.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aNm.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aNm.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aNm.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aNm.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aNm.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aNm.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aNm.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aNm.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oB() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aNm.getUniqueId();
    }

    public void cm(boolean z) {
        int i = 1;
        if (this.bbb != null && this.bba != null) {
            boolean z2 = this.bbb.Ox() && this.bba.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
