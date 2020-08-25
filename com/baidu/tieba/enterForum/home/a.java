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
    private LikeModel ewX;
    private com.baidu.tieba.ueg.d fIl;
    private BaseFragmentActivity fpJ;
    private EnterForumFragment hvg;
    private EnterForumModel hvi;
    private RecentlyVisitedForumModel hvj;
    private boolean hvk;
    private String hvm;
    private long hvn;
    private boolean hvo;
    private com.baidu.tieba.enterForum.view.d hvq;
    private boolean hvr;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b hvh = null;
    private com.baidu.tbadk.core.dialog.a fkO = null;
    private boolean hvl = false;
    private int hvp = 1;
    private CustomMessageListener hvs = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.hvl = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hvt = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.hvi.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.hvh.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (a.this.hvh.isEmpty()) {
                        a.this.hvh.cc(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.hvi.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.hvi.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d hvu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bz(a.this.ewX.getErrorCode(), a.this.ewX.getErrorString())) {
                AntiHelper.bb(a.this.fpJ.getPageContext().getPageActivity(), a.this.ewX.getErrorString());
            } else if (obj != null) {
                a.this.hvi.nD(!StringUtils.isNull(a.this.hvm));
            } else if (!StringUtils.isNull(a.this.ewX.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.ewX.getErrorString());
            }
        }
    };
    private final EnterForumModel.b hvv = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.hvg != null) {
                if (aVar.type == 1) {
                    a.this.hvh.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.hvk = true;
                        com.baidu.tieba.enterForum.data.d dVar = aVar.hyh;
                        a.this.a(dVar);
                        if (dVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_LIKE_forum_sort_state", dVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.hvk) {
                        com.baidu.tieba.enterForum.data.d dVar2 = aVar.hyh;
                        a.this.hvi.c(dVar2);
                        a.this.a(dVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.fpJ.showToast(aVar.error);
                    a.this.hvh.vS(com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.hvn > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.hvn, a.this.hvi.cga() - a.this.hvn, a.this.hvi.cfY(), a.this.hvi.cfZ(), currentTimeMillis - a.this.hvi.cfX());
                    a.this.hvn = -1L;
                }
                String string = a.this.fpJ.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.hyh != null && aVar.hyh.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.hyh.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.ceG() != null) {
                        string = hotSearchInfoData.ceG();
                    }
                }
                a.this.setSearchHint(string);
                if (aVar.hyh != null && aVar.hyh.ceB() != null) {
                    a.this.hvh.b(aVar.hyh.ceB());
                }
            }
        }
    };
    private f.c esW = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.huT.loadAd();
            a.this.hvi.nD(!StringUtils.isNull(a.this.hvm));
            a.this.hvj.LoadData();
            a.this.hvi.nC(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter htj = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.hvi = null;
        this.isFirst = true;
        this.hvk = false;
        this.hvn = -1L;
        this.hvg = enterForumFragment;
        this.fpJ = enterForumFragment.getBaseFragmentActivity();
        this.htj.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.csG();
        this.hvn = System.currentTimeMillis();
        this.isFirst = true;
        this.hvk = false;
        this.hvm = "";
        this.hvi = new EnterForumModel(this.fpJ.getPageContext());
        this.hvj = new RecentlyVisitedForumModel();
        this.ewX = new LikeModel(this.fpJ.getPageContext());
        this.fIl = new com.baidu.tieba.ueg.d(this.fpJ.getPageContext());
        this.ewX.setLoadDataCallBack(this.hvu);
        this.hvi.a(this.hvv);
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.cfV().m(this.hvg.getFragmentActivity(), l.getStatusBarHeight(this.hvg.getFragmentActivity()));
        initUI();
        initListener();
        cfC();
    }

    private void initListener() {
        cfB();
        this.hvg.registerListener(this.hvt);
        this.hvg.registerListener(this.hvs);
    }

    private void cfB() {
        this.hvg.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hvh != null && a.this.hvh.ces()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void cfC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<al>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<al> run(CustomMessage<al> customMessage) {
                al alVar = new al();
                ArrayList arrayList = new ArrayList();
                if (a.this.hvi != null && a.this.hvi.cgb() != null && a.this.hvi.cgb().cew() != null && y.getCount(a.this.hvi.cgb().cew().ceS()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.hvi.cgb().cew().ceS().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fpJ.getPageContext().getPageActivity());
            aVar.zz(String.format(this.fpJ.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.fpJ.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.fpJ.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.fpJ.getPageContext());
            aVar.bhg();
        }
    }

    public void ny(boolean z) {
        if (this.mWaitingDialog == null) {
            cfD();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void cfD() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.fpJ.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.fpJ.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.hvh = new com.baidu.tieba.enterForum.view.b(this.hvg, this.mRootView, this.htj, this.hvj, this.hvi);
        this.hvh.setListPullRefreshListener(this.esW);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nz(boolean z) {
        if (this.hvh != null && this.hvg != null) {
            if (z) {
                if (this.hvg.isPrimary() && this.hvg.isResumed()) {
                    this.hvh.startPullRefresh();
                } else {
                    this.hvh.completeRefresh();
                }
            } else {
                this.hvh.completeRefresh();
            }
            this.hvh.nO(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.hvg.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar) {
        if (this.hvh != null) {
            if (dVar == null) {
                this.hvh.cc(this.mRootView);
                return;
            }
            g cew = dVar.cew();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (cew != null) {
                arrayList = cew.ceS();
            }
            a(arrayList, dVar.cex());
            b(dVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.ceG() != null) {
                setSearchHint(hotSearchInfoData.ceG());
            }
            this.hvh.che();
            this.hvh.vS(dVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.hvg.cfw() != null) {
            if (!StringUtils.isNull(str)) {
                this.hvg.cfw().setSearchHint(str.trim());
            } else {
                this.hvg.cfw().setSearchHint(this.fpJ.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.hvh.a(this.hvi.a(list, com.baidu.tbadk.util.f.bvn()), bjVar, this.hvi.cgd());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        if (dVar != null && dVar.cez() != null && this.hvg.isPrimary() && this.fkO == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.fpJ.getActivity());
            if (frsPrivateCommonDialogView.b(dVar.cez())) {
                this.fkO = new com.baidu.tbadk.core.dialog.a(this.fpJ.getActivity());
                this.fkO.nw(2);
                this.fkO.aX(frsPrivateCommonDialogView);
                this.fkO.ig(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bju().b(a.this.fpJ.getPageContext(), new String[]{dVar.cez().bdF()});
                        a.this.fkO.dismiss();
                        a.this.fkO = null;
                    }
                });
                this.fkO.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.fkO = null;
                    }
                });
                this.fkO.b(this.fpJ.getPageContext()).bhg();
            }
        }
    }

    private void cfE() {
        if (this.fkO != null) {
            this.fkO.dismiss();
            this.fkO = null;
        }
    }

    public void loadData() {
        if (this.hvh != null) {
            gj(false);
        }
    }

    public void cfF() {
        if (this.hvh != null) {
            gj(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.cfV().destroy();
        if (this.hvh != null) {
            this.hvh.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.hvj != null) {
            this.hvj.onDestroy();
        }
        if (this.hvi != null) {
            this.hvi.onDestroy();
        }
        if (this.htj != null) {
            this.htj.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hvh != null) {
            this.hvh.onChangeSkinType(i);
        }
        if (this.hvq != null) {
            this.hvq.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.hvi != null) {
            this.hvi.cancelLoadData();
        }
    }

    public void gj(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.hvr && this.hvi != null && this.hvh != null) {
            String str = this.hvm;
            this.hvm = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.hvm == null || this.hvm.equals(str)) {
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
                if (this.hvi != null && this.hvi.cgb() != null && this.hvi.cgb().cew() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.hvi.cgb().cew().ceS().iterator();
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
                this.hvh.nN(this.hvi.cgd());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.hvi != null) {
                        this.hvi.nE(StringUtils.isNull(this.hvm) ? false : true);
                    }
                    this.hvj.LoadData();
                } else if (z2 && this.hvi != null) {
                    this.hvi.nE(StringUtils.isNull(this.hvm) ? false : true);
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
        if (this.hvg.isAdded() && this.hvg.isPrimary()) {
            if (this.hvj != null) {
                this.hvj.onPrimary();
            }
        } else {
            cfE();
        }
        if (this.hvh != null) {
            this.hvh.onPrimary();
        }
    }

    public void onPause() {
        if (this.hvh != null && this.hvh.chd() != null) {
            this.hvh.chd().completePullRefresh();
        }
        if (this.hvj != null) {
            this.hvj.onPause();
        }
        if (this.hvi != null) {
            this.hvi.onPause();
        }
        if (this.hvh != null) {
            this.hvh.onPause();
        }
    }

    public void aJE() {
        if (this.hvh != null) {
            this.hvh.cb(this.mRootView);
        }
    }

    /* loaded from: classes16.dex */
    private class b extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f hvz;
        private aa mNetwork = null;

        public b(com.baidu.tieba.enterForum.data.f fVar) {
            this.hvz = null;
            this.hvz = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hvz;
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
            a.this.ny(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                    a.this.hvo = true;
                    if (a.this.hvg.isAdded() && a.this.fpJ != null) {
                        a.this.fpJ.showToast(a.this.fpJ.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.q(false, this.hvz.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.hvz.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.hvz.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.hvz.getName()));
                    }
                    a.this.hvh.a(this.hvz, a.this.hvi.cgd());
                    a.this.hvi.b(this.hvz);
                } else if (a.this.fpJ != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fpJ.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hvg.isAdded()) {
                        a.this.fpJ.showToast(a.this.fpJ.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.ny(true);
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
        private com.baidu.tieba.enterForum.data.f hvz;
        private aa mNetwork = null;

        public C0669a(com.baidu.tieba.enterForum.data.f fVar) {
            this.hvz = null;
            this.hvz = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.hvz;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.ceI() == 0) {
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
            a.this.ny(false);
            int ceI = this.hvz.ceI();
            if (this.mNetwork != null) {
                if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                    a.this.hvo = true;
                    if (a.this.hvg.isAdded() && a.this.fpJ != null) {
                        a.this.fpJ.showToast(a.this.fpJ.getActivity().getString(ceI > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.hvi.nD(true);
                } else if (a.this.fpJ != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.fpJ.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.hvg.isAdded()) {
                        a.this.fpJ.showToast(a.this.fpJ.getActivity().getString(ceI > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.ny(true);
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
                    com.baidu.tieba.im.settingcache.d.cIj().z(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int btu = bVar.btu();
        com.baidu.tbadk.mvc.b.a btv = bVar.btv();
        switch (btu) {
            case 1:
                if (this.hvp != 2 && (btv instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) btv).getName();
                    if (at.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.fpJ.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((com.baidu.tieba.enterForum.data.f) btv).brh() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((com.baidu.tieba.enterForum.data.f) btv).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((com.baidu.tieba.enterForum.data.f) btv).ceN());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((com.baidu.tieba.enterForum.data.f) btv).ceM().night != null && ((com.baidu.tieba.enterForum.data.f) btv).ceM().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) btv).ceM().night.pattern_image);
                                    }
                                } else if (((com.baidu.tieba.enterForum.data.f) btv).ceM().day != null && ((com.baidu.tieba.enterForum.data.f) btv).ceM().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((com.baidu.tieba.enterForum.data.f) btv).ceM().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((com.baidu.tieba.enterForum.data.f) btv).ceQ());
                            ((com.baidu.tieba.enterForum.data.f) btv).ey(0L);
                        }
                        this.fpJ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.fpJ.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new aq("c12888"));
                        }
                        TiebaStatic.log(new aq("c13368").u("uid", TbadkApplication.getCurrentAccountId()).ai("obj_type", this.hvi.cgb().getSortType() == 1 ? 2 : 1).dD("fid", ((com.baidu.tieba.enterForum.data.f) btv).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.hvp == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                this.hvo = false;
                if (this.hvg.getView() == null || this.hvg.getView().getParent() == null) {
                    return true;
                }
                this.hvg.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (btv instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) btv);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(this.fpJ.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fpJ.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.fpJ.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.fpJ.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aq("c13367").dD("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dD("obj_type", "2").ai("obj_locate", 1));
                this.fpJ.finish();
                return true;
            case 9:
                if (this.hvh != null) {
                    this.hvh.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.hvp = 2;
                return true;
            case 11:
                this.hvp = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.hvp != 2) {
                    if (this.hvq == null) {
                        this.hvq = new com.baidu.tieba.enterForum.view.d(this.fpJ.getPageContext(), this.htj);
                    }
                    if (btv instanceof com.baidu.tieba.enterForum.data.f) {
                        this.hvq.c((com.baidu.tieba.enterForum.data.f) btv);
                        this.hvq.Nv();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (btv instanceof com.baidu.tieba.enterForum.data.f) {
                    new C0669a((com.baidu.tieba.enterForum.data.f) btv).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    TiebaStatic.log(new aq("c13370").ai("obj_type", ((com.baidu.tieba.enterForum.data.f) btv).ceI() <= 0 ? 1 : 2).dD("fid", ((com.baidu.tieba.enterForum.data.f) btv).getId()).u("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                be.bju().b(this.fpJ.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fIl.dAq() || !(btv instanceof com.baidu.tieba.enterForum.data.f)) {
                    return true;
                }
                be.bju().b(this.fpJ.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((com.baidu.tieba.enterForum.data.f) btv).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.btw());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.btw());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.c) bVar.btw());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean btt() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.fpJ.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hvh != null) {
            this.hvh.setPageUniqueId(bdUniqueId);
        }
    }

    public void nA(boolean z) {
        int i;
        if (this.hvh != null && this.hvg != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hvh.setAdState(cVar);
        this.hvg.setAdState(cVar);
    }

    public com.baidu.tieba.enterForum.view.b cfG() {
        return this.hvh;
    }
}
