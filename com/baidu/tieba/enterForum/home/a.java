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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes21.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel eYI;
    private BaseFragmentActivity fTc;
    private com.baidu.tieba.ueg.d gnu;
    private EnterForumModel ikA;
    private RecentlyVisitedForumModel ikB;
    private boolean ikC;
    private String ikE;
    private long ikF;
    private boolean ikG;
    private com.baidu.tieba.enterForum.view.d ikI;
    private boolean ikJ;
    private EnterForumFragment iky;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b ikz = null;
    private com.baidu.tbadk.core.dialog.a fNN = null;
    private boolean ikD = false;
    private int ikH = 1;
    private CustomMessageListener ikK = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.ikD = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a ikL = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.ikA.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.ikz.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.ikz.isEmpty()) {
                        a.this.ikz.cC(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.ikA.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.ikA.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d ikM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bP(a.this.eYI.getErrorCode(), a.this.eYI.getErrorString())) {
                AntiHelper.bj(a.this.fTc.getPageContext().getPageActivity(), a.this.eYI.getErrorString());
            } else if (obj != null) {
                a.this.ikA.oU(!StringUtils.isNull(a.this.ikE));
            } else if (!StringUtils.isNull(a.this.eYI.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.eYI.getErrorString());
            }
        }
    };
    private final EnterForumModel.b ikN = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.iky != null) {
                if (aVar.type == 1) {
                    a.this.ikz.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.ikC = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.inx;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.ikC) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.inx;
                        a.this.ikA.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.fTc.showToast(aVar.error);
                    a.this.ikz.yb(com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.ikF > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.ikF, a.this.ikA.crZ() - a.this.ikF, a.this.ikA.crX(), a.this.ikA.crY(), currentTimeMillis - a.this.ikA.crW());
                    a.this.ikF = -1L;
                }
                String string = a.this.fTc.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.inx != null && aVar.inx.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.inx.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.cqD() != null) {
                        string = hotSearchInfoData.cqD();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.inx != null && aVar.inx.cqy() != null) {
                    a.this.ikz.b(aVar.inx.cqy());
                }
            }
        }
    };
    private f.c eUM = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.ikl.loadAd();
            a.this.ikA.oU(!StringUtils.isNull(a.this.ikE));
            a.this.ikB.LoadData();
            a.this.ikA.oT(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter iiB = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.ikA = null;
        this.isFirst = true;
        this.ikC = false;
        this.ikF = -1L;
        this.iky = enterForumFragment;
        this.fTc = enterForumFragment.getBaseFragmentActivity();
        this.iiB.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.cEG();
        this.ikF = System.currentTimeMillis();
        this.isFirst = true;
        this.ikC = false;
        this.ikE = "";
        this.ikA = new EnterForumModel(this.fTc.getPageContext());
        this.ikB = new RecentlyVisitedForumModel();
        this.eYI = new LikeModel(this.fTc.getPageContext());
        this.gnu = new com.baidu.tieba.ueg.d(this.fTc.getPageContext());
        this.eYI.setLoadDataCallBack(this.ikM);
        this.ikA.a(this.ikN);
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.crU().m(this.iky.getFragmentActivity(), l.getStatusBarHeight(this.iky.getFragmentActivity()));
        initUI();
        initListener();
        crB();
    }

    private void initListener() {
        crA();
        this.iky.registerListener(this.ikL);
        this.iky.registerListener(this.ikK);
    }

    private void crA() {
        this.iky.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.ikz != null && a.this.ikz.cqp()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void crB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<am>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<am> run(CustomMessage<am> customMessage) {
                am amVar = new am();
                ArrayList arrayList = new ArrayList();
                if (a.this.ikA != null && a.this.ikA.csa() != null && a.this.ikA.csa().cqt() != null && y.getCount(a.this.ikA.csa().cqt().cqP()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.ikA.csa().cqt().cqP().iterator();
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
                    amVar.bi(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, amVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fTc.getPageContext().getPageActivity());
            aVar.AJ(String.format(this.fTc.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.fTc.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.fTc.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ot(R.color.CAM_X0105);
            aVar.b(this.fTc.getPageContext());
            aVar.bog();
        }
    }

    public void oP(boolean z) {
        if (this.mWaitingDialog == null) {
            crC();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void crC() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.fTc.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.fTc.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.ikz = new com.baidu.tieba.enterForum.view.b(this.iky, this.mRootView, this.iiB, this.ikB, this.ikA);
        this.ikz.setListPullRefreshListener(this.eUM);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void oQ(boolean z) {
        if (this.ikz != null && this.iky != null) {
            if (z) {
                if (this.iky.isPrimary() && this.iky.isResumed()) {
                    this.ikz.startPullRefresh();
                } else {
                    this.ikz.completeRefresh();
                }
            } else {
                this.ikz.completeRefresh();
            }
            this.ikz.pf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.iky.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.ikz != null) {
            if (dVar == null) {
                this.ikz.cC(this.mRootView);
                return;
            }
            g cqt = dVar.cqt();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cqt != null) {
                arrayList = cqt.cqP();
            }
            a(arrayList, dVar.cqu());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bpu().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.cqD() != null) {
                setSearchHint(hotSearchInfoData.cqD());
            }
            this.ikz.ctb();
            this.ikz.yb(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.iky.crv() != null) {
            if (!StringUtils.isNull(str)) {
                this.iky.crv().setSearchHint(str.trim());
            } else {
                this.iky.crv().setSearchHint(this.fTc.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bk bkVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ikz.a(this.ikA.a(list, com.baidu.tbadk.util.f.bCN()), bkVar, this.ikA.csc());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.cqw() != null && this.iky.isPrimary() && this.fNN == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.fTc.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.cqw())) {
                this.fNN = new com.baidu.tbadk.core.dialog.a(this.fTc.getActivity());
                this.fNN.ov(2);
                this.fNN.bg(frsPrivateCommonDialogView);
                this.fNN.iX(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bqF().b(a.this.fTc.getPageContext(), new String[]{dVar.cqw().bkD()});
                        a.this.fNN.dismiss();
                        a.this.fNN = null;
                    }
                });
                this.fNN.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.fNN = null;
                    }
                });
                this.fNN.b(this.fTc.getPageContext()).bog();
            }
        }
    }

    private void crD() {
        if (this.fNN != null) {
            this.fNN.dismiss();
            this.fNN = null;
        }
    }

    public void loadData() {
        if (this.ikz != null) {
            hd(false);
        }
    }

    public void crE() {
        if (this.ikz != null) {
            hd(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.crU().destroy();
        if (this.ikz != null) {
            this.ikz.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.ikB != null) {
            this.ikB.onDestroy();
        }
        if (this.ikA != null) {
            this.ikA.onDestroy();
        }
        if (this.iiB != null) {
            this.iiB.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ikz != null) {
            this.ikz.onChangeSkinType(i);
        }
        if (this.ikI != null) {
            this.ikI.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.ikA != null) {
            this.ikA.cancelLoadData();
        }
    }

    public void hd(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.ikJ && this.ikA != null && this.ikz != null) {
            String str = this.ikE;
            this.ikE = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.ikE == null || this.ikE.equals(str)) {
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
                if (this.ikA != null && this.ikA.csa() != null && this.ikA.csa().cqt() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.ikA.csa().cqt().cqP().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.yd(1);
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
                    com.baidu.tieba.tbadkCore.util.a.SF(currentAccount);
                }
                this.ikz.pe(this.ikA.csc());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.ikA != null) {
                        this.ikA.oV(StringUtils.isNull(this.ikE) ? false : true);
                    }
                    this.ikB.LoadData();
                } else if (z2 && this.ikA != null) {
                    this.ikA.oV(StringUtils.isNull(this.ikE) ? false : true);
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
        if (this.iky.isAdded() && this.iky.isPrimary()) {
            if (this.ikB != null) {
                this.ikB.onPrimary();
            }
        } else {
            crD();
        }
        if (this.ikz != null) {
            this.ikz.onPrimary();
        }
    }

    public void onPause() {
        if (this.ikz != null && this.ikz.cta() != null) {
            this.ikz.cta().completePullRefresh();
        }
        if (this.ikB != null) {
            this.ikB.onPause();
        }
        if (this.ikA != null) {
            this.ikA.onPause();
        }
        if (this.ikz != null) {
            this.ikz.onPause();
        }
    }

    public void aQK() {
        if (this.ikz != null) {
            this.ikz.cB(this.mRootView);
        }
    }

    /* loaded from: classes21.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f ikR;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.ikR = null;
            this.ikR = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.ikR;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.bqa().bqH().mIsNeedTbs = true;
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
            a.this.oP(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.bqa().bqI().isRequestSuccess()) {
                    a.this.ikG = true;
                    if (a.this.iky.isAdded() && a.this.fTc != null) {
                        a.this.fTc.showToast(a.this.fTc.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.t(false, this.ikR.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.ikR.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.ikR.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.ikR.getName()));
                    }
                    a.this.ikz.a(this.ikR, a.this.ikA.csc());
                    a.this.ikA.b(this.ikR);
                } else if (a.this.fTc != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fTc.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iky.isAdded()) {
                        a.this.fTc.showToast(a.this.fTc.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.oP(true);
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
    /* loaded from: classes21.dex */
    private class C0717a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f ikR;
        private aa mNetwork = null;

        public C0717a(com.baidu.tieba.enterForum.data.f fVar) {
            this.ikR = null;
            this.ikR = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.ikR;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.cqF() == 0) {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.bqa().bqH().mIsNeedTbs = true;
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
            super.onPostExecute((C0717a) str);
            a.this.oP(false);
            int cqF = this.ikR.cqF();
            if (this.mNetwork != null) {
                if (this.mNetwork.bqa().bqI().isRequestSuccess()) {
                    a.this.ikG = true;
                    if (a.this.iky.isAdded() && a.this.fTc != null) {
                        a.this.fTc.showToast(a.this.fTc.getActivity().getString(cqF > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.ikA.oU(true);
                } else if (a.this.fTc != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fTc.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iky.isAdded()) {
                        a.this.fTc.showToast(a.this.fTc.getActivity().getString(cqF > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.oP(true);
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
    public void t(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.cUM().A(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bAR = bVar.bAR();
        com.baidu.tbadk.mvc.b.a bAS = bVar.bAS();
        switch (bAR) {
            case 1:
                if (this.ikH != 2 && (bAS instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bAS).getName();
                    if (au.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.fTc.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bAS).byu() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bAS).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bAS).cqK());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bAS).cqJ().night != null && ((com.baidu.tieba.enterForum.data.f) bAS).cqJ().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bAS).cqJ().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bAS).cqJ().day != null && ((com.baidu.tieba.enterForum.data.f) bAS).cqJ().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bAS).cqJ().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bAS).cqN());
                            ((com.baidu.tieba.enterForum.data.f) bAS).fz(0L);
                        }
                        this.fTc.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.fTc.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new ar("c12888"));
                        }
                        TiebaStatic.log(new ar("c13368").w("uid", TbadkApplication.getCurrentAccountId()).ak("obj_type", this.ikA.csa().getSortType() == 1 ? 2 : 1).dR("fid", ((com.baidu.tieba.enterForum.data.f) bAS).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.ikH == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.ikG = false;
                if (this.iky.getView() == null || this.iky.getView().getParent() == null) {
                    return true;
                }
                this.iky.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bAS instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bAS);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(this.fTc.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fTc.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ar("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.fTc.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fTc.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ar("c13367").dR("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dR("obj_type", "2").ak("obj_locate", 1));
                this.fTc.finish();
                return true;
            case 9:
                if (this.ikz != null) {
                    this.ikz.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.ikH = 2;
                return true;
            case 11:
                this.ikH = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.ikH != 2) {
                    if (this.ikI == null) {
                        this.ikI = new com.baidu.tieba.enterForum.view.d(this.fTc.getPageContext(), this.iiB);
                    }
                    if (bAS instanceof com.baidu.tieba.enterForum.data.f) {
                        this.ikI.c((com.baidu.tieba.enterForum.data.f) bAS);
                        this.ikI.PA();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bAS instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0717a((com.baidu.tieba.enterForum.data.f) bAS).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new ar("c13370").ak("obj_type", ((com.baidu.tieba.enterForum.data.f) bAS).cqF() <= 0 ? 1 : 2).dR("fid", ((com.baidu.tieba.enterForum.data.f) bAS).getId()).w("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                bf.bqF().b(this.fTc.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.gnu.dNO() || !(bAS instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                bf.bqF().b(this.fTc.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bAS).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bAT());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bAT());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bAT());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bAQ() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.fTc.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ikz != null) {
            this.ikz.setPageUniqueId(bdUniqueId);
        }
    }

    public void oR(boolean z) {
        int i;
        if (this.ikz != null && this.iky != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ikz.setAdState(cVar);
        this.iky.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b crF() {
        return this.ikz;
    }
}
