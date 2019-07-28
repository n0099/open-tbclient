package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.os.Bundle;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity cYb;
    private LikeModel cdr;
    private EnterForumFragment eXd;
    private EnterForumModel eXf;
    private RecentlyVisitedForumModel eXg;
    private com.baidu.tieba.ueg.d eXh;
    private boolean eXj;
    private String eXl;
    private long eXm;
    private boolean eXn;
    private com.baidu.tieba.enterForum.view.d eXp;
    private boolean eXq;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b eXe = null;
    private com.baidu.tbadk.core.dialog.a eXi = null;
    private boolean eXk = false;
    private int eXo = 1;
    private CustomMessageListener eXr = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.eXk = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a eXs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.eXf.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.eXe.oT();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cYb.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cYb.showToast(errorString);
                    if (a.this.eXe.isEmpty()) {
                        a.this.eXe.bO(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.eXf.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.eXf.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d eXt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(a.this.cdr.getErrorCode(), a.this.cdr.getErrorString())) {
                AntiHelper.aJ(a.this.cYb.getPageContext().getPageActivity(), a.this.cdr.getErrorString());
            } else if (obj != null) {
                a.this.eXf.jp(!StringUtils.isNull(a.this.eXl));
            } else if (!StringUtils.isNull(a.this.cdr.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.cdr.getErrorString());
            }
        }
    };
    private final EnterForumModel.b eXu = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.eXd != null) {
                if (aVar.type == 1) {
                    a.this.eXe.oT();
                }
                if (aVar.eYD) {
                    if (aVar.type == 1) {
                        a.this.eXj = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.eYE;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.eXj) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.eYE;
                        a.this.eXf.d(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.cYb.showToast(aVar.error);
                    a.this.eXe.qt(com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.eXm > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.eXm, a.this.eXf.bgm() - a.this.eXm, a.this.eXf.bgk(), a.this.eXf.bgl(), currentTimeMillis - a.this.eXf.bgj());
                    a.this.eXm = -1L;
                }
                String string = a.this.cYb.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.eYE != null && aVar.eYE.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.eYE.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.ahO().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bfn() != null) {
                        string = hotSearchInfoData.bfn();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c caD = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            EnterForumDelegateStatic.eWP.loadAd();
            a.this.eXf.jp(!StringUtils.isNull(a.this.eXl));
            a.this.eXg.LoadData();
            a.this.eXf.jo(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eVo = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aIO();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.eXf = null;
        this.isFirst = true;
        this.eXj = false;
        this.eXm = -1L;
        this.eXd = enterForumFragment;
        this.cYb = enterForumFragment.getBaseFragmentActivity();
        this.eVo.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.brS();
        this.eXm = System.currentTimeMillis();
        this.isFirst = true;
        this.eXj = false;
        this.eXl = "";
        this.eXf = new EnterForumModel(this.cYb.getPageContext());
        this.eXg = new RecentlyVisitedForumModel();
        this.cdr = new LikeModel(this.cYb.getPageContext());
        this.eXh = new com.baidu.tieba.ueg.d(this.cYb.getPageContext());
        this.cdr.setLoadDataCallBack(this.eXt);
        this.eXf.a(this.eXu);
        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.bgh().m(this.eXd.getFragmentActivity(), l.u(this.eXd.getFragmentActivity()));
        initUI();
        initListener();
        bfO();
    }

    private void initListener() {
        bfN();
        this.eXd.registerListener(this.eXs);
        this.eXd.registerListener(this.eXr);
    }

    private static void aIO() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void bfN() {
        this.eXd.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eXe != null && a.this.eXe.bfb()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                }
            }
        });
    }

    private void bfO() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.eXf != null && a.this.eXf.bgn() != null && a.this.eXf.bgn().bff() != null && v.Z(a.this.eXf.bgn().bff().bfy()) > 0) {
                    Iterator<f> it = a.this.eXf.bgn().bff().bfy().iterator();
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
                    aeVar.T(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, aeVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cYb.getPageContext().getPageActivity());
            aVar.mO(String.format(this.cYb.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.kt()) {
                        a.this.cYb.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.cYb.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.hv(R.color.cp_cont_b);
            aVar.b(this.cYb.getPageContext());
            aVar.agI();
        }
    }

    public void jj(boolean z) {
        if (this.mWaitingDialog == null) {
            bfP();
        }
        this.mWaitingDialog.ej(z);
    }

    private void bfP() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.cYb.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.cYb.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.eXe = new com.baidu.tieba.enterForum.view.b(this.eXd, this.mRootView, this.eVo, this.eXg, this.eXf);
        this.eXe.setListPullRefreshListener(this.caD);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jk(boolean z) {
        if (this.eXe != null && this.eXd != null) {
            if (z) {
                if (this.eXd.isPrimary() && this.eXd.isResumed()) {
                    this.eXe.startPullRefresh();
                } else {
                    this.eXe.oT();
                }
            } else {
                this.eXe.oT();
            }
            this.eXe.jv(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.eXd.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.eXe != null) {
            if (cVar == null) {
                this.eXe.bO(this.mRootView);
                return;
            }
            g bff = cVar.bff();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bff != null) {
                arrayList = bff.bfy();
            }
            bE(arrayList);
            if (b(cVar)) {
                this.eXe.bK(cVar.bfg());
            }
            c(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.ahO().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bfn() != null) {
                setSearchHint(hotSearchInfoData.bfn());
            }
            this.eXe.bgV();
            this.eXe.qt(cVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.c cVar) {
        if (TbadkCoreApplication.isLogin() && cVar != null) {
            if ((cVar.bff() == null || v.aa(cVar.bff().bfy())) && com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.eXe != null) {
            if (!StringUtils.isNull(str)) {
                this.eXe.setSearchHint(str.trim());
            } else {
                this.eXe.setSearchHint(this.cYb.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bE(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.eXe.j(this.eXf.a(list, com.baidu.tbadk.util.d.awb()), this.eXf.bgp());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bfi() != null && this.eXd.isPrimary() && this.eXi == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.cYb.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bfi())) {
                this.eXi = new com.baidu.tbadk.core.dialog.a(this.cYb.getActivity());
                this.eXi.hx(2);
                this.eXi.aH(frsPrivateCommonDialogView);
                this.eXi.dR(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bb.ajC().c(a.this.cYb.getPageContext(), new String[]{cVar.bfi().adC()});
                        a.this.eXi.dismiss();
                        a.this.eXi = null;
                    }
                });
                this.eXi.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eXi = null;
                    }
                });
                this.eXi.b(this.cYb.getPageContext()).agI();
            }
        }
    }

    private void bfQ() {
        if (this.eXi != null) {
            this.eXi.dismiss();
            this.eXi = null;
        }
    }

    public void loadData() {
        if (this.eXe != null) {
            jl(false);
        }
    }

    public void bfR() {
        if (this.eXe != null) {
            jl(true);
        }
    }

    public void onDestroy() {
        atG();
        com.baidu.tieba.enterForum.model.a.bgh().destroy();
        if (this.eXe != null) {
            this.eXe.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.eXg != null) {
            this.eXg.onDestroy();
        }
        if (this.eXf != null) {
            this.eXf.onDestroy();
        }
        if (this.eVo != null) {
            this.eVo.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eXe != null) {
            this.eXe.onChangeSkinType(i);
        }
        if (this.eXp != null) {
            this.eXp.onChangeSkinType();
        }
    }

    public void atG() {
        if (this.eXf != null) {
            this.eXf.cancelLoadData();
        }
    }

    public void jl(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.eXq && this.eXf != null && this.eXe != null) {
            String str = this.eXl;
            this.eXl = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.eXl == null || this.eXl.equals(str)) {
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
                if (this.eXf != null && this.eXf.bgn() != null && this.eXf.bgn().bff() != null) {
                    Iterator<f> it = this.eXf.bgn().bff().bfy().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.qv(1);
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
                    com.baidu.tieba.tbadkCore.util.a.EQ(currentAccount);
                }
                this.eXe.notifyDataSetChanged();
            }
            if (z2 || z4) {
                atG();
                if (z4) {
                    if (this.eXf != null) {
                        this.eXf.jq(StringUtils.isNull(this.eXl) ? false : true);
                    }
                    this.eXg.LoadData();
                } else if (z2 && this.eXf != null) {
                    this.eXf.jq(StringUtils.isNull(this.eXl) ? false : true);
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
        if (this.eXd.isAdded() && this.eXd.isPrimary()) {
            if (this.eXg != null) {
                this.eXg.onPrimary();
            }
        } else {
            bfQ();
        }
        if (this.eXe != null) {
            this.eXe.onPrimary();
        }
    }

    public void onPause() {
        if (this.eXe != null && this.eXe.bgU() != null) {
            this.eXe.bgU().completePullRefresh();
        }
        if (this.eXg != null) {
            this.eXg.onPause();
        }
        if (this.eXf != null) {
            this.eXf.onPause();
        }
        if (this.eXe != null) {
            this.eXe.onPause();
        }
    }

    public void bfS() {
        if (this.eXe != null) {
            this.eXe.bN(this.mRootView);
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f eXA;
        private x mNetwork = null;

        public b(f fVar) {
            this.eXA = null;
            this.eXA = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eXA;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.o("fid", fVar.getId());
                        this.mNetwork.o("kw", fVar.getName());
                        this.mNetwork.aiE().ajE().mIsNeedTbs = true;
                        this.mNetwork.aig();
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
            super.onPostExecute((b) str);
            a.this.jj(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                    a.this.eXn = true;
                    if (a.this.eXd.isAdded() && a.this.cYb != null) {
                        a.this.cYb.showToast(a.this.cYb.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.eXA.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.eXA.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.eXA.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.eXA.getName()));
                    }
                    a.this.eXe.a(this.eXA, a.this.eXf.bgp());
                    a.this.eXf.b(this.eXA);
                } else if (a.this.cYb != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cYb.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eXd.isAdded()) {
                        a.this.cYb.showToast(a.this.cYb.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.jj(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0302a extends BdAsyncTask<f, Integer, String> {
        private f eXA;
        private x mNetwork = null;

        public C0302a(f fVar) {
            this.eXA = null;
            this.eXA = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eXA;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bfp() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.o("forum_id", fVar.getId());
                        this.mNetwork.aiE().ajE().mIsNeedTbs = true;
                        this.mNetwork.aig();
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
            super.onPostExecute((C0302a) str);
            a.this.jj(false);
            int bfp = this.eXA.bfp();
            if (this.mNetwork != null) {
                if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                    a.this.eXn = true;
                    if (a.this.eXd.isAdded() && a.this.cYb != null) {
                        a.this.cYb.showToast(a.this.cYb.getActivity().getString(bfp > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.eXf.jp(true);
                } else if (a.this.cYb != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cYb.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eXd.isAdded()) {
                        a.this.cYb.showToast(a.this.cYb.getActivity().getString(bfp > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.jj(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.bGs().w(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int auj = bVar.auj();
        com.baidu.tbadk.mvc.b.a auk = bVar.auk();
        switch (auj) {
            case 1:
                if (this.eXo != 2 && (auk instanceof f)) {
                    String name = ((f) auk).getName();
                    if (aq.bg(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.cYb.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) auk).arK() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) auk).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) auk).bfu());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) auk).bft().night != null && ((f) auk).bft().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) auk).bft().night.pattern_image);
                                    }
                                } else if (((f) auk).bft().day != null && ((f) auk).bft().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) auk).bft().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) auk).bfx());
                            ((f) auk).cZ(0L);
                        }
                        this.cYb.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.cYb.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").l("uid", TbadkApplication.getCurrentAccountId()).P("obj_type", this.eXf.bgn().getSortType() == 1 ? 2 : 1).bT("fid", ((f) auk).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.eXo == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("enter_forum_edit_mode", true);
                if (auk instanceof com.baidu.tieba.enterForum.data.h) {
                    ((com.baidu.tieba.enterForum.data.h) auk).getPosition();
                }
                this.eXn = false;
                if (this.eXd.getView() == null || this.eXd.getView().getParent() == null) {
                    return true;
                }
                this.eXd.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (auk instanceof f) {
                    a((f) auk);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bd.cE(this.cYb.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cYb.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.cYb.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cYb.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").bT("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an("c12049").bT("obj_type", "2").P("obj_locate", 1));
                this.cYb.finish();
                return true;
            case 9:
                if (this.eXe != null) {
                    this.eXe.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.eXo = 2;
                return true;
            case 11:
                this.eXo = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.eXo != 2) {
                    if (this.eXp == null) {
                        this.eXp = new com.baidu.tieba.enterForum.view.d(this.cYb.getPageContext(), this.eVo);
                    }
                    if (auk instanceof f) {
                        this.eXp.c((f) auk);
                        this.eXp.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (auk instanceof f) {
                    new C0302a((f) auk).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").P("obj_type", ((f) auk).bfp() <= 0 ? 1 : 2).bT("fid", ((f) auk).getId()).l("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                bb.ajC().c(this.cYb.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eXh.ctd() || !(auk instanceof f)) {
                    return true;
                }
                bb.ajC().c(this.cYb.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) auk).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aul());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aul());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aul());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aui() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.cYb.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eXe != null) {
            this.eXe.setPageUniqueId(bdUniqueId);
        }
    }

    public void jm(boolean z) {
        int i;
        if (this.eXe != null && this.eXd != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eXe.setAdState(bVar);
        this.eXd.setAdState(bVar);
    }
}
