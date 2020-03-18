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
    private static List<String> fVQ = new ArrayList();
    private RelativeLayout aDf;
    private com.baidu.tieba.enterForum.data.b fUl;
    private a fVK;
    private c fVL;
    private NoNetworkView fVM;
    private PluginErrorTipView fVN;
    private ObservedChangeLinearLayout fVO;
    private RelativeLayout fVP;
    private CustomMessageListener fVR = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.fVK != null) {
                EnterForumFragment.this.fVK.byB();
            }
        }
    };
    private CustomMessageListener fVS = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.fVK != null) {
                    EnterForumFragment.this.fVK.kG(true);
                }
                if (EnterForumFragment.this.fVL != null) {
                    EnterForumFragment.this.fVL.bcS();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bzb()) {
                com.baidu.tieba.enterForum.model.b.bzc();
            }
        }
    };

    public ObservedChangeLinearLayout byt() {
        return this.fVO;
    }

    private void bI(View view) {
        this.aDf = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fVM = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.fVN = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.fVO = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.fVK = new a(this);
        this.fVK.setPageUniqueId(getUniqueId());
        this.fVM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.fVK.kG(z);
                if (EnterForumFragment.this.byu() != null) {
                    EnterForumFragment.this.byu().byJ();
                }
            }
        });
        this.aDf.addView(this.fVK.getView(), 0);
        this.fVK.akL();
        View findViewById = this.aDf.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.aDf.removeView(findViewById);
            this.aDf.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fVK.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.fVL = cVar;
    }

    public c byu() {
        return this.fVL;
    }

    public void uZ() {
        byv();
        if (this.fVK != null) {
            this.fVK.loadData();
        }
    }

    private void byv() {
        if (this.fVK != null) {
            this.fVK.kI(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            uZ();
            if (this.fVK != null) {
                refreshImage(this.fVK.getView());
            }
            com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
        }
        if (this.fVK != null) {
            this.fVK.onPrimary();
        }
        if (byu() != null) {
            byu().byJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.aDf, R.color.cp_bg_line_d);
        if (this.fVK != null) {
            this.fVK.onChangeSkinType(i);
        }
        if (this.fVM != null) {
            this.fVM.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVN != null) {
            this.fVN.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVP != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.fVP);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bI(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.fVR);
        registerListener(this.fVS);
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fVK != null) {
            this.fVK.onDestroy();
        }
        this.fVL = null;
        MessageManager.getInstance().unRegisterListener(this.fVR);
        MessageManager.getInstance().unRegisterListener(this.fVS);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fVK != null) {
            this.fVK.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fVM != null && this.fVM.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fVM.update(false);
        }
    }

    public RelativeLayout byw() {
        return this.aDf;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fUl = bVar;
        this.fVL.setAdState(bVar);
    }
}
