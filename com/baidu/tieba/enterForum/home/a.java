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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity dWk;
    private LikeModel dfB;
    private String fPA;
    private long fPB;
    private boolean fPC;
    private com.baidu.tieba.enterForum.view.d fPE;
    private boolean fPF;
    private EnterForumFragment fPt;
    private EnterForumModel fPv;
    private RecentlyVisitedForumModel fPw;
    private com.baidu.tieba.ueg.d fPx;
    private boolean fPy;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b fPu = null;
    private com.baidu.tbadk.core.dialog.a dPm = null;
    private boolean fPz = false;
    private int fPD = 1;
    private CustomMessageListener fPG = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.fPz = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fPH = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.fPv.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.fPu.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.dWk.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.dWk.showToast(errorString);
                    if (a.this.fPu.isEmpty()) {
                        a.this.fPu.bG(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.fPv.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.fPv.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d fPI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.aW(a.this.dfB.getErrorCode(), a.this.dfB.getErrorString())) {
                AntiHelper.bj(a.this.dWk.getPageContext().getPageActivity(), a.this.dfB.getErrorString());
            } else if (obj != null) {
                a.this.fPv.kt(!StringUtils.isNull(a.this.fPA));
            } else if (!StringUtils.isNull(a.this.dfB.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.dfB.getErrorString());
            }
        }
    };
    private final EnterForumModel.b fPJ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.fPt != null) {
                if (aVar.type == 1) {
                    a.this.fPu.completeRefresh();
                }
                if (aVar.isOk) {
                    if (aVar.type == 1) {
                        a.this.fPy = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.fQV;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.fPy) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.fQV;
                        a.this.fPv.d(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.dWk.showToast(aVar.error);
                    a.this.fPu.ry(com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.fPB > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.fPB, a.this.fPv.bwg() - a.this.fPB, a.this.fPv.bwe(), a.this.fPv.bwf(), currentTimeMillis - a.this.fPv.bwd());
                    a.this.fPB = -1L;
                }
                String string = a.this.dWk.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.fQV != null && aVar.fQV.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.fQV.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bvh() != null) {
                        string = hotSearchInfoData.bvh();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private g.c dcr = new g.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.fPf.loadAd();
            a.this.fPv.kt(!StringUtils.isNull(a.this.fPA));
            a.this.fPw.LoadData();
            a.this.fPv.ks(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter fNE = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aZq();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.fPv = null;
        this.isFirst = true;
        this.fPy = false;
        this.fPB = -1L;
        this.fPt = enterForumFragment;
        this.dWk = enterForumFragment.getBaseFragmentActivity();
        this.fNE.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bHp();
        this.fPB = System.currentTimeMillis();
        this.isFirst = true;
        this.fPy = false;
        this.fPA = "";
        this.fPv = new EnterForumModel(this.dWk.getPageContext());
        this.fPw = new RecentlyVisitedForumModel();
        this.dfB = new LikeModel(this.dWk.getPageContext());
        this.fPx = new com.baidu.tieba.ueg.d(this.dWk.getPageContext());
        this.dfB.setLoadDataCallBack(this.fPI);
        this.fPv.a(this.fPJ);
        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.bwb().init(this.fPt.getFragmentActivity(), l.getStatusBarHeight(this.fPt.getFragmentActivity()));
        initUI();
        initListener();
        bvI();
    }

    private void initListener() {
        bvH();
        this.fPt.registerListener(this.fPH);
        this.fPt.registerListener(this.fPG);
    }

    private static void aZq() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, 1002400, Config.FORUM_RECOMMEND, forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void bvH() {
        this.fPt.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fPu != null && a.this.fPu.buV()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bvI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<af>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<af> run(CustomMessage<af> customMessage) {
                af afVar = new af();
                ArrayList arrayList = new ArrayList();
                if (a.this.fPv != null && a.this.fPv.bwh() != null && a.this.fPv.bwh().buZ() != null && v.getCount(a.this.fPv.bwh().buZ().bvs()) > 0) {
                    Iterator<f> it = a.this.fPv.bwh().buZ().bvs().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.f.b.toLong(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    afVar.aw(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, afVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dWk.getPageContext().getPageActivity());
            aVar.sz(String.format(this.dWk.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.dWk.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.dWk.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.jG(R.color.cp_cont_b);
            aVar.b(this.dWk.getPageContext());
            aVar.aBW();
        }
    }

    public void kn(boolean z) {
        if (this.mWaitingDialog == null) {
            bvJ();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bvJ() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.dWk.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.dWk.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.fPu = new com.baidu.tieba.enterForum.view.b(this.fPt, this.mRootView, this.fNE, this.fPw, this.fPv);
        this.fPu.setListPullRefreshListener(this.dcr);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ko(boolean z) {
        if (this.fPu != null && this.fPt != null) {
            if (z) {
                if (this.fPt.isPrimary() && this.fPt.isResumed()) {
                    this.fPu.startPullRefresh();
                } else {
                    this.fPu.completeRefresh();
                }
            } else {
                this.fPu.completeRefresh();
            }
            this.fPu.kz(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.fPt.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.fPu != null) {
            if (cVar == null) {
                this.fPu.bG(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g buZ = cVar.buZ();
            ArrayList<f> arrayList = new ArrayList<>();
            if (buZ != null) {
                arrayList = buZ.bvs();
            }
            bN(arrayList);
            if (b(cVar)) {
                this.fPu.bT(cVar.bva());
            }
            c(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bvh() != null) {
                setSearchHint(hotSearchInfoData.bvh());
            }
            this.fPu.bwV();
            this.fPu.ry(cVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.c cVar) {
        if (TbadkCoreApplication.isLogin() && cVar != null) {
            if ((cVar.buZ() == null || v.isEmpty(cVar.buZ().bvs())) && com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false)) {
                return com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.fPt.bvE() != null) {
            if (!StringUtils.isNull(str)) {
                this.fPt.bvE().setSearchHint(str.trim());
            } else {
                this.fPt.bvE().setSearchHint(this.dWk.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bN(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.fPu.k(this.fPv.a(list, com.baidu.tbadk.util.e.aPj()), this.fPv.bwj());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bvc() != null && this.fPt.isPrimary() && this.dPm == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.dWk.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bvc())) {
                this.dPm = new com.baidu.tbadk.core.dialog.a(this.dWk.getActivity());
                this.dPm.jI(2);
                this.dPm.aK(frsPrivateCommonDialogView);
                this.dPm.fv(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aEa().b(a.this.dWk.getPageContext(), new String[]{cVar.bvc().ayJ()});
                        a.this.dPm.dismiss();
                        a.this.dPm = null;
                    }
                });
                this.dPm.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.dPm = null;
                    }
                });
                this.dPm.b(this.dWk.getPageContext()).aBW();
            }
        }
    }

    private void bvK() {
        if (this.dPm != null) {
            this.dPm.dismiss();
            this.dPm = null;
        }
    }

    public void loadData() {
        if (this.fPu != null) {
            kp(false);
        }
    }

    public void bvL() {
        if (this.fPu != null) {
            kp(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.bwb().destroy();
        if (this.fPu != null) {
            this.fPu.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.fPw != null) {
            this.fPw.onDestroy();
        }
        if (this.fPv != null) {
            this.fPv.onDestroy();
        }
        if (this.fNE != null) {
            this.fNE.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fPu != null) {
            this.fPu.onChangeSkinType(i);
        }
        if (this.fPE != null) {
            this.fPE.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.fPv != null) {
            this.fPv.cancelLoadData();
        }
    }

    public void kp(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.fPF && this.fPv != null && this.fPu != null) {
            String str = this.fPA;
            this.fPA = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.fPA == null || this.fPA.equals(str)) {
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
                if (this.fPv != null && this.fPv.bwh() != null && this.fPv.bwh().buZ() != null) {
                    Iterator<f> it = this.fPv.bwh().buZ().bvs().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.rA(1);
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
                    com.baidu.tieba.tbadkCore.util.a.IK(currentAccount);
                }
                this.fPu.notifyDataSetChanged();
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.fPv != null) {
                        this.fPv.ku(StringUtils.isNull(this.fPA) ? false : true);
                    }
                    this.fPw.LoadData();
                } else if (z2 && this.fPv != null) {
                    this.fPv.ku(StringUtils.isNull(this.fPA) ? false : true);
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
        if (this.fPt.isAdded() && this.fPt.isPrimary()) {
            if (this.fPw != null) {
                this.fPw.onPrimary();
            }
        } else {
            bvK();
        }
        if (this.fPu != null) {
            this.fPu.onPrimary();
        }
    }

    public void onPause() {
        if (this.fPu != null && this.fPu.bwU() != null) {
            this.fPu.bwU().completePullRefresh();
        }
        if (this.fPw != null) {
            this.fPw.onPause();
        }
        if (this.fPv != null) {
            this.fPv.onPause();
        }
        if (this.fPu != null) {
            this.fPu.onPause();
        }
    }

    public void ahZ() {
        if (this.fPu != null) {
            this.fPu.bF(this.mRootView);
        }
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f fPO;
        private x mNetwork = null;

        public b(f fVar) {
            this.fPO = null;
            this.fPO = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fPO;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.aDB().aEb().mIsNeedTbs = true;
                        this.mNetwork.postNetData();
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
            a.this.kn(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.aDB().aEc().isRequestSuccess()) {
                    a.this.fPC = true;
                    if (a.this.fPt.isAdded() && a.this.dWk != null) {
                        a.this.dWk.showToast(a.this.dWk.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.fPO.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.fPO.getId()));
                    long j = com.baidu.adp.lib.f.b.toLong(this.fPO.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.fPO.getName()));
                    }
                    a.this.fPu.a(this.fPO, a.this.fPv.bwj());
                    a.this.fPv.b(this.fPO);
                } else if (a.this.dWk != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.dWk.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fPt.isAdded()) {
                        a.this.dWk.showToast(a.this.dWk.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.kn(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0483a extends BdAsyncTask<f, Integer, String> {
        private f fPO;
        private x mNetwork = null;

        public C0483a(f fVar) {
            this.fPO = null;
            this.fPO = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fPO;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bvj() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.aDB().aEb().mIsNeedTbs = true;
                        this.mNetwork.postNetData();
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
            super.onPostExecute((C0483a) str);
            a.this.kn(false);
            int bvj = this.fPO.bvj();
            if (this.mNetwork != null) {
                if (this.mNetwork.aDB().aEc().isRequestSuccess()) {
                    a.this.fPC = true;
                    if (a.this.fPt.isAdded() && a.this.dWk != null) {
                        a.this.dWk.showToast(a.this.dWk.getActivity().getString(bvj > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.fPv.kt(true);
                } else if (a.this.dWk != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.dWk.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fPt.isAdded()) {
                        a.this.dWk.showToast(a.this.dWk.getActivity().getString(bvj > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.kn(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
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
                    com.baidu.tieba.im.settingcache.d.bVp().x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aNy = bVar.aNy();
        com.baidu.tbadk.mvc.b.a aNz = bVar.aNz();
        switch (aNy) {
            case 1:
                if (this.fPD != 2 && (aNz instanceof f)) {
                    String name = ((f) aNz).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.dWk.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) aNz).aLp() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) aNz).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) aNz).bvo());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) aNz).bvn().night != null && ((f) aNz).bvn().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) aNz).bvn().night.pattern_image);
                                    }
                                } else if (((f) aNz).bvn().day != null && ((f) aNz).bvn().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) aNz).bvn().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) aNz).bvr());
                            ((f) aNz).dh(0L);
                        }
                        this.dWk.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.dWk.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").s("uid", TbadkApplication.getCurrentAccountId()).Z("obj_type", this.fPv.bwh().getSortType() == 1 ? 2 : 1).cp("fid", ((f) aNz).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.fPD == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (aNz instanceof h) {
                    ((h) aNz).getPosition();
                }
                this.fPC = false;
                if (this.fPt.getView() == null || this.fPt.getView().getParent() == null) {
                    return true;
                }
                this.fPt.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (aNz instanceof f) {
                    a((f) aNz);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.dWk.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.dWk.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.dWk.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.dWk.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").cp("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).cp("obj_type", "2").Z("obj_locate", 1));
                this.dWk.finish();
                return true;
            case 9:
                if (this.fPu != null) {
                    this.fPu.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.fPD = 2;
                return true;
            case 11:
                this.fPD = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.fPD != 2) {
                    if (this.fPE == null) {
                        this.fPE = new com.baidu.tieba.enterForum.view.d(this.dWk.getPageContext(), this.fNE);
                    }
                    if (aNz instanceof f) {
                        this.fPE.c((f) aNz);
                        this.fPE.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (aNz instanceof f) {
                    new C0483a((f) aNz).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").Z("obj_type", ((f) aNz).bvj() <= 0 ? 1 : 2).cp("fid", ((f) aNz).getId()).s("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.aEa().b(this.dWk.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fPx.cMc() || !(aNz instanceof f)) {
                    return true;
                }
                ba.aEa().b(this.dWk.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) aNz).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aNA());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aNA());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.aNA());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aNx() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.dWk.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fPu != null) {
            this.fPu.setPageUniqueId(bdUniqueId);
        }
    }

    public void kq(boolean z) {
        int i;
        if (this.fPu != null && this.fPt != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fPu.setAdState(bVar);
        this.fPt.setAdState(bVar);
    }
}
