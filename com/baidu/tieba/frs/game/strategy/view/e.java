package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment;
import com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost;
import java.util.List;
/* loaded from: classes22.dex */
public class e {
    private ImageView gEr;
    private NoNetworkView gjn;
    private FrsGameStrategyMainFragment iWK;
    private ScrollLabelTabHost iWL;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public e(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        this.iWK = frsGameStrategyMainFragment;
        this.mRootView = view;
        if (this.mRootView != null) {
            initUI();
        }
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(this.iWK.getPageContext().getPageActivity(), R.dimen.ds24), 0);
        this.gEr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.gEr.setLayoutParams(layoutParams);
        this.gEr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(e.this.iWK.getFid())) {
                    e.this.iWK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(e.this.iWK.getPageContext().getPageActivity(), e.this.iWK.getFid(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
                }
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_single_act".equals(e.this.mFrom)) {
                    e.this.iWK.getActivity().finish();
                    return;
                }
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, e.this.iWK.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.gjn = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.iWL = (ScrollLabelTabHost) this.mRootView.findViewById(R.id.frs_game_tabview);
        this.iWL.setPageId(this.iWK.getBaseFragmentActivity().getUniqueId());
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public NavigationBar bSH() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iWK.getPageContext(), i);
        this.gjn.onChangeSkinType(this.iWK.getPageContext(), i);
        this.iWL.onChangeSkinType(i);
        if (this.gEr != null) {
            ap.setNavbarIconSrc(this.gEr, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.iWL.setDelegateFrsGameTabDataLoadListener(aVar);
    }

    public void setTabData(List<com.baidu.tieba.frs.game.strategy.tab.e> list, boolean z) {
        this.iWL.setTabData(list, z);
    }

    public void b(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        this.iWL.b(i, i2, list, list2, z, z2, i3);
    }

    public void n(int i, int i2, String str) {
        this.iWL.n(i, i2, str);
    }

    public void onDestory() {
        this.iWL.onDestory();
    }

    public void bPV() {
        if (this.iWL != null) {
            this.iWL.bPV();
        }
    }
}
