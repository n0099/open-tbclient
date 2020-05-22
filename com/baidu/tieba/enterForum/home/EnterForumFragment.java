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
    private static List<String> gPz = new ArrayList();
    private RelativeLayout bej;
    private NoNetworkView fan;
    private com.baidu.tieba.enterForum.data.d gNJ;
    private a gPu;
    private c gPv;
    private PluginErrorTipView gPw;
    private ObservedChangeLinearLayout gPx;
    private RelativeLayout gPy;
    private CustomMessageListener gPA = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.gPu != null) {
                EnterForumFragment.this.gPu.bOR();
            }
        }
    };
    private CustomMessageListener gPB = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.gPu != null) {
                    EnterForumFragment.this.gPu.mf(true);
                }
                if (EnterForumFragment.this.gPv != null) {
                    EnterForumFragment.this.gPv.brf();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bPv()) {
                com.baidu.tieba.enterForum.model.b.bPw();
            }
        }
    };

    public ObservedChangeLinearLayout bOH() {
        return this.gPx;
    }

    private void bN(View view) {
        this.bej = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fan = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.gPw = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.gPx = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.gPu = new a(this);
        this.gPu.setPageUniqueId(getUniqueId());
        this.fan.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.gPu.mf(z);
                if (EnterForumFragment.this.bOI() != null) {
                    EnterForumFragment.this.bOI().bOX();
                }
            }
        });
        this.bej.addView(this.gPu.getView(), 0);
        this.gPu.awE();
        View findViewById = this.bej.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bej.removeView(findViewById);
            this.bej.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.gPu.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.gPv = cVar;
    }

    public c bOI() {
        return this.gPv;
    }

    public void bOJ() {
        bOK();
        if (this.gPu != null) {
            this.gPu.loadData();
        }
    }

    private void bOK() {
        if (this.gPu != null) {
            this.gPu.mg(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bOJ();
            if (this.gPu != null) {
                refreshImage(this.gPu.getView());
            }
            com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
        }
        if (this.gPu != null) {
            this.gPu.onPrimary();
        }
        if (bOI() != null) {
            bOI().bOX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.bej, R.color.cp_bg_line_d);
        if (this.gPu != null) {
            this.gPu.onChangeSkinType(i);
        }
        if (this.fan != null) {
            this.fan.onChangeSkinType(getPageContext(), i);
        }
        if (this.gPw != null) {
            this.gPw.onChangeSkinType(getPageContext(), i);
        }
        if (this.gPy != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.gPy);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bN(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dct().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.gPA);
        registerListener(this.gPB);
        com.baidu.tieba.s.c.dct().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gPu != null) {
            this.gPu.onDestroy();
        }
        this.gPv = null;
        MessageManager.getInstance().unRegisterListener(this.gPA);
        MessageManager.getInstance().unRegisterListener(this.gPB);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gPu != null) {
            this.gPu.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fan != null && this.fan.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fan.update(false);
        }
    }

    public RelativeLayout bOL() {
        return this.bej;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gNJ = dVar;
        this.gPv.setAdState(dVar);
    }

    public boolean bOM() {
        if (this.gPu == null || this.gPu.bOS() == null) {
            return true;
        }
        return this.gPu.bOS().bQj();
    }
}
