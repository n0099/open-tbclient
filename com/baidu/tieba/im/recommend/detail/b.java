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
/* loaded from: classes20.dex */
public class b {
    private TextView dTQ;
    private NoNetworkView fDV;
    private RecommendDetailActivity jyc;
    private HeadImageView jyd;
    private TextView jye;
    private TextView jyf;
    private LinearLayout jyg;
    private SettingTextSwitchView jyh;
    private View jyi;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.jyc = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.jyc != null) {
            this.jyc.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.jyc.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.jyc.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            KX(this.jyc.getResources().getString(R.string.recommend_detail_activity_title));
            this.fDV = (NoNetworkView) this.jyc.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.jyc.findViewById(R.id.content_view);
            this.jyd = (HeadImageView) this.jyc.findViewById(R.id.user_image);
            this.jyd.setIsRound(true);
            this.dTQ = (TextView) this.jyc.findViewById(R.id.user_name);
            this.jye = (TextView) this.jyc.findViewById(R.id.user_type);
            this.jyf = (TextView) this.jyc.findViewById(R.id.intro_content);
            this.jyh = (SettingTextSwitchView) this.jyc.findViewById(R.id.switch_view);
            this.jyh.setSwitchStateChangeListener(this.jyc);
            this.jyh.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.jyg = (LinearLayout) this.jyc.findViewById(R.id.switch_ll);
            this.jyi = this.jyc.findViewById(R.id.divider_1);
        }
    }

    public void KX(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.jyc != null) {
            this.jyd.startLoad(userInfoBigVip.portraith, 12, false);
            this.dTQ.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.jye.setText(userInfoBigVip.user_type);
            this.jyf.setText(userInfoBigVip.user_detail);
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
            this.jyh.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.jyh.getSwitchView().turnOnNoCallback();
        } else {
            this.jyh.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jyc != null && this.jyc.getPageContext() != null && this.jyc.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.jyc.getPageContext(), i);
            }
            if (this.fDV != null) {
                this.fDV.onChangeSkinType(this.jyc.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.jyc.getPageContext(), i);
            }
            if (this.jyh != null) {
                this.jyh.pT(i);
            }
            if (this.jyi != null) {
                ap.setBackgroundColor(this.jyi, R.color.cp_bg_line_e);
            }
            this.jyc.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.jyc.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void Bd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jyc.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.oK(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oK(i));
        this.mNoDataView.onChangeSkinType(this.jyc.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cHX() {
        if (this.jyg != null) {
            this.jyg.setVisibility(0);
        }
    }

    public void cHY() {
        if (this.jyg != null) {
            this.jyg.setVisibility(8);
        }
    }
}
