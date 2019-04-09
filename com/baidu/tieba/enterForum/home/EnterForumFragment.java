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
    private static List<String> eCk = new ArrayList();
    private a eCd;
    private c eCe;
    private NoNetworkView eCf;
    private PluginErrorTipView eCg;
    private RelativeLayout eCh;
    private ObservedChangeLinearLayout eCi;
    private RelativeLayout eCj;
    private CustomMessageListener eCl = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.eCd != null) {
                EnterForumFragment.this.eCd.aWC();
            }
        }
    };
    private CustomMessageListener eCm = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.eCd != null) {
                    EnterForumFragment.this.eCd.iv(true);
                }
                if (EnterForumFragment.this.eCe != null) {
                    EnterForumFragment.this.eCe.aBC();
                }
            }
        }
    };
    final CustomMessageListener erX = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.aWX()) {
                com.baidu.tieba.enterForum.model.b.aWY();
            }
        }
    };

    public ObservedChangeLinearLayout aWu() {
        return this.eCi;
    }

    private void bC(View view) {
        this.eCh = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        this.eCf = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.eCg = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.eCi = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.eCd = new a(this);
        this.eCd.setPageUniqueId(getUniqueId());
        this.eCf.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                EnterForumFragment.this.eCd.iv(z);
            }
        });
        this.eCh.addView(this.eCd.getView(), 0);
        this.eCd.loadData();
    }

    public void setTabViewController(c cVar) {
        this.eCe = cVar;
    }

    public c aWv() {
        return this.eCe;
    }

    public void aWw() {
        aWx();
        if (this.eCd != null) {
            this.eCd.loadData();
        }
    }

    private void aWx() {
        if (this.eCd != null) {
            this.eCd.ix(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aWw();
            if (this.eCd != null) {
                refreshImage(this.eCd.getView());
            }
        }
        if (this.eCd != null) {
            this.eCd.onPrimary();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.eCh, d.C0277d.cp_bg_line_d);
        if (this.eCd != null) {
            this.eCd.onChangeSkinType(i);
        }
        if (this.eCf != null) {
            this.eCf.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCg != null) {
            this.eCg.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCj != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.eCj);
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
        this.erX.setPriority(101);
        registerListener(this.erX);
        registerListener(this.eCl);
        registerListener(this.eCm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eCd != null) {
            this.eCd.onDestroy();
        }
        this.eCe = null;
        MessageManager.getInstance().unRegisterListener(this.eCl);
        MessageManager.getInstance().unRegisterListener(this.eCm);
        MessageManager.getInstance().unRegisterListener(this.erX);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eCd != null) {
            this.eCd.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eCf != null && this.eCf.getVisibility() == 0 && j.kY()) {
            this.eCf.dO(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
