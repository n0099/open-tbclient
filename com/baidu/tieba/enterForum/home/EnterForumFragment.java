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
    private static List<String> fVh = new ArrayList();
    private RelativeLayout aCR;
    private com.baidu.tieba.enterForum.data.b fTC;
    private a fVb;
    private c fVc;
    private NoNetworkView fVd;
    private PluginErrorTipView fVe;
    private ObservedChangeLinearLayout fVf;
    private RelativeLayout fVg;
    private CustomMessageListener fVi = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.fVb != null) {
                EnterForumFragment.this.fVb.byv();
            }
        }
    };
    private CustomMessageListener fVj = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.fVb != null) {
                    EnterForumFragment.this.fVb.kB(true);
                }
                if (EnterForumFragment.this.fVc != null) {
                    EnterForumFragment.this.fVc.bcO();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.byV()) {
                com.baidu.tieba.enterForum.model.b.byW();
            }
        }
    };

    public ObservedChangeLinearLayout byn() {
        return this.fVf;
    }

    private void bI(View view) {
        this.aCR = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fVd = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.fVe = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.fVf = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.fVb = new a(this);
        this.fVb.setPageUniqueId(getUniqueId());
        this.fVd.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.fVb.kB(z);
                if (EnterForumFragment.this.byo() != null) {
                    EnterForumFragment.this.byo().byD();
                }
            }
        });
        this.aCR.addView(this.fVb.getView(), 0);
        this.fVb.akI();
        View findViewById = this.aCR.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.aCR.removeView(findViewById);
            this.aCR.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fVb.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.fVc = cVar;
    }

    public c byo() {
        return this.fVc;
    }

    public void uU() {
        byp();
        if (this.fVb != null) {
            this.fVb.loadData();
        }
    }

    private void byp() {
        if (this.fVb != null) {
            this.fVb.kD(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            uU();
            if (this.fVb != null) {
                refreshImage(this.fVb.getView());
            }
            com.baidu.tieba.s.c.cKb().b(getUniqueId(), false);
        }
        if (this.fVb != null) {
            this.fVb.onPrimary();
        }
        if (byo() != null) {
            byo().byD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.aCR, R.color.cp_bg_line_d);
        if (this.fVb != null) {
            this.fVb.onChangeSkinType(i);
        }
        if (this.fVd != null) {
            this.fVd.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVe != null) {
            this.fVe.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVg != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.fVg);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bI(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.cKb().w(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.fVi);
        registerListener(this.fVj);
        com.baidu.tieba.s.c.cKb().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.cKb().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fVb != null) {
            this.fVb.onDestroy();
        }
        this.fVc = null;
        MessageManager.getInstance().unRegisterListener(this.fVi);
        MessageManager.getInstance().unRegisterListener(this.fVj);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.cKb().x(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fVb != null) {
            this.fVb.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fVd != null && this.fVd.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fVd.update(false);
        }
    }

    public RelativeLayout byq() {
        return this.aCR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fTC = bVar;
        this.fVc.setAdState(bVar);
    }
}
