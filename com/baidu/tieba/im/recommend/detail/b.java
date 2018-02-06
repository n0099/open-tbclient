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
    private TextView bfg;
    private NoNetworkView cbj;
    private RecommendDetailActivity eMk;
    private HeadImageView eMl;
    private TextView eMm;
    private TextView eMn;
    private SettingTextSwitchView eMo;
    private LinearLayout eMp;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.eMk = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.eMk != null) {
            this.eMk.setContentView(d.h.recommend_detail_activity);
            this.mRootView = this.eMk.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.eMk.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cbj = (NoNetworkView) this.eMk.findViewById(d.g.view_no_network);
            this.eMp = (LinearLayout) this.eMk.findViewById(d.g.content_view);
            this.eMl = (HeadImageView) this.eMk.findViewById(d.g.user_image);
            this.bfg = (TextView) this.eMk.findViewById(d.g.user_name);
            this.eMm = (TextView) this.eMk.findViewById(d.g.user_type);
            this.eMn = (TextView) this.eMk.findViewById(d.g.intro_content);
            this.eMo = (SettingTextSwitchView) this.eMk.findViewById(d.g.switch_view);
            this.eMo.setSwitchStateChangeListener(this.eMk);
            this.eMo.setVisibility(8);
            this.eMp.setVisibility(8);
        }
    }

    public void nK(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.eMk != null) {
            this.eMl.startLoad(userInfoBigVip.portraith, 12, false);
            this.bfg.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.eMm.setText(userInfoBigVip.user_type);
            this.eMn.setText(userInfoBigVip.user_detail);
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
            this.eMo.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eMo.getSwitchView().rH();
        } else {
            this.eMo.getSwitchView().rI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eMk != null && this.eMk.getPageContext() != null && this.eMk.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eMk.getPageContext(), i);
            }
            if (this.cbj != null) {
                this.cbj.onChangeSkinType(this.eMk.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eMk.getPageContext(), i);
            }
            if (this.eMo != null) {
                this.eMo.hr(i);
            }
            this.eMk.getPageContext().getLayoutMode().aQ(i == 1);
            this.eMk.getPageContext().getLayoutMode().aM(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eMp.setVisibility(0);
    }

    public void lc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eMk.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gp(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(i));
        this.mNoDataView.onChangeSkinType(this.eMk.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.eMp.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }
}
