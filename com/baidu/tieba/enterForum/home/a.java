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
    private BaseFragmentActivity ePs;
    private com.baidu.tieba.ueg.d fgm;
    private EnterForumFragment gPD;
    private EnterForumModel gPF;
    private RecentlyVisitedForumModel gPG;
    private boolean gPH;
    private String gPJ;
    private long gPK;
    private boolean gPL;
    private com.baidu.tieba.enterForum.view.d gPN;
    private boolean gPO;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b gPE = null;
    private com.baidu.tbadk.core.dialog.a eIE = null;
    private boolean gPI = false;
    private int gPM = 1;
    private CustomMessageListener gPP = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.gPI = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a gPQ = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.gPF.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.gPE.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.ePs.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.ePs.showToast(errorString);
                    if (a.this.gPE.isEmpty()) {
                        a.this.gPE.bR(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.gPF.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.gPF.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d gPR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bv(a.this.dYI.getErrorCode(), a.this.dYI.getErrorString())) {
                AntiHelper.aX(a.this.ePs.getPageContext().getPageActivity(), a.this.dYI.getErrorString());
            } else if (obj != null) {
                a.this.gPF.mj(!StringUtils.isNull(a.this.gPJ));
            } else if (!StringUtils.isNull(a.this.dYI.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.dYI.getErrorString());
            }
        }
    };
    private final EnterForumModel.b gPS = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.gPD != null) {
                if (aVar.type == 1) {
                    a.this.gPE.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.gPH = true;
                        com.baidu.tieba.enterForum.data.e eVar = aVar.gSM;
                        a.this.a(eVar);
                        if (eVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_LIKE_forum_sort_state", eVar.getSortType());
                        }
                        if (a.this.gPD.bOI() != null) {
                            a.this.gPD.bOI().a(eVar.bNV(), true);
                        }
                    } else if (aVar.type == 0 && !a.this.gPH) {
                        com.baidu.tieba.enterForum.data.e eVar2 = aVar.gSM;
                        a.this.gPF.c(eVar2);
                        a.this.a(eVar2);
                        if (a.this.gPD.bOI() != null) {
                            a.this.gPD.bOI().a(eVar2.bNV(), false);
                        }
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.ePs.showToast(aVar.error);
                    a.this.gPE.sI(com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.gPK > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.gPK, a.this.gPF.bPq() - a.this.gPK, a.this.gPF.bPo(), a.this.gPF.bPp(), currentTimeMillis - a.this.gPF.bPn());
                    a.this.gPK = -1L;
                }
                String string = a.this.ePs.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.gSM != null && aVar.gSM.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.gSM.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bOa() != null) {
                        string = hotSearchInfoData.bOa();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private f.c dVt = new f.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.gPq.loadAd();
            a.this.gPF.mj(!StringUtils.isNull(a.this.gPJ));
            a.this.gPG.LoadData();
            a.this.gPF.mi(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter gNE = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.gPF = null;
        this.isFirst = true;
        this.gPH = false;
        this.gPK = -1L;
        this.gPD = enterForumFragment;
        this.ePs = enterForumFragment.getBaseFragmentActivity();
        this.gNE.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.cbc();
        this.gPK = System.currentTimeMillis();
        this.isFirst = true;
        this.gPH = false;
        this.gPJ = "";
        this.gPF = new EnterForumModel(this.ePs.getPageContext());
        this.gPG = new RecentlyVisitedForumModel();
        this.dYI = new LikeModel(this.ePs.getPageContext());
        this.fgm = new com.baidu.tieba.ueg.d(this.ePs.getPageContext());
        this.dYI.setLoadDataCallBack(this.gPR);
        this.gPF.a(this.gPS);
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.bPl().m(this.gPD.getFragmentActivity(), l.getStatusBarHeight(this.gPD.getFragmentActivity()));
        initUI();
        initListener();
        bOO();
    }

    private void initListener() {
        bON();
        this.gPD.registerListener(this.gPQ);
        this.gPD.registerListener(this.gPP);
    }

    private void bON() {
        this.gPD.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gPE != null && a.this.gPE.bNN()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bOO() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.gPF != null && a.this.gPF.bPr() != null && a.this.gPF.bPr().bNR() != null && v.getCount(a.this.gPF.bPr().bNR().bOm()) > 0) {
                    Iterator<h> it = a.this.gPF.bPr().bNR().bOm().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ePs.getPageContext().getPageActivity());
            aVar.vO(String.format(this.ePs.getPageContext().getString(R.string.attention_cancel_dialog_message), hVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.ePs.showToast(R.string.delete_like_fail);
                    } else {
                        new b(hVar).execute(new h[0]);
                    }
                    TiebaStatic.eventStat(a.this.ePs.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.kE(R.color.cp_cont_b);
            aVar.b(this.ePs.getPageContext());
            aVar.aST();
        }
    }

    public void me(boolean z) {
        if (this.mWaitingDialog == null) {
            bOP();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bOP() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.ePs.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.ePs.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.gPE = new com.baidu.tieba.enterForum.view.b(this.gPD, this.mRootView, this.gNE, this.gPG, this.gPF);
        this.gPE.setListPullRefreshListener(this.dVt);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mf(boolean z) {
        if (this.gPE != null && this.gPD != null) {
            if (z) {
                if (this.gPD.isPrimary() && this.gPD.isResumed()) {
                    this.gPE.startPullRefresh();
                } else {
                    this.gPE.completeRefresh();
                }
            } else {
                this.gPE.completeRefresh();
            }
            this.gPE.mu(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.gPD.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.e eVar) {
        if (this.gPE != null) {
            if (eVar == null) {
                this.gPE.bR(this.mRootView);
                return;
            }
            i bNR = eVar.bNR();
            ArrayList<h> arrayList = new ArrayList<>();
            if (bNR != null) {
                arrayList = bNR.bOm();
            }
            a(arrayList, eVar.bNS());
            b(eVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bOa() != null) {
                setSearchHint(hotSearchInfoData.bOa());
            }
            this.gPE.bQs();
            this.gPE.sI(eVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.gPD.bOI() != null) {
            if (!StringUtils.isNull(str)) {
                this.gPD.bOI().setSearchHint(str.trim());
            } else {
                this.gPD.bOI().setSearchHint(this.ePs.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<h> list, com.baidu.tieba.enterForum.data.l lVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.gPE.a(this.gPF.a(list, com.baidu.tbadk.util.e.bgr()), lVar, this.gPF.bPt());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar) {
        if (eVar != null && eVar.bNU() != null && this.gPD.isPrimary() && this.eIE == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.ePs.getActivity());
            if (frsPrivateCommonDialogView.b(eVar.bNU())) {
                this.eIE = new com.baidu.tbadk.core.dialog.a(this.ePs.getActivity());
                this.eIE.kG(2);
                this.eIE.aP(frsPrivateCommonDialogView);
                this.eIE.gX(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aUZ().b(a.this.ePs.getPageContext(), new String[]{eVar.bNU().aPE()});
                        a.this.eIE.dismiss();
                        a.this.eIE = null;
                    }
                });
                this.eIE.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eIE = null;
                    }
                });
                this.eIE.b(this.ePs.getPageContext()).aST();
            }
        }
    }

    private void bOQ() {
        if (this.eIE != null) {
            this.eIE.dismiss();
            this.eIE = null;
        }
    }

    public void loadData() {
        if (this.gPE != null) {
            fC(false);
        }
    }

    public void bOR() {
        if (this.gPE != null) {
            fC(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.bPl().destroy();
        if (this.gPE != null) {
            this.gPE.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.gPG != null) {
            this.gPG.onDestroy();
        }
        if (this.gPF != null) {
            this.gPF.onDestroy();
        }
        if (this.gNE != null) {
            this.gNE.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gPE != null) {
            this.gPE.onChangeSkinType(i);
        }
        if (this.gPN != null) {
            this.gPN.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.gPF != null) {
            this.gPF.cancelLoadData();
        }
    }

    public void fC(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.gPO && this.gPF != null && this.gPE != null) {
            String str = this.gPJ;
            this.gPJ = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.gPJ == null || this.gPJ.equals(str)) {
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
                if (this.gPF != null && this.gPF.bPr() != null && this.gPF.bPr().bNR() != null) {
                    Iterator<h> it = this.gPF.bPr().bNR().bOm().iterator();
                    while (it.hasNext()) {
                        h next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.sK(1);
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
                    com.baidu.tieba.tbadkCore.util.a.MH(currentAccount);
                }
                this.gPE.mt(this.gPF.bPt());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.gPF != null) {
                        this.gPF.mk(StringUtils.isNull(this.gPJ) ? false : true);
                    }
                    this.gPG.LoadData();
                } else if (z2 && this.gPF != null) {
                    this.gPF.mk(StringUtils.isNull(this.gPJ) ? false : true);
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
        if (this.gPD.isAdded() && this.gPD.isPrimary()) {
            if (this.gPG != null) {
                this.gPG.onPrimary();
            }
        } else {
            bOQ();
        }
        if (this.gPE != null) {
            this.gPE.onPrimary();
        }
    }

    public void onPause() {
        if (this.gPE != null && this.gPE.bQr() != null) {
            this.gPE.bQr().completePullRefresh();
        }
        if (this.gPG != null) {
            this.gPG.onPause();
        }
        if (this.gPF != null) {
            this.gPF.onPause();
        }
        if (this.gPE != null) {
            this.gPE.onPause();
        }
    }

    public void awE() {
        if (this.gPE != null) {
            this.gPE.bQ(this.mRootView);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<h, Integer, String> {
        private h gPW;
        private x mNetwork = null;

        public b(h hVar) {
            this.gPW = null;
            this.gPW = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(h... hVarArr) {
            h hVar = this.gPW;
            if (hVar != null) {
                try {
                    if (hVar.getId() != null && hVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", hVar.getId());
                        this.mNetwork.addPostData("kw", hVar.getName());
                        this.mNetwork.aUA().aVa().mIsNeedTbs = true;
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
                if (this.mNetwork.aUA().aVb().isRequestSuccess()) {
                    a.this.gPL = true;
                    if (a.this.gPD.isAdded() && a.this.ePs != null) {
                        a.this.ePs.showToast(a.this.ePs.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.n(false, this.gPW.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.gPW.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.gPW.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.gPW.getName()));
                    }
                    a.this.gPE.a(this.gPW, a.this.gPF.bPt());
                    a.this.gPF.b(this.gPW);
                } else if (a.this.ePs != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.ePs.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.gPD.isAdded()) {
                        a.this.ePs.showToast(a.this.ePs.getActivity().getString(R.string.delete_like_fail));
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
        private h gPW;
        private x mNetwork = null;

        public C0601a(h hVar) {
            this.gPW = null;
            this.gPW = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(h... hVarArr) {
            h hVar = this.gPW;
            if (hVar != null) {
                try {
                    if (hVar.getId() != null && hVar.getName() != null) {
                        if (hVar.bOc() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", hVar.getId());
                        this.mNetwork.aUA().aVa().mIsNeedTbs = true;
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
            int bOc = this.gPW.bOc();
            if (this.mNetwork != null) {
                if (this.mNetwork.aUA().aVb().isRequestSuccess()) {
                    a.this.gPL = true;
                    if (a.this.gPD.isAdded() && a.this.ePs != null) {
                        a.this.ePs.showToast(a.this.ePs.getActivity().getString(bOc > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.gPF.mj(true);
                } else if (a.this.ePs != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.ePs.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.gPD.isAdded()) {
                        a.this.ePs.showToast(a.this.ePs.getActivity().getString(bOc > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.cpr().z(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int beR = bVar.beR();
        com.baidu.tbadk.mvc.b.a beS = bVar.beS();
        switch (beR) {
            case 1:
                if (this.gPM != 2 && (beS instanceof h)) {
                    String name = ((h) beS).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.ePs.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((h) beS).bcJ() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((h) beS).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((h) beS).bOh());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((h) beS).bOg().night != null && ((h) beS).bOg().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((h) beS).bOg().night.pattern_image);
                                    }
                                } else if (((h) beS).bOg().day != null && ((h) beS).bOg().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((h) beS).bOg().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((h) beS).bOk());
                            ((h) beS).dX(0L);
                        }
                        this.ePs.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.ePs.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").s("uid", TbadkApplication.getCurrentAccountId()).ag("obj_type", this.gPF.bPr().getSortType() == 1 ? 2 : 1).dh("fid", ((h) beS).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.gPM == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (beS instanceof j) {
                    ((j) beS).getPosition();
                }
                this.gPL = false;
                if (this.gPD.getView() == null || this.gPD.getView().getParent() == null) {
                    return true;
                }
                this.gPD.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (beS instanceof h) {
                    a((h) beS);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.ePs.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.ePs.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.ePs.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.ePs.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").dh("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).dh("obj_type", "2").ag("obj_locate", 1));
                this.ePs.finish();
                return true;
            case 9:
                if (this.gPE != null) {
                    this.gPE.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.gPM = 2;
                return true;
            case 11:
                this.gPM = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.gPM != 2) {
                    if (this.gPN == null) {
                        this.gPN = new com.baidu.tieba.enterForum.view.d(this.ePs.getPageContext(), this.gNE);
                    }
                    if (beS instanceof h) {
                        this.gPN.c((h) beS);
                        this.gPN.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (beS instanceof h) {
                    new C0601a((h) beS).execute(new h[0]);
                    TiebaStatic.log(new an("c13370").ag("obj_type", ((h) beS).bOc() <= 0 ? 1 : 2).dh("fid", ((h) beS).getId()).s("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aUZ().b(this.ePs.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fgm.dhk() || !(beS instanceof h)) {
                    return true;
                }
                ba.aUZ().b(this.ePs.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((h) beS).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.beT());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.beT());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.beT());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean beQ() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.ePs.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gPE != null) {
            this.gPE.setPageUniqueId(bdUniqueId);
        }
    }

    public void mg(boolean z) {
        int i;
        if (this.gPE != null && this.gPD != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gPE.setAdState(dVar);
        this.gPD.setAdState(dVar);
    }

    public com.baidu.tieba.enterForum.view.b bOS() {
        return this.gPE;
    }
}
