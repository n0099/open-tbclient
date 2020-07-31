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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes16.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel emT;
    private BaseFragmentActivity feq;
    private com.baidu.tieba.ueg.d fwT;
    private EnterForumFragment hih;
    private EnterForumModel hij;
    private RecentlyVisitedForumModel hik;
    private boolean hil;
    private String hin;
    private long hio;
    private boolean hip;
    private com.baidu.tieba.enterForum.view.d hir;
    private boolean his;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b hii = null;
    private com.baidu.tbadk.core.dialog.a eZw = null;
    private boolean him = false;
    private int hiq = 1;
    private CustomMessageListener hit = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.him = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hiu = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.hij.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.hii.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.hii.isEmpty()) {
                        a.this.hii.ca(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.hij.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.hij.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d hiv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bB(a.this.emT.getErrorCode(), a.this.emT.getErrorString())) {
                AntiHelper.aW(a.this.feq.getPageContext().getPageActivity(), a.this.emT.getErrorString());
            } else if (obj != null) {
                a.this.hij.mZ(!StringUtils.isNull(a.this.hin));
            } else if (!StringUtils.isNull(a.this.emT.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.emT.getErrorString());
            }
        }
    };
    private final EnterForumModel.b hiw = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.hih != null) {
                if (aVar.type == 1) {
                    a.this.hii.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.hil = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.hlq;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                        if (a.this.hih.bVf() != null) {
                            a.this.hih.bVf().a(dVar.bUp(), true);
                        }
                    } else if (aVar.type == 0 && !a.this.hil) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.hlq;
                        a.this.hij.c(dVar2);
                        a.this.a(dVar2);
                        if (a.this.hih.bVf() != null) {
                            a.this.hih.bVf().a(dVar2.bUp(), false);
                        }
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.feq.showToast(aVar.error);
                    a.this.hii.tD(com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.hio > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.hio, a.this.hij.bVN() - a.this.hio, a.this.hij.bVL(), a.this.hij.bVM(), currentTimeMillis - a.this.hij.bVK());
                    a.this.hio = -1L;
                }
                String string = a.this.feq.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.hlq != null && aVar.hlq.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.hlq.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bUv() != null) {
                        string = hotSearchInfoData.bUv();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.hlq != null && aVar.hlq.bUq() != null) {
                    a.this.hii.b(aVar.hlq.bUq());
                }
            }
        }
    };
    private f.c ejc = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.hhT.loadAd();
            a.this.hij.mZ(!StringUtils.isNull(a.this.hin));
            a.this.hik.LoadData();
            a.this.hij.mY(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter hgq = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.hij = null;
        this.isFirst = true;
        this.hil = false;
        this.hio = -1L;
        this.hih = enterForumFragment;
        this.feq = enterForumFragment.getBaseFragmentActivity();
        this.hgq.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.cic();
        this.hio = System.currentTimeMillis();
        this.isFirst = true;
        this.hil = false;
        this.hin = "";
        this.hij = new EnterForumModel(this.feq.getPageContext());
        this.hik = new RecentlyVisitedForumModel();
        this.emT = new LikeModel(this.feq.getPageContext());
        this.fwT = new com.baidu.tieba.ueg.d(this.feq.getPageContext());
        this.emT.setLoadDataCallBack(this.hiv);
        this.hij.a(this.hiw);
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.bVI().m(this.hih.getFragmentActivity(), l.getStatusBarHeight(this.hih.getFragmentActivity()));
        initUI();
        initListener();
        bVl();
    }

    private void initListener() {
        bVk();
        this.hih.registerListener(this.hiu);
        this.hih.registerListener(this.hit);
    }

    private void bVk() {
        this.hih.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hii != null && a.this.hii.bUg()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bVl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ak>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ak> run(CustomMessage<ak> customMessage) {
                ak akVar = new ak();
                ArrayList arrayList = new ArrayList();
                if (a.this.hij != null && a.this.hij.bVO() != null && a.this.hij.bVO().bUk() != null && x.getCount(a.this.hij.bVO().bUk().bUH()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.hij.bVO().bUk().bUH().iterator();
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
                    akVar.aK(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, akVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.feq.getPageContext().getPageActivity());
            aVar.xl(String.format(this.feq.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.feq.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.feq.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.lo(R.color.cp_cont_b);
            aVar.b(this.feq.getPageContext());
            aVar.aYL();
        }
    }

    public void mU(boolean z) {
        if (this.mWaitingDialog == null) {
            bVm();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bVm() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.feq.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.feq.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.hii = new com.baidu.tieba.enterForum.view.b(this.hih, this.mRootView, this.hgq, this.hik, this.hij);
        this.hii.setListPullRefreshListener(this.ejc);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mV(boolean z) {
        if (this.hii != null && this.hih != null) {
            if (z) {
                if (this.hih.isPrimary() && this.hih.isResumed()) {
                    this.hii.startPullRefresh();
                } else {
                    this.hii.completeRefresh();
                }
            } else {
                this.hii.completeRefresh();
            }
            this.hii.nk(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.hih.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.hii != null) {
            if (dVar == null) {
                this.hii.ca(this.mRootView);
                return;
            }
            g bUk = dVar.bUk();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (bUk != null) {
                arrayList = bUk.bUH();
            }
            a(arrayList, dVar.bUl());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bUv() != null) {
                setSearchHint(hotSearchInfoData.bUv());
            }
            this.hii.bWR();
            this.hii.tD(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.hih.bVf() != null) {
            if (!StringUtils.isNull(str)) {
                this.hih.bVf().setSearchHint(str.trim());
            } else {
                this.hih.bVf().setSearchHint(this.feq.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bi biVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.hii.a(this.hij.a(list, com.baidu.tbadk.util.f.bmA()), biVar, this.hij.bVQ());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.bUn() != null && this.hih.isPrimary() && this.eZw == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.feq.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.bUn())) {
                this.eZw = new com.baidu.tbadk.core.dialog.a(this.feq.getActivity());
                this.eZw.lq(2);
                this.eZw.aV(frsPrivateCommonDialogView);
                this.eZw.hK(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bd.baV().b(a.this.feq.getPageContext(), new String[]{dVar.bUn().aVm()});
                        a.this.eZw.dismiss();
                        a.this.eZw = null;
                    }
                });
                this.eZw.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eZw = null;
                    }
                });
                this.eZw.b(this.feq.getPageContext()).aYL();
            }
        }
    }

    private void bVn() {
        if (this.eZw != null) {
            this.eZw.dismiss();
            this.eZw = null;
        }
    }

    public void loadData() {
        if (this.hii != null) {
            fQ(false);
        }
    }

    public void bVo() {
        if (this.hii != null) {
            fQ(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.bVI().destroy();
        if (this.hii != null) {
            this.hii.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.hik != null) {
            this.hik.onDestroy();
        }
        if (this.hij != null) {
            this.hij.onDestroy();
        }
        if (this.hgq != null) {
            this.hgq.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hii != null) {
            this.hii.onChangeSkinType(i);
        }
        if (this.hir != null) {
            this.hir.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.hij != null) {
            this.hij.cancelLoadData();
        }
    }

    public void fQ(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.his && this.hij != null && this.hii != null) {
            String str = this.hin;
            this.hin = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.hin == null || this.hin.equals(str)) {
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
                if (this.hij != null && this.hij.bVO() != null && this.hij.bVO().bUk() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.hij.bVO().bUk().bUH().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.tF(1);
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
                    com.baidu.tieba.tbadkCore.util.a.NS(currentAccount);
                }
                this.hii.nj(this.hij.bVQ());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.hij != null) {
                        this.hij.na(StringUtils.isNull(this.hin) ? false : true);
                    }
                    this.hik.LoadData();
                } else if (z2 && this.hij != null) {
                    this.hij.na(StringUtils.isNull(this.hin) ? false : true);
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
        if (this.hih.isAdded() && this.hih.isPrimary()) {
            if (this.hik != null) {
                this.hik.onPrimary();
            }
        } else {
            bVn();
        }
        if (this.hii != null) {
            this.hii.onPrimary();
        }
    }

    public void onPause() {
        if (this.hii != null && this.hii.bWQ() != null) {
            this.hii.bWQ().completePullRefresh();
        }
        if (this.hik != null) {
            this.hik.onPause();
        }
        if (this.hij != null) {
            this.hij.onPause();
        }
        if (this.hii != null) {
            this.hii.onPause();
        }
    }

    public void aAV() {
        if (this.hii != null) {
            this.hii.bZ(this.mRootView);
        }
    }

    /* loaded from: classes16.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hiA;
        private z mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.hiA = null;
            this.hiA = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hiA;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.bav().baW().mIsNeedTbs = true;
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
            a.this.mU(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.bav().baX().isRequestSuccess()) {
                    a.this.hip = true;
                    if (a.this.hih.isAdded() && a.this.feq != null) {
                        a.this.feq.showToast(a.this.feq.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.p(false, this.hiA.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.hiA.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.hiA.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.hiA.getName()));
                    }
                    a.this.hii.a(this.hiA, a.this.hij.bVQ());
                    a.this.hij.b(this.hiA);
                } else if (a.this.feq != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.feq.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hih.isAdded()) {
                        a.this.feq.showToast(a.this.feq.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.mU(true);
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
    /* loaded from: classes16.dex */
    private class C0618a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hiA;
        private z mNetwork = null;

        public C0618a(com.baidu.tieba.enterForum.data.f fVar) {
            this.hiA = null;
            this.hiA = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hiA;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bUx() == 0) {
                            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.bav().baW().mIsNeedTbs = true;
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
            super.onPostExecute((C0618a) str);
            a.this.mU(false);
            int bUx = this.hiA.bUx();
            if (this.mNetwork != null) {
                if (this.mNetwork.bav().baX().isRequestSuccess()) {
                    a.this.hip = true;
                    if (a.this.hih.isAdded() && a.this.feq != null) {
                        a.this.feq.showToast(a.this.feq.getActivity().getString(bUx > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.hij.mZ(true);
                } else if (a.this.feq != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.feq.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hih.isAdded()) {
                        a.this.feq.showToast(a.this.feq.getActivity().getString(bUx > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.mU(true);
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
                    com.baidu.tieba.im.settingcache.d.cxs().A(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bkI = bVar.bkI();
        com.baidu.tbadk.mvc.b.a bkJ = bVar.bkJ();
        switch (bkI) {
            case 1:
                if (this.hiq != 2 && (bkJ instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bkJ).getName();
                    if (as.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.feq.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bkJ).biv() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bkJ).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bkJ).bUC());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bkJ).bUB().night != null && ((com.baidu.tieba.enterForum.data.f) bkJ).bUB().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bkJ).bUB().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bkJ).bUB().day != null && ((com.baidu.tieba.enterForum.data.f) bkJ).bUB().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bkJ).bUB().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bkJ).bUF());
                            ((com.baidu.tieba.enterForum.data.f) bkJ).en(0L);
                        }
                        this.feq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.feq.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new ap("c12888"));
                        }
                        TiebaStatic.log(new ap("c13368").t("uid", TbadkApplication.getCurrentAccountId()).ah("obj_type", this.hij.bVO().getSortType() == 1 ? 2 : 1).dn("fid", ((com.baidu.tieba.enterForum.data.f) bkJ).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.hiq == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.hip = false;
                if (this.hih.getView() == null || this.hih.getView().getParent() == null) {
                    return true;
                }
                this.hih.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bkJ instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bkJ);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bf.skipToLoginActivity(this.feq.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.feq.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ap("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.feq.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.feq.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ap("c13367").dn("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new ap(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dn("obj_type", "2").ah("obj_locate", 1));
                this.feq.finish();
                return true;
            case 9:
                if (this.hii != null) {
                    this.hii.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.hiq = 2;
                return true;
            case 11:
                this.hiq = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.hiq != 2) {
                    if (this.hir == null) {
                        this.hir = new com.baidu.tieba.enterForum.view.d(this.feq.getPageContext(), this.hgq);
                    }
                    if (bkJ instanceof com.baidu.tieba.enterForum.data.f) {
                        this.hir.c((com.baidu.tieba.enterForum.data.f) bkJ);
                        this.hir.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bkJ instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0618a((com.baidu.tieba.enterForum.data.f) bkJ).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new ap("c13370").ah("obj_type", ((com.baidu.tieba.enterForum.data.f) bkJ).bUx() <= 0 ? 1 : 2).dn("fid", ((com.baidu.tieba.enterForum.data.f) bkJ).getId()).t("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                bd.baV().b(this.feq.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fwT.doU() || !(bkJ instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                bd.baV().b(this.feq.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bkJ).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bkK());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bkK());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bkK());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bkH() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.feq.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hii != null) {
            this.hii.setPageUniqueId(bdUniqueId);
        }
    }

    public void mW(boolean z) {
        int i;
        if (this.hii != null && this.hih != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hii.setAdState(cVar);
        this.hih.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b bVp() {
        return this.hii;
    }
}
