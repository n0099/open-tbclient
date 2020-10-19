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
    private LikeModel eLp;
    private BaseFragmentActivity fFk;
    private com.baidu.tieba.ueg.d fXV;
    private EnterForumFragment hRm;
    private EnterForumModel hRo;
    private RecentlyVisitedForumModel hRp;
    private boolean hRq;
    private String hRs;
    private long hRt;
    private boolean hRu;
    private com.baidu.tieba.enterForum.view.d hRw;
    private boolean hRx;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b hRn = null;
    private com.baidu.tbadk.core.dialog.a fzZ = null;
    private boolean hRr = false;
    private int hRv = 1;
    private CustomMessageListener hRy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.hRr = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hRz = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.hRo.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.hRn.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.hRn.isEmpty()) {
                        a.this.hRn.cp(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.hRo.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.hRo.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d hRA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bM(a.this.eLp.getErrorCode(), a.this.eLp.getErrorString())) {
                AntiHelper.bk(a.this.fFk.getPageContext().getPageActivity(), a.this.eLp.getErrorString());
            } else if (obj != null) {
                a.this.hRo.oq(!StringUtils.isNull(a.this.hRs));
            } else if (!StringUtils.isNull(a.this.eLp.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.eLp.getErrorString());
            }
        }
    };
    private final EnterForumModel.b hRB = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.hRm != null) {
                if (aVar.type == 1) {
                    a.this.hRn.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.hRq = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.hUk;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.hRq) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.hUk;
                        a.this.hRo.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.fFk.showToast(aVar.error);
                    a.this.hRn.wX(com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.hRt > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.hRt, a.this.hRo.cmO() - a.this.hRt, a.this.hRo.cmM(), a.this.hRo.cmN(), currentTimeMillis - a.this.hRo.cmL());
                    a.this.hRt = -1L;
                }
                String string = a.this.fFk.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.hUk != null && aVar.hUk.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.hUk.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.blO().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.cls() != null) {
                        string = hotSearchInfoData.cls();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.hUk != null && aVar.hUk.cln() != null) {
                    a.this.hRn.b(aVar.hUk.cln());
                }
            }
        }
    };
    private f.c eHp = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.hQZ.loadAd();
            a.this.hRo.oq(!StringUtils.isNull(a.this.hRs));
            a.this.hRp.LoadData();
            a.this.hRo.op(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter hPp = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.hRo = null;
        this.isFirst = true;
        this.hRq = false;
        this.hRt = -1L;
        this.hRm = enterForumFragment;
        this.fFk = enterForumFragment.getBaseFragmentActivity();
        this.hPp.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.czt();
        this.hRt = System.currentTimeMillis();
        this.isFirst = true;
        this.hRq = false;
        this.hRs = "";
        this.hRo = new EnterForumModel(this.fFk.getPageContext());
        this.hRp = new RecentlyVisitedForumModel();
        this.eLp = new LikeModel(this.fFk.getPageContext());
        this.fXV = new com.baidu.tieba.ueg.d(this.fFk.getPageContext());
        this.eLp.setLoadDataCallBack(this.hRA);
        this.hRo.a(this.hRB);
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cmJ().m(this.hRm.getFragmentActivity(), l.getStatusBarHeight(this.hRm.getFragmentActivity()));
        initUI();
        initListener();
        cmq();
    }

    private void initListener() {
        cmp();
        this.hRm.registerListener(this.hRz);
        this.hRm.registerListener(this.hRy);
    }

    private void cmp() {
        this.hRm.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hRn != null && a.this.hRn.cle()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void cmq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<al>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<al> run(CustomMessage<al> customMessage) {
                al alVar = new al();
                ArrayList arrayList = new ArrayList();
                if (a.this.hRo != null && a.this.hRo.cmP() != null && a.this.hRo.cmP().cli() != null && y.getCount(a.this.hRo.cmP().cli().clE()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.hRo.cmP().cli().clE().iterator();
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
                    alVar.aR(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, alVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fFk.getPageContext().getPageActivity());
            aVar.AH(String.format(this.fFk.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.fFk.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.fFk.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.oc(R.color.cp_cont_b);
            aVar.b(this.fFk.getPageContext());
            aVar.bkJ();
        }
    }

    public void ol(boolean z) {
        if (this.mWaitingDialog == null) {
            cmr();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void cmr() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.fFk.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.fFk.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.hRn = new com.baidu.tieba.enterForum.view.b(this.hRm, this.mRootView, this.hPp, this.hRp, this.hRo);
        this.hRn.setListPullRefreshListener(this.eHp);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void om(boolean z) {
        if (this.hRn != null && this.hRm != null) {
            if (z) {
                if (this.hRm.isPrimary() && this.hRm.isResumed()) {
                    this.hRn.startPullRefresh();
                } else {
                    this.hRn.completeRefresh();
                }
            } else {
                this.hRn.completeRefresh();
            }
            this.hRn.oB(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.hRm.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.hRn != null) {
            if (dVar == null) {
                this.hRn.cp(this.mRootView);
                return;
            }
            g cli = dVar.cli();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cli != null) {
                arrayList = cli.clE();
            }
            a(arrayList, dVar.clj());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.cls() != null) {
                setSearchHint(hotSearchInfoData.cls());
            }
            this.hRn.cnQ();
            this.hRn.wX(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.hRm.cmk() != null) {
            if (!StringUtils.isNull(str)) {
                this.hRm.cmk().setSearchHint(str.trim());
            } else {
                this.hRm.cmk().setSearchHint(this.fFk.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.hRn.a(this.hRo.a(list, com.baidu.tbadk.util.f.bzc()), bjVar, this.hRo.cmR());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.cll() != null && this.hRm.isPrimary() && this.fzZ == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.fFk.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.cll())) {
                this.fzZ = new com.baidu.tbadk.core.dialog.a(this.fFk.getActivity());
                this.fzZ.oe(2);
                this.fzZ.ba(frsPrivateCommonDialogView);
                this.fzZ.iA(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bmY().b(a.this.fFk.getPageContext(), new String[]{dVar.cll().bhi()});
                        a.this.fzZ.dismiss();
                        a.this.fzZ = null;
                    }
                });
                this.fzZ.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.fzZ = null;
                    }
                });
                this.fzZ.b(this.fFk.getPageContext()).bkJ();
            }
        }
    }

    private void cms() {
        if (this.fzZ != null) {
            this.fzZ.dismiss();
            this.fzZ = null;
        }
    }

    public void loadData() {
        if (this.hRn != null) {
            gE(false);
        }
    }

    public void cmt() {
        if (this.hRn != null) {
            gE(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cmJ().destroy();
        if (this.hRn != null) {
            this.hRn.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.hRp != null) {
            this.hRp.onDestroy();
        }
        if (this.hRo != null) {
            this.hRo.onDestroy();
        }
        if (this.hPp != null) {
            this.hPp.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hRn != null) {
            this.hRn.onChangeSkinType(i);
        }
        if (this.hRw != null) {
            this.hRw.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.hRo != null) {
            this.hRo.cancelLoadData();
        }
    }

    public void gE(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.hRx && this.hRo != null && this.hRn != null) {
            String str = this.hRs;
            this.hRs = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.hRs == null || this.hRs.equals(str)) {
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
                if (this.hRo != null && this.hRo.cmP() != null && this.hRo.cmP().cli() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.hRo.cmP().cli().clE().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.wZ(1);
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
                    com.baidu.tieba.tbadkCore.util.a.Se(currentAccount);
                }
                this.hRn.oA(this.hRo.cmR());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.hRo != null) {
                        this.hRo.or(StringUtils.isNull(this.hRs) ? false : true);
                    }
                    this.hRp.LoadData();
                } else if (z2 && this.hRo != null) {
                    this.hRo.or(StringUtils.isNull(this.hRs) ? false : true);
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
        if (this.hRm.isAdded() && this.hRm.isPrimary()) {
            if (this.hRp != null) {
                this.hRp.onPrimary();
            }
        } else {
            cms();
        }
        if (this.hRn != null) {
            this.hRn.onPrimary();
        }
    }

    public void onPause() {
        if (this.hRn != null && this.hRn.cnP() != null) {
            this.hRn.cnP().completePullRefresh();
        }
        if (this.hRp != null) {
            this.hRp.onPause();
        }
        if (this.hRo != null) {
            this.hRo.onPause();
        }
        if (this.hRn != null) {
            this.hRn.onPause();
        }
    }

    public void aMY() {
        if (this.hRn != null) {
            this.hRn.co(this.mRootView);
        }
    }

    /* loaded from: classes22.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hRF;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.hRF = null;
            this.hRF = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hRF;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.bmu().bna().mIsNeedTbs = true;
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
            a.this.ol(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.bmu().bnb().isRequestSuccess()) {
                    a.this.hRu = true;
                    if (a.this.hRm.isAdded() && a.this.fFk != null) {
                        a.this.fFk.showToast(a.this.fFk.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.q(false, this.hRF.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.hRF.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.hRF.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.hRF.getName()));
                    }
                    a.this.hRn.a(this.hRF, a.this.hRo.cmR());
                    a.this.hRo.b(this.hRF);
                } else if (a.this.fFk != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fFk.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hRm.isAdded()) {
                        a.this.fFk.showToast(a.this.fFk.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.ol(true);
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
    private class C0684a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hRF;
        private aa mNetwork = null;

        public C0684a(com.baidu.tieba.enterForum.data.f fVar) {
            this.hRF = null;
            this.hRF = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hRF;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.clu() == 0) {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.bmu().bna().mIsNeedTbs = true;
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
            super.onPostExecute((C0684a) str);
            a.this.ol(false);
            int clu = this.hRF.clu();
            if (this.mNetwork != null) {
                if (this.mNetwork.bmu().bnb().isRequestSuccess()) {
                    a.this.hRu = true;
                    if (a.this.hRm.isAdded() && a.this.fFk != null) {
                        a.this.fFk.showToast(a.this.fFk.getActivity().getString(clu > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.hRo.oq(true);
                } else if (a.this.fFk != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fFk.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hRm.isAdded()) {
                        a.this.fFk.showToast(a.this.fFk.getActivity().getString(clu > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.ol(true);
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
                    com.baidu.tieba.im.settingcache.d.cPy().z(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int bxj = bVar.bxj();
        com.baidu.tbadk.mvc.b.a bxk = bVar.bxk();
        switch (bxj) {
            case 1:
                if (this.hRv != 2 && (bxk instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) bxk).getName();
                    if (at.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.fFk.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) bxk).buM() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) bxk).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) bxk).clz());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) bxk).cly().night != null && ((com.baidu.tieba.enterForum.data.f) bxk).cly().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bxk).cly().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) bxk).cly().day != null && ((com.baidu.tieba.enterForum.data.f) bxk).cly().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) bxk).cly().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) bxk).clC());
                            ((com.baidu.tieba.enterForum.data.f) bxk).eZ(0L);
                        }
                        this.fFk.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.fFk.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new aq("c12888"));
                        }
                        TiebaStatic.log(new aq("c13368").u("uid", TbadkApplication.getCurrentAccountId()).aj("obj_type", this.hRo.cmP().getSortType() == 1 ? 2 : 1).dK("fid", ((com.baidu.tieba.enterForum.data.f) bxk).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.hRv == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.hRu = false;
                if (this.hRm.getView() == null || this.hRm.getView().getParent() == null) {
                    return true;
                }
                this.hRm.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (bxk instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) bxk);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(this.fFk.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fFk.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.fFk.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fFk.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("c13367").dK("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dK("obj_type", "2").aj("obj_locate", 1));
                this.fFk.finish();
                return true;
            case 9:
                if (this.hRn != null) {
                    this.hRn.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.hRv = 2;
                return true;
            case 11:
                this.hRv = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.hRv != 2) {
                    if (this.hRw == null) {
                        this.hRw = new com.baidu.tieba.enterForum.view.d(this.fFk.getPageContext(), this.hPp);
                    }
                    if (bxk instanceof com.baidu.tieba.enterForum.data.f) {
                        this.hRw.c((com.baidu.tieba.enterForum.data.f) bxk);
                        this.hRw.Pd();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (bxk instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0684a((com.baidu.tieba.enterForum.data.f) bxk).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new aq("c13370").aj("obj_type", ((com.baidu.tieba.enterForum.data.f) bxk).clu() <= 0 ? 1 : 2).dK("fid", ((com.baidu.tieba.enterForum.data.f) bxk).getId()).u("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                be.bmY().b(this.fFk.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fXV.dIf() || !(bxk instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                be.bmY().b(this.fFk.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) bxk).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bxl());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bxl());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.bxl());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bxi() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.fFk.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hRn != null) {
            this.hRn.setPageUniqueId(bdUniqueId);
        }
    }

    public void on(boolean z) {
        int i;
        if (this.hRn != null && this.hRm != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hRn.setAdState(cVar);
        this.hRm.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b cmu() {
        return this.hRn;
    }
}
