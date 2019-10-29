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
/* loaded from: classes3.dex */
public class b {
    private TextView csn;
    private NoNetworkView dwI;
    private RecommendDetailActivity gPM;
    private HeadImageView gPN;
    private TextView gPO;
    private TextView gPP;
    private LinearLayout gPQ;
    private SettingTextSwitchView gPR;
    private View gPS;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.gPM = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.gPM != null) {
            this.gPM.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.gPM.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.gPM.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            yk(this.gPM.getResources().getString(R.string.recommend_detail_activity_title));
            this.dwI = (NoNetworkView) this.gPM.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.gPM.findViewById(R.id.content_view);
            this.gPN = (HeadImageView) this.gPM.findViewById(R.id.user_image);
            this.gPN.setIsRound(true);
            this.csn = (TextView) this.gPM.findViewById(R.id.user_name);
            this.gPO = (TextView) this.gPM.findViewById(R.id.user_type);
            this.gPP = (TextView) this.gPM.findViewById(R.id.intro_content);
            this.gPR = (SettingTextSwitchView) this.gPM.findViewById(R.id.switch_view);
            this.gPR.setSwitchStateChangeListener(this.gPM);
            this.gPR.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.gPQ = (LinearLayout) this.gPM.findViewById(R.id.switch_ll);
            this.gPS = this.gPM.findViewById(R.id.divider_1);
        }
    }

    public void yk(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.gPM != null) {
            this.gPN.startLoad(userInfoBigVip.portraith, 12, false);
            this.csn.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.gPO.setText(userInfoBigVip.user_type);
            this.gPP.setText(userInfoBigVip.user_detail);
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
            this.gPR.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.gPR.getSwitchView().turnOnNoCallback();
        } else {
            this.gPR.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gPM != null && this.gPM.getPageContext() != null && this.gPM.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gPM.getPageContext(), i);
            }
            if (this.dwI != null) {
                this.dwI.onChangeSkinType(this.gPM.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.gPM.getPageContext(), i);
            }
            if (this.gPR != null) {
                this.gPR.jA(i);
            }
            if (this.gPS != null) {
                am.setBackgroundColor(this.gPS, R.color.cp_bg_line_e);
            }
            this.gPM.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.gPM.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void uc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gPM.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.iL(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iL(i));
        this.mNoDataView.onChangeSkinType(this.gPM.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bDT() {
        if (this.gPQ != null) {
            this.gPQ.setVisibility(0);
        }
    }

    public void bDU() {
        if (this.gPQ != null) {
            this.gPQ.setVisibility(8);
        }
    }
}
