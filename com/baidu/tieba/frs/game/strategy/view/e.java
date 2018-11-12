package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment;
import com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private NoNetworkView bKI;
    private ImageView bVL;
    private FrsGameStrategyMainFragment dNw;
    private ScrollLabelTabHost dNx;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public e(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        this.dNw = frsGameStrategyMainFragment;
        this.mRootView = view;
        if (this.mRootView != null) {
            initUI();
        }
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.h(this.dNw.getPageContext().getPageActivity(), e.C0200e.ds24), 0);
        this.bVL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.bVL.setLayoutParams(layoutParams);
        this.bVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(e.this.dNw.getFid())) {
                    e.this.dNw.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(e.this.dNw.getPageContext().getPageActivity(), e.this.dNw.getFid(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
                }
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_single_act".equals(e.this.mFrom)) {
                    e.this.dNw.getActivity().finish();
                    return;
                }
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, e.this.dNw.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        this.dNx = (ScrollLabelTabHost) this.mRootView.findViewById(e.g.frs_game_tabview);
        this.dNx.setPageId(this.dNw.getBaseFragmentActivity().getUniqueId());
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public NavigationBar aaO() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dNw.getPageContext(), i);
        this.bKI.onChangeSkinType(this.dNw.getPageContext(), i);
        this.dNx.onChangeSkinType(i);
        if (this.bVL != null) {
            al.a(this.bVL, e.f.btn_more_selector_s, e.f.btn_more_selector);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.dNx.setDelegateFrsGameTabDataLoadListener(aVar);
    }

    public void setTabData(List<com.baidu.tieba.frs.game.strategy.tab.e> list, boolean z) {
        this.dNx.setTabData(list, z);
    }

    public void b(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        this.dNx.b(i, i2, list, list2, z, z2, i3);
    }

    public void d(int i, int i2, String str) {
        this.dNx.d(i, i2, str);
    }

    public void onDestory() {
        this.dNx.onDestory();
    }

    public void ZQ() {
        if (this.dNx != null) {
            this.dNx.ZQ();
        }
    }
}
