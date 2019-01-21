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
    private static List<String> drV = new ArrayList();
    final CustomMessageListener dip = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.awS()) {
                    d.awT();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.drV.contains(currentAccount)) {
                        EnterForumFragment.this.f(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.Gv()) {
                        EnterForumFragment.this.f(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.GC())) {
                        TiebaStatic.log(new am("c12594"));
                        EnterForumFragment.this.f(true, activityPrizeData.GC());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.f(false, null);
            }
        }
    };
    private a drK;
    private ViewGroup drL;
    private ImageView drM;
    private TextView drN;
    private View drO;
    private NoNetworkView drP;
    private PluginErrorTipView drQ;
    private RelativeLayout drR;
    private ImageView drS;
    private ObservedChangeLinearLayout drT;
    private RelativeLayout drU;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout awo() {
        return this.drT;
    }

    private void aI(View view) {
        this.drR = (RelativeLayout) view.findViewById(e.g.enter_root_layout);
        aJ(view);
        this.drP = (NoNetworkView) view.findViewById(e.g.view_no_network);
        this.drQ = (PluginErrorTipView) view.findViewById(e.g.view_plugin_error_tip);
        this.drT = (ObservedChangeLinearLayout) view.findViewById(e.g.tab_layout);
        this.drK = new a(this);
        this.drK.setPageUniqueId(getUniqueId());
        this.drP.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bG(boolean z) {
                EnterForumFragment.this.drK.gd(z);
            }
        });
        this.drR.addView(this.drK.getView(), 0);
    }

    private void awp() {
        if (this.drU == null) {
            ((ViewStub) this.drR.findViewById(e.g.activity_prize_stub)).inflate();
            this.drU = (RelativeLayout) this.drR.findViewById(e.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.drU.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.drU.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.drU);
            this.drL = (ViewGroup) this.drU.findViewById(e.g.activity_root_view);
            this.drM = (ImageView) this.drU.findViewById(e.g.activity_close_view);
            this.drN = (TextView) this.drU.findViewById(e.g.activity_tip_view);
            this.drM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12596"));
                    EnterForumFragment.drV.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.f(false, null);
                }
            });
            this.drL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String Gy = TbadkCoreApplication.getInst().getActivityPrizeData().Gy();
                    if (!StringUtils.isNull(Gy)) {
                        TiebaStatic.log(new am("c12595"));
                        ay.Es().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{Gy}, true);
                    }
                }
            });
        }
    }

    private void aJ(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.enter_forum_navigation_bar);
        al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.drS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.awr()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ba.bI(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.drS.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), e.C0210e.tbds44), 0);
        this.drS.setLayoutParams(layoutParams);
    }

    public void awq() {
        aws();
        if (this.drK != null) {
            this.drK.loadData();
            if (this.drK.awC()) {
                this.drK.awB();
            }
        }
    }

    public boolean awr() {
        if (this.drK != null) {
            return this.drK.awC();
        }
        return false;
    }

    private void aws() {
        if (this.drK != null) {
            this.drK.gf(true);
        }
    }

    public void awt() {
        if (!awr()) {
            al.a(this.drS, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
        } else {
            al.a(this.drS, e.f.icon_topbar_sign_s, e.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            awq();
            if (this.drK != null) {
                refreshImage(this.drK.getView());
            }
            if (this.drK != null) {
                this.drK.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.drR, e.d.cp_bg_line_d);
        if (this.drK != null) {
            this.drK.onChangeSkinType(i);
        }
        if (this.drP != null) {
            this.drP.onChangeSkinType(getPageContext(), i);
        }
        if (this.drQ != null) {
            this.drQ.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        }
        if (this.drU != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.drU);
        }
        awt();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.fragment_enter_forum, viewGroup, false);
        aI(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dip.setPriority(101);
        registerListener(this.dip);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.drK != null) {
            this.drK.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.drK != null) {
            this.drK.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.drP != null && this.drP.getVisibility() == 0 && j.kV()) {
            this.drP.bF(false);
        }
    }

    public RelativeLayout awu() {
        return this.drR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        if (z) {
            if (this.drU == null) {
                awp();
            }
            if (this.drO == null) {
                this.drO = this.drK.awx();
            }
            this.drL.setVisibility(0);
            this.drN.setText(str);
            return;
        }
        if (this.drU != null) {
            this.drL.setVisibility(8);
        }
        if (this.drO != null) {
            this.drK.aK(this.drO);
            this.drO = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
