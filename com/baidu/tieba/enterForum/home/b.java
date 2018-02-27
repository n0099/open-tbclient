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
    private BaseFragmentActivity bTU;
    private LikeModel ccU;
    private com.baidu.tieba.enterForum.home.a dpr;
    private EnterForumModel dpt;
    private boolean dpu;
    private String dpw;
    private long dpx;
    private boolean dpy;
    private boolean dpz;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b dps = null;
    private boolean dpv = false;
    private CustomMessageListener dpA = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.dpv = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a dpB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.dpt.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.dps.sV();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bTU.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bTU.showToast(errorString);
                    if (b.this.dps.isEmpty()) {
                        b.this.dps.bJ(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.dpt.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.dpt.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener dpC = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.dpz = true;
        }
    };
    private com.baidu.adp.base.d dpD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (AntiHelper.vR(b.this.ccU.getErrorCode())) {
                AntiHelper.ar(b.this.bTU.getPageContext().getPageActivity(), b.this.ccU.getErrorString());
            } else if (obj != null) {
                b.this.dpt.fw(!StringUtils.isNull(b.this.dpw));
            } else if (!StringUtils.isNull(b.this.ccU.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.ccU.getErrorString());
            }
        }
    };
    private final EnterForumModel.b dpE = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.dpr.isAdded()) {
                if (aVar.type == 1) {
                    b.this.dps.sV();
                }
                if (aVar.dqb) {
                    if (aVar.type == 1) {
                        b.this.dpu = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.dqc);
                    } else if (aVar.type == 0 && !b.this.dpu) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.dqc;
                        b.this.dpt.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bTU.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.dpx > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.dpx, b.this.dpt.aqQ() - b.this.dpx, b.this.dpt.aqO(), b.this.dpt.aqP(), currentTimeMillis - b.this.dpt.aqN());
                    b.this.dpx = -1L;
                }
                if (aVar.dqc == null || aVar.dqc.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bTU.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.dqc.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.aqm() != null) {
                    b.this.setSearchHint(hotSearchInfoData.aqm());
                }
            }
        }
    };
    private j.b bcF = new j.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            b.this.dpt.fw(!StringUtils.isNull(b.this.dpw));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter doJ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        WL();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.dpt = null;
        this.isFirst = true;
        this.dpu = false;
        this.dpx = -1L;
        this.dpr = aVar;
        this.bTU = aVar.getBaseFragmentActivity();
        this.doJ.addEventDelegate(this);
        this.dpx = System.currentTimeMillis();
        this.isFirst = true;
        this.dpu = false;
        this.dpw = "";
        this.dpt = new EnterForumModel(this.bTU.getPageContext());
        this.ccU = new LikeModel(this.bTU.getPageContext());
        this.ccU.setLoadDataCallBack(this.dpD);
        this.dpt.a(this.dpE);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aqI().z(this.dpr.getFragmentActivity(), l.p(this.dpr.getFragmentActivity()));
        initUI();
        initListener();
        aqA();
    }

    private void initListener() {
        aqD();
        this.dpr.registerListener(this.dpC);
        this.dpr.registerListener(this.dpB);
        this.dpr.registerListener(this.dpA);
    }

    private static void WL() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aqA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016550, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (b.this.dpt != null && b.this.dpt.aqR() != null && b.this.dpt.aqR().aqj() != null && v.D(b.this.dpt.aqR().aqj().aqo()) > 0) {
                    Iterator<f> it = b.this.dpt.aqR().aqj().aqo().iterator();
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
        return !this.dpt.h(this.dps.ard(), this.dps.are());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.dps.arb();
    }

    public View aqC() {
        return this.dps.aqC();
    }

    public void bH(View view) {
        this.dps.bH(view);
    }

    private void aqD() {
        this.dpr.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.aqB();
                } else {
                    b.this.aqE();
                }
                if (b.this.dpy) {
                    b.this.dps.startPullRefresh();
                }
            }
        });
        this.dpr.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dps.arb();
                if (b.this.isChanged()) {
                    if (b.this.dps.isEmpty()) {
                        b.this.dps.bJ(b.this.mRootView);
                        return;
                    } else {
                        b.this.dps.ara();
                        b.this.dpt.aQ(b.this.dps.ard());
                    }
                }
                if (b.this.dpy) {
                    b.this.dps.startPullRefresh();
                }
            }
        });
    }

    public void aqE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bTU.getPageContext().getPageActivity());
        aVar.fb(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.aqB();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.fc(d.C0141d.cp_cont_b);
        aVar.b(this.bTU.getPageContext());
        aVar.AU();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bTU.getPageContext().getPageActivity());
            aVar.dk(String.format(this.bTU.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.pa()) {
                        b.this.bTU.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.bTU.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fc(d.C0141d.cp_cont_b);
            aVar.b(this.bTU.getPageContext());
            aVar.AU();
        }
    }

    public void fs(boolean z) {
        if (this.mWaitingDialog == null) {
            aqF();
        }
        this.mWaitingDialog.bq(z);
    }

    private void aqF() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.bTU.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bTU.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.dps = new com.baidu.tieba.enterForum.b.b(this.dpr, this.mRootView, this.doJ);
        this.dps.a(this.bcF);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ft(boolean z) {
        if (this.dps != null && this.dpr != null) {
            if (z) {
                if (this.dpr.isPrimary() && this.dpr.isResumed()) {
                    this.dps.startPullRefresh();
                    return;
                } else {
                    this.dps.sV();
                    return;
                }
            }
            this.dps.sV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.dpr.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.dps != null) {
            if (bVar == null) {
                this.dps.bJ(this.mRootView);
                return;
            }
            g aqj = bVar.aqj();
            ArrayList<f> arrayList = new ArrayList<>();
            if (aqj != null) {
                arrayList = aqj.aqo();
            }
            aO(arrayList);
            if (b(bVar)) {
                this.dps.aV(bVar.aqk());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aqm() != null) {
                setSearchHint(hotSearchInfoData.aqm());
            }
            this.dps.arf();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.aqj() == null || v.E(bVar.aqj().aqo())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.dps.setSearchHint(str.trim());
        } else {
            this.dps.setSearchHint(this.bTU.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void aO(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.dps.aU(this.dpt.a(list, com.baidu.tbadk.util.c.OV()));
        }
    }

    public void Ws() {
        if (this.dps != null) {
            fu(false);
        }
    }

    public void onDestroy() {
        MG();
        com.baidu.tieba.enterForum.model.a.aqI().destroy();
        if (this.dps != null) {
            if (this.dpt != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.dpt.aQ(this.dps.ard());
            }
            this.dps.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016550);
    }

    public void onChangeSkinType(int i) {
        if (this.dps != null) {
            this.dps.onChangeSkinType(i);
        }
    }

    public void MG() {
        if (this.dpt != null) {
            this.dpt.cancelLoadData();
        }
    }

    public void fu(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.dpz && this.dpt != null && this.dps != null) {
            String str = this.dpw;
            this.dpw = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.dpw == null || this.dpw.equals(str)) {
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
                if (this.dpt != null && this.dpt.aqR() != null && this.dpt.aqR().aqj() != null) {
                    Iterator<f> it = this.dpt.aqR().aqj().aqo().iterator();
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
                this.dps.notifyDataSetChanged();
            }
            if (z2 || z4) {
                MG();
                if (z4) {
                    this.dpt.fw(StringUtils.isNull(this.dpw) ? false : true);
                } else if (z2) {
                    this.dpt.fx(!StringUtils.isNull(this.dpw));
                    this.dpt.fw(StringUtils.isNull(this.dpw) ? false : true);
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
        if (this.dps != null && this.dps.aqZ() != null) {
            this.dps.aqZ().completePullRefresh();
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f dpJ;
        private x mNetwork = null;

        public a(f fVar) {
            this.dpJ = null;
            this.dpJ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.dpJ;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.Cy().Dv().mIsNeedTbs = true;
                        this.mNetwork.Ca();
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
                if (this.mNetwork.Cy().Dw().isRequestSuccess()) {
                    b.this.dpy = true;
                    if (b.this.dpr.isAdded() && b.this.bTU != null) {
                        b.this.bTU.showToast(b.this.bTU.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.f(false, this.dpJ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.dpJ.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.dpJ.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.dpJ.getName()));
                    }
                    b.this.dps.b(this.dpJ);
                } else if (b.this.bTU != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bTU.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.dpr.isAdded()) {
                        b.this.bTU.showToast(b.this.bTU.getActivity().getString(d.j.delete_like_fail));
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
                    com.baidu.tieba.im.settingcache.d.aLV().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Nc = bVar.Nc();
        com.baidu.tbadk.mvc.b.a Nd = bVar.Nd();
        switch (Nc) {
            case 1:
                if (Nd instanceof f) {
                    String name = ((f) Nd).getName();
                    if (am.aT(name)) {
                        this.bTU.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bTU.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        if (this.bTU.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new ak("c12888"));
                        }
                        List<f> ard = this.dps.ard();
                        if (!v.E(ard)) {
                            if (v.D(ard) > 1 && ard.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < ard.size()) {
                                    if (!ard.get(i2).getName().equals(name)) {
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
                this.dps.mn(Nd instanceof h ? ((h) Nd).getPosition() : 0);
                this.dpy = false;
                if (this.dpr.getView() == null || this.dpr.getView().getParent() == null) {
                    return true;
                }
                this.dpr.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Nd instanceof f) {
                    a((f) Nd);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.bTU.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bTU.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.bTU.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bTU.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ab("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ab("obj_type", "2").s("obj_locate", 1));
                this.bTU.finish();
                return true;
            case 9:
                if (this.dps != null) {
                    this.dps.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void aqG() {
        if (this.dps != null) {
            this.dps.arc();
        }
    }

    public boolean aqH() {
        if (this.dps != null) {
            return this.dps.aqH();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Nb() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bTU.getUniqueId();
    }

    public void fv(boolean z) {
        int i = 1;
        if (this.dps != null && this.dpr != null) {
            boolean z2 = this.dps.aqH() && this.dpr.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }
}
