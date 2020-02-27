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
    private static List<String> fUS = new ArrayList();
    private RelativeLayout aCP;
    private com.baidu.tieba.enterForum.data.b fTn;
    private a fUM;
    private c fUN;
    private NoNetworkView fUO;
    private PluginErrorTipView fUP;
    private ObservedChangeLinearLayout fUQ;
    private RelativeLayout fUR;
    private CustomMessageListener fUT = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.fUM != null) {
                EnterForumFragment.this.fUM.bys();
            }
        }
    };
    private CustomMessageListener fUU = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.fUM != null) {
                    EnterForumFragment.this.fUM.kB(true);
                }
                if (EnterForumFragment.this.fUN != null) {
                    EnterForumFragment.this.fUN.bcL();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.byS()) {
                com.baidu.tieba.enterForum.model.b.byT();
            }
        }
    };

    public ObservedChangeLinearLayout byk() {
        return this.fUQ;
    }

    private void bI(View view) {
        this.aCP = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fUO = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.fUP = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.fUQ = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.fUM = new a(this);
        this.fUM.setPageUniqueId(getUniqueId());
        this.fUO.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.fUM.kB(z);
                if (EnterForumFragment.this.byl() != null) {
                    EnterForumFragment.this.byl().byA();
                }
            }
        });
        this.aCP.addView(this.fUM.getView(), 0);
        this.fUM.akG();
        View findViewById = this.aCP.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.aCP.removeView(findViewById);
            this.aCP.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fUM.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.fUN = cVar;
    }

    public c byl() {
        return this.fUN;
    }

    public void uU() {
        bym();
        if (this.fUM != null) {
            this.fUM.loadData();
        }
    }

    private void bym() {
        if (this.fUM != null) {
            this.fUM.kD(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            uU();
            if (this.fUM != null) {
                refreshImage(this.fUM.getView());
            }
            com.baidu.tieba.s.c.cJY().b(getUniqueId(), false);
        }
        if (this.fUM != null) {
            this.fUM.onPrimary();
        }
        if (byl() != null) {
            byl().byA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.aCP, R.color.cp_bg_line_d);
        if (this.fUM != null) {
            this.fUM.onChangeSkinType(i);
        }
        if (this.fUO != null) {
            this.fUO.onChangeSkinType(getPageContext(), i);
        }
        if (this.fUP != null) {
            this.fUP.onChangeSkinType(getPageContext(), i);
        }
        if (this.fUR != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.fUR);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bI(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.fUT);
        registerListener(this.fUU);
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fUM != null) {
            this.fUM.onDestroy();
        }
        this.fUN = null;
        MessageManager.getInstance().unRegisterListener(this.fUT);
        MessageManager.getInstance().unRegisterListener(this.fUU);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fUM != null) {
            this.fUM.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fUO != null && this.fUO.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fUO.update(false);
        }
    }

    public RelativeLayout byn() {
        return this.aCP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fTn = bVar;
        this.fUN.setAdState(bVar);
    }
}
