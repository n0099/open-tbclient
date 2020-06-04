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
/* loaded from: classes9.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> gPK = new ArrayList();
    private RelativeLayout bej;
    private NoNetworkView fay;
    private com.baidu.tieba.enterForum.data.d gNU;
    private a gPF;
    private c gPG;
    private PluginErrorTipView gPH;
    private ObservedChangeLinearLayout gPI;
    private RelativeLayout gPJ;
    private CustomMessageListener gPL = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.gPF != null) {
                EnterForumFragment.this.gPF.bOT();
            }
        }
    };
    private CustomMessageListener gPM = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.gPF != null) {
                    EnterForumFragment.this.gPF.mf(true);
                }
                if (EnterForumFragment.this.gPG != null) {
                    EnterForumFragment.this.gPG.brh();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bPx()) {
                com.baidu.tieba.enterForum.model.b.bPy();
            }
        }
    };

    public ObservedChangeLinearLayout bOJ() {
        return this.gPI;
    }

    private void bN(View view) {
        this.bej = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fay = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.gPH = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.gPI = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.gPF = new a(this);
        this.gPF.setPageUniqueId(getUniqueId());
        this.fay.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.gPF.mf(z);
                if (EnterForumFragment.this.bOK() != null) {
                    EnterForumFragment.this.bOK().bOZ();
                }
            }
        });
        this.bej.addView(this.gPF.getView(), 0);
        this.gPF.awE();
        View findViewById = this.bej.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bej.removeView(findViewById);
            this.bej.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.gPF.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.gPG = cVar;
    }

    public c bOK() {
        return this.gPG;
    }

    public void bOL() {
        bOM();
        if (this.gPF != null) {
            this.gPF.loadData();
        }
    }

    private void bOM() {
        if (this.gPF != null) {
            this.gPF.mg(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bOL();
            if (this.gPF != null) {
                refreshImage(this.gPF.getView());
            }
            com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
        }
        if (this.gPF != null) {
            this.gPF.onPrimary();
        }
        if (bOK() != null) {
            bOK().bOZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.bej, R.color.cp_bg_line_d);
        if (this.gPF != null) {
            this.gPF.onChangeSkinType(i);
        }
        if (this.fay != null) {
            this.fay.onChangeSkinType(getPageContext(), i);
        }
        if (this.gPH != null) {
            this.gPH.onChangeSkinType(getPageContext(), i);
        }
        if (this.gPJ != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.gPJ);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bN(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.gPL);
        registerListener(this.gPM);
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gPF != null) {
            this.gPF.onDestroy();
        }
        this.gPG = null;
        MessageManager.getInstance().unRegisterListener(this.gPL);
        MessageManager.getInstance().unRegisterListener(this.gPM);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gPF != null) {
            this.gPF.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fay != null && this.fay.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fay.update(false);
        }
    }

    public RelativeLayout bON() {
        return this.bej;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gNU = dVar;
        this.gPG.setAdState(dVar);
    }

    public boolean bOO() {
        if (this.gPF == null || this.gPF.bOU() == null) {
            return true;
        }
        return this.gPF.bOU().bQl();
    }
}
