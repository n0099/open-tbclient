package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment;
import com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private ImageView gUb;
    private NoNetworkView gxx;
    private FrsGameStrategyMainFragment jsQ;
    private ScrollLabelTabHost jsR;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        this.jsQ = frsGameStrategyMainFragment;
        this.mRootView = view;
        if (this.mRootView != null) {
            initUI();
        }
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(this.jsQ.getPageContext().getPageActivity(), R.dimen.ds24), 0);
        this.gUb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.gUb.setLayoutParams(layoutParams);
        this.gUb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(d.this.jsQ.getFid())) {
                    d.this.jsQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(d.this.jsQ.getPageContext().getPageActivity(), d.this.jsQ.getFid(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
                }
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_single_act".equals(d.this.mFrom)) {
                    d.this.jsQ.getActivity().finish();
                    return;
                }
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, d.this.jsQ.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.jsR = (ScrollLabelTabHost) this.mRootView.findViewById(R.id.frs_game_tabview);
        this.jsR.setPageId(this.jsQ.getBaseFragmentActivity().getUniqueId());
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public NavigationBar bUz() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jsQ.getPageContext(), i);
        this.gxx.onChangeSkinType(this.jsQ.getPageContext(), i);
        this.jsR.onChangeSkinType(i);
        if (this.gUb != null) {
            ao.setNavbarIconSrc(this.gUb, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.jsR.setDelegateFrsGameTabDataLoadListener(aVar);
    }

    public void setTabData(List<com.baidu.tieba.frs.game.strategy.tab.e> list, boolean z) {
        this.jsR.setTabData(list, z);
    }

    public void b(int i, int i2, List<n> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        this.jsR.b(i, i2, list, list2, z, z2, i3);
    }

    public void o(int i, int i2, String str) {
        this.jsR.o(i, i2, str);
    }

    public void onDestory() {
        this.jsR.onDestory();
    }

    public void bRN() {
        if (this.jsR != null) {
            this.jsR.bRN();
        }
    }
}
