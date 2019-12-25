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
/* loaded from: classes6.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> fPp = new ArrayList();
    private RelativeLayout axQ;
    private com.baidu.tieba.enterForum.data.b fNJ;
    private a fPj;
    private c fPk;
    private NoNetworkView fPl;
    private PluginErrorTipView fPm;
    private ObservedChangeLinearLayout fPn;
    private RelativeLayout fPo;
    private CustomMessageListener fPq = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.fPj != null) {
                EnterForumFragment.this.fPj.bvL();
            }
        }
    };
    private CustomMessageListener fPr = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.fPj != null) {
                    EnterForumFragment.this.fPj.ko(true);
                }
                if (EnterForumFragment.this.fPk != null) {
                    EnterForumFragment.this.fPk.aZX();
                }
            }
        }
    };
    final CustomMessageListener cDA = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.bwl()) {
                com.baidu.tieba.enterForum.model.b.bwm();
            }
        }
    };

    public ObservedChangeLinearLayout bvD() {
        return this.fPn;
    }

    private void bD(View view) {
        this.axQ = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.fPl = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.fPm = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.fPn = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.fPj = new a(this);
        this.fPj.setPageUniqueId(getUniqueId());
        this.fPl.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.fPj.ko(z);
                if (EnterForumFragment.this.bvE() != null) {
                    EnterForumFragment.this.bvE().bvT();
                }
            }
        });
        this.axQ.addView(this.fPj.getView(), 0);
        this.fPj.ahZ();
        View findViewById = this.axQ.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.axQ.removeView(findViewById);
            this.axQ.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fPj.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.fPk = cVar;
    }

    public c bvE() {
        return this.fPk;
    }

    public void tm() {
        bvF();
        if (this.fPj != null) {
            this.fPj.loadData();
        }
    }

    private void bvF() {
        if (this.fPj != null) {
            this.fPj.kq(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            tm();
            if (this.fPj != null) {
                refreshImage(this.fPj.getView());
            }
            com.baidu.tieba.r.c.cHo().b(getUniqueId(), false);
        }
        if (this.fPj != null) {
            this.fPj.onPrimary();
        }
        if (bvE() != null) {
            bvE().bvT();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.axQ, R.color.cp_bg_line_d);
        if (this.fPj != null) {
            this.fPj.onChangeSkinType(i);
        }
        if (this.fPl != null) {
            this.fPl.onChangeSkinType(getPageContext(), i);
        }
        if (this.fPm != null) {
            this.fPm.onChangeSkinType(getPageContext(), i);
        }
        if (this.fPo != null) {
            com.baidu.tbadk.q.a.a(getPageContext(), this.fPo);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bD(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cDA.setPriority(101);
        registerListener(this.cDA);
        registerListener(this.fPq);
        registerListener(this.fPr);
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fPj != null) {
            this.fPj.onDestroy();
        }
        this.fPk = null;
        MessageManager.getInstance().unRegisterListener(this.fPq);
        MessageManager.getInstance().unRegisterListener(this.fPr);
        MessageManager.getInstance().unRegisterListener(this.cDA);
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fPj != null) {
            this.fPj.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fPl != null && this.fPl.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.fPl.update(false);
        }
    }

    public RelativeLayout bvG() {
        return this.axQ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fNJ = bVar;
        this.fPk.setAdState(bVar);
    }
}
