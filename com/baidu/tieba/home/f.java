package com.baidu.tieba.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.x;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    private BaseFragmentActivity aPI;
    private boolean aPK;
    private ac zm;
    private r aPB = null;
    private n aPC = null;
    private com.baidu.tieba.model.d aPD = null;
    private ab aPE = null;
    private boolean aPF = true;
    private boolean aPG = false;
    private Boolean aPH = false;
    private long aDp = -1;
    private boolean aPJ = false;
    private com.baidu.adp.framework.listener.a aPL = new g(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private com.baidu.adp.base.i aPM = new h(this);
    private final com.baidu.tieba.model.h aPN = new i(this);
    private final View.OnKeyListener aPO = new j(this);
    private final com.baidu.adp.widget.ListView.g wz = new k(this);

    static {
        JC();
    }

    private void JB() {
        MessageManager.getInstance().unRegisterListener(this.aPL);
        MessageManager.getInstance().registerListener(this.aPL);
    }

    private static void JC() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.aPB.JX() || dialogInterface == this.aPB.JY()) {
            switch (i) {
                case 0:
                    if (this.aPE != null) {
                        String name = this.aPE.getName();
                        if (bf.aC(name)) {
                            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aPI.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    JD();
                    return;
                default:
                    return;
            }
        }
    }

    private void JD() {
        if (this.aPE != null) {
            if (this.aPE.isLike() == 1) {
                this.aPB.JW();
            } else if (this.aPC == null) {
                this.aPC = new n(this, this.aPE);
                this.aPC.execute(new ab[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aPI = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aPL.setTag(BdUniqueId.gen());
        JB();
        this.aDp = System.currentTimeMillis();
        initData(getArguments());
        initUI();
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(x.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aPB = new r(this.aPI, this, this.aPO);
        this.aPB.a(this.wz);
        this.aPB.e(new l(this));
        this.aPB.JK().setOnClickListener(this);
    }

    private void initData(Bundle bundle) {
        this.aPF = true;
        this.aPG = false;
        this.aPH = false;
        this.aPD = new com.baidu.tieba.model.d(this.aPI.getPageContext());
        this.aPD.a(this.aPN);
        this.zm = new ac(this.aPI.getPageContext());
        this.zm.setLoadDataCallBack(this.aPM);
        this.aPD.a(this.aPN);
        long j = com.baidu.tbadk.core.sharedPref.b.oj().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (j == 0 || N(j)) {
            this.aPK = true;
        } else {
            this.aPK = false;
        }
    }

    public boolean JE() {
        return this.aPK;
    }

    private boolean N(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aPJ = false;
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(getActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            getActivity().finish();
        }
        if (!isShow()) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(getActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            getActivity().finish();
        }
        this.aPB.onResume();
        ck(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        wm();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.search_text_tip) {
            sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aPI.getPageContext().getPageActivity())));
        } else if (view.getId() == this.aPB.JO() || view.getId() == this.aPB.JP()) {
            if (!this.aPJ) {
                ab abVar = view.getTag() instanceof ab ? (ab) view.getTag() : null;
                if (abVar != null) {
                    String name = abVar.getName();
                    if (bf.aC(name)) {
                        TiebaStatic.eventStat(this.aPI.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aPJ = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aPI.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else if (view == this.aPB.JK()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aPI.getPageContext().getPageActivity())));
        } else if (view.getId() == this.aPB.JQ()) {
            if (this.aPB.JZ() != null) {
                this.aPB.JZ().cm(false);
                this.aPB.notifyDataSetChanged();
                com.baidu.tbadk.core.sharedPref.b.oj().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                TiebaStatic.eventStat(this.aPI.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
            }
        } else if (view.getId() == this.aPB.JR()) {
            if (this.aPB.JZ() != null && this.aPB.JZ().JG() > 1) {
                if (this.aPB.JZ().Jj() != null) {
                    this.aPB.JZ().Jj().clear();
                }
                this.aPB.JZ().fs((this.aPB.JZ().getPageIndex() + 1) % this.aPB.JZ().JG());
                this.aPB.JZ().notifyDataSetChanged();
                TiebaStatic.eventStat(this.aPI.getPageContext().getPageActivity(), "recom_flist_change", "click", 1, new Object[0]);
            }
        } else if (view.getId() == this.aPB.JS()) {
            com.baidu.tieba.data.m mVar = view.getTag() instanceof com.baidu.tieba.data.m ? (com.baidu.tieba.data.m) view.getTag() : null;
            if (mVar != null) {
                String forumName = mVar.getForumName();
                String valueOf = String.valueOf(mVar.getForumId());
                if (bf.aC(forumName)) {
                    TiebaStatic.eventStat(this.aPI.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                    this.aPJ = true;
                    sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aPI.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    TiebaStatic.eventStat(this.aPI.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf);
                }
            }
        } else if (view.getId() == this.aPB.JT()) {
            com.baidu.tieba.data.m mVar2 = view.getTag() instanceof com.baidu.tieba.data.m ? (com.baidu.tieba.data.m) view.getTag() : null;
            if (mVar2 != null) {
                String forumName2 = mVar2.getForumName();
                String valueOf2 = String.valueOf(mVar2.getForumId());
                if (bf.aC(forumName2)) {
                    this.zm.aQ(forumName2, valueOf2);
                    TiebaStatic.eventStat(this.aPI.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.aPB.JO() || view.getId() == this.aPB.JP()) {
            this.aPE = null;
            ab abVar = view.getTag() instanceof ab ? (ab) view.getTag() : null;
            if (abVar != null) {
                this.aPE = abVar;
                String name = abVar.getName();
                int isLike = abVar.isLike();
                if (bf.aC(name)) {
                    if (isLike == 1) {
                        this.aPB.JU();
                    } else {
                        this.aPB.JV();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aPB.onChangeSkinType(i);
    }

    public void wm() {
        if (this.aPC != null) {
            this.aPC.cancel();
            this.aPC = null;
        }
        this.aPD.cancelLoadData();
    }

    public void ck(boolean z) {
        boolean z2;
        boolean z3;
        if (this.aPD != null) {
            boolean booleanValue = this.aPH.booleanValue();
            this.aPH = Boolean.valueOf((TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccountName() == null) ? false : true);
            if (this.aPF) {
                this.aPF = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.aPH.booleanValue()) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (TbadkCoreApplication.m255getInst().getLikeBarChanged()) {
                TbadkCoreApplication.m255getInst().setLikeBarChanged(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TbadkCoreApplication.m255getInst().signedForumCount() > 0) {
                if (this.aPD != null && this.aPD.JH() != null && this.aPD.JH().CE() != null) {
                    Iterator<ab> it = this.aPD.JH().CE().CT().iterator();
                    while (it.hasNext()) {
                        ab next = it.next();
                        if (TbadkCoreApplication.m255getInst().hasSignedForum(next.getName())) {
                            next.hK(1);
                            int signLevelUpValue = TbadkCoreApplication.m255getInst().getSignLevelUpValue(next.getName());
                            if (signLevelUpValue > 0) {
                                next.setLevel(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.m255getInst().clearSignedForum();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.tbadkCore.util.j.ir(currentAccount);
                }
                this.aPB.notifyDataSetChanged();
            }
            if (z2 || z4) {
                wm();
                if (z4) {
                    this.aPB.jJ();
                } else if (z2) {
                    this.aPD.dv(this.aPH.booleanValue());
                    this.aPB.jJ();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        new m(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }
}
