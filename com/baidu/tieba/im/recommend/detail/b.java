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
    private TextView cbW;
    private NoNetworkView dlX;
    private LinearLayout ecP;
    private RecommendDetailActivity gIP;
    private HeadImageView gIQ;
    private TextView gIR;
    private TextView gIS;
    private LinearLayout gIT;
    private SettingTextSwitchView gIU;
    private View gIV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.gIP = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.gIP != null) {
            this.gIP.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.gIP.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.gIP.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            yH(this.gIP.getResources().getString(R.string.recommend_detail_activity_title));
            this.dlX = (NoNetworkView) this.gIP.findViewById(R.id.view_no_network);
            this.ecP = (LinearLayout) this.gIP.findViewById(R.id.content_view);
            this.gIQ = (HeadImageView) this.gIP.findViewById(R.id.user_image);
            this.gIQ.setIsRound(true);
            this.cbW = (TextView) this.gIP.findViewById(R.id.user_name);
            this.gIR = (TextView) this.gIP.findViewById(R.id.user_type);
            this.gIS = (TextView) this.gIP.findViewById(R.id.intro_content);
            this.gIU = (SettingTextSwitchView) this.gIP.findViewById(R.id.switch_view);
            this.gIU.setSwitchStateChangeListener(this.gIP);
            this.gIU.setVisibility(8);
            this.ecP.setVisibility(8);
            this.gIT = (LinearLayout) this.gIP.findViewById(R.id.switch_ll);
            this.gIV = this.gIP.findViewById(R.id.divider_1);
        }
    }

    public void yH(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.gIP != null) {
            this.gIQ.startLoad(userInfoBigVip.portraith, 12, false);
            this.cbW.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.gIR.setText(userInfoBigVip.user_type);
            this.gIS.setText(userInfoBigVip.user_detail);
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
            this.gIU.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.gIU.getSwitchView().mT();
        } else {
            this.gIU.getSwitchView().mU();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gIP != null && this.gIP.getPageContext() != null && this.gIP.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gIP.getPageContext(), i);
            }
            if (this.dlX != null) {
                this.dlX.onChangeSkinType(this.gIP.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.gIP.getPageContext(), i);
            }
            if (this.gIU != null) {
                this.gIU.jT(i);
            }
            if (this.gIV != null) {
                al.l(this.gIV, R.color.cp_bg_line_e);
            }
            this.gIP.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.gIP.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
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
            this.mNoDataView = NoDataViewFactory.a(this.gIP.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.iH(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(i));
        this.mNoDataView.onChangeSkinType(this.gIP.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.ecP.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bDz() {
        if (this.gIT != null) {
            this.gIT.setVisibility(0);
        }
    }

    public void bDA() {
        if (this.gIT != null) {
            this.gIT.setVisibility(8);
        }
    }
}
