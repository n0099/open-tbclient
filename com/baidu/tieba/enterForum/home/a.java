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
import com.baidu.tbadk.core.data.bl;
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
/* loaded from: classes22.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel fgf;
    private BaseFragmentActivity gbo;
    private com.baidu.tieba.ueg.d gvF;
    private boolean isFirst;
    private long ivA;
    private boolean ivB;
    private com.baidu.tieba.enterForum.view.d ivD;
    private boolean ivE;
    private EnterForumFragment ivt;
    private EnterForumModel ivv;
    private RecentlyVisitedForumModel ivw;
    private boolean ivx;
    private String ivz;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b ivu = null;
    private com.baidu.tbadk.core.dialog.a fVx = null;
    private boolean ivy = false;
    private int ivC = 1;
    private CustomMessageListener ivF = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.ivy = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a ivG = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.ivv.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.ivu.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.ivu.isEmpty()) {
                        a.this.ivu.cJ(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.ivv.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.ivv.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d ivH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bP(a.this.fgf.getErrorCode(), a.this.fgf.getErrorString())) {
                AntiHelper.bn(a.this.gbo.getPageContext().getPageActivity(), a.this.fgf.getErrorString());
            } else if (obj != null) {
                a.this.ivv.pq(!StringUtils.isNull(a.this.ivz));
            } else if (!StringUtils.isNull(a.this.fgf.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.fgf.getErrorString());
            }
        }
    };
    private final EnterForumModel.b ivI = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.ivt != null) {
                if (aVar.type == 1) {
                    a.this.ivu.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.ivx = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.iyr;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.ivx) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.iyr;
                        a.this.ivv.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.gbo.showToast(aVar.error);
                    a.this.ivu.yG(com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.ivA > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.ivA, a.this.ivv.cwp() - a.this.ivA, a.this.ivv.cwn(), a.this.ivv.cwo(), currentTimeMillis - a.this.ivv.cwm());
                    a.this.ivA = -1L;
                }
                String string = a.this.gbo.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.iyr != null && aVar.iyr.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.iyr.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.cuS() != null) {
                        string = hotSearchInfoData.cuS();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.iyr != null && aVar.iyr.cuN() != null) {
                    a.this.ivu.b(aVar.iyr.cuN());
                }
            }
        }
    };
    private f.c fci = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.ivg.loadAd();
            a.this.ivv.pq(!StringUtils.isNull(a.this.ivz));
            a.this.ivw.LoadData();
            a.this.ivv.pp(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter itw = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.ivv = null;
        this.isFirst = true;
        this.ivx = false;
        this.ivA = -1L;
        this.ivt = enterForumFragment;
        this.gbo = enterForumFragment.getBaseFragmentActivity();
        this.itw.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.cJU();
        this.ivA = System.currentTimeMillis();
        this.isFirst = true;
        this.ivx = false;
        this.ivz = "";
        this.ivv = new EnterForumModel(this.gbo.getPageContext());
        this.ivw = new RecentlyVisitedForumModel();
        this.fgf = new LikeModel(this.gbo.getPageContext());
        this.gvF = new com.baidu.tieba.ueg.d(this.gbo.getPageContext());
        this.fgf.setLoadDataCallBack(this.ivH);
        this.ivv.a(this.ivI);
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cwk().v(this.ivt.getFragmentActivity(), l.getStatusBarHeight(this.ivt.getFragmentActivity()));
        initUI();
        initListener();
        cvR();
    }

    private void initListener() {
        cvQ();
        this.ivt.registerListener(this.ivG);
        this.ivt.registerListener(this.ivF);
    }

    private void cvQ() {
        this.ivt.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.ivu != null && a.this.ivu.cuE()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void cvR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<an>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<an> run(CustomMessage<an> customMessage) {
                an anVar = new an();
                ArrayList arrayList = new ArrayList();
                if (a.this.ivv != null && a.this.ivv.cwq() != null && a.this.ivv.cwq().cuI() != null && y.getCount(a.this.ivv.cwq().cuI().cve()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.ivv.cwq().cuI().cve().iterator();
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
                    anVar.bl(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, anVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gbo.getPageContext().getPageActivity());
            aVar.Bq(String.format(this.gbo.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.gbo.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.gbo.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.oR(R.color.CAM_X0105);
            aVar.b(this.gbo.getPageContext());
            aVar.brv();
        }
    }

    public void pl(boolean z) {
        if (this.mWaitingDialog == null) {
            cvS();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void cvS() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.gbo.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.gbo.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.ivu = new com.baidu.tieba.enterForum.view.b(this.ivt, this.mRootView, this.itw, this.ivw, this.ivv);
        this.ivu.setListPullRefreshListener(this.fci);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pm(boolean z) {
        if (this.ivu != null && this.ivt != null) {
            if (z) {
                if (this.ivt.isPrimary() && this.ivt.isResumed()) {
                    this.ivu.startPullRefresh();
                } else {
                    this.ivu.completeRefresh();
                }
            } else {
                this.ivu.completeRefresh();
            }
            this.ivu.pB(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.ivt.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.ivu != null) {
            if (dVar == null) {
                this.ivu.cJ(this.mRootView);
                return;
            }
            g cuI = dVar.cuI();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cuI != null) {
                arrayList = cuI.cve();
            }
            a(arrayList, dVar.cuJ());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.cuS() != null) {
                setSearchHint(hotSearchInfoData.cuS());
            }
            this.ivu.cxr();
            this.ivu.yG(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.ivt.cvL() != null) {
            if (!StringUtils.isNull(str)) {
                this.ivt.cvL().setSearchHint(str.trim());
            } else {
                this.ivt.cvL().setSearchHint(this.gbo.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bl blVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ivu.a(this.ivv.a(list, com.baidu.tbadk.util.f.bGo()), blVar, this.ivv.cws());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.cuL() != null && this.ivt.isPrimary() && this.fVx == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.gbo.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.cuL())) {
                this.fVx = new com.baidu.tbadk.core.dialog.a(this.gbo.getActivity());
                this.fVx.oT(2);
                this.fVx.bi(frsPrivateCommonDialogView);
                this.fVx.jm(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bua().b(a.this.gbo.getPageContext(), new String[]{dVar.cuL().bnQ()});
                        a.this.fVx.dismiss();
                        a.this.fVx = null;
                    }
                });
                this.fVx.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.fVx = null;
                    }
                });
                this.fVx.b(this.gbo.getPageContext()).brv();
            }
        }
    }

    private void cvT() {
        if (this.fVx != null) {
            this.fVx.dismiss();
            this.fVx = null;
        }
    }

    public void loadData() {
        if (this.ivu != null) {
            hs(false);
        }
    }

    public void cvU() {
        if (this.ivu != null) {
            hs(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cwk().destroy();
        if (this.ivu != null) {
            this.ivu.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.ivw != null) {
            this.ivw.onDestroy();
        }
        if (this.ivv != null) {
            this.ivv.onDestroy();
        }
        if (this.itw != null) {
            this.itw.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ivu != null) {
            this.ivu.onChangeSkinType(i);
        }
        if (this.ivD != null) {
            this.ivD.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.ivv != null) {
            this.ivv.cancelLoadData();
        }
    }

    public void hs(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.ivE && this.ivv != null && this.ivu != null) {
            String str = this.ivz;
            this.ivz = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.ivz == null || this.ivz.equals(str)) {
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
                if (this.ivv != null && this.ivv.cwq() != null && this.ivv.cwq().cuI() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.ivv.cwq().cuI().cve().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.yI(1);
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
                    com.baidu.tieba.tbadkCore.util.a.TU(currentAccount);
                }
                this.ivu.pA(this.ivv.cws());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.ivv != null) {
                        this.ivv.pr(StringUtils.isNull(this.ivz) ? false : true);
                    }
                    this.ivw.LoadData();
                } else if (z2 && this.ivv != null) {
                    this.ivv.pr(StringUtils.isNull(this.ivz) ? false : true);
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
        if (this.ivt.isAdded() && this.ivt.isPrimary()) {
            if (this.ivw != null) {
                this.ivw.onPrimary();
            }
        } else {
            cvT();
        }
        if (this.ivu != null) {
            this.ivu.onPrimary();
        }
    }

    public void onPause() {
        if (this.ivu != null && this.ivu.cxq() != null) {
            this.ivu.cxq().completePullRefresh();
        }
        if (this.ivw != null) {
            this.ivw.onPause();
        }
        if (this.ivv != null) {
            this.ivv.onPause();
        }
        if (this.ivu != null) {
            this.ivu.onPause();
        }
    }

    public void aTP() {
        if (this.ivu != null) {
            this.ivu.cI(this.mRootView);
        }
    }

    /* loaded from: classes22.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f ivM;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.ivM = null;
            this.ivM = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.ivM;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.btv().bue().mIsNeedTbs = true;
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
            a.this.pl(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.btv().buf().isRequestSuccess()) {
                    a.this.ivB = true;
                    if (a.this.ivt.isAdded() && a.this.gbo != null) {
                        a.this.gbo.showToast(a.this.gbo.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.s(false, this.ivM.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.ivM.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.ivM.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.ivM.getName()));
                    }
                    a.this.ivu.a(this.ivM, a.this.ivv.cws());
                    a.this.ivv.b(this.ivM);
                } else if (a.this.gbo != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gbo.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.ivt.isAdded()) {
                        a.this.gbo.showToast(a.this.gbo.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.pl(true);
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
    private class C0731a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f ivM;
        private aa mNetwork = null;

        public C0731a(com.baidu.tieba.enterForum.data.f fVar) {
            this.ivM = null;
            this.ivM = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.ivM;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.cuU() == 0) {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.btv().bue().mIsNeedTbs = true;
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
            super.onPostExecute((C0731a) str);
            a.this.pl(false);
            int cuU = this.ivM.cuU();
            if (this.mNetwork != null) {
                if (this.mNetwork.btv().buf().isRequestSuccess()) {
                    a.this.ivB = true;
                    if (a.this.ivt.isAdded() && a.this.gbo != null) {
                        a.this.gbo.showToast(a.this.gbo.getActivity().getString(cuU > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.ivv.pq(true);
                } else if (a.this.gbo != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.gbo.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.ivt.isAdded()) {
                        a.this.gbo.showToast(a.this.gbo.getActivity().getString(cuU > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.pl(true);
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
                    com.baidu.tieba.im.settingcache.d.cZZ().B(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bEt = bVar.bEt();
        com.baidu.tbadk.mvc.b.a bEu = bVar.bEu();
        switch (bEt) {
            case 1:
                if (this.ivC != 2 && (bEu instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bEu).getName();
                    if (au.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.gbo.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bEu).bBU() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bEu).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bEu).cuZ());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bEu).cuY().night != null && ((com.baidu.tieba.enterForum.data.f) bEu).cuY().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bEu).cuY().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bEu).cuY().day != null && ((com.baidu.tieba.enterForum.data.f) bEu).cuY().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bEu).cuY().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bEu).cvc());
                            ((com.baidu.tieba.enterForum.data.f) bEu).gd(0L);
                        }
                        this.gbo.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.gbo.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new ar("c12888"));
                        }
                        TiebaStatic.log(new ar("c13368").w("uid", TbadkApplication.getCurrentAccountId()).al("obj_type", this.ivv.cwq().getSortType() == 1 ? 2 : 1).dY("fid", ((com.baidu.tieba.enterForum.data.f) bEu).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.ivC == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.ivB = false;
                if (this.ivt.getView() == null || this.ivt.getView().getParent() == null) {
                    return true;
                }
                this.ivt.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bEu instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bEu);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(this.gbo.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gbo.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ar("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.gbo.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.gbo.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ar("c13367").dY("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dY("obj_type", "2").al("obj_locate", 1));
                this.gbo.finish();
                return true;
            case 9:
                if (this.ivu != null) {
                    this.ivu.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.ivC = 2;
                return true;
            case 11:
                this.ivC = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.ivC != 2) {
                    if (this.ivD == null) {
                        this.ivD = new com.baidu.tieba.enterForum.view.d(this.gbo.getPageContext(), this.itw);
                    }
                    if (bEu instanceof com.baidu.tieba.enterForum.data.f) {
                        this.ivD.c((com.baidu.tieba.enterForum.data.f) bEu);
                        this.ivD.RU();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bEu instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0731a((com.baidu.tieba.enterForum.data.f) bEu).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new ar("c13370").al("obj_type", ((com.baidu.tieba.enterForum.data.f) bEu).cuU() <= 0 ? 1 : 2).dY("fid", ((com.baidu.tieba.enterForum.data.f) bEu).getId()).w("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                bf.bua().b(this.gbo.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.gvF.dTh() || !(bEu instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                bf.bua().b(this.gbo.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bEu).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bEv());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bEv());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bEv());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bEs() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.gbo.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ivu != null) {
            this.ivu.setPageUniqueId(bdUniqueId);
        }
    }

    public void pn(boolean z) {
        int i;
        if (this.ivu != null && this.ivt != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ivu.setAdState(cVar);
        this.ivt.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b cvV() {
        return this.ivu;
    }
}
