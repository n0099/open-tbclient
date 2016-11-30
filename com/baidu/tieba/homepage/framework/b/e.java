package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private ImageView aXq;
    private ObservedChangeLinearLayout bJF;
    private ImageView cJA;
    private a cJB;
    private com.baidu.tieba.d.c cJC;
    private ImageView cJz;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener cJD = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cJE = new g(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private View.OnTouchListener aKw = new h(this);
    private a.InterfaceC0058a aMT = new i(this);

    public a aoh() {
        return this.cJB;
    }

    public View.OnTouchListener aoi() {
        return this.aKw;
    }

    public ObservedChangeLinearLayout YN() {
        return this.bJF;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bJF = observedChangeLinearLayout;
        ar(view);
        this.cJB = new a(context, observedChangeLinearLayout, view2);
        this.cJC = new com.baidu.tieba.d.c(context);
        this.cJC.a(this.aMT);
        aoj();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cJE.setTag(bdUniqueId);
        this.cJD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cJE);
        MessageManager.getInstance().registerListener(this.cJD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoj() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                fm(true);
                long j = com.baidu.tbadk.core.sharedPref.b.um().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.um().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.um().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.um().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                fl(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            fm(false);
            fl(false);
            com.baidu.tbadk.core.sharedPref.b.um().putBoolean("game_is_show_tip", false);
        }
    }

    public boolean aok() {
        return this.cJz != null && this.cJz.getVisibility() == 0;
    }

    public void fl(boolean z) {
        if (z) {
            if (this.cJA.getVisibility() != 0) {
                this.cJA.setVisibility(0);
                fn(true);
                at.c(this.cJA, r.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        fn(false);
        this.cJA.setVisibility(8);
    }

    public void fm(boolean z) {
        if (this.cJz != null) {
            if (z) {
                this.cJz.setVisibility(0);
            } else {
                this.cJz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cJz.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds20);
            }
            this.cJz.setLayoutParams(layoutParams);
        }
    }

    private void ar(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(r.g.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.game_tip_view, (View.OnClickListener) null);
        this.cJz = (ImageView) addCustomView.findViewById(r.g.game_button_iv);
        this.cJA = (ImageView) addCustomView.findViewById(r.g.game_tip_msg_iv);
        this.cJz.setOnClickListener(new j(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds16), 0);
        this.aXq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_search, (View.OnClickListener) null);
        this.aXq.setLayoutParams(layoutParams);
        this.aXq.setOnClickListener(new k(this));
        this.mNavigationBar.setLoginClickListener(new l(this));
        this.mNavigationBar.setRegisterClickListener(new m(this));
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
        if (C != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(C, i);
        }
        at.c(this.cJA, r.f.icon_news_down_bar_one);
        at.b(this.cJz, r.f.icon_game_bg_s, r.f.icon_game_bg);
        at.b(this.aXq, r.f.icon_search_bg_s, r.f.icon_search_bg);
        at.a(this.mCenterIcon, r.f.icon_home_logo, r.f.s_icon_home_logo, r.f.icon_home_logo, i);
    }

    public void onDestroy() {
        if (this.cJB != null) {
            this.cJB.aac();
        }
    }
}
