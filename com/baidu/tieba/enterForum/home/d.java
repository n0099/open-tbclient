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
    private com.baidu.tieba.tbadkCore.w LT;
    private BaseFragmentActivity aFU;
    private String aLI;
    private boolean aLK;
    private long aLL;
    private ViewEventCenter aLM;
    private boolean aLN;
    private com.baidu.tbadk.core.view.a aLO;
    private boolean aLR;
    private com.baidu.tbadk.core.dialog.a aLT;
    private com.baidu.tieba.enterForum.d.e aLF = null;
    private com.baidu.tieba.enterForum.c.c aLG = null;
    private boolean isFirst = true;
    private boolean aLH = false;
    private long aLJ = -1;
    private final CustomMessageListener aFV = new e(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener aLP = new o(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private com.baidu.adp.framework.listener.a aLQ = new p(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aLS = new q(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g aLU = new r(this);
    private final c.b aLV = new s(this);
    private p.a aez = new t(this);

    static {
        If();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aLS);
        Ii();
        Ij();
        registerListener(this.aLQ);
        registerListener(this.aFV);
        registerListener(this.aLP);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private static void If() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ig() {
        return (this.aLG.b(this.aLF.IR(), this.aLF.IS()) && (this.aLF.IF() == this.aLF.IJ())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, false));
        this.aLF.IP();
    }

    private void Ii() {
        registerListener(new u(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        registerListener(new v(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    private void Ij() {
        registerListener(new f(this, CmdConfigCustom.MAINTAB_TAB_SLIDINGMENU_CLOSED));
    }

    public void Ik() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bF(i.h.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_cancel_change), new g(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new h(this));
        aVar.b(this.aFU.getPageContext());
        aVar.sO();
    }

    private void Il() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bF(i.h.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.hide), new i(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new j(this));
        aVar.b(getPageContext());
        aVar.sO();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
            aVar.cu(String.format(this.aFU.getPageContext().getString(i.h.attention_cancel_dialog_content), vVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.confirm), new k(this, vVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new l(this));
            aVar.b(getPageContext());
            aVar.sO();
        }
    }

    public void bL(boolean z) {
        if (this.aLO == null) {
            Im();
        }
        this.aLO.av(z);
    }

    private void Im() {
        this.aLO = new com.baidu.tbadk.core.view.a(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aFU = getBaseFragmentActivity();
        this.aLM = new ViewEventCenter();
        this.aLM.addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aLJ = System.currentTimeMillis();
        initData(getArguments());
        initUI();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.aLN = this.aLG.hasShowForumEditGuide();
        com.baidu.tieba.enterForum.c.a.In().j(getFragmentActivity(), com.baidu.adp.lib.util.k.l(getFragmentActivity()));
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(i.g.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aLF = new com.baidu.tieba.enterForum.d.e(this, this.aLM);
        this.aLF.a(this.aez);
        this.aLF.c(new m(this));
    }

    private void initData(Bundle bundle) {
        this.isFirst = true;
        this.aLH = false;
        this.aLI = "";
        this.aLG = new com.baidu.tieba.enterForum.c.c(this.aFU.getPageContext());
        this.aLL = this.aLG.IC();
        this.LT = new com.baidu.tieba.tbadkCore.w(this.aFU.getPageContext());
        this.LT.setLoadDataCallBack(this.aLU);
        this.aLG.a(this.aLV);
        com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("enter_forum_edit_mode", false);
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.aLF != null) {
            if (bVar.HT() != null && bVar.HT().Ic() != null && !bVar.HT().Ic().isEmpty()) {
                this.aLF.a(getPageContext(), bVar.HT().Ic().get(0));
            }
            com.baidu.tieba.enterForum.b.d HU = bVar.HU();
            if (HU != null && HU.HX() != null) {
                int size = HU.HX().size();
                String str = "key_first_start_maintab_" + TbadkCoreApplication.getCurrentAccount();
                boolean z = com.baidu.tbadk.core.sharedPref.b.tr().getBoolean(str, true);
                if (!TbadkCoreApplication.m411getInst().isEnterRecommendFrs() && size < 5 && z && TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getActivity()).createNormalCfg(2)));
                }
                com.baidu.tbadk.core.sharedPref.b.tr().putBoolean(str, false);
                if (size <= 10) {
                    if (size <= 0) {
                        if (this.mIsLogin) {
                            this.aLF.bP(true);
                        } else {
                            this.aLF.bP(false);
                        }
                    } else {
                        this.aLF.bP(false);
                    }
                    boolean aj = this.aLG.aj(this.aLL);
                    List<com.baidu.tieba.enterForum.b.f> Ib = bVar.HS() != null ? bVar.HS().Ib() : null;
                    if (!aj || Ib == null || Ib.isEmpty()) {
                        this.aLF.IU();
                    } else {
                        this.aLF.P(Ib);
                    }
                    if (!this.mIsLogin && Ib != null && !Ib.isEmpty()) {
                        this.aLF.P(Ib);
                    }
                } else {
                    this.aLF.IU();
                    this.aLF.bP(false);
                }
            }
            K(HU == null ? null : HU.HX());
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.tr().getString("hot_search_title", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.aLF.setSearchHint(str.trim());
        } else {
            this.aLF.setSearchHint(getString(i.h.enter_forum_search_tip));
        }
    }

    private void K(List<com.baidu.tieba.tbadkCore.v> list) {
        if (list != null) {
            int eZ = this.aLG.eZ(0);
            if (eZ == 0) {
                if (list.size() > 8) {
                    eZ = 2;
                } else {
                    eZ = 1;
                }
            }
            this.aLF.fc(eZ);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aLF.S(this.aLG.a(list, this.aLG.IB()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aLF != null) {
            this.aLF.onStop();
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
        if (this.aLF != null) {
            this.aLF.onResume();
            bM(false);
            if (this.aLF.IN()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Boolean.valueOf(isPrimary())));
            }
            if (!isPrimary() && this.aLT != null) {
                this.aLT.dismiss();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        Cj();
        com.baidu.tieba.enterForum.c.a.In().destroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aLF != null) {
            this.aLF.onChangeSkinType(i);
        }
    }

    public void Cj() {
        if (this.aLG != null) {
            this.aLG.cancelLoadData();
        }
    }

    public void bM(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aLR && this.aLG != null && this.aLF != null) {
            String str = this.aLI;
            this.aLI = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aLI == null || this.aLI.equals(str)) {
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
                if (this.aLG != null && this.aLG.Ix() != null && this.aLG.Ix().HU() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.v> it = this.aLG.Ix().HU().HX().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.v next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.kS(1);
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
                    com.baidu.tieba.tbadkCore.util.m.lF(currentAccount);
                }
                this.aLF.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Cj();
                if (z4) {
                    this.aLF.nw();
                } else if (z2) {
                    this.aLG.bO(StringUtils.isNull(this.aLI) ? false : true);
                    this.aLF.nw();
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
        private com.baidu.tieba.tbadkCore.v aMa;
        private com.baidu.tbadk.core.util.w afh = null;

        public a(com.baidu.tieba.tbadkCore.v vVar) {
            this.aMa = null;
            this.aMa = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.v... vVarArr) {
            com.baidu.tieba.tbadkCore.v vVar = this.aMa;
            if (vVar != null) {
                try {
                    if (vVar.getId() != null && vVar.getName() != null) {
                        this.afh = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.afh.o(ImageViewerConfig.FORUM_ID, vVar.getId());
                        this.afh.o("kw", vVar.getName());
                        this.afh.ue().uV().mIsNeedTbs = true;
                        this.afh.tD();
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
            if (this.afh != null) {
                if (!this.afh.ue().uW().qS()) {
                    if (d.this.aFU != null) {
                        if (!StringUtils.isNull(this.afh.getErrorString())) {
                            d.this.aFU.showToast(this.afh.getErrorString());
                            return;
                        } else if (d.this.isAdded()) {
                            d.this.aFU.showToast(d.this.getString(i.h.delete_like_fail));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                d.this.aLK = true;
                if (d.this.isAdded() && d.this.aFU != null) {
                    d.this.aFU.showToast(d.this.getString(i.h.delete_like_success));
                }
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                d.this.e(false, this.aMa.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.aMa.getId()));
                d.this.aLF.b(this.aMa);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bL(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afh != null) {
                this.afh.gJ();
                this.afh = null;
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
        int CA = bVar.CA();
        com.baidu.tbadk.mvc.b.a CB = bVar.CB();
        switch (CA) {
            case 1:
                if (CB instanceof com.baidu.tieba.tbadkCore.v) {
                    String name = ((com.baidu.tieba.tbadkCore.v) CB).getName();
                    if (as.aP(name)) {
                        TiebaStatic.eventStat(this.aFU.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aFU.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, true));
                com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("enter_forum_edit_mode", true);
                this.aLF.fa(CB instanceof com.baidu.tieba.enterForum.b.e ? ((com.baidu.tieba.enterForum.b.e) CB).getPosition() : 0);
                this.aLK = false;
                if (getView() != null && getView().getParent() != null) {
                    getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (CB instanceof com.baidu.tieba.tbadkCore.v) {
                    a((com.baidu.tieba.tbadkCore.v) CB);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aLF.IL() != null) {
                    arrayList.addAll(this.aLF.IL());
                }
                List<com.baidu.tieba.tbadkCore.v> M = this.aLG.M(this.aLF.IL());
                if (!arrayList.isEmpty() && this.aLG.b(arrayList, M)) {
                    showToast(i.h.enter_forum_sort_already);
                } else {
                    this.aLF.O(M);
                }
                return true;
            case 7:
                this.aLF.IM();
                return true;
            case 8:
                Il();
                return true;
            case 9:
                this.aLF.IT();
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aFU.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (CB instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar = (com.baidu.tieba.enterForum.b.f) CB;
                    String forumName = fVar.getForumName();
                    String valueOf = String.valueOf(fVar.getForumId());
                    if (as.aP(forumName)) {
                        TiebaStatic.log(new aq("c10358").ae(ImageViewerConfig.FORUM_ID, valueOf));
                        TiebaStatic.eventStat(this.aFU.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.LT.be(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (CB instanceof com.baidu.tieba.enterForum.b.f) {
                    com.baidu.tieba.enterForum.b.f fVar2 = (com.baidu.tieba.enterForum.b.f) CB;
                    String forumName2 = fVar2.getForumName();
                    String valueOf2 = String.valueOf(fVar2.getForumId());
                    if (as.aP(forumName2)) {
                        TiebaStatic.log(new aq("c10357").ae(ImageViewerConfig.FORUM_ID, valueOf2));
                        TiebaStatic.eventStat(this.aFU.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aFU.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aFU.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!this.mIsLogin) {
                            TiebaStatic.eventStat(this.aFU.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aFU.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aFU.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aFU.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aFU.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
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
