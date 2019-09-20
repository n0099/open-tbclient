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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
    private BaseFragmentActivity cZT;
    private LikeModel cer;
    private EnterForumFragment eYT;
    private EnterForumModel eYV;
    private RecentlyVisitedForumModel eYW;
    private com.baidu.tieba.ueg.d eYX;
    private boolean eYZ;
    private String eZb;
    private long eZc;
    private boolean eZd;
    private com.baidu.tieba.enterForum.view.d eZf;
    private boolean eZg;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private com.baidu.tieba.enterForum.view.b eYU = null;
    private com.baidu.tbadk.core.dialog.a eYY = null;
    private boolean eZa = false;
    private int eZe = 1;
    private CustomMessageListener eZh = new CustomMessageListener(2921032) { // from class: com.baidu.tieba.enterForum.home.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.eZa = true;
            }
        }
    };
    private com.baidu.adp.framework.listener.a eZi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.a.7
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && a.this.eYV.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                a.this.eYU.oU();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cZT.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cZT.showToast(errorString);
                    if (a.this.eYU.isEmpty()) {
                        a.this.eYU.bO(a.this.mRootView);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    a.this.eYV.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    a.this.eYV.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private com.baidu.adp.base.d eZj = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.a.10
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(a.this.cer.getErrorCode(), a.this.cer.getErrorString())) {
                AntiHelper.aQ(a.this.cZT.getPageContext().getPageActivity(), a.this.cer.getErrorString());
            } else if (obj != null) {
                a.this.eYV.js(!StringUtils.isNull(a.this.eZb));
            } else if (!StringUtils.isNull(a.this.cer.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), a.this.cer.getErrorString());
            }
        }
    };
    private final EnterForumModel.b eZk = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.a.11
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (aVar != null && a.this.eYT != null) {
                if (aVar.type == 1) {
                    a.this.eYU.oU();
                }
                if (aVar.fax) {
                    if (aVar.type == 1) {
                        a.this.eYZ = true;
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar = aVar.fay;
                        a.this.a(cVar);
                        if (cVar.getSortType() > 0) {
                            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_LIKE_forum_sort_state", cVar.getSortType());
                        }
                    } else if (aVar.type == 0 && !a.this.eYZ) {
                        new com.baidu.tieba.enterForum.data.c();
                        com.baidu.tieba.enterForum.data.c cVar2 = aVar.fay;
                        a.this.eYV.d(cVar2);
                        a.this.a(cVar2);
                    }
                } else if (aVar.error != null && !aVar.error.equals("")) {
                    a.this.cZT.showToast(aVar.error);
                    a.this.eYU.qx(com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
                if (aVar.type == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && a.this.isShow()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (aVar.type == 1 && a.this.eZc > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - a.this.eZc, a.this.eYV.bgV() - a.this.eZc, a.this.eYV.bgT(), a.this.eYV.bgU(), currentTimeMillis - a.this.eYV.bgS());
                    a.this.eZc = -1L;
                }
                String string = a.this.cZT.getResources().getString(R.string.enter_forum_search_tip);
                if (aVar.fay != null && aVar.fay.getHotSearchInfoData() != null) {
                    HotSearchInfoData hotSearchInfoData = aVar.fay.getHotSearchInfoData();
                    com.baidu.tbadk.core.sharedPref.b.ahU().putString("hot_search_info", OrmObject.jsonStrWithObject(hotSearchInfoData));
                    if (hotSearchInfoData != null && hotSearchInfoData.bfT() != null) {
                        string = hotSearchInfoData.bfT();
                    }
                }
                a.this.setSearchHint(string);
            }
        }
    };
    private h.c cbC = new h.c() { // from class: com.baidu.tieba.enterForum.home.a.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            EnterForumDelegateStatic.eYF.loadAd();
            a.this.eYV.js(!StringUtils.isNull(a.this.eZb));
            a.this.eYW.LoadData();
            a.this.eYV.jr(true);
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
        }
    };
    private ViewEventCenter eXb = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        aJu();
    }

    public a(EnterForumFragment enterForumFragment) {
        this.eYV = null;
        this.isFirst = true;
        this.eYZ = false;
        this.eZc = -1L;
        this.eYT = enterForumFragment;
        this.cZT = enterForumFragment.getBaseFragmentActivity();
        this.eXb.addEventDelegate(this);
        com.baidu.tieba.frs.e.d.bsS();
        this.eZc = System.currentTimeMillis();
        this.isFirst = true;
        this.eYZ = false;
        this.eZb = "";
        this.eYV = new EnterForumModel(this.cZT.getPageContext());
        this.eYW = new RecentlyVisitedForumModel();
        this.cer = new LikeModel(this.cZT.getPageContext());
        this.eYX = new com.baidu.tieba.ueg.d(this.cZT.getPageContext());
        this.cer.setLoadDataCallBack(this.eZj);
        this.eYV.a(this.eZk);
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.bgQ().m(this.eYT.getFragmentActivity(), l.u(this.eYT.getFragmentActivity()));
        initUI();
        initListener();
        bgv();
    }

    private void initListener() {
        bgu();
        this.eYT.registerListener(this.eZi);
        this.eYT.registerListener(this.eZh);
    }

    private static void aJu() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void bgu() {
        this.eYT.registerListener(new CustomMessageListener(2007010) { // from class: com.baidu.tieba.enterForum.home.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.eYU != null && a.this.eYU.bfH()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                }
            }
        });
    }

    private void bgv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new CustomMessageTask.CustomRunnable<ae>() { // from class: com.baidu.tieba.enterForum.home.a.6
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
                ae aeVar = new ae();
                ArrayList arrayList = new ArrayList();
                if (a.this.eYV != null && a.this.eYV.bgW() != null && a.this.eYV.bgW().bfL() != null && v.Z(a.this.eYV.bgW().bfL().bge()) > 0) {
                    Iterator<f> it = a.this.eYV.bgW().bfL().bge().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.e(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.getName());
                            hotTopicBussinessData.setForumAvatar(next.getAvatar());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    aeVar.T(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, aeVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(final f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cZT.getPageContext().getPageActivity());
            aVar.mQ(String.format(this.cZT.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.getName()));
            aVar.a(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (!l.kt()) {
                        a.this.cZT.showToast(R.string.delete_like_fail);
                    } else {
                        new b(fVar).execute(new f[0]);
                    }
                    TiebaStatic.eventStat(a.this.cZT.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                    aVar2.dismiss();
                }
            });
            aVar.b(TbadkCoreApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.enterForum.home.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.hw(R.color.cp_cont_b);
            aVar.b(this.cZT.getPageContext());
            aVar.agO();
        }
    }

    public void jm(boolean z) {
        if (this.mWaitingDialog == null) {
            bgw();
        }
        this.mWaitingDialog.em(z);
    }

    private void bgw() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.cZT.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.cZT.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
        this.eYU = new com.baidu.tieba.enterForum.view.b(this.eYT, this.mRootView, this.eXb, this.eYW, this.eYV);
        this.eYU.setListPullRefreshListener(this.cbC);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jn(boolean z) {
        if (this.eYU != null && this.eYT != null) {
            if (z) {
                if (this.eYT.isPrimary() && this.eYT.isResumed()) {
                    this.eYU.startPullRefresh();
                } else {
                    this.eYU.oU();
                }
            } else {
                this.eYU.oU();
            }
            this.eYU.jy(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.eYT.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.data.c cVar) {
        if (this.eYU != null) {
            if (cVar == null) {
                this.eYU.bO(this.mRootView);
                return;
            }
            g bfL = cVar.bfL();
            ArrayList<f> arrayList = new ArrayList<>();
            if (bfL != null) {
                arrayList = bfL.bge();
            }
            bE(arrayList);
            if (b(cVar)) {
                this.eYU.bK(cVar.bfM());
            }
            c(cVar);
            HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.ahU().getString("hot_search_info", ""), HotSearchInfoData.class);
            if (hotSearchInfoData != null && hotSearchInfoData.bfT() != null) {
                setSearchHint(hotSearchInfoData.bfT());
            }
            this.eYU.bhK();
            this.eYU.qx(cVar.getSortType());
        }
    }

    public boolean b(com.baidu.tieba.enterForum.data.c cVar) {
        if (TbadkCoreApplication.isLogin() && cVar != null) {
            if ((cVar.bfL() == null || v.aa(cVar.bfL().bge())) && com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (this.eYT.bgq() != null) {
            if (!StringUtils.isNull(str)) {
                this.eYT.bgq().setSearchHint(str.trim());
            } else {
                this.eYT.bgq().setSearchHint(this.cZT.getActivity().getString(R.string.enter_forum_search_tip));
            }
        }
    }

    private void bE(List<f> list) {
        if (list != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.eYU.j(this.eYV.a(list, com.baidu.tbadk.util.d.awp()), this.eYV.bgY());
        }
    }

    private void c(final com.baidu.tieba.enterForum.data.c cVar) {
        if (cVar != null && cVar.bfO() != null && this.eYT.isPrimary() && this.eYY == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.cZT.getActivity());
            if (frsPrivateCommonDialogView.b(cVar.bfO())) {
                this.eYY = new com.baidu.tbadk.core.dialog.a(this.cZT.getActivity());
                this.eYY.hy(2);
                this.eYY.aH(frsPrivateCommonDialogView);
                this.eYY.dR(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.ajK().c(a.this.cZT.getPageContext(), new String[]{cVar.bfO().adH()});
                        a.this.eYY.dismiss();
                        a.this.eYY = null;
                    }
                });
                this.eYY.a(new a.b() { // from class: com.baidu.tieba.enterForum.home.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        a.this.eYY = null;
                    }
                });
                this.eYY.b(this.cZT.getPageContext()).agO();
            }
        }
    }

    private void bgx() {
        if (this.eYY != null) {
            this.eYY.dismiss();
            this.eYY = null;
        }
    }

    public void loadData() {
        if (this.eYU != null) {
            jo(false);
        }
    }

    public void bgy() {
        if (this.eYU != null) {
            jo(true);
        }
    }

    public void onDestroy() {
        atU();
        com.baidu.tieba.enterForum.model.a.bgQ().destroy();
        if (this.eYU != null) {
            this.eYU.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2016527);
        if (this.eYW != null) {
            this.eYW.onDestroy();
        }
        if (this.eYV != null) {
            this.eYV.onDestroy();
        }
        if (this.eXb != null) {
            this.eXb.removeEventDelegate(this);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eYU != null) {
            this.eYU.onChangeSkinType(i);
        }
        if (this.eZf != null) {
            this.eZf.onChangeSkinType();
        }
    }

    public void atU() {
        if (this.eYV != null) {
            this.eYV.cancelLoadData();
        }
    }

    public void jo(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.eZg && this.eYV != null && this.eYU != null) {
            String str = this.eZb;
            this.eZb = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.eZb == null || this.eZb.equals(str)) {
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
                if (this.eYV != null && this.eYV.bgW() != null && this.eYV.bgW().bfL() != null) {
                    Iterator<f> it = this.eYV.bgW().bfL().bge().iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.getName())) {
                            next.qz(1);
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
                    com.baidu.tieba.tbadkCore.util.a.Fr(currentAccount);
                }
                this.eYU.notifyDataSetChanged();
            }
            if (z2 || z4) {
                atU();
                if (z4) {
                    if (this.eYV != null) {
                        this.eYV.jt(StringUtils.isNull(this.eZb) ? false : true);
                    }
                    this.eYW.LoadData();
                } else if (z2 && this.eYV != null) {
                    this.eYV.jt(StringUtils.isNull(this.eZb) ? false : true);
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
        if (this.eYT.isAdded() && this.eYT.isPrimary()) {
            if (this.eYW != null) {
                this.eYW.onPrimary();
            }
        } else {
            bgx();
        }
        if (this.eYU != null) {
            this.eYU.onPrimary();
        }
    }

    public void onPause() {
        if (this.eYU != null && this.eYU.bhJ() != null) {
            this.eYU.bhJ().completePullRefresh();
        }
        if (this.eYW != null) {
            this.eYW.onPause();
        }
        if (this.eYV != null) {
            this.eYV.onPause();
        }
        if (this.eYU != null) {
            this.eYU.onPause();
        }
    }

    public void bgz() {
        if (this.eYU != null) {
            this.eYU.bN(this.mRootView);
        }
    }

    /* loaded from: classes4.dex */
    private class b extends BdAsyncTask<f, Integer, String> {
        private f eZq;
        private x mNetwork = null;

        public b(f fVar) {
            this.eZq = null;
            this.eZq = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eZq;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.mNetwork.o("fid", fVar.getId());
                        this.mNetwork.o("kw", fVar.getName());
                        this.mNetwork.aiK().ajM().mIsNeedTbs = true;
                        this.mNetwork.aim();
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
            a.this.jm(false);
            if (this.mNetwork != null) {
                if (this.mNetwork.aiK().ajN().isRequestSuccess()) {
                    a.this.eZd = true;
                    if (a.this.eYT.isAdded() && a.this.cZT != null) {
                        a.this.cZT.showToast(a.this.cZT.getActivity().getString(R.string.unlike_success));
                    }
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    a.this.l(false, this.eZq.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.eZq.getId()));
                    long e = com.baidu.adp.lib.g.b.e(this.eZq.getId(), 0L);
                    if (e > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(e)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.eZq.getName()));
                    }
                    a.this.eYU.a(this.eZq, a.this.eYV.bgY());
                    a.this.eYV.b(this.eZq);
                } else if (a.this.cZT != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cZT.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eYT.isAdded()) {
                        a.this.cZT.showToast(a.this.cZT.getActivity().getString(R.string.delete_like_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.jm(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* renamed from: com.baidu.tieba.enterForum.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0311a extends BdAsyncTask<f, Integer, String> {
        private f eZq;
        private x mNetwork = null;

        public C0311a(f fVar) {
            this.eZq = null;
            this.eZq = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(f... fVarArr) {
            f fVar = this.eZq;
            if (fVar != null) {
                try {
                    if (fVar.getId() != null && fVar.getName() != null) {
                        if (fVar.bfV() == 0) {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.mNetwork.o("forum_id", fVar.getId());
                        this.mNetwork.aiK().ajM().mIsNeedTbs = true;
                        this.mNetwork.aim();
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
            super.onPostExecute((C0311a) str);
            a.this.jm(false);
            int bfV = this.eZq.bfV();
            if (this.mNetwork != null) {
                if (this.mNetwork.aiK().ajN().isRequestSuccess()) {
                    a.this.eZd = true;
                    if (a.this.eYT.isAdded() && a.this.cZT != null) {
                        a.this.cZT.showToast(a.this.cZT.getActivity().getString(bfV > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                    }
                    a.this.eYV.js(true);
                } else if (a.this.cZT != null) {
                    if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                        a.this.cZT.showToast(this.mNetwork.getErrorString());
                    } else if (a.this.eYT.isAdded()) {
                        a.this.cZT.showToast(a.this.cZT.getActivity().getString(bfV > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.jm(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
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
                    com.baidu.tieba.im.settingcache.d.bHu().x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int aux = bVar.aux();
        com.baidu.tbadk.mvc.b.a auy = bVar.auy();
        switch (aux) {
            case 1:
                if (this.eZe != 2 && (auy instanceof f)) {
                    String name = ((f) auy).getName();
                    if (aq.bg(name)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.cZT.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object extra = bVar.getExtra();
                        if (extra instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (!((f) auy).arY() || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 0);
                            } else {
                                intent.putExtra("transition_type", 2);
                                intent.putExtra("info_forum_image_rect", ((Bundle) extra).getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", ((f) auy).getAvatar());
                                intent.putExtra("info_forum_name_rect", ((Bundle) extra).getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", name);
                                intent.putExtra("info_forum_head_background_color", ((f) auy).bga());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (((f) auy).bfZ().night != null && ((f) auy).bfZ().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", ((f) auy).bfZ().night.pattern_image);
                                    }
                                } else if (((f) auy).bfZ().day != null && ((f) auy).bfZ().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", ((f) auy).bfZ().day.pattern_image);
                                }
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ((f) auy).bgd());
                            ((f) auy).dc(0L);
                        }
                        this.cZT.sendMessage(new CustomMessage(2003000, callFrom));
                        if (this.cZT.getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(name)) {
                            TiebaStatic.log(new an("c12888"));
                        }
                        TiebaStatic.log(new an("c13368").n("uid", TbadkApplication.getCurrentAccountId()).P("obj_type", this.eYV.bgW().getSortType() == 1 ? 2 : 1).bT("fid", ((f) auy).getId()));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (this.eZe == 2) {
                    return false;
                }
                if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("enter_forum_edit_mode", true);
                if (auy instanceof com.baidu.tieba.enterForum.data.h) {
                    ((com.baidu.tieba.enterForum.data.h) auy).getPosition();
                }
                this.eZd = false;
                if (this.eYT.getView() == null || this.eYT.getView().getParent() == null) {
                    return true;
                }
                this.eYT.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (auy instanceof f) {
                    a((f) auy);
                    return true;
                }
                return false;
            case 6:
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cE(this.cZT.getActivity());
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, 2));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cZT.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.cZT.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.cZT.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new an("c13367").bT("obj_location", "1"));
                return true;
            case 8:
                TiebaStatic.log(new an("c12049").bT("obj_type", "2").P("obj_locate", 1));
                this.cZT.finish();
                return true;
            case 9:
                if (this.eYU != null) {
                    this.eYU.startPullRefresh();
                    return true;
                }
                return true;
            case 10:
                this.eZe = 2;
                return true;
            case 11:
                this.eZe = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                return true;
            case 12:
                if (this.eZe != 2) {
                    if (this.eZf == null) {
                        this.eZf = new com.baidu.tieba.enterForum.view.d(this.cZT.getPageContext(), this.eXb);
                    }
                    if (auy instanceof f) {
                        this.eZf.c((f) auy);
                        this.eZf.showDialog();
                        return true;
                    }
                    return true;
                }
                return true;
            case 13:
                if (auy instanceof f) {
                    new C0311a((f) auy).execute(new f[0]);
                    TiebaStatic.log(new an("c13370").P("obj_type", ((f) auy).bfV() <= 0 ? 1 : 2).bT("fid", ((f) auy).getId()).n("uid", TbadkApplication.getCurrentAccountId()));
                    return true;
                }
                return false;
            case 14:
                ba.ajK().c(this.cZT.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                return true;
            case 15:
                if (this.eYX.cun() || !(auy instanceof f)) {
                    return true;
                }
                ba.ajK().c(this.cZT.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((f) auy).getId() + "&nomenu=1"});
                return true;
            case 16:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.auz());
                break;
            case 17:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.auz());
                break;
            case 18:
                setAdState((com.baidu.tieba.enterForum.data.b) bVar.auz());
                break;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean auw() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.cZT.getUniqueId();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eYU != null) {
            this.eYU.setPageUniqueId(bdUniqueId);
        }
    }

    public void jp(boolean z) {
        int i;
        if (this.eYU != null && this.eYT != null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(i)));
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eYU.setAdState(bVar);
        this.eYT.setAdState(bVar);
    }
}
