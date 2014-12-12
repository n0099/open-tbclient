package com.baidu.tieba.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.tbadkCore.ac;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    private boolean aOB;
    private BaseFragmentActivity aOz;
    private ac zm;
    private s aOs = null;
    private n aOt = null;
    private com.baidu.tieba.model.d aOu = null;
    private ab aOv = null;
    private boolean aOw = true;
    private boolean aOx = false;
    private Boolean aOy = false;
    private long aCo = -1;
    private boolean aOA = false;
    private com.baidu.adp.framework.listener.a aOC = new g(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private com.baidu.adp.base.i aOD = new h(this);
    private final com.baidu.tieba.model.h aOE = new i(this);
    private final View.OnKeyListener aOF = new j(this);
    private final com.baidu.adp.widget.ListView.g wv = new k(this);

    static {
        Je();
    }

    private void Jd() {
        MessageManager.getInstance().unRegisterListener(this.aOC);
        MessageManager.getInstance().registerListener(this.aOC);
    }

    private static void Je() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.aOs.JB() || dialogInterface == this.aOs.JC()) {
            switch (i) {
                case 0:
                    if (this.aOv != null) {
                        String name = this.aOv.getName();
                        if (ba.aC(name)) {
                            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aOz.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    Jf();
                    return;
                default:
                    return;
            }
        }
    }

    private void Jf() {
        if (this.aOv != null) {
            if (this.aOv.isLike() == 1) {
                this.aOs.JA();
            } else if (this.aOt == null) {
                this.aOt = new n(this, this.aOv);
                this.aOt.execute(new ab[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aOz = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aOC.setTag(BdUniqueId.gen());
        Jd();
        this.aCo = System.currentTimeMillis();
        initData(getArguments());
        initUI();
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.x.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aOs = new s(this.aOz, this, this.aOF);
        this.aOs.a(this.wv);
        this.aOs.e(new l(this));
        this.aOs.Jo().setOnClickListener(this);
    }

    private void initData(Bundle bundle) {
        this.aOw = true;
        this.aOx = false;
        this.aOy = false;
        this.aOu = new com.baidu.tieba.model.d(this.aOz.getPageContext());
        this.aOu.a(this.aOE);
        this.zm = new ac(this.aOz.getPageContext());
        this.zm.setLoadDataCallBack(this.aOD);
        this.aOu.a(this.aOE);
        long j = com.baidu.tbadk.core.sharedPref.b.og().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (j == 0 || N(j)) {
            this.aOB = true;
        } else {
            this.aOB = false;
        }
    }

    public boolean Jg() {
        return this.aOB;
    }

    private boolean N(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aOs.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aOA = false;
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
        this.aOs.onResume();
        ch(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        vT();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.search_bg_layout) {
            sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aOz.getPageContext().getPageActivity())));
        } else if (view.getId() == this.aOs.Js() || view.getId() == this.aOs.Jt()) {
            if (!this.aOA) {
                ab abVar = view.getTag() instanceof ab ? (ab) view.getTag() : null;
                if (abVar != null) {
                    String name = abVar.getName();
                    if (ba.aC(name)) {
                        TiebaStatic.eventStat(this.aOz.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aOA = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aOz.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else if (view == this.aOs.Jo()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aOz.getPageContext().getPageActivity())));
        } else if (view == this.aOs.Jl()) {
            this.aOs.JD();
        } else if (view == this.aOs.Jk()) {
            TbadkCoreApplication.m255getInst().setTiebaHelperOpen(true);
            Hao123Plugin hao123Plugin = (Hao123Plugin) PluginCenter.gX().hc();
            if (hao123Plugin != null) {
                hao123Plugin.openFloating(this.aOz.getPageContext().getPageActivity());
            }
            this.aOs.JD();
            com.baidu.tbadk.core.i.B(this.aOz.getPageContext().getPageActivity(), "tb_zs_entering");
        } else if (view.getId() == this.aOs.Ju()) {
            if (this.aOs.JE() != null) {
                this.aOs.JE().cj(false);
                this.aOs.notifyDataSetChanged();
                com.baidu.tbadk.core.sharedPref.b.og().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                TiebaStatic.eventStat(this.aOz.getPageContext().getPageActivity(), "recom_unlike", "click", 1, new Object[0]);
            }
        } else if (view.getId() == this.aOs.Jv()) {
            if (this.aOs.JE() != null && this.aOs.JE().Jj() > 1) {
                if (this.aOs.JE().IL() != null) {
                    this.aOs.JE().IL().clear();
                }
                this.aOs.JE().fn((this.aOs.JE().getPageIndex() + 1) % this.aOs.JE().Jj());
                this.aOs.JE().notifyDataSetChanged();
                TiebaStatic.eventStat(this.aOz.getPageContext().getPageActivity(), "recom_change", "click", 1, new Object[0]);
            }
        } else if (view.getId() == this.aOs.Jw()) {
            com.baidu.tieba.data.m mVar = view.getTag() instanceof com.baidu.tieba.data.m ? (com.baidu.tieba.data.m) view.getTag() : null;
            if (mVar != null) {
                String forumName = mVar.getForumName();
                String valueOf = String.valueOf(mVar.getForumId());
                if (ba.aC(forumName)) {
                    TiebaStatic.eventStat(this.aOz.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                    this.aOA = true;
                    sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aOz.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    TiebaStatic.eventStat(this.aOz.getPageContext().getPageActivity(), "recom_pic", "click", 1, "dev_id", valueOf);
                }
            }
        } else if (view.getId() == this.aOs.Jx()) {
            com.baidu.tieba.data.m mVar2 = view.getTag() instanceof com.baidu.tieba.data.m ? (com.baidu.tieba.data.m) view.getTag() : null;
            if (mVar2 != null) {
                String forumName2 = mVar2.getForumName();
                String valueOf2 = String.valueOf(mVar2.getForumId());
                if (ba.aC(forumName2)) {
                    this.zm.aN(forumName2, valueOf2);
                    TiebaStatic.eventStat(this.aOz.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.aOs.Js() || view.getId() == this.aOs.Jt()) {
            this.aOv = null;
            ab abVar = view.getTag() instanceof ab ? (ab) view.getTag() : null;
            if (abVar != null) {
                this.aOv = abVar;
                String name = abVar.getName();
                int isLike = abVar.isLike();
                if (ba.aC(name)) {
                    if (isLike == 1) {
                        this.aOs.Jy();
                    } else {
                        this.aOs.Jz();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aOs.onChangeSkinType(i);
    }

    public void vT() {
        if (this.aOt != null) {
            this.aOt.cancel();
            this.aOt = null;
        }
        this.aOu.cancelLoadData();
    }

    public void ch(boolean z) {
        boolean z2;
        boolean z3;
        if (this.aOu != null) {
            boolean booleanValue = this.aOy.booleanValue();
            this.aOy = Boolean.valueOf((TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccountName() == null) ? false : true);
            if (this.aOw) {
                this.aOw = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.aOy.booleanValue()) {
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
                if (this.aOu != null && this.aOu.Ud() != null && this.aOu.Ud().Ce() != null) {
                    Iterator<ab> it = this.aOu.Ud().Ce().Cu().iterator();
                    while (it.hasNext()) {
                        ab next = it.next();
                        if (TbadkCoreApplication.m255getInst().hasSignedForum(next.getName())) {
                            next.hB(1);
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
                    com.baidu.tieba.tbadkCore.util.j.ik(currentAccount);
                }
                this.aOs.notifyDataSetChanged();
            }
            if (z2 || z4) {
                vT();
                if (z4) {
                    this.aOs.jK();
                } else if (z2) {
                    this.aOu.dq(this.aOy.booleanValue());
                    this.aOs.jK();
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }
}
