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
    private static List<String> gAQ = new ArrayList();
    private RelativeLayout aWR;
    private a gAK;
    private c gAL;
    private NoNetworkView gAM;
    private PluginErrorTipView gAN;
    private ObservedChangeLinearLayout gAO;
    private RelativeLayout gAP;
    private com.baidu.tieba.enterForum.data.d gyZ;
    private CustomMessageListener gAR = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.gAK != null) {
                EnterForumFragment.this.gAK.bIx();
            }
        }
    };
    private CustomMessageListener gAS = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.gAK != null) {
                    EnterForumFragment.this.gAK.lJ(true);
                }
                if (EnterForumFragment.this.gAL != null) {
                    EnterForumFragment.this.gAL.blH();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bJb()) {
                com.baidu.tieba.enterForum.model.b.bJc();
            }
        }
    };

    public ObservedChangeLinearLayout bIn() {
        return this.gAO;
    }

    private void bO(View view) {
        this.aWR = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gAM = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.gAN = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.gAO = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.gAK = new a(this);
        this.gAK.setPageUniqueId(getUniqueId());
        this.gAM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.gAK.lJ(z);
                if (EnterForumFragment.this.bIo() != null) {
                    EnterForumFragment.this.bIo().bID();
                }
            }
        });
        this.aWR.addView(this.gAK.getView(), 0);
        this.gAK.asX();
        View findViewById = this.aWR.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.aWR.removeView(findViewById);
            this.aWR.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.gAK.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.gAL = cVar;
    }

    public c bIo() {
        return this.gAL;
    }

    public void bIp() {
        bIq();
        if (this.gAK != null) {
            this.gAK.loadData();
        }
    }

    private void bIq() {
        if (this.gAK != null) {
            this.gAK.lL(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bIp();
            if (this.gAK != null) {
                refreshImage(this.gAK.getView());
            }
            com.baidu.tieba.s.c.cVo().b(getUniqueId(), false);
        }
        if (this.gAK != null) {
            this.gAK.onPrimary();
        }
        if (bIo() != null) {
            bIo().bID();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.aWR, R.color.cp_bg_line_d);
        if (this.gAK != null) {
            this.gAK.onChangeSkinType(i);
        }
        if (this.gAM != null) {
            this.gAM.onChangeSkinType(getPageContext(), i);
        }
        if (this.gAN != null) {
            this.gAN.onChangeSkinType(getPageContext(), i);
        }
        if (this.gAP != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.gAP);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bO(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.cVo().w(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.gAR);
        registerListener(this.gAS);
        com.baidu.tieba.s.c.cVo().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.cVo().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gAK != null) {
            this.gAK.onDestroy();
        }
        this.gAL = null;
        MessageManager.getInstance().unRegisterListener(this.gAR);
        MessageManager.getInstance().unRegisterListener(this.gAS);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.cVo().x(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gAK != null) {
            this.gAK.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gAM != null && this.gAM.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gAM.update(false);
        }
    }

    public RelativeLayout bIr() {
        return this.aWR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gyZ = dVar;
        this.gAL.setAdState(dVar);
    }

    public boolean bIs() {
        if (this.gAK == null || this.gAK.bIy() == null) {
            return true;
        }
        return this.gAK.bIy().bJN();
    }
}
