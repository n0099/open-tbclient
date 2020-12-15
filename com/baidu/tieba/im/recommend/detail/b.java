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
    private NoNetworkView grf;
    private RecommendDetailActivity kCm;
    private HeadImageView kCn;
    private TextView kCo;
    private TextView kCp;
    private LinearLayout kCq;
    private SettingTextSwitchView kCr;
    private View kCs;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.kCm = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.kCm != null) {
            this.kCm.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.kCm.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.kCm.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            NN(this.kCm.getResources().getString(R.string.recommend_detail_activity_title));
            this.grf = (NoNetworkView) this.kCm.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.kCm.findViewById(R.id.content_view);
            this.kCn = (HeadImageView) this.kCm.findViewById(R.id.user_image);
            this.kCn.setIsRound(true);
            this.eBQ = (TextView) this.kCm.findViewById(R.id.user_name);
            this.kCo = (TextView) this.kCm.findViewById(R.id.user_type);
            this.kCp = (TextView) this.kCm.findViewById(R.id.intro_content);
            this.kCr = (SettingTextSwitchView) this.kCm.findViewById(R.id.switch_view);
            this.kCr.setSwitchStateChangeListener(this.kCm);
            this.kCr.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.kCq = (LinearLayout) this.kCm.findViewById(R.id.switch_ll);
            this.kCs = this.kCm.findViewById(R.id.divider_1);
        }
    }

    public void NN(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.kCm != null) {
            this.kCn.startLoad(userInfoBigVip.portraith, 12, false);
            this.eBQ.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.kCo.setText(userInfoBigVip.user_type);
            this.kCp.setText(userInfoBigVip.user_detail);
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
            this.kCr.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.kCr.getSwitchView().turnOnNoCallback();
        } else {
            this.kCr.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kCm != null && this.kCm.getPageContext() != null && this.kCm.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kCm.getPageContext(), i);
            }
            if (this.grf != null) {
                this.grf.onChangeSkinType(this.kCm.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.kCm.getPageContext(), i);
            }
            if (this.kCr != null) {
                this.kCr.rY(i);
            }
            if (this.kCs != null) {
                ap.setBackgroundColor(this.kCs, R.color.CAM_X0205);
            }
            this.kCm.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.kCm.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
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
            this.mNoDataView = NoDataViewFactory.a(this.kCm.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.qP(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(i));
        this.mNoDataView.onChangeSkinType(this.kCm.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cZN() {
        if (this.kCq != null) {
            this.kCq.setVisibility(0);
        }
    }

    public void cZO() {
        if (this.kCq != null) {
            this.kCq.setVisibility(8);
        }
    }
}
