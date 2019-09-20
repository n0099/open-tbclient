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
    private static List<String> eYP = new ArrayList();
    private com.baidu.tieba.enterForum.data.b eXg;
    private a eYJ;
    private c eYK;
    private NoNetworkView eYL;
    private PluginErrorTipView eYM;
    private ObservedChangeLinearLayout eYN;
    private RelativeLayout eYO;
    private RelativeLayout ewL;
    private CustomMessageListener eYQ = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.eYJ != null) {
                EnterForumFragment.this.eYJ.bgy();
            }
        }
    };
    private CustomMessageListener eYR = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.eYJ != null) {
                    EnterForumFragment.this.eYJ.jn(true);
                }
                if (EnterForumFragment.this.eYK != null) {
                    EnterForumFragment.this.eYK.aKb();
                }
            }
        }
    };
    final CustomMessageListener bzl = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bha()) {
                com.baidu.tieba.enterForum.model.b.bhb();
            }
        }
    };

    public ObservedChangeLinearLayout bgp() {
        return this.eYN;
    }

    private void bL(View view) {
        this.ewL = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.eYL = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.eYM = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.eYN = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.eYJ = new a(this);
        this.eYJ.setPageUniqueId(getUniqueId());
        this.eYL.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void es(boolean z) {
                EnterForumFragment.this.eYJ.jn(z);
                if (EnterForumFragment.this.bgq() != null) {
                    EnterForumFragment.this.bgq().bgH();
                }
            }
        });
        this.ewL.addView(this.eYJ.getView(), 0);
        this.eYJ.bgz();
        View findViewById = this.ewL.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.ewL.removeView(findViewById);
            this.ewL.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.eYJ.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.eYK = cVar;
    }

    public c bgq() {
        return this.eYK;
    }

    public void bgr() {
        bgs();
        if (this.eYJ != null) {
            this.eYJ.loadData();
        }
    }

    private void bgs() {
        if (this.eYJ != null) {
            this.eYJ.jp(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bgr();
            if (this.eYJ != null) {
                refreshImage(this.eYJ.getView());
            }
            com.baidu.tieba.q.c.cpt().b(getUniqueId(), false);
        }
        if (this.eYJ != null) {
            this.eYJ.onPrimary();
        }
        if (bgq() != null) {
            bgq().bgH();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.l(this.ewL, R.color.cp_bg_line_d);
        if (this.eYJ != null) {
            this.eYJ.onChangeSkinType(i);
        }
        if (this.eYL != null) {
            this.eYL.onChangeSkinType(getPageContext(), i);
        }
        if (this.eYM != null) {
            this.eYM.onChangeSkinType(getPageContext(), i);
        }
        if (this.eYO != null) {
            com.baidu.tbadk.s.a.a(getPageContext(), this.eYO);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bL(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.q.c.cpt().u(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bzl.setPriority(101);
        registerListener(this.bzl);
        registerListener(this.eYQ);
        registerListener(this.eYR);
        com.baidu.tieba.q.c.cpt().u(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.q.c.cpt().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eYJ != null) {
            this.eYJ.onDestroy();
        }
        this.eYK = null;
        MessageManager.getInstance().unRegisterListener(this.eYQ);
        MessageManager.getInstance().unRegisterListener(this.eYR);
        MessageManager.getInstance().unRegisterListener(this.bzl);
        com.baidu.tieba.q.c.cpt().v(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eYJ != null) {
            this.eYJ.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eYL != null && this.eYL.getVisibility() == 0 && j.kc()) {
            this.eYL.er(false);
        }
    }

    public RelativeLayout bgt() {
        return this.ewL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eXg = bVar;
        this.eYK.setAdState(bVar);
    }
}
