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
    private BaseFragmentActivity aZc;
    private LikeModel bJG;
    private com.baidu.tieba.enterForum.home.a ccf;
    private EnterForumModel cch;
    private boolean cci;
    private String cck;
    private long ccl;
    private boolean ccm;
    private com.baidu.tbadk.core.view.a ccn;
    private boolean cco;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.b ccg = null;
    private boolean ccj = false;
    private final CustomMessageListener aZd = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.ccg != null) {
                b.this.ccg.startPullRefresh();
            }
        }
    };
    private CustomMessageListener ccp = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ccj = true;
                b.this.ccg.eq(b.this.ccj);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ccq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.cch.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.ccg.ady();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.aZc.getResources().getString(d.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.aZc.showToast(errorString);
                    if (b.this.ccg.isEmpty()) {
                        b.this.ccg.ap(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.cch.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.cch.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener ccr = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cco = true;
        }
    };
    private com.baidu.adp.base.d ccs = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.tz(b.this.bJG.getErrorCode())) {
                AntiHelper.ar(b.this.aZc.getPageContext().getPageActivity(), b.this.bJG.getErrorString());
            } else if (obj != null) {
                b.this.cch.eo(!StringUtils.isNull(b.this.cck));
            } else if (!StringUtils.isNull(b.this.bJG.getErrorString())) {
                k.showToast(TbadkCoreApplication.getInst(), b.this.bJG.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cct = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.ccf.isAdded()) {
                if (aVar.type == 1) {
                    b.this.ccg.ady();
                }
                if (aVar.ccM) {
                    if (aVar.type == 1) {
                        b.this.cci = true;
                        new com.baidu.tieba.enterForum.b.b();
                        b.this.a(aVar.ccN);
                    } else if (aVar.type == 0 && !b.this.cci) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.ccN;
                        b.this.cch.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.aZc.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.ccl > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.ccl, b.this.cch.adj() - b.this.ccl, b.this.cch.adh(), b.this.cch.adi(), currentTimeMillis - b.this.cch.adg());
                    b.this.ccl = -1L;
                }
                if (aVar.ccN == null || aVar.ccN.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.aZc.getResources().getString(d.l.enter_forum_search_tip));
                    return;
                }
                f hotSearchInfoData = aVar.ccN.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.acH());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.acI());
                b.this.setSearchHint(hotSearchInfoData.acH());
            }
        }
    };
    private k.b anh = new k.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            b.this.cch.eo(!StringUtils.isNull(b.this.cck));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cbt = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Nd();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.cch = null;
        this.isFirst = true;
        this.cci = false;
        this.ccl = -1L;
        this.ccf = aVar;
        this.aZc = aVar.getBaseFragmentActivity();
        this.cbt.addEventDelegate(this);
        this.ccl = System.currentTimeMillis();
        this.isFirst = true;
        this.cci = false;
        this.cck = "";
        this.cch = new EnterForumModel(this.aZc.getPageContext());
        this.bJG = new LikeModel(this.aZc.getPageContext());
        this.bJG.setLoadDataCallBack(this.ccs);
        this.cch.a(this.cct);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.adb().o(this.ccf.getFragmentActivity(), com.baidu.adp.lib.util.k.n(this.ccf.getFragmentActivity()));
        initUI();
        initListener();
        acU();
    }

    private void initListener() {
        acW();
        this.ccf.registerListener(this.ccr);
        this.ccf.registerListener(this.ccq);
        this.ccf.registerListener(this.aZd);
        this.ccf.registerListener(this.ccp);
    }

    private static void Nd() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void acU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ai>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ai> run(CustomMessage<ai> customMessage) {
                ai aiVar = new ai();
                ArrayList arrayList = new ArrayList();
                if (b.this.cch != null && b.this.cch.adk() != null && b.this.cch.adk().acE() != null && v.u(b.this.cch.adk().acE().acK()) > 0) {
                    Iterator<g> it = b.this.cch.adk().acE().acK().iterator();
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
        return !this.cch.g(this.ccg.adz(), this.ccg.adA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.ccg.adw();
    }

    private void acW() {
        this.ccf.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.acV();
                } else {
                    b.this.acX();
                }
                if (b.this.ccm) {
                    b.this.ccg.startPullRefresh();
                }
            }
        });
        this.ccf.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ccg.adw();
                if (b.this.isChanged()) {
                    if (b.this.ccg.isEmpty()) {
                        b.this.ccg.ap(b.this.mRootView);
                        return;
                    } else {
                        b.this.ccg.adv();
                        b.this.cch.as(b.this.ccg.adz());
                    }
                }
                if (b.this.ccm) {
                    b.this.ccg.startPullRefresh();
                }
            }
        });
    }

    public void acX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aZc.getPageContext().getPageActivity());
        aVar.cc(d.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.l.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.acV();
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
        aVar.b(this.aZc.getPageContext());
        aVar.to();
    }

    public void a(final g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aZc.getPageContext().getPageActivity());
            aVar.cM(String.format(this.aZc.getPageContext().getString(d.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.l.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!com.baidu.adp.lib.util.k.hz()) {
                        b.this.aZc.showToast(d.l.delete_like_fail);
                    } else {
                        new a(gVar).execute(new g[0]);
                    }
                    TiebaStatic.eventStat(b.this.aZc.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.aZc.getPageContext());
            aVar.to();
        }
    }

    public void ek(boolean z) {
        if (this.ccn == null) {
            acY();
        }
        this.ccn.aH(z);
    }

    private void acY() {
        this.ccn = new com.baidu.tbadk.core.view.a(this.aZc.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aZc.getActivity()).inflate(d.j.enter_forum_view, (ViewGroup) null);
        this.ccg = new com.baidu.tieba.enterForum.c.b(this.ccf, this.mRootView, this.cbt);
        this.ccg.a(this.anh);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void el(boolean z) {
        if (this.ccg != null && this.ccf != null) {
            if (z) {
                if (this.ccf.isPrimary() && this.ccf.isResumed()) {
                    this.ccg.startPullRefresh();
                    return;
                } else {
                    this.ccg.ady();
                    return;
                }
            }
            this.ccg.ady();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.ccf.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.ccg != null) {
            if (bVar == null) {
                this.ccg.ap(this.mRootView);
                return;
            }
            h acE = bVar.acE();
            ArrayList<g> arrayList = new ArrayList<>();
            if (acE != null) {
                arrayList = acE.acK();
            }
            aq(arrayList);
            if (b(bVar)) {
                this.ccg.ax(bVar.acF());
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.ccg.adB();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.b.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.acE() == null || v.v(bVar.acE().acK())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.ccg.setSearchHint(str.trim());
        } else {
            this.ccg.setSearchHint(this.aZc.getActivity().getString(d.l.enter_forum_search_tip));
        }
    }

    private void aq(List<g> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ccg.aw(this.cch.a(list, c.GY()));
        }
    }

    public void PN() {
        if (this.ccg != null) {
            em(false);
        }
    }

    public void onDestroy() {
        EF();
        com.baidu.tieba.enterForum.model.a.adb().destroy();
        if (this.ccg != null) {
            if (this.cch != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cch.as(this.ccg.adz());
            }
            this.ccg.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.ccg != null) {
            this.ccg.onChangeSkinType(i);
        }
    }

    public void EF() {
        if (this.cch != null) {
            this.cch.cancelLoadData();
        }
    }

    public void em(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cco && this.cch != null && this.ccg != null) {
            String str = this.cck;
            this.cck = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cck == null || this.cck.equals(str)) {
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
                if (this.cch != null && this.cch.adk() != null && this.cch.adk().acE() != null) {
                    Iterator<g> it = this.cch.adk().acE().acK().iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.iq(1);
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
                    com.baidu.tieba.tbadkCore.util.a.sg(currentAccount);
                }
                this.ccg.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EF();
                if (z4) {
                    this.cch.eo(StringUtils.isNull(this.cck) ? false : true);
                } else if (z2) {
                    this.cch.ep(!StringUtils.isNull(this.cck));
                    this.cch.eo(StringUtils.isNull(this.cck) ? false : true);
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
        if (this.ccg != null && this.ccg.adu() != null) {
            this.ccg.adu().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<g, Integer, String> {
        private g ccx;
        private x mNetwork = null;

        public a(g gVar) {
            this.ccx = null;
            this.ccx = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(g... gVarArr) {
            g gVar = this.ccx;
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
            b.this.ek(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.vj().wg().isRequestSuccess()) {
                    b.this.ccm = true;
                    if (b.this.ccf.isAdded() && b.this.aZc != null) {
                        b.this.aZc.showToast(b.this.aZc.getActivity().getString(d.l.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.e(false, this.ccx.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.ccx.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.ccx.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.ccx.getName()));
                    }
                    b.this.ccg.b(this.ccx);
                } else if (b.this.aZc != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.aZc.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.ccf.isAdded()) {
                        b.this.aZc.showToast(b.this.aZc.getActivity().getString(d.l.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.ek(true);
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
                    com.baidu.tieba.im.settingcache.d.aAh().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
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
                        this.aZc.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aZc.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<g> adz = this.ccg.adz();
                        if (!v.v(adz)) {
                            if (v.u(adz) > 1 && adz.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < adz.size()) {
                                    if (!adz.get(i2).getName().equals(name)) {
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
                this.ccg.is(Fe instanceof i ? ((i) Fe).getPosition() : 0);
                this.ccm = false;
                if (this.ccf.getView() == null || this.ccf.getView().getParent() == null) {
                    return true;
                }
                this.ccf.getView().getParent().requestDisallowInterceptTouchEvent(true);
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aZc.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aZc.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aZc.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aZc.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ad("obj_type", "4"));
                return true;
            case 8:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, "推荐"));
                TiebaStatic.log(new ak("c12049").ad("obj_type", "2").r("obj_locate", 1));
                this.aZc.finish();
                return true;
            case 9:
                if (this.ccg != null) {
                    this.ccg.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void acZ() {
        if (this.ccg != null) {
            this.ccg.adx();
        }
    }

    public boolean ada() {
        if (this.ccg != null) {
            return this.ccg.ada();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fc() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aZc.getUniqueId();
    }

    public void en(boolean z) {
        int i = 1;
        if (this.ccg != null && this.ccf != null) {
            boolean z2 = this.ccg.ada() && this.ccf.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
