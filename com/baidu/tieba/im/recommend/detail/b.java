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
    private TextView cBd;
    private NoNetworkView ePq;
    private RecommendDetailActivity iul;
    private HeadImageView ium;
    private TextView iun;
    private TextView iuo;
    private LinearLayout iup;
    private SettingTextSwitchView iuq;
    private View iur;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.iul = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.iul != null) {
            this.iul.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.iul.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.iul.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Ff(this.iul.getResources().getString(R.string.recommend_detail_activity_title));
            this.ePq = (NoNetworkView) this.iul.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.iul.findViewById(R.id.content_view);
            this.ium = (HeadImageView) this.iul.findViewById(R.id.user_image);
            this.ium.setIsRound(true);
            this.cBd = (TextView) this.iul.findViewById(R.id.user_name);
            this.iun = (TextView) this.iul.findViewById(R.id.user_type);
            this.iuo = (TextView) this.iul.findViewById(R.id.intro_content);
            this.iuq = (SettingTextSwitchView) this.iul.findViewById(R.id.switch_view);
            this.iuq.setSwitchStateChangeListener(this.iul);
            this.iuq.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.iup = (LinearLayout) this.iul.findViewById(R.id.switch_ll);
            this.iur = this.iul.findViewById(R.id.divider_1);
        }
    }

    public void Ff(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.iul != null) {
            this.ium.startLoad(userInfoBigVip.portraith, 12, false);
            this.cBd.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.iun.setText(userInfoBigVip.user_type);
            this.iuo.setText(userInfoBigVip.user_detail);
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
            this.iuq.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.iuq.getSwitchView().turnOnNoCallback();
        } else {
            this.iuq.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iul != null && this.iul.getPageContext() != null && this.iul.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.iul.getPageContext(), i);
            }
            if (this.ePq != null) {
                this.ePq.onChangeSkinType(this.iul.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.iul.getPageContext(), i);
            }
            if (this.iuq != null) {
                this.iuq.ms(i);
            }
            if (this.iur != null) {
                am.setBackgroundColor(this.iur, R.color.cp_bg_line_e);
            }
            this.iul.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.iul.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void wU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iul.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.lr(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lr(i));
        this.mNoDataView.onChangeSkinType(this.iul.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void ciH() {
        if (this.iup != null) {
            this.iup.setVisibility(0);
        }
    }

    public void ciI() {
        if (this.iup != null) {
            this.iup.setVisibility(8);
        }
    }
}
