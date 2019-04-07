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
import com.baidu.tieba.d;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView bUa;
    private LinearLayout dSo;
    private NoNetworkView dbq;
    private TextView grA;
    private TextView grB;
    private LinearLayout grC;
    private SettingTextSwitchView grD;
    private View grE;
    private RecommendDetailActivity gry;
    private HeadImageView grz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.gry = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.gry != null) {
            this.gry.setContentView(d.h.recommend_detail_activity);
            this.mRootView = this.gry.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.gry.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            xq(this.gry.getResources().getString(d.j.recommend_detail_activity_title));
            this.dbq = (NoNetworkView) this.gry.findViewById(d.g.view_no_network);
            this.dSo = (LinearLayout) this.gry.findViewById(d.g.content_view);
            this.grz = (HeadImageView) this.gry.findViewById(d.g.user_image);
            this.grz.setIsRound(true);
            this.bUa = (TextView) this.gry.findViewById(d.g.user_name);
            this.grA = (TextView) this.gry.findViewById(d.g.user_type);
            this.grB = (TextView) this.gry.findViewById(d.g.intro_content);
            this.grD = (SettingTextSwitchView) this.gry.findViewById(d.g.switch_view);
            this.grD.setSwitchStateChangeListener(this.gry);
            this.grD.setVisibility(8);
            this.dSo.setVisibility(8);
            this.grC = (LinearLayout) this.gry.findViewById(d.g.switch_ll);
            this.grE = this.gry.findViewById(d.g.divider_1);
        }
    }

    public void xq(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.gry != null) {
            this.grz.startLoad(userInfoBigVip.portraith, 12, false);
            this.bUa.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.grA.setText(userInfoBigVip.user_type);
            this.grB.setText(userInfoBigVip.user_detail);
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
            this.grD.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.grD.getSwitchView().nY();
        } else {
            this.grD.getSwitchView().nZ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gry != null && this.gry.getPageContext() != null && this.gry.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gry.getPageContext(), i);
            }
            if (this.dbq != null) {
                this.dbq.onChangeSkinType(this.gry.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.gry.getPageContext(), i);
            }
            if (this.grD != null) {
                this.grD.jf(i);
            }
            if (this.grE != null) {
                al.l(this.grE, d.C0277d.cp_bg_line_e);
            }
            this.gry.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.gry.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dSo.setVisibility(0);
    }

    public void nQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gry.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds320)), NoDataViewFactory.d.hT(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(i));
        this.mNoDataView.onChangeSkinType(this.gry.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.dSo.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bvN() {
        if (this.grC != null) {
            this.grC.setVisibility(0);
        }
    }

    public void bvO() {
        if (this.grC != null) {
            this.grC.setVisibility(8);
        }
    }
}
