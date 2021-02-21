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
    private static List<String> iIT = new ArrayList();
    private RelativeLayout bMd;
    private NoNetworkView gyk;
    private com.baidu.tieba.enterForum.data.c iHf;
    private a iIO;
    private c iIP;
    private PluginErrorTipView iIQ;
    private ObservedChangeLinearLayout iIR;
    private RelativeLayout iIS;
    private CustomMessageListener iIU = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.iIO != null) {
                EnterForumFragment.this.iIO.cwp();
            }
        }
    };
    private CustomMessageListener iIV = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.iIO != null) {
                    EnterForumFragment.this.iIO.pP(true);
                }
                if (EnterForumFragment.this.iIP != null) {
                    EnterForumFragment.this.iIP.bRR();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cwP()) {
                com.baidu.tieba.enterForum.model.b.cwQ();
            }
        }
    };

    public ObservedChangeLinearLayout cwf() {
        return this.iIR;
    }

    private void cN(View view) {
        this.bMd = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gyk = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.iIQ = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.iIR = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.iIO = new a(this);
        this.iIO.setPageUniqueId(getUniqueId());
        this.gyk.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.iIO.pP(z);
                if (EnterForumFragment.this.cwg() != null) {
                    EnterForumFragment.this.cwg().cwv();
                }
            }
        });
        this.bMd.addView(this.iIO.getView(), 0);
        this.iIO.aSC();
        View findViewById = this.bMd.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bMd.removeView(findViewById);
            this.bMd.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iIO.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.iIP = cVar;
    }

    public c cwg() {
        return this.iIP;
    }

    public void cwh() {
        cwi();
        if (this.iIO != null) {
            this.iIO.loadData();
        }
    }

    private void cwi() {
        if (this.iIO != null) {
            this.iIO.pQ(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cwh();
            if (this.iIO != null) {
                refreshImage(this.iIO.getView());
            }
            com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
        }
        if (this.iIO != null) {
            this.iIO.onPrimary();
        }
        if (cwg() != null) {
            cwg().cwv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bMd, R.color.CAM_X0201);
        if (this.iIO != null) {
            this.iIO.onChangeSkinType(i);
        }
        if (this.gyk != null) {
            this.gyk.onChangeSkinType(getPageContext(), i);
        }
        if (this.iIQ != null) {
            this.iIQ.onChangeSkinType(getPageContext(), i);
        }
        if (this.iIS != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.iIS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cN(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.iIU);
        registerListener(this.iIV);
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.iIO != null) {
            this.iIO.onDestroy();
        }
        this.iIP = null;
        MessageManager.getInstance().unRegisterListener(this.iIU);
        MessageManager.getInstance().unRegisterListener(this.iIV);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iIO != null) {
            this.iIO.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gyk != null && this.gyk.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gyk.update(false);
        }
    }

    public RelativeLayout cwj() {
        return this.bMd;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iHf = cVar;
        this.iIP.setAdState(cVar);
    }

    public boolean cwk() {
        if (this.iIO == null || this.iIO.cwq() == null) {
            return true;
        }
        return this.iIO.cwq().cxB();
    }
}
