package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel bUp;
    private BaseFragmentActivity cOs;
    private EnterForumFragment eCG;
    private EnterForumModel eCI;
    private RecentlyVisitedForumModel eCJ;
    private com.baidu.tieba.ueg.c eCK;
    private boolean eCM;
    private String eCO;
    private long eCP;
    private boolean eCQ;
    private com.baidu.tieba.enterForum.view.d eCS;
    private boolean eCT;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b eCH = null;
    private com.baidu.tbadk.core.dialog.a eCL = null;
    private boolean eCN = false;
    private int eCR = 1;
    private CustomMessageListener eCU = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.eCN = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a eCV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.eCI.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.eCH.pD();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cOs.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cOs.showToast(errorString);
                    if (a.this.eCH.isEmpty()) {
                        a.this.eCH.bE(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.eCI.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.eCI.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d eCW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aB(a.this.bUp.getErrorCode(), a.this.bUp.getErrorString())) {
                AntiHelper.aV(a.this.cOs.getPageContext().getPageActivity(), a.this.bUp.getErrorString());
            } else if (obj != null) {
                a.this.eCI.iz(!StringUtils.isNull(a.this.eCO));
            } else if (!StringUtils.isNull(a.this.bUp.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.bUp.getErrorString());
            }
        }
    };
    private final EnterForumModel.b eCX = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.eCG != null) {
                if (aVar.type == 1) {
                    a.this.eCH.pD();
                }
                if (aVar.eDZ) {
                    if (aVar.type == 1) {
                        a.this.eCM = true;
                        new com.baidu.tieba.enterForum.data.a();
                        com.baidu.tieba.enterForum.data.a aVar2 = aVar.eEa;
                        a.this.a(aVar2);
                        if (aVar2.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_LIKE_forum_sort_state", aVar2.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.eCM) {
                        new com.baidu.tieba.enterForum.data.a();
                        com.baidu.tieba.enterForum.data.a aVar3 = aVar.eEa;
                        a.this.eCI.d(aVar3);
                        a.this.a(aVar3);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.cOs.showToast(aVar.error);
                    a.this.eCH.pb(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.eCP > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.eCP, a.this.eCI.aWV() - a.this.eCP, a.this.eCI.aWT(), a.this.eCI.aWU(), currentTimeMillis - a.this.eCI.aWS());
                    a.this.eCP = -1L;
                }
                String string = a.this.cOs.getResources().getString(d.j.enter_forum_search_tip);
                if (aVar.eEa != null && aVar.eEa.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.eEa.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.aWj() != null) {
                        string = hotSearchInfoData.aWj();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c bRF = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            a.this.eCI.iz(!StringUtils.isNull(a.this.eCO));
            a.this.eCJ.LoadData();
            a.this.eCI.iy(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eBd = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aBb();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.eCI = null;
        this.isFirst = true;
        this.eCM = false;
        this.eCP = -1L;
        this.eCG = enterForumFragment;
        this.cOs = enterForumFragment.getBaseFragmentActivity();
        this.eBd.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.biz();
        this.eCP = System.currentTimeMillis();
        this.isFirst = true;
        this.eCM = false;
        this.eCO = "";
        this.eCI = new EnterForumModel(this.cOs.getPageContext());
        this.eCJ = new RecentlyVisitedForumModel();
        this.bUp = new LikeModel(this.cOs.getPageContext());
        this.eCK = new com.baidu.tieba.ueg.c(this.cOs.getPageContext());
        this.bUp.setLoadDataCallBack(this.eCW);
        this.eCI.a(this.eCX);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aWR().m(this.eCG.getFragmentActivity(), l.r(this.eCG.getFragmentActivity()));
        initUI();
        initListener();
        aWC();
    }

    private void initListener() {
        aWB();
        this.eCG.registerListener(this.eCV);
        this.eCG.registerListener(this.eCU);
    }

    private static void aBb() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aWB() {
        this.eCG.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eCH != null && a.this.eCH.aVX()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                }
            }
        });
    }

    private void aWC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.eCI != null && a.this.eCI.aWW() != null && a.this.eCI.aWW().aWa() != null && v.S(a.this.eCI.aWW().aWa().aWu()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.d> it = a.this.eCI.aWW().aWa().aWu().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.d next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.d(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    aeVar.M(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, aeVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cOs.getPageContext().getPageActivity());
            aVar.ly(String.format(this.cOs.getPageContext().getString(d.j.attention_cancel_dialog_message), dVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.lo()) {
                        a.this.cOs.showToast(d.j.delete_like_fail);
                    } else {
                        new b(dVar).execute(new com.baidu.tieba.enterForum.data.d[0]);
                    }
                    TiebaStatic.eventStat(a.this.cOs.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.gE(d.C0236d.cp_cont_b);
            aVar.b(this.cOs.getPageContext());
            aVar.aaZ();
        }
    }

    public void iu(boolean z) {
        if (this.mWaitingDialog == null) {
            aWD();
        }
        this.mWaitingDialog.dJ(z);
    }

    private void aWD() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.cOs.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.cOs.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.eCH = new com.baidu.tieba.enterForum.view.b(this.eCG, this.mRootView, this.eBd, this.eCJ, this.eCI);
        this.eCH.setListPullRefreshListener(this.bRF);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void iv(boolean z) {
        if (this.eCH != null && this.eCG != null) {
            if (z) {
                if (this.eCG.isPrimary() && this.eCG.isResumed()) {
                    this.eCH.startPullRefresh();
                    return;
                } else {
                    this.eCH.pD();
                    return;
                }
            }
            this.eCH.pD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.eCG.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (this.eCH != null) {
            if (aVar == null) {
                this.eCH.bE(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.e aWa = aVar.aWa();
            ArrayList<com.baidu.tieba.enterForum.data.d> arrayList = new ArrayList<>();
            if (aWa != null) {
                arrayList = aWa.aWu();
            }
            bw(arrayList);
            if (b(aVar)) {
                this.eCH.bC(aVar.aWb());
            }
            c(aVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aWj() != null) {
                setSearchHint(hotSearchInfoData.aWj());
            }
            this.eCH.aXC();
            this.eCH.pb(aVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.a aVar) {
        if (TbadkCoreApplication.isLogin() && aVar != null) {
            if ((aVar.aWa() == null || v.T(aVar.aWa().aWu())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.eCH.setSearchHint(str.trim());
        } else {
            this.eCH.setSearchHint(this.cOs.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void bw(List<com.baidu.tieba.enterForum.data.d> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.eCH.j(this.eCI.a(list, com.baidu.tbadk.util.d.apS()), this.eCI.aWY());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar != null && aVar.aWd() != null && this.eCG.isPrimary() && this.eCL == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.cOs.getActivity());
            if (frsPrivateCommonDialogView.b(aVar.aWd())) {
                this.eCL = new com.baidu.tbadk.core.dialog.a(this.cOs.getActivity());
                this.eCL.gF(2);
                this.eCL.az(frsPrivateCommonDialogView);
                this.eCL.dr(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.adD().c(a.this.cOs.getPageContext(), new String[]{aVar.aWd().XW()});
                        a.this.eCL.dismiss();
                        a.this.eCL = null;
                    }
                });
                this.eCL.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.eCL = null;
                    }
                });
                this.eCL.b(this.cOs.getPageContext()).aaZ();
            }
        }
    }

    private void aWE() {
        if (this.eCL != null) {
            this.eCL.dismiss();
            this.eCL = null;
        }
    }

    public void loadData() {
        if (this.eCH != null) {
            iw(false);
        }
    }

    public void aWF() {
        if (this.eCH != null) {
            iw(true);
        }
    }

    public void onDestroy() {
        anA();
        com.baidu.tieba.enterForum.model.a.aWR().destroy();
        if (this.eCH != null) {
            this.eCH.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.eCJ != null) {
            this.eCJ.onDestroy();
        }
        if (this.eCI != null) {
            this.eCI.onDestroy();
        }
        if (this.eBd != null) {
            this.eBd.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eCH != null) {
            this.eCH.onChangeSkinType(i);
        }
        if (this.eCS != null) {
            this.eCS.onChangeSkinType();
        }
    }

    public void anA() {
        if (this.eCI != null) {
            this.eCI.cancelLoadData();
        }
    }

    public void iw(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.eCT && this.eCI != null && this.eCH != null) {
            String str = this.eCO;
            this.eCO = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.eCO == null || this.eCO.equals(str)) {
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = true;
            }
            if (TbadkCoreApplication.getInst().getLikeBarChanged()) {
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TbadkCoreApplication.getInst().signedForumCount() > 0) {
                if (this.eCI != null && this.eCI.aWW() != null && this.eCI.aWW().aWa() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.d> it = this.eCI.aWW().aWa().aWu().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.d next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.pd(1);
                            int signLevelUpValue = TbadkCoreApplication.getInst().getSignLevelUpValue(next.getName());
                            if (signLevelUpValue > 0) {
                                next.setLevel(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.getInst().clearSignedForum();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.tbadkCore.util.a.CI(currentAccount);
                }
                this.eCH.notifyDataSetChanged();
            }
            if (z2 || z4) {
                anA();
                if (z4) {
                    if (this.eCI != null) {
                        this.eCI.iA(StringUtils.isNull(this.eCO) ? false : true);
                    }
                    this.eCJ.LoadData();
                } else if (z2 && this.eCI != null) {
                    this.eCI.iA(StringUtils.isNull(this.eCO) ? false : true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    public void onPrimary() {
        if (this.eCG.isAdded() && this.eCG.isPrimary()) {
            if (this.eCJ != null) {
                this.eCJ.onPrimary();
            }
        } else {
            aWE();
        }
        if (this.eCH != null) {
            this.eCH.onPrimary();
        }
    }

    public void onPause() {
        if (this.eCH != null && this.eCH.aXB() != null) {
            this.eCH.aXB().completePullRefresh();
        }
        if (this.eCJ != null) {
            this.eCJ.onPause();
        }
        if (this.eCI != null) {
            this.eCI.onPause();
        }
        if (this.eCH != null) {
            this.eCH.onPause();
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.d, Integer, String> {
        private com.baidu.tieba.enterForum.data.d eDd;
        private x mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.d dVar) {
            this.eDd = null;
            this.eDd = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.d... dVarArr) {
            com.baidu.tieba.enterForum.data.d dVar = this.eDd;
            if (dVar != null) {
                try {
                    if (dVar.getId() != null && dVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, dVar.getId());
                        this.mNetwork.x("kw", dVar.getName());
                        this.mNetwork.acH().adF().mIsNeedTbs = true;
                        this.mNetwork.acj();
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
            super.onPostExecute((b) str);
            a.this.iu(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.acH().adG().isRequestSuccess()) {
                    a.this.eCQ = true;
                    if (a.this.eCG.isAdded() && a.this.cOs != null) {
                        a.this.cOs.showToast(a.this.cOs.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.eDd.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.eDd.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.eDd.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.eDd.getName()));
                    }
                    a.this.eCH.a(this.eDd, a.this.eCI.aWY());
                    a.this.eCI.b(this.eDd);
                } else if (a.this.cOs != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cOs.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eCG.isAdded()) {
                        a.this.cOs.showToast(a.this.cOs.getActivity().getString(d.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.iu(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0240a extends BdAsyncTask<com.baidu.tieba.enterForum.data.d, Integer, String> {
        private com.baidu.tieba.enterForum.data.d eDd;
        private x mNetwork = null;

        public C0240a(com.baidu.tieba.enterForum.data.d dVar) {
            this.eDd = null;
            this.eDd = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.d... dVarArr) {
            com.baidu.tieba.enterForum.data.d dVar = this.eDd;
            if (dVar != null) {
                try {
                    if (dVar.getId() != null && dVar.getName() != null) {
                        if (dVar.aWl() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.x("forum_id", dVar.getId());
                        this.mNetwork.acH().adF().mIsNeedTbs = true;
                        this.mNetwork.acj();
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
            super.onPostExecute((C0240a) str);
            a.this.iu(false);
            int aWl = this.eDd.aWl();
            if (this.mNetwork != null) {
                if (this.mNetwork.acH().adG().isRequestSuccess()) {
                    a.this.eCQ = true;
                    if (a.this.eCG.isAdded() && a.this.cOs != null) {
                        a.this.cOs.showToast(a.this.cOs.getActivity().getString(aWl > 0 ? d.j.enter_forum_untop_forum_succ : d.j.enter_forum_top_forum_succ));
                    }
                    a.this.eCI.iz(true);
                } else if (a.this.cOs != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cOs.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eCG.isAdded()) {
                        a.this.cOs.showToast(a.this.cOs.getActivity().getString(aWl > 0 ? d.j.enter_forum_untop_forum_fail : d.j.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.iu(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.bwd().t(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aoc = bVar.aoc();
        com.baidu.tbadk.mvc.b.a aod = bVar.aod();
        switch (aoc) {
            case 1:
                if (this.eCR != 2 && (aod instanceof com.baidu.tieba.enterForum.data.d)) {
                    String name = ((com.baidu.tieba.enterForum.data.d) aod).getName();
                    if (ap.bv(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.cOs.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.d) aod).alF() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.d) aod).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.d) aod).aWq());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.d) aod).aWp().night != null && ((com.baidu.tieba.enterForum.data.d) aod).aWp().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.d) aod).aWp().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.d) aod).aWp().day != null && ((com.baidu.tieba.enterForum.data.d) aod).aWp().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.d) aod).aWp().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.d) aod).aWt());
                            ((com.baidu.tieba.enterForum.data.d) aod).cv(0L);
                        }
                        this.cOs.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.cOs.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        TiebaStatic.log(new am("c13368").k("uid", TbadkApplication.getCurrentAccountId()).T("obj_type", this.eCI.aWW().getSortType() == 1 ? 2 : 1).bJ(ImageViewerConfig.FORUM_ID, ((com.baidu.tieba.enterForum.data.d) aod).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.eCR == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                if (aod instanceof f) {
                    ((f) aod).getPosition();
                }
                this.eCQ = false;
                if (this.eCG.getView() == null || this.eCG.getView().getParent() == null) {
                    return true;
                }
                this.eCG.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (aod instanceof com.baidu.tieba.enterForum.data.d) {
                    a((com.baidu.tieba.enterForum.data.d) aod);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cY(this.cOs.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cOs.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.cOs.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cOs.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("c13367").bJ("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").bJ("obj_type", "2").T("obj_locate", 1));
                this.cOs.finish();
                return true;
            case 9:
                if (this.eCH != null) {
                    this.eCH.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.eCR = 2;
                return true;
            case 11:
                this.eCR = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.eCR != 2) {
                    if (this.eCS == null) {
                        this.eCS = new com.baidu.tieba.enterForum.view.d(this.cOs.getPageContext(), this.eBd);
                    }
                    if (aod instanceof com.baidu.tieba.enterForum.data.d) {
                        this.eCS.c((com.baidu.tieba.enterForum.data.d) aod);
                        this.eCS.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aod instanceof com.baidu.tieba.enterForum.data.d) {
                    new C0240a((com.baidu.tieba.enterForum.data.d) aod).execute(new com.baidu.tieba.enterForum.data.d[0]);
                    TiebaStatic.log(new am("c13370").T("obj_type", ((com.baidu.tieba.enterForum.data.d) aod).aWl() <= 0 ? 1 : 2).bJ(ImageViewerConfig.FORUM_ID, ((com.baidu.tieba.enterForum.data.d) aod).getId()).k("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.adD().c(this.cOs.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eCK.cim() || !(aod instanceof com.baidu.tieba.enterForum.data.d)) {
                    return true;
                }
                ba.adD().c(this.cOs.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.d) aod).getId() + "&nomenu=1"});
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aob() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.cOs.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eCH != null) {
            this.eCH.setPageUniqueId(bdUniqueId);
        }
    }

    public void ix(boolean z) {
        int i;
        if (this.eCH != null && this.eCG != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }
}
