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
/* loaded from: classes3.dex */
public class b {
    private TextView ccZ;
    private NoNetworkView dnF;
    private LinearLayout ehl;
    private RecommendDetailActivity gOZ;
    private HeadImageView gPa;
    private TextView gPb;
    private TextView gPc;
    private LinearLayout gPd;
    private SettingTextSwitchView gPe;
    private View gPf;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.gOZ = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.gOZ != null) {
            this.gOZ.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.gOZ.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.gOZ.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            zs(this.gOZ.getResources().getString(R.string.recommend_detail_activity_title));
            this.dnF = (NoNetworkView) this.gOZ.findViewById(R.id.view_no_network);
            this.ehl = (LinearLayout) this.gOZ.findViewById(R.id.content_view);
            this.gPa = (HeadImageView) this.gOZ.findViewById(R.id.user_image);
            this.gPa.setIsRound(true);
            this.ccZ = (TextView) this.gOZ.findViewById(R.id.user_name);
            this.gPb = (TextView) this.gOZ.findViewById(R.id.user_type);
            this.gPc = (TextView) this.gOZ.findViewById(R.id.intro_content);
            this.gPe = (SettingTextSwitchView) this.gOZ.findViewById(R.id.switch_view);
            this.gPe.setSwitchStateChangeListener(this.gOZ);
            this.gPe.setVisibility(8);
            this.ehl.setVisibility(8);
            this.gPd = (LinearLayout) this.gOZ.findViewById(R.id.switch_ll);
            this.gPf = this.gOZ.findViewById(R.id.divider_1);
        }
    }

    public void zs(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.gOZ != null) {
            this.gPa.startLoad(userInfoBigVip.portraith, 12, false);
            this.ccZ.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.gPb.setText(userInfoBigVip.user_type);
            this.gPc.setText(userInfoBigVip.user_detail);
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
            this.gPe.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.gPe.getSwitchView().nk();
        } else {
            this.gPe.getSwitchView().nl();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gOZ != null && this.gOZ.getPageContext() != null && this.gOZ.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gOZ.getPageContext(), i);
            }
            if (this.dnF != null) {
                this.dnF.onChangeSkinType(this.gOZ.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.gOZ.getPageContext(), i);
            }
            if (this.gPe != null) {
                this.gPe.jZ(i);
            }
            if (this.gPf != null) {
                am.l(this.gPf, R.color.cp_bg_line_e);
            }
            this.gOZ.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.gOZ.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ehl.setVisibility(0);
    }

    public void oW(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gOZ.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.iN(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(i));
        this.mNoDataView.onChangeSkinType(this.gOZ.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.ehl.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bGg() {
        if (this.gPd != null) {
            this.gPd.setVisibility(0);
        }
    }

    public void bGh() {
        if (this.gPd != null) {
            this.gPd.setVisibility(8);
        }
    }
}
