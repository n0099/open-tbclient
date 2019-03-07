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
    private static List<String> eCC = new ArrayList();
    private ObservedChangeLinearLayout eCA;
    private RelativeLayout eCB;
    private a eCv;
    private c eCw;
    private NoNetworkView eCx;
    private PluginErrorTipView eCy;
    private RelativeLayout eCz;
    private CustomMessageListener eCD = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.eCv != null) {
                EnterForumFragment.this.eCv.aWE();
            }
        }
    };
    private CustomMessageListener eCE = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.eCv != null) {
                    EnterForumFragment.this.eCv.iv(true);
                }
                if (EnterForumFragment.this.eCw != null) {
                    EnterForumFragment.this.eCw.aBF();
                }
            }
        }
    };
    final CustomMessageListener eso = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.aWZ()) {
                com.baidu.tieba.enterForum.model.b.aXa();
            }
        }
    };

    public ObservedChangeLinearLayout aWw() {
        return this.eCA;
    }

    private void bC(View view) {
        this.eCz = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        this.eCx = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.eCy = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.eCA = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.eCv = new a(this);
        this.eCv.setPageUniqueId(getUniqueId());
        this.eCx.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                EnterForumFragment.this.eCv.iv(z);
            }
        });
        this.eCz.addView(this.eCv.getView(), 0);
        this.eCv.loadData();
    }

    public void setTabViewController(c cVar) {
        this.eCw = cVar;
    }

    public c aWx() {
        return this.eCw;
    }

    public void aWy() {
        aWz();
        if (this.eCv != null) {
            this.eCv.loadData();
        }
    }

    private void aWz() {
        if (this.eCv != null) {
            this.eCv.ix(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aWy();
            if (this.eCv != null) {
                refreshImage(this.eCv.getView());
            }
        }
        if (this.eCv != null) {
            this.eCv.onPrimary();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.eCz, d.C0236d.cp_bg_line_d);
        if (this.eCv != null) {
            this.eCv.onChangeSkinType(i);
        }
        if (this.eCx != null) {
            this.eCx.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCy != null) {
            this.eCy.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCB != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.eCB);
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
        this.eso.setPriority(101);
        registerListener(this.eso);
        registerListener(this.eCD);
        registerListener(this.eCE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eCv != null) {
            this.eCv.onDestroy();
        }
        this.eCw = null;
        MessageManager.getInstance().unRegisterListener(this.eCD);
        MessageManager.getInstance().unRegisterListener(this.eCE);
        MessageManager.getInstance().unRegisterListener(this.eso);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eCv != null) {
            this.eCv.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eCx != null && this.eCx.getVisibility() == 0 && j.kY()) {
            this.eCx.dO(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
