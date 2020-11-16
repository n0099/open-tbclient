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
/* loaded from: classes25.dex */
public class b {
    private TextView euO;
    private NoNetworkView giU;
    private RecommendDetailActivity koO;
    private HeadImageView koP;
    private TextView koQ;
    private TextView koR;
    private LinearLayout koS;
    private SettingTextSwitchView koT;
    private View koU;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.koO = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.koO != null) {
            this.koO.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.koO.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.koO.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            MF(this.koO.getResources().getString(R.string.recommend_detail_activity_title));
            this.giU = (NoNetworkView) this.koO.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.koO.findViewById(R.id.content_view);
            this.koP = (HeadImageView) this.koO.findViewById(R.id.user_image);
            this.koP.setIsRound(true);
            this.euO = (TextView) this.koO.findViewById(R.id.user_name);
            this.koQ = (TextView) this.koO.findViewById(R.id.user_type);
            this.koR = (TextView) this.koO.findViewById(R.id.intro_content);
            this.koT = (SettingTextSwitchView) this.koO.findViewById(R.id.switch_view);
            this.koT.setSwitchStateChangeListener(this.koO);
            this.koT.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.koS = (LinearLayout) this.koO.findViewById(R.id.switch_ll);
            this.koU = this.koO.findViewById(R.id.divider_1);
        }
    }

    public void MF(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.koO != null) {
            this.koP.startLoad(userInfoBigVip.portraith, 12, false);
            this.euO.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.koQ.setText(userInfoBigVip.user_type);
            this.koR.setText(userInfoBigVip.user_detail);
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
            this.koT.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.koT.getSwitchView().turnOnNoCallback();
        } else {
            this.koT.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.koO != null && this.koO.getPageContext() != null && this.koO.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.koO.getPageContext(), i);
            }
            if (this.giU != null) {
                this.giU.onChangeSkinType(this.koO.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.koO.getPageContext(), i);
            }
            if (this.koT != null) {
                this.koT.rx(i);
            }
            if (this.koU != null) {
                ap.setBackgroundColor(this.koU, R.color.CAM_X0205);
            }
            this.koO.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.koO.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void Do(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.koO.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.qo(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.qo(i));
        this.mNoDataView.onChangeSkinType(this.koO.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cUA() {
        if (this.koS != null) {
            this.koS.setVisibility(0);
        }
    }

    public void cUB() {
        if (this.koS != null) {
            this.koS.setVisibility(8);
        }
    }
}
