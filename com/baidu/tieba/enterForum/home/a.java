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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel dku;
    private BaseFragmentActivity ebb;
    private com.baidu.tieba.ueg.d eqc;
    private EnterForumFragment fVU;
    private EnterForumModel fVW;
    private RecentlyVisitedForumModel fVX;
    private boolean fVY;
    private String fWa;
    private long fWb;
    private boolean fWc;
    private com.baidu.tieba.enterForum.view.d fWe;
    private boolean fWf;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b fVV = null;
    private com.baidu.tbadk.core.dialog.a dUf = null;
    private boolean fVZ = false;
    private int fWd = 1;
    private CustomMessageListener fWg = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.fVZ = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fWh = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.fVW.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.fVV.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.ebb.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.ebb.showToast(errorString);
                    if (a.this.fVV.isEmpty()) {
                        a.this.fVV.bL(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.fVW.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.fVW.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d fWi = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bb(a.this.dku.getErrorCode(), a.this.dku.getErrorString())) {
                AntiHelper.bn(a.this.ebb.getPageContext().getPageActivity(), a.this.dku.getErrorString());
            } else if (obj != null) {
                a.this.fVW.kL(!StringUtils.isNull(a.this.fWa));
            } else if (!StringUtils.isNull(a.this.dku.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.dku.getErrorString());
            }
        }
    };
    private final EnterForumModel.b fWj = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.fVU != null) {
                if (aVar.type == 1) {
                    a.this.fVV.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.fVY = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.fXu;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.fVY) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.fXu;
                        a.this.fVW.c(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.ebb.showToast(aVar.error);
                    a.this.fVV.rM(com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.fWb > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.fWb, a.this.fVW.byW() - a.this.fWb, a.this.fVW.byU(), a.this.fVW.byV(), currentTimeMillis - a.this.fVW.byT());
                    a.this.fWb = -1L;
                }
                String string = a.this.ebb.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.fXu != null && aVar.fXu.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.fXu.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bxU() != null) {
                        string = hotSearchInfoData.bxU();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private g.c dhi = new g.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.fVG.loadAd();
            a.this.fVW.kL(!StringUtils.isNull(a.this.fWa));
            a.this.fVX.LoadData();
            a.this.fVW.kK(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter fUg = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.fVW = null;
        this.isFirst = true;
        this.fVY = false;
        this.fWb = -1L;
        this.fVU = enterForumFragment;
        this.ebb = enterForumFragment.getBaseFragmentActivity();
        this.fUg.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bKj();
        this.fWb = System.currentTimeMillis();
        this.isFirst = true;
        this.fVY = false;
        this.fWa = "";
        this.fVW = new EnterForumModel(this.ebb.getPageContext());
        this.fVX = new RecentlyVisitedForumModel();
        this.dku = new LikeModel(this.ebb.getPageContext());
        this.eqc = new com.baidu.tieba.ueg.d(this.ebb.getPageContext());
        this.dku.setLoadDataCallBack(this.fWi);
        this.fVW.a(this.fWj);
        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.byR().init(this.fVU.getFragmentActivity(), l.getStatusBarHeight(this.fVU.getFragmentActivity()));
        initUI();
        initListener();
        byy();
    }

    private void initListener() {
        byx();
        this.fVU.registerListener(this.fWh);
        this.fVU.registerListener(this.fWg);
    }

    private void byx() {
        this.fVU.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fVV != null && a.this.fVV.bxJ()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void byy() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<af>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<af> run(CustomMessage<af> customMessage) {
                af afVar = new af();
                ArrayList arrayList = new ArrayList();
                if (a.this.fVW != null && a.this.fVW.byX() != null && a.this.fVW.byX().bxN() != null && v.getCount(a.this.fVW.byX().bxN().byg()) > 0) {
                    Iterator<f> it = a.this.fVW.byX().bxN().byg().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.f.b.toLong(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    afVar.av(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, afVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ebb.getPageContext().getPageActivity());
            aVar.sR(String.format(this.ebb.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.ebb.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.ebb.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.jX(R.color.cp_cont_b);
            aVar.b(this.ebb.getPageContext());
            aVar.aEG();
        }
    }

    public void kF(boolean z) {
        if (this.mWaitingDialog == null) {
            byz();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void byz() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.ebb.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.ebb.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.fVV = new com.baidu.tieba.enterForum.view.b(this.fVU, this.mRootView, this.fUg, this.fVX, this.fVW);
        this.fVV.setListPullRefreshListener(this.dhi);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void kG(boolean z) {
        if (this.fVV != null && this.fVU != null) {
            if (z) {
                if (this.fVU.isPrimary() && this.fVU.isResumed()) {
                    this.fVV.startPullRefresh();
                } else {
                    this.fVV.completeRefresh();
                }
            } else {
                this.fVV.completeRefresh();
            }
            this.fVV.kU(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.fVU.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.fVV != null) {
            if (cVar == null) {
                this.fVV.bL(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g bxN = cVar.bxN();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bxN != null) {
                arrayList = bxN.byg();
            }
            bM(arrayList);
            b(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bxU() != null) {
                setSearchHint(hotSearchInfoData.bxU());
            }
            this.fVV.bzI();
            this.fVV.rM(cVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.fVU.byu() != null) {
            if (!StringUtils.isNull(str)) {
                this.fVU.byu().setSearchHint(str.trim());
            } else {
                this.fVU.byu().setSearchHint(this.ebb.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bM(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.fVV.n(this.fVW.a(list, com.baidu.tbadk.util.e.aSa()), this.fVW.byZ());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bxP() != null && this.fVU.isPrimary() && this.dUf == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.ebb.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bxP())) {
                this.dUf = new com.baidu.tbadk.core.dialog.a(this.ebb.getActivity());
                this.dUf.jZ(2);
                this.dUf.aO(frsPrivateCommonDialogView);
                this.dUf.fI(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aGK().b(a.this.ebb.getPageContext(), new String[]{cVar.bxP().aBy()});
                        a.this.dUf.dismiss();
                        a.this.dUf = null;
                    }
                });
                this.dUf.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.dUf = null;
                    }
                });
                this.dUf.b(this.ebb.getPageContext()).aEG();
            }
        }
    }

    private void byA() {
        if (this.dUf != null) {
            this.dUf.dismiss();
            this.dUf = null;
        }
    }

    public void loadData() {
        if (this.fVV != null) {
            kH(false);
        }
    }

    public void byB() {
        if (this.fVV != null) {
            kH(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.byR().destroy();
        if (this.fVV != null) {
            this.fVV.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.fVX != null) {
            this.fVX.onDestroy();
        }
        if (this.fVW != null) {
            this.fVW.onDestroy();
        }
        if (this.fUg != null) {
            this.fUg.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fVV != null) {
            this.fVV.onChangeSkinType(i);
        }
        if (this.fWe != null) {
            this.fWe.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.fVW != null) {
            this.fVW.cancelLoadData();
        }
    }

    public void kH(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.fWf && this.fVW != null && this.fVV != null) {
            String str = this.fWa;
            this.fWa = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.fWa == null || this.fWa.equals(str)) {
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
                if (this.fVW != null && this.fVW.byX() != null && this.fVW.byX().bxN() != null) {
                    Iterator<f> it = this.fVW.byX().bxN().byg().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.rO(1);
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
                    com.baidu.tieba.tbadkCore.util.a.Jh(currentAccount);
                }
                this.fVV.kT(this.fVW.byZ());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.fVW != null) {
                        this.fVW.kM(StringUtils.isNull(this.fWa) ? false : true);
                    }
                    this.fVX.LoadData();
                } else if (z2 && this.fVW != null) {
                    this.fVW.kM(StringUtils.isNull(this.fWa) ? false : true);
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
        if (this.fVU.isAdded() && this.fVU.isPrimary()) {
            if (this.fVX != null) {
                this.fVX.onPrimary();
            }
        } else {
            byA();
        }
        if (this.fVV != null) {
            this.fVV.onPrimary();
        }
    }

    public void onPause() {
        if (this.fVV != null && this.fVV.bzH() != null) {
            this.fVV.bzH().completePullRefresh();
        }
        if (this.fVX != null) {
            this.fVX.onPause();
        }
        if (this.fVW != null) {
            this.fVW.onPause();
        }
        if (this.fVV != null) {
            this.fVV.onPause();
        }
    }

    public void akL() {
        if (this.fVV != null) {
            this.fVV.bK(this.mRootView);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f fWn;
        private x mNetwork = null;

        public b(f fVar) {
            this.fWn = null;
            this.fWn = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fWn;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.aGk().aGL().mIsNeedTbs = true;
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
            a.this.kF(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.aGk().aGM().isRequestSuccess()) {
                    a.this.fWc = true;
                    if (a.this.fVU.isAdded() && a.this.ebb != null) {
                        a.this.ebb.showToast(a.this.ebb.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.m(false, this.fWn.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.fWn.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.fWn.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.fWn.getName()));
                    }
                    a.this.fVV.a(this.fWn, a.this.fVW.byZ());
                    a.this.fVW.b(this.fWn);
                } else if (a.this.ebb != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.ebb.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fVU.isAdded()) {
                        a.this.ebb.showToast(a.this.ebb.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.kF(true);
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
    /* loaded from: classes9.dex */
    private class C0495a extends BdAsyncTask<f, Integer, String> {
        private f fWn;
        private x mNetwork = null;

        public C0495a(f fVar) {
            this.fWn = null;
            this.fWn = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fWn;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bxW() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.aGk().aGL().mIsNeedTbs = true;
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
            super.onPostExecute((C0495a) str);
            a.this.kF(false);
            int bxW = this.fWn.bxW();
            if (this.mNetwork != null) {
                if (this.mNetwork.aGk().aGM().isRequestSuccess()) {
                    a.this.fWc = true;
                    if (a.this.fVU.isAdded() && a.this.ebb != null) {
                        a.this.ebb.showToast(a.this.ebb.getActivity().getString(bxW > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.fVW.kL(true);
                } else if (a.this.ebb != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.ebb.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fVU.isAdded()) {
                        a.this.ebb.showToast(a.this.ebb.getActivity().getString(bxW > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.kF(true);
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
    public void m(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.bYu().y(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aQs = bVar.aQs();
        com.baidu.tbadk.mvc.b.a aQt = bVar.aQt();
        switch (aQs) {
            case 1:
                if (this.fWd != 2 && (aQt instanceof f)) {
                    String name = ((f) aQt).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.ebb.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) aQt).aOl() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) aQt).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) aQt).byb());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) aQt).bya().night != null && ((f) aQt).bya().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) aQt).bya().night.pattern_image);
                                    }
                                } else if (((f) aQt).bya().day != null && ((f) aQt).bya().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) aQt).bya().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) aQt).bye());
                            ((f) aQt).m31do(0L);
                        }
                        this.ebb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.ebb.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").s("uid", TbadkApplication.getCurrentAccountId()).X("obj_type", this.fVW.byX().getSortType() == 1 ? 2 : 1).cx("fid", ((f) aQt).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.fWd == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (aQt instanceof h) {
                    ((h) aQt).getPosition();
                }
                this.fWc = false;
                if (this.fVU.getView() == null || this.fVU.getView().getParent() == null) {
                    return true;
                }
                this.fVU.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (aQt instanceof f) {
                    a((f) aQt);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.ebb.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.ebb.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.ebb.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.ebb.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").cx("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).cx("obj_type", "2").X("obj_locate", 1));
                this.ebb.finish();
                return true;
            case 9:
                if (this.fVV != null) {
                    this.fVV.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.fWd = 2;
                return true;
            case 11:
                this.fWd = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.fWd != 2) {
                    if (this.fWe == null) {
                        this.fWe = new com.baidu.tieba.enterForum.view.d(this.ebb.getPageContext(), this.fUg);
                    }
                    if (aQt instanceof f) {
                        this.fWe.c((f) aQt);
                        this.fWe.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aQt instanceof f) {
                    new C0495a((f) aQt).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").X("obj_type", ((f) aQt).bxW() <= 0 ? 1 : 2).cx("fid", ((f) aQt).getId()).s("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aGK().b(this.ebb.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eqc.cPb() || !(aQt instanceof f)) {
                    return true;
                }
                ba.aGK().b(this.ebb.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) aQt).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQu());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQu());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQu());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aQr() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.ebb.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fVV != null) {
            this.fVV.setPageUniqueId(bdUniqueId);
        }
    }

    public void kI(boolean z) {
        int i;
        if (this.fVV != null && this.fVU != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fVV.setAdState(bVar);
        this.fVU.setAdState(bVar);
    }
}
