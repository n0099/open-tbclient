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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.w Gg;
    private BaseFragmentActivity aVu;
    private f bpP;
    private com.baidu.tieba.enterForum.c.c bpR;
    private boolean bpS;
    private String bpT;
    private long bpV;
    private boolean bpW;
    private long bpX;
    private com.baidu.tbadk.core.view.a bpY;
    private boolean bpZ;
    private com.baidu.tbadk.core.dialog.a bqa;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.d.e bpQ = null;
    private boolean bpU = false;
    private final CustomMessageListener aVv = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private CustomMessageListener bqb = new w(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bqc = new x(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bqd = new aa(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bqe = new ab(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g bqf = new ac(this);
    private final c.b bqg = new ad(this);
    private final CustomMessageListener bqh = new ae(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private z.b agw = new af(this);
    private ViewEventCenter aRj = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        IQ();
    }

    public void gF(int i) {
        if (this.bpQ != null && this.bpQ.TL() != null && this.bpQ.TL().getLayoutParams() != null) {
            this.bpQ.TL().getLayoutParams().height = i;
            this.bpQ.TL().setLayoutParams(this.bpQ.TL().getLayoutParams());
        }
    }

    public l(f fVar) {
        this.bpR = null;
        this.isFirst = true;
        this.bpS = false;
        this.bpV = -1L;
        this.bpP = fVar;
        this.aVu = fVar.getBaseFragmentActivity();
        this.aRj.addEventDelegate(this);
        this.bpV = System.currentTimeMillis();
        this.isFirst = true;
        this.bpS = false;
        this.bpT = "";
        this.bpR = new com.baidu.tieba.enterForum.c.c(this.aVu.getPageContext());
        this.bpX = this.bpR.Tz();
        this.Gg = new com.baidu.tieba.tbadkCore.w(this.aVu.getPageContext());
        this.Gg.setLoadDataCallBack(this.bqf);
        this.bpR.a(this.bqg);
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.Tm().j(this.bpP.getFragmentActivity(), com.baidu.adp.lib.util.k.m(this.bpP.getFragmentActivity()));
        initUI();
        Tc();
    }

    private void Tc() {
        Tf();
        this.bpP.registerListener(this.bqe);
        this.bpP.registerListener(this.bqd);
        this.bpP.registerListener(this.aVv);
        this.bpP.registerListener(this.bqb);
        this.bpP.registerListener(this.bqc);
        this.bpP.registerListener(this.bqh);
    }

    private static void IQ() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Td() {
        return (this.bpR.f(this.bpQ.TR(), this.bpQ.TS()) && (this.bpQ.TC() == this.bpQ.TG())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Te() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bpQ.TN();
    }

    private void Tf() {
        this.bpP.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bpP.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void Tg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aVu.getPageContext().getPageActivity());
        aVar.cb(r.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(r.j.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(r.j.cancel), new q(this));
        aVar.b(this.aVu.getPageContext());
        aVar.tb();
    }

    private void Th() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aVu.getPageContext().getPageActivity());
        aVar.cb(r.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m9getInst().getString(r.j.hide), new r(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(r.j.cancel), new s(this));
        aVar.b(this.aVu.getPageContext());
        aVar.tb();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aVu.getPageContext().getPageActivity());
            aVar.cG(String.format(this.aVu.getPageContext().getString(r.j.attention_cancel_dialog_content), vVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(r.j.confirm), new t(this, vVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(r.j.cancel), new u(this));
            aVar.b(this.aVu.getPageContext());
            aVar.tb();
        }
    }

    public void cW(boolean z) {
        if (this.bpY == null) {
            Ti();
        }
        this.bpY.aJ(z);
    }

    private void Ti() {
        this.bpY = new com.baidu.tbadk.core.view.a(this.aVu.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aVu.getActivity()).inflate(r.h.enter_forum_view, (ViewGroup) null);
        this.bpQ = new com.baidu.tieba.enterForum.d.e(this.bpP, this.mRootView, this.aRj);
        this.bpQ.a(this.agw);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void cX(boolean z) {
        if (this.bpQ != null && this.bpP != null) {
            if (z) {
                if (this.bpP.isPrimary() && this.bpP.isResumed()) {
                    this.bpQ.kv();
                    return;
                } else {
                    this.bpQ.TP();
                    return;
                }
            }
            this.bpQ.TP();
        }
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            this.aVu.showToast(str);
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_BANNER_NO_AD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bpP.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.bpQ != null) {
            c(bVar);
            b(bVar);
            com.baidu.tieba.enterForum.b.e SK = bVar.SK();
            if (SK != null && SK.SP() != null) {
                int size = SK.SP().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bpQ.dc(true);
                        } else {
                            this.bpQ.dc(false);
                        }
                    } else {
                        this.bpQ.dc(false);
                    }
                    boolean aQ = this.bpR.aQ(this.bpX);
                    List<com.baidu.tieba.enterForum.b.g> ST = bVar.SG() != null ? bVar.SG().ST() : null;
                    boolean z = aQ && !com.baidu.tbadk.core.util.x.t(ST);
                    if (z) {
                        this.bpQ.ag(ST);
                    } else {
                        this.bpQ.TU();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.x.t(ST)) {
                        this.bpQ.ag(ST);
                    }
                } else {
                    this.bpQ.TU();
                    this.bpQ.dc(false);
                }
            }
            ab(SK != null ? SK.SP() : null);
            if (TbadkCoreApplication.isLogin() && SK != null && SK.SP() != null && SK.SP().size() > 0) {
                this.bpQ.setAttentionTitleVisibililty(true);
            } else {
                this.bpQ.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.tW().getString("hot_search_title", ""));
            this.bpQ.TV();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.bpQ != null) {
            this.bpQ.f(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.c.e.dN().ac("ad_baichuan_open") != 0 && this.bpQ != null) {
            View bannerView = this.bpQ.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bpQ.ab(bannerView2);
                    this.bpU = false;
                }
            } else if (this.bpU) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bpQ.ab(bannerView3);
                    TiebaStatic.log(new at("c10807"));
                    this.bpU = false;
                }
            } else {
                Z(bannerView);
            }
        }
    }

    private void Z(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int I = com.baidu.adp.lib.util.k.I(this.aVu.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.e(this.aVu.getPageContext(), (int) ((0.16875f * I) + 0.5d), I, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bpQ.setSearchHint(str.trim());
        } else {
            this.bpQ.setSearchHint(this.aVu.getActivity().getString(r.j.enter_forum_search_tip));
        }
    }

    private void ab(List<com.baidu.tieba.tbadkCore.v> list) {
        if (list != null) {
            int gH = this.bpR.gH(0);
            if (gH == 0) {
                if (list.size() > 8) {
                    gH = 2;
                } else {
                    gH = 1;
                }
            }
            this.bpQ.gK(gH);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bpQ.aj(this.bpR.a(list, this.bpR.Ty()));
        }
    }

    public void Tj() {
        if (this.bpQ != null) {
            cY(false);
            if (!this.bpP.isPrimary() && this.bqa != null) {
                this.bqa.dismiss();
            }
        }
    }

    public void onDestroy() {
        Ed();
        com.baidu.tieba.enterForum.c.a.Tm().destroy();
        if (this.bpQ != null && this.bpQ.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.bpQ.getBannerView()), (Class) null);
        }
        if (this.bpQ != null) {
            this.bpQ.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bpQ != null) {
            this.bpQ.onChangeSkinType(i);
        }
    }

    public void Ed() {
        if (this.bpR != null) {
            this.bpR.cancelLoadData();
        }
    }

    public void cY(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bpZ && this.bpR != null && this.bpQ != null) {
            String str = this.bpT;
            this.bpT = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bpT == null || this.bpT.equals(str)) {
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
                if (this.bpR != null && this.bpR.Tv() != null && this.bpR.Tv().SK() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.v> it = this.bpR.Tv().SK().SP().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.v next = it.next();
                        if (TbadkCoreApplication.m9getInst().hasSignedForum(next.getName())) {
                            next.er(1);
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
                    com.baidu.tieba.tbadkCore.util.l.qo(currentAccount);
                }
                this.bpQ.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ed();
                if (z4) {
                    this.bpQ.kv();
                } else if (z2) {
                    this.bpR.db(StringUtils.isNull(this.bpT) ? false : true);
                    this.bpQ.kv();
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
        if (this.bpQ != null && this.bpQ.TK() != null) {
            this.bpQ.TK().ku();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.v, Integer, String> {
        private com.baidu.tbadk.core.util.z aiN = null;
        private com.baidu.tieba.tbadkCore.v bqp;

        public a(com.baidu.tieba.tbadkCore.v vVar) {
            this.bqp = null;
            this.bqp = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.v... vVarArr) {
            com.baidu.tieba.tbadkCore.v vVar = this.bqp;
            if (vVar != null) {
                try {
                    if (vVar.getId() != null && vVar.getName() != null) {
                        this.aiN = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.aiN.n("fid", vVar.getId());
                        this.aiN.n("kw", vVar.getName());
                        this.aiN.uI().vB().mIsNeedTbs = true;
                        this.aiN.uk();
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
        /* renamed from: ew */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            l.this.cW(false);
            if (this.aiN != null) {
                if (!this.aiN.uI().vC().oH()) {
                    if (l.this.aVu != null) {
                        if (StringUtils.isNull(this.aiN.getErrorString())) {
                            if (l.this.bpP.isAdded()) {
                                l.this.aVu.showToast(l.this.aVu.getActivity().getString(r.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        l.this.aVu.showToast(this.aiN.getErrorString());
                        return;
                    }
                    return;
                }
                l.this.bpW = true;
                if (l.this.bpP.isAdded() && l.this.aVu != null) {
                    l.this.aVu.showToast(l.this.aVu.getActivity().getString(r.j.delete_like_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                l.this.f(false, this.bqp.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bqp.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.bqp.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                l.this.bpQ.b(this.bqp);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            l.this.cW(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiN != null) {
                this.aiN.eg();
                this.aiN = null;
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
        int Ey = bVar.Ey();
        com.baidu.tbadk.mvc.b.a Ez = bVar.Ez();
        switch (Ey) {
            case 1:
                if (Ez instanceof com.baidu.tieba.tbadkCore.v) {
                    String name = ((com.baidu.tieba.tbadkCore.v) Ez).getName();
                    if (av.aN(name)) {
                        TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aVu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVu.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, ib(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("enter_forum_edit_mode", true);
                this.bpQ.gI(Ez instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) Ez).getPosition() : 0);
                this.bpW = false;
                if (this.bpP.getView() != null && this.bpP.getView().getParent() != null) {
                    this.bpP.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Ez instanceof com.baidu.tieba.tbadkCore.v) {
                    a((com.baidu.tieba.tbadkCore.v) Ez);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.bpQ.TI() != null) {
                    arrayList.addAll(this.bpQ.TI());
                }
                List<com.baidu.tieba.tbadkCore.v> ad = this.bpR.ad(this.bpQ.TI());
                if (!arrayList.isEmpty() && this.bpR.f(arrayList, ad)) {
                    this.aVu.showToast(r.j.enter_forum_sort_already);
                } else {
                    this.bpQ.af(ad);
                }
                return true;
            case 7:
                this.bpQ.TJ();
                return true;
            case 8:
                Th();
                return true;
            case 9:
                this.bpQ.TT();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Ez instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) Ez;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (av.aN(forumName)) {
                        TiebaStatic.log(new at("c10358").ab("fid", valueOf));
                        TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.Gg.bV(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Ez instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar2 = (com.baidu.tieba.enterForum.b.g) Ez;
                    String forumName2 = gVar2.getForumName();
                    String valueOf2 = String.valueOf(gVar2.getForumId());
                    if (av.aN(forumName2)) {
                        TiebaStatic.log(new at("c10357").ab("fid", valueOf2));
                        TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aVu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVu.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aVu.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aVu.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean ib(String str) {
        if (this.bpR == null || this.bpR.Tv() == null || this.bpR.Tv().SH() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> SM = this.bpR.Tv().SH().SM();
        if (com.baidu.tbadk.core.util.x.t(SM)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : SM) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.x.t(eVar.BS());
            }
        }
        return false;
    }

    public void Tk() {
        if (this.bpQ != null) {
            this.bpQ.TO();
        }
    }

    public boolean Tl() {
        if (this.bpQ != null) {
            return this.bpQ.Tl();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lL() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aVu.getUniqueId();
    }

    public void cZ(boolean z) {
        int i = 1;
        if (this.bpQ != null && this.bpP != null) {
            boolean z2 = this.bpQ.Tl() && this.bpP.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
