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
import com.baidu.adp.lib.f.g;
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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c {
    private ImageView Lb;
    private TextView cKQ;
    private View cKR;
    private ImageView cKS;
    private ImageView cKT;
    private LinearLayout cKV;
    private TextView cKW;
    private View.OnClickListener cKY;
    private View cKZ;
    private MorePopupWindow cLa;
    protected View cLb;
    private View cLc;
    private View cLd;
    private AdBaseWebViewActivity dYO;
    private int dYP;
    private int dYQ;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean cLe = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dYO = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dYO.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.dYO.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dYO.findViewById(R.id.view_navigation_bar);
        so("");
        this.cKV = (LinearLayout) this.dYO.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKV.setLayoutParams(layoutParams);
        this.cKW = (TextView) this.dYO.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.dYO.findViewById(R.id.webview_progress);
        this.cKR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dYO != null && !c.this.dYO.webViewGoBack()) {
                    c.this.dYO.finish();
                }
            }
        });
        this.cKS = (ImageView) this.cKR.findViewById(R.id.widget_navi_back_button);
        this.cKS.setContentDescription(this.dYO.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dYO != null) {
                    c.this.dYO.finish();
                }
            }
        });
        this.cKT = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cKT.setContentDescription(this.dYO.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKT.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dYO.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cKT.setLayoutParams(layoutParams2);
        this.cKZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.arR();
            }
        });
        this.Lb = (ImageView) this.cKZ.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.dYO.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cLa = new MorePopupWindow(this.dYO.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dYO.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azG() {
                c.this.arR();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azH() {
            }
        });
        this.cLb = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cLb.setOnClickListener(this.dYO);
        if (com.baidu.tbadk.coreExtra.share.f.dU(this.dYO.getPageContext().getPageActivity())) {
            this.cLb.setVisibility(0);
        } else {
            this.cLb.setVisibility(8);
        }
        this.cLa.refresh();
        this.cLd = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cLd.setOnClickListener(this.dYO);
        this.cLc = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cLc.setOnClickListener(this.dYO);
        aYa();
    }

    private void aYa() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dYO.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dYO.getPageContext().getPageActivity()).heightPixels;
        this.dYP = (i - statusBarHeight) - dimens;
        this.dYQ = i - statusBarHeight;
    }

    public boolean azz() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean azB() {
        try {
            this.cKV.addView(this.dYO.createWebView());
            this.cKW.setVisibility(8);
            if (!this.cLe) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cKW.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cKV.getLayoutParams().height = this.dYP;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cKV.getLayoutParams().height = this.dYQ;
        this.mNavigationBar.setVisibility(8);
    }

    public void fp(boolean z) {
        if (this.cLb != null) {
            if (z) {
                this.cLb.setVisibility(0);
            } else {
                this.cLb.setVisibility(8);
            }
            this.cLa.refresh();
        }
    }

    public void fq(boolean z) {
        if (this.cKZ != null) {
            if (z) {
                this.cKZ.setVisibility(0);
            } else {
                this.cKZ.setVisibility(8);
            }
        }
    }

    public void arR() {
        this.cLa.showWindowInRightBottomOfHost();
    }

    public void arS() {
        g.dismissPopupWindow(this.cLa, this.dYO.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.cKW.setVisibility(8);
    }

    public void so(String str) {
        this.cKQ = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cKS != null && this.cKS.getVisibility() == 0 && this.cKT != null && this.cKT.getVisibility() == 0) {
            this.cKQ.setMaxWidth(l.getDimens(this.dYO.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cKQ, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dYO.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dYO.getPageContext().getPageActivity(), shareItem, true, azE())));
        }
    }

    private SparseArray<String> azE() {
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
            this.mNavigationBar.onChangeSkinType(this.dYO.getPageContext(), i);
        }
        if (this.cLa != null) {
            this.cLa.onChangeSkinType(this.dYO, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dYO.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cKS, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cKT, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.Lb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cKV.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dYO.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cA(null, this.dYO.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dYO.getResources().getString(R.string.refresh), this.cKY)));
        }
        this.mNoDataView.onChangeSkinType(this.dYO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cKV.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKY = onClickListener;
    }

    public void release() {
        if (this.cKV != null) {
            this.cKV.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLa != null) {
            g.dismissPopupWindow(this.cLa, this.dYO.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cKV.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cKS, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKT, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        so("");
        this.dYO.getWindow().setFlags(1024, 1024);
    }

    public void azF() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKV.setLayoutParams(layoutParams);
        this.cKS.setBackgroundDrawable(null);
        this.cKT.setBackgroundDrawable(null);
        this.Lb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dYO.getWindow().clearFlags(1024);
    }

    public void fs(boolean z) {
        this.cLe = z;
    }
}
