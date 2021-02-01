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
    private LikeModel fnw;
    private com.baidu.tieba.ueg.d gEI;
    private BaseFragmentActivity gin;
    private EnterForumFragment iIJ;
    private EnterForumModel iIL;
    private RecentlyVisitedForumModel iIM;
    private boolean iIN;
    private String iIP;
    private long iIQ;
    private boolean iIR;
    private com.baidu.tieba.enterForum.view.d iIT;
    private boolean iIU;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b iIK = null;
    private com.baidu.tbadk.core.dialog.a gcL = null;
    private boolean iIO = false;
    private int iIS = 1;
    private CustomMessageListener iIV = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.iIO = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iIW = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.iIL.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.iIK.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.iIK.isEmpty()) {
                        a.this.iIK.cR(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.iIL.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.iIL.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.e iIX = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bX(a.this.fnw.getErrorCode(), a.this.fnw.getErrorString())) {
                AntiHelper.br(a.this.gin.getPageContext().getPageActivity(), a.this.fnw.getErrorString());
            } else if (obj != null) {
                a.this.iIL.pT(!StringUtils.isNull(a.this.iIP));
            } else if (!StringUtils.isNull(a.this.fnw.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.fnw.getErrorString());
            }
        }
    };
    private final EnterForumModel.b iIY = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.iIJ != null) {
                if (aVar.type == 1) {
                    a.this.iIK.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.iIN = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.iLG;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.iIN) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.iLG;
                        a.this.iIL.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.gin.showToast(aVar.error);
                    a.this.iIK.xx(com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.iIQ > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.iIQ, a.this.iIL.cwD() - a.this.iIQ, a.this.iIL.cwB(), a.this.iIL.cwC(), currentTimeMillis - a.this.iIL.cwA());
                    a.this.iIQ = -1L;
                }
                String string = a.this.gin.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.iLG != null && aVar.iLG.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.iLG.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.cvg() != null) {
                        string = hotSearchInfoData.cvg();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.iLG != null && aVar.iLG.cvb() != null) {
                    a.this.iIK.b(aVar.iLG.cvb());
                }
            }
        }
    };
    private f.c fjz = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.iIw.loadAd();
            a.this.iIL.pT(!StringUtils.isNull(a.this.iIP));
            a.this.iIM.LoadData();
            a.this.iIL.pS(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter iGM = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.iIL = null;
        this.isFirst = true;
        this.iIN = false;
        this.iIQ = -1L;
        this.iIJ = enterForumFragment;
        this.gin = enterForumFragment.getBaseFragmentActivity();
        this.iGM.addEventDelegate(this);
        com.baidu.tieba.frs.c.d.cKr();
        this.iIQ = System.currentTimeMillis();
        this.isFirst = true;
        this.iIN = false;
        this.iIP = "";
        this.iIL = new EnterForumModel(this.gin.getPageContext());
        this.iIM = new RecentlyVisitedForumModel();
        this.fnw = new LikeModel(this.gin.getPageContext());
        this.gEI = new com.baidu.tieba.ueg.d(this.gin.getPageContext());
        this.fnw.setLoadDataCallBack(this.iIX);
        this.iIL.a(this.iIY);
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cwy().w(this.iIJ.getFragmentActivity(), l.getStatusBarHeight(this.iIJ.getFragmentActivity()));
        initUI();
        initListener();
        cwf();
    }

    private void initListener() {
        cwe();
        this.iIJ.registerListener(this.iIW);
        this.iIJ.registerListener(this.iIV);
    }

    private void cwe() {
        this.iIJ.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.iIK != null && a.this.iIK.cuS()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void cwf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ao>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ao> run(CustomMessage<ao> customMessage) {
                ao aoVar = new ao();
                ArrayList arrayList = new ArrayList();
                if (a.this.iIL != null && a.this.iIL.cwE() != null && a.this.iIL.cwE().cuW() != null && y.getCount(a.this.iIL.cwE().cuW().cvs()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.iIL.cwE().cuW().cvs().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gin.getPageContext().getPageActivity());
            aVar.Au(String.format(this.gin.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.gin.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.gin.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ny(R.color.CAM_X0105);
            aVar.b(this.gin.getPageContext());
            aVar.bqx();
        }
    }

    public void pO(boolean z) {
        if (this.mWaitingDialog == null) {
            cwg();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void cwg() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.gin.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.gin.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.iIK = new com.baidu.tieba.enterForum.view.b(this.iIJ, this.mRootView, this.iGM, this.iIM, this.iIL);
        this.iIK.setListPullRefreshListener(this.fjz);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pP(boolean z) {
        if (this.iIK != null && this.iIJ != null) {
            if (z) {
                if (this.iIJ.isPrimary() && this.iIJ.isResumed()) {
                    this.iIK.startPullRefresh();
                } else {
                    this.iIK.completeRefresh();
                }
            } else {
                this.iIK.completeRefresh();
            }
            this.iIK.qe(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.iIJ.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.iIK != null) {
            if (dVar == null) {
                this.iIK.cR(this.mRootView);
                return;
            }
            g cuW = dVar.cuW();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cuW != null) {
                arrayList = cuW.cvs();
            }
            a(arrayList, dVar.cuX());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.cvg() != null) {
                setSearchHint(hotSearchInfoData.cvg());
            }
            this.iIK.cxF();
            this.iIK.xx(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.iIJ.cvZ() != null) {
            if (!StringUtils.isNull(str)) {
                this.iIJ.cvZ().setSearchHint(str.trim());
            } else {
                this.iIJ.cvZ().setSearchHint(this.gin.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bo boVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.iIK.a(this.iIL.a(list, com.baidu.tbadk.util.f.bFk()), boVar, this.iIL.cwG());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.cuZ() != null && this.iIJ.isPrimary() && this.gcL == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.gin.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.cuZ())) {
                this.gcL = new com.baidu.tbadk.core.dialog.a(this.gin.getActivity());
                this.gcL.nA(2);
                this.gcL.bn(frsPrivateCommonDialogView);
                this.gcL.jG(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bsV().b(a.this.gin.getPageContext(), new String[]{dVar.cuZ().bmQ()});
                        a.this.gcL.dismiss();
                        a.this.gcL = null;
                    }
                });
                this.gcL.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.gcL = null;
                    }
                });
                this.gcL.b(this.gin.getPageContext()).bqx();
            }
        }
    }

    private void cwh() {
        if (this.gcL != null) {
            this.gcL.dismiss();
            this.gcL = null;
        }
    }

    public void loadData() {
        if (this.iIK != null) {
            hI(false);
        }
    }

    public void cwi() {
        if (this.iIK != null) {
            hI(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cwy().destroy();
        if (this.iIK != null) {
            this.iIK.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.iIM != null) {
            this.iIM.onDestroy();
        }
        if (this.iIL != null) {
            this.iIL.onDestroy();
        }
        if (this.iGM != null) {
            this.iGM.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iIK != null) {
            this.iIK.onChangeSkinType(i);
        }
        if (this.iIT != null) {
            this.iIT.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.iIL != null) {
            this.iIL.cancelLoadData();
        }
    }

    public void hI(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.iIU && this.iIL != null && this.iIK != null) {
            String str = this.iIP;
            this.iIP = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.iIP == null || this.iIP.equals(str)) {
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
                if (this.iIL != null && this.iIL.cwE() != null && this.iIL.cwE().cuW() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.iIL.cwE().cuW().cvs().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.xz(1);
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
                    com.baidu.tieba.tbadkCore.util.a.Tt(currentAccount);
                }
                this.iIK.qd(this.iIL.cwG());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.iIL != null) {
                        this.iIL.pU(StringUtils.isNull(this.iIP) ? false : true);
                    }
                    this.iIM.LoadData();
                } else if (z2 && this.iIL != null) {
                    this.iIL.pU(StringUtils.isNull(this.iIP) ? false : true);
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
        if (this.iIJ.isAdded() && this.iIJ.isPrimary()) {
            if (this.iIM != null) {
                this.iIM.onPrimary();
            }
        } else {
            cwh();
        }
        if (this.iIK != null) {
            this.iIK.onPrimary();
        }
    }

    public void onPause() {
        if (this.iIK != null && this.iIK.cxE() != null) {
            this.iIK.cxE().completePullRefresh();
        }
        if (this.iIM != null) {
            this.iIM.onPause();
        }
        if (this.iIL != null) {
            this.iIL.onPause();
        }
        if (this.iIK != null) {
            this.iIK.onPause();
        }
    }

    public void aSC() {
        if (this.iIK != null) {
            this.iIK.cQ(this.mRootView);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f iJc;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.iJc = null;
            this.iJc = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.iJc;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.bsr().bta().mIsNeedTbs = true;
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
                if (this.mNetwork.bsr().btb().isRequestSuccess()) {
                    a.this.iIR = true;
                    if (a.this.iIJ.isAdded() && a.this.gin != null) {
                        a.this.gin.showToast(a.this.gin.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.z(false, this.iJc.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.iJc.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.iJc.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.iJc.getName()));
                    }
                    a.this.iIK.a(this.iJc, a.this.iIL.cwG());
                    a.this.iIL.b(this.iJc);
                } else if (a.this.gin != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gin.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iIJ.isAdded()) {
                        a.this.gin.showToast(a.this.gin.getActivity().getString(R.string.delete_like_fail));
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
    private class C0705a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f iJc;
        private aa mNetwork = null;

        public C0705a(com.baidu.tieba.enterForum.data.f fVar) {
            this.iJc = null;
            this.iJc = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.iJc;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.cvi() == 0) {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.bsr().bta().mIsNeedTbs = true;
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
            a.this.pO(false);
            int cvi = this.iJc.cvi();
            if (this.mNetwork != null) {
                if (this.mNetwork.bsr().btb().isRequestSuccess()) {
                    a.this.iIR = true;
                    if (a.this.iIJ.isAdded() && a.this.gin != null) {
                        a.this.gin.showToast(a.this.gin.getActivity().getString(cvi > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.iIL.pT(true);
                } else if (a.this.gin != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gin.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.iIJ.isAdded()) {
                        a.this.gin.showToast(a.this.gin.getActivity().getString(cvi > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.cXT().D(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bDn = bVar.bDn();
        com.baidu.tbadk.mvc.b.a bDo = bVar.bDo();
        switch (bDn) {
            case 1:
                if (this.iIS != 2 && (bDo instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bDo).getName();
                    if (au.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.gin.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bDo).bAO() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bDo).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bDo).cvn());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bDo).cvm().night != null && ((com.baidu.tieba.enterForum.data.f) bDo).cvm().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bDo).cvm().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bDo).cvm().day != null && ((com.baidu.tieba.enterForum.data.f) bDo).cvm().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bDo).cvm().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bDo).cvq());
                            ((com.baidu.tieba.enterForum.data.f) bDo).gi(0L);
                        }
                        this.gin.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.gin.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new ar("c12888"));
                        }
                        TiebaStatic.log(new ar("c13368").v("uid", TbadkApplication.getCurrentAccountId()).ap("obj_type", this.iIL.cwE().getSortType() == 1 ? 2 : 1).dR("fid", ((com.baidu.tieba.enterForum.data.f) bDo).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.iIS == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.iIR = false;
                if (this.iIJ.getView() == null || this.iIJ.getView().getParent() == null) {
                    return true;
                }
                this.iIJ.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bDo instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bDo);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(this.gin.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gin.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ar("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.gin.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gin.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ar("c13367").dR("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dR("obj_type", "2").ap("obj_locate", 1));
                this.gin.finish();
                return true;
            case 9:
                if (this.iIK != null) {
                    this.iIK.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.iIS = 2;
                return true;
            case 11:
                this.iIS = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.iIS != 2) {
                    if (this.iIT == null) {
                        this.iIT = new com.baidu.tieba.enterForum.view.d(this.gin.getPageContext(), this.iGM);
                    }
                    if (bDo instanceof com.baidu.tieba.enterForum.data.f) {
                        this.iIT.c((com.baidu.tieba.enterForum.data.f) bDo);
                        this.iIT.QE();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bDo instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0705a((com.baidu.tieba.enterForum.data.f) bDo).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new ar("c13370").ap("obj_type", ((com.baidu.tieba.enterForum.data.f) bDo).cvi() <= 0 ? 1 : 2).dR("fid", ((com.baidu.tieba.enterForum.data.f) bDo).getId()).v("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                bf.bsV().b(this.gin.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.gEI.dRs() || !(bDo instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                bf.bsV().b(this.gin.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bDo).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bDp());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bDp());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bDp());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bDm() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.gin.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iIK != null) {
            this.iIK.setPageUniqueId(bdUniqueId);
        }
    }

    public void pQ(boolean z) {
        int i;
        if (this.iIK != null && this.iIJ != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iIK.setAdState(cVar);
        this.iIJ.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b cwj() {
        return this.iIK;
    }
}
