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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
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
    private BaseFragmentActivity bml;
    private LikeModel bvr;
    private EnterForumFragment cRW;
    private EnterForumModel cRY;
    private RecentlyVisitedForumModel cRZ;
    private boolean cSa;
    private String cSc;
    private long cSd;
    private boolean cSe;
    private boolean cSg;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a cRX = null;
    private boolean cSb = false;
    private int cSf = 1;
    private CustomMessageListener cSh = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cSb = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a cSi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.cRY.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.cRX.nW();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bml.getResources().getString(d.k.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bml.showToast(errorString);
                    if (a.this.cRX.isEmpty()) {
                        a.this.cRX.ao(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.cRY.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.cRY.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener cSj = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cSg = true;
        }
    };
    private com.baidu.adp.base.d cSk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (AntiHelper.tE(a.this.bvr.getErrorCode())) {
                AntiHelper.ao(a.this.bml.getPageContext().getPageActivity(), a.this.bvr.getErrorString());
            } else if (obj != null) {
                a.this.cRY.fg(!StringUtils.isNull(a.this.cSc));
            } else if (!StringUtils.isNull(a.this.bvr.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.bvr.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cSl = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.cRW.isAdded()) {
                if (aVar.type == 1) {
                    a.this.cRX.nW();
                }
                if (aVar.cSS) {
                    if (aVar.type == 1) {
                        a.this.cSa = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.cST);
                    } else if (aVar.type == 0 && !a.this.cSa) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.cST;
                        a.this.cRY.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.bml.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.cSd > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.cSd, a.this.cRY.apl() - a.this.cSd, a.this.cRY.apj(), a.this.cRY.apk(), currentTimeMillis - a.this.cRY.aph());
                    a.this.cSd = -1L;
                }
                if (aVar.cST == null || aVar.cST.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.bml.getResources().getString(d.k.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.cST.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.aoC() != null) {
                    a.this.setSearchHint(hotSearchInfoData.aoC());
                }
            }
        }
    };
    private f.b awh = new f.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.f.b
        public void aS(boolean z) {
            a.this.cRY.fg(!StringUtils.isNull(a.this.cSc));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cRe = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        SH();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.cRY = null;
        this.isFirst = true;
        this.cSa = false;
        this.cSd = -1L;
        this.cRW = enterForumFragment;
        this.bml = enterForumFragment.getBaseFragmentActivity();
        this.cRe.addEventDelegate(this);
        this.cSd = System.currentTimeMillis();
        this.isFirst = true;
        this.cSa = false;
        this.cSc = "";
        this.cRY = new EnterForumModel(this.bml.getPageContext());
        this.cRZ = new RecentlyVisitedForumModel();
        this.bvr = new LikeModel(this.bml.getPageContext());
        this.bvr.setLoadDataCallBack(this.cSk);
        this.cRY.a(this.cSl);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.apd().k(this.cRW.getFragmentActivity(), l.o(this.cRW.getFragmentActivity()));
        initUI();
        initListener();
        aoR();
    }

    private void initListener() {
        aoU();
        this.cRW.registerListener(this.cSj);
        this.cRW.registerListener(this.cSi);
        this.cRW.registerListener(this.cSh);
    }

    private static void SH() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aoR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016550, new CustomMessageTask.CustomRunnable<ad>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ad> run(CustomMessage<ad> customMessage) {
                ad adVar = new ad();
                ArrayList arrayList = new ArrayList();
                if (a.this.cRY != null && a.this.cRY.apm() != null && a.this.cRY.apm().aoz() != null && w.y(a.this.cRY.apm().aoz().aoE()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.cRY.apm().aoz().aoE().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.c(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    adVar.t(arrayList);
                }
                return new CustomResponsedMessage<>(2016550, adVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.cRY.i(this.cRX.apy(), this.cRX.apz());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.cRX.apw();
    }

    public View aoT() {
        return this.cRX.aoT();
    }

    public void am(View view) {
        this.cRX.am(view);
    }

    private void aoU() {
        this.cRW.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cRX == null || !a.this.cRX.aow()) {
                    if (!a.this.isChanged()) {
                        a.this.aoS();
                    } else {
                        a.this.aoV();
                    }
                    if (a.this.cSe) {
                        a.this.cRX.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.cRW.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cRX.apw();
                if (a.this.isChanged()) {
                    if (a.this.cRX.isEmpty()) {
                        a.this.cRX.ao(a.this.mRootView);
                        return;
                    } else {
                        a.this.cRX.apv();
                        a.this.cRY.aR(a.this.cRX.apy());
                    }
                }
                if (a.this.cSe) {
                    a.this.cRX.startPullRefresh();
                }
            }
        });
    }

    public void aoV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bml.getPageContext().getPageActivity());
        aVar.cc(d.k.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.k.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.aoS();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cd(d.C0141d.cp_cont_b);
        aVar.b(this.bml.getPageContext());
        aVar.xa();
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bml.getPageContext().getPageActivity());
            aVar.dB(String.format(this.bml.getPageContext().getString(d.k.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.k.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.jU()) {
                        a.this.bml.showToast(d.k.delete_like_fail);
                    } else {
                        new C0144a(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.bml.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cd(d.C0141d.cp_cont_b);
            aVar.b(this.bml.getPageContext());
            aVar.xa();
        }
    }

    public void fc(boolean z) {
        if (this.mWaitingDialog == null) {
            aoW();
        }
        this.mWaitingDialog.aM(z);
    }

    private void aoW() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.bml.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bml.getActivity()).inflate(d.i.enter_forum_view, (ViewGroup) null);
        this.cRX = new com.baidu.tieba.enterForum.view.a(this.cRW, this.mRootView, this.cRe, this.cRZ);
        this.cRX.a(this.awh);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fd(boolean z) {
        if (this.cRX != null && this.cRW != null) {
            if (z) {
                if (this.cRW.isPrimary() && this.cRW.isResumed()) {
                    this.cRX.startPullRefresh();
                    return;
                } else {
                    this.cRX.nW();
                    return;
                }
            }
            this.cRX.nW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cRW.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.cRX != null) {
            if (bVar == null) {
                this.cRX.ao(this.mRootView);
                return;
            }
            g aoz = bVar.aoz();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (aoz != null) {
                arrayList = aoz.aoE();
            }
            aP(arrayList);
            if (b(bVar)) {
                this.cRX.aW(bVar.aoA());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aoC() != null) {
                setSearchHint(hotSearchInfoData.aoC());
            }
            this.cRX.apA();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.aoz() == null || w.z(bVar.aoz().aoE())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.cRX.setSearchHint(str.trim());
        } else {
            this.cRX.setSearchHint(this.bml.getActivity().getString(d.k.enter_forum_search_tip));
        }
    }

    private void aP(List<com.baidu.tieba.enterForum.data.f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.cRX.aV(this.cRY.a(list, com.baidu.tbadk.util.c.KR()));
        }
    }

    public void So() {
        if (this.cRX != null) {
            fe(false);
        }
    }

    public void onDestroy() {
        IN();
        com.baidu.tieba.enterForum.model.a.apd().destroy();
        if (this.cRX != null) {
            if (this.cRY != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cRY.aR(this.cRX.apy());
            }
            this.cRX.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016550);
        if (this.cRZ != null) {
            this.cRZ.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cRX != null) {
            this.cRX.onChangeSkinType(i);
        }
    }

    public void IN() {
        if (this.cRY != null) {
            this.cRY.cancelLoadData();
        }
    }

    public void fe(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cSg && this.cRY != null && this.cRX != null) {
            String str = this.cSc;
            this.cSc = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cSc == null || this.cSc.equals(str)) {
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
                if (this.cRY != null && this.cRY.apm() != null && this.cRY.apm().aoz() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.cRY.apm().aoz().aoE().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.jy(1);
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
                this.cRX.notifyDataSetChanged();
            }
            if (z2 || z4) {
                IN();
                if (z4) {
                    this.cRY.fg(StringUtils.isNull(this.cSc) ? false : true);
                } else if (z2) {
                    this.cRY.fh(!StringUtils.isNull(this.cSc));
                    this.cRY.fg(StringUtils.isNull(this.cSc) ? false : true);
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
        if (this.cRZ != null) {
            this.cRZ.onPrimary();
        }
    }

    public void onPause() {
        if (this.cRX != null && this.cRX.apu() != null) {
            this.cRX.apu().completePullRefresh();
        }
        if (this.cRZ != null) {
            this.cRZ.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0144a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f cSq;
        private y mNetwork = null;

        public C0144a(com.baidu.tieba.enterForum.data.f fVar) {
            this.cSq = null;
            this.cSq = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.cSq;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.o(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.o("kw", fVar.getName());
                        this.mNetwork.yJ().zI().mIsNeedTbs = true;
                        this.mNetwork.yl();
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
            super.onPostExecute((C0144a) str);
            a.this.fc(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                    a.this.cSe = true;
                    if (a.this.cRW.isAdded() && a.this.bml != null) {
                        a.this.bml.showToast(a.this.bml.getActivity().getString(d.k.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.i(false, this.cSq.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.cSq.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cSq.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.cSq.getName()));
                    }
                    a.this.cRX.b(this.cSq);
                } else if (a.this.bml != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.bml.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.cRW.isAdded()) {
                        a.this.bml.showToast(a.this.bml.getActivity().getString(d.k.delete_like_fail));
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
                    com.baidu.tieba.im.settingcache.d.aLP().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Jl = bVar.Jl();
        com.baidu.tbadk.mvc.b.a Jm = bVar.Jm();
        switch (Jl) {
            case 1:
                if (this.cSf != 2 && (Jm instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) Jm).getName();
                    if (ao.bc(name)) {
                        this.bml.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bml.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        if (this.bml.getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        List<com.baidu.tieba.enterForum.data.f> apy = this.cRX.apy();
                        if (!w.z(apy)) {
                            if (w.y(apy) > 1 && apy.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < apy.size()) {
                                    if (!apy.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new am("c12049").ah("obj_type", "2").r("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.cSf == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.cRX.jB(Jm instanceof h ? ((h) Jm).getPosition() : 0);
                this.cSe = false;
                if (this.cRW.getView() == null || this.cRW.getView().getParent() == null) {
                    return true;
                }
                this.cRW.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Jm instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) Jm);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bml.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bml.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.bml.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bml.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("c10378").ah("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").ah("obj_type", "2").r("obj_locate", 1));
                this.bml.finish();
                return true;
            case 9:
                if (this.cRX != null) {
                    this.cRX.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.cSf = 2;
                return true;
            case 11:
                this.cSf = 1;
                return true;
        }
    }

    public void aoX() {
        if (this.cRX != null) {
            this.cRX.apx();
        }
    }

    public boolean aoY() {
        if (this.cRX != null) {
            return this.cRX.aoY();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Jk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bml.getUniqueId();
    }

    public void ff(boolean z) {
        int i = 0;
        if (this.cRX != null && this.cRW != null) {
            boolean z2 = this.cRX.aoY() && this.cRW.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.cRX.aow()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
