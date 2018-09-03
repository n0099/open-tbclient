package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.f;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel azn;
    private BaseFragmentActivity bos;
    private EnterForumFragment cSD;
    private EnterForumModel cSF;
    private RecentlyVisitedForumModel cSG;
    private boolean cSH;
    private String cSJ;
    private long cSK;
    private boolean cSL;
    private boolean cSN;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a cSE = null;
    private boolean cSI = false;
    private int cSM = 1;
    private CustomMessageListener cSO = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cSI = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a cSP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.cSF.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.cSE.nV();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bos.getResources().getString(f.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bos.showToast(errorString);
                    if (a.this.cSE.isEmpty()) {
                        a.this.cSE.at(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.cSF.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.cSF.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener cSQ = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cSN = true;
        }
    };
    private d cSR = new d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (AntiHelper.al(a.this.azn.getErrorCode(), a.this.azn.getErrorString())) {
                AntiHelper.aq(a.this.bos.getPageContext().getPageActivity(), a.this.azn.getErrorString());
            } else if (obj != null) {
                a.this.cSF.fh(!StringUtils.isNull(a.this.cSJ));
            } else if (!StringUtils.isNull(a.this.azn.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.azn.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cSS = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.cSD.isAdded()) {
                if (aVar.type == 1) {
                    a.this.cSE.nV();
                }
                if (aVar.cTz) {
                    if (aVar.type == 1) {
                        a.this.cSH = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.cTA);
                    } else if (aVar.type == 0 && !a.this.cSH) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.cTA;
                        a.this.cSF.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.bos.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.cSK > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.cSK, a.this.cSF.apf() - a.this.cSK, a.this.cSF.apd(), a.this.cSF.ape(), currentTimeMillis - a.this.cSF.apc());
                    a.this.cSK = -1L;
                }
                if (aVar.cTA == null || aVar.cTA.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.bos.getResources().getString(f.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.cTA.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.aov() != null) {
                    a.this.setSearchHint(hotSearchInfoData.aov());
                }
            }
        }
    };
    private g.b awt = new g.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.g.b
        public void aT(boolean z) {
            a.this.cSF.fh(!StringUtils.isNull(a.this.cSJ));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cRF = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        To();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.cSF = null;
        this.isFirst = true;
        this.cSH = false;
        this.cSK = -1L;
        this.cSD = enterForumFragment;
        this.bos = enterForumFragment.getBaseFragmentActivity();
        this.cRF.addEventDelegate(this);
        this.cSK = System.currentTimeMillis();
        this.isFirst = true;
        this.cSH = false;
        this.cSJ = "";
        this.cSF = new EnterForumModel(this.bos.getPageContext());
        this.cSG = new RecentlyVisitedForumModel();
        this.azn = new LikeModel(this.bos.getPageContext());
        this.azn.setLoadDataCallBack(this.cSR);
        this.cSF.a(this.cSS);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aoY().l(this.cSD.getFragmentActivity(), l.n(this.cSD.getFragmentActivity()));
        initUI();
        initListener();
        aoM();
    }

    private void initListener() {
        aoP();
        this.cSD.registerListener(this.cSQ);
        this.cSD.registerListener(this.cSP);
        this.cSD.registerListener(this.cSO);
    }

    private static void To() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aoM() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016550, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (a.this.cSF != null && a.this.cSF.apg() != null && a.this.cSF.apg().aos() != null && w.y(a.this.cSF.apg().aos().aoy()) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = a.this.cSF.apg().aos().aoy().iterator();
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
        return !this.cSF.i(this.cSE.apt(), this.cSE.apu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.cSE.apr();
    }

    public View aoO() {
        return this.cSE.aoO();
    }

    public void ar(View view) {
        this.cSE.ar(view);
    }

    private void aoP() {
        this.cSD.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cSE == null || !a.this.cSE.aop()) {
                    if (!a.this.isChanged()) {
                        a.this.aoN();
                    } else {
                        a.this.aoQ();
                    }
                    if (a.this.cSL) {
                        a.this.cSE.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.cSD.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cSE.apr();
                if (a.this.isChanged()) {
                    if (a.this.cSE.isEmpty()) {
                        a.this.cSE.at(a.this.mRootView);
                        return;
                    } else {
                        a.this.cSE.apq();
                        a.this.cSF.aR(a.this.cSE.apt());
                    }
                }
                if (a.this.cSL) {
                    a.this.cSE.startPullRefresh();
                }
            }
        });
    }

    public void aoQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bos.getPageContext().getPageActivity());
        aVar.cf(f.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(f.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.aoN();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cg(f.d.cp_cont_b);
        aVar.b(this.bos.getPageContext());
        aVar.xe();
    }

    public void a(final com.baidu.tieba.enterForum.data.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bos.getPageContext().getPageActivity());
            aVar.dB(String.format(this.bos.getPageContext().getString(f.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(f.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.jV()) {
                        a.this.bos.showToast(f.j.delete_like_fail);
                    } else {
                        new C0142a(fVar).execute(new com.baidu.tieba.enterForum.data.f[0]);
                    }
                    TiebaStatic.eventStat(a.this.bos.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cg(f.d.cp_cont_b);
            aVar.b(this.bos.getPageContext());
            aVar.xe();
        }
    }

    public void fd(boolean z) {
        if (this.mWaitingDialog == null) {
            aoR();
        }
        this.mWaitingDialog.aN(z);
    }

    private void aoR() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.bos.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bos.getActivity()).inflate(f.h.enter_forum_view, (ViewGroup) null);
        this.cSE = new com.baidu.tieba.enterForum.view.a(this.cSD, this.mRootView, this.cRF, this.cSG);
        this.cSE.a(this.awt);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fe(boolean z) {
        if (this.cSE != null && this.cSD != null) {
            if (z) {
                if (this.cSD.isPrimary() && this.cSD.isResumed()) {
                    this.cSE.startPullRefresh();
                    return;
                } else {
                    this.cSE.nV();
                    return;
                }
            }
            this.cSE.nV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cSD.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.cSE != null) {
            if (bVar == null) {
                this.cSE.at(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g aos = bVar.aos();
            ArrayList<com.baidu.tieba.enterForum.data.f> arrayList = new ArrayList<>();
            if (aos != null) {
                arrayList = aos.aoy();
            }
            aP(arrayList);
            if (b(bVar)) {
                this.cSE.aW(bVar.aot());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aov() != null) {
                setSearchHint(hotSearchInfoData.aov());
            }
            this.cSE.apv();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.aos() == null || w.z(bVar.aos().aoy())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.cSE.setSearchHint(str.trim());
        } else {
            this.cSE.setSearchHint(this.bos.getActivity().getString(f.j.enter_forum_search_tip));
        }
    }

    private void aP(List<com.baidu.tieba.enterForum.data.f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.cSE.aV(this.cSF.a(list, com.baidu.tbadk.util.c.Li()));
        }
    }

    public void loadData() {
        if (this.cSE != null) {
            ff(false);
        }
    }

    public void onDestroy() {
        Ja();
        com.baidu.tieba.enterForum.model.a.aoY().destroy();
        if (this.cSE != null) {
            if (this.cSF != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cSF.aR(this.cSE.apt());
            }
            this.cSE.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016550);
        if (this.cSG != null) {
            this.cSG.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cSE != null) {
            this.cSE.onChangeSkinType(i);
        }
    }

    public void Ja() {
        if (this.cSF != null) {
            this.cSF.cancelLoadData();
        }
    }

    public void ff(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cSN && this.cSF != null && this.cSE != null) {
            String str = this.cSJ;
            this.cSJ = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cSJ == null || this.cSJ.equals(str)) {
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
                if (this.cSF != null && this.cSF.apg() != null && this.cSF.apg().aos() != null) {
                    Iterator<com.baidu.tieba.enterForum.data.f> it = this.cSF.apg().aos().aoy().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.jH(1);
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
                    com.baidu.tieba.tbadkCore.util.a.tV(currentAccount);
                }
                this.cSE.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ja();
                if (z4) {
                    this.cSF.fh(StringUtils.isNull(this.cSJ) ? false : true);
                } else if (z2) {
                    this.cSF.fi(!StringUtils.isNull(this.cSJ));
                    this.cSF.fh(StringUtils.isNull(this.cSJ) ? false : true);
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
        if (this.cSG != null) {
            this.cSG.onPrimary();
        }
    }

    public void onPause() {
        if (this.cSE != null && this.cSE.app() != null) {
            this.cSE.app().completePullRefresh();
        }
        if (this.cSG != null) {
            this.cSG.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0142a extends BdAsyncTask<com.baidu.tieba.enterForum.data.f, Integer, String> {
        private com.baidu.tieba.enterForum.data.f cSX;
        private y mNetwork = null;

        public C0142a(com.baidu.tieba.enterForum.data.f fVar) {
            this.cSX = null;
            this.cSX = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.data.f... fVarArr) {
            com.baidu.tieba.enterForum.data.f fVar = this.cSX;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.o(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.o("kw", fVar.getName());
                        this.mNetwork.yM().zK().mIsNeedTbs = true;
                        this.mNetwork.yo();
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
            super.onPostExecute((C0142a) str);
            a.this.fd(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.yM().zL().isRequestSuccess()) {
                    a.this.cSL = true;
                    if (a.this.cSD.isAdded() && a.this.bos != null) {
                        a.this.bos.showToast(a.this.bos.getActivity().getString(f.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.h(false, this.cSX.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.cSX.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cSX.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.cSX.getName()));
                    }
                    a.this.cSE.b(this.cSX);
                } else if (a.this.bos != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.bos.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.cSD.isAdded()) {
                        a.this.bos.showToast(a.this.bos.getActivity().getString(f.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.fd(true);
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
    public void h(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aNs().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int JC = bVar.JC();
        com.baidu.tbadk.mvc.b.a JD = bVar.JD();
        switch (JC) {
            case 1:
                if (this.cSM != 2 && (JD instanceof com.baidu.tieba.enterForum.data.f)) {
                    String name = ((com.baidu.tieba.enterForum.data.f) JD).getName();
                    if (ap.bf(name)) {
                        this.bos.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bos.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.bos.getResources().getString(f.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        List<com.baidu.tieba.enterForum.data.f> apt = this.cSE.apt();
                        if (!w.z(apt)) {
                            if (w.y(apt) > 1 && apt.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < apt.size()) {
                                    if (!apt.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new an("c12049").ae("obj_type", "2").r("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.cSM == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.cSE.jK(JD instanceof h ? ((h) JD).getPosition() : 0);
                this.cSL = false;
                if (this.cSD.getView() == null || this.cSD.getView().getParent() == null) {
                    return true;
                }
                this.cSD.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (JD instanceof com.baidu.tieba.enterForum.data.f) {
                    a((com.baidu.tieba.enterForum.data.f) JD);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bos.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bos.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.bos.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bos.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c10378").ae("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new an("c12049").ae("obj_type", "2").r("obj_locate", 1));
                this.bos.finish();
                return true;
            case 9:
                if (this.cSE != null) {
                    this.cSE.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.cSM = 2;
                return true;
            case 11:
                this.cSM = 1;
                return true;
        }
    }

    public void aoS() {
        if (this.cSE != null) {
            this.cSE.aps();
        }
    }

    public boolean aoT() {
        if (this.cSE != null) {
            return this.cSE.aoT();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean JB() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bos.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cSE != null) {
            this.cSE.setPageUniqueId(bdUniqueId);
        }
    }

    public void fg(boolean z) {
        int i = 0;
        if (this.cSE != null && this.cSD != null) {
            boolean z2 = this.cSE.aoT() && this.cSD.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.cSE.aop()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
