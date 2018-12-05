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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel aLl;
    private BaseFragmentActivity bCu;
    private RecentlyVisitedForumModel doA;
    private boolean doB;
    private String doD;
    private long doE;
    private boolean doF;
    private boolean doH;
    private EnterForumFragment dox;
    private EnterForumModel doz;
    private boolean isFirst;
    private View mRootView;
    private d mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a doy = null;
    private boolean doC = false;
    private int doG = 1;
    private CustomMessageListener doI = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.doC = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a doJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.doz.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.doy.pg();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bCu.getResources().getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bCu.showToast(errorString);
                    if (a.this.doy.isEmpty()) {
                        a.this.doy.aJ(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.doz.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.doz.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener doK = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.doH = true;
        }
    };
    private com.baidu.adp.base.d doL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.ai(a.this.aLl.getErrorCode(), a.this.aLl.getErrorString())) {
                AntiHelper.aJ(a.this.bCu.getPageContext().getPageActivity(), a.this.aLl.getErrorString());
            } else if (obj != null) {
                a.this.doz.gb(!StringUtils.isNull(a.this.doD));
            } else if (!StringUtils.isNull(a.this.aLl.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.aLl.getErrorString());
            }
        }
    };
    private final EnterForumModel.b doM = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.dox.isAdded()) {
                if (aVar.type == 1) {
                    a.this.doy.pg();
                }
                if (aVar.dpn) {
                    if (aVar.type == 1) {
                        a.this.doB = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.dpo);
                    } else if (aVar.type == 0 && !a.this.doB) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.dpo;
                        a.this.doz.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.bCu.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.doE > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.doE, a.this.doz.avA() - a.this.doE, a.this.doz.avy(), a.this.doz.avz(), currentTimeMillis - a.this.doz.avx());
                    a.this.doE = -1L;
                }
                if (aVar.dpo == null || aVar.dpo.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.bCu.getResources().getString(e.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.dpo.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.auS() != null) {
                    a.this.setSearchHint(hotSearchInfoData.auS());
                }
            }
        }
    };
    private j.b aIE = new j.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            a.this.doz.gb(!StringUtils.isNull(a.this.doD));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter dnB = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        ZZ();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.doz = null;
        this.isFirst = true;
        this.doB = false;
        this.doE = -1L;
        this.dox = enterForumFragment;
        this.bCu = enterForumFragment.getBaseFragmentActivity();
        this.dnB.addEventDelegate(this);
        this.doE = System.currentTimeMillis();
        this.isFirst = true;
        this.doB = false;
        this.doD = "";
        this.doz = new EnterForumModel(this.bCu.getPageContext());
        this.doA = new RecentlyVisitedForumModel();
        this.aLl = new LikeModel(this.bCu.getPageContext());
        this.aLl.setLoadDataCallBack(this.doL);
        this.doz.a(this.doM);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.avt().o(this.dox.getFragmentActivity(), l.r(this.dox.getFragmentActivity()));
        initUI();
        initListener();
        avj();
    }

    private void initListener() {
        avm();
        this.dox.registerListener(this.doK);
        this.dox.registerListener(this.doJ);
        this.dox.registerListener(this.doI);
    }

    private static void ZZ() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void avj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (a.this.doz != null && a.this.doz.avB() != null && a.this.doz.avB().auP() != null && v.H(a.this.doz.avB().auP().auV()) > 0) {
                    Iterator<f> it = a.this.doz.avB().auP().auV().iterator();
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
                    acVar.C(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, acVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.doz.i(this.doy.avN(), this.doy.avO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avk() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.doy.avL();
    }

    public View avl() {
        return this.doy.avl();
    }

    public void aH(View view) {
        this.doy.aH(view);
    }

    private void avm() {
        this.dox.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.doy == null || !a.this.doy.auM()) {
                    if (!a.this.isChanged()) {
                        a.this.avk();
                    } else {
                        a.this.avn();
                    }
                    if (a.this.doF) {
                        a.this.doy.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.dox.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.doy.avL();
                if (a.this.isChanged()) {
                    if (a.this.doy.isEmpty()) {
                        a.this.doy.aJ(a.this.mRootView);
                        return;
                    } else {
                        a.this.doy.avK();
                        a.this.doz.bi(a.this.doy.avN());
                    }
                }
                if (a.this.doF) {
                    a.this.doy.startPullRefresh();
                }
            }
        });
    }

    public void avn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bCu.getPageContext().getPageActivity());
        aVar.db(e.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(e.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.avk();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.dc(e.d.cp_cont_b);
        aVar.b(this.bCu.getPageContext());
        aVar.BF();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bCu.getPageContext().getPageActivity());
            aVar.eB(String.format(this.bCu.getPageContext().getString(e.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(e.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.ll()) {
                        a.this.bCu.showToast(e.j.delete_like_fail);
                    } else {
                        new C0212a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.bCu.getPageContext().getPageActivity(), "recom_flist_unlike", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dc(e.d.cp_cont_b);
            aVar.b(this.bCu.getPageContext());
            aVar.BF();
        }
    }

    public void fX(boolean z) {
        if (this.mWaitingDialog == null) {
            avo();
        }
        this.mWaitingDialog.bA(z);
    }

    private void avo() {
        this.mWaitingDialog = new d(this.bCu.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bCu.getActivity()).inflate(e.h.enter_forum_view, (ViewGroup) null);
        this.doy = new com.baidu.tieba.enterForum.view.a(this.dox, this.mRootView, this.dnB, this.doA);
        this.doy.a(this.aIE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fY(boolean z) {
        if (this.doy != null && this.dox != null) {
            if (z) {
                if (this.dox.isPrimary() && this.dox.isResumed()) {
                    this.doy.startPullRefresh();
                    return;
                } else {
                    this.doy.pg();
                    return;
                }
            }
            this.doy.pg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.dox.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.doy != null) {
            if (bVar == null) {
                this.doy.aJ(this.mRootView);
                return;
            }
            g auP = bVar.auP();
            ArrayList<f> arrayList = new ArrayList<>();
            if (auP != null) {
                arrayList = auP.auV();
            }
            bg(arrayList);
            if (b(bVar)) {
                this.doy.bn(bVar.auQ());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.auS() != null) {
                setSearchHint(hotSearchInfoData.auS());
            }
            this.doy.avP();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.auP() == null || v.I(bVar.auP().auV())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.doy.setSearchHint(str.trim());
        } else {
            this.doy.setSearchHint(this.bCu.getActivity().getString(e.j.enter_forum_search_tip));
        }
    }

    private void bg(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.doy.bm(this.doz.a(list, com.baidu.tbadk.util.d.PM()));
        }
    }

    public void loadData() {
        if (this.doy != null) {
            fZ(false);
        }
    }

    public void onDestroy() {
        NE();
        com.baidu.tieba.enterForum.model.a.avt().destroy();
        if (this.doy != null) {
            if (this.doz != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.doz.bi(this.doy.avN());
            }
            this.doy.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.doA != null) {
            this.doA.onDestroy();
        }
        if (this.dnB != null) {
            this.dnB.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.doy != null) {
            this.doy.onChangeSkinType(i);
        }
    }

    public void NE() {
        if (this.doz != null) {
            this.doz.cancelLoadData();
        }
    }

    public void fZ(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.doH && this.doz != null && this.doy != null) {
            String str = this.doD;
            this.doD = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.doD == null || this.doD.equals(str)) {
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
                if (this.doz != null && this.doz.avB() != null && this.doz.avB().auP() != null) {
                    Iterator<f> it = this.doz.avB().auP().auV().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.lm(1);
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
                    com.baidu.tieba.tbadkCore.util.a.vK(currentAccount);
                }
                this.doy.notifyDataSetChanged();
            }
            if (z2 || z4) {
                NE();
                if (z4) {
                    this.doz.gb(StringUtils.isNull(this.doD) ? false : true);
                } else if (z2) {
                    this.doz.gc(!StringUtils.isNull(this.doD));
                    this.doz.gb(StringUtils.isNull(this.doD) ? false : true);
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
        if (this.doA != null) {
            this.doA.onPrimary();
        }
    }

    public void onPause() {
        if (this.doy != null && this.doy.avJ() != null) {
            this.doy.avJ().completePullRefresh();
        }
        if (this.doA != null) {
            this.doA.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0212a extends BdAsyncTask<f, Integer, String> {
        private f doR;
        private x mNetwork = null;

        public C0212a(f fVar) {
            this.doR = null;
            this.doR = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.doR;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.x("kw", fVar.getName());
                        this.mNetwork.Dj().Eh().mIsNeedTbs = true;
                        this.mNetwork.CL();
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
            super.onPostExecute((C0212a) str);
            a.this.fX(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                    a.this.doF = true;
                    if (a.this.dox.isAdded() && a.this.bCu != null) {
                        a.this.bCu.showToast(a.this.bCu.getActivity().getString(e.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.g(false, this.doR.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.doR.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.doR.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.doR.getName()));
                    }
                    a.this.doy.b(this.doR);
                } else if (a.this.bCu != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.bCu.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.dox.isAdded()) {
                        a.this.bCu.showToast(a.this.bCu.getActivity().getString(e.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.fX(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aUk().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Od = bVar.Od();
        com.baidu.tbadk.mvc.b.a Oe = bVar.Oe();
        switch (Od) {
            case 1:
                if (this.doG != 2 && (Oe instanceof f)) {
                    String name = ((f) Oe).getName();
                    if (ao.bv(name)) {
                        this.bCu.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bCu.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.bCu.getResources().getString(e.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        List<f> avN = this.doy.avN();
                        if (!v.I(avN)) {
                            if (v.H(avN) > 1 && avN.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < avN.size()) {
                                    if (!avN.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new am("c12049").aA("obj_type", "2").x("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.doG == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.doy.lp(Oe instanceof h ? ((h) Oe).getPosition() : 0);
                this.doF = false;
                if (this.dox.getView() == null || this.dox.getView().getParent() == null) {
                    return true;
                }
                this.dox.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Oe instanceof f) {
                    a((f) Oe);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bCu.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bCu.getPageContext().getPageActivity(), "notlogin_6", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.bCu.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bCu.getPageContext().getPageActivity(), "notlogin_8", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("c10378").aA("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").aA("obj_type", "2").x("obj_locate", 1));
                this.bCu.finish();
                return true;
            case 9:
                if (this.doy != null) {
                    this.doy.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.doG = 2;
                return true;
            case 11:
                this.doG = 1;
                return true;
        }
    }

    public void avp() {
        if (this.doy != null) {
            this.doy.avM();
        }
    }

    public boolean avq() {
        if (this.doy != null) {
            return this.doy.avq();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Oc() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bCu.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.doy != null) {
            this.doy.setPageUniqueId(bdUniqueId);
        }
    }

    public void ga(boolean z) {
        int i = 0;
        if (this.doy != null && this.dox != null) {
            boolean z2 = this.doy.avq() && this.dox.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.doy.auM()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
