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
    private BaseFragmentActivity beb;
    private LikeModel bnl;
    private EnterForumFragment cIQ;
    private EnterForumModel cIS;
    private RecentlyVisitedForumModel cIT;
    private boolean cIU;
    private String cIW;
    private long cIX;
    private boolean cIY;
    private boolean cJa;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a cIR = null;
    private boolean cIV = false;
    private int cIZ = 1;
    private CustomMessageListener cJb = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cIV = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a cJc = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.cIS.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.cIR.lg();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.beb.getResources().getString(d.k.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.beb.showToast(errorString);
                    if (a.this.cIR.isEmpty()) {
                        a.this.cIR.ao(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.cIS.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.cIS.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener cJd = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.cJa = true;
        }
    };
    private com.baidu.adp.base.d cJe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.ts(a.this.bnl.getErrorCode())) {
                AntiHelper.am(a.this.beb.getPageContext().getPageActivity(), a.this.bnl.getErrorString());
            } else if (obj != null) {
                a.this.cIS.fc(!StringUtils.isNull(a.this.cIW));
            } else if (!StringUtils.isNull(a.this.bnl.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.bnl.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cJf = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.cIQ.isAdded()) {
                if (aVar.type == 1) {
                    a.this.cIR.lg();
                }
                if (aVar.cJM) {
                    if (aVar.type == 1) {
                        a.this.cIU = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.cJN);
                    } else if (aVar.type == 0 && !a.this.cIU) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.cJN;
                        a.this.cIS.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.beb.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.cIX > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.cIX, a.this.cIS.alf() - a.this.cIX, a.this.cIS.ald(), a.this.cIS.ale(), currentTimeMillis - a.this.cIS.alc());
                    a.this.cIX = -1L;
                }
                if (aVar.cJN == null || aVar.cJN.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.beb.getResources().getString(d.k.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.cJN.getHotSearchInfoData();
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
            a.this.cIS.fc(!StringUtils.isNull(a.this.cIW));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cHX = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Pj();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.cIS = null;
        this.isFirst = true;
        this.cIU = false;
        this.cIX = -1L;
        this.cIQ = enterForumFragment;
        this.beb = enterForumFragment.getBaseFragmentActivity();
        this.cHX.addEventDelegate(this);
        this.cIX = System.currentTimeMillis();
        this.isFirst = true;
        this.cIU = false;
        this.cIW = "";
        this.cIS = new EnterForumModel(this.beb.getPageContext());
        this.cIT = new RecentlyVisitedForumModel();
        this.bnl = new LikeModel(this.beb.getPageContext());
        this.bnl.setLoadDataCallBack(this.cJe);
        this.cIS.a(this.cJf);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.akX().k(this.cIQ.getFragmentActivity(), l.p(this.cIQ.getFragmentActivity()));
        initUI();
        initListener();
        akL();
    }

    private void initListener() {
        akO();
        this.cIQ.registerListener(this.cJd);
        this.cIQ.registerListener(this.cJc);
        this.cIQ.registerListener(this.cJb);
    }

    private static void Pj() {
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
                if (a.this.cIS != null && a.this.cIS.alg() != null && a.this.cIS.alg().akt() != null && v.v(a.this.cIS.alg().akt().aky()) > 0) {
                    Iterator<f> it = a.this.cIS.alg().akt().aky().iterator();
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
        return !this.cIS.h(this.cIR.als(), this.cIR.alt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.cIR.alq();
    }

    public View akN() {
        return this.cIR.akN();
    }

    public void am(View view2) {
        this.cIR.am(view2);
    }

    private void akO() {
        this.cIQ.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cIR == null || !a.this.cIR.akq()) {
                    if (!a.this.isChanged()) {
                        a.this.akM();
                    } else {
                        a.this.akP();
                    }
                    if (a.this.cIY) {
                        a.this.cIR.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.cIQ.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cIR.alq();
                if (a.this.isChanged()) {
                    if (a.this.cIR.isEmpty()) {
                        a.this.cIR.ao(a.this.mRootView);
                        return;
                    } else {
                        a.this.cIR.alp();
                        a.this.cIS.aO(a.this.cIR.als());
                    }
                }
                if (a.this.cIY) {
                    a.this.cIR.startPullRefresh();
                }
            }
        });
    }

    public void akP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.beb.getPageContext().getPageActivity());
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
        aVar.b(this.beb.getPageContext());
        aVar.tC();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.beb.getPageContext().getPageActivity());
            aVar.dc(String.format(this.beb.getPageContext().getString(d.k.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.k.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.hg()) {
                        a.this.beb.showToast(d.k.delete_like_fail);
                    } else {
                        new C0129a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.beb.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.beb.getPageContext());
            aVar.tC();
        }
    }

    public void eY(boolean z) {
        if (this.mWaitingDialog == null) {
            akQ();
        }
        this.mWaitingDialog.aI(z);
    }

    private void akQ() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.beb.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.beb.getActivity()).inflate(d.i.enter_forum_view, (ViewGroup) null);
        this.cIR = new com.baidu.tieba.enterForum.view.a(this.cIQ, this.mRootView, this.cHX, this.cIT);
        this.cIR.a(this.anZ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eZ(boolean z) {
        if (this.cIR != null && this.cIQ != null) {
            if (z) {
                if (this.cIQ.isPrimary() && this.cIQ.isResumed()) {
                    this.cIR.startPullRefresh();
                    return;
                } else {
                    this.cIR.lg();
                    return;
                }
            }
            this.cIR.lg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cIQ.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.cIR != null) {
            if (bVar == null) {
                this.cIR.ao(this.mRootView);
                return;
            }
            g akt = bVar.akt();
            ArrayList<f> arrayList = new ArrayList<>();
            if (akt != null) {
                arrayList = akt.aky();
            }
            aM(arrayList);
            if (b(bVar)) {
                this.cIR.aT(bVar.aku());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.akw() != null) {
                setSearchHint(hotSearchInfoData.akw());
            }
            this.cIR.alu();
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
            this.cIR.setSearchHint(str.trim());
        } else {
            this.cIR.setSearchHint(this.beb.getActivity().getString(d.k.enter_forum_search_tip));
        }
    }

    private void aM(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.cIR.aS(this.cIS.a(list, com.baidu.tbadk.util.c.Hx()));
        }
    }

    public void OQ() {
        if (this.cIR != null) {
            fa(false);
        }
    }

    public void onDestroy() {
        Fi();
        com.baidu.tieba.enterForum.model.a.akX().destroy();
        if (this.cIR != null) {
            if (this.cIS != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cIS.aO(this.cIR.als());
            }
            this.cIR.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016550);
        if (this.cIT != null) {
            this.cIT.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cIR != null) {
            this.cIR.onChangeSkinType(i);
        }
    }

    public void Fi() {
        if (this.cIS != null) {
            this.cIS.cancelLoadData();
        }
    }

    public void fa(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.cJa && this.cIS != null && this.cIR != null) {
            String str = this.cIW;
            this.cIW = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cIW == null || this.cIW.equals(str)) {
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
                if (this.cIS != null && this.cIS.alg() != null && this.cIS.alg().akt() != null) {
                    Iterator<f> it = this.cIS.alg().akt().aky().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.jv(1);
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
                    com.baidu.tieba.tbadkCore.util.a.sZ(currentAccount);
                }
                this.cIR.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Fi();
                if (z4) {
                    this.cIS.fc(StringUtils.isNull(this.cIW) ? false : true);
                } else if (z2) {
                    this.cIS.fd(!StringUtils.isNull(this.cIW));
                    this.cIS.fc(StringUtils.isNull(this.cIW) ? false : true);
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
        if (this.cIT != null) {
            this.cIT.onPrimary();
        }
    }

    public void onPause() {
        if (this.cIR != null && this.cIR.alo() != null) {
            this.cIR.alo().completePullRefresh();
        }
        if (this.cIT != null) {
            this.cIT.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0129a extends BdAsyncTask<f, Integer, String> {
        private f cJk;
        private x mNetwork = null;

        public C0129a(f fVar) {
            this.cJk = null;
            this.cJk = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.cJk;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.vi().wh().mIsNeedTbs = true;
                        this.mNetwork.uK();
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
            a.this.eY(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.vi().wi().isRequestSuccess()) {
                    a.this.cIY = true;
                    if (a.this.cIQ.isAdded() && a.this.beb != null) {
                        a.this.beb.showToast(a.this.beb.getActivity().getString(d.k.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.h(false, this.cJk.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.cJk.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cJk.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.cJk.getName()));
                    }
                    a.this.cIR.b(this.cJk);
                } else if (a.this.beb != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.beb.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.cIQ.isAdded()) {
                        a.this.beb.showToast(a.this.beb.getActivity().getString(d.k.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.eY(true);
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
                    com.baidu.tieba.im.settingcache.d.aGU().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int FD = bVar.FD();
        com.baidu.tbadk.mvc.b.a FE = bVar.FE();
        switch (FD) {
            case 1:
                if (this.cIZ != 2 && (FE instanceof f)) {
                    String name = ((f) FE).getName();
                    if (an.aQ(name)) {
                        this.beb.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.beb.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        if (this.beb.getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new al("c12888"));
                        }
                        List<f> als = this.cIR.als();
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
                if (this.cIZ == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.cIR.jy(FE instanceof h ? ((h) FE).getPosition() : 0);
                this.cIY = false;
                if (this.cIQ.getView() == null || this.cIQ.getView().getParent() == null) {
                    return true;
                }
                this.cIQ.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (FE instanceof f) {
                    a((f) FE);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.beb.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.beb.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new al("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.beb.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.beb.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new al("c10378").ac("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new al("c12049").ac("obj_type", "2").r("obj_locate", 1));
                this.beb.finish();
                return true;
            case 9:
                if (this.cIR != null) {
                    this.cIR.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.cIZ = 2;
                return true;
            case 11:
                this.cIZ = 1;
                return true;
        }
    }

    public void akR() {
        if (this.cIR != null) {
            this.cIR.alr();
        }
    }

    public boolean akS() {
        if (this.cIR != null) {
            return this.cIR.akS();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean FC() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.beb.getUniqueId();
    }

    public void fb(boolean z) {
        int i = 0;
        if (this.cIR != null && this.cIQ != null) {
            boolean z2 = this.cIR.akS() && this.cIQ.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.cIR.akq()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
