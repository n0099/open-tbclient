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
    private LikeModel djT;
    private BaseFragmentActivity eax;
    private EnterForumFragment fUW;
    private EnterForumModel fUY;
    private RecentlyVisitedForumModel fUZ;
    private com.baidu.tieba.ueg.d fVa;
    private boolean fVb;
    private String fVd;
    private long fVe;
    private boolean fVf;
    private com.baidu.tieba.enterForum.view.d fVh;
    private boolean fVi;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b fUX = null;
    private com.baidu.tbadk.core.dialog.a dTB = null;
    private boolean fVc = false;
    private int fVg = 1;
    private CustomMessageListener fVj = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.fVc = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fVk = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.fUY.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.fUX.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.eax.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.eax.showToast(errorString);
                    if (a.this.fUX.isEmpty()) {
                        a.this.fUX.bL(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.fUY.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.fUY.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d fVl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bb(a.this.djT.getErrorCode(), a.this.djT.getErrorString())) {
                AntiHelper.bn(a.this.eax.getPageContext().getPageActivity(), a.this.djT.getErrorString());
            } else if (obj != null) {
                a.this.fUY.kG(!StringUtils.isNull(a.this.fVd));
            } else if (!StringUtils.isNull(a.this.djT.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.djT.getErrorString());
            }
        }
    };
    private final EnterForumModel.b fVm = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.fUW != null) {
                if (aVar.type == 1) {
                    a.this.fUX.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.fVb = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.fWx;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aFB().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.fVb) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.fWx;
                        a.this.fUY.c(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.eax.showToast(aVar.error);
                    a.this.fUX.rK(com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.fVe > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.fVe, a.this.fUY.byN() - a.this.fVe, a.this.fUY.byL(), a.this.fUY.byM(), currentTimeMillis - a.this.fUY.byK());
                    a.this.fVe = -1L;
                }
                String string = a.this.eax.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.fWx != null && aVar.fWx.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.fWx.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bxM() != null) {
                        string = hotSearchInfoData.bxM();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private g.c dgH = new g.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.fUI.loadAd();
            a.this.fUY.kG(!StringUtils.isNull(a.this.fVd));
            a.this.fUZ.LoadData();
            a.this.fUY.kF(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter fTi = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.fUY = null;
        this.isFirst = true;
        this.fVb = false;
        this.fVe = -1L;
        this.fUW = enterForumFragment;
        this.eax = enterForumFragment.getBaseFragmentActivity();
        this.fTi.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bJT();
        this.fVe = System.currentTimeMillis();
        this.isFirst = true;
        this.fVb = false;
        this.fVd = "";
        this.fUY = new EnterForumModel(this.eax.getPageContext());
        this.fUZ = new RecentlyVisitedForumModel();
        this.djT = new LikeModel(this.eax.getPageContext());
        this.fVa = new com.baidu.tieba.ueg.d(this.eax.getPageContext());
        this.djT.setLoadDataCallBack(this.fVl);
        this.fUY.a(this.fVm);
        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.byI().init(this.fUW.getFragmentActivity(), l.getStatusBarHeight(this.fUW.getFragmentActivity()));
        initUI();
        initListener();
        byp();
    }

    private void initListener() {
        byo();
        this.fUW.registerListener(this.fVk);
        this.fUW.registerListener(this.fVj);
    }

    private void byo() {
        this.fUW.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fUX != null && a.this.fUX.bxB()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void byp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<af>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<af> run(CustomMessage<af> customMessage) {
                af afVar = new af();
                ArrayList arrayList = new ArrayList();
                if (a.this.fUY != null && a.this.fUY.byO() != null && a.this.fUY.byO().bxF() != null && v.getCount(a.this.fUY.byO().bxF().bxX()) > 0) {
                    Iterator<f> it = a.this.fUY.byO().bxF().bxX().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eax.getPageContext().getPageActivity());
            aVar.sS(String.format(this.eax.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.eax.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.eax.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.eax.getPageContext());
            aVar.aEA();
        }
    }

    public void kA(boolean z) {
        if (this.mWaitingDialog == null) {
            byq();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void byq() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.eax.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.eax.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.fUX = new com.baidu.tieba.enterForum.view.b(this.fUW, this.mRootView, this.fTi, this.fUZ, this.fUY);
        this.fUX.setListPullRefreshListener(this.dgH);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void kB(boolean z) {
        if (this.fUX != null && this.fUW != null) {
            if (z) {
                if (this.fUW.isPrimary() && this.fUW.isResumed()) {
                    this.fUX.startPullRefresh();
                } else {
                    this.fUX.completeRefresh();
                }
            } else {
                this.fUX.completeRefresh();
            }
            this.fUX.kP(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.fUW.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.fUX != null) {
            if (cVar == null) {
                this.fUX.bL(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g bxF = cVar.bxF();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bxF != null) {
                arrayList = bxF.bxX();
            }
            bM(arrayList);
            b(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bxM() != null) {
                setSearchHint(hotSearchInfoData.bxM());
            }
            this.fUX.bzz();
            this.fUX.rK(cVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.fUW.byl() != null) {
            if (!StringUtils.isNull(str)) {
                this.fUW.byl().setSearchHint(str.trim());
            } else {
                this.fUW.byl().setSearchHint(this.eax.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bM(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.fUX.n(this.fUY.a(list, com.baidu.tbadk.util.e.aRT()), this.fUY.byQ());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bxH() != null && this.fUW.isPrimary() && this.dTB == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.eax.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bxH())) {
                this.dTB = new com.baidu.tbadk.core.dialog.a(this.eax.getActivity());
                this.dTB.jZ(2);
                this.dTB.aO(frsPrivateCommonDialogView);
                this.dTB.fH(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aGE().b(a.this.eax.getPageContext(), new String[]{cVar.bxH().aBt()});
                        a.this.dTB.dismiss();
                        a.this.dTB = null;
                    }
                });
                this.dTB.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.dTB = null;
                    }
                });
                this.dTB.b(this.eax.getPageContext()).aEA();
            }
        }
    }

    private void byr() {
        if (this.dTB != null) {
            this.dTB.dismiss();
            this.dTB = null;
        }
    }

    public void loadData() {
        if (this.fUX != null) {
            kC(false);
        }
    }

    public void bys() {
        if (this.fUX != null) {
            kC(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.byI().destroy();
        if (this.fUX != null) {
            this.fUX.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.fUZ != null) {
            this.fUZ.onDestroy();
        }
        if (this.fUY != null) {
            this.fUY.onDestroy();
        }
        if (this.fTi != null) {
            this.fTi.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fUX != null) {
            this.fUX.onChangeSkinType(i);
        }
        if (this.fVh != null) {
            this.fVh.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.fUY != null) {
            this.fUY.cancelLoadData();
        }
    }

    public void kC(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.fVi && this.fUY != null && this.fUX != null) {
            String str = this.fVd;
            this.fVd = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.fVd == null || this.fVd.equals(str)) {
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
                if (this.fUY != null && this.fUY.byO() != null && this.fUY.byO().bxF() != null) {
                    Iterator<f> it = this.fUY.byO().bxF().bxX().iterator();
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
                    com.baidu.tieba.tbadkCore.util.a.Jh(currentAccount);
                }
                this.fUX.kO(this.fUY.byQ());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.fUY != null) {
                        this.fUY.kH(StringUtils.isNull(this.fVd) ? false : true);
                    }
                    this.fUZ.LoadData();
                } else if (z2 && this.fUY != null) {
                    this.fUY.kH(StringUtils.isNull(this.fVd) ? false : true);
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
        if (this.fUW.isAdded() && this.fUW.isPrimary()) {
            if (this.fUZ != null) {
                this.fUZ.onPrimary();
            }
        } else {
            byr();
        }
        if (this.fUX != null) {
            this.fUX.onPrimary();
        }
    }

    public void onPause() {
        if (this.fUX != null && this.fUX.bzy() != null) {
            this.fUX.bzy().completePullRefresh();
        }
        if (this.fUZ != null) {
            this.fUZ.onPause();
        }
        if (this.fUY != null) {
            this.fUY.onPause();
        }
        if (this.fUX != null) {
            this.fUX.onPause();
        }
    }

    public void akG() {
        if (this.fUX != null) {
            this.fUX.bK(this.mRootView);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f fVq;
        private x mNetwork = null;

        public b(f fVar) {
            this.fVq = null;
            this.fVq = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fVq;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.aGe().aGF().mIsNeedTbs = true;
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
                if (this.mNetwork.aGe().aGG().isRequestSuccess()) {
                    a.this.fVf = true;
                    if (a.this.fUW.isAdded() && a.this.eax != null) {
                        a.this.eax.showToast(a.this.eax.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.m(false, this.fVq.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.fVq.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.fVq.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.fVq.getName()));
                    }
                    a.this.fUX.a(this.fVq, a.this.fUY.byQ());
                    a.this.fUY.b(this.fVq);
                } else if (a.this.eax != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eax.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fUW.isAdded()) {
                        a.this.eax.showToast(a.this.eax.getActivity().getString(R.string.delete_like_fail));
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
        private f fVq;
        private x mNetwork = null;

        public C0495a(f fVar) {
            this.fVq = null;
            this.fVq = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fVq;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bxO() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.aGe().aGF().mIsNeedTbs = true;
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
            int bxO = this.fVq.bxO();
            if (this.mNetwork != null) {
                if (this.mNetwork.aGe().aGG().isRequestSuccess()) {
                    a.this.fVf = true;
                    if (a.this.fUW.isAdded() && a.this.eax != null) {
                        a.this.eax.showToast(a.this.eax.getActivity().getString(bxO > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.fUY.kG(true);
                } else if (a.this.eax != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eax.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fUW.isAdded()) {
                        a.this.eax.showToast(a.this.eax.getActivity().getString(bxO > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.bXZ().y(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aQl = bVar.aQl();
        com.baidu.tbadk.mvc.b.a aQm = bVar.aQm();
        switch (aQl) {
            case 1:
                if (this.fVg != 2 && (aQm instanceof f)) {
                    String name = ((f) aQm).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.eax.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) aQm).aOe() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) aQm).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) aQm).bxT());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) aQm).bxS().night != null && ((f) aQm).bxS().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) aQm).bxS().night.pattern_image);
                                    }
                                } else if (((f) aQm).bxS().day != null && ((f) aQm).bxS().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) aQm).bxS().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) aQm).bxW());
                            ((f) aQm).m33do(0L);
                        }
                        this.eax.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.eax.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").s("uid", TbadkApplication.getCurrentAccountId()).X("obj_type", this.fUY.byO().getSortType() == 1 ? 2 : 1).cy("fid", ((f) aQm).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.fVg == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (aQm instanceof h) {
                    ((h) aQm).getPosition();
                }
                this.fVf = false;
                if (this.fUW.getView() == null || this.fUW.getView().getParent() == null) {
                    return true;
                }
                this.fUW.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (aQm instanceof f) {
                    a((f) aQm);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.eax.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eax.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.eax.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eax.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").cy("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).cy("obj_type", "2").X("obj_locate", 1));
                this.eax.finish();
                return true;
            case 9:
                if (this.fUX != null) {
                    this.fUX.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.fVg = 2;
                return true;
            case 11:
                this.fVg = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.fVg != 2) {
                    if (this.fVh == null) {
                        this.fVh = new com.baidu.tieba.enterForum.view.d(this.eax.getPageContext(), this.fTi);
                    }
                    if (aQm instanceof f) {
                        this.fVh.c((f) aQm);
                        this.fVh.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aQm instanceof f) {
                    new C0495a((f) aQm).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").X("obj_type", ((f) aQm).bxO() <= 0 ? 1 : 2).cy("fid", ((f) aQm).getId()).s("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aGE().b(this.eax.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fVa.cOE() || !(aQm instanceof f)) {
                    return true;
                }
                ba.aGE().b(this.eax.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) aQm).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQn());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQn());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQn());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aQk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.eax.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fUX != null) {
            this.fUX.setPageUniqueId(bdUniqueId);
        }
    }

    public void kD(boolean z) {
        int i;
        if (this.fUX != null && this.fUW != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fUX.setAdState(bVar);
        this.fUW.setAdState(bVar);
    }
}
