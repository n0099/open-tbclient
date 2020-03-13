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
    private LikeModel dkh;
    private BaseFragmentActivity eaL;
    private EnterForumFragment fVl;
    private EnterForumModel fVn;
    private RecentlyVisitedForumModel fVo;
    private com.baidu.tieba.ueg.d fVp;
    private boolean fVq;
    private String fVs;
    private long fVt;
    private boolean fVu;
    private com.baidu.tieba.enterForum.view.d fVw;
    private boolean fVx;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b fVm = null;
    private com.baidu.tbadk.core.dialog.a dTP = null;
    private boolean fVr = false;
    private int fVv = 1;
    private CustomMessageListener fVy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.fVr = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fVz = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.fVn.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.fVm.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.eaL.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.eaL.showToast(errorString);
                    if (a.this.fVm.isEmpty()) {
                        a.this.fVm.bL(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.fVn.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.fVn.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d fVA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bb(a.this.dkh.getErrorCode(), a.this.dkh.getErrorString())) {
                AntiHelper.bn(a.this.eaL.getPageContext().getPageActivity(), a.this.dkh.getErrorString());
            } else if (obj != null) {
                a.this.fVn.kG(!StringUtils.isNull(a.this.fVs));
            } else if (!StringUtils.isNull(a.this.dkh.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.dkh.getErrorString());
            }
        }
    };
    private final EnterForumModel.b fVB = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.fVl != null) {
                if (aVar.type == 1) {
                    a.this.fVm.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.fVq = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.fWM;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.fVq) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.fWM;
                        a.this.fVn.c(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.eaL.showToast(aVar.error);
                    a.this.fVm.rK(com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.fVt > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.fVt, a.this.fVn.byQ() - a.this.fVt, a.this.fVn.byO(), a.this.fVn.byP(), currentTimeMillis - a.this.fVn.byN());
                    a.this.fVt = -1L;
                }
                String string = a.this.eaL.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.fWM != null && aVar.fWM.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.fWM.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bxP() != null) {
                        string = hotSearchInfoData.bxP();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private g.c dgV = new g.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.fUX.loadAd();
            a.this.fVn.kG(!StringUtils.isNull(a.this.fVs));
            a.this.fVo.LoadData();
            a.this.fVn.kF(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter fTx = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.fVn = null;
        this.isFirst = true;
        this.fVq = false;
        this.fVt = -1L;
        this.fVl = enterForumFragment;
        this.eaL = enterForumFragment.getBaseFragmentActivity();
        this.fTx.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bJW();
        this.fVt = System.currentTimeMillis();
        this.isFirst = true;
        this.fVq = false;
        this.fVs = "";
        this.fVn = new EnterForumModel(this.eaL.getPageContext());
        this.fVo = new RecentlyVisitedForumModel();
        this.dkh = new LikeModel(this.eaL.getPageContext());
        this.fVp = new com.baidu.tieba.ueg.d(this.eaL.getPageContext());
        this.dkh.setLoadDataCallBack(this.fVA);
        this.fVn.a(this.fVB);
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.byL().init(this.fVl.getFragmentActivity(), l.getStatusBarHeight(this.fVl.getFragmentActivity()));
        initUI();
        initListener();
        bys();
    }

    private void initListener() {
        byr();
        this.fVl.registerListener(this.fVz);
        this.fVl.registerListener(this.fVy);
    }

    private void byr() {
        this.fVl.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fVm != null && a.this.fVm.bxE()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bys() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<af>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<af> run(CustomMessage<af> customMessage) {
                af afVar = new af();
                ArrayList arrayList = new ArrayList();
                if (a.this.fVn != null && a.this.fVn.byR() != null && a.this.fVn.byR().bxI() != null && v.getCount(a.this.fVn.byR().bxI().bya()) > 0) {
                    Iterator<f> it = a.this.fVn.byR().bxI().bya().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eaL.getPageContext().getPageActivity());
            aVar.sS(String.format(this.eaL.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.eaL.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.eaL.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.eaL.getPageContext());
            aVar.aEC();
        }
    }

    public void kA(boolean z) {
        if (this.mWaitingDialog == null) {
            byt();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void byt() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.eaL.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.eaL.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.fVm = new com.baidu.tieba.enterForum.view.b(this.fVl, this.mRootView, this.fTx, this.fVo, this.fVn);
        this.fVm.setListPullRefreshListener(this.dgV);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void kB(boolean z) {
        if (this.fVm != null && this.fVl != null) {
            if (z) {
                if (this.fVl.isPrimary() && this.fVl.isResumed()) {
                    this.fVm.startPullRefresh();
                } else {
                    this.fVm.completeRefresh();
                }
            } else {
                this.fVm.completeRefresh();
            }
            this.fVm.kP(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.fVl.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.fVm != null) {
            if (cVar == null) {
                this.fVm.bL(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g bxI = cVar.bxI();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bxI != null) {
                arrayList = bxI.bya();
            }
            bM(arrayList);
            b(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bxP() != null) {
                setSearchHint(hotSearchInfoData.bxP());
            }
            this.fVm.bzC();
            this.fVm.rK(cVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.fVl.byo() != null) {
            if (!StringUtils.isNull(str)) {
                this.fVl.byo().setSearchHint(str.trim());
            } else {
                this.fVl.byo().setSearchHint(this.eaL.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bM(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.fVm.n(this.fVn.a(list, com.baidu.tbadk.util.e.aRW()), this.fVn.byT());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bxK() != null && this.fVl.isPrimary() && this.dTP == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.eaL.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bxK())) {
                this.dTP = new com.baidu.tbadk.core.dialog.a(this.eaL.getActivity());
                this.dTP.jZ(2);
                this.dTP.aO(frsPrivateCommonDialogView);
                this.dTP.fH(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aGG().b(a.this.eaL.getPageContext(), new String[]{cVar.bxK().aBv()});
                        a.this.dTP.dismiss();
                        a.this.dTP = null;
                    }
                });
                this.dTP.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.dTP = null;
                    }
                });
                this.dTP.b(this.eaL.getPageContext()).aEC();
            }
        }
    }

    private void byu() {
        if (this.dTP != null) {
            this.dTP.dismiss();
            this.dTP = null;
        }
    }

    public void loadData() {
        if (this.fVm != null) {
            kC(false);
        }
    }

    public void byv() {
        if (this.fVm != null) {
            kC(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.byL().destroy();
        if (this.fVm != null) {
            this.fVm.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.fVo != null) {
            this.fVo.onDestroy();
        }
        if (this.fVn != null) {
            this.fVn.onDestroy();
        }
        if (this.fTx != null) {
            this.fTx.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fVm != null) {
            this.fVm.onChangeSkinType(i);
        }
        if (this.fVw != null) {
            this.fVw.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.fVn != null) {
            this.fVn.cancelLoadData();
        }
    }

    public void kC(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.fVx && this.fVn != null && this.fVm != null) {
            String str = this.fVs;
            this.fVs = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.fVs == null || this.fVs.equals(str)) {
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
                if (this.fVn != null && this.fVn.byR() != null && this.fVn.byR().bxI() != null) {
                    Iterator<f> it = this.fVn.byR().bxI().bya().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.rM(1);
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
                    com.baidu.tieba.tbadkCore.util.a.Ji(currentAccount);
                }
                this.fVm.kO(this.fVn.byT());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.fVn != null) {
                        this.fVn.kH(StringUtils.isNull(this.fVs) ? false : true);
                    }
                    this.fVo.LoadData();
                } else if (z2 && this.fVn != null) {
                    this.fVn.kH(StringUtils.isNull(this.fVs) ? false : true);
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
        if (this.fVl.isAdded() && this.fVl.isPrimary()) {
            if (this.fVo != null) {
                this.fVo.onPrimary();
            }
        } else {
            byu();
        }
        if (this.fVm != null) {
            this.fVm.onPrimary();
        }
    }

    public void onPause() {
        if (this.fVm != null && this.fVm.bzB() != null) {
            this.fVm.bzB().completePullRefresh();
        }
        if (this.fVo != null) {
            this.fVo.onPause();
        }
        if (this.fVn != null) {
            this.fVn.onPause();
        }
        if (this.fVm != null) {
            this.fVm.onPause();
        }
    }

    public void akI() {
        if (this.fVm != null) {
            this.fVm.bK(this.mRootView);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f fVF;
        private x mNetwork = null;

        public b(f fVar) {
            this.fVF = null;
            this.fVF = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fVF;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.aGg().aGH().mIsNeedTbs = true;
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
            a.this.kA(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.aGg().aGI().isRequestSuccess()) {
                    a.this.fVu = true;
                    if (a.this.fVl.isAdded() && a.this.eaL != null) {
                        a.this.eaL.showToast(a.this.eaL.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.m(false, this.fVF.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.fVF.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.fVF.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.fVF.getName()));
                    }
                    a.this.fVm.a(this.fVF, a.this.fVn.byT());
                    a.this.fVn.b(this.fVF);
                } else if (a.this.eaL != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eaL.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fVl.isAdded()) {
                        a.this.eaL.showToast(a.this.eaL.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.kA(true);
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
        private f fVF;
        private x mNetwork = null;

        public C0495a(f fVar) {
            this.fVF = null;
            this.fVF = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fVF;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bxR() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.aGg().aGH().mIsNeedTbs = true;
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
            a.this.kA(false);
            int bxR = this.fVF.bxR();
            if (this.mNetwork != null) {
                if (this.mNetwork.aGg().aGI().isRequestSuccess()) {
                    a.this.fVu = true;
                    if (a.this.fVl.isAdded() && a.this.eaL != null) {
                        a.this.eaL.showToast(a.this.eaL.getActivity().getString(bxR > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.fVn.kG(true);
                } else if (a.this.eaL != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eaL.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fVl.isAdded()) {
                        a.this.eaL.showToast(a.this.eaL.getActivity().getString(bxR > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.kA(true);
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
                    com.baidu.tieba.im.settingcache.d.bYc().y(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aQo = bVar.aQo();
        com.baidu.tbadk.mvc.b.a aQp = bVar.aQp();
        switch (aQo) {
            case 1:
                if (this.fVv != 2 && (aQp instanceof f)) {
                    String name = ((f) aQp).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.eaL.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) aQp).aOh() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) aQp).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) aQp).bxW());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) aQp).bxV().night != null && ((f) aQp).bxV().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) aQp).bxV().night.pattern_image);
                                    }
                                } else if (((f) aQp).bxV().day != null && ((f) aQp).bxV().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) aQp).bxV().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) aQp).bxZ());
                            ((f) aQp).m33do(0L);
                        }
                        this.eaL.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.eaL.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").s("uid", TbadkApplication.getCurrentAccountId()).X("obj_type", this.fVn.byR().getSortType() == 1 ? 2 : 1).cy("fid", ((f) aQp).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.fVv == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (aQp instanceof h) {
                    ((h) aQp).getPosition();
                }
                this.fVu = false;
                if (this.fVl.getView() == null || this.fVl.getView().getParent() == null) {
                    return true;
                }
                this.fVl.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (aQp instanceof f) {
                    a((f) aQp);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.eaL.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eaL.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.eaL.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eaL.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").cy("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).cy("obj_type", "2").X("obj_locate", 1));
                this.eaL.finish();
                return true;
            case 9:
                if (this.fVm != null) {
                    this.fVm.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.fVv = 2;
                return true;
            case 11:
                this.fVv = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.fVv != 2) {
                    if (this.fVw == null) {
                        this.fVw = new com.baidu.tieba.enterForum.view.d(this.eaL.getPageContext(), this.fTx);
                    }
                    if (aQp instanceof f) {
                        this.fVw.c((f) aQp);
                        this.fVw.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aQp instanceof f) {
                    new C0495a((f) aQp).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").X("obj_type", ((f) aQp).bxR() <= 0 ? 1 : 2).cy("fid", ((f) aQp).getId()).s("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aGG().b(this.eaL.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fVp.cOH() || !(aQp instanceof f)) {
                    return true;
                }
                ba.aGG().b(this.eaL.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) aQp).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQq());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQq());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQq());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aQn() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.eaL.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fVm != null) {
            this.fVm.setPageUniqueId(bdUniqueId);
        }
    }

    public void kD(boolean z) {
        int i;
        if (this.fVm != null && this.fVl != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fVm.setAdState(bVar);
        this.fVl.setAdState(bVar);
    }
}
