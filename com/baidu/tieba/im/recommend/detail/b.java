package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
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
    private TextView dEL;
    private NoNetworkView fns;
    private RecommendDetailActivity jaH;
    private HeadImageView jaI;
    private TextView jaJ;
    private TextView jaK;
    private LinearLayout jaL;
    private SettingTextSwitchView jaM;
    private View jaN;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.jaH = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.jaH != null) {
            this.jaH.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.jaH.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.jaH.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Hq(this.jaH.getResources().getString(R.string.recommend_detail_activity_title));
            this.fns = (NoNetworkView) this.jaH.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.jaH.findViewById(R.id.content_view);
            this.jaI = (HeadImageView) this.jaH.findViewById(R.id.user_image);
            this.jaI.setIsRound(true);
            this.dEL = (TextView) this.jaH.findViewById(R.id.user_name);
            this.jaJ = (TextView) this.jaH.findViewById(R.id.user_type);
            this.jaK = (TextView) this.jaH.findViewById(R.id.intro_content);
            this.jaM = (SettingTextSwitchView) this.jaH.findViewById(R.id.switch_view);
            this.jaM.setSwitchStateChangeListener(this.jaH);
            this.jaM.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.jaL = (LinearLayout) this.jaH.findViewById(R.id.switch_ll);
            this.jaN = this.jaH.findViewById(R.id.divider_1);
        }
    }

    public void Hq(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.jaH != null) {
            this.jaI.startLoad(userInfoBigVip.portraith, 12, false);
            this.dEL.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.jaJ.setText(userInfoBigVip.user_type);
            this.jaK.setText(userInfoBigVip.user_detail);
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
            this.jaM.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.jaM.getSwitchView().turnOnNoCallback();
        } else {
            this.jaM.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jaH != null && this.jaH.getPageContext() != null && this.jaH.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jaH.getPageContext(), i);
            }
            if (this.fns != null) {
                this.fns.onChangeSkinType(this.jaH.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.jaH.getPageContext(), i);
            }
            if (this.jaM != null) {
                this.jaM.nq(i);
            }
            if (this.jaN != null) {
                an.setBackgroundColor(this.jaN, R.color.cp_bg_line_e);
            }
            this.jaH.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.jaH.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void ym(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jaH.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.mm(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.mm(i));
        this.mNoDataView.onChangeSkinType(this.jaH.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void ctd() {
        if (this.jaL != null) {
            this.jaL.setVisibility(0);
        }
    }

    public void cte() {
        if (this.jaL != null) {
            this.jaL.setVisibility(8);
        }
    }
}
