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
    private static List<String> iKC = new ArrayList();
    private RelativeLayout bND;
    private NoNetworkView gzT;
    private com.baidu.tieba.enterForum.data.c iIO;
    private ObservedChangeLinearLayout iKA;
    private RelativeLayout iKB;
    private a iKx;
    private c iKy;
    private PluginErrorTipView iKz;
    private CustomMessageListener iKD = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.iKx != null) {
                EnterForumFragment.this.iKx.cwv();
            }
        }
    };
    private CustomMessageListener iKE = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.iKx != null) {
                    EnterForumFragment.this.iKx.pP(true);
                }
                if (EnterForumFragment.this.iKy != null) {
                    EnterForumFragment.this.iKy.bRX();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cwV()) {
                com.baidu.tieba.enterForum.model.b.cwW();
            }
        }
    };

    public ObservedChangeLinearLayout cwl() {
        return this.iKA;
    }

    private void cN(View view) {
        this.bND = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.gzT = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.iKz = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.iKA = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.iKx = new a(this);
        this.iKx.setPageUniqueId(getUniqueId());
        this.gzT.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.iKx.pP(z);
                if (EnterForumFragment.this.cwm() != null) {
                    EnterForumFragment.this.cwm().cwB();
                }
            }
        });
        this.bND.addView(this.iKx.getView(), 0);
        this.iKx.aSF();
        View findViewById = this.bND.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bND.removeView(findViewById);
            this.bND.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iKx.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.iKy = cVar;
    }

    public c cwm() {
        return this.iKy;
    }

    public void cwn() {
        cwo();
        if (this.iKx != null) {
            this.iKx.loadData();
        }
    }

    private void cwo() {
        if (this.iKx != null) {
            this.iKx.pQ(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cwn();
            if (this.iKx != null) {
                refreshImage(this.iKx.getView());
            }
            com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
        }
        if (this.iKx != null) {
            this.iKx.onPrimary();
        }
        if (cwm() != null) {
            cwm().cwB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bND, R.color.CAM_X0201);
        if (this.iKx != null) {
            this.iKx.onChangeSkinType(i);
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(getPageContext(), i);
        }
        if (this.iKz != null) {
            this.iKz.onChangeSkinType(getPageContext(), i);
        }
        if (this.iKB != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.iKB);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        cN(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.iKD);
        registerListener(this.iKE);
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.iKx != null) {
            this.iKx.onDestroy();
        }
        this.iKy = null;
        MessageManager.getInstance().unRegisterListener(this.iKD);
        MessageManager.getInstance().unRegisterListener(this.iKE);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iKx != null) {
            this.iKx.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gzT != null && this.gzT.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.gzT.update(false);
        }
    }

    public RelativeLayout cwp() {
        return this.bND;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iIO = cVar;
        this.iKy.setAdState(cVar);
    }

    public boolean cwq() {
        if (this.iKx == null || this.iKx.cww() == null) {
            return true;
        }
        return this.iKx.cww().cxH();
    }
}
