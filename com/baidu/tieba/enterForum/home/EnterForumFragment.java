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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> hvi = new ArrayList();
    private RelativeLayout bpx;
    private NoNetworkView fCq;
    private com.baidu.tieba.enterForum.data.c htu;
    private a hvd;
    private c hve;
    private PluginErrorTipView hvf;
    private ObservedChangeLinearLayout hvg;
    private RelativeLayout hvh;
    private CustomMessageListener hvj = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.hvd != null) {
                EnterForumFragment.this.hvd.cfG();
            }
        }
    };
    private CustomMessageListener hvk = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.hvd != null) {
                    EnterForumFragment.this.hvd.nB(true);
                }
                if (EnterForumFragment.this.hve != null) {
                    EnterForumFragment.this.hve.bGn();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cgg()) {
                com.baidu.tieba.enterForum.model.b.cgh();
            }
        }
    };

    public ObservedChangeLinearLayout cfw() {
        return this.hvg;
    }

    private void bY(View view) {
        this.bpx = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fCq = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.hvf = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.hvg = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.hvd = new a(this);
        this.hvd.setPageUniqueId(getUniqueId());
        this.fCq.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.hvd.nB(z);
                if (EnterForumFragment.this.cfx() != null) {
                    EnterForumFragment.this.cfx().cfM();
                }
            }
        });
        this.bpx.addView(this.hvd.getView(), 0);
        this.hvd.aJE();
        View findViewById = this.bpx.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bpx.removeView(findViewById);
            this.bpx.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hvd.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.hve = cVar;
    }

    public c cfx() {
        return this.hve;
    }

    public void cfy() {
        cfz();
        if (this.hvd != null) {
            this.hvd.loadData();
        }
    }

    private void cfz() {
        if (this.hvd != null) {
            this.hvd.nC(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cfy();
            if (this.hvd != null) {
                refreshImage(this.hvd.getView());
            }
            com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
        }
        if (this.hvd != null) {
            this.hvd.onPrimary();
        }
        if (cfx() != null) {
            cfx().cfM();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bpx, R.color.cp_bg_line_d);
        if (this.hvd != null) {
            this.hvd.onChangeSkinType(i);
        }
        if (this.fCq != null) {
            this.fCq.onChangeSkinType(getPageContext(), i);
        }
        if (this.hvf != null) {
            this.hvf.onChangeSkinType(getPageContext(), i);
        }
        if (this.hvh != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.hvh);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bY(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.hvj);
        registerListener(this.hvk);
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hvd != null) {
            this.hvd.onDestroy();
        }
        this.hve = null;
        MessageManager.getInstance().unRegisterListener(this.hvj);
        MessageManager.getInstance().unRegisterListener(this.hvk);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hvd != null) {
            this.hvd.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fCq != null && this.fCq.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fCq.update(false);
        }
    }

    public RelativeLayout cfA() {
        return this.bpx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.htu = cVar;
        this.hve.setAdState(cVar);
    }

    public boolean cfB() {
        if (this.hvd == null || this.hvd.cfH() == null) {
            return true;
        }
        return this.hvd.cfH().cgU();
    }
}
