package com.baidu.tieba.enterForum.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> cIN = new ArrayList();
    private a cIC;
    private ViewGroup cID;
    private ImageView cIE;
    private TextView cIF;
    private View cIG;
    private NoNetworkView cIH;
    private PluginErrorTipView cII;
    private RelativeLayout cIJ;
    private ImageView cIK;
    private ObservedChangeLinearLayout cIL;
    private RelativeLayout cIM;
    final CustomMessageListener cIO = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.all()) {
                    d.alm();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.cIN.contains(currentAccount)) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.xU()) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.yb())) {
                        TiebaStatic.log(new al("c12594"));
                        EnterForumFragment.this.g(true, activityPrizeData.yb());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.g(false, null);
            }
        }
    };
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout akE() {
        return this.cIL;
    }

    private void ak(View view2) {
        this.cIJ = (RelativeLayout) view2.findViewById(d.g.enter_root_layout);
        al(view2);
        this.cIH = (NoNetworkView) view2.findViewById(d.g.view_no_network);
        this.cII = (PluginErrorTipView) view2.findViewById(d.g.view_plugin_error_tip);
        this.cIL = (ObservedChangeLinearLayout) view2.findViewById(d.g.tab_layout);
        this.cIC = new a(this);
        this.cIH.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                EnterForumFragment.this.cIC.eZ(z);
            }
        });
        this.cIJ.addView(this.cIC.getView(), 0);
    }

    private void akF() {
        if (this.cIM == null) {
            ((ViewStub) this.cIJ.findViewById(d.g.activity_prize_stub)).inflate();
            this.cIM = (RelativeLayout) this.cIJ.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cIM.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.cIM.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.cIM);
            this.cID = (ViewGroup) this.cIM.findViewById(d.g.activity_root_view);
            this.cIE = (ImageView) this.cIM.findViewById(d.g.activity_close_view);
            this.cIF = (TextView) this.cIM.findViewById(d.g.activity_tip_view);
            this.cIE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c12596"));
                    EnterForumFragment.cIN.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.g(false, null);
                }
            });
            this.cID.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String xX = TbadkCoreApplication.getInst().getActivityPrizeData().xX();
                    if (!StringUtils.isNull(xX)) {
                        TiebaStatic.log(new al("c12595"));
                        ax.wf().a(EnterForumFragment.this.getPageContext(), new String[]{xX}, true);
                    }
                }
            });
        }
    }

    private void al(View view2) {
        this.mNavigationBar = (NavigationBar) view2.findViewById(d.g.enter_forum_navigation_bar);
        ak.j(this.mNavigationBar, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.cIK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (!EnterForumFragment.this.akH()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        az.aJ(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cIK.getLayoutParams();
        layoutParams.setMargins(0, 0, l.e(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.cIK.setLayoutParams(layoutParams);
    }

    public void akG() {
        akI();
        if (this.cIC != null) {
            this.cIC.OQ();
            if (this.cIC.akS()) {
                this.cIC.akR();
            }
        }
    }

    public boolean akH() {
        if (this.cIC != null) {
            return this.cIC.akS();
        }
        return false;
    }

    private void akI() {
        if (this.cIC != null) {
            this.cIC.fb(true);
        }
    }

    public void akJ() {
        if (!akH()) {
            ak.a(this.cIK, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            ak.a(this.cIK, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            akG();
            if (this.cIC != null) {
                refreshImage(this.cIC.getView());
            }
            if (this.cIC != null) {
                this.cIC.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.j(this.cIJ, d.C0126d.cp_bg_line_d);
        if (this.cIC != null) {
            this.cIC.onChangeSkinType(i);
        }
        if (this.cIH != null) {
            this.cIH.onChangeSkinType(getPageContext(), i);
        }
        if (this.cII != null) {
            this.cII.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            ak.j(this.mNavigationBar, d.C0126d.cp_bg_line_d);
        }
        if (this.cIM != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.cIM);
        }
        akJ();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.fragment_enter_forum, viewGroup, false);
        ak(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cIO.setPriority(101);
        registerListener(this.cIO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cIC != null) {
            this.cIC.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cIC != null) {
            this.cIC.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cIH != null && this.cIH.getVisibility() == 0 && j.gP()) {
            this.cIH.aL(false);
        }
    }

    public RelativeLayout akK() {
        return this.cIJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        if (z) {
            if (this.cIM == null) {
                akF();
            }
            if (this.cIG == null) {
                this.cIG = this.cIC.akN();
            }
            this.cID.setVisibility(0);
            this.cIF.setText(str);
            return;
        }
        if (this.cIM != null) {
            this.cID.setVisibility(8);
        }
        if (this.cIG != null) {
            this.cIC.am(this.cIG);
            this.cIG = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
