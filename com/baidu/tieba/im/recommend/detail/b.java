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
/* loaded from: classes26.dex */
public class b {
    private TextView eig;
    private NoNetworkView fTu;
    private RecommendDetailActivity jVH;
    private HeadImageView jVI;
    private TextView jVJ;
    private TextView jVK;
    private LinearLayout jVL;
    private SettingTextSwitchView jVM;
    private View jVN;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.jVH = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.jVH != null) {
            this.jVH.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.jVH.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.jVH.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Mp(this.jVH.getResources().getString(R.string.recommend_detail_activity_title));
            this.fTu = (NoNetworkView) this.jVH.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.jVH.findViewById(R.id.content_view);
            this.jVI = (HeadImageView) this.jVH.findViewById(R.id.user_image);
            this.jVI.setIsRound(true);
            this.eig = (TextView) this.jVH.findViewById(R.id.user_name);
            this.jVJ = (TextView) this.jVH.findViewById(R.id.user_type);
            this.jVK = (TextView) this.jVH.findViewById(R.id.intro_content);
            this.jVM = (SettingTextSwitchView) this.jVH.findViewById(R.id.switch_view);
            this.jVM.setSwitchStateChangeListener(this.jVH);
            this.jVM.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.jVL = (LinearLayout) this.jVH.findViewById(R.id.switch_ll);
            this.jVN = this.jVH.findViewById(R.id.divider_1);
        }
    }

    public void Mp(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.jVH != null) {
            this.jVI.startLoad(userInfoBigVip.portraith, 12, false);
            this.eig.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.jVJ.setText(userInfoBigVip.user_type);
            this.jVK.setText(userInfoBigVip.user_detail);
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
            this.jVM.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.jVM.getSwitchView().turnOnNoCallback();
        } else {
            this.jVM.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jVH != null && this.jVH.getPageContext() != null && this.jVH.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jVH.getPageContext(), i);
            }
            if (this.fTu != null) {
                this.fTu.onChangeSkinType(this.jVH.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.jVH.getPageContext(), i);
            }
            if (this.jVM != null) {
                this.jVM.qE(i);
            }
            if (this.jVN != null) {
                ap.setBackgroundColor(this.jVN, R.color.cp_bg_line_e);
            }
            this.jVH.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.jVH.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void Ck(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jVH.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.pv(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pv(i));
        this.mNoDataView.onChangeSkinType(this.jVH.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cPm() {
        if (this.jVL != null) {
            this.jVL.setVisibility(0);
        }
    }

    public void cPn() {
        if (this.jVL != null) {
            this.jVL.setVisibility(8);
        }
    }
}
