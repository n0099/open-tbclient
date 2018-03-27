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
    private NoNetworkView cba;
    private ImageView clb;
    private com.baidu.tieba.frs.game.strategy.a dOR;
    private ScrollLabelTabHost dOS;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public f(com.baidu.tieba.frs.game.strategy.a aVar, View view) {
        this.dOR = aVar;
        this.mRootView = view;
        if (this.mRootView != null) {
            initUI();
        }
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.t(this.dOR.getPageContext().getPageActivity(), d.e.ds24), 0);
        this.clb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.clb.setLayoutParams(layoutParams);
        this.clb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(f.this.dOR.getFid())) {
                    f.this.dOR.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.dOR.getPageContext().getPageActivity(), f.this.dOR.getFid(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
                }
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        this.dOS = (ScrollLabelTabHost) this.mRootView.findViewById(d.g.frs_game_tabview);
        this.dOS.setPageId(this.dOR.getBaseFragmentActivity().getUniqueId());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public NavigationBar avk() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dOR.getPageContext(), i);
        this.cba.onChangeSkinType(this.dOR.getPageContext(), i);
        this.dOS.onChangeSkinType(i);
        if (this.clb != null) {
            aj.a(this.clb, d.f.btn_more_selector_s, d.f.btn_more_selector);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dOS.setDelegateFrsGameTabDataLoadListener(bVar);
    }

    public void h(List<com.baidu.tieba.frs.game.strategy.tab.f> list, boolean z) {
        this.dOS.h(list, z);
    }

    public void b(int i, int i2, List<i> list, List<com.baidu.tieba.frs.game.strategy.tab.f> list2, boolean z, boolean z2, int i3) {
        this.dOS.b(i, i2, list, list2, z, z2, i3);
    }

    public void f(int i, int i2, String str) {
        this.dOS.f(i, i2, str);
    }

    public void onDestory() {
        this.dOS.onDestory();
    }

    public void XL() {
        if (this.dOS != null) {
            this.dOS.XL();
        }
    }
}
