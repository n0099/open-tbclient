package com.baidu.tieba.im.recommend.detail;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.e;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class b {
    private TextView aHt;
    private NoNetworkView bKI;
    private LinearLayout czV;
    private RecommendDetailActivity eRl;
    private HeadImageView eRm;
    private TextView eRn;
    private TextView eRo;
    private LinearLayout eRp;
    private SettingTextSwitchView eRq;
    private View eRr;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.eRl = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.eRl != null) {
            this.eRl.setContentView(e.h.recommend_detail_activity);
            this.mRootView = this.eRl.findViewById(e.g.root_view);
            this.mNavigationBar = (NavigationBar) this.eRl.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            pS(this.eRl.getResources().getString(e.j.recommend_detail_activity_title));
            this.bKI = (NoNetworkView) this.eRl.findViewById(e.g.view_no_network);
            this.czV = (LinearLayout) this.eRl.findViewById(e.g.content_view);
            this.eRm = (HeadImageView) this.eRl.findViewById(e.g.user_image);
            this.eRm.setIsRound(true);
            this.aHt = (TextView) this.eRl.findViewById(e.g.user_name);
            this.eRn = (TextView) this.eRl.findViewById(e.g.user_type);
            this.eRo = (TextView) this.eRl.findViewById(e.g.intro_content);
            this.eRq = (SettingTextSwitchView) this.eRl.findViewById(e.g.switch_view);
            this.eRq.setSwitchStateChangeListener(this.eRl);
            this.eRq.setVisibility(8);
            this.czV.setVisibility(8);
            this.eRp = (LinearLayout) this.eRl.findViewById(e.g.switch_ll);
            this.eRr = this.eRl.findViewById(e.g.divider_1);
        }
    }

    public void pS(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.eRl != null) {
            this.eRm.startLoad(userInfoBigVip.portraith, 12, false);
            this.aHt.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.eRn.setText(userInfoBigVip.user_type);
            this.eRo.setText(userInfoBigVip.user_detail);
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
            this.eRq.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eRq.getSwitchView().nQ();
        } else {
            this.eRq.getSwitchView().nR();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eRl != null && this.eRl.getPageContext() != null && this.eRl.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eRl.getPageContext(), i);
            }
            if (this.bKI != null) {
                this.bKI.onChangeSkinType(this.eRl.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eRl.getPageContext(), i);
            }
            if (this.eRq != null) {
                this.eRq.fg(i);
            }
            if (this.eRr != null) {
                al.j(this.eRr, e.d.cp_bg_line_e);
            }
            this.eRl.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.eRl.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.czV.setVisibility(0);
    }

    public void jJ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eRl.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds320)), NoDataViewFactory.d.ec(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(i));
        this.mNoDataView.onChangeSkinType(this.eRl.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.czV.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aSg() {
        if (this.eRp != null) {
            this.eRp.setVisibility(0);
        }
    }

    public void aSh() {
        if (this.eRp != null) {
            this.eRp.setVisibility(8);
        }
    }
}
