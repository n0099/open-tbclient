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
    private BaseFragmentActivity aZo;
    private LikeModel bGc;
    private String bYA;
    private long bYB;
    private boolean bYC;
    private com.baidu.tbadk.core.view.a bYD;
    private boolean bYE;
    private com.baidu.tieba.enterForum.home.a bYv;
    private EnterForumModel bYx;
    private boolean bYy;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.b bYw = null;
    private boolean bYz = false;
    private final CustomMessageListener aZp = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.bYw != null) {
                b.this.bYw.startPullRefresh();
            }
        }
    };
    private CustomMessageListener bYF = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !b.this.bYw.acm()) {
                b.this.bYz = true;
                b.this.bYw.em(b.this.bYz);
            }
        }
    };
    private com.baidu.adp.framework.listener.a bYG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.bYx.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.bYw.ach();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.aZo.getResources().getString(d.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.aZo.showToast(errorString);
                    if (b.this.bYw.isEmpty()) {
                        b.this.bYw.ai(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.bYx.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.bYx.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener bYH = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bYE = true;
        }
    };
    private com.baidu.adp.base.d bYI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void g(Object obj) {
            if (AntiHelper.tn(b.this.bGc.getErrorCode())) {
                AntiHelper.ar(b.this.aZo.getPageContext().getPageActivity(), b.this.bGc.getErrorString());
            } else if (obj != null) {
                b.this.bYx.ek(!StringUtils.isNull(b.this.bYA));
            } else if (!StringUtils.isNull(b.this.bGc.getErrorString())) {
                k.showToast(TbadkCoreApplication.getInst(), b.this.bGc.getErrorString());
            }
        }
    };
    private final EnterForumModel.b bYJ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.bYv.isAdded()) {
                if (aVar.type == 1) {
                    b.this.bYw.ach();
                }
                if (aVar.bZe) {
                    if (aVar.type == 1) {
                        b.this.bYy = true;
                        new com.baidu.tieba.enterForum.b.b();
                        b.this.a(aVar.bZf);
                    } else if (aVar.type == 0 && !b.this.bYy) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bZf;
                        b.this.bYx.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.bZd != null && !aVar.bZd.equals("")) {
                    b.this.aZo.showToast(aVar.bZd);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.bYB > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.bYB, b.this.bYx.abS() - b.this.bYB, b.this.bYx.abQ(), b.this.bYx.abR(), currentTimeMillis - b.this.bYx.abP());
                    b.this.bYB = -1L;
                }
                if (aVar.bZf == null || aVar.bZf.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.aZo.getResources().getString(d.l.enter_forum_search_tip));
                    return;
                }
                f hotSearchInfoData = aVar.bZf.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.abn());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.abo());
                b.this.setSearchHint(hotSearchInfoData.abn());
            }
        }
    };
    private k.b anM = new k.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            b.this.bYx.ek(!StringUtils.isNull(b.this.bYA));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter bXK = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        MQ();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.bYx = null;
        this.isFirst = true;
        this.bYy = false;
        this.bYB = -1L;
        this.bYv = aVar;
        this.aZo = aVar.getBaseFragmentActivity();
        this.bXK.addEventDelegate(this);
        this.bYB = System.currentTimeMillis();
        this.isFirst = true;
        this.bYy = false;
        this.bYA = "";
        this.bYx = new EnterForumModel(this.aZo.getPageContext());
        this.bGc = new LikeModel(this.aZo.getPageContext());
        this.bGc.setLoadDataCallBack(this.bYI);
        this.bYx.a(this.bYJ);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.abK().n(this.bYv.getFragmentActivity(), com.baidu.adp.lib.util.k.n(this.bYv.getFragmentActivity()));
        initUI();
        initListener();
        abB();
    }

    private void initListener() {
        abE();
        this.bYv.registerListener(this.bYH);
        this.bYv.registerListener(this.bYG);
        this.bYv.registerListener(this.aZp);
        this.bYv.registerListener(this.bYF);
    }

    private static void MQ() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void abB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ai>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ai> run(CustomMessage<ai> customMessage) {
                ai aiVar = new ai();
                ArrayList arrayList = new ArrayList();
                if (b.this.bYx != null && b.this.bYx.abT() != null && b.this.bYx.abT().abj() != null && u.u(b.this.bYx.abT().abj().abq()) > 0) {
                    Iterator<g> it = b.this.bYx.abT().abj().abq().iterator();
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
    public boolean abC() {
        return !this.bYx.h(this.bYw.aci(), this.bYw.acj());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bYw.acf();
    }

    private void abE() {
        this.bYv.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.abC()) {
                    b.this.abD();
                } else {
                    b.this.abF();
                }
                if (b.this.bYC) {
                    b.this.bYw.startPullRefresh();
                }
            }
        });
        this.bYv.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bYw.acf();
                if (b.this.abC()) {
                    if (b.this.bYw.isEmpty()) {
                        b.this.bYw.ai(b.this.mRootView);
                        return;
                    } else {
                        b.this.bYw.ace();
                        b.this.bYx.ar(b.this.bYw.aci());
                    }
                }
                if (b.this.bYC) {
                    b.this.bYw.startPullRefresh();
                }
            }
        });
    }

    public void abF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aZo.getPageContext().getPageActivity());
        aVar.cc(d.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.l.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.abD();
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
        aVar.b(this.aZo.getPageContext());
        aVar.tr();
    }

    public void a(final g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aZo.getPageContext().getPageActivity());
            aVar.cT(String.format(this.aZo.getPageContext().getString(d.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.l.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!com.baidu.adp.lib.util.k.hI()) {
                        b.this.aZo.showToast(d.l.delete_like_fail);
                    } else {
                        new a(gVar).execute(new g[0]);
                    }
                    TiebaStatic.eventStat(b.this.aZo.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.aZo.getPageContext());
            aVar.tr();
        }
    }

    public void eg(boolean z) {
        if (this.bYD == null) {
            abG();
        }
        this.bYD.aH(z);
    }

    private void abG() {
        this.bYD = new com.baidu.tbadk.core.view.a(this.aZo.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aZo.getActivity()).inflate(d.j.enter_forum_view, (ViewGroup) null);
        this.bYw = new com.baidu.tieba.enterForum.c.b(this.bYv, this.mRootView, this.bXK);
        this.bYw.a(this.anM);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eh(boolean z) {
        if (this.bYw != null && this.bYv != null) {
            if (z) {
                if (this.bYv.isPrimary() && this.bYv.isResumed()) {
                    this.bYw.startPullRefresh();
                    return;
                } else {
                    this.bYw.ach();
                    return;
                }
            }
            this.bYw.ach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bYv.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        ArrayList arrayList;
        ArrayList<g> arrayList2;
        boolean z;
        if (this.bYw != null) {
            if (bVar == null) {
                this.bYw.ai(this.mRootView);
                return;
            }
            h abj = bVar.abj();
            com.baidu.tieba.enterForum.b.k abk = bVar.abk();
            ArrayList<g> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            if (abj == null && abk == null) {
                arrayList2 = arrayList3;
                z = true;
                arrayList = arrayList4;
            } else {
                List<j> abs = abk.abs();
                if (abj != null) {
                    arrayList3 = abj.abq();
                }
                if (u.v(arrayList3) && u.v(abs)) {
                    arrayList2 = arrayList3;
                    z = true;
                    arrayList = abs;
                } else {
                    arrayList = abs;
                    arrayList2 = arrayList3;
                    z = false;
                }
            }
            if (z) {
                this.bYw.ai(this.mRootView);
                return;
            }
            g(arrayList2, arrayList);
            if (b(bVar)) {
                this.bYw.av(bVar.abl());
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.bYw.ack();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.b.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.abj() == null || u.v(bVar.abj().abq())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bYw.setSearchHint(str.trim());
        } else {
            this.bYw.setSearchHint(this.aZo.getActivity().getString(d.l.enter_forum_search_tip));
        }
    }

    private void g(List<g> list, List<j> list2) {
        if (list != null && list2 != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bYw.i(this.bYx.a(list, c.GZ()), list2);
        }
    }

    public void Pr() {
        if (this.bYw != null) {
            ei(false);
        }
    }

    public void onDestroy() {
        EH();
        com.baidu.tieba.enterForum.model.a.abK().destroy();
        if (this.bYw != null) {
            if (this.bYx != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.bYx.ar(this.bYw.aci());
            }
            this.bYw.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.bYw != null) {
            this.bYw.onChangeSkinType(i);
        }
    }

    public void EH() {
        if (this.bYx != null) {
            this.bYx.cancelLoadData();
        }
    }

    public void ei(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bYE && this.bYx != null && this.bYw != null) {
            String str = this.bYA;
            this.bYA = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bYA == null || this.bYA.equals(str)) {
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
                if (this.bYx != null && this.bYx.abT() != null && this.bYx.abT().abj() != null) {
                    Iterator<g> it = this.bYx.abT().abj().abq().iterator();
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
                    com.baidu.tieba.tbadkCore.util.a.se(currentAccount);
                }
                this.bYw.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EH();
                if (z4) {
                    this.bYx.ek(StringUtils.isNull(this.bYA) ? false : true);
                } else if (z2) {
                    this.bYx.el(!StringUtils.isNull(this.bYA));
                    this.bYx.ek(StringUtils.isNull(this.bYA) ? false : true);
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
        if (this.bYw != null && this.bYw.acd() != null) {
            this.bYw.acd().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<g, Integer, String> {
        private g bYO;
        private w mNetwork = null;

        public a(g gVar) {
            this.bYO = null;
            this.bYO = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(g... gVarArr) {
            g gVar = this.bYO;
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
            b.this.eg(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.vl().wi().isRequestSuccess()) {
                    b.this.bYC = true;
                    if (b.this.bYv.isAdded() && b.this.aZo != null) {
                        b.this.aZo.showToast(b.this.aZo.getActivity().getString(d.l.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.d(false, this.bYO.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bYO.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.bYO.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.bYO.getName()));
                    }
                    b.this.bYw.b(this.bYO);
                } else if (b.this.aZo != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.aZo.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.bYv.isAdded()) {
                        b.this.aZo.showToast(b.this.aZo.getActivity().getString(d.l.delete_like_fail));
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
                    com.baidu.tieba.im.settingcache.d.axQ().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
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
                        this.aZo.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aZo.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<g> aci = this.bYw.aci();
                        if (!u.v(aci)) {
                            if (u.u(aci) > 1 && aci.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < aci.size()) {
                                    if (!aci.get(i2).getName().equals(name)) {
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
                this.bYw.ig(Fg instanceof i ? ((i) Fg).getPosition() : 0);
                this.bYC = false;
                if (this.bYv.getView() == null || this.bYv.getView().getParent() == null) {
                    return true;
                }
                this.bYv.getView().getParent().requestDisallowInterceptTouchEvent(true);
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
                        this.aZo.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aZo.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.log(new aj("c10577").g("fid", forumId));
                        return true;
                    }
                    return false;
                }
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aZo.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aZo.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aj("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aZo.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aZo.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new aj("c10378").aa("obj_type", "4"));
                return true;
            case 8:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, "推荐"));
                TiebaStatic.log(new aj("c12049").aa("obj_type", "2").r("obj_locate", 1));
                this.aZo.finish();
                return true;
            case 9:
                if (this.bYw != null) {
                    this.bYw.startPullRefresh();
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    public void abH() {
        if (this.bYw != null) {
            this.bYw.acg();
        }
    }

    public boolean abI() {
        if (this.bYw != null) {
            return this.bYw.abI();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fe() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aZo.getUniqueId();
    }

    public void ej(boolean z) {
        int i = 1;
        if (this.bYw != null && this.bYv != null) {
            boolean z2 = this.bYw.abI() && this.bYv.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void abJ() {
        if (this.bYw != null) {
            this.bYw.abJ();
        }
    }
}
