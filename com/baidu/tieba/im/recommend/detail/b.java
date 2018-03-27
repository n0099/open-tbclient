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
    private TextView beW;
    private NoNetworkView cba;
    private RecommendDetailActivity eMo;
    private HeadImageView eMp;
    private TextView eMq;
    private TextView eMr;
    private SettingTextSwitchView eMs;
    private LinearLayout eMt;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.eMo = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.eMo != null) {
            this.eMo.setContentView(d.h.recommend_detail_activity);
            this.mRootView = this.eMo.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.eMo.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cba = (NoNetworkView) this.eMo.findViewById(d.g.view_no_network);
            this.eMt = (LinearLayout) this.eMo.findViewById(d.g.content_view);
            this.eMp = (HeadImageView) this.eMo.findViewById(d.g.user_image);
            this.beW = (TextView) this.eMo.findViewById(d.g.user_name);
            this.eMq = (TextView) this.eMo.findViewById(d.g.user_type);
            this.eMr = (TextView) this.eMo.findViewById(d.g.intro_content);
            this.eMs = (SettingTextSwitchView) this.eMo.findViewById(d.g.switch_view);
            this.eMs.setSwitchStateChangeListener(this.eMo);
            this.eMs.setVisibility(8);
            this.eMt.setVisibility(8);
        }
    }

    public void nK(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.eMo != null) {
            this.eMp.startLoad(userInfoBigVip.portraith, 12, false);
            this.beW.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.eMq.setText(userInfoBigVip.user_type);
            this.eMr.setText(userInfoBigVip.user_detail);
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
            this.eMs.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eMs.getSwitchView().rH();
        } else {
            this.eMs.getSwitchView().rI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eMo != null && this.eMo.getPageContext() != null && this.eMo.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eMo.getPageContext(), i);
            }
            if (this.cba != null) {
                this.cba.onChangeSkinType(this.eMo.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eMo.getPageContext(), i);
            }
            if (this.eMs != null) {
                this.eMs.hr(i);
            }
            this.eMo.getPageContext().getLayoutMode().aQ(i == 1);
            this.eMo.getPageContext().getLayoutMode().aM(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eMt.setVisibility(0);
    }

    public void lc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eMo.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gp(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(i));
        this.mNoDataView.onChangeSkinType(this.eMo.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.eMt.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }
}
