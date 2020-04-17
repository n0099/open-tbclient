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
    private static List<String> gAK = new ArrayList();
    private RelativeLayout aWM;
    private a gAE;
    private c gAF;
    private NoNetworkView gAG;
    private PluginErrorTipView gAH;
    private ObservedChangeLinearLayout gAI;
    private RelativeLayout gAJ;
    private com.baidu.tieba.enterForum.data.d gyT;
    private CustomMessageListener gAL = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.gAE != null) {
                EnterForumFragment.this.gAE.bIz();
            }
        }
    };
    private CustomMessageListener gAM = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.gAE != null) {
                    EnterForumFragment.this.gAE.lJ(true);
                }
                if (EnterForumFragment.this.gAF != null) {
                    EnterForumFragment.this.gAF.blJ();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bJd()) {
                com.baidu.tieba.enterForum.model.b.bJe();
            }
        }
    };

    public ObservedChangeLinearLayout bIp() {
        return this.gAI;
    }

    private void bO(View view) {
        this.aWM = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gAG = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.gAH = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.gAI = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.gAE = new a(this);
        this.gAE.setPageUniqueId(getUniqueId());
        this.gAG.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.gAE.lJ(z);
                if (EnterForumFragment.this.bIq() != null) {
                    EnterForumFragment.this.bIq().bIF();
                }
            }
        });
        this.aWM.addView(this.gAE.getView(), 0);
        this.gAE.asX();
        View findViewById = this.aWM.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.aWM.removeView(findViewById);
            this.aWM.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.gAE.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.gAF = cVar;
    }

    public c bIq() {
        return this.gAF;
    }

    public void bIr() {
        bIs();
        if (this.gAE != null) {
            this.gAE.loadData();
        }
    }

    private void bIs() {
        if (this.gAE != null) {
            this.gAE.lL(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bIr();
            if (this.gAE != null) {
                refreshImage(this.gAE.getView());
            }
            com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
        }
        if (this.gAE != null) {
            this.gAE.onPrimary();
        }
        if (bIq() != null) {
            bIq().bIF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.aWM, R.color.cp_bg_line_d);
        if (this.gAE != null) {
            this.gAE.onChangeSkinType(i);
        }
        if (this.gAG != null) {
            this.gAG.onChangeSkinType(getPageContext(), i);
        }
        if (this.gAH != null) {
            this.gAH.onChangeSkinType(getPageContext(), i);
        }
        if (this.gAJ != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.gAJ);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bO(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.gAL);
        registerListener(this.gAM);
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gAE != null) {
            this.gAE.onDestroy();
        }
        this.gAF = null;
        MessageManager.getInstance().unRegisterListener(this.gAL);
        MessageManager.getInstance().unRegisterListener(this.gAM);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gAE != null) {
            this.gAE.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gAG != null && this.gAG.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gAG.update(false);
        }
    }

    public RelativeLayout bIt() {
        return this.aWM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gyT = dVar;
        this.gAF.setAdState(dVar);
    }

    public boolean bIu() {
        if (this.gAE == null || this.gAE.bIA() == null) {
            return true;
        }
        return this.gAE.bIA().bJP();
    }
}
