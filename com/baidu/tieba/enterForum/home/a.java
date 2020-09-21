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
/* loaded from: classes21.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel ezi;
    private com.baidu.tieba.ueg.d fLE;
    private BaseFragmentActivity fsZ;
    private com.baidu.tieba.enterForum.view.d hCB;
    private boolean hCC;
    private EnterForumFragment hCr;
    private EnterForumModel hCt;
    private RecentlyVisitedForumModel hCu;
    private boolean hCv;
    private String hCx;
    private long hCy;
    private boolean hCz;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b hCs = null;
    private com.baidu.tbadk.core.dialog.a fnL = null;
    private boolean hCw = false;
    private int hCA = 1;
    private CustomMessageListener hCD = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.hCw = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hCE = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.hCt.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.hCs.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.hCs.isEmpty()) {
                        a.this.hCs.cl(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.hCt.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.hCt.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d hCF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bC(a.this.ezi.getErrorCode(), a.this.ezi.getErrorString())) {
                AntiHelper.bh(a.this.fsZ.getPageContext().getPageActivity(), a.this.ezi.getErrorString());
            } else if (obj != null) {
                a.this.hCt.nL(!StringUtils.isNull(a.this.hCx));
            } else if (!StringUtils.isNull(a.this.ezi.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.ezi.getErrorString());
            }
        }
    };
    private final EnterForumModel.b hCG = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.hCr != null) {
                if (aVar.type == 1) {
                    a.this.hCs.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.hCv = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.hFp;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.hCv) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.hFp;
                        a.this.hCt.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.fsZ.showToast(aVar.error);
                    a.this.hCs.wr(com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.hCy > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.hCy, a.this.hCt.cjs() - a.this.hCy, a.this.hCt.cjq(), a.this.hCt.cjr(), currentTimeMillis - a.this.hCt.cjp());
                    a.this.hCy = -1L;
                }
                String string = a.this.fsZ.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.hFp != null && aVar.hFp.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.hFp.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.chW() != null) {
                        string = hotSearchInfoData.chW();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.hFp != null && aVar.hFp.chR() != null) {
                    a.this.hCs.b(aVar.hFp.chR());
                }
            }
        }
    };
    private f.c evf = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.hCe.loadAd();
            a.this.hCt.nL(!StringUtils.isNull(a.this.hCx));
            a.this.hCu.LoadData();
            a.this.hCt.nK(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter hAu = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.hCt = null;
        this.isFirst = true;
        this.hCv = false;
        this.hCy = -1L;
        this.hCr = enterForumFragment;
        this.fsZ = enterForumFragment.getBaseFragmentActivity();
        this.hAu.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.cvW();
        this.hCy = System.currentTimeMillis();
        this.isFirst = true;
        this.hCv = false;
        this.hCx = "";
        this.hCt = new EnterForumModel(this.fsZ.getPageContext());
        this.hCu = new RecentlyVisitedForumModel();
        this.ezi = new LikeModel(this.fsZ.getPageContext());
        this.fLE = new com.baidu.tieba.ueg.d(this.fsZ.getPageContext());
        this.ezi.setLoadDataCallBack(this.hCF);
        this.hCt.a(this.hCG);
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cjn().m(this.hCr.getFragmentActivity(), l.getStatusBarHeight(this.hCr.getFragmentActivity()));
        initUI();
        initListener();
        ciU();
    }

    private void initListener() {
        ciT();
        this.hCr.registerListener(this.hCE);
        this.hCr.registerListener(this.hCD);
    }

    private void ciT() {
        this.hCr.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hCs != null && a.this.hCs.chI()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void ciU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<al>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<al> run(CustomMessage<al> customMessage) {
                al alVar = new al();
                ArrayList arrayList = new ArrayList();
                if (a.this.hCt != null && a.this.hCt.cjt() != null && a.this.hCt.cjt().chM() != null && y.getCount(a.this.hCt.cjt().chM().cii()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.hCt.cjt().chM().cii().iterator();
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
                    alVar.aO(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, alVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fsZ.getPageContext().getPageActivity());
            aVar.zV(String.format(this.fsZ.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.fsZ.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.fsZ.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.nF(R.color.cp_cont_b);
            aVar.b(this.fsZ.getPageContext());
            aVar.bia();
        }
    }

    public void nG(boolean z) {
        if (this.mWaitingDialog == null) {
            ciV();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void ciV() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.fsZ.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.fsZ.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.hCs = new com.baidu.tieba.enterForum.view.b(this.hCr, this.mRootView, this.hAu, this.hCu, this.hCt);
        this.hCs.setListPullRefreshListener(this.evf);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nH(boolean z) {
        if (this.hCs != null && this.hCr != null) {
            if (z) {
                if (this.hCr.isPrimary() && this.hCr.isResumed()) {
                    this.hCs.startPullRefresh();
                } else {
                    this.hCs.completeRefresh();
                }
            } else {
                this.hCs.completeRefresh();
            }
            this.hCs.nW(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.hCr.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.hCs != null) {
            if (dVar == null) {
                this.hCs.cl(this.mRootView);
                return;
            }
            g chM = dVar.chM();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (chM != null) {
                arrayList = chM.cii();
            }
            a(arrayList, dVar.chN());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.chW() != null) {
                setSearchHint(hotSearchInfoData.chW());
            }
            this.hCs.cku();
            this.hCs.wr(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.hCr.ciO() != null) {
            if (!StringUtils.isNull(str)) {
                this.hCr.ciO().setSearchHint(str.trim());
            } else {
                this.hCr.ciO().setSearchHint(this.fsZ.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.hCs.a(this.hCt.a(list, com.baidu.tbadk.util.f.bws()), bjVar, this.hCt.cjv());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.chP() != null && this.hCr.isPrimary() && this.fnL == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.fsZ.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.chP())) {
                this.fnL = new com.baidu.tbadk.core.dialog.a(this.fsZ.getActivity());
                this.fnL.nH(2);
                this.fnL.aZ(frsPrivateCommonDialogView);
                this.fnL.ie(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bkp().b(a.this.fsZ.getPageContext(), new String[]{dVar.chP().bez()});
                        a.this.fnL.dismiss();
                        a.this.fnL = null;
                    }
                });
                this.fnL.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.fnL = null;
                    }
                });
                this.fnL.b(this.fsZ.getPageContext()).bia();
            }
        }
    }

    private void ciW() {
        if (this.fnL != null) {
            this.fnL.dismiss();
            this.fnL = null;
        }
    }

    public void loadData() {
        if (this.hCs != null) {
            gi(false);
        }
    }

    public void ciX() {
        if (this.hCs != null) {
            gi(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cjn().destroy();
        if (this.hCs != null) {
            this.hCs.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.hCu != null) {
            this.hCu.onDestroy();
        }
        if (this.hCt != null) {
            this.hCt.onDestroy();
        }
        if (this.hAu != null) {
            this.hAu.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hCs != null) {
            this.hCs.onChangeSkinType(i);
        }
        if (this.hCB != null) {
            this.hCB.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.hCt != null) {
            this.hCt.cancelLoadData();
        }
    }

    public void gi(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.hCC && this.hCt != null && this.hCs != null) {
            String str = this.hCx;
            this.hCx = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.hCx == null || this.hCx.equals(str)) {
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
                if (this.hCt != null && this.hCt.cjt() != null && this.hCt.cjt().chM() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.hCt.cjt().chM().cii().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.wt(1);
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
                    com.baidu.tieba.tbadkCore.util.a.Rq(currentAccount);
                }
                this.hCs.nV(this.hCt.cjv());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.hCt != null) {
                        this.hCt.nM(StringUtils.isNull(this.hCx) ? false : true);
                    }
                    this.hCu.LoadData();
                } else if (z2 && this.hCt != null) {
                    this.hCt.nM(StringUtils.isNull(this.hCx) ? false : true);
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
        if (this.hCr.isAdded() && this.hCr.isPrimary()) {
            if (this.hCu != null) {
                this.hCu.onPrimary();
            }
        } else {
            ciW();
        }
        if (this.hCs != null) {
            this.hCs.onPrimary();
        }
    }

    public void onPause() {
        if (this.hCs != null && this.hCs.ckt() != null) {
            this.hCs.ckt().completePullRefresh();
        }
        if (this.hCu != null) {
            this.hCu.onPause();
        }
        if (this.hCt != null) {
            this.hCt.onPause();
        }
        if (this.hCs != null) {
            this.hCs.onPause();
        }
    }

    public void aKp() {
        if (this.hCs != null) {
            this.hCs.ck(this.mRootView);
        }
    }

    /* loaded from: classes21.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hCK;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.hCK = null;
            this.hCK = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hCK;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.bjL().bkq().mIsNeedTbs = true;
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
            a.this.nG(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
                    a.this.hCz = true;
                    if (a.this.hCr.isAdded() && a.this.fsZ != null) {
                        a.this.fsZ.showToast(a.this.fsZ.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.q(false, this.hCK.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.hCK.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.hCK.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.hCK.getName()));
                    }
                    a.this.hCs.a(this.hCK, a.this.hCt.cjv());
                    a.this.hCt.b(this.hCK);
                } else if (a.this.fsZ != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fsZ.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hCr.isAdded()) {
                        a.this.fsZ.showToast(a.this.fsZ.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.nG(true);
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
    private class C0666a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hCK;
        private aa mNetwork = null;

        public C0666a(com.baidu.tieba.enterForum.data.f fVar) {
            this.hCK = null;
            this.hCK = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hCK;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.chY() == 0) {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.bjL().bkq().mIsNeedTbs = true;
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
            super.onPostExecute((C0666a) str);
            a.this.nG(false);
            int chY = this.hCK.chY();
            if (this.mNetwork != null) {
                if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
                    a.this.hCz = true;
                    if (a.this.hCr.isAdded() && a.this.fsZ != null) {
                        a.this.fsZ.showToast(a.this.fsZ.getActivity().getString(chY > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.hCt.nL(true);
                } else if (a.this.fsZ != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fsZ.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hCr.isAdded()) {
                        a.this.fsZ.showToast(a.this.fsZ.getActivity().getString(chY > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.nG(true);
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
    public void q(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.cLQ().z(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int buz = bVar.buz();
        com.baidu.tbadk.mvc.b.a buA = bVar.buA();
        switch (buz) {
            case 1:
                if (this.hCA != 2 && (buA instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) buA).getName();
                    if (at.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.fsZ.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) buA).bsc() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) buA).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) buA).cid());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) buA).cic().night != null && ((com.baidu.tieba.enterForum.data.f) buA).cic().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) buA).cic().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) buA).cic().day != null && ((com.baidu.tieba.enterForum.data.f) buA).cic().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) buA).cic().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) buA).cig());
                            ((com.baidu.tieba.enterForum.data.f) buA).eI(0L);
                        }
                        this.fsZ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.fsZ.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new aq("c12888"));
                        }
                        TiebaStatic.log(new aq("c13368").u("uid", TbadkApplication.getCurrentAccountId()).ai("obj_type", this.hCt.cjt().getSortType() == 1 ? 2 : 1).dF("fid", ((com.baidu.tieba.enterForum.data.f) buA).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.hCA == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.hCz = false;
                if (this.hCr.getView() == null || this.hCr.getView().getParent() == null) {
                    return true;
                }
                this.hCr.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (buA instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) buA);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(this.fsZ.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fsZ.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.fsZ.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fsZ.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("c13367").dF("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dF("obj_type", "2").ai("obj_locate", 1));
                this.fsZ.finish();
                return true;
            case 9:
                if (this.hCs != null) {
                    this.hCs.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.hCA = 2;
                return true;
            case 11:
                this.hCA = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.hCA != 2) {
                    if (this.hCB == null) {
                        this.hCB = new com.baidu.tieba.enterForum.view.d(this.fsZ.getPageContext(), this.hAu);
                    }
                    if (buA instanceof com.baidu.tieba.enterForum.data.f) {
                        this.hCB.c((com.baidu.tieba.enterForum.data.f) buA);
                        this.hCB.NY();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (buA instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0666a((com.baidu.tieba.enterForum.data.f) buA).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new aq("c13370").ai("obj_type", ((com.baidu.tieba.enterForum.data.f) buA).chY() <= 0 ? 1 : 2).dF("fid", ((com.baidu.tieba.enterForum.data.f) buA).getId()).u("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                be.bkp().b(this.fsZ.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fLE.dEt() || !(buA instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                be.bkp().b(this.fsZ.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) buA).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.buB());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.buB());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.buB());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean buy() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.fsZ.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hCs != null) {
            this.hCs.setPageUniqueId(bdUniqueId);
        }
    }

    public void nI(boolean z) {
        int i;
        if (this.hCs != null && this.hCr != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hCs.setAdState(cVar);
        this.hCr.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b ciY() {
        return this.hCs;
    }
}
