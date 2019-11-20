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
/* loaded from: classes4.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> faJ = new ArrayList();
    private RelativeLayout aqa;
    private com.baidu.tieba.enterForum.data.b eZb;
    private a faD;
    private c faE;
    private NoNetworkView faF;
    private PluginErrorTipView faG;
    private ObservedChangeLinearLayout faH;
    private RelativeLayout faI;
    private CustomMessageListener faK = new CustomMessageListener(2001629) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity() && EnterForumFragment.this.faD != null) {
                EnterForumFragment.this.faD.bep();
            }
        }
    };
    private CustomMessageListener faL = new CustomMessageListener(2001631) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.faD != null) {
                    EnterForumFragment.this.faD.jc(true);
                }
                if (EnterForumFragment.this.faE != null) {
                    EnterForumFragment.this.faE.aJz();
                }
            }
        }
    };
    final CustomMessageListener bRa = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && com.baidu.tieba.enterForum.model.b.beR()) {
                com.baidu.tieba.enterForum.model.b.beS();
            }
        }
    };

    public ObservedChangeLinearLayout beh() {
        return this.faH;
    }

    private void bI(View view) {
        this.aqa = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.faF = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.faG = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.faH = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        this.faD = new a(this);
        this.faD.setPageUniqueId(getUniqueId());
        this.faF.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                EnterForumFragment.this.faD.jc(z);
                if (EnterForumFragment.this.bei() != null) {
                    EnterForumFragment.this.bei().bey();
                }
            }
        });
        this.aqa.addView(this.faD.getView(), 0);
        this.faD.beq();
        View findViewById = this.aqa.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.aqa.removeView(findViewById);
            this.aqa.addView(findViewById, 0);
        }
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.faD.loadData();
        }
    }

    public void setTabViewController(c cVar) {
        this.faE = cVar;
    }

    public c bei() {
        return this.faE;
    }

    public void ry() {
        bej();
        if (this.faD != null) {
            this.faD.loadData();
        }
    }

    private void bej() {
        if (this.faD != null) {
            this.faD.je(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            ry();
            if (this.faD != null) {
                refreshImage(this.faD.getView());
            }
            com.baidu.tieba.q.c.cni().b(getUniqueId(), false);
        }
        if (this.faD != null) {
            this.faD.onPrimary();
        }
        if (bei() != null) {
            bei().bey();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.aqa, R.color.cp_bg_line_d);
        if (this.faD != null) {
            this.faD.onChangeSkinType(i);
        }
        if (this.faF != null) {
            this.faF.onChangeSkinType(getPageContext(), i);
        }
        if (this.faG != null) {
            this.faG.onChangeSkinType(getPageContext(), i);
        }
        if (this.faI != null) {
            com.baidu.tbadk.s.a.a(getPageContext(), this.faI);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        bI(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.q.c.cni().v(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bRa.setPriority(101);
        registerListener(this.bRa);
        registerListener(this.faK);
        registerListener(this.faL);
        com.baidu.tieba.q.c.cni().v(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.faD != null) {
            this.faD.onDestroy();
        }
        this.faE = null;
        MessageManager.getInstance().unRegisterListener(this.faK);
        MessageManager.getInstance().unRegisterListener(this.faL);
        MessageManager.getInstance().unRegisterListener(this.bRa);
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.faD != null) {
            this.faD.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.faF != null && this.faF.getVisibility() == 0 && j.isNetWorkAvailable()) {
            this.faF.update(false);
        }
    }

    public RelativeLayout bek() {
        return this.aqa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eZb = bVar;
        this.faE.setAdState(bVar);
    }
}
