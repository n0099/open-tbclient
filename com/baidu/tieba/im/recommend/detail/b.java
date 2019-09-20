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
    private TextView cdZ;
    private NoNetworkView dpy;
    private LinearLayout ejc;
    private RecommendDetailActivity gRL;
    private HeadImageView gRM;
    private TextView gRN;
    private TextView gRO;
    private LinearLayout gRP;
    private SettingTextSwitchView gRQ;
    private View gRR;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.gRL = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.gRL != null) {
            this.gRL.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.gRL.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.gRL.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            zS(this.gRL.getResources().getString(R.string.recommend_detail_activity_title));
            this.dpy = (NoNetworkView) this.gRL.findViewById(R.id.view_no_network);
            this.ejc = (LinearLayout) this.gRL.findViewById(R.id.content_view);
            this.gRM = (HeadImageView) this.gRL.findViewById(R.id.user_image);
            this.gRM.setIsRound(true);
            this.cdZ = (TextView) this.gRL.findViewById(R.id.user_name);
            this.gRN = (TextView) this.gRL.findViewById(R.id.user_type);
            this.gRO = (TextView) this.gRL.findViewById(R.id.intro_content);
            this.gRQ = (SettingTextSwitchView) this.gRL.findViewById(R.id.switch_view);
            this.gRQ.setSwitchStateChangeListener(this.gRL);
            this.gRQ.setVisibility(8);
            this.ejc.setVisibility(8);
            this.gRP = (LinearLayout) this.gRL.findViewById(R.id.switch_ll);
            this.gRR = this.gRL.findViewById(R.id.divider_1);
        }
    }

    public void zS(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.gRL != null) {
            this.gRM.startLoad(userInfoBigVip.portraith, 12, false);
            this.cdZ.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.gRN.setText(userInfoBigVip.user_type);
            this.gRO.setText(userInfoBigVip.user_detail);
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
            this.gRQ.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.gRQ.getSwitchView().nk();
        } else {
            this.gRQ.getSwitchView().nl();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gRL != null && this.gRL.getPageContext() != null && this.gRL.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.gRL.getPageContext(), i);
            }
            if (this.dpy != null) {
                this.dpy.onChangeSkinType(this.gRL.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.gRL.getPageContext(), i);
            }
            if (this.gRQ != null) {
                this.gRQ.kd(i);
            }
            if (this.gRR != null) {
                am.l(this.gRR, R.color.cp_bg_line_e);
            }
            this.gRL.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.gRL.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ejc.setVisibility(0);
    }

    public void pb(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gRL.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.iQ(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(i));
        this.mNoDataView.onChangeSkinType(this.gRL.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.ejc.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void bHi() {
        if (this.gRP != null) {
            this.gRP.setVisibility(0);
        }
    }

    public void bHj() {
        if (this.gRP != null) {
            this.gRP.setVisibility(8);
        }
    }
}
