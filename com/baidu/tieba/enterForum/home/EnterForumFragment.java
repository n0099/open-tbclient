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
/* loaded from: classes21.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> hCn = new ArrayList();
    private RelativeLayout bsG;
    private NoNetworkView fFC;
    private com.baidu.tieba.enterForum.data.c hAz;
    private a hCi;
    private c hCj;
    private PluginErrorTipView hCk;
    private ObservedChangeLinearLayout hCl;
    private RelativeLayout hCm;
    private CustomMessageListener hCo = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.hCi != null) {
                EnterForumFragment.this.hCi.ciX();
            }
        }
    };
    private CustomMessageListener hCp = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.hCi != null) {
                    EnterForumFragment.this.hCi.nH(true);
                }
                if (EnterForumFragment.this.hCj != null) {
                    EnterForumFragment.this.hCj.bHD();
                }
            }
        }
    };
    final CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.cjx()) {
                com.baidu.tieba.enterForum.model.b.cjy();
            }
        }
    };

    public ObservedChangeLinearLayout ciN() {
        return this.hCl;
    }

    private void ch(View view) {
        this.bsG = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fFC = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.hCk = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.hCl = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.hCi = new a(this);
        this.hCi.setPageUniqueId(getUniqueId());
        this.fFC.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.hCi.nH(z);
                if (EnterForumFragment.this.ciO() != null) {
                    EnterForumFragment.this.ciO().cjd();
                }
            }
        });
        this.bsG.addView(this.hCi.getView(), 0);
        this.hCi.aKp();
        View findViewById = this.bsG.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.bsG.removeView(findViewById);
            this.bsG.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hCi.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.hCj = cVar;
    }

    public c ciO() {
        return this.hCj;
    }

    public void ciP() {
        ciQ();
        if (this.hCi != null) {
            this.hCi.loadData();
        }
    }

    private void ciQ() {
        if (this.hCi != null) {
            this.hCi.nI(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            ciP();
            if (this.hCi != null) {
                refreshImage(this.hCi.getView());
            }
            com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
        }
        if (this.hCi != null) {
            this.hCi.onPrimary();
        }
        if (ciO() != null) {
            ciO().cjd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.bsG, R.color.cp_bg_line_d);
        if (this.hCi != null) {
            this.hCi.onChangeSkinType(i);
        }
        if (this.fFC != null) {
            this.fFC.onChangeSkinType(getPageContext(), i);
        }
        if (this.hCk != null) {
            this.hCk.onChangeSkinType(getPageContext(), i);
        }
        if (this.hCm != null) {
            com.baidu.tbadk.r.a.a(getPageContext(), this.hCm);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        ch(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSyncFinishListener.setPriority(101);
        registerListener(this.mSyncFinishListener);
        registerListener(this.hCo);
        registerListener(this.hCp);
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hCi != null) {
            this.hCi.onDestroy();
        }
        this.hCj = null;
        MessageManager.getInstance().unRegisterListener(this.hCo);
        MessageManager.getInstance().unRegisterListener(this.hCp);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hCi != null) {
            this.hCi.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fFC != null && this.fFC.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fFC.update(false);
        }
    }

    public RelativeLayout ciR() {
        return this.bsG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hAz = cVar;
        this.hCj.setAdState(cVar);
    }

    public boolean ciS() {
        if (this.hCi == null || this.hCi.ciY() == null) {
            return true;
        }
        return this.hCi.ciY().ckj();
    }
}
