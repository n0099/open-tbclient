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
    private NoNetworkView dlW;
    private LinearLayout ecO;
    private RecommendDetailActivity gIM;
    private HeadImageView gIN;
    private TextView gIO;
    private TextView gIP;
    private LinearLayout gIQ;
    private SettingTextSwitchView gIR;
    private View gIS;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.gIM = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.gIM != null) {
            this.gIM.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.gIM.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.gIM.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            yF(this.gIM.getResources().getString(R.string.recommend_detail_activity_title));
            this.dlW = (NoNetworkView) this.gIM.findViewById(R.id.view_no_network);
            this.ecO = (LinearLayout) this.gIM.findViewById(R.id.content_view);
            this.gIN = (HeadImageView) this.gIM.findViewById(R.id.user_image);
            this.gIN.setIsRound(true);
            this.cbV = (TextView) this.gIM.findViewById(R.id.user_name);
            this.gIO = (TextView) this.gIM.findViewById(R.id.user_type);
            this.gIP = (TextView) this.gIM.findViewById(R.id.intro_content);
            this.gIR = (SettingTextSwitchView) this.gIM.findViewById(R.id.switch_view);
            this.gIR.setSwitchStateChangeListener(this.gIM);
            this.gIR.setVisibility(8);
            this.ecO.setVisibility(8);
            this.gIQ = (LinearLayout) this.gIM.findViewById(R.id.switch_ll);
            this.gIS = this.gIM.findViewById(R.id.divider_1);
        }
    }

    public void yF(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.gIM != null) {
            this.gIN.startLoad(userInfoBigVip.portraith, 12, false);
            this.cbV.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.gIO.setText(userInfoBigVip.user_type);
            this.gIP.setText(userInfoBigVip.user_detail);
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
            this.gIR.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.gIR.getSwitchView().mT();
        } else {
            this.gIR.getSwitchView().mU();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gIM != null && this.gIM.getPageContext() != null && this.gIM.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gIM.getPageContext(), i);
            }
            if (this.dlW != null) {
                this.dlW.onChangeSkinType(this.gIM.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.gIM.getPageContext(), i);
            }
            if (this.gIR != null) {
                this.gIR.jT(i);
            }
            if (this.gIS != null) {
                al.l(this.gIS, R.color.cp_bg_line_e);
            }
            this.gIM.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.gIM.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ecO.setVisibility(0);
    }

    public void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gIM.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.iH(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(i));
        this.mNoDataView.onChangeSkinType(this.gIM.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.ecO.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bDv() {
        if (this.gIQ != null) {
            this.gIQ.setVisibility(0);
        }
    }

    public void bDw() {
        if (this.gIQ != null) {
            this.gIQ.setVisibility(8);
        }
    }
}
