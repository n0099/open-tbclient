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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> dgI = new ArrayList();
    final CustomMessageListener cWU = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.auw()) {
                    d.aux();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.dgI.contains(currentAccount)) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.ES()) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.EZ())) {
                        TiebaStatic.log(new am("c12594"));
                        EnterForumFragment.this.g(true, activityPrizeData.EZ());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.g(false, null);
            }
        }
    };
    private TextView dgA;
    private View dgB;
    private NoNetworkView dgC;
    private PluginErrorTipView dgD;
    private RelativeLayout dgE;
    private ImageView dgF;
    private ObservedChangeLinearLayout dgG;
    private RelativeLayout dgH;
    private a dgx;
    private ViewGroup dgy;
    private ImageView dgz;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout atQ() {
        return this.dgG;
    }

    private void aD(View view) {
        this.dgE = (RelativeLayout) view.findViewById(e.g.enter_root_layout);
        aE(view);
        this.dgC = (NoNetworkView) view.findViewById(e.g.view_no_network);
        this.dgD = (PluginErrorTipView) view.findViewById(e.g.view_plugin_error_tip);
        this.dgG = (ObservedChangeLinearLayout) view.findViewById(e.g.tab_layout);
        this.dgx = new a(this);
        this.dgx.setPageUniqueId(getUniqueId());
        this.dgC.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bn(boolean z) {
                EnterForumFragment.this.dgx.fN(z);
            }
        });
        this.dgE.addView(this.dgx.getView(), 0);
    }

    private void atR() {
        if (this.dgH == null) {
            ((ViewStub) this.dgE.findViewById(e.g.activity_prize_stub)).inflate();
            this.dgH = (RelativeLayout) this.dgE.findViewById(e.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dgH.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.dgH.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.dgH);
            this.dgy = (ViewGroup) this.dgH.findViewById(e.g.activity_root_view);
            this.dgz = (ImageView) this.dgH.findViewById(e.g.activity_close_view);
            this.dgA = (TextView) this.dgH.findViewById(e.g.activity_tip_view);
            this.dgz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12596"));
                    EnterForumFragment.dgI.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.g(false, null);
                }
            });
            this.dgy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String EV = TbadkCoreApplication.getInst().getActivityPrizeData().EV();
                    if (!StringUtils.isNull(EV)) {
                        TiebaStatic.log(new am("c12595"));
                        ay.CU().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{EV}, true);
                    }
                }
            });
        }
    }

    private void aE(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.enter_forum_navigation_bar);
        al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.dgF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.atT()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ba.bH(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgF.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), e.C0175e.tbds44), 0);
        this.dgF.setLayoutParams(layoutParams);
    }

    public void atS() {
        atU();
        if (this.dgx != null) {
            this.dgx.loadData();
            if (this.dgx.aue()) {
                this.dgx.aud();
            }
        }
    }

    public boolean atT() {
        if (this.dgx != null) {
            return this.dgx.aue();
        }
        return false;
    }

    private void atU() {
        if (this.dgx != null) {
            this.dgx.fP(true);
        }
    }

    public void atV() {
        if (!atT()) {
            al.a(this.dgF, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
        } else {
            al.a(this.dgF, e.f.icon_topbar_sign_s, e.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            atS();
            if (this.dgx != null) {
                refreshImage(this.dgx.getView());
            }
            if (this.dgx != null) {
                this.dgx.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.dgE, e.d.cp_bg_line_d);
        if (this.dgx != null) {
            this.dgx.onChangeSkinType(i);
        }
        if (this.dgC != null) {
            this.dgC.onChangeSkinType(getPageContext(), i);
        }
        if (this.dgD != null) {
            this.dgD.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        }
        if (this.dgH != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.dgH);
        }
        atV();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.fragment_enter_forum, viewGroup, false);
        aD(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cWU.setPriority(101);
        registerListener(this.cWU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dgx != null) {
            this.dgx.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dgx != null) {
            this.dgx.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dgC != null && this.dgC.getVisibility() == 0 && j.kX()) {
            this.dgC.bm(false);
        }
    }

    public RelativeLayout atW() {
        return this.dgE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        if (z) {
            if (this.dgH == null) {
                atR();
            }
            if (this.dgB == null) {
                this.dgB = this.dgx.atZ();
            }
            this.dgy.setVisibility(0);
            this.dgA.setText(str);
            return;
        }
        if (this.dgH != null) {
            this.dgy.setVisibility(8);
        }
        if (this.dgB != null) {
            this.dgx.aF(this.dgB);
            this.dgB = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
