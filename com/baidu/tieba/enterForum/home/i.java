package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity aXS;
    private e bGM;
    private EnterForumModel bGO;
    private boolean bGP;
    private String bGQ;
    private long bGR;
    private boolean bGS;
    private com.baidu.tbadk.core.view.a bGT;
    private boolean bGU;
    private LikeModel bue;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.c bGN = null;
    private final CustomMessageListener aXT = new j(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private com.baidu.adp.framework.listener.a bGV = new p(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bGW = new q(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.f bGX = new r(this);
    private final EnterForumModel.b bGY = new s(this);
    private ae.b alm = new t(this);
    private ViewEventCenter bGb = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Jx();
    }

    public i(e eVar) {
        this.bGO = null;
        this.isFirst = true;
        this.bGP = false;
        this.bGR = -1L;
        this.bGM = eVar;
        this.aXS = eVar.getBaseFragmentActivity();
        this.bGb.addEventDelegate(this);
        this.bGR = System.currentTimeMillis();
        this.isFirst = true;
        this.bGP = false;
        this.bGQ = "";
        this.bGO = new EnterForumModel(this.aXS.getPageContext());
        this.bue = new LikeModel(this.aXS.getPageContext());
        this.bue.setLoadDataCallBack(this.bGX);
        this.bGO.a(this.bGY);
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.Ws().m(this.bGM.getFragmentActivity(), com.baidu.adp.lib.util.k.m(this.bGM.getFragmentActivity()));
        initUI();
        initListener();
        Wk();
    }

    private void initListener() {
        Wn();
        this.bGM.registerListener(this.bGW);
        this.bGM.registerListener(this.bGV);
        this.bGM.registerListener(this.aXT);
    }

    private static void Jx() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void Wk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new u(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wl() {
        return !this.bGO.e(this.bGN.WO(), this.bGN.WP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bGN.WL();
    }

    private void Wn() {
        this.bGM.registerListener(new v(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bGM.registerListener(new w(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void Wo() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXS.getPageContext().getPageActivity());
        aVar.bX(w.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_cancel_change), new k(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new l(this));
        aVar.bY(w.e.cp_cont_b);
        aVar.b(this.aXS.getPageContext());
        aVar.td();
    }

    public void a(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXS.getPageContext().getPageActivity());
            aVar.cC(String.format(this.aXS.getPageContext().getString(w.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.cancel_attention), new m(this, gVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new n(this));
            aVar.bY(w.e.cp_cont_b);
            aVar.b(this.aXS.getPageContext());
            aVar.td();
        }
    }

    public void dr(boolean z) {
        if (this.bGT == null) {
            Wp();
        }
        this.bGT.aI(z);
    }

    private void Wp() {
        this.bGT = new com.baidu.tbadk.core.view.a(this.aXS.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aXS.getActivity()).inflate(w.j.enter_forum_view, (ViewGroup) null);
        this.bGN = new com.baidu.tieba.enterForum.c.c(this.bGM, this.mRootView, this.bGb);
        this.bGN.a(this.alm);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void ds(boolean z) {
        if (this.bGN != null && this.bGM != null) {
            if (z) {
                if (this.bGM.isPrimary() && this.bGM.isResumed()) {
                    this.bGN.startPullRefresh();
                    return;
                } else {
                    this.bGN.WN();
                    return;
                }
            }
            this.bGN.WN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bGM.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        ArrayList arrayList;
        ArrayList<com.baidu.tieba.enterForum.b.g> arrayList2;
        boolean z = true;
        if (this.bGN != null) {
            if (bVar == null) {
                this.bGN.ac(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.b.h VT = bVar.VT();
            com.baidu.tieba.enterForum.b.k VU = bVar.VU();
            ArrayList<com.baidu.tieba.enterForum.b.g> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            if (VT == null && VU == null) {
                arrayList = arrayList4;
                arrayList2 = arrayList3;
            } else {
                List<com.baidu.tieba.enterForum.b.j> Wb = VU.Wb();
                ArrayList<com.baidu.tieba.enterForum.b.g> VZ = VT.VZ();
                if (x.r(VZ) && x.r(Wb)) {
                    arrayList = Wb;
                    arrayList2 = VZ;
                } else {
                    z = false;
                    arrayList = Wb;
                    arrayList2 = VZ;
                }
            }
            if (z) {
                this.bGN.ac(this.mRootView);
                return;
            }
            d(arrayList2, arrayList);
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.tX().getString("hot_search_title", ""));
            this.bGN.WQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bGN.setSearchHint(str.trim());
        } else {
            this.bGN.setSearchHint(this.aXS.getActivity().getString(w.l.enter_forum_search_tip));
        }
    }

    private void d(List<com.baidu.tieba.enterForum.b.g> list, List<com.baidu.tieba.enterForum.b.j> list2) {
        if (list != null && list2 != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bGN.f(this.bGO.a(list, com.baidu.tbadk.util.c.Gk()), list2);
        }
    }

    public void NA() {
        if (this.bGN != null) {
            dt(false);
        }
    }

    public void onDestroy() {
        DT();
        com.baidu.tieba.enterForum.model.a.Ws().destroy();
        if (this.bGN != null) {
            if (this.bGO != null && TbadkCoreApplication.m9getInst().getLikeBarChanged()) {
                this.bGO.af(this.bGN.WO());
            }
            this.bGN.onDestory();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.bGN != null) {
            this.bGN.onChangeSkinType(i);
        }
    }

    public void DT() {
        if (this.bGO != null) {
            this.bGO.cancelLoadData();
        }
    }

    public void dt(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bGU && this.bGO != null && this.bGN != null) {
            String str = this.bGQ;
            this.bGQ = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bGQ == null || this.bGQ.equals(str)) {
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = true;
            }
            if (TbadkCoreApplication.m9getInst().getLikeBarChanged()) {
                TbadkCoreApplication.m9getInst().setLikeBarChanged(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TbadkCoreApplication.m9getInst().signedForumCount() > 0) {
                if (this.bGO != null && this.bGO.WB() != null && this.bGO.WB().VT() != null) {
                    Iterator<com.baidu.tieba.enterForum.b.g> it = this.bGO.WB().VT().VZ().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.b.g next = it.next();
                        if (TbadkCoreApplication.m9getInst().hasSignedForum(next.getName())) {
                            next.hq(1);
                            int signLevelUpValue = TbadkCoreApplication.m9getInst().getSignLevelUpValue(next.getName());
                            if (signLevelUpValue > 0) {
                                next.setLevel(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().clearSignedForum();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.tbadkCore.util.l.qb(currentAccount);
                }
                this.bGN.notifyDataSetChanged();
            }
            if (z2 || z4) {
                DT();
                if (z4) {
                    this.bGO.dv(StringUtils.isNull(this.bGQ) ? false : true);
                } else if (z2) {
                    this.bGO.dw(!StringUtils.isNull(this.bGQ));
                    this.bGO.dv(StringUtils.isNull(this.bGQ) ? false : true);
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
        if (this.bGN != null && this.bGN.WJ() != null) {
            this.bGN.WJ().completePullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.enterForum.b.g, Integer, String> {
        private com.baidu.tieba.enterForum.b.g bHd;
        private z mNetwork = null;

        public a(com.baidu.tieba.enterForum.b.g gVar) {
            this.bHd = null;
            this.bHd = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.b.g... gVarArr) {
            com.baidu.tieba.enterForum.b.g gVar = this.bHd;
            if (gVar != null) {
                try {
                    if (gVar.getId() != null && gVar.getName() != null) {
                        this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", gVar.getId());
                        this.mNetwork.n("kw", gVar.getName());
                        this.mNetwork.uJ().vD().mIsNeedTbs = true;
                        this.mNetwork.ul();
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
            i.this.dr(false);
            if (this.mNetwork != null) {
                if (!this.mNetwork.uJ().vE().isRequestSuccess()) {
                    if (i.this.aXS != null) {
                        if (StringUtils.isNull(this.mNetwork.getErrorString())) {
                            if (i.this.bGM.isAdded()) {
                                i.this.aXS.showToast(i.this.aXS.getActivity().getString(w.l.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        i.this.aXS.showToast(this.mNetwork.getErrorString());
                        return;
                    }
                    return;
                }
                i.this.bGS = true;
                if (i.this.bGM.isAdded() && i.this.aXS != null) {
                    i.this.aXS.showToast(i.this.aXS.getActivity().getString(w.l.unlike_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                i.this.d(false, this.bHd.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bHd.getId()));
                long c = com.baidu.adp.lib.g.b.c(this.bHd.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.bHd.getName()));
                }
                i.this.bGN.b(this.bHd);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            i.this.dr(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fs();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, String str) {
        new o(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int Ep = bVar.Ep();
        com.baidu.tbadk.mvc.b.a Eq = bVar.Eq();
        switch (Ep) {
            case 1:
                if (Eq instanceof com.baidu.tieba.enterForum.b.g) {
                    String name = ((com.baidu.tieba.enterForum.b.g) Eq).getName();
                    if (au.aB(name)) {
                        this.aXS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aXS.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<com.baidu.tieba.enterForum.b.g> WO = this.bGN.WO();
                        if (!x.r(WO)) {
                            if (x.q(WO) > 1 && WO.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < WO.size()) {
                                    if (!WO.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new as("c12049").aa("obj_type", "2").s("obj_locate", i));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                if (com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("enter_forum_edit_mode", false)) {
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("enter_forum_edit_mode", true);
                this.bGN.hr(Eq instanceof com.baidu.tieba.enterForum.b.i ? ((com.baidu.tieba.enterForum.b.i) Eq).getPosition() : 0);
                this.bGS = false;
                if (this.bGM.getView() == null || this.bGM.getView().getParent() == null) {
                    return true;
                }
                this.bGM.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Eq instanceof com.baidu.tieba.enterForum.b.g) {
                    a((com.baidu.tieba.enterForum.b.g) Eq);
                    return true;
                }
                return false;
            case 5:
                if (Eq instanceof com.baidu.tieba.enterForum.b.j) {
                    String forumName = ((com.baidu.tieba.enterForum.b.j) Eq).getForumName();
                    if (au.aB(forumName)) {
                        long forumId = ((com.baidu.tieba.enterForum.b.j) Eq).getForumId();
                        this.aXS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aXS.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.log(new as("c10577").g("fid", forumId));
                        return true;
                    }
                    return false;
                }
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aXS.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXS.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new as("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aXS.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXS.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new as("c10378").aa("obj_type", "4"));
                return true;
            case 8:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, "推荐"));
                TiebaStatic.log(new as("c12049").aa("obj_type", "2").s("obj_locate", 1));
                this.aXS.finish();
                return true;
            default:
                return false;
        }
    }

    public void Wq() {
        if (this.bGN != null) {
            this.bGN.WM();
        }
    }

    public boolean Wr() {
        if (this.bGN != null) {
            return this.bGN.Wr();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Eo() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aXS.getUniqueId();
    }

    public void du(boolean z) {
        int i = 1;
        if (this.bGN != null && this.bGM != null) {
            boolean z2 = this.bGN.Wr() && this.bGM.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
