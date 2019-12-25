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
/* loaded from: classes10.dex */
public class b {
    private TextView bXt;
    private NoNetworkView egT;
    private RecommendDetailActivity hCZ;
    private HeadImageView hDa;
    private TextView hDb;
    private TextView hDc;
    private LinearLayout hDd;
    private SettingTextSwitchView hDe;
    private View hDf;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.hCZ = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.hCZ != null) {
            this.hCZ.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.hCZ.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.hCZ.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            CT(this.hCZ.getResources().getString(R.string.recommend_detail_activity_title));
            this.egT = (NoNetworkView) this.hCZ.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.hCZ.findViewById(R.id.content_view);
            this.hDa = (HeadImageView) this.hCZ.findViewById(R.id.user_image);
            this.hDa.setIsRound(true);
            this.bXt = (TextView) this.hCZ.findViewById(R.id.user_name);
            this.hDb = (TextView) this.hCZ.findViewById(R.id.user_type);
            this.hDc = (TextView) this.hCZ.findViewById(R.id.intro_content);
            this.hDe = (SettingTextSwitchView) this.hCZ.findViewById(R.id.switch_view);
            this.hDe.setSwitchStateChangeListener(this.hCZ);
            this.hDe.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.hDd = (LinearLayout) this.hCZ.findViewById(R.id.switch_ll);
            this.hDf = this.hCZ.findViewById(R.id.divider_1);
        }
    }

    public void CT(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.hCZ != null) {
            this.hDa.startLoad(userInfoBigVip.portraith, 12, false);
            this.bXt.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.hDb.setText(userInfoBigVip.user_type);
            this.hDc.setText(userInfoBigVip.user_detail);
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
            this.hDe.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.hDe.getSwitchView().turnOnNoCallback();
        } else {
            this.hDe.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hCZ != null && this.hCZ.getPageContext() != null && this.hCZ.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.hCZ.getPageContext(), i);
            }
            if (this.egT != null) {
                this.egT.onChangeSkinType(this.hCZ.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.hCZ.getPageContext(), i);
            }
            if (this.hDe != null) {
                this.hDe.lM(i);
            }
            if (this.hDf != null) {
                am.setBackgroundColor(this.hDf, R.color.cp_bg_line_e);
            }
            this.hCZ.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.hCZ.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void wd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hCZ.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.kQ(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.kQ(i));
        this.mNoDataView.onChangeSkinType(this.hCZ.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bVd() {
        if (this.hDd != null) {
            this.hDd.setVisibility(0);
        }
    }

    public void bVe() {
        if (this.hDd != null) {
            this.hDd.setVisibility(8);
        }
    }
}
