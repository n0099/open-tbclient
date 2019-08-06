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
    private BaseFragmentActivity cYi;
    private LikeModel cdy;
    private boolean eXA;
    private EnterForumFragment eXn;
    private EnterForumModel eXp;
    private RecentlyVisitedForumModel eXq;
    private com.baidu.tieba.ueg.d eXr;
    private boolean eXt;
    private String eXv;
    private long eXw;
    private boolean eXx;
    private com.baidu.tieba.enterForum.view.d eXz;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b eXo = null;
    private com.baidu.tbadk.core.dialog.a eXs = null;
    private boolean eXu = false;
    private int eXy = 1;
    private CustomMessageListener eXB = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.eXu = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a eXC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.eXp.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.eXo.oT();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cYi.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cYi.showToast(errorString);
                    if (a.this.eXo.isEmpty()) {
                        a.this.eXo.bP(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.eXp.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.eXp.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d eXD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(a.this.cdy.getErrorCode(), a.this.cdy.getErrorString())) {
                AntiHelper.aJ(a.this.cYi.getPageContext().getPageActivity(), a.this.cdy.getErrorString());
            } else if (obj != null) {
                a.this.eXp.jp(!StringUtils.isNull(a.this.eXv));
            } else if (!StringUtils.isNull(a.this.cdy.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.cdy.getErrorString());
            }
        }
    };
    private final EnterForumModel.b eXE = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.eXn != null) {
                if (aVar.type == 1) {
                    a.this.eXo.oT();
                }
                if (aVar.eYR) {
                    if (aVar.type == 1) {
                        a.this.eXt = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.eYS;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.eXt) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.eYS;
                        a.this.eXp.d(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.cYi.showToast(aVar.error);
                    a.this.eXo.qu(com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.eXw > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.eXw, a.this.eXp.bgp() - a.this.eXw, a.this.eXp.bgn(), a.this.eXp.bgo(), currentTimeMillis - a.this.eXp.bgm());
                    a.this.eXw = -1L;
                }
                String string = a.this.cYi.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.eYS != null && aVar.eYS.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.eYS.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bfp() != null) {
                        string = hotSearchInfoData.bfp();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c caJ = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            EnterForumDelegateStatic.eWZ.loadAd();
            a.this.eXp.jp(!StringUtils.isNull(a.this.eXv));
            a.this.eXq.LoadData();
            a.this.eXp.jo(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eVv = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aIQ();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.eXp = null;
        this.isFirst = true;
        this.eXt = false;
        this.eXw = -1L;
        this.eXn = enterForumFragment;
        this.cYi = enterForumFragment.getBaseFragmentActivity();
        this.eVv.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bsf();
        this.eXw = System.currentTimeMillis();
        this.isFirst = true;
        this.eXt = false;
        this.eXv = "";
        this.eXp = new EnterForumModel(this.cYi.getPageContext());
        this.eXq = new RecentlyVisitedForumModel();
        this.cdy = new LikeModel(this.cYi.getPageContext());
        this.eXr = new com.baidu.tieba.ueg.d(this.cYi.getPageContext());
        this.cdy.setLoadDataCallBack(this.eXD);
        this.eXp.a(this.eXE);
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.bgk().m(this.eXn.getFragmentActivity(), l.u(this.eXn.getFragmentActivity()));
        initUI();
        initListener();
        bfQ();
    }

    private void initListener() {
        bfP();
        this.eXn.registerListener(this.eXC);
        this.eXn.registerListener(this.eXB);
    }

    private static void aIQ() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void bfP() {
        this.eXn.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eXo != null && a.this.eXo.bfd()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                }
            }
        });
    }

    private void bfQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.eXp != null && a.this.eXp.bgq() != null && a.this.eXp.bgq().bfh() != null && v.Z(a.this.eXp.bgq().bfh().bfA()) > 0) {
                    Iterator<f> it = a.this.eXp.bgq().bfh().bfA().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cYi.getPageContext().getPageActivity());
            aVar.mO(String.format(this.cYi.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.kt()) {
                        a.this.cYi.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.cYi.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.cYi.getPageContext());
            aVar.agK();
        }
    }

    public void jj(boolean z) {
        if (this.mWaitingDialog == null) {
            bfR();
        }
        this.mWaitingDialog.ej(z);
    }

    private void bfR() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.cYi.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.cYi.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.eXo = new com.baidu.tieba.enterForum.view.b(this.eXn, this.mRootView, this.eVv, this.eXq, this.eXp);
        this.eXo.setListPullRefreshListener(this.caJ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jk(boolean z) {
        if (this.eXo != null && this.eXn != null) {
            if (z) {
                if (this.eXn.isPrimary() && this.eXn.isResumed()) {
                    this.eXo.startPullRefresh();
                } else {
                    this.eXo.oT();
                }
            } else {
                this.eXo.oT();
            }
            this.eXo.jv(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.eXn.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.eXo != null) {
            if (cVar == null) {
                this.eXo.bP(this.mRootView);
                return;
            }
            g bfh = cVar.bfh();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bfh != null) {
                arrayList = bfh.bfA();
            }
            bE(arrayList);
            if (b(cVar)) {
                this.eXo.bK(cVar.bfi());
            }
            c(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.ahQ().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bfp() != null) {
                setSearchHint(hotSearchInfoData.bfp());
            }
            this.eXo.bhc();
            this.eXo.qu(cVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.c cVar) {
        if (TbadkCoreApplication.isLogin() && cVar != null) {
            if ((cVar.bfh() == null || v.aa(cVar.bfh().bfA())) && com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.eXn.bfM() != null) {
            if (!StringUtils.isNull(str)) {
                this.eXn.bfM().setSearchHint(str.trim());
            } else {
                this.eXn.bfM().setSearchHint(this.cYi.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bE(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.eXo.j(this.eXp.a(list, com.baidu.tbadk.util.d.awd()), this.eXp.bgs());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bfk() != null && this.eXn.isPrimary() && this.eXs == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.cYi.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bfk())) {
                this.eXs = new com.baidu.tbadk.core.dialog.a(this.cYi.getActivity());
                this.eXs.hx(2);
                this.eXs.aH(frsPrivateCommonDialogView);
                this.eXs.dR(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bb.ajE().c(a.this.cYi.getPageContext(), new String[]{cVar.bfk().adD()});
                        a.this.eXs.dismiss();
                        a.this.eXs = null;
                    }
                });
                this.eXs.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eXs = null;
                    }
                });
                this.eXs.b(this.cYi.getPageContext()).agK();
            }
        }
    }

    private void bfS() {
        if (this.eXs != null) {
            this.eXs.dismiss();
            this.eXs = null;
        }
    }

    public void loadData() {
        if (this.eXo != null) {
            jl(false);
        }
    }

    public void bfT() {
        if (this.eXo != null) {
            jl(true);
        }
    }

    public void onDestroy() {
        atI();
        com.baidu.tieba.enterForum.model.a.bgk().destroy();
        if (this.eXo != null) {
            this.eXo.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.eXq != null) {
            this.eXq.onDestroy();
        }
        if (this.eXp != null) {
            this.eXp.onDestroy();
        }
        if (this.eVv != null) {
            this.eVv.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eXo != null) {
            this.eXo.onChangeSkinType(i);
        }
        if (this.eXz != null) {
            this.eXz.onChangeSkinType();
        }
    }

    public void atI() {
        if (this.eXp != null) {
            this.eXp.cancelLoadData();
        }
    }

    public void jl(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.eXA && this.eXp != null && this.eXo != null) {
            String str = this.eXv;
            this.eXv = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.eXv == null || this.eXv.equals(str)) {
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
                if (this.eXp != null && this.eXp.bgq() != null && this.eXp.bgq().bfh() != null) {
                    Iterator<f> it = this.eXp.bgq().bfh().bfA().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.qw(1);
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
                    com.baidu.tieba.tbadkCore.util.a.ER(currentAccount);
                }
                this.eXo.notifyDataSetChanged();
            }
            if (z2 || z4) {
                atI();
                if (z4) {
                    if (this.eXp != null) {
                        this.eXp.jq(StringUtils.isNull(this.eXv) ? false : true);
                    }
                    this.eXq.LoadData();
                } else if (z2 && this.eXp != null) {
                    this.eXp.jq(StringUtils.isNull(this.eXv) ? false : true);
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
        if (this.eXn.isAdded() && this.eXn.isPrimary()) {
            if (this.eXq != null) {
                this.eXq.onPrimary();
            }
        } else {
            bfS();
        }
        if (this.eXo != null) {
            this.eXo.onPrimary();
        }
    }

    public void onPause() {
        if (this.eXo != null && this.eXo.bhb() != null) {
            this.eXo.bhb().completePullRefresh();
        }
        if (this.eXq != null) {
            this.eXq.onPause();
        }
        if (this.eXp != null) {
            this.eXp.onPause();
        }
        if (this.eXo != null) {
            this.eXo.onPause();
        }
    }

    public void bfU() {
        if (this.eXo != null) {
            this.eXo.bO(this.mRootView);
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f eXK;
        private x mNetwork = null;

        public b(f fVar) {
            this.eXK = null;
            this.eXK = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eXK;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.o("fid", fVar.getId());
                        this.mNetwork.o("kw", fVar.getName());
                        this.mNetwork.aiG().ajG().mIsNeedTbs = true;
                        this.mNetwork.aii();
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
                if (this.mNetwork.aiG().ajH().isRequestSuccess()) {
                    a.this.eXx = true;
                    if (a.this.eXn.isAdded() && a.this.cYi != null) {
                        a.this.cYi.showToast(a.this.cYi.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.eXK.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.eXK.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.eXK.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.eXK.getName()));
                    }
                    a.this.eXo.a(this.eXK, a.this.eXp.bgs());
                    a.this.eXp.b(this.eXK);
                } else if (a.this.cYi != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cYi.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eXn.isAdded()) {
                        a.this.cYi.showToast(a.this.cYi.getActivity().getString(R.string.delete_like_fail));
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
        private f eXK;
        private x mNetwork = null;

        public C0302a(f fVar) {
            this.eXK = null;
            this.eXK = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eXK;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bfr() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.o("forum_id", fVar.getId());
                        this.mNetwork.aiG().ajG().mIsNeedTbs = true;
                        this.mNetwork.aii();
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
            int bfr = this.eXK.bfr();
            if (this.mNetwork != null) {
                if (this.mNetwork.aiG().ajH().isRequestSuccess()) {
                    a.this.eXx = true;
                    if (a.this.eXn.isAdded() && a.this.cYi != null) {
                        a.this.cYi.showToast(a.this.cYi.getActivity().getString(bfr > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.eXp.jp(true);
                } else if (a.this.cYi != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cYi.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eXn.isAdded()) {
                        a.this.cYi.showToast(a.this.cYi.getActivity().getString(bfr > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.bGG().w(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aul = bVar.aul();
        com.baidu.tbadk.mvc.b.a aum = bVar.aum();
        switch (aul) {
            case 1:
                if (this.eXy != 2 && (aum instanceof f)) {
                    String name = ((f) aum).getName();
                    if (aq.bg(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.cYi.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) aum).arM() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) aum).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) aum).bfw());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) aum).bfv().night != null && ((f) aum).bfv().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) aum).bfv().night.pattern_image);
                                    }
                                } else if (((f) aum).bfv().day != null && ((f) aum).bfv().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) aum).bfv().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) aum).bfz());
                            ((f) aum).cZ(0L);
                        }
                        this.cYi.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.cYi.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").l("uid", TbadkApplication.getCurrentAccountId()).P("obj_type", this.eXp.bgq().getSortType() == 1 ? 2 : 1).bT("fid", ((f) aum).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.eXy == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("enter_forum_edit_mode", true);
                if (aum instanceof com.baidu.tieba.enterForum.data.h) {
                    ((com.baidu.tieba.enterForum.data.h) aum).getPosition();
                }
                this.eXx = false;
                if (this.eXn.getView() == null || this.eXn.getView().getParent() == null) {
                    return true;
                }
                this.eXn.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (aum instanceof f) {
                    a((f) aum);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bd.cE(this.cYi.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cYi.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.cYi.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cYi.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").bT("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an("c12049").bT("obj_type", "2").P("obj_locate", 1));
                this.cYi.finish();
                return true;
            case 9:
                if (this.eXo != null) {
                    this.eXo.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.eXy = 2;
                return true;
            case 11:
                this.eXy = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.eXy != 2) {
                    if (this.eXz == null) {
                        this.eXz = new com.baidu.tieba.enterForum.view.d(this.cYi.getPageContext(), this.eVv);
                    }
                    if (aum instanceof f) {
                        this.eXz.c((f) aum);
                        this.eXz.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aum instanceof f) {
                    new C0302a((f) aum).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").P("obj_type", ((f) aum).bfr() <= 0 ? 1 : 2).bT("fid", ((f) aum).getId()).l("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                bb.ajE().c(this.cYi.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eXr.ctz() || !(aum instanceof f)) {
                    return true;
                }
                bb.ajE().c(this.cYi.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) aum).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aun());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aun());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aun());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean auk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.cYi.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eXo != null) {
            this.eXo.setPageUniqueId(bdUniqueId);
        }
    }

    public void jm(boolean z) {
        int i;
        if (this.eXo != null && this.eXn != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eXo.setAdState(bVar);
        this.eXn.setAdState(bVar);
    }
}
