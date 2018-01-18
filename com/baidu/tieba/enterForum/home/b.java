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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.c;
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
    private BaseFragmentActivity bRS;
    private LikeModel cSD;
    private com.baidu.tieba.enterForum.home.a dmr;
    private EnterForumModel dmt;
    private boolean dmu;
    private String dmw;
    private long dmx;
    private boolean dmy;
    private boolean dmz;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b dms = null;
    private boolean dmv = false;
    private CustomMessageListener dmA = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.dmv = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a dmB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.dmt.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.dms.sV();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bRS.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bRS.showToast(errorString);
                    if (b.this.dms.isEmpty()) {
                        b.this.dms.bK(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.dmt.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.dmt.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener dmC = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.dmz = true;
        }
    };
    private com.baidu.adp.base.d dmD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (AntiHelper.vQ(b.this.cSD.getErrorCode())) {
                AntiHelper.ao(b.this.bRS.getPageContext().getPageActivity(), b.this.cSD.getErrorString());
            } else if (obj != null) {
                b.this.dmt.fn(!StringUtils.isNull(b.this.dmw));
            } else if (!StringUtils.isNull(b.this.cSD.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.cSD.getErrorString());
            }
        }
    };
    private final EnterForumModel.b dmE = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.dmr.isAdded()) {
                if (aVar.type == 1) {
                    b.this.dms.sV();
                }
                if (aVar.dmY) {
                    if (aVar.type == 1) {
                        b.this.dmu = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.dmZ);
                    } else if (aVar.type == 0 && !b.this.dmu) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.dmZ;
                        b.this.dmt.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bRS.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.dmx > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.dmx, b.this.dmt.apW() - b.this.dmx, b.this.dmt.apU(), b.this.dmt.apV(), currentTimeMillis - b.this.dmt.apT());
                    b.this.dmx = -1L;
                }
                if (aVar.dmZ == null || aVar.dmZ.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bRS.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.dmZ.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.apt() != null) {
                    b.this.setSearchHint(hotSearchInfoData.apt());
                }
            }
        }
    };
    private j.b baR = new j.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void onListPullRefresh(boolean z) {
            b.this.dmt.fn(!StringUtils.isNull(b.this.dmw));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter dlJ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        VT();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.dmt = null;
        this.isFirst = true;
        this.dmu = false;
        this.dmx = -1L;
        this.dmr = aVar;
        this.bRS = aVar.getBaseFragmentActivity();
        this.dlJ.addEventDelegate(this);
        this.dmx = System.currentTimeMillis();
        this.isFirst = true;
        this.dmu = false;
        this.dmw = "";
        this.dmt = new EnterForumModel(this.bRS.getPageContext());
        this.cSD = new LikeModel(this.bRS.getPageContext());
        this.cSD.setLoadDataCallBack(this.dmD);
        this.dmt.a(this.dmE);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.apO().y(this.dmr.getFragmentActivity(), l.n(this.dmr.getFragmentActivity()));
        initUI();
        initListener();
        apG();
    }

    private void initListener() {
        apJ();
        this.dmr.registerListener(this.dmC);
        this.dmr.registerListener(this.dmB);
        this.dmr.registerListener(this.dmA);
    }

    private static void VT() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void apG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (b.this.dmt != null && b.this.dmt.apX() != null && b.this.dmt.apX().apq() != null && v.D(b.this.dmt.apX().apq().apv()) > 0) {
                    Iterator<f> it = b.this.dmt.apX().apq().apv().iterator();
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
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, acVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.dmt.i(this.dms.aqj(), this.dms.aqk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.dms.aqh();
    }

    public View apI() {
        return this.dms.apI();
    }

    public void bI(View view) {
        this.dms.bI(view);
    }

    private void apJ() {
        this.dmr.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.apH();
                } else {
                    b.this.apK();
                }
                if (b.this.dmy) {
                    b.this.dms.startPullRefresh();
                }
            }
        });
        this.dmr.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dms.aqh();
                if (b.this.isChanged()) {
                    if (b.this.dms.isEmpty()) {
                        b.this.dms.bK(b.this.mRootView);
                        return;
                    } else {
                        b.this.dms.aqg();
                        b.this.dmt.aO(b.this.dms.aqj());
                    }
                }
                if (b.this.dmy) {
                    b.this.dms.startPullRefresh();
                }
            }
        });
    }

    public void apK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bRS.getPageContext().getPageActivity());
        aVar.fb(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.apH();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.fc(d.C0107d.cp_cont_b);
        aVar.b(this.bRS.getPageContext());
        aVar.AA();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bRS.getPageContext().getPageActivity());
            aVar.cZ(String.format(this.bRS.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.oZ()) {
                        b.this.bRS.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.bRS.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fc(d.C0107d.cp_cont_b);
            aVar.b(this.bRS.getPageContext());
            aVar.AA();
        }
    }

    public void fj(boolean z) {
        if (this.mWaitingDialog == null) {
            apL();
        }
        this.mWaitingDialog.bm(z);
    }

    private void apL() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.bRS.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bRS.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.dms = new com.baidu.tieba.enterForum.b.b(this.dmr, this.mRootView, this.dlJ);
        this.dms.a(this.baR);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fk(boolean z) {
        if (this.dms != null && this.dmr != null) {
            if (z) {
                if (this.dmr.isPrimary() && this.dmr.isResumed()) {
                    this.dms.startPullRefresh();
                    return;
                } else {
                    this.dms.sV();
                    return;
                }
            }
            this.dms.sV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.dmr.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.dms != null) {
            if (bVar == null) {
                this.dms.bK(this.mRootView);
                return;
            }
            g apq = bVar.apq();
            ArrayList<f> arrayList = new ArrayList<>();
            if (apq != null) {
                arrayList = apq.apv();
            }
            aM(arrayList);
            if (b(bVar)) {
                this.dms.aT(bVar.apr());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.apt() != null) {
                setSearchHint(hotSearchInfoData.apt());
            }
            this.dms.aql();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.apq() == null || v.E(bVar.apq().apv())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.dms.setSearchHint(str.trim());
        } else {
            this.dms.setSearchHint(this.bRS.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void aM(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.dms.aS(this.dmt.a(list, c.Op()));
        }
    }

    public void Vz() {
        if (this.dms != null) {
            fl(false);
        }
    }

    public void onDestroy() {
        LZ();
        com.baidu.tieba.enterForum.model.a.apO().destroy();
        if (this.dms != null) {
            if (this.dmt != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.dmt.aO(this.dms.aqj());
            }
            this.dms.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.dms != null) {
            this.dms.onChangeSkinType(i);
        }
    }

    public void LZ() {
        if (this.dmt != null) {
            this.dmt.cancelLoadData();
        }
    }

    public void fl(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.dmz && this.dmt != null && this.dms != null) {
            String str = this.dmw;
            this.dmw = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.dmw == null || this.dmw.equals(str)) {
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
                if (this.dmt != null && this.dmt.apX() != null && this.dmt.apX().apq() != null) {
                    Iterator<f> it = this.dmt.apX().apq().apv().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.mo(1);
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
                    com.baidu.tieba.tbadkCore.util.a.sA(currentAccount);
                }
                this.dms.notifyDataSetChanged();
            }
            if (z2 || z4) {
                LZ();
                if (z4) {
                    this.dmt.fn(StringUtils.isNull(this.dmw) ? false : true);
                } else if (z2) {
                    this.dmt.fo(!StringUtils.isNull(this.dmw));
                    this.dmt.fn(StringUtils.isNull(this.dmw) ? false : true);
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
        if (this.dms != null && this.dms.aqf() != null) {
            this.dms.aqf().completePullRefresh();
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f dmJ;
        private x mNetwork = null;

        public a(f fVar) {
            this.dmJ = null;
            this.dmJ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.dmJ;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.Cf().Db().mIsNeedTbs = true;
                        this.mNetwork.BH();
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
            b.this.fj(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.Cf().Dc().isRequestSuccess()) {
                    b.this.dmy = true;
                    if (b.this.dmr.isAdded() && b.this.bRS != null) {
                        b.this.bRS.showToast(b.this.bRS.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.f(false, this.dmJ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.dmJ.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.dmJ.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.dmJ.getName()));
                    }
                    b.this.dms.b(this.dmJ);
                } else if (b.this.bRS != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bRS.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.dmr.isAdded()) {
                        b.this.bRS.showToast(b.this.bRS.getActivity().getString(d.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.fj(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mR();
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
                    com.baidu.tieba.im.settingcache.d.aKp().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Mv = bVar.Mv();
        com.baidu.tbadk.mvc.b.a Mw = bVar.Mw();
        switch (Mv) {
            case 1:
                if (Mw instanceof f) {
                    String name = ((f) Mw).getName();
                    if (am.aT(name)) {
                        this.bRS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bRS.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<f> aqj = this.dms.aqj();
                        if (!v.E(aqj)) {
                            if (v.D(aqj) > 1 && aqj.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < aqj.size()) {
                                    if (!aqj.get(i2).getName().equals(name)) {
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.dms.mq(Mw instanceof h ? ((h) Mw).getPosition() : 0);
                this.dmy = false;
                if (this.dmr.getView() == null || this.dmr.getView().getParent() == null) {
                    return true;
                }
                this.dmr.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Mw instanceof f) {
                    a((f) Mw);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.bRS.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bRS.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.bRS.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bRS.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ab("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ab("obj_type", "2").s("obj_locate", 1));
                this.bRS.finish();
                return true;
            case 9:
                if (this.dms != null) {
                    this.dms.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void apM() {
        if (this.dms != null) {
            this.dms.aqi();
        }
    }

    public boolean apN() {
        if (this.dms != null) {
            return this.dms.apN();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Mu() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bRS.getUniqueId();
    }

    public void fm(boolean z) {
        int i = 1;
        if (this.dms != null && this.dmr != null) {
            boolean z2 = this.dms.apN() && this.dmr.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
