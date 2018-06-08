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
    private TextView ayt;
    private NoNetworkView btu;
    private RecommendDetailActivity etn;
    private HeadImageView eto;
    private TextView etp;
    private TextView etq;
    private LinearLayout etr;
    private SettingTextSwitchView ets;
    private LinearLayout ett;
    private View etu;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.etn = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.etn != null) {
            this.etn.setContentView(d.i.recommend_detail_activity);
            this.mRootView = this.etn.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.etn.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            oF(this.etn.getResources().getString(d.k.recommend_detail_activity_title));
            this.btu = (NoNetworkView) this.etn.findViewById(d.g.view_no_network);
            this.ett = (LinearLayout) this.etn.findViewById(d.g.content_view);
            this.eto = (HeadImageView) this.etn.findViewById(d.g.user_image);
            this.eto.setIsRound(true);
            this.ayt = (TextView) this.etn.findViewById(d.g.user_name);
            this.etp = (TextView) this.etn.findViewById(d.g.user_type);
            this.etq = (TextView) this.etn.findViewById(d.g.intro_content);
            this.ets = (SettingTextSwitchView) this.etn.findViewById(d.g.switch_view);
            this.ets.setSwitchStateChangeListener(this.etn);
            this.ets.setVisibility(8);
            this.ett.setVisibility(8);
            this.etr = (LinearLayout) this.etn.findViewById(d.g.switch_ll);
            this.etu = this.etn.findViewById(d.g.divider_1);
        }
    }

    public void oF(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.etn != null) {
            this.eto.startLoad(userInfoBigVip.portraith, 12, false);
            this.ayt.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.etp.setText(userInfoBigVip.user_type);
            this.etq.setText(userInfoBigVip.user_detail);
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
            this.ets.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.ets.getSwitchView().mA();
        } else {
            this.ets.getSwitchView().mB();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.etn != null && this.etn.getPageContext() != null && this.etn.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.etn.getPageContext(), i);
            }
            if (this.btu != null) {
                this.btu.onChangeSkinType(this.etn.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.etn.getPageContext(), i);
            }
            if (this.ets != null) {
                this.ets.eu(i);
            }
            if (this.etu != null) {
                al.j(this.etu, d.C0141d.cp_bg_line_e);
            }
            this.etn.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.etn.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ett.setVisibility(0);
    }

    public void ij(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.etn.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds320)), NoDataViewFactory.d.dr(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(i));
        this.mNoDataView.onChangeSkinType(this.etn.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.ett.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aLD() {
        if (this.etr != null) {
            this.etr.setVisibility(0);
        }
    }

    public void aLE() {
        if (this.etr != null) {
            this.etr.setVisibility(8);
        }
    }
}
