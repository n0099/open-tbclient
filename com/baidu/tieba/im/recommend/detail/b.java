package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView aqm;
    private NoNetworkView blp;
    private RecommendDetailActivity ehW;
    private HeadImageView ehX;
    private TextView ehY;
    private TextView ehZ;
    private LinearLayout eia;
    private SettingTextSwitchView eib;
    private LinearLayout eic;
    private View eid;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.ehW = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.ehW != null) {
            this.ehW.setContentView(d.i.recommend_detail_activity);
            this.mRootView = this.ehW.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.ehW.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            nR(this.ehW.getResources().getString(d.k.recommend_detail_activity_title));
            this.blp = (NoNetworkView) this.ehW.findViewById(d.g.view_no_network);
            this.eic = (LinearLayout) this.ehW.findViewById(d.g.content_view);
            this.ehX = (HeadImageView) this.ehW.findViewById(d.g.user_image);
            this.ehX.setIsRound(true);
            this.aqm = (TextView) this.ehW.findViewById(d.g.user_name);
            this.ehY = (TextView) this.ehW.findViewById(d.g.user_type);
            this.ehZ = (TextView) this.ehW.findViewById(d.g.intro_content);
            this.eib = (SettingTextSwitchView) this.ehW.findViewById(d.g.switch_view);
            this.eib.setSwitchStateChangeListener(this.ehW);
            this.eib.setVisibility(8);
            this.eic.setVisibility(8);
            this.eia = (LinearLayout) this.ehW.findViewById(d.g.switch_ll);
            this.eid = this.ehW.findViewById(d.g.divider_1);
        }
    }

    public void nR(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.ehW != null) {
            this.ehX.startLoad(userInfoBigVip.portraith, 12, false);
            this.aqm.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.ehY.setText(userInfoBigVip.user_type);
            this.ehZ.setText(userInfoBigVip.user_detail);
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
            this.eib.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eib.getSwitchView().jM();
        } else {
            this.eib.getSwitchView().jN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ehW != null && this.ehW.getPageContext() != null && this.ehW.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.ehW.getPageContext(), i);
            }
            if (this.blp != null) {
                this.blp.onChangeSkinType(this.ehW.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.ehW.getPageContext(), i);
            }
            if (this.eib != null) {
                this.eib.eq(i);
            }
            if (this.eid != null) {
                ak.j(this.eid, d.C0126d.cp_bg_line_e);
            }
            this.ehW.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.ehW.getPageContext().getLayoutMode().u(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eic.setVisibility(0);
    }

    public void ii(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ehW.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds320)), NoDataViewFactory.d.dp(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(i));
        this.mNoDataView.onChangeSkinType(this.ehW.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.eic.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aGI() {
        if (this.eia != null) {
            this.eia.setVisibility(0);
        }
    }

    public void aGJ() {
        if (this.eia != null) {
            this.eia.setVisibility(8);
        }
    }
}
