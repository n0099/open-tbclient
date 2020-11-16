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
/* loaded from: classes21.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> iku = new ArrayList();
    private RelativeLayout bDi;
    private NoNetworkView ghk;
    private com.baidu.tieba.enterForum.data.c iiG;
    private a ikp;
    private c ikq;
    private PluginErrorTipView ikr;
    private ObservedChangeLinearLayout iks;
    private RelativeLayout ikt;
    private CustomMessageListener ikv = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.ikp != null) {
                EnterForumFragment.this.ikp.crE();
            }
        }
    };
    private CustomMessageListener ikw = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.ikp != null) {
                    EnterForumFragment.this.ikp.oQ(true);
                }
                if (EnterForumFragment.this.ikq != null) {
                    EnterForumFragment.this.ikq.bOK();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cse()) {
                com.baidu.tieba.enterForum.model.b.csf();
            }
        }
    };

    public ObservedChangeLinearLayout cru() {
        return this.iks;
    }

    private void cy(View view) {
        this.bDi = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.ghk = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.ikr = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.iks = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.ikp = new a(this);
        this.ikp.setPageUniqueId(getUniqueId());
        this.ghk.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.ikp.oQ(z);
                if (EnterForumFragment.this.crv() != null) {
                    EnterForumFragment.this.crv().crK();
                }
            }
        });
        this.bDi.addView(this.ikp.getView(), 0);
        this.ikp.aQK();
        View findViewById = this.bDi.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bDi.removeView(findViewById);
            this.bDi.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.ikp.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.ikq = cVar;
    }

    public c crv() {
        return this.ikq;
    }

    public void crw() {
        crx();
        if (this.ikp != null) {
            this.ikp.loadData();
        }
    }

    private void crx() {
        if (this.ikp != null) {
            this.ikp.oR(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            crw();
            if (this.ikp != null) {
                refreshImage(this.ikp.getView());
            }
            com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
        }
        if (this.ikp != null) {
            this.ikp.onPrimary();
        }
        if (crv() != null) {
            crv().crK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bDi, R.color.CAM_X0201);
        if (this.ikp != null) {
            this.ikp.onChangeSkinType(i);
        }
        if (this.ghk != null) {
            this.ghk.onChangeSkinType(getPageContext(), i);
        }
        if (this.ikr != null) {
            this.ikr.onChangeSkinType(getPageContext(), i);
        }
        if (this.ikt != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.ikt);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cy(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.ikv);
        registerListener(this.ikw);
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ikp != null) {
            this.ikp.onDestroy();
        }
        this.ikq = null;
        MessageManager.getInstance().unRegisterListener(this.ikv);
        MessageManager.getInstance().unRegisterListener(this.ikw);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ikp != null) {
            this.ikp.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ghk != null && this.ghk.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.ghk.update(false);
        }
    }

    public RelativeLayout cry() {
        return this.bDi;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iiG = cVar;
        this.ikq.setAdState(cVar);
    }

    public boolean crz() {
        if (this.ikp == null || this.ikp.crF() == null) {
            return true;
        }
        return this.ikp.crF().csQ();
    }
}
