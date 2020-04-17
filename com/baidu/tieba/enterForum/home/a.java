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
    private LikeModel dKo;
    private BaseFragmentActivity eAO;
    private com.baidu.tieba.ueg.d eTz;
    private EnterForumFragment gAO;
    private EnterForumModel gAQ;
    private RecentlyVisitedForumModel gAR;
    private boolean gAS;
    private String gAU;
    private long gAV;
    private boolean gAW;
    private com.baidu.tieba.enterForum.view.d gAY;
    private boolean gAZ;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b gAP = null;
    private com.baidu.tbadk.core.dialog.a etY = null;
    private boolean gAT = false;
    private int gAX = 1;
    private CustomMessageListener gBa = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.gAT = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a gBb = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.gAQ.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.gAP.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.eAO.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.eAO.showToast(errorString);
                    if (a.this.gAP.isEmpty()) {
                        a.this.gAP.bR(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.gAQ.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.gAQ.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d gBc = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bq(a.this.dKo.getErrorCode(), a.this.dKo.getErrorString())) {
                AntiHelper.bi(a.this.eAO.getPageContext().getPageActivity(), a.this.dKo.getErrorString());
            } else if (obj != null) {
                a.this.gAQ.lO(!StringUtils.isNull(a.this.gAU));
            } else if (!StringUtils.isNull(a.this.dKo.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.dKo.getErrorString());
            }
        }
    };
    private final EnterForumModel.b gBd = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.gAO != null) {
                if (aVar.type == 1) {
                    a.this.gAP.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.gAS = true;
                        com.baidu.tieba.enterForum.data.e eVar = aVar.gDY;
                        a.this.a(eVar);
                        if (eVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_LIKE_forum_sort_state", eVar.getSortType());
                        }
                        if (a.this.gAO.bIq() != null) {
                            a.this.gAO.bIq().a(eVar.bHD(), true);
                        }
                    } else if (aVar.type == 0 && !a.this.gAS) {
                        com.baidu.tieba.enterForum.data.e eVar2 = aVar.gDY;
                        a.this.gAQ.c(eVar2);
                        a.this.a(eVar2);
                        if (a.this.gAO.bIq() != null) {
                            a.this.gAO.bIq().a(eVar2.bHD(), false);
                        }
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.eAO.showToast(aVar.error);
                    a.this.gAP.sd(com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.gAV > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.gAV, a.this.gAQ.bIY() - a.this.gAV, a.this.gAQ.bIW(), a.this.gAQ.bIX(), currentTimeMillis - a.this.gAQ.bIV());
                    a.this.gAV = -1L;
                }
                String string = a.this.eAO.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.gDY != null && aVar.gDY.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.gDY.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bHI() != null) {
                        string = hotSearchInfoData.bHI();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private g.c dHd = new g.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.gAA.loadAd();
            a.this.gAQ.lO(!StringUtils.isNull(a.this.gAU));
            a.this.gAR.LoadData();
            a.this.gAQ.lN(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter gyO = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    public a(EnterForumFragment enterForumFragment) {
        this.gAQ = null;
        this.isFirst = true;
        this.gAS = false;
        this.gAV = -1L;
        this.gAO = enterForumFragment;
        this.eAO = enterForumFragment.getBaseFragmentActivity();
        this.gyO.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bUG();
        this.gAV = System.currentTimeMillis();
        this.isFirst = true;
        this.gAS = false;
        this.gAU = "";
        this.gAQ = new EnterForumModel(this.eAO.getPageContext());
        this.gAR = new RecentlyVisitedForumModel();
        this.dKo = new LikeModel(this.eAO.getPageContext());
        this.eTz = new com.baidu.tieba.ueg.d(this.eAO.getPageContext());
        this.dKo.setLoadDataCallBack(this.gBc);
        this.gAQ.a(this.gBd);
        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.bIT().m(this.gAO.getFragmentActivity(), l.getStatusBarHeight(this.gAO.getFragmentActivity()));
        initUI();
        initListener();
        bIw();
    }

    private void initListener() {
        bIv();
        this.gAO.registerListener(this.gBb);
        this.gAO.registerListener(this.gBa);
    }

    private void bIv() {
        this.gAO.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gAP != null && a.this.gAP.bHv()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bIw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<af>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<af> run(CustomMessage<af> customMessage) {
                af afVar = new af();
                ArrayList arrayList = new ArrayList();
                if (a.this.gAQ != null && a.this.gAQ.bIZ() != null && a.this.gAQ.bIZ().bHz() != null && v.getCount(a.this.gAQ.bIZ().bHz().bHU()) > 0) {
                    Iterator<h> it = a.this.gAQ.bIZ().bHz().bHU().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eAO.getPageContext().getPageActivity());
            aVar.uf(String.format(this.eAO.getPageContext().getString(R.string.attention_cancel_dialog_message), hVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.eAO.showToast(R.string.delete_like_fail);
                    } else {
                        new b(hVar).execute(new h[0]);
                    }
                    TiebaStatic.eventStat(a.this.eAO.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.eAO.getPageContext());
            aVar.aMU();
        }
    }

    public void lI(boolean z) {
        if (this.mWaitingDialog == null) {
            bIx();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bIx() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.eAO.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.eAO.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.gAP = new com.baidu.tieba.enterForum.view.b(this.gAO, this.mRootView, this.gyO, this.gAR, this.gAQ);
        this.gAP.setListPullRefreshListener(this.dHd);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void lJ(boolean z) {
        if (this.gAP != null && this.gAO != null) {
            if (z) {
                if (this.gAO.isPrimary() && this.gAO.isResumed()) {
                    this.gAP.startPullRefresh();
                } else {
                    this.gAP.completeRefresh();
                }
            } else {
                this.gAP.completeRefresh();
            }
            this.gAP.lZ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.gAO.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.e eVar) {
        if (this.gAP != null) {
            if (eVar == null) {
                this.gAP.bR(this.mRootView);
                return;
            }
            i bHz = eVar.bHz();
            ArrayList<h> arrayList = new ArrayList<>();
            if (bHz != null) {
                arrayList = bHz.bHU();
            }
            a(arrayList, eVar.bHA());
            b(eVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bHI() != null) {
                setSearchHint(hotSearchInfoData.bHI());
            }
            this.gAP.bJY();
            this.gAP.sd(eVar.getSortType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.gAO.bIq() != null) {
            if (!StringUtils.isNull(str)) {
                this.gAO.bIq().setSearchHint(str.trim());
            } else {
                this.gAO.bIq().setSearchHint(this.eAO.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void a(List<h> list, com.baidu.tieba.enterForum.data.l lVar) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.gAP.a(this.gAQ.a(list, com.baidu.tbadk.util.e.baj()), lVar, this.gAQ.bJb());
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar) {
        if (eVar != null && eVar.bHC() != null && this.gAO.isPrimary() && this.etY == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.eAO.getActivity());
            if (frsPrivateCommonDialogView.b(eVar.bHC())) {
                this.etY = new com.baidu.tbadk.core.dialog.a(this.eAO.getActivity());
                this.etY.kg(2);
                this.etY.aP(frsPrivateCommonDialogView);
                this.etY.gF(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aOY().b(a.this.eAO.getPageContext(), new String[]{eVar.bHC().aJL()});
                        a.this.etY.dismiss();
                        a.this.etY = null;
                    }
                });
                this.etY.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.etY = null;
                    }
                });
                this.etY.b(this.eAO.getPageContext()).aMU();
            }
        }
    }

    private void bIy() {
        if (this.etY != null) {
            this.etY.dismiss();
            this.etY = null;
        }
    }

    public void loadData() {
        if (this.gAP != null) {
            lK(false);
        }
    }

    public void bIz() {
        if (this.gAP != null) {
            lK(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.bIT().destroy();
        if (this.gAP != null) {
            this.gAP.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.gAR != null) {
            this.gAR.onDestroy();
        }
        if (this.gAQ != null) {
            this.gAQ.onDestroy();
        }
        if (this.gyO != null) {
            this.gyO.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gAP != null) {
            this.gAP.onChangeSkinType(i);
        }
        if (this.gAY != null) {
            this.gAY.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.gAQ != null) {
            this.gAQ.cancelLoadData();
        }
    }

    public void lK(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.gAZ && this.gAQ != null && this.gAP != null) {
            String str = this.gAU;
            this.gAU = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.gAU == null || this.gAU.equals(str)) {
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
                if (this.gAQ != null && this.gAQ.bIZ() != null && this.gAQ.bIZ().bHz() != null) {
                    Iterator<h> it = this.gAQ.bIZ().bHz().bHU().iterator();
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
                    com.baidu.tieba.tbadkCore.util.a.KR(currentAccount);
                }
                this.gAP.lY(this.gAQ.bJb());
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.gAQ != null) {
                        this.gAQ.lP(StringUtils.isNull(this.gAU) ? false : true);
                    }
                    this.gAR.LoadData();
                } else if (z2 && this.gAQ != null) {
                    this.gAQ.lP(StringUtils.isNull(this.gAU) ? false : true);
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
        if (this.gAO.isAdded() && this.gAO.isPrimary()) {
            if (this.gAR != null) {
                this.gAR.onPrimary();
            }
        } else {
            bIy();
        }
        if (this.gAP != null) {
            this.gAP.onPrimary();
        }
    }

    public void onPause() {
        if (this.gAP != null && this.gAP.bJX() != null) {
            this.gAP.bJX().completePullRefresh();
        }
        if (this.gAR != null) {
            this.gAR.onPause();
        }
        if (this.gAQ != null) {
            this.gAQ.onPause();
        }
        if (this.gAP != null) {
            this.gAP.onPause();
        }
    }

    public void asX() {
        if (this.gAP != null) {
            this.gAP.bQ(this.mRootView);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<h, Integer, String> {
        private h gBh;
        private x mNetwork = null;

        public b(h hVar) {
            this.gBh = null;
            this.gBh = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(h... hVarArr) {
            h hVar = this.gBh;
            if (hVar != null) {
                try {
                    if (hVar.getId() != null && hVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", hVar.getId());
                        this.mNetwork.addPostData("kw", hVar.getName());
                        this.mNetwork.aOy().aOZ().mIsNeedTbs = true;
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
                if (this.mNetwork.aOy().aPa().isRequestSuccess()) {
                    a.this.gAW = true;
                    if (a.this.gAO.isAdded() && a.this.eAO != null) {
                        a.this.eAO.showToast(a.this.eAO.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.n(false, this.gBh.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.gBh.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.gBh.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.gBh.getName()));
                    }
                    a.this.gAP.a(this.gBh, a.this.gAQ.bJb());
                    a.this.gAQ.b(this.gBh);
                } else if (a.this.eAO != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eAO.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.gAO.isAdded()) {
                        a.this.eAO.showToast(a.this.eAO.getActivity().getString(R.string.delete_like_fail));
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
    private class C0530a extends BdAsyncTask<h, Integer, String> {
        private h gBh;
        private x mNetwork = null;

        public C0530a(h hVar) {
            this.gBh = null;
            this.gBh = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(h... hVarArr) {
            h hVar = this.gBh;
            if (hVar != null) {
                try {
                    if (hVar.getId() != null && hVar.getName() != null) {
                        if (hVar.bHK() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", hVar.getId());
                        this.mNetwork.aOy().aOZ().mIsNeedTbs = true;
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
            super.onPostExecute((C0530a) str);
            a.this.lI(false);
            int bHK = this.gBh.bHK();
            if (this.mNetwork != null) {
                if (this.mNetwork.aOy().aPa().isRequestSuccess()) {
                    a.this.gAW = true;
                    if (a.this.gAO.isAdded() && a.this.eAO != null) {
                        a.this.eAO.showToast(a.this.eAO.getActivity().getString(bHK > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.gAQ.lO(true);
                } else if (a.this.eAO != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.eAO.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.gAO.isAdded()) {
                        a.this.eAO.showToast(a.this.eAO.getActivity().getString(bHK > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.ciV().x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aYJ = bVar.aYJ();
        com.baidu.tbadk.mvc.b.a aYK = bVar.aYK();
        switch (aYJ) {
            case 1:
                if (this.gAX != 2 && (aYK instanceof h)) {
                    String name = ((h) aYK).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.eAO.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((h) aYK).aWC() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((h) aYK).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((h) aYK).bHP());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((h) aYK).bHO().night != null && ((h) aYK).bHO().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((h) aYK).bHO().night.pattern_image);
                                    }
                                } else if (((h) aYK).bHO().day != null && ((h) aYK).bHO().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((h) aYK).bHO().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((h) aYK).bHS());
                            ((h) aYK).dW(0L);
                        }
                        this.eAO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.eAO.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").t("uid", TbadkApplication.getCurrentAccountId()).af("obj_type", this.gAQ.bIZ().getSortType() == 1 ? 2 : 1).cI("fid", ((h) aYK).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.gAX == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (aYK instanceof j) {
                    ((j) aYK).getPosition();
                }
                this.gAW = false;
                if (this.gAO.getView() == null || this.gAO.getView().getParent() == null) {
                    return true;
                }
                this.gAO.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (aYK instanceof h) {
                    a((h) aYK);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.eAO.getActivity());
                    return true;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eAO.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.eAO.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.eAO.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").cI("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).cI("obj_type", "2").af("obj_locate", 1));
                this.eAO.finish();
                return true;
            case 9:
                if (this.gAP != null) {
                    this.gAP.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.gAX = 2;
                return true;
            case 11:
                this.gAX = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.gAX != 2) {
                    if (this.gAY == null) {
                        this.gAY = new com.baidu.tieba.enterForum.view.d(this.eAO.getPageContext(), this.gyO);
                    }
                    if (aYK instanceof h) {
                        this.gAY.c((h) aYK);
                        this.gAY.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aYK instanceof h) {
                    new C0530a((h) aYK).execute(new h[0]);
                    TiebaStatic.log(new an("c13370").af("obj_type", ((h) aYK).bHK() <= 0 ? 1 : 2).cI("fid", ((h) aYK).getId()).t("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aOY().b(this.eAO.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eTz.cZY() || !(aYK instanceof h)) {
                    return true;
                }
                ba.aOY().b(this.eAO.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((h) aYK).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.aYL());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.aYL());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.d) bVar.aYL());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aYI() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.eAO.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gAP != null) {
            this.gAP.setPageUniqueId(bdUniqueId);
        }
    }

    public void lL(boolean z) {
        int i;
        if (this.gAP != null && this.gAO != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gAP.setAdState(dVar);
        this.gAO.setAdState(dVar);
    }

    public com.baidu.tieba.enterForum.view.b bIA() {
        return this.gAP;
    }
}
