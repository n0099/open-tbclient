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
/* loaded from: classes8.dex */
public class b {
    private TextView eIO;
    private NoNetworkView gAh;
    private RecommendDetailActivity kLi;
    private HeadImageView kLj;
    private TextView kLk;
    private TextView kLl;
    private LinearLayout kLm;
    private SettingTextSwitchView kLn;
    private View kLo;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.kLi = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.kLi != null) {
            this.kLi.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.kLi.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.kLi.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Nb(this.kLi.getResources().getString(R.string.recommend_detail_activity_title));
            this.gAh = (NoNetworkView) this.kLi.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.kLi.findViewById(R.id.content_view);
            this.kLj = (HeadImageView) this.kLi.findViewById(R.id.user_image);
            this.kLj.setIsRound(true);
            this.eIO = (TextView) this.kLi.findViewById(R.id.user_name);
            this.kLk = (TextView) this.kLi.findViewById(R.id.user_type);
            this.kLl = (TextView) this.kLi.findViewById(R.id.intro_content);
            this.kLn = (SettingTextSwitchView) this.kLi.findViewById(R.id.switch_view);
            this.kLn.setSwitchStateChangeListener(this.kLi);
            this.kLn.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.kLm = (LinearLayout) this.kLi.findViewById(R.id.switch_ll);
            this.kLo = this.kLi.findViewById(R.id.divider_1);
        }
    }

    public void Nb(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.kLi != null) {
            this.kLj.startLoad(userInfoBigVip.portraith, 12, false);
            this.eIO.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.kLk.setText(userInfoBigVip.user_type);
            this.kLl.setText(userInfoBigVip.user_detail);
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
            this.kLn.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.kLn.getSwitchView().turnOnNoCallback();
        } else {
            this.kLn.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kLi != null && this.kLi.getPageContext() != null && this.kLi.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kLi.getPageContext(), i);
            }
            if (this.gAh != null) {
                this.gAh.onChangeSkinType(this.kLi.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.kLi.getPageContext(), i);
            }
            if (this.kLn != null) {
                this.kLn.qJ(i);
            }
            if (this.kLo != null) {
                ap.setBackgroundColor(this.kLo, R.color.CAM_X0205);
            }
            this.kLi.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.kLi.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void CY(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kLi.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.pz(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(i));
        this.mNoDataView.onChangeSkinType(this.kLi.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cXG() {
        if (this.kLm != null) {
            this.kLm.setVisibility(0);
        }
    }

    public void cXH() {
        if (this.kLm != null) {
            this.kLm.setVisibility(8);
        }
    }
}
