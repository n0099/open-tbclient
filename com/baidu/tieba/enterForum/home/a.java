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
    private LikeModel djU;
    private BaseFragmentActivity eay;
    private EnterForumFragment fUY;
    private EnterForumModel fVa;
    private RecentlyVisitedForumModel fVb;
    private com.baidu.tieba.ueg.d fVc;
    private boolean fVd;
    private String fVf;
    private long fVg;
    private boolean fVh;
    private com.baidu.tieba.enterForum.view.d fVj;
    private boolean fVk;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b fUZ = null;
    private com.baidu.tbadk.core.dialog.a dTC = null;
    private boolean fVe = false;
    private int fVi = 1;
    private CustomMessageListener fVl = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.fVe = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fVm = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.fVa.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.fUZ.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.eay.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.eay.showToast(errorString);
                    if (a.this.fUZ.isEmpty()) {
                        a.this.fUZ.bL(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.fVa.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.fVa.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d fVn = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bb(a.this.djU.getErrorCode(), a.this.djU.getErrorString())) {
                AntiHelper.bn(a.this.eay.getPageContext().getPageActivity(), a.this.djU.getErrorString());
            } else if (obj != null) {
                a.this.fVa.kG(!StringUtils.isNull(a.this.fVf));
            } else if (!StringUtils.isNull(a.this.djU.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.djU.getErrorString());
            }
        }
    };
    private final EnterForumModel.b fVo = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.fUY != null) {
                if (aVar.type == 1) {
                    a.this.fUZ.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.fVd = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.fWz;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.fVd) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.fWz;
                        a.this.fVa.c(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.eay.showToast(aVar.error);
                    a.this.fUZ.rK(com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.fVg > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.fVg, a.this.fVa.byP() - a.this.fVg, a.this.fVa.byN(), a.this.fVa.byO(), currentTimeMillis - a.this.fVa.byM());
                    a.this.fVg = -1L;
                }
                String string = a.this.eay.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.fWz != null && aVar.fWz.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.fWz.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bxO() != null) {
                        string = hotSearchInfoData.bxO();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private g.c dgI = new g.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.fUK.loadAd();
            a.this.fVa.kG(!StringUtils.isNull(a.this.fVf));
            a.this.fVb.LoadData();
            a.this.fVa.kF(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter fTk = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.fVa = null;
        this.isFirst = true;
        this.fVd = false;
        this.fVg = -1L;
        this.fUY = enterForumFragment;
        this.eay = enterForumFragment.getBaseFragmentActivity();
        this.fTk.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bJV();
        this.fVg = System.currentTimeMillis();
        this.isFirst = true;
        this.fVd = false;
        this.fVf = "";
        this.fVa = new EnterForumModel(this.eay.getPageContext());
        this.fVb = new RecentlyVisitedForumModel();
        this.djU = new LikeModel(this.eay.getPageContext());
        this.fVc = new com.baidu.tieba.ueg.d(this.eay.getPageContext());
        this.djU.setLoadDataCallBack(this.fVn);
        this.fVa.a(this.fVo);
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.byK().init(this.fUY.getFragmentActivity(), l.getStatusBarHeight(this.fUY.getFragmentActivity()));
        initUI();
        initListener();
        byr();
    }

    private void initListener() {
        byq();
        this.fUY.registerListener(this.fVm);
        this.fUY.registerListener(this.fVl);
    }

    private void byq() {
        this.fUY.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fUZ != null && a.this.fUZ.bxD()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void byr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<af>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<af> run(CustomMessage<af> customMessage) {
                af afVar = new af();
                ArrayList arrayList = new ArrayList();
                if (a.this.fVa != null && a.this.fVa.byQ() != null && a.this.fVa.byQ().bxH() != null && v.getCount(a.this.fVa.byQ().bxH().bxZ()) > 0) {
                    Iterator<f> it = a.this.fVa.byQ().bxH().bxZ().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eay.getPageContext().getPageActivity());
            aVar.sS(String.format(this.eay.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.eay.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.eay.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.eay.getPageContext());
            aVar.aEC();
        }
    }

    public void kA(boolean z) {
        if (this.mWaitingDialog == null) {
            bys();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bys() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.eay.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.eay.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.fUZ = new com.baidu.tieba.enterForum.view.b(this.fUY, this.mRootView, this.fTk, this.fVb, this.fVa);
        this.fUZ.setListPullRefreshListener(this.dgI);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void kB(boolean z) {
        if (this.fUZ != null && this.fUY != null) {
            if (z) {
                if (this.fUY.isPrimary() && this.fUY.isResumed()) {
                    this.fUZ.startPullRefresh();
                } else {
                    this.fUZ.completeRefresh();
                }
            } else {
                this.fUZ.completeRefresh();
            }
            this.fUZ.kP(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.fUY.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.fUZ != null) {
            if (cVar == null) {
                this.fUZ.bL(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g bxH = cVar.bxH();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bxH != null) {
                arrayList = bxH.bxZ();
            }
            bM(arrayList);
            b(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bxO() != null) {
                setSearchHint(hotSearchInfoData.bxO());
            }
            this.fUZ.bzB();
            this.fUZ.rK(cVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.fUY.byn() != null) {
            if (!StringUtils.isNull(str)) {
                this.fUY.byn().setSearchHint(str.trim());
            } else {
                this.fUY.byn().setSearchHint(this.eay.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bM(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.fUZ.n(this.fVa.a(list, com.baidu.tbadk.util.e.aRV()), this.fVa.byS());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bxJ() != null && this.fUY.isPrimary() && this.dTC == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.eay.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bxJ())) {
                this.dTC = new com.baidu.tbadk.core.dialog.a(this.eay.getActivity());
                this.dTC.jZ(2);
                this.dTC.aO(frsPrivateCommonDialogView);
                this.dTC.fH(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aGG().b(a.this.eay.getPageContext(), new String[]{cVar.bxJ().aBv()});
                        a.this.dTC.dismiss();
                        a.this.dTC = null;
                    }
                });
                this.dTC.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.dTC = null;
                    }
                });
                this.dTC.b(this.eay.getPageContext()).aEC();
            }
        }
    }

    private void byt() {
        if (this.dTC != null) {
            this.dTC.dismiss();
            this.dTC = null;
        }
    }

    public void loadData() {
        if (this.fUZ != null) {
            kC(false);
        }
    }

    public void byu() {
        if (this.fUZ != null) {
            kC(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.byK().destroy();
        if (this.fUZ != null) {
            this.fUZ.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.fVb != null) {
            this.fVb.onDestroy();
        }
        if (this.fVa != null) {
            this.fVa.onDestroy();
        }
        if (this.fTk != null) {
            this.fTk.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fUZ != null) {
            this.fUZ.onChangeSkinType(i);
        }
        if (this.fVj != null) {
            this.fVj.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.fVa != null) {
            this.fVa.cancelLoadData();
        }
    }

    public void kC(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.fVk && this.fVa != null && this.fUZ != null) {
            String str = this.fVf;
            this.fVf = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.fVf == null || this.fVf.equals(str)) {
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
                if (this.fVa != null && this.fVa.byQ() != null && this.fVa.byQ().bxH() != null) {
                    Iterator<f> it = this.fVa.byQ().bxH().bxZ().iterator();
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
                this.fUZ.kO(this.fVa.byS());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.fVa != null) {
                        this.fVa.kH(StringUtils.isNull(this.fVf) ? false : true);
                    }
                    this.fVb.LoadData();
                } else if (z2 && this.fVa != null) {
                    this.fVa.kH(StringUtils.isNull(this.fVf) ? false : true);
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
        if (this.fUY.isAdded() && this.fUY.isPrimary()) {
            if (this.fVb != null) {
                this.fVb.onPrimary();
            }
        } else {
            byt();
        }
        if (this.fUZ != null) {
            this.fUZ.onPrimary();
        }
    }

    public void onPause() {
        if (this.fUZ != null && this.fUZ.bzA() != null) {
            this.fUZ.bzA().completePullRefresh();
        }
        if (this.fVb != null) {
            this.fVb.onPause();
        }
        if (this.fVa != null) {
            this.fVa.onPause();
        }
        if (this.fUZ != null) {
            this.fUZ.onPause();
        }
    }

    public void akI() {
        if (this.fUZ != null) {
            this.fUZ.bK(this.mRootView);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f fVs;
        private x mNetwork = null;

        public b(f fVar) {
            this.fVs = null;
            this.fVs = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fVs;
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
                    a.this.fVh = true;
                    if (a.this.fUY.isAdded() && a.this.eay != null) {
                        a.this.eay.showToast(a.this.eay.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.m(false, this.fVs.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.fVs.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.fVs.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.fVs.getName()));
                    }
                    a.this.fUZ.a(this.fVs, a.this.fVa.byS());
                    a.this.fVa.b(this.fVs);
                } else if (a.this.eay != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eay.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fUY.isAdded()) {
                        a.this.eay.showToast(a.this.eay.getActivity().getString(R.string.delete_like_fail));
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
        private f fVs;
        private x mNetwork = null;

        public C0495a(f fVar) {
            this.fVs = null;
            this.fVs = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fVs;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bxQ() == 0) {
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
            int bxQ = this.fVs.bxQ();
            if (this.mNetwork != null) {
                if (this.mNetwork.aGg().aGI().isRequestSuccess()) {
                    a.this.fVh = true;
                    if (a.this.fUY.isAdded() && a.this.eay != null) {
                        a.this.eay.showToast(a.this.eay.getActivity().getString(bxQ > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.fVa.kG(true);
                } else if (a.this.eay != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eay.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fUY.isAdded()) {
                        a.this.eay.showToast(a.this.eay.getActivity().getString(bxQ > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.bYb().y(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aQn = bVar.aQn();
        com.baidu.tbadk.mvc.b.a aQo = bVar.aQo();
        switch (aQn) {
            case 1:
                if (this.fVi != 2 && (aQo instanceof f)) {
                    String name = ((f) aQo).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.eay.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) aQo).aOg() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) aQo).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) aQo).bxV());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) aQo).bxU().night != null && ((f) aQo).bxU().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) aQo).bxU().night.pattern_image);
                                    }
                                } else if (((f) aQo).bxU().day != null && ((f) aQo).bxU().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) aQo).bxU().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) aQo).bxY());
                            ((f) aQo).m33do(0L);
                        }
                        this.eay.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.eay.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").s("uid", TbadkApplication.getCurrentAccountId()).X("obj_type", this.fVa.byQ().getSortType() == 1 ? 2 : 1).cy("fid", ((f) aQo).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.fVi == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (aQo instanceof h) {
                    ((h) aQo).getPosition();
                }
                this.fVh = false;
                if (this.fUY.getView() == null || this.fUY.getView().getParent() == null) {
                    return true;
                }
                this.fUY.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (aQo instanceof f) {
                    a((f) aQo);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.eay.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eay.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.eay.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eay.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").cy("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).cy("obj_type", "2").X("obj_locate", 1));
                this.eay.finish();
                return true;
            case 9:
                if (this.fUZ != null) {
                    this.fUZ.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.fVi = 2;
                return true;
            case 11:
                this.fVi = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.fVi != 2) {
                    if (this.fVj == null) {
                        this.fVj = new com.baidu.tieba.enterForum.view.d(this.eay.getPageContext(), this.fTk);
                    }
                    if (aQo instanceof f) {
                        this.fVj.c((f) aQo);
                        this.fVj.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aQo instanceof f) {
                    new C0495a((f) aQo).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").X("obj_type", ((f) aQo).bxQ() <= 0 ? 1 : 2).cy("fid", ((f) aQo).getId()).s("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aGG().b(this.eay.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fVc.cOG() || !(aQo instanceof f)) {
                    return true;
                }
                ba.aGG().b(this.eay.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) aQo).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQp());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQp());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aQp());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aQm() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.eay.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fUZ != null) {
            this.fUZ.setPageUniqueId(bdUniqueId);
        }
    }

    public void kD(boolean z) {
        int i;
        if (this.fUZ != null && this.fUY != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fUZ.setAdState(bVar);
        this.fUY.setAdState(bVar);
    }
}
