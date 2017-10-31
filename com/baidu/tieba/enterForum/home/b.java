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
import com.baidu.tbadk.core.data.ag;
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
    private LikeModel bRe;
    private BaseFragmentActivity bbe;
    private com.baidu.tieba.enterForum.home.a cki;
    private EnterForumModel ckk;
    private boolean ckl;
    private String ckn;
    private long cko;
    private boolean ckp;
    private boolean ckq;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b ckj = null;
    private boolean ckm = false;
    private final CustomMessageListener bbf = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.ckj != null) {
                b.this.ckj.startPullRefresh();
            }
        }
    };
    private CustomMessageListener ckr = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ckm = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a cks = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.ckk.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.ckj.afz();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bbe.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bbe.showToast(errorString);
                    if (b.this.ckj.isEmpty()) {
                        b.this.ckj.ar(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.ckk.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.ckk.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener ckt = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ckq = true;
        }
    };
    private com.baidu.adp.base.d cku = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.tW(b.this.bRe.getErrorCode())) {
                AntiHelper.ao(b.this.bbe.getPageContext().getPageActivity(), b.this.bRe.getErrorString());
            } else if (obj != null) {
                b.this.ckk.ef(!StringUtils.isNull(b.this.ckn));
            } else if (!StringUtils.isNull(b.this.bRe.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.bRe.getErrorString());
            }
        }
    };
    private final EnterForumModel.b ckv = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.cki.isAdded()) {
                if (aVar.type == 1) {
                    b.this.ckj.afz();
                }
                if (aVar.ckO) {
                    if (aVar.type == 1) {
                        b.this.ckl = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.ckP);
                    } else if (aVar.type == 0 && !b.this.ckl) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.ckP;
                        b.this.ckk.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bbe.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.cko > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.cko, b.this.ckk.afl() - b.this.cko, b.this.ckk.afj(), b.this.ckk.afk(), currentTimeMillis - b.this.ckk.afi());
                    b.this.cko = -1L;
                }
                if (aVar.ckP == null || aVar.ckP.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bbe.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.ckP.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.aeK() != null) {
                    b.this.setSearchHint(hotSearchInfoData.aeK());
                }
            }
        }
    };
    private g.b amz = new g.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            b.this.ckk.ef(!StringUtils.isNull(b.this.ckn));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter cjC = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        ND();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.ckk = null;
        this.isFirst = true;
        this.ckl = false;
        this.cko = -1L;
        this.cki = aVar;
        this.bbe = aVar.getBaseFragmentActivity();
        this.cjC.addEventDelegate(this);
        this.cko = System.currentTimeMillis();
        this.isFirst = true;
        this.ckl = false;
        this.ckn = "";
        this.ckk = new EnterForumModel(this.bbe.getPageContext());
        this.bRe = new LikeModel(this.bbe.getPageContext());
        this.bRe.setLoadDataCallBack(this.cku);
        this.ckk.a(this.ckv);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.afd().l(this.cki.getFragmentActivity(), l.n(this.cki.getFragmentActivity()));
        initUI();
        initListener();
        aeW();
    }

    private void initListener() {
        aeY();
        this.cki.registerListener(this.ckt);
        this.cki.registerListener(this.cks);
        this.cki.registerListener(this.bbf);
        this.cki.registerListener(this.ckr);
    }

    private static void ND() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aeW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ag>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ag> run(CustomMessage<ag> customMessage) {
                ag agVar = new ag();
                ArrayList arrayList = new ArrayList();
                if (b.this.ckk != null && b.this.ckk.afm() != null && b.this.ckk.afm().aeH() != null && v.u(b.this.ckk.afm().aeH().aeM()) > 0) {
                    Iterator<f> it = b.this.ckk.afm().aeH().aeM().iterator();
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
                    agVar.q(arrayList);
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, agVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.ckk.h(this.ckj.afA(), this.ckj.afB());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeX() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.ckj.afx();
    }

    private void aeY() {
        this.cki.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.aeX();
                } else {
                    b.this.aeZ();
                }
                if (b.this.ckp) {
                    b.this.ckj.startPullRefresh();
                }
            }
        });
        this.cki.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ckj.afx();
                if (b.this.isChanged()) {
                    if (b.this.ckj.isEmpty()) {
                        b.this.ckj.ar(b.this.mRootView);
                        return;
                    } else {
                        b.this.ckj.afw();
                        b.this.ckk.at(b.this.ckj.afA());
                    }
                }
                if (b.this.ckp) {
                    b.this.ckj.startPullRefresh();
                }
            }
        });
    }

    public void aeZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bbe.getPageContext().getPageActivity());
        aVar.cc(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.aeX();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cd(d.C0080d.cp_cont_b);
        aVar.b(this.bbe.getPageContext());
        aVar.th();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bbe.getPageContext().getPageActivity());
            aVar.cS(String.format(this.bbe.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.hy()) {
                        b.this.bbe.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.bbe.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cd(d.C0080d.cp_cont_b);
            aVar.b(this.bbe.getPageContext());
            aVar.th();
        }
    }

    public void eb(boolean z) {
        if (this.mWaitingDialog == null) {
            afa();
        }
        this.mWaitingDialog.aE(z);
    }

    private void afa() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.bbe.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bbe.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.ckj = new com.baidu.tieba.enterForum.b.b(this.cki, this.mRootView, this.cjC);
        this.ckj.a(this.amz);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ec(boolean z) {
        if (this.ckj != null && this.cki != null) {
            if (z) {
                if (this.cki.isPrimary() && this.cki.isResumed()) {
                    this.ckj.startPullRefresh();
                    return;
                } else {
                    this.ckj.afz();
                    return;
                }
            }
            this.ckj.afz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cki.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.ckj != null) {
            if (bVar == null) {
                this.ckj.ar(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.data.g aeH = bVar.aeH();
            ArrayList<f> arrayList = new ArrayList<>();
            if (aeH != null) {
                arrayList = aeH.aeM();
            }
            ar(arrayList);
            if (b(bVar)) {
                this.ckj.ay(bVar.aeI());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.aeK() != null) {
                setSearchHint(hotSearchInfoData.aeK());
            }
            this.ckj.afC();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.aeH() == null || v.v(bVar.aeH().aeM())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.ckj.setSearchHint(str.trim());
        } else {
            this.ckj.setSearchHint(this.bbe.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void ar(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ckj.ax(this.ckk.a(list, c.GJ()));
        }
    }

    public void Rx() {
        if (this.ckj != null) {
            ed(false);
        }
    }

    public void onDestroy() {
        Er();
        com.baidu.tieba.enterForum.model.a.afd().destroy();
        if (this.ckj != null) {
            if (this.ckk != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.ckk.at(this.ckj.afA());
            }
            this.ckj.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.ckj != null) {
            this.ckj.onChangeSkinType(i);
        }
    }

    public void Er() {
        if (this.ckk != null) {
            this.ckk.cancelLoadData();
        }
    }

    public void ed(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.ckq && this.ckk != null && this.ckj != null) {
            String str = this.ckn;
            this.ckn = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.ckn == null || this.ckn.equals(str)) {
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
                if (this.ckk != null && this.ckk.afm() != null && this.ckk.afm().aeH() != null) {
                    Iterator<f> it = this.ckk.afm().aeH().aeM().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.iP(1);
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
                    com.baidu.tieba.tbadkCore.util.a.sz(currentAccount);
                }
                this.ckj.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Er();
                if (z4) {
                    this.ckk.ef(StringUtils.isNull(this.ckn) ? false : true);
                } else if (z2) {
                    this.ckk.eg(!StringUtils.isNull(this.ckn));
                    this.ckk.ef(StringUtils.isNull(this.ckn) ? false : true);
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
        if (this.ckj != null && this.ckj.afv() != null) {
            this.ckj.afv().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f ckz;
        private x mNetwork = null;

        public a(f fVar) {
            this.ckz = null;
            this.ckz = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.ckz;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.n("kw", fVar.getName());
                        this.mNetwork.uN().vK().mIsNeedTbs = true;
                        this.mNetwork.up();
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
            b.this.eb(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.uN().vL().isRequestSuccess()) {
                    b.this.ckp = true;
                    if (b.this.cki.isAdded() && b.this.bbe != null) {
                        b.this.bbe.showToast(b.this.bbe.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.e(false, this.ckz.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.ckz.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.ckz.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.ckz.getName()));
                    }
                    b.this.ckj.b(this.ckz);
                } else if (b.this.bbe != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bbe.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.cki.isAdded()) {
                        b.this.bbe.showToast(b.this.bbe.getActivity().getString(d.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.eb(true);
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
    public void e(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.b.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aBv().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int EO = bVar.EO();
        com.baidu.tbadk.mvc.b.a EP = bVar.EP();
        switch (EO) {
            case 1:
                if (EP instanceof f) {
                    String name = ((f) EP).getName();
                    if (am.aL(name)) {
                        this.bbe.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bbe.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<f> afA = this.ckj.afA();
                        if (!v.v(afA)) {
                            if (v.u(afA) > 1 && afA.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < afA.size()) {
                                    if (!afA.get(i2).getName().equals(name)) {
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
                this.ckj.iR(EP instanceof h ? ((h) EP).getPosition() : 0);
                this.ckp = false;
                if (this.cki.getView() == null || this.cki.getView().getParent() == null) {
                    return true;
                }
                this.cki.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (EP instanceof f) {
                    a((f) EP);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.bbe.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bbe.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.bbe.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bbe.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ac("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ac("obj_type", "2").r("obj_locate", 1));
                this.bbe.finish();
                return true;
            case 9:
                if (this.ckj != null) {
                    this.ckj.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void afb() {
        if (this.ckj != null) {
            this.ckj.afy();
        }
    }

    public boolean afc() {
        if (this.ckj != null) {
            return this.ckj.afc();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EN() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bbe.getUniqueId();
    }

    public void ee(boolean z) {
        int i = 1;
        if (this.ckj != null && this.cki != null) {
            boolean z2 = this.ckj.afc() && this.cki.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
