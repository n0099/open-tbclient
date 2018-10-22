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
    private TextView aGD;
    private NoNetworkView bJX;
    private LinearLayout cyN;
    private RecommendDetailActivity ePT;
    private HeadImageView ePU;
    private TextView ePV;
    private TextView ePW;
    private LinearLayout ePX;
    private SettingTextSwitchView ePY;
    private View ePZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.ePT = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.ePT != null) {
            this.ePT.setContentView(e.h.recommend_detail_activity);
            this.mRootView = this.ePT.findViewById(e.g.root_view);
            this.mNavigationBar = (NavigationBar) this.ePT.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            pR(this.ePT.getResources().getString(e.j.recommend_detail_activity_title));
            this.bJX = (NoNetworkView) this.ePT.findViewById(e.g.view_no_network);
            this.cyN = (LinearLayout) this.ePT.findViewById(e.g.content_view);
            this.ePU = (HeadImageView) this.ePT.findViewById(e.g.user_image);
            this.ePU.setIsRound(true);
            this.aGD = (TextView) this.ePT.findViewById(e.g.user_name);
            this.ePV = (TextView) this.ePT.findViewById(e.g.user_type);
            this.ePW = (TextView) this.ePT.findViewById(e.g.intro_content);
            this.ePY = (SettingTextSwitchView) this.ePT.findViewById(e.g.switch_view);
            this.ePY.setSwitchStateChangeListener(this.ePT);
            this.ePY.setVisibility(8);
            this.cyN.setVisibility(8);
            this.ePX = (LinearLayout) this.ePT.findViewById(e.g.switch_ll);
            this.ePZ = this.ePT.findViewById(e.g.divider_1);
        }
    }

    public void pR(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.ePT != null) {
            this.ePU.startLoad(userInfoBigVip.portraith, 12, false);
            this.aGD.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.ePV.setText(userInfoBigVip.user_type);
            this.ePW.setText(userInfoBigVip.user_detail);
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
            this.ePY.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.ePY.getSwitchView().nS();
        } else {
            this.ePY.getSwitchView().nT();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ePT != null && this.ePT.getPageContext() != null && this.ePT.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.ePT.getPageContext(), i);
            }
            if (this.bJX != null) {
                this.bJX.onChangeSkinType(this.ePT.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.ePT.getPageContext(), i);
            }
            if (this.ePY != null) {
                this.ePY.eS(i);
            }
            if (this.ePZ != null) {
                al.j(this.ePZ, e.d.cp_bg_line_e);
            }
            this.ePT.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.ePT.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.cyN.setVisibility(0);
    }

    public void jq(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ePT.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds320)), NoDataViewFactory.d.dO(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(i));
        this.mNoDataView.onChangeSkinType(this.ePT.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.cyN.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aSJ() {
        if (this.ePX != null) {
            this.ePX.setVisibility(0);
        }
    }

    public void aSK() {
        if (this.ePX != null) {
            this.ePX.setVisibility(8);
        }
    }
}
