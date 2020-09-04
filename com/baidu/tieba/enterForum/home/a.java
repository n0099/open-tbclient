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
/* loaded from: classes16.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel exb;
    private com.baidu.tieba.ueg.d fIp;
    private BaseFragmentActivity fpN;
    private EnterForumFragment hvm;
    private EnterForumModel hvo;
    private RecentlyVisitedForumModel hvp;
    private boolean hvq;
    private String hvs;
    private long hvt;
    private boolean hvu;
    private com.baidu.tieba.enterForum.view.d hvw;
    private boolean hvx;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b hvn = null;
    private com.baidu.tbadk.core.dialog.a fkS = null;
    private boolean hvr = false;
    private int hvv = 1;
    private CustomMessageListener hvy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.hvr = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hvz = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.hvo.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.hvn.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.hvn.isEmpty()) {
                        a.this.hvn.cc(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.hvo.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.hvo.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d hvA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.by(a.this.exb.getErrorCode(), a.this.exb.getErrorString())) {
                AntiHelper.bb(a.this.fpN.getPageContext().getPageActivity(), a.this.exb.getErrorString());
            } else if (obj != null) {
                a.this.hvo.nF(!StringUtils.isNull(a.this.hvs));
            } else if (!StringUtils.isNull(a.this.exb.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.exb.getErrorString());
            }
        }
    };
    private final EnterForumModel.b hvB = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.hvm != null) {
                if (aVar.type == 1) {
                    a.this.hvn.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.hvq = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.hyn;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.hvq) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.hyn;
                        a.this.hvo.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.fpN.showToast(aVar.error);
                    a.this.hvn.vS(com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.hvt > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.hvt, a.this.hvo.cgb() - a.this.hvt, a.this.hvo.cfZ(), a.this.hvo.cga(), currentTimeMillis - a.this.hvo.cfY());
                    a.this.hvt = -1L;
                }
                String string = a.this.fpN.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.hyn != null && aVar.hyn.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.hyn.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.ceH() != null) {
                        string = hotSearchInfoData.ceH();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.hyn != null && aVar.hyn.ceC() != null) {
                    a.this.hvn.b(aVar.hyn.ceC());
                }
            }
        }
    };
    private f.c eta = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.huZ.loadAd();
            a.this.hvo.nF(!StringUtils.isNull(a.this.hvs));
            a.this.hvp.LoadData();
            a.this.hvo.nE(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter htp = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.hvo = null;
        this.isFirst = true;
        this.hvq = false;
        this.hvt = -1L;
        this.hvm = enterForumFragment;
        this.fpN = enterForumFragment.getBaseFragmentActivity();
        this.htp.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.csH();
        this.hvt = System.currentTimeMillis();
        this.isFirst = true;
        this.hvq = false;
        this.hvs = "";
        this.hvo = new EnterForumModel(this.fpN.getPageContext());
        this.hvp = new RecentlyVisitedForumModel();
        this.exb = new LikeModel(this.fpN.getPageContext());
        this.fIp = new com.baidu.tieba.ueg.d(this.fpN.getPageContext());
        this.exb.setLoadDataCallBack(this.hvA);
        this.hvo.a(this.hvB);
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cfW().m(this.hvm.getFragmentActivity(), l.getStatusBarHeight(this.hvm.getFragmentActivity()));
        initUI();
        initListener();
        cfD();
    }

    private void initListener() {
        cfC();
        this.hvm.registerListener(this.hvz);
        this.hvm.registerListener(this.hvy);
    }

    private void cfC() {
        this.hvm.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hvn != null && a.this.hvn.cet()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void cfD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<al>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<al> run(CustomMessage<al> customMessage) {
                al alVar = new al();
                ArrayList arrayList = new ArrayList();
                if (a.this.hvo != null && a.this.hvo.cgc() != null && a.this.hvo.cgc().cex() != null && y.getCount(a.this.hvo.cgc().cex().ceT()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.hvo.cgc().cex().ceT().iterator();
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
                    alVar.aK(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, alVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fpN.getPageContext().getPageActivity());
            aVar.zA(String.format(this.fpN.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.fpN.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.fpN.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.nu(R.color.cp_cont_b);
            aVar.b(this.fpN.getPageContext());
            aVar.bhg();
        }
    }

    public void nA(boolean z) {
        if (this.mWaitingDialog == null) {
            cfE();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void cfE() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.fpN.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.fpN.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.hvn = new com.baidu.tieba.enterForum.view.b(this.hvm, this.mRootView, this.htp, this.hvp, this.hvo);
        this.hvn.setListPullRefreshListener(this.eta);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nB(boolean z) {
        if (this.hvn != null && this.hvm != null) {
            if (z) {
                if (this.hvm.isPrimary() && this.hvm.isResumed()) {
                    this.hvn.startPullRefresh();
                } else {
                    this.hvn.completeRefresh();
                }
            } else {
                this.hvn.completeRefresh();
            }
            this.hvn.nQ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.hvm.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.hvn != null) {
            if (dVar == null) {
                this.hvn.cc(this.mRootView);
                return;
            }
            g cex = dVar.cex();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cex != null) {
                arrayList = cex.ceT();
            }
            a(arrayList, dVar.cey());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.ceH() != null) {
                setSearchHint(hotSearchInfoData.ceH());
            }
            this.hvn.chf();
            this.hvn.vS(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.hvm.cfx() != null) {
            if (!StringUtils.isNull(str)) {
                this.hvm.cfx().setSearchHint(str.trim());
            } else {
                this.hvm.cfx().setSearchHint(this.fpN.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.hvn.a(this.hvo.a(list, com.baidu.tbadk.util.f.bvo()), bjVar, this.hvo.cge());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.ceA() != null && this.hvm.isPrimary() && this.fkS == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.fpN.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.ceA())) {
                this.fkS = new com.baidu.tbadk.core.dialog.a(this.fpN.getActivity());
                this.fkS.nw(2);
                this.fkS.aX(frsPrivateCommonDialogView);
                this.fkS.ih(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bju().b(a.this.fpN.getPageContext(), new String[]{dVar.ceA().bdF()});
                        a.this.fkS.dismiss();
                        a.this.fkS = null;
                    }
                });
                this.fkS.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.fkS = null;
                    }
                });
                this.fkS.b(this.fpN.getPageContext()).bhg();
            }
        }
    }

    private void cfF() {
        if (this.fkS != null) {
            this.fkS.dismiss();
            this.fkS = null;
        }
    }

    public void loadData() {
        if (this.hvn != null) {
            gk(false);
        }
    }

    public void cfG() {
        if (this.hvn != null) {
            gk(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cfW().destroy();
        if (this.hvn != null) {
            this.hvn.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.hvp != null) {
            this.hvp.onDestroy();
        }
        if (this.hvo != null) {
            this.hvo.onDestroy();
        }
        if (this.htp != null) {
            this.htp.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hvn != null) {
            this.hvn.onChangeSkinType(i);
        }
        if (this.hvw != null) {
            this.hvw.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.hvo != null) {
            this.hvo.cancelLoadData();
        }
    }

    public void gk(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.hvx && this.hvo != null && this.hvn != null) {
            String str = this.hvs;
            this.hvs = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.hvs == null || this.hvs.equals(str)) {
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
                if (this.hvo != null && this.hvo.cgc() != null && this.hvo.cgc().cex() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.hvo.cgc().cex().ceT().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.vU(1);
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
                    com.baidu.tieba.tbadkCore.util.a.QQ(currentAccount);
                }
                this.hvn.nP(this.hvo.cge());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.hvo != null) {
                        this.hvo.nG(StringUtils.isNull(this.hvs) ? false : true);
                    }
                    this.hvp.LoadData();
                } else if (z2 && this.hvo != null) {
                    this.hvo.nG(StringUtils.isNull(this.hvs) ? false : true);
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
        if (this.hvm.isAdded() && this.hvm.isPrimary()) {
            if (this.hvp != null) {
                this.hvp.onPrimary();
            }
        } else {
            cfF();
        }
        if (this.hvn != null) {
            this.hvn.onPrimary();
        }
    }

    public void onPause() {
        if (this.hvn != null && this.hvn.che() != null) {
            this.hvn.che().completePullRefresh();
        }
        if (this.hvp != null) {
            this.hvp.onPause();
        }
        if (this.hvo != null) {
            this.hvo.onPause();
        }
        if (this.hvn != null) {
            this.hvn.onPause();
        }
    }

    public void aJE() {
        if (this.hvn != null) {
            this.hvn.cb(this.mRootView);
        }
    }

    /* loaded from: classes16.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hvF;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.hvF = null;
            this.hvF = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hvF;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.biQ().bjv().mIsNeedTbs = true;
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
            a.this.nA(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                    a.this.hvu = true;
                    if (a.this.hvm.isAdded() && a.this.fpN != null) {
                        a.this.fpN.showToast(a.this.fpN.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.q(false, this.hvF.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.hvF.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.hvF.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.hvF.getName()));
                    }
                    a.this.hvn.a(this.hvF, a.this.hvo.cge());
                    a.this.hvo.b(this.hvF);
                } else if (a.this.fpN != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fpN.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hvm.isAdded()) {
                        a.this.fpN.showToast(a.this.fpN.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.nA(true);
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
    private class C0669a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hvF;
        private aa mNetwork = null;

        public C0669a(com.baidu.tieba.enterForum.data.f fVar) {
            this.hvF = null;
            this.hvF = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hvF;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.ceJ() == 0) {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.biQ().bjv().mIsNeedTbs = true;
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
            super.onPostExecute((C0669a) str);
            a.this.nA(false);
            int ceJ = this.hvF.ceJ();
            if (this.mNetwork != null) {
                if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                    a.this.hvu = true;
                    if (a.this.hvm.isAdded() && a.this.fpN != null) {
                        a.this.fpN.showToast(a.this.fpN.getActivity().getString(ceJ > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.hvo.nF(true);
                } else if (a.this.fpN != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fpN.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hvm.isAdded()) {
                        a.this.fpN.showToast(a.this.fpN.getActivity().getString(ceJ > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.nA(true);
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
                    com.baidu.tieba.im.settingcache.d.cIk().z(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int btv = bVar.btv();
        com.baidu.tbadk.mvc.b.a btw = bVar.btw();
        switch (btv) {
            case 1:
                if (this.hvv != 2 && (btw instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) btw).getName();
                    if (at.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.fpN.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) btw).bri() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) btw).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) btw).ceO());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) btw).ceN().night != null && ((com.baidu.tieba.enterForum.data.f) btw).ceN().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) btw).ceN().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) btw).ceN().day != null && ((com.baidu.tieba.enterForum.data.f) btw).ceN().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) btw).ceN().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) btw).ceR());
                            ((com.baidu.tieba.enterForum.data.f) btw).ey(0L);
                        }
                        this.fpN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.fpN.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new aq("c12888"));
                        }
                        TiebaStatic.log(new aq("c13368").u("uid", TbadkApplication.getCurrentAccountId()).ai("obj_type", this.hvo.cgc().getSortType() == 1 ? 2 : 1).dD("fid", ((com.baidu.tieba.enterForum.data.f) btw).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.hvv == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.hvu = false;
                if (this.hvm.getView() == null || this.hvm.getView().getParent() == null) {
                    return true;
                }
                this.hvm.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (btw instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) btw);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(this.fpN.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fpN.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.fpN.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fpN.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("c13367").dD("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dD("obj_type", "2").ai("obj_locate", 1));
                this.fpN.finish();
                return true;
            case 9:
                if (this.hvn != null) {
                    this.hvn.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.hvv = 2;
                return true;
            case 11:
                this.hvv = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.hvv != 2) {
                    if (this.hvw == null) {
                        this.hvw = new com.baidu.tieba.enterForum.view.d(this.fpN.getPageContext(), this.htp);
                    }
                    if (btw instanceof com.baidu.tieba.enterForum.data.f) {
                        this.hvw.c((com.baidu.tieba.enterForum.data.f) btw);
                        this.hvw.Nv();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (btw instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0669a((com.baidu.tieba.enterForum.data.f) btw).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new aq("c13370").ai("obj_type", ((com.baidu.tieba.enterForum.data.f) btw).ceJ() <= 0 ? 1 : 2).dD("fid", ((com.baidu.tieba.enterForum.data.f) btw).getId()).u("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                be.bju().b(this.fpN.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fIp.dAz() || !(btw instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                be.bju().b(this.fpN.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) btw).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.btx());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.btx());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.btx());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean btu() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.fpN.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hvn != null) {
            this.hvn.setPageUniqueId(bdUniqueId);
        }
    }

    public void nC(boolean z) {
        int i;
        if (this.hvn != null && this.hvm != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hvn.setAdState(cVar);
        this.hvm.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b cfH() {
        return this.hvn;
    }
}
