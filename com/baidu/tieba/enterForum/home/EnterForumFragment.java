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
    private static List<String> iHC = new ArrayList();
    private RelativeLayout bNf;
    private NoNetworkView gzT;
    private com.baidu.tieba.enterForum.data.c iFO;
    private ObservedChangeLinearLayout iHA;
    private RelativeLayout iHB;
    private a iHx;
    private c iHy;
    private PluginErrorTipView iHz;
    private CustomMessageListener iHD = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.iHx != null) {
                EnterForumFragment.this.iHx.cyO();
            }
        }
    };
    private CustomMessageListener iHE = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.iHx != null) {
                    EnterForumFragment.this.iHx.pJ(true);
                }
                if (EnterForumFragment.this.iHy != null) {
                    EnterForumFragment.this.iHy.bUZ();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.czo()) {
                com.baidu.tieba.enterForum.model.b.czp();
            }
        }
    };

    public ObservedChangeLinearLayout cyE() {
        return this.iHA;
    }

    private void cP(View view) {
        this.bNf = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gzT = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.iHz = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.iHA = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.iHx = new a(this);
        this.iHx.setPageUniqueId(getUniqueId());
        this.gzT.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.iHx.pJ(z);
                if (EnterForumFragment.this.cyF() != null) {
                    EnterForumFragment.this.cyF().cyU();
                }
            }
        });
        this.bNf.addView(this.iHx.getView(), 0);
        this.iHx.aWk();
        View findViewById = this.bNf.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bNf.removeView(findViewById);
            this.bNf.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iHx.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.iHy = cVar;
    }

    public c cyF() {
        return this.iHy;
    }

    public void cyG() {
        cyH();
        if (this.iHx != null) {
            this.iHx.loadData();
        }
    }

    private void cyH() {
        if (this.iHx != null) {
            this.iHx.pK(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cyG();
            if (this.iHx != null) {
                refreshImage(this.iHx.getView());
            }
            com.baidu.tieba.s.c.dNY().b(getUniqueId(), false);
        }
        if (this.iHx != null) {
            this.iHx.onPrimary();
        }
        if (cyF() != null) {
            cyF().cyU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.bNf, R.color.CAM_X0201);
        if (this.iHx != null) {
            this.iHx.onChangeSkinType(i);
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(getPageContext(), i);
        }
        if (this.iHz != null) {
            this.iHz.onChangeSkinType(getPageContext(), i);
        }
        if (this.iHB != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.iHB);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cP(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dNY().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.iHD);
        registerListener(this.iHE);
        com.baidu.tieba.s.c.dNY().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dNY().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.iHx != null) {
            this.iHx.onDestroy();
        }
        this.iHy = null;
        MessageManager.getInstance().unRegisterListener(this.iHD);
        MessageManager.getInstance().unRegisterListener(this.iHE);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dNY().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iHx != null) {
            this.iHx.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gzT != null && this.gzT.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gzT.update(false);
        }
    }

    public RelativeLayout cyI() {
        return this.bNf;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iFO = cVar;
        this.iHy.setAdState(cVar);
    }

    public boolean cyJ() {
        if (this.iHx == null || this.iHx.cyP() == null) {
            return true;
        }
        return this.iHx.cyP().cAa();
    }
}
