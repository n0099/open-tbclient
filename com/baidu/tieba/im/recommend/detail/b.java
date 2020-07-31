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
    private RecommendDetailActivity jjb;
    private HeadImageView jjc;
    private TextView jjd;
    private TextView jje;
    private LinearLayout jjf;
    private SettingTextSwitchView jjg;
    private View jjh;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.jjb = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.jjb != null) {
            this.jjb.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.jjb.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.jjb.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            If(this.jjb.getResources().getString(R.string.recommend_detail_activity_title));
            this.fsB = (NoNetworkView) this.jjb.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.jjb.findViewById(R.id.content_view);
            this.jjc = (HeadImageView) this.jjb.findViewById(R.id.user_image);
            this.jjc.setIsRound(true);
            this.dKI = (TextView) this.jjb.findViewById(R.id.user_name);
            this.jjd = (TextView) this.jjb.findViewById(R.id.user_type);
            this.jje = (TextView) this.jjb.findViewById(R.id.intro_content);
            this.jjg = (SettingTextSwitchView) this.jjb.findViewById(R.id.switch_view);
            this.jjg.setSwitchStateChangeListener(this.jjb);
            this.jjg.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.jjf = (LinearLayout) this.jjb.findViewById(R.id.switch_ll);
            this.jjh = this.jjb.findViewById(R.id.divider_1);
        }
    }

    public void If(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.jjb != null) {
            this.jjc.startLoad(userInfoBigVip.portraith, 12, false);
            this.dKI.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.jjd.setText(userInfoBigVip.user_type);
            this.jje.setText(userInfoBigVip.user_detail);
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
            this.jjg.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.jjg.getSwitchView().turnOnNoCallback();
        } else {
            this.jjg.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjb != null && this.jjb.getPageContext() != null && this.jjb.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jjb.getPageContext(), i);
            }
            if (this.fsB != null) {
                this.fsB.onChangeSkinType(this.jjb.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.jjb.getPageContext(), i);
            }
            if (this.jjg != null) {
                this.jjg.nI(i);
            }
            if (this.jjh != null) {
                ao.setBackgroundColor(this.jjh, R.color.cp_bg_line_e);
            }
            this.jjb.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.jjb.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
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
            this.mNoDataView = NoDataViewFactory.a(this.jjb.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.mF(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.mF(i));
        this.mNoDataView.onChangeSkinType(this.jjb.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cxg() {
        if (this.jjf != null) {
            this.jjf.setVisibility(0);
        }
    }

    public void cxh() {
        if (this.jjf != null) {
            this.jjf.setVisibility(8);
        }
    }
}
