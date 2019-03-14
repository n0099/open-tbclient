package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment;
import com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    private NoNetworkView dbm;
    private ImageView dpq;
    private FrsGameStrategyMainFragment fkZ;
    private ScrollLabelTabHost fla;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public e(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        this.fkZ = frsGameStrategyMainFragment;
        this.mRootView = view;
        if (this.mRootView != null) {
            initUI();
        }
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.h(this.fkZ.getPageContext().getPageActivity(), d.e.ds24), 0);
        this.dpq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.dpq.setLayoutParams(layoutParams);
        this.dpq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(e.this.fkZ.getFid())) {
                    e.this.fkZ.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(e.this.fkZ.getPageContext().getPageActivity(), e.this.fkZ.getFid(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
                }
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_single_act".equals(e.this.mFrom)) {
                    e.this.fkZ.getActivity().finish();
                    return;
                }
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, e.this.fkZ.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        this.fla = (ScrollLabelTabHost) this.mRootView.findViewById(d.g.frs_game_tabview);
        this.fla.setPageId(this.fkZ.getBaseFragmentActivity().getUniqueId());
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public NavigationBar aDp() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fkZ.getPageContext(), i);
        this.dbm.onChangeSkinType(this.fkZ.getPageContext(), i);
        this.fla.onChangeSkinType(i);
        if (this.dpq != null) {
            al.a(this.dpq, d.f.btn_more_selector_s, d.f.btn_more_selector);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.fla.setDelegateFrsGameTabDataLoadListener(aVar);
    }

    public void setTabData(List<com.baidu.tieba.frs.game.strategy.tab.e> list, boolean z) {
        this.fla.setTabData(list, z);
    }

    public void b(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        this.fla.b(i, i2, list, list2, z, z2, i3);
    }

    public void f(int i, int i2, String str) {
        this.fla.f(i, i2, str);
    }

    public void onDestory() {
        this.fla.onDestory();
    }

    public void aCt() {
        if (this.fla != null) {
            this.fla.aCt();
        }
    }
}
