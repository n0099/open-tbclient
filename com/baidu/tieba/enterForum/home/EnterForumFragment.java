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
    private static List<String> idJ = new ArrayList();
    private RelativeLayout byI;
    private NoNetworkView gbO;
    private com.baidu.tieba.enterForum.data.c ibR;
    private a idE;
    private c idF;
    private PluginErrorTipView idG;
    private ObservedChangeLinearLayout idH;
    private RelativeLayout idI;
    private CustomMessageListener idK = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.idE != null) {
                EnterForumFragment.this.idE.cpA();
            }
        }
    };
    private CustomMessageListener idL = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.idE != null) {
                    EnterForumFragment.this.idE.oE(true);
                }
                if (EnterForumFragment.this.idF != null) {
                    EnterForumFragment.this.idF.bMR();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cqa()) {
                com.baidu.tieba.enterForum.model.b.cqb();
            }
        }
    };

    public ObservedChangeLinearLayout cpq() {
        return this.idH;
    }

    private void cp(View view) {
        this.byI = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gbO = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.idG = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.idH = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.idE = new a(this);
        this.idE.setPageUniqueId(getUniqueId());
        this.gbO.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.idE.oE(z);
                if (EnterForumFragment.this.cpr() != null) {
                    EnterForumFragment.this.cpr().cpG();
                }
            }
        });
        this.byI.addView(this.idE.getView(), 0);
        this.idE.aOS();
        View findViewById = this.byI.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.byI.removeView(findViewById);
            this.byI.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.idE.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.idF = cVar;
    }

    public c cpr() {
        return this.idF;
    }

    public void cps() {
        cpt();
        if (this.idE != null) {
            this.idE.loadData();
        }
    }

    private void cpt() {
        if (this.idE != null) {
            this.idE.oF(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cps();
            if (this.idE != null) {
                refreshImage(this.idE.getView());
            }
            com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
        }
        if (this.idE != null) {
            this.idE.onPrimary();
        }
        if (cpr() != null) {
            cpr().cpG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.byI, R.color.cp_bg_line_d);
        if (this.idE != null) {
            this.idE.onChangeSkinType(i);
        }
        if (this.gbO != null) {
            this.gbO.onChangeSkinType(getPageContext(), i);
        }
        if (this.idG != null) {
            this.idG.onChangeSkinType(getPageContext(), i);
        }
        if (this.idI != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.idI);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cp(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dGv().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.idK);
        registerListener(this.idL);
        com.baidu.tieba.s.c.dGv().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dGv().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.idE != null) {
            this.idE.onDestroy();
        }
        this.idF = null;
        MessageManager.getInstance().unRegisterListener(this.idK);
        MessageManager.getInstance().unRegisterListener(this.idL);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dGv().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.idE != null) {
            this.idE.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gbO != null && this.gbO.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gbO.update(false);
        }
    }

    public RelativeLayout cpu() {
        return this.byI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ibR = cVar;
        this.idF.setAdState(cVar);
    }

    public boolean cpv() {
        if (this.idE == null || this.idE.cpB() == null) {
            return true;
        }
        return this.idE.cpB().cqM();
    }
}
