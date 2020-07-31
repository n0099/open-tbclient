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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> hic = new ArrayList();
    private RelativeLayout bjP;
    private NoNetworkView fqQ;
    private com.baidu.tieba.enterForum.data.c hgv;
    private a hhX;
    private c hhY;
    private PluginErrorTipView hhZ;
    private ObservedChangeLinearLayout hia;
    private RelativeLayout hib;
    private CustomMessageListener hie = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.hhX != null) {
                EnterForumFragment.this.hhX.bVo();
            }
        }
    };
    private CustomMessageListener hif = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.hhX != null) {
                    EnterForumFragment.this.hhX.mV(true);
                }
                if (EnterForumFragment.this.hhY != null) {
                    EnterForumFragment.this.hhY.bxn();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bVS()) {
                com.baidu.tieba.enterForum.model.b.bVT();
            }
        }
    };

    public ObservedChangeLinearLayout bVe() {
        return this.hia;
    }

    private void bW(View view) {
        this.bjP = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fqQ = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.hhZ = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.hia = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.hhX = new a(this);
        this.hhX.setPageUniqueId(getUniqueId());
        this.fqQ.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.hhX.mV(z);
                if (EnterForumFragment.this.bVf() != null) {
                    EnterForumFragment.this.bVf().bVu();
                }
            }
        });
        this.bjP.addView(this.hhX.getView(), 0);
        this.hhX.aAV();
        View findViewById = this.bjP.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bjP.removeView(findViewById);
            this.bjP.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hhX.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.hhY = cVar;
    }

    public c bVf() {
        return this.hhY;
    }

    public void bVg() {
        bVh();
        if (this.hhX != null) {
            this.hhX.loadData();
        }
    }

    private void bVh() {
        if (this.hhX != null) {
            this.hhX.mW(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bVg();
            if (this.hhX != null) {
                refreshImage(this.hhX.getView());
            }
            com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
        }
        if (this.hhX != null) {
            this.hhX.onPrimary();
        }
        if (bVf() != null) {
            bVf().bVu();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.bjP, R.color.cp_bg_line_d);
        if (this.hhX != null) {
            this.hhX.onChangeSkinType(i);
        }
        if (this.fqQ != null) {
            this.fqQ.onChangeSkinType(getPageContext(), i);
        }
        if (this.hhZ != null) {
            this.hhZ.onChangeSkinType(getPageContext(), i);
        }
        if (this.hib != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.hib);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bW(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.hie);
        registerListener(this.hif);
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hhX != null) {
            this.hhX.onDestroy();
        }
        this.hhY = null;
        MessageManager.getInstance().unRegisterListener(this.hie);
        MessageManager.getInstance().unRegisterListener(this.hif);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hhX != null) {
            this.hhX.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fqQ != null && this.fqQ.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fqQ.update(false);
        }
    }

    public RelativeLayout bVi() {
        return this.bjP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hgv = cVar;
        this.hhY.setAdState(cVar);
    }

    public boolean bVj() {
        if (this.hhX == null || this.hhX.bVp() == null) {
            return true;
        }
        return this.hhX.bVp().bWG();
    }
}
