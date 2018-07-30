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
    private LikeModel azq;
    private BaseFragmentActivity boq;
    private EnterForumFragment cSG;
    private EnterForumModel cSI;
    private RecentlyVisitedForumModel cSJ;
    private boolean cSK;
    private String cSM;
    private long cSN;
    private boolean cSO;
    private boolean cSQ;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a cSH = null;
    private boolean cSL = false;
    private int cSP = 1;
    private CustomMessageListener cSR = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cSL = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a cSS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.cSI.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.cSH.nY();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.boq.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.boq.showToast(errorString);
                    if (a.this.cSH.isEmpty()) {
                        a.this.cSH.at(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.cSI.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.cSI.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener cST = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cSQ = true;
        }
    };
    private com.baidu.adp.base.d cSU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (AntiHelper.al(a.this.azq.getErrorCode(), a.this.azq.getErrorString())) {
                AntiHelper.aq(a.this.boq.getPageContext().getPageActivity(), a.this.azq.getErrorString());
            } else if (obj != null) {
                a.this.cSI.fh(!StringUtils.isNull(a.this.cSM));
            } else if (!StringUtils.isNull(a.this.azq.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.azq.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cSV = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.cSG.isAdded()) {
                if (aVar.type == 1) {
                    a.this.cSH.nY();
                }
                if (aVar.cTD) {
                    if (aVar.type == 1) {
                        a.this.cSK = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.cTE);
                    } else if (aVar.type == 0 && !a.this.cSK) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.cTE;
                        a.this.cSI.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.boq.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.cSN > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.cSN, a.this.cSI.apf() - a.this.cSN, a.this.cSI.apd(), a.this.cSI.ape(), currentTimeMillis - a.this.cSI.apc());
                    a.this.cSN = -1L;
                }
                if (aVar.cTE == null || aVar.cTE.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.boq.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.cTE.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.aov() != null) {
                    a.this.setSearchHint(hotSearchInfoData.aov());
                }
            }
        }
    };
    private g.b aww = new g.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.g.b
        public void aS(boolean z) {
            a.this.cSI.fh(!StringUtils.isNull(a.this.cSM));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cRI = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Tl();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.cSI = null;
        this.isFirst = true;
        this.cSK = false;
        this.cSN = -1L;
        this.cSG = enterForumFragment;
        this.boq = enterForumFragment.getBaseFragmentActivity();
        this.cRI.addEventDelegate(this);
        this.cSN = System.currentTimeMillis();
        this.isFirst = true;
        this.cSK = false;
        this.cSM = "";
        this.cSI = new EnterForumModel(this.boq.getPageContext());
        this.cSJ = new RecentlyVisitedForumModel();
        this.azq = new LikeModel(this.boq.getPageContext());
        this.azq.setLoadDataCallBack(this.cSU);
        this.cSI.a(this.cSV);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aoY().l(this.cSG.getFragmentActivity(), l.o(this.cSG.getFragmentActivity()));
        initUI();
        initListener();
        aoM();
    }

    private void initListener() {
        aoP();
        this.cSG.registerListener(this.cST);
        this.cSG.registerListener(this.cSS);
        this.cSG.registerListener(this.cSR);
    }

    private static void Tl() {
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
                if (a.this.cSI != null && a.this.cSI.apg() != null && a.this.cSI.apg().aos() != null && w.y(a.this.cSI.apg().aos().aoy()) > 0) {
                    Iterator<f> it = a.this.cSI.apg().aos().aoy().iterator();
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
        return !this.cSI.i(this.cSH.apt(), this.cSH.apu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.cSH.apr();
    }

    public View aoO() {
        return this.cSH.aoO();
    }

    public void ar(View view) {
        this.cSH.ar(view);
    }

    private void aoP() {
        this.cSG.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cSH == null || !a.this.cSH.aop()) {
                    if (!a.this.isChanged()) {
                        a.this.aoN();
                    } else {
                        a.this.aoQ();
                    }
                    if (a.this.cSO) {
                        a.this.cSH.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.cSG.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cSH.apr();
                if (a.this.isChanged()) {
                    if (a.this.cSH.isEmpty()) {
                        a.this.cSH.at(a.this.mRootView);
                        return;
                    } else {
                        a.this.cSH.apq();
                        a.this.cSI.aR(a.this.cSH.apt());
                    }
                }
                if (a.this.cSO) {
                    a.this.cSH.startPullRefresh();
                }
            }
        });
    }

    public void aoQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.boq.getPageContext().getPageActivity());
        aVar.cf(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.aoN();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cg(d.C0140d.cp_cont_b);
        aVar.b(this.boq.getPageContext());
        aVar.xf();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.boq.getPageContext().getPageActivity());
            aVar.dB(String.format(this.boq.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.jV()) {
                        a.this.boq.showToast(d.j.delete_like_fail);
                    } else {
                        new C0143a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.boq.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cg(d.C0140d.cp_cont_b);
            aVar.b(this.boq.getPageContext());
            aVar.xf();
        }
    }

    public void fd(boolean z) {
        if (this.mWaitingDialog == null) {
            aoR();
        }
        this.mWaitingDialog.aM(z);
    }

    private void aoR() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.boq.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.boq.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.cSH = new com.baidu.tieba.enterForum.view.a(this.cSG, this.mRootView, this.cRI, this.cSJ);
        this.cSH.a(this.aww);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fe(boolean z) {
        if (this.cSH != null && this.cSG != null) {
            if (z) {
                if (this.cSG.isPrimary() && this.cSG.isResumed()) {
                    this.cSH.startPullRefresh();
                    return;
                } else {
                    this.cSH.nY();
                    return;
                }
            }
            this.cSH.nY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cSG.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.cSH != null) {
            if (bVar == null) {
                this.cSH.at(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g aos = bVar.aos();
            ArrayList<f> arrayList = new ArrayList<>();
            if (aos != null) {
                arrayList = aos.aoy();
            }
            aP(arrayList);
            if (b(bVar)) {
                this.cSH.aW(bVar.aot());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aov() != null) {
                setSearchHint(hotSearchInfoData.aov());
            }
            this.cSH.apv();
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
            this.cSH.setSearchHint(str.trim());
        } else {
            this.cSH.setSearchHint(this.boq.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void aP(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.cSH.aV(this.cSI.a(list, com.baidu.tbadk.util.c.Le()));
        }
    }

    public void SS() {
        if (this.cSH != null) {
            ff(false);
        }
    }

    public void onDestroy() {
        Ja();
        com.baidu.tieba.enterForum.model.a.aoY().destroy();
        if (this.cSH != null) {
            if (this.cSI != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cSI.aR(this.cSH.apt());
            }
            this.cSH.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016550);
        if (this.cSJ != null) {
            this.cSJ.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cSH != null) {
            this.cSH.onChangeSkinType(i);
        }
    }

    public void Ja() {
        if (this.cSI != null) {
            this.cSI.cancelLoadData();
        }
    }

    public void ff(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cSQ && this.cSI != null && this.cSH != null) {
            String str = this.cSM;
            this.cSM = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cSM == null || this.cSM.equals(str)) {
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
                if (this.cSI != null && this.cSI.apg() != null && this.cSI.apg().aos() != null) {
                    Iterator<f> it = this.cSI.apg().aos().aoy().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.jI(1);
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
                    com.baidu.tieba.tbadkCore.util.a.tR(currentAccount);
                }
                this.cSH.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ja();
                if (z4) {
                    this.cSI.fh(StringUtils.isNull(this.cSM) ? false : true);
                } else if (z2) {
                    this.cSI.fi(!StringUtils.isNull(this.cSM));
                    this.cSI.fh(StringUtils.isNull(this.cSM) ? false : true);
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
        if (this.cSJ != null) {
            this.cSJ.onPrimary();
        }
    }

    public void onPause() {
        if (this.cSH != null && this.cSH.app() != null) {
            this.cSH.app().completePullRefresh();
        }
        if (this.cSJ != null) {
            this.cSJ.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0143a extends BdAsyncTask<f, Integer, String> {
        private f cTa;
        private y mNetwork = null;

        public C0143a(f fVar) {
            this.cTa = null;
            this.cTa = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.cTa;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.o(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.o("kw", fVar.getName());
                        this.mNetwork.yO().zM().mIsNeedTbs = true;
                        this.mNetwork.yq();
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
            a.this.fd(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.yO().zN().isRequestSuccess()) {
                    a.this.cSO = true;
                    if (a.this.cSG.isAdded() && a.this.boq != null) {
                        a.this.boq.showToast(a.this.boq.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.i(false, this.cTa.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.cTa.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cTa.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.cTa.getName()));
                    }
                    a.this.cSH.b(this.cTa);
                } else if (a.this.boq != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.boq.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.cSG.isAdded()) {
                        a.this.boq.showToast(a.this.boq.getActivity().getString(d.j.delete_like_fail));
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
    public void i(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aNv().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Jy = bVar.Jy();
        com.baidu.tbadk.mvc.b.a Jz = bVar.Jz();
        switch (Jy) {
            case 1:
                if (this.cSP != 2 && (Jz instanceof f)) {
                    String name = ((f) Jz).getName();
                    if (ap.bf(name)) {
                        this.boq.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.boq.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.boq.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        List<f> apt = this.cSH.apt();
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
                        TiebaStatic.log(new an("c12049").af("obj_type", "2").r("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.cSP == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.cSH.jL(Jz instanceof h ? ((h) Jz).getPosition() : 0);
                this.cSO = false;
                if (this.cSG.getView() == null || this.cSG.getView().getParent() == null) {
                    return true;
                }
                this.cSG.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Jz instanceof f) {
                    a((f) Jz);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.boq.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.boq.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.boq.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.boq.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c10378").af("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new an("c12049").af("obj_type", "2").r("obj_locate", 1));
                this.boq.finish();
                return true;
            case 9:
                if (this.cSH != null) {
                    this.cSH.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.cSP = 2;
                return true;
            case 11:
                this.cSP = 1;
                return true;
        }
    }

    public void aoS() {
        if (this.cSH != null) {
            this.cSH.aps();
        }
    }

    public boolean aoT() {
        if (this.cSH != null) {
            return this.cSH.aoT();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Jx() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.boq.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cSH != null) {
            this.cSH.setPageUniqueId(bdUniqueId);
        }
    }

    public void fg(boolean z) {
        int i = 0;
        if (this.cSH != null && this.cSG != null) {
            boolean z2 = this.cSH.aoT() && this.cSG.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.cSH.aop()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
