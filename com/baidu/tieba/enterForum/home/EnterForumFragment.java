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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> eWZ = new ArrayList();
    private com.baidu.tieba.enterForum.data.b eVt;
    private a eWT;
    private c eWU;
    private NoNetworkView eWV;
    private PluginErrorTipView eWW;
    private ObservedChangeLinearLayout eWX;
    private RelativeLayout eWY;
    private RelativeLayout euU;
    private CustomMessageListener eXa = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.eWT != null) {
                EnterForumFragment.this.eWT.bfR();
            }
        }
    };
    private CustomMessageListener eXb = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.eWT != null) {
                    EnterForumFragment.this.eWT.jk(true);
                }
                if (EnterForumFragment.this.eWU != null) {
                    EnterForumFragment.this.eWU.aJv();
                }
            }
        }
    };
    final CustomMessageListener byN = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bgr()) {
                com.baidu.tieba.enterForum.model.b.bgs();
            }
        }
    };

    public ObservedChangeLinearLayout bfJ() {
        return this.eWX;
    }

    private void bL(View view) {
        this.euU = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.eWV = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.eWW = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.eWX = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.eWT = new a(this);
        this.eWT.setPageUniqueId(getUniqueId());
        this.eWV.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                EnterForumFragment.this.eWT.jk(z);
                if (EnterForumFragment.this.bfK() != null) {
                    EnterForumFragment.this.bfK().bga();
                }
            }
        });
        this.euU.addView(this.eWT.getView(), 0);
        this.eWT.bfS();
        View findViewById = this.euU.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.euU.removeView(findViewById);
            this.euU.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.eWT.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.eWU = cVar;
    }

    public c bfK() {
        return this.eWU;
    }

    public void bfL() {
        bfM();
        if (this.eWT != null) {
            this.eWT.loadData();
        }
    }

    private void bfM() {
        if (this.eWT != null) {
            this.eWT.jm(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bfL();
            if (this.eWT != null) {
                refreshImage(this.eWT.getView());
            }
            com.baidu.tieba.q.c.coo().b(getUniqueId(), false);
        }
        if (this.eWT != null) {
            this.eWT.onPrimary();
        }
        if (bfK() != null) {
            bfK().bga();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.l(this.euU, R.color.cp_bg_line_d);
        if (this.eWT != null) {
            this.eWT.onChangeSkinType(i);
        }
        if (this.eWV != null) {
            this.eWV.onChangeSkinType(getPageContext(), i);
        }
        if (this.eWW != null) {
            this.eWW.onChangeSkinType(getPageContext(), i);
        }
        if (this.eWY != null) {
            com.baidu.tbadk.s.a.a(getPageContext(), this.eWY);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bL(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.q.c.coo().u(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.byN.setPriority(101);
        registerListener(this.byN);
        registerListener(this.eXa);
        registerListener(this.eXb);
        com.baidu.tieba.q.c.coo().u(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eWT != null) {
            this.eWT.onDestroy();
        }
        this.eWU = null;
        MessageManager.getInstance().unRegisterListener(this.eXa);
        MessageManager.getInstance().unRegisterListener(this.eXb);
        MessageManager.getInstance().unRegisterListener(this.byN);
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eWT != null) {
            this.eWT.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eWV != null && this.eWV.getVisibility() == 0 && j.kc()) {
            this.eWV.eo(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eVt = bVar;
        this.eWU.setAdState(bVar);
    }
}
