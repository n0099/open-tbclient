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
    private static List<String> eCy = new ArrayList();
    private a eCr;
    private c eCs;
    private NoNetworkView eCt;
    private PluginErrorTipView eCu;
    private RelativeLayout eCv;
    private ObservedChangeLinearLayout eCw;
    private RelativeLayout eCx;
    private CustomMessageListener eCz = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.eCr != null) {
                EnterForumFragment.this.eCr.aWE();
            }
        }
    };
    private CustomMessageListener eCA = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.eCr != null) {
                    EnterForumFragment.this.eCr.iv(true);
                }
                if (EnterForumFragment.this.eCs != null) {
                    EnterForumFragment.this.eCs.aBF();
                }
            }
        }
    };
    final CustomMessageListener esk = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.aWZ()) {
                com.baidu.tieba.enterForum.model.b.aXa();
            }
        }
    };

    public ObservedChangeLinearLayout aWw() {
        return this.eCw;
    }

    private void bC(View view) {
        this.eCv = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        this.eCt = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.eCu = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.eCw = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.eCr = new a(this);
        this.eCr.setPageUniqueId(getUniqueId());
        this.eCt.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                EnterForumFragment.this.eCr.iv(z);
            }
        });
        this.eCv.addView(this.eCr.getView(), 0);
        this.eCr.loadData();
    }

    public void setTabViewController(c cVar) {
        this.eCs = cVar;
    }

    public c aWx() {
        return this.eCs;
    }

    public void aWy() {
        aWz();
        if (this.eCr != null) {
            this.eCr.loadData();
        }
    }

    private void aWz() {
        if (this.eCr != null) {
            this.eCr.ix(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aWy();
            if (this.eCr != null) {
                refreshImage(this.eCr.getView());
            }
        }
        if (this.eCr != null) {
            this.eCr.onPrimary();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.eCv, d.C0277d.cp_bg_line_d);
        if (this.eCr != null) {
            this.eCr.onChangeSkinType(i);
        }
        if (this.eCt != null) {
            this.eCt.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCu != null) {
            this.eCu.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCx != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.eCx);
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
        this.esk.setPriority(101);
        registerListener(this.esk);
        registerListener(this.eCz);
        registerListener(this.eCA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eCr != null) {
            this.eCr.onDestroy();
        }
        this.eCs = null;
        MessageManager.getInstance().unRegisterListener(this.eCz);
        MessageManager.getInstance().unRegisterListener(this.eCA);
        MessageManager.getInstance().unRegisterListener(this.esk);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eCr != null) {
            this.eCr.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eCt != null && this.eCt.getVisibility() == 0 && j.kY()) {
            this.eCt.dO(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
