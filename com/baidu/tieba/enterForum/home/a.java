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
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.i;
import com.baidu.tieba.enterForum.data.j;
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
    private LikeModel dYI;
    private BaseFragmentActivity ePD;
    private com.baidu.tieba.ueg.d fgx;
    private EnterForumFragment gPO;
    private EnterForumModel gPQ;
    private RecentlyVisitedForumModel gPR;
    private boolean gPS;
    private String gPU;
    private long gPV;
    private boolean gPW;
    private com.baidu.tieba.enterForum.view.d gPY;
    private boolean gPZ;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b gPP = null;
    private com.baidu.tbadk.core.dialog.a eIP = null;
    private boolean gPT = false;
    private int gPX = 1;
    private CustomMessageListener gQa = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.gPT = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a gQb = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.gPQ.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.gPP.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.ePD.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.ePD.showToast(errorString);
                    if (a.this.gPP.isEmpty()) {
                        a.this.gPP.bR(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.gPQ.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.gPQ.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d gQc = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bv(a.this.dYI.getErrorCode(), a.this.dYI.getErrorString())) {
                AntiHelper.aX(a.this.ePD.getPageContext().getPageActivity(), a.this.dYI.getErrorString());
            } else if (obj != null) {
                a.this.gPQ.mj(!StringUtils.isNull(a.this.gPU));
            } else if (!StringUtils.isNull(a.this.dYI.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.dYI.getErrorString());
            }
        }
    };
    private final EnterForumModel.b gQd = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.gPO != null) {
                if (aVar.type == 1) {
                    a.this.gPP.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.gPS = true;
                        com.baidu.tieba.enterForum.data.e eVar = aVar.gSX;
                        a.this.a(eVar);
                        if (eVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_LIKE_forum_sort_state", eVar.getSortType());
                        }
                        if (a.this.gPO.bOK() != null) {
                            a.this.gPO.bOK().a(eVar.bNX(), true);
                        }
                    } else if (aVar.type == 0 && !a.this.gPS) {
                        com.baidu.tieba.enterForum.data.e eVar2 = aVar.gSX;
                        a.this.gPQ.c(eVar2);
                        a.this.a(eVar2);
                        if (a.this.gPO.bOK() != null) {
                            a.this.gPO.bOK().a(eVar2.bNX(), false);
                        }
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.ePD.showToast(aVar.error);
                    a.this.gPP.sK(com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.gPV > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.gPV, a.this.gPQ.bPs() - a.this.gPV, a.this.gPQ.bPq(), a.this.gPQ.bPr(), currentTimeMillis - a.this.gPQ.bPp());
                    a.this.gPV = -1L;
                }
                String string = a.this.ePD.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.gSX != null && aVar.gSX.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.gSX.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bOc() != null) {
                        string = hotSearchInfoData.bOc();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private f.c dVt = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.gPB.loadAd();
            a.this.gPQ.mj(!StringUtils.isNull(a.this.gPU));
            a.this.gPR.LoadData();
            a.this.gPQ.mi(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter gNP = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.gPQ = null;
        this.isFirst = true;
        this.gPS = false;
        this.gPV = -1L;
        this.gPO = enterForumFragment;
        this.ePD = enterForumFragment.getBaseFragmentActivity();
        this.gNP.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.cbk();
        this.gPV = System.currentTimeMillis();
        this.isFirst = true;
        this.gPS = false;
        this.gPU = "";
        this.gPQ = new EnterForumModel(this.ePD.getPageContext());
        this.gPR = new RecentlyVisitedForumModel();
        this.dYI = new LikeModel(this.ePD.getPageContext());
        this.fgx = new com.baidu.tieba.ueg.d(this.ePD.getPageContext());
        this.dYI.setLoadDataCallBack(this.gQc);
        this.gPQ.a(this.gQd);
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.bPn().m(this.gPO.getFragmentActivity(), l.getStatusBarHeight(this.gPO.getFragmentActivity()));
        initUI();
        initListener();
        bOQ();
    }

    private void initListener() {
        bOP();
        this.gPO.registerListener(this.gQb);
        this.gPO.registerListener(this.gQa);
    }

    private void bOP() {
        this.gPO.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gPP != null && a.this.gPP.bNP()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bOQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.gPQ != null && a.this.gPQ.bPt() != null && a.this.gPQ.bPt().bNT() != null && v.getCount(a.this.gPQ.bPt().bNT().bOo()) > 0) {
                    Iterator<h> it = a.this.gPQ.bPt().bNT().bOo().iterator();
                    while (it.hasNext()) {
                        h next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.f.b.toLong(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    aeVar.az(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, aeVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final h hVar) {
        if (hVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ePD.getPageContext().getPageActivity());
            aVar.vO(String.format(this.ePD.getPageContext().getString(R.string.attention_cancel_dialog_message), hVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.ePD.showToast(R.string.delete_like_fail);
                    } else {
                        new b(hVar).execute(new h[0]);
                    }
                    TiebaStatic.eventStat(a.this.ePD.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.kG(R.color.cp_cont_b);
            aVar.b(this.ePD.getPageContext());
            aVar.aST();
        }
    }

    public void me(boolean z) {
        if (this.mWaitingDialog == null) {
            bOR();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bOR() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.ePD.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.ePD.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.gPP = new com.baidu.tieba.enterForum.view.b(this.gPO, this.mRootView, this.gNP, this.gPR, this.gPQ);
        this.gPP.setListPullRefreshListener(this.dVt);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mf(boolean z) {
        if (this.gPP != null && this.gPO != null) {
            if (z) {
                if (this.gPO.isPrimary() && this.gPO.isResumed()) {
                    this.gPP.startPullRefresh();
                } else {
                    this.gPP.completeRefresh();
                }
            } else {
                this.gPP.completeRefresh();
            }
            this.gPP.mu(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.gPO.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.e eVar) {
        if (this.gPP != null) {
            if (eVar == null) {
                this.gPP.bR(this.mRootView);
                return;
            }
            i bNT = eVar.bNT();
            ArrayList<h> arrayList = new ArrayList<>();
            if (bNT != null) {
                arrayList = bNT.bOo();
            }
            a(arrayList, eVar.bNU());
            b(eVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bOc() != null) {
                setSearchHint(hotSearchInfoData.bOc());
            }
            this.gPP.bQu();
            this.gPP.sK(eVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.gPO.bOK() != null) {
            if (!StringUtils.isNull(str)) {
                this.gPO.bOK().setSearchHint(str.trim());
            } else {
                this.gPO.bOK().setSearchHint(this.ePD.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<h> list, com.baidu.tieba.enterForum.data.l lVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.gPP.a(this.gPQ.a(list, com.baidu.tbadk.util.e.bgs()), lVar, this.gPQ.bPv());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar) {
        if (eVar != null && eVar.bNW() != null && this.gPO.isPrimary() && this.eIP == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.ePD.getActivity());
            if (frsPrivateCommonDialogView.b(eVar.bNW())) {
                this.eIP = new com.baidu.tbadk.core.dialog.a(this.ePD.getActivity());
                this.eIP.kI(2);
                this.eIP.aP(frsPrivateCommonDialogView);
                this.eIP.gX(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aVa().b(a.this.ePD.getPageContext(), new String[]{eVar.bNW().aPE()});
                        a.this.eIP.dismiss();
                        a.this.eIP = null;
                    }
                });
                this.eIP.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eIP = null;
                    }
                });
                this.eIP.b(this.ePD.getPageContext()).aST();
            }
        }
    }

    private void bOS() {
        if (this.eIP != null) {
            this.eIP.dismiss();
            this.eIP = null;
        }
    }

    public void loadData() {
        if (this.gPP != null) {
            fC(false);
        }
    }

    public void bOT() {
        if (this.gPP != null) {
            fC(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.bPn().destroy();
        if (this.gPP != null) {
            this.gPP.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.gPR != null) {
            this.gPR.onDestroy();
        }
        if (this.gPQ != null) {
            this.gPQ.onDestroy();
        }
        if (this.gNP != null) {
            this.gNP.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gPP != null) {
            this.gPP.onChangeSkinType(i);
        }
        if (this.gPY != null) {
            this.gPY.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.gPQ != null) {
            this.gPQ.cancelLoadData();
        }
    }

    public void fC(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.gPZ && this.gPQ != null && this.gPP != null) {
            String str = this.gPU;
            this.gPU = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.gPU == null || this.gPU.equals(str)) {
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
                if (this.gPQ != null && this.gPQ.bPt() != null && this.gPQ.bPt().bNT() != null) {
                    Iterator<h> it = this.gPQ.bPt().bNT().bOo().iterator();
                    while (it.hasNext()) {
                        h next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.sM(1);
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
                    com.baidu.tieba.tbadkCore.util.a.MI(currentAccount);
                }
                this.gPP.mt(this.gPQ.bPv());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.gPQ != null) {
                        this.gPQ.mk(StringUtils.isNull(this.gPU) ? false : true);
                    }
                    this.gPR.LoadData();
                } else if (z2 && this.gPQ != null) {
                    this.gPQ.mk(StringUtils.isNull(this.gPU) ? false : true);
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
        if (this.gPO.isAdded() && this.gPO.isPrimary()) {
            if (this.gPR != null) {
                this.gPR.onPrimary();
            }
        } else {
            bOS();
        }
        if (this.gPP != null) {
            this.gPP.onPrimary();
        }
    }

    public void onPause() {
        if (this.gPP != null && this.gPP.bQt() != null) {
            this.gPP.bQt().completePullRefresh();
        }
        if (this.gPR != null) {
            this.gPR.onPause();
        }
        if (this.gPQ != null) {
            this.gPQ.onPause();
        }
        if (this.gPP != null) {
            this.gPP.onPause();
        }
    }

    public void awE() {
        if (this.gPP != null) {
            this.gPP.bQ(this.mRootView);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<h, Integer, String> {
        private h gQh;
        private x mNetwork = null;

        public b(h hVar) {
            this.gQh = null;
            this.gQh = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(h... hVarArr) {
            h hVar = this.gQh;
            if (hVar != null) {
                try {
                    if (hVar.getId() != null && hVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", hVar.getId());
                        this.mNetwork.addPostData("kw", hVar.getName());
                        this.mNetwork.aUA().aVb().mIsNeedTbs = true;
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
            a.this.me(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.aUA().aVc().isRequestSuccess()) {
                    a.this.gPW = true;
                    if (a.this.gPO.isAdded() && a.this.ePD != null) {
                        a.this.ePD.showToast(a.this.ePD.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.n(false, this.gQh.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.gQh.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.gQh.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.gQh.getName()));
                    }
                    a.this.gPP.a(this.gQh, a.this.gPQ.bPv());
                    a.this.gPQ.b(this.gQh);
                } else if (a.this.ePD != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.ePD.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.gPO.isAdded()) {
                        a.this.ePD.showToast(a.this.ePD.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.me(true);
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
    private class C0601a extends BdAsyncTask<h, Integer, String> {
        private h gQh;
        private x mNetwork = null;

        public C0601a(h hVar) {
            this.gQh = null;
            this.gQh = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(h... hVarArr) {
            h hVar = this.gQh;
            if (hVar != null) {
                try {
                    if (hVar.getId() != null && hVar.getName() != null) {
                        if (hVar.bOe() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", hVar.getId());
                        this.mNetwork.aUA().aVb().mIsNeedTbs = true;
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
            super.onPostExecute((C0601a) str);
            a.this.me(false);
            int bOe = this.gQh.bOe();
            if (this.mNetwork != null) {
                if (this.mNetwork.aUA().aVc().isRequestSuccess()) {
                    a.this.gPW = true;
                    if (a.this.gPO.isAdded() && a.this.ePD != null) {
                        a.this.ePD.showToast(a.this.ePD.getActivity().getString(bOe > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.gPQ.mj(true);
                } else if (a.this.ePD != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.ePD.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.gPO.isAdded()) {
                        a.this.ePD.showToast(a.this.ePD.getActivity().getString(bOe > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.me(true);
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
    public void n(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.cpA().z(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int beS = bVar.beS();
        com.baidu.tbadk.mvc.b.a beT = bVar.beT();
        switch (beS) {
            case 1:
                if (this.gPX != 2 && (beT instanceof h)) {
                    String name = ((h) beT).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.ePD.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((h) beT).bcK() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((h) beT).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((h) beT).bOj());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((h) beT).bOi().night != null && ((h) beT).bOi().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((h) beT).bOi().night.pattern_image);
                                    }
                                } else if (((h) beT).bOi().day != null && ((h) beT).bOi().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((h) beT).bOi().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((h) beT).bOm());
                            ((h) beT).dX(0L);
                        }
                        this.ePD.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.ePD.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").s("uid", TbadkApplication.getCurrentAccountId()).ag("obj_type", this.gPQ.bPt().getSortType() == 1 ? 2 : 1).dh("fid", ((h) beT).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.gPX == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (beT instanceof j) {
                    ((j) beT).getPosition();
                }
                this.gPW = false;
                if (this.gPO.getView() == null || this.gPO.getView().getParent() == null) {
                    return true;
                }
                this.gPO.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (beT instanceof h) {
                    a((h) beT);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.ePD.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.ePD.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.ePD.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.ePD.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").dh("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dh("obj_type", "2").ag("obj_locate", 1));
                this.ePD.finish();
                return true;
            case 9:
                if (this.gPP != null) {
                    this.gPP.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.gPX = 2;
                return true;
            case 11:
                this.gPX = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.gPX != 2) {
                    if (this.gPY == null) {
                        this.gPY = new com.baidu.tieba.enterForum.view.d(this.ePD.getPageContext(), this.gNP);
                    }
                    if (beT instanceof h) {
                        this.gPY.c((h) beT);
                        this.gPY.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (beT instanceof h) {
                    new C0601a((h) beT).execute(new h[0]);
                    TiebaStatic.log(new an("c13370").ag("obj_type", ((h) beT).bOe() <= 0 ? 1 : 2).dh("fid", ((h) beT).getId()).s("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aVa().b(this.ePD.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fgx.dhz() || !(beT instanceof h)) {
                    return true;
                }
                ba.aVa().b(this.ePD.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((h) beT).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.beU());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.beU());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.beU());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean beR() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.ePD.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gPP != null) {
            this.gPP.setPageUniqueId(bdUniqueId);
        }
    }

    public void mg(boolean z) {
        int i;
        if (this.gPP != null && this.gPO != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gPP.setAdState(dVar);
        this.gPO.setAdState(dVar);
    }

    public com.baidu.tieba.enterForum.view.b bOU() {
        return this.gPP;
    }
}
