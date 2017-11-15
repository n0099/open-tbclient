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
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel bRr;
    private BaseFragmentActivity bbn;
    private com.baidu.tieba.enterForum.home.a ckB;
    private EnterForumModel ckD;
    private boolean ckE;
    private String ckG;
    private long ckH;
    private boolean ckI;
    private boolean ckJ;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b ckC = null;
    private boolean ckF = false;
    private final CustomMessageListener bbo = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.ckC != null) {
                b.this.ckC.startPullRefresh();
            }
        }
    };
    private CustomMessageListener ckK = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ckF = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a ckL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.ckD.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.ckC.afN();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bbn.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bbn.showToast(errorString);
                    if (b.this.ckC.isEmpty()) {
                        b.this.ckC.as(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.ckD.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.ckD.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener ckM = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ckJ = true;
        }
    };
    private com.baidu.adp.base.d ckN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.ua(b.this.bRr.getErrorCode())) {
                AntiHelper.ao(b.this.bbn.getPageContext().getPageActivity(), b.this.bRr.getErrorString());
            } else if (obj != null) {
                b.this.ckD.ek(!StringUtils.isNull(b.this.ckG));
            } else if (!StringUtils.isNull(b.this.bRr.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.bRr.getErrorString());
            }
        }
    };
    private final EnterForumModel.b ckO = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.ckB.isAdded()) {
                if (aVar.type == 1) {
                    b.this.ckC.afN();
                }
                if (aVar.clh) {
                    if (aVar.type == 1) {
                        b.this.ckE = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.cli);
                    } else if (aVar.type == 0 && !b.this.ckE) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.cli;
                        b.this.ckD.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bbn.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.ckH > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.ckH, b.this.ckD.afz() - b.this.ckH, b.this.ckD.afx(), b.this.ckD.afy(), currentTimeMillis - b.this.ckD.afw());
                    b.this.ckH = -1L;
                }
                if (aVar.cli == null || aVar.cli.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bbn.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.cli.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.aeW() != null) {
                    b.this.setSearchHint(hotSearchInfoData.aeW());
                }
            }
        }
    };
    private g.b amy = new g.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            b.this.ckD.ek(!StringUtils.isNull(b.this.ckG));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cjP = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        NO();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.ckD = null;
        this.isFirst = true;
        this.ckE = false;
        this.ckH = -1L;
        this.ckB = aVar;
        this.bbn = aVar.getBaseFragmentActivity();
        this.cjP.addEventDelegate(this);
        this.ckH = System.currentTimeMillis();
        this.isFirst = true;
        this.ckE = false;
        this.ckG = "";
        this.ckD = new EnterForumModel(this.bbn.getPageContext());
        this.bRr = new LikeModel(this.bbn.getPageContext());
        this.bRr.setLoadDataCallBack(this.ckN);
        this.ckD.a(this.ckO);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.afr().l(this.ckB.getFragmentActivity(), l.n(this.ckB.getFragmentActivity()));
        initUI();
        initListener();
        afj();
    }

    private void initListener() {
        afm();
        this.ckB.registerListener(this.ckM);
        this.ckB.registerListener(this.ckL);
        this.ckB.registerListener(this.bbo);
        this.ckB.registerListener(this.ckK);
    }

    private static void NO() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void afj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ag>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ag> run(CustomMessage<ag> customMessage) {
                ag agVar = new ag();
                ArrayList arrayList = new ArrayList();
                if (b.this.ckD != null && b.this.ckD.afA() != null && b.this.ckD.afA().aeT() != null && v.u(b.this.ckD.afA().aeT().aeY()) > 0) {
                    Iterator<f> it = b.this.ckD.afA().aeT().aeY().iterator();
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
                    agVar.q(arrayList);
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, agVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.ckD.h(this.ckC.afO(), this.ckC.afP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.ckC.afL();
    }

    public View afl() {
        return this.ckC.afl();
    }

    public void aq(View view) {
        this.ckC.aq(view);
    }

    private void afm() {
        this.ckB.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.afk();
                } else {
                    b.this.afn();
                }
                if (b.this.ckI) {
                    b.this.ckC.startPullRefresh();
                }
            }
        });
        this.ckB.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ckC.afL();
                if (b.this.isChanged()) {
                    if (b.this.ckC.isEmpty()) {
                        b.this.ckC.as(b.this.mRootView);
                        return;
                    } else {
                        b.this.ckC.afK();
                        b.this.ckD.at(b.this.ckC.afO());
                    }
                }
                if (b.this.ckI) {
                    b.this.ckC.startPullRefresh();
                }
            }
        });
    }

    public void afn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bbn.getPageContext().getPageActivity());
        aVar.cc(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.afk();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cd(d.C0080d.cp_cont_b);
        aVar.b(this.bbn.getPageContext());
        aVar.th();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bbn.getPageContext().getPageActivity());
            aVar.cS(String.format(this.bbn.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.hy()) {
                        b.this.bbn.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.bbn.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cd(d.C0080d.cp_cont_b);
            aVar.b(this.bbn.getPageContext());
            aVar.th();
        }
    }

    public void eg(boolean z) {
        if (this.mWaitingDialog == null) {
            afo();
        }
        this.mWaitingDialog.aE(z);
    }

    private void afo() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.bbn.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bbn.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.ckC = new com.baidu.tieba.enterForum.b.b(this.ckB, this.mRootView, this.cjP);
        this.ckC.a(this.amy);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eh(boolean z) {
        if (this.ckC != null && this.ckB != null) {
            if (z) {
                if (this.ckB.isPrimary() && this.ckB.isResumed()) {
                    this.ckC.startPullRefresh();
                    return;
                } else {
                    this.ckC.afN();
                    return;
                }
            }
            this.ckC.afN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.ckB.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.ckC != null) {
            if (bVar == null) {
                this.ckC.as(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g aeT = bVar.aeT();
            ArrayList<f> arrayList = new ArrayList<>();
            if (aeT != null) {
                arrayList = aeT.aeY();
            }
            ar(arrayList);
            if (b(bVar)) {
                this.ckC.ay(bVar.aeU());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aeW() != null) {
                setSearchHint(hotSearchInfoData.aeW());
            }
            this.ckC.afQ();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.aeT() == null || v.v(bVar.aeT().aeY())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.ckC.setSearchHint(str.trim());
        } else {
            this.ckC.setSearchHint(this.bbn.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void ar(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ckC.ax(this.ckD.a(list, c.GU()));
        }
    }

    public void RG() {
        if (this.ckC != null) {
            ei(false);
        }
    }

    public void onDestroy() {
        ED();
        com.baidu.tieba.enterForum.model.a.afr().destroy();
        if (this.ckC != null) {
            if (this.ckD != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.ckD.at(this.ckC.afO());
            }
            this.ckC.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.ckC != null) {
            this.ckC.onChangeSkinType(i);
        }
    }

    public void ED() {
        if (this.ckD != null) {
            this.ckD.cancelLoadData();
        }
    }

    public void ei(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.ckJ && this.ckD != null && this.ckC != null) {
            String str = this.ckG;
            this.ckG = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.ckG == null || this.ckG.equals(str)) {
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
                if (this.ckD != null && this.ckD.afA() != null && this.ckD.afA().aeT() != null) {
                    Iterator<f> it = this.ckD.afA().aeT().aeY().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.iN(1);
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
                    com.baidu.tieba.tbadkCore.util.a.sF(currentAccount);
                }
                this.ckC.notifyDataSetChanged();
            }
            if (z2 || z4) {
                ED();
                if (z4) {
                    this.ckD.ek(StringUtils.isNull(this.ckG) ? false : true);
                } else if (z2) {
                    this.ckD.el(!StringUtils.isNull(this.ckG));
                    this.ckD.ek(StringUtils.isNull(this.ckG) ? false : true);
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
        if (this.ckC != null && this.ckC.afJ() != null) {
            this.ckC.afJ().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f ckS;
        private x mNetwork = null;

        public a(f fVar) {
            this.ckS = null;
            this.ckS = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.ckS;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.uN().vK().mIsNeedTbs = true;
                        this.mNetwork.up();
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
            b.this.eg(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.uN().vL().isRequestSuccess()) {
                    b.this.ckI = true;
                    if (b.this.ckB.isAdded() && b.this.bbn != null) {
                        b.this.bbn.showToast(b.this.bbn.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.f(false, this.ckS.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.ckS.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.ckS.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.ckS.getName()));
                    }
                    b.this.ckC.b(this.ckS);
                } else if (b.this.bbn != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bbn.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.ckB.isAdded()) {
                        b.this.bbn.showToast(b.this.bbn.getActivity().getString(d.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.eg(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aBz().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Fa = bVar.Fa();
        com.baidu.tbadk.mvc.b.a Fb = bVar.Fb();
        switch (Fa) {
            case 1:
                if (Fb instanceof f) {
                    String name = ((f) Fb).getName();
                    if (am.aL(name)) {
                        this.bbn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bbn.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<f> afO = this.ckC.afO();
                        if (!v.v(afO)) {
                            if (v.u(afO) > 1 && afO.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < afO.size()) {
                                    if (!afO.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new ak("c12049").ac("obj_type", "2").r("obj_locate", i));
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
                this.ckC.iP(Fb instanceof h ? ((h) Fb).getPosition() : 0);
                this.ckI = false;
                if (this.ckB.getView() == null || this.ckB.getView().getParent() == null) {
                    return true;
                }
                this.ckB.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Fb instanceof f) {
                    a((f) Fb);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.bbn.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bbn.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.bbn.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bbn.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ac("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ac("obj_type", "2").r("obj_locate", 1));
                this.bbn.finish();
                return true;
            case 9:
                if (this.ckC != null) {
                    this.ckC.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void afp() {
        if (this.ckC != null) {
            this.ckC.afM();
        }
    }

    public boolean afq() {
        if (this.ckC != null) {
            return this.ckC.afq();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EZ() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bbn.getUniqueId();
    }

    public void ej(boolean z) {
        int i = 1;
        if (this.ckC != null && this.ckB != null) {
            boolean z2 = this.ckC.afq() && this.ckB.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
