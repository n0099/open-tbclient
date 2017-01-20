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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.f.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private ImageView aSh;
    private ObservedChangeLinearLayout bxv;
    private ImageView cvW;
    private ImageView cvX;
    private a cvY;
    private com.baidu.tieba.f.c cvZ;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener cwa = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cwb = new g(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private View.OnTouchListener aIu = new h(this);
    private a.InterfaceC0057a aLl = new i(this);

    public a ajP() {
        return this.cvY;
    }

    public View.OnTouchListener ajQ() {
        return this.aIu;
    }

    public ObservedChangeLinearLayout Ut() {
        return this.bxv;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bxv = observedChangeLinearLayout;
        aw(view);
        this.cvY = new a(context, observedChangeLinearLayout, view2);
        this.cvZ = new com.baidu.tieba.f.c(context);
        this.cvZ.a(this.aLl);
        ajR();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cwb.setTag(bdUniqueId);
        this.cwa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cwb);
        MessageManager.getInstance().registerListener(this.cwa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajR() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                fb(true);
                long j = com.baidu.tbadk.core.sharedPref.b.tQ().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.tQ().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                fa(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            fb(false);
            fa(false);
            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("game_is_show_tip", false);
        }
    }

    public boolean ajS() {
        return this.cvW != null && this.cvW.getVisibility() == 0;
    }

    public void fa(boolean z) {
        if (z) {
            if (this.cvX.getVisibility() != 0) {
                this.cvX.setVisibility(0);
                fc(true);
                ap.c(this.cvX, r.g.icon_news_down_bar_one);
                return;
            }
            return;
        }
        fc(false);
        this.cvX.setVisibility(8);
    }

    public void fb(boolean z) {
        if (this.cvW != null) {
            if (z) {
                this.cvW.setVisibility(0);
            } else {
                this.cvW.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cvW.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds20);
            }
            this.cvW.setLayoutParams(layoutParams);
        }
    }

    private void aw(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(r.h.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.game_tip_view, (View.OnClickListener) null);
        this.cvW = (ImageView) addCustomView.findViewById(r.h.game_button_iv);
        this.cvX = (ImageView) addCustomView.findViewById(r.h.game_tip_msg_iv);
        this.cvW.setOnClickListener(new j(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds16), 0);
        this.aSh = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.widget_nb_item_search, (View.OnClickListener) null);
        this.aSh.setLayoutParams(layoutParams);
        this.aSh.setOnClickListener(new k(this));
        this.mNavigationBar.setLoginClickListener(new l(this));
        this.mNavigationBar.setRegisterClickListener(new m(this));
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.adp.base.g<?> C = com.baidu.adp.base.k.C(this.mContext);
        if (C != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(C, i);
        }
        ap.c(this.cvX, r.g.icon_news_down_bar_one);
        ap.b(this.cvW, r.g.icon_game_bg_s, r.g.icon_game_bg);
        ap.b(this.aSh, r.g.icon_search_bg_s, r.g.icon_search_bg);
        ap.a(this.mCenterIcon, r.g.icon_home_logo, r.g.s_icon_home_logo, r.g.icon_home_logo, i);
    }

    public void onDestroy() {
        if (this.cvY != null) {
            this.cvY.VK();
        }
    }
}
