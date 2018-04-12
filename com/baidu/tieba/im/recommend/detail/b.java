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
    private NoNetworkView bla;
    private RecommendDetailActivity egS;
    private HeadImageView egT;
    private TextView egU;
    private TextView egV;
    private LinearLayout egW;
    private SettingTextSwitchView egX;
    private LinearLayout egY;
    private View egZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.egS = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.egS != null) {
            this.egS.setContentView(d.i.recommend_detail_activity);
            this.mRootView = this.egS.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.egS.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            nO(this.egS.getResources().getString(d.k.recommend_detail_activity_title));
            this.bla = (NoNetworkView) this.egS.findViewById(d.g.view_no_network);
            this.egY = (LinearLayout) this.egS.findViewById(d.g.content_view);
            this.egT = (HeadImageView) this.egS.findViewById(d.g.user_image);
            this.egT.setIsRound(true);
            this.aqm = (TextView) this.egS.findViewById(d.g.user_name);
            this.egU = (TextView) this.egS.findViewById(d.g.user_type);
            this.egV = (TextView) this.egS.findViewById(d.g.intro_content);
            this.egX = (SettingTextSwitchView) this.egS.findViewById(d.g.switch_view);
            this.egX.setSwitchStateChangeListener(this.egS);
            this.egX.setVisibility(8);
            this.egY.setVisibility(8);
            this.egW = (LinearLayout) this.egS.findViewById(d.g.switch_ll);
            this.egZ = this.egS.findViewById(d.g.divider_1);
        }
    }

    public void nO(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.egS != null) {
            this.egT.startLoad(userInfoBigVip.portraith, 12, false);
            this.aqm.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.egU.setText(userInfoBigVip.user_type);
            this.egV.setText(userInfoBigVip.user_detail);
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
            this.egX.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.egX.getSwitchView().jM();
        } else {
            this.egX.getSwitchView().jN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.egS != null && this.egS.getPageContext() != null && this.egS.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.egS.getPageContext(), i);
            }
            if (this.bla != null) {
                this.bla.onChangeSkinType(this.egS.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.egS.getPageContext(), i);
            }
            if (this.egX != null) {
                this.egX.eq(i);
            }
            if (this.egZ != null) {
                ak.j(this.egZ, d.C0126d.cp_bg_line_e);
            }
            this.egS.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.egS.getPageContext().getLayoutMode().u(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.egY.setVisibility(0);
    }

    public void ik(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.egS.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds320)), NoDataViewFactory.d.dp(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(i));
        this.mNoDataView.onChangeSkinType(this.egS.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.egY.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aGK() {
        if (this.egW != null) {
            this.egW.setVisibility(0);
        }
    }

    public void aGL() {
        if (this.egW != null) {
            this.egW.setVisibility(8);
        }
    }
}
