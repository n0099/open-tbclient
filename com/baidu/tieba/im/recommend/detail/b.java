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
/* loaded from: classes13.dex */
public class b {
    private TextView dXU;
    private NoNetworkView fci;
    private RecommendDetailActivity iJE;
    private HeadImageView iJF;
    private TextView iJG;
    private TextView iJH;
    private LinearLayout iJI;
    private SettingTextSwitchView iJJ;
    private View iJK;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.iJE = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.iJE != null) {
            this.iJE.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.iJE.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.iJE.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            GO(this.iJE.getResources().getString(R.string.recommend_detail_activity_title));
            this.fci = (NoNetworkView) this.iJE.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.iJE.findViewById(R.id.content_view);
            this.iJF = (HeadImageView) this.iJE.findViewById(R.id.user_image);
            this.iJF.setIsRound(true);
            this.dXU = (TextView) this.iJE.findViewById(R.id.user_name);
            this.iJG = (TextView) this.iJE.findViewById(R.id.user_type);
            this.iJH = (TextView) this.iJE.findViewById(R.id.intro_content);
            this.iJJ = (SettingTextSwitchView) this.iJE.findViewById(R.id.switch_view);
            this.iJJ.setSwitchStateChangeListener(this.iJE);
            this.iJJ.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.iJI = (LinearLayout) this.iJE.findViewById(R.id.switch_ll);
            this.iJK = this.iJE.findViewById(R.id.divider_1);
        }
    }

    public void GO(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.iJE != null) {
            this.iJF.startLoad(userInfoBigVip.portraith, 12, false);
            this.dXU.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.iJG.setText(userInfoBigVip.user_type);
            this.iJH.setText(userInfoBigVip.user_detail);
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
            this.iJJ.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.iJJ.getSwitchView().turnOnNoCallback();
        } else {
            this.iJJ.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iJE != null && this.iJE.getPageContext() != null && this.iJE.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.iJE.getPageContext(), i);
            }
            if (this.fci != null) {
                this.fci.onChangeSkinType(this.iJE.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.iJE.getPageContext(), i);
            }
            if (this.iJJ != null) {
                this.iJJ.mW(i);
            }
            if (this.iJK != null) {
                am.setBackgroundColor(this.iJK, R.color.cp_bg_line_e);
            }
            this.iJE.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.iJE.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void xC(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iJE.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.lV(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lV(i));
        this.mNoDataView.onChangeSkinType(this.iJE.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cpo() {
        if (this.iJI != null) {
            this.iJI.setVisibility(0);
        }
    }

    public void cpp() {
        if (this.iJI != null) {
            this.iJI.setVisibility(8);
        }
    }
}
