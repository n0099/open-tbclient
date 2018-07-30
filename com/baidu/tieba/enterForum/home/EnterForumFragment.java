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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
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
    private static List<String> cSE = new ArrayList();
    final CustomMessageListener cIP = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.apm()) {
                    d.apn();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.cSE.contains(currentAccount)) {
                        EnterForumFragment.this.h(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.BD()) {
                        EnterForumFragment.this.h(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.BK())) {
                        TiebaStatic.log(new an("c12594"));
                        EnterForumFragment.this.h(true, activityPrizeData.BK());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.h(false, null);
            }
        }
    };
    private RelativeLayout cSA;
    private ImageView cSB;
    private ObservedChangeLinearLayout cSC;
    private RelativeLayout cSD;
    private a cSt;
    private ViewGroup cSu;
    private ImageView cSv;
    private TextView cSw;
    private View cSx;
    private NoNetworkView cSy;
    private PluginErrorTipView cSz;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout aoF() {
        return this.cSC;
    }

    private void ap(View view) {
        this.cSA = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        aq(view);
        this.cSy = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.cSz = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.cSC = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.cSt = new a(this);
        this.cSt.setPageUniqueId(getUniqueId());
        this.cSy.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aQ(boolean z) {
                EnterForumFragment.this.cSt.fe(z);
            }
        });
        this.cSA.addView(this.cSt.getView(), 0);
    }

    private void aoG() {
        if (this.cSD == null) {
            ((ViewStub) this.cSA.findViewById(d.g.activity_prize_stub)).inflate();
            this.cSD = (RelativeLayout) this.cSA.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cSD.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.cSD.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.cSD);
            this.cSu = (ViewGroup) this.cSD.findViewById(d.g.activity_root_view);
            this.cSv = (ImageView) this.cSD.findViewById(d.g.activity_close_view);
            this.cSw = (TextView) this.cSD.findViewById(d.g.activity_tip_view);
            this.cSv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12596"));
                    EnterForumFragment.cSE.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.h(false, null);
                }
            });
            this.cSu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String BG = TbadkCoreApplication.getInst().getActivityPrizeData().BG();
                    if (!StringUtils.isNull(BG)) {
                        TiebaStatic.log(new an("c12595"));
                        ay.zK().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{BG}, true);
                    }
                }
            });
        }
    }

    private void aq(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        am.j(this.mNavigationBar, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.cSB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.aoI()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ba.aU(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cSB.getLayoutParams();
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.cSB.setLayoutParams(layoutParams);
    }

    public void aoH() {
        aoJ();
        if (this.cSt != null) {
            this.cSt.SS();
            if (this.cSt.aoT()) {
                this.cSt.aoS();
            }
        }
    }

    public boolean aoI() {
        if (this.cSt != null) {
            return this.cSt.aoT();
        }
        return false;
    }

    private void aoJ() {
        if (this.cSt != null) {
            this.cSt.fg(true);
        }
    }

    public void aoK() {
        if (!aoI()) {
            am.a(this.cSB, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            am.a(this.cSB, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aoH();
            if (this.cSt != null) {
                refreshImage(this.cSt.getView());
            }
            if (this.cSt != null) {
                this.cSt.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.j(this.cSA, d.C0140d.cp_bg_line_d);
        if (this.cSt != null) {
            this.cSt.onChangeSkinType(i);
        }
        if (this.cSy != null) {
            this.cSy.onChangeSkinType(getPageContext(), i);
        }
        if (this.cSz != null) {
            this.cSz.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            am.j(this.mNavigationBar, d.C0140d.cp_bg_line_d);
        }
        if (this.cSD != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.cSD);
        }
        aoK();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_enter_forum, viewGroup, false);
        ap(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cIP.setPriority(101);
        registerListener(this.cIP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cSt != null) {
            this.cSt.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cSt != null) {
            this.cSt.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cSy != null && this.cSy.getVisibility() == 0 && j.jE()) {
            this.cSy.aP(false);
        }
    }

    public RelativeLayout aoL() {
        return this.cSA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, String str) {
        if (z) {
            if (this.cSD == null) {
                aoG();
            }
            if (this.cSx == null) {
                this.cSx = this.cSt.aoO();
            }
            this.cSu.setVisibility(0);
            this.cSw.setText(str);
            return;
        }
        if (this.cSD != null) {
            this.cSu.setVisibility(8);
        }
        if (this.cSx != null) {
            this.cSt.ar(this.cSx);
            this.cSx = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
