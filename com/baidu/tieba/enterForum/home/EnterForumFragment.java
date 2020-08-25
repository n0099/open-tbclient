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
    private static List<String> hvc = new ArrayList();
    private RelativeLayout bpu;
    private NoNetworkView fCm;
    private com.baidu.tieba.enterForum.data.c hto;
    private a huX;
    private c huY;
    private PluginErrorTipView huZ;
    private ObservedChangeLinearLayout hva;
    private RelativeLayout hvb;
    private CustomMessageListener hvd = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.huX != null) {
                EnterForumFragment.this.huX.cfF();
            }
        }
    };
    private CustomMessageListener hve = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.huX != null) {
                    EnterForumFragment.this.huX.nz(true);
                }
                if (EnterForumFragment.this.huY != null) {
                    EnterForumFragment.this.huY.bGm();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cgf()) {
                com.baidu.tieba.enterForum.model.b.cgg();
            }
        }
    };

    public ObservedChangeLinearLayout cfv() {
        return this.hva;
    }

    private void bY(View view) {
        this.bpu = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fCm = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.huZ = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.hva = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.huX = new a(this);
        this.huX.setPageUniqueId(getUniqueId());
        this.fCm.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.huX.nz(z);
                if (EnterForumFragment.this.cfw() != null) {
                    EnterForumFragment.this.cfw().cfL();
                }
            }
        });
        this.bpu.addView(this.huX.getView(), 0);
        this.huX.aJE();
        View findViewById = this.bpu.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bpu.removeView(findViewById);
            this.bpu.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.huX.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.huY = cVar;
    }

    public c cfw() {
        return this.huY;
    }

    public void cfx() {
        cfy();
        if (this.huX != null) {
            this.huX.loadData();
        }
    }

    private void cfy() {
        if (this.huX != null) {
            this.huX.nA(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cfx();
            if (this.huX != null) {
                refreshImage(this.huX.getView());
            }
            com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
        }
        if (this.huX != null) {
            this.huX.onPrimary();
        }
        if (cfw() != null) {
            cfw().cfL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bpu, R.color.cp_bg_line_d);
        if (this.huX != null) {
            this.huX.onChangeSkinType(i);
        }
        if (this.fCm != null) {
            this.fCm.onChangeSkinType(getPageContext(), i);
        }
        if (this.huZ != null) {
            this.huZ.onChangeSkinType(getPageContext(), i);
        }
        if (this.hvb != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.hvb);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bY(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.hvd);
        registerListener(this.hve);
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.huX != null) {
            this.huX.onDestroy();
        }
        this.huY = null;
        MessageManager.getInstance().unRegisterListener(this.hvd);
        MessageManager.getInstance().unRegisterListener(this.hve);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.huX != null) {
            this.huX.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fCm != null && this.fCm.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fCm.update(false);
        }
    }

    public RelativeLayout cfz() {
        return this.bpu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hto = cVar;
        this.huY.setAdState(cVar);
    }

    public boolean cfA() {
        if (this.huX == null || this.huX.cfG() == null) {
            return true;
        }
        return this.huX.cfG().cgT();
    }
}
