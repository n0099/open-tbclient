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
    private LikeModel fpO;
    private com.baidu.tieba.ueg.d gGE;
    private BaseFragmentActivity gkF;
    private EnterForumFragment iHG;
    private EnterForumModel iHI;
    private RecentlyVisitedForumModel iHJ;
    private boolean iHK;
    private String iHM;
    private long iHN;
    private boolean iHO;
    private com.baidu.tieba.enterForum.view.d iHQ;
    private boolean iHR;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b iHH = null;
    private com.baidu.tbadk.core.dialog.a gfd = null;
    private boolean iHL = false;
    private int iHP = 1;
    private CustomMessageListener iHS = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.iHL = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iHT = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.iHI.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.iHH.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.iHH.isEmpty()) {
                        a.this.iHH.cT(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.iHI.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.iHI.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.e iHU = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bP(a.this.fpO.getErrorCode(), a.this.fpO.getErrorString())) {
                AntiHelper.bs(a.this.gkF.getPageContext().getPageActivity(), a.this.fpO.getErrorString());
            } else if (obj != null) {
                a.this.iHI.pN(!StringUtils.isNull(a.this.iHM));
            } else if (!StringUtils.isNull(a.this.fpO.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.fpO.getErrorString());
            }
        }
    };
    private final EnterForumModel.b iHV = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.iHG != null) {
                if (aVar.type == 1) {
                    a.this.iHH.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.iHK = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.iKE;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.iHK) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.iKE;
                        a.this.iHI.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.gkF.showToast(aVar.error);
                    a.this.iHH.yT(com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.iHN > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.iHN, a.this.iHI.czj() - a.this.iHN, a.this.iHI.czh(), a.this.iHI.czi(), currentTimeMillis - a.this.iHI.czg());
                    a.this.iHN = -1L;
                }
                String string = a.this.gkF.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.iKE != null && aVar.iKE.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.iKE.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.bvr().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.cxM() != null) {
                        string = hotSearchInfoData.cxM();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.iKE != null && aVar.iKE.cxH() != null) {
                    a.this.iHH.b(aVar.iKE.cxH());
                }
            }
        }
    };
    private f.c flR = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.iHt.loadAd();
            a.this.iHI.pN(!StringUtils.isNull(a.this.iHM));
            a.this.iHJ.LoadData();
            a.this.iHI.pM(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter iFJ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.iHI = null;
        this.isFirst = true;
        this.iHK = false;
        this.iHN = -1L;
        this.iHG = enterForumFragment;
        this.gkF = enterForumFragment.getBaseFragmentActivity();
        this.iFJ.addEventDelegate(this);
        com.baidu.tieba.frs.c.d.cMW();
        this.iHN = System.currentTimeMillis();
        this.isFirst = true;
        this.iHK = false;
        this.iHM = "";
        this.iHI = new EnterForumModel(this.gkF.getPageContext());
        this.iHJ = new RecentlyVisitedForumModel();
        this.fpO = new LikeModel(this.gkF.getPageContext());
        this.gGE = new com.baidu.tieba.ueg.d(this.gkF.getPageContext());
        this.fpO.setLoadDataCallBack(this.iHU);
        this.iHI.a(this.iHV);
        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cze().w(this.iHG.getFragmentActivity(), l.getStatusBarHeight(this.iHG.getFragmentActivity()));
        initUI();
        initListener();
        cyL();
    }

    private void initListener() {
        cyK();
        this.iHG.registerListener(this.iHT);
        this.iHG.registerListener(this.iHS);
    }

    private void cyK() {
        this.iHG.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.iHH != null && a.this.iHH.cxy()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void cyL() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<an>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<an> run(CustomMessage<an> customMessage) {
                an anVar = new an();
                ArrayList arrayList = new ArrayList();
                if (a.this.iHI != null && a.this.iHI.czk() != null && a.this.iHI.czk().cxC() != null && x.getCount(a.this.iHI.czk().cxC().cxY()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.iHI.czk().cxC().cxY().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gkF.getPageContext().getPageActivity());
            aVar.Bo(String.format(this.gkF.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.gkF.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.gkF.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.pb(R.color.CAM_X0105);
            aVar.b(this.gkF.getPageContext());
            aVar.btY();
        }
    }

    public void pI(boolean z) {
        if (this.mWaitingDialog == null) {
            cyM();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void cyM() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.gkF.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.gkF.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.iHH = new com.baidu.tieba.enterForum.view.b(this.iHG, this.mRootView, this.iFJ, this.iHJ, this.iHI);
        this.iHH.setListPullRefreshListener(this.flR);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pJ(boolean z) {
        if (this.iHH != null && this.iHG != null) {
            if (z) {
                if (this.iHG.isPrimary() && this.iHG.isResumed()) {
                    this.iHH.startPullRefresh();
                } else {
                    this.iHH.completeRefresh();
                }
            } else {
                this.iHH.completeRefresh();
            }
            this.iHH.pY(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.iHG.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.iHH != null) {
            if (dVar == null) {
                this.iHH.cT(this.mRootView);
                return;
            }
            g cxC = dVar.cxC();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cxC != null) {
                arrayList = cxC.cxY();
            }
            a(arrayList, dVar.cxD());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bvr().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.cxM() != null) {
                setSearchHint(hotSearchInfoData.cxM());
            }
            this.iHH.cAl();
            this.iHH.yT(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.iHG.cyF() != null) {
            if (!StringUtils.isNull(str)) {
                this.iHG.cyF().setSearchHint(str.trim());
            } else {
                this.iHG.cyF().setSearchHint(this.gkF.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bm bmVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.iHH.a(this.iHI.a(list, com.baidu.tbadk.util.e.bIJ()), bmVar, this.iHI.czm());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.cxF() != null && this.iHG.isPrimary() && this.gfd == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.gkF.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.cxF())) {
                this.gfd = new com.baidu.tbadk.core.dialog.a(this.gkF.getActivity());
                this.gfd.pd(2);
                this.gfd.br(frsPrivateCommonDialogView);
                this.gfd.jI(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bwv().b(a.this.gkF.getPageContext(), new String[]{dVar.cxF().bqr()});
                        a.this.gfd.dismiss();
                        a.this.gfd = null;
                    }
                });
                this.gfd.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.gfd = null;
                    }
                });
                this.gfd.b(this.gkF.getPageContext()).btY();
            }
        }
    }

    private void cyN() {
        if (this.gfd != null) {
            this.gfd.dismiss();
            this.gfd = null;
        }
    }

    public void loadData() {
        if (this.iHH != null) {
            hK(false);
        }
    }

    public void cyO() {
        if (this.iHH != null) {
            hK(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cze().destroy();
        if (this.iHH != null) {
            this.iHH.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.iHJ != null) {
            this.iHJ.onDestroy();
        }
        if (this.iHI != null) {
            this.iHI.onDestroy();
        }
        if (this.iFJ != null) {
            this.iFJ.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iHH != null) {
            this.iHH.onChangeSkinType(i);
        }
        if (this.iHQ != null) {
            this.iHQ.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.iHI != null) {
            this.iHI.cancelLoadData();
        }
    }

    public void hK(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.iHR && this.iHI != null && this.iHH != null) {
            String str = this.iHM;
            this.iHM = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.iHM == null || this.iHM.equals(str)) {
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
                if (this.iHI != null && this.iHI.czk() != null && this.iHI.czk().cxC() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.iHI.czk().cxC().cxY().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.yV(1);
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
                    com.baidu.tieba.tbadkCore.util.a.TD(currentAccount);
                }
                this.iHH.pX(this.iHI.czm());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.iHI != null) {
                        this.iHI.pO(StringUtils.isNull(this.iHM) ? false : true);
                    }
                    this.iHJ.LoadData();
                } else if (z2 && this.iHI != null) {
                    this.iHI.pO(StringUtils.isNull(this.iHM) ? false : true);
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
        if (this.iHG.isAdded() && this.iHG.isPrimary()) {
            if (this.iHJ != null) {
                this.iHJ.onPrimary();
            }
        } else {
            cyN();
        }
        if (this.iHH != null) {
            this.iHH.onPrimary();
        }
    }

    public void onPause() {
        if (this.iHH != null && this.iHH.cAk() != null) {
            this.iHH.cAk().completePullRefresh();
        }
        if (this.iHJ != null) {
            this.iHJ.onPause();
        }
        if (this.iHI != null) {
            this.iHI.onPause();
        }
        if (this.iHH != null) {
            this.iHH.onPause();
        }
    }

    public void aWk() {
        if (this.iHH != null) {
            this.iHH.cS(this.mRootView);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f iHZ;
        private z mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.iHZ = null;
            this.iHZ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.iHZ;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.bvR().bwA().mIsNeedTbs = true;
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
            a.this.pI(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.bvR().bwB().isRequestSuccess()) {
                    a.this.iHO = true;
                    if (a.this.iHG.isAdded() && a.this.gkF != null) {
                        a.this.gkF.showToast(a.this.gkF.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.s(false, this.iHZ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.iHZ.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.iHZ.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.iHZ.getName()));
                    }
                    a.this.iHH.a(this.iHZ, a.this.iHI.czm());
                    a.this.iHI.b(this.iHZ);
                } else if (a.this.gkF != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gkF.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iHG.isAdded()) {
                        a.this.gkF.showToast(a.this.gkF.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.pI(true);
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
    private class C0722a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f iHZ;
        private z mNetwork = null;

        public C0722a(com.baidu.tieba.enterForum.data.f fVar) {
            this.iHZ = null;
            this.iHZ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.iHZ;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.cxO() == 0) {
                            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.bvR().bwA().mIsNeedTbs = true;
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
            super.onPostExecute((C0722a) str);
            a.this.pI(false);
            int cxO = this.iHZ.cxO();
            if (this.mNetwork != null) {
                if (this.mNetwork.bvR().bwB().isRequestSuccess()) {
                    a.this.iHO = true;
                    if (a.this.iHG.isAdded() && a.this.gkF != null) {
                        a.this.gkF.showToast(a.this.gkF.getActivity().getString(cxO > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.iHI.pN(true);
                } else if (a.this.gkF != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gkF.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iHG.isAdded()) {
                        a.this.gkF.showToast(a.this.gkF.getActivity().getString(cxO > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.pI(true);
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
                    com.baidu.tieba.im.settingcache.d.cZN().D(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bGO = bVar.bGO();
        com.baidu.tbadk.mvc.b.a bGP = bVar.bGP();
        switch (bGO) {
            case 1:
                if (this.iHP != 2 && (bGP instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bGP).getName();
                    if (at.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.gkF.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bGP).bEq() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bGP).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bGP).cxT());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bGP).cxS().night != null && ((com.baidu.tieba.enterForum.data.f) bGP).cxS().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bGP).cxS().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bGP).cxS().day != null && ((com.baidu.tieba.enterForum.data.f) bGP).cxS().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bGP).cxS().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bGP).cxW());
                            ((com.baidu.tieba.enterForum.data.f) bGP).gd(0L);
                        }
                        this.gkF.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.gkF.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new aq("c12888"));
                        }
                        TiebaStatic.log(new aq("c13368").w("uid", TbadkApplication.getCurrentAccountId()).an("obj_type", this.iHI.czk().getSortType() == 1 ? 2 : 1).dX("fid", ((com.baidu.tieba.enterForum.data.f) bGP).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.iHP == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.iHO = false;
                if (this.iHG.getView() == null || this.iHG.getView().getParent() == null) {
                    return true;
                }
                this.iHG.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bGP instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bGP);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(this.gkF.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gkF.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.gkF.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gkF.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("c13367").dX("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dX("obj_type", "2").an("obj_locate", 1));
                this.gkF.finish();
                return true;
            case 9:
                if (this.iHH != null) {
                    this.iHH.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.iHP = 2;
                return true;
            case 11:
                this.iHP = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.iHP != 2) {
                    if (this.iHQ == null) {
                        this.iHQ = new com.baidu.tieba.enterForum.view.d(this.gkF.getPageContext(), this.iFJ);
                    }
                    if (bGP instanceof com.baidu.tieba.enterForum.data.f) {
                        this.iHQ.c((com.baidu.tieba.enterForum.data.f) bGP);
                        this.iHQ.SY();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bGP instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0722a((com.baidu.tieba.enterForum.data.f) bGP).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new aq("c13370").an("obj_type", ((com.baidu.tieba.enterForum.data.f) bGP).cxO() <= 0 ? 1 : 2).dX("fid", ((com.baidu.tieba.enterForum.data.f) bGP).getId()).w("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                be.bwv().b(this.gkF.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.gGE.dSZ() || !(bGP instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                be.bwv().b(this.gkF.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bGP).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bGQ());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bGQ());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bGQ());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bGN() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.gkF.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iHH != null) {
            this.iHH.setPageUniqueId(bdUniqueId);
        }
    }

    public void pK(boolean z) {
        int i;
        if (this.iHH != null && this.iHG != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iHH.setAdState(cVar);
        this.iHG.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b cyP() {
        return this.iHH;
    }
}
