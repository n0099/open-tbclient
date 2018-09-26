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
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
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
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel aCp;
    private BaseFragmentActivity bui;
    private String cYA;
    private long cYB;
    private boolean cYC;
    private boolean cYE;
    private EnterForumFragment cYu;
    private EnterForumModel cYw;
    private RecentlyVisitedForumModel cYx;
    private boolean cYy;
    private boolean isFirst;
    private View mRootView;
    private d mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a cYv = null;
    private boolean cYz = false;
    private int cYD = 1;
    private CustomMessageListener cYF = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cYz = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a cYG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.cYw.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.cYv.pb();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bui.getResources().getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bui.showToast(errorString);
                    if (a.this.cYv.isEmpty()) {
                        a.this.cYv.aH(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.cYw.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.cYw.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener cYH = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cYE = true;
        }
    };
    private com.baidu.adp.base.d cYI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void j(Object obj) {
            if (AntiHelper.am(a.this.aCp.getErrorCode(), a.this.aCp.getErrorString())) {
                AntiHelper.aG(a.this.bui.getPageContext().getPageActivity(), a.this.aCp.getErrorString());
            } else if (obj != null) {
                a.this.cYw.fy(!StringUtils.isNull(a.this.cYA));
            } else if (!StringUtils.isNull(a.this.aCp.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.aCp.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cYJ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.cYu.isAdded()) {
                if (aVar.type == 1) {
                    a.this.cYv.pb();
                }
                if (aVar.cZq) {
                    if (aVar.type == 1) {
                        a.this.cYy = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.cZr);
                    } else if (aVar.type == 0 && !a.this.cYy) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.cZr;
                        a.this.cYw.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.bui.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.cYB > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.cYB, a.this.cYw.aqU() - a.this.cYB, a.this.cYw.aqS(), a.this.cYw.aqT(), currentTimeMillis - a.this.cYw.aqR());
                    a.this.cYB = -1L;
                }
                if (aVar.cZr == null || aVar.cZr.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.bui.getResources().getString(e.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.cZr.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.aqk() != null) {
                    a.this.setSearchHint(hotSearchInfoData.aqk());
                }
            }
        }
    };
    private j.b azG = new j.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void bf(boolean z) {
            a.this.cYw.fy(!StringUtils.isNull(a.this.cYA));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cXw = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Vb();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.cYw = null;
        this.isFirst = true;
        this.cYy = false;
        this.cYB = -1L;
        this.cYu = enterForumFragment;
        this.bui = enterForumFragment.getBaseFragmentActivity();
        this.cXw.addEventDelegate(this);
        this.cYB = System.currentTimeMillis();
        this.isFirst = true;
        this.cYy = false;
        this.cYA = "";
        this.cYw = new EnterForumModel(this.bui.getPageContext());
        this.cYx = new RecentlyVisitedForumModel();
        this.aCp = new LikeModel(this.bui.getPageContext());
        this.aCp.setLoadDataCallBack(this.cYI);
        this.cYw.a(this.cYJ);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aqN().n(this.cYu.getFragmentActivity(), l.r(this.cYu.getFragmentActivity()));
        initUI();
        initListener();
        aqB();
    }

    private void initListener() {
        aqE();
        this.cYu.registerListener(this.cYH);
        this.cYu.registerListener(this.cYG);
        this.cYu.registerListener(this.cYF);
    }

    private static void Vb() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aqB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016550, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (a.this.cYw != null && a.this.cYw.aqV() != null && a.this.cYw.aqV().aqh() != null && v.y(a.this.cYw.aqV().aqh().aqn()) > 0) {
                    Iterator<f> it = a.this.cYw.aqV().aqh().aqn().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.d(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    acVar.t(arrayList);
                }
                return new CustomResponsedMessage<>(2016550, acVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.cYw.i(this.cYv.arh(), this.cYv.ari());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqC() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.cYv.arf();
    }

    public View aqD() {
        return this.cYv.aqD();
    }

    public void aF(View view) {
        this.cYv.aF(view);
    }

    private void aqE() {
        this.cYu.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cYv == null || !a.this.cYv.aqe()) {
                    if (!a.this.isChanged()) {
                        a.this.aqC();
                    } else {
                        a.this.aqF();
                    }
                    if (a.this.cYC) {
                        a.this.cYv.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.cYu.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cYv.arf();
                if (a.this.isChanged()) {
                    if (a.this.cYv.isEmpty()) {
                        a.this.cYv.aH(a.this.mRootView);
                        return;
                    } else {
                        a.this.cYv.are();
                        a.this.cYw.aS(a.this.cYv.arh());
                    }
                }
                if (a.this.cYC) {
                    a.this.cYv.startPullRefresh();
                }
            }
        });
    }

    public void aqF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bui.getPageContext().getPageActivity());
        aVar.cp(e.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(e.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.aqC();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cq(e.d.cp_cont_b);
        aVar.b(this.bui.getPageContext());
        aVar.yl();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bui.getPageContext().getPageActivity());
            aVar.dT(String.format(this.bui.getPageContext().getString(e.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(e.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.lb()) {
                        a.this.bui.showToast(e.j.delete_like_fail);
                    } else {
                        new C0143a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.bui.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cq(e.d.cp_cont_b);
            aVar.b(this.bui.getPageContext());
            aVar.yl();
        }
    }

    public void fu(boolean z) {
        if (this.mWaitingDialog == null) {
            aqG();
        }
        this.mWaitingDialog.aZ(z);
    }

    private void aqG() {
        this.mWaitingDialog = new d(this.bui.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bui.getActivity()).inflate(e.h.enter_forum_view, (ViewGroup) null);
        this.cYv = new com.baidu.tieba.enterForum.view.a(this.cYu, this.mRootView, this.cXw, this.cYx);
        this.cYv.a(this.azG);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fv(boolean z) {
        if (this.cYv != null && this.cYu != null) {
            if (z) {
                if (this.cYu.isPrimary() && this.cYu.isResumed()) {
                    this.cYv.startPullRefresh();
                    return;
                } else {
                    this.cYv.pb();
                    return;
                }
            }
            this.cYv.pb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cYu.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.cYv != null) {
            if (bVar == null) {
                this.cYv.aH(this.mRootView);
                return;
            }
            g aqh = bVar.aqh();
            ArrayList<f> arrayList = new ArrayList<>();
            if (aqh != null) {
                arrayList = aqh.aqn();
            }
            aQ(arrayList);
            if (b(bVar)) {
                this.cYv.aX(bVar.aqi());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aqk() != null) {
                setSearchHint(hotSearchInfoData.aqk());
            }
            this.cYv.arj();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.aqh() == null || v.z(bVar.aqh().aqn())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.cYv.setSearchHint(str.trim());
        } else {
            this.cYv.setSearchHint(this.bui.getActivity().getString(e.j.enter_forum_search_tip));
        }
    }

    private void aQ(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.cYv.aW(this.cYw.a(list, com.baidu.tbadk.util.d.Mz()));
        }
    }

    public void loadData() {
        if (this.cYv != null) {
            fw(false);
        }
    }

    public void onDestroy() {
        Kq();
        com.baidu.tieba.enterForum.model.a.aqN().destroy();
        if (this.cYv != null) {
            if (this.cYw != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cYw.aS(this.cYv.arh());
            }
            this.cYv.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016550);
        if (this.cYx != null) {
            this.cYx.onDestroy();
        }
        if (this.cXw != null) {
            this.cXw.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cYv != null) {
            this.cYv.onChangeSkinType(i);
        }
    }

    public void Kq() {
        if (this.cYw != null) {
            this.cYw.cancelLoadData();
        }
    }

    public void fw(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cYE && this.cYw != null && this.cYv != null) {
            String str = this.cYA;
            this.cYA = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cYA == null || this.cYA.equals(str)) {
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
                if (this.cYw != null && this.cYw.aqV() != null && this.cYw.aqV().aqh() != null) {
                    Iterator<f> it = this.cYw.aqV().aqh().aqn().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.kg(1);
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
                    com.baidu.tieba.tbadkCore.util.a.uC(currentAccount);
                }
                this.cYv.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Kq();
                if (z4) {
                    this.cYw.fy(StringUtils.isNull(this.cYA) ? false : true);
                } else if (z2) {
                    this.cYw.fz(!StringUtils.isNull(this.cYA));
                    this.cYw.fy(StringUtils.isNull(this.cYA) ? false : true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    public void onPrimary() {
        if (this.cYx != null) {
            this.cYx.onPrimary();
        }
    }

    public void onPause() {
        if (this.cYv != null && this.cYv.ard() != null) {
            this.cYv.ard().completePullRefresh();
        }
        if (this.cYx != null) {
            this.cYx.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0143a extends BdAsyncTask<f, Integer, String> {
        private f cYO;
        private x mNetwork = null;

        public C0143a(f fVar) {
            this.cYO = null;
            this.cYO = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.cYO;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.u(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.u("kw", fVar.getName());
                        this.mNetwork.zR().AP().mIsNeedTbs = true;
                        this.mNetwork.zt();
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
            super.onPostExecute((C0143a) str);
            a.this.fu(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                    a.this.cYC = true;
                    if (a.this.cYu.isAdded() && a.this.bui != null) {
                        a.this.bui.showToast(a.this.bui.getActivity().getString(e.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.h(false, this.cYO.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.cYO.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.cYO.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.cYO.getName()));
                    }
                    a.this.cYv.b(this.cYO);
                } else if (a.this.bui != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.bui.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.cYu.isAdded()) {
                        a.this.bui.showToast(a.this.bui.getActivity().getString(e.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.fu(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.iT();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aPH().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int KS = bVar.KS();
        com.baidu.tbadk.mvc.b.a KT = bVar.KT();
        switch (KS) {
            case 1:
                if (this.cYD != 2 && (KT instanceof f)) {
                    String name = ((f) KT).getName();
                    if (ao.bw(name)) {
                        this.bui.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bui.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.bui.getResources().getString(e.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        List<f> arh = this.cYv.arh();
                        if (!v.z(arh)) {
                            if (v.y(arh) > 1 && arh.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < arh.size()) {
                                    if (!arh.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new am("c12049").al("obj_type", "2").w("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.cYD == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.cYv.kj(KT instanceof h ? ((h) KT).getPosition() : 0);
                this.cYC = false;
                if (this.cYu.getView() == null || this.cYu.getView().getParent() == null) {
                    return true;
                }
                this.cYu.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (KT instanceof f) {
                    a((f) KT);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bui.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bui.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.bui.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bui.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("c10378").al("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").al("obj_type", "2").w("obj_locate", 1));
                this.bui.finish();
                return true;
            case 9:
                if (this.cYv != null) {
                    this.cYv.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.cYD = 2;
                return true;
            case 11:
                this.cYD = 1;
                return true;
        }
    }

    public void aqH() {
        if (this.cYv != null) {
            this.cYv.arg();
        }
    }

    public boolean aqI() {
        if (this.cYv != null) {
            return this.cYv.aqI();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean KR() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bui.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cYv != null) {
            this.cYv.setPageUniqueId(bdUniqueId);
        }
    }

    public void fx(boolean z) {
        int i = 0;
        if (this.cYv != null && this.cYu != null) {
            boolean z2 = this.cYv.aqI() && this.cYu.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.cYv.aqe()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
