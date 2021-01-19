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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
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
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel fle;
    private com.baidu.tieba.ueg.d gBY;
    private BaseFragmentActivity gfX;
    private EnterForumFragment iCZ;
    private EnterForumModel iDb;
    private RecentlyVisitedForumModel iDc;
    private boolean iDd;
    private String iDf;
    private long iDg;
    private boolean iDh;
    private com.baidu.tieba.enterForum.view.d iDj;
    private boolean iDk;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b iDa = null;
    private com.baidu.tbadk.core.dialog.a gau = null;
    private boolean iDe = false;
    private int iDi = 1;
    private CustomMessageListener iDl = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.iDe = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iDm = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.iDb.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.iDa.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.iDa.isEmpty()) {
                        a.this.iDa.cT(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.iDb.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.iDb.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.e iDn = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bQ(a.this.fle.getErrorCode(), a.this.fle.getErrorString())) {
                AntiHelper.bs(a.this.gfX.getPageContext().getPageActivity(), a.this.fle.getErrorString());
            } else if (obj != null) {
                a.this.iDb.pJ(!StringUtils.isNull(a.this.iDf));
            } else if (!StringUtils.isNull(a.this.fle.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.fle.getErrorString());
            }
        }
    };
    private final EnterForumModel.b iDo = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.iCZ != null) {
                if (aVar.type == 1) {
                    a.this.iDa.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.iDd = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.iFX;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.iDd) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.iFX;
                        a.this.iDb.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.gfX.showToast(aVar.error);
                    a.this.iDa.xn(com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.iDg > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.iDg, a.this.iDb.cvr() - a.this.iDg, a.this.iDb.cvp(), a.this.iDb.cvq(), currentTimeMillis - a.this.iDb.cvo());
                    a.this.iDg = -1L;
                }
                String string = a.this.gfX.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.iFX != null && aVar.iFX.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.iFX.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.brx().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.ctU() != null) {
                        string = hotSearchInfoData.ctU();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.iFX != null && aVar.iFX.ctP() != null) {
                    a.this.iDa.b(aVar.iFX.ctP());
                }
            }
        }
    };
    private f.c fhg = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.iCM.loadAd();
            a.this.iDb.pJ(!StringUtils.isNull(a.this.iDf));
            a.this.iDc.LoadData();
            a.this.iDb.pI(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter iBc = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.iDb = null;
        this.isFirst = true;
        this.iDd = false;
        this.iDg = -1L;
        this.iCZ = enterForumFragment;
        this.gfX = enterForumFragment.getBaseFragmentActivity();
        this.iBc.addEventDelegate(this);
        com.baidu.tieba.frs.c.d.cJe();
        this.iDg = System.currentTimeMillis();
        this.isFirst = true;
        this.iDd = false;
        this.iDf = "";
        this.iDb = new EnterForumModel(this.gfX.getPageContext());
        this.iDc = new RecentlyVisitedForumModel();
        this.fle = new LikeModel(this.gfX.getPageContext());
        this.gBY = new com.baidu.tieba.ueg.d(this.gfX.getPageContext());
        this.fle.setLoadDataCallBack(this.iDn);
        this.iDb.a(this.iDo);
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cvm().w(this.iCZ.getFragmentActivity(), l.getStatusBarHeight(this.iCZ.getFragmentActivity()));
        initUI();
        initListener();
        cuT();
    }

    private void initListener() {
        cuS();
        this.iCZ.registerListener(this.iDm);
        this.iCZ.registerListener(this.iDl);
    }

    private void cuS() {
        this.iCZ.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.iDa != null && a.this.iDa.ctG()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void cuT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<an>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<an> run(CustomMessage<an> customMessage) {
                an anVar = new an();
                ArrayList arrayList = new ArrayList();
                if (a.this.iDb != null && a.this.iDb.cvs() != null && a.this.iDb.cvs().ctK() != null && x.getCount(a.this.iDb.cvs().ctK().cug()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.iDb.cvs().ctK().cug().iterator();
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
                    anVar.bs(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, anVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gfX.getPageContext().getPageActivity());
            aVar.Ad(String.format(this.gfX.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.gfX.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.gfX.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.nv(R.color.CAM_X0105);
            aVar.b(this.gfX.getPageContext());
            aVar.bqe();
        }
    }

    public void pE(boolean z) {
        if (this.mWaitingDialog == null) {
            cuU();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void cuU() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.gfX.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.gfX.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.iDa = new com.baidu.tieba.enterForum.view.b(this.iCZ, this.mRootView, this.iBc, this.iDc, this.iDb);
        this.iDa.setListPullRefreshListener(this.fhg);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pF(boolean z) {
        if (this.iDa != null && this.iCZ != null) {
            if (z) {
                if (this.iCZ.isPrimary() && this.iCZ.isResumed()) {
                    this.iDa.startPullRefresh();
                } else {
                    this.iDa.completeRefresh();
                }
            } else {
                this.iDa.completeRefresh();
            }
            this.iDa.pU(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.iCZ.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.iDa != null) {
            if (dVar == null) {
                this.iDa.cT(this.mRootView);
                return;
            }
            g ctK = dVar.ctK();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (ctK != null) {
                arrayList = ctK.cug();
            }
            a(arrayList, dVar.ctL());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.ctU() != null) {
                setSearchHint(hotSearchInfoData.ctU());
            }
            this.iDa.cwt();
            this.iDa.xn(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.iCZ.cuN() != null) {
            if (!StringUtils.isNull(str)) {
                this.iCZ.cuN().setSearchHint(str.trim());
            } else {
                this.iCZ.cuN().setSearchHint(this.gfX.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bm bmVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.iDa.a(this.iDb.a(list, com.baidu.tbadk.util.e.bER()), bmVar, this.iDb.cvu());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.ctN() != null && this.iCZ.isPrimary() && this.gau == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.gfX.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.ctN())) {
                this.gau = new com.baidu.tbadk.core.dialog.a(this.gfX.getActivity());
                this.gau.nx(2);
                this.gau.br(frsPrivateCommonDialogView);
                this.gau.jE(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bsB().b(a.this.gfX.getPageContext(), new String[]{dVar.ctN().bmx()});
                        a.this.gau.dismiss();
                        a.this.gau = null;
                    }
                });
                this.gau.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.gau = null;
                    }
                });
                this.gau.b(this.gfX.getPageContext()).bqe();
            }
        }
    }

    private void cuV() {
        if (this.gau != null) {
            this.gau.dismiss();
            this.gau = null;
        }
    }

    public void loadData() {
        if (this.iDa != null) {
            hG(false);
        }
    }

    public void cuW() {
        if (this.iDa != null) {
            hG(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cvm().destroy();
        if (this.iDa != null) {
            this.iDa.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.iDc != null) {
            this.iDc.onDestroy();
        }
        if (this.iDb != null) {
            this.iDb.onDestroy();
        }
        if (this.iBc != null) {
            this.iBc.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iDa != null) {
            this.iDa.onChangeSkinType(i);
        }
        if (this.iDj != null) {
            this.iDj.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.iDb != null) {
            this.iDb.cancelLoadData();
        }
    }

    public void hG(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.iDk && this.iDb != null && this.iDa != null) {
            String str = this.iDf;
            this.iDf = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.iDf == null || this.iDf.equals(str)) {
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
                if (this.iDb != null && this.iDb.cvs() != null && this.iDb.cvs().ctK() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.iDb.cvs().ctK().cug().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.xp(1);
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
                    com.baidu.tieba.tbadkCore.util.a.Sw(currentAccount);
                }
                this.iDa.pT(this.iDb.cvu());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.iDb != null) {
                        this.iDb.pK(StringUtils.isNull(this.iDf) ? false : true);
                    }
                    this.iDc.LoadData();
                } else if (z2 && this.iDb != null) {
                    this.iDb.pK(StringUtils.isNull(this.iDf) ? false : true);
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
        if (this.iCZ.isAdded() && this.iCZ.isPrimary()) {
            if (this.iDc != null) {
                this.iDc.onPrimary();
            }
        } else {
            cuV();
        }
        if (this.iDa != null) {
            this.iDa.onPrimary();
        }
    }

    public void onPause() {
        if (this.iDa != null && this.iDa.cws() != null) {
            this.iDa.cws().completePullRefresh();
        }
        if (this.iDc != null) {
            this.iDc.onPause();
        }
        if (this.iDb != null) {
            this.iDb.onPause();
        }
        if (this.iDa != null) {
            this.iDa.onPause();
        }
    }

    public void aSq() {
        if (this.iDa != null) {
            this.iDa.cS(this.mRootView);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f iDs;
        private z mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.iDs = null;
            this.iDs = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.iDs;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.brX().bsG().mIsNeedTbs = true;
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
            a.this.pE(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                    a.this.iDh = true;
                    if (a.this.iCZ.isAdded() && a.this.gfX != null) {
                        a.this.gfX.showToast(a.this.gfX.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.s(false, this.iDs.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.iDs.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.iDs.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.iDs.getName()));
                    }
                    a.this.iDa.a(this.iDs, a.this.iDb.cvu());
                    a.this.iDb.b(this.iDs);
                } else if (a.this.gfX != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gfX.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iCZ.isAdded()) {
                        a.this.gfX.showToast(a.this.gfX.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.pE(true);
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
    /* loaded from: classes2.dex */
    private class C0705a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f iDs;
        private z mNetwork = null;

        public C0705a(com.baidu.tieba.enterForum.data.f fVar) {
            this.iDs = null;
            this.iDs = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.iDs;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.ctW() == 0) {
                            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.brX().bsG().mIsNeedTbs = true;
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
            super.onPostExecute((C0705a) str);
            a.this.pE(false);
            int ctW = this.iDs.ctW();
            if (this.mNetwork != null) {
                if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                    a.this.iDh = true;
                    if (a.this.iCZ.isAdded() && a.this.gfX != null) {
                        a.this.gfX.showToast(a.this.gfX.getActivity().getString(ctW > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.iDb.pJ(true);
                } else if (a.this.gfX != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gfX.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iCZ.isAdded()) {
                        a.this.gfX.showToast(a.this.gfX.getActivity().getString(ctW > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.pE(true);
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
                    com.baidu.tieba.im.settingcache.d.cVV().D(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bCV = bVar.bCV();
        com.baidu.tbadk.mvc.b.a bCW = bVar.bCW();
        switch (bCV) {
            case 1:
                if (this.iDi != 2 && (bCW instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bCW).getName();
                    if (at.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.gfX.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bCW).bAw() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bCW).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bCW).cub());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bCW).cua().night != null && ((com.baidu.tieba.enterForum.data.f) bCW).cua().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bCW).cua().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bCW).cua().day != null && ((com.baidu.tieba.enterForum.data.f) bCW).cua().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bCW).cua().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bCW).cue());
                            ((com.baidu.tieba.enterForum.data.f) bCW).gd(0L);
                        }
                        this.gfX.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.gfX.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new aq("c12888"));
                        }
                        TiebaStatic.log(new aq("c13368").w("uid", TbadkApplication.getCurrentAccountId()).an("obj_type", this.iDb.cvs().getSortType() == 1 ? 2 : 1).dW("fid", ((com.baidu.tieba.enterForum.data.f) bCW).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.iDi == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.iDh = false;
                if (this.iCZ.getView() == null || this.iCZ.getView().getParent() == null) {
                    return true;
                }
                this.iCZ.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bCW instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bCW);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(this.gfX.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gfX.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.gfX.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gfX.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("c13367").dW("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dW("obj_type", "2").an("obj_locate", 1));
                this.gfX.finish();
                return true;
            case 9:
                if (this.iDa != null) {
                    this.iDa.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.iDi = 2;
                return true;
            case 11:
                this.iDi = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.iDi != 2) {
                    if (this.iDj == null) {
                        this.iDj = new com.baidu.tieba.enterForum.view.d(this.gfX.getPageContext(), this.iBc);
                    }
                    if (bCW instanceof com.baidu.tieba.enterForum.data.f) {
                        this.iDj.c((com.baidu.tieba.enterForum.data.f) bCW);
                        this.iDj.Pd();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bCW instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0705a((com.baidu.tieba.enterForum.data.f) bCW).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new aq("c13370").an("obj_type", ((com.baidu.tieba.enterForum.data.f) bCW).ctW() <= 0 ? 1 : 2).dW("fid", ((com.baidu.tieba.enterForum.data.f) bCW).getId()).w("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                be.bsB().b(this.gfX.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.gBY.dPh() || !(bCW instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                be.bsB().b(this.gfX.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bCW).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bCX());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bCX());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bCX());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bCU() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.gfX.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iDa != null) {
            this.iDa.setPageUniqueId(bdUniqueId);
        }
    }

    public void pG(boolean z) {
        int i;
        if (this.iDa != null && this.iCZ != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iDa.setAdState(cVar);
        this.iCZ.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b cuX() {
        return this.iDa;
    }
}
