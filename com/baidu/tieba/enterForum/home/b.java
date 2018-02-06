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
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.j;
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
public class b implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity bUg;
    private LikeModel cdg;
    private com.baidu.tieba.enterForum.home.a dpD;
    private EnterForumModel dpF;
    private boolean dpG;
    private String dpI;
    private long dpJ;
    private boolean dpK;
    private boolean dpL;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b dpE = null;
    private boolean dpH = false;
    private CustomMessageListener dpM = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.dpH = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a dpN = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.dpF.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.dpE.sV();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bUg.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bUg.showToast(errorString);
                    if (b.this.dpE.isEmpty()) {
                        b.this.dpE.bJ(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.dpF.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.dpF.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener dpO = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.dpL = true;
        }
    };
    private com.baidu.adp.base.d dpP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (AntiHelper.vQ(b.this.cdg.getErrorCode())) {
                AntiHelper.ar(b.this.bUg.getPageContext().getPageActivity(), b.this.cdg.getErrorString());
            } else if (obj != null) {
                b.this.dpF.fw(!StringUtils.isNull(b.this.dpI));
            } else if (!StringUtils.isNull(b.this.cdg.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.cdg.getErrorString());
            }
        }
    };
    private final EnterForumModel.b dpQ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.dpD.isAdded()) {
                if (aVar.type == 1) {
                    b.this.dpE.sV();
                }
                if (aVar.dqn) {
                    if (aVar.type == 1) {
                        b.this.dpG = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.dqo);
                    } else if (aVar.type == 0 && !b.this.dpG) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.dqo;
                        b.this.dpF.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bUg.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.dpJ > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.dpJ, b.this.dpF.aqR() - b.this.dpJ, b.this.dpF.aqP(), b.this.dpF.aqQ(), currentTimeMillis - b.this.dpF.aqO());
                    b.this.dpJ = -1L;
                }
                if (aVar.dqo == null || aVar.dqo.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bUg.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.dqo.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.aqn() != null) {
                    b.this.setSearchHint(hotSearchInfoData.aqn());
                }
            }
        }
    };
    private j.b bcR = new j.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            b.this.dpF.fw(!StringUtils.isNull(b.this.dpI));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter doV = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        WM();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.dpF = null;
        this.isFirst = true;
        this.dpG = false;
        this.dpJ = -1L;
        this.dpD = aVar;
        this.bUg = aVar.getBaseFragmentActivity();
        this.doV.addEventDelegate(this);
        this.dpJ = System.currentTimeMillis();
        this.isFirst = true;
        this.dpG = false;
        this.dpI = "";
        this.dpF = new EnterForumModel(this.bUg.getPageContext());
        this.cdg = new LikeModel(this.bUg.getPageContext());
        this.cdg.setLoadDataCallBack(this.dpP);
        this.dpF.a(this.dpQ);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aqJ().z(this.dpD.getFragmentActivity(), l.p(this.dpD.getFragmentActivity()));
        initUI();
        initListener();
        aqB();
    }

    private void initListener() {
        aqE();
        this.dpD.registerListener(this.dpO);
        this.dpD.registerListener(this.dpN);
        this.dpD.registerListener(this.dpM);
    }

    private static void WM() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aqB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016550, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (b.this.dpF != null && b.this.dpF.aqS() != null && b.this.dpF.aqS().aqk() != null && v.D(b.this.dpF.aqS().aqk().aqp()) > 0) {
                    Iterator<f> it = b.this.dpF.aqS().aqk().aqp().iterator();
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
                    acVar.A(arrayList);
                }
                return new CustomResponsedMessage<>(2016550, acVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.dpF.h(this.dpE.are(), this.dpE.arf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqC() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.dpE.arc();
    }

    public View aqD() {
        return this.dpE.aqD();
    }

    public void bH(View view) {
        this.dpE.bH(view);
    }

    private void aqE() {
        this.dpD.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.aqC();
                } else {
                    b.this.aqF();
                }
                if (b.this.dpK) {
                    b.this.dpE.startPullRefresh();
                }
            }
        });
        this.dpD.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dpE.arc();
                if (b.this.isChanged()) {
                    if (b.this.dpE.isEmpty()) {
                        b.this.dpE.bJ(b.this.mRootView);
                        return;
                    } else {
                        b.this.dpE.arb();
                        b.this.dpF.aQ(b.this.dpE.are());
                    }
                }
                if (b.this.dpK) {
                    b.this.dpE.startPullRefresh();
                }
            }
        });
    }

    public void aqF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bUg.getPageContext().getPageActivity());
        aVar.fb(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.aqC();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.fc(d.C0140d.cp_cont_b);
        aVar.b(this.bUg.getPageContext());
        aVar.AU();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bUg.getPageContext().getPageActivity());
            aVar.dk(String.format(this.bUg.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.pa()) {
                        b.this.bUg.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.bUg.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fc(d.C0140d.cp_cont_b);
            aVar.b(this.bUg.getPageContext());
            aVar.AU();
        }
    }

    public void fs(boolean z) {
        if (this.mWaitingDialog == null) {
            aqG();
        }
        this.mWaitingDialog.bq(z);
    }

    private void aqG() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.bUg.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bUg.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.dpE = new com.baidu.tieba.enterForum.b.b(this.dpD, this.mRootView, this.doV);
        this.dpE.a(this.bcR);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ft(boolean z) {
        if (this.dpE != null && this.dpD != null) {
            if (z) {
                if (this.dpD.isPrimary() && this.dpD.isResumed()) {
                    this.dpE.startPullRefresh();
                    return;
                } else {
                    this.dpE.sV();
                    return;
                }
            }
            this.dpE.sV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.dpD.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.dpE != null) {
            if (bVar == null) {
                this.dpE.bJ(this.mRootView);
                return;
            }
            g aqk = bVar.aqk();
            ArrayList<f> arrayList = new ArrayList<>();
            if (aqk != null) {
                arrayList = aqk.aqp();
            }
            aO(arrayList);
            if (b(bVar)) {
                this.dpE.aV(bVar.aql());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aqn() != null) {
                setSearchHint(hotSearchInfoData.aqn());
            }
            this.dpE.arg();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.aqk() == null || v.E(bVar.aqk().aqp())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.dpE.setSearchHint(str.trim());
        } else {
            this.dpE.setSearchHint(this.bUg.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void aO(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.dpE.aU(this.dpF.a(list, com.baidu.tbadk.util.c.OW()));
        }
    }

    public void Wt() {
        if (this.dpE != null) {
            fu(false);
        }
    }

    public void onDestroy() {
        MH();
        com.baidu.tieba.enterForum.model.a.aqJ().destroy();
        if (this.dpE != null) {
            if (this.dpF != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.dpF.aQ(this.dpE.are());
            }
            this.dpE.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016550);
    }

    public void onChangeSkinType(int i) {
        if (this.dpE != null) {
            this.dpE.onChangeSkinType(i);
        }
    }

    public void MH() {
        if (this.dpF != null) {
            this.dpF.cancelLoadData();
        }
    }

    public void fu(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.dpL && this.dpF != null && this.dpE != null) {
            String str = this.dpI;
            this.dpI = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.dpI == null || this.dpI.equals(str)) {
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
                if (this.dpF != null && this.dpF.aqS() != null && this.dpF.aqS().aqk() != null) {
                    Iterator<f> it = this.dpF.aqS().aqk().aqp().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.ml(1);
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
                    com.baidu.tieba.tbadkCore.util.a.sP(currentAccount);
                }
                this.dpE.notifyDataSetChanged();
            }
            if (z2 || z4) {
                MH();
                if (z4) {
                    this.dpF.fw(StringUtils.isNull(this.dpI) ? false : true);
                } else if (z2) {
                    this.dpF.fx(!StringUtils.isNull(this.dpI));
                    this.dpF.fw(StringUtils.isNull(this.dpI) ? false : true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    public void onPause() {
        if (this.dpE != null && this.dpE.ara() != null) {
            this.dpE.ara().completePullRefresh();
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f dpV;
        private x mNetwork = null;

        public a(f fVar) {
            this.dpV = null;
            this.dpV = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.dpV;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.Cz().Dw().mIsNeedTbs = true;
                        this.mNetwork.Cb();
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
            super.onPostExecute((a) str);
            b.this.fs(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    b.this.dpK = true;
                    if (b.this.dpD.isAdded() && b.this.bUg != null) {
                        b.this.bUg.showToast(b.this.bUg.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.f(false, this.dpV.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.dpV.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.dpV.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.dpV.getName()));
                    }
                    b.this.dpE.b(this.dpV);
                } else if (b.this.bUg != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bUg.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.dpD.isAdded()) {
                        b.this.bUg.showToast(b.this.bUg.getActivity().getString(d.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.fs(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.b.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aLW().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Nd = bVar.Nd();
        com.baidu.tbadk.mvc.b.a Ne = bVar.Ne();
        switch (Nd) {
            case 1:
                if (Ne instanceof f) {
                    String name = ((f) Ne).getName();
                    if (am.aT(name)) {
                        this.bUg.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bUg.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        if (this.bUg.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new ak("c12888"));
                        }
                        List<f> are = this.dpE.are();
                        if (!v.E(are)) {
                            if (v.D(are) > 1 && are.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < are.size()) {
                                    if (!are.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new ak("c12049").ab("obj_type", "2").s("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.dpE.mn(Ne instanceof h ? ((h) Ne).getPosition() : 0);
                this.dpK = false;
                if (this.dpD.getView() == null || this.dpD.getView().getParent() == null) {
                    return true;
                }
                this.dpD.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Ne instanceof f) {
                    a((f) Ne);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bUg.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bUg.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.bUg.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bUg.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ab("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ab("obj_type", "2").s("obj_locate", 1));
                this.bUg.finish();
                return true;
            case 9:
                if (this.dpE != null) {
                    this.dpE.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void aqH() {
        if (this.dpE != null) {
            this.dpE.ard();
        }
    }

    public boolean aqI() {
        if (this.dpE != null) {
            return this.dpE.aqI();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Nc() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bUg.getUniqueId();
    }

    public void fv(boolean z) {
        int i = 1;
        if (this.dpE != null && this.dpD != null) {
            boolean z2 = this.dpE.aqI() && this.dpD.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }
}
