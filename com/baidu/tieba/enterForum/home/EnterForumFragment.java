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
    private static List<String> ijG = new ArrayList();
    private RelativeLayout bET;
    private NoNetworkView ghD;
    private com.baidu.tieba.enterForum.data.c ihS;
    private a ijB;
    private c ijC;
    private PluginErrorTipView ijD;
    private ObservedChangeLinearLayout ijE;
    private RelativeLayout ijF;
    private CustomMessageListener ijH = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.ijB != null) {
                EnterForumFragment.this.ijB.csb();
            }
        }
    };
    private CustomMessageListener ijI = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.ijB != null) {
                    EnterForumFragment.this.ijB.oN(true);
                }
                if (EnterForumFragment.this.ijC != null) {
                    EnterForumFragment.this.ijC.bPr();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.csB()) {
                com.baidu.tieba.enterForum.model.b.csC();
            }
        }
    };

    public ObservedChangeLinearLayout crR() {
        return this.ijE;
    }

    private void cu(View view) {
        this.bET = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.ghD = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.ijD = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.ijE = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.ijB = new a(this);
        this.ijB.setPageUniqueId(getUniqueId());
        this.ghD.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.ijB.oN(z);
                if (EnterForumFragment.this.crS() != null) {
                    EnterForumFragment.this.crS().csh();
                }
            }
        });
        this.bET.addView(this.ijB.getView(), 0);
        this.ijB.aRs();
        View findViewById = this.bET.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bET.removeView(findViewById);
            this.bET.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.ijB.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.ijC = cVar;
    }

    public c crS() {
        return this.ijC;
    }

    public void crT() {
        crU();
        if (this.ijB != null) {
            this.ijB.loadData();
        }
    }

    private void crU() {
        if (this.ijB != null) {
            this.ijB.oO(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            crT();
            if (this.ijB != null) {
                refreshImage(this.ijB.getView());
            }
            com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
        }
        if (this.ijB != null) {
            this.ijB.onPrimary();
        }
        if (crS() != null) {
            crS().csh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bET, R.color.cp_bg_line_d);
        if (this.ijB != null) {
            this.ijB.onChangeSkinType(i);
        }
        if (this.ghD != null) {
            this.ghD.onChangeSkinType(getPageContext(), i);
        }
        if (this.ijD != null) {
            this.ijD.onChangeSkinType(getPageContext(), i);
        }
        if (this.ijF != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.ijF);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cu(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.ijH);
        registerListener(this.ijI);
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ijB != null) {
            this.ijB.onDestroy();
        }
        this.ijC = null;
        MessageManager.getInstance().unRegisterListener(this.ijH);
        MessageManager.getInstance().unRegisterListener(this.ijI);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ijB != null) {
            this.ijB.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ghD != null && this.ghD.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.ghD.update(false);
        }
    }

    public RelativeLayout crV() {
        return this.bET;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ihS = cVar;
        this.ijC.setAdState(cVar);
    }

    public boolean crW() {
        if (this.ijB == null || this.ijB.csc() == null) {
            return true;
        }
        return this.ijB.csc().ctn();
    }
}
