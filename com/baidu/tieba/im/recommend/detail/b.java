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
/* loaded from: classes3.dex */
public class b {
    private TextView cdg;
    private NoNetworkView dnM;
    private LinearLayout ehs;
    private RecommendDetailActivity gPR;
    private HeadImageView gPS;
    private TextView gPT;
    private TextView gPU;
    private LinearLayout gPV;
    private SettingTextSwitchView gPW;
    private View gPX;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.gPR = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.gPR != null) {
            this.gPR.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.gPR.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.gPR.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            zt(this.gPR.getResources().getString(R.string.recommend_detail_activity_title));
            this.dnM = (NoNetworkView) this.gPR.findViewById(R.id.view_no_network);
            this.ehs = (LinearLayout) this.gPR.findViewById(R.id.content_view);
            this.gPS = (HeadImageView) this.gPR.findViewById(R.id.user_image);
            this.gPS.setIsRound(true);
            this.cdg = (TextView) this.gPR.findViewById(R.id.user_name);
            this.gPT = (TextView) this.gPR.findViewById(R.id.user_type);
            this.gPU = (TextView) this.gPR.findViewById(R.id.intro_content);
            this.gPW = (SettingTextSwitchView) this.gPR.findViewById(R.id.switch_view);
            this.gPW.setSwitchStateChangeListener(this.gPR);
            this.gPW.setVisibility(8);
            this.ehs.setVisibility(8);
            this.gPV = (LinearLayout) this.gPR.findViewById(R.id.switch_ll);
            this.gPX = this.gPR.findViewById(R.id.divider_1);
        }
    }

    public void zt(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.gPR != null) {
            this.gPS.startLoad(userInfoBigVip.portraith, 12, false);
            this.cdg.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.gPT.setText(userInfoBigVip.user_type);
            this.gPU.setText(userInfoBigVip.user_detail);
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
            this.gPW.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.gPW.getSwitchView().nk();
        } else {
            this.gPW.getSwitchView().nl();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gPR != null && this.gPR.getPageContext() != null && this.gPR.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gPR.getPageContext(), i);
            }
            if (this.dnM != null) {
                this.dnM.onChangeSkinType(this.gPR.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.gPR.getPageContext(), i);
            }
            if (this.gPW != null) {
                this.gPW.ka(i);
            }
            if (this.gPX != null) {
                am.l(this.gPX, R.color.cp_bg_line_e);
            }
            this.gPR.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.gPR.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ehs.setVisibility(0);
    }

    public void oX(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gPR.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.iN(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(i));
        this.mNoDataView.onChangeSkinType(this.gPR.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.ehs.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bGu() {
        if (this.gPV != null) {
            this.gPV.setVisibility(0);
        }
    }

    public void bGv() {
        if (this.gPV != null) {
            this.gPV.setVisibility(8);
        }
    }
}
