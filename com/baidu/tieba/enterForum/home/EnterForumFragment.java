package com.baidu.tieba.enterForum.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> fSy = new ArrayList();
    private RelativeLayout ayz;
    private com.baidu.tieba.enterForum.data.b fQS;
    private a fSs;
    private c fSt;
    private NoNetworkView fSu;
    private PluginErrorTipView fSv;
    private ObservedChangeLinearLayout fSw;
    private RelativeLayout fSx;
    private CustomMessageListener fSz = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.fSs != null) {
                EnterForumFragment.this.fSs.bwN();
            }
        }
    };
    private CustomMessageListener fSA = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.fSs != null) {
                    EnterForumFragment.this.fSs.kz(true);
                }
                if (EnterForumFragment.this.fSt != null) {
                    EnterForumFragment.this.fSt.baw();
                }
            }
        }
    };
    final CustomMessageListener cDL = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bxn()) {
                com.baidu.tieba.enterForum.model.b.bxo();
            }
        }
    };

    public ObservedChangeLinearLayout bwF() {
        return this.fSw;
    }

    private void bI(View view) {
        this.ayz = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fSu = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.fSv = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.fSw = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.fSs = new a(this);
        this.fSs.setPageUniqueId(getUniqueId());
        this.fSu.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.fSs.kz(z);
                if (EnterForumFragment.this.bwG() != null) {
                    EnterForumFragment.this.bwG().bwV();
                }
            }
        });
        this.ayz.addView(this.fSs.getView(), 0);
        this.fSs.ais();
        View findViewById = this.ayz.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.ayz.removeView(findViewById);
            this.ayz.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fSs.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.fSt = cVar;
    }

    public c bwG() {
        return this.fSt;
    }

    public void tE() {
        bwH();
        if (this.fSs != null) {
            this.fSs.loadData();
        }
    }

    private void bwH() {
        if (this.fSs != null) {
            this.fSs.kB(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = false;
        super.onPrimary();
        if (isAdded()) {
            if (isPrimary()) {
                tE();
                if (this.fSs != null) {
                    refreshImage(this.fSs.getView());
                }
                com.baidu.tieba.r.c.cIu().b(getUniqueId(), false);
            } else if (TbSingleton.getInstance().isShowNewYearSkin() && UtilHelper.canUseStyleImmersiveSticky()) {
                if (TbadkCoreApplication.getInst().getSkinType() == 4 || TbadkCoreApplication.getInst().getSkinType() == 1) {
                    z = true;
                }
                UtilHelper.changeStatusBarIconAndTextColor(z, getFragmentActivity());
            }
        }
        if (this.fSs != null) {
            this.fSs.onPrimary();
        }
        if (bwG() != null) {
            bwG().bwV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.ayz, R.color.cp_bg_line_d);
        if (this.fSs != null) {
            this.fSs.onChangeSkinType(i);
        }
        if (this.fSu != null) {
            this.fSu.onChangeSkinType(getPageContext(), i);
        }
        if (this.fSv != null) {
            this.fSv.onChangeSkinType(getPageContext(), i);
        }
        if (this.fSx != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.fSx);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bI(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.r.c.cIu().w(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cDL.setPriority(101);
        registerListener(this.cDL);
        registerListener(this.fSz);
        registerListener(this.fSA);
        com.baidu.tieba.r.c.cIu().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.r.c.cIu().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fSs != null) {
            this.fSs.onDestroy();
        }
        this.fSt = null;
        MessageManager.getInstance().unRegisterListener(this.fSz);
        MessageManager.getInstance().unRegisterListener(this.fSA);
        MessageManager.getInstance().unRegisterListener(this.cDL);
        com.baidu.tieba.r.c.cIu().x(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fSs != null) {
            this.fSs.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fSu != null && this.fSu.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fSu.update(false);
        }
    }

    public RelativeLayout bwI() {
        return this.ayz;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fQS = bVar;
        this.fSt.setAdState(bVar);
    }
}
