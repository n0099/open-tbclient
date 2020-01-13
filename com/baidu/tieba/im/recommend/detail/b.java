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
/* loaded from: classes11.dex */
public class b {
    private TextView bXF;
    private NoNetworkView ehd;
    private RecommendDetailActivity hGC;
    private HeadImageView hGD;
    private TextView hGE;
    private TextView hGF;
    private LinearLayout hGG;
    private SettingTextSwitchView hGH;
    private View hGI;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.hGC = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.hGC != null) {
            this.hGC.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.hGC.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.hGC.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Dd(this.hGC.getResources().getString(R.string.recommend_detail_activity_title));
            this.ehd = (NoNetworkView) this.hGC.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.hGC.findViewById(R.id.content_view);
            this.hGD = (HeadImageView) this.hGC.findViewById(R.id.user_image);
            this.hGD.setIsRound(true);
            this.bXF = (TextView) this.hGC.findViewById(R.id.user_name);
            this.hGE = (TextView) this.hGC.findViewById(R.id.user_type);
            this.hGF = (TextView) this.hGC.findViewById(R.id.intro_content);
            this.hGH = (SettingTextSwitchView) this.hGC.findViewById(R.id.switch_view);
            this.hGH.setSwitchStateChangeListener(this.hGC);
            this.hGH.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.hGG = (LinearLayout) this.hGC.findViewById(R.id.switch_ll);
            this.hGI = this.hGC.findViewById(R.id.divider_1);
        }
    }

    public void Dd(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.hGC != null) {
            this.hGD.startLoad(userInfoBigVip.portraith, 12, false);
            this.bXF.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.hGE.setText(userInfoBigVip.user_type);
            this.hGF.setText(userInfoBigVip.user_detail);
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
            this.hGH.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.hGH.getSwitchView().turnOnNoCallback();
        } else {
            this.hGH.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hGC != null && this.hGC.getPageContext() != null && this.hGC.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hGC.getPageContext(), i);
            }
            if (this.ehd != null) {
                this.ehd.onChangeSkinType(this.hGC.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.hGC.getPageContext(), i);
            }
            if (this.hGH != null) {
                this.hGH.lM(i);
            }
            if (this.hGI != null) {
                am.setBackgroundColor(this.hGI, R.color.cp_bg_line_e);
            }
            this.hGC.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.hGC.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void wi(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hGC.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.kQ(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.kQ(i));
        this.mNoDataView.onChangeSkinType(this.hGC.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bWm() {
        if (this.hGG != null) {
            this.hGG.setVisibility(0);
        }
    }

    public void bWn() {
        if (this.hGG != null) {
            this.hGG.setVisibility(8);
        }
    }
}
