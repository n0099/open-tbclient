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
    private static List<String> drU = new ArrayList();
    final CustomMessageListener dio = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.awS()) {
                    d.awT();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.drU.contains(currentAccount)) {
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
    private a drJ;
    private ViewGroup drK;
    private ImageView drL;
    private TextView drM;
    private View drN;
    private NoNetworkView drO;
    private PluginErrorTipView drP;
    private RelativeLayout drQ;
    private ImageView drR;
    private ObservedChangeLinearLayout drS;
    private RelativeLayout drT;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout awo() {
        return this.drS;
    }

    private void aI(View view) {
        this.drQ = (RelativeLayout) view.findViewById(e.g.enter_root_layout);
        aJ(view);
        this.drO = (NoNetworkView) view.findViewById(e.g.view_no_network);
        this.drP = (PluginErrorTipView) view.findViewById(e.g.view_plugin_error_tip);
        this.drS = (ObservedChangeLinearLayout) view.findViewById(e.g.tab_layout);
        this.drJ = new a(this);
        this.drJ.setPageUniqueId(getUniqueId());
        this.drO.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bG(boolean z) {
                EnterForumFragment.this.drJ.gd(z);
            }
        });
        this.drQ.addView(this.drJ.getView(), 0);
    }

    private void awp() {
        if (this.drT == null) {
            ((ViewStub) this.drQ.findViewById(e.g.activity_prize_stub)).inflate();
            this.drT = (RelativeLayout) this.drQ.findViewById(e.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.drT.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.drT.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.drT);
            this.drK = (ViewGroup) this.drT.findViewById(e.g.activity_root_view);
            this.drL = (ImageView) this.drT.findViewById(e.g.activity_close_view);
            this.drM = (TextView) this.drT.findViewById(e.g.activity_tip_view);
            this.drL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12596"));
                    EnterForumFragment.drU.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.f(false, null);
                }
            });
            this.drK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
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
        this.drR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.drR.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), e.C0210e.tbds44), 0);
        this.drR.setLayoutParams(layoutParams);
    }

    public void awq() {
        aws();
        if (this.drJ != null) {
            this.drJ.loadData();
            if (this.drJ.awC()) {
                this.drJ.awB();
            }
        }
    }

    public boolean awr() {
        if (this.drJ != null) {
            return this.drJ.awC();
        }
        return false;
    }

    private void aws() {
        if (this.drJ != null) {
            this.drJ.gf(true);
        }
    }

    public void awt() {
        if (!awr()) {
            al.a(this.drR, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
        } else {
            al.a(this.drR, e.f.icon_topbar_sign_s, e.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            awq();
            if (this.drJ != null) {
                refreshImage(this.drJ.getView());
            }
            if (this.drJ != null) {
                this.drJ.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.drQ, e.d.cp_bg_line_d);
        if (this.drJ != null) {
            this.drJ.onChangeSkinType(i);
        }
        if (this.drO != null) {
            this.drO.onChangeSkinType(getPageContext(), i);
        }
        if (this.drP != null) {
            this.drP.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        }
        if (this.drT != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.drT);
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
        this.dio.setPriority(101);
        registerListener(this.dio);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.drJ != null) {
            this.drJ.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.drJ != null) {
            this.drJ.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.drO != null && this.drO.getVisibility() == 0 && j.kV()) {
            this.drO.bF(false);
        }
    }

    public RelativeLayout awu() {
        return this.drQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        if (z) {
            if (this.drT == null) {
                awp();
            }
            if (this.drN == null) {
                this.drN = this.drJ.awx();
            }
            this.drK.setVisibility(0);
            this.drM.setText(str);
            return;
        }
        if (this.drT != null) {
            this.drK.setVisibility(8);
        }
        if (this.drN != null) {
            this.drJ.aK(this.drN);
            this.drN = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
