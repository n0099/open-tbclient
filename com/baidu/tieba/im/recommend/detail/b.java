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
    private TextView eBQ;
    private NoNetworkView grd;
    private RecommendDetailActivity kCk;
    private HeadImageView kCl;
    private TextView kCm;
    private TextView kCn;
    private LinearLayout kCo;
    private SettingTextSwitchView kCp;
    private View kCq;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.kCk = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.kCk != null) {
            this.kCk.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.kCk.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.kCk.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            NN(this.kCk.getResources().getString(R.string.recommend_detail_activity_title));
            this.grd = (NoNetworkView) this.kCk.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.kCk.findViewById(R.id.content_view);
            this.kCl = (HeadImageView) this.kCk.findViewById(R.id.user_image);
            this.kCl.setIsRound(true);
            this.eBQ = (TextView) this.kCk.findViewById(R.id.user_name);
            this.kCm = (TextView) this.kCk.findViewById(R.id.user_type);
            this.kCn = (TextView) this.kCk.findViewById(R.id.intro_content);
            this.kCp = (SettingTextSwitchView) this.kCk.findViewById(R.id.switch_view);
            this.kCp.setSwitchStateChangeListener(this.kCk);
            this.kCp.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.kCo = (LinearLayout) this.kCk.findViewById(R.id.switch_ll);
            this.kCq = this.kCk.findViewById(R.id.divider_1);
        }
    }

    public void NN(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.kCk != null) {
            this.kCl.startLoad(userInfoBigVip.portraith, 12, false);
            this.eBQ.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.kCm.setText(userInfoBigVip.user_type);
            this.kCn.setText(userInfoBigVip.user_detail);
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
            this.kCp.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.kCp.getSwitchView().turnOnNoCallback();
        } else {
            this.kCp.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kCk != null && this.kCk.getPageContext() != null && this.kCk.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kCk.getPageContext(), i);
            }
            if (this.grd != null) {
                this.grd.onChangeSkinType(this.kCk.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.kCk.getPageContext(), i);
            }
            if (this.kCp != null) {
                this.kCp.rY(i);
            }
            if (this.kCq != null) {
                ap.setBackgroundColor(this.kCq, R.color.CAM_X0205);
            }
            this.kCk.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.kCk.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void Ed(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kCk.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.qP(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(i));
        this.mNoDataView.onChangeSkinType(this.kCk.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cZM() {
        if (this.kCo != null) {
            this.kCo.setVisibility(0);
        }
    }

    public void cZN() {
        if (this.kCo != null) {
            this.kCo.setVisibility(8);
        }
    }
}
