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
    private TextView cbW;
    private NoNetworkView elL;
    private RecommendDetailActivity hKp;
    private HeadImageView hKq;
    private TextView hKr;
    private TextView hKs;
    private LinearLayout hKt;
    private SettingTextSwitchView hKu;
    private View hKv;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.hKp = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.hKp != null) {
            this.hKp.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.hKp.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.hKp.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Du(this.hKp.getResources().getString(R.string.recommend_detail_activity_title));
            this.elL = (NoNetworkView) this.hKp.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.hKp.findViewById(R.id.content_view);
            this.hKq = (HeadImageView) this.hKp.findViewById(R.id.user_image);
            this.hKq.setIsRound(true);
            this.cbW = (TextView) this.hKp.findViewById(R.id.user_name);
            this.hKr = (TextView) this.hKp.findViewById(R.id.user_type);
            this.hKs = (TextView) this.hKp.findViewById(R.id.intro_content);
            this.hKu = (SettingTextSwitchView) this.hKp.findViewById(R.id.switch_view);
            this.hKu.setSwitchStateChangeListener(this.hKp);
            this.hKu.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.hKt = (LinearLayout) this.hKp.findViewById(R.id.switch_ll);
            this.hKv = this.hKp.findViewById(R.id.divider_1);
        }
    }

    public void Du(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.hKp != null) {
            this.hKq.startLoad(userInfoBigVip.portraith, 12, false);
            this.cbW.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.hKr.setText(userInfoBigVip.user_type);
            this.hKs.setText(userInfoBigVip.user_detail);
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
            this.hKu.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.hKu.getSwitchView().turnOnNoCallback();
        } else {
            this.hKu.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hKp != null && this.hKp.getPageContext() != null && this.hKp.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hKp.getPageContext(), i);
            }
            if (this.elL != null) {
                this.elL.onChangeSkinType(this.hKp.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.hKp.getPageContext(), i);
            }
            if (this.hKu != null) {
                this.hKu.mg(i);
            }
            if (this.hKv != null) {
                am.setBackgroundColor(this.hKv, R.color.cp_bg_line_e);
            }
            this.hKp.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.hKp.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void ww(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hKp.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.lh(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(i));
        this.mNoDataView.onChangeSkinType(this.hKp.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bYi() {
        if (this.hKt != null) {
            this.hKt.setVisibility(0);
        }
    }

    public void bYj() {
        if (this.hKt != null) {
            this.hKt.setVisibility(8);
        }
    }
}
