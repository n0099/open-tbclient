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
    private static List<String> cHH = new ArrayList();
    private View cHA;
    private NoNetworkView cHB;
    private PluginErrorTipView cHC;
    private RelativeLayout cHD;
    private ImageView cHE;
    private ObservedChangeLinearLayout cHF;
    private RelativeLayout cHG;
    final CustomMessageListener cHI = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.all()) {
                    d.alm();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.cHH.contains(currentAccount)) {
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
    private a cHw;
    private ViewGroup cHx;
    private ImageView cHy;
    private TextView cHz;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout akE() {
        return this.cHF;
    }

    private void ak(View view2) {
        this.cHD = (RelativeLayout) view2.findViewById(d.g.enter_root_layout);
        al(view2);
        this.cHB = (NoNetworkView) view2.findViewById(d.g.view_no_network);
        this.cHC = (PluginErrorTipView) view2.findViewById(d.g.view_plugin_error_tip);
        this.cHF = (ObservedChangeLinearLayout) view2.findViewById(d.g.tab_layout);
        this.cHw = new a(this);
        this.cHB.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                EnterForumFragment.this.cHw.eY(z);
            }
        });
        this.cHD.addView(this.cHw.getView(), 0);
    }

    private void akF() {
        if (this.cHG == null) {
            ((ViewStub) this.cHD.findViewById(d.g.activity_prize_stub)).inflate();
            this.cHG = (RelativeLayout) this.cHD.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cHG.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.cHG.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.cHG);
            this.cHx = (ViewGroup) this.cHG.findViewById(d.g.activity_root_view);
            this.cHy = (ImageView) this.cHG.findViewById(d.g.activity_close_view);
            this.cHz = (TextView) this.cHG.findViewById(d.g.activity_tip_view);
            this.cHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c12596"));
                    EnterForumFragment.cHH.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.g(false, null);
                }
            });
            this.cHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
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
        this.cHE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cHE.getLayoutParams();
        layoutParams.setMargins(0, 0, l.e(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.cHE.setLayoutParams(layoutParams);
    }

    public void akG() {
        akI();
        if (this.cHw != null) {
            this.cHw.OT();
            if (this.cHw.akS()) {
                this.cHw.akR();
            }
        }
    }

    public boolean akH() {
        if (this.cHw != null) {
            return this.cHw.akS();
        }
        return false;
    }

    private void akI() {
        if (this.cHw != null) {
            this.cHw.fa(true);
        }
    }

    public void akJ() {
        if (!akH()) {
            ak.a(this.cHE, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            ak.a(this.cHE, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            akG();
            if (this.cHw != null) {
                refreshImage(this.cHw.getView());
            }
            if (this.cHw != null) {
                this.cHw.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.j(this.cHD, d.C0126d.cp_bg_line_d);
        if (this.cHw != null) {
            this.cHw.onChangeSkinType(i);
        }
        if (this.cHB != null) {
            this.cHB.onChangeSkinType(getPageContext(), i);
        }
        if (this.cHC != null) {
            this.cHC.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            ak.j(this.mNavigationBar, d.C0126d.cp_bg_line_d);
        }
        if (this.cHG != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.cHG);
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
        this.cHI.setPriority(101);
        registerListener(this.cHI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cHw != null) {
            this.cHw.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cHw != null) {
            this.cHw.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cHB != null && this.cHB.getVisibility() == 0 && j.gP()) {
            this.cHB.aL(false);
        }
    }

    public RelativeLayout akK() {
        return this.cHD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        if (z) {
            if (this.cHG == null) {
                akF();
            }
            if (this.cHA == null) {
                this.cHA = this.cHw.akN();
            }
            this.cHx.setVisibility(0);
            this.cHz.setText(str);
            return;
        }
        if (this.cHG != null) {
            this.cHx.setVisibility(8);
        }
        if (this.cHA != null) {
            this.cHw.am(this.cHA);
            this.cHA = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
