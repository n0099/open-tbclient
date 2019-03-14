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
    private LikeModel bUq;
    private BaseFragmentActivity cOp;
    private EnterForumFragment eCC;
    private EnterForumModel eCE;
    private RecentlyVisitedForumModel eCF;
    private com.baidu.tieba.ueg.c eCG;
    private boolean eCI;
    private String eCK;
    private long eCL;
    private boolean eCM;
    private com.baidu.tieba.enterForum.view.d eCO;
    private boolean eCP;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b eCD = null;
    private com.baidu.tbadk.core.dialog.a eCH = null;
    private boolean eCJ = false;
    private int eCN = 1;
    private CustomMessageListener eCQ = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.eCJ = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a eCR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.eCE.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.eCD.pD();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cOp.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cOp.showToast(errorString);
                    if (a.this.eCD.isEmpty()) {
                        a.this.eCD.bE(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.eCE.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.eCE.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d eCS = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aB(a.this.bUq.getErrorCode(), a.this.bUq.getErrorString())) {
                AntiHelper.aU(a.this.cOp.getPageContext().getPageActivity(), a.this.bUq.getErrorString());
            } else if (obj != null) {
                a.this.eCE.iz(!StringUtils.isNull(a.this.eCK));
            } else if (!StringUtils.isNull(a.this.bUq.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.bUq.getErrorString());
            }
        }
    };
    private final EnterForumModel.b eCT = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.eCC != null) {
                if (aVar.type == 1) {
                    a.this.eCD.pD();
                }
                if (aVar.eDV) {
                    if (aVar.type == 1) {
                        a.this.eCI = true;
                        new com.baidu.tieba.enterForum.data.a();
                        com.baidu.tieba.enterForum.data.a aVar2 = aVar.eDW;
                        a.this.a(aVar2);
                        if (aVar2.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_LIKE_forum_sort_state", aVar2.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.eCI) {
                        new com.baidu.tieba.enterForum.data.a();
                        com.baidu.tieba.enterForum.data.a aVar3 = aVar.eDW;
                        a.this.eCE.d(aVar3);
                        a.this.a(aVar3);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.cOp.showToast(aVar.error);
                    a.this.eCD.pb(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.eCL > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.eCL, a.this.eCE.aWU() - a.this.eCL, a.this.eCE.aWS(), a.this.eCE.aWT(), currentTimeMillis - a.this.eCE.aWR());
                    a.this.eCL = -1L;
                }
                String string = a.this.cOp.getResources().getString(d.j.enter_forum_search_tip);
                if (aVar.eDW != null && aVar.eDW.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.eDW.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.aWi() != null) {
                        string = hotSearchInfoData.aWi();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c bRG = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            a.this.eCE.iz(!StringUtils.isNull(a.this.eCK));
            a.this.eCF.LoadData();
            a.this.eCE.iy(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eAZ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aBa();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.eCE = null;
        this.isFirst = true;
        this.eCI = false;
        this.eCL = -1L;
        this.eCC = enterForumFragment;
        this.cOp = enterForumFragment.getBaseFragmentActivity();
        this.eAZ.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.biy();
        this.eCL = System.currentTimeMillis();
        this.isFirst = true;
        this.eCI = false;
        this.eCK = "";
        this.eCE = new EnterForumModel(this.cOp.getPageContext());
        this.eCF = new RecentlyVisitedForumModel();
        this.bUq = new LikeModel(this.cOp.getPageContext());
        this.eCG = new com.baidu.tieba.ueg.c(this.cOp.getPageContext());
        this.bUq.setLoadDataCallBack(this.eCS);
        this.eCE.a(this.eCT);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aWQ().m(this.eCC.getFragmentActivity(), l.r(this.eCC.getFragmentActivity()));
        initUI();
        initListener();
        aWB();
    }

    private void initListener() {
        aWA();
        this.eCC.registerListener(this.eCR);
        this.eCC.registerListener(this.eCQ);
    }

    private static void aBa() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aWA() {
        this.eCC.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eCD != null && a.this.eCD.aVW()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                }
            }
        });
    }

    private void aWB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.eCE != null && a.this.eCE.aWV() != null && a.this.eCE.aWV().aVZ() != null && v.S(a.this.eCE.aWV().aVZ().aWt()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.d> it = a.this.eCE.aWV().aVZ().aWt().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cOp.getPageContext().getPageActivity());
            aVar.ly(String.format(this.cOp.getPageContext().getString(d.j.attention_cancel_dialog_message), dVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.lo()) {
                        a.this.cOp.showToast(d.j.delete_like_fail);
                    } else {
                        new b(dVar).execute(new com.baidu.tieba.enterForum.data.d[0]);
                    }
                    TiebaStatic.eventStat(a.this.cOp.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.gE(d.C0277d.cp_cont_b);
            aVar.b(this.cOp.getPageContext());
            aVar.aaZ();
        }
    }

    public void iu(boolean z) {
        if (this.mWaitingDialog == null) {
            aWC();
        }
        this.mWaitingDialog.dJ(z);
    }

    private void aWC() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.cOp.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.cOp.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.eCD = new com.baidu.tieba.enterForum.view.b(this.eCC, this.mRootView, this.eAZ, this.eCF, this.eCE);
        this.eCD.setListPullRefreshListener(this.bRG);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void iv(boolean z) {
        if (this.eCD != null && this.eCC != null) {
            if (z) {
                if (this.eCC.isPrimary() && this.eCC.isResumed()) {
                    this.eCD.startPullRefresh();
                    return;
                } else {
                    this.eCD.pD();
                    return;
                }
            }
            this.eCD.pD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.eCC.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (this.eCD != null) {
            if (aVar == null) {
                this.eCD.bE(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.e aVZ = aVar.aVZ();
            ArrayList<com.baidu.tieba.enterForum.data.d> arrayList = new ArrayList<>();
            if (aVZ != null) {
                arrayList = aVZ.aWt();
            }
            bw(arrayList);
            if (b(aVar)) {
                this.eCD.bC(aVar.aWa());
            }
            c(aVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aWi() != null) {
                setSearchHint(hotSearchInfoData.aWi());
            }
            this.eCD.aXB();
            this.eCD.pb(aVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.a aVar) {
        if (TbadkCoreApplication.isLogin() && aVar != null) {
            if ((aVar.aVZ() == null || v.T(aVar.aVZ().aWt())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.eCD.setSearchHint(str.trim());
        } else {
            this.eCD.setSearchHint(this.cOp.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void bw(List<com.baidu.tieba.enterForum.data.d> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.eCD.j(this.eCE.a(list, com.baidu.tbadk.util.d.apR()), this.eCE.aWX());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar != null && aVar.aWc() != null && this.eCC.isPrimary() && this.eCH == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.cOp.getActivity());
            if (frsPrivateCommonDialogView.b(aVar.aWc())) {
                this.eCH = new com.baidu.tbadk.core.dialog.a(this.cOp.getActivity());
                this.eCH.gF(2);
                this.eCH.az(frsPrivateCommonDialogView);
                this.eCH.dr(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.adD().c(a.this.cOp.getPageContext(), new String[]{aVar.aWc().XW()});
                        a.this.eCH.dismiss();
                        a.this.eCH = null;
                    }
                });
                this.eCH.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.eCH = null;
                    }
                });
                this.eCH.b(this.cOp.getPageContext()).aaZ();
            }
        }
    }

    private void aWD() {
        if (this.eCH != null) {
            this.eCH.dismiss();
            this.eCH = null;
        }
    }

    public void loadData() {
        if (this.eCD != null) {
            iw(false);
        }
    }

    public void aWE() {
        if (this.eCD != null) {
            iw(true);
        }
    }

    public void onDestroy() {
        anz();
        com.baidu.tieba.enterForum.model.a.aWQ().destroy();
        if (this.eCD != null) {
            this.eCD.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.eCF != null) {
            this.eCF.onDestroy();
        }
        if (this.eCE != null) {
            this.eCE.onDestroy();
        }
        if (this.eAZ != null) {
            this.eAZ.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eCD != null) {
            this.eCD.onChangeSkinType(i);
        }
        if (this.eCO != null) {
            this.eCO.onChangeSkinType();
        }
    }

    public void anz() {
        if (this.eCE != null) {
            this.eCE.cancelLoadData();
        }
    }

    public void iw(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.eCP && this.eCE != null && this.eCD != null) {
            String str = this.eCK;
            this.eCK = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.eCK == null || this.eCK.equals(str)) {
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
                if (this.eCE != null && this.eCE.aWV() != null && this.eCE.aWV().aVZ() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.d> it = this.eCE.aWV().aVZ().aWt().iterator();
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
                    com.baidu.tieba.tbadkCore.util.a.CG(currentAccount);
                }
                this.eCD.notifyDataSetChanged();
            }
            if (z2 || z4) {
                anz();
                if (z4) {
                    if (this.eCE != null) {
                        this.eCE.iA(StringUtils.isNull(this.eCK) ? false : true);
                    }
                    this.eCF.LoadData();
                } else if (z2 && this.eCE != null) {
                    this.eCE.iA(StringUtils.isNull(this.eCK) ? false : true);
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
        if (this.eCC.isAdded() && this.eCC.isPrimary()) {
            if (this.eCF != null) {
                this.eCF.onPrimary();
            }
        } else {
            aWD();
        }
        if (this.eCD != null) {
            this.eCD.onPrimary();
        }
    }

    public void onPause() {
        if (this.eCD != null && this.eCD.aXA() != null) {
            this.eCD.aXA().completePullRefresh();
        }
        if (this.eCF != null) {
            this.eCF.onPause();
        }
        if (this.eCE != null) {
            this.eCE.onPause();
        }
        if (this.eCD != null) {
            this.eCD.onPause();
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.d, Integer, String> {
        private com.baidu.tieba.enterForum.data.d eCZ;
        private x mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.d dVar) {
            this.eCZ = null;
            this.eCZ = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.d... dVarArr) {
            com.baidu.tieba.enterForum.data.d dVar = this.eCZ;
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
                    a.this.eCM = true;
                    if (a.this.eCC.isAdded() && a.this.cOp != null) {
                        a.this.cOp.showToast(a.this.cOp.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.eCZ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.eCZ.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.eCZ.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.eCZ.getName()));
                    }
                    a.this.eCD.a(this.eCZ, a.this.eCE.aWX());
                    a.this.eCE.b(this.eCZ);
                } else if (a.this.cOp != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cOp.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eCC.isAdded()) {
                        a.this.cOp.showToast(a.this.cOp.getActivity().getString(d.j.delete_like_fail));
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
    private class C0281a extends BdAsyncTask<com.baidu.tieba.enterForum.data.d, Integer, String> {
        private com.baidu.tieba.enterForum.data.d eCZ;
        private x mNetwork = null;

        public C0281a(com.baidu.tieba.enterForum.data.d dVar) {
            this.eCZ = null;
            this.eCZ = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.d... dVarArr) {
            com.baidu.tieba.enterForum.data.d dVar = this.eCZ;
            if (dVar != null) {
                try {
                    if (dVar.getId() != null && dVar.getName() != null) {
                        if (dVar.aWk() == 0) {
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
            super.onPostExecute((C0281a) str);
            a.this.iu(false);
            int aWk = this.eCZ.aWk();
            if (this.mNetwork != null) {
                if (this.mNetwork.acH().adG().isRequestSuccess()) {
                    a.this.eCM = true;
                    if (a.this.eCC.isAdded() && a.this.cOp != null) {
                        a.this.cOp.showToast(a.this.cOp.getActivity().getString(aWk > 0 ? d.j.enter_forum_untop_forum_succ : d.j.enter_forum_top_forum_succ));
                    }
                    a.this.eCE.iz(true);
                } else if (a.this.cOp != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cOp.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eCC.isAdded()) {
                        a.this.cOp.showToast(a.this.cOp.getActivity().getString(aWk > 0 ? d.j.enter_forum_untop_forum_fail : d.j.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.bwc().t(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aob = bVar.aob();
        com.baidu.tbadk.mvc.b.a aoc = bVar.aoc();
        switch (aob) {
            case 1:
                if (this.eCN != 2 && (aoc instanceof com.baidu.tieba.enterForum.data.d)) {
                    String name = ((com.baidu.tieba.enterForum.data.d) aoc).getName();
                    if (ap.bv(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.cOp.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.d) aoc).alE() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.d) aoc).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.d) aoc).aWp());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.d) aoc).aWo().night != null && ((com.baidu.tieba.enterForum.data.d) aoc).aWo().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.d) aoc).aWo().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.d) aoc).aWo().day != null && ((com.baidu.tieba.enterForum.data.d) aoc).aWo().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.d) aoc).aWo().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.d) aoc).aWs());
                            ((com.baidu.tieba.enterForum.data.d) aoc).cv(0L);
                        }
                        this.cOp.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.cOp.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        TiebaStatic.log(new am("c13368").k("uid", TbadkApplication.getCurrentAccountId()).T("obj_type", this.eCE.aWV().getSortType() == 1 ? 2 : 1).bJ(ImageViewerConfig.FORUM_ID, ((com.baidu.tieba.enterForum.data.d) aoc).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.eCN == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                if (aoc instanceof f) {
                    ((f) aoc).getPosition();
                }
                this.eCM = false;
                if (this.eCC.getView() == null || this.eCC.getView().getParent() == null) {
                    return true;
                }
                this.eCC.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (aoc instanceof com.baidu.tieba.enterForum.data.d) {
                    a((com.baidu.tieba.enterForum.data.d) aoc);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cY(this.cOp.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cOp.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.cOp.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cOp.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("c13367").bJ("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").bJ("obj_type", "2").T("obj_locate", 1));
                this.cOp.finish();
                return true;
            case 9:
                if (this.eCD != null) {
                    this.eCD.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.eCN = 2;
                return true;
            case 11:
                this.eCN = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.eCN != 2) {
                    if (this.eCO == null) {
                        this.eCO = new com.baidu.tieba.enterForum.view.d(this.cOp.getPageContext(), this.eAZ);
                    }
                    if (aoc instanceof com.baidu.tieba.enterForum.data.d) {
                        this.eCO.c((com.baidu.tieba.enterForum.data.d) aoc);
                        this.eCO.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aoc instanceof com.baidu.tieba.enterForum.data.d) {
                    new C0281a((com.baidu.tieba.enterForum.data.d) aoc).execute(new com.baidu.tieba.enterForum.data.d[0]);
                    TiebaStatic.log(new am("c13370").T("obj_type", ((com.baidu.tieba.enterForum.data.d) aoc).aWk() <= 0 ? 1 : 2).bJ(ImageViewerConfig.FORUM_ID, ((com.baidu.tieba.enterForum.data.d) aoc).getId()).k("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.adD().c(this.cOp.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eCG.cip() || !(aoc instanceof com.baidu.tieba.enterForum.data.d)) {
                    return true;
                }
                ba.adD().c(this.cOp.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.d) aoc).getId() + "&nomenu=1"});
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aoa() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.cOp.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eCD != null) {
            this.eCD.setPageUniqueId(bdUniqueId);
        }
    }

    public void ix(boolean z) {
        int i;
        if (this.eCD != null && this.eCC != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }
}
