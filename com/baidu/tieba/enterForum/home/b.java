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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.i;
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
    private BaseFragmentActivity bRL;
    private LikeModel cOc;
    private com.baidu.tieba.enterForum.home.a dhQ;
    private EnterForumModel dhS;
    private boolean dhT;
    private String dhV;
    private long dhW;
    private boolean dhX;
    private boolean dhY;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b dhR = null;
    private boolean dhU = false;
    private CustomMessageListener dhZ = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.dhU = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a dia = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.dhS.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.dhR.sV();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bRL.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bRL.showToast(errorString);
                    if (b.this.dhR.isEmpty()) {
                        b.this.dhR.bI(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.dhS.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.dhS.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener dib = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.dhY = true;
        }
    };
    private com.baidu.adp.base.d dic = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (AntiHelper.xo(b.this.cOc.getErrorCode())) {
                AntiHelper.ap(b.this.bRL.getPageContext().getPageActivity(), b.this.cOc.getErrorString());
            } else if (obj != null) {
                b.this.dhS.fj(!StringUtils.isNull(b.this.dhV));
            } else if (!StringUtils.isNull(b.this.cOc.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.cOc.getErrorString());
            }
        }
    };
    private final EnterForumModel.b did = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.dhQ.isAdded()) {
                if (aVar.type == 1) {
                    b.this.dhR.sV();
                }
                if (aVar.dix) {
                    if (aVar.type == 1) {
                        b.this.dhT = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.diy);
                    } else if (aVar.type == 0 && !b.this.dhT) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.diy;
                        b.this.dhS.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bRL.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.dhW > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.dhW, b.this.dhS.aoT() - b.this.dhW, b.this.dhS.aoR(), b.this.dhS.aoS(), currentTimeMillis - b.this.dhS.aoQ());
                    b.this.dhW = -1L;
                }
                if (aVar.diy == null || aVar.diy.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bRL.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.diy.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.aoq() != null) {
                    b.this.setSearchHint(hotSearchInfoData.aoq());
                }
            }
        }
    };
    private i.b baS = new i.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tbadk.core.view.i.b
        public void onListPullRefresh(boolean z) {
            b.this.dhS.fj(!StringUtils.isNull(b.this.dhV));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter dhh = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Wf();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.dhS = null;
        this.isFirst = true;
        this.dhT = false;
        this.dhW = -1L;
        this.dhQ = aVar;
        this.bRL = aVar.getBaseFragmentActivity();
        this.dhh.addEventDelegate(this);
        this.dhW = System.currentTimeMillis();
        this.isFirst = true;
        this.dhT = false;
        this.dhV = "";
        this.dhS = new EnterForumModel(this.bRL.getPageContext());
        this.cOc = new LikeModel(this.bRL.getPageContext());
        this.cOc.setLoadDataCallBack(this.dic);
        this.dhS.a(this.did);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aoL().y(this.dhQ.getFragmentActivity(), l.n(this.dhQ.getFragmentActivity()));
        initUI();
        initListener();
        aoD();
    }

    private void initListener() {
        aoG();
        this.dhQ.registerListener(this.dib);
        this.dhQ.registerListener(this.dia);
        this.dhQ.registerListener(this.dhZ);
    }

    private static void Wf() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aoD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ad>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ad> run(CustomMessage<ad> customMessage) {
                ad adVar = new ad();
                ArrayList arrayList = new ArrayList();
                if (b.this.dhS != null && b.this.dhS.aoU() != null && b.this.dhS.aoU().aon() != null && v.F(b.this.dhS.aoU().aon().aos()) > 0) {
                    Iterator<f> it = b.this.dhS.aoU().aon().aos().iterator();
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
                    adVar.B(arrayList);
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, adVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.dhS.i(this.dhR.apg(), this.dhR.aph());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoE() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.dhR.ape();
    }

    public View aoF() {
        return this.dhR.aoF();
    }

    public void bG(View view) {
        this.dhR.bG(view);
    }

    private void aoG() {
        this.dhQ.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.aoE();
                } else {
                    b.this.aoH();
                }
                if (b.this.dhX) {
                    b.this.dhR.startPullRefresh();
                }
            }
        });
        this.dhQ.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dhR.ape();
                if (b.this.isChanged()) {
                    if (b.this.dhR.isEmpty()) {
                        b.this.dhR.bI(b.this.mRootView);
                        return;
                    } else {
                        b.this.dhR.apd();
                        b.this.dhS.aQ(b.this.dhR.apg());
                    }
                }
                if (b.this.dhX) {
                    b.this.dhR.startPullRefresh();
                }
            }
        });
    }

    public void aoH() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bRL.getPageContext().getPageActivity());
        aVar.fd(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.aoE();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.fe(d.C0108d.cp_cont_b);
        aVar.b(this.bRL.getPageContext());
        aVar.AI();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bRL.getPageContext().getPageActivity());
            aVar.cZ(String.format(this.bRL.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.oZ()) {
                        b.this.bRL.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.bRL.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fe(d.C0108d.cp_cont_b);
            aVar.b(this.bRL.getPageContext());
            aVar.AI();
        }
    }

    public void ff(boolean z) {
        if (this.mWaitingDialog == null) {
            aoI();
        }
        this.mWaitingDialog.bm(z);
    }

    private void aoI() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.bRL.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bRL.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.dhR = new com.baidu.tieba.enterForum.b.b(this.dhQ, this.mRootView, this.dhh);
        this.dhR.a(this.baS);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fg(boolean z) {
        if (this.dhR != null && this.dhQ != null) {
            if (z) {
                if (this.dhQ.isPrimary() && this.dhQ.isResumed()) {
                    this.dhR.startPullRefresh();
                    return;
                } else {
                    this.dhR.sV();
                    return;
                }
            }
            this.dhR.sV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.dhQ.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.dhR != null) {
            if (bVar == null) {
                this.dhR.bI(this.mRootView);
                return;
            }
            g aon = bVar.aon();
            ArrayList<f> arrayList = new ArrayList<>();
            if (aon != null) {
                arrayList = aon.aos();
            }
            aO(arrayList);
            if (b(bVar)) {
                this.dhR.aV(bVar.aoo());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aoq() != null) {
                setSearchHint(hotSearchInfoData.aoq());
            }
            this.dhR.api();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.aon() == null || v.G(bVar.aon().aos())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.dhR.setSearchHint(str.trim());
        } else {
            this.dhR.setSearchHint(this.bRL.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void aO(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.dhR.aU(this.dhS.a(list, c.OB()));
        }
    }

    public void VL() {
        if (this.dhR != null) {
            fh(false);
        }
    }

    public void onDestroy() {
        Ml();
        com.baidu.tieba.enterForum.model.a.aoL().destroy();
        if (this.dhR != null) {
            if (this.dhS != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.dhS.aQ(this.dhR.apg());
            }
            this.dhR.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.dhR != null) {
            this.dhR.onChangeSkinType(i);
        }
    }

    public void Ml() {
        if (this.dhS != null) {
            this.dhS.cancelLoadData();
        }
    }

    public void fh(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.dhY && this.dhS != null && this.dhR != null) {
            String str = this.dhV;
            this.dhV = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.dhV == null || this.dhV.equals(str)) {
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
                if (this.dhS != null && this.dhS.aoU() != null && this.dhS.aoU().aon() != null) {
                    Iterator<f> it = this.dhS.aoU().aon().aos().iterator();
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
                    com.baidu.tieba.tbadkCore.util.a.tg(currentAccount);
                }
                this.dhR.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ml();
                if (z4) {
                    this.dhS.fj(StringUtils.isNull(this.dhV) ? false : true);
                } else if (z2) {
                    this.dhS.fk(!StringUtils.isNull(this.dhV));
                    this.dhS.fj(StringUtils.isNull(this.dhV) ? false : true);
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
        if (this.dhR != null && this.dhR.apc() != null) {
            this.dhR.apc().completePullRefresh();
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f dii;
        private x mNetwork = null;

        public a(f fVar) {
            this.dii = null;
            this.dii = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.dii;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.Cn().Dk().mIsNeedTbs = true;
                        this.mNetwork.BP();
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
            b.this.ff(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.Cn().Dl().isRequestSuccess()) {
                    b.this.dhX = true;
                    if (b.this.dhQ.isAdded() && b.this.bRL != null) {
                        b.this.bRL.showToast(b.this.bRL.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.f(false, this.dii.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.dii.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.dii.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.dii.getName()));
                    }
                    b.this.dhR.b(this.dii);
                } else if (b.this.bRL != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bRL.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.dhQ.isAdded()) {
                        b.this.bRL.showToast(b.this.bRL.getActivity().getString(d.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.ff(true);
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
                    com.baidu.tieba.im.settingcache.d.aKk().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int MH = bVar.MH();
        com.baidu.tbadk.mvc.b.a MI = bVar.MI();
        switch (MH) {
            case 1:
                if (MI instanceof f) {
                    String name = ((f) MI).getName();
                    if (am.aT(name)) {
                        this.bRL.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bRL.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<f> apg = this.dhR.apg();
                        if (!v.G(apg)) {
                            if (v.F(apg) > 1 && apg.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < apg.size()) {
                                    if (!apg.get(i2).getName().equals(name)) {
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
                this.dhR.mn(MI instanceof h ? ((h) MI).getPosition() : 0);
                this.dhX = false;
                if (this.dhQ.getView() == null || this.dhQ.getView().getParent() == null) {
                    return true;
                }
                this.dhQ.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (MI instanceof f) {
                    a((f) MI);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.bRL.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bRL.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.bRL.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bRL.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ab("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ab("obj_type", "2").s("obj_locate", 1));
                this.bRL.finish();
                return true;
            case 9:
                if (this.dhR != null) {
                    this.dhR.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void aoJ() {
        if (this.dhR != null) {
            this.dhR.apf();
        }
    }

    public boolean aoK() {
        if (this.dhR != null) {
            return this.dhR.aoK();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean MG() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bRL.getUniqueId();
    }

    public void fi(boolean z) {
        int i = 1;
        if (this.dhR != null && this.dhQ != null) {
            boolean z2 = this.dhR.aoK() && this.dhQ.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
