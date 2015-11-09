package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.SettingChangeMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseFragment implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.w LU;
    private BaseFragmentActivity aEO;
    private String aLQ;
    private boolean aLS;
    private long aLT;
    private ViewEventCenter aLU;
    private boolean aLV;
    private com.baidu.tbadk.core.view.a aLW;
    private boolean aLZ;
    private com.baidu.tbadk.core.dialog.a aMb;
    private com.baidu.tieba.enterForum.d.e aLN = null;
    private com.baidu.tieba.enterForum.c.c aLO = null;
    private boolean isFirst = true;
    private boolean aLP = false;
    private long aLR = -1;
    private final CustomMessageListener aEP = new e(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener aLX = new o(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private com.baidu.adp.framework.listener.a aLY = new p(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aMa = new q(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g aMc = new r(this);
    private final c.b aMd = new s(this);
    private p.a aeE = new t(this);

    static {
        Iv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aMa);
        Iy();
        Iz();
        registerListener(this.aLY);
        registerListener(this.aEP);
        registerListener(this.aLX);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private static void Iv() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Iw() {
        return (this.aLO.b(this.aLN.Jh(), this.aLN.Ji()) && (this.aLN.IV() == this.aLN.IZ())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, false));
        this.aLN.Jf();
    }

    private void Iy() {
        registerListener(new u(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        registerListener(new v(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    private void Iz() {
        registerListener(new f(this, CmdConfigCustom.MAINTAB_TAB_SLIDINGMENU_CLOSED));
    }

    public void IA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bF(i.h.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_cancel_change), new g(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new h(this));
        aVar.b(this.aEO.getPageContext());
        aVar.sR();
    }

    private void IB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bF(i.h.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.hide), new i(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new j(this));
        aVar.b(getPageContext());
        aVar.sR();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
            aVar.cu(String.format(this.aEO.getPageContext().getString(i.h.attention_cancel_dialog_content), vVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.confirm), new k(this, vVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new l(this));
            aVar.b(getPageContext());
            aVar.sR();
        }
    }

    public void bN(boolean z) {
        if (this.aLW == null) {
            IC();
        }
        this.aLW.av(z);
    }

    private void IC() {
        this.aLW = new com.baidu.tbadk.core.view.a(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aEO = getBaseFragmentActivity();
        this.aLU = new ViewEventCenter();
        this.aLU.addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aLR = System.currentTimeMillis();
        initData(getArguments());
        initUI();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.aLV = this.aLO.hasShowForumEditGuide();
        com.baidu.tieba.enterForum.c.a.ID().j(getFragmentActivity(), com.baidu.adp.lib.util.k.l(getFragmentActivity()));
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(i.g.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aLN = new com.baidu.tieba.enterForum.d.e(this, this.aLU);
        this.aLN.a(this.aeE);
        this.aLN.c(new m(this));
    }

    private void initData(Bundle bundle) {
        this.isFirst = true;
        this.aLP = false;
        this.aLQ = "";
        this.aLO = new com.baidu.tieba.enterForum.c.c(this.aEO.getPageContext());
        this.aLT = this.aLO.IS();
        this.LU = new com.baidu.tieba.tbadkCore.w(this.aEO.getPageContext());
        this.LU.setLoadDataCallBack(this.aMc);
        this.aLO.a(this.aMd);
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("enter_forum_edit_mode", false);
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.aLN != null) {
            if (bVar.Ij() != null && bVar.Ij().Is() != null && !bVar.Ij().Is().isEmpty()) {
                this.aLN.a(getPageContext(), bVar.Ij().Is().get(0));
            }
            com.baidu.tieba.enterForum.b.d Ik = bVar.Ik();
            if (Ik != null && Ik.In() != null) {
                int size = Ik.In().size();
                String str = "key_first_start_maintab_" + TbadkCoreApplication.getCurrentAccount();
                boolean z = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(str, true);
                if (!TbadkCoreApplication.m411getInst().isEnterRecommendFrs() && size < 5 && z && TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getActivity()).createNormalCfg(2)));
                }
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean(str, false);
                if (size <= 10) {
                    if (size <= 0) {
                        if (this.mIsLogin) {
                            this.aLN.bR(true);
                        } else {
                            this.aLN.bR(false);
                        }
                    } else {
                        this.aLN.bR(false);
                    }
                    boolean aj = this.aLO.aj(this.aLT);
                    List<com.baidu.tieba.enterForum.b.f> Ir = bVar.Ii() != null ? bVar.Ii().Ir() : null;
                    if (!aj || Ir == null || Ir.isEmpty()) {
                        this.aLN.Jk();
                    } else {
                        this.aLN.R(Ir);
                    }
                    if (!this.mIsLogin && Ir != null && !Ir.isEmpty()) {
                        this.aLN.R(Ir);
                    }
                } else {
                    this.aLN.Jk();
                    this.aLN.bR(false);
                }
            }
            M(Ik == null ? null : Ik.In());
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.tu().getString("hot_search_title", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.aLN.setSearchHint(str.trim());
        } else {
            this.aLN.setSearchHint(getString(i.h.enter_forum_search_tip));
        }
    }

    private void M(List<com.baidu.tieba.tbadkCore.v> list) {
        if (list != null) {
            int fh = this.aLO.fh(0);
            if (fh == 0) {
                if (list.size() > 8) {
                    fh = 2;
                } else {
                    fh = 1;
                }
            }
            this.aLN.fk(fh);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aLN.U(this.aLO.a(list, this.aLO.IR()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aLN != null) {
            this.aLN.onStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!isShow()) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.aLN != null) {
            this.aLN.onResume();
            bO(false);
            if (this.aLN.Jd()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Boolean.valueOf(isPrimary())));
            }
            if (!isPrimary() && this.aMb != null) {
                this.aMb.dismiss();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        Cc();
        com.baidu.tieba.enterForum.c.a.ID().destroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aLN != null) {
            this.aLN.onChangeSkinType(i);
        }
    }

    public void Cc() {
        if (this.aLO != null) {
            this.aLO.cancelLoadData();
        }
    }

    public void bO(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aLZ && this.aLO != null && this.aLN != null) {
            String str = this.aLQ;
            this.aLQ = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aLQ == null || this.aLQ.equals(str)) {
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
                if (this.aLO != null && this.aLO.IN() != null && this.aLO.IN().Ik() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.v> it = this.aLO.IN().Ik().In().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.v next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.lg(1);
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
                    com.baidu.tieba.tbadkCore.util.m.lL(currentAccount);
                }
                this.aLN.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Cc();
                if (z4) {
                    this.aLN.nx();
                } else if (z2) {
                    this.aLO.bQ(StringUtils.isNull(this.aLQ) ? false : true);
                    this.aLN.nx();
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
        private com.baidu.tieba.tbadkCore.v aMi;
        private com.baidu.tbadk.core.util.w afm = null;

        public a(com.baidu.tieba.tbadkCore.v vVar) {
            this.aMi = null;
            this.aMi = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.v... vVarArr) {
            com.baidu.tieba.tbadkCore.v vVar = this.aMi;
            if (vVar != null) {
                try {
                    if (vVar.getId() != null && vVar.getName() != null) {
                        this.afm = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.afm.o(ImageViewerConfig.FORUM_ID, vVar.getId());
                        this.afm.o("kw", vVar.getName());
                        this.afm.uh().uZ().mIsNeedTbs = true;
                        this.afm.tG();
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
            d.this.bN(false);
            if (this.afm != null) {
                if (!this.afm.uh().va().qT()) {
                    if (d.this.aEO != null) {
                        if (!StringUtils.isNull(this.afm.getErrorString())) {
                            d.this.aEO.showToast(this.afm.getErrorString());
                            return;
                        } else if (d.this.isAdded()) {
                            d.this.aEO.showToast(d.this.getString(i.h.delete_like_fail));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                d.this.aLS = true;
                if (d.this.isAdded() && d.this.aEO != null) {
                    d.this.aEO.showToast(d.this.getString(i.h.delete_like_success));
                }
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                d.this.e(false, this.aMi.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.aMi.getId()));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(this.aMi.getId(), 0L))));
                d.this.aLN.b(this.aMi);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bN(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afm != null) {
                this.afm.gJ();
                this.afm = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new n(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Ct = bVar.Ct();
        com.baidu.tbadk.mvc.b.a Cu = bVar.Cu();
        switch (Ct) {
            case 1:
                if (Cu instanceof com.baidu.tieba.tbadkCore.v) {
                    String name = ((com.baidu.tieba.tbadkCore.v) Cu).getName();
                    if (as.aN(name)) {
                        TiebaStatic.eventStat(this.aEO.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aEO.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, true));
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("enter_forum_edit_mode", true);
                this.aLN.fi(Cu instanceof com.baidu.tieba.enterForum.b.e ? ((com.baidu.tieba.enterForum.b.e) Cu).getPosition() : 0);
                this.aLS = false;
                if (getView() != null && getView().getParent() != null) {
                    getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Cu instanceof com.baidu.tieba.tbadkCore.v) {
                    a((com.baidu.tieba.tbadkCore.v) Cu);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aLN.Jb() != null) {
                    arrayList.addAll(this.aLN.Jb());
                }
                List<com.baidu.tieba.tbadkCore.v> O = this.aLO.O(this.aLN.Jb());
                if (!arrayList.isEmpty() && this.aLO.b(arrayList, O)) {
                    showToast(i.h.enter_forum_sort_already);
                } else {
                    this.aLN.Q(O);
                }
                return true;
            case 7:
                this.aLN.Jc();
                return true;
            case 8:
                IB();
                return true;
            case 9:
                this.aLN.Jj();
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aEO.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Cu instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar = (com.baidu.tieba.enterForum.b.f) Cu;
                    String forumName = fVar.getForumName();
                    String valueOf = String.valueOf(fVar.getForumId());
                    if (as.aN(forumName)) {
                        TiebaStatic.log(new aq("c10358").ae(ImageViewerConfig.FORUM_ID, valueOf));
                        TiebaStatic.eventStat(this.aEO.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.LU.bd(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Cu instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar2 = (com.baidu.tieba.enterForum.b.f) Cu;
                    String forumName2 = fVar2.getForumName();
                    String valueOf2 = String.valueOf(fVar2.getForumId());
                    if (as.aN(forumName2)) {
                        TiebaStatic.log(new aq("c10357").ae(ImageViewerConfig.FORUM_ID, valueOf2));
                        TiebaStatic.eventStat(this.aEO.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aEO.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aEO.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!this.mIsLogin) {
                            TiebaStatic.eventStat(this.aEO.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aEO.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aEO.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aEO.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aEO.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oJ() {
        return false;
    }
}
