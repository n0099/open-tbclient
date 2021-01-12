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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> iCV = new ArrayList();
    private RelativeLayout bIt;
    private NoNetworkView gvm;
    private com.baidu.tieba.enterForum.data.c iBh;
    private a iCQ;
    private c iCR;
    private PluginErrorTipView iCS;
    private ObservedChangeLinearLayout iCT;
    private RelativeLayout iCU;
    private CustomMessageListener iCW = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.iCQ != null) {
                EnterForumFragment.this.iCQ.cuW();
            }
        }
    };
    private CustomMessageListener iCX = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.iCQ != null) {
                    EnterForumFragment.this.iCQ.pF(true);
                }
                if (EnterForumFragment.this.iCR != null) {
                    EnterForumFragment.this.iCR.bRh();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cvw()) {
                com.baidu.tieba.enterForum.model.b.cvx();
            }
        }
    };

    public ObservedChangeLinearLayout cuM() {
        return this.iCT;
    }

    private void cP(View view) {
        this.bIt = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gvm = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.iCS = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.iCT = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.iCQ = new a(this);
        this.iCQ.setPageUniqueId(getUniqueId());
        this.gvm.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.iCQ.pF(z);
                if (EnterForumFragment.this.cuN() != null) {
                    EnterForumFragment.this.cuN().cvc();
                }
            }
        });
        this.bIt.addView(this.iCQ.getView(), 0);
        this.iCQ.aSq();
        View findViewById = this.bIt.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bIt.removeView(findViewById);
            this.bIt.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iCQ.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.iCR = cVar;
    }

    public c cuN() {
        return this.iCR;
    }

    public void cuO() {
        cuP();
        if (this.iCQ != null) {
            this.iCQ.loadData();
        }
    }

    private void cuP() {
        if (this.iCQ != null) {
            this.iCQ.pG(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cuO();
            if (this.iCQ != null) {
                refreshImage(this.iCQ.getView());
            }
            com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
        }
        if (this.iCQ != null) {
            this.iCQ.onPrimary();
        }
        if (cuN() != null) {
            cuN().cvc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.bIt, R.color.CAM_X0201);
        if (this.iCQ != null) {
            this.iCQ.onChangeSkinType(i);
        }
        if (this.gvm != null) {
            this.gvm.onChangeSkinType(getPageContext(), i);
        }
        if (this.iCS != null) {
            this.iCS.onChangeSkinType(getPageContext(), i);
        }
        if (this.iCU != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.iCU);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cP(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.iCW);
        registerListener(this.iCX);
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.iCQ != null) {
            this.iCQ.onDestroy();
        }
        this.iCR = null;
        MessageManager.getInstance().unRegisterListener(this.iCW);
        MessageManager.getInstance().unRegisterListener(this.iCX);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iCQ != null) {
            this.iCQ.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gvm != null && this.gvm.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gvm.update(false);
        }
    }

    public RelativeLayout cuQ() {
        return this.bIt;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iBh = cVar;
        this.iCR.setAdState(cVar);
    }

    public boolean cuR() {
        if (this.iCQ == null || this.iCQ.cuX() == null) {
            return true;
        }
        return this.iCQ.cuX().cwi();
    }
}
