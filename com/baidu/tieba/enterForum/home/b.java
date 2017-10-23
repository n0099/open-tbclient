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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
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
import com.baidu.tieba.enterForum.b.f;
import com.baidu.tieba.enterForum.b.h;
import com.baidu.tieba.enterForum.b.i;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel bJy;
    private BaseFragmentActivity bay;
    private com.baidu.tieba.enterForum.home.a ccM;
    private EnterForumModel ccO;
    private boolean ccP;
    private String ccR;
    private long ccS;
    private boolean ccT;
    private com.baidu.tbadk.core.view.a ccU;
    private boolean ccV;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.b ccN = null;
    private boolean ccQ = false;
    private final CustomMessageListener baz = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.ccN != null) {
                b.this.ccN.startPullRefresh();
            }
        }
    };
    private CustomMessageListener ccW = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ccQ = true;
                b.this.ccN.ej(b.this.ccQ);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ccX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.ccO.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.ccN.ads();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bay.getResources().getString(d.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bay.showToast(errorString);
                    if (b.this.ccN.isEmpty()) {
                        b.this.ccN.ao(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.ccO.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.ccO.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener ccY = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ccV = true;
        }
    };
    private com.baidu.adp.base.d ccZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.tF(b.this.bJy.getErrorCode())) {
                AntiHelper.ao(b.this.bay.getPageContext().getPageActivity(), b.this.bJy.getErrorString());
            } else if (obj != null) {
                b.this.ccO.eh(!StringUtils.isNull(b.this.ccR));
            } else if (!StringUtils.isNull(b.this.bJy.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.bJy.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cda = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.ccM.isAdded()) {
                if (aVar.type == 1) {
                    b.this.ccN.ads();
                }
                if (aVar.cdt) {
                    if (aVar.type == 1) {
                        b.this.ccP = true;
                        new com.baidu.tieba.enterForum.b.b();
                        b.this.a(aVar.cdu);
                    } else if (aVar.type == 0 && !b.this.ccP) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.cdu;
                        b.this.ccO.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bay.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.ccS > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.ccS, b.this.ccO.add() - b.this.ccS, b.this.ccO.adb(), b.this.ccO.adc(), currentTimeMillis - b.this.ccO.ada());
                    b.this.ccS = -1L;
                }
                if (aVar.cdu == null || aVar.cdu.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bay.getResources().getString(d.l.enter_forum_search_tip));
                    return;
                }
                f hotSearchInfoData = aVar.cdu.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.acB());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.acC());
                b.this.setSearchHint(hotSearchInfoData.acB());
            }
        }
    };
    private g.b amd = new g.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            b.this.ccO.eh(!StringUtils.isNull(b.this.ccR));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cbZ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Nq();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.ccO = null;
        this.isFirst = true;
        this.ccP = false;
        this.ccS = -1L;
        this.ccM = aVar;
        this.bay = aVar.getBaseFragmentActivity();
        this.cbZ.addEventDelegate(this);
        this.ccS = System.currentTimeMillis();
        this.isFirst = true;
        this.ccP = false;
        this.ccR = "";
        this.ccO = new EnterForumModel(this.bay.getPageContext());
        this.bJy = new LikeModel(this.bay.getPageContext());
        this.bJy.setLoadDataCallBack(this.ccZ);
        this.ccO.a(this.cda);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.acV().l(this.ccM.getFragmentActivity(), l.n(this.ccM.getFragmentActivity()));
        initUI();
        initListener();
        acO();
    }

    private void initListener() {
        acQ();
        this.ccM.registerListener(this.ccY);
        this.ccM.registerListener(this.ccX);
        this.ccM.registerListener(this.baz);
        this.ccM.registerListener(this.ccW);
    }

    private static void Nq() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void acO() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ag>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ag> run(CustomMessage<ag> customMessage) {
                ag agVar = new ag();
                ArrayList arrayList = new ArrayList();
                if (b.this.ccO != null && b.this.ccO.ade() != null && b.this.ccO.ade().acy() != null && v.t(b.this.ccO.ade().acy().acE()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.b.g> it = b.this.ccO.ade().acy().acE().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.b.g next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.c(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    agVar.p(arrayList);
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, agVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.ccO.g(this.ccN.adt(), this.ccN.adu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acP() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.ccN.adq();
    }

    private void acQ() {
        this.ccM.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.acP();
                } else {
                    b.this.acR();
                }
                if (b.this.ccT) {
                    b.this.ccN.startPullRefresh();
                }
            }
        });
        this.ccM.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ccN.adq();
                if (b.this.isChanged()) {
                    if (b.this.ccN.isEmpty()) {
                        b.this.ccN.ao(b.this.mRootView);
                        return;
                    } else {
                        b.this.ccN.adp();
                        b.this.ccO.ar(b.this.ccN.adt());
                    }
                }
                if (b.this.ccT) {
                    b.this.ccN.startPullRefresh();
                }
            }
        });
    }

    public void acR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bay.getPageContext().getPageActivity());
        aVar.cc(d.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.l.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.acP();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cd(d.e.cp_cont_b);
        aVar.b(this.bay.getPageContext());
        aVar.tb();
    }

    public void a(final com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bay.getPageContext().getPageActivity());
            aVar.cL(String.format(this.bay.getPageContext().getString(d.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.l.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.hy()) {
                        b.this.bay.showToast(d.l.delete_like_fail);
                    } else {
                        new a(gVar).execute(new com.baidu.tieba.enterForum.b.g[0]);
                    }
                    TiebaStatic.eventStat(b.this.bay.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cd(d.e.cp_cont_b);
            aVar.b(this.bay.getPageContext());
            aVar.tb();
        }
    }

    public void ed(boolean z) {
        if (this.ccU == null) {
            acS();
        }
        this.ccU.aG(z);
    }

    private void acS() {
        this.ccU = new com.baidu.tbadk.core.view.a(this.bay.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bay.getActivity()).inflate(d.j.enter_forum_view, (ViewGroup) null);
        this.ccN = new com.baidu.tieba.enterForum.c.b(this.ccM, this.mRootView, this.cbZ);
        this.ccN.a(this.amd);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ee(boolean z) {
        if (this.ccN != null && this.ccM != null) {
            if (z) {
                if (this.ccM.isPrimary() && this.ccM.isResumed()) {
                    this.ccN.startPullRefresh();
                    return;
                } else {
                    this.ccN.ads();
                    return;
                }
            }
            this.ccN.ads();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.ccM.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.ccN != null) {
            if (bVar == null) {
                this.ccN.ao(this.mRootView);
                return;
            }
            h acy = bVar.acy();
            ArrayList<com.baidu.tieba.enterForum.b.g> arrayList = new ArrayList<>();
            if (acy != null) {
                arrayList = acy.acE();
            }
            ap(arrayList);
            if (b(bVar)) {
                this.ccN.aw(bVar.acz());
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.ccN.adv();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.b.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.acy() == null || v.u(bVar.acy().acE())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.ccN.setSearchHint(str.trim());
        } else {
            this.ccN.setSearchHint(this.bay.getActivity().getString(d.l.enter_forum_search_tip));
        }
    }

    private void ap(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ccN.av(this.ccO.a(list, c.Gx()));
        }
    }

    public void Qf() {
        if (this.ccN != null) {
            ef(false);
        }
    }

    public void onDestroy() {
        Ee();
        com.baidu.tieba.enterForum.model.a.acV().destroy();
        if (this.ccN != null) {
            if (this.ccO != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.ccO.ar(this.ccN.adt());
            }
            this.ccN.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.ccN != null) {
            this.ccN.onChangeSkinType(i);
        }
    }

    public void Ee() {
        if (this.ccO != null) {
            this.ccO.cancelLoadData();
        }
    }

    public void ef(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.ccV && this.ccO != null && this.ccN != null) {
            String str = this.ccR;
            this.ccR = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.ccR == null || this.ccR.equals(str)) {
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
                if (this.ccO != null && this.ccO.ade() != null && this.ccO.ade().acy() != null) {
                    Iterator<com.baidu.tieba.enterForum.b.g> it = this.ccO.ade().acy().acE().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.b.g next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.iz(1);
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
                    com.baidu.tieba.tbadkCore.util.a.rR(currentAccount);
                }
                this.ccN.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ee();
                if (z4) {
                    this.ccO.eh(StringUtils.isNull(this.ccR) ? false : true);
                } else if (z2) {
                    this.ccO.ei(!StringUtils.isNull(this.ccR));
                    this.ccO.eh(StringUtils.isNull(this.ccR) ? false : true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    public void onPause() {
        if (this.ccN != null && this.ccN.ado() != null) {
            this.ccN.ado().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<com.baidu.tieba.enterForum.b.g, Integer, String> {
        private com.baidu.tieba.enterForum.b.g cde;
        private x mNetwork = null;

        public a(com.baidu.tieba.enterForum.b.g gVar) {
            this.cde = null;
            this.cde = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.b.g... gVarArr) {
            com.baidu.tieba.enterForum.b.g gVar = this.cde;
            if (gVar != null) {
                try {
                    if (gVar.getId() != null && gVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", gVar.getId());
                        this.mNetwork.n("kw", gVar.getName());
                        this.mNetwork.uG().vC().mIsNeedTbs = true;
                        this.mNetwork.ui();
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
            b.this.ed(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.uG().vD().isRequestSuccess()) {
                    b.this.ccT = true;
                    if (b.this.ccM.isAdded() && b.this.bay != null) {
                        b.this.bay.showToast(b.this.bay.getActivity().getString(d.l.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.e(false, this.cde.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.cde.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cde.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.cde.getName()));
                    }
                    b.this.ccN.b(this.cde);
                } else if (b.this.bay != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bay.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.ccM.isAdded()) {
                        b.this.bay.showToast(b.this.bay.getActivity().getString(d.l.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.ed(true);
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
    public void e(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aza().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int EC = bVar.EC();
        com.baidu.tbadk.mvc.b.a ED = bVar.ED();
        switch (EC) {
            case 1:
                if (ED instanceof com.baidu.tieba.enterForum.b.g) {
                    String name = ((com.baidu.tieba.enterForum.b.g) ED).getName();
                    if (am.aL(name)) {
                        this.bay.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bay.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<com.baidu.tieba.enterForum.b.g> adt = this.ccN.adt();
                        if (!v.u(adt)) {
                            if (v.t(adt) > 1 && adt.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < adt.size()) {
                                    if (!adt.get(i2).getName().equals(name)) {
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
                this.ccN.iB(ED instanceof i ? ((i) ED).getPosition() : 0);
                this.ccT = false;
                if (this.ccM.getView() == null || this.ccM.getView().getParent() == null) {
                    return true;
                }
                this.ccM.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (ED instanceof com.baidu.tieba.enterForum.b.g) {
                    a((com.baidu.tieba.enterForum.b.g) ED);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.bay.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bay.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.bay.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bay.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ac("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ac("obj_type", "2").r("obj_locate", 1));
                this.bay.finish();
                return true;
            case 9:
                if (this.ccN != null) {
                    this.ccN.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void acT() {
        if (this.ccN != null) {
            this.ccN.adr();
        }
    }

    public boolean acU() {
        if (this.ccN != null) {
            return this.ccN.acU();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EB() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bay.getUniqueId();
    }

    public void eg(boolean z) {
        int i = 1;
        if (this.ccN != null && this.ccM != null) {
            boolean z2 = this.ccN.acU() && this.ccM.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
