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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel eZA;
    private BaseFragmentActivity fTv;
    private com.baidu.tieba.ueg.d gnN;
    private EnterForumFragment ijK;
    private EnterForumModel ijM;
    private RecentlyVisitedForumModel ijN;
    private boolean ijO;
    private String ijQ;
    private long ijR;
    private boolean ijS;
    private com.baidu.tieba.enterForum.view.d ijU;
    private boolean ijV;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b ijL = null;
    private com.baidu.tbadk.core.dialog.a fOk = null;
    private boolean ijP = false;
    private int ijT = 1;
    private CustomMessageListener ijW = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.ijP = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a ijX = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.ijM.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.ijL.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.ijL.isEmpty()) {
                        a.this.ijL.cy(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.ijM.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.ijM.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d ijY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bR(a.this.eZA.getErrorCode(), a.this.eZA.getErrorString())) {
                AntiHelper.bm(a.this.fTv.getPageContext().getPageActivity(), a.this.eZA.getErrorString());
            } else if (obj != null) {
                a.this.ijM.oR(!StringUtils.isNull(a.this.ijQ));
            } else if (!StringUtils.isNull(a.this.eZA.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.eZA.getErrorString());
            }
        }
    };
    private final EnterForumModel.b ijZ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.ijK != null) {
                if (aVar.type == 1) {
                    a.this.ijL.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.ijO = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.imI;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.ijO) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.imI;
                        a.this.ijM.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.fTv.showToast(aVar.error);
                    a.this.ijL.xD(com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.ijR > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.ijR, a.this.ijM.csw() - a.this.ijR, a.this.ijM.csu(), a.this.ijM.csv(), currentTimeMillis - a.this.ijM.cst());
                    a.this.ijR = -1L;
                }
                String string = a.this.fTv.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.imI != null && aVar.imI.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.imI.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.cra() != null) {
                        string = hotSearchInfoData.cra();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.imI != null && aVar.imI.cqV() != null) {
                    a.this.ijL.b(aVar.imI.cqV());
                }
            }
        }
    };
    private f.c eVA = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.ijx.loadAd();
            a.this.ijM.oR(!StringUtils.isNull(a.this.ijQ));
            a.this.ijN.LoadData();
            a.this.ijM.oQ(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter ihN = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.ijM = null;
        this.isFirst = true;
        this.ijO = false;
        this.ijR = -1L;
        this.ijK = enterForumFragment;
        this.fTv = enterForumFragment.getBaseFragmentActivity();
        this.ihN.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.cFb();
        this.ijR = System.currentTimeMillis();
        this.isFirst = true;
        this.ijO = false;
        this.ijQ = "";
        this.ijM = new EnterForumModel(this.fTv.getPageContext());
        this.ijN = new RecentlyVisitedForumModel();
        this.eZA = new LikeModel(this.fTv.getPageContext());
        this.gnN = new com.baidu.tieba.ueg.d(this.fTv.getPageContext());
        this.eZA.setLoadDataCallBack(this.ijY);
        this.ijM.a(this.ijZ);
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.csr().m(this.ijK.getFragmentActivity(), l.getStatusBarHeight(this.ijK.getFragmentActivity()));
        initUI();
        initListener();
        crY();
    }

    private void initListener() {
        crX();
        this.ijK.registerListener(this.ijX);
        this.ijK.registerListener(this.ijW);
    }

    private void crX() {
        this.ijK.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.ijL != null && a.this.ijL.cqM()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void crY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<al>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<al> run(CustomMessage<al> customMessage) {
                al alVar = new al();
                ArrayList arrayList = new ArrayList();
                if (a.this.ijM != null && a.this.ijM.csx() != null && a.this.ijM.csx().cqQ() != null && y.getCount(a.this.ijM.csx().cqQ().crm()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.ijM.csx().cqQ().crm().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.f.b.toLong(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    alVar.bi(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, alVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fTv.getPageContext().getPageActivity());
            aVar.Bo(String.format(this.fTv.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.fTv.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.fTv.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ox(R.color.cp_cont_b);
            aVar.b(this.fTv.getPageContext());
            aVar.bpc();
        }
    }

    public void oM(boolean z) {
        if (this.mWaitingDialog == null) {
            crZ();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void crZ() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.fTv.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.fTv.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.ijL = new com.baidu.tieba.enterForum.view.b(this.ijK, this.mRootView, this.ihN, this.ijN, this.ijM);
        this.ijL.setListPullRefreshListener(this.eVA);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void oN(boolean z) {
        if (this.ijL != null && this.ijK != null) {
            if (z) {
                if (this.ijK.isPrimary() && this.ijK.isResumed()) {
                    this.ijL.startPullRefresh();
                } else {
                    this.ijL.completeRefresh();
                }
            } else {
                this.ijL.completeRefresh();
            }
            this.ijL.pc(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.ijK.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.ijL != null) {
            if (dVar == null) {
                this.ijL.cy(this.mRootView);
                return;
            }
            g cqQ = dVar.cqQ();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cqQ != null) {
                arrayList = cqQ.crm();
            }
            a(arrayList, dVar.cqR());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.cra() != null) {
                setSearchHint(hotSearchInfoData.cra());
            }
            this.ijL.cty();
            this.ijL.xD(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.ijK.crS() != null) {
            if (!StringUtils.isNull(str)) {
                this.ijK.crS().setSearchHint(str.trim());
            } else {
                this.ijK.crS().setSearchHint(this.fTv.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ijL.a(this.ijM.a(list, com.baidu.tbadk.util.f.bDu()), bjVar, this.ijM.csz());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.cqT() != null && this.ijK.isPrimary() && this.fOk == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.fTv.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.cqT())) {
                this.fOk = new com.baidu.tbadk.core.dialog.a(this.fTv.getActivity());
                this.fOk.oz(2);
                this.fOk.bf(frsPrivateCommonDialogView);
                this.fOk.iW(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.brr().b(a.this.fTv.getPageContext(), new String[]{dVar.cqT().blB()});
                        a.this.fOk.dismiss();
                        a.this.fOk = null;
                    }
                });
                this.fOk.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.fOk = null;
                    }
                });
                this.fOk.b(this.fTv.getPageContext()).bpc();
            }
        }
    }

    private void csa() {
        if (this.fOk != null) {
            this.fOk.dismiss();
            this.fOk = null;
        }
    }

    public void loadData() {
        if (this.ijL != null) {
            ha(false);
        }
    }

    public void csb() {
        if (this.ijL != null) {
            ha(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.csr().destroy();
        if (this.ijL != null) {
            this.ijL.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.ijN != null) {
            this.ijN.onDestroy();
        }
        if (this.ijM != null) {
            this.ijM.onDestroy();
        }
        if (this.ihN != null) {
            this.ihN.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ijL != null) {
            this.ijL.onChangeSkinType(i);
        }
        if (this.ijU != null) {
            this.ijU.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.ijM != null) {
            this.ijM.cancelLoadData();
        }
    }

    public void ha(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.ijV && this.ijM != null && this.ijL != null) {
            String str = this.ijQ;
            this.ijQ = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.ijQ == null || this.ijQ.equals(str)) {
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
                if (this.ijM != null && this.ijM.csx() != null && this.ijM.csx().cqQ() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.ijM.csx().cqQ().crm().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.xF(1);
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
                    com.baidu.tieba.tbadkCore.util.a.SU(currentAccount);
                }
                this.ijL.pb(this.ijM.csz());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.ijM != null) {
                        this.ijM.oS(StringUtils.isNull(this.ijQ) ? false : true);
                    }
                    this.ijN.LoadData();
                } else if (z2 && this.ijM != null) {
                    this.ijM.oS(StringUtils.isNull(this.ijQ) ? false : true);
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
        if (this.ijK.isAdded() && this.ijK.isPrimary()) {
            if (this.ijN != null) {
                this.ijN.onPrimary();
            }
        } else {
            csa();
        }
        if (this.ijL != null) {
            this.ijL.onPrimary();
        }
    }

    public void onPause() {
        if (this.ijL != null && this.ijL.ctx() != null) {
            this.ijL.ctx().completePullRefresh();
        }
        if (this.ijN != null) {
            this.ijN.onPause();
        }
        if (this.ijM != null) {
            this.ijM.onPause();
        }
        if (this.ijL != null) {
            this.ijL.onPause();
        }
    }

    public void aRs() {
        if (this.ijL != null) {
            this.ijL.cx(this.mRootView);
        }
    }

    /* loaded from: classes22.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f ikd;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.ikd = null;
            this.ikd = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.ikd;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.bqN().brt().mIsNeedTbs = true;
                        this.mNetwork.postNetData();
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
            a.this.oM(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.bqN().bru().isRequestSuccess()) {
                    a.this.ijS = true;
                    if (a.this.ijK.isAdded() && a.this.fTv != null) {
                        a.this.fTv.showToast(a.this.fTv.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.s(false, this.ikd.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.ikd.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.ikd.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.ikd.getName()));
                    }
                    a.this.ijL.a(this.ikd, a.this.ijM.csz());
                    a.this.ijM.b(this.ikd);
                } else if (a.this.fTv != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fTv.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.ijK.isAdded()) {
                        a.this.fTv.showToast(a.this.fTv.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.oM(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private class C0714a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f ikd;
        private aa mNetwork = null;

        public C0714a(com.baidu.tieba.enterForum.data.f fVar) {
            this.ikd = null;
            this.ikd = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.ikd;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.crc() == 0) {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.bqN().brt().mIsNeedTbs = true;
                        this.mNetwork.postNetData();
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
            super.onPostExecute((C0714a) str);
            a.this.oM(false);
            int crc = this.ikd.crc();
            if (this.mNetwork != null) {
                if (this.mNetwork.bqN().bru().isRequestSuccess()) {
                    a.this.ijS = true;
                    if (a.this.ijK.isAdded() && a.this.fTv != null) {
                        a.this.fTv.showToast(a.this.fTv.getActivity().getString(crc > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.ijM.oR(true);
                } else if (a.this.fTv != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fTv.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.ijK.isAdded()) {
                        a.this.fTv.showToast(a.this.fTv.getActivity().getString(crc > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.oM(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.cVg().A(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bBB = bVar.bBB();
        com.baidu.tbadk.mvc.b.a bBC = bVar.bBC();
        switch (bBB) {
            case 1:
                if (this.ijT != 2 && (bBC instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bBC).getName();
                    if (at.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.fTv.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bBC).bze() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bBC).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bBC).crh());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bBC).crg().night != null && ((com.baidu.tieba.enterForum.data.f) bBC).crg().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bBC).crg().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bBC).crg().day != null && ((com.baidu.tieba.enterForum.data.f) bBC).crg().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bBC).crg().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bBC).crk());
                            ((com.baidu.tieba.enterForum.data.f) bBC).fw(0L);
                        }
                        this.fTv.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.fTv.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new aq("c12888"));
                        }
                        TiebaStatic.log(new aq("c13368").w("uid", TbadkApplication.getCurrentAccountId()).al("obj_type", this.ijM.csx().getSortType() == 1 ? 2 : 1).dR("fid", ((com.baidu.tieba.enterForum.data.f) bBC).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.ijT == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.ijS = false;
                if (this.ijK.getView() == null || this.ijK.getView().getParent() == null) {
                    return true;
                }
                this.ijK.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bBC instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bBC);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(this.fTv.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fTv.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.fTv.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fTv.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("c13367").dR("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dR("obj_type", "2").al("obj_locate", 1));
                this.fTv.finish();
                return true;
            case 9:
                if (this.ijL != null) {
                    this.ijL.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.ijT = 2;
                return true;
            case 11:
                this.ijT = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.ijT != 2) {
                    if (this.ijU == null) {
                        this.ijU = new com.baidu.tieba.enterForum.view.d(this.fTv.getPageContext(), this.ihN);
                    }
                    if (bBC instanceof com.baidu.tieba.enterForum.data.f) {
                        this.ijU.c((com.baidu.tieba.enterForum.data.f) bBC);
                        this.ijU.Qj();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bBC instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0714a((com.baidu.tieba.enterForum.data.f) bBC).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new aq("c13370").al("obj_type", ((com.baidu.tieba.enterForum.data.f) bBC).crc() <= 0 ? 1 : 2).dR("fid", ((com.baidu.tieba.enterForum.data.f) bBC).getId()).w("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                be.brr().b(this.fTv.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.gnN.dNP() || !(bBC instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                be.brr().b(this.fTv.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bBC).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bBD());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bBD());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bBD());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bBA() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.fTv.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ijL != null) {
            this.ijL.setPageUniqueId(bdUniqueId);
        }
    }

    public void oO(boolean z) {
        int i;
        if (this.ijL != null && this.ijK != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ijL.setAdState(cVar);
        this.ijK.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b csc() {
        return this.ijL;
    }
}
