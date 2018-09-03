package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.f;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView ayV;
    private NoNetworkView bvB;
    private LinearLayout cks;
    private RecommendDetailActivity eAS;
    private HeadImageView eAT;
    private TextView eAU;
    private TextView eAV;
    private LinearLayout eAW;
    private SettingTextSwitchView eAX;
    private View eAY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.eAS = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.eAS != null) {
            this.eAS.setContentView(f.h.recommend_detail_activity);
            this.mRootView = this.eAS.findViewById(f.g.root_view);
            this.mNavigationBar = (NavigationBar) this.eAS.findViewById(f.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            oK(this.eAS.getResources().getString(f.j.recommend_detail_activity_title));
            this.bvB = (NoNetworkView) this.eAS.findViewById(f.g.view_no_network);
            this.cks = (LinearLayout) this.eAS.findViewById(f.g.content_view);
            this.eAT = (HeadImageView) this.eAS.findViewById(f.g.user_image);
            this.eAT.setIsRound(true);
            this.ayV = (TextView) this.eAS.findViewById(f.g.user_name);
            this.eAU = (TextView) this.eAS.findViewById(f.g.user_type);
            this.eAV = (TextView) this.eAS.findViewById(f.g.intro_content);
            this.eAX = (SettingTextSwitchView) this.eAS.findViewById(f.g.switch_view);
            this.eAX.setSwitchStateChangeListener(this.eAS);
            this.eAX.setVisibility(8);
            this.cks.setVisibility(8);
            this.eAW = (LinearLayout) this.eAS.findViewById(f.g.switch_ll);
            this.eAY = this.eAS.findViewById(f.g.divider_1);
        }
    }

    public void oK(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.eAS != null) {
            this.eAT.startLoad(userInfoBigVip.portraith, 12, false);
            this.ayV.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.eAU.setText(userInfoBigVip.user_type);
            this.eAV.setText(userInfoBigVip.user_detail);
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
            this.eAX.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eAX.getSwitchView().mC();
        } else {
            this.eAX.getSwitchView().mD();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eAS != null && this.eAS.getPageContext() != null && this.eAS.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eAS.getPageContext(), i);
            }
            if (this.bvB != null) {
                this.bvB.onChangeSkinType(this.eAS.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eAS.getPageContext(), i);
            }
            if (this.eAX != null) {
                this.eAX.ex(i);
            }
            if (this.eAY != null) {
                am.j(this.eAY, f.d.cp_bg_line_e);
            }
            this.eAS.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.eAS.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.cks.setVisibility(0);
    }

    public void is(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eAS.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds320)), NoDataViewFactory.d.dt(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(i));
        this.mNoDataView.onChangeSkinType(this.eAS.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.cks.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aNg() {
        if (this.eAW != null) {
            this.eAW.setVisibility(0);
        }
    }

    public void aNh() {
        if (this.eAW != null) {
            this.eAW.setVisibility(8);
        }
    }
}
