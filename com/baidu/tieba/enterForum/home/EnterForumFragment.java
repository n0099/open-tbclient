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
    private static List<String> cHE = new ArrayList();
    private RelativeLayout cHA;
    private ImageView cHB;
    private ObservedChangeLinearLayout cHC;
    private RelativeLayout cHD;
    final CustomMessageListener cHF = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.all()) {
                    d.alm();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.cHE.contains(currentAccount)) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.xV()) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.yc())) {
                        TiebaStatic.log(new al("c12594"));
                        EnterForumFragment.this.g(true, activityPrizeData.yc());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.g(false, null);
            }
        }
    };
    private a cHt;
    private ViewGroup cHu;
    private ImageView cHv;
    private TextView cHw;
    private View cHx;
    private NoNetworkView cHy;
    private PluginErrorTipView cHz;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout akE() {
        return this.cHC;
    }

    private void ak(View view2) {
        this.cHA = (RelativeLayout) view2.findViewById(d.g.enter_root_layout);
        al(view2);
        this.cHy = (NoNetworkView) view2.findViewById(d.g.view_no_network);
        this.cHz = (PluginErrorTipView) view2.findViewById(d.g.view_plugin_error_tip);
        this.cHC = (ObservedChangeLinearLayout) view2.findViewById(d.g.tab_layout);
        this.cHt = new a(this);
        this.cHy.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                EnterForumFragment.this.cHt.eY(z);
            }
        });
        this.cHA.addView(this.cHt.getView(), 0);
    }

    private void akF() {
        if (this.cHD == null) {
            ((ViewStub) this.cHA.findViewById(d.g.activity_prize_stub)).inflate();
            this.cHD = (RelativeLayout) this.cHA.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cHD.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.cHD.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.cHD);
            this.cHu = (ViewGroup) this.cHD.findViewById(d.g.activity_root_view);
            this.cHv = (ImageView) this.cHD.findViewById(d.g.activity_close_view);
            this.cHw = (TextView) this.cHD.findViewById(d.g.activity_tip_view);
            this.cHv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c12596"));
                    EnterForumFragment.cHE.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.g(false, null);
                }
            });
            this.cHu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String xY = TbadkCoreApplication.getInst().getActivityPrizeData().xY();
                    if (!StringUtils.isNull(xY)) {
                        TiebaStatic.log(new al("c12595"));
                        ax.wg().a(EnterForumFragment.this.getPageContext(), new String[]{xY}, true);
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
        this.cHB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cHB.getLayoutParams();
        layoutParams.setMargins(0, 0, l.e(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.cHB.setLayoutParams(layoutParams);
    }

    public void akG() {
        akI();
        if (this.cHt != null) {
            this.cHt.OT();
            if (this.cHt.akS()) {
                this.cHt.akR();
            }
        }
    }

    public boolean akH() {
        if (this.cHt != null) {
            return this.cHt.akS();
        }
        return false;
    }

    private void akI() {
        if (this.cHt != null) {
            this.cHt.fa(true);
        }
    }

    public void akJ() {
        if (!akH()) {
            ak.a(this.cHB, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            ak.a(this.cHB, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            akG();
            if (this.cHt != null) {
                refreshImage(this.cHt.getView());
            }
            if (this.cHt != null) {
                this.cHt.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.j(this.cHA, d.C0126d.cp_bg_line_d);
        if (this.cHt != null) {
            this.cHt.onChangeSkinType(i);
        }
        if (this.cHy != null) {
            this.cHy.onChangeSkinType(getPageContext(), i);
        }
        if (this.cHz != null) {
            this.cHz.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            ak.j(this.mNavigationBar, d.C0126d.cp_bg_line_d);
        }
        if (this.cHD != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.cHD);
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
        this.cHF.setPriority(101);
        registerListener(this.cHF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cHt != null) {
            this.cHt.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cHt != null) {
            this.cHt.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cHy != null && this.cHy.getVisibility() == 0 && j.gP()) {
            this.cHy.aL(false);
        }
    }

    public RelativeLayout akK() {
        return this.cHA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        if (z) {
            if (this.cHD == null) {
                akF();
            }
            if (this.cHx == null) {
                this.cHx = this.cHt.akN();
            }
            this.cHu.setVisibility(0);
            this.cHw.setText(str);
            return;
        }
        if (this.cHD != null) {
            this.cHu.setVisibility(8);
        }
        if (this.cHx != null) {
            this.cHt.am(this.cHx);
            this.cHx = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
