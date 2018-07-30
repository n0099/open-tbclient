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
import com.baidu.tieba.d;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView ayY;
    private NoNetworkView bvz;
    private LinearLayout ckv;
    private RecommendDetailActivity eAW;
    private HeadImageView eAX;
    private TextView eAY;
    private TextView eAZ;
    private LinearLayout eBa;
    private SettingTextSwitchView eBb;
    private View eBc;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.eAW = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.eAW != null) {
            this.eAW.setContentView(d.h.recommend_detail_activity);
            this.mRootView = this.eAW.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.eAW.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            oI(this.eAW.getResources().getString(d.j.recommend_detail_activity_title));
            this.bvz = (NoNetworkView) this.eAW.findViewById(d.g.view_no_network);
            this.ckv = (LinearLayout) this.eAW.findViewById(d.g.content_view);
            this.eAX = (HeadImageView) this.eAW.findViewById(d.g.user_image);
            this.eAX.setIsRound(true);
            this.ayY = (TextView) this.eAW.findViewById(d.g.user_name);
            this.eAY = (TextView) this.eAW.findViewById(d.g.user_type);
            this.eAZ = (TextView) this.eAW.findViewById(d.g.intro_content);
            this.eBb = (SettingTextSwitchView) this.eAW.findViewById(d.g.switch_view);
            this.eBb.setSwitchStateChangeListener(this.eAW);
            this.eBb.setVisibility(8);
            this.ckv.setVisibility(8);
            this.eBa = (LinearLayout) this.eAW.findViewById(d.g.switch_ll);
            this.eBc = this.eAW.findViewById(d.g.divider_1);
        }
    }

    public void oI(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.eAW != null) {
            this.eAX.startLoad(userInfoBigVip.portraith, 12, false);
            this.ayY.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.eAY.setText(userInfoBigVip.user_type);
            this.eAZ.setText(userInfoBigVip.user_detail);
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
            this.eBb.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eBb.getSwitchView().mC();
        } else {
            this.eBb.getSwitchView().mD();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eAW != null && this.eAW.getPageContext() != null && this.eAW.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eAW.getPageContext(), i);
            }
            if (this.bvz != null) {
                this.bvz.onChangeSkinType(this.eAW.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eAW.getPageContext(), i);
            }
            if (this.eBb != null) {
                this.eBb.ey(i);
            }
            if (this.eBc != null) {
                am.j(this.eBc, d.C0140d.cp_bg_line_e);
            }
            this.eAW.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.eAW.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ckv.setVisibility(0);
    }

    public void it(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eAW.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds320)), NoDataViewFactory.d.du(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.du(i));
        this.mNoDataView.onChangeSkinType(this.eAW.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.ckv.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aNj() {
        if (this.eBa != null) {
            this.eBa.setVisibility(0);
        }
    }

    public void aNk() {
        if (this.eBa != null) {
            this.eBa.setVisibility(8);
        }
    }
}
