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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bo;
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
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel foW;
    private com.baidu.tieba.ueg.d gGF;
    private BaseFragmentActivity gke;
    private EnterForumFragment iKG;
    private EnterForumModel iKI;
    private RecentlyVisitedForumModel iKJ;
    private boolean iKK;
    private String iKM;
    private long iKN;
    private boolean iKO;
    private com.baidu.tieba.enterForum.view.d iKQ;
    private boolean iKR;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b iKH = null;
    private com.baidu.tbadk.core.dialog.a ger = null;
    private boolean iKL = false;
    private int iKP = 1;
    private CustomMessageListener iKS = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.iKL = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iKT = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.iKI.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.iKH.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.iKH.isEmpty()) {
                        a.this.iKH.cR(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.iKI.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.iKI.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.e iKU = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bX(a.this.foW.getErrorCode(), a.this.foW.getErrorString())) {
                AntiHelper.bq(a.this.gke.getPageContext().getPageActivity(), a.this.foW.getErrorString());
            } else if (obj != null) {
                a.this.iKI.pT(!StringUtils.isNull(a.this.iKM));
            } else if (!StringUtils.isNull(a.this.foW.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.foW.getErrorString());
            }
        }
    };
    private final EnterForumModel.b iKV = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.iKG != null) {
                if (aVar.type == 1) {
                    a.this.iKH.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.iKK = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.iND;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.iKK) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.iND;
                        a.this.iKI.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.gke.showToast(aVar.error);
                    a.this.iKH.xy(com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.iKN > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.iKN, a.this.iKI.cwQ() - a.this.iKN, a.this.iKI.cwO(), a.this.iKI.cwP(), currentTimeMillis - a.this.iKI.cwN());
                    a.this.iKN = -1L;
                }
                String string = a.this.gke.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.iND != null && aVar.iND.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.iND.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.brR().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.cvt() != null) {
                        string = hotSearchInfoData.cvt();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.iND != null && aVar.iND.cvo() != null) {
                    a.this.iKH.b(aVar.iND.cvo());
                }
            }
        }
    };
    private f.c fkY = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.iKt.loadAd();
            a.this.iKI.pT(!StringUtils.isNull(a.this.iKM));
            a.this.iKJ.LoadData();
            a.this.iKI.pS(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter iIJ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.iKI = null;
        this.isFirst = true;
        this.iKK = false;
        this.iKN = -1L;
        this.iKG = enterForumFragment;
        this.gke = enterForumFragment.getBaseFragmentActivity();
        this.iIJ.addEventDelegate(this);
        com.baidu.tieba.frs.c.d.cKE();
        this.iKN = System.currentTimeMillis();
        this.isFirst = true;
        this.iKK = false;
        this.iKM = "";
        this.iKI = new EnterForumModel(this.gke.getPageContext());
        this.iKJ = new RecentlyVisitedForumModel();
        this.foW = new LikeModel(this.gke.getPageContext());
        this.gGF = new com.baidu.tieba.ueg.d(this.gke.getPageContext());
        this.foW.setLoadDataCallBack(this.iKU);
        this.iKI.a(this.iKV);
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cwL().w(this.iKG.getFragmentActivity(), l.getStatusBarHeight(this.iKG.getFragmentActivity()));
        initUI();
        initListener();
        cws();
    }

    private void initListener() {
        cwr();
        this.iKG.registerListener(this.iKT);
        this.iKG.registerListener(this.iKS);
    }

    private void cwr() {
        this.iKG.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.iKH != null && a.this.iKH.cvf()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void cws() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ao>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ao> run(CustomMessage<ao> customMessage) {
                ao aoVar = new ao();
                ArrayList arrayList = new ArrayList();
                if (a.this.iKI != null && a.this.iKI.cwR() != null && a.this.iKI.cwR().cvj() != null && y.getCount(a.this.iKI.cwR().cvj().cvF()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.iKI.cwR().cvj().cvF().iterator();
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
                    aoVar.bn(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, aoVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gke.getPageContext().getPageActivity());
            aVar.AB(String.format(this.gke.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.gke.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.gke.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.nz(R.color.CAM_X0105);
            aVar.b(this.gke.getPageContext());
            aVar.bqz();
        }
    }

    public void pO(boolean z) {
        if (this.mWaitingDialog == null) {
            cwt();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void cwt() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.gke.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.gke.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.iKH = new com.baidu.tieba.enterForum.view.b(this.iKG, this.mRootView, this.iIJ, this.iKJ, this.iKI);
        this.iKH.setListPullRefreshListener(this.fkY);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pP(boolean z) {
        if (this.iKH != null && this.iKG != null) {
            if (z) {
                if (this.iKG.isPrimary() && this.iKG.isResumed()) {
                    this.iKH.startPullRefresh();
                } else {
                    this.iKH.completeRefresh();
                }
            } else {
                this.iKH.completeRefresh();
            }
            this.iKH.qe(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.iKG.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.iKH != null) {
            if (dVar == null) {
                this.iKH.cR(this.mRootView);
                return;
            }
            g cvj = dVar.cvj();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cvj != null) {
                arrayList = cvj.cvF();
            }
            a(arrayList, dVar.cvk());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.brR().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.cvt() != null) {
                setSearchHint(hotSearchInfoData.cvt());
            }
            this.iKH.cxS();
            this.iKH.xy(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.iKG.cwm() != null) {
            if (!StringUtils.isNull(str)) {
                this.iKG.cwm().setSearchHint(str.trim());
            } else {
                this.iKG.cwm().setSearchHint(this.gke.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bo boVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.iKH.a(this.iKI.a(list, com.baidu.tbadk.util.f.bFo()), boVar, this.iKI.cwT());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.cvm() != null && this.iKG.isPrimary() && this.ger == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.gke.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.cvm())) {
                this.ger = new com.baidu.tbadk.core.dialog.a(this.gke.getActivity());
                this.ger.nB(2);
                this.ger.bn(frsPrivateCommonDialogView);
                this.ger.jG(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bsY().b(a.this.gke.getPageContext(), new String[]{dVar.cvm().bmS()});
                        a.this.ger.dismiss();
                        a.this.ger = null;
                    }
                });
                this.ger.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.ger = null;
                    }
                });
                this.ger.b(this.gke.getPageContext()).bqz();
            }
        }
    }

    private void cwu() {
        if (this.ger != null) {
            this.ger.dismiss();
            this.ger = null;
        }
    }

    public void loadData() {
        if (this.iKH != null) {
            hI(false);
        }
    }

    public void cwv() {
        if (this.iKH != null) {
            hI(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cwL().destroy();
        if (this.iKH != null) {
            this.iKH.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.iKJ != null) {
            this.iKJ.onDestroy();
        }
        if (this.iKI != null) {
            this.iKI.onDestroy();
        }
        if (this.iIJ != null) {
            this.iIJ.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iKH != null) {
            this.iKH.onChangeSkinType(i);
        }
        if (this.iKQ != null) {
            this.iKQ.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.iKI != null) {
            this.iKI.cancelLoadData();
        }
    }

    public void hI(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.iKR && this.iKI != null && this.iKH != null) {
            String str = this.iKM;
            this.iKM = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.iKM == null || this.iKM.equals(str)) {
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
                if (this.iKI != null && this.iKI.cwR() != null && this.iKI.cwR().cvj() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.iKI.cwR().cvj().cvF().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.xA(1);
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
                    com.baidu.tieba.tbadkCore.util.a.TM(currentAccount);
                }
                this.iKH.qd(this.iKI.cwT());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.iKI != null) {
                        this.iKI.pU(StringUtils.isNull(this.iKM) ? false : true);
                    }
                    this.iKJ.LoadData();
                } else if (z2 && this.iKI != null) {
                    this.iKI.pU(StringUtils.isNull(this.iKM) ? false : true);
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
        if (this.iKG.isAdded() && this.iKG.isPrimary()) {
            if (this.iKJ != null) {
                this.iKJ.onPrimary();
            }
        } else {
            cwu();
        }
        if (this.iKH != null) {
            this.iKH.onPrimary();
        }
    }

    public void onPause() {
        if (this.iKH != null && this.iKH.cxR() != null) {
            this.iKH.cxR().completePullRefresh();
        }
        if (this.iKJ != null) {
            this.iKJ.onPause();
        }
        if (this.iKI != null) {
            this.iKI.onPause();
        }
        if (this.iKH != null) {
            this.iKH.onPause();
        }
    }

    public void aSF() {
        if (this.iKH != null) {
            this.iKH.cQ(this.mRootView);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f iKZ;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.iKZ = null;
            this.iKZ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.iKZ;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.bsu().btd().mIsNeedTbs = true;
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
            a.this.pO(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.bsu().bte().isRequestSuccess()) {
                    a.this.iKO = true;
                    if (a.this.iKG.isAdded() && a.this.gke != null) {
                        a.this.gke.showToast(a.this.gke.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.z(false, this.iKZ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.iKZ.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.iKZ.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.iKZ.getName()));
                    }
                    a.this.iKH.a(this.iKZ, a.this.iKI.cwT());
                    a.this.iKI.b(this.iKZ);
                } else if (a.this.gke != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gke.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iKG.isAdded()) {
                        a.this.gke.showToast(a.this.gke.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.pO(true);
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
    private class C0712a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f iKZ;
        private aa mNetwork = null;

        public C0712a(com.baidu.tieba.enterForum.data.f fVar) {
            this.iKZ = null;
            this.iKZ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.iKZ;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.cvv() == 0) {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.bsu().btd().mIsNeedTbs = true;
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
            super.onPostExecute((C0712a) str);
            a.this.pO(false);
            int cvv = this.iKZ.cvv();
            if (this.mNetwork != null) {
                if (this.mNetwork.bsu().bte().isRequestSuccess()) {
                    a.this.iKO = true;
                    if (a.this.iKG.isAdded() && a.this.gke != null) {
                        a.this.gke.showToast(a.this.gke.getActivity().getString(cvv > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.iKI.pT(true);
                } else if (a.this.gke != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gke.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iKG.isAdded()) {
                        a.this.gke.showToast(a.this.gke.getActivity().getString(cvv > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.pO(true);
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
    public void z(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.cYh().D(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bDq = bVar.bDq();
        com.baidu.tbadk.mvc.b.a bDr = bVar.bDr();
        switch (bDq) {
            case 1:
                if (this.iKP != 2 && (bDr instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bDr).getName();
                    if (au.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.gke.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bDr).bAR() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bDr).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bDr).cvA());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bDr).cvz().night != null && ((com.baidu.tieba.enterForum.data.f) bDr).cvz().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bDr).cvz().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bDr).cvz().day != null && ((com.baidu.tieba.enterForum.data.f) bDr).cvz().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bDr).cvz().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bDr).cvD());
                            ((com.baidu.tieba.enterForum.data.f) bDr).gi(0L);
                        }
                        this.gke.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.gke.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new ar("c12888"));
                        }
                        TiebaStatic.log(new ar("c13368").v("uid", TbadkApplication.getCurrentAccountId()).aq("obj_type", this.iKI.cwR().getSortType() == 1 ? 2 : 1).dR("fid", ((com.baidu.tieba.enterForum.data.f) bDr).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.iKP == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.iKO = false;
                if (this.iKG.getView() == null || this.iKG.getView().getParent() == null) {
                    return true;
                }
                this.iKG.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bDr instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bDr);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(this.gke.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gke.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ar("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.gke.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gke.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ar("c13367").dR("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dR("obj_type", "2").aq("obj_locate", 1));
                this.gke.finish();
                return true;
            case 9:
                if (this.iKH != null) {
                    this.iKH.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.iKP = 2;
                return true;
            case 11:
                this.iKP = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.iKP != 2) {
                    if (this.iKQ == null) {
                        this.iKQ = new com.baidu.tieba.enterForum.view.d(this.gke.getPageContext(), this.iIJ);
                    }
                    if (bDr instanceof com.baidu.tieba.enterForum.data.f) {
                        this.iKQ.c((com.baidu.tieba.enterForum.data.f) bDr);
                        this.iKQ.QH();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bDr instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0712a((com.baidu.tieba.enterForum.data.f) bDr).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new ar("c13370").aq("obj_type", ((com.baidu.tieba.enterForum.data.f) bDr).cvv() <= 0 ? 1 : 2).dR("fid", ((com.baidu.tieba.enterForum.data.f) bDr).getId()).v("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                bf.bsY().b(this.gke.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.gGF.dRI() || !(bDr instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                bf.bsY().b(this.gke.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bDr).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bDs());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bDs());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bDs());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bDp() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.gke.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iKH != null) {
            this.iKH.setPageUniqueId(bdUniqueId);
        }
    }

    public void pQ(boolean z) {
        int i;
        if (this.iKH != null && this.iKG != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iKH.setAdState(cVar);
        this.iKG.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b cww() {
        return this.iKH;
    }
}
