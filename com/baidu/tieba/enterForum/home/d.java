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
import com.baidu.tbadk.core.view.x;
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
    private BaseFragmentActivity aGQ;
    private String aMC;
    private boolean aME;
    private long aMF;
    private ViewEventCenter aMG;
    private boolean aMH;
    private com.baidu.tbadk.core.view.a aMI;
    private boolean aML;
    private com.baidu.tbadk.core.dialog.a aMN;
    private com.baidu.tieba.enterForum.d.e aMz = null;
    private com.baidu.tieba.enterForum.c.c aMA = null;
    private boolean isFirst = true;
    private boolean aMB = false;
    private long aMD = -1;
    private final CustomMessageListener aGR = new e(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener aMJ = new o(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private com.baidu.adp.framework.listener.a aMK = new p(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aMM = new q(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g aMO = new r(this);
    private final c.b aMP = new s(this);
    private x.a afl = new t(this);

    static {
        In();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aMM);
        Iq();
        Ir();
        registerListener(this.aMK);
        registerListener(this.aGR);
        registerListener(this.aMJ);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private static void In() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Io() {
        return (this.aMA.b(this.aMz.Ja(), this.aMz.Jb()) && (this.aMz.IN() == this.aMz.IR())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ip() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, false));
        this.aMz.IY();
    }

    private void Iq() {
        registerListener(new u(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        registerListener(new v(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    private void Ir() {
        registerListener(new f(this, CmdConfigCustom.MAINTAB_TAB_SLIDINGMENU_CLOSED));
    }

    public void Is() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bF(i.h.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_cancel_change), new g(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new h(this));
        aVar.b(this.aGQ.getPageContext());
        aVar.sU();
    }

    private void It() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bF(i.h.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.hide), new i(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new j(this));
        aVar.b(getPageContext());
        aVar.sU();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
            aVar.ct(String.format(this.aGQ.getPageContext().getString(i.h.attention_cancel_dialog_content), vVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.confirm), new k(this, vVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new l(this));
            aVar.b(getPageContext());
            aVar.sU();
        }
    }

    public void bO(boolean z) {
        if (this.aMI == null) {
            Iu();
        }
        this.aMI.av(z);
    }

    private void Iu() {
        this.aMI = new com.baidu.tbadk.core.view.a(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aGQ = getBaseFragmentActivity();
        this.aMG = new ViewEventCenter();
        this.aMG.addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aMD = System.currentTimeMillis();
        initData(getArguments());
        initUI();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.aMH = this.aMA.hasShowForumEditGuide();
        com.baidu.tieba.enterForum.c.a.Iv().j(getFragmentActivity(), com.baidu.adp.lib.util.k.l(getFragmentActivity()));
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(i.g.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aMz = new com.baidu.tieba.enterForum.d.e(this, this.aMG);
        this.aMz.a(this.afl);
        this.aMz.c(new m(this));
    }

    private void initData(Bundle bundle) {
        this.isFirst = true;
        this.aMB = false;
        this.aMC = "";
        this.aMA = new com.baidu.tieba.enterForum.c.c(this.aGQ.getPageContext());
        this.aMF = this.aMA.IK();
        this.LS = new com.baidu.tieba.tbadkCore.w(this.aGQ.getPageContext());
        this.LS.setLoadDataCallBack(this.aMO);
        this.aMA.a(this.aMP);
        com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("enter_forum_edit_mode", false);
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null) {
            if (bVar.Id() != null && bVar.Id().sl() != null && !bVar.Id().sl().isEmpty()) {
                this.aMz.a(getPageContext(), bVar.Id().sl().get(0));
            }
            com.baidu.tieba.enterForum.b.c Ie = bVar.Ie();
            if (Ie != null && Ie.Ig() != null) {
                int size = Ie.Ig().size();
                String str = "key_first_start_maintab_" + TbadkCoreApplication.getCurrentAccount();
                boolean z = com.baidu.tbadk.core.sharedPref.b.tx().getBoolean(str, true);
                if (!TbadkCoreApplication.m411getInst().isEnterRecommendFrs() && size < 5 && z && TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getActivity()).createNormalCfg(2)));
                }
                com.baidu.tbadk.core.sharedPref.b.tx().putBoolean(str, false);
                if (size <= 10) {
                    if (size <= 0) {
                        if (this.mIsLogin) {
                            this.aMz.bS(true);
                        } else {
                            this.aMz.bS(false);
                        }
                    } else {
                        this.aMz.bS(false);
                    }
                    boolean S = this.aMA.S(this.aMF);
                    List<com.baidu.tieba.enterForum.b.e> Ik = bVar.Ic() != null ? bVar.Ic().Ik() : null;
                    if (!S || Ik == null || Ik.isEmpty()) {
                        this.aMz.Jd();
                    } else {
                        this.aMz.O(Ik);
                    }
                    if (!this.mIsLogin && Ik != null && !Ik.isEmpty()) {
                        this.aMz.O(Ik);
                    }
                } else {
                    this.aMz.Jd();
                    this.aMz.bS(false);
                }
            }
            J(Ie == null ? null : Ie.Ig());
        }
    }

    private void J(List<com.baidu.tieba.tbadkCore.v> list) {
        if (list != null) {
            int eU = this.aMA.eU(0);
            if (eU == 0) {
                if (list.size() > 8) {
                    eU = 2;
                } else {
                    eU = 1;
                }
            }
            this.aMz.eX(eU);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aMz.R(this.aMA.a(list, this.aMA.IJ()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aMz.onStop();
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
        this.aMz.onResume();
        bP(false);
        if (this.aMz.IW()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Boolean.valueOf(isPrimary())));
        }
        if (!isPrimary() && this.aMN != null) {
            this.aMN.dismiss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        Cz();
        com.baidu.tieba.enterForum.c.a.Iv().destroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aMz.onChangeSkinType(i);
    }

    public void Cz() {
        this.aMA.cancelLoadData();
    }

    public void bP(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aML && this.aMA != null) {
            String str = this.aMC;
            this.aMC = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aMC == null || this.aMC.equals(str)) {
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
                if (this.aMA != null && this.aMA.IF() != null && this.aMA.IF().Ie() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.v> it = this.aMA.IF().Ie().Ig().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.v next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.kq(1);
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
                    com.baidu.tieba.tbadkCore.util.k.le(currentAccount);
                }
                this.aMz.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Cz();
                if (z4) {
                    this.aMz.nv();
                } else if (z2) {
                    this.aMA.bR(StringUtils.isNull(this.aMC) ? false : true);
                    this.aMz.nv();
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
        private com.baidu.tieba.tbadkCore.v aMU;
        private com.baidu.tbadk.core.util.v afT = null;

        public a(com.baidu.tieba.tbadkCore.v vVar) {
            this.aMU = null;
            this.aMU = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.v... vVarArr) {
            com.baidu.tieba.tbadkCore.v vVar = this.aMU;
            if (vVar != null) {
                try {
                    if (vVar.getId() != null && vVar.getName() != null) {
                        this.afT = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.afT.o(ImageViewerConfig.FORUM_ID, vVar.getId());
                        this.afT.o("kw", vVar.getName());
                        this.afT.uj().uZ().mIsNeedTbs = true;
                        this.afT.tI();
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
            d.this.bO(false);
            if (this.afT != null) {
                if (!this.afT.uj().va().qZ()) {
                    if (d.this.aGQ != null) {
                        if (!StringUtils.isNull(this.afT.getErrorString())) {
                            d.this.aGQ.showToast(this.afT.getErrorString());
                            return;
                        } else if (d.this.isAdded()) {
                            d.this.aGQ.showToast(d.this.getString(i.h.delete_like_fail));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                d.this.aME = true;
                if (d.this.isAdded() && d.this.aGQ != null) {
                    d.this.aGQ.showToast(d.this.getString(i.h.delete_like_success));
                }
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                d.this.e(false, this.aMU.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.aMU.getId()));
                d.this.aMz.b(this.aMU);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bO(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afT != null) {
                this.afT.gJ();
                this.afT = null;
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
        int CQ = bVar.CQ();
        com.baidu.tbadk.mvc.b.a CR = bVar.CR();
        switch (CQ) {
            case 1:
                if (CR instanceof com.baidu.tieba.tbadkCore.v) {
                    String name = ((com.baidu.tieba.tbadkCore.v) CR).getName();
                    if (aq.aP(name)) {
                        TiebaStatic.eventStat(this.aGQ.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aGQ.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, true));
                com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("enter_forum_edit_mode", true);
                this.aMz.eV(CR instanceof com.baidu.tieba.enterForum.b.d ? ((com.baidu.tieba.enterForum.b.d) CR).getPosition() : 0);
                this.aME = false;
                if (getView() != null && getView().getParent() != null) {
                    getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (CR instanceof com.baidu.tieba.tbadkCore.v) {
                    a((com.baidu.tieba.tbadkCore.v) CR);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aMz.IT() != null) {
                    arrayList.addAll(this.aMz.IT());
                }
                List<com.baidu.tieba.tbadkCore.v> L = this.aMA.L(this.aMz.IT());
                if (!arrayList.isEmpty() && this.aMA.b(arrayList, L)) {
                    showToast(i.h.enter_forum_sort_already);
                } else {
                    this.aMz.N(L);
                }
                return true;
            case 7:
                this.aMz.IV();
                return true;
            case 8:
                It();
                return true;
            case 9:
                this.aMz.Jc();
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aGQ.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (CR instanceof com.baidu.tieba.enterForum.b.e) {
                    com.baidu.tieba.enterForum.b.e eVar = (com.baidu.tieba.enterForum.b.e) CR;
                    String forumName = eVar.getForumName();
                    String valueOf = String.valueOf(eVar.getForumId());
                    if (aq.aP(forumName)) {
                        TiebaStatic.eventStat(this.aGQ.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.LS.be(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (CR instanceof com.baidu.tieba.enterForum.b.e) {
                    com.baidu.tieba.enterForum.b.e eVar2 = (com.baidu.tieba.enterForum.b.e) CR;
                    String forumName2 = eVar2.getForumName();
                    String valueOf2 = String.valueOf(eVar2.getForumId());
                    if (aq.aP(forumName2)) {
                        TiebaStatic.eventStat(this.aGQ.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aGQ.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aGQ.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!this.mIsLogin) {
                            TiebaStatic.eventStat(this.aGQ.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aGQ.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aGQ.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aGQ.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.aGQ.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oH() {
        return false;
    }
}
