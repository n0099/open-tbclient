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
/* loaded from: classes26.dex */
public class b {
    private TextView eqE;
    private NoNetworkView gdx;
    private RecommendDetailActivity kii;
    private HeadImageView kij;
    private TextView kik;
    private TextView kil;
    private LinearLayout kim;
    private SettingTextSwitchView kin;
    private View kio;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.kii = recommendDetailActivity;
        initView();
    }

    private void initView() {
        if (this.kii != null) {
            this.kii.setContentView(R.layout.recommend_detail_activity);
            this.mRootView = this.kii.findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) this.kii.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            MN(this.kii.getResources().getString(R.string.recommend_detail_activity_title));
            this.gdx = (NoNetworkView) this.kii.findViewById(R.id.view_no_network);
            this.mContentView = (LinearLayout) this.kii.findViewById(R.id.content_view);
            this.kij = (HeadImageView) this.kii.findViewById(R.id.user_image);
            this.kij.setIsRound(true);
            this.eqE = (TextView) this.kii.findViewById(R.id.user_name);
            this.kik = (TextView) this.kii.findViewById(R.id.user_type);
            this.kil = (TextView) this.kii.findViewById(R.id.intro_content);
            this.kin = (SettingTextSwitchView) this.kii.findViewById(R.id.switch_view);
            this.kin.setSwitchStateChangeListener(this.kii);
            this.kin.setVisibility(8);
            this.mContentView.setVisibility(8);
            this.kim = (LinearLayout) this.kii.findViewById(R.id.switch_ll);
            this.kio = this.kii.findViewById(R.id.divider_1);
        }
    }

    public void MN(String str) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setCenterTextTitle(str);
        }
    }

    public void b(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip != null && this.kii != null) {
            this.kij.startLoad(userInfoBigVip.portraith, 12, false);
            this.eqE.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
            this.kik.setText(userInfoBigVip.user_type);
            this.kil.setText(userInfoBigVip.user_detail);
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
            this.kin.setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.kin.getSwitchView().turnOnNoCallback();
        } else {
            this.kin.getSwitchView().turnOffNoCallback();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kii != null && this.kii.getPageContext() != null && this.kii.getPageContext().getLayoutMode() != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.kii.getPageContext(), i);
            }
            if (this.gdx != null) {
                this.gdx.onChangeSkinType(this.kii.getPageContext(), i);
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.kii.getPageContext(), i);
            }
            if (this.kin != null) {
                this.kin.qP(i);
            }
            if (this.kio != null) {
                ap.setBackgroundColor(this.kio, R.color.cp_bg_line_e);
            }
            this.kii.getPageContext().getLayoutMode().setNightMode(i == 1);
            this.kii.getPageContext().getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.mContentView.setVisibility(0);
    }

    public void CD(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kii.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.d.pG(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pG(i));
        this.mNoDataView.onChangeSkinType(this.kii.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mContentView.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void cSt() {
        if (this.kim != null) {
            this.kim.setVisibility(0);
        }
    }

    public void cSu() {
        if (this.kim != null) {
            this.kim.setVisibility(8);
        }
    }
}
