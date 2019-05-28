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
    private static List<String> eRZ = new ArrayList();
    private com.baidu.tieba.enterForum.data.b eQt;
    private a eRT;
    private c eRU;
    private NoNetworkView eRV;
    private PluginErrorTipView eRW;
    private ObservedChangeLinearLayout eRX;
    private RelativeLayout eRY;
    private RelativeLayout epW;
    private CustomMessageListener eSa = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.eRT != null) {
                EnterForumFragment.this.eRT.bdP();
            }
        }
    };
    private CustomMessageListener eSb = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.eRT != null) {
                    EnterForumFragment.this.eRT.ja(true);
                }
                if (EnterForumFragment.this.eRU != null) {
                    EnterForumFragment.this.eRU.aHV();
                }
            }
        }
    };
    final CustomMessageListener bxW = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.beo()) {
                com.baidu.tieba.enterForum.model.b.bep();
            }
        }
    };

    public ObservedChangeLinearLayout bdH() {
        return this.eRX;
    }

    private void bJ(View view) {
        this.epW = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.eRV = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.eRW = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.eRX = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.eRT = new a(this);
        this.eRT.setPageUniqueId(getUniqueId());
        this.eRV.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                EnterForumFragment.this.eRT.ja(z);
                if (EnterForumFragment.this.bdI() != null) {
                    EnterForumFragment.this.bdI().bdX();
                }
            }
        });
        this.epW.addView(this.eRT.getView(), 0);
        this.eRT.bdQ();
        View findViewById = this.epW.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.epW.removeView(findViewById);
            this.epW.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.eRT.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.eRU = cVar;
    }

    public c bdI() {
        return this.eRU;
    }

    public void bdJ() {
        bdK();
        if (this.eRT != null) {
            this.eRT.loadData();
        }
    }

    private void bdK() {
        if (this.eRT != null) {
            this.eRT.jc(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bdJ();
            if (this.eRT != null) {
                refreshImage(this.eRT.getView());
            }
            com.baidu.tieba.q.c.clv().b(getUniqueId(), false);
        }
        if (this.eRT != null) {
            this.eRT.onPrimary();
        }
        if (bdI() != null) {
            bdI().bdX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.epW, R.color.cp_bg_line_d);
        if (this.eRT != null) {
            this.eRT.onChangeSkinType(i);
        }
        if (this.eRV != null) {
            this.eRV.onChangeSkinType(getPageContext(), i);
        }
        if (this.eRW != null) {
            this.eRW.onChangeSkinType(getPageContext(), i);
        }
        if (this.eRY != null) {
            com.baidu.tbadk.s.a.a(getPageContext(), this.eRY);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bJ(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.q.c.clv().u(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bxW.setPriority(101);
        registerListener(this.bxW);
        registerListener(this.eSa);
        registerListener(this.eSb);
        com.baidu.tieba.q.c.clv().u(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.q.c.clv().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eRT != null) {
            this.eRT.onDestroy();
        }
        this.eRU = null;
        MessageManager.getInstance().unRegisterListener(this.eSa);
        MessageManager.getInstance().unRegisterListener(this.eSb);
        MessageManager.getInstance().unRegisterListener(this.bxW);
        com.baidu.tieba.q.c.clv().v(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eRT != null) {
            this.eRT.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eRV != null && this.eRV.getVisibility() == 0 && j.jS()) {
            this.eRV.ek(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eQt = bVar;
        this.eRU.setAdState(bVar);
    }
}
