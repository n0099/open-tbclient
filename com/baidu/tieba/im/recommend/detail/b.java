package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes20.dex */
public class b {
    private TextView dTU;
    private NoNetworkView fDZ;
    private RecommendDetailActivity jyi;
    private HeadImageView jyj;
    private TextView jyk;
    private TextView jyl;
    private LinearLayout jym;
    private SettingTextSwitchView jyn;
    private View jyo;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.jyi = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.jyi != null) {
            this.jyi.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.jyi.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.jyi.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            KY(this.jyi.getResources().getString(R.string.recommend_detail_activity_title));
            this.fDZ = (NoNetworkView) this.jyi.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.jyi.findViewById(R.id.content_view);
            this.jyj = (HeadImageView) this.jyi.findViewById(R.id.user_image);
            this.jyj.setIsRound(true);
            this.dTU = (TextView) this.jyi.findViewById(R.id.user_name);
            this.jyk = (TextView) this.jyi.findViewById(R.id.user_type);
            this.jyl = (TextView) this.jyi.findViewById(R.id.intro_content);
            this.jyn = (SettingTextSwitchView) this.jyi.findViewById(R.id.switch_view);
            this.jyn.setSwitchStateChangeListener(this.jyi);
            this.jyn.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.jym = (LinearLayout) this.jyi.findViewById(R.id.switch_ll);
            this.jyo = this.jyi.findViewById(R.id.divider_1);
        }
    }

    public void KY(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.jyi != null) {
            this.jyj.startLoad(userInfoBigVip.portraith, 12, false);
            this.dTU.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.jyk.setText(userInfoBigVip.user_type);
            this.jyl.setText(userInfoBigVip.user_detail);
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
            this.jyn.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.jyn.getSwitchView().turnOnNoCallback();
        } else {
            this.jyn.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jyi != null && this.jyi.getPageContext() != null && this.jyi.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jyi.getPageContext(), i);
            }
            if (this.fDZ != null) {
                this.fDZ.onChangeSkinType(this.jyi.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.jyi.getPageContext(), i);
            }
            if (this.jyn != null) {
                this.jyn.pT(i);
            }
            if (this.jyo != null) {
                ap.setBackgroundColor(this.jyo, R.color.cp_bg_line_e);
            }
            this.jyi.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.jyi.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void Bd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jyi.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.oK(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oK(i));
        this.mNoDataView.onChangeSkinType(this.jyi.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cHY() {
        if (this.jym != null) {
            this.jym.setVisibility(0);
        }
    }

    public void cHZ() {
        if (this.jym != null) {
            this.jym.setVisibility(8);
        }
    }
}
