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
    private com.baidu.tieba.tbadkCore.y Dq;
    private BaseFragmentActivity aMU;
    private e btf;
    private com.baidu.tieba.enterForum.c.c bth;
    private boolean bti;
    private String btj;
    private long btl;
    private boolean btm;
    private long bto;
    private com.baidu.tbadk.core.view.b btp;
    private boolean btq;
    private com.baidu.tbadk.core.dialog.a btr;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.view.e btg = null;
    private boolean btk = false;
    private final CustomMessageListener aMV = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener bts = new v(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener btt = new x(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener btu = new y(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a btv = new ab(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener btw = new ac(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g btx = new ad(this);
    private final c.b bty = new ae(this);
    private final CustomMessageListener btz = new af(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private t.b acD = new m(this);
    private ViewEventCenter bfx = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Iv();
    }

    public void gO(int i) {
        if (this.btg != null && this.btg.SM() != null && this.btg.SM().getLayoutParams() != null) {
            this.btg.SM().getLayoutParams().height = i;
            this.btg.SM().setLayoutParams(this.btg.SM().getLayoutParams());
        }
    }

    public k(e eVar) {
        this.bth = null;
        this.isFirst = true;
        this.bti = false;
        this.btl = -1L;
        this.btf = eVar;
        this.aMU = eVar.getBaseFragmentActivity();
        this.bfx.addEventDelegate(this);
        this.btl = System.currentTimeMillis();
        this.isFirst = true;
        this.bti = false;
        this.btj = "";
        this.bth = new com.baidu.tieba.enterForum.c.c(this.aMU.getPageContext());
        this.bto = this.bth.Sy();
        this.Dq = new com.baidu.tieba.tbadkCore.y(this.aMU.getPageContext());
        this.Dq.setLoadDataCallBack(this.btx);
        this.bth.a(this.bty);
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.Sk().i(this.btf.getFragmentActivity(), com.baidu.adp.lib.util.k.i(this.btf.getFragmentActivity()));
        nl();
        Pk();
    }

    private void Pk() {
        Sd();
        this.btf.registerListener(this.btw);
        this.btf.registerListener(this.btv);
        this.btf.registerListener(this.aMV);
        this.btf.registerListener(this.bts);
        this.btf.registerListener(this.btt);
        this.btf.registerListener(this.btu);
        this.btf.registerListener(this.btz);
    }

    private static void Iv() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sb() {
        return (this.bth.e(this.btg.SS(), this.btg.ST()) && (this.btg.SB() == this.btg.SH())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.btg.Sh();
    }

    private void Sd() {
        this.btf.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.btf.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void Se() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aMU.getPageContext().getPageActivity());
        aVar.bM(u.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(u.j.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(u.j.cancel), new q(this));
        aVar.b(this.aMU.getPageContext());
        aVar.rT();
    }

    private void Sf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aMU.getPageContext().getPageActivity());
        aVar.bM(u.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m9getInst().getString(u.j.hide), new r(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(u.j.cancel), new s(this));
        aVar.b(this.aMU.getPageContext());
        aVar.rT();
    }

    public void a(com.baidu.tieba.tbadkCore.x xVar) {
        if (xVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aMU.getPageContext().getPageActivity());
            aVar.cz(String.format(this.aMU.getPageContext().getString(u.j.attention_cancel_dialog_content), xVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(u.j.confirm), new t(this, xVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(u.j.cancel), new u(this));
            aVar.b(this.aMU.getPageContext());
            aVar.rT();
        }
    }

    public void cL(boolean z) {
        if (this.btp == null) {
            Sg();
        }
        this.btp.aB(z);
    }

    private void Sg() {
        this.btp = new com.baidu.tbadk.core.view.b(this.aMU.getPageContext());
    }

    private void nl() {
        this.mRootView = LayoutInflater.from(this.aMU.getActivity()).inflate(u.h.enter_forum_view, (ViewGroup) null);
        this.btg = new com.baidu.tieba.enterForum.view.e(this.btf, this.mRootView, this.bfx);
        this.btg.a(this.acD);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void cM(boolean z) {
        if (this.btg != null && this.btf != null) {
            if (z) {
                if (this.btf.isPrimary() && this.btf.isResumed()) {
                    this.btg.jB();
                    return;
                } else {
                    this.btg.SQ();
                    return;
                }
            }
            this.btg.SQ();
        }
    }

    public void f(boolean z, String str) {
        if (!z && str != null) {
            this.aMU.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.btf.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.btg != null) {
            c(bVar);
            d(bVar);
            b(bVar);
            com.baidu.tieba.enterForum.b.e RL = bVar.RL();
            if (RL != null && RL.RQ() != null) {
                int size = RL.RQ().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.btg.cR(true);
                        } else {
                            this.btg.cR(false);
                        }
                    } else {
                        this.btg.cR(false);
                    }
                    boolean aO = this.bth.aO(this.bto);
                    List<com.baidu.tieba.enterForum.b.g> RT = bVar.RH() != null ? bVar.RH().RT() : null;
                    boolean z = aO && !com.baidu.tbadk.core.util.y.t(RT);
                    if (z) {
                        this.btg.ag(RT);
                    } else {
                        this.btg.SV();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.y.t(RT)) {
                        this.btg.ag(RT);
                    }
                } else {
                    this.btg.SV();
                    this.btg.cR(false);
                }
            }
            ab(RL != null ? RL.RQ() : null);
            if (TbadkCoreApplication.isLogin() && RL != null && RL.RQ() != null && RL.RQ().size() > 0) {
                this.btg.setAttentionTitleVisibililty(true);
            } else {
                this.btg.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.sO().getString("hot_search_title", ""));
            this.btg.SX();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.btg != null) {
            this.btg.g(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.c.e.cT().Z("ad_baichuan_open") != 0 && this.btg != null) {
            View bannerView = this.btg.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.btg.aa(bannerView2);
                    this.btk = false;
                }
            } else if (this.btk) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.btg.aa(bannerView3);
                    TiebaStatic.log(new ay("c10807"));
                    this.btk = false;
                }
            } else {
                Y(bannerView);
            }
        }
    }

    private void d(com.baidu.tieba.enterForum.b.b bVar) {
        View togetherHiBannerView;
        if (com.baidu.tbadk.plugins.d.Fk() && this.btg != null && this.btg.getTogetherHiBannerView() == null && (togetherHiBannerView = getTogetherHiBannerView()) != null) {
            this.btg.ab(togetherHiBannerView);
        }
    }

    private void Y(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int A = com.baidu.adp.lib.util.k.A(this.aMU.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.b(this.aMU.getActivity(), this.aMU.getResources().getDimensionPixelSize(u.e.ds100), A, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    private View getTogetherHiBannerView() {
        int A = com.baidu.adp.lib.util.k.A(this.aMU.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_HI_GETENTERBANNER, View.class, new com.baidu.tbadk.coreExtra.data.n(this.aMU.getActivity(), this.aMU.getResources().getDimensionPixelSize(u.e.ds100), A, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.btg.setSearchHint(str.trim());
        } else {
            this.btg.setSearchHint(this.aMU.getActivity().getString(u.j.enter_forum_search_tip));
        }
    }

    private void ab(List<com.baidu.tieba.tbadkCore.x> list) {
        if (list != null) {
            int gQ = this.bth.gQ(0);
            if (gQ == 0) {
                if (list.size() > 8) {
                    gQ = 2;
                } else {
                    gQ = 1;
                }
            }
            this.btg.gT(gQ);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.btg.aj(this.bth.a(list, this.bth.Sx()));
        }
    }

    public void MJ() {
        if (this.btg != null) {
            cN(false);
            if (!this.btf.isPrimary() && this.btr != null) {
                this.btr.dismiss();
            }
        }
    }

    public void onDestroy() {
        CW();
        com.baidu.tieba.enterForum.c.a.Sk().destroy();
        if (this.btg != null && this.btg.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.btg.getBannerView()), (Class) null);
        }
        if (this.btg != null) {
            this.btg.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.btg != null) {
            this.btg.onChangeSkinType(i);
        }
    }

    public void CW() {
        if (this.bth != null) {
            this.bth.cancelLoadData();
        }
    }

    public void cN(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.btq && this.bth != null && this.btg != null) {
            String str = this.btj;
            this.btj = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.btj == null || this.btj.equals(str)) {
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
                if (this.bth != null && this.bth.Su() != null && this.bth.Su().RL() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.x> it = this.bth.Su().RL().RQ().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.x next = it.next();
                        if (TbadkCoreApplication.m9getInst().hasSignedForum(next.getName())) {
                            next.ea(1);
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
                    com.baidu.tieba.tbadkCore.util.m.pE(currentAccount);
                }
                this.btg.notifyDataSetChanged();
            }
            if (z2 || z4) {
                CW();
                if (z4) {
                    this.btg.jB();
                } else if (z2) {
                    this.bth.cQ(StringUtils.isNull(this.btj) ? false : true);
                    this.btg.jB();
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
        if (this.btg != null && this.btg.SL() != null) {
            this.btg.SL().jA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.x, Integer, String> {
        private com.baidu.tbadk.core.util.ab afj = null;
        private com.baidu.tieba.tbadkCore.x btH;

        public a(com.baidu.tieba.tbadkCore.x xVar) {
            this.btH = null;
            this.btH = xVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.x... xVarArr) {
            com.baidu.tieba.tbadkCore.x xVar = this.btH;
            if (xVar != null) {
                try {
                    if (xVar.getId() != null && xVar.getName() != null) {
                        this.afj = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.afj.n("fid", xVar.getId());
                        this.afj.n("kw", xVar.getName());
                        this.afj.ty().uu().mIsNeedTbs = true;
                        this.afj.ta();
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
        /* renamed from: es */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            k.this.cL(false);
            if (this.afj != null) {
                if (!this.afj.ty().uv().nU()) {
                    if (k.this.aMU != null) {
                        if (StringUtils.isNull(this.afj.getErrorString())) {
                            if (k.this.btf.isAdded()) {
                                k.this.aMU.showToast(k.this.aMU.getActivity().getString(u.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        k.this.aMU.showToast(this.afj.getErrorString());
                        return;
                    }
                    return;
                }
                k.this.btm = true;
                if (k.this.btf.isAdded() && k.this.aMU != null) {
                    k.this.aMU.showToast(k.this.aMU.getActivity().getString(u.j.delete_like_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                k.this.g(false, this.btH.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.btH.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.btH.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                k.this.btg.b(this.btH);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            k.this.cL(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afj != null) {
                this.afj.dm();
                this.afj = null;
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
        int Ds = bVar.Ds();
        com.baidu.tbadk.mvc.b.a Dt = bVar.Dt();
        switch (Ds) {
            case 1:
                if (Dt instanceof com.baidu.tieba.tbadkCore.x) {
                    String name = ((com.baidu.tieba.tbadkCore.x) Dt).getName();
                    if (ba.aL(name)) {
                        TiebaStatic.eventStat(this.aMU.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aMU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aMU.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, iw(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("enter_forum_edit_mode", true);
                this.btg.gR(Dt instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) Dt).getPosition() : 0);
                this.btm = false;
                if (this.btf.getView() != null && this.btf.getView().getParent() != null) {
                    this.btf.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Dt instanceof com.baidu.tieba.tbadkCore.x) {
                    a((com.baidu.tieba.tbadkCore.x) Dt);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.btg.SJ() != null) {
                    arrayList.addAll(this.btg.SJ());
                }
                List<com.baidu.tieba.tbadkCore.x> ad = this.bth.ad(this.btg.SJ());
                if (!arrayList.isEmpty() && this.bth.e(arrayList, ad)) {
                    this.aMU.showToast(u.j.enter_forum_sort_already);
                } else {
                    this.btg.af(ad);
                }
                return true;
            case 7:
                this.btg.SK();
                return true;
            case 8:
                Sf();
                return true;
            case 9:
                this.btg.SU();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aMU.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Dt instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) Dt;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (ba.aL(forumName)) {
                        TiebaStatic.log(new ay("c10358").ab("fid", valueOf));
                        TiebaStatic.eventStat(this.aMU.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.Dq.bJ(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Dt instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar2 = (com.baidu.tieba.enterForum.b.g) Dt;
                    String forumName2 = gVar2.getForumName();
                    String valueOf2 = String.valueOf(gVar2.getForumId());
                    if (ba.aL(forumName2)) {
                        TiebaStatic.log(new ay("c10357").ab("fid", valueOf2));
                        TiebaStatic.eventStat(this.aMU.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aMU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aMU.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aMU.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aMU.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aMU.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aMU.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aMU.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aMU.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean iw(String str) {
        if (this.bth == null || this.bth.Su() == null || this.bth.Su().RI() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> RN = this.bth.Su().RI().RN();
        if (com.baidu.tbadk.core.util.y.t(RN)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : RN) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.y.t(eVar.AH());
            }
        }
        return false;
    }

    public void Sh() {
        if (this.btg != null) {
            this.btg.SO();
        }
    }

    public void Si() {
        if (this.btg != null) {
            this.btg.SP();
        }
    }

    public boolean Sj() {
        if (this.btg != null) {
            return this.btg.Sj();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kR() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aMU.getUniqueId();
    }

    public void cO(boolean z) {
        int i = 1;
        if (this.btg != null && this.btf != null) {
            boolean z2 = this.btg.Sj() && this.btf.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
