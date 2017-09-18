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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.f;
import com.baidu.tieba.enterForum.b.g;
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
    private BaseFragmentActivity aYZ;
    private LikeModel bKx;
    private com.baidu.tieba.enterForum.home.a ccX;
    private EnterForumModel ccZ;
    private boolean cda;
    private String cdc;
    private long cdd;
    private boolean cde;
    private com.baidu.tbadk.core.view.a cdf;
    private boolean cdg;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.b ccY = null;
    private boolean cdb = false;
    private final CustomMessageListener aZa = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.ccY != null) {
                b.this.ccY.startPullRefresh();
            }
        }
    };
    private CustomMessageListener cdh = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cdb = true;
                b.this.ccY.er(b.this.cdb);
            }
        }
    };
    private com.baidu.adp.framework.listener.a cdi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.ccZ.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.ccY.adJ();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.aYZ.getResources().getString(d.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.aYZ.showToast(errorString);
                    if (b.this.ccY.isEmpty()) {
                        b.this.ccY.ap(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.ccZ.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.ccZ.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener cdj = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cdg = true;
        }
    };
    private com.baidu.adp.base.d cdk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.tB(b.this.bKx.getErrorCode())) {
                AntiHelper.ar(b.this.aYZ.getPageContext().getPageActivity(), b.this.bKx.getErrorString());
            } else if (obj != null) {
                b.this.ccZ.ep(!StringUtils.isNull(b.this.cdc));
            } else if (!StringUtils.isNull(b.this.bKx.getErrorString())) {
                k.showToast(TbadkCoreApplication.getInst(), b.this.bKx.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cdl = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.ccX.isAdded()) {
                if (aVar.type == 1) {
                    b.this.ccY.adJ();
                }
                if (aVar.cdE) {
                    if (aVar.type == 1) {
                        b.this.cda = true;
                        new com.baidu.tieba.enterForum.b.b();
                        b.this.a(aVar.cdF);
                    } else if (aVar.type == 0 && !b.this.cda) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.cdF;
                        b.this.ccZ.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.aYZ.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.cdd > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.cdd, b.this.ccZ.adu() - b.this.cdd, b.this.ccZ.ads(), b.this.ccZ.adt(), currentTimeMillis - b.this.ccZ.adr());
                    b.this.cdd = -1L;
                }
                if (aVar.cdF == null || aVar.cdF.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.aYZ.getResources().getString(d.l.enter_forum_search_tip));
                    return;
                }
                f hotSearchInfoData = aVar.cdF.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.acS());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.acT());
                b.this.setSearchHint(hotSearchInfoData.acS());
            }
        }
    };
    private k.b anf = new k.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            b.this.ccZ.ep(!StringUtils.isNull(b.this.cdc));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter ccl = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Ne();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.ccZ = null;
        this.isFirst = true;
        this.cda = false;
        this.cdd = -1L;
        this.ccX = aVar;
        this.aYZ = aVar.getBaseFragmentActivity();
        this.ccl.addEventDelegate(this);
        this.cdd = System.currentTimeMillis();
        this.isFirst = true;
        this.cda = false;
        this.cdc = "";
        this.ccZ = new EnterForumModel(this.aYZ.getPageContext());
        this.bKx = new LikeModel(this.aYZ.getPageContext());
        this.bKx.setLoadDataCallBack(this.cdk);
        this.ccZ.a(this.cdl);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.adm().n(this.ccX.getFragmentActivity(), com.baidu.adp.lib.util.k.n(this.ccX.getFragmentActivity()));
        initUI();
        initListener();
        adf();
    }

    private void initListener() {
        adh();
        this.ccX.registerListener(this.cdj);
        this.ccX.registerListener(this.cdi);
        this.ccX.registerListener(this.aZa);
        this.ccX.registerListener(this.cdh);
    }

    private static void Ne() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void adf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ai>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ai> run(CustomMessage<ai> customMessage) {
                ai aiVar = new ai();
                ArrayList arrayList = new ArrayList();
                if (b.this.ccZ != null && b.this.ccZ.adv() != null && b.this.ccZ.adv().acP() != null && v.u(b.this.ccZ.adv().acP().acV()) > 0) {
                    Iterator<g> it = b.this.ccZ.adv().acP().acV().iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.c(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    aiVar.q(arrayList);
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, aiVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.ccZ.g(this.ccY.adK(), this.ccY.adL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.ccY.adH();
    }

    private void adh() {
        this.ccX.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.adg();
                } else {
                    b.this.adi();
                }
                if (b.this.cde) {
                    b.this.ccY.startPullRefresh();
                }
            }
        });
        this.ccX.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ccY.adH();
                if (b.this.isChanged()) {
                    if (b.this.ccY.isEmpty()) {
                        b.this.ccY.ap(b.this.mRootView);
                        return;
                    } else {
                        b.this.ccY.adG();
                        b.this.ccZ.as(b.this.ccY.adK());
                    }
                }
                if (b.this.cde) {
                    b.this.ccY.startPullRefresh();
                }
            }
        });
    }

    public void adi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aYZ.getPageContext().getPageActivity());
        aVar.cc(d.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.l.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.adg();
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
        aVar.b(this.aYZ.getPageContext());
        aVar.to();
    }

    public void a(final g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aYZ.getPageContext().getPageActivity());
            aVar.cM(String.format(this.aYZ.getPageContext().getString(d.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.l.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!com.baidu.adp.lib.util.k.hz()) {
                        b.this.aYZ.showToast(d.l.delete_like_fail);
                    } else {
                        new a(gVar).execute(new g[0]);
                    }
                    TiebaStatic.eventStat(b.this.aYZ.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.aYZ.getPageContext());
            aVar.to();
        }
    }

    public void el(boolean z) {
        if (this.cdf == null) {
            adj();
        }
        this.cdf.aH(z);
    }

    private void adj() {
        this.cdf = new com.baidu.tbadk.core.view.a(this.aYZ.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aYZ.getActivity()).inflate(d.j.enter_forum_view, (ViewGroup) null);
        this.ccY = new com.baidu.tieba.enterForum.c.b(this.ccX, this.mRootView, this.ccl);
        this.ccY.a(this.anf);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void em(boolean z) {
        if (this.ccY != null && this.ccX != null) {
            if (z) {
                if (this.ccX.isPrimary() && this.ccX.isResumed()) {
                    this.ccY.startPullRefresh();
                    return;
                } else {
                    this.ccY.adJ();
                    return;
                }
            }
            this.ccY.adJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.ccX.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.ccY != null) {
            if (bVar == null) {
                this.ccY.ap(this.mRootView);
                return;
            }
            h acP = bVar.acP();
            ArrayList<g> arrayList = new ArrayList<>();
            if (acP != null) {
                arrayList = acP.acV();
            }
            aq(arrayList);
            if (b(bVar)) {
                this.ccY.ax(bVar.acQ());
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.ccY.adM();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.b.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.acP() == null || v.v(bVar.acP().acV())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.ccY.setSearchHint(str.trim());
        } else {
            this.ccY.setSearchHint(this.aYZ.getActivity().getString(d.l.enter_forum_search_tip));
        }
    }

    private void aq(List<g> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ccY.aw(this.ccZ.a(list, c.GY()));
        }
    }

    public void PP() {
        if (this.ccY != null) {
            en(false);
        }
    }

    public void onDestroy() {
        EF();
        com.baidu.tieba.enterForum.model.a.adm().destroy();
        if (this.ccY != null) {
            if (this.ccZ != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.ccZ.as(this.ccY.adK());
            }
            this.ccY.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.ccY != null) {
            this.ccY.onChangeSkinType(i);
        }
    }

    public void EF() {
        if (this.ccZ != null) {
            this.ccZ.cancelLoadData();
        }
    }

    public void en(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cdg && this.ccZ != null && this.ccY != null) {
            String str = this.cdc;
            this.cdc = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cdc == null || this.cdc.equals(str)) {
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
                if (this.ccZ != null && this.ccZ.adv() != null && this.ccZ.adv().acP() != null) {
                    Iterator<g> it = this.ccZ.adv().acP().acV().iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.is(1);
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
                    com.baidu.tieba.tbadkCore.util.a.si(currentAccount);
                }
                this.ccY.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EF();
                if (z4) {
                    this.ccZ.ep(StringUtils.isNull(this.cdc) ? false : true);
                } else if (z2) {
                    this.ccZ.eq(!StringUtils.isNull(this.cdc));
                    this.ccZ.ep(StringUtils.isNull(this.cdc) ? false : true);
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
        if (this.ccY != null && this.ccY.adF() != null) {
            this.ccY.adF().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<g, Integer, String> {
        private g cdp;
        private x mNetwork = null;

        public a(g gVar) {
            this.cdp = null;
            this.cdp = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(g... gVarArr) {
            g gVar = this.cdp;
            if (gVar != null) {
                try {
                    if (gVar.getId() != null && gVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", gVar.getId());
                        this.mNetwork.n("kw", gVar.getName());
                        this.mNetwork.vj().wf().mIsNeedTbs = true;
                        this.mNetwork.uM();
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
            b.this.el(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.vj().wg().isRequestSuccess()) {
                    b.this.cde = true;
                    if (b.this.ccX.isAdded() && b.this.aYZ != null) {
                        b.this.aYZ.showToast(b.this.aYZ.getActivity().getString(d.l.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.e(false, this.cdp.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.cdp.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cdp.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.cdp.getName()));
                    }
                    b.this.ccY.b(this.cdp);
                } else if (b.this.aYZ != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.aYZ.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.ccX.isAdded()) {
                        b.this.aYZ.showToast(b.this.aYZ.getActivity().getString(d.l.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.el(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fp();
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
                    com.baidu.tieba.im.settingcache.d.aAs().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Fd = bVar.Fd();
        com.baidu.tbadk.mvc.b.a Fe = bVar.Fe();
        switch (Fd) {
            case 1:
                if (Fe instanceof g) {
                    String name = ((g) Fe).getName();
                    if (am.aL(name)) {
                        this.aYZ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aYZ.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<g> adK = this.ccY.adK();
                        if (!v.v(adK)) {
                            if (v.u(adK) > 1 && adK.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < adK.size()) {
                                    if (!adK.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new ak("c12049").ad("obj_type", "2").r("obj_locate", i));
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
                this.ccY.iu(Fe instanceof i ? ((i) Fe).getPosition() : 0);
                this.cde = false;
                if (this.ccX.getView() == null || this.ccX.getView().getParent() == null) {
                    return true;
                }
                this.ccX.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Fe instanceof g) {
                    a((g) Fe);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aYZ.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aYZ.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aYZ.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aYZ.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ad("obj_type", "4"));
                return true;
            case 8:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, "推荐"));
                TiebaStatic.log(new ak("c12049").ad("obj_type", "2").r("obj_locate", 1));
                this.aYZ.finish();
                return true;
            case 9:
                if (this.ccY != null) {
                    this.ccY.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void adk() {
        if (this.ccY != null) {
            this.ccY.adI();
        }
    }

    public boolean adl() {
        if (this.ccY != null) {
            return this.ccY.adl();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fc() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aYZ.getUniqueId();
    }

    public void eo(boolean z) {
        int i = 1;
        if (this.ccY != null && this.ccX != null) {
            boolean z2 = this.ccY.adl() && this.ccX.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
