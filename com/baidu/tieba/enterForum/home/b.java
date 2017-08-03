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
    private BaseFragmentActivity aYd;
    private LikeModel bES;
    private com.baidu.tieba.enterForum.home.a bXp;
    private EnterForumModel bXr;
    private boolean bXs;
    private String bXu;
    private long bXv;
    private boolean bXw;
    private com.baidu.tbadk.core.view.a bXx;
    private boolean bXy;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.b bXq = null;
    private boolean bXt = false;
    private final CustomMessageListener aYe = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.bXq != null) {
                b.this.bXq.startPullRefresh();
            }
        }
    };
    private CustomMessageListener bXz = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !b.this.bXq.ach()) {
                b.this.bXt = true;
                b.this.bXq.em(b.this.bXt);
            }
        }
    };
    private com.baidu.adp.framework.listener.a bXA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.bXr.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.bXq.acc();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.aYd.getResources().getString(d.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.aYd.showToast(errorString);
                    if (b.this.bXq.isEmpty()) {
                        b.this.bXq.ai(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.bXr.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.bXr.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener bXB = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bXy = true;
        }
    };
    private com.baidu.adp.base.d bXC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void g(Object obj) {
            if (AntiHelper.tn(b.this.bES.getErrorCode())) {
                AntiHelper.ar(b.this.aYd.getPageContext().getPageActivity(), b.this.bES.getErrorString());
            } else if (obj != null) {
                b.this.bXr.ek(!StringUtils.isNull(b.this.bXu));
            } else if (!StringUtils.isNull(b.this.bES.getErrorString())) {
                k.showToast(TbadkCoreApplication.getInst(), b.this.bES.getErrorString());
            }
        }
    };
    private final EnterForumModel.b bXD = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.bXp.isAdded()) {
                if (aVar.type == 1) {
                    b.this.bXq.acc();
                }
                if (aVar.bXY) {
                    if (aVar.type == 1) {
                        b.this.bXs = true;
                        new com.baidu.tieba.enterForum.b.b();
                        b.this.a(aVar.bXZ);
                    } else if (aVar.type == 0 && !b.this.bXs) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bXZ;
                        b.this.bXr.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.bXX != null && !aVar.bXX.equals("")) {
                    b.this.aYd.showToast(aVar.bXX);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.bXv > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.bXv, b.this.bXr.abN() - b.this.bXv, b.this.bXr.abL(), b.this.bXr.abM(), currentTimeMillis - b.this.bXr.abK());
                    b.this.bXv = -1L;
                }
                if (aVar.bXZ == null || aVar.bXZ.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.aYd.getResources().getString(d.l.enter_forum_search_tip));
                    return;
                }
                f hotSearchInfoData = aVar.bXZ.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.abi());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.abj());
                b.this.setSearchHint(hotSearchInfoData.abi());
            }
        }
    };
    private k.b amt = new k.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            b.this.bXr.ek(!StringUtils.isNull(b.this.bXu));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter bWE = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        ML();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.bXr = null;
        this.isFirst = true;
        this.bXs = false;
        this.bXv = -1L;
        this.bXp = aVar;
        this.aYd = aVar.getBaseFragmentActivity();
        this.bWE.addEventDelegate(this);
        this.bXv = System.currentTimeMillis();
        this.isFirst = true;
        this.bXs = false;
        this.bXu = "";
        this.bXr = new EnterForumModel(this.aYd.getPageContext());
        this.bES = new LikeModel(this.aYd.getPageContext());
        this.bES.setLoadDataCallBack(this.bXC);
        this.bXr.a(this.bXD);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.abF().n(this.bXp.getFragmentActivity(), com.baidu.adp.lib.util.k.n(this.bXp.getFragmentActivity()));
        initUI();
        initListener();
        abw();
    }

    private void initListener() {
        abz();
        this.bXp.registerListener(this.bXB);
        this.bXp.registerListener(this.bXA);
        this.bXp.registerListener(this.aYe);
        this.bXp.registerListener(this.bXz);
    }

    private static void ML() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void abw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ai>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ai> run(CustomMessage<ai> customMessage) {
                ai aiVar = new ai();
                ArrayList arrayList = new ArrayList();
                if (b.this.bXr != null && b.this.bXr.abO() != null && b.this.bXr.abO().abe() != null && u.u(b.this.bXr.abO().abe().abl()) > 0) {
                    Iterator<g> it = b.this.bXr.abO().abe().abl().iterator();
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
    public boolean abx() {
        return !this.bXr.h(this.bXq.acd(), this.bXq.ace());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aby() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bXq.aca();
    }

    private void abz() {
        this.bXp.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.abx()) {
                    b.this.aby();
                } else {
                    b.this.abA();
                }
                if (b.this.bXw) {
                    b.this.bXq.startPullRefresh();
                }
            }
        });
        this.bXp.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bXq.aca();
                if (b.this.abx()) {
                    if (b.this.bXq.isEmpty()) {
                        b.this.bXq.ai(b.this.mRootView);
                        return;
                    } else {
                        b.this.bXq.abZ();
                        b.this.bXr.ar(b.this.bXq.acd());
                    }
                }
                if (b.this.bXw) {
                    b.this.bXq.startPullRefresh();
                }
            }
        });
    }

    public void abA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aYd.getPageContext().getPageActivity());
        aVar.ca(d.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.l.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.aby();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cb(d.e.cp_cont_b);
        aVar.b(this.aYd.getPageContext());
        aVar.th();
    }

    public void a(final g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aYd.getPageContext().getPageActivity());
            aVar.cN(String.format(this.aYd.getPageContext().getString(d.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.l.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!com.baidu.adp.lib.util.k.hy()) {
                        b.this.aYd.showToast(d.l.delete_like_fail);
                    } else {
                        new a(gVar).execute(new g[0]);
                    }
                    TiebaStatic.eventStat(b.this.aYd.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cb(d.e.cp_cont_b);
            aVar.b(this.aYd.getPageContext());
            aVar.th();
        }
    }

    public void eg(boolean z) {
        if (this.bXx == null) {
            abB();
        }
        this.bXx.aH(z);
    }

    private void abB() {
        this.bXx = new com.baidu.tbadk.core.view.a(this.aYd.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aYd.getActivity()).inflate(d.j.enter_forum_view, (ViewGroup) null);
        this.bXq = new com.baidu.tieba.enterForum.c.b(this.bXp, this.mRootView, this.bWE);
        this.bXq.a(this.amt);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eh(boolean z) {
        if (this.bXq != null && this.bXp != null) {
            if (z) {
                if (this.bXp.isPrimary() && this.bXp.isResumed()) {
                    this.bXq.startPullRefresh();
                    return;
                } else {
                    this.bXq.acc();
                    return;
                }
            }
            this.bXq.acc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bXp.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        ArrayList arrayList;
        ArrayList<g> arrayList2;
        boolean z;
        if (this.bXq != null) {
            if (bVar == null) {
                this.bXq.ai(this.mRootView);
                return;
            }
            h abe = bVar.abe();
            com.baidu.tieba.enterForum.b.k abf = bVar.abf();
            ArrayList<g> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            if (abe == null && abf == null) {
                arrayList2 = arrayList3;
                z = true;
                arrayList = arrayList4;
            } else {
                List<j> abn = abf.abn();
                if (abe != null) {
                    arrayList3 = abe.abl();
                }
                if (u.v(arrayList3) && u.v(abn)) {
                    arrayList2 = arrayList3;
                    z = true;
                    arrayList = abn;
                } else {
                    arrayList = abn;
                    arrayList2 = arrayList3;
                    z = false;
                }
            }
            if (z) {
                this.bXq.ai(this.mRootView);
                return;
            }
            g(arrayList2, arrayList);
            if (b(bVar)) {
                this.bXq.av(bVar.abg());
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.bXq.acf();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.b.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.abe() == null || u.v(bVar.abe().abl())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bXq.setSearchHint(str.trim());
        } else {
            this.bXq.setSearchHint(this.aYd.getActivity().getString(d.l.enter_forum_search_tip));
        }
    }

    private void g(List<g> list, List<j> list2) {
        if (list != null && list2 != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bXq.i(this.bXr.a(list, c.GR()), list2);
        }
    }

    public void Pm() {
        if (this.bXq != null) {
            ei(false);
        }
    }

    public void onDestroy() {
        Ez();
        com.baidu.tieba.enterForum.model.a.abF().destroy();
        if (this.bXq != null) {
            if (this.bXr != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.bXr.ar(this.bXq.acd());
            }
            this.bXq.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.bXq != null) {
            this.bXq.onChangeSkinType(i);
        }
    }

    public void Ez() {
        if (this.bXr != null) {
            this.bXr.cancelLoadData();
        }
    }

    public void ei(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bXy && this.bXr != null && this.bXq != null) {
            String str = this.bXu;
            this.bXu = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bXu == null || this.bXu.equals(str)) {
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
                if (this.bXr != null && this.bXr.abO() != null && this.bXr.abO().abe() != null) {
                    Iterator<g> it = this.bXr.abO().abe().abl().iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.ie(1);
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
                    com.baidu.tieba.tbadkCore.util.a.rZ(currentAccount);
                }
                this.bXq.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ez();
                if (z4) {
                    this.bXr.ek(StringUtils.isNull(this.bXu) ? false : true);
                } else if (z2) {
                    this.bXr.el(!StringUtils.isNull(this.bXu));
                    this.bXr.ek(StringUtils.isNull(this.bXu) ? false : true);
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
        if (this.bXq != null && this.bXq.abY() != null) {
            this.bXq.abY().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<g, Integer, String> {
        private g bXI;
        private w mNetwork = null;

        public a(g gVar) {
            this.bXI = null;
            this.bXI = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(g... gVarArr) {
            g gVar = this.bXI;
            if (gVar != null) {
                try {
                    if (gVar.getId() != null && gVar.getName() != null) {
                        this.mNetwork = new w(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", gVar.getId());
                        this.mNetwork.n("kw", gVar.getName());
                        this.mNetwork.vb().vX().mIsNeedTbs = true;
                        this.mNetwork.uE();
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
                if (this.mNetwork.vb().vY().isRequestSuccess()) {
                    b.this.bXw = true;
                    if (b.this.bXp.isAdded() && b.this.aYd != null) {
                        b.this.aYd.showToast(b.this.aYd.getActivity().getString(d.l.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.d(false, this.bXI.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bXI.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.bXI.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.bXI.getName()));
                    }
                    b.this.bXq.b(this.bXI);
                } else if (b.this.aYd != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.aYd.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.bXp.isAdded()) {
                        b.this.aYd.showToast(b.this.aYd.getActivity().getString(d.l.delete_like_fail));
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
                this.mNetwork.fp();
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
                    com.baidu.tieba.im.settingcache.d.axF().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int EX = bVar.EX();
        com.baidu.tbadk.mvc.b.a EY = bVar.EY();
        switch (EX) {
            case 1:
                if (EY instanceof g) {
                    String name = ((g) EY).getName();
                    if (al.aI(name)) {
                        this.aYd.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aYd.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<g> acd = this.bXq.acd();
                        if (!u.v(acd)) {
                            if (u.u(acd) > 1 && acd.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < acd.size()) {
                                    if (!acd.get(i2).getName().equals(name)) {
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
                this.bXq.ig(EY instanceof i ? ((i) EY).getPosition() : 0);
                this.bXw = false;
                if (this.bXp.getView() == null || this.bXp.getView().getParent() == null) {
                    return true;
                }
                this.bXp.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (EY instanceof g) {
                    a((g) EY);
                    return true;
                }
                return false;
            case 5:
                if (EY instanceof j) {
                    String forumName = ((j) EY).getForumName();
                    if (al.aI(forumName)) {
                        long forumId = ((j) EY).getForumId();
                        this.aYd.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aYd.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.log(new aj("c10577").f("fid", forumId));
                        return true;
                    }
                    return false;
                }
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aYd.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aYd.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aj("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aYd.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aYd.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aj("c10378").aa("obj_type", "4"));
                return true;
            case 8:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, "推荐"));
                TiebaStatic.log(new aj("c12049").aa("obj_type", "2").r("obj_locate", 1));
                this.aYd.finish();
                return true;
            case 9:
                if (this.bXq != null) {
                    this.bXq.startPullRefresh();
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    public void abC() {
        if (this.bXq != null) {
            this.bXq.acb();
        }
    }

    public boolean abD() {
        if (this.bXq != null) {
            return this.bXq.abD();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EW() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aYd.getUniqueId();
    }

    public void ej(boolean z) {
        int i = 1;
        if (this.bXq != null && this.bXp != null) {
            boolean z2 = this.bXq.abD() && this.bXp.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void abE() {
        if (this.bXq != null) {
            this.bXq.abE();
        }
    }
}
