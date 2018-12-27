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
    private LikeModel aLn;
    private BaseFragmentActivity bCx;
    private EnterForumFragment drn;
    private EnterForumModel drp;
    private RecentlyVisitedForumModel drq;
    private boolean drr;
    private String drt;
    private long dru;
    private boolean drv;
    private boolean drx;
    private boolean isFirst;
    private View mRootView;
    private d mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a dro = null;
    private boolean drs = false;
    private int drw = 1;
    private CustomMessageListener dry = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.drs = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a drz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.drp.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.dro.pg();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bCx.getResources().getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bCx.showToast(errorString);
                    if (a.this.dro.isEmpty()) {
                        a.this.dro.aM(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.drp.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.drp.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener drA = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.drx = true;
        }
    };
    private com.baidu.adp.base.d drB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aj(a.this.aLn.getErrorCode(), a.this.aLn.getErrorString())) {
                AntiHelper.aJ(a.this.bCx.getPageContext().getPageActivity(), a.this.aLn.getErrorString());
            } else if (obj != null) {
                a.this.drp.gd(!StringUtils.isNull(a.this.drt));
            } else if (!StringUtils.isNull(a.this.aLn.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.aLn.getErrorString());
            }
        }
    };
    private final EnterForumModel.b drC = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.drn.isAdded()) {
                if (aVar.type == 1) {
                    a.this.dro.pg();
                }
                if (aVar.dsd) {
                    if (aVar.type == 1) {
                        a.this.drr = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.dse);
                    } else if (aVar.type == 0 && !a.this.drr) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.dse;
                        a.this.drp.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.bCx.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.dru > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.dru, a.this.drp.awp() - a.this.dru, a.this.drp.awn(), a.this.drp.awo(), currentTimeMillis - a.this.drp.awm());
                    a.this.dru = -1L;
                }
                if (aVar.dse == null || aVar.dse.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.bCx.getResources().getString(e.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.dse.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.avH() != null) {
                    a.this.setSearchHint(hotSearchInfoData.avH());
                }
            }
        }
    };
    private j.b aIF = new j.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            a.this.drp.gd(!StringUtils.isNull(a.this.drt));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter dqs = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aab();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.drp = null;
        this.isFirst = true;
        this.drr = false;
        this.dru = -1L;
        this.drn = enterForumFragment;
        this.bCx = enterForumFragment.getBaseFragmentActivity();
        this.dqs.addEventDelegate(this);
        this.dru = System.currentTimeMillis();
        this.isFirst = true;
        this.drr = false;
        this.drt = "";
        this.drp = new EnterForumModel(this.bCx.getPageContext());
        this.drq = new RecentlyVisitedForumModel();
        this.aLn = new LikeModel(this.bCx.getPageContext());
        this.aLn.setLoadDataCallBack(this.drB);
        this.drp.a(this.drC);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.awi().o(this.drn.getFragmentActivity(), l.r(this.drn.getFragmentActivity()));
        initUI();
        initListener();
        avY();
    }

    private void initListener() {
        awb();
        this.drn.registerListener(this.drA);
        this.drn.registerListener(this.drz);
        this.drn.registerListener(this.dry);
    }

    private static void aab() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void avY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (a.this.drp != null && a.this.drp.awq() != null && a.this.drp.awq().avE() != null && v.H(a.this.drp.awq().avE().avK()) > 0) {
                    Iterator<f> it = a.this.drp.awq().avE().avK().iterator();
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
        return !this.drp.i(this.dro.awC(), this.dro.awD());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.dro.awA();
    }

    public View awa() {
        return this.dro.awa();
    }

    public void aK(View view) {
        this.dro.aK(view);
    }

    private void awb() {
        this.drn.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.dro == null || !a.this.dro.avB()) {
                    if (!a.this.isChanged()) {
                        a.this.avZ();
                    } else {
                        a.this.awc();
                    }
                    if (a.this.drv) {
                        a.this.dro.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.drn.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.dro.awA();
                if (a.this.isChanged()) {
                    if (a.this.dro.isEmpty()) {
                        a.this.dro.aM(a.this.mRootView);
                        return;
                    } else {
                        a.this.dro.awz();
                        a.this.drp.bj(a.this.dro.awC());
                    }
                }
                if (a.this.drv) {
                    a.this.dro.startPullRefresh();
                }
            }
        });
    }

    public void awc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bCx.getPageContext().getPageActivity());
        aVar.db(e.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(e.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.avZ();
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
        aVar.b(this.bCx.getPageContext());
        aVar.BF();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bCx.getPageContext().getPageActivity());
            aVar.eB(String.format(this.bCx.getPageContext().getString(e.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(e.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.ll()) {
                        a.this.bCx.showToast(e.j.delete_like_fail);
                    } else {
                        new C0212a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.bCx.getPageContext().getPageActivity(), "recom_flist_unlike", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
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
            aVar.b(this.bCx.getPageContext());
            aVar.BF();
        }
    }

    public void fZ(boolean z) {
        if (this.mWaitingDialog == null) {
            awd();
        }
        this.mWaitingDialog.bA(z);
    }

    private void awd() {
        this.mWaitingDialog = new d(this.bCx.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bCx.getActivity()).inflate(e.h.enter_forum_view, (ViewGroup) null);
        this.dro = new com.baidu.tieba.enterForum.view.a(this.drn, this.mRootView, this.dqs, this.drq);
        this.dro.a(this.aIF);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ga(boolean z) {
        if (this.dro != null && this.drn != null) {
            if (z) {
                if (this.drn.isPrimary() && this.drn.isResumed()) {
                    this.dro.startPullRefresh();
                    return;
                } else {
                    this.dro.pg();
                    return;
                }
            }
            this.dro.pg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.drn.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.dro != null) {
            if (bVar == null) {
                this.dro.aM(this.mRootView);
                return;
            }
            g avE = bVar.avE();
            ArrayList<f> arrayList = new ArrayList<>();
            if (avE != null) {
                arrayList = avE.avK();
            }
            bh(arrayList);
            if (b(bVar)) {
                this.dro.bo(bVar.avF());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.avH() != null) {
                setSearchHint(hotSearchInfoData.avH());
            }
            this.dro.awE();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.avE() == null || v.I(bVar.avE().avK())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.dro.setSearchHint(str.trim());
        } else {
            this.dro.setSearchHint(this.bCx.getActivity().getString(e.j.enter_forum_search_tip));
        }
    }

    private void bh(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.dro.bn(this.drp.a(list, com.baidu.tbadk.util.d.PO()));
        }
    }

    public void loadData() {
        if (this.dro != null) {
            gb(false);
        }
    }

    public void onDestroy() {
        NF();
        com.baidu.tieba.enterForum.model.a.awi().destroy();
        if (this.dro != null) {
            if (this.drp != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.drp.bj(this.dro.awC());
            }
            this.dro.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.drq != null) {
            this.drq.onDestroy();
        }
        if (this.dqs != null) {
            this.dqs.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dro != null) {
            this.dro.onChangeSkinType(i);
        }
    }

    public void NF() {
        if (this.drp != null) {
            this.drp.cancelLoadData();
        }
    }

    public void gb(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.drx && this.drp != null && this.dro != null) {
            String str = this.drt;
            this.drt = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.drt == null || this.drt.equals(str)) {
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
                if (this.drp != null && this.drp.awq() != null && this.drp.awq().avE() != null) {
                    Iterator<f> it = this.drp.awq().avE().avK().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.lz(1);
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
                    com.baidu.tieba.tbadkCore.util.a.vN(currentAccount);
                }
                this.dro.notifyDataSetChanged();
            }
            if (z2 || z4) {
                NF();
                if (z4) {
                    this.drp.gd(StringUtils.isNull(this.drt) ? false : true);
                } else if (z2) {
                    this.drp.ge(!StringUtils.isNull(this.drt));
                    this.drp.gd(StringUtils.isNull(this.drt) ? false : true);
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
        if (this.drq != null) {
            this.drq.onPrimary();
        }
    }

    public void onPause() {
        if (this.dro != null && this.dro.awy() != null) {
            this.dro.awy().completePullRefresh();
        }
        if (this.drq != null) {
            this.drq.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0212a extends BdAsyncTask<f, Integer, String> {
        private f drH;
        private x mNetwork = null;

        public C0212a(f fVar) {
            this.drH = null;
            this.drH = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.drH;
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
            a.this.fZ(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                    a.this.drv = true;
                    if (a.this.drn.isAdded() && a.this.bCx != null) {
                        a.this.bCx.showToast(a.this.bCx.getActivity().getString(e.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.h(false, this.drH.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.drH.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.drH.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.drH.getName()));
                    }
                    a.this.dro.b(this.drH);
                } else if (a.this.bCx != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.bCx.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.drn.isAdded()) {
                        a.this.bCx.showToast(a.this.bCx.getActivity().getString(e.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.fZ(true);
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
    public void h(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aUX().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Oe = bVar.Oe();
        com.baidu.tbadk.mvc.b.a Of = bVar.Of();
        switch (Oe) {
            case 1:
                if (this.drw != 2 && (Of instanceof f)) {
                    String name = ((f) Of).getName();
                    if (ao.bv(name)) {
                        this.bCx.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bCx.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.bCx.getResources().getString(e.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        List<f> awC = this.dro.awC();
                        if (!v.I(awC)) {
                            if (v.H(awC) > 1 && awC.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < awC.size()) {
                                    if (!awC.get(i2).getName().equals(name)) {
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
                if (this.drw == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.dro.lC(Of instanceof h ? ((h) Of).getPosition() : 0);
                this.drv = false;
                if (this.drn.getView() == null || this.drn.getView().getParent() == null) {
                    return true;
                }
                this.drn.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Of instanceof f) {
                    a((f) Of);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bCx.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bCx.getPageContext().getPageActivity(), "notlogin_6", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.bCx.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bCx.getPageContext().getPageActivity(), "notlogin_8", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("c10378").aA("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").aA("obj_type", "2").x("obj_locate", 1));
                this.bCx.finish();
                return true;
            case 9:
                if (this.dro != null) {
                    this.dro.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.drw = 2;
                return true;
            case 11:
                this.drw = 1;
                return true;
        }
    }

    public void awe() {
        if (this.dro != null) {
            this.dro.awB();
        }
    }

    public boolean awf() {
        if (this.dro != null) {
            return this.dro.awf();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Od() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bCx.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dro != null) {
            this.dro.setPageUniqueId(bdUniqueId);
        }
    }

    public void gc(boolean z) {
        int i = 0;
        if (this.dro != null && this.drn != null) {
            boolean z2 = this.dro.awf() && this.drn.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.dro.avB()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
