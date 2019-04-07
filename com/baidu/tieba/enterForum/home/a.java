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
    private LikeModel bUs;
    private BaseFragmentActivity cOr;
    private boolean eCA;
    private EnterForumFragment eCn;
    private EnterForumModel eCp;
    private RecentlyVisitedForumModel eCq;
    private com.baidu.tieba.ueg.c eCr;
    private boolean eCt;
    private String eCv;
    private long eCw;
    private boolean eCx;
    private com.baidu.tieba.enterForum.view.d eCz;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b eCo = null;
    private com.baidu.tbadk.core.dialog.a eCs = null;
    private boolean eCu = false;
    private int eCy = 1;
    private CustomMessageListener eCB = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.eCu = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a eCC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.eCp.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.eCo.pD();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cOr.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cOr.showToast(errorString);
                    if (a.this.eCo.isEmpty()) {
                        a.this.eCo.bE(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.eCp.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.eCp.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d eCD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aD(a.this.bUs.getErrorCode(), a.this.bUs.getErrorString())) {
                AntiHelper.aU(a.this.cOr.getPageContext().getPageActivity(), a.this.bUs.getErrorString());
            } else if (obj != null) {
                a.this.eCp.iz(!StringUtils.isNull(a.this.eCv));
            } else if (!StringUtils.isNull(a.this.bUs.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.bUs.getErrorString());
            }
        }
    };
    private final EnterForumModel.b eCE = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.eCn != null) {
                if (aVar.type == 1) {
                    a.this.eCo.pD();
                }
                if (aVar.eDG) {
                    if (aVar.type == 1) {
                        a.this.eCt = true;
                        new com.baidu.tieba.enterForum.data.a();
                        com.baidu.tieba.enterForum.data.a aVar2 = aVar.eDH;
                        a.this.a(aVar2);
                        if (aVar2.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_LIKE_forum_sort_state", aVar2.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.eCt) {
                        new com.baidu.tieba.enterForum.data.a();
                        com.baidu.tieba.enterForum.data.a aVar3 = aVar.eDH;
                        a.this.eCp.d(aVar3);
                        a.this.a(aVar3);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.cOr.showToast(aVar.error);
                    a.this.eCo.oX(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.eCw > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.eCw, a.this.eCp.aWS() - a.this.eCw, a.this.eCp.aWQ(), a.this.eCp.aWR(), currentTimeMillis - a.this.eCp.aWP());
                    a.this.eCw = -1L;
                }
                String string = a.this.cOr.getResources().getString(d.j.enter_forum_search_tip);
                if (aVar.eDH != null && aVar.eDH.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.eDH.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.aWg() != null) {
                        string = hotSearchInfoData.aWg();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c bRI = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            a.this.eCp.iz(!StringUtils.isNull(a.this.eCv));
            a.this.eCq.LoadData();
            a.this.eCp.iy(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eAK = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aAX();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.eCp = null;
        this.isFirst = true;
        this.eCt = false;
        this.eCw = -1L;
        this.eCn = enterForumFragment;
        this.cOr = enterForumFragment.getBaseFragmentActivity();
        this.eAK.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.biw();
        this.eCw = System.currentTimeMillis();
        this.isFirst = true;
        this.eCt = false;
        this.eCv = "";
        this.eCp = new EnterForumModel(this.cOr.getPageContext());
        this.eCq = new RecentlyVisitedForumModel();
        this.bUs = new LikeModel(this.cOr.getPageContext());
        this.eCr = new com.baidu.tieba.ueg.c(this.cOr.getPageContext());
        this.bUs.setLoadDataCallBack(this.eCD);
        this.eCp.a(this.eCE);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aWO().m(this.eCn.getFragmentActivity(), l.r(this.eCn.getFragmentActivity()));
        initUI();
        initListener();
        aWz();
    }

    private void initListener() {
        aWy();
        this.eCn.registerListener(this.eCC);
        this.eCn.registerListener(this.eCB);
    }

    private static void aAX() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aWy() {
        this.eCn.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eCo != null && a.this.eCo.aVU()) {
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
                if (a.this.eCp != null && a.this.eCp.aWT() != null && a.this.eCp.aWT().aVX() != null && v.S(a.this.eCp.aWT().aVX().aWr()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.d> it = a.this.eCp.aWT().aVX().aWr().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cOr.getPageContext().getPageActivity());
            aVar.lz(String.format(this.cOr.getPageContext().getString(d.j.attention_cancel_dialog_message), dVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.lo()) {
                        a.this.cOr.showToast(d.j.delete_like_fail);
                    } else {
                        new b(dVar).execute(new com.baidu.tieba.enterForum.data.d[0]);
                    }
                    TiebaStatic.eventStat(a.this.cOr.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.cOr.getPageContext());
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
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.cOr.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.cOr.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.eCo = new com.baidu.tieba.enterForum.view.b(this.eCn, this.mRootView, this.eAK, this.eCq, this.eCp);
        this.eCo.setListPullRefreshListener(this.bRI);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void iv(boolean z) {
        if (this.eCo != null && this.eCn != null) {
            if (z) {
                if (this.eCn.isPrimary() && this.eCn.isResumed()) {
                    this.eCo.startPullRefresh();
                    return;
                } else {
                    this.eCo.pD();
                    return;
                }
            }
            this.eCo.pD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.eCn.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.a aVar) {
        if (this.eCo != null) {
            if (aVar == null) {
                this.eCo.bE(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.e aVX = aVar.aVX();
            ArrayList<com.baidu.tieba.enterForum.data.d> arrayList = new ArrayList<>();
            if (aVX != null) {
                arrayList = aVX.aWr();
            }
            bu(arrayList);
            if (b(aVar)) {
                this.eCo.bA(aVar.aVY());
            }
            c(aVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aWg() != null) {
                setSearchHint(hotSearchInfoData.aWg());
            }
            this.eCo.aXy();
            this.eCo.oX(aVar.getSortType());
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
            this.eCo.setSearchHint(str.trim());
        } else {
            this.eCo.setSearchHint(this.cOr.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void bu(List<com.baidu.tieba.enterForum.data.d> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.eCo.j(this.eCp.a(list, com.baidu.tbadk.util.d.apO()), this.eCp.aWV());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.a aVar) {
        if (aVar != null && aVar.aWa() != null && this.eCn.isPrimary() && this.eCs == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.cOr.getActivity());
            if (frsPrivateCommonDialogView.b(aVar.aWa())) {
                this.eCs = new com.baidu.tbadk.core.dialog.a(this.cOr.getActivity());
                this.eCs.gE(2);
                this.eCs.az(frsPrivateCommonDialogView);
                this.eCs.dr(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.adA().c(a.this.cOr.getPageContext(), new String[]{aVar.aWa().XT()});
                        a.this.eCs.dismiss();
                        a.this.eCs = null;
                    }
                });
                this.eCs.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.eCs = null;
                    }
                });
                this.eCs.b(this.cOr.getPageContext()).aaW();
            }
        }
    }

    private void aWB() {
        if (this.eCs != null) {
            this.eCs.dismiss();
            this.eCs = null;
        }
    }

    public void loadData() {
        if (this.eCo != null) {
            iw(false);
        }
    }

    public void aWC() {
        if (this.eCo != null) {
            iw(true);
        }
    }

    public void onDestroy() {
        anw();
        com.baidu.tieba.enterForum.model.a.aWO().destroy();
        if (this.eCo != null) {
            this.eCo.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.eCq != null) {
            this.eCq.onDestroy();
        }
        if (this.eCp != null) {
            this.eCp.onDestroy();
        }
        if (this.eAK != null) {
            this.eAK.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eCo != null) {
            this.eCo.onChangeSkinType(i);
        }
        if (this.eCz != null) {
            this.eCz.onChangeSkinType();
        }
    }

    public void anw() {
        if (this.eCp != null) {
            this.eCp.cancelLoadData();
        }
    }

    public void iw(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.eCA && this.eCp != null && this.eCo != null) {
            String str = this.eCv;
            this.eCv = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.eCv == null || this.eCv.equals(str)) {
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
                if (this.eCp != null && this.eCp.aWT() != null && this.eCp.aWT().aVX() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.d> it = this.eCp.aWT().aVX().aWr().iterator();
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
                this.eCo.notifyDataSetChanged();
            }
            if (z2 || z4) {
                anw();
                if (z4) {
                    if (this.eCp != null) {
                        this.eCp.iA(StringUtils.isNull(this.eCv) ? false : true);
                    }
                    this.eCq.LoadData();
                } else if (z2 && this.eCp != null) {
                    this.eCp.iA(StringUtils.isNull(this.eCv) ? false : true);
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
        if (this.eCn.isAdded() && this.eCn.isPrimary()) {
            if (this.eCq != null) {
                this.eCq.onPrimary();
            }
        } else {
            aWB();
        }
        if (this.eCo != null) {
            this.eCo.onPrimary();
        }
    }

    public void onPause() {
        if (this.eCo != null && this.eCo.aXx() != null) {
            this.eCo.aXx().completePullRefresh();
        }
        if (this.eCq != null) {
            this.eCq.onPause();
        }
        if (this.eCp != null) {
            this.eCp.onPause();
        }
        if (this.eCo != null) {
            this.eCo.onPause();
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.d, Integer, String> {
        private com.baidu.tieba.enterForum.data.d eCK;
        private x mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.d dVar) {
            this.eCK = null;
            this.eCK = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.d... dVarArr) {
            com.baidu.tieba.enterForum.data.d dVar = this.eCK;
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
                    a.this.eCx = true;
                    if (a.this.eCn.isAdded() && a.this.cOr != null) {
                        a.this.cOr.showToast(a.this.cOr.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.eCK.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.eCK.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.eCK.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.eCK.getName()));
                    }
                    a.this.eCo.a(this.eCK, a.this.eCp.aWV());
                    a.this.eCp.b(this.eCK);
                } else if (a.this.cOr != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cOr.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eCn.isAdded()) {
                        a.this.cOr.showToast(a.this.cOr.getActivity().getString(d.j.delete_like_fail));
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
        private com.baidu.tieba.enterForum.data.d eCK;
        private x mNetwork = null;

        public C0281a(com.baidu.tieba.enterForum.data.d dVar) {
            this.eCK = null;
            this.eCK = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.d... dVarArr) {
            com.baidu.tieba.enterForum.data.d dVar = this.eCK;
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
            int aWi = this.eCK.aWi();
            if (this.mNetwork != null) {
                if (this.mNetwork.acE().adD().isRequestSuccess()) {
                    a.this.eCx = true;
                    if (a.this.eCn.isAdded() && a.this.cOr != null) {
                        a.this.cOr.showToast(a.this.cOr.getActivity().getString(aWi > 0 ? d.j.enter_forum_untop_forum_succ : d.j.enter_forum_top_forum_succ));
                    }
                    a.this.eCp.iz(true);
                } else if (a.this.cOr != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cOr.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eCn.isAdded()) {
                        a.this.cOr.showToast(a.this.cOr.getActivity().getString(aWi > 0 ? d.j.enter_forum_untop_forum_fail : d.j.enter_forum_top_forum_fail));
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
                if (this.eCy != 2 && (anZ instanceof com.baidu.tieba.enterForum.data.d)) {
                    String name = ((com.baidu.tieba.enterForum.data.d) anZ).getName();
                    if (ap.bv(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.cOr.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
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
                        this.cOr.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.cOr.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        TiebaStatic.log(new am("c13368").k("uid", TbadkApplication.getCurrentAccountId()).T("obj_type", this.eCp.aWT().getSortType() == 1 ? 2 : 1).bJ(ImageViewerConfig.FORUM_ID, ((com.baidu.tieba.enterForum.data.d) anZ).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.eCy == 2) {
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
                this.eCx = false;
                if (this.eCn.getView() == null || this.eCn.getView().getParent() == null) {
                    return true;
                }
                this.eCn.getView().getParent().requestDisallowInterceptTouchEvent(true);
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
                    bc.cY(this.cOr.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cOr.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.cOr.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cOr.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("c13367").bJ("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").bJ("obj_type", "2").T("obj_locate", 1));
                this.cOr.finish();
                return true;
            case 9:
                if (this.eCo != null) {
                    this.eCo.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.eCy = 2;
                return true;
            case 11:
                this.eCy = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.eCy != 2) {
                    if (this.eCz == null) {
                        this.eCz = new com.baidu.tieba.enterForum.view.d(this.cOr.getPageContext(), this.eAK);
                    }
                    if (anZ instanceof com.baidu.tieba.enterForum.data.d) {
                        this.eCz.c((com.baidu.tieba.enterForum.data.d) anZ);
                        this.eCz.showDialog();
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
                ba.adA().c(this.cOr.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eCr.cin() || !(anZ instanceof com.baidu.tieba.enterForum.data.d)) {
                    return true;
                }
                ba.adA().c(this.cOr.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.d) anZ).getId() + "&nomenu=1"});
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean anX() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.cOr.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eCo != null) {
            this.eCo.setPageUniqueId(bdUniqueId);
        }
    }

    public void ix(boolean z) {
        int i;
        if (this.eCo != null && this.eCn != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }
}
