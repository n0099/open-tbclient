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
    private TextView cAX;
    private NoNetworkView ePl;
    private RecommendDetailActivity iuf;
    private HeadImageView iug;
    private TextView iuh;
    private TextView iui;
    private LinearLayout iuj;
    private SettingTextSwitchView iuk;
    private View iul;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.iuf = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.iuf != null) {
            this.iuf.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.iuf.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.iuf.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Fc(this.iuf.getResources().getString(R.string.recommend_detail_activity_title));
            this.ePl = (NoNetworkView) this.iuf.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.iuf.findViewById(R.id.content_view);
            this.iug = (HeadImageView) this.iuf.findViewById(R.id.user_image);
            this.iug.setIsRound(true);
            this.cAX = (TextView) this.iuf.findViewById(R.id.user_name);
            this.iuh = (TextView) this.iuf.findViewById(R.id.user_type);
            this.iui = (TextView) this.iuf.findViewById(R.id.intro_content);
            this.iuk = (SettingTextSwitchView) this.iuf.findViewById(R.id.switch_view);
            this.iuk.setSwitchStateChangeListener(this.iuf);
            this.iuk.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.iuj = (LinearLayout) this.iuf.findViewById(R.id.switch_ll);
            this.iul = this.iuf.findViewById(R.id.divider_1);
        }
    }

    public void Fc(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.iuf != null) {
            this.iug.startLoad(userInfoBigVip.portraith, 12, false);
            this.cAX.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.iuh.setText(userInfoBigVip.user_type);
            this.iui.setText(userInfoBigVip.user_detail);
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
            this.iuk.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.iuk.getSwitchView().turnOnNoCallback();
        } else {
            this.iuk.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iuf != null && this.iuf.getPageContext() != null && this.iuf.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.iuf.getPageContext(), i);
            }
            if (this.ePl != null) {
                this.ePl.onChangeSkinType(this.iuf.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.iuf.getPageContext(), i);
            }
            if (this.iuk != null) {
                this.iuk.ms(i);
            }
            if (this.iul != null) {
                am.setBackgroundColor(this.iul, R.color.cp_bg_line_e);
            }
            this.iuf.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.iuf.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void wU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iuf.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.lr(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lr(i));
        this.mNoDataView.onChangeSkinType(this.iuf.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void ciJ() {
        if (this.iuj != null) {
            this.iuj.setVisibility(0);
        }
    }

    public void ciK() {
        if (this.iuj != null) {
            this.iuj.setVisibility(8);
        }
    }
}
