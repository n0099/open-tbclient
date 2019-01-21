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
    private TextView aLy;
    private NoNetworkView bPm;
    private LinearLayout cFz;
    private RecommendDetailActivity fbF;
    private HeadImageView fbG;
    private TextView fbH;
    private TextView fbI;
    private LinearLayout fbJ;
    private SettingTextSwitchView fbK;
    private View fbL;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.fbF = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.fbF != null) {
            this.fbF.setContentView(e.h.recommend_detail_activity);
            this.mRootView = this.fbF.findViewById(e.g.root_view);
            this.mNavigationBar = (NavigationBar) this.fbF.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            qN(this.fbF.getResources().getString(e.j.recommend_detail_activity_title));
            this.bPm = (NoNetworkView) this.fbF.findViewById(e.g.view_no_network);
            this.cFz = (LinearLayout) this.fbF.findViewById(e.g.content_view);
            this.fbG = (HeadImageView) this.fbF.findViewById(e.g.user_image);
            this.fbG.setIsRound(true);
            this.aLy = (TextView) this.fbF.findViewById(e.g.user_name);
            this.fbH = (TextView) this.fbF.findViewById(e.g.user_type);
            this.fbI = (TextView) this.fbF.findViewById(e.g.intro_content);
            this.fbK = (SettingTextSwitchView) this.fbF.findViewById(e.g.switch_view);
            this.fbK.setSwitchStateChangeListener(this.fbF);
            this.fbK.setVisibility(8);
            this.cFz.setVisibility(8);
            this.fbJ = (LinearLayout) this.fbF.findViewById(e.g.switch_ll);
            this.fbL = this.fbF.findViewById(e.g.divider_1);
        }
    }

    public void qN(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.fbF != null) {
            this.fbG.startLoad(userInfoBigVip.portraith, 12, false);
            this.aLy.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.fbH.setText(userInfoBigVip.user_type);
            this.fbI.setText(userInfoBigVip.user_detail);
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
            this.fbK.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.fbK.getSwitchView().nT();
        } else {
            this.fbK.getSwitchView().nU();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fbF != null && this.fbF.getPageContext() != null && this.fbF.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.fbF.getPageContext(), i);
            }
            if (this.bPm != null) {
                this.bPm.onChangeSkinType(this.fbF.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.fbF.getPageContext(), i);
            }
            if (this.fbK != null) {
                this.fbK.fv(i);
            }
            if (this.fbL != null) {
                al.j(this.fbL, e.d.cp_bg_line_e);
            }
            this.fbF.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.fbF.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.cFz.setVisibility(0);
    }

    public void kf(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fbF.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds320)), NoDataViewFactory.d.eq(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.onChangeSkinType(this.fbF.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.cFz.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aVl() {
        if (this.fbJ != null) {
            this.fbJ.setVisibility(0);
        }
    }

    public void aVm() {
        if (this.fbJ != null) {
            this.fbJ.setVisibility(8);
        }
    }
}
