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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> fbA = new ArrayList();
    private RelativeLayout aqs;
    private com.baidu.tieba.enterForum.data.b eZS;
    private a fbu;
    private c fbv;
    private NoNetworkView fbw;
    private PluginErrorTipView fbx;
    private ObservedChangeLinearLayout fby;
    private RelativeLayout fbz;
    private CustomMessageListener fbB = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.fbu != null) {
                EnterForumFragment.this.fbu.ber();
            }
        }
    };
    private CustomMessageListener fbC = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.fbu != null) {
                    EnterForumFragment.this.fbu.jc(true);
                }
                if (EnterForumFragment.this.fbv != null) {
                    EnterForumFragment.this.fbv.aJB();
                }
            }
        }
    };
    final CustomMessageListener bRR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.beT()) {
                com.baidu.tieba.enterForum.model.b.beU();
            }
        }
    };

    public ObservedChangeLinearLayout bej() {
        return this.fby;
    }

    private void bI(View view) {
        this.aqs = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fbw = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.fbx = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.fby = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.fbu = new a(this);
        this.fbu.setPageUniqueId(getUniqueId());
        this.fbw.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.fbu.jc(z);
                if (EnterForumFragment.this.bek() != null) {
                    EnterForumFragment.this.bek().beA();
                }
            }
        });
        this.aqs.addView(this.fbu.getView(), 0);
        this.fbu.bes();
        View findViewById = this.aqs.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.aqs.removeView(findViewById);
            this.aqs.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fbu.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.fbv = cVar;
    }

    public c bek() {
        return this.fbv;
    }

    public void rx() {
        bel();
        if (this.fbu != null) {
            this.fbu.loadData();
        }
    }

    private void bel() {
        if (this.fbu != null) {
            this.fbu.je(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            rx();
            if (this.fbu != null) {
                refreshImage(this.fbu.getView());
            }
            com.baidu.tieba.q.c.cnk().b(getUniqueId(), false);
        }
        if (this.fbu != null) {
            this.fbu.onPrimary();
        }
        if (bek() != null) {
            bek().beA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.aqs, R.color.cp_bg_line_d);
        if (this.fbu != null) {
            this.fbu.onChangeSkinType(i);
        }
        if (this.fbw != null) {
            this.fbw.onChangeSkinType(getPageContext(), i);
        }
        if (this.fbx != null) {
            this.fbx.onChangeSkinType(getPageContext(), i);
        }
        if (this.fbz != null) {
            com.baidu.tbadk.s.a.a(getPageContext(), this.fbz);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bI(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.q.c.cnk().v(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bRR.setPriority(101);
        registerListener(this.bRR);
        registerListener(this.fbB);
        registerListener(this.fbC);
        com.baidu.tieba.q.c.cnk().v(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.q.c.cnk().w(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fbu != null) {
            this.fbu.onDestroy();
        }
        this.fbv = null;
        MessageManager.getInstance().unRegisterListener(this.fbB);
        MessageManager.getInstance().unRegisterListener(this.fbC);
        MessageManager.getInstance().unRegisterListener(this.bRR);
        com.baidu.tieba.q.c.cnk().w(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fbu != null) {
            this.fbu.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fbw != null && this.fbw.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fbw.update(false);
        }
    }

    public RelativeLayout bem() {
        return this.aqs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eZS = bVar;
        this.fbv.setAdState(bVar);
    }
}
