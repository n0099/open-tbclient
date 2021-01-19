package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes7.dex */
public class b {
    private TextView eGI;
    private NoNetworkView gxx;
    private RecommendDetailActivity kDd;
    private HeadImageView kDe;
    private TextView kDf;
    private TextView kDg;
    private LinearLayout kDh;
    private SettingTextSwitchView kDi;
    private View kDj;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.kDd = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.kDd != null) {
            this.kDd.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.kDd.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.kDd.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Mn(this.kDd.getResources().getString(R.string.recommend_detail_activity_title));
            this.gxx = (NoNetworkView) this.kDd.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.kDd.findViewById(R.id.content_view);
            this.kDe = (HeadImageView) this.kDd.findViewById(R.id.user_image);
            this.kDe.setIsRound(true);
            this.eGI = (TextView) this.kDd.findViewById(R.id.user_name);
            this.kDf = (TextView) this.kDd.findViewById(R.id.user_type);
            this.kDg = (TextView) this.kDd.findViewById(R.id.intro_content);
            this.kDi = (SettingTextSwitchView) this.kDd.findViewById(R.id.switch_view);
            this.kDi.setSwitchStateChangeListener(this.kDd);
            this.kDi.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.kDh = (LinearLayout) this.kDd.findViewById(R.id.switch_ll);
            this.kDj = this.kDd.findViewById(R.id.divider_1);
        }
    }

    public void Mn(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.kDd != null) {
            this.kDe.startLoad(userInfoBigVip.portraith, 12, false);
            this.eGI.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.kDf.setText(userInfoBigVip.user_type);
            this.kDg.setText(userInfoBigVip.user_detail);
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
            this.kDi.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.kDi.getSwitchView().turnOnNoCallback();
        } else {
            this.kDi.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kDd != null && this.kDd.getPageContext() != null && this.kDd.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kDd.getPageContext(), i);
            }
            if (this.gxx != null) {
                this.gxx.onChangeSkinType(this.kDd.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.kDd.getPageContext(), i);
            }
            if (this.kDi != null) {
                this.kDi.qE(i);
            }
            if (this.kDj != null) {
                ao.setBackgroundColor(this.kDj, R.color.CAM_X0205);
            }
            this.kDd.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.kDd.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void CG(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kDd.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.pu(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pu(i));
        this.mNoDataView.onChangeSkinType(this.kDd.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cVI() {
        if (this.kDh != null) {
            this.kDh.setVisibility(0);
        }
    }

    public void cVJ() {
        if (this.kDh != null) {
            this.kDh.setVisibility(8);
        }
    }
}
