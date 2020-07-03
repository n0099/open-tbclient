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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> hct = new ArrayList();
    private RelativeLayout bjv;
    private NoNetworkView flI;
    private com.baidu.tieba.enterForum.data.c haQ;
    private a hco;
    private c hcp;
    private PluginErrorTipView hcq;
    private ObservedChangeLinearLayout hcr;
    private RelativeLayout hcs;
    private CustomMessageListener hcu = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.hco != null) {
                EnterForumFragment.this.hco.bRW();
            }
        }
    };
    private CustomMessageListener hcv = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.hco != null) {
                    EnterForumFragment.this.hco.mq(true);
                }
                if (EnterForumFragment.this.hcp != null) {
                    EnterForumFragment.this.hcp.bud();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bSA()) {
                com.baidu.tieba.enterForum.model.b.bSB();
            }
        }
    };

    public ObservedChangeLinearLayout bRM() {
        return this.hcr;
    }

    private void bQ(View view) {
        this.bjv = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.flI = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.hcq = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.hcr = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.hco = new a(this);
        this.hco.setPageUniqueId(getUniqueId());
        this.flI.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.hco.mq(z);
                if (EnterForumFragment.this.bRN() != null) {
                    EnterForumFragment.this.bRN().bSc();
                }
            }
        });
        this.bjv.addView(this.hco.getView(), 0);
        this.hco.axK();
        View findViewById = this.bjv.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bjv.removeView(findViewById);
            this.bjv.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hco.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.hcp = cVar;
    }

    public c bRN() {
        return this.hcp;
    }

    public void bRO() {
        bRP();
        if (this.hco != null) {
            this.hco.loadData();
        }
    }

    private void bRP() {
        if (this.hco != null) {
            this.hco.mr(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bRO();
            if (this.hco != null) {
                refreshImage(this.hco.getView());
            }
            com.baidu.tieba.s.c.dgX().b(getUniqueId(), false);
        }
        if (this.hco != null) {
            this.hco.onPrimary();
        }
        if (bRN() != null) {
            bRN().bSc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.setBackgroundColor(this.bjv, R.color.cp_bg_line_d);
        if (this.hco != null) {
            this.hco.onChangeSkinType(i);
        }
        if (this.flI != null) {
            this.flI.onChangeSkinType(getPageContext(), i);
        }
        if (this.hcq != null) {
            this.hcq.onChangeSkinType(getPageContext(), i);
        }
        if (this.hcs != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.hcs);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bQ(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dgX().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.hcu);
        registerListener(this.hcv);
        com.baidu.tieba.s.c.dgX().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dgX().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hco != null) {
            this.hco.onDestroy();
        }
        this.hcp = null;
        MessageManager.getInstance().unRegisterListener(this.hcu);
        MessageManager.getInstance().unRegisterListener(this.hcv);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dgX().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hco != null) {
            this.hco.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.flI != null && this.flI.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.flI.update(false);
        }
    }

    public RelativeLayout bRQ() {
        return this.bjv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.haQ = cVar;
        this.hcp.setAdState(cVar);
    }

    public boolean bRR() {
        if (this.hco == null || this.hco.bRX() == null) {
            return true;
        }
        return this.hco.bRX().bTo();
    }
}
