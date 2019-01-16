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
    private TextView aLx;
    private NoNetworkView bPl;
    private LinearLayout cFy;
    private RecommendDetailActivity fbE;
    private HeadImageView fbF;
    private TextView fbG;
    private TextView fbH;
    private LinearLayout fbI;
    private SettingTextSwitchView fbJ;
    private View fbK;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.fbE = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.fbE != null) {
            this.fbE.setContentView(e.h.recommend_detail_activity);
            this.mRootView = this.fbE.findViewById(e.g.root_view);
            this.mNavigationBar = (NavigationBar) this.fbE.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            qN(this.fbE.getResources().getString(e.j.recommend_detail_activity_title));
            this.bPl = (NoNetworkView) this.fbE.findViewById(e.g.view_no_network);
            this.cFy = (LinearLayout) this.fbE.findViewById(e.g.content_view);
            this.fbF = (HeadImageView) this.fbE.findViewById(e.g.user_image);
            this.fbF.setIsRound(true);
            this.aLx = (TextView) this.fbE.findViewById(e.g.user_name);
            this.fbG = (TextView) this.fbE.findViewById(e.g.user_type);
            this.fbH = (TextView) this.fbE.findViewById(e.g.intro_content);
            this.fbJ = (SettingTextSwitchView) this.fbE.findViewById(e.g.switch_view);
            this.fbJ.setSwitchStateChangeListener(this.fbE);
            this.fbJ.setVisibility(8);
            this.cFy.setVisibility(8);
            this.fbI = (LinearLayout) this.fbE.findViewById(e.g.switch_ll);
            this.fbK = this.fbE.findViewById(e.g.divider_1);
        }
    }

    public void qN(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.fbE != null) {
            this.fbF.startLoad(userInfoBigVip.portraith, 12, false);
            this.aLx.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.fbG.setText(userInfoBigVip.user_type);
            this.fbH.setText(userInfoBigVip.user_detail);
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
            this.fbJ.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.fbJ.getSwitchView().nT();
        } else {
            this.fbJ.getSwitchView().nU();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fbE != null && this.fbE.getPageContext() != null && this.fbE.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.fbE.getPageContext(), i);
            }
            if (this.bPl != null) {
                this.bPl.onChangeSkinType(this.fbE.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.fbE.getPageContext(), i);
            }
            if (this.fbJ != null) {
                this.fbJ.fv(i);
            }
            if (this.fbK != null) {
                al.j(this.fbK, e.d.cp_bg_line_e);
            }
            this.fbE.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.fbE.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.cFy.setVisibility(0);
    }

    public void kf(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fbE.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds320)), NoDataViewFactory.d.eq(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.onChangeSkinType(this.fbE.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.cFy.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aVl() {
        if (this.fbI != null) {
            this.fbI.setVisibility(0);
        }
    }

    public void aVm() {
        if (this.fbI != null) {
            this.fbI.setVisibility(8);
        }
    }
}
