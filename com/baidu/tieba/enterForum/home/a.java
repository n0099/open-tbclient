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
    private BaseFragmentActivity cWF;
    private LikeModel cco;
    private EnterForumFragment eSd;
    private EnterForumModel eSf;
    private RecentlyVisitedForumModel eSg;
    private com.baidu.tieba.ueg.d eSh;
    private boolean eSj;
    private String eSl;
    private long eSm;
    private boolean eSn;
    private com.baidu.tieba.enterForum.view.d eSp;
    private boolean eSq;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b eSe = null;
    private com.baidu.tbadk.core.dialog.a eSi = null;
    private boolean eSk = false;
    private int eSo = 1;
    private CustomMessageListener eSr = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.eSk = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a eSs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.eSf.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.eSe.oy();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cWF.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cWF.showToast(errorString);
                    if (a.this.eSe.isEmpty()) {
                        a.this.eSe.bM(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.eSf.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.eSf.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d eSt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(a.this.cco.getErrorCode(), a.this.cco.getErrorString())) {
                AntiHelper.aI(a.this.cWF.getPageContext().getPageActivity(), a.this.cco.getErrorString());
            } else if (obj != null) {
                a.this.eSf.jf(!StringUtils.isNull(a.this.eSl));
            } else if (!StringUtils.isNull(a.this.cco.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.cco.getErrorString());
            }
        }
    };
    private final EnterForumModel.b eSu = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.eSd != null) {
                if (aVar.type == 1) {
                    a.this.eSe.oy();
                }
                if (aVar.eTC) {
                    if (aVar.type == 1) {
                        a.this.eSj = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.eTD;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.eSj) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.eTD;
                        a.this.eSf.d(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.cWF.showToast(aVar.error);
                    a.this.eSe.qb(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.eSm > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.eSm, a.this.eSf.bej() - a.this.eSm, a.this.eSf.beh(), a.this.eSf.bei(), currentTimeMillis - a.this.eSf.beg());
                    a.this.eSm = -1L;
                }
                String string = a.this.cWF.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.eTD != null && aVar.eTD.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.eTD.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bdl() != null) {
                        string = hotSearchInfoData.bdl();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c bZB = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            EnterForumDelegateStatic.eRP.loadAd();
            a.this.eSf.jf(!StringUtils.isNull(a.this.eSl));
            a.this.eSg.LoadData();
            a.this.eSf.je(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eQo = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aHr();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.eSf = null;
        this.isFirst = true;
        this.eSj = false;
        this.eSm = -1L;
        this.eSd = enterForumFragment;
        this.cWF = enterForumFragment.getBaseFragmentActivity();
        this.eQo.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bpR();
        this.eSm = System.currentTimeMillis();
        this.isFirst = true;
        this.eSj = false;
        this.eSl = "";
        this.eSf = new EnterForumModel(this.cWF.getPageContext());
        this.eSg = new RecentlyVisitedForumModel();
        this.cco = new LikeModel(this.cWF.getPageContext());
        this.eSh = new com.baidu.tieba.ueg.d(this.cWF.getPageContext());
        this.cco.setLoadDataCallBack(this.eSt);
        this.eSf.a(this.eSu);
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.bee().m(this.eSd.getFragmentActivity(), l.r(this.eSd.getFragmentActivity()));
        initUI();
        initListener();
        bdM();
    }

    private void initListener() {
        bdL();
        this.eSd.registerListener(this.eSs);
        this.eSd.registerListener(this.eSr);
    }

    private static void aHr() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void bdL() {
        this.eSd.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eSe != null && a.this.eSe.bcZ()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                }
            }
        });
    }

    private void bdM() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.eSf != null && a.this.eSf.bek() != null && a.this.eSf.bek().bdd() != null && v.Z(a.this.eSf.bek().bdd().bdw()) > 0) {
                    Iterator<f> it = a.this.eSf.bek().bdd().bdw().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cWF.getPageContext().getPageActivity());
            aVar.mD(String.format(this.cWF.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.ki()) {
                        a.this.cWF.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.cWF.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
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
            aVar.b(this.cWF.getPageContext());
            aVar.afG();
        }
    }

    public void iZ(boolean z) {
        if (this.mWaitingDialog == null) {
            bdN();
        }
        this.mWaitingDialog.ef(z);
    }

    private void bdN() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.cWF.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.cWF.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.eSe = new com.baidu.tieba.enterForum.view.b(this.eSd, this.mRootView, this.eQo, this.eSg, this.eSf);
        this.eSe.setListPullRefreshListener(this.bZB);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ja(boolean z) {
        if (this.eSe != null && this.eSd != null) {
            if (z) {
                if (this.eSd.isPrimary() && this.eSd.isResumed()) {
                    this.eSe.startPullRefresh();
                } else {
                    this.eSe.oy();
                }
            } else {
                this.eSe.oy();
            }
            this.eSe.jl(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.eSd.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.eSe != null) {
            if (cVar == null) {
                this.eSe.bM(this.mRootView);
                return;
            }
            g bdd = cVar.bdd();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bdd != null) {
                arrayList = bdd.bdw();
            }
            bC(arrayList);
            if (b(cVar)) {
                this.eSe.bI(cVar.bde());
            }
            c(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.agM().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bdl() != null) {
                setSearchHint(hotSearchInfoData.bdl());
            }
            this.eSe.beS();
            this.eSe.qb(cVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.c cVar) {
        if (TbadkCoreApplication.isLogin() && cVar != null) {
            if ((cVar.bdd() == null || v.aa(cVar.bdd().bdw())) && com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.eSe.setSearchHint(str.trim());
        } else {
            this.eSe.setSearchHint(this.cWF.getActivity().getString(R.string.enter_forum_search_tip));
        }
    }

    private void bC(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.eSe.i(this.eSf.a(list, com.baidu.tbadk.util.d.auS()), this.eSf.bem());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bdg() != null && this.eSd.isPrimary() && this.eSi == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.cWF.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bdg())) {
                this.eSi = new com.baidu.tbadk.core.dialog.a(this.cWF.getActivity());
                this.eSi.hr(2);
                this.eSi.aF(frsPrivateCommonDialogView);
                this.eSi.dN(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aiz().c(a.this.cWF.getPageContext(), new String[]{cVar.bdg().acA()});
                        a.this.eSi.dismiss();
                        a.this.eSi = null;
                    }
                });
                this.eSi.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eSi = null;
                    }
                });
                this.eSi.b(this.cWF.getPageContext()).afG();
            }
        }
    }

    private void bdO() {
        if (this.eSi != null) {
            this.eSi.dismiss();
            this.eSi = null;
        }
    }

    public void loadData() {
        if (this.eSe != null) {
            jb(false);
        }
    }

    public void bdP() {
        if (this.eSe != null) {
            jb(true);
        }
    }

    public void onDestroy() {
        asz();
        com.baidu.tieba.enterForum.model.a.bee().destroy();
        if (this.eSe != null) {
            this.eSe.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.eSg != null) {
            this.eSg.onDestroy();
        }
        if (this.eSf != null) {
            this.eSf.onDestroy();
        }
        if (this.eQo != null) {
            this.eQo.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eSe != null) {
            this.eSe.onChangeSkinType(i);
        }
        if (this.eSp != null) {
            this.eSp.onChangeSkinType();
        }
    }

    public void asz() {
        if (this.eSf != null) {
            this.eSf.cancelLoadData();
        }
    }

    public void jb(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.eSq && this.eSf != null && this.eSe != null) {
            String str = this.eSl;
            this.eSl = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.eSl == null || this.eSl.equals(str)) {
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
                if (this.eSf != null && this.eSf.bek() != null && this.eSf.bek().bdd() != null) {
                    Iterator<f> it = this.eSf.bek().bdd().bdw().iterator();
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
                    com.baidu.tieba.tbadkCore.util.a.Ed(currentAccount);
                }
                this.eSe.notifyDataSetChanged();
            }
            if (z2 || z4) {
                asz();
                if (z4) {
                    if (this.eSf != null) {
                        this.eSf.jg(StringUtils.isNull(this.eSl) ? false : true);
                    }
                    this.eSg.LoadData();
                } else if (z2 && this.eSf != null) {
                    this.eSf.jg(StringUtils.isNull(this.eSl) ? false : true);
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
        if (this.eSd.isAdded() && this.eSd.isPrimary()) {
            if (this.eSg != null) {
                this.eSg.onPrimary();
            }
        } else {
            bdO();
        }
        if (this.eSe != null) {
            this.eSe.onPrimary();
        }
    }

    public void onPause() {
        if (this.eSe != null && this.eSe.beR() != null) {
            this.eSe.beR().completePullRefresh();
        }
        if (this.eSg != null) {
            this.eSg.onPause();
        }
        if (this.eSf != null) {
            this.eSf.onPause();
        }
        if (this.eSe != null) {
            this.eSe.onPause();
        }
    }

    public void bdQ() {
        if (this.eSe != null) {
            this.eSe.bL(this.mRootView);
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f eSA;
        private x mNetwork = null;

        public b(f fVar) {
            this.eSA = null;
            this.eSA = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eSA;
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
                    a.this.eSn = true;
                    if (a.this.eSd.isAdded() && a.this.cWF != null) {
                        a.this.cWF.showToast(a.this.cWF.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.k(false, this.eSA.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.eSA.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.eSA.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.eSA.getName()));
                    }
                    a.this.eSe.a(this.eSA, a.this.eSf.bem());
                    a.this.eSf.b(this.eSA);
                } else if (a.this.cWF != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cWF.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eSd.isAdded()) {
                        a.this.cWF.showToast(a.this.cWF.getActivity().getString(R.string.delete_like_fail));
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
        private f eSA;
        private x mNetwork = null;

        public C0299a(f fVar) {
            this.eSA = null;
            this.eSA = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eSA;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bdn() == 0) {
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
            int bdn = this.eSA.bdn();
            if (this.mNetwork != null) {
                if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                    a.this.eSn = true;
                    if (a.this.eSd.isAdded() && a.this.cWF != null) {
                        a.this.cWF.showToast(a.this.cWF.getActivity().getString(bdn > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.eSf.jf(true);
                } else if (a.this.cWF != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cWF.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eSd.isAdded()) {
                        a.this.cWF.showToast(a.this.cWF.getActivity().getString(bdn > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.bDL().w(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
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
                if (this.eSo != 2 && (atc instanceof f)) {
                    String name = ((f) atc).getName();
                    if (ap.bf(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.cWF.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
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
                                intent.putExtra("info_forum_head_background_color", ((f) atc).bds());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) atc).bdr().night != null && ((f) atc).bdr().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) atc).bdr().night.pattern_image);
                                    }
                                } else if (((f) atc).bdr().day != null && ((f) atc).bdr().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) atc).bdr().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) atc).bdv());
                            ((f) atc).cS(0L);
                        }
                        this.cWF.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.cWF.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        TiebaStatic.log(new am("c13368").l("uid", TbadkApplication.getCurrentAccountId()).P("obj_type", this.eSf.bek().getSortType() == 1 ? 2 : 1).bT("fid", ((f) atc).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.eSo == 2) {
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
                this.eSn = false;
                if (this.eSd.getView() == null || this.eSd.getView().getParent() == null) {
                    return true;
                }
                this.eSd.getView().getParent().requestDisallowInterceptTouchEvent(true);
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
                    bc.cD(this.cWF.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cWF.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.cWF.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cWF.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new am("c13367").bT("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").bT("obj_type", "2").P("obj_locate", 1));
                this.cWF.finish();
                return true;
            case 9:
                if (this.eSe != null) {
                    this.eSe.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.eSo = 2;
                return true;
            case 11:
                this.eSo = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.eSo != 2) {
                    if (this.eSp == null) {
                        this.eSp = new com.baidu.tieba.enterForum.view.d(this.cWF.getPageContext(), this.eQo);
                    }
                    if (atc instanceof f) {
                        this.eSp.c((f) atc);
                        this.eSp.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (atc instanceof f) {
                    new C0299a((f) atc).execute(new f[0]);
                    TiebaStatic.log(new am("c13370").P("obj_type", ((f) atc).bdn() <= 0 ? 1 : 2).bT("fid", ((f) atc).getId()).l("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aiz().c(this.cWF.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eSh.cqt() || !(atc instanceof f)) {
                    return true;
                }
                ba.aiz().c(this.cWF.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) atc).getId() + "&nomenu=1"});
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
        return this.cWF.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eSe != null) {
            this.eSe.setPageUniqueId(bdUniqueId);
        }
    }

    public void jc(boolean z) {
        int i;
        if (this.eSe != null && this.eSd != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eSe.setAdState(bVar);
        this.eSd.setAdState(bVar);
    }
}
