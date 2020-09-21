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
    private TextView dWe;
    private NoNetworkView fHl;
    private RecommendDetailActivity jGK;
    private HeadImageView jGL;
    private TextView jGM;
    private TextView jGN;
    private LinearLayout jGO;
    private SettingTextSwitchView jGP;
    private View jGQ;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.jGK = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.jGK != null) {
            this.jGK.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.jGK.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.jGK.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            LA(this.jGK.getResources().getString(R.string.recommend_detail_activity_title));
            this.fHl = (NoNetworkView) this.jGK.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.jGK.findViewById(R.id.content_view);
            this.jGL = (HeadImageView) this.jGK.findViewById(R.id.user_image);
            this.jGL.setIsRound(true);
            this.dWe = (TextView) this.jGK.findViewById(R.id.user_name);
            this.jGM = (TextView) this.jGK.findViewById(R.id.user_type);
            this.jGN = (TextView) this.jGK.findViewById(R.id.intro_content);
            this.jGP = (SettingTextSwitchView) this.jGK.findViewById(R.id.switch_view);
            this.jGP.setSwitchStateChangeListener(this.jGK);
            this.jGP.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.jGO = (LinearLayout) this.jGK.findViewById(R.id.switch_ll);
            this.jGQ = this.jGK.findViewById(R.id.divider_1);
        }
    }

    public void LA(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.jGK != null) {
            this.jGL.startLoad(userInfoBigVip.portraith, 12, false);
            this.dWe.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.jGM.setText(userInfoBigVip.user_type);
            this.jGN.setText(userInfoBigVip.user_detail);
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
            this.jGP.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.jGP.getSwitchView().turnOnNoCallback();
        } else {
            this.jGP.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jGK != null && this.jGK.getPageContext() != null && this.jGK.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jGK.getPageContext(), i);
            }
            if (this.fHl != null) {
                this.fHl.onChangeSkinType(this.jGK.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.jGK.getPageContext(), i);
            }
            if (this.jGP != null) {
                this.jGP.qg(i);
            }
            if (this.jGQ != null) {
                ap.setBackgroundColor(this.jGQ, R.color.cp_bg_line_e);
            }
            this.jGK.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.jGK.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void BE(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jGK.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.oW(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oW(i));
        this.mNoDataView.onChangeSkinType(this.jGK.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cLE() {
        if (this.jGO != null) {
            this.jGO.setVisibility(0);
        }
    }

    public void cLF() {
        if (this.jGO != null) {
            this.jGO.setVisibility(8);
        }
    }
}
