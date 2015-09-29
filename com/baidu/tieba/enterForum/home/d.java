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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    private com.baidu.tieba.tbadkCore.w LS;
    private BaseFragmentActivity aFJ;
    private long aLA;
    private ViewEventCenter aLB;
    private boolean aLC;
    private com.baidu.tbadk.core.view.a aLD;
    private boolean aLG;
    private com.baidu.tbadk.core.dialog.a aLI;
    private String aLx;
    private boolean aLz;
    private com.baidu.tieba.enterForum.d.e aLu = null;
    private com.baidu.tieba.enterForum.c.c aLv = null;
    private boolean isFirst = true;
    private boolean aLw = false;
    private long aLy = -1;
    private final CustomMessageListener aFK = new e(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener aLE = new o(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private com.baidu.adp.framework.listener.a aLF = new p(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aLH = new q(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g aLJ = new r(this);
    private final c.b aLK = new s(this);
    private p.a aey = new t(this);

    static {
        Ij();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aLH);
        Im();
        In();
        registerListener(this.aLF);
        registerListener(this.aFK);
        registerListener(this.aLE);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private static void Ij() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ik() {
        return (this.aLv.b(this.aLu.IV(), this.aLu.IW()) && (this.aLu.IJ() == this.aLu.IN())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, false));
        this.aLu.IT();
    }

    private void Im() {
        registerListener(new u(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        registerListener(new v(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    private void In() {
        registerListener(new f(this, CmdConfigCustom.MAINTAB_TAB_SLIDINGMENU_CLOSED));
    }

    public void Io() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bF(i.h.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_cancel_change), new g(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new h(this));
        aVar.b(this.aFJ.getPageContext());
        aVar.sR();
    }

    private void Ip() {
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
            aVar.ct(String.format(this.aFJ.getPageContext().getString(i.h.attention_cancel_dialog_content), vVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.confirm), new k(this, vVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new l(this));
            aVar.b(getPageContext());
            aVar.sR();
        }
    }

    public void bL(boolean z) {
        if (this.aLD == null) {
            Iq();
        }
        this.aLD.av(z);
    }

    private void Iq() {
        this.aLD = new com.baidu.tbadk.core.view.a(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aFJ = getBaseFragmentActivity();
        this.aLB = new ViewEventCenter();
        this.aLB.addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aLy = System.currentTimeMillis();
        initData(getArguments());
        initUI();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.aLC = this.aLv.hasShowForumEditGuide();
        com.baidu.tieba.enterForum.c.a.Ir().j(getFragmentActivity(), com.baidu.adp.lib.util.k.l(getFragmentActivity()));
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(i.g.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aLu = new com.baidu.tieba.enterForum.d.e(this, this.aLB);
        this.aLu.a(this.aey);
        this.aLu.c(new m(this));
    }

    private void initData(Bundle bundle) {
        this.isFirst = true;
        this.aLw = false;
        this.aLx = "";
        this.aLv = new com.baidu.tieba.enterForum.c.c(this.aFJ.getPageContext());
        this.aLA = this.aLv.IG();
        this.LS = new com.baidu.tieba.tbadkCore.w(this.aFJ.getPageContext());
        this.LS.setLoadDataCallBack(this.aLJ);
        this.aLv.a(this.aLK);
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("enter_forum_edit_mode", false);
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.aLu != null) {
            if (bVar.HX() != null && bVar.HX().Ig() != null && !bVar.HX().Ig().isEmpty()) {
                this.aLu.a(getPageContext(), bVar.HX().Ig().get(0));
            }
            com.baidu.tieba.enterForum.b.d HY = bVar.HY();
            if (HY != null && HY.Ib() != null) {
                int size = HY.Ib().size();
                String str = "key_first_start_maintab_" + TbadkCoreApplication.getCurrentAccount();
                boolean z = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(str, true);
                if (!TbadkCoreApplication.m411getInst().isEnterRecommendFrs() && size < 5 && z && TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getActivity()).createNormalCfg(2)));
                }
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean(str, false);
                if (size <= 10) {
                    if (size <= 0) {
                        if (this.mIsLogin) {
                            this.aLu.bP(true);
                        } else {
                            this.aLu.bP(false);
                        }
                    } else {
                        this.aLu.bP(false);
                    }
                    boolean ab = this.aLv.ab(this.aLA);
                    List<com.baidu.tieba.enterForum.b.f> If = bVar.HW() != null ? bVar.HW().If() : null;
                    if (!ab || If == null || If.isEmpty()) {
                        this.aLu.IY();
                    } else {
                        this.aLu.P(If);
                    }
                    if (!this.mIsLogin && If != null && !If.isEmpty()) {
                        this.aLu.P(If);
                    }
                } else {
                    this.aLu.IY();
                    this.aLu.bP(false);
                }
            }
            K(HY == null ? null : HY.Ib());
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.tu().getString("hot_search_title", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.aLu.setSearchHint(str.trim());
        } else {
            this.aLu.setSearchHint(getString(i.h.enter_forum_search_tip));
        }
    }

    private void K(List<com.baidu.tieba.tbadkCore.v> list) {
        if (list != null) {
            int eZ = this.aLv.eZ(0);
            if (eZ == 0) {
                if (list.size() > 8) {
                    eZ = 2;
                } else {
                    eZ = 1;
                }
            }
            this.aLu.fc(eZ);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aLu.S(this.aLv.a(list, this.aLv.IF()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aLu != null) {
            this.aLu.onStop();
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
        if (this.aLu != null) {
            this.aLu.onResume();
            bM(false);
            if (this.aLu.IR()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Boolean.valueOf(isPrimary())));
            }
            if (!isPrimary() && this.aLI != null) {
                this.aLI.dismiss();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        Cm();
        com.baidu.tieba.enterForum.c.a.Ir().destroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aLu != null) {
            this.aLu.onChangeSkinType(i);
        }
    }

    public void Cm() {
        if (this.aLv != null) {
            this.aLv.cancelLoadData();
        }
    }

    public void bM(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aLG && this.aLv != null && this.aLu != null) {
            String str = this.aLx;
            this.aLx = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aLx == null || this.aLx.equals(str)) {
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
                if (this.aLv != null && this.aLv.IB() != null && this.aLv.IB().HY() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.v> it = this.aLv.IB().HY().Ib().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.v next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.kQ(1);
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
                    com.baidu.tieba.tbadkCore.util.m.lC(currentAccount);
                }
                this.aLu.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Cm();
                if (z4) {
                    this.aLu.nw();
                } else if (z2) {
                    this.aLv.bO(StringUtils.isNull(this.aLx) ? false : true);
                    this.aLu.nw();
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
        private com.baidu.tieba.tbadkCore.v aLP;
        private com.baidu.tbadk.core.util.w afg = null;

        public a(com.baidu.tieba.tbadkCore.v vVar) {
            this.aLP = null;
            this.aLP = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.v... vVarArr) {
            com.baidu.tieba.tbadkCore.v vVar = this.aLP;
            if (vVar != null) {
                try {
                    if (vVar.getId() != null && vVar.getName() != null) {
                        this.afg = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.afg.o(ImageViewerConfig.FORUM_ID, vVar.getId());
                        this.afg.o("kw", vVar.getName());
                        this.afg.uh().uX().mIsNeedTbs = true;
                        this.afg.tG();
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
            d.this.bL(false);
            if (this.afg != null) {
                if (!this.afg.uh().uY().qV()) {
                    if (d.this.aFJ != null) {
                        if (!StringUtils.isNull(this.afg.getErrorString())) {
                            d.this.aFJ.showToast(this.afg.getErrorString());
                            return;
                        } else if (d.this.isAdded()) {
                            d.this.aFJ.showToast(d.this.getString(i.h.delete_like_fail));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                d.this.aLz = true;
                if (d.this.isAdded() && d.this.aFJ != null) {
                    d.this.aFJ.showToast(d.this.getString(i.h.delete_like_success));
                }
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                d.this.e(false, this.aLP.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.aLP.getId()));
                d.this.aLu.b(this.aLP);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bL(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afg != null) {
                this.afg.gJ();
                this.afg = null;
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
        int CD = bVar.CD();
        com.baidu.tbadk.mvc.b.a CE = bVar.CE();
        switch (CD) {
            case 1:
                if (CE instanceof com.baidu.tieba.tbadkCore.v) {
                    String name = ((com.baidu.tieba.tbadkCore.v) CE).getName();
                    if (ar.aP(name)) {
                        TiebaStatic.eventStat(this.aFJ.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aFJ.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, true));
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("enter_forum_edit_mode", true);
                this.aLu.fa(CE instanceof com.baidu.tieba.enterForum.b.e ? ((com.baidu.tieba.enterForum.b.e) CE).getPosition() : 0);
                this.aLz = false;
                if (getView() != null && getView().getParent() != null) {
                    getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (CE instanceof com.baidu.tieba.tbadkCore.v) {
                    a((com.baidu.tieba.tbadkCore.v) CE);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aLu.IP() != null) {
                    arrayList.addAll(this.aLu.IP());
                }
                List<com.baidu.tieba.tbadkCore.v> M = this.aLv.M(this.aLu.IP());
                if (!arrayList.isEmpty() && this.aLv.b(arrayList, M)) {
                    showToast(i.h.enter_forum_sort_already);
                } else {
                    this.aLu.O(M);
                }
                return true;
            case 7:
                this.aLu.IQ();
                return true;
            case 8:
                Ip();
                return true;
            case 9:
                this.aLu.IX();
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aFJ.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (CE instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar = (com.baidu.tieba.enterForum.b.f) CE;
                    String forumName = fVar.getForumName();
                    String valueOf = String.valueOf(fVar.getForumId());
                    if (ar.aP(forumName)) {
                        TiebaStatic.log(new ap("c10358").ae(ImageViewerConfig.FORUM_ID, valueOf));
                        TiebaStatic.eventStat(this.aFJ.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.LS.be(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (CE instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar2 = (com.baidu.tieba.enterForum.b.f) CE;
                    String forumName2 = fVar2.getForumName();
                    String valueOf2 = String.valueOf(fVar2.getForumId());
                    if (ar.aP(forumName2)) {
                        TiebaStatic.log(new ap("c10357").ae(ImageViewerConfig.FORUM_ID, valueOf2));
                        TiebaStatic.eventStat(this.aFJ.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aFJ.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aFJ.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!this.mIsLogin) {
                            TiebaStatic.eventStat(this.aFJ.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aFJ.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aFJ.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aFJ.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aFJ.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oI() {
        return false;
    }
}
