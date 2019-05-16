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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> eRY = new ArrayList();
    private com.baidu.tieba.enterForum.data.b eQs;
    private a eRS;
    private c eRT;
    private NoNetworkView eRU;
    private PluginErrorTipView eRV;
    private ObservedChangeLinearLayout eRW;
    private RelativeLayout eRX;
    private RelativeLayout epV;
    private CustomMessageListener eRZ = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.eRS != null) {
                EnterForumFragment.this.eRS.bdM();
            }
        }
    };
    private CustomMessageListener eSa = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.eRS != null) {
                    EnterForumFragment.this.eRS.ja(true);
                }
                if (EnterForumFragment.this.eRT != null) {
                    EnterForumFragment.this.eRT.aHS();
                }
            }
        }
    };
    final CustomMessageListener bxW = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bel()) {
                com.baidu.tieba.enterForum.model.b.bem();
            }
        }
    };

    public ObservedChangeLinearLayout bdE() {
        return this.eRW;
    }

    private void bJ(View view) {
        this.epV = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.eRU = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.eRV = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.eRW = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.eRS = new a(this);
        this.eRS.setPageUniqueId(getUniqueId());
        this.eRU.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                EnterForumFragment.this.eRS.ja(z);
                if (EnterForumFragment.this.bdF() != null) {
                    EnterForumFragment.this.bdF().bdU();
                }
            }
        });
        this.epV.addView(this.eRS.getView(), 0);
        this.eRS.bdN();
        View findViewById = this.epV.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.epV.removeView(findViewById);
            this.epV.addView(findViewById, 0);
        }
        this.eRS.loadData();
    }

    public void setTabViewController(c cVar) {
        this.eRT = cVar;
    }

    public c bdF() {
        return this.eRT;
    }

    public void bdG() {
        bdH();
        if (this.eRS != null) {
            this.eRS.loadData();
        }
    }

    private void bdH() {
        if (this.eRS != null) {
            this.eRS.jc(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bdG();
            if (this.eRS != null) {
                refreshImage(this.eRS.getView());
            }
            com.baidu.tieba.q.c.clt().b(getUniqueId(), false);
        }
        if (this.eRS != null) {
            this.eRS.onPrimary();
        }
        if (bdF() != null) {
            bdF().bdU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.epV, R.color.cp_bg_line_d);
        if (this.eRS != null) {
            this.eRS.onChangeSkinType(i);
        }
        if (this.eRU != null) {
            this.eRU.onChangeSkinType(getPageContext(), i);
        }
        if (this.eRV != null) {
            this.eRV.onChangeSkinType(getPageContext(), i);
        }
        if (this.eRX != null) {
            com.baidu.tbadk.s.a.a(getPageContext(), this.eRX);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bJ(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.q.c.clt().u(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bxW.setPriority(101);
        registerListener(this.bxW);
        registerListener(this.eRZ);
        registerListener(this.eSa);
        com.baidu.tieba.q.c.clt().u(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.q.c.clt().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eRS != null) {
            this.eRS.onDestroy();
        }
        this.eRT = null;
        MessageManager.getInstance().unRegisterListener(this.eRZ);
        MessageManager.getInstance().unRegisterListener(this.eSa);
        MessageManager.getInstance().unRegisterListener(this.bxW);
        com.baidu.tieba.q.c.clt().v(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eRS != null) {
            this.eRS.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eRU != null && this.eRU.getVisibility() == 0 && j.jS()) {
            this.eRU.ek(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eQs = bVar;
        this.eRT.setAdState(bVar);
    }
}
