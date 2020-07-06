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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.g;
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
    private BaseFragmentActivity eZO;
    private LikeModel egK;
    private com.baidu.tieba.ueg.d frL;
    private RecentlyVisitedForumModel hcA;
    private boolean hcB;
    private String hcD;
    private long hcE;
    private boolean hcF;
    private com.baidu.tieba.enterForum.view.d hcH;
    private boolean hcI;
    private EnterForumFragment hcx;
    private EnterForumModel hcz;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b hcy = null;
    private com.baidu.tbadk.core.dialog.a eTb = null;
    private boolean hcC = false;
    private int hcG = 1;
    private CustomMessageListener hcJ = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.hcC = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hcK = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.hcz.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.hcy.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.eZO.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.eZO.showToast(errorString);
                    if (a.this.hcy.isEmpty()) {
                        a.this.hcy.bU(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.hcz.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.hcz.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d hcL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bA(a.this.egK.getErrorCode(), a.this.egK.getErrorString())) {
                AntiHelper.aX(a.this.eZO.getPageContext().getPageActivity(), a.this.egK.getErrorString());
            } else if (obj != null) {
                a.this.hcz.mu(!StringUtils.isNull(a.this.hcD));
            } else if (!StringUtils.isNull(a.this.egK.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.egK.getErrorString());
            }
        }
    };
    private final EnterForumModel.b hcM = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.hcx != null) {
                if (aVar.type == 1) {
                    a.this.hcy.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.hcB = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.hfG;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                        if (a.this.hcx.bRO() != null) {
                            a.this.hcx.bRO().a(dVar.bRe(), true);
                        }
                    } else if (aVar.type == 0 && !a.this.hcB) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.hfG;
                        a.this.hcz.c(dVar2);
                        a.this.a(dVar2);
                        if (a.this.hcx.bRO() != null) {
                            a.this.hcx.bRO().a(dVar2.bRe(), false);
                        }
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.eZO.showToast(aVar.error);
                    a.this.hcy.tl(com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.hcE > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.hcE, a.this.hcz.bSw() - a.this.hcE, a.this.hcz.bSu(), a.this.hcz.bSv(), currentTimeMillis - a.this.hcz.bSt());
                    a.this.hcE = -1L;
                }
                String string = a.this.eZO.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.hfG != null && aVar.hfG.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.hfG.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bRj() != null) {
                        string = hotSearchInfoData.bRj();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private f.c ecS = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.hck.loadAd();
            a.this.hcz.mu(!StringUtils.isNull(a.this.hcD));
            a.this.hcA.LoadData();
            a.this.hcz.mt(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter haL = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.hcz = null;
        this.isFirst = true;
        this.hcB = false;
        this.hcE = -1L;
        this.hcx = enterForumFragment;
        this.eZO = enterForumFragment.getBaseFragmentActivity();
        this.haL.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.ceD();
        this.hcE = System.currentTimeMillis();
        this.isFirst = true;
        this.hcB = false;
        this.hcD = "";
        this.hcz = new EnterForumModel(this.eZO.getPageContext());
        this.hcA = new RecentlyVisitedForumModel();
        this.egK = new LikeModel(this.eZO.getPageContext());
        this.frL = new com.baidu.tieba.ueg.d(this.eZO.getPageContext());
        this.egK.setLoadDataCallBack(this.hcL);
        this.hcz.a(this.hcM);
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.bSr().m(this.hcx.getFragmentActivity(), l.getStatusBarHeight(this.hcx.getFragmentActivity()));
        initUI();
        initListener();
        bRU();
    }

    private void initListener() {
        bRT();
        this.hcx.registerListener(this.hcK);
        this.hcx.registerListener(this.hcJ);
    }

    private void bRT() {
        this.hcx.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hcy != null && a.this.hcy.bQV()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bRU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<aj>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<aj> run(CustomMessage<aj> customMessage) {
                aj ajVar = new aj();
                ArrayList arrayList = new ArrayList();
                if (a.this.hcz != null && a.this.hcz.bSx() != null && a.this.hcz.bSx().bQZ() != null && w.getCount(a.this.hcz.bSx().bQZ().bRv()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.hcz.bSx().bQZ().bRv().iterator();
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
                    ajVar.aD(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, ajVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eZO.getPageContext().getPageActivity());
            aVar.we(String.format(this.eZO.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.eZO.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.eZO.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.kU(R.color.cp_cont_b);
            aVar.b(this.eZO.getPageContext());
            aVar.aUN();
        }
    }

    public void mp(boolean z) {
        if (this.mWaitingDialog == null) {
            bRV();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bRV() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.eZO.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.eZO.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.hcy = new com.baidu.tieba.enterForum.view.b(this.hcx, this.mRootView, this.haL, this.hcA, this.hcz);
        this.hcy.setListPullRefreshListener(this.ecS);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mq(boolean z) {
        if (this.hcy != null && this.hcx != null) {
            if (z) {
                if (this.hcx.isPrimary() && this.hcx.isResumed()) {
                    this.hcy.startPullRefresh();
                } else {
                    this.hcy.completeRefresh();
                }
            } else {
                this.hcy.completeRefresh();
            }
            this.hcy.mF(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.hcx.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.hcy != null) {
            if (dVar == null) {
                this.hcy.bU(this.mRootView);
                return;
            }
            g bQZ = dVar.bQZ();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (bQZ != null) {
                arrayList = bQZ.bRv();
            }
            a(arrayList, dVar.bRa());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bRj() != null) {
                setSearchHint(hotSearchInfoData.bRj());
            }
            this.hcy.bTy();
            this.hcy.tl(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.hcx.bRO() != null) {
            if (!StringUtils.isNull(str)) {
                this.hcx.bRO().setSearchHint(str.trim());
            } else {
                this.hcx.bRO().setSearchHint(this.eZO.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bh bhVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.hcy.a(this.hcz.a(list, com.baidu.tbadk.util.e.biG()), bhVar, this.hcz.bSz());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.bRc() != null && this.hcx.isPrimary() && this.eTb == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.eZO.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.bRc())) {
                this.eTb = new com.baidu.tbadk.core.dialog.a(this.eZO.getActivity());
                this.eTb.kW(2);
                this.eTb.aP(frsPrivateCommonDialogView);
                this.eTb.hg(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bc.aWU().b(a.this.eZO.getPageContext(), new String[]{dVar.bRc().aRq()});
                        a.this.eTb.dismiss();
                        a.this.eTb = null;
                    }
                });
                this.eTb.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eTb = null;
                    }
                });
                this.eTb.b(this.eZO.getPageContext()).aUN();
            }
        }
    }

    private void bRW() {
        if (this.eTb != null) {
            this.eTb.dismiss();
            this.eTb = null;
        }
    }

    public void loadData() {
        if (this.hcy != null) {
            fH(false);
        }
    }

    public void bRX() {
        if (this.hcy != null) {
            fH(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.bSr().destroy();
        if (this.hcy != null) {
            this.hcy.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.hcA != null) {
            this.hcA.onDestroy();
        }
        if (this.hcz != null) {
            this.hcz.onDestroy();
        }
        if (this.haL != null) {
            this.haL.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hcy != null) {
            this.hcy.onChangeSkinType(i);
        }
        if (this.hcH != null) {
            this.hcH.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.hcz != null) {
            this.hcz.cancelLoadData();
        }
    }

    public void fH(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.hcI && this.hcz != null && this.hcy != null) {
            String str = this.hcD;
            this.hcD = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.hcD == null || this.hcD.equals(str)) {
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
                if (this.hcz != null && this.hcz.bSx() != null && this.hcz.bSx().bQZ() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.hcz.bSx().bQZ().bRv().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.tn(1);
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
                    com.baidu.tieba.tbadkCore.util.a.Nk(currentAccount);
                }
                this.hcy.mE(this.hcz.bSz());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.hcz != null) {
                        this.hcz.mv(StringUtils.isNull(this.hcD) ? false : true);
                    }
                    this.hcA.LoadData();
                } else if (z2 && this.hcz != null) {
                    this.hcz.mv(StringUtils.isNull(this.hcD) ? false : true);
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
        if (this.hcx.isAdded() && this.hcx.isPrimary()) {
            if (this.hcA != null) {
                this.hcA.onPrimary();
            }
        } else {
            bRW();
        }
        if (this.hcy != null) {
            this.hcy.onPrimary();
        }
    }

    public void onPause() {
        if (this.hcy != null && this.hcy.bTx() != null) {
            this.hcy.bTx().completePullRefresh();
        }
        if (this.hcA != null) {
            this.hcA.onPause();
        }
        if (this.hcz != null) {
            this.hcz.onPause();
        }
        if (this.hcy != null) {
            this.hcy.onPause();
        }
    }

    public void axK() {
        if (this.hcy != null) {
            this.hcy.bT(this.mRootView);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hcQ;
        private y mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.hcQ = null;
            this.hcQ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hcQ;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new y(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.aWu().aWV().mIsNeedTbs = true;
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
            a.this.mp(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
                    a.this.hcF = true;
                    if (a.this.hcx.isAdded() && a.this.eZO != null) {
                        a.this.eZO.showToast(a.this.eZO.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.p(false, this.hcQ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.hcQ.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.hcQ.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.hcQ.getName()));
                    }
                    a.this.hcy.a(this.hcQ, a.this.hcz.bSz());
                    a.this.hcz.b(this.hcQ);
                } else if (a.this.eZO != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eZO.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hcx.isAdded()) {
                        a.this.eZO.showToast(a.this.eZO.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.mp(true);
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
    private class C0609a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hcQ;
        private y mNetwork = null;

        public C0609a(com.baidu.tieba.enterForum.data.f fVar) {
            this.hcQ = null;
            this.hcQ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hcQ;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bRl() == 0) {
                            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.aWu().aWV().mIsNeedTbs = true;
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
            super.onPostExecute((C0609a) str);
            a.this.mp(false);
            int bRl = this.hcQ.bRl();
            if (this.mNetwork != null) {
                if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
                    a.this.hcF = true;
                    if (a.this.hcx.isAdded() && a.this.eZO != null) {
                        a.this.eZO.showToast(a.this.eZO.getActivity().getString(bRl > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.hcz.mu(true);
                } else if (a.this.eZO != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eZO.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hcx.isAdded()) {
                        a.this.eZO.showToast(a.this.eZO.getActivity().getString(bRl > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.mp(true);
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
    public void p(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.ctq().A(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bgX = bVar.bgX();
        com.baidu.tbadk.mvc.b.a bgY = bVar.bgY();
        switch (bgX) {
            case 1:
                if (this.hcG != 2 && (bgY instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bgY).getName();
                    if (ar.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.eZO.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bgY).beM() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bgY).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bgY).bRq());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bgY).bRp().night != null && ((com.baidu.tieba.enterForum.data.f) bgY).bRp().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bgY).bRp().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bgY).bRp().day != null && ((com.baidu.tieba.enterForum.data.f) bgY).bRp().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bgY).bRp().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bgY).bRt());
                            ((com.baidu.tieba.enterForum.data.f) bgY).ea(0L);
                        }
                        this.eZO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.eZO.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new ao("c12888"));
                        }
                        TiebaStatic.log(new ao("c13368").s("uid", TbadkApplication.getCurrentAccountId()).ag("obj_type", this.hcz.bSx().getSortType() == 1 ? 2 : 1).dk("fid", ((com.baidu.tieba.enterForum.data.f) bgY).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.hcG == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (bgY instanceof h) {
                    ((h) bgY).getPosition();
                }
                this.hcF = false;
                if (this.hcx.getView() == null || this.hcx.getView().getParent() == null) {
                    return true;
                }
                this.hcx.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bgY instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bgY);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    be.skipToLoginActivity(this.eZO.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eZO.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ao("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.eZO.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eZO.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ao("c13367").dk("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new ao(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dk("obj_type", "2").ag("obj_locate", 1));
                this.eZO.finish();
                return true;
            case 9:
                if (this.hcy != null) {
                    this.hcy.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.hcG = 2;
                return true;
            case 11:
                this.hcG = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.hcG != 2) {
                    if (this.hcH == null) {
                        this.hcH = new com.baidu.tieba.enterForum.view.d(this.eZO.getPageContext(), this.haL);
                    }
                    if (bgY instanceof com.baidu.tieba.enterForum.data.f) {
                        this.hcH.c((com.baidu.tieba.enterForum.data.f) bgY);
                        this.hcH.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bgY instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0609a((com.baidu.tieba.enterForum.data.f) bgY).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new ao("c13370").ag("obj_type", ((com.baidu.tieba.enterForum.data.f) bgY).bRl() <= 0 ? 1 : 2).dk("fid", ((com.baidu.tieba.enterForum.data.f) bgY).getId()).s("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                bc.aWU().b(this.eZO.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.frL.dlL() || !(bgY instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                bc.aWU().b(this.eZO.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bgY).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bgZ());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bgZ());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bgZ());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bgW() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.eZO.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hcy != null) {
            this.hcy.setPageUniqueId(bdUniqueId);
        }
    }

    public void mr(boolean z) {
        int i;
        if (this.hcy != null && this.hcx != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hcy.setAdState(cVar);
        this.hcx.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b bRY() {
        return this.hcy;
    }
}
