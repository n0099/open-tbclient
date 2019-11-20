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
import com.baidu.adp.lib.g.g;
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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.view.ApkDownloadBannerView;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c {
    private TextView bUf;
    private View bUg;
    private ImageView bUh;
    private ImageView bUj;
    private ImageView bUk;
    private LinearLayout bUm;
    private TextView bUn;
    private View.OnClickListener bUp;
    private View bUq;
    private MorePopupWindow bUr;
    protected View bUs;
    private int bUv;
    private int bUw;
    private AdBaseWebViewActivity dgU;
    private ApkDownloadBannerView dgV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey dgW = null;
    private com.baidu.tieba.ad.download.a.d dgX = null;
    private boolean bUx = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dgU = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dgU.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.dgU.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dgU.findViewById(R.id.view_navigation_bar);
        mH("");
        this.bUm = (LinearLayout) this.dgU.findViewById(R.id.webview_container);
        this.dgV = (ApkDownloadBannerView) this.dgU.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bUm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bUm.setLayoutParams(layoutParams);
        this.bUn = (TextView) this.dgU.findViewById(R.id.webview_crash_tip);
        this.bUg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dgU != null && !c.this.dgU.webViewGoBack()) {
                    c.this.dgU.finish();
                }
            }
        });
        this.bUh = (ImageView) this.bUg.findViewById(R.id.widget_navi_back_button);
        this.bUh.setContentDescription(this.dgU.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aDA();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.aDB();
            }
        });
        afY();
    }

    private void afY() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dgU.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dgU.getPageContext().getPageActivity()).heightPixels;
        this.bUv = (i - statusBarHeight) - dimens;
        this.bUw = i - statusBarHeight;
    }

    public boolean aga() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean agc() {
        try {
            this.bUm.addView(this.dgU.createWebView());
            this.bUn.setVisibility(8);
            if (!this.bUx) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bUn.setVisibility(0);
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
        this.bUm.getLayoutParams().height = -1;
    }

    public void dR(boolean z) {
        if (this.bUs != null) {
            if (z) {
                this.bUs.setVisibility(0);
            } else {
                this.bUs.setVisibility(8);
            }
            this.bUr.refresh();
        }
    }

    public void dS(boolean z) {
        if (this.bUq != null) {
            if (z) {
                this.bUq.setVisibility(0);
            } else {
                this.bUq.setVisibility(8);
            }
        }
    }

    public void ZD() {
        g.dismissPopupWindow(this.bUr, this.dgU.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.bUn.setVisibility(8);
    }

    public void mH(String str) {
        this.bUf = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bUh != null && this.bUh.getVisibility() == 0 && this.bUj != null && this.bUj.getVisibility() == 0) {
            this.bUf.setMaxWidth(l.getDimens(this.dgU.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.bUf, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.dgU.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.bS(TiebaInitialize.Params.OBJ_URL, eVar.linkUrl);
            anVar.O("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dgU.getPageContext().getPageActivity(), eVar, true, agf())));
        }
    }

    private SparseArray<String> agf() {
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
            this.mNavigationBar.onChangeSkinType(this.dgU.getPageContext(), i);
        }
        if (this.bUr != null) {
            this.bUr.onChangeSkinType(this.dgU, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dgU.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.bUh, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.bUj, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.bUk, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bUm.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dgU.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.bU(null, this.dgU.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dgU.getResources().getString(R.string.refresh), this.bUp)));
        }
        this.mNoDataView.onChangeSkinType(this.dgU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bUm.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bUp = onClickListener;
    }

    public void release() {
        if (this.bUm != null) {
            this.bUm.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bUr != null) {
            g.dismissPopupWindow(this.bUr, this.dgU.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bUm.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bUm.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.bUh, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bUj, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bUk, R.drawable.frs_star_navigation_bg);
        mH("");
        this.dgU.getWindow().setFlags(1024, 1024);
    }

    public void agg() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bUm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bUm.setLayoutParams(layoutParams);
        this.bUh.setBackgroundDrawable(null);
        this.bUj.setBackgroundDrawable(null);
        this.bUk.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dgU.getWindow().clearFlags(1024);
    }

    public void dU(boolean z) {
        this.bUx = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.dgW = downloadCacheKey;
        if (this.dgX == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.aDG().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.dgV, d, "LANDING_PAGE");
            this.dgX = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        aDA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDA() {
        if (this.dgW != null && this.dgX != null) {
            com.baidu.tieba.ad.download.d.aDG().a(this.dgW, this.dgX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDB() {
        com.baidu.tieba.ad.download.d.aDG().b(this.dgW, this.dgX);
    }
}
