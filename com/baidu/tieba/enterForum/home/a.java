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
    private LikeModel dKs;
    private BaseFragmentActivity eAT;
    private com.baidu.tieba.ueg.d eTE;
    private EnterForumFragment gAU;
    private EnterForumModel gAW;
    private RecentlyVisitedForumModel gAX;
    private boolean gAY;
    private String gBa;
    private long gBb;
    private boolean gBc;
    private com.baidu.tieba.enterForum.view.d gBe;
    private boolean gBf;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b gAV = null;
    private com.baidu.tbadk.core.dialog.a eud = null;
    private boolean gAZ = false;
    private int gBd = 1;
    private CustomMessageListener gBg = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.gAZ = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a gBh = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.gAW.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.gAV.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.eAT.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.eAT.showToast(errorString);
                    if (a.this.gAV.isEmpty()) {
                        a.this.gAV.bR(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.gAW.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.gAW.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d gBi = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bq(a.this.dKs.getErrorCode(), a.this.dKs.getErrorString())) {
                AntiHelper.aW(a.this.eAT.getPageContext().getPageActivity(), a.this.dKs.getErrorString());
            } else if (obj != null) {
                a.this.gAW.lO(!StringUtils.isNull(a.this.gBa));
            } else if (!StringUtils.isNull(a.this.dKs.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.dKs.getErrorString());
            }
        }
    };
    private final EnterForumModel.b gBj = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.gAU != null) {
                if (aVar.type == 1) {
                    a.this.gAV.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.gAY = true;
                        com.baidu.tieba.enterForum.data.e eVar = aVar.gEe;
                        a.this.a(eVar);
                        if (eVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_LIKE_forum_sort_state", eVar.getSortType());
                        }
                        if (a.this.gAU.bIo() != null) {
                            a.this.gAU.bIo().a(eVar.bHB(), true);
                        }
                    } else if (aVar.type == 0 && !a.this.gAY) {
                        com.baidu.tieba.enterForum.data.e eVar2 = aVar.gEe;
                        a.this.gAW.c(eVar2);
                        a.this.a(eVar2);
                        if (a.this.gAU.bIo() != null) {
                            a.this.gAU.bIo().a(eVar2.bHB(), false);
                        }
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.eAT.showToast(aVar.error);
                    a.this.gAV.sd(com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.gBb > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.gBb, a.this.gAW.bIW() - a.this.gBb, a.this.gAW.bIU(), a.this.gAW.bIV(), currentTimeMillis - a.this.gAW.bIT());
                    a.this.gBb = -1L;
                }
                String string = a.this.eAT.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.gEe != null && aVar.gEe.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.gEe.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bHG() != null) {
                        string = hotSearchInfoData.bHG();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private g.c dHh = new g.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.gAG.loadAd();
            a.this.gAW.lO(!StringUtils.isNull(a.this.gBa));
            a.this.gAX.LoadData();
            a.this.gAW.lN(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter gyU = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.gAW = null;
        this.isFirst = true;
        this.gAY = false;
        this.gBb = -1L;
        this.gAU = enterForumFragment;
        this.eAT = enterForumFragment.getBaseFragmentActivity();
        this.gyU.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bUE();
        this.gBb = System.currentTimeMillis();
        this.isFirst = true;
        this.gAY = false;
        this.gBa = "";
        this.gAW = new EnterForumModel(this.eAT.getPageContext());
        this.gAX = new RecentlyVisitedForumModel();
        this.dKs = new LikeModel(this.eAT.getPageContext());
        this.eTE = new com.baidu.tieba.ueg.d(this.eAT.getPageContext());
        this.dKs.setLoadDataCallBack(this.gBi);
        this.gAW.a(this.gBj);
        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.bIR().m(this.gAU.getFragmentActivity(), l.getStatusBarHeight(this.gAU.getFragmentActivity()));
        initUI();
        initListener();
        bIu();
    }

    private void initListener() {
        bIt();
        this.gAU.registerListener(this.gBh);
        this.gAU.registerListener(this.gBg);
    }

    private void bIt() {
        this.gAU.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gAV != null && a.this.gAV.bHt()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bIu() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<af>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<af> run(CustomMessage<af> customMessage) {
                af afVar = new af();
                ArrayList arrayList = new ArrayList();
                if (a.this.gAW != null && a.this.gAW.bIX() != null && a.this.gAW.bIX().bHx() != null && v.getCount(a.this.gAW.bIX().bHx().bHS()) > 0) {
                    Iterator<h> it = a.this.gAW.bIX().bHx().bHS().iterator();
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
                    afVar.aE(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, afVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final h hVar) {
        if (hVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eAT.getPageContext().getPageActivity());
            aVar.ui(String.format(this.eAT.getPageContext().getString(R.string.attention_cancel_dialog_message), hVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.eAT.showToast(R.string.delete_like_fail);
                    } else {
                        new b(hVar).execute(new h[0]);
                    }
                    TiebaStatic.eventStat(a.this.eAT.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ke(R.color.cp_cont_b);
            aVar.b(this.eAT.getPageContext());
            aVar.aMS();
        }
    }

    public void lI(boolean z) {
        if (this.mWaitingDialog == null) {
            bIv();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bIv() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.eAT.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.eAT.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.gAV = new com.baidu.tieba.enterForum.view.b(this.gAU, this.mRootView, this.gyU, this.gAX, this.gAW);
        this.gAV.setListPullRefreshListener(this.dHh);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void lJ(boolean z) {
        if (this.gAV != null && this.gAU != null) {
            if (z) {
                if (this.gAU.isPrimary() && this.gAU.isResumed()) {
                    this.gAV.startPullRefresh();
                } else {
                    this.gAV.completeRefresh();
                }
            } else {
                this.gAV.completeRefresh();
            }
            this.gAV.lZ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.gAU.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.e eVar) {
        if (this.gAV != null) {
            if (eVar == null) {
                this.gAV.bR(this.mRootView);
                return;
            }
            i bHx = eVar.bHx();
            ArrayList<h> arrayList = new ArrayList<>();
            if (bHx != null) {
                arrayList = bHx.bHS();
            }
            a(arrayList, eVar.bHy());
            b(eVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bHG() != null) {
                setSearchHint(hotSearchInfoData.bHG());
            }
            this.gAV.bJW();
            this.gAV.sd(eVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.gAU.bIo() != null) {
            if (!StringUtils.isNull(str)) {
                this.gAU.bIo().setSearchHint(str.trim());
            } else {
                this.gAU.bIo().setSearchHint(this.eAT.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<h> list, com.baidu.tieba.enterForum.data.l lVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.gAV.a(this.gAW.a(list, com.baidu.tbadk.util.e.bah()), lVar, this.gAW.bIZ());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar) {
        if (eVar != null && eVar.bHA() != null && this.gAU.isPrimary() && this.eud == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.eAT.getActivity());
            if (frsPrivateCommonDialogView.b(eVar.bHA())) {
                this.eud = new com.baidu.tbadk.core.dialog.a(this.eAT.getActivity());
                this.eud.kg(2);
                this.eud.aP(frsPrivateCommonDialogView);
                this.eud.gF(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aOV().b(a.this.eAT.getPageContext(), new String[]{eVar.bHA().aJJ()});
                        a.this.eud.dismiss();
                        a.this.eud = null;
                    }
                });
                this.eud.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eud = null;
                    }
                });
                this.eud.b(this.eAT.getPageContext()).aMS();
            }
        }
    }

    private void bIw() {
        if (this.eud != null) {
            this.eud.dismiss();
            this.eud = null;
        }
    }

    public void loadData() {
        if (this.gAV != null) {
            lK(false);
        }
    }

    public void bIx() {
        if (this.gAV != null) {
            lK(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.bIR().destroy();
        if (this.gAV != null) {
            this.gAV.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.gAX != null) {
            this.gAX.onDestroy();
        }
        if (this.gAW != null) {
            this.gAW.onDestroy();
        }
        if (this.gyU != null) {
            this.gyU.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gAV != null) {
            this.gAV.onChangeSkinType(i);
        }
        if (this.gBe != null) {
            this.gBe.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.gAW != null) {
            this.gAW.cancelLoadData();
        }
    }

    public void lK(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.gBf && this.gAW != null && this.gAV != null) {
            String str = this.gBa;
            this.gBa = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.gBa == null || this.gBa.equals(str)) {
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
                if (this.gAW != null && this.gAW.bIX() != null && this.gAW.bIX().bHx() != null) {
                    Iterator<h> it = this.gAW.bIX().bHx().bHS().iterator();
                    while (it.hasNext()) {
                        h next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.sf(1);
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
                    com.baidu.tieba.tbadkCore.util.a.KU(currentAccount);
                }
                this.gAV.lY(this.gAW.bIZ());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.gAW != null) {
                        this.gAW.lP(StringUtils.isNull(this.gBa) ? false : true);
                    }
                    this.gAX.LoadData();
                } else if (z2 && this.gAW != null) {
                    this.gAW.lP(StringUtils.isNull(this.gBa) ? false : true);
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
        if (this.gAU.isAdded() && this.gAU.isPrimary()) {
            if (this.gAX != null) {
                this.gAX.onPrimary();
            }
        } else {
            bIw();
        }
        if (this.gAV != null) {
            this.gAV.onPrimary();
        }
    }

    public void onPause() {
        if (this.gAV != null && this.gAV.bJV() != null) {
            this.gAV.bJV().completePullRefresh();
        }
        if (this.gAX != null) {
            this.gAX.onPause();
        }
        if (this.gAW != null) {
            this.gAW.onPause();
        }
        if (this.gAV != null) {
            this.gAV.onPause();
        }
    }

    public void asX() {
        if (this.gAV != null) {
            this.gAV.bQ(this.mRootView);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<h, Integer, String> {
        private h gBn;
        private x mNetwork = null;

        public b(h hVar) {
            this.gBn = null;
            this.gBn = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(h... hVarArr) {
            h hVar = this.gBn;
            if (hVar != null) {
                try {
                    if (hVar.getId() != null && hVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", hVar.getId());
                        this.mNetwork.addPostData("kw", hVar.getName());
                        this.mNetwork.aOw().aOW().mIsNeedTbs = true;
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
            a.this.lI(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.aOw().aOX().isRequestSuccess()) {
                    a.this.gBc = true;
                    if (a.this.gAU.isAdded() && a.this.eAT != null) {
                        a.this.eAT.showToast(a.this.eAT.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.n(false, this.gBn.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.gBn.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.gBn.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.gBn.getName()));
                    }
                    a.this.gAV.a(this.gBn, a.this.gAW.bIZ());
                    a.this.gAW.b(this.gBn);
                } else if (a.this.eAT != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eAT.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.gAU.isAdded()) {
                        a.this.eAT.showToast(a.this.eAT.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.lI(true);
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
    private class C0551a extends BdAsyncTask<h, Integer, String> {
        private h gBn;
        private x mNetwork = null;

        public C0551a(h hVar) {
            this.gBn = null;
            this.gBn = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(h... hVarArr) {
            h hVar = this.gBn;
            if (hVar != null) {
                try {
                    if (hVar.getId() != null && hVar.getName() != null) {
                        if (hVar.bHI() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", hVar.getId());
                        this.mNetwork.aOw().aOW().mIsNeedTbs = true;
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
            super.onPostExecute((C0551a) str);
            a.this.lI(false);
            int bHI = this.gBn.bHI();
            if (this.mNetwork != null) {
                if (this.mNetwork.aOw().aOX().isRequestSuccess()) {
                    a.this.gBc = true;
                    if (a.this.gAU.isAdded() && a.this.eAT != null) {
                        a.this.eAT.showToast(a.this.eAT.getActivity().getString(bHI > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.gAW.lO(true);
                } else if (a.this.eAT != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eAT.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.gAU.isAdded()) {
                        a.this.eAT.showToast(a.this.eAT.getActivity().getString(bHI > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.lI(true);
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
                    com.baidu.tieba.im.settingcache.d.ciT().x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aYH = bVar.aYH();
        com.baidu.tbadk.mvc.b.a aYI = bVar.aYI();
        switch (aYH) {
            case 1:
                if (this.gBd != 2 && (aYI instanceof h)) {
                    String name = ((h) aYI).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.eAT.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((h) aYI).aWA() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((h) aYI).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((h) aYI).bHN());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((h) aYI).bHM().night != null && ((h) aYI).bHM().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((h) aYI).bHM().night.pattern_image);
                                    }
                                } else if (((h) aYI).bHM().day != null && ((h) aYI).bHM().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((h) aYI).bHM().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((h) aYI).bHQ());
                            ((h) aYI).dW(0L);
                        }
                        this.eAT.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.eAT.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").t("uid", TbadkApplication.getCurrentAccountId()).af("obj_type", this.gAW.bIX().getSortType() == 1 ? 2 : 1).cI("fid", ((h) aYI).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.gBd == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (aYI instanceof j) {
                    ((j) aYI).getPosition();
                }
                this.gBc = false;
                if (this.gAU.getView() == null || this.gAU.getView().getParent() == null) {
                    return true;
                }
                this.gAU.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (aYI instanceof h) {
                    a((h) aYI);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.eAT.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eAT.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.eAT.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eAT.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").cI("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).cI("obj_type", "2").af("obj_locate", 1));
                this.eAT.finish();
                return true;
            case 9:
                if (this.gAV != null) {
                    this.gAV.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.gBd = 2;
                return true;
            case 11:
                this.gBd = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.gBd != 2) {
                    if (this.gBe == null) {
                        this.gBe = new com.baidu.tieba.enterForum.view.d(this.eAT.getPageContext(), this.gyU);
                    }
                    if (aYI instanceof h) {
                        this.gBe.c((h) aYI);
                        this.gBe.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aYI instanceof h) {
                    new C0551a((h) aYI).execute(new h[0]);
                    TiebaStatic.log(new an("c13370").af("obj_type", ((h) aYI).bHI() <= 0 ? 1 : 2).cI("fid", ((h) aYI).getId()).t("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aOV().b(this.eAT.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eTE.cZV() || !(aYI instanceof h)) {
                    return true;
                }
                ba.aOV().b(this.eAT.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((h) aYI).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.aYJ());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.aYJ());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.aYJ());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aYG() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.eAT.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gAV != null) {
            this.gAV.setPageUniqueId(bdUniqueId);
        }
    }

    public void lL(boolean z) {
        int i;
        if (this.gAV != null && this.gAU != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gAV.setAdState(dVar);
        this.gAU.setAdState(dVar);
    }

    public com.baidu.tieba.enterForum.view.b bIy() {
        return this.gAV;
    }
}
