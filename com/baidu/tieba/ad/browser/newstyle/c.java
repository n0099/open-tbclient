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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes8.dex */
public class c {
    private ImageView afe;
    private LinearLayout dDA;
    private TextView dDB;
    private View.OnClickListener dDD;
    private View dDE;
    private MorePopupWindow dDF;
    protected View dDG;
    private TextView dDu;
    private View dDv;
    private ImageView dDw;
    private ImageView dDy;
    private int eYr;
    private int eYs;
    private AdBaseWebViewActivity eYy;
    private ApkDownloadBannerView eYz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey eYA = null;
    private com.baidu.tieba.ad.download.a.d eYB = null;
    private boolean dDJ = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.eYy = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.eYy.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.eYy.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.eYy.findViewById(R.id.view_navigation_bar);
        vv("");
        this.dDA = (LinearLayout) this.eYy.findViewById(R.id.webview_container);
        this.eYz = (ApkDownloadBannerView) this.eYy.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDA.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dDA.setLayoutParams(layoutParams);
        this.dDB = (TextView) this.eYy.findViewById(R.id.webview_crash_tip);
        this.dDv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eYy != null && !c.this.eYy.webViewGoBack()) {
                    c.this.eYy.finish();
                }
            }
        });
        this.dDw = (ImageView) this.dDv.findViewById(R.id.widget_navi_back_button);
        this.dDw.setContentDescription(this.eYy.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.boY();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.boZ();
            }
        });
        boW();
    }

    private void boW() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.eYy.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.eYy.getPageContext().getPageActivity()).heightPixels;
        this.eYr = (i - statusBarHeight) - dimens;
        this.eYs = i - statusBarHeight;
    }

    public boolean aPh() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean aPj() {
        try {
            this.dDA.addView(this.eYy.createWebView());
            this.dDB.setVisibility(8);
            if (!this.dDJ) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dDB.setVisibility(0);
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
        this.dDA.getLayoutParams().height = -1;
    }

    public void gM(boolean z) {
        if (this.dDG != null) {
            if (z) {
                this.dDG.setVisibility(0);
            } else {
                this.dDG.setVisibility(8);
            }
            this.dDF.refresh();
        }
    }

    public void gN(boolean z) {
        if (this.dDE != null) {
            if (z) {
                this.dDE.setVisibility(0);
            } else {
                this.dDE.setVisibility(8);
            }
        }
    }

    public void aFg() {
        g.dismissPopupWindow(this.dDF, this.eYy.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.dDB.setVisibility(8);
    }

    public void vv(String str) {
        this.dDu = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dDw != null && this.dDw.getVisibility() == 0 && this.dDy != null && this.dDy.getVisibility() == 0) {
            this.dDu.setMaxWidth(l.getDimens(this.eYy.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        an.setNavbarTitleColor(this.dDu, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.eYy.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ao aoVar = new ao(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aoVar.dk(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aoVar.ag("obj_type", 0);
            TiebaStatic.log(aoVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.eYy.getPageContext().getPageActivity(), shareItem, true, aPm())));
        }
    }

    private SparseArray<String> aPm() {
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
            this.mNavigationBar.onChangeSkinType(this.eYy.getPageContext(), i);
        }
        if (this.dDF != null) {
            this.dDF.onChangeSkinType(this.eYy, i, an.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eYy.getPageContext(), i);
        }
        an.setNavbarIconSrc(this.dDw, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        an.setNavbarIconSrc(this.dDy, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        an.setNavbarIconSrc(this.afe, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dDA.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eYy.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dm(null, this.eYy.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eYy.getResources().getString(R.string.refresh), this.dDD)));
        }
        this.mNoDataView.onChangeSkinType(this.eYy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dDA.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dDD = onClickListener;
    }

    public void release() {
        if (this.dDA != null) {
            this.dDA.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dDF != null) {
            g.dismissPopupWindow(this.dDF, this.eYy.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDA.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dDA.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        an.setBackgroundResource(this.dDw, R.drawable.frs_star_navigation_bg);
        an.setBackgroundResource(this.dDy, R.drawable.frs_star_navigation_bg);
        an.setBackgroundResource(this.afe, R.drawable.frs_star_navigation_bg);
        vv("");
        this.eYy.getWindow().setFlags(1024, 1024);
    }

    public void aPo() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDA.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dDA.setLayoutParams(layoutParams);
        this.dDw.setBackgroundDrawable(null);
        this.dDy.setBackgroundDrawable(null);
        this.afe.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.eYy.getWindow().clearFlags(1024);
    }

    public void gP(boolean z) {
        this.dDJ = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.eYA = downloadCacheKey;
        if (this.eYB == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bpf().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.eYz, d, "LANDING_PAGE");
            this.eYB = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        boY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boY() {
        if (this.eYA != null && this.eYB != null) {
            com.baidu.tieba.ad.download.d.bpf().a(this.eYA, this.eYB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boZ() {
        com.baidu.tieba.ad.download.d.bpf().b(this.eYA, this.eYB);
    }
}
