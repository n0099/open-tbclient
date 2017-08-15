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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.f;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.b.h;
import com.baidu.tieba.enterForum.b.i;
import com.baidu.tieba.enterForum.b.j;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity aZp;
    private LikeModel bGL;
    private com.baidu.tieba.enterForum.home.a bZh;
    private EnterForumModel bZj;
    private boolean bZk;
    private String bZm;
    private long bZn;
    private boolean bZo;
    private com.baidu.tbadk.core.view.a bZp;
    private boolean bZq;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.b bZi = null;
    private boolean bZl = false;
    private final CustomMessageListener aZq = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.bZi != null) {
                b.this.bZi.startPullRefresh();
            }
        }
    };
    private CustomMessageListener bZr = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !b.this.bZi.acH()) {
                b.this.bZl = true;
                b.this.bZi.en(b.this.bZl);
            }
        }
    };
    private com.baidu.adp.framework.listener.a bZs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.bZj.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.bZi.acC();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.aZp.getResources().getString(d.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.aZp.showToast(errorString);
                    if (b.this.bZi.isEmpty()) {
                        b.this.bZi.ai(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.bZj.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.bZj.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener bZt = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bZq = true;
        }
    };
    private com.baidu.adp.base.d bZu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void g(Object obj) {
            if (AntiHelper.tx(b.this.bGL.getErrorCode())) {
                AntiHelper.ar(b.this.aZp.getPageContext().getPageActivity(), b.this.bGL.getErrorString());
            } else if (obj != null) {
                b.this.bZj.el(!StringUtils.isNull(b.this.bZm));
            } else if (!StringUtils.isNull(b.this.bGL.getErrorString())) {
                k.showToast(TbadkCoreApplication.getInst(), b.this.bGL.getErrorString());
            }
        }
    };
    private final EnterForumModel.b bZv = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.bZh.isAdded()) {
                if (aVar.type == 1) {
                    b.this.bZi.acC();
                }
                if (aVar.bZQ) {
                    if (aVar.type == 1) {
                        b.this.bZk = true;
                        new com.baidu.tieba.enterForum.b.b();
                        b.this.a(aVar.bZR);
                    } else if (aVar.type == 0 && !b.this.bZk) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bZR;
                        b.this.bZj.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.bZP != null && !aVar.bZP.equals("")) {
                    b.this.aZp.showToast(aVar.bZP);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.bZn > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.bZn, b.this.bZj.acn() - b.this.bZn, b.this.bZj.acl(), b.this.bZj.acm(), currentTimeMillis - b.this.bZj.ack());
                    b.this.bZn = -1L;
                }
                if (aVar.bZR == null || aVar.bZR.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.aZp.getResources().getString(d.l.enter_forum_search_tip));
                    return;
                }
                f hotSearchInfoData = aVar.bZR.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.abI());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.abJ());
                b.this.setSearchHint(hotSearchInfoData.abI());
            }
        }
    };
    private k.b anN = new k.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            b.this.bZj.el(!StringUtils.isNull(b.this.bZm));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter bYw = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        MQ();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.bZj = null;
        this.isFirst = true;
        this.bZk = false;
        this.bZn = -1L;
        this.bZh = aVar;
        this.aZp = aVar.getBaseFragmentActivity();
        this.bYw.addEventDelegate(this);
        this.bZn = System.currentTimeMillis();
        this.isFirst = true;
        this.bZk = false;
        this.bZm = "";
        this.bZj = new EnterForumModel(this.aZp.getPageContext());
        this.bGL = new LikeModel(this.aZp.getPageContext());
        this.bGL.setLoadDataCallBack(this.bZu);
        this.bZj.a(this.bZv);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.acf().n(this.bZh.getFragmentActivity(), com.baidu.adp.lib.util.k.n(this.bZh.getFragmentActivity()));
        initUI();
        initListener();
        abW();
    }

    private void initListener() {
        abZ();
        this.bZh.registerListener(this.bZt);
        this.bZh.registerListener(this.bZs);
        this.bZh.registerListener(this.aZq);
        this.bZh.registerListener(this.bZr);
    }

    private static void MQ() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void abW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ai>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ai> run(CustomMessage<ai> customMessage) {
                ai aiVar = new ai();
                ArrayList arrayList = new ArrayList();
                if (b.this.bZj != null && b.this.bZj.aco() != null && b.this.bZj.aco().abE() != null && u.u(b.this.bZj.aco().abE().abL()) > 0) {
                    Iterator<g> it = b.this.bZj.aco().abE().abL().iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.d(next.getId(), 0L));
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
    public boolean abX() {
        return !this.bZj.h(this.bZi.acD(), this.bZi.acE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abY() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bZi.acA();
    }

    private void abZ() {
        this.bZh.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.abX()) {
                    b.this.abY();
                } else {
                    b.this.aca();
                }
                if (b.this.bZo) {
                    b.this.bZi.startPullRefresh();
                }
            }
        });
        this.bZh.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bZi.acA();
                if (b.this.abX()) {
                    if (b.this.bZi.isEmpty()) {
                        b.this.bZi.ai(b.this.mRootView);
                        return;
                    } else {
                        b.this.bZi.acz();
                        b.this.bZj.ar(b.this.bZi.acD());
                    }
                }
                if (b.this.bZo) {
                    b.this.bZi.startPullRefresh();
                }
            }
        });
    }

    public void aca() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aZp.getPageContext().getPageActivity());
        aVar.cc(d.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.l.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.abY();
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
        aVar.b(this.aZp.getPageContext());
        aVar.tr();
    }

    public void a(final g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aZp.getPageContext().getPageActivity());
            aVar.cT(String.format(this.aZp.getPageContext().getString(d.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.l.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!com.baidu.adp.lib.util.k.hI()) {
                        b.this.aZp.showToast(d.l.delete_like_fail);
                    } else {
                        new a(gVar).execute(new g[0]);
                    }
                    TiebaStatic.eventStat(b.this.aZp.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.aZp.getPageContext());
            aVar.tr();
        }
    }

    public void eh(boolean z) {
        if (this.bZp == null) {
            acb();
        }
        this.bZp.aH(z);
    }

    private void acb() {
        this.bZp = new com.baidu.tbadk.core.view.a(this.aZp.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aZp.getActivity()).inflate(d.j.enter_forum_view, (ViewGroup) null);
        this.bZi = new com.baidu.tieba.enterForum.c.b(this.bZh, this.mRootView, this.bYw);
        this.bZi.a(this.anN);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ei(boolean z) {
        if (this.bZi != null && this.bZh != null) {
            if (z) {
                if (this.bZh.isPrimary() && this.bZh.isResumed()) {
                    this.bZi.startPullRefresh();
                    return;
                } else {
                    this.bZi.acC();
                    return;
                }
            }
            this.bZi.acC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bZh.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        ArrayList arrayList;
        ArrayList<g> arrayList2;
        boolean z;
        if (this.bZi != null) {
            if (bVar == null) {
                this.bZi.ai(this.mRootView);
                return;
            }
            h abE = bVar.abE();
            com.baidu.tieba.enterForum.b.k abF = bVar.abF();
            ArrayList<g> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            if (abE == null && abF == null) {
                arrayList2 = arrayList3;
                z = true;
                arrayList = arrayList4;
            } else {
                List<j> abN = abF.abN();
                if (abE != null) {
                    arrayList3 = abE.abL();
                }
                if (u.v(arrayList3) && u.v(abN)) {
                    arrayList2 = arrayList3;
                    z = true;
                    arrayList = abN;
                } else {
                    arrayList = abN;
                    arrayList2 = arrayList3;
                    z = false;
                }
            }
            if (z) {
                this.bZi.ai(this.mRootView);
                return;
            }
            g(arrayList2, arrayList);
            if (b(bVar)) {
                this.bZi.av(bVar.abG());
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.bZi.acF();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.b.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.abE() == null || u.v(bVar.abE().abL())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bZi.setSearchHint(str.trim());
        } else {
            this.bZi.setSearchHint(this.aZp.getActivity().getString(d.l.enter_forum_search_tip));
        }
    }

    private void g(List<g> list, List<j> list2) {
        if (list != null && list2 != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bZi.i(this.bZj.a(list, c.GZ()), list2);
        }
    }

    public void Py() {
        if (this.bZi != null) {
            ej(false);
        }
    }

    public void onDestroy() {
        EH();
        com.baidu.tieba.enterForum.model.a.acf().destroy();
        if (this.bZi != null) {
            if (this.bZj != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.bZj.ar(this.bZi.acD());
            }
            this.bZi.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.bZi != null) {
            this.bZi.onChangeSkinType(i);
        }
    }

    public void EH() {
        if (this.bZj != null) {
            this.bZj.cancelLoadData();
        }
    }

    public void ej(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bZq && this.bZj != null && this.bZi != null) {
            String str = this.bZm;
            this.bZm = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bZm == null || this.bZm.equals(str)) {
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
                if (this.bZj != null && this.bZj.aco() != null && this.bZj.aco().abE() != null) {
                    Iterator<g> it = this.bZj.aco().abE().abL().iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.ig(1);
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
                this.bZi.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EH();
                if (z4) {
                    this.bZj.el(StringUtils.isNull(this.bZm) ? false : true);
                } else if (z2) {
                    this.bZj.em(!StringUtils.isNull(this.bZm));
                    this.bZj.el(StringUtils.isNull(this.bZm) ? false : true);
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
        if (this.bZi != null && this.bZi.acy() != null) {
            this.bZi.acy().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<g, Integer, String> {
        private g bZA;
        private w mNetwork = null;

        public a(g gVar) {
            this.bZA = null;
            this.bZA = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(g... gVarArr) {
            g gVar = this.bZA;
            if (gVar != null) {
                try {
                    if (gVar.getId() != null && gVar.getName() != null) {
                        this.mNetwork = new w(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", gVar.getId());
                        this.mNetwork.n("kw", gVar.getName());
                        this.mNetwork.vl().wh().mIsNeedTbs = true;
                        this.mNetwork.uO();
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
            b.this.eh(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.vl().wi().isRequestSuccess()) {
                    b.this.bZo = true;
                    if (b.this.bZh.isAdded() && b.this.aZp != null) {
                        b.this.aZp.showToast(b.this.aZp.getActivity().getString(d.l.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.d(false, this.bZA.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bZA.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.bZA.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.bZA.getName()));
                    }
                    b.this.bZi.b(this.bZA);
                } else if (b.this.aZp != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.aZp.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.bZh.isAdded()) {
                        b.this.aZp.showToast(b.this.aZp.getActivity().getString(d.l.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.eh(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.ayx().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Ff = bVar.Ff();
        com.baidu.tbadk.mvc.b.a Fg = bVar.Fg();
        switch (Ff) {
            case 1:
                if (Fg instanceof g) {
                    String name = ((g) Fg).getName();
                    if (al.aO(name)) {
                        this.aZp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aZp.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<g> acD = this.bZi.acD();
                        if (!u.v(acD)) {
                            if (u.u(acD) > 1 && acD.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < acD.size()) {
                                    if (!acD.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new aj("c12049").aa("obj_type", "2").r("obj_locate", i));
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
                this.bZi.ii(Fg instanceof i ? ((i) Fg).getPosition() : 0);
                this.bZo = false;
                if (this.bZh.getView() == null || this.bZh.getView().getParent() == null) {
                    return true;
                }
                this.bZh.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Fg instanceof g) {
                    a((g) Fg);
                    return true;
                }
                return false;
            case 5:
                if (Fg instanceof j) {
                    String forumName = ((j) Fg).getForumName();
                    if (al.aO(forumName)) {
                        long forumId = ((j) Fg).getForumId();
                        this.aZp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aZp.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.log(new aj("c10577").g("fid", forumId));
                        return true;
                    }
                    return false;
                }
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aZp.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aZp.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aj("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aZp.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aZp.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aj("c10378").aa("obj_type", "4"));
                return true;
            case 8:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, "推荐"));
                TiebaStatic.log(new aj("c12049").aa("obj_type", "2").r("obj_locate", 1));
                this.aZp.finish();
                return true;
            case 9:
                if (this.bZi != null) {
                    this.bZi.startPullRefresh();
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    public void acc() {
        if (this.bZi != null) {
            this.bZi.acB();
        }
    }

    public boolean acd() {
        if (this.bZi != null) {
            return this.bZi.acd();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fe() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aZp.getUniqueId();
    }

    public void ek(boolean z) {
        int i = 1;
        if (this.bZi != null && this.bZh != null) {
            boolean z2 = this.bZi.acd() && this.bZh.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void ace() {
        if (this.bZi != null) {
            this.bZi.ace();
        }
    }
}
