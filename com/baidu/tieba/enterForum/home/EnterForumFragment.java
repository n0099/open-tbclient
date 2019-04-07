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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> eCj = new ArrayList();
    private a eCc;
    private c eCd;
    private NoNetworkView eCe;
    private PluginErrorTipView eCf;
    private RelativeLayout eCg;
    private ObservedChangeLinearLayout eCh;
    private RelativeLayout eCi;
    private CustomMessageListener eCk = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.eCc != null) {
                EnterForumFragment.this.eCc.aWC();
            }
        }
    };
    private CustomMessageListener eCl = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.eCc != null) {
                    EnterForumFragment.this.eCc.iv(true);
                }
                if (EnterForumFragment.this.eCd != null) {
                    EnterForumFragment.this.eCd.aBC();
                }
            }
        }
    };
    final CustomMessageListener erW = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.aWX()) {
                com.baidu.tieba.enterForum.model.b.aWY();
            }
        }
    };

    public ObservedChangeLinearLayout aWu() {
        return this.eCh;
    }

    private void bC(View view) {
        this.eCg = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        this.eCe = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.eCf = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.eCh = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.eCc = new a(this);
        this.eCc.setPageUniqueId(getUniqueId());
        this.eCe.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                EnterForumFragment.this.eCc.iv(z);
            }
        });
        this.eCg.addView(this.eCc.getView(), 0);
        this.eCc.loadData();
    }

    public void setTabViewController(c cVar) {
        this.eCd = cVar;
    }

    public c aWv() {
        return this.eCd;
    }

    public void aWw() {
        aWx();
        if (this.eCc != null) {
            this.eCc.loadData();
        }
    }

    private void aWx() {
        if (this.eCc != null) {
            this.eCc.ix(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aWw();
            if (this.eCc != null) {
                refreshImage(this.eCc.getView());
            }
        }
        if (this.eCc != null) {
            this.eCc.onPrimary();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.eCg, d.C0277d.cp_bg_line_d);
        if (this.eCc != null) {
            this.eCc.onChangeSkinType(i);
        }
        if (this.eCe != null) {
            this.eCe.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCf != null) {
            this.eCf.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCi != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.eCi);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_enter_forum, viewGroup, false);
        bC(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.erW.setPriority(101);
        registerListener(this.erW);
        registerListener(this.eCk);
        registerListener(this.eCl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eCc != null) {
            this.eCc.onDestroy();
        }
        this.eCd = null;
        MessageManager.getInstance().unRegisterListener(this.eCk);
        MessageManager.getInstance().unRegisterListener(this.eCl);
        MessageManager.getInstance().unRegisterListener(this.erW);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eCc != null) {
            this.eCc.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eCe != null && this.eCe.getVisibility() == 0 && j.kY()) {
            this.eCe.dO(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
