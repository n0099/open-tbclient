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
    private TextView aBX;
    private NoNetworkView bBq;
    private LinearLayout cqk;
    private RecommendDetailActivity eIj;
    private HeadImageView eIk;
    private TextView eIl;
    private TextView eIm;
    private LinearLayout eIn;
    private SettingTextSwitchView eIo;
    private View eIp;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.eIj = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.eIj != null) {
            this.eIj.setContentView(e.h.recommend_detail_activity);
            this.mRootView = this.eIj.findViewById(e.g.root_view);
            this.mNavigationBar = (NavigationBar) this.eIj.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            pp(this.eIj.getResources().getString(e.j.recommend_detail_activity_title));
            this.bBq = (NoNetworkView) this.eIj.findViewById(e.g.view_no_network);
            this.cqk = (LinearLayout) this.eIj.findViewById(e.g.content_view);
            this.eIk = (HeadImageView) this.eIj.findViewById(e.g.user_image);
            this.eIk.setIsRound(true);
            this.aBX = (TextView) this.eIj.findViewById(e.g.user_name);
            this.eIl = (TextView) this.eIj.findViewById(e.g.user_type);
            this.eIm = (TextView) this.eIj.findViewById(e.g.intro_content);
            this.eIo = (SettingTextSwitchView) this.eIj.findViewById(e.g.switch_view);
            this.eIo.setSwitchStateChangeListener(this.eIj);
            this.eIo.setVisibility(8);
            this.cqk.setVisibility(8);
            this.eIn = (LinearLayout) this.eIj.findViewById(e.g.switch_ll);
            this.eIp = this.eIj.findViewById(e.g.divider_1);
        }
    }

    public void pp(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.eIj != null) {
            this.eIk.startLoad(userInfoBigVip.portraith, 12, false);
            this.aBX.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.eIl.setText(userInfoBigVip.user_type);
            this.eIm.setText(userInfoBigVip.user_detail);
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
            this.eIo.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eIo.getSwitchView().nI();
        } else {
            this.eIo.getSwitchView().nJ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eIj != null && this.eIj.getPageContext() != null && this.eIj.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eIj.getPageContext(), i);
            }
            if (this.bBq != null) {
                this.bBq.onChangeSkinType(this.eIj.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eIj.getPageContext(), i);
            }
            if (this.eIo != null) {
                this.eIo.eJ(i);
            }
            if (this.eIp != null) {
                al.j(this.eIp, e.d.cp_bg_line_e);
            }
            this.eIj.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.eIj.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.cqk.setVisibility(0);
    }

    public void iR(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eIj.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds320)), NoDataViewFactory.d.dE(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(i));
        this.mNoDataView.onChangeSkinType(this.eIj.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.cqk.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void aPv() {
        if (this.eIn != null) {
            this.eIn.setVisibility(0);
        }
    }

    public void aPw() {
        if (this.eIn != null) {
            this.eIn.setVisibility(8);
        }
    }
}
