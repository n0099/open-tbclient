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
/* loaded from: classes8.dex */
public class c {
    private ImageView aex;
    protected View dyA;
    private TextView dyo;
    private View dyp;
    private ImageView dyq;
    private ImageView dys;
    private LinearLayout dyu;
    private TextView dyv;
    private View.OnClickListener dyx;
    private View dyy;
    private MorePopupWindow dyz;
    private int eNV;
    private int eNW;
    private AdBaseWebViewActivity eOc;
    private ApkDownloadBannerView eOd;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey eOe = null;
    private com.baidu.tieba.ad.download.a.d eOf = null;
    private boolean dyD = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.eOc = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.eOc.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.eOc.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.eOc.findViewById(R.id.view_navigation_bar);
        vl("");
        this.dyu = (LinearLayout) this.eOc.findViewById(R.id.webview_container);
        this.eOd = (ApkDownloadBannerView) this.eOc.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dyu.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dyu.setLayoutParams(layoutParams);
        this.dyv = (TextView) this.eOc.findViewById(R.id.webview_crash_tip);
        this.dyp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eOc != null && !c.this.eOc.webViewGoBack()) {
                    c.this.eOc.finish();
                }
            }
        });
        this.dyq = (ImageView) this.dyp.findViewById(R.id.widget_navi_back_button);
        this.dyq.setContentDescription(this.eOc.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bmx();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bmy();
            }
        });
        bmv();
    }

    private void bmv() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.eOc.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.eOc.getPageContext().getPageActivity()).heightPixels;
        this.eNV = (i - statusBarHeight) - dimens;
        this.eNW = i - statusBarHeight;
    }

    public boolean aND() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean aNF() {
        try {
            this.dyu.addView(this.eOc.createWebView());
            this.dyv.setVisibility(8);
            if (!this.dyD) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dyv.setVisibility(0);
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
        this.dyu.getLayoutParams().height = -1;
    }

    public void gF(boolean z) {
        if (this.dyA != null) {
            if (z) {
                this.dyA.setVisibility(0);
            } else {
                this.dyA.setVisibility(8);
            }
            this.dyz.refresh();
        }
    }

    public void gG(boolean z) {
        if (this.dyy != null) {
            if (z) {
                this.dyy.setVisibility(0);
            } else {
                this.dyy.setVisibility(8);
            }
        }
    }

    public void aEa() {
        g.dismissPopupWindow(this.dyz, this.eOc.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.dyv.setVisibility(8);
    }

    public void vl(String str) {
        this.dyo = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dyq != null && this.dyq.getVisibility() == 0 && this.dys != null && this.dys.getVisibility() == 0) {
            this.dyo.setMaxWidth(l.getDimens(this.eOc.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.dyo, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.eOc.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.dh(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.ag("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.eOc.getPageContext().getPageActivity(), shareItem, true, aNI())));
        }
    }

    private SparseArray<String> aNI() {
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
            this.mNavigationBar.onChangeSkinType(this.eOc.getPageContext(), i);
        }
        if (this.dyz != null) {
            this.dyz.onChangeSkinType(this.eOc, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eOc.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.dyq, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.dys, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.aex, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dyu.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eOc.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dj(null, this.eOc.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eOc.getResources().getString(R.string.refresh), this.dyx)));
        }
        this.mNoDataView.onChangeSkinType(this.eOc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dyu.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dyx = onClickListener;
    }

    public void release() {
        if (this.dyu != null) {
            this.dyu.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dyz != null) {
            g.dismissPopupWindow(this.dyz, this.eOc.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dyu.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dyu.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.dyq, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.dys, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.aex, R.drawable.frs_star_navigation_bg);
        vl("");
        this.eOc.getWindow().setFlags(1024, 1024);
    }

    public void aNJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dyu.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dyu.setLayoutParams(layoutParams);
        this.dyq.setBackgroundDrawable(null);
        this.dys.setBackgroundDrawable(null);
        this.aex.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.eOc.getWindow().clearFlags(1024);
    }

    public void gI(boolean z) {
        this.dyD = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.eOe = downloadCacheKey;
        if (this.eOf == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bmD().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.eOd, d, "LANDING_PAGE");
            this.eOf = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bmx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmx() {
        if (this.eOe != null && this.eOf != null) {
            com.baidu.tieba.ad.download.d.bmD().a(this.eOe, this.eOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmy() {
        com.baidu.tieba.ad.download.d.bmD().b(this.eOe, this.eOf);
    }
}
