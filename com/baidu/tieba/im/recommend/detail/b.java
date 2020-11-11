package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes26.dex */
public class b {
    private TextView ewx;
    private NoNetworkView gjn;
    private RecommendDetailActivity koe;
    private HeadImageView kof;
    private TextView kog;
    private TextView koh;
    private LinearLayout koi;
    private SettingTextSwitchView koj;
    private View kok;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.koe = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.koe != null) {
            this.koe.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.koe.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.koe.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Ne(this.koe.getResources().getString(R.string.recommend_detail_activity_title));
            this.gjn = (NoNetworkView) this.koe.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.koe.findViewById(R.id.content_view);
            this.kof = (HeadImageView) this.koe.findViewById(R.id.user_image);
            this.kof.setIsRound(true);
            this.ewx = (TextView) this.koe.findViewById(R.id.user_name);
            this.kog = (TextView) this.koe.findViewById(R.id.user_type);
            this.koh = (TextView) this.koe.findViewById(R.id.intro_content);
            this.koj = (SettingTextSwitchView) this.koe.findViewById(R.id.switch_view);
            this.koj.setSwitchStateChangeListener(this.koe);
            this.koj.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.koi = (LinearLayout) this.koe.findViewById(R.id.switch_ll);
            this.kok = this.koe.findViewById(R.id.divider_1);
        }
    }

    public void Ne(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.koe != null) {
            this.kof.startLoad(userInfoBigVip.portraith, 12, false);
            this.ewx.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.kog.setText(userInfoBigVip.user_type);
            this.koh.setText(userInfoBigVip.user_detail);
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
            this.koj.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.koj.getSwitchView().turnOnNoCallback();
        } else {
            this.koj.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.koe != null && this.koe.getPageContext() != null && this.koe.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.koe.getPageContext(), i);
            }
            if (this.gjn != null) {
                this.gjn.onChangeSkinType(this.koe.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.koe.getPageContext(), i);
            }
            if (this.koj != null) {
                this.koj.qZ(i);
            }
            if (this.kok != null) {
                ap.setBackgroundColor(this.kok, R.color.cp_bg_line_e);
            }
            this.koe.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.koe.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void CQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.koe.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.pQ(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pQ(i));
        this.mNoDataView.onChangeSkinType(this.koe.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cUU() {
        if (this.koi != null) {
            this.koi.setVisibility(0);
        }
    }

    public void cUV() {
        if (this.koi != null) {
            this.koi.setVisibility(8);
        }
    }
}
