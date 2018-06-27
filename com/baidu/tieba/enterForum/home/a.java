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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
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
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity bnK;
    private LikeModel bwM;
    private EnterForumFragment cPU;
    private EnterForumModel cPW;
    private RecentlyVisitedForumModel cPX;
    private boolean cPY;
    private String cQa;
    private long cQb;
    private boolean cQc;
    private boolean cQe;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a cPV = null;
    private boolean cPZ = false;
    private int cQd = 1;
    private CustomMessageListener cQf = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cPZ = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a cQg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.cPW.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.cPV.nW();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bnK.getResources().getString(d.k.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bnK.showToast(errorString);
                    if (a.this.cPV.isEmpty()) {
                        a.this.cPV.aq(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.cPW.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.cPW.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener cQh = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cQe = true;
        }
    };
    private com.baidu.adp.base.d cQi = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (AntiHelper.tQ(a.this.bwM.getErrorCode())) {
                AntiHelper.ao(a.this.bnK.getPageContext().getPageActivity(), a.this.bwM.getErrorString());
            } else if (obj != null) {
                a.this.cPW.fg(!StringUtils.isNull(a.this.cQa));
            } else if (!StringUtils.isNull(a.this.bwM.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.bwM.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cQj = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.cPU.isAdded()) {
                if (aVar.type == 1) {
                    a.this.cPV.nW();
                }
                if (aVar.cQQ) {
                    if (aVar.type == 1) {
                        a.this.cPY = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.cQR);
                    } else if (aVar.type == 0 && !a.this.cPY) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.cQR;
                        a.this.cPW.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.bnK.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.cQb > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.cQb, a.this.cPW.aoF() - a.this.cQb, a.this.cPW.aoD(), a.this.cPW.aoE(), currentTimeMillis - a.this.cPW.aoC());
                    a.this.cQb = -1L;
                }
                if (aVar.cQR == null || aVar.cQR.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.bnK.getResources().getString(d.k.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.cQR.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.anW() != null) {
                    a.this.setSearchHint(hotSearchInfoData.anW());
                }
            }
        }
    };
    private g.b awQ = new g.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.g.b
        public void aU(boolean z) {
            a.this.cPW.fg(!StringUtils.isNull(a.this.cQa));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cOZ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Td();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.cPW = null;
        this.isFirst = true;
        this.cPY = false;
        this.cQb = -1L;
        this.cPU = enterForumFragment;
        this.bnK = enterForumFragment.getBaseFragmentActivity();
        this.cOZ.addEventDelegate(this);
        this.cQb = System.currentTimeMillis();
        this.isFirst = true;
        this.cPY = false;
        this.cQa = "";
        this.cPW = new EnterForumModel(this.bnK.getPageContext());
        this.cPX = new RecentlyVisitedForumModel();
        this.bwM = new LikeModel(this.bnK.getPageContext());
        this.bwM.setLoadDataCallBack(this.cQi);
        this.cPW.a(this.cQj);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aoy().k(this.cPU.getFragmentActivity(), l.o(this.cPU.getFragmentActivity()));
        initUI();
        initListener();
        aom();
    }

    private void initListener() {
        aop();
        this.cPU.registerListener(this.cQh);
        this.cPU.registerListener(this.cQg);
        this.cPU.registerListener(this.cQf);
    }

    private static void Td() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aom() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016550, new CustomMessageTask.CustomRunnable<ad>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ad> run(CustomMessage<ad> customMessage) {
                ad adVar = new ad();
                ArrayList arrayList = new ArrayList();
                if (a.this.cPW != null && a.this.cPW.aoG() != null && a.this.cPW.aoG().anT() != null && w.z(a.this.cPW.aoG().anT().anZ()) > 0) {
                    Iterator<f> it = a.this.cPW.aoG().anT().anZ().iterator();
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
                    adVar.u(arrayList);
                }
                return new CustomResponsedMessage<>(2016550, adVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.cPW.i(this.cPV.aoS(), this.cPV.aoT());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aon() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.cPV.aoQ();
    }

    public View aoo() {
        return this.cPV.aoo();
    }

    public void ao(View view) {
        this.cPV.ao(view);
    }

    private void aop() {
        this.cPU.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cPV == null || !a.this.cPV.anQ()) {
                    if (!a.this.isChanged()) {
                        a.this.aon();
                    } else {
                        a.this.aoq();
                    }
                    if (a.this.cQc) {
                        a.this.cPV.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.cPU.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cPV.aoQ();
                if (a.this.isChanged()) {
                    if (a.this.cPV.isEmpty()) {
                        a.this.cPV.aq(a.this.mRootView);
                        return;
                    } else {
                        a.this.cPV.aoP();
                        a.this.cPW.aS(a.this.cPV.aoS());
                    }
                }
                if (a.this.cQc) {
                    a.this.cPV.startPullRefresh();
                }
            }
        });
    }

    public void aoq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bnK.getPageContext().getPageActivity());
        aVar.cd(d.k.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.k.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.aon();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.ce(d.C0142d.cp_cont_b);
        aVar.b(this.bnK.getPageContext());
        aVar.xn();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bnK.getPageContext().getPageActivity());
            aVar.dE(String.format(this.bnK.getPageContext().getString(d.k.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.k.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.jU()) {
                        a.this.bnK.showToast(d.k.delete_like_fail);
                    } else {
                        new C0145a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.bnK.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ce(d.C0142d.cp_cont_b);
            aVar.b(this.bnK.getPageContext());
            aVar.xn();
        }
    }

    public void fc(boolean z) {
        if (this.mWaitingDialog == null) {
            aor();
        }
        this.mWaitingDialog.aO(z);
    }

    private void aor() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.bnK.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bnK.getActivity()).inflate(d.i.enter_forum_view, (ViewGroup) null);
        this.cPV = new com.baidu.tieba.enterForum.view.a(this.cPU, this.mRootView, this.cOZ, this.cPX);
        this.cPV.a(this.awQ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fd(boolean z) {
        if (this.cPV != null && this.cPU != null) {
            if (z) {
                if (this.cPU.isPrimary() && this.cPU.isResumed()) {
                    this.cPV.startPullRefresh();
                    return;
                } else {
                    this.cPV.nW();
                    return;
                }
            }
            this.cPV.nW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cPU.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.cPV != null) {
            if (bVar == null) {
                this.cPV.aq(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g anT = bVar.anT();
            ArrayList<f> arrayList = new ArrayList<>();
            if (anT != null) {
                arrayList = anT.anZ();
            }
            aQ(arrayList);
            if (b(bVar)) {
                this.cPV.aX(bVar.anU());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.anW() != null) {
                setSearchHint(hotSearchInfoData.anW());
            }
            this.cPV.aoU();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.anT() == null || w.A(bVar.anT().anZ())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.cPV.setSearchHint(str.trim());
        } else {
            this.cPV.setSearchHint(this.bnK.getActivity().getString(d.k.enter_forum_search_tip));
        }
    }

    private void aQ(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.cPV.aW(this.cPW.a(list, com.baidu.tbadk.util.c.Lj()));
        }
    }

    public void SK() {
        if (this.cPV != null) {
            fe(false);
        }
    }

    public void onDestroy() {
        Jf();
        com.baidu.tieba.enterForum.model.a.aoy().destroy();
        if (this.cPV != null) {
            if (this.cPW != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cPW.aS(this.cPV.aoS());
            }
            this.cPV.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016550);
        if (this.cPX != null) {
            this.cPX.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cPV != null) {
            this.cPV.onChangeSkinType(i);
        }
    }

    public void Jf() {
        if (this.cPW != null) {
            this.cPW.cancelLoadData();
        }
    }

    public void fe(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cQe && this.cPW != null && this.cPV != null) {
            String str = this.cQa;
            this.cQa = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cQa == null || this.cQa.equals(str)) {
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
                if (this.cPW != null && this.cPW.aoG() != null && this.cPW.aoG().anT() != null) {
                    Iterator<f> it = this.cPW.aoG().anT().anZ().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.jw(1);
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
                    com.baidu.tieba.tbadkCore.util.a.tT(currentAccount);
                }
                this.cPV.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Jf();
                if (z4) {
                    this.cPW.fg(StringUtils.isNull(this.cQa) ? false : true);
                } else if (z2) {
                    this.cPW.fh(!StringUtils.isNull(this.cQa));
                    this.cPW.fg(StringUtils.isNull(this.cQa) ? false : true);
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
        if (this.cPX != null) {
            this.cPX.onPrimary();
        }
    }

    public void onPause() {
        if (this.cPV != null && this.cPV.aoO() != null) {
            this.cPV.aoO().completePullRefresh();
        }
        if (this.cPX != null) {
            this.cPX.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0145a extends BdAsyncTask<f, Integer, String> {
        private f cQo;
        private y mNetwork = null;

        public C0145a(f fVar) {
            this.cQo = null;
            this.cQo = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.cQo;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.o(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.o("kw", fVar.getName());
                        this.mNetwork.yX().zX().mIsNeedTbs = true;
                        this.mNetwork.yz();
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
            super.onPostExecute((C0145a) str);
            a.this.fc(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.yX().zY().isRequestSuccess()) {
                    a.this.cQc = true;
                    if (a.this.cPU.isAdded() && a.this.bnK != null) {
                        a.this.bnK.showToast(a.this.bnK.getActivity().getString(d.k.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.i(false, this.cQo.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.cQo.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cQo.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.cQo.getName()));
                    }
                    a.this.cPV.b(this.cQo);
                } else if (a.this.bnK != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.bnK.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.cPU.isAdded()) {
                        a.this.bnK.showToast(a.this.bnK.getActivity().getString(d.k.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.fc(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aMv().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int JD = bVar.JD();
        com.baidu.tbadk.mvc.b.a JE = bVar.JE();
        switch (JD) {
            case 1:
                if (this.cQd != 2 && (JE instanceof f)) {
                    String name = ((f) JE).getName();
                    if (ap.be(name)) {
                        this.bnK.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bnK.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.bnK.getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        List<f> aoS = this.cPV.aoS();
                        if (!w.A(aoS)) {
                            if (w.z(aoS) > 1 && aoS.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < aoS.size()) {
                                    if (!aoS.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new an("c12049").ah("obj_type", "2").r("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.cQd == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.cPV.jz(JE instanceof h ? ((h) JE).getPosition() : 0);
                this.cQc = false;
                if (this.cPU.getView() == null || this.cPU.getView().getParent() == null) {
                    return true;
                }
                this.cPU.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (JE instanceof f) {
                    a((f) JE);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bnK.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bnK.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.bnK.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bnK.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c10378").ah("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new an("c12049").ah("obj_type", "2").r("obj_locate", 1));
                this.bnK.finish();
                return true;
            case 9:
                if (this.cPV != null) {
                    this.cPV.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.cQd = 2;
                return true;
            case 11:
                this.cQd = 1;
                return true;
        }
    }

    public void aos() {
        if (this.cPV != null) {
            this.cPV.aoR();
        }
    }

    public boolean aot() {
        if (this.cPV != null) {
            return this.cPV.aot();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean JC() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bnK.getUniqueId();
    }

    public void ff(boolean z) {
        int i = 0;
        if (this.cPV != null && this.cPU != null) {
            boolean z2 = this.cPV.aot() && this.cPU.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.cPV.anQ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
