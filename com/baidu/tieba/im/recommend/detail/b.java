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
    private TextView bUb;
    private LinearLayout dSp;
    private NoNetworkView dbr;
    private HeadImageView grA;
    private TextView grB;
    private TextView grC;
    private LinearLayout grD;
    private SettingTextSwitchView grE;
    private View grF;
    private RecommendDetailActivity grz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.grz = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.grz != null) {
            this.grz.setContentView(d.h.recommend_detail_activity);
            this.mRootView = this.grz.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.grz.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            xq(this.grz.getResources().getString(d.j.recommend_detail_activity_title));
            this.dbr = (NoNetworkView) this.grz.findViewById(d.g.view_no_network);
            this.dSp = (LinearLayout) this.grz.findViewById(d.g.content_view);
            this.grA = (HeadImageView) this.grz.findViewById(d.g.user_image);
            this.grA.setIsRound(true);
            this.bUb = (TextView) this.grz.findViewById(d.g.user_name);
            this.grB = (TextView) this.grz.findViewById(d.g.user_type);
            this.grC = (TextView) this.grz.findViewById(d.g.intro_content);
            this.grE = (SettingTextSwitchView) this.grz.findViewById(d.g.switch_view);
            this.grE.setSwitchStateChangeListener(this.grz);
            this.grE.setVisibility(8);
            this.dSp.setVisibility(8);
            this.grD = (LinearLayout) this.grz.findViewById(d.g.switch_ll);
            this.grF = this.grz.findViewById(d.g.divider_1);
        }
    }

    public void xq(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.grz != null) {
            this.grA.startLoad(userInfoBigVip.portraith, 12, false);
            this.bUb.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.grB.setText(userInfoBigVip.user_type);
            this.grC.setText(userInfoBigVip.user_detail);
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
            this.grE.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.grE.getSwitchView().nY();
        } else {
            this.grE.getSwitchView().nZ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.grz != null && this.grz.getPageContext() != null && this.grz.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.grz.getPageContext(), i);
            }
            if (this.dbr != null) {
                this.dbr.onChangeSkinType(this.grz.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.grz.getPageContext(), i);
            }
            if (this.grE != null) {
                this.grE.jf(i);
            }
            if (this.grF != null) {
                al.l(this.grF, d.C0277d.cp_bg_line_e);
            }
            this.grz.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.grz.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dSp.setVisibility(0);
    }

    public void nQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.grz.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds320)), NoDataViewFactory.d.hT(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(i));
        this.mNoDataView.onChangeSkinType(this.grz.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.dSp.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bvN() {
        if (this.grD != null) {
            this.grD.setVisibility(0);
        }
    }

    public void bvO() {
        if (this.grD != null) {
            this.grD.setVisibility(8);
        }
    }
}
