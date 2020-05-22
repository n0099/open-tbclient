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
import com.baidu.tieba.R;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes13.dex */
public class b {
    private TextView dXU;
    private NoNetworkView fbX;
    private RecommendDetailActivity iIR;
    private HeadImageView iIS;
    private TextView iIT;
    private TextView iIU;
    private LinearLayout iIV;
    private SettingTextSwitchView iIW;
    private View iIX;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.iIR = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.iIR != null) {
            this.iIR.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.iIR.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.iIR.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            GO(this.iIR.getResources().getString(R.string.recommend_detail_activity_title));
            this.fbX = (NoNetworkView) this.iIR.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.iIR.findViewById(R.id.content_view);
            this.iIS = (HeadImageView) this.iIR.findViewById(R.id.user_image);
            this.iIS.setIsRound(true);
            this.dXU = (TextView) this.iIR.findViewById(R.id.user_name);
            this.iIT = (TextView) this.iIR.findViewById(R.id.user_type);
            this.iIU = (TextView) this.iIR.findViewById(R.id.intro_content);
            this.iIW = (SettingTextSwitchView) this.iIR.findViewById(R.id.switch_view);
            this.iIW.setSwitchStateChangeListener(this.iIR);
            this.iIW.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.iIV = (LinearLayout) this.iIR.findViewById(R.id.switch_ll);
            this.iIX = this.iIR.findViewById(R.id.divider_1);
        }
    }

    public void GO(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.iIR != null) {
            this.iIS.startLoad(userInfoBigVip.portraith, 12, false);
            this.dXU.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.iIT.setText(userInfoBigVip.user_type);
            this.iIU.setText(userInfoBigVip.user_detail);
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
            this.iIW.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.iIW.getSwitchView().turnOnNoCallback();
        } else {
            this.iIW.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iIR != null && this.iIR.getPageContext() != null && this.iIR.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.iIR.getPageContext(), i);
            }
            if (this.fbX != null) {
                this.fbX.onChangeSkinType(this.iIR.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.iIR.getPageContext(), i);
            }
            if (this.iIW != null) {
                this.iIW.mU(i);
            }
            if (this.iIX != null) {
                am.setBackgroundColor(this.iIX, R.color.cp_bg_line_e);
            }
            this.iIR.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.iIR.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void xA(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iIR.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.lT(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lT(i));
        this.mNoDataView.onChangeSkinType(this.iIR.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cpf() {
        if (this.iIV != null) {
            this.iIV.setVisibility(0);
        }
    }

    public void cpg() {
        if (this.iIV != null) {
            this.iIV.setVisibility(8);
        }
    }
}
