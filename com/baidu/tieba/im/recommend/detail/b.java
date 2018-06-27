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
import com.baidu.tieba.d;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView azm;
    private NoNetworkView buT;
    private LinearLayout ciN;
    private RecommendDetailActivity exd;
    private HeadImageView exe;
    private TextView exf;
    private TextView exg;
    private LinearLayout exh;
    private SettingTextSwitchView exi;
    private View exj;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.exd = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.exd != null) {
            this.exd.setContentView(d.i.recommend_detail_activity);
            this.mRootView = this.exd.findViewById(d.g.root_view);
            this.mNavigationBar = (NavigationBar) this.exd.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            oG(this.exd.getResources().getString(d.k.recommend_detail_activity_title));
            this.buT = (NoNetworkView) this.exd.findViewById(d.g.view_no_network);
            this.ciN = (LinearLayout) this.exd.findViewById(d.g.content_view);
            this.exe = (HeadImageView) this.exd.findViewById(d.g.user_image);
            this.exe.setIsRound(true);
            this.azm = (TextView) this.exd.findViewById(d.g.user_name);
            this.exf = (TextView) this.exd.findViewById(d.g.user_type);
            this.exg = (TextView) this.exd.findViewById(d.g.intro_content);
            this.exi = (SettingTextSwitchView) this.exd.findViewById(d.g.switch_view);
            this.exi.setSwitchStateChangeListener(this.exd);
            this.exi.setVisibility(8);
            this.ciN.setVisibility(8);
            this.exh = (LinearLayout) this.exd.findViewById(d.g.switch_ll);
            this.exj = this.exd.findViewById(d.g.divider_1);
        }
    }

    public void oG(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.exd != null) {
            this.exe.startLoad(userInfoBigVip.portraith, 12, false);
            this.azm.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.exf.setText(userInfoBigVip.user_type);
            this.exg.setText(userInfoBigVip.user_detail);
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
            this.exi.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.exi.getSwitchView().mA();
        } else {
            this.exi.getSwitchView().mB();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.exd != null && this.exd.getPageContext() != null && this.exd.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.exd.getPageContext(), i);
            }
            if (this.buT != null) {
                this.buT.onChangeSkinType(this.exd.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.exd.getPageContext(), i);
            }
            if (this.exi != null) {
                this.exi.ev(i);
            }
            if (this.exj != null) {
                am.j(this.exj, d.C0142d.cp_bg_line_e);
            }
            this.exd.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.exd.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ciN.setVisibility(0);
    }

    public void il(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.exd.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds320)), NoDataViewFactory.d.ds(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(i));
        this.mNoDataView.onChangeSkinType(this.exd.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.ciN.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aMj() {
        if (this.exh != null) {
            this.exh.setVisibility(0);
        }
    }

    public void aMk() {
        if (this.exh != null) {
            this.exh.setVisibility(8);
        }
    }
}
