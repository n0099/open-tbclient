package com.baidu.tieba.ad.browser;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private TextView bUW;
    private View bUX;
    private ImageView bUY;
    private View bUZ;
    private ImageView bVa;
    private ImageView bVb;
    private LinearLayout bVd;
    private TextView bVe;
    private View.OnClickListener bVg;
    private View bVh;
    private MorePopupWindow bVi;
    protected View bVj;
    private View bVk;
    private View bVl;
    private int bVm;
    private int bVn;
    private AdBaseWebViewActivity dhF;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean bVo = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dhF = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dhF.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.dhF.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dhF.findViewById(R.id.view_navigation_bar);
        mH("");
        this.bVd = (LinearLayout) this.dhF.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bVd.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bVd.setLayoutParams(layoutParams);
        this.bVe = (TextView) this.dhF.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.dhF.findViewById(R.id.webview_progress);
        this.bUX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dhF != null && !d.this.dhF.webViewGoBack()) {
                    d.this.dhF.finish();
                }
            }
        });
        this.bUY = (ImageView) this.bUX.findViewById(R.id.widget_navi_back_button);
        this.bUY.setContentDescription(this.dhF.getResources().getString(R.string.back));
        this.bUZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dhF != null) {
                    d.this.dhF.finish();
                }
            }
        });
        this.bVa = (ImageView) this.bUZ.findViewById(R.id.widget_navi_back_button);
        this.bVa.setContentDescription(this.dhF.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bVa.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dhF.getPageContext().getPageActivity(), R.dimen.ds4);
        this.bVa.setLayoutParams(layoutParams2);
        this.bVh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ZE();
            }
        });
        this.bVb = (ImageView) this.bVh.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.dhF.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bVi = new MorePopupWindow(this.dhF.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dhF.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void agj() {
                d.this.ZE();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void agk() {
            }
        });
        this.bVj = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bVj.setOnClickListener(this.dhF);
        if (com.baidu.tbadk.coreExtra.c.f.cv(this.dhF.getPageContext().getPageActivity())) {
            this.bVj.setVisibility(0);
        } else {
            this.bVj.setVisibility(8);
        }
        this.bVi.refresh();
        this.bVl = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bVl.setOnClickListener(this.dhF);
        this.bVk = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bVk.setOnClickListener(this.dhF);
        aga();
    }

    private void aga() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dhF.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dhF.getPageContext().getPageActivity()).heightPixels;
        this.bVm = (i - statusBarHeight) - dimens;
        this.bVn = i - statusBarHeight;
    }

    public boolean agc() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean age() {
        try {
            this.bVd.addView(this.dhF.createWebView());
            this.bVe.setVisibility(8);
            if (!this.bVo) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bVe.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bVd.getLayoutParams().height = this.bVm;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.bVd.getLayoutParams().height = this.bVn;
        this.mNavigationBar.setVisibility(8);
    }

    public void dR(boolean z) {
        if (this.bVj != null) {
            if (z) {
                this.bVj.setVisibility(0);
            } else {
                this.bVj.setVisibility(8);
            }
            this.bVi.refresh();
        }
    }

    public void dS(boolean z) {
        if (this.bVh != null) {
            if (z) {
                this.bVh.setVisibility(0);
            } else {
                this.bVh.setVisibility(8);
            }
        }
    }

    public void ZE() {
        this.bVi.showWindowInRightBottomOfHost();
    }

    public void ZF() {
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.bVi, this.dhF.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.bVe.setVisibility(8);
    }

    public void mH(String str) {
        this.bUW = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bUY != null && this.bUY.getVisibility() == 0 && this.bVa != null && this.bVa.getVisibility() == 0) {
            this.bUW.setMaxWidth(l.getDimens(this.dhF.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.bUW, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.dhF.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.bS(TiebaInitialize.Params.OBJ_URL, eVar.linkUrl);
            anVar.O("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dhF.getPageContext().getPageActivity(), eVar, true, agh())));
        }
    }

    private SparseArray<String> agh() {
        if (0 != 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>(8);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dhF.getPageContext(), i);
        }
        if (this.bVi != null) {
            this.bVi.onChangeSkinType(this.dhF, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dhF.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.bUY, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.bVa, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.bVb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bVd.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dhF.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.bU(null, this.dhF.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dhF.getResources().getString(R.string.refresh), this.bVg)));
        }
        this.mNoDataView.onChangeSkinType(this.dhF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bVd.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bVg = onClickListener;
    }

    public void release() {
        if (this.bVd != null) {
            this.bVd.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bVi != null) {
            com.baidu.adp.lib.g.g.dismissPopupWindow(this.bVi, this.dhF.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bVd.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bVd.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.bUY, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bVa, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bVb, R.drawable.frs_star_navigation_bg);
        mH("");
        this.dhF.getWindow().setFlags(1024, 1024);
    }

    public void agi() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bVd.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bVd.setLayoutParams(layoutParams);
        this.bUY.setBackgroundDrawable(null);
        this.bVa.setBackgroundDrawable(null);
        this.bVb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dhF.getWindow().clearFlags(1024);
    }

    public void dU(boolean z) {
        this.bVo = z;
    }
}
