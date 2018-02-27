package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView beT;
    private NoNetworkView caX;
    private RecommendDetailActivity eLY;
    private HeadImageView eLZ;
    private TextView eMa;
    private TextView eMb;
    private SettingTextSwitchView eMc;
    private LinearLayout eMd;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.eLY = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.eLY != null) {
            this.eLY.setContentView(d.h.recommend_detail_activity);
            this.mRootView = this.eLY.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.eLY.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.caX = (NoNetworkView) this.eLY.findViewById(d.g.view_no_network);
            this.eMd = (LinearLayout) this.eLY.findViewById(d.g.content_view);
            this.eLZ = (HeadImageView) this.eLY.findViewById(d.g.user_image);
            this.beT = (TextView) this.eLY.findViewById(d.g.user_name);
            this.eMa = (TextView) this.eLY.findViewById(d.g.user_type);
            this.eMb = (TextView) this.eLY.findViewById(d.g.intro_content);
            this.eMc = (SettingTextSwitchView) this.eLY.findViewById(d.g.switch_view);
            this.eMc.setSwitchStateChangeListener(this.eLY);
            this.eMc.setVisibility(8);
            this.eMd.setVisibility(8);
        }
    }

    public void nK(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.eLY != null) {
            this.eLZ.startLoad(userInfoBigVip.portraith, 12, false);
            this.beT.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.eMa.setText(userInfoBigVip.user_type);
            this.eMb.setText(userInfoBigVip.user_detail);
            if (z) {
                if (userInfoBigVip.message_accept.intValue() == 1) {
                    setSwitch(true);
                    TbadkCoreApplication.getInst().setPromotedMessage(true);
                } else {
                    setSwitch(false);
                    TbadkCoreApplication.getInst().setPromotedMessage(false);
                }
            } else if (TbadkCoreApplication.getInst().isPromotedMessageOn()) {
                setSwitch(true);
            } else {
                setSwitch(false);
            }
            this.eMc.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eMc.getSwitchView().rH();
        } else {
            this.eMc.getSwitchView().rI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eLY != null && this.eLY.getPageContext() != null && this.eLY.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eLY.getPageContext(), i);
            }
            if (this.caX != null) {
                this.caX.onChangeSkinType(this.eLY.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eLY.getPageContext(), i);
            }
            if (this.eMc != null) {
                this.eMc.hr(i);
            }
            this.eLY.getPageContext().getLayoutMode().aQ(i == 1);
            this.eLY.getPageContext().getLayoutMode().aM(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eMd.setVisibility(0);
    }

    public void lc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eLY.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gp(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(i));
        this.mNoDataView.onChangeSkinType(this.eLY.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.eMd.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }
}
