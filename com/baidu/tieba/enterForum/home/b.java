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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel bZp;
    private BaseFragmentActivity bey;
    private com.baidu.tieba.enterForum.home.a ctf;
    private EnterForumModel cth;
    private boolean cti;
    private String ctk;
    private long ctl;
    private boolean ctm;
    private boolean ctn;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b ctg = null;
    private boolean ctj = false;
    private final CustomMessageListener bez = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.ctg != null) {
                b.this.ctg.startPullRefresh();
            }
        }
    };
    private CustomMessageListener cto = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ctj = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a ctp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.cth.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.ctg.ahy();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bey.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bey.showToast(errorString);
                    if (b.this.ctg.isEmpty()) {
                        b.this.ctg.at(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.cth.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.cth.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener ctq = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ctn = true;
        }
    };
    private com.baidu.adp.base.d ctr = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.uq(b.this.bZp.getErrorCode())) {
                AntiHelper.an(b.this.bey.getPageContext().getPageActivity(), b.this.bZp.getErrorString());
            } else if (obj != null) {
                b.this.cth.eB(!StringUtils.isNull(b.this.ctk));
            } else if (!StringUtils.isNull(b.this.bZp.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.bZp.getErrorString());
            }
        }
    };
    private final EnterForumModel.b cts = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.ctf.isAdded()) {
                if (aVar.type == 1) {
                    b.this.ctg.ahy();
                }
                if (aVar.ctN) {
                    if (aVar.type == 1) {
                        b.this.cti = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.ctO);
                    } else if (aVar.type == 0 && !b.this.cti) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.ctO;
                        b.this.cth.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bey.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.ctl > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.ctl, b.this.cth.ahl() - b.this.ctl, b.this.cth.ahj(), b.this.cth.ahk(), currentTimeMillis - b.this.cth.ahi());
                    b.this.ctl = -1L;
                }
                if (aVar.ctO == null || aVar.ctO.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bey.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.ctO.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.agI() != null) {
                    b.this.setSearchHint(hotSearchInfoData.agI());
                }
            }
        }
    };
    private g.b amU = new g.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            b.this.cth.eB(!StringUtils.isNull(b.this.ctk));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter csw = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        OG();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.cth = null;
        this.isFirst = true;
        this.cti = false;
        this.ctl = -1L;
        this.ctf = aVar;
        this.bey = aVar.getBaseFragmentActivity();
        this.csw.addEventDelegate(this);
        this.ctl = System.currentTimeMillis();
        this.isFirst = true;
        this.cti = false;
        this.ctk = "";
        this.cth = new EnterForumModel(this.bey.getPageContext());
        this.bZp = new LikeModel(this.bey.getPageContext());
        this.bZp.setLoadDataCallBack(this.ctr);
        this.cth.a(this.cts);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.ahd().l(this.ctf.getFragmentActivity(), l.n(this.ctf.getFragmentActivity()));
        initUI();
        initListener();
        agV();
    }

    private void initListener() {
        agY();
        this.ctf.registerListener(this.ctq);
        this.ctf.registerListener(this.ctp);
        this.ctf.registerListener(this.bez);
        this.ctf.registerListener(this.cto);
    }

    private static void OG() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void agV() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (b.this.cth != null && b.this.cth.ahm() != null && b.this.cth.ahm().agF() != null && v.v(b.this.cth.ahm().agF().agK()) > 0) {
                    Iterator<f> it = b.this.cth.ahm().agF().agK().iterator();
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
                    acVar.r(arrayList);
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, acVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.cth.i(this.ctg.ahz(), this.ctg.ahA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agW() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.ctg.ahw();
    }

    public View agX() {
        return this.ctg.agX();
    }

    public void ar(View view) {
        this.ctg.ar(view);
    }

    private void agY() {
        this.ctf.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.agW();
                } else {
                    b.this.agZ();
                }
                if (b.this.ctm) {
                    b.this.ctg.startPullRefresh();
                }
            }
        });
        this.ctf.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ctg.ahw();
                if (b.this.isChanged()) {
                    if (b.this.ctg.isEmpty()) {
                        b.this.ctg.at(b.this.mRootView);
                        return;
                    } else {
                        b.this.ctg.ahv();
                        b.this.cth.aF(b.this.ctg.ahz());
                    }
                }
                if (b.this.ctm) {
                    b.this.ctg.startPullRefresh();
                }
            }
        });
    }

    public void agZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bey.getPageContext().getPageActivity());
        aVar.cd(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.agW();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.ce(d.C0082d.cp_cont_b);
        aVar.b(this.bey.getPageContext());
        aVar.tk();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bey.getPageContext().getPageActivity());
            aVar.cS(String.format(this.bey.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.hy()) {
                        b.this.bey.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.bey.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ce(d.C0082d.cp_cont_b);
            aVar.b(this.bey.getPageContext());
            aVar.tk();
        }
    }

    public void ex(boolean z) {
        if (this.mWaitingDialog == null) {
            aha();
        }
        this.mWaitingDialog.aE(z);
    }

    private void aha() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.bey.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bey.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.ctg = new com.baidu.tieba.enterForum.b.b(this.ctf, this.mRootView, this.csw);
        this.ctg.a(this.amU);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ey(boolean z) {
        if (this.ctg != null && this.ctf != null) {
            if (z) {
                if (this.ctf.isPrimary() && this.ctf.isResumed()) {
                    this.ctg.startPullRefresh();
                    return;
                } else {
                    this.ctg.ahy();
                    return;
                }
            }
            this.ctg.ahy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.ctf.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.ctg != null) {
            if (bVar == null) {
                this.ctg.at(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g agF = bVar.agF();
            ArrayList<f> arrayList = new ArrayList<>();
            if (agF != null) {
                arrayList = agF.agK();
            }
            aD(arrayList);
            if (b(bVar)) {
                this.ctg.aK(bVar.agG());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.agI() != null) {
                setSearchHint(hotSearchInfoData.agI());
            }
            this.ctg.ahB();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.agF() == null || v.w(bVar.agF().agK())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.ctg.setSearchHint(str.trim());
        } else {
            this.ctg.setSearchHint(this.bey.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void aD(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ctg.aJ(this.cth.a(list, c.Hb()));
        }
    }

    public void Om() {
        if (this.ctg != null) {
            ez(false);
        }
    }

    public void onDestroy() {
        EK();
        com.baidu.tieba.enterForum.model.a.ahd().destroy();
        if (this.ctg != null) {
            if (this.cth != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.cth.aF(this.ctg.ahz());
            }
            this.ctg.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.ctg != null) {
            this.ctg.onChangeSkinType(i);
        }
    }

    public void EK() {
        if (this.cth != null) {
            this.cth.cancelLoadData();
        }
    }

    public void ez(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.ctn && this.cth != null && this.ctg != null) {
            String str = this.ctk;
            this.ctk = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.ctk == null || this.ctk.equals(str)) {
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
                if (this.cth != null && this.cth.ahm() != null && this.cth.ahm().agF() != null) {
                    Iterator<f> it = this.cth.ahm().agF().agK().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.jl(1);
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
                    com.baidu.tieba.tbadkCore.util.a.tc(currentAccount);
                }
                this.ctg.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EK();
                if (z4) {
                    this.cth.eB(StringUtils.isNull(this.ctk) ? false : true);
                } else if (z2) {
                    this.cth.eC(!StringUtils.isNull(this.ctk));
                    this.cth.eB(StringUtils.isNull(this.ctk) ? false : true);
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
        if (this.ctg != null && this.ctg.ahu() != null) {
            this.ctg.ahu().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f cty;
        private x mNetwork = null;

        public a(f fVar) {
            this.cty = null;
            this.cty = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.cty;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.uQ().vN().mIsNeedTbs = true;
                        this.mNetwork.us();
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
            b.this.ex(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.uQ().vO().isRequestSuccess()) {
                    b.this.ctm = true;
                    if (b.this.ctf.isAdded() && b.this.bey != null) {
                        b.this.bey.showToast(b.this.bey.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.f(false, this.cty.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.cty.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.cty.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.cty.getName()));
                    }
                    b.this.ctg.b(this.cty);
                } else if (b.this.bey != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bey.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.ctf.isAdded()) {
                        b.this.bey.showToast(b.this.bey.getActivity().getString(d.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.ex(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aCZ().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Fh = bVar.Fh();
        com.baidu.tbadk.mvc.b.a Fi = bVar.Fi();
        switch (Fh) {
            case 1:
                if (Fi instanceof f) {
                    String name = ((f) Fi).getName();
                    if (am.aL(name)) {
                        this.bey.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bey.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<f> ahz = this.ctg.ahz();
                        if (!v.w(ahz)) {
                            if (v.v(ahz) > 1 && ahz.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < ahz.size()) {
                                    if (!ahz.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new ak("c12049").ac("obj_type", "2").r("obj_locate", i));
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
                this.ctg.jn(Fi instanceof h ? ((h) Fi).getPosition() : 0);
                this.ctm = false;
                if (this.ctf.getView() == null || this.ctf.getView().getParent() == null) {
                    return true;
                }
                this.ctf.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Fi instanceof f) {
                    a((f) Fi);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.bey.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bey.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.bey.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bey.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ac("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ac("obj_type", "2").r("obj_locate", 1));
                this.bey.finish();
                return true;
            case 9:
                if (this.ctg != null) {
                    this.ctg.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void ahb() {
        if (this.ctg != null) {
            this.ctg.ahx();
        }
    }

    public boolean ahc() {
        if (this.ctg != null) {
            return this.ctg.ahc();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fg() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bey.getUniqueId();
    }

    public void eA(boolean z) {
        int i = 1;
        if (this.ctg != null && this.ctf != null) {
            boolean z2 = this.ctg.ahc() && this.ctf.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
