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
    private static List<String> eXj = new ArrayList();
    private com.baidu.tieba.enterForum.data.b eVA;
    private a eXd;
    private c eXe;
    private NoNetworkView eXf;
    private PluginErrorTipView eXg;
    private ObservedChangeLinearLayout eXh;
    private RelativeLayout eXi;
    private RelativeLayout evb;
    private CustomMessageListener eXk = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.eXd != null) {
                EnterForumFragment.this.eXd.bfT();
            }
        }
    };
    private CustomMessageListener eXl = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.eXd != null) {
                    EnterForumFragment.this.eXd.jk(true);
                }
                if (EnterForumFragment.this.eXe != null) {
                    EnterForumFragment.this.eXe.aJx();
                }
            }
        }
    };
    final CustomMessageListener byN = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bgu()) {
                com.baidu.tieba.enterForum.model.b.bgv();
            }
        }
    };

    public ObservedChangeLinearLayout bfL() {
        return this.eXh;
    }

    private void bL(View view) {
        this.evb = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.eXf = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.eXg = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.eXh = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.eXd = new a(this);
        this.eXd.setPageUniqueId(getUniqueId());
        this.eXf.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                EnterForumFragment.this.eXd.jk(z);
                if (EnterForumFragment.this.bfM() != null) {
                    EnterForumFragment.this.bfM().bgc();
                }
            }
        });
        this.evb.addView(this.eXd.getView(), 0);
        this.eXd.bfU();
        View findViewById = this.evb.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.evb.removeView(findViewById);
            this.evb.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.eXd.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.eXe = cVar;
    }

    public c bfM() {
        return this.eXe;
    }

    public void bfN() {
        bfO();
        if (this.eXd != null) {
            this.eXd.loadData();
        }
    }

    private void bfO() {
        if (this.eXd != null) {
            this.eXd.jm(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bfN();
            if (this.eXd != null) {
                refreshImage(this.eXd.getView());
            }
            com.baidu.tieba.q.c.coG().b(getUniqueId(), false);
        }
        if (this.eXd != null) {
            this.eXd.onPrimary();
        }
        if (bfM() != null) {
            bfM().bgc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.l(this.evb, R.color.cp_bg_line_d);
        if (this.eXd != null) {
            this.eXd.onChangeSkinType(i);
        }
        if (this.eXf != null) {
            this.eXf.onChangeSkinType(getPageContext(), i);
        }
        if (this.eXg != null) {
            this.eXg.onChangeSkinType(getPageContext(), i);
        }
        if (this.eXi != null) {
            com.baidu.tbadk.s.a.a(getPageContext(), this.eXi);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bL(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.q.c.coG().u(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.byN.setPriority(101);
        registerListener(this.byN);
        registerListener(this.eXk);
        registerListener(this.eXl);
        com.baidu.tieba.q.c.coG().u(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.q.c.coG().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eXd != null) {
            this.eXd.onDestroy();
        }
        this.eXe = null;
        MessageManager.getInstance().unRegisterListener(this.eXk);
        MessageManager.getInstance().unRegisterListener(this.eXl);
        MessageManager.getInstance().unRegisterListener(this.byN);
        com.baidu.tieba.q.c.coG().v(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eXd != null) {
            this.eXd.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eXf != null && this.eXf.getVisibility() == 0 && j.kc()) {
            this.eXf.eo(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eVA = bVar;
        this.eXe.setAdState(bVar);
    }
}
