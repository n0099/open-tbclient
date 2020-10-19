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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> hRi = new ArrayList();
    private RelativeLayout bwu;
    private NoNetworkView fRL;
    private com.baidu.tieba.enterForum.data.c hPu;
    private a hRd;
    private c hRe;
    private PluginErrorTipView hRf;
    private ObservedChangeLinearLayout hRg;
    private RelativeLayout hRh;
    private CustomMessageListener hRj = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.hRd != null) {
                EnterForumFragment.this.hRd.cmt();
            }
        }
    };
    private CustomMessageListener hRk = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.hRd != null) {
                    EnterForumFragment.this.hRd.om(true);
                }
                if (EnterForumFragment.this.hRe != null) {
                    EnterForumFragment.this.hRe.bKp();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cmT()) {
                com.baidu.tieba.enterForum.model.b.cmU();
            }
        }
    };

    public ObservedChangeLinearLayout cmj() {
        return this.hRg;
    }

    private void cl(View view) {
        this.bwu = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fRL = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.hRf = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.hRg = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.hRd = new a(this);
        this.hRd.setPageUniqueId(getUniqueId());
        this.fRL.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.hRd.om(z);
                if (EnterForumFragment.this.cmk() != null) {
                    EnterForumFragment.this.cmk().cmz();
                }
            }
        });
        this.bwu.addView(this.hRd.getView(), 0);
        this.hRd.aMY();
        View findViewById = this.bwu.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bwu.removeView(findViewById);
            this.bwu.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hRd.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.hRe = cVar;
    }

    public c cmk() {
        return this.hRe;
    }

    public void cml() {
        cmm();
        if (this.hRd != null) {
            this.hRd.loadData();
        }
    }

    private void cmm() {
        if (this.hRd != null) {
            this.hRd.on(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cml();
            if (this.hRd != null) {
                refreshImage(this.hRd.getView());
            }
            com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
        }
        if (this.hRd != null) {
            this.hRd.onPrimary();
        }
        if (cmk() != null) {
            cmk().cmz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bwu, R.color.cp_bg_line_d);
        if (this.hRd != null) {
            this.hRd.onChangeSkinType(i);
        }
        if (this.fRL != null) {
            this.fRL.onChangeSkinType(getPageContext(), i);
        }
        if (this.hRf != null) {
            this.hRf.onChangeSkinType(getPageContext(), i);
        }
        if (this.hRh != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.hRh);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cl(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.hRj);
        registerListener(this.hRk);
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hRd != null) {
            this.hRd.onDestroy();
        }
        this.hRe = null;
        MessageManager.getInstance().unRegisterListener(this.hRj);
        MessageManager.getInstance().unRegisterListener(this.hRk);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hRd != null) {
            this.hRd.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fRL != null && this.fRL.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fRL.update(false);
        }
    }

    public RelativeLayout cmn() {
        return this.bwu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hPu = cVar;
        this.hRe.setAdState(cVar);
    }

    public boolean cmo() {
        if (this.hRd == null || this.hRd.cmu() == null) {
            return true;
        }
        return this.hRd.cmu().cnF();
    }
}
