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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
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
    private BaseFragmentActivity bea;
    private LikeModel bmW;
    private EnterForumFragment cHK;
    private EnterForumModel cHM;
    private RecentlyVisitedForumModel cHN;
    private boolean cHO;
    private String cHQ;
    private long cHR;
    private boolean cHS;
    private boolean cHU;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a cHL = null;
    private boolean cHP = false;
    private int cHT = 1;
    private CustomMessageListener cHV = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cHP = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a cHW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.cHM.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.cHL.lh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bea.getResources().getString(d.k.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bea.showToast(errorString);
                    if (a.this.cHL.isEmpty()) {
                        a.this.cHL.ao(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.cHM.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.cHM.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener cHX = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cHU = true;
        }
    };
    private com.baidu.adp.base.d cHY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.tu(a.this.bmW.getErrorCode())) {
                AntiHelper.am(a.this.bea.getPageContext().getPageActivity(), a.this.bmW.getErrorString());
            } else if (obj != null) {
                a.this.cHM.fb(!StringUtils.isNull(a.this.cHQ));
            } else if (!StringUtils.isNull(a.this.bmW.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.bmW.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cHZ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.cHK.isAdded()) {
                if (aVar.type == 1) {
                    a.this.cHL.lh();
                }
                if (aVar.cIG) {
                    if (aVar.type == 1) {
                        a.this.cHO = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.cIH);
                    } else if (aVar.type == 0 && !a.this.cHO) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.cIH;
                        a.this.cHM.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.bea.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.cHR > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.cHR, a.this.cHM.alf() - a.this.cHR, a.this.cHM.ald(), a.this.cHM.ale(), currentTimeMillis - a.this.cHM.alc());
                    a.this.cHR = -1L;
                }
                if (aVar.cIH == null || aVar.cIH.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.bea.getResources().getString(d.k.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.cIH.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.akw() != null) {
                    a.this.setSearchHint(hotSearchInfoData.akw());
                }
            }
        }
    };
    private e.b anZ = new e.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            a.this.cHM.fb(!StringUtils.isNull(a.this.cHQ));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cGR = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Pm();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.cHM = null;
        this.isFirst = true;
        this.cHO = false;
        this.cHR = -1L;
        this.cHK = enterForumFragment;
        this.bea = enterForumFragment.getBaseFragmentActivity();
        this.cGR.addEventDelegate(this);
        this.cHR = System.currentTimeMillis();
        this.isFirst = true;
        this.cHO = false;
        this.cHQ = "";
        this.cHM = new EnterForumModel(this.bea.getPageContext());
        this.cHN = new RecentlyVisitedForumModel();
        this.bmW = new LikeModel(this.bea.getPageContext());
        this.bmW.setLoadDataCallBack(this.cHY);
        this.cHM.a(this.cHZ);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.akX().k(this.cHK.getFragmentActivity(), l.p(this.cHK.getFragmentActivity()));
        initUI();
        initListener();
        akL();
    }

    private void initListener() {
        akO();
        this.cHK.registerListener(this.cHX);
        this.cHK.registerListener(this.cHW);
        this.cHK.registerListener(this.cHV);
    }

    private static void Pm() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void akL() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016550, new CustomMessageTask.CustomRunnable<ad>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ad> run(CustomMessage<ad> customMessage) {
                ad adVar = new ad();
                ArrayList arrayList = new ArrayList();
                if (a.this.cHM != null && a.this.cHM.alg() != null && a.this.cHM.alg().akt() != null && v.v(a.this.cHM.alg().akt().aky()) > 0) {
                    Iterator<f> it = a.this.cHM.alg().akt().aky().iterator();
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
                    adVar.q(arrayList);
                }
                return new CustomResponsedMessage<>(2016550, adVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.cHM.h(this.cHL.als(), this.cHL.alt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.cHL.alq();
    }

    public View akN() {
        return this.cHL.akN();
    }

    public void am(View view2) {
        this.cHL.am(view2);
    }

    private void akO() {
        this.cHK.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cHL == null || !a.this.cHL.akq()) {
                    if (!a.this.isChanged()) {
                        a.this.akM();
                    } else {
                        a.this.akP();
                    }
                    if (a.this.cHS) {
                        a.this.cHL.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.cHK.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cHL.alq();
                if (a.this.isChanged()) {
                    if (a.this.cHL.isEmpty()) {
                        a.this.cHL.ao(a.this.mRootView);
                        return;
                    } else {
                        a.this.cHL.alp();
                        a.this.cHM.aL(a.this.cHL.als());
                    }
                }
                if (a.this.cHS) {
                    a.this.cHL.startPullRefresh();
                }
            }
        });
    }

    public void akP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bea.getPageContext().getPageActivity());
        aVar.ca(d.k.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.k.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.akM();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cb(d.C0126d.cp_cont_b);
        aVar.b(this.bea.getPageContext());
        aVar.tD();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bea.getPageContext().getPageActivity());
            aVar.dc(String.format(this.bea.getPageContext().getString(d.k.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.k.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.hg()) {
                        a.this.bea.showToast(d.k.delete_like_fail);
                    } else {
                        new C0129a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.bea.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cb(d.C0126d.cp_cont_b);
            aVar.b(this.bea.getPageContext());
            aVar.tD();
        }
    }

    public void eX(boolean z) {
        if (this.mWaitingDialog == null) {
            akQ();
        }
        this.mWaitingDialog.aI(z);
    }

    private void akQ() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.bea.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bea.getActivity()).inflate(d.i.enter_forum_view, (ViewGroup) null);
        this.cHL = new com.baidu.tieba.enterForum.view.a(this.cHK, this.mRootView, this.cGR, this.cHN);
        this.cHL.a(this.anZ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eY(boolean z) {
        if (this.cHL != null && this.cHK != null) {
            if (z) {
                if (this.cHK.isPrimary() && this.cHK.isResumed()) {
                    this.cHL.startPullRefresh();
                    return;
                } else {
                    this.cHL.lh();
                    return;
                }
            }
            this.cHL.lh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cHK.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.cHL != null) {
            if (bVar == null) {
                this.cHL.ao(this.mRootView);
                return;
            }
            g akt = bVar.akt();
            ArrayList<f> arrayList = new ArrayList<>();
            if (akt != null) {
                arrayList = akt.aky();
            }
            aJ(arrayList);
            if (b(bVar)) {
                this.cHL.aQ(bVar.aku());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.akw() != null) {
                setSearchHint(hotSearchInfoData.akw());
            }
            this.cHL.alu();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.akt() == null || v.w(bVar.akt().aky())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.cHL.setSearchHint(str.trim());
        } else {
            this.cHL.setSearchHint(this.bea.getActivity().getString(d.k.enter_forum_search_tip));
        }
    }

    private void aJ(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.cHL.aP(this.cHM.a(list, com.baidu.tbadk.util.c.Hz()));
        }
    }

    public void OT() {
        if (this.cHL != null) {
            eZ(false);
        }
    }

    public void onDestroy() {
        Fk();
        com.baidu.tieba.enterForum.model.a.akX().destroy();
        if (this.cHL != null) {
            if (this.cHM != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cHM.aL(this.cHL.als());
            }
            this.cHL.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016550);
        if (this.cHN != null) {
            this.cHN.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cHL != null) {
            this.cHL.onChangeSkinType(i);
        }
    }

    public void Fk() {
        if (this.cHM != null) {
            this.cHM.cancelLoadData();
        }
    }

    public void eZ(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cHU && this.cHM != null && this.cHL != null) {
            String str = this.cHQ;
            this.cHQ = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cHQ == null || this.cHQ.equals(str)) {
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
                if (this.cHM != null && this.cHM.alg() != null && this.cHM.alg().akt() != null) {
                    Iterator<f> it = this.cHM.alg().akt().aky().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.jx(1);
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
                    com.baidu.tieba.tbadkCore.util.a.sW(currentAccount);
                }
                this.cHL.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Fk();
                if (z4) {
                    this.cHM.fb(StringUtils.isNull(this.cHQ) ? false : true);
                } else if (z2) {
                    this.cHM.fc(!StringUtils.isNull(this.cHQ));
                    this.cHM.fb(StringUtils.isNull(this.cHQ) ? false : true);
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
        if (this.cHN != null) {
            this.cHN.onPrimary();
        }
    }

    public void onPause() {
        if (this.cHL != null && this.cHL.alo() != null) {
            this.cHL.alo().completePullRefresh();
        }
        if (this.cHN != null) {
            this.cHN.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0129a extends BdAsyncTask<f, Integer, String> {
        private f cIe;
        private x mNetwork = null;

        public C0129a(f fVar) {
            this.cIe = null;
            this.cIe = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.cIe;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.vj().wi().mIsNeedTbs = true;
                        this.mNetwork.uL();
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
            super.onPostExecute((C0129a) str);
            a.this.eX(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.vj().wj().isRequestSuccess()) {
                    a.this.cHS = true;
                    if (a.this.cHK.isAdded() && a.this.bea != null) {
                        a.this.bea.showToast(a.this.bea.getActivity().getString(d.k.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.h(false, this.cIe.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.cIe.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cIe.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.cIe.getName()));
                    }
                    a.this.cHL.b(this.cIe);
                } else if (a.this.bea != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.bea.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.cHK.isAdded()) {
                        a.this.bea.showToast(a.this.bea.getActivity().getString(d.k.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.eX(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
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
                    com.baidu.tieba.im.settingcache.d.aGW().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int FF = bVar.FF();
        com.baidu.tbadk.mvc.b.a FG = bVar.FG();
        switch (FF) {
            case 1:
                if (this.cHT != 2 && (FG instanceof f)) {
                    String name = ((f) FG).getName();
                    if (an.aQ(name)) {
                        this.bea.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bea.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        if (this.bea.getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new al("c12888"));
                        }
                        List<f> als = this.cHL.als();
                        if (!v.w(als)) {
                            if (v.v(als) > 1 && als.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < als.size()) {
                                    if (!als.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new al("c12049").ac("obj_type", "2").r("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.cHT == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.cHL.jA(FG instanceof h ? ((h) FG).getPosition() : 0);
                this.cHS = false;
                if (this.cHK.getView() == null || this.cHK.getView().getParent() == null) {
                    return true;
                }
                this.cHK.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (FG instanceof f) {
                    a((f) FG);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bea.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bea.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new al("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.bea.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bea.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new al("c10378").ac("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new al("c12049").ac("obj_type", "2").r("obj_locate", 1));
                this.bea.finish();
                return true;
            case 9:
                if (this.cHL != null) {
                    this.cHL.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.cHT = 2;
                return true;
            case 11:
                this.cHT = 1;
                return true;
        }
    }

    public void akR() {
        if (this.cHL != null) {
            this.cHL.alr();
        }
    }

    public boolean akS() {
        if (this.cHL != null) {
            return this.cHL.akS();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean FE() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bea.getUniqueId();
    }

    public void fa(boolean z) {
        int i = 0;
        if (this.cHL != null && this.cHK != null) {
            boolean z2 = this.cHL.akS() && this.cHK.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.cHL.akq()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
