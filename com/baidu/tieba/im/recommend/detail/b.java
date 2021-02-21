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
/* loaded from: classes8.dex */
public class b {
    private TextView eIO;
    private NoNetworkView gAv;
    private LinearLayout kLA;
    private SettingTextSwitchView kLB;
    private View kLC;
    private RecommendDetailActivity kLw;
    private HeadImageView kLx;
    private TextView kLy;
    private TextView kLz;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.kLw = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.kLw != null) {
            this.kLw.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.kLw.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.kLw.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Nc(this.kLw.getResources().getString(R.string.recommend_detail_activity_title));
            this.gAv = (NoNetworkView) this.kLw.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.kLw.findViewById(R.id.content_view);
            this.kLx = (HeadImageView) this.kLw.findViewById(R.id.user_image);
            this.kLx.setIsRound(true);
            this.eIO = (TextView) this.kLw.findViewById(R.id.user_name);
            this.kLy = (TextView) this.kLw.findViewById(R.id.user_type);
            this.kLz = (TextView) this.kLw.findViewById(R.id.intro_content);
            this.kLB = (SettingTextSwitchView) this.kLw.findViewById(R.id.switch_view);
            this.kLB.setSwitchStateChangeListener(this.kLw);
            this.kLB.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.kLA = (LinearLayout) this.kLw.findViewById(R.id.switch_ll);
            this.kLC = this.kLw.findViewById(R.id.divider_1);
        }
    }

    public void Nc(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.kLw != null) {
            this.kLx.startLoad(userInfoBigVip.portraith, 12, false);
            this.eIO.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.kLy.setText(userInfoBigVip.user_type);
            this.kLz.setText(userInfoBigVip.user_detail);
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
            this.kLB.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.kLB.getSwitchView().turnOnNoCallback();
        } else {
            this.kLB.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kLw != null && this.kLw.getPageContext() != null && this.kLw.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kLw.getPageContext(), i);
            }
            if (this.gAv != null) {
                this.gAv.onChangeSkinType(this.kLw.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.kLw.getPageContext(), i);
            }
            if (this.kLB != null) {
                this.kLB.qJ(i);
            }
            if (this.kLC != null) {
                ap.setBackgroundColor(this.kLC, R.color.CAM_X0205);
            }
            this.kLw.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.kLw.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void CY(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kLw.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.pz(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(i));
        this.mNoDataView.onChangeSkinType(this.kLw.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cXN() {
        if (this.kLA != null) {
            this.kLA.setVisibility(0);
        }
    }

    public void cXO() {
        if (this.kLA != null) {
            this.kLA.setVisibility(8);
        }
    }
}
