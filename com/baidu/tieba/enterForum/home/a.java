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
    private LikeModel csF;
    private BaseFragmentActivity djs;
    private EnterForumFragment fbE;
    private EnterForumModel fbG;
    private RecentlyVisitedForumModel fbH;
    private com.baidu.tieba.ueg.d fbI;
    private boolean fbK;
    private String fbM;
    private long fbN;
    private boolean fbO;
    private com.baidu.tieba.enterForum.view.d fbQ;
    private boolean fbR;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b fbF = null;
    private com.baidu.tbadk.core.dialog.a fbJ = null;
    private boolean fbL = false;
    private int fbP = 1;
    private CustomMessageListener fbS = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.fbL = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fbT = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.fbG.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.fbF.completeRefresh();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.djs.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.djs.showToast(errorString);
                    if (a.this.fbF.isEmpty()) {
                        a.this.fbF.bL(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.fbG.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.fbG.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d fbU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.aH(a.this.csF.getErrorCode(), a.this.csF.getErrorString())) {
                AntiHelper.aS(a.this.djs.getPageContext().getPageActivity(), a.this.csF.getErrorString());
            } else if (obj != null) {
                a.this.fbG.jh(!StringUtils.isNull(a.this.fbM));
            } else if (!StringUtils.isNull(a.this.csF.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.csF.getErrorString());
            }
        }
    };
    private final EnterForumModel.b fbV = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.fbE != null) {
                if (aVar.type == 1) {
                    a.this.fbF.completeRefresh();
                }
                if (aVar.fdi) {
                    if (aVar.type == 1) {
                        a.this.fbK = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.fdj;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.fbK) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.fdj;
                        a.this.fbG.d(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.djs.showToast(aVar.error);
                    a.this.fbF.pt(com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.fbN > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_FORUM_ENTER, currentTimeMillis - a.this.fbN, a.this.fbG.beO() - a.this.fbN, a.this.fbG.beM(), a.this.fbG.beN(), currentTimeMillis - a.this.fbG.beL());
                    a.this.fbN = -1L;
                }
                String string = a.this.djs.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.fdj != null && aVar.fdj.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.fdj.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.HOT_SEARCH_INFO, OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bdN() != null) {
                        string = hotSearchInfoData.bdN();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c cpS = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            EnterForumDelegateStatic.fbq.aEP();
            a.this.fbG.jh(!StringUtils.isNull(a.this.fbM));
            a.this.fbH.LoadData();
            a.this.fbG.jg(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eZN = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aIU();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.fbG = null;
        this.isFirst = true;
        this.fbK = false;
        this.fbN = -1L;
        this.fbE = enterForumFragment;
        this.djs = enterForumFragment.getBaseFragmentActivity();
        this.eZN.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bpW();
        this.fbN = System.currentTimeMillis();
        this.isFirst = true;
        this.fbK = false;
        this.fbM = "";
        this.fbG = new EnterForumModel(this.djs.getPageContext());
        this.fbH = new RecentlyVisitedForumModel();
        this.csF = new LikeModel(this.djs.getPageContext());
        this.fbI = new com.baidu.tieba.ueg.d(this.djs.getPageContext());
        this.csF.setLoadDataCallBack(this.fbU);
        this.fbG.a(this.fbV);
        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        com.baidu.tieba.enterForum.model.a.beJ().k(this.fbE.getFragmentActivity(), l.getStatusBarHeight(this.fbE.getFragmentActivity()));
        initUI();
        initListener();
        beo();
    }

    private void initListener() {
        ben();
        this.fbE.registerListener(this.fbT);
        this.fbE.registerListener(this.fbS);
    }

    private static void aIU() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, 1002400, Config.FORUM_RECOMMEND, forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void ben() {
        this.fbE.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fbF != null && a.this.fbF.bdB()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                }
            }
        });
    }

    private void beo() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.fbG != null && a.this.fbG.beP() != null && a.this.fbG.beP().bdF() != null && v.getCount(a.this.fbG.beP().bdF().bdY()) > 0) {
                    Iterator<f> it = a.this.fbG.beP().bdF().bdY().iterator();
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.djs.getPageContext().getPageActivity());
            aVar.nn(String.format(this.djs.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.isNetOk()) {
                        a.this.djs.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.djs.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.hV(R.color.cp_cont_b);
            aVar.b(this.djs.getPageContext());
            aVar.akO();
        }
    }

    public void jb(boolean z) {
        if (this.mWaitingDialog == null) {
            bep();
        }
        this.mWaitingDialog.setDialogVisiable(z);
    }

    private void bep() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.djs.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.djs.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.fbF = new com.baidu.tieba.enterForum.view.b(this.fbE, this.mRootView, this.eZN, this.fbH, this.fbG);
        this.fbF.setListPullRefreshListener(this.cpS);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jc(boolean z) {
        if (this.fbF != null && this.fbE != null) {
            if (z) {
                if (this.fbE.isPrimary() && this.fbE.isResumed()) {
                    this.fbF.startPullRefresh();
                } else {
                    this.fbF.completeRefresh();
                }
            } else {
                this.fbF.completeRefresh();
            }
            this.fbF.jn(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.fbE.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.fbF != null) {
            if (cVar == null) {
                this.fbF.bL(this.mRootView);
                return;
            }
            g bdF = cVar.bdF();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bdF != null) {
                arrayList = bdF.bdY();
            }
            bR(arrayList);
            if (b(cVar)) {
                this.fbF.bX(cVar.bdG());
            }
            c(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bdN() != null) {
                setSearchHint(hotSearchInfoData.bdN());
            }
            this.fbF.bfC();
            this.fbF.pt(cVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.c cVar) {
        if (TbadkCoreApplication.isLogin() && cVar != null) {
            if ((cVar.bdF() == null || v.isEmpty(cVar.bdF().bdY())) && com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false)) {
                return com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.fbE.bek() != null) {
            if (!StringUtils.isNull(str)) {
                this.fbE.bek().setSearchHint(str.trim());
            } else {
                this.fbE.bek().setSearchHint(this.djs.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bR(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.fbF.j(this.fbG.a(list, com.baidu.tbadk.util.d.axu()), this.fbG.beR());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bdI() != null && this.fbE.isPrimary() && this.fbJ == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.djs.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bdI())) {
                this.fbJ = new com.baidu.tbadk.core.dialog.a(this.djs.getActivity());
                this.fbJ.hX(2);
                this.fbJ.aM(frsPrivateCommonDialogView);
                this.fbJ.eh(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.amQ().b(a.this.djs.getPageContext(), new String[]{cVar.bdI().ahL()});
                        a.this.fbJ.dismiss();
                        a.this.fbJ = null;
                    }
                });
                this.fbJ.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.fbJ = null;
                    }
                });
                this.fbJ.b(this.djs.getPageContext()).akO();
            }
        }
    }

    private void beq() {
        if (this.fbJ != null) {
            this.fbJ.dismiss();
            this.fbJ = null;
        }
    }

    public void loadData() {
        if (this.fbF != null) {
            jd(false);
        }
    }

    public void ber() {
        if (this.fbF != null) {
            jd(true);
        }
    }

    public void onDestroy() {
        cancelAllAsyncTask();
        com.baidu.tieba.enterForum.model.a.beJ().destroy();
        if (this.fbF != null) {
            this.fbF.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.fbH != null) {
            this.fbH.onDestroy();
        }
        if (this.fbG != null) {
            this.fbG.onDestroy();
        }
        if (this.eZN != null) {
            this.eZN.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fbF != null) {
            this.fbF.onChangeSkinType(i);
        }
        if (this.fbQ != null) {
            this.fbQ.onChangeSkinType();
        }
    }

    public void cancelAllAsyncTask() {
        if (this.fbG != null) {
            this.fbG.cancelLoadData();
        }
    }

    public void jd(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.fbR && this.fbG != null && this.fbF != null) {
            String str = this.fbM;
            this.fbM = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.fbM == null || this.fbM.equals(str)) {
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
                if (this.fbG != null && this.fbG.beP() != null && this.fbG.beP().bdF() != null) {
                    Iterator<f> it = this.fbG.beP().bdF().bdY().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.pv(1);
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
                this.fbF.notifyDataSetChanged();
            }
            if (z2 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    if (this.fbG != null) {
                        this.fbG.ji(StringUtils.isNull(this.fbM) ? false : true);
                    }
                    this.fbH.LoadData();
                } else if (z2 && this.fbG != null) {
                    this.fbG.ji(StringUtils.isNull(this.fbM) ? false : true);
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
        if (this.fbE.isAdded() && this.fbE.isPrimary()) {
            if (this.fbH != null) {
                this.fbH.onPrimary();
            }
        } else {
            beq();
        }
        if (this.fbF != null) {
            this.fbF.onPrimary();
        }
    }

    public void onPause() {
        if (this.fbF != null && this.fbF.bfB() != null) {
            this.fbF.bfB().completePullRefresh();
        }
        if (this.fbH != null) {
            this.fbH.onPause();
        }
        if (this.fbG != null) {
            this.fbG.onPause();
        }
        if (this.fbF != null) {
            this.fbF.onPause();
        }
    }

    public void bes() {
        if (this.fbF != null) {
            this.fbF.bK(this.mRootView);
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f fcb;
        private x mNetwork = null;

        public b(f fVar) {
            this.fcb = null;
            this.fcb = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fcb;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.UNFAVO_ADDRESS);
                        this.mNetwork.addPostData("fid", fVar.getId());
                        this.mNetwork.addPostData("kw", fVar.getName());
                        this.mNetwork.amr().amR().mIsNeedTbs = true;
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
                if (this.mNetwork.amr().amS().isRequestSuccess()) {
                    a.this.fbO = true;
                    if (a.this.fbE.isAdded() && a.this.djs != null) {
                        a.this.djs.showToast(a.this.djs.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.fcb.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.fcb.getId()));
                    long j = com.baidu.adp.lib.g.b.toLong(this.fcb.getId(), 0L);
                    if (j > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(j)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.fcb.getName()));
                    }
                    a.this.fbF.a(this.fcb, a.this.fbG.beR());
                    a.this.fbG.b(this.fcb);
                } else if (a.this.djs != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.djs.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fbE.isAdded()) {
                        a.this.djs.showToast(a.this.djs.getActivity().getString(R.string.delete_like_fail));
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
        private f fcb;
        private x mNetwork = null;

        public C0400a(f fVar) {
            this.fcb = null;
            this.fcb = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.fcb;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bdP() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.addPostData("forum_id", fVar.getId());
                        this.mNetwork.amr().amR().mIsNeedTbs = true;
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
            int bdP = this.fcb.bdP();
            if (this.mNetwork != null) {
                if (this.mNetwork.amr().amS().isRequestSuccess()) {
                    a.this.fbO = true;
                    if (a.this.fbE.isAdded() && a.this.djs != null) {
                        a.this.djs.showToast(a.this.djs.getActivity().getString(bdP > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.fbG.jh(true);
                } else if (a.this.djs != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.djs.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.fbE.isAdded()) {
                        a.this.djs.showToast(a.this.djs.getActivity().getString(bdP > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
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
                    com.baidu.tieba.im.settingcache.d.bEf().x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int avQ = bVar.avQ();
        com.baidu.tbadk.mvc.b.a avR = bVar.avR();
        switch (avQ) {
            case 1:
                if (this.fbP != 2 && (avR instanceof f)) {
                    String name = ((f) avR).getName();
                    if (aq.isForumName(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.djs.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) avR).atM() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) avR).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) avR).bdU());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) avR).bdT().night != null && ((f) avR).bdT().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) avR).bdT().night.pattern_image);
                                    }
                                } else if (((f) avR).bdT().day != null && ((f) avR).bdT().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) avR).bdT().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) avR).bdX());
                            ((f) avR).cC(0L);
                        }
                        this.djs.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                        if (this.djs.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").p("uid", TbadkApplication.getCurrentAccountId()).O("obj_type", this.fbG.beP().getSortType() == 1 ? 2 : 1).bS("fid", ((f) avR).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.fbP == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, true);
                if (avR instanceof com.baidu.tieba.enterForum.data.h) {
                    ((com.baidu.tieba.enterForum.data.h) avR).getPosition();
                }
                this.fbO = false;
                if (this.fbE.getView() == null || this.fbE.getView().getParent() == null) {
                    return true;
                }
                this.fbE.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
                return true;
            case 4:
                if (avR instanceof f) {
                    a((f) avR);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.djs.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.djs.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.djs.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.djs.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").bS("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).bS("obj_type", "2").O("obj_locate", 1));
                this.djs.finish();
                return true;
            case 9:
                if (this.fbF != null) {
                    this.fbF.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.fbP = 2;
                return true;
            case 11:
                this.fbP = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
                return true;
            case 12:
                if (this.fbP != 2) {
                    if (this.fbQ == null) {
                        this.fbQ = new com.baidu.tieba.enterForum.view.d(this.djs.getPageContext(), this.eZN);
                    }
                    if (avR instanceof f) {
                        this.fbQ.c((f) avR);
                        this.fbQ.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (avR instanceof f) {
                    new C0400a((f) avR).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").O("obj_type", ((f) avR).bdP() <= 0 ? 1 : 2).bS("fid", ((f) avR).getId()).p("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.amQ().b(this.djs.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.fbI.csc() || !(avR instanceof f)) {
                    return true;
                }
                ba.amQ().b(this.djs.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) avR).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.avS());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.avS());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.avS());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean avP() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.djs.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fbF != null) {
            this.fbF.setPageUniqueId(bdUniqueId);
        }
    }

    public void je(boolean z) {
        int i;
        if (this.fbF != null && this.fbE != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fbF.setAdState(bVar);
        this.fbE.setAdState(bVar);
    }
}
