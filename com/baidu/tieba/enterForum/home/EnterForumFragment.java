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
/* loaded from: classes2.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> iIF = new ArrayList();
    private RelativeLayout bMd;
    private NoNetworkView gxW;
    private com.baidu.tieba.enterForum.data.c iGR;
    private a iIA;
    private c iIB;
    private PluginErrorTipView iIC;
    private ObservedChangeLinearLayout iID;
    private RelativeLayout iIE;
    private CustomMessageListener iIG = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.iIA != null) {
                EnterForumFragment.this.iIA.cwi();
            }
        }
    };
    private CustomMessageListener iIH = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.iIA != null) {
                    EnterForumFragment.this.iIA.pP(true);
                }
                if (EnterForumFragment.this.iIB != null) {
                    EnterForumFragment.this.iIB.bRK();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cwI()) {
                com.baidu.tieba.enterForum.model.b.cwJ();
            }
        }
    };

    public ObservedChangeLinearLayout cvY() {
        return this.iID;
    }

    private void cN(View view) {
        this.bMd = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gxW = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.iIC = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.iID = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.iIA = new a(this);
        this.iIA.setPageUniqueId(getUniqueId());
        this.gxW.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.iIA.pP(z);
                if (EnterForumFragment.this.cvZ() != null) {
                    EnterForumFragment.this.cvZ().cwo();
                }
            }
        });
        this.bMd.addView(this.iIA.getView(), 0);
        this.iIA.aSC();
        View findViewById = this.bMd.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bMd.removeView(findViewById);
            this.bMd.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iIA.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.iIB = cVar;
    }

    public c cvZ() {
        return this.iIB;
    }

    public void cwa() {
        cwb();
        if (this.iIA != null) {
            this.iIA.loadData();
        }
    }

    private void cwb() {
        if (this.iIA != null) {
            this.iIA.pQ(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cwa();
            if (this.iIA != null) {
                refreshImage(this.iIA.getView());
            }
            com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
        }
        if (this.iIA != null) {
            this.iIA.onPrimary();
        }
        if (cvZ() != null) {
            cvZ().cwo();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bMd, R.color.CAM_X0201);
        if (this.iIA != null) {
            this.iIA.onChangeSkinType(i);
        }
        if (this.gxW != null) {
            this.gxW.onChangeSkinType(getPageContext(), i);
        }
        if (this.iIC != null) {
            this.iIC.onChangeSkinType(getPageContext(), i);
        }
        if (this.iIE != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.iIE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cN(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.iIG);
        registerListener(this.iIH);
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.iIA != null) {
            this.iIA.onDestroy();
        }
        this.iIB = null;
        MessageManager.getInstance().unRegisterListener(this.iIG);
        MessageManager.getInstance().unRegisterListener(this.iIH);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iIA != null) {
            this.iIA.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gxW != null && this.gxW.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gxW.update(false);
        }
    }

    public RelativeLayout cwc() {
        return this.bMd;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iGR = cVar;
        this.iIB.setAdState(cVar);
    }

    public boolean cwd() {
        if (this.iIA == null || this.iIA.cwj() == null) {
            return true;
        }
        return this.iIA.cwj().cxu();
    }
}
