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
    private TextView aVt;
    private RecommendDetailActivity bms;
    private HeadImageView bmt;
    private TextView bmu;
    private TextView bmv;
    private SettingTextSwitchView bmw;
    private LinearLayout bmx;
    private NavigationBar mNavigationBar;
    private s mNoDataView;
    private NoNetworkView mNoNetworkView;
    private View mRootView;

    public i(RecommendDetailActivity recommendDetailActivity) {
        this.bms = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.bms != null) {
            this.bms.setContentView(w.recommend_detail_activity);
            this.mRootView = this.bms.findViewById(v.root_view);
            this.mNavigationBar = (NavigationBar) this.bms.findViewById(v.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNoNetworkView = (NoNetworkView) this.bms.findViewById(v.view_no_network);
            this.bmx = (LinearLayout) this.bms.findViewById(v.content_view);
            this.bmt = (HeadImageView) this.bms.findViewById(v.user_image);
            this.aVt = (TextView) this.bms.findViewById(v.user_name);
            this.bmu = (TextView) this.bms.findViewById(v.user_type);
            this.bmv = (TextView) this.bms.findViewById(v.intro_content);
            this.bmw = (SettingTextSwitchView) this.bms.findViewById(v.switch_view);
            this.bmw.setSwitchStateChangeListener(this.bms);
            this.bmw.setVisibility(8);
            this.bmx.setVisibility(8);
        }
    }

    public void gQ(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setTitleText(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.bms != null) {
            this.bmt.c(userInfoBigVip.portraith, 12, false);
            this.aVt.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.bmu.setText(userInfoBigVip.user_type);
            this.bmv.setText(userInfoBigVip.user_detail);
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
            this.bmw.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.bmw.getSwitchView().lY();
        } else {
            this.bmw.getSwitchView().lZ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bms != null && this.bms.getPageContext() != null && this.bms.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.bms.getPageContext(), i);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bms.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bms.getPageContext(), i);
            }
            if (this.bmw != null) {
                this.bmw.dc(i);
            }
            this.bms.getPageContext().getLayoutMode().X(i == 1);
            this.bms.getPageContext().getLayoutMode().h(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bmx.setVisibility(0);
    }

    public void fh(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bms.getPageContext().getPageActivity(), this.mRootView, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(i), null);
        }
        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(i));
        this.mNoDataView.onChangeSkinType(this.bms.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.bmx.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }
}
