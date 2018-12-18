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
    private TextView aKT;
    private NoNetworkView bOx;
    private LinearLayout cDN;
    private RecommendDetailActivity eYa;
    private HeadImageView eYb;
    private TextView eYc;
    private TextView eYd;
    private LinearLayout eYe;
    private SettingTextSwitchView eYf;
    private View eYg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.eYa = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.eYa != null) {
            this.eYa.setContentView(e.h.recommend_detail_activity);
            this.mRootView = this.eYa.findViewById(e.g.root_view);
            this.mNavigationBar = (NavigationBar) this.eYa.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            qu(this.eYa.getResources().getString(e.j.recommend_detail_activity_title));
            this.bOx = (NoNetworkView) this.eYa.findViewById(e.g.view_no_network);
            this.cDN = (LinearLayout) this.eYa.findViewById(e.g.content_view);
            this.eYb = (HeadImageView) this.eYa.findViewById(e.g.user_image);
            this.eYb.setIsRound(true);
            this.aKT = (TextView) this.eYa.findViewById(e.g.user_name);
            this.eYc = (TextView) this.eYa.findViewById(e.g.user_type);
            this.eYd = (TextView) this.eYa.findViewById(e.g.intro_content);
            this.eYf = (SettingTextSwitchView) this.eYa.findViewById(e.g.switch_view);
            this.eYf.setSwitchStateChangeListener(this.eYa);
            this.eYf.setVisibility(8);
            this.cDN.setVisibility(8);
            this.eYe = (LinearLayout) this.eYa.findViewById(e.g.switch_ll);
            this.eYg = this.eYa.findViewById(e.g.divider_1);
        }
    }

    public void qu(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.eYa != null) {
            this.eYb.startLoad(userInfoBigVip.portraith, 12, false);
            this.aKT.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.eYc.setText(userInfoBigVip.user_type);
            this.eYd.setText(userInfoBigVip.user_detail);
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
            this.eYf.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eYf.getSwitchView().nP();
        } else {
            this.eYf.getSwitchView().nQ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eYa != null && this.eYa.getPageContext() != null && this.eYa.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eYa.getPageContext(), i);
            }
            if (this.bOx != null) {
                this.bOx.onChangeSkinType(this.eYa.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eYa.getPageContext(), i);
            }
            if (this.eYf != null) {
                this.eYf.fu(i);
            }
            if (this.eYg != null) {
                al.j(this.eYg, e.d.cp_bg_line_e);
            }
            this.eYa.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.eYa.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.cDN.setVisibility(0);
    }

    public void jX(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eYa.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds320)), NoDataViewFactory.d.eq(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.onChangeSkinType(this.eYa.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.cDN.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aTX() {
        if (this.eYe != null) {
            this.eYe.setVisibility(0);
        }
    }

    public void aTY() {
        if (this.eYe != null) {
            this.eYe.setVisibility(8);
        }
    }
}
