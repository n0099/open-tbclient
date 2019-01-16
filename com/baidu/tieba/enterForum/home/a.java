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
    private LikeModel aLP;
    private BaseFragmentActivity bDk;
    private EnterForumFragment drW;
    private EnterForumModel drY;
    private RecentlyVisitedForumModel drZ;
    private boolean dsa;
    private String dsc;
    private long dsd;
    private boolean dse;
    private boolean dsg;
    private boolean isFirst;
    private View mRootView;
    private d mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a drX = null;
    private boolean dsb = false;
    private int dsf = 1;
    private CustomMessageListener dsh = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.dsb = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a dsi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.drY.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.drX.pk();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bDk.getResources().getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bDk.showToast(errorString);
                    if (a.this.drX.isEmpty()) {
                        a.this.drX.aM(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.drY.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.drY.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener dsj = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.dsg = true;
        }
    };
    private com.baidu.adp.base.d dsk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.al(a.this.aLP.getErrorCode(), a.this.aLP.getErrorString())) {
                AntiHelper.aH(a.this.bDk.getPageContext().getPageActivity(), a.this.aLP.getErrorString());
            } else if (obj != null) {
                a.this.drY.gg(!StringUtils.isNull(a.this.dsc));
            } else if (!StringUtils.isNull(a.this.aLP.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.aLP.getErrorString());
            }
        }
    };
    private final EnterForumModel.b dsl = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.drW.isAdded()) {
                if (aVar.type == 1) {
                    a.this.drX.pk();
                }
                if (aVar.dsM) {
                    if (aVar.type == 1) {
                        a.this.dsa = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.dsN);
                    } else if (aVar.type == 0 && !a.this.dsa) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.dsN;
                        a.this.drY.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.bDk.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.dsd > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.dsd, a.this.drY.awM() - a.this.dsd, a.this.drY.awK(), a.this.drY.awL(), currentTimeMillis - a.this.drY.awJ());
                    a.this.dsd = -1L;
                }
                if (aVar.dsN == null || aVar.dsN.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.bDk.getResources().getString(e.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.dsN.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.awf() != null) {
                    a.this.setSearchHint(hotSearchInfoData.awf());
                }
            }
        }
    };
    private j.b aJh = new j.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void bI(boolean z) {
            a.this.drY.gg(!StringUtils.isNull(a.this.dsc));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter dre = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aay();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.drY = null;
        this.isFirst = true;
        this.dsa = false;
        this.dsd = -1L;
        this.drW = enterForumFragment;
        this.bDk = enterForumFragment.getBaseFragmentActivity();
        this.dre.addEventDelegate(this);
        this.dsd = System.currentTimeMillis();
        this.isFirst = true;
        this.dsa = false;
        this.dsc = "";
        this.drY = new EnterForumModel(this.bDk.getPageContext());
        this.drZ = new RecentlyVisitedForumModel();
        this.aLP = new LikeModel(this.bDk.getPageContext());
        this.aLP.setLoadDataCallBack(this.dsk);
        this.drY.a(this.dsl);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.awF().o(this.drW.getFragmentActivity(), l.r(this.drW.getFragmentActivity()));
        initUI();
        initListener();
        awv();
    }

    private void initListener() {
        awy();
        this.drW.registerListener(this.dsj);
        this.drW.registerListener(this.dsi);
        this.drW.registerListener(this.dsh);
    }

    private static void aay() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void awv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (a.this.drY != null && a.this.drY.awN() != null && a.this.drY.awN().awc() != null && v.H(a.this.drY.awN().awc().awi()) > 0) {
                    Iterator<f> it = a.this.drY.awN().awc().awi().iterator();
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
        return !this.drY.i(this.drX.awZ(), this.drX.axa());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aww() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.drX.awX();
    }

    public View awx() {
        return this.drX.awx();
    }

    public void aK(View view) {
        this.drX.aK(view);
    }

    private void awy() {
        this.drW.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.drX == null || !a.this.drX.avZ()) {
                    if (!a.this.isChanged()) {
                        a.this.aww();
                    } else {
                        a.this.awz();
                    }
                    if (a.this.dse) {
                        a.this.drX.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.drW.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.drX.awX();
                if (a.this.isChanged()) {
                    if (a.this.drX.isEmpty()) {
                        a.this.drX.aM(a.this.mRootView);
                        return;
                    } else {
                        a.this.drX.awW();
                        a.this.drY.bk(a.this.drX.awZ());
                    }
                }
                if (a.this.dse) {
                    a.this.drX.startPullRefresh();
                }
            }
        });
    }

    public void awz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bDk.getPageContext().getPageActivity());
        aVar.db(e.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(e.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.aww();
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
        aVar.b(this.bDk.getPageContext());
        aVar.BS();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bDk.getPageContext().getPageActivity());
            aVar.eK(String.format(this.bDk.getPageContext().getString(e.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(e.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.ll()) {
                        a.this.bDk.showToast(e.j.delete_like_fail);
                    } else {
                        new C0212a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.bDk.getPageContext().getPageActivity(), "recom_flist_unlike", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
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
            aVar.b(this.bDk.getPageContext());
            aVar.BS();
        }
    }

    public void gc(boolean z) {
        if (this.mWaitingDialog == null) {
            awA();
        }
        this.mWaitingDialog.bB(z);
    }

    private void awA() {
        this.mWaitingDialog = new d(this.bDk.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bDk.getActivity()).inflate(e.h.enter_forum_view, (ViewGroup) null);
        this.drX = new com.baidu.tieba.enterForum.view.a(this.drW, this.mRootView, this.dre, this.drZ);
        this.drX.a(this.aJh);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void gd(boolean z) {
        if (this.drX != null && this.drW != null) {
            if (z) {
                if (this.drW.isPrimary() && this.drW.isResumed()) {
                    this.drX.startPullRefresh();
                    return;
                } else {
                    this.drX.pk();
                    return;
                }
            }
            this.drX.pk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.drW.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.drX != null) {
            if (bVar == null) {
                this.drX.aM(this.mRootView);
                return;
            }
            g awc = bVar.awc();
            ArrayList<f> arrayList = new ArrayList<>();
            if (awc != null) {
                arrayList = awc.awi();
            }
            bi(arrayList);
            if (b(bVar)) {
                this.drX.bp(bVar.awd());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.awf() != null) {
                setSearchHint(hotSearchInfoData.awf());
            }
            this.drX.axb();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.awc() == null || v.I(bVar.awc().awi())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.drX.setSearchHint(str.trim());
        } else {
            this.drX.setSearchHint(this.bDk.getActivity().getString(e.j.enter_forum_search_tip));
        }
    }

    private void bi(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.drX.bo(this.drY.a(list, com.baidu.tbadk.util.d.Qg()));
        }
    }

    public void loadData() {
        if (this.drX != null) {
            ge(false);
        }
    }

    public void onDestroy() {
        NW();
        com.baidu.tieba.enterForum.model.a.awF().destroy();
        if (this.drX != null) {
            if (this.drY != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.drY.bk(this.drX.awZ());
            }
            this.drX.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.drZ != null) {
            this.drZ.onDestroy();
        }
        if (this.dre != null) {
            this.dre.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.drX != null) {
            this.drX.onChangeSkinType(i);
        }
    }

    public void NW() {
        if (this.drY != null) {
            this.drY.cancelLoadData();
        }
    }

    public void ge(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.dsg && this.drY != null && this.drX != null) {
            String str = this.dsc;
            this.dsc = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.dsc == null || this.dsc.equals(str)) {
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
                if (this.drY != null && this.drY.awN() != null && this.drY.awN().awc() != null) {
                    Iterator<f> it = this.drY.awN().awc().awi().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.lA(1);
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
                    com.baidu.tieba.tbadkCore.util.a.wd(currentAccount);
                }
                this.drX.notifyDataSetChanged();
            }
            if (z2 || z4) {
                NW();
                if (z4) {
                    this.drY.gg(StringUtils.isNull(this.dsc) ? false : true);
                } else if (z2) {
                    this.drY.gh(!StringUtils.isNull(this.dsc));
                    this.drY.gg(StringUtils.isNull(this.dsc) ? false : true);
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
        if (this.drZ != null) {
            this.drZ.onPrimary();
        }
    }

    public void onPause() {
        if (this.drX != null && this.drX.awV() != null) {
            this.drX.awV().completePullRefresh();
        }
        if (this.drZ != null) {
            this.drZ.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0212a extends BdAsyncTask<f, Integer, String> {
        private f dsq;
        private x mNetwork = null;

        public C0212a(f fVar) {
            this.dsq = null;
            this.dsq = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.dsq;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.x("kw", fVar.getName());
                        this.mNetwork.Dw().Eu().mIsNeedTbs = true;
                        this.mNetwork.CY();
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
            a.this.gc(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.Dw().Ev().isRequestSuccess()) {
                    a.this.dse = true;
                    if (a.this.drW.isAdded() && a.this.bDk != null) {
                        a.this.bDk.showToast(a.this.bDk.getActivity().getString(e.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.g(false, this.dsq.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.dsq.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.dsq.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.dsq.getName()));
                    }
                    a.this.drX.b(this.dsq);
                } else if (a.this.bDk != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.bDk.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.drW.isAdded()) {
                        a.this.bDk.showToast(a.this.bDk.getActivity().getString(e.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.gc(true);
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
                    com.baidu.tieba.im.settingcache.d.aVx().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Ow = bVar.Ow();
        com.baidu.tbadk.mvc.b.a Ox = bVar.Ox();
        switch (Ow) {
            case 1:
                if (this.dsf != 2 && (Ox instanceof f)) {
                    String name = ((f) Ox).getName();
                    if (ao.bv(name)) {
                        this.bDk.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bDk.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.bDk.getResources().getString(e.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        List<f> awZ = this.drX.awZ();
                        if (!v.I(awZ)) {
                            if (v.H(awZ) > 1 && awZ.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < awZ.size()) {
                                    if (!awZ.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new am("c12049").aB("obj_type", "2").y("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.dsf == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.drX.lD(Ox instanceof h ? ((h) Ox).getPosition() : 0);
                this.dse = false;
                if (this.drW.getView() == null || this.drW.getView().getParent() == null) {
                    return true;
                }
                this.drW.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Ox instanceof f) {
                    a((f) Ox);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bDk.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bDk.getPageContext().getPageActivity(), "notlogin_6", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.bDk.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bDk.getPageContext().getPageActivity(), "notlogin_8", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("c10378").aB("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").aB("obj_type", "2").y("obj_locate", 1));
                this.bDk.finish();
                return true;
            case 9:
                if (this.drX != null) {
                    this.drX.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.dsf = 2;
                return true;
            case 11:
                this.dsf = 1;
                return true;
        }
    }

    public void awB() {
        if (this.drX != null) {
            this.drX.awY();
        }
    }

    public boolean awC() {
        if (this.drX != null) {
            return this.drX.awC();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Ov() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bDk.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.drX != null) {
            this.drX.setPageUniqueId(bdUniqueId);
        }
    }

    public void gf(boolean z) {
        int i = 0;
        if (this.drX != null && this.drW != null) {
            boolean z2 = this.drX.awC() && this.drW.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.drX.avZ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
