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
import com.baidu.tieba.R;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView cbV;
    private NoNetworkView dlX;
    private LinearLayout ecP;
    private RecommendDetailActivity gIN;
    private HeadImageView gIO;
    private TextView gIP;
    private TextView gIQ;
    private LinearLayout gIR;
    private SettingTextSwitchView gIS;
    private View gIT;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.gIN = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.gIN != null) {
            this.gIN.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.gIN.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.gIN.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            yF(this.gIN.getResources().getString(R.string.recommend_detail_activity_title));
            this.dlX = (NoNetworkView) this.gIN.findViewById(R.id.view_no_network);
            this.ecP = (LinearLayout) this.gIN.findViewById(R.id.content_view);
            this.gIO = (HeadImageView) this.gIN.findViewById(R.id.user_image);
            this.gIO.setIsRound(true);
            this.cbV = (TextView) this.gIN.findViewById(R.id.user_name);
            this.gIP = (TextView) this.gIN.findViewById(R.id.user_type);
            this.gIQ = (TextView) this.gIN.findViewById(R.id.intro_content);
            this.gIS = (SettingTextSwitchView) this.gIN.findViewById(R.id.switch_view);
            this.gIS.setSwitchStateChangeListener(this.gIN);
            this.gIS.setVisibility(8);
            this.ecP.setVisibility(8);
            this.gIR = (LinearLayout) this.gIN.findViewById(R.id.switch_ll);
            this.gIT = this.gIN.findViewById(R.id.divider_1);
        }
    }

    public void yF(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.gIN != null) {
            this.gIO.startLoad(userInfoBigVip.portraith, 12, false);
            this.cbV.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.gIP.setText(userInfoBigVip.user_type);
            this.gIQ.setText(userInfoBigVip.user_detail);
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
            this.gIS.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.gIS.getSwitchView().mT();
        } else {
            this.gIS.getSwitchView().mU();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gIN != null && this.gIN.getPageContext() != null && this.gIN.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gIN.getPageContext(), i);
            }
            if (this.dlX != null) {
                this.dlX.onChangeSkinType(this.gIN.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.gIN.getPageContext(), i);
            }
            if (this.gIS != null) {
                this.gIS.jT(i);
            }
            if (this.gIT != null) {
                al.l(this.gIT, R.color.cp_bg_line_e);
            }
            this.gIN.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.gIN.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ecP.setVisibility(0);
    }

    public void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gIN.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.iH(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(i));
        this.mNoDataView.onChangeSkinType(this.gIN.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.ecP.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bDy() {
        if (this.gIR != null) {
            this.gIR.setVisibility(0);
        }
    }

    public void bDz() {
        if (this.gIR != null) {
            this.gIR.setVisibility(8);
        }
    }
}
