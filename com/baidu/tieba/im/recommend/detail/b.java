package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.e;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView aGD;
    private NoNetworkView bJX;
    private LinearLayout cyN;
    private RecommendDetailActivity ePS;
    private HeadImageView ePT;
    private TextView ePU;
    private TextView ePV;
    private LinearLayout ePW;
    private SettingTextSwitchView ePX;
    private View ePY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.ePS = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.ePS != null) {
            this.ePS.setContentView(e.h.recommend_detail_activity);
            this.mRootView = this.ePS.findViewById(e.g.root_view);
            this.mNavigationBar = (NavigationBar) this.ePS.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            pR(this.ePS.getResources().getString(e.j.recommend_detail_activity_title));
            this.bJX = (NoNetworkView) this.ePS.findViewById(e.g.view_no_network);
            this.cyN = (LinearLayout) this.ePS.findViewById(e.g.content_view);
            this.ePT = (HeadImageView) this.ePS.findViewById(e.g.user_image);
            this.ePT.setIsRound(true);
            this.aGD = (TextView) this.ePS.findViewById(e.g.user_name);
            this.ePU = (TextView) this.ePS.findViewById(e.g.user_type);
            this.ePV = (TextView) this.ePS.findViewById(e.g.intro_content);
            this.ePX = (SettingTextSwitchView) this.ePS.findViewById(e.g.switch_view);
            this.ePX.setSwitchStateChangeListener(this.ePS);
            this.ePX.setVisibility(8);
            this.cyN.setVisibility(8);
            this.ePW = (LinearLayout) this.ePS.findViewById(e.g.switch_ll);
            this.ePY = this.ePS.findViewById(e.g.divider_1);
        }
    }

    public void pR(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.ePS != null) {
            this.ePT.startLoad(userInfoBigVip.portraith, 12, false);
            this.aGD.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.ePU.setText(userInfoBigVip.user_type);
            this.ePV.setText(userInfoBigVip.user_detail);
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
            this.ePX.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.ePX.getSwitchView().nS();
        } else {
            this.ePX.getSwitchView().nT();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ePS != null && this.ePS.getPageContext() != null && this.ePS.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.ePS.getPageContext(), i);
            }
            if (this.bJX != null) {
                this.bJX.onChangeSkinType(this.ePS.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.ePS.getPageContext(), i);
            }
            if (this.ePX != null) {
                this.ePX.eS(i);
            }
            if (this.ePY != null) {
                al.j(this.ePY, e.d.cp_bg_line_e);
            }
            this.ePS.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.ePS.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.cyN.setVisibility(0);
    }

    public void jq(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ePS.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds320)), NoDataViewFactory.d.dO(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(i));
        this.mNoDataView.onChangeSkinType(this.ePS.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.cyN.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aSJ() {
        if (this.ePW != null) {
            this.ePW.setVisibility(0);
        }
    }

    public void aSK() {
        if (this.ePW != null) {
            this.ePW.setVisibility(8);
        }
    }
}
