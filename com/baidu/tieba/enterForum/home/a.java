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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
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
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private LikeModel aHL;
    private BaseFragmentActivity byX;
    private EnterForumFragment dhP;
    private EnterForumModel dhR;
    private RecentlyVisitedForumModel dhS;
    private boolean dhT;
    private String dhV;
    private long dhW;
    private boolean dhX;
    private boolean dhZ;
    private boolean isFirst;
    private View mRootView;
    private d mWaitingDialog;
    private com.baidu.tieba.enterForum.view.a dhQ = null;
    private boolean dhU = false;
    private int dhY = 1;
    private CustomMessageListener dia = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.dhU = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a dib = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.dhR.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.dhQ.ph();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.byX.getResources().getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.byX.showToast(errorString);
                    if (a.this.dhQ.isEmpty()) {
                        a.this.dhQ.aJ(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.dhR.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.dhR.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener dic = new CustomMessageListener(2007008) { // from class: com.baidu.tieba.enterForum.home.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.dhZ = true;
        }
    };
    private com.baidu.adp.base.d did = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.ai(a.this.aHL.getErrorCode(), a.this.aHL.getErrorString())) {
                AntiHelper.aG(a.this.byX.getPageContext().getPageActivity(), a.this.aHL.getErrorString());
            } else if (obj != null) {
                a.this.dhR.ga(!StringUtils.isNull(a.this.dhV));
            } else if (!StringUtils.isNull(a.this.aHL.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.aHL.getErrorString());
            }
        }
    };
    private final EnterForumModel.b die = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.4
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.dhP.isAdded()) {
                if (aVar.type == 1) {
                    a.this.dhQ.ph();
                }
                if (aVar.diK) {
                    if (aVar.type == 1) {
                        a.this.dhT = true;
                        new com.baidu.tieba.enterForum.data.b();
                        a.this.a(aVar.diL);
                    } else if (aVar.type == 0 && !a.this.dhT) {
                        new com.baidu.tieba.enterForum.data.b();
                        com.baidu.tieba.enterForum.data.b bVar = aVar.diL;
                        a.this.dhR.c(bVar);
                        a.this.a(bVar);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.byX.showToast(aVar.error);
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.dhW > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.dhW, a.this.dhR.atP() - a.this.dhW, a.this.dhR.atN(), a.this.dhR.atO(), currentTimeMillis - a.this.dhR.atM());
                    a.this.dhW = -1L;
                }
                if (aVar.diL == null || aVar.diL.getHotSearchInfoData() == null) {
                    a.this.setSearchHint(a.this.byX.getResources().getString(e.j.enter_forum_search_tip));
                    return;
                }
                HotSearchInfoData hotSearchInfoData = aVar.diL.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                if (hotSearchInfoData != null && hotSearchInfoData.atg() != null) {
                    a.this.setSearchHint(hotSearchInfoData.atg());
                }
            }
        }
    };
    private j.b aFe = new j.b() { // from class: com.baidu.tieba.enterForum.home.a.5
        @Override // com.baidu.tbadk.core.view.j.b
        public void bG(boolean z) {
            a.this.dhR.ga(!StringUtils.isNull(a.this.dhV));
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter dgT = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        YT();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.dhR = null;
        this.isFirst = true;
        this.dhT = false;
        this.dhW = -1L;
        this.dhP = enterForumFragment;
        this.byX = enterForumFragment.getBaseFragmentActivity();
        this.dgT.addEventDelegate(this);
        this.dhW = System.currentTimeMillis();
        this.isFirst = true;
        this.dhT = false;
        this.dhV = "";
        this.dhR = new EnterForumModel(this.byX.getPageContext());
        this.dhS = new RecentlyVisitedForumModel();
        this.aHL = new LikeModel(this.byX.getPageContext());
        this.aHL.setLoadDataCallBack(this.did);
        this.dhR.a(this.die);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.atI().o(this.dhP.getFragmentActivity(), l.r(this.dhP.getFragmentActivity()));
        initUI();
        initListener();
        atx();
    }

    private void initListener() {
        atA();
        this.dhP.registerListener(this.dic);
        this.dhP.registerListener(this.dib);
        this.dhP.registerListener(this.dia);
    }

    private static void YT() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void atx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.enterForum.home.a.7
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
                ac acVar = new ac();
                ArrayList arrayList = new ArrayList();
                if (a.this.dhR != null && a.this.dhR.atQ() != null && a.this.dhR.atQ().atd() != null && v.H(a.this.dhR.atQ().atd().atj()) > 0) {
                    Iterator<f> it = a.this.dhR.atQ().atd().atj().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.d(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    acVar.C(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, acVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChanged() {
        return !this.dhR.i(this.dhQ.auc(), this.dhQ.aud());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aty() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
        this.dhQ.aua();
    }

    public View atz() {
        return this.dhQ.atz();
    }

    public void aH(View view) {
        this.dhQ.aH(view);
    }

    private void atA() {
        this.dhP.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.dhQ == null || !a.this.dhQ.ata()) {
                    if (!a.this.isChanged()) {
                        a.this.aty();
                    } else {
                        a.this.atB();
                    }
                    if (a.this.dhX) {
                        a.this.dhQ.startPullRefresh();
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        });
        this.dhP.registerListener(new CustomMessageListener(2007011) { // from class: com.baidu.tieba.enterForum.home.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.dhQ.aua();
                if (a.this.isChanged()) {
                    if (a.this.dhQ.isEmpty()) {
                        a.this.dhQ.aJ(a.this.mRootView);
                        return;
                    } else {
                        a.this.dhQ.atZ();
                        a.this.dhR.bg(a.this.dhQ.auc());
                    }
                }
                if (a.this.dhX) {
                    a.this.dhQ.startPullRefresh();
                }
            }
        });
    }

    public void atB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.byX.getPageContext().getPageActivity());
        aVar.cN(e.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.getInst().getString(e.j.enter_forum_cancel_change), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.aty();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        });
        aVar.b(TbadkCoreApplication.getInst().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.cO(e.d.cp_cont_b);
        aVar.b(this.byX.getPageContext());
        aVar.AB();
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.byX.getPageContext().getPageActivity());
            aVar.ej(String.format(this.byX.getPageContext().getString(e.j.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(e.j.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.lm()) {
                        a.this.byX.showToast(e.j.delete_like_fail);
                    } else {
                        new C0202a(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.byX.getPageContext().getPageActivity(), "recom_flist_unlike", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cO(e.d.cp_cont_b);
            aVar.b(this.byX.getPageContext());
            aVar.AB();
        }
    }

    public void fW(boolean z) {
        if (this.mWaitingDialog == null) {
            atC();
        }
        this.mWaitingDialog.bz(z);
    }

    private void atC() {
        this.mWaitingDialog = new d(this.byX.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.byX.getActivity()).inflate(e.h.enter_forum_view, (ViewGroup) null);
        this.dhQ = new com.baidu.tieba.enterForum.view.a(this.dhP, this.mRootView, this.dgT, this.dhS);
        this.dhQ.a(this.aFe);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fX(boolean z) {
        if (this.dhQ != null && this.dhP != null) {
            if (z) {
                if (this.dhP.isPrimary() && this.dhP.isResumed()) {
                    this.dhQ.startPullRefresh();
                    return;
                } else {
                    this.dhQ.ph();
                    return;
                }
            }
            this.dhQ.ph();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.dhP.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.b bVar) {
        if (this.dhQ != null) {
            if (bVar == null) {
                this.dhQ.aJ(this.mRootView);
                return;
            }
            g atd = bVar.atd();
            ArrayList<f> arrayList = new ArrayList<>();
            if (atd != null) {
                arrayList = atd.atj();
            }
            be(arrayList);
            if (b(bVar)) {
                this.dhQ.bl(bVar.ate());
            }
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.atg() != null) {
                setSearchHint(hotSearchInfoData.atg());
            }
            this.dhQ.aue();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.atd() == null || v.I(bVar.atd().atj())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.dhQ.setSearchHint(str.trim());
        } else {
            this.dhQ.setSearchHint(this.byX.getActivity().getString(e.j.enter_forum_search_tip));
        }
    }

    private void be(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.dhQ.bk(this.dhR.a(list, com.baidu.tbadk.util.d.OG()));
        }
    }

    public void loadData() {
        if (this.dhQ != null) {
            fY(false);
        }
    }

    public void onDestroy() {
        MA();
        com.baidu.tieba.enterForum.model.a.atI().destroy();
        if (this.dhQ != null) {
            if (this.dhR != null && TbadkCoreApplication.getInst().getLikeBarChanged()) {
                this.dhR.bg(this.dhQ.auc());
            }
            this.dhQ.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.dhS != null) {
            this.dhS.onDestroy();
        }
        if (this.dgT != null) {
            this.dgT.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dhQ != null) {
            this.dhQ.onChangeSkinType(i);
        }
    }

    public void MA() {
        if (this.dhR != null) {
            this.dhR.cancelLoadData();
        }
    }

    public void fY(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.dhZ && this.dhR != null && this.dhQ != null) {
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
                if (this.dhR != null && this.dhR.atQ() != null && this.dhR.atQ().atd() != null) {
                    Iterator<f> it = this.dhR.atQ().atd().atj().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.kW(1);
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
                    com.baidu.tieba.tbadkCore.util.a.vj(currentAccount);
                }
                this.dhQ.notifyDataSetChanged();
            }
            if (z2 || z4) {
                MA();
                if (z4) {
                    this.dhR.ga(StringUtils.isNull(this.dhV) ? false : true);
                } else if (z2) {
                    this.dhR.gb(!StringUtils.isNull(this.dhV));
                    this.dhR.ga(StringUtils.isNull(this.dhV) ? false : true);
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
        if (this.dhS != null) {
            this.dhS.onPrimary();
        }
    }

    public void onPause() {
        if (this.dhQ != null && this.dhQ.atY() != null) {
            this.dhQ.atY().completePullRefresh();
        }
        if (this.dhS != null) {
            this.dhS.onPause();
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0202a extends BdAsyncTask<f, Integer, String> {
        private f dij;
        private x mNetwork = null;

        public C0202a(f fVar) {
            this.dij = null;
            this.dij = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.dij;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, fVar.getId());
                        this.mNetwork.x("kw", fVar.getName());
                        this.mNetwork.Cf().Dd().mIsNeedTbs = true;
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
            super.onPostExecute((C0202a) str);
            a.this.fW(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.Cf().De().isRequestSuccess()) {
                    a.this.dhX = true;
                    if (a.this.dhP.isAdded() && a.this.byX != null) {
                        a.this.byX.showToast(a.this.byX.getActivity().getString(e.j.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.g(false, this.dij.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.dij.getId()));
                    long d = com.baidu.adp.lib.g.b.d(this.dij.getId(), 0L);
                    if (d > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.dij.getName()));
                    }
                    a.this.dhQ.b(this.dij);
                } else if (a.this.byX != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.byX.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.dhP.isAdded()) {
                        a.this.byX.showToast(a.this.byX.getActivity().getString(e.j.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.fW(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aSs().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int MZ = bVar.MZ();
        com.baidu.tbadk.mvc.b.a Na = bVar.Na();
        switch (MZ) {
            case 1:
                if (this.dhY != 2 && (Na instanceof f)) {
                    String name = ((f) Na).getName();
                    if (ao.bv(name)) {
                        this.byX.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.byX.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.byX.getResources().getString(e.j.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new am("c12888"));
                        }
                        List<f> auc = this.dhQ.auc();
                        if (!v.I(auc)) {
                            if (v.H(auc) > 1 && auc.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < auc.size()) {
                                    if (!auc.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new am("c12049").ax("obj_type", "2").x("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.dhY == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", true);
                this.dhQ.kZ(Na instanceof h ? ((h) Na).getPosition() : 0);
                this.dhX = false;
                if (this.dhP.getView() == null || this.dhP.getView().getParent() == null) {
                    return true;
                }
                this.dhP.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Na instanceof f) {
                    a((f) Na);
                    return true;
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.byX.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.byX.getPageContext().getPageActivity(), "notlogin_6", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("find_more_text_click"));
                return true;
            case 7:
                IntentConfig intentConfig = new IntentConfig(this.byX.getPageContext().getPageActivity());
                if (intentConfig.getIntent() != null) {
                    intentConfig.getIntent().putExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.byX.getPageContext().getPageActivity(), "notlogin_8", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                TiebaStatic.log(new am("c10378").ax("obj_type", "4"));
                return true;
            case 8:
                TiebaStatic.log(new am("c12049").ax("obj_type", "2").x("obj_locate", 1));
                this.byX.finish();
                return true;
            case 9:
                if (this.dhQ != null) {
                    this.dhQ.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.dhY = 2;
                return true;
            case 11:
                this.dhY = 1;
                return true;
        }
    }

    public void atD() {
        if (this.dhQ != null) {
            this.dhQ.aub();
        }
    }

    public boolean atE() {
        if (this.dhQ != null) {
            return this.dhQ.atE();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean MY() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.byX.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dhQ != null) {
            this.dhQ.setPageUniqueId(bdUniqueId);
        }
    }

    public void fZ(boolean z) {
        int i = 0;
        if (this.dhQ != null && this.dhP != null) {
            boolean z2 = this.dhQ.atE() && this.dhP.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (!z2 && z) {
                i = 1;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
            if (this.dhQ.ata()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }
}
