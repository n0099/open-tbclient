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
    private TextView cbJ;
    private NoNetworkView elh;
    private RecommendDetailActivity hIB;
    private HeadImageView hIC;
    private TextView hID;
    private TextView hIE;
    private LinearLayout hIF;
    private SettingTextSwitchView hIG;
    private View hIH;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.hIB = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.hIB != null) {
            this.hIB.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.hIB.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.hIB.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Dt(this.hIB.getResources().getString(R.string.recommend_detail_activity_title));
            this.elh = (NoNetworkView) this.hIB.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.hIB.findViewById(R.id.content_view);
            this.hIC = (HeadImageView) this.hIB.findViewById(R.id.user_image);
            this.hIC.setIsRound(true);
            this.cbJ = (TextView) this.hIB.findViewById(R.id.user_name);
            this.hID = (TextView) this.hIB.findViewById(R.id.user_type);
            this.hIE = (TextView) this.hIB.findViewById(R.id.intro_content);
            this.hIG = (SettingTextSwitchView) this.hIB.findViewById(R.id.switch_view);
            this.hIG.setSwitchStateChangeListener(this.hIB);
            this.hIG.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.hIF = (LinearLayout) this.hIB.findViewById(R.id.switch_ll);
            this.hIH = this.hIB.findViewById(R.id.divider_1);
        }
    }

    public void Dt(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.hIB != null) {
            this.hIC.startLoad(userInfoBigVip.portraith, 12, false);
            this.cbJ.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.hID.setText(userInfoBigVip.user_type);
            this.hIE.setText(userInfoBigVip.user_detail);
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
            this.hIG.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.hIG.getSwitchView().turnOnNoCallback();
        } else {
            this.hIG.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hIB != null && this.hIB.getPageContext() != null && this.hIB.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hIB.getPageContext(), i);
            }
            if (this.elh != null) {
                this.elh.onChangeSkinType(this.hIB.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.hIB.getPageContext(), i);
            }
            if (this.hIG != null) {
                this.hIG.me(i);
            }
            if (this.hIH != null) {
                am.setBackgroundColor(this.hIH, R.color.cp_bg_line_e);
            }
            this.hIB.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.hIB.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hIB.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.lh(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(i));
        this.mNoDataView.onChangeSkinType(this.hIB.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bXN() {
        if (this.hIF != null) {
            this.hIF.setVisibility(0);
        }
    }

    public void bXO() {
        if (this.hIF != null) {
            this.hIF.setVisibility(8);
        }
    }
}
