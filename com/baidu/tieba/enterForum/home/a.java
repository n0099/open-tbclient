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
    private LikeModel bUt;
    private BaseFragmentActivity cOs;
    private com.baidu.tieba.enterForum.view.d eCA;
    private boolean eCB;
    private EnterForumFragment eCo;
    private EnterForumModel eCq;
    private RecentlyVisitedForumModel eCr;
    private com.baidu.tieba.ueg.c eCs;
    private boolean eCu;
    private String eCw;
    private long eCx;
    private boolean eCy;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b eCp = null;
    private com.baidu.tbadk.core.dialog.a eCt = null;
    private boolean eCv = false;
    private int eCz = 1;
    private CustomMessageListener eCC = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.eCv = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a eCD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.eCq.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.eCp.pD();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cOs.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cOs.showToast(errorString);
                    if (a.this.eCp.isEmpty()) {
                        a.this.eCp.bE(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.eCq.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.eCq.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d eCE = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aD(a.this.bUt.getErrorCode(), a.this.bUt.getErrorString())) {
                AntiHelper.aU(a.this.cOs.getPageContext().getPageActivity(), a.this.bUt.getErrorString());
            } else if (obj != null) {
                a.this.eCq.iz(!StringUtils.isNull(a.this.eCw));
            } else if (!StringUtils.isNull(a.this.bUt.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.bUt.getErrorString());
            }
        }
    };
    private final EnterForumModel.b eCF = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.eCo != null) {
                if (aVar.type == 1) {
                    a.this.eCp.pD();
                }
                if (aVar.eDH) {
                    if (aVar.type == 1) {
                        a.this.eCu = true;
                        new com.baidu.tieba.enterForum.data.a();
                        com.baidu.tieba.enterForum.data.a aVar2 = aVar.eDI;
                        a.this.a(aVar2);
                        if (aVar2.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_LIKE_forum_sort_state", aVar2.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.eCu) {
                        new com.baidu.tieba.enterForum.data.a();
                        com.baidu.tieba.enterForum.data.a aVar3 = aVar.eDI;
                        a.this.eCq.d(aVar3);
                        a.this.a(aVar3);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.cOs.showToast(aVar.error);
                    a.this.eCp.oX(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.eCx > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.eCx, a.this.eCq.aWS() - a.this.eCx, a.this.eCq.aWQ(), a.this.eCq.aWR(), currentTimeMillis - a.this.eCq.aWP());
                    a.this.eCx = -1L;
                }
                String string = a.this.cOs.getResources().getString(d.j.enter_forum_search_tip);
                if (aVar.eDI != null && aVar.eDI.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.eDI.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.aWg() != null) {
                        string = hotSearchInfoData.aWg();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c bRJ = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            a.this.eCq.iz(!StringUtils.isNull(a.this.eCw));
            a.this.eCr.LoadData();
            a.this.eCq.iy(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eAL = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aAX();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.eCq = null;
        this.isFirst = true;
        this.eCu = false;
        this.eCx = -1L;
        this.eCo = enterForumFragment;
        this.cOs = enterForumFragment.getBaseFragmentActivity();
        this.eAL.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.biw();
        this.eCx = System.currentTimeMillis();
        this.isFirst = true;
        this.eCu = false;
        this.eCw = "";
        this.eCq = new EnterForumModel(this.cOs.getPageContext());
        this.eCr = new RecentlyVisitedForumModel();
        this.bUt = new LikeModel(this.cOs.getPageContext());
        this.eCs = new com.baidu.tieba.ueg.c(this.cOs.getPageContext());
        this.bUt.setLoadDataCallBack(this.eCE);
        this.eCq.a(this.eCF);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aWO().m(this.eCo.getFragmentActivity(), l.r(this.eCo.getFragmentActivity()));
        initUI();
        initListener();
        aWz();
    }

    private void initListener() {
        aWy();
        this.eCo.registerListener(this.eCD);
        this.eCo.registerListener(this.eCC);
    }

    private static void aAX() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aWy() {
        this.eCo.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eCp != null && a.this.eCp.aVU()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                }
            }
        });
    }

    private void aWz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.eCq != null && a.this.eCq.aWT() != null && a.this.eCq.aWT().aVX() != null && v.S(a.this.eCq.aWT().aVX().aWr()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.d> it = a.this.eCq.aWT().aVX().aWr().iterator();
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
            aVar.lz(String.format(this.cOs.getPageContext().getString(d.j.attention_cancel_dialog_message), dVar.getName()));
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
            aVar.gD(d.C0277d.cp_cont_b);
            aVar.b(this.cOs.getPageContext());
            aVar.aaW();
        }
    }

    public void iu(boolean z) {
        if (this.mWaitingDialog == null) {
            aWA();
        }
        this.mWaitingDialog.dJ(z);
    }

    private void aWA() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.cOs.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.cOs.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.eCp = new com.baidu.tieba.enterForum.view.b(this.eCo, this.mRootView, this.eAL, this.eCr, this.eCq);
        this.eCp.setListPullRefreshListener(this.bRJ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void iv(boolean z) {
        if (this.eCp != null && this.eCo != null) {
            if (z) {
                if (this.eCo.isPrimary() && this.eCo.isResumed()) {
                    this.eCp.startPullRefresh();
                    return;
                } else {
                    this.eCp.pD();
                    return;
                }
            }
            this.eCp.pD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.eCo.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (this.eCp != null) {
            if (aVar == null) {
                this.eCp.bE(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.e aVX = aVar.aVX();
            ArrayList<com.baidu.tieba.enterForum.data.d> arrayList = new ArrayList<>();
            if (aVX != null) {
                arrayList = aVX.aWr();
            }
            bu(arrayList);
            if (b(aVar)) {
                this.eCp.bA(aVar.aVY());
            }
            c(aVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aWg() != null) {
                setSearchHint(hotSearchInfoData.aWg());
            }
            this.eCp.aXy();
            this.eCp.oX(aVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.a aVar) {
        if (TbadkCoreApplication.isLogin() && aVar != null) {
            if ((aVar.aVX() == null || v.T(aVar.aVX().aWr())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.eCp.setSearchHint(str.trim());
        } else {
            this.eCp.setSearchHint(this.cOs.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void bu(List<com.baidu.tieba.enterForum.data.d> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.eCp.j(this.eCq.a(list, com.baidu.tbadk.util.d.apO()), this.eCq.aWV());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar != null && aVar.aWa() != null && this.eCo.isPrimary() && this.eCt == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.cOs.getActivity());
            if (frsPrivateCommonDialogView.b(aVar.aWa())) {
                this.eCt = new com.baidu.tbadk.core.dialog.a(this.cOs.getActivity());
                this.eCt.gE(2);
                this.eCt.az(frsPrivateCommonDialogView);
                this.eCt.dr(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.adA().c(a.this.cOs.getPageContext(), new String[]{aVar.aWa().XT()});
                        a.this.eCt.dismiss();
                        a.this.eCt = null;
                    }
                });
                this.eCt.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.eCt = null;
                    }
                });
                this.eCt.b(this.cOs.getPageContext()).aaW();
            }
        }
    }

    private void aWB() {
        if (this.eCt != null) {
            this.eCt.dismiss();
            this.eCt = null;
        }
    }

    public void loadData() {
        if (this.eCp != null) {
            iw(false);
        }
    }

    public void aWC() {
        if (this.eCp != null) {
            iw(true);
        }
    }

    public void onDestroy() {
        anw();
        com.baidu.tieba.enterForum.model.a.aWO().destroy();
        if (this.eCp != null) {
            this.eCp.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.eCr != null) {
            this.eCr.onDestroy();
        }
        if (this.eCq != null) {
            this.eCq.onDestroy();
        }
        if (this.eAL != null) {
            this.eAL.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eCp != null) {
            this.eCp.onChangeSkinType(i);
        }
        if (this.eCA != null) {
            this.eCA.onChangeSkinType();
        }
    }

    public void anw() {
        if (this.eCq != null) {
            this.eCq.cancelLoadData();
        }
    }

    public void iw(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.eCB && this.eCq != null && this.eCp != null) {
            String str = this.eCw;
            this.eCw = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.eCw == null || this.eCw.equals(str)) {
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
                if (this.eCq != null && this.eCq.aWT() != null && this.eCq.aWT().aVX() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.d> it = this.eCq.aWT().aVX().aWr().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.d next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.oZ(1);
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
                    com.baidu.tieba.tbadkCore.util.a.CF(currentAccount);
                }
                this.eCp.notifyDataSetChanged();
            }
            if (z2 || z4) {
                anw();
                if (z4) {
                    if (this.eCq != null) {
                        this.eCq.iA(StringUtils.isNull(this.eCw) ? false : true);
                    }
                    this.eCr.LoadData();
                } else if (z2 && this.eCq != null) {
                    this.eCq.iA(StringUtils.isNull(this.eCw) ? false : true);
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
        if (this.eCo.isAdded() && this.eCo.isPrimary()) {
            if (this.eCr != null) {
                this.eCr.onPrimary();
            }
        } else {
            aWB();
        }
        if (this.eCp != null) {
            this.eCp.onPrimary();
        }
    }

    public void onPause() {
        if (this.eCp != null && this.eCp.aXx() != null) {
            this.eCp.aXx().completePullRefresh();
        }
        if (this.eCr != null) {
            this.eCr.onPause();
        }
        if (this.eCq != null) {
            this.eCq.onPause();
        }
        if (this.eCp != null) {
            this.eCp.onPause();
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.d, Integer, String> {
        private com.baidu.tieba.enterForum.data.d eCL;
        private x mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.d dVar) {
            this.eCL = null;
            this.eCL = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.d... dVarArr) {
            com.baidu.tieba.enterForum.data.d dVar = this.eCL;
            if (dVar != null) {
                try {
                    if (dVar.getId() != null && dVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, dVar.getId());
                        this.mNetwork.x("kw", dVar.getName());
                        this.mNetwork.acE().adC().mIsNeedTbs = true;
                        this.mNetwork.acg();
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
                if (this.mNetwork.acE().adD().isRequestSuccess()) {
                    a.this.eCy = true;
                    if (a.this.eCo.isAdded() && a.this.cOs != null) {
                        a.this.cOs.showToast(a.this.cOs.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.eCL.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.eCL.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.eCL.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.eCL.getName()));
                    }
                    a.this.eCp.a(this.eCL, a.this.eCq.aWV());
                    a.this.eCq.b(this.eCL);
                } else if (a.this.cOs != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cOs.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eCo.isAdded()) {
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
    private class C0281a extends BdAsyncTask<com.baidu.tieba.enterForum.data.d, Integer, String> {
        private com.baidu.tieba.enterForum.data.d eCL;
        private x mNetwork = null;

        public C0281a(com.baidu.tieba.enterForum.data.d dVar) {
            this.eCL = null;
            this.eCL = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.d... dVarArr) {
            com.baidu.tieba.enterForum.data.d dVar = this.eCL;
            if (dVar != null) {
                try {
                    if (dVar.getId() != null && dVar.getName() != null) {
                        if (dVar.aWi() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.x("forum_id", dVar.getId());
                        this.mNetwork.acE().adC().mIsNeedTbs = true;
                        this.mNetwork.acg();
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
            int aWi = this.eCL.aWi();
            if (this.mNetwork != null) {
                if (this.mNetwork.acE().adD().isRequestSuccess()) {
                    a.this.eCy = true;
                    if (a.this.eCo.isAdded() && a.this.cOs != null) {
                        a.this.cOs.showToast(a.this.cOs.getActivity().getString(aWi > 0 ? d.j.enter_forum_untop_forum_succ : d.j.enter_forum_top_forum_succ));
                    }
                    a.this.eCq.iz(true);
                } else if (a.this.cOs != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cOs.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eCo.isAdded()) {
                        a.this.cOs.showToast(a.this.cOs.getActivity().getString(aWi > 0 ? d.j.enter_forum_untop_forum_fail : d.j.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.bvZ().t(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int anY = bVar.anY();
        com.baidu.tbadk.mvc.b.a anZ = bVar.anZ();
        switch (anY) {
            case 1:
                if (this.eCz != 2 && (anZ instanceof com.baidu.tieba.enterForum.data.d)) {
                    String name = ((com.baidu.tieba.enterForum.data.d) anZ).getName();
                    if (ap.bv(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.cOs.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.d) anZ).alB() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.d) anZ).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.d) anZ).aWn());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.d) anZ).aWm().night != null && ((com.baidu.tieba.enterForum.data.d) anZ).aWm().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.d) anZ).aWm().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.d) anZ).aWm().day != null && ((com.baidu.tieba.enterForum.data.d) anZ).aWm().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.d) anZ).aWm().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.d) anZ).aWq());
                            ((com.baidu.tieba.enterForum.data.d) anZ).cv(0L);
                        }
                        this.cOs.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.cOs.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        TiebaStatic.log(new am("c13368").k("uid", TbadkApplication.getCurrentAccountId()).T("obj_type", this.eCq.aWT().getSortType() == 1 ? 2 : 1).bJ(ImageViewerConfig.FORUM_ID, ((com.baidu.tieba.enterForum.data.d) anZ).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.eCz == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                if (anZ instanceof f) {
                    ((f) anZ).getPosition();
                }
                this.eCy = false;
                if (this.eCo.getView() == null || this.eCo.getView().getParent() == null) {
                    return true;
                }
                this.eCo.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (anZ instanceof com.baidu.tieba.enterForum.data.d) {
                    a((com.baidu.tieba.enterForum.data.d) anZ);
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
                if (this.eCp != null) {
                    this.eCp.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.eCz = 2;
                return true;
            case 11:
                this.eCz = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.eCz != 2) {
                    if (this.eCA == null) {
                        this.eCA = new com.baidu.tieba.enterForum.view.d(this.cOs.getPageContext(), this.eAL);
                    }
                    if (anZ instanceof com.baidu.tieba.enterForum.data.d) {
                        this.eCA.c((com.baidu.tieba.enterForum.data.d) anZ);
                        this.eCA.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (anZ instanceof com.baidu.tieba.enterForum.data.d) {
                    new C0281a((com.baidu.tieba.enterForum.data.d) anZ).execute(new com.baidu.tieba.enterForum.data.d[0]);
                    TiebaStatic.log(new am("c13370").T("obj_type", ((com.baidu.tieba.enterForum.data.d) anZ).aWi() <= 0 ? 1 : 2).bJ(ImageViewerConfig.FORUM_ID, ((com.baidu.tieba.enterForum.data.d) anZ).getId()).k("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.adA().c(this.cOs.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eCs.cin() || !(anZ instanceof com.baidu.tieba.enterForum.data.d)) {
                    return true;
                }
                ba.adA().c(this.cOs.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.d) anZ).getId() + "&nomenu=1"});
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean anX() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.cOs.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eCp != null) {
            this.eCp.setPageUniqueId(bdUniqueId);
        }
    }

    public void ix(boolean z) {
        int i;
        if (this.eCp != null && this.eCo != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }
}
