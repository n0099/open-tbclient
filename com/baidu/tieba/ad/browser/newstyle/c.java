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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes15.dex */
public class c {
    private ImageView aeV;
    private View.OnClickListener dJA;
    private View dJB;
    private MorePopupWindow dJC;
    protected View dJD;
    private TextView dJr;
    private View dJs;
    private ImageView dJt;
    private ImageView dJv;
    private LinearLayout dJx;
    private TextView dJy;
    private int fcT;
    private int fcU;
    private AdBaseWebViewActivity fda;
    private ApkDownloadBannerView fdb;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey fdc = null;
    private com.baidu.tieba.ad.download.a.d fdd = null;
    private boolean dJG = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.fda = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.fda.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.fda.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.fda.findViewById(R.id.view_navigation_bar);
        wx("");
        this.dJx = (LinearLayout) this.fda.findViewById(R.id.webview_container);
        this.fdb = (ApkDownloadBannerView) this.fda.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJx.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dJx.setLayoutParams(layoutParams);
        this.dJy = (TextView) this.fda.findViewById(R.id.webview_crash_tip);
        this.dJs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fda != null && !c.this.fda.webViewGoBack()) {
                    c.this.fda.finish();
                }
            }
        });
        this.dJt = (ImageView) this.dJs.findViewById(R.id.widget_navi_back_button);
        this.dJt.setContentDescription(this.fda.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bsb();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bsc();
            }
        });
        brZ();
    }

    private void brZ() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.fda.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.fda.getPageContext().getPageActivity()).heightPixels;
        this.fcT = (i - statusBarHeight) - dimens;
        this.fcU = i - statusBarHeight;
    }

    public boolean aTc() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean aTe() {
        try {
            this.dJx.addView(this.fda.createWebView());
            this.dJy.setVisibility(8);
            if (!this.dJG) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dJy.setVisibility(0);
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
        this.dJx.getLayoutParams().height = -1;
    }

    public void hh(boolean z) {
        if (this.dJD != null) {
            if (z) {
                this.dJD.setVisibility(0);
            } else {
                this.dJD.setVisibility(8);
            }
            this.dJC.refresh();
        }
    }

    public void hi(boolean z) {
        if (this.dJB != null) {
            if (z) {
                this.dJB.setVisibility(0);
            } else {
                this.dJB.setVisibility(8);
            }
        }
    }

    public void aIX() {
        g.dismissPopupWindow(this.dJC, this.fda.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.dJy.setVisibility(8);
    }

    public void wx(String str) {
        this.dJr = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dJt != null && this.dJt.getVisibility() == 0 && this.dJv != null && this.dJv.getVisibility() == 0) {
            this.dJr.setMaxWidth(l.getDimens(this.fda.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ao.setNavbarTitleColor(this.dJr, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.fda.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ap apVar = new ap(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            apVar.dn(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            apVar.ah("obj_type", 0);
            TiebaStatic.log(apVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.fda.getPageContext().getPageActivity(), shareItem, true, aTh())));
        }
    }

    private SparseArray<String> aTh() {
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
            this.mNavigationBar.onChangeSkinType(this.fda.getPageContext(), i);
        }
        if (this.dJC != null) {
            this.dJC.onChangeSkinType(this.fda, i, ao.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fda.getPageContext(), i);
        }
        ao.setNavbarIconSrc(this.dJt, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ao.setNavbarIconSrc(this.dJv, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ao.setNavbarIconSrc(this.aeV, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dJx.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fda.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.m31do(null, this.fda.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fda.getResources().getString(R.string.refresh), this.dJA)));
        }
        this.mNoDataView.onChangeSkinType(this.fda.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dJx.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dJA = onClickListener;
    }

    public void release() {
        if (this.dJx != null) {
            this.dJx.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dJC != null) {
            g.dismissPopupWindow(this.dJC, this.fda.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJx.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dJx.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ao.setBackgroundResource(this.dJt, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.dJv, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.aeV, R.drawable.frs_star_navigation_bg);
        wx("");
        this.fda.getWindow().setFlags(1024, 1024);
    }

    public void aTj() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJx.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dJx.setLayoutParams(layoutParams);
        this.dJt.setBackgroundDrawable(null);
        this.dJv.setBackgroundDrawable(null);
        this.aeV.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.fda.getWindow().clearFlags(1024);
    }

    public void hk(boolean z) {
        this.dJG = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.fdc = downloadCacheKey;
        if (this.fdd == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bsi().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.fdb, d, "LANDING_PAGE");
            this.fdd = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bsb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsb() {
        if (this.fdc != null && this.fdd != null) {
            com.baidu.tieba.ad.download.d.bsi().a(this.fdc, this.fdd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsc() {
        com.baidu.tieba.ad.download.d.bsi().b(this.fdc, this.fdd);
    }
}
