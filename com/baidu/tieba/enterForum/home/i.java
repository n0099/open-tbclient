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
    private BaseFragmentActivity aVu;
    private e bMA;
    private EnterForumModel bMC;
    private boolean bMD;
    private String bME;
    private long bMF;
    private boolean bMG;
    private com.baidu.tbadk.core.view.a bMH;
    private boolean bMI;
    private LikeModel bzS;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.c bMB = null;
    private final CustomMessageListener aVv = new j(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private com.baidu.adp.framework.listener.a bMJ = new p(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bMK = new q(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.f bML = new r(this);
    private final EnterForumModel.b bMM = new s(this);
    private ae.b alb = new t(this);
    private ViewEventCenter bLQ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        LR();
    }

    public i(e eVar) {
        this.bMC = null;
        this.isFirst = true;
        this.bMD = false;
        this.bMF = -1L;
        this.bMA = eVar;
        this.aVu = eVar.getBaseFragmentActivity();
        this.bLQ.addEventDelegate(this);
        this.bMF = System.currentTimeMillis();
        this.isFirst = true;
        this.bMD = false;
        this.bME = "";
        this.bMC = new EnterForumModel(this.aVu.getPageContext());
        this.bzS = new LikeModel(this.aVu.getPageContext());
        this.bzS.setLoadDataCallBack(this.bML);
        this.bMC.a(this.bMM);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.Xv().m(this.bMA.getFragmentActivity(), com.baidu.adp.lib.util.k.n(this.bMA.getFragmentActivity()));
        initUI();
        initListener();
        Xn();
    }

    private void initListener() {
        Xq();
        this.bMA.registerListener(this.bMK);
        this.bMA.registerListener(this.bMJ);
        this.bMA.registerListener(this.aVv);
    }

    private static void LR() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void Xn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new u(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xo() {
        return !this.bMC.g(this.bMB.XR(), this.bMB.XS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xp() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bMB.XO();
    }

    private void Xq() {
        this.bMA.registerListener(new v(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bMA.registerListener(new w(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void Xr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aVu.getPageContext().getPageActivity());
        aVar.bY(w.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_cancel_change), new k(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new l(this));
        aVar.bZ(w.e.cp_cont_b);
        aVar.b(this.aVu.getPageContext());
        aVar.tc();
    }

    public void a(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aVu.getPageContext().getPageActivity());
            aVar.cB(String.format(this.aVu.getPageContext().getString(w.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.cancel_attention), new m(this, gVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new n(this));
            aVar.bZ(w.e.cp_cont_b);
            aVar.b(this.aVu.getPageContext());
            aVar.tc();
        }
    }

    public void dI(boolean z) {
        if (this.bMH == null) {
            Xs();
        }
        this.bMH.aH(z);
    }

    private void Xs() {
        this.bMH = new com.baidu.tbadk.core.view.a(this.aVu.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aVu.getActivity()).inflate(w.j.enter_forum_view, (ViewGroup) null);
        this.bMB = new com.baidu.tieba.enterForum.c.c(this.bMA, this.mRootView, this.bLQ);
        this.bMB.a(this.alb);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dJ(boolean z) {
        if (this.bMB != null && this.bMA != null) {
            if (z) {
                if (this.bMA.isPrimary() && this.bMA.isResumed()) {
                    this.bMB.startPullRefresh();
                    return;
                } else {
                    this.bMB.XQ();
                    return;
                }
            }
            this.bMB.XQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bMA.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        ArrayList arrayList;
        ArrayList<com.baidu.tieba.enterForum.b.g> arrayList2;
        boolean z;
        if (this.bMB != null) {
            if (bVar == null) {
                this.bMB.ac(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.b.h WW = bVar.WW();
            com.baidu.tieba.enterForum.b.k WX = bVar.WX();
            ArrayList<com.baidu.tieba.enterForum.b.g> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            if (WW == null && WX == null) {
                arrayList2 = arrayList3;
                z = true;
                arrayList = arrayList4;
            } else {
                List<com.baidu.tieba.enterForum.b.j> Xe = WX.Xe();
                if (WW != null) {
                    arrayList3 = WW.Xc();
                }
                if (x.r(arrayList3) && x.r(Xe)) {
                    arrayList2 = arrayList3;
                    z = true;
                    arrayList = Xe;
                } else {
                    arrayList = Xe;
                    arrayList2 = arrayList3;
                    z = false;
                }
            }
            if (z) {
                this.bMB.ac(this.mRootView);
                return;
            }
            f(arrayList2, arrayList);
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.bMB.XT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bMB.setSearchHint(str.trim());
        } else {
            this.bMB.setSearchHint(this.aVu.getActivity().getString(w.l.enter_forum_search_tip));
        }
    }

    private void f(List<com.baidu.tieba.enterForum.b.g> list, List<com.baidu.tieba.enterForum.b.j> list2) {
        if (list != null && list2 != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bMB.h(this.bMC.a(list, com.baidu.tbadk.util.c.Ge()), list2);
        }
    }

    public void NJ() {
        if (this.bMB != null) {
            dK(false);
        }
    }

    public void onDestroy() {
        DN();
        com.baidu.tieba.enterForum.model.a.Xv().destroy();
        if (this.bMB != null) {
            if (this.bMC != null && TbadkCoreApplication.m9getInst().getLikeBarChanged()) {
                this.bMC.af(this.bMB.XR());
            }
            this.bMB.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.bMB != null) {
            this.bMB.onChangeSkinType(i);
        }
    }

    public void DN() {
        if (this.bMC != null) {
            this.bMC.cancelLoadData();
        }
    }

    public void dK(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bMI && this.bMC != null && this.bMB != null) {
            String str = this.bME;
            this.bME = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bME == null || this.bME.equals(str)) {
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
                if (this.bMC != null && this.bMC.XE() != null && this.bMC.XE().WW() != null) {
                    Iterator<com.baidu.tieba.enterForum.b.g> it = this.bMC.XE().WW().Xc().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.b.g next = it.next();
                        if (TbadkCoreApplication.m9getInst().hasSignedForum(next.getName())) {
                            next.hO(1);
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
                    com.baidu.tieba.tbadkCore.util.l.qp(currentAccount);
                }
                this.bMB.notifyDataSetChanged();
            }
            if (z2 || z4) {
                DN();
                if (z4) {
                    this.bMC.dM(StringUtils.isNull(this.bME) ? false : true);
                } else if (z2) {
                    this.bMC.dN(!StringUtils.isNull(this.bME));
                    this.bMC.dM(StringUtils.isNull(this.bME) ? false : true);
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
        if (this.bMB != null && this.bMB.XM() != null) {
            this.bMB.XM().completePullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.enterForum.b.g, Integer, String> {
        private com.baidu.tieba.enterForum.b.g bMR;
        private z mNetwork = null;

        public a(com.baidu.tieba.enterForum.b.g gVar) {
            this.bMR = null;
            this.bMR = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.b.g... gVarArr) {
            com.baidu.tieba.enterForum.b.g gVar = this.bMR;
            if (gVar != null) {
                try {
                    if (gVar.getId() != null && gVar.getName() != null) {
                        this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", gVar.getId());
                        this.mNetwork.n("kw", gVar.getName());
                        this.mNetwork.uF().vA().mIsNeedTbs = true;
                        this.mNetwork.ug();
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
            i.this.dI(false);
            if (this.mNetwork != null) {
                if (!this.mNetwork.uF().vB().isRequestSuccess()) {
                    if (i.this.aVu != null) {
                        if (StringUtils.isNull(this.mNetwork.getErrorString())) {
                            if (i.this.bMA.isAdded()) {
                                i.this.aVu.showToast(i.this.aVu.getActivity().getString(w.l.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        i.this.aVu.showToast(this.mNetwork.getErrorString());
                        return;
                    }
                    return;
                }
                i.this.bMG = true;
                if (i.this.bMA.isAdded() && i.this.aVu != null) {
                    i.this.aVu.showToast(i.this.aVu.getActivity().getString(w.l.unlike_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                i.this.d(false, this.bMR.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bMR.getId()));
                long c = com.baidu.adp.lib.g.b.c(this.bMR.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.bMR.getName()));
                }
                i.this.bMB.b(this.bMR);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            i.this.dI(true);
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
        int Ej = bVar.Ej();
        com.baidu.tbadk.mvc.b.a Ek = bVar.Ek();
        switch (Ej) {
            case 1:
                if (Ek instanceof com.baidu.tieba.enterForum.b.g) {
                    String name = ((com.baidu.tieba.enterForum.b.g) Ek).getName();
                    if (au.aB(name)) {
                        this.aVu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVu.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<com.baidu.tieba.enterForum.b.g> XR = this.bMB.XR();
                        if (!x.r(XR)) {
                            if (x.q(XR) > 1 && XR.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < XR.size()) {
                                    if (!XR.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new as("c12049").Z("obj_type", "2").r("obj_locate", i));
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
                this.bMB.hP(Ek instanceof com.baidu.tieba.enterForum.b.i ? ((com.baidu.tieba.enterForum.b.i) Ek).getPosition() : 0);
                this.bMG = false;
                if (this.bMA.getView() == null || this.bMA.getView().getParent() == null) {
                    return true;
                }
                this.bMA.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (Ek instanceof com.baidu.tieba.enterForum.b.g) {
                    a((com.baidu.tieba.enterForum.b.g) Ek);
                    return true;
                }
                return false;
            case 5:
                if (Ek instanceof com.baidu.tieba.enterForum.b.j) {
                    String forumName = ((com.baidu.tieba.enterForum.b.j) Ek).getForumName();
                    if (au.aB(forumName)) {
                        long forumId = ((com.baidu.tieba.enterForum.b.j) Ek).getForumId();
                        this.aVu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aVu.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.log(new as("c10577").f("fid", forumId));
                        return true;
                    }
                    return false;
                }
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aVu.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new as("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aVu.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aVu.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new as("c10378").Z("obj_type", "4"));
                return true;
            case 8:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, "推荐"));
                TiebaStatic.log(new as("c12049").Z("obj_type", "2").r("obj_locate", 1));
                this.aVu.finish();
                return true;
            default:
                return false;
        }
    }

    public void Xt() {
        if (this.bMB != null) {
            this.bMB.XP();
        }
    }

    public boolean Xu() {
        if (this.bMB != null) {
            return this.bMB.Xu();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Ei() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aVu.getUniqueId();
    }

    public void dL(boolean z) {
        int i = 1;
        if (this.bMB != null && this.bMA != null) {
            boolean z2 = this.bMB.Xu() && this.bMA.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
