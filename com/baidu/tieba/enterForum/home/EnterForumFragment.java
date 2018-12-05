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
    private static List<String> dov = new ArrayList();
    final CustomMessageListener deM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.avG()) {
                    d.avH();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.dov.contains(currentAccount)) {
                        EnterForumFragment.this.f(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.Gh()) {
                        EnterForumFragment.this.f(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.Go())) {
                        TiebaStatic.log(new am("c12594"));
                        EnterForumFragment.this.f(true, activityPrizeData.Go());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.f(false, null);
            }
        }
    };
    private a dok;
    private ViewGroup dol;
    private ImageView dom;
    private TextView don;
    private View doo;
    private NoNetworkView dop;
    private PluginErrorTipView doq;
    private RelativeLayout dor;
    private ImageView dos;
    private ObservedChangeLinearLayout dot;
    private RelativeLayout dou;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout avc() {
        return this.dot;
    }

    private void aF(View view) {
        this.dor = (RelativeLayout) view.findViewById(e.g.enter_root_layout);
        aG(view);
        this.dop = (NoNetworkView) view.findViewById(e.g.view_no_network);
        this.doq = (PluginErrorTipView) view.findViewById(e.g.view_plugin_error_tip);
        this.dot = (ObservedChangeLinearLayout) view.findViewById(e.g.tab_layout);
        this.dok = new a(this);
        this.dok.setPageUniqueId(getUniqueId());
        this.dop.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bF(boolean z) {
                EnterForumFragment.this.dok.fY(z);
            }
        });
        this.dor.addView(this.dok.getView(), 0);
    }

    private void avd() {
        if (this.dou == null) {
            ((ViewStub) this.dor.findViewById(e.g.activity_prize_stub)).inflate();
            this.dou = (RelativeLayout) this.dor.findViewById(e.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dou.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.dou.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.dou);
            this.dol = (ViewGroup) this.dou.findViewById(e.g.activity_root_view);
            this.dom = (ImageView) this.dou.findViewById(e.g.activity_close_view);
            this.don = (TextView) this.dou.findViewById(e.g.activity_tip_view);
            this.dom.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12596"));
                    EnterForumFragment.dov.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.f(false, null);
                }
            });
            this.dol.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String Gk = TbadkCoreApplication.getInst().getActivityPrizeData().Gk();
                    if (!StringUtils.isNull(Gk)) {
                        TiebaStatic.log(new am("c12595"));
                        ay.Ef().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{Gk}, true);
                    }
                }
            });
        }
    }

    private void aG(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.enter_forum_navigation_bar);
        al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.dos = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.avf()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ba.bI(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dos.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), e.C0210e.tbds44), 0);
        this.dos.setLayoutParams(layoutParams);
    }

    public void ave() {
        avg();
        if (this.dok != null) {
            this.dok.loadData();
            if (this.dok.avq()) {
                this.dok.avp();
            }
        }
    }

    public boolean avf() {
        if (this.dok != null) {
            return this.dok.avq();
        }
        return false;
    }

    private void avg() {
        if (this.dok != null) {
            this.dok.ga(true);
        }
    }

    public void avh() {
        if (!avf()) {
            al.a(this.dos, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
        } else {
            al.a(this.dos, e.f.icon_topbar_sign_s, e.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            ave();
            if (this.dok != null) {
                refreshImage(this.dok.getView());
            }
            if (this.dok != null) {
                this.dok.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.dor, e.d.cp_bg_line_d);
        if (this.dok != null) {
            this.dok.onChangeSkinType(i);
        }
        if (this.dop != null) {
            this.dop.onChangeSkinType(getPageContext(), i);
        }
        if (this.doq != null) {
            this.doq.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        }
        if (this.dou != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.dou);
        }
        avh();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.fragment_enter_forum, viewGroup, false);
        aF(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.deM.setPriority(101);
        registerListener(this.deM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dok != null) {
            this.dok.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dok != null) {
            this.dok.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dop != null && this.dop.getVisibility() == 0 && j.kV()) {
            this.dop.bE(false);
        }
    }

    public RelativeLayout avi() {
        return this.dor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        if (z) {
            if (this.dou == null) {
                avd();
            }
            if (this.doo == null) {
                this.doo = this.dok.avl();
            }
            this.dol.setVisibility(0);
            this.don.setText(str);
            return;
        }
        if (this.dou != null) {
            this.dol.setVisibility(8);
        }
        if (this.doo != null) {
            this.dok.aH(this.doo);
            this.doo = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
