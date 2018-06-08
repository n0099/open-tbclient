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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment;
import com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private ImageView bDU;
    private NoNetworkView btu;
    private FrsGameStrategyMainFragment drQ;
    private ScrollLabelTabHost drR;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public e(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        this.drQ = frsGameStrategyMainFragment;
        this.mRootView = view;
        if (this.mRootView != null) {
            initUI();
        }
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.e(this.drQ.getPageContext().getPageActivity(), d.e.ds24), 0);
        this.bDU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.bDU.setLayoutParams(layoutParams);
        this.bDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(e.this.drQ.getFid())) {
                    e.this.drQ.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(e.this.drQ.getPageContext().getPageActivity(), e.this.drQ.getFid(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
                }
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_single_act".equals(e.this.mFrom)) {
                    e.this.drQ.getActivity().finish();
                    return;
                }
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, e.this.drQ.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        this.drR = (ScrollLabelTabHost) this.mRootView.findViewById(d.g.frs_game_tabview);
        this.drR.setPageId(this.drQ.getBaseFragmentActivity().getUniqueId());
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public NavigationBar UB() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.drQ.getPageContext(), i);
        this.btu.onChangeSkinType(this.drQ.getPageContext(), i);
        this.drR.onChangeSkinType(i);
        if (this.bDU != null) {
            al.a(this.bDU, d.f.btn_more_selector_s, d.f.btn_more_selector);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.drR.setDelegateFrsGameTabDataLoadListener(aVar);
    }

    public void setTabData(List<com.baidu.tieba.frs.game.strategy.tab.e> list, boolean z) {
        this.drR.setTabData(list, z);
    }

    public void b(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        this.drR.b(i, i2, list, list2, z, z2, i3);
    }

    public void d(int i, int i2, String str) {
        this.drR.d(i, i2, str);
    }

    public void onDestory() {
        this.drR.onDestory();
    }

    public void TG() {
        if (this.drR != null) {
            this.drR.TG();
        }
    }
}
