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
/* loaded from: classes13.dex */
public class b {
    private TextView cbL;
    private NoNetworkView elv;
    private RecommendDetailActivity hIP;
    private HeadImageView hIQ;
    private TextView hIR;
    private TextView hIS;
    private LinearLayout hIT;
    private SettingTextSwitchView hIU;
    private View hIV;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.hIP = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.hIP != null) {
            this.hIP.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.hIP.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.hIP.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Du(this.hIP.getResources().getString(R.string.recommend_detail_activity_title));
            this.elv = (NoNetworkView) this.hIP.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.hIP.findViewById(R.id.content_view);
            this.hIQ = (HeadImageView) this.hIP.findViewById(R.id.user_image);
            this.hIQ.setIsRound(true);
            this.cbL = (TextView) this.hIP.findViewById(R.id.user_name);
            this.hIR = (TextView) this.hIP.findViewById(R.id.user_type);
            this.hIS = (TextView) this.hIP.findViewById(R.id.intro_content);
            this.hIU = (SettingTextSwitchView) this.hIP.findViewById(R.id.switch_view);
            this.hIU.setSwitchStateChangeListener(this.hIP);
            this.hIU.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.hIT = (LinearLayout) this.hIP.findViewById(R.id.switch_ll);
            this.hIV = this.hIP.findViewById(R.id.divider_1);
        }
    }

    public void Du(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.hIP != null) {
            this.hIQ.startLoad(userInfoBigVip.portraith, 12, false);
            this.cbL.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.hIR.setText(userInfoBigVip.user_type);
            this.hIS.setText(userInfoBigVip.user_detail);
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
            this.hIU.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.hIU.getSwitchView().turnOnNoCallback();
        } else {
            this.hIU.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hIP != null && this.hIP.getPageContext() != null && this.hIP.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hIP.getPageContext(), i);
            }
            if (this.elv != null) {
                this.elv.onChangeSkinType(this.hIP.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.hIP.getPageContext(), i);
            }
            if (this.hIU != null) {
                this.hIU.me(i);
            }
            if (this.hIV != null) {
                am.setBackgroundColor(this.hIV, R.color.cp_bg_line_e);
            }
            this.hIP.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.hIP.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hIP.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.lh(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(i));
        this.mNoDataView.onChangeSkinType(this.hIP.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bXQ() {
        if (this.hIT != null) {
            this.hIT.setVisibility(0);
        }
    }

    public void bXR() {
        if (this.hIT != null) {
            this.hIT.setVisibility(8);
        }
    }
}
