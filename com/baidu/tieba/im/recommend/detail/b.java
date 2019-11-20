package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView crw;
    private NoNetworkView dvR;
    private RecommendDetailActivity gOV;
    private HeadImageView gOW;
    private TextView gOX;
    private TextView gOY;
    private LinearLayout gOZ;
    private SettingTextSwitchView gPa;
    private View gPb;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.gOV = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.gOV != null) {
            this.gOV.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.gOV.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.gOV.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            yk(this.gOV.getResources().getString(R.string.recommend_detail_activity_title));
            this.dvR = (NoNetworkView) this.gOV.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.gOV.findViewById(R.id.content_view);
            this.gOW = (HeadImageView) this.gOV.findViewById(R.id.user_image);
            this.gOW.setIsRound(true);
            this.crw = (TextView) this.gOV.findViewById(R.id.user_name);
            this.gOX = (TextView) this.gOV.findViewById(R.id.user_type);
            this.gOY = (TextView) this.gOV.findViewById(R.id.intro_content);
            this.gPa = (SettingTextSwitchView) this.gOV.findViewById(R.id.switch_view);
            this.gPa.setSwitchStateChangeListener(this.gOV);
            this.gPa.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.gOZ = (LinearLayout) this.gOV.findViewById(R.id.switch_ll);
            this.gPb = this.gOV.findViewById(R.id.divider_1);
        }
    }

    public void yk(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.gOV != null) {
            this.gOW.startLoad(userInfoBigVip.portraith, 12, false);
            this.crw.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.gOX.setText(userInfoBigVip.user_type);
            this.gOY.setText(userInfoBigVip.user_detail);
            if (z) {
                if (userInfoBigVip.message_accept.intValue() == 1) {
                    setSwitch(true);
                    TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(userInfoBigVip.user_id), true);
                } else {
                    setSwitch(false);
                    TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(userInfoBigVip.user_id), false);
                }
            } else if (TbadkCoreApplication.getInst().isPromotedMessageOn(String.valueOf(userInfoBigVip.user_id))) {
                setSwitch(true);
            } else {
                setSwitch(false);
            }
            this.gPa.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.gPa.getSwitchView().turnOnNoCallback();
        } else {
            this.gPa.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gOV != null && this.gOV.getPageContext() != null && this.gOV.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gOV.getPageContext(), i);
            }
            if (this.dvR != null) {
                this.dvR.onChangeSkinType(this.gOV.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.gOV.getPageContext(), i);
            }
            if (this.gPa != null) {
                this.gPa.jz(i);
            }
            if (this.gPb != null) {
                am.setBackgroundColor(this.gPb, R.color.cp_bg_line_e);
            }
            this.gOV.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.gOV.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void ub(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gOV.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.iK(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(i));
        this.mNoDataView.onChangeSkinType(this.gOV.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bDR() {
        if (this.gOZ != null) {
            this.gOZ.setVisibility(0);
        }
    }

    public void bDS() {
        if (this.gOZ != null) {
            this.gOZ.setVisibility(8);
        }
    }
}
