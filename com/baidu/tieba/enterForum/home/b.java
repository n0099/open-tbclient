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
    private BaseFragmentActivity aZq;
    private LikeModel bGM;
    private com.baidu.tieba.enterForum.home.a bZi;
    private EnterForumModel bZk;
    private boolean bZl;
    private String bZn;
    private long bZo;
    private boolean bZp;
    private com.baidu.tbadk.core.view.a bZq;
    private boolean bZr;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.b bZj = null;
    private boolean bZm = false;
    private final CustomMessageListener aZr = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.bZj != null) {
                b.this.bZj.startPullRefresh();
            }
        }
    };
    private CustomMessageListener bZs = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !b.this.bZj.acD()) {
                b.this.bZm = true;
                b.this.bZj.en(b.this.bZm);
            }
        }
    };
    private com.baidu.adp.framework.listener.a bZt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.bZk.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.bZj.acy();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.aZq.getResources().getString(d.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.aZq.showToast(errorString);
                    if (b.this.bZj.isEmpty()) {
                        b.this.bZj.ah(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.bZk.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.bZk.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener bZu = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bZr = true;
        }
    };
    private com.baidu.adp.base.d bZv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void g(Object obj) {
            if (AntiHelper.tx(b.this.bGM.getErrorCode())) {
                AntiHelper.ar(b.this.aZq.getPageContext().getPageActivity(), b.this.bGM.getErrorString());
            } else if (obj != null) {
                b.this.bZk.el(!StringUtils.isNull(b.this.bZn));
            } else if (!StringUtils.isNull(b.this.bGM.getErrorString())) {
                k.showToast(TbadkCoreApplication.getInst(), b.this.bGM.getErrorString());
            }
        }
    };
    private final EnterForumModel.b bZw = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.bZi.isAdded()) {
                if (aVar.type == 1) {
                    b.this.bZj.acy();
                }
                if (aVar.bZR) {
                    if (aVar.type == 1) {
                        b.this.bZl = true;
                        new com.baidu.tieba.enterForum.b.b();
                        b.this.a(aVar.bZS);
                    } else if (aVar.type == 0 && !b.this.bZl) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bZS;
                        b.this.bZk.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.bZQ != null && !aVar.bZQ.equals("")) {
                    b.this.aZq.showToast(aVar.bZQ);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.bZo > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.bZo, b.this.bZk.acj() - b.this.bZo, b.this.bZk.ach(), b.this.bZk.aci(), currentTimeMillis - b.this.bZk.acg());
                    b.this.bZo = -1L;
                }
                if (aVar.bZS == null || aVar.bZS.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.aZq.getResources().getString(d.l.enter_forum_search_tip));
                    return;
                }
                f hotSearchInfoData = aVar.bZS.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.abF());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.abG());
                b.this.setSearchHint(hotSearchInfoData.abF());
            }
        }
    };
    private k.b anN = new k.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            b.this.bZk.el(!StringUtils.isNull(b.this.bZn));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter bYx = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        MQ();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.bZk = null;
        this.isFirst = true;
        this.bZl = false;
        this.bZo = -1L;
        this.bZi = aVar;
        this.aZq = aVar.getBaseFragmentActivity();
        this.bYx.addEventDelegate(this);
        this.bZo = System.currentTimeMillis();
        this.isFirst = true;
        this.bZl = false;
        this.bZn = "";
        this.bZk = new EnterForumModel(this.aZq.getPageContext());
        this.bGM = new LikeModel(this.aZq.getPageContext());
        this.bGM.setLoadDataCallBack(this.bZv);
        this.bZk.a(this.bZw);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.acb().n(this.bZi.getFragmentActivity(), com.baidu.adp.lib.util.k.n(this.bZi.getFragmentActivity()));
        initUI();
        initListener();
        abT();
    }

    private void initListener() {
        abV();
        this.bZi.registerListener(this.bZu);
        this.bZi.registerListener(this.bZt);
        this.bZi.registerListener(this.aZr);
        this.bZi.registerListener(this.bZs);
    }

    private static void MQ() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void abT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ai>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ai> run(CustomMessage<ai> customMessage) {
                ai aiVar = new ai();
                ArrayList arrayList = new ArrayList();
                if (b.this.bZk != null && b.this.bZk.ack() != null && b.this.bZk.ack().abB() != null && u.u(b.this.bZk.ack().abB().abI()) > 0) {
                    Iterator<g> it = b.this.bZk.ack().abB().abI().iterator();
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
    public boolean isChanged() {
        return !this.bZk.h(this.bZj.acz(), this.bZj.acA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bZj.acw();
    }

    private void abV() {
        this.bZi.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.abU();
                } else {
                    b.this.abW();
                }
                if (b.this.bZp) {
                    b.this.bZj.startPullRefresh();
                }
            }
        });
        this.bZi.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bZj.acw();
                if (b.this.isChanged()) {
                    if (b.this.bZj.isEmpty()) {
                        b.this.bZj.ah(b.this.mRootView);
                        return;
                    } else {
                        b.this.bZj.acv();
                        b.this.bZk.ar(b.this.bZj.acz());
                    }
                }
                if (b.this.bZp) {
                    b.this.bZj.startPullRefresh();
                }
            }
        });
    }

    public void abW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aZq.getPageContext().getPageActivity());
        aVar.cc(d.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.l.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.abU();
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
        aVar.b(this.aZq.getPageContext());
        aVar.ts();
    }

    public void a(final g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aZq.getPageContext().getPageActivity());
            aVar.cW(String.format(this.aZq.getPageContext().getString(d.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.l.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!com.baidu.adp.lib.util.k.hI()) {
                        b.this.aZq.showToast(d.l.delete_like_fail);
                    } else {
                        new a(gVar).execute(new g[0]);
                    }
                    TiebaStatic.eventStat(b.this.aZq.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.aZq.getPageContext());
            aVar.ts();
        }
    }

    public void eh(boolean z) {
        if (this.bZq == null) {
            abX();
        }
        this.bZq.aH(z);
    }

    private void abX() {
        this.bZq = new com.baidu.tbadk.core.view.a(this.aZq.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aZq.getActivity()).inflate(d.j.enter_forum_view, (ViewGroup) null);
        this.bZj = new com.baidu.tieba.enterForum.c.b(this.bZi, this.mRootView, this.bYx);
        this.bZj.a(this.anN);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ei(boolean z) {
        if (this.bZj != null && this.bZi != null) {
            if (z) {
                if (this.bZi.isPrimary() && this.bZi.isResumed()) {
                    this.bZj.startPullRefresh();
                    return;
                } else {
                    this.bZj.acy();
                    return;
                }
            }
            this.bZj.acy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bZi.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        ArrayList arrayList;
        ArrayList<g> arrayList2;
        boolean z;
        if (this.bZj != null) {
            if (bVar == null) {
                this.bZj.ah(this.mRootView);
                return;
            }
            h abB = bVar.abB();
            com.baidu.tieba.enterForum.b.k abC = bVar.abC();
            ArrayList<g> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            if (abB == null && abC == null) {
                arrayList2 = arrayList3;
                z = true;
                arrayList = arrayList4;
            } else {
                List<j> abK = abC.abK();
                if (abB != null) {
                    arrayList3 = abB.abI();
                }
                if (u.v(arrayList3) && u.v(abK)) {
                    arrayList2 = arrayList3;
                    z = true;
                    arrayList = abK;
                } else {
                    arrayList = abK;
                    arrayList2 = arrayList3;
                    z = false;
                }
            }
            if (z) {
                this.bZj.ah(this.mRootView);
                return;
            }
            g(arrayList2, arrayList);
            if (b(bVar)) {
                this.bZj.av(bVar.abD());
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.bZj.acB();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.b.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.abB() == null || u.v(bVar.abB().abI())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bZj.setSearchHint(str.trim());
        } else {
            this.bZj.setSearchHint(this.aZq.getActivity().getString(d.l.enter_forum_search_tip));
        }
    }

    private void g(List<g> list, List<j> list2) {
        if (list != null && list2 != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bZj.i(this.bZk.a(list, c.GZ()), list2);
        }
    }

    public void Px() {
        if (this.bZj != null) {
            ej(false);
        }
    }

    public void onDestroy() {
        EH();
        com.baidu.tieba.enterForum.model.a.acb().destroy();
        if (this.bZj != null) {
            if (this.bZk != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.bZk.ar(this.bZj.acz());
            }
            this.bZj.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.bZj != null) {
            this.bZj.onChangeSkinType(i);
        }
    }

    public void EH() {
        if (this.bZk != null) {
            this.bZk.cancelLoadData();
        }
    }

    public void ej(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bZr && this.bZk != null && this.bZj != null) {
            String str = this.bZn;
            this.bZn = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bZn == null || this.bZn.equals(str)) {
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
                if (this.bZk != null && this.bZk.ack() != null && this.bZk.ack().abB() != null) {
                    Iterator<g> it = this.bZk.ack().abB().abI().iterator();
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
                    com.baidu.tieba.tbadkCore.util.a.sl(currentAccount);
                }
                this.bZj.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EH();
                if (z4) {
                    this.bZk.el(StringUtils.isNull(this.bZn) ? false : true);
                } else if (z2) {
                    this.bZk.em(!StringUtils.isNull(this.bZn));
                    this.bZk.el(StringUtils.isNull(this.bZn) ? false : true);
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
        if (this.bZj != null && this.bZj.acu() != null) {
            this.bZj.acu().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<g, Integer, String> {
        private g bZB;
        private w mNetwork = null;

        public a(g gVar) {
            this.bZB = null;
            this.bZB = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(g... gVarArr) {
            g gVar = this.bZB;
            if (gVar != null) {
                try {
                    if (gVar.getId() != null && gVar.getName() != null) {
                        this.mNetwork = new w(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", gVar.getId());
                        this.mNetwork.n("kw", gVar.getName());
                        this.mNetwork.vm().wi().mIsNeedTbs = true;
                        this.mNetwork.uP();
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
                if (this.mNetwork.vm().wj().isRequestSuccess()) {
                    b.this.bZp = true;
                    if (b.this.bZi.isAdded() && b.this.aZq != null) {
                        b.this.aZq.showToast(b.this.aZq.getActivity().getString(d.l.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.e(false, this.bZB.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bZB.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.bZB.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.bZB.getName()));
                    }
                    b.this.bZj.b(this.bZB);
                } else if (b.this.aZq != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.aZq.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.bZi.isAdded()) {
                        b.this.aZq.showToast(b.this.aZq.getActivity().getString(d.l.delete_like_fail));
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
    public void e(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.ays().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
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
                    if (al.aP(name)) {
                        this.aZq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aZq.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<g> acz = this.bZj.acz();
                        if (!u.v(acz)) {
                            if (u.u(acz) > 1 && acz.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < acz.size()) {
                                    if (!acz.get(i2).getName().equals(name)) {
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
                this.bZj.ii(Fg instanceof i ? ((i) Fg).getPosition() : 0);
                this.bZp = false;
                if (this.bZi.getView() == null || this.bZi.getView().getParent() == null) {
                    return true;
                }
                this.bZi.getView().getParent().requestDisallowInterceptTouchEvent(true);
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
                    if (al.aP(forumName)) {
                        long forumId = ((j) Fg).getForumId();
                        this.aZq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aZq.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.log(new aj("c10577").g("fid", forumId));
                        return true;
                    }
                    return false;
                }
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aZq.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aZq.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aj("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aZq.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aZq.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aj("c10378").aa("obj_type", "4"));
                return true;
            case 8:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, "推荐"));
                TiebaStatic.log(new aj("c12049").aa("obj_type", "2").r("obj_locate", 1));
                this.aZq.finish();
                return true;
            case 9:
                if (this.bZj != null) {
                    this.bZj.startPullRefresh();
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    public void abY() {
        if (this.bZj != null) {
            this.bZj.acx();
        }
    }

    public boolean abZ() {
        if (this.bZj != null) {
            return this.bZj.abZ();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fe() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aZq.getUniqueId();
    }

    public void ek(boolean z) {
        int i = 1;
        if (this.bZj != null && this.bZi != null) {
            boolean z2 = this.bZj.abZ() && this.bZi.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void aca() {
        if (this.bZj != null) {
            this.bZj.aca();
        }
    }
}
