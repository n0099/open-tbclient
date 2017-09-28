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
    private LikeModel bJK;
    private BaseFragmentActivity baM;
    private com.baidu.tieba.enterForum.home.a ccY;
    private EnterForumModel cda;
    private boolean cdb;
    private String cdd;
    private long cde;
    private boolean cdf;
    private com.baidu.tbadk.core.view.a cdg;
    private boolean cdh;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.b ccZ = null;
    private boolean cdc = false;
    private final CustomMessageListener baN = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.ccZ != null) {
                b.this.ccZ.startPullRefresh();
            }
        }
    };
    private CustomMessageListener cdi = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cdc = true;
                b.this.ccZ.ek(b.this.cdc);
            }
        }
    };
    private com.baidu.adp.framework.listener.a cdj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.cda.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.ccZ.adw();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.baM.getResources().getString(d.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.baM.showToast(errorString);
                    if (b.this.ccZ.isEmpty()) {
                        b.this.ccZ.ao(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.cda.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.cda.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener cdk = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cdh = true;
        }
    };
    private com.baidu.adp.base.d cdl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.tG(b.this.bJK.getErrorCode())) {
                AntiHelper.at(b.this.baM.getPageContext().getPageActivity(), b.this.bJK.getErrorString());
            } else if (obj != null) {
                b.this.cda.ei(!StringUtils.isNull(b.this.cdd));
            } else if (!StringUtils.isNull(b.this.bJK.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.bJK.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cdm = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.ccY.isAdded()) {
                if (aVar.type == 1) {
                    b.this.ccZ.adw();
                }
                if (aVar.cdF) {
                    if (aVar.type == 1) {
                        b.this.cdb = true;
                        new com.baidu.tieba.enterForum.b.b();
                        b.this.a(aVar.cdG);
                    } else if (aVar.type == 0 && !b.this.cdb) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.cdG;
                        b.this.cda.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.baM.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.cde > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.cde, b.this.cda.adh() - b.this.cde, b.this.cda.adf(), b.this.cda.adg(), currentTimeMillis - b.this.cda.ade());
                    b.this.cde = -1L;
                }
                if (aVar.cdG == null || aVar.cdG.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.baM.getResources().getString(d.l.enter_forum_search_tip));
                    return;
                }
                f hotSearchInfoData = aVar.cdG.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.acF());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.acG());
                b.this.setSearchHint(hotSearchInfoData.acF());
            }
        }
    };
    private g.b amp = new g.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            b.this.cda.ei(!StringUtils.isNull(b.this.cdd));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter ccl = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Nw();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.cda = null;
        this.isFirst = true;
        this.cdb = false;
        this.cde = -1L;
        this.ccY = aVar;
        this.baM = aVar.getBaseFragmentActivity();
        this.ccl.addEventDelegate(this);
        this.cde = System.currentTimeMillis();
        this.isFirst = true;
        this.cdb = false;
        this.cdd = "";
        this.cda = new EnterForumModel(this.baM.getPageContext());
        this.bJK = new LikeModel(this.baM.getPageContext());
        this.bJK.setLoadDataCallBack(this.cdl);
        this.cda.a(this.cdm);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.acZ().m(this.ccY.getFragmentActivity(), l.n(this.ccY.getFragmentActivity()));
        initUI();
        initListener();
        acS();
    }

    private void initListener() {
        acU();
        this.ccY.registerListener(this.cdk);
        this.ccY.registerListener(this.cdj);
        this.ccY.registerListener(this.baN);
        this.ccY.registerListener(this.cdi);
    }

    private static void Nw() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void acS() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ag>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ag> run(CustomMessage<ag> customMessage) {
                ag agVar = new ag();
                ArrayList arrayList = new ArrayList();
                if (b.this.cda != null && b.this.cda.adi() != null && b.this.cda.adi().acC() != null && v.t(b.this.cda.adi().acC().acI()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.b.g> it = b.this.cda.adi().acC().acI().iterator();
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
        return !this.cda.g(this.ccZ.adx(), this.ccZ.ady());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.ccZ.adu();
    }

    private void acU() {
        this.ccY.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.acT();
                } else {
                    b.this.acV();
                }
                if (b.this.cdf) {
                    b.this.ccZ.startPullRefresh();
                }
            }
        });
        this.ccY.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ccZ.adu();
                if (b.this.isChanged()) {
                    if (b.this.ccZ.isEmpty()) {
                        b.this.ccZ.ao(b.this.mRootView);
                        return;
                    } else {
                        b.this.ccZ.adt();
                        b.this.cda.ar(b.this.ccZ.adx());
                    }
                }
                if (b.this.cdf) {
                    b.this.ccZ.startPullRefresh();
                }
            }
        });
    }

    public void acV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.baM.getPageContext().getPageActivity());
        aVar.cd(d.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.l.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.acT();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.ce(d.e.cp_cont_b);
        aVar.b(this.baM.getPageContext());
        aVar.ti();
    }

    public void a(final com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.baM.getPageContext().getPageActivity());
            aVar.cM(String.format(this.baM.getPageContext().getString(d.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.l.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.hy()) {
                        b.this.baM.showToast(d.l.delete_like_fail);
                    } else {
                        new a(gVar).execute(new com.baidu.tieba.enterForum.b.g[0]);
                    }
                    TiebaStatic.eventStat(b.this.baM.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ce(d.e.cp_cont_b);
            aVar.b(this.baM.getPageContext());
            aVar.ti();
        }
    }

    public void ee(boolean z) {
        if (this.cdg == null) {
            acW();
        }
        this.cdg.aH(z);
    }

    private void acW() {
        this.cdg = new com.baidu.tbadk.core.view.a(this.baM.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.baM.getActivity()).inflate(d.j.enter_forum_view, (ViewGroup) null);
        this.ccZ = new com.baidu.tieba.enterForum.c.b(this.ccY, this.mRootView, this.ccl);
        this.ccZ.a(this.amp);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ef(boolean z) {
        if (this.ccZ != null && this.ccY != null) {
            if (z) {
                if (this.ccY.isPrimary() && this.ccY.isResumed()) {
                    this.ccZ.startPullRefresh();
                    return;
                } else {
                    this.ccZ.adw();
                    return;
                }
            }
            this.ccZ.adw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.ccY.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.ccZ != null) {
            if (bVar == null) {
                this.ccZ.ao(this.mRootView);
                return;
            }
            h acC = bVar.acC();
            ArrayList<com.baidu.tieba.enterForum.b.g> arrayList = new ArrayList<>();
            if (acC != null) {
                arrayList = acC.acI();
            }
            ap(arrayList);
            if (b(bVar)) {
                this.ccZ.aw(bVar.acD());
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.ccZ.adz();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.b.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.acC() == null || v.u(bVar.acC().acI())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.ccZ.setSearchHint(str.trim());
        } else {
            this.ccZ.setSearchHint(this.baM.getActivity().getString(d.l.enter_forum_search_tip));
        }
    }

    private void ap(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ccZ.av(this.cda.a(list, c.GD()));
        }
    }

    public void Qj() {
        if (this.ccZ != null) {
            eg(false);
        }
    }

    public void onDestroy() {
        Ek();
        com.baidu.tieba.enterForum.model.a.acZ().destroy();
        if (this.ccZ != null) {
            if (this.cda != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cda.ar(this.ccZ.adx());
            }
            this.ccZ.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.ccZ != null) {
            this.ccZ.onChangeSkinType(i);
        }
    }

    public void Ek() {
        if (this.cda != null) {
            this.cda.cancelLoadData();
        }
    }

    public void eg(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cdh && this.cda != null && this.ccZ != null) {
            String str = this.cdd;
            this.cdd = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cdd == null || this.cdd.equals(str)) {
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
                if (this.cda != null && this.cda.adi() != null && this.cda.adi().acC() != null) {
                    Iterator<com.baidu.tieba.enterForum.b.g> it = this.cda.adi().acC().acI().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.b.g next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.iA(1);
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
                    com.baidu.tieba.tbadkCore.util.a.rS(currentAccount);
                }
                this.ccZ.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ek();
                if (z4) {
                    this.cda.ei(StringUtils.isNull(this.cdd) ? false : true);
                } else if (z2) {
                    this.cda.ej(!StringUtils.isNull(this.cdd));
                    this.cda.ei(StringUtils.isNull(this.cdd) ? false : true);
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
        if (this.ccZ != null && this.ccZ.ads() != null) {
            this.ccZ.ads().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<com.baidu.tieba.enterForum.b.g, Integer, String> {
        private com.baidu.tieba.enterForum.b.g cdq;
        private x mNetwork = null;

        public a(com.baidu.tieba.enterForum.b.g gVar) {
            this.cdq = null;
            this.cdq = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.b.g... gVarArr) {
            com.baidu.tieba.enterForum.b.g gVar = this.cdq;
            if (gVar != null) {
                try {
                    if (gVar.getId() != null && gVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", gVar.getId());
                        this.mNetwork.n("kw", gVar.getName());
                        this.mNetwork.uN().vJ().mIsNeedTbs = true;
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
            b.this.ee(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.uN().vK().isRequestSuccess()) {
                    b.this.cdf = true;
                    if (b.this.ccY.isAdded() && b.this.baM != null) {
                        b.this.baM.showToast(b.this.baM.getActivity().getString(d.l.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.e(false, this.cdq.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.cdq.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cdq.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.cdq.getName()));
                    }
                    b.this.ccZ.b(this.cdq);
                } else if (b.this.baM != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.baM.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.ccY.isAdded()) {
                        b.this.baM.showToast(b.this.baM.getActivity().getString(d.l.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.ee(true);
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
                    com.baidu.tieba.im.settingcache.d.azf().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int EI = bVar.EI();
        com.baidu.tbadk.mvc.b.a EJ = bVar.EJ();
        switch (EI) {
            case 1:
                if (EJ instanceof com.baidu.tieba.enterForum.b.g) {
                    String name = ((com.baidu.tieba.enterForum.b.g) EJ).getName();
                    if (am.aL(name)) {
                        this.baM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.baM.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<com.baidu.tieba.enterForum.b.g> adx = this.ccZ.adx();
                        if (!v.u(adx)) {
                            if (v.t(adx) > 1 && adx.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < adx.size()) {
                                    if (!adx.get(i2).getName().equals(name)) {
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
                this.ccZ.iC(EJ instanceof i ? ((i) EJ).getPosition() : 0);
                this.cdf = false;
                if (this.ccY.getView() == null || this.ccY.getView().getParent() == null) {
                    return true;
                }
                this.ccY.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (EJ instanceof com.baidu.tieba.enterForum.b.g) {
                    a((com.baidu.tieba.enterForum.b.g) EJ);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.baM.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.baM.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.baM.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.baM.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ad("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ad("obj_type", "2").r("obj_locate", 1));
                this.baM.finish();
                return true;
            case 9:
                if (this.ccZ != null) {
                    this.ccZ.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void acX() {
        if (this.ccZ != null) {
            this.ccZ.adv();
        }
    }

    public boolean acY() {
        if (this.ccZ != null) {
            return this.ccZ.acY();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EH() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.baM.getUniqueId();
    }

    public void eh(boolean z) {
        int i = 1;
        if (this.ccZ != null && this.ccY != null) {
            boolean z2 = this.ccZ.acY() && this.ccY.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
