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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity dWt;
    private LikeModel dfN;
    private EnterForumFragment fSC;
    private EnterForumModel fSE;
    private RecentlyVisitedForumModel fSF;
    private com.baidu.tieba.ueg.d fSG;
    private boolean fSH;
    private String fSJ;
    private long fSK;
    private boolean fSL;
    private com.baidu.tieba.enterForum.view.d fSN;
    private boolean fSO;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b fSD = null;
    private com.baidu.tbadk.core.dialog.a dPv = null;
    private boolean fSI = false;
    private int fSM = 1;
    private CustomMessageListener fSP = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.fSI = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fSQ = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.fSE.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.fSD.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.dWt.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.dWt.showToast(errorString);
                    if (a.this.fSD.isEmpty()) {
                        a.this.fSD.bL(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.fSE.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.fSE.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d fSR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bc(a.this.dfN.getErrorCode(), a.this.dfN.getErrorString())) {
                AntiHelper.bn(a.this.dWt.getPageContext().getPageActivity(), a.this.dfN.getErrorString());
            } else if (obj != null) {
                a.this.fSE.kE(!StringUtils.isNull(a.this.fSJ));
            } else if (!StringUtils.isNull(a.this.dfN.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.dfN.getErrorString());
            }
        }
    };
    private final EnterForumModel.b fSS = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.fSC != null) {
                if (aVar.type == 1) {
                    a.this.fSD.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.fSH = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.fUf;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.fSH) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.fUf;
                        a.this.fSE.d(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.dWt.showToast(aVar.error);
                    a.this.fSD.rD(com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.fSK > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.fSK, a.this.fSE.bxi() - a.this.fSK, a.this.fSE.bxg(), a.this.fSE.bxh(), currentTimeMillis - a.this.fSE.bxf());
                    a.this.fSK = -1L;
                }
                String string = a.this.dWt.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.fUf != null && aVar.fUf.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.fUf.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bwj() != null) {
                        string = hotSearchInfoData.bwj();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private g.c dcC = new g.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.fSo.loadAd();
            a.this.fSE.kE(!StringUtils.isNull(a.this.fSJ));
            a.this.fSF.LoadData();
            a.this.fSE.kD(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter fQN = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aZL();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.fSE = null;
        this.isFirst = true;
        this.fSH = false;
        this.fSK = -1L;
        this.fSC = enterForumFragment;
        this.dWt = enterForumFragment.getBaseFragmentActivity();
        this.fQN.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bIr();
        this.fSK = System.currentTimeMillis();
        this.isFirst = true;
        this.fSH = false;
        this.fSJ = "";
        this.fSE = new EnterForumModel(this.dWt.getPageContext());
        this.fSF = new RecentlyVisitedForumModel();
        this.dfN = new LikeModel(this.dWt.getPageContext());
        this.fSG = new com.baidu.tieba.ueg.d(this.dWt.getPageContext());
        this.dfN.setLoadDataCallBack(this.fSR);
        this.fSE.a(this.fSS);
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.bxd().init(this.fSC.getFragmentActivity(), l.getStatusBarHeight(this.fSC.getFragmentActivity()));
        initUI();
        initListener();
        bwK();
    }

    private void initListener() {
        bwJ();
        this.fSC.registerListener(this.fSQ);
        this.fSC.registerListener(this.fSP);
    }

    private static void aZL() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, 1002400, Config.FORUM_RECOMMEND, forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void bwJ() {
        this.fSC.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fSD != null && a.this.fSD.bvX()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bwK() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<af>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<af> run(CustomMessage<af> customMessage) {
                af afVar = new af();
                ArrayList arrayList = new ArrayList();
                if (a.this.fSE != null && a.this.fSE.bxj() != null && a.this.fSE.bxj().bwb() != null && v.getCount(a.this.fSE.bxj().bwb().bwu()) > 0) {
                    Iterator<f> it = a.this.fSE.bxj().bwb().bwu().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.f.b.toLong(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    afVar.av(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, afVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dWt.getPageContext().getPageActivity());
            aVar.sC(String.format(this.dWt.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.dWt.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.dWt.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.jG(R.color.cp_cont_b);
            aVar.b(this.dWt.getPageContext());
            aVar.aCp();
        }
    }

    public void ky(boolean z) {
        if (this.mWaitingDialog == null) {
            bwL();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bwL() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.dWt.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.dWt.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.fSD = new com.baidu.tieba.enterForum.view.b(this.fSC, this.mRootView, this.fQN, this.fSF, this.fSE);
        this.fSD.setListPullRefreshListener(this.dcC);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void kz(boolean z) {
        if (this.fSD != null && this.fSC != null) {
            if (z) {
                if (this.fSC.isPrimary() && this.fSC.isResumed()) {
                    this.fSD.startPullRefresh();
                } else {
                    this.fSD.completeRefresh();
                }
            } else {
                this.fSD.completeRefresh();
            }
            this.fSD.kL(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.fSC.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.fSD != null) {
            if (cVar == null) {
                this.fSD.bL(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g bwb = cVar.bwb();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bwb != null) {
                arrayList = bwb.bwu();
            }
            bN(arrayList);
            if (b(cVar)) {
                this.fSD.bT(cVar.bwc());
            }
            c(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bwj() != null) {
                setSearchHint(hotSearchInfoData.bwj());
            }
            this.fSD.bxX();
            this.fSD.rD(cVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.c cVar) {
        if (TbadkCoreApplication.isLogin() && cVar != null) {
            if ((cVar.bwb() == null || v.isEmpty(cVar.bwb().bwu())) && com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false)) {
                return com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.fSC.bwG() != null) {
            if (!StringUtils.isNull(str)) {
                this.fSC.bwG().setSearchHint(str.trim());
            } else {
                this.fSC.bwG().setSearchHint(this.dWt.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bN(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.fSD.m(this.fSE.a(list, com.baidu.tbadk.util.e.aPC()), this.fSE.bxl());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bwe() != null && this.fSC.isPrimary() && this.dPv == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.dWt.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bwe())) {
                this.dPv = new com.baidu.tbadk.core.dialog.a(this.dWt.getActivity());
                this.dPv.jI(2);
                this.dPv.aO(frsPrivateCommonDialogView);
                this.dPv.fA(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aEt().b(a.this.dWt.getPageContext(), new String[]{cVar.bwe().azc()});
                        a.this.dPv.dismiss();
                        a.this.dPv = null;
                    }
                });
                this.dPv.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.dPv = null;
                    }
                });
                this.dPv.b(this.dWt.getPageContext()).aCp();
            }
        }
    }

    private void bwM() {
        if (this.dPv != null) {
            this.dPv.dismiss();
            this.dPv = null;
        }
    }

    public void loadData() {
        if (this.fSD != null) {
            kA(false);
        }
    }

    public void bwN() {
        if (this.fSD != null) {
            kA(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.bxd().destroy();
        if (this.fSD != null) {
            this.fSD.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.fSF != null) {
            this.fSF.onDestroy();
        }
        if (this.fSE != null) {
            this.fSE.onDestroy();
        }
        if (this.fQN != null) {
            this.fQN.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fSD != null) {
            this.fSD.onChangeSkinType(i);
        }
        if (this.fSN != null) {
            this.fSN.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.fSE != null) {
            this.fSE.cancelLoadData();
        }
    }

    public void kA(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.fSO && this.fSE != null && this.fSD != null) {
            String str = this.fSJ;
            this.fSJ = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.fSJ == null || this.fSJ.equals(str)) {
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
                if (this.fSE != null && this.fSE.bxj() != null && this.fSE.bxj().bwb() != null) {
                    Iterator<f> it = this.fSE.bxj().bwb().bwu().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.rF(1);
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
                    com.baidu.tieba.tbadkCore.util.a.IU(currentAccount);
                }
                this.fSD.kK(this.fSE.bxl());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.fSE != null) {
                        this.fSE.kF(StringUtils.isNull(this.fSJ) ? false : true);
                    }
                    this.fSF.LoadData();
                } else if (z2 && this.fSE != null) {
                    this.fSE.kF(StringUtils.isNull(this.fSJ) ? false : true);
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
        if (this.fSC.isAdded() && this.fSC.isPrimary()) {
            if (this.fSF != null) {
                this.fSF.onPrimary();
            }
        } else {
            bwM();
        }
        if (this.fSD != null) {
            this.fSD.onPrimary();
        }
    }

    public void onPause() {
        if (this.fSD != null && this.fSD.bxW() != null) {
            this.fSD.bxW().completePullRefresh();
        }
        if (this.fSF != null) {
            this.fSF.onPause();
        }
        if (this.fSE != null) {
            this.fSE.onPause();
        }
        if (this.fSD != null) {
            this.fSD.onPause();
        }
    }

    public void ais() {
        if (this.fSD != null) {
            this.fSD.bK(this.mRootView);
        }
    }

    /* loaded from: classes7.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f fSX;
        private x mNetwork = null;

        public b(f fVar) {
            this.fSX = null;
            this.fSX = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fSX;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.aDU().aEu().mIsNeedTbs = true;
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
            a.this.ky(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                    a.this.fSL = true;
                    if (a.this.fSC.isAdded() && a.this.dWt != null) {
                        a.this.dWt.showToast(a.this.dWt.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.fSX.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.fSX.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.fSX.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.fSX.getName()));
                    }
                    a.this.fSD.a(this.fSX, a.this.fSE.bxl());
                    a.this.fSE.b(this.fSX);
                } else if (a.this.dWt != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.dWt.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fSC.isAdded()) {
                        a.this.dWt.showToast(a.this.dWt.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.ky(true);
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
    /* loaded from: classes7.dex */
    private class C0487a extends BdAsyncTask<f, Integer, String> {
        private f fSX;
        private x mNetwork = null;

        public C0487a(f fVar) {
            this.fSX = null;
            this.fSX = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fSX;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bwl() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.aDU().aEu().mIsNeedTbs = true;
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
            super.onPostExecute((C0487a) str);
            a.this.ky(false);
            int bwl = this.fSX.bwl();
            if (this.mNetwork != null) {
                if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                    a.this.fSL = true;
                    if (a.this.fSC.isAdded() && a.this.dWt != null) {
                        a.this.dWt.showToast(a.this.dWt.getActivity().getString(bwl > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.fSE.kE(true);
                } else if (a.this.dWt != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.dWt.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fSC.isAdded()) {
                        a.this.dWt.showToast(a.this.dWt.getActivity().getString(bwl > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.ky(true);
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
    public void l(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.bWy().x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aNR = bVar.aNR();
        com.baidu.tbadk.mvc.b.a aNS = bVar.aNS();
        switch (aNR) {
            case 1:
                if (this.fSM != 2 && (aNS instanceof f)) {
                    String name = ((f) aNS).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.dWt.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) aNS).aLI() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) aNS).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) aNS).bwq());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) aNS).bwp().night != null && ((f) aNS).bwp().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) aNS).bwp().night.pattern_image);
                                    }
                                } else if (((f) aNS).bwp().day != null && ((f) aNS).bwp().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) aNS).bwp().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) aNS).bwt());
                            ((f) aNS).dm(0L);
                        }
                        this.dWt.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.dWt.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").s("uid", TbadkApplication.getCurrentAccountId()).Z("obj_type", this.fSE.bxj().getSortType() == 1 ? 2 : 1).cp("fid", ((f) aNS).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.fSM == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (aNS instanceof h) {
                    ((h) aNS).getPosition();
                }
                this.fSL = false;
                if (this.fSC.getView() == null || this.fSC.getView().getParent() == null) {
                    return true;
                }
                this.fSC.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (aNS instanceof f) {
                    a((f) aNS);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.dWt.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.dWt.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.dWt.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.dWt.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").cp("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).cp("obj_type", "2").Z("obj_locate", 1));
                this.dWt.finish();
                return true;
            case 9:
                if (this.fSD != null) {
                    this.fSD.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.fSM = 2;
                return true;
            case 11:
                this.fSM = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.fSM != 2) {
                    if (this.fSN == null) {
                        this.fSN = new com.baidu.tieba.enterForum.view.d(this.dWt.getPageContext(), this.fQN);
                    }
                    if (aNS instanceof f) {
                        this.fSN.c((f) aNS);
                        this.fSN.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aNS instanceof f) {
                    new C0487a((f) aNS).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").Z("obj_type", ((f) aNS).bwl() <= 0 ? 1 : 2).cp("fid", ((f) aNS).getId()).s("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aEt().b(this.dWt.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fSG.cNh() || !(aNS instanceof f)) {
                    return true;
                }
                ba.aEt().b(this.dWt.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) aNS).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aNT());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aNT());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aNT());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aNQ() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.dWt.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fSD != null) {
            this.fSD.setPageUniqueId(bdUniqueId);
        }
    }

    public void kB(boolean z) {
        int i;
        if (this.fSD != null && this.fSC != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fSD.setAdState(bVar);
        this.fSC.setAdState(bVar);
    }
}
