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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    private ImageView aYJ;
    private TbPageContext<?> ajU;
    private ObservedChangeLinearLayout bGL;
    private ImageView cym;
    private ImageView cyn;
    private a cyo;
    private com.baidu.tieba.e.c cyp;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener cyq = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cyr = new g(this, CmdConfigCustom.CMD_GAME_CENTER_INIT);
    private View.OnTouchListener aOj = new h(this);
    private a.InterfaceC0055a aRo = new i(this);

    public a ajW() {
        return this.cyo;
    }

    public View.OnTouchListener ajX() {
        return this.aOj;
    }

    public ObservedChangeLinearLayout WQ() {
        return this.bGL;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bGL = observedChangeLinearLayout;
        as(view);
        this.cyo = new a(context, observedChangeLinearLayout, view2);
        this.cyp = new com.baidu.tieba.e.c(context);
        this.cyp.a(this.aRo);
        ajY();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cyr.setTag(bdUniqueId);
        this.cyq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cyr);
        MessageManager.getInstance().registerListener(this.cyq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajY() {
        if (com.baidu.adp.lib.b.e.eZ().Y("android_game_enter_switch") == 1 && p.aer) {
            fc(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        fc(false);
        fb(false);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("game_is_show_tip", false);
    }

    public boolean ajZ() {
        return this.cym != null && this.cym.getVisibility() == 0;
    }

    public void fb(boolean z) {
        if (z) {
            if (this.cyn.getVisibility() != 0) {
                this.cyn.setVisibility(0);
                fd(true);
                aq.c(this.cyn, w.g.icon_news_down_bar_one);
                return;
            }
            return;
        }
        fd(false);
        this.cyn.setVisibility(8);
    }

    public void fc(boolean z) {
        if (this.cym != null) {
            if (z) {
                this.cym.setVisibility(0);
            } else {
                this.cym.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cym.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds20);
            }
            this.cym.setLayoutParams(layoutParams);
        }
    }

    private void as(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(w.h.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.game_tip_view, (View.OnClickListener) null);
        this.cym = (ImageView) addCustomView.findViewById(w.h.game_button_iv);
        this.cyn = (ImageView) addCustomView.findViewById(w.h.game_tip_msg_iv);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16), 0);
        this.aYJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
        this.aYJ.setLayoutParams(layoutParams);
        this.aYJ.setOnClickListener(new j(this));
        this.mNavigationBar.setLoginClickListener(new k(this));
        this.mNavigationBar.setRegisterClickListener(new l(this));
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.mContext);
        if (Z != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(Z, i);
        }
        aq.c(this.cyn, w.g.icon_news_down_bar_one);
        aq.b(this.cym, w.g.icon_game_bg_s, w.g.icon_game_bg);
        aq.b(this.aYJ, w.g.icon_search_bg_s, w.g.icon_search_bg);
        aq.a(this.mCenterIcon, w.g.icon_home_logo, w.g.s_icon_home_logo, w.g.icon_home_logo, i);
    }

    public void onDestroy() {
        if (this.cyo != null) {
            this.cyo.Yh();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.ajU = tbPageContext;
        if (this.cym != null) {
            this.cym.setOnClickListener(new m(this));
        }
    }
}
