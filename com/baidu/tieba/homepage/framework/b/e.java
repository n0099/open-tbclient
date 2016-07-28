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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d.c;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e {
    private ObservedChangeLinearLayout bvn;
    private ImageView csA;
    private ImageView csB;
    private a csC;
    private com.baidu.tieba.d.c csD;
    private ImageView csz;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener csE = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener csF = new g(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private View.OnTouchListener aGS = new h(this);
    private c.InterfaceC0055c aZA = new i(this);

    public a ahn() {
        return this.csC;
    }

    public View.OnTouchListener aho() {
        return this.aGS;
    }

    public ObservedChangeLinearLayout SF() {
        return this.bvn;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bvn = observedChangeLinearLayout;
        as(view);
        this.csC = new a(context, observedChangeLinearLayout, view2);
        this.csD = new com.baidu.tieba.d.c(context);
        this.csD.a(this.aZA);
        ahp();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.csF.setTag(bdUniqueId);
        this.csE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.csF);
        MessageManager.getInstance().registerListener(this.csE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahp() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m10getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                eA(true);
                long j = com.baidu.tbadk.core.sharedPref.b.sN().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.sN().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                ez(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            eA(false);
            ez(false);
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("game_is_show_tip", false);
        }
    }

    public boolean ahq() {
        return this.csz != null && this.csz.getVisibility() == 0;
    }

    public void ez(boolean z) {
        if (z) {
            if (this.csA.getVisibility() != 0) {
                this.csA.setVisibility(0);
                eB(true);
                av.c(this.csA, u.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eB(false);
        this.csA.setVisibility(8);
    }

    public void eA(boolean z) {
        if (this.csz != null) {
            if (z) {
                this.csz.setVisibility(0);
            } else {
                this.csz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.csz.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds20);
            }
            this.csz.setLayoutParams(layoutParams);
        }
    }

    private void as(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(u.g.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.game_tip_view, (View.OnClickListener) null);
        this.csz = (ImageView) addCustomView.findViewById(u.g.game_button_iv);
        this.csA = (ImageView) addCustomView.findViewById(u.g.game_tip_msg_iv);
        this.csz.setOnClickListener(new j(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds16), 0);
        this.csB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_search, (View.OnClickListener) null);
        this.csB.setLayoutParams(layoutParams);
        this.csB.setOnClickListener(new k(this));
        this.mNavigationBar.setLoginClickListener(new l(this));
        this.mNavigationBar.setRegisterClickListener(new m(this));
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.mContext);
        if (s != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(s, i);
        }
        av.c(this.csA, u.f.icon_news_down_bar_one);
        av.b(this.csz, u.f.icon_game_bg_s, u.f.icon_game_bg);
        av.b(this.csB, u.f.icon_search_bg_s, u.f.icon_search_bg);
        av.a(this.mCenterIcon, u.f.icon_home_logo, u.f.s_icon_home_logo, u.f.icon_home_logo, TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void onDestroy() {
        if (this.csC != null) {
            this.csC.Xz();
        }
    }
}
