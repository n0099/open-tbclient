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
/* loaded from: classes7.dex */
public class b {
    private TextView eKp;
    private NoNetworkView gCe;
    private TextView kNA;
    private TextView kNB;
    private LinearLayout kNC;
    private SettingTextSwitchView kND;
    private View kNE;
    private RecommendDetailActivity kNy;
    private HeadImageView kNz;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.kNy = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.kNy != null) {
            this.kNy.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.kNy.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.kNy.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Ni(this.kNy.getResources().getString(R.string.recommend_detail_activity_title));
            this.gCe = (NoNetworkView) this.kNy.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.kNy.findViewById(R.id.content_view);
            this.kNz = (HeadImageView) this.kNy.findViewById(R.id.user_image);
            this.kNz.setIsRound(true);
            this.eKp = (TextView) this.kNy.findViewById(R.id.user_name);
            this.kNA = (TextView) this.kNy.findViewById(R.id.user_type);
            this.kNB = (TextView) this.kNy.findViewById(R.id.intro_content);
            this.kND = (SettingTextSwitchView) this.kNy.findViewById(R.id.switch_view);
            this.kND.setSwitchStateChangeListener(this.kNy);
            this.kND.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.kNC = (LinearLayout) this.kNy.findViewById(R.id.switch_ll);
            this.kNE = this.kNy.findViewById(R.id.divider_1);
        }
    }

    public void Ni(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.kNy != null) {
            this.kNz.startLoad(userInfoBigVip.portraith, 12, false);
            this.eKp.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.kNA.setText(userInfoBigVip.user_type);
            this.kNB.setText(userInfoBigVip.user_detail);
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
            this.kND.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.kND.getSwitchView().turnOnNoCallback();
        } else {
            this.kND.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kNy != null && this.kNy.getPageContext() != null && this.kNy.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kNy.getPageContext(), i);
            }
            if (this.gCe != null) {
                this.gCe.onChangeSkinType(this.kNy.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.kNy.getPageContext(), i);
            }
            if (this.kND != null) {
                this.kND.qK(i);
            }
            if (this.kNE != null) {
                ap.setBackgroundColor(this.kNE, R.color.CAM_X0205);
            }
            this.kNy.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.kNy.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void Db(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kNy.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.pA(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pA(i));
        this.mNoDataView.onChangeSkinType(this.kNy.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cXU() {
        if (this.kNC != null) {
            this.kNC.setVisibility(0);
        }
    }

    public void cXV() {
        if (this.kNC != null) {
            this.kNC.setVisibility(8);
        }
    }
}
