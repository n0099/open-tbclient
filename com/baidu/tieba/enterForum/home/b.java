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
    private LikeModel bZx;
    private BaseFragmentActivity beD;
    private boolean ctA;
    private boolean ctB;
    private com.baidu.tieba.enterForum.home.a cts;
    private EnterForumModel ctu;
    private boolean ctv;
    private String cty;
    private long ctz;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.b.b ctt = null;
    private boolean ctw = false;
    private final CustomMessageListener beE = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.enterForum.home.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.ctt != null) {
                b.this.ctt.startPullRefresh();
            }
        }
    };
    private CustomMessageListener ctC = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE) { // from class: com.baidu.tieba.enterForum.home.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ctw = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a ctD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.10
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.ctu.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                b.this.ctt.ahF();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = b.this.beD.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    b.this.beD.showToast(errorString);
                    if (b.this.ctt.isEmpty()) {
                        b.this.ctt.av(b.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.ctu.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.ctu.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener ctE = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_RESET_TABS) { // from class: com.baidu.tieba.enterForum.home.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ctB = true;
        }
    };
    private com.baidu.adp.base.d ctF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.b.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.uB(b.this.bZx.getErrorCode())) {
                AntiHelper.am(b.this.beD.getPageContext().getPageActivity(), b.this.bZx.getErrorString());
            } else if (obj != null) {
                b.this.ctu.eC(!StringUtils.isNull(b.this.cty));
            } else if (!StringUtils.isNull(b.this.bZx.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), b.this.bZx.getErrorString());
            }
        }
    };
    private final EnterForumModel.b ctG = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.5
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && b.this.cts.isAdded()) {
                if (aVar.type == 1) {
                    b.this.ctt.ahF();
                }
                if (aVar.cua) {
                    if (aVar.type == 1) {
                        b.this.ctv = true;
                        new com.baidu.tieba.enterForum.data.b();
                        b.this.a(aVar.cub);
                    } else if (aVar.type == 0 && !b.this.ctv) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.cub;
                        b.this.ctu.c(bVar);
                        b.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    b.this.beD.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && b.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && b.this.ctz > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - b.this.ctz, b.this.ctu.ahs() - b.this.ctz, b.this.ctu.ahq(), b.this.ctu.ahr(), currentTimeMillis - b.this.ctu.ahp());
                    b.this.ctz = -1L;
                }
                if (aVar.cub == null || aVar.cub.getHotSearchInfoData() == null) {
                    b.this.setSearchHint(b.this.beD.getResources().getString(d.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.cub.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.agP() != null) {
                    b.this.setSearchHint(hotSearchInfoData.agP());
                }
            }
        }
    };
    private h.b amU = new h.b() { // from class: com.baidu.tieba.enterForum.home.b.6
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefresh(boolean z) {
            b.this.ctu.eC(!StringUtils.isNull(b.this.cty));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter csJ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        OG();
    }

    public b(com.baidu.tieba.enterForum.home.a aVar) {
        this.ctu = null;
        this.isFirst = true;
        this.ctv = false;
        this.ctz = -1L;
        this.cts = aVar;
        this.beD = aVar.getBaseFragmentActivity();
        this.csJ.addEventDelegate(this);
        this.ctz = System.currentTimeMillis();
        this.isFirst = true;
        this.ctv = false;
        this.cty = "";
        this.ctu = new EnterForumModel(this.beD.getPageContext());
        this.bZx = new LikeModel(this.beD.getPageContext());
        this.bZx.setLoadDataCallBack(this.ctF);
        this.ctu.a(this.ctG);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.ahk().l(this.cts.getFragmentActivity(), l.n(this.cts.getFragmentActivity()));
        initUI();
        initListener();
        ahc();
    }

    private void initListener() {
        ahf();
        this.cts.registerListener(this.ctE);
        this.cts.registerListener(this.ctD);
        this.cts.registerListener(this.beE);
        this.cts.registerListener(this.ctC);
    }

    private static void OG() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void ahc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.b.9
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (b.this.ctu != null && b.this.ctu.aht() != null && b.this.ctu.aht().agM() != null && v.v(b.this.ctu.aht().agM().agR()) > 0) {
                    Iterator<f> it = b.this.ctu.aht().agM().agR().iterator();
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
        return !this.ctu.i(this.ctt.ahG(), this.ctt.ahH());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahd() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.ctt.ahD();
    }

    public View ahe() {
        return this.ctt.ahe();
    }

    public void at(View view) {
        this.ctt.at(view);
    }

    private void ahf() {
        this.cts.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL) { // from class: com.baidu.tieba.enterForum.home.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!b.this.isChanged()) {
                    b.this.ahd();
                } else {
                    b.this.ahg();
                }
                if (b.this.ctA) {
                    b.this.ctt.startPullRefresh();
                }
            }
        });
        this.cts.registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM) { // from class: com.baidu.tieba.enterForum.home.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ctt.ahD();
                if (b.this.isChanged()) {
                    if (b.this.ctt.isEmpty()) {
                        b.this.ctt.av(b.this.mRootView);
                        return;
                    } else {
                        b.this.ctt.ahC();
                        b.this.ctu.aF(b.this.ctt.ahG());
                    }
                }
                if (b.this.ctA) {
                    b.this.ctt.startPullRefresh();
                }
            }
        });
    }

    public void ahg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.beD.getPageContext().getPageActivity());
        aVar.cd(d.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(d.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                b.this.ahd();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.ce(d.C0095d.cp_cont_b);
        aVar.b(this.beD.getPageContext());
        aVar.th();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.beD.getPageContext().getPageActivity());
            aVar.cS(String.format(this.beD.getPageContext().getString(d.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(d.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.hy()) {
                        b.this.beD.showToast(d.j.delete_like_fail);
                    } else {
                        new a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(b.this.beD.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ce(d.C0095d.cp_cont_b);
            aVar.b(this.beD.getPageContext());
            aVar.th();
        }
    }

    public void ey(boolean z) {
        if (this.mWaitingDialog == null) {
            ahh();
        }
        this.mWaitingDialog.aE(z);
    }

    private void ahh() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.beD.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.beD.getActivity()).inflate(d.h.enter_forum_view, (ViewGroup) null);
        this.ctt = new com.baidu.tieba.enterForum.b.b(this.cts, this.mRootView, this.csJ);
        this.ctt.a(this.amU);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ez(boolean z) {
        if (this.ctt != null && this.cts != null) {
            if (z) {
                if (this.cts.isPrimary() && this.cts.isResumed()) {
                    this.ctt.startPullRefresh();
                    return;
                } else {
                    this.ctt.ahF();
                    return;
                }
            }
            this.ctt.ahF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.cts.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.ctt != null) {
            if (bVar == null) {
                this.ctt.av(this.mRootView);
                return;
            }
            g agM = bVar.agM();
            ArrayList<f> arrayList = new ArrayList<>();
            if (agM != null) {
                arrayList = agM.agR();
            }
            aD(arrayList);
            if (b(bVar)) {
                this.ctt.aK(bVar.agN());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.agP() != null) {
                setSearchHint(hotSearchInfoData.agP());
            }
            this.ctt.ahI();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.agM() == null || v.w(bVar.agM().agR())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.ctt.setSearchHint(str.trim());
        } else {
            this.ctt.setSearchHint(this.beD.getActivity().getString(d.j.enter_forum_search_tip));
        }
    }

    private void aD(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.ctt.aJ(this.ctu.a(list, c.Hc()));
        }
    }

    public void Om() {
        if (this.ctt != null) {
            eA(false);
        }
    }

    public void onDestroy() {
        EL();
        com.baidu.tieba.enterForum.model.a.ahk().destroy();
        if (this.ctt != null) {
            if (this.ctu != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.ctu.aF(this.ctt.ahG());
            }
            this.ctt.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.ctt != null) {
            this.ctt.onChangeSkinType(i);
        }
    }

    public void EL() {
        if (this.ctu != null) {
            this.ctu.cancelLoadData();
        }
    }

    public void eA(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.ctB && this.ctu != null && this.ctt != null) {
            String str = this.cty;
            this.cty = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.cty == null || this.cty.equals(str)) {
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
                if (this.ctu != null && this.ctu.aht() != null && this.ctu.aht().agM() != null) {
                    Iterator<f> it = this.ctu.aht().agM().agR().iterator();
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
                this.ctt.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EL();
                if (z4) {
                    this.ctu.eC(StringUtils.isNull(this.cty) ? false : true);
                } else if (z2) {
                    this.ctu.eD(!StringUtils.isNull(this.cty));
                    this.ctu.eC(StringUtils.isNull(this.cty) ? false : true);
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
        if (this.ctt != null && this.ctt.ahB() != null) {
            this.ctt.ahB().completePullRefresh();
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<f, Integer, String> {
        private f ctL;
        private x mNetwork = null;

        public a(f fVar) {
            this.ctL = null;
            this.ctL = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.ctL;
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
                    b.this.ctA = true;
                    if (b.this.cts.isAdded() && b.this.beD != null) {
                        b.this.beD.showToast(b.this.beD.getActivity().getString(d.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    b.this.f(false, this.ctL.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.ctL.getId()));
                    long c = com.baidu.adp.lib.g.b.c(this.ctL.getId(), 0L);
                    if (c > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.ctL.getName()));
                    }
                    b.this.ctt.b(this.ctL);
                } else if (b.this.beD != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        b.this.beD.showToast(this.mNetwork.getErrorString());
                    } else if (b.this.cts.isAdded()) {
                        b.this.beD.showToast(b.this.beD.getActivity().getString(d.j.delete_like_fail));
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
                        this.beD.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.beD.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<f> ahG = this.ctt.ahG();
                        if (!v.w(ahG)) {
                            if (v.v(ahG) > 1 && ahG.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < ahG.size()) {
                                    if (!ahG.get(i2).getName().equals(name)) {
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
                this.ctt.jp(Fj instanceof com.baidu.tieba.enterForum.data.h ? ((com.baidu.tieba.enterForum.data.h) Fj).getPosition() : 0);
                this.ctA = false;
                if (this.cts.getView() == null || this.cts.getView().getParent() == null) {
                    return true;
                }
                this.cts.getView().getParent().requestDisallowInterceptTouchEvent(true);
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.beD.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.beD.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.beD.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.beD.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new ak("c10378").ac("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new ak("c12049").ac("obj_type", "2").r("obj_locate", 1));
                this.beD.finish();
                return true;
            case 9:
                if (this.ctt != null) {
                    this.ctt.startPullRefresh();
                    return true;
                }
                return true;
        }
    }

    public void ahi() {
        if (this.ctt != null) {
            this.ctt.ahE();
        }
    }

    public boolean ahj() {
        if (this.ctt != null) {
            return this.ctt.ahj();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fh() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.beD.getUniqueId();
    }

    public void eB(boolean z) {
        int i = 1;
        if (this.ctt != null && this.cts != null) {
            boolean z2 = this.ctt.ahj() && this.cts.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
