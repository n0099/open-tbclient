package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
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
    private TextView dKI;
    private NoNetworkView fsB;
    private RecommendDetailActivity jjd;
    private HeadImageView jje;
    private TextView jjf;
    private TextView jjg;
    private LinearLayout jjh;
    private SettingTextSwitchView jji;
    private View jjj;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.jjd = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.jjd != null) {
            this.jjd.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.jjd.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.jjd.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            If(this.jjd.getResources().getString(R.string.recommend_detail_activity_title));
            this.fsB = (NoNetworkView) this.jjd.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.jjd.findViewById(R.id.content_view);
            this.jje = (HeadImageView) this.jjd.findViewById(R.id.user_image);
            this.jje.setIsRound(true);
            this.dKI = (TextView) this.jjd.findViewById(R.id.user_name);
            this.jjf = (TextView) this.jjd.findViewById(R.id.user_type);
            this.jjg = (TextView) this.jjd.findViewById(R.id.intro_content);
            this.jji = (SettingTextSwitchView) this.jjd.findViewById(R.id.switch_view);
            this.jji.setSwitchStateChangeListener(this.jjd);
            this.jji.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.jjh = (LinearLayout) this.jjd.findViewById(R.id.switch_ll);
            this.jjj = this.jjd.findViewById(R.id.divider_1);
        }
    }

    public void If(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.jjd != null) {
            this.jje.startLoad(userInfoBigVip.portraith, 12, false);
            this.dKI.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.jjf.setText(userInfoBigVip.user_type);
            this.jjg.setText(userInfoBigVip.user_detail);
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
            this.jji.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.jji.getSwitchView().turnOnNoCallback();
        } else {
            this.jji.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjd != null && this.jjd.getPageContext() != null && this.jjd.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jjd.getPageContext(), i);
            }
            if (this.fsB != null) {
                this.fsB.onChangeSkinType(this.jjd.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.jjd.getPageContext(), i);
            }
            if (this.jji != null) {
                this.jji.nI(i);
            }
            if (this.jjj != null) {
                ao.setBackgroundColor(this.jjj, R.color.cp_bg_line_e);
            }
            this.jjd.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.jjd.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void yK(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jjd.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.mF(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.mF(i));
        this.mNoDataView.onChangeSkinType(this.jjd.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cxg() {
        if (this.jjh != null) {
            this.jjh.setVisibility(0);
        }
    }

    public void cxh() {
        if (this.jjh != null) {
            this.jjh.setVisibility(8);
        }
    }
}
