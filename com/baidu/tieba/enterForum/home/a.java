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
/* loaded from: classes22.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel eTL;
    private BaseFragmentActivity fNF;
    private com.baidu.tieba.ueg.d ghZ;
    private EnterForumFragment idN;
    private EnterForumModel idP;
    private RecentlyVisitedForumModel idQ;
    private boolean idR;
    private String idT;
    private long idU;
    private boolean idV;
    private com.baidu.tieba.enterForum.view.d idX;
    private boolean idY;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b idO = null;
    private com.baidu.tbadk.core.dialog.a fIu = null;
    private boolean idS = false;
    private int idW = 1;
    private CustomMessageListener idZ = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.idS = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iea = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.idP.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.idO.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.idO.isEmpty()) {
                        a.this.idO.ct(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.idP.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.idP.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d ieb = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bN(a.this.eTL.getErrorCode(), a.this.eTL.getErrorString())) {
                AntiHelper.bm(a.this.fNF.getPageContext().getPageActivity(), a.this.eTL.getErrorString());
            } else if (obj != null) {
                a.this.idP.oI(!StringUtils.isNull(a.this.idT));
            } else if (!StringUtils.isNull(a.this.eTL.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.eTL.getErrorString());
            }
        }
    };
    private final EnterForumModel.b iec = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.idN != null) {
                if (aVar.type == 1) {
                    a.this.idO.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.idR = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.igK;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.idR) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.igK;
                        a.this.idP.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.fNF.showToast(aVar.error);
                    a.this.idO.xq(com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.idU > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.idU, a.this.idP.cpV() - a.this.idU, a.this.idP.cpT(), a.this.idP.cpU(), currentTimeMillis - a.this.idP.cpS());
                    a.this.idU = -1L;
                }
                String string = a.this.fNF.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.igK != null && aVar.igK.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.igK.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.coz() != null) {
                        string = hotSearchInfoData.coz();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.igK != null && aVar.igK.cou() != null) {
                    a.this.idO.b(aVar.igK.cou());
                }
            }
        }
    };
    private f.c ePL = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.idA.loadAd();
            a.this.idP.oI(!StringUtils.isNull(a.this.idT));
            a.this.idQ.LoadData();
            a.this.idP.oH(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter ibM = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.idP = null;
        this.isFirst = true;
        this.idR = false;
        this.idU = -1L;
        this.idN = enterForumFragment;
        this.fNF = enterForumFragment.getBaseFragmentActivity();
        this.ibM.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.cCA();
        this.idU = System.currentTimeMillis();
        this.isFirst = true;
        this.idR = false;
        this.idT = "";
        this.idP = new EnterForumModel(this.fNF.getPageContext());
        this.idQ = new RecentlyVisitedForumModel();
        this.eTL = new LikeModel(this.fNF.getPageContext());
        this.ghZ = new com.baidu.tieba.ueg.d(this.fNF.getPageContext());
        this.eTL.setLoadDataCallBack(this.ieb);
        this.idP.a(this.iec);
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cpQ().m(this.idN.getFragmentActivity(), l.getStatusBarHeight(this.idN.getFragmentActivity()));
        initUI();
        initListener();
        cpx();
    }

    private void initListener() {
        cpw();
        this.idN.registerListener(this.iea);
        this.idN.registerListener(this.idZ);
    }

    private void cpw() {
        this.idN.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.idO != null && a.this.idO.col()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void cpx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<al>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<al> run(CustomMessage<al> customMessage) {
                al alVar = new al();
                ArrayList arrayList = new ArrayList();
                if (a.this.idP != null && a.this.idP.cpW() != null && a.this.idP.cpW().cop() != null && y.getCount(a.this.idP.cpW().cop().coL()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.idP.cpW().cop().coL().iterator();
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
                    alVar.bb(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, alVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fNF.getPageContext().getPageActivity());
            aVar.Ba(String.format(this.fNF.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.fNF.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.fNF.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.on(R.color.cp_cont_b);
            aVar.b(this.fNF.getPageContext());
            aVar.bmC();
        }
    }

    public void oD(boolean z) {
        if (this.mWaitingDialog == null) {
            cpy();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void cpy() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.fNF.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.fNF.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.idO = new com.baidu.tieba.enterForum.view.b(this.idN, this.mRootView, this.ibM, this.idQ, this.idP);
        this.idO.setListPullRefreshListener(this.ePL);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void oE(boolean z) {
        if (this.idO != null && this.idN != null) {
            if (z) {
                if (this.idN.isPrimary() && this.idN.isResumed()) {
                    this.idO.startPullRefresh();
                } else {
                    this.idO.completeRefresh();
                }
            } else {
                this.idO.completeRefresh();
            }
            this.idO.oT(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.idN.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.idO != null) {
            if (dVar == null) {
                this.idO.ct(this.mRootView);
                return;
            }
            g cop = dVar.cop();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cop != null) {
                arrayList = cop.coL();
            }
            a(arrayList, dVar.coq());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.coz() != null) {
                setSearchHint(hotSearchInfoData.coz());
            }
            this.idO.cqX();
            this.idO.xq(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.idN.cpr() != null) {
            if (!StringUtils.isNull(str)) {
                this.idN.cpr().setSearchHint(str.trim());
            } else {
                this.idN.cpr().setSearchHint(this.fNF.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.idO.a(this.idP.a(list, com.baidu.tbadk.util.f.bAV()), bjVar, this.idP.cpY());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.cos() != null && this.idN.isPrimary() && this.fIu == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.fNF.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.cos())) {
                this.fIu = new com.baidu.tbadk.core.dialog.a(this.fNF.getActivity());
                this.fIu.op(2);
                this.fIu.bb(frsPrivateCommonDialogView);
                this.fIu.iN(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.boR().b(a.this.fNF.getPageContext(), new String[]{dVar.cos().bjb()});
                        a.this.fIu.dismiss();
                        a.this.fIu = null;
                    }
                });
                this.fIu.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.fIu = null;
                    }
                });
                this.fIu.b(this.fNF.getPageContext()).bmC();
            }
        }
    }

    private void cpz() {
        if (this.fIu != null) {
            this.fIu.dismiss();
            this.fIu = null;
        }
    }

    public void loadData() {
        if (this.idO != null) {
            gR(false);
        }
    }

    public void cpA() {
        if (this.idO != null) {
            gR(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cpQ().destroy();
        if (this.idO != null) {
            this.idO.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.idQ != null) {
            this.idQ.onDestroy();
        }
        if (this.idP != null) {
            this.idP.onDestroy();
        }
        if (this.ibM != null) {
            this.ibM.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.idO != null) {
            this.idO.onChangeSkinType(i);
        }
        if (this.idX != null) {
            this.idX.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.idP != null) {
            this.idP.cancelLoadData();
        }
    }

    public void gR(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.idY && this.idP != null && this.idO != null) {
            String str = this.idT;
            this.idT = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.idT == null || this.idT.equals(str)) {
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
                if (this.idP != null && this.idP.cpW() != null && this.idP.cpW().cop() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.idP.cpW().cop().coL().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.xs(1);
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
                    com.baidu.tieba.tbadkCore.util.a.SD(currentAccount);
                }
                this.idO.oS(this.idP.cpY());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.idP != null) {
                        this.idP.oJ(StringUtils.isNull(this.idT) ? false : true);
                    }
                    this.idQ.LoadData();
                } else if (z2 && this.idP != null) {
                    this.idP.oJ(StringUtils.isNull(this.idT) ? false : true);
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
        if (this.idN.isAdded() && this.idN.isPrimary()) {
            if (this.idQ != null) {
                this.idQ.onPrimary();
            }
        } else {
            cpz();
        }
        if (this.idO != null) {
            this.idO.onPrimary();
        }
    }

    public void onPause() {
        if (this.idO != null && this.idO.cqW() != null) {
            this.idO.cqW().completePullRefresh();
        }
        if (this.idQ != null) {
            this.idQ.onPause();
        }
        if (this.idP != null) {
            this.idP.onPause();
        }
        if (this.idO != null) {
            this.idO.onPause();
        }
    }

    public void aOS() {
        if (this.idO != null) {
            this.idO.cs(this.mRootView);
        }
    }

    /* loaded from: classes22.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f ieg;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.ieg = null;
            this.ieg = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.ieg;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.bon().boT().mIsNeedTbs = true;
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
            a.this.oD(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.bon().boU().isRequestSuccess()) {
                    a.this.idV = true;
                    if (a.this.idN.isAdded() && a.this.fNF != null) {
                        a.this.fNF.showToast(a.this.fNF.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.s(false, this.ieg.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.ieg.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.ieg.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.ieg.getName()));
                    }
                    a.this.idO.a(this.ieg, a.this.idP.cpY());
                    a.this.idP.b(this.ieg);
                } else if (a.this.fNF != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fNF.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.idN.isAdded()) {
                        a.this.fNF.showToast(a.this.fNF.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.oD(true);
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
    /* loaded from: classes22.dex */
    private class C0700a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f ieg;
        private aa mNetwork = null;

        public C0700a(com.baidu.tieba.enterForum.data.f fVar) {
            this.ieg = null;
            this.ieg = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.ieg;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.coB() == 0) {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.bon().boT().mIsNeedTbs = true;
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
            super.onPostExecute((C0700a) str);
            a.this.oD(false);
            int coB = this.ieg.coB();
            if (this.mNetwork != null) {
                if (this.mNetwork.bon().boU().isRequestSuccess()) {
                    a.this.idV = true;
                    if (a.this.idN.isAdded() && a.this.fNF != null) {
                        a.this.fNF.showToast(a.this.fNF.getActivity().getString(coB > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.idP.oI(true);
                } else if (a.this.fNF != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fNF.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.idN.isAdded()) {
                        a.this.fNF.showToast(a.this.fNF.getActivity().getString(coB > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.oD(true);
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
                    com.baidu.tieba.im.settingcache.d.cSF().z(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bzc = bVar.bzc();
        com.baidu.tbadk.mvc.b.a bzd = bVar.bzd();
        switch (bzc) {
            case 1:
                if (this.idW != 2 && (bzd instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bzd).getName();
                    if (at.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.fNF.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bzd).bwF() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bzd).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bzd).coG());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bzd).coF().night != null && ((com.baidu.tieba.enterForum.data.f) bzd).coF().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bzd).coF().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bzd).coF().day != null && ((com.baidu.tieba.enterForum.data.f) bzd).coF().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bzd).coF().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bzd).coJ());
                            ((com.baidu.tieba.enterForum.data.f) bzd).fa(0L);
                        }
                        this.fNF.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.fNF.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new aq("c12888"));
                        }
                        TiebaStatic.log(new aq("c13368").w("uid", TbadkApplication.getCurrentAccountId()).aj("obj_type", this.idP.cpW().getSortType() == 1 ? 2 : 1).dR("fid", ((com.baidu.tieba.enterForum.data.f) bzd).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.idW == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.idV = false;
                if (this.idN.getView() == null || this.idN.getView().getParent() == null) {
                    return true;
                }
                this.idN.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bzd instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bzd);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(this.fNF.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fNF.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.fNF.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fNF.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("c13367").dR("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dR("obj_type", "2").aj("obj_locate", 1));
                this.fNF.finish();
                return true;
            case 9:
                if (this.idO != null) {
                    this.idO.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.idW = 2;
                return true;
            case 11:
                this.idW = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.idW != 2) {
                    if (this.idX == null) {
                        this.idX = new com.baidu.tieba.enterForum.view.d(this.fNF.getPageContext(), this.ibM);
                    }
                    if (bzd instanceof com.baidu.tieba.enterForum.data.f) {
                        this.idX.c((com.baidu.tieba.enterForum.data.f) bzd);
                        this.idX.PJ();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bzd instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0700a((com.baidu.tieba.enterForum.data.f) bzd).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new aq("c13370").aj("obj_type", ((com.baidu.tieba.enterForum.data.f) bzd).coB() <= 0 ? 1 : 2).dR("fid", ((com.baidu.tieba.enterForum.data.f) bzd).getId()).w("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                be.boR().b(this.fNF.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.ghZ.dLn() || !(bzd instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                be.boR().b(this.fNF.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bzd).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bze());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bze());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bze());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bzb() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.fNF.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.idO != null) {
            this.idO.setPageUniqueId(bdUniqueId);
        }
    }

    public void oF(boolean z) {
        int i;
        if (this.idO != null && this.idN != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.idO.setAdState(cVar);
        this.idN.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b cpB() {
        return this.idO;
    }
}
