package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
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
    private TextView aqm;
    private NoNetworkView bla;
    private RecommendDetailActivity egP;
    private HeadImageView egQ;
    private TextView egR;
    private TextView egS;
    private LinearLayout egT;
    private SettingTextSwitchView egU;
    private LinearLayout egV;
    private View egW;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.egP = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.egP != null) {
            this.egP.setContentView(d.i.recommend_detail_activity);
            this.mRootView = this.egP.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.egP.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            nO(this.egP.getResources().getString(d.k.recommend_detail_activity_title));
            this.bla = (NoNetworkView) this.egP.findViewById(d.g.view_no_network);
            this.egV = (LinearLayout) this.egP.findViewById(d.g.content_view);
            this.egQ = (HeadImageView) this.egP.findViewById(d.g.user_image);
            this.egQ.setIsRound(true);
            this.aqm = (TextView) this.egP.findViewById(d.g.user_name);
            this.egR = (TextView) this.egP.findViewById(d.g.user_type);
            this.egS = (TextView) this.egP.findViewById(d.g.intro_content);
            this.egU = (SettingTextSwitchView) this.egP.findViewById(d.g.switch_view);
            this.egU.setSwitchStateChangeListener(this.egP);
            this.egU.setVisibility(8);
            this.egV.setVisibility(8);
            this.egT = (LinearLayout) this.egP.findViewById(d.g.switch_ll);
            this.egW = this.egP.findViewById(d.g.divider_1);
        }
    }

    public void nO(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.egP != null) {
            this.egQ.startLoad(userInfoBigVip.portraith, 12, false);
            this.aqm.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.egR.setText(userInfoBigVip.user_type);
            this.egS.setText(userInfoBigVip.user_detail);
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
            this.egU.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.egU.getSwitchView().jM();
        } else {
            this.egU.getSwitchView().jN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.egP != null && this.egP.getPageContext() != null && this.egP.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.egP.getPageContext(), i);
            }
            if (this.bla != null) {
                this.bla.onChangeSkinType(this.egP.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.egP.getPageContext(), i);
            }
            if (this.egU != null) {
                this.egU.ep(i);
            }
            if (this.egW != null) {
                ak.j(this.egW, d.C0126d.cp_bg_line_e);
            }
            this.egP.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.egP.getPageContext().getLayoutMode().u(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.egV.setVisibility(0);
    }

    public void ij(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.egP.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds320)), NoDataViewFactory.d.m16do(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.m16do(i));
        this.mNoDataView.onChangeSkinType(this.egP.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.egV.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aGK() {
        if (this.egT != null) {
            this.egT.setVisibility(0);
        }
    }

    public void aGL() {
        if (this.egT != null) {
            this.egT.setVisibility(8);
        }
    }
}
