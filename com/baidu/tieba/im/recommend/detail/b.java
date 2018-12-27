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
    private TextView aKV;
    private NoNetworkView bOA;
    private LinearLayout cEN;
    private RecommendDetailActivity faR;
    private HeadImageView faS;
    private TextView faT;
    private TextView faU;
    private LinearLayout faV;
    private SettingTextSwitchView faW;
    private View faX;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.faR = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.faR != null) {
            this.faR.setContentView(e.h.recommend_detail_activity);
            this.mRootView = this.faR.findViewById(e.g.root_view);
            this.mNavigationBar = (NavigationBar) this.faR.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            qx(this.faR.getResources().getString(e.j.recommend_detail_activity_title));
            this.bOA = (NoNetworkView) this.faR.findViewById(e.g.view_no_network);
            this.cEN = (LinearLayout) this.faR.findViewById(e.g.content_view);
            this.faS = (HeadImageView) this.faR.findViewById(e.g.user_image);
            this.faS.setIsRound(true);
            this.aKV = (TextView) this.faR.findViewById(e.g.user_name);
            this.faT = (TextView) this.faR.findViewById(e.g.user_type);
            this.faU = (TextView) this.faR.findViewById(e.g.intro_content);
            this.faW = (SettingTextSwitchView) this.faR.findViewById(e.g.switch_view);
            this.faW.setSwitchStateChangeListener(this.faR);
            this.faW.setVisibility(8);
            this.cEN.setVisibility(8);
            this.faV = (LinearLayout) this.faR.findViewById(e.g.switch_ll);
            this.faX = this.faR.findViewById(e.g.divider_1);
        }
    }

    public void qx(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.faR != null) {
            this.faS.startLoad(userInfoBigVip.portraith, 12, false);
            this.aKV.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.faT.setText(userInfoBigVip.user_type);
            this.faU.setText(userInfoBigVip.user_detail);
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
            this.faW.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.faW.getSwitchView().nP();
        } else {
            this.faW.getSwitchView().nQ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.faR != null && this.faR.getPageContext() != null && this.faR.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.faR.getPageContext(), i);
            }
            if (this.bOA != null) {
                this.bOA.onChangeSkinType(this.faR.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.faR.getPageContext(), i);
            }
            if (this.faW != null) {
                this.faW.fv(i);
            }
            if (this.faX != null) {
                al.j(this.faX, e.d.cp_bg_line_e);
            }
            this.faR.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.faR.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.cEN.setVisibility(0);
    }

    public void kf(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.faR.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds320)), NoDataViewFactory.d.eq(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.onChangeSkinType(this.faR.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.cEN.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aUL() {
        if (this.faV != null) {
            this.faV.setVisibility(0);
        }
    }

    public void aUM() {
        if (this.faV != null) {
            this.faV.setVisibility(8);
        }
    }
}
