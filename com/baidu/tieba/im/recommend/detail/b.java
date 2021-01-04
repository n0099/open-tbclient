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
/* loaded from: classes8.dex */
public class b {
    private TextView eLt;
    private NoNetworkView gCe;
    private RecommendDetailActivity kHI;
    private HeadImageView kHJ;
    private TextView kHK;
    private TextView kHL;
    private LinearLayout kHM;
    private SettingTextSwitchView kHN;
    private View kHO;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.kHI = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.kHI != null) {
            this.kHI.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.kHI.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.kHI.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Nv(this.kHI.getResources().getString(R.string.recommend_detail_activity_title));
            this.gCe = (NoNetworkView) this.kHI.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.kHI.findViewById(R.id.content_view);
            this.kHJ = (HeadImageView) this.kHI.findViewById(R.id.user_image);
            this.kHJ.setIsRound(true);
            this.eLt = (TextView) this.kHI.findViewById(R.id.user_name);
            this.kHK = (TextView) this.kHI.findViewById(R.id.user_type);
            this.kHL = (TextView) this.kHI.findViewById(R.id.intro_content);
            this.kHN = (SettingTextSwitchView) this.kHI.findViewById(R.id.switch_view);
            this.kHN.setSwitchStateChangeListener(this.kHI);
            this.kHN.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.kHM = (LinearLayout) this.kHI.findViewById(R.id.switch_ll);
            this.kHO = this.kHI.findViewById(R.id.divider_1);
        }
    }

    public void Nv(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.kHI != null) {
            this.kHJ.startLoad(userInfoBigVip.portraith, 12, false);
            this.eLt.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.kHK.setText(userInfoBigVip.user_type);
            this.kHL.setText(userInfoBigVip.user_detail);
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
            this.kHN.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.kHN.getSwitchView().turnOnNoCallback();
        } else {
            this.kHN.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kHI != null && this.kHI.getPageContext() != null && this.kHI.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kHI.getPageContext(), i);
            }
            if (this.gCe != null) {
                this.gCe.onChangeSkinType(this.kHI.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.kHI.getPageContext(), i);
            }
            if (this.kHN != null) {
                this.kHN.sk(i);
            }
            if (this.kHO != null) {
                ao.setBackgroundColor(this.kHO, R.color.CAM_X0205);
            }
            this.kHI.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.kHI.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void En(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kHI.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.ra(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ra(i));
        this.mNoDataView.onChangeSkinType(this.kHI.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cZz() {
        if (this.kHM != null) {
            this.kHM.setVisibility(0);
        }
    }

    public void cZA() {
        if (this.kHM != null) {
            this.kHM.setVisibility(8);
        }
    }
}
