package com.baidu.tieba.enterForum.home;

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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel aGV;
    private BaseFragmentActivity bym;
    private EnterForumFragment dgK;
    private EnterForumModel dgM;
    private RecentlyVisitedForumModel dgN;
    private boolean dgO;
    private String dgQ;
    private long dgR;
    private boolean dgS;
    private boolean dgU;
    private boolean isFirst;
    private View mRootView;
    private d mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a dgL = null;
    private boolean dgP = false;
    private int dgT = 1;
    private CustomMessageListener dgV = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.dgP = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a dgW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.dgM.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.dgL.pj();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bym.getResources().getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bym.showToast(errorString);
                    if (a.this.dgL.isEmpty()) {
                        a.this.dgL.aH(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.dgM.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.dgM.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener dgX = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.dgU = true;
        }
    };
    private com.baidu.adp.base.d dgY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.am(a.this.aGV.getErrorCode(), a.this.aGV.getErrorString())) {
                AntiHelper.aI(a.this.bym.getPageContext().getPageActivity(), a.this.aGV.getErrorString());
            } else if (obj != null) {
                a.this.dgM.fQ(!StringUtils.isNull(a.this.dgQ));
            } else if (!StringUtils.isNull(a.this.aGV.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.aGV.getErrorString());
            }
        }
    };
    private final EnterForumModel.b dgZ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.dgK.isAdded()) {
                if (aVar.type == 1) {
                    a.this.dgL.pj();
                }
                if (aVar.dhF) {
                    if (aVar.type == 1) {
                        a.this.dgO = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.dhG);
                    } else if (aVar.type == 0 && !a.this.dgO) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.dhG;
                        a.this.dgM.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.bym.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.dgR > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.dgR, a.this.dgM.aur() - a.this.dgR, a.this.dgM.aup(), a.this.dgM.auq(), currentTimeMillis - a.this.dgM.auo());
                    a.this.dgR = -1L;
                }
                if (aVar.dhG == null || aVar.dhG.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.bym.getResources().getString(e.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.dhG.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.atH() != null) {
                    a.this.setSearchHint(hotSearchInfoData.atH());
                }
            }
        }
    };
    private j.b aEo = new j.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void bp(boolean z) {
            a.this.dgM.fQ(!StringUtils.isNull(a.this.dgQ));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter dfO = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        YJ();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.dgM = null;
        this.isFirst = true;
        this.dgO = false;
        this.dgR = -1L;
        this.dgK = enterForumFragment;
        this.bym = enterForumFragment.getBaseFragmentActivity();
        this.dfO.addEventDelegate(this);
        this.dgR = System.currentTimeMillis();
        this.isFirst = true;
        this.dgO = false;
        this.dgQ = "";
        this.dgM = new EnterForumModel(this.bym.getPageContext());
        this.dgN = new RecentlyVisitedForumModel();
        this.aGV = new LikeModel(this.bym.getPageContext());
        this.aGV.setLoadDataCallBack(this.dgY);
        this.dgM.a(this.dgZ);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.auk().o(this.dgK.getFragmentActivity(), l.r(this.dgK.getFragmentActivity()));
        initUI();
        initListener();
        atY();
    }

    private void initListener() {
        aub();
        this.dgK.registerListener(this.dgX);
        this.dgK.registerListener(this.dgW);
        this.dgK.registerListener(this.dgV);
    }

    private static void YJ() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void atY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (a.this.dgM != null && a.this.dgM.aus() != null && a.this.dgM.aus().atE() != null && v.I(a.this.dgM.aus().atE().atK()) > 0) {
                    Iterator<f> it = a.this.dgM.aus().atE().atK().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.d(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    acVar.D(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, acVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.dgM.i(this.dgL.auE(), this.dgL.auF());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.dgL.auC();
    }

    public View aua() {
        return this.dgL.aua();
    }

    public void aF(View view) {
        this.dgL.aF(view);
    }

    private void aub() {
        this.dgK.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.dgL == null || !a.this.dgL.atB()) {
                    if (!a.this.isChanged()) {
                        a.this.atZ();
                    } else {
                        a.this.auc();
                    }
                    if (a.this.dgS) {
                        a.this.dgL.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.dgK.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.dgL.auC();
                if (a.this.isChanged()) {
                    if (a.this.dgL.isEmpty()) {
                        a.this.dgL.aH(a.this.mRootView);
                        return;
                    } else {
                        a.this.dgL.auB();
                        a.this.dgM.bi(a.this.dgL.auE());
                    }
                }
                if (a.this.dgS) {
                    a.this.dgL.startPullRefresh();
                }
            }
        });
    }

    public void auc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bym.getPageContext().getPageActivity());
        aVar.cz(e.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(e.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.atZ();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cA(e.d.cp_cont_b);
        aVar.b(this.bym.getPageContext());
        aVar.Au();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bym.getPageContext().getPageActivity());
            aVar.ej(String.format(this.bym.getPageContext().getString(e.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(e.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.lo()) {
                        a.this.bym.showToast(e.j.delete_like_fail);
                    } else {
                        new C0177a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.bym.getPageContext().getPageActivity(), "recom_flist_unlike", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cA(e.d.cp_cont_b);
            aVar.b(this.bym.getPageContext());
            aVar.Au();
        }
    }

    public void fM(boolean z) {
        if (this.mWaitingDialog == null) {
            aud();
        }
        this.mWaitingDialog.bj(z);
    }

    private void aud() {
        this.mWaitingDialog = new d(this.bym.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bym.getActivity()).inflate(e.h.enter_forum_view, (ViewGroup) null);
        this.dgL = new com.baidu.tieba.enterForum.view.a(this.dgK, this.mRootView, this.dfO, this.dgN);
        this.dgL.a(this.aEo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fN(boolean z) {
        if (this.dgL != null && this.dgK != null) {
            if (z) {
                if (this.dgK.isPrimary() && this.dgK.isResumed()) {
                    this.dgL.startPullRefresh();
                    return;
                } else {
                    this.dgL.pj();
                    return;
                }
            }
            this.dgL.pj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.dgK.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.dgL != null) {
            if (bVar == null) {
                this.dgL.aH(this.mRootView);
                return;
            }
            g atE = bVar.atE();
            ArrayList<f> arrayList = new ArrayList<>();
            if (atE != null) {
                arrayList = atE.atK();
            }
            bg(arrayList);
            if (b(bVar)) {
                this.dgL.bn(bVar.atF());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.atH() != null) {
                setSearchHint(hotSearchInfoData.atH());
            }
            this.dgL.auG();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.atE() == null || v.J(bVar.atE().atK())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.dgL.setSearchHint(str.trim());
        } else {
            this.dgL.setSearchHint(this.bym.getActivity().getString(e.j.enter_forum_search_tip));
        }
    }

    private void bg(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.dgL.bm(this.dgM.a(list, com.baidu.tbadk.util.d.Ox()));
        }
    }

    public void loadData() {
        if (this.dgL != null) {
            fO(false);
        }
    }

    public void onDestroy() {
        Mo();
        com.baidu.tieba.enterForum.model.a.auk().destroy();
        if (this.dgL != null) {
            if (this.dgM != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.dgM.bi(this.dgL.auE());
            }
            this.dgL.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.dgN != null) {
            this.dgN.onDestroy();
        }
        if (this.dfO != null) {
            this.dfO.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dgL != null) {
            this.dgL.onChangeSkinType(i);
        }
    }

    public void Mo() {
        if (this.dgM != null) {
            this.dgM.cancelLoadData();
        }
    }

    public void fO(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.dgU && this.dgM != null && this.dgL != null) {
            String str = this.dgQ;
            this.dgQ = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.dgQ == null || this.dgQ.equals(str)) {
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
                if (this.dgM != null && this.dgM.aus() != null && this.dgM.aus().atE() != null) {
                    Iterator<f> it = this.dgM.aus().atE().atK().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.kE(1);
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
                    com.baidu.tieba.tbadkCore.util.a.ve(currentAccount);
                }
                this.dgL.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Mo();
                if (z4) {
                    this.dgM.fQ(StringUtils.isNull(this.dgQ) ? false : true);
                } else if (z2) {
                    this.dgM.fR(!StringUtils.isNull(this.dgQ));
                    this.dgM.fQ(StringUtils.isNull(this.dgQ) ? false : true);
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
        if (this.dgN != null) {
            this.dgN.onPrimary();
        }
    }

    public void onPause() {
        if (this.dgL != null && this.dgL.auA() != null) {
            this.dgL.auA().completePullRefresh();
        }
        if (this.dgN != null) {
            this.dgN.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0177a extends BdAsyncTask<f, Integer, String> {
        private f dhe;
        private x mNetwork = null;

        public C0177a(f fVar) {
            this.dhe = null;
            this.dhe = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.dhe;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.x("kw", fVar.getName());
                        this.mNetwork.BY().CW().mIsNeedTbs = true;
                        this.mNetwork.BA();
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
            super.onPostExecute((C0177a) str);
            a.this.fM(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.BY().CX().isRequestSuccess()) {
                    a.this.dgS = true;
                    if (a.this.dgK.isAdded() && a.this.bym != null) {
                        a.this.bym.showToast(a.this.bym.getActivity().getString(e.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.h(false, this.dhe.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.dhe.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.dhe.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.dhe.getName()));
                    }
                    a.this.dgL.b(this.dhe);
                } else if (a.this.bym != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.bym.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.dgK.isAdded()) {
                        a.this.bym.showToast(a.this.bym.getActivity().getString(e.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.fM(true);
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
    public void h(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aSV().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int MQ = bVar.MQ();
        com.baidu.tbadk.mvc.b.a MR = bVar.MR();
        switch (MQ) {
            case 1:
                if (this.dgT != 2 && (MR instanceof f)) {
                    String name = ((f) MR).getName();
                    if (ao.bv(name)) {
                        this.bym.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bym.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.bym.getResources().getString(e.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        List<f> auE = this.dgL.auE();
                        if (!v.J(auE)) {
                            if (v.I(auE) > 1 && auE.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < auE.size()) {
                                    if (!auE.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new am("c12049").ax("obj_type", "2").x("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.dgT == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.dgL.kH(MR instanceof h ? ((h) MR).getPosition() : 0);
                this.dgS = false;
                if (this.dgK.getView() == null || this.dgK.getView().getParent() == null) {
                    return true;
                }
                this.dgK.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (MR instanceof f) {
                    a((f) MR);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bym.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bym.getPageContext().getPageActivity(), "notlogin_6", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.bym.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bym.getPageContext().getPageActivity(), "notlogin_8", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("c10378").ax("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").ax("obj_type", "2").x("obj_locate", 1));
                this.bym.finish();
                return true;
            case 9:
                if (this.dgL != null) {
                    this.dgL.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.dgT = 2;
                return true;
            case 11:
                this.dgT = 1;
                return true;
        }
    }

    public void aue() {
        if (this.dgL != null) {
            this.dgL.auD();
        }
    }

    public boolean auf() {
        if (this.dgL != null) {
            return this.dgL.auf();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean MP() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bym.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dgL != null) {
            this.dgL.setPageUniqueId(bdUniqueId);
        }
    }

    public void fP(boolean z) {
        int i = 0;
        if (this.dgL != null && this.dgK != null) {
            boolean z2 = this.dgL.auf() && this.dgK.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.dgL.atB()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
