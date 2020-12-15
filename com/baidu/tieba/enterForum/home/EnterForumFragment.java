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
    private static List<String> ivp = new ArrayList();
    private RelativeLayout bIq;
    private NoNetworkView gpw;
    private com.baidu.tieba.enterForum.data.c itB;
    private a ivk;
    private c ivl;
    private PluginErrorTipView ivm;
    private ObservedChangeLinearLayout ivn;
    private RelativeLayout ivo;
    private CustomMessageListener ivq = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.ivk != null) {
                EnterForumFragment.this.ivk.cvU();
            }
        }
    };
    private CustomMessageListener ivr = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.ivk != null) {
                    EnterForumFragment.this.ivk.pm(true);
                }
                if (EnterForumFragment.this.ivl != null) {
                    EnterForumFragment.this.ivl.bSw();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cwu()) {
                com.baidu.tieba.enterForum.model.b.cwv();
            }
        }
    };

    public ObservedChangeLinearLayout cvK() {
        return this.ivn;
    }

    private void cF(View view) {
        this.bIq = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gpw = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.ivm = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.ivn = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.ivk = new a(this);
        this.ivk.setPageUniqueId(getUniqueId());
        this.gpw.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.ivk.pm(z);
                if (EnterForumFragment.this.cvL() != null) {
                    EnterForumFragment.this.cvL().cwa();
                }
            }
        });
        this.bIq.addView(this.ivk.getView(), 0);
        this.ivk.aTP();
        View findViewById = this.bIq.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bIq.removeView(findViewById);
            this.bIq.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.ivk.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.ivl = cVar;
    }

    public c cvL() {
        return this.ivl;
    }

    public void cvM() {
        cvN();
        if (this.ivk != null) {
            this.ivk.loadData();
        }
    }

    private void cvN() {
        if (this.ivk != null) {
            this.ivk.pn(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cvM();
            if (this.ivk != null) {
                refreshImage(this.ivk.getView());
            }
            com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
        }
        if (this.ivk != null) {
            this.ivk.onPrimary();
        }
        if (cvL() != null) {
            cvL().cwa();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bIq, R.color.CAM_X0201);
        if (this.ivk != null) {
            this.ivk.onChangeSkinType(i);
        }
        if (this.gpw != null) {
            this.gpw.onChangeSkinType(getPageContext(), i);
        }
        if (this.ivm != null) {
            this.ivm.onChangeSkinType(getPageContext(), i);
        }
        if (this.ivo != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.ivo);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cF(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.ivq);
        registerListener(this.ivr);
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ivk != null) {
            this.ivk.onDestroy();
        }
        this.ivl = null;
        MessageManager.getInstance().unRegisterListener(this.ivq);
        MessageManager.getInstance().unRegisterListener(this.ivr);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ivk != null) {
            this.ivk.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gpw != null && this.gpw.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gpw.update(false);
        }
    }

    public RelativeLayout cvO() {
        return this.bIq;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.itB = cVar;
        this.ivl.setAdState(cVar);
    }

    public boolean cvP() {
        if (this.ivk == null || this.ivk.cvV() == null) {
            return true;
        }
        return this.ivk.cvV().cxg();
    }
}
