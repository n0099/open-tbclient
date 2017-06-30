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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
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
    private BaseFragmentActivity aWN;
    private LikeModel bAL;
    private e bTb;
    private EnterForumModel bTd;
    private boolean bTe;
    private String bTg;
    private long bTh;
    private boolean bTi;
    private com.baidu.tbadk.core.view.a bTj;
    private boolean bTk;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.c bTc = null;
    private boolean bTf = false;
    private final CustomMessageListener aWO = new j(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private CustomMessageListener bTl = new q(this, CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE);
    private com.baidu.adp.framework.listener.a bTm = new r(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bTn = new s(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.f bTo = new t(this);
    private final EnterForumModel.b bTp = new u(this);
    private ae.b alP = new v(this);
    private ViewEventCenter bSq = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        MF();
    }

    public i(e eVar) {
        this.bTd = null;
        this.isFirst = true;
        this.bTe = false;
        this.bTh = -1L;
        this.bTb = eVar;
        this.aWN = eVar.getBaseFragmentActivity();
        this.bSq.addEventDelegate(this);
        this.bTh = System.currentTimeMillis();
        this.isFirst = true;
        this.bTe = false;
        this.bTg = "";
        this.bTd = new EnterForumModel(this.aWN.getPageContext());
        this.bAL = new LikeModel(this.aWN.getPageContext());
        this.bAL.setLoadDataCallBack(this.bTo);
        this.bTd.a(this.bTp);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.aaT().n(this.bTb.getFragmentActivity(), com.baidu.adp.lib.util.k.n(this.bTb.getFragmentActivity()));
        initUI();
        initListener();
        aaK();
    }

    private void initListener() {
        aaN();
        this.bTb.registerListener(this.bTn);
        this.bTb.registerListener(this.bTm);
        this.bTb.registerListener(this.aWO);
        this.bTb.registerListener(this.bTl);
    }

    private static void MF() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private void aaK() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, new w(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaL() {
        return !this.bTd.h(this.bTc.abr(), this.bTc.abs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bTc.abo();
    }

    private void aaN() {
        this.bTb.registerListener(new x(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bTb.registerListener(new k(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void aaO() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aWN.getPageContext().getPageActivity());
        aVar.bY(w.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_cancel_change), new l(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new m(this));
        aVar.bZ(w.e.cp_cont_b);
        aVar.b(this.aWN.getPageContext());
        aVar.ta();
    }

    public void a(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aWN.getPageContext().getPageActivity());
            aVar.cI(String.format(this.aWN.getPageContext().getString(w.l.attention_cancel_dialog_message), gVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.cancel_attention), new n(this, gVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new o(this));
            aVar.bZ(w.e.cp_cont_b);
            aVar.b(this.aWN.getPageContext());
            aVar.ta();
        }
    }

    public void dX(boolean z) {
        if (this.bTj == null) {
            aaP();
        }
        this.bTj.aI(z);
    }

    private void aaP() {
        this.bTj = new com.baidu.tbadk.core.view.a(this.aWN.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aWN.getActivity()).inflate(w.j.enter_forum_view, (ViewGroup) null);
        this.bTc = new com.baidu.tieba.enterForum.c.c(this.bTb, this.mRootView, this.bSq);
        this.bTc.a(this.alP);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dY(boolean z) {
        if (this.bTc != null && this.bTb != null) {
            if (z) {
                if (this.bTb.isPrimary() && this.bTb.isResumed()) {
                    this.bTc.startPullRefresh();
                    return;
                } else {
                    this.bTc.abq();
                    return;
                }
            }
            this.bTc.abq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bTb.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        ArrayList arrayList;
        ArrayList<com.baidu.tieba.enterForum.b.g> arrayList2;
        boolean z;
        if (this.bTc != null) {
            if (bVar == null) {
                this.bTc.ad(this.mRootView);
                return;
            }
            com.baidu.tieba.enterForum.b.h aas = bVar.aas();
            com.baidu.tieba.enterForum.b.k aat = bVar.aat();
            ArrayList<com.baidu.tieba.enterForum.b.g> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            if (aas == null && aat == null) {
                arrayList2 = arrayList3;
                z = true;
                arrayList = arrayList4;
            } else {
                List<com.baidu.tieba.enterForum.b.j> aaB = aat.aaB();
                if (aas != null) {
                    arrayList3 = aas.aaz();
                }
                if (z.t(arrayList3) && z.t(aaB)) {
                    arrayList2 = arrayList3;
                    z = true;
                    arrayList = aaB;
                } else {
                    arrayList = aaB;
                    arrayList2 = arrayList3;
                    z = false;
                }
            }
            if (z) {
                this.bTc.ad(this.mRootView);
                return;
            }
            g(arrayList2, arrayList);
            if (b(bVar)) {
                this.bTc.ap(bVar.aau());
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_title", ""));
            this.bTc.abt();
        }
    }

    public boolean b(com.baidu.tieba.enterForum.b.b bVar) {
        if (TbadkCoreApplication.isLogin() && bVar != null) {
            if ((bVar.aas() == null || z.t(bVar.aas().aaz())) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_recommend_forums_window_", false)) {
                return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("set_recommend_label", false);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bTc.setSearchHint(str.trim());
        } else {
            this.bTc.setSearchHint(this.aWN.getActivity().getString(w.l.enter_forum_search_tip));
        }
    }

    private void g(List<com.baidu.tieba.enterForum.b.g> list, List<com.baidu.tieba.enterForum.b.j> list2) {
        if (list != null && list2 != null) {
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bTc.i(this.bTd.a(list, com.baidu.tbadk.util.c.GB()), list2);
        }
    }

    public void OZ() {
        if (this.bTc != null) {
            dZ(false);
        }
    }

    public void onDestroy() {
        Ek();
        com.baidu.tieba.enterForum.model.a.aaT().destroy();
        if (this.bTc != null) {
            if (this.bTd != null && TbadkCoreApplication.m9getInst().getLikeBarChanged()) {
                this.bTd.al(this.bTc.abr());
            }
            this.bTc.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST);
    }

    public void onChangeSkinType(int i) {
        if (this.bTc != null) {
            this.bTc.onChangeSkinType(i);
        }
    }

    public void Ek() {
        if (this.bTd != null) {
            this.bTd.cancelLoadData();
        }
    }

    public void dZ(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bTk && this.bTd != null && this.bTc != null) {
            String str = this.bTg;
            this.bTg = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bTg == null || this.bTg.equals(str)) {
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
                if (this.bTd != null && this.bTd.abc() != null && this.bTd.abc().aas() != null) {
                    Iterator<com.baidu.tieba.enterForum.b.g> it = this.bTd.abc().aas().aaz().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.b.g next = it.next();
                        if (TbadkCoreApplication.m9getInst().hasSignedForum(next.getName())) {
                            next.hX(1);
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
                    com.baidu.tieba.tbadkCore.util.l.rn(currentAccount);
                }
                this.bTc.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ek();
                if (z4) {
                    this.bTd.eb(StringUtils.isNull(this.bTg) ? false : true);
                } else if (z2) {
                    this.bTd.ec(!StringUtils.isNull(this.bTg));
                    this.bTd.eb(StringUtils.isNull(this.bTg) ? false : true);
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
        if (this.bTc != null && this.bTc.abm() != null) {
            this.bTc.abm().completePullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.enterForum.b.g, Integer, String> {
        private com.baidu.tieba.enterForum.b.g bTu;
        private ab mNetwork = null;

        public a(com.baidu.tieba.enterForum.b.g gVar) {
            this.bTu = null;
            this.bTu = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.enterForum.b.g... gVarArr) {
            com.baidu.tieba.enterForum.b.g gVar = this.bTu;
            if (gVar != null) {
                try {
                    if (gVar.getId() != null && gVar.getName() != null) {
                        this.mNetwork = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", gVar.getId());
                        this.mNetwork.n("kw", gVar.getName());
                        this.mNetwork.uV().vR().mIsNeedTbs = true;
                        this.mNetwork.uy();
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
            i.this.dX(false);
            if (this.mNetwork != null) {
                if (!this.mNetwork.uV().vS().isRequestSuccess()) {
                    if (i.this.aWN != null) {
                        if (StringUtils.isNull(this.mNetwork.getErrorString())) {
                            if (i.this.bTb.isAdded()) {
                                i.this.aWN.showToast(i.this.aWN.getActivity().getString(w.l.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        i.this.aWN.showToast(this.mNetwork.getErrorString());
                        return;
                    }
                    return;
                }
                i.this.bTi = true;
                if (i.this.bTb.isAdded() && i.this.aWN != null) {
                    i.this.aWN.showToast(i.this.aWN.getActivity().getString(w.l.unlike_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                i.this.d(false, this.bTu.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bTu.getId()));
                long c = com.baidu.adp.lib.g.b.c(this.bTu.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.bTu.getName()));
                }
                i.this.bTc.b(this.bTu);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            i.this.dX(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fr();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, String str) {
        new p(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int i = 0;
        int EG = bVar.EG();
        com.baidu.tbadk.mvc.b.a EH = bVar.EH();
        switch (EG) {
            case 1:
                if (EH instanceof com.baidu.tieba.enterForum.b.g) {
                    String name = ((com.baidu.tieba.enterForum.b.g) EH).getName();
                    if (aw.aG(name)) {
                        this.aWN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWN.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        List<com.baidu.tieba.enterForum.b.g> abr = this.bTc.abr();
                        if (!z.t(abr)) {
                            if (z.s(abr) > 1 && abr.get(0).getType() == 1) {
                                i = 1;
                            }
                            int i2 = i;
                            while (true) {
                                if (i2 < abr.size()) {
                                    if (!abr.get(i2).getName().equals(name)) {
                                        i2++;
                                    } else {
                                        i = (i2 - i) + 2;
                                    }
                                }
                            }
                        }
                        TiebaStatic.log(new au("c12049").Z("obj_type", "2").r("obj_locate", i));
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
                this.bTc.hZ(EH instanceof com.baidu.tieba.enterForum.b.i ? ((com.baidu.tieba.enterForum.b.i) EH).getPosition() : 0);
                this.bTi = false;
                if (this.bTb.getView() == null || this.bTb.getView().getParent() == null) {
                    return true;
                }
                this.bTb.getView().getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
                return true;
            case 4:
                if (EH instanceof com.baidu.tieba.enterForum.b.g) {
                    a((com.baidu.tieba.enterForum.b.g) EH);
                    return true;
                }
                return false;
            case 5:
                if (EH instanceof com.baidu.tieba.enterForum.b.j) {
                    String forumName = ((com.baidu.tieba.enterForum.b.j) EH).getForumName();
                    if (aw.aG(forumName)) {
                        long forumId = ((com.baidu.tieba.enterForum.b.j) EH).getForumId();
                        this.aWN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWN.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.log(new au("c10577").f("fid", forumId));
                        return true;
                    }
                    return false;
                }
                return false;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aWN.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aWN.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new au("find_more_text_click"));
                return true;
            case 7:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aWN.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aWN.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log(new au("c10378").Z("obj_type", "4"));
                return true;
            case 8:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, "推荐"));
                TiebaStatic.log(new au("c12049").Z("obj_type", "2").r("obj_locate", 1));
                this.aWN.finish();
                return true;
            case 9:
                if (this.bTc != null) {
                    this.bTc.startPullRefresh();
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    public void aaQ() {
        if (this.bTc != null) {
            this.bTc.abp();
        }
    }

    public boolean aaR() {
        if (this.bTc != null) {
            return this.bTc.aaR();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EF() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aWN.getUniqueId();
    }

    public void ea(boolean z) {
        int i = 1;
        if (this.bTc != null && this.bTb != null) {
            boolean z2 = this.bTc.aaR() && this.bTb.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }

    public void aaS() {
        if (this.bTc != null) {
            this.bTc.aaS();
        }
    }
}
