package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes.dex */
public class i {
    private TextView aVe;
    private RecommendDetailActivity bmc;
    private HeadImageView bmd;
    private TextView bme;
    private TextView bmf;
    private SettingTextSwitchView bmg;
    private LinearLayout bmh;
    private NavigationBar mNavigationBar;
    private s mNoDataView;
    private NoNetworkView mNoNetworkView;
    private View mRootView;

    public i(RecommendDetailActivity recommendDetailActivity) {
        this.bmc = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.bmc != null) {
            this.bmc.setContentView(w.recommend_detail_activity);
            this.mRootView = this.bmc.findViewById(v.root_view);
            this.mNavigationBar = (NavigationBar) this.bmc.findViewById(v.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNoNetworkView = (NoNetworkView) this.bmc.findViewById(v.view_no_network);
            this.bmh = (LinearLayout) this.bmc.findViewById(v.content_view);
            this.bmd = (HeadImageView) this.bmc.findViewById(v.user_image);
            this.aVe = (TextView) this.bmc.findViewById(v.user_name);
            this.bme = (TextView) this.bmc.findViewById(v.user_type);
            this.bmf = (TextView) this.bmc.findViewById(v.intro_content);
            this.bmg = (SettingTextSwitchView) this.bmc.findViewById(v.switch_view);
            this.bmg.setSwitchStateChangeListener(this.bmc);
            this.bmg.setVisibility(8);
            this.bmh.setVisibility(8);
        }
    }

    public void gN(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setTitleText(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.bmc != null) {
            this.bmd.c(userInfoBigVip.portraith, 12, false);
            this.aVe.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.bme.setText(userInfoBigVip.user_type);
            this.bmf.setText(userInfoBigVip.user_detail);
            if (z) {
                if (userInfoBigVip.message_accept.intValue() == 1) {
                    setSwitch(true);
                    TbadkCoreApplication.m411getInst().setPromotedMessage(true);
                } else {
                    setSwitch(false);
                    TbadkCoreApplication.m411getInst().setPromotedMessage(false);
                }
            } else if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                setSwitch(true);
            } else {
                setSwitch(false);
            }
            this.bmg.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.bmg.getSwitchView().lY();
        } else {
            this.bmg.getSwitchView().lZ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bmc != null && this.bmc.getPageContext() != null && this.bmc.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.bmc.getPageContext(), i);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bmc.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bmc.getPageContext(), i);
            }
            if (this.bmg != null) {
                this.bmg.dc(i);
            }
            this.bmc.getPageContext().getLayoutMode().X(i == 1);
            this.bmc.getPageContext().getLayoutMode().h(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bmh.setVisibility(0);
    }

    public void fg(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bmc.getPageContext().getPageActivity(), this.mRootView, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(i), null);
        }
        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(i));
        this.mNoDataView.onChangeSkinType(this.bmc.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.bmh.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }
}
