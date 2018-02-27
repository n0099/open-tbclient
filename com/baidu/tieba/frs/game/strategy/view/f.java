package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    private NoNetworkView caX;
    private ImageView ckY;
    private com.baidu.tieba.frs.game.strategy.a dOM;
    private ScrollLabelTabHost dON;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public f(com.baidu.tieba.frs.game.strategy.a aVar, View view) {
        this.dOM = aVar;
        this.mRootView = view;
        if (this.mRootView != null) {
            initUI();
        }
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.t(this.dOM.getPageContext().getPageActivity(), d.e.ds24), 0);
        this.ckY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.ckY.setLayoutParams(layoutParams);
        this.ckY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(f.this.dOM.getFid())) {
                    f.this.dOM.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.dOM.getPageContext().getPageActivity(), f.this.dOM.getFid(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
                }
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        this.dON = (ScrollLabelTabHost) this.mRootView.findViewById(d.g.frs_game_tabview);
        this.dON.setPageId(this.dOM.getBaseFragmentActivity().getUniqueId());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public NavigationBar avj() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dOM.getPageContext(), i);
        this.caX.onChangeSkinType(this.dOM.getPageContext(), i);
        this.dON.onChangeSkinType(i);
        if (this.ckY != null) {
            aj.a(this.ckY, d.f.btn_more_selector_s, d.f.btn_more_selector);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dON.setDelegateFrsGameTabDataLoadListener(bVar);
    }

    public void h(List<com.baidu.tieba.frs.game.strategy.tab.f> list, boolean z) {
        this.dON.h(list, z);
    }

    public void b(int i, int i2, List<i> list, List<com.baidu.tieba.frs.game.strategy.tab.f> list2, boolean z, boolean z2, int i3) {
        this.dON.b(i, i2, list, list2, z, z2, i3);
    }

    public void f(int i, int i2, String str) {
        this.dON.f(i, i2, str);
    }

    public void onDestory() {
        this.dON.onDestory();
    }

    public void XK() {
        if (this.dON != null) {
            this.dON.XK();
        }
    }
}
