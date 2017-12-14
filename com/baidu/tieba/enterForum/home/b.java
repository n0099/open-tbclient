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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel bZt;
    private BaseFragmentActivity bez;
    private com.baidu.tieba.enterForum.home.a cto;
    private EnterForumModel ctq;
    private boolean ctr;
    private String ctt;
    private long ctu;
    private boolean ctv;
    private boolean ctw;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b ctp = null;
    private boolean cts = false;
    private final CustomMessageListener beA = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.ctp != null) {
                b.this.ctp.startPullRefresh();
            }
        }
    };
    private CustomMessageListener cty = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cts = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a ctz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.ctq.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.ctp.ahG();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.bez.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.bez.showToast(errorString);
                    if (b.this.ctp.isEmpty()) {
                        b.this.ctp.au(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.ctq.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.ctq.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener ctA = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ctw = true;
        }
    };
    private com.baidu.adp.base.d ctB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.uB(b.this.bZt.getErrorCode())) {
                AntiHelper.am(b.this.bez.getPageContext().getPageActivity(), b.this.bZt.getErrorString());
            } else if (obj != null) {
                b.this.ctq.eC(!StringUtils.isNull(b.this.ctt));
            } else if (!StringUtils.isNull(b.this.bZt.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.bZt.getErrorString());
            }
        }
    };
    private final EnterForumModel.b ctC = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.cto.isAdded()) {
                if (aVar.type == 1) {
                    b.this.ctp.ahG();
                }
                if (aVar.ctW) {
                    if (aVar.type == 1) {
                        b.this.ctr = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.ctX);
                    } else if (aVar.type == 0 && !b.this.ctr) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.ctX;
                        b.this.ctq.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.bez.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.ctu > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.ctu, b.this.ctq.aht() - b.this.ctu, b.this.ctq.ahr(), b.this.ctq.ahs(), currentTimeMillis - b.this.ctq.ahq());
                    b.this.ctu = -1L;
                }
                if (aVar.ctX == null || aVar.ctX.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.bez.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.ctX.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.agQ() != null) {
                    b.this.setSearchHint(hotSearchInfoData.agQ());
                }
            }
        }
    };
    private h.b amR = new h.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefresh(boolean z) {
            b.this.ctq.eC(!StringUtils.isNull(b.this.ctt));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter csF = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        OG();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.ctq = null;
        this.isFirst = true;
        this.ctr = false;
        this.ctu = -1L;
        this.cto = aVar;
        this.bez = aVar.getBaseFragmentActivity();
        this.csF.addEventDelegate(this);
        this.ctu = System.currentTimeMillis();
        this.isFirst = true;
        this.ctr = false;
        this.ctt = "";
        this.ctq = new EnterForumModel(this.bez.getPageContext());
        this.bZt = new LikeModel(this.bez.getPageContext());
        this.bZt.setLoadDataCallBack(this.ctB);
        this.ctq.a(this.ctC);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.ahl().l(this.cto.getFragmentActivity(), l.n(this.cto.getFragmentActivity()));
        initUI();
        initListener();
        ahd();
    }

    private void initListener() {
        ahg();
        this.cto.registerListener(this.ctA);
        this.cto.registerListener(this.ctz);
        this.cto.registerListener(this.beA);
        this.cto.registerListener(this.cty);
    }

    private static void OG() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void ahd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (b.this.ctq != null && b.this.ctq.ahu() != null && b.this.ctq.ahu().agN() != null && v.v(b.this.ctq.ahu().agN().agS()) > 0) {
                    Iterator<f> it = b.this.ctq.ahu().agN().agS().iterator();
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
        return !this.ctq.i(this.ctp.ahH(), this.ctp.ahI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahe() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.ctp.ahE();
    }

    public View ahf() {
        return this.ctp.ahf();
    }

    public void as(View view) {
        this.ctp.as(view);
    }

    private void ahg() {
        this.cto.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.ahe();
                } else {
                    b.this.ahh();
                }
                if (b.this.ctv) {
                    b.this.ctp.startPullRefresh();
                }
            }
        });
        this.cto.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ctp.ahE();
                if (b.this.isChanged()) {
                    if (b.this.ctp.isEmpty()) {
                        b.this.ctp.au(b.this.mRootView);
                        return;
                    } else {
                        b.this.ctp.ahD();
                        b.this.ctq.aF(b.this.ctp.ahH());
                    }
                }
                if (b.this.ctv) {
                    b.this.ctp.startPullRefresh();
                }
            }
        });
    }

    public void ahh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bez.getPageContext().getPageActivity());
        aVar.cd(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.ahe();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.ce(d.C0096d.cp_cont_b);
        aVar.b(this.bez.getPageContext());
        aVar.th();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bez.getPageContext().getPageActivity());
            aVar.cS(String.format(this.bez.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.hy()) {
                        b.this.bez.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.bez.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ce(d.C0096d.cp_cont_b);
            aVar.b(this.bez.getPageContext());
            aVar.th();
        }
    }

    public void ey(boolean z) {
        if (this.mWaitingDialog == null) {
            ahi();
        }
        this.mWaitingDialog.aE(z);
    }

    private void ahi() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.bez.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.bez.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.ctp = new com.baidu.tieba.enterForum.b.b(this.cto, this.mRootView, this.csF);
        this.ctp.a(this.amR);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ez(boolean z) {
        if (this.ctp != null && this.cto != null) {
            if (z) {
                if (this.cto.isPrimary() && this.cto.isResumed()) {
                    this.ctp.startPullRefresh();
                    return;
                } else {
                    this.ctp.ahG();
                    return;
                }
            }
            this.ctp.ahG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cto.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.ctp != null) {
            if (bVar == null) {
                this.ctp.au(this.mRootView);
                return;
            }
            g agN = bVar.agN();
            ArrayList<f> arrayList = new ArrayList<>();
            if (agN != null) {
                arrayList = agN.agS();
            }
            aD(arrayList);
            if (b(bVar)) {
                this.ctp.aK(bVar.agO());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.agQ() != null) {
                setSearchHint(hotSearchInfoData.agQ());
            }
            this.ctp.ahJ();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.agN() == null || v.w(bVar.agN().agS())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.ctp.setSearchHint(str.trim());
        } else {
            this.ctp.setSearchHint(this.bez.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void aD(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ctp.aJ(this.ctq.a(list, c.Hc()));
        }
    }

    public void Om() {
        if (this.ctp != null) {
            eA(false);
        }
    }

    public void onDestroy() {
        EL();
        com.baidu.tieba.enterForum.model.a.ahl().destroy();
        if (this.ctp != null) {
            if (this.ctq != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.ctq.aF(this.ctp.ahH());
            }
            this.ctp.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.ctp != null) {
            this.ctp.onChangeSkinType(i);
        }
    }

    public void EL() {
        if (this.ctq != null) {
            this.ctq.cancelLoadData();
        }
    }

    public void eA(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.ctw && this.ctq != null && this.ctp != null) {
            String str = this.ctt;
            this.ctt = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.ctt == null || this.ctt.equals(str)) {
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
                if (this.ctq != null && this.ctq.ahu() != null && this.ctq.ahu().agN() != null) {
                    Iterator<f> it = this.ctq.ahu().agN().agS().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.jn(1);
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
                    com.baidu.tieba.tbadkCore.util.a.th(currentAccount);
                }
                this.ctp.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EL();
                if (z4) {
                    this.ctq.eC(StringUtils.isNull(this.ctt) ? false : true);
                } else if (z2) {
                    this.ctq.eD(!StringUtils.isNull(this.ctt));
                    this.ctq.eC(StringUtils.isNull(this.ctt) ? false : true);
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
        if (this.ctp != null && this.ctp.ahC() != null) {
            this.ctp.ahC().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f ctH;
        private x mNetwork = null;

        public a(f fVar) {
            this.ctH = null;
            this.ctH = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.ctH;
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
            b.this.ey(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.uN().vL().isRequestSuccess()) {
                    b.this.ctv = true;
                    if (b.this.cto.isAdded() && b.this.bez != null) {
                        b.this.bez.showToast(b.this.bez.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.f(false, this.ctH.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.ctH.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.ctH.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.ctH.getName()));
                    }
                    b.this.ctp.b(this.ctH);
                } else if (b.this.bez != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.bez.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.cto.isAdded()) {
                        b.this.bez.showToast(b.this.bez.getActivity().getString(d.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            b.this.ey(true);
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
                    com.baidu.tieba.im.settingcache.d.aDi().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Fi = bVar.Fi();
        com.baidu.tbadk.mvc.b.a Fj = bVar.Fj();
        switch (Fi) {
            case 1:
                if (Fj instanceof f) {
                    String name = ((f) Fj).getName();
                    if (am.aL(name)) {
                        this.bez.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bez.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<f> ahH = this.ctp.ahH();
                        if (!v.w(ahH)) {
                            if (v.v(ahH) > 1 && ahH.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < ahH.size()) {
                                    if (!ahH.get(i2).getName().equals(name)) {
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
                this.ctp.jp(Fj instanceof com.baidu.tieba.enterForum.data.h ? ((com.baidu.tieba.enterForum.data.h) Fj).getPosition() : 0);
                this.ctv = false;
                if (this.cto.getView() == null || this.cto.getView().getParent() == null) {
                    return true;
                }
                this.cto.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Fj instanceof f) {
                    a((f) Fj);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.bez.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bez.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.bez.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.bez.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ac("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ac("obj_type", "2").r("obj_locate", 1));
                this.bez.finish();
                return true;
            case 9:
                if (this.ctp != null) {
                    this.ctp.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void ahj() {
        if (this.ctp != null) {
            this.ctp.ahF();
        }
    }

    public boolean ahk() {
        if (this.ctp != null) {
            return this.ctp.ahk();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fh() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.bez.getUniqueId();
    }

    public void eB(boolean z) {
        int i = 1;
        if (this.ctp != null && this.cto != null) {
            boolean z2 = this.ctp.ahk() && this.cto.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
