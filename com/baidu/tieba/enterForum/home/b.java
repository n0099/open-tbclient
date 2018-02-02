package com.baidu.tieba.enterForum.home;

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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity bSa;
    private LikeModel cSY;
    private com.baidu.tieba.enterForum.home.a dmM;
    private EnterForumModel dmO;
    private boolean dmP;
    private String dmR;
    private long dmS;
    private boolean dmT;
    private boolean dmU;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b dmN = null;
    private boolean dmQ = false;
    private CustomMessageListener dmV = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.dmQ = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a dmW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.dmO.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.dmN.sW();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bSa.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bSa.showToast(errorString);
                    if (b.this.dmN.isEmpty()) {
                        b.this.dmN.bK(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.dmO.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.dmO.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener dmX = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.dmU = true;
        }
    };
    private com.baidu.adp.base.d dmY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (AntiHelper.vQ(b.this.cSY.getErrorCode())) {
                AntiHelper.an(b.this.bSa.getPageContext().getPageActivity(), b.this.cSY.getErrorString());
            } else if (obj != null) {
                b.this.dmO.fq(!StringUtils.isNull(b.this.dmR));
            } else if (!StringUtils.isNull(b.this.cSY.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.cSY.getErrorString());
            }
        }
    };
    private final EnterForumModel.b dmZ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.dmM.isAdded()) {
                if (aVar.type == 1) {
                    b.this.dmN.sW();
                }
                if (aVar.dnt) {
                    if (aVar.type == 1) {
                        b.this.dmP = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.dnu);
                    } else if (aVar.type == 0 && !b.this.dmP) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.dnu;
                        b.this.dmO.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bSa.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.dmS > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.dmS, b.this.dmO.aqb() - b.this.dmS, b.this.dmO.apZ(), b.this.dmO.aqa(), currentTimeMillis - b.this.dmO.apY());
                    b.this.dmS = -1L;
                }
                if (aVar.dnu == null || aVar.dnu.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bSa.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.dnu.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.apy() != null) {
                    b.this.setSearchHint(hotSearchInfoData.apy());
                }
            }
        }
    };
    private j.b baZ = new j.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void onListPullRefresh(boolean z) {
            b.this.dmO.fq(!StringUtils.isNull(b.this.dmR));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter dme = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        VV();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.dmO = null;
        this.isFirst = true;
        this.dmP = false;
        this.dmS = -1L;
        this.dmM = aVar;
        this.bSa = aVar.getBaseFragmentActivity();
        this.dme.addEventDelegate(this);
        this.dmS = System.currentTimeMillis();
        this.isFirst = true;
        this.dmP = false;
        this.dmR = "";
        this.dmO = new EnterForumModel(this.bSa.getPageContext());
        this.cSY = new LikeModel(this.bSa.getPageContext());
        this.cSY.setLoadDataCallBack(this.dmY);
        this.dmO.a(this.dmZ);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.apT().y(this.dmM.getFragmentActivity(), l.n(this.dmM.getFragmentActivity()));
        initUI();
        initListener();
        apL();
    }

    private void initListener() {
        apO();
        this.dmM.registerListener(this.dmX);
        this.dmM.registerListener(this.dmW);
        this.dmM.registerListener(this.dmV);
    }

    private static void VV() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void apL() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (b.this.dmO != null && b.this.dmO.aqc() != null && b.this.dmO.aqc().apv() != null && v.D(b.this.dmO.aqc().apv().apA()) > 0) {
                    Iterator<f> it = b.this.dmO.aqc().apv().apA().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.c(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    acVar.A(arrayList);
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, acVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.dmO.i(this.dmN.aqo(), this.dmN.aqp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.dmN.aqm();
    }

    public View apN() {
        return this.dmN.apN();
    }

    public void bI(View view) {
        this.dmN.bI(view);
    }

    private void apO() {
        this.dmM.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.apM();
                } else {
                    b.this.apP();
                }
                if (b.this.dmT) {
                    b.this.dmN.startPullRefresh();
                }
            }
        });
        this.dmM.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dmN.aqm();
                if (b.this.isChanged()) {
                    if (b.this.dmN.isEmpty()) {
                        b.this.dmN.bK(b.this.mRootView);
                        return;
                    } else {
                        b.this.dmN.aql();
                        b.this.dmO.aO(b.this.dmN.aqo());
                    }
                }
                if (b.this.dmT) {
                    b.this.dmN.startPullRefresh();
                }
            }
        });
    }

    public void apP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bSa.getPageContext().getPageActivity());
        aVar.fb(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.apM();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.fc(d.C0108d.cp_cont_b);
        aVar.b(this.bSa.getPageContext());
        aVar.AB();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bSa.getPageContext().getPageActivity());
            aVar.cZ(String.format(this.bSa.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.pa()) {
                        b.this.bSa.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.bSa.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fc(d.C0108d.cp_cont_b);
            aVar.b(this.bSa.getPageContext());
            aVar.AB();
        }
    }

    public void fm(boolean z) {
        if (this.mWaitingDialog == null) {
            apQ();
        }
        this.mWaitingDialog.bn(z);
    }

    private void apQ() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.bSa.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bSa.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.dmN = new com.baidu.tieba.enterForum.b.b(this.dmM, this.mRootView, this.dme);
        this.dmN.a(this.baZ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fn(boolean z) {
        if (this.dmN != null && this.dmM != null) {
            if (z) {
                if (this.dmM.isPrimary() && this.dmM.isResumed()) {
                    this.dmN.startPullRefresh();
                    return;
                } else {
                    this.dmN.sW();
                    return;
                }
            }
            this.dmN.sW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.dmM.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.dmN != null) {
            if (bVar == null) {
                this.dmN.bK(this.mRootView);
                return;
            }
            g apv = bVar.apv();
            ArrayList<f> arrayList = new ArrayList<>();
            if (apv != null) {
                arrayList = apv.apA();
            }
            aM(arrayList);
            if (b(bVar)) {
                this.dmN.aT(bVar.apw());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.apy() != null) {
                setSearchHint(hotSearchInfoData.apy());
            }
            this.dmN.aqq();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.apv() == null || v.E(bVar.apv().apA())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.dmN.setSearchHint(str.trim());
        } else {
            this.dmN.setSearchHint(this.bSa.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void aM(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.dmN.aS(this.dmO.a(list, c.Or()));
        }
    }

    public void VB() {
        if (this.dmN != null) {
            fo(false);
        }
    }

    public void onDestroy() {
        Mb();
        com.baidu.tieba.enterForum.model.a.apT().destroy();
        if (this.dmN != null) {
            if (this.dmO != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.dmO.aO(this.dmN.aqo());
            }
            this.dmN.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.dmN != null) {
            this.dmN.onChangeSkinType(i);
        }
    }

    public void Mb() {
        if (this.dmO != null) {
            this.dmO.cancelLoadData();
        }
    }

    public void fo(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.dmU && this.dmO != null && this.dmN != null) {
            String str = this.dmR;
            this.dmR = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.dmR == null || this.dmR.equals(str)) {
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
                if (this.dmO != null && this.dmO.aqc() != null && this.dmO.aqc().apv() != null) {
                    Iterator<f> it = this.dmO.aqc().apv().apA().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.mo(1);
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
                    com.baidu.tieba.tbadkCore.util.a.sI(currentAccount);
                }
                this.dmN.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Mb();
                if (z4) {
                    this.dmO.fq(StringUtils.isNull(this.dmR) ? false : true);
                } else if (z2) {
                    this.dmO.fr(!StringUtils.isNull(this.dmR));
                    this.dmO.fq(StringUtils.isNull(this.dmR) ? false : true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    public void onPause() {
        if (this.dmN != null && this.dmN.aqk() != null) {
            this.dmN.aqk().completePullRefresh();
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f dne;
        private x mNetwork = null;

        public a(f fVar) {
            this.dne = null;
            this.dne = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.dne;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.Cg().Dc().mIsNeedTbs = true;
                        this.mNetwork.BI();
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
            super.onPostExecute((a) str);
            b.this.fm(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.Cg().Dd().isRequestSuccess()) {
                    b.this.dmT = true;
                    if (b.this.dmM.isAdded() && b.this.bSa != null) {
                        b.this.bSa.showToast(b.this.bSa.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.f(false, this.dne.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.dne.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.dne.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.dne.getName()));
                    }
                    b.this.dmN.b(this.dne);
                } else if (b.this.bSa != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bSa.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.dmM.isAdded()) {
                        b.this.bSa.showToast(b.this.bSa.getActivity().getString(d.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.fm(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.b.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aKu().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Mx = bVar.Mx();
        com.baidu.tbadk.mvc.b.a My = bVar.My();
        switch (Mx) {
            case 1:
                if (My instanceof f) {
                    String name = ((f) My).getName();
                    if (am.aT(name)) {
                        this.bSa.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bSa.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<f> aqo = this.dmN.aqo();
                        if (!v.E(aqo)) {
                            if (v.D(aqo) > 1 && aqo.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < aqo.size()) {
                                    if (!aqo.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new ak("c12049").aa("obj_type", "2").s("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.dmN.mq(My instanceof h ? ((h) My).getPosition() : 0);
                this.dmT = false;
                if (this.dmM.getView() == null || this.dmM.getView().getParent() == null) {
                    return true;
                }
                this.dmM.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (My instanceof f) {
                    a((f) My);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.bSa.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bSa.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.bSa.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bSa.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").aa("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").aa("obj_type", "2").s("obj_locate", 1));
                this.bSa.finish();
                return true;
            case 9:
                if (this.dmN != null) {
                    this.dmN.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void apR() {
        if (this.dmN != null) {
            this.dmN.aqn();
        }
    }

    public boolean apS() {
        if (this.dmN != null) {
            return this.dmN.apS();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Mw() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bSa.getUniqueId();
    }

    public void fp(boolean z) {
        int i = 1;
        if (this.dmN != null && this.dmM != null) {
            boolean z2 = this.dmN.apS() && this.dmM.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
