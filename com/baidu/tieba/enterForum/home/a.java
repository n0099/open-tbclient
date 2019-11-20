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
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private LikeModel crO;
    private BaseFragmentActivity diB;
    private EnterForumFragment faN;
    private EnterForumModel faP;
    private RecentlyVisitedForumModel faQ;
    private com.baidu.tieba.ueg.d faR;
    private boolean faT;
    private String faV;
    private long faW;
    private boolean faX;
    private com.baidu.tieba.enterForum.view.d faZ;
    private boolean fba;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b faO = null;
    private com.baidu.tbadk.core.dialog.a faS = null;
    private boolean faU = false;
    private int faY = 1;
    private CustomMessageListener fbb = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.faU = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fbc = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.faP.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.faO.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.diB.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.diB.showToast(errorString);
                    if (a.this.faO.isEmpty()) {
                        a.this.faO.bL(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.faP.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.faP.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d fbd = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.aG(a.this.crO.getErrorCode(), a.this.crO.getErrorString())) {
                AntiHelper.aS(a.this.diB.getPageContext().getPageActivity(), a.this.crO.getErrorString());
            } else if (obj != null) {
                a.this.faP.jh(!StringUtils.isNull(a.this.faV));
            } else if (!StringUtils.isNull(a.this.crO.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.crO.getErrorString());
            }
        }
    };
    private final EnterForumModel.b fbe = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.faN != null) {
                if (aVar.type == 1) {
                    a.this.faO.completeRefresh();
                }
                if (aVar.fcr) {
                    if (aVar.type == 1) {
                        a.this.faT = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.fcs;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.faT) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.fcs;
                        a.this.faP.d(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.diB.showToast(aVar.error);
                    a.this.faO.ps(com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.faW > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.faW, a.this.faP.beM() - a.this.faW, a.this.faP.beK(), a.this.faP.beL(), currentTimeMillis - a.this.faP.beJ());
                    a.this.faW = -1L;
                }
                String string = a.this.diB.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.fcs != null && aVar.fcs.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.fcs.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bdL() != null) {
                        string = hotSearchInfoData.bdL();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c cpa = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.faz.aEN();
            a.this.faP.jh(!StringUtils.isNull(a.this.faV));
            a.this.faQ.LoadData();
            a.this.faP.jg(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eYW = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aIS();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.faP = null;
        this.isFirst = true;
        this.faT = false;
        this.faW = -1L;
        this.faN = enterForumFragment;
        this.diB = enterForumFragment.getBaseFragmentActivity();
        this.eYW.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bpU();
        this.faW = System.currentTimeMillis();
        this.isFirst = true;
        this.faT = false;
        this.faV = "";
        this.faP = new EnterForumModel(this.diB.getPageContext());
        this.faQ = new RecentlyVisitedForumModel();
        this.crO = new LikeModel(this.diB.getPageContext());
        this.faR = new com.baidu.tieba.ueg.d(this.diB.getPageContext());
        this.crO.setLoadDataCallBack(this.fbd);
        this.faP.a(this.fbe);
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.beH().k(this.faN.getFragmentActivity(), l.getStatusBarHeight(this.faN.getFragmentActivity()));
        initUI();
        initListener();
        bem();
    }

    private void initListener() {
        bel();
        this.faN.registerListener(this.fbc);
        this.faN.registerListener(this.fbb);
    }

    private static void aIS() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, 1002400, Config.FORUM_RECOMMEND, forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void bel() {
        this.faN.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.faO != null && a.this.faO.bdz()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void bem() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.faP != null && a.this.faP.beN() != null && a.this.faP.beN().bdD() != null && v.getCount(a.this.faP.beN().bdD().bdW()) > 0) {
                    Iterator<f> it = a.this.faP.beN().bdD().bdW().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.toLong(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    aeVar.aq(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, aeVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.diB.getPageContext().getPageActivity());
            aVar.nn(String.format(this.diB.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.diB.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.diB.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.hU(R.color.cp_cont_b);
            aVar.b(this.diB.getPageContext());
            aVar.akM();
        }
    }

    public void jb(boolean z) {
        if (this.mWaitingDialog == null) {
            ben();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void ben() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.diB.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.diB.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.faO = new com.baidu.tieba.enterForum.view.b(this.faN, this.mRootView, this.eYW, this.faQ, this.faP);
        this.faO.setListPullRefreshListener(this.cpa);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jc(boolean z) {
        if (this.faO != null && this.faN != null) {
            if (z) {
                if (this.faN.isPrimary() && this.faN.isResumed()) {
                    this.faO.startPullRefresh();
                } else {
                    this.faO.completeRefresh();
                }
            } else {
                this.faO.completeRefresh();
            }
            this.faO.jn(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.faN.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.faO != null) {
            if (cVar == null) {
                this.faO.bL(this.mRootView);
                return;
            }
            g bdD = cVar.bdD();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bdD != null) {
                arrayList = bdD.bdW();
            }
            bR(arrayList);
            if (b(cVar)) {
                this.faO.bX(cVar.bdE());
            }
            c(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bdL() != null) {
                setSearchHint(hotSearchInfoData.bdL());
            }
            this.faO.bfA();
            this.faO.ps(cVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.c cVar) {
        if (TbadkCoreApplication.isLogin() && cVar != null) {
            if ((cVar.bdD() == null || v.isEmpty(cVar.bdD().bdW())) && com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false)) {
                return com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.faN.bei() != null) {
            if (!StringUtils.isNull(str)) {
                this.faN.bei().setSearchHint(str.trim());
            } else {
                this.faN.bei().setSearchHint(this.diB.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bR(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.faO.j(this.faP.a(list, com.baidu.tbadk.util.d.axs()), this.faP.beP());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bdG() != null && this.faN.isPrimary() && this.faS == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.diB.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bdG())) {
                this.faS = new com.baidu.tbadk.core.dialog.a(this.diB.getActivity());
                this.faS.hW(2);
                this.faS.aM(frsPrivateCommonDialogView);
                this.faS.eh(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.amO().b(a.this.diB.getPageContext(), new String[]{cVar.bdG().ahJ()});
                        a.this.faS.dismiss();
                        a.this.faS = null;
                    }
                });
                this.faS.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.faS = null;
                    }
                });
                this.faS.b(this.diB.getPageContext()).akM();
            }
        }
    }

    private void beo() {
        if (this.faS != null) {
            this.faS.dismiss();
            this.faS = null;
        }
    }

    public void loadData() {
        if (this.faO != null) {
            jd(false);
        }
    }

    public void bep() {
        if (this.faO != null) {
            jd(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.beH().destroy();
        if (this.faO != null) {
            this.faO.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.faQ != null) {
            this.faQ.onDestroy();
        }
        if (this.faP != null) {
            this.faP.onDestroy();
        }
        if (this.eYW != null) {
            this.eYW.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.faO != null) {
            this.faO.onChangeSkinType(i);
        }
        if (this.faZ != null) {
            this.faZ.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.faP != null) {
            this.faP.cancelLoadData();
        }
    }

    public void jd(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.fba && this.faP != null && this.faO != null) {
            String str = this.faV;
            this.faV = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.faV == null || this.faV.equals(str)) {
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
                if (this.faP != null && this.faP.beN() != null && this.faP.beN().bdD() != null) {
                    Iterator<f> it = this.faP.beN().bdD().bdW().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.pu(1);
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
                    com.baidu.tieba.tbadkCore.util.a.DV(currentAccount);
                }
                this.faO.notifyDataSetChanged();
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.faP != null) {
                        this.faP.ji(StringUtils.isNull(this.faV) ? false : true);
                    }
                    this.faQ.LoadData();
                } else if (z2 && this.faP != null) {
                    this.faP.ji(StringUtils.isNull(this.faV) ? false : true);
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
        if (this.faN.isAdded() && this.faN.isPrimary()) {
            if (this.faQ != null) {
                this.faQ.onPrimary();
            }
        } else {
            beo();
        }
        if (this.faO != null) {
            this.faO.onPrimary();
        }
    }

    public void onPause() {
        if (this.faO != null && this.faO.bfz() != null) {
            this.faO.bfz().completePullRefresh();
        }
        if (this.faQ != null) {
            this.faQ.onPause();
        }
        if (this.faP != null) {
            this.faP.onPause();
        }
        if (this.faO != null) {
            this.faO.onPause();
        }
    }

    public void beq() {
        if (this.faO != null) {
            this.faO.bK(this.mRootView);
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f fbk;
        private x mNetwork = null;

        public b(f fVar) {
            this.fbk = null;
            this.fbk = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fbk;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.amp().amP().mIsNeedTbs = true;
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
            a.this.jb(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.amp().amQ().isRequestSuccess()) {
                    a.this.faX = true;
                    if (a.this.faN.isAdded() && a.this.diB != null) {
                        a.this.diB.showToast(a.this.diB.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.fbk.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.fbk.getId()));
                    long j = com.baidu.adp.lib.g.b.toLong(this.fbk.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.fbk.getName()));
                    }
                    a.this.faO.a(this.fbk, a.this.faP.beP());
                    a.this.faP.b(this.fbk);
                } else if (a.this.diB != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.diB.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.faN.isAdded()) {
                        a.this.diB.showToast(a.this.diB.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.jb(true);
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
    /* loaded from: classes4.dex */
    private class C0400a extends BdAsyncTask<f, Integer, String> {
        private f fbk;
        private x mNetwork = null;

        public C0400a(f fVar) {
            this.fbk = null;
            this.fbk = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fbk;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bdN() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.amp().amP().mIsNeedTbs = true;
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
            super.onPostExecute((C0400a) str);
            a.this.jb(false);
            int bdN = this.fbk.bdN();
            if (this.mNetwork != null) {
                if (this.mNetwork.amp().amQ().isRequestSuccess()) {
                    a.this.faX = true;
                    if (a.this.faN.isAdded() && a.this.diB != null) {
                        a.this.diB.showToast(a.this.diB.getActivity().getString(bdN > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.faP.jh(true);
                } else if (a.this.diB != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.diB.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.faN.isAdded()) {
                        a.this.diB.showToast(a.this.diB.getActivity().getString(bdN > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.jb(true);
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
                    com.baidu.tieba.im.settingcache.d.bEd().x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int avO = bVar.avO();
        com.baidu.tbadk.mvc.b.a avP = bVar.avP();
        switch (avO) {
            case 1:
                if (this.faY != 2 && (avP instanceof f)) {
                    String name = ((f) avP).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.diB.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) avP).atK() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) avP).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) avP).bdS());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) avP).bdR().night != null && ((f) avP).bdR().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) avP).bdR().night.pattern_image);
                                    }
                                } else if (((f) avP).bdR().day != null && ((f) avP).bdR().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) avP).bdR().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) avP).bdV());
                            ((f) avP).cB(0L);
                        }
                        this.diB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.diB.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").p("uid", TbadkApplication.getCurrentAccountId()).O("obj_type", this.faP.beN().getSortType() == 1 ? 2 : 1).bS("fid", ((f) avP).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.faY == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (avP instanceof com.baidu.tieba.enterForum.data.h) {
                    ((com.baidu.tieba.enterForum.data.h) avP).getPosition();
                }
                this.faX = false;
                if (this.faN.getView() == null || this.faN.getView().getParent() == null) {
                    return true;
                }
                this.faN.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (avP instanceof f) {
                    a((f) avP);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.diB.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.diB.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.diB.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.diB.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").bS("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).bS("obj_type", "2").O("obj_locate", 1));
                this.diB.finish();
                return true;
            case 9:
                if (this.faO != null) {
                    this.faO.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.faY = 2;
                return true;
            case 11:
                this.faY = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.faY != 2) {
                    if (this.faZ == null) {
                        this.faZ = new com.baidu.tieba.enterForum.view.d(this.diB.getPageContext(), this.eYW);
                    }
                    if (avP instanceof f) {
                        this.faZ.c((f) avP);
                        this.faZ.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (avP instanceof f) {
                    new C0400a((f) avP).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").O("obj_type", ((f) avP).bdN() <= 0 ? 1 : 2).bS("fid", ((f) avP).getId()).p("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.amO().b(this.diB.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.faR.csa() || !(avP instanceof f)) {
                    return true;
                }
                ba.amO().b(this.diB.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) avP).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.avQ());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.avQ());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.avQ());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean avN() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.diB.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.faO != null) {
            this.faO.setPageUniqueId(bdUniqueId);
        }
    }

    public void je(boolean z) {
        int i;
        if (this.faO != null && this.faN != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.faO.setAdState(bVar);
        this.faN.setAdState(bVar);
    }
}
