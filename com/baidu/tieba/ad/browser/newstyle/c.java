package com.baidu.tieba.ad.browser.newstyle;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
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
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.view.ApkDownloadBannerView;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c {
    private ImageView KG;
    private TextView cGN;
    private View cGO;
    private ImageView cGP;
    private ImageView cGQ;
    private LinearLayout cGS;
    private TextView cGT;
    private View.OnClickListener cGV;
    private View cGW;
    private MorePopupWindow cGX;
    protected View cGY;
    private int dUL;
    private int dUM;
    private AdBaseWebViewActivity dUS;
    private ApkDownloadBannerView dUT;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey dUU = null;
    private com.baidu.tieba.ad.download.a.d dUV = null;
    private boolean cHb = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dUS = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dUS.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.dUS.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dUS.findViewById(R.id.view_navigation_bar);
        rY("");
        this.cGS = (LinearLayout) this.dUS.findViewById(R.id.webview_container);
        this.dUT = (ApkDownloadBannerView) this.dUS.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGS.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGS.setLayoutParams(layoutParams);
        this.cGT = (TextView) this.dUS.findViewById(R.id.webview_crash_tip);
        this.cGO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dUS != null && !c.this.dUS.webViewGoBack()) {
                    c.this.dUS.finish();
                }
            }
        });
        this.cGP = (ImageView) this.cGO.findViewById(R.id.widget_navi_back_button);
        this.cGP.setContentDescription(this.dUS.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aVN();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.aVO();
            }
        });
        aVL();
    }

    private void aVL() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dUS.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dUS.getPageContext().getPageActivity()).heightPixels;
        this.dUL = (i - statusBarHeight) - dimens;
        this.dUM = i - statusBarHeight;
    }

    public boolean axl() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean axn() {
        try {
            this.cGS.addView(this.dUS.createWebView());
            this.cGT.setVisibility(8);
            if (!this.cHb) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cGT.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.mNavigationBar.setVisibility(0);
        } else {
            this.mNavigationBar.setVisibility(8);
        }
        this.cGS.getLayoutParams().height = -1;
    }

    public void fi(boolean z) {
        if (this.cGY != null) {
            if (z) {
                this.cGY.setVisibility(0);
            } else {
                this.cGY.setVisibility(8);
            }
            this.cGX.refresh();
        }
    }

    public void fj(boolean z) {
        if (this.cGW != null) {
            if (z) {
                this.cGW.setVisibility(0);
            } else {
                this.cGW.setVisibility(8);
            }
        }
    }

    public void apF() {
        g.dismissPopupWindow(this.cGX, this.dUS.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.cGT.setVisibility(8);
    }

    public void rY(String str) {
        this.cGN = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cGP != null && this.cGP.getVisibility() == 0 && this.cGQ != null && this.cGQ.getVisibility() == 0) {
            this.cGN.setMaxWidth(l.getDimens(this.dUS.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cGN, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dUS.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cp(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.Z("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dUS.getPageContext().getPageActivity(), shareItem, true, axq())));
        }
    }

    private SparseArray<String> axq() {
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
            this.mNavigationBar.onChangeSkinType(this.dUS.getPageContext(), i);
        }
        if (this.cGX != null) {
            this.cGX.onChangeSkinType(this.dUS, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dUS.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cGP, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cGQ, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.KG, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cGS.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dUS.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cr(null, this.dUS.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dUS.getResources().getString(R.string.refresh), this.cGV)));
        }
        this.mNoDataView.onChangeSkinType(this.dUS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cGS.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cGV = onClickListener;
    }

    public void release() {
        if (this.cGS != null) {
            this.cGS.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cGX != null) {
            g.dismissPopupWindow(this.cGX, this.dUS.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGS.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cGS.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cGP, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cGQ, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.KG, R.drawable.frs_star_navigation_bg);
        rY("");
        this.dUS.getWindow().setFlags(1024, 1024);
    }

    public void axr() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGS.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGS.setLayoutParams(layoutParams);
        this.cGP.setBackgroundDrawable(null);
        this.cGQ.setBackgroundDrawable(null);
        this.KG.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dUS.getWindow().clearFlags(1024);
    }

    public void fl(boolean z) {
        this.cHb = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.dUU = downloadCacheKey;
        if (this.dUV == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.aVT().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.dUT, d, "LANDING_PAGE");
            this.dUV = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        aVN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVN() {
        if (this.dUU != null && this.dUV != null) {
            com.baidu.tieba.ad.download.d.aVT().a(this.dUU, this.dUV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVO() {
        com.baidu.tieba.ad.download.d.aVT().b(this.dUU, this.dUV);
    }
}
