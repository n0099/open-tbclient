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
    private static List<String> fUU = new ArrayList();
    private RelativeLayout aCQ;
    private com.baidu.tieba.enterForum.data.b fTp;
    private a fUO;
    private c fUP;
    private NoNetworkView fUQ;
    private PluginErrorTipView fUR;
    private ObservedChangeLinearLayout fUS;
    private RelativeLayout fUT;
    private CustomMessageListener fUV = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.fUO != null) {
                EnterForumFragment.this.fUO.byu();
            }
        }
    };
    private CustomMessageListener fUW = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.fUO != null) {
                    EnterForumFragment.this.fUO.kB(true);
                }
                if (EnterForumFragment.this.fUP != null) {
                    EnterForumFragment.this.fUP.bcN();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.byU()) {
                com.baidu.tieba.enterForum.model.b.byV();
            }
        }
    };

    public ObservedChangeLinearLayout bym() {
        return this.fUS;
    }

    private void bI(View view) {
        this.aCQ = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fUQ = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.fUR = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.fUS = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.fUO = new a(this);
        this.fUO.setPageUniqueId(getUniqueId());
        this.fUQ.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.fUO.kB(z);
                if (EnterForumFragment.this.byn() != null) {
                    EnterForumFragment.this.byn().byC();
                }
            }
        });
        this.aCQ.addView(this.fUO.getView(), 0);
        this.fUO.akI();
        View findViewById = this.aCQ.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.aCQ.removeView(findViewById);
            this.aCQ.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fUO.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.fUP = cVar;
    }

    public c byn() {
        return this.fUP;
    }

    public void uU() {
        byo();
        if (this.fUO != null) {
            this.fUO.loadData();
        }
    }

    private void byo() {
        if (this.fUO != null) {
            this.fUO.kD(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            uU();
            if (this.fUO != null) {
                refreshImage(this.fUO.getView());
            }
            com.baidu.tieba.s.c.cKa().b(getUniqueId(), false);
        }
        if (this.fUO != null) {
            this.fUO.onPrimary();
        }
        if (byn() != null) {
            byn().byC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.aCQ, R.color.cp_bg_line_d);
        if (this.fUO != null) {
            this.fUO.onChangeSkinType(i);
        }
        if (this.fUQ != null) {
            this.fUQ.onChangeSkinType(getPageContext(), i);
        }
        if (this.fUR != null) {
            this.fUR.onChangeSkinType(getPageContext(), i);
        }
        if (this.fUT != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.fUT);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bI(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.cKa().w(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.fUV);
        registerListener(this.fUW);
        com.baidu.tieba.s.c.cKa().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.cKa().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fUO != null) {
            this.fUO.onDestroy();
        }
        this.fUP = null;
        MessageManager.getInstance().unRegisterListener(this.fUV);
        MessageManager.getInstance().unRegisterListener(this.fUW);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.cKa().x(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fUO != null) {
            this.fUO.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fUQ != null && this.fUQ.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fUQ.update(false);
        }
    }

    public RelativeLayout byp() {
        return this.aCQ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fTp = bVar;
        this.fUP.setAdState(bVar);
    }
}
