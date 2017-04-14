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
    private ImageView aYG;
    private TbPageContext<?> ajT;
    private ObservedChangeLinearLayout bEu;
    private ImageView cvV;
    private ImageView cvW;
    private a cvX;
    private com.baidu.tieba.e.c cvY;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener cvZ = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cwa = new g(this, CmdConfigCustom.CMD_GAME_CENTER_INIT);
    private View.OnTouchListener aOh = new h(this);
    private a.InterfaceC0055a aRm = new i(this);

    public a aiV() {
        return this.cvX;
    }

    public View.OnTouchListener aiW() {
        return this.aOh;
    }

    public ObservedChangeLinearLayout VP() {
        return this.bEu;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bEu = observedChangeLinearLayout;
        as(view);
        this.cvX = new a(context, observedChangeLinearLayout, view2);
        this.cvY = new com.baidu.tieba.e.c(context);
        this.cvY.a(this.aRm);
        aiX();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cwa.setTag(bdUniqueId);
        this.cvZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cwa);
        MessageManager.getInstance().registerListener(this.cvZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiX() {
        if (com.baidu.adp.lib.b.e.eY().Y("android_game_enter_switch") == 1 && p.aeq) {
            eS(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        eS(false);
        eR(false);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("game_is_show_tip", false);
    }

    public boolean aiY() {
        return this.cvV != null && this.cvV.getVisibility() == 0;
    }

    public void eR(boolean z) {
        if (z) {
            if (this.cvW.getVisibility() != 0) {
                this.cvW.setVisibility(0);
                eT(true);
                aq.c(this.cvW, w.g.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eT(false);
        this.cvW.setVisibility(8);
    }

    public void eS(boolean z) {
        if (this.cvV != null) {
            if (z) {
                this.cvV.setVisibility(0);
            } else {
                this.cvV.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cvV.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds20);
            }
            this.cvV.setLayoutParams(layoutParams);
        }
    }

    private void as(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(w.h.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.game_tip_view, (View.OnClickListener) null);
        this.cvV = (ImageView) addCustomView.findViewById(w.h.game_button_iv);
        this.cvW = (ImageView) addCustomView.findViewById(w.h.game_tip_msg_iv);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16), 0);
        this.aYG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
        this.aYG.setLayoutParams(layoutParams);
        this.aYG.setOnClickListener(new j(this));
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
        aq.c(this.cvW, w.g.icon_news_down_bar_one);
        aq.b(this.cvV, w.g.icon_game_bg_s, w.g.icon_game_bg);
        aq.b(this.aYG, w.g.icon_search_bg_s, w.g.icon_search_bg);
        aq.a(this.mCenterIcon, w.g.icon_home_logo, w.g.s_icon_home_logo, w.g.icon_home_logo, i);
    }

    public void onDestroy() {
        if (this.cvX != null) {
            this.cvX.Xg();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.ajT = tbPageContext;
        if (this.cvV != null) {
            this.cvV.setOnClickListener(new m(this));
        }
    }
}
