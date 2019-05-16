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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
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
    private BaseFragmentActivity cWD;
    private LikeModel ccn;
    private EnterForumFragment eSc;
    private EnterForumModel eSe;
    private RecentlyVisitedForumModel eSf;
    private com.baidu.tieba.ueg.d eSg;
    private boolean eSi;
    private String eSk;
    private long eSl;
    private boolean eSm;
    private com.baidu.tieba.enterForum.view.d eSo;
    private boolean eSp;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b eSd = null;
    private com.baidu.tbadk.core.dialog.a eSh = null;
    private boolean eSj = false;
    private int eSn = 1;
    private CustomMessageListener eSq = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.eSj = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a eSr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.eSe.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.eSd.oy();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cWD.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cWD.showToast(errorString);
                    if (a.this.eSd.isEmpty()) {
                        a.this.eSd.bM(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.eSe.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.eSe.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d eSs = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(a.this.ccn.getErrorCode(), a.this.ccn.getErrorString())) {
                AntiHelper.aI(a.this.cWD.getPageContext().getPageActivity(), a.this.ccn.getErrorString());
            } else if (obj != null) {
                a.this.eSe.jf(!StringUtils.isNull(a.this.eSk));
            } else if (!StringUtils.isNull(a.this.ccn.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.ccn.getErrorString());
            }
        }
    };
    private final EnterForumModel.b eSt = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.eSc != null) {
                if (aVar.type == 1) {
                    a.this.eSd.oy();
                }
                if (aVar.eTB) {
                    if (aVar.type == 1) {
                        a.this.eSi = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.eTC;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.eSi) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.eTC;
                        a.this.eSe.d(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.cWD.showToast(aVar.error);
                    a.this.eSd.qb(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.eSl > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.eSl, a.this.eSe.beg() - a.this.eSl, a.this.eSe.bee(), a.this.eSe.bef(), currentTimeMillis - a.this.eSe.bed());
                    a.this.eSl = -1L;
                }
                String string = a.this.cWD.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.eTC != null && aVar.eTC.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.eTC.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bdi() != null) {
                        string = hotSearchInfoData.bdi();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c bZA = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            EnterForumDelegateStatic.eRO.loadAd();
            a.this.eSe.jf(!StringUtils.isNull(a.this.eSk));
            a.this.eSf.LoadData();
            a.this.eSe.je(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eQn = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aHo();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.eSe = null;
        this.isFirst = true;
        this.eSi = false;
        this.eSl = -1L;
        this.eSc = enterForumFragment;
        this.cWD = enterForumFragment.getBaseFragmentActivity();
        this.eQn.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bpM();
        this.eSl = System.currentTimeMillis();
        this.isFirst = true;
        this.eSi = false;
        this.eSk = "";
        this.eSe = new EnterForumModel(this.cWD.getPageContext());
        this.eSf = new RecentlyVisitedForumModel();
        this.ccn = new LikeModel(this.cWD.getPageContext());
        this.eSg = new com.baidu.tieba.ueg.d(this.cWD.getPageContext());
        this.ccn.setLoadDataCallBack(this.eSs);
        this.eSe.a(this.eSt);
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.beb().m(this.eSc.getFragmentActivity(), l.r(this.eSc.getFragmentActivity()));
        initUI();
        initListener();
        bdJ();
    }

    private void initListener() {
        bdI();
        this.eSc.registerListener(this.eSr);
        this.eSc.registerListener(this.eSq);
    }

    private static void aHo() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void bdI() {
        this.eSc.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eSd != null && a.this.eSd.bcW()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                }
            }
        });
    }

    private void bdJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.eSe != null && a.this.eSe.beh() != null && a.this.eSe.beh().bda() != null && v.Z(a.this.eSe.beh().bda().bdt()) > 0) {
                    Iterator<f> it = a.this.eSe.beh().bda().bdt().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cWD.getPageContext().getPageActivity());
            aVar.mE(String.format(this.cWD.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.ki()) {
                        a.this.cWD.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.cWD.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.hp(R.color.cp_cont_b);
            aVar.b(this.cWD.getPageContext());
            aVar.afG();
        }
    }

    public void iZ(boolean z) {
        if (this.mWaitingDialog == null) {
            bdK();
        }
        this.mWaitingDialog.ef(z);
    }

    private void bdK() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.cWD.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.cWD.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.eSd = new com.baidu.tieba.enterForum.view.b(this.eSc, this.mRootView, this.eQn, this.eSf, this.eSe);
        this.eSd.setListPullRefreshListener(this.bZA);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ja(boolean z) {
        if (this.eSd != null && this.eSc != null) {
            if (z) {
                if (this.eSc.isPrimary() && this.eSc.isResumed()) {
                    this.eSd.startPullRefresh();
                } else {
                    this.eSd.oy();
                }
            } else {
                this.eSd.oy();
            }
            this.eSd.jl(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.eSc.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.eSd != null) {
            if (cVar == null) {
                this.eSd.bM(this.mRootView);
                return;
            }
            g bda = cVar.bda();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bda != null) {
                arrayList = bda.bdt();
            }
            bC(arrayList);
            if (b(cVar)) {
                this.eSd.bI(cVar.bdb());
            }
            c(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.agM().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bdi() != null) {
                setSearchHint(hotSearchInfoData.bdi());
            }
            this.eSd.beP();
            this.eSd.qb(cVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.c cVar) {
        if (TbadkCoreApplication.isLogin() && cVar != null) {
            if ((cVar.bda() == null || v.aa(cVar.bda().bdt())) && com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.eSd.setSearchHint(str.trim());
        } else {
            this.eSd.setSearchHint(this.cWD.getActivity().getString(R.string.enter_forum_search_tip));
        }
    }

    private void bC(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.eSd.i(this.eSe.a(list, com.baidu.tbadk.util.d.auS()), this.eSe.bej());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bdd() != null && this.eSc.isPrimary() && this.eSh == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.cWD.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bdd())) {
                this.eSh = new com.baidu.tbadk.core.dialog.a(this.cWD.getActivity());
                this.eSh.hr(2);
                this.eSh.aF(frsPrivateCommonDialogView);
                this.eSh.dN(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aiz().c(a.this.cWD.getPageContext(), new String[]{cVar.bdd().acA()});
                        a.this.eSh.dismiss();
                        a.this.eSh = null;
                    }
                });
                this.eSh.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eSh = null;
                    }
                });
                this.eSh.b(this.cWD.getPageContext()).afG();
            }
        }
    }

    private void bdL() {
        if (this.eSh != null) {
            this.eSh.dismiss();
            this.eSh = null;
        }
    }

    public void loadData() {
        if (this.eSd != null) {
            jb(false);
        }
    }

    public void bdM() {
        if (this.eSd != null) {
            jb(true);
        }
    }

    public void onDestroy() {
        asz();
        com.baidu.tieba.enterForum.model.a.beb().destroy();
        if (this.eSd != null) {
            this.eSd.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.eSf != null) {
            this.eSf.onDestroy();
        }
        if (this.eSe != null) {
            this.eSe.onDestroy();
        }
        if (this.eQn != null) {
            this.eQn.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eSd != null) {
            this.eSd.onChangeSkinType(i);
        }
        if (this.eSo != null) {
            this.eSo.onChangeSkinType();
        }
    }

    public void asz() {
        if (this.eSe != null) {
            this.eSe.cancelLoadData();
        }
    }

    public void jb(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.eSp && this.eSe != null && this.eSd != null) {
            String str = this.eSk;
            this.eSk = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.eSk == null || this.eSk.equals(str)) {
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
                if (this.eSe != null && this.eSe.beh() != null && this.eSe.beh().bda() != null) {
                    Iterator<f> it = this.eSe.beh().bda().bdt().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.qd(1);
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
                    com.baidu.tieba.tbadkCore.util.a.Eb(currentAccount);
                }
                this.eSd.notifyDataSetChanged();
            }
            if (z2 || z4) {
                asz();
                if (z4) {
                    if (this.eSe != null) {
                        this.eSe.jg(StringUtils.isNull(this.eSk) ? false : true);
                    }
                    this.eSf.LoadData();
                } else if (z2 && this.eSe != null) {
                    this.eSe.jg(StringUtils.isNull(this.eSk) ? false : true);
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
        if (this.eSc.isAdded() && this.eSc.isPrimary()) {
            if (this.eSf != null) {
                this.eSf.onPrimary();
            }
        } else {
            bdL();
        }
        if (this.eSd != null) {
            this.eSd.onPrimary();
        }
    }

    public void onPause() {
        if (this.eSd != null && this.eSd.beO() != null) {
            this.eSd.beO().completePullRefresh();
        }
        if (this.eSf != null) {
            this.eSf.onPause();
        }
        if (this.eSe != null) {
            this.eSe.onPause();
        }
        if (this.eSd != null) {
            this.eSd.onPause();
        }
    }

    public void bdN() {
        if (this.eSd != null) {
            this.eSd.bL(this.mRootView);
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f eSz;
        private x mNetwork = null;

        public b(f fVar) {
            this.eSz = null;
            this.eSz = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eSz;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.o("fid", fVar.getId());
                        this.mNetwork.o("kw", fVar.getName());
                        this.mNetwork.ahC().aiB().mIsNeedTbs = true;
                        this.mNetwork.ahe();
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
            a.this.iZ(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                    a.this.eSm = true;
                    if (a.this.eSc.isAdded() && a.this.cWD != null) {
                        a.this.cWD.showToast(a.this.cWD.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.k(false, this.eSz.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.eSz.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.eSz.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.eSz.getName()));
                    }
                    a.this.eSd.a(this.eSz, a.this.eSe.bej());
                    a.this.eSe.b(this.eSz);
                } else if (a.this.cWD != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cWD.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eSc.isAdded()) {
                        a.this.cWD.showToast(a.this.cWD.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.iZ(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ia();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0299a extends BdAsyncTask<f, Integer, String> {
        private f eSz;
        private x mNetwork = null;

        public C0299a(f fVar) {
            this.eSz = null;
            this.eSz = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eSz;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bdk() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.o("forum_id", fVar.getId());
                        this.mNetwork.ahC().aiB().mIsNeedTbs = true;
                        this.mNetwork.ahe();
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
            super.onPostExecute((C0299a) str);
            a.this.iZ(false);
            int bdk = this.eSz.bdk();
            if (this.mNetwork != null) {
                if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                    a.this.eSm = true;
                    if (a.this.eSc.isAdded() && a.this.cWD != null) {
                        a.this.cWD.showToast(a.this.cWD.getActivity().getString(bdk > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.eSe.jf(true);
                } else if (a.this.cWD != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cWD.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eSc.isAdded()) {
                        a.this.cWD.showToast(a.this.cWD.getActivity().getString(bdk > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.iZ(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ia();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.bDH().w(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int atb = bVar.atb();
        com.baidu.tbadk.mvc.b.a atc = bVar.atc();
        switch (atb) {
            case 1:
                if (this.eSn != 2 && (atc instanceof f)) {
                    String name = ((f) atc).getName();
                    if (ap.bf(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.cWD.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) atc).aqE() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) atc).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) atc).bdp());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) atc).bdo().night != null && ((f) atc).bdo().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) atc).bdo().night.pattern_image);
                                    }
                                } else if (((f) atc).bdo().day != null && ((f) atc).bdo().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) atc).bdo().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) atc).bds());
                            ((f) atc).cS(0L);
                        }
                        this.cWD.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.cWD.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        TiebaStatic.log(new am("c13368").l("uid", TbadkApplication.getCurrentAccountId()).P("obj_type", this.eSe.beh().getSortType() == 1 ? 2 : 1).bT("fid", ((f) atc).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.eSn == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_edit_mode", true);
                if (atc instanceof com.baidu.tieba.enterForum.data.h) {
                    ((com.baidu.tieba.enterForum.data.h) atc).getPosition();
                }
                this.eSm = false;
                if (this.eSc.getView() == null || this.eSc.getView().getParent() == null) {
                    return true;
                }
                this.eSc.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (atc instanceof f) {
                    a((f) atc);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cD(this.cWD.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cWD.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.cWD.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cWD.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("c13367").bT("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").bT("obj_type", "2").P("obj_locate", 1));
                this.cWD.finish();
                return true;
            case 9:
                if (this.eSd != null) {
                    this.eSd.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.eSn = 2;
                return true;
            case 11:
                this.eSn = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.eSn != 2) {
                    if (this.eSo == null) {
                        this.eSo = new com.baidu.tieba.enterForum.view.d(this.cWD.getPageContext(), this.eQn);
                    }
                    if (atc instanceof f) {
                        this.eSo.c((f) atc);
                        this.eSo.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (atc instanceof f) {
                    new C0299a((f) atc).execute(new f[0]);
                    TiebaStatic.log(new am("c13370").P("obj_type", ((f) atc).bdk() <= 0 ? 1 : 2).bT("fid", ((f) atc).getId()).l("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aiz().c(this.cWD.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eSg.cqq() || !(atc instanceof f)) {
                    return true;
                }
                ba.aiz().c(this.cWD.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) atc).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.atd());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.atd());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.atd());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean ata() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.cWD.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eSd != null) {
            this.eSd.setPageUniqueId(bdUniqueId);
        }
    }

    public void jc(boolean z) {
        int i;
        if (this.eSd != null && this.eSc != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eSd.setAdState(bVar);
        this.eSc.setAdState(bVar);
    }
}
