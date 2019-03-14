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
    private TextView bTY;
    private LinearLayout dSX;
    private NoNetworkView dbm;
    private RecommendDetailActivity grL;
    private HeadImageView grM;
    private TextView grN;
    private TextView grO;
    private LinearLayout grP;
    private SettingTextSwitchView grQ;
    private View grR;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.grL = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.grL != null) {
            this.grL.setContentView(d.h.recommend_detail_activity);
            this.mRootView = this.grL.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.grL.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            xr(this.grL.getResources().getString(d.j.recommend_detail_activity_title));
            this.dbm = (NoNetworkView) this.grL.findViewById(d.g.view_no_network);
            this.dSX = (LinearLayout) this.grL.findViewById(d.g.content_view);
            this.grM = (HeadImageView) this.grL.findViewById(d.g.user_image);
            this.grM.setIsRound(true);
            this.bTY = (TextView) this.grL.findViewById(d.g.user_name);
            this.grN = (TextView) this.grL.findViewById(d.g.user_type);
            this.grO = (TextView) this.grL.findViewById(d.g.intro_content);
            this.grQ = (SettingTextSwitchView) this.grL.findViewById(d.g.switch_view);
            this.grQ.setSwitchStateChangeListener(this.grL);
            this.grQ.setVisibility(8);
            this.dSX.setVisibility(8);
            this.grP = (LinearLayout) this.grL.findViewById(d.g.switch_ll);
            this.grR = this.grL.findViewById(d.g.divider_1);
        }
    }

    public void xr(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.grL != null) {
            this.grM.startLoad(userInfoBigVip.portraith, 12, false);
            this.bTY.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.grN.setText(userInfoBigVip.user_type);
            this.grO.setText(userInfoBigVip.user_detail);
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
            this.grQ.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.grQ.getSwitchView().nY();
        } else {
            this.grQ.getSwitchView().nZ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.grL != null && this.grL.getPageContext() != null && this.grL.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.grL.getPageContext(), i);
            }
            if (this.dbm != null) {
                this.dbm.onChangeSkinType(this.grL.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.grL.getPageContext(), i);
            }
            if (this.grQ != null) {
                this.grQ.jg(i);
            }
            if (this.grR != null) {
                al.l(this.grR, d.C0277d.cp_bg_line_e);
            }
            this.grL.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.grL.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dSX.setVisibility(0);
    }

    public void nS(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.grL.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds320)), NoDataViewFactory.d.hU(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(i));
        this.mNoDataView.onChangeSkinType(this.grL.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.dSX.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bvQ() {
        if (this.grP != null) {
            this.grP.setVisibility(0);
        }
    }

    public void bvR() {
        if (this.grP != null) {
            this.grP.setVisibility(8);
        }
    }
}
