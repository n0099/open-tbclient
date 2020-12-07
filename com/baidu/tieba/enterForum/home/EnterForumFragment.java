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
/* loaded from: classes22.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> ivn = new ArrayList();
    private RelativeLayout bIq;
    private NoNetworkView gpu;
    private com.baidu.tieba.enterForum.data.c itz;
    private a ivi;
    private c ivj;
    private PluginErrorTipView ivk;
    private ObservedChangeLinearLayout ivl;
    private RelativeLayout ivm;
    private CustomMessageListener ivo = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.ivi != null) {
                EnterForumFragment.this.ivi.cvT();
            }
        }
    };
    private CustomMessageListener ivp = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.ivi != null) {
                    EnterForumFragment.this.ivi.pm(true);
                }
                if (EnterForumFragment.this.ivj != null) {
                    EnterForumFragment.this.ivj.bSv();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cwt()) {
                com.baidu.tieba.enterForum.model.b.cwu();
            }
        }
    };

    public ObservedChangeLinearLayout cvJ() {
        return this.ivl;
    }

    private void cF(View view) {
        this.bIq = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gpu = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.ivk = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.ivl = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.ivi = new a(this);
        this.ivi.setPageUniqueId(getUniqueId());
        this.gpu.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.ivi.pm(z);
                if (EnterForumFragment.this.cvK() != null) {
                    EnterForumFragment.this.cvK().cvZ();
                }
            }
        });
        this.bIq.addView(this.ivi.getView(), 0);
        this.ivi.aTP();
        View findViewById = this.bIq.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bIq.removeView(findViewById);
            this.bIq.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.ivi.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.ivj = cVar;
    }

    public c cvK() {
        return this.ivj;
    }

    public void cvL() {
        cvM();
        if (this.ivi != null) {
            this.ivi.loadData();
        }
    }

    private void cvM() {
        if (this.ivi != null) {
            this.ivi.pn(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cvL();
            if (this.ivi != null) {
                refreshImage(this.ivi.getView());
            }
            com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
        }
        if (this.ivi != null) {
            this.ivi.onPrimary();
        }
        if (cvK() != null) {
            cvK().cvZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bIq, R.color.CAM_X0201);
        if (this.ivi != null) {
            this.ivi.onChangeSkinType(i);
        }
        if (this.gpu != null) {
            this.gpu.onChangeSkinType(getPageContext(), i);
        }
        if (this.ivk != null) {
            this.ivk.onChangeSkinType(getPageContext(), i);
        }
        if (this.ivm != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.ivm);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cF(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.t.c.dOe().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.ivo);
        registerListener(this.ivp);
        com.baidu.tieba.t.c.dOe().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.t.c.dOe().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ivi != null) {
            this.ivi.onDestroy();
        }
        this.ivj = null;
        MessageManager.getInstance().unRegisterListener(this.ivo);
        MessageManager.getInstance().unRegisterListener(this.ivp);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.t.c.dOe().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ivi != null) {
            this.ivi.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gpu != null && this.gpu.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gpu.update(false);
        }
    }

    public RelativeLayout cvN() {
        return this.bIq;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.itz = cVar;
        this.ivj.setAdState(cVar);
    }

    public boolean cvO() {
        if (this.ivi == null || this.ivi.cvU() == null) {
            return true;
        }
        return this.ivi.cvU().cxf();
    }
}
