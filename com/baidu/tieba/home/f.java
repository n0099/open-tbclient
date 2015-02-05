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
    private BaseFragmentActivity aPH;
    private boolean aPJ;
    private ac zj;
    private r aPA = null;
    private n aPB = null;
    private com.baidu.tieba.model.d aPC = null;
    private ab aPD = null;
    private boolean aPE = true;
    private boolean aPF = false;
    private Boolean aPG = false;
    private long aDm = -1;
    private boolean aPI = false;
    private com.baidu.adp.framework.listener.a aPK = new g(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private com.baidu.adp.base.i aPL = new h(this);
    private final com.baidu.tieba.model.h aPM = new i(this);
    private final View.OnKeyListener aPN = new j(this);
    private final com.baidu.adp.widget.ListView.g ww = new k(this);

    static {
        Jx();
    }

    private void Jw() {
        MessageManager.getInstance().unRegisterListener(this.aPK);
        MessageManager.getInstance().registerListener(this.aPK);
    }

    private static void Jx() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.aPA.JS() || dialogInterface == this.aPA.JT()) {
            switch (i) {
                case 0:
                    if (this.aPD != null) {
                        String name = this.aPD.getName();
                        if (bf.aC(name)) {
                            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aPH.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    Jy();
                    return;
                default:
                    return;
            }
        }
    }

    private void Jy() {
        if (this.aPD != null) {
            if (this.aPD.isLike() == 1) {
                this.aPA.JR();
            } else if (this.aPB == null) {
                this.aPB = new n(this, this.aPD);
                this.aPB.execute(new ab[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aPH = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aPK.setTag(BdUniqueId.gen());
        Jw();
        this.aDm = System.currentTimeMillis();
        initData(getArguments());
        initUI();
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(x.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aPA = new r(this.aPH, this, this.aPN);
        this.aPA.a(this.ww);
        this.aPA.e(new l(this));
        this.aPA.JF().setOnClickListener(this);
    }

    private void initData(Bundle bundle) {
        this.aPE = true;
        this.aPF = false;
        this.aPG = false;
        this.aPC = new com.baidu.tieba.model.d(this.aPH.getPageContext());
        this.aPC.a(this.aPM);
        this.zj = new ac(this.aPH.getPageContext());
        this.zj.setLoadDataCallBack(this.aPL);
        this.aPC.a(this.aPM);
        long j = com.baidu.tbadk.core.sharedPref.b.oc().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (j == 0 || N(j)) {
            this.aPJ = true;
        } else {
            this.aPJ = false;
        }
    }

    public boolean Jz() {
        return this.aPJ;
    }

    private boolean N(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aPI = false;
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
        this.aPA.onResume();
        ck(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        wg();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.search_text_tip) {
            sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aPH.getPageContext().getPageActivity())));
        } else if (view.getId() == this.aPA.JJ() || view.getId() == this.aPA.JK()) {
            if (!this.aPI) {
                ab abVar = view.getTag() instanceof ab ? (ab) view.getTag() : null;
                if (abVar != null) {
                    String name = abVar.getName();
                    if (bf.aC(name)) {
                        TiebaStatic.eventStat(this.aPH.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aPI = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aPH.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else if (view == this.aPA.JF()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aPH.getPageContext().getPageActivity())));
        } else if (view.getId() == this.aPA.JL()) {
            if (this.aPA.JU() != null) {
                this.aPA.JU().cm(false);
                this.aPA.notifyDataSetChanged();
                com.baidu.tbadk.core.sharedPref.b.oc().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                TiebaStatic.eventStat(this.aPH.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
            }
        } else if (view.getId() == this.aPA.JM()) {
            if (this.aPA.JU() != null && this.aPA.JU().JB() > 1) {
                if (this.aPA.JU().Je() != null) {
                    this.aPA.JU().Je().clear();
                }
                this.aPA.JU().fs((this.aPA.JU().getPageIndex() + 1) % this.aPA.JU().JB());
                this.aPA.JU().notifyDataSetChanged();
                TiebaStatic.eventStat(this.aPH.getPageContext().getPageActivity(), "recom_flist_change", "click", 1, new Object[0]);
            }
        } else if (view.getId() == this.aPA.JN()) {
            com.baidu.tieba.data.m mVar = view.getTag() instanceof com.baidu.tieba.data.m ? (com.baidu.tieba.data.m) view.getTag() : null;
            if (mVar != null) {
                String forumName = mVar.getForumName();
                String valueOf = String.valueOf(mVar.getForumId());
                if (bf.aC(forumName)) {
                    TiebaStatic.eventStat(this.aPH.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                    this.aPI = true;
                    sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aPH.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    TiebaStatic.eventStat(this.aPH.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf);
                }
            }
        } else if (view.getId() == this.aPA.JO()) {
            com.baidu.tieba.data.m mVar2 = view.getTag() instanceof com.baidu.tieba.data.m ? (com.baidu.tieba.data.m) view.getTag() : null;
            if (mVar2 != null) {
                String forumName2 = mVar2.getForumName();
                String valueOf2 = String.valueOf(mVar2.getForumId());
                if (bf.aC(forumName2)) {
                    this.zj.aQ(forumName2, valueOf2);
                    TiebaStatic.eventStat(this.aPH.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.aPA.JJ() || view.getId() == this.aPA.JK()) {
            this.aPD = null;
            ab abVar = view.getTag() instanceof ab ? (ab) view.getTag() : null;
            if (abVar != null) {
                this.aPD = abVar;
                String name = abVar.getName();
                int isLike = abVar.isLike();
                if (bf.aC(name)) {
                    if (isLike == 1) {
                        this.aPA.JP();
                    } else {
                        this.aPA.JQ();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aPA.onChangeSkinType(i);
    }

    public void wg() {
        if (this.aPB != null) {
            this.aPB.cancel();
            this.aPB = null;
        }
        this.aPC.cancelLoadData();
    }

    public void ck(boolean z) {
        boolean z2;
        boolean z3;
        if (this.aPC != null) {
            boolean booleanValue = this.aPG.booleanValue();
            this.aPG = Boolean.valueOf((TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccountName() == null) ? false : true);
            if (this.aPE) {
                this.aPE = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.aPG.booleanValue()) {
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
                if (this.aPC != null && this.aPC.JC() != null && this.aPC.JC().Cy() != null) {
                    Iterator<ab> it = this.aPC.JC().Cy().CN().iterator();
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
                    com.baidu.tieba.tbadkCore.util.j.ip(currentAccount);
                }
                this.aPA.notifyDataSetChanged();
            }
            if (z2 || z4) {
                wg();
                if (z4) {
                    this.aPA.jC();
                } else if (z2) {
                    this.aPC.dv(this.aPG.booleanValue());
                    this.aPA.jC();
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
