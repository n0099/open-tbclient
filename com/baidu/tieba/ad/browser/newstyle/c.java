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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes20.dex */
public class c {
    private ImageView agA;
    private TextView dUN;
    private View dUO;
    private ImageView dUP;
    private ImageView dUR;
    private LinearLayout dUT;
    private TextView dUU;
    private View.OnClickListener dUW;
    private View dUX;
    private MorePopupWindow dUY;
    protected View dUZ;
    private AdBaseWebViewActivity frE;
    private ApkDownloadBannerView frF;
    private int frx;
    private int fry;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private DownloadCacheKey frG = null;
    private com.baidu.tieba.ad.download.a.d frH = null;
    private boolean dVc = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.frE = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.frE.setContentView(R.layout.base_ad_webview_activity);
        this.mRoot = this.frE.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.frE.findViewById(R.id.view_navigation_bar);
        ze("");
        this.dUT = (LinearLayout) this.frE.findViewById(R.id.webview_container);
        this.frF = (ApkDownloadBannerView) this.frE.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dUT.setLayoutParams(layoutParams);
        this.dUU = (TextView) this.frE.findViewById(R.id.webview_crash_tip);
        this.dUO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.frE != null && !c.this.frE.webViewGoBack()) {
                    c.this.frE.finish();
                }
            }
        });
        this.dUP = (ImageView) this.dUO.findViewById(R.id.widget_navi_back_button);
        this.dUP.setContentDescription(this.frE.getResources().getString(R.string.back));
        this.mRoot.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ad.browser.newstyle.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.bCl();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                c.this.bCm();
            }
        });
        bCj();
    }

    private void bCj() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.frE.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.frE.getPageContext().getPageActivity()).heightPixels;
        this.frx = (i - statusBarHeight) - dimens;
        this.fry = i - statusBarHeight;
    }

    public boolean bcn() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean bcp() {
        try {
            this.dUT.addView(this.frE.createWebView());
            this.dUU.setVisibility(8);
            if (!this.dVc) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dUU.setVisibility(0);
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
        this.dUT.getLayoutParams().height = -1;
    }

    public void hB(boolean z) {
        if (this.dUZ != null) {
            if (z) {
                this.dUZ.setVisibility(0);
            } else {
                this.dUZ.setVisibility(8);
            }
            this.dUY.refresh();
        }
    }

    public void hC(boolean z) {
        if (this.dUX != null) {
            if (z) {
                this.dUX.setVisibility(0);
            } else {
                this.dUX.setVisibility(8);
            }
        }
    }

    public void aSz() {
        g.dismissPopupWindow(this.dUY, this.frE.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
    }

    public void hideProgressBar() {
    }

    public void hideCrashTip() {
        this.dUU.setVisibility(8);
    }

    public void ze(String str) {
        this.dUN = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dUP != null && this.dUP.getVisibility() == 0 && this.dUR != null && this.dUR.getVisibility() == 0) {
            this.dUN.setMaxWidth(l.getDimens(this.frE.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        ap.setNavbarTitleColor(this.dUN, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.frE.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dF(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.ai("obj_type", 0);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.frE.getPageContext().getPageActivity(), shareItem, true, bcs())));
        }
    }

    private SparseArray<String> bcs() {
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
            this.mNavigationBar.onChangeSkinType(this.frE.getPageContext(), i);
        }
        if (this.dUY != null) {
            this.dUY.onChangeSkinType(this.frE, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.frE.getPageContext(), i);
        }
        ap.setNavbarIconSrc(this.dUP, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        ap.setNavbarIconSrc(this.dUR, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        ap.setNavbarIconSrc(this.agA, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dUT.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.frE.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dG(null, this.frE.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.frE.getResources().getString(R.string.refresh), this.dUW)));
        }
        this.mNoDataView.onChangeSkinType(this.frE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dUT.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dUW = onClickListener;
    }

    public void release() {
        if (this.dUT != null) {
            this.dUT.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dUY != null) {
            g.dismissPopupWindow(this.dUY, this.frE.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dUT.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.setBackgroundResource(this.dUP, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dUR, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agA, R.drawable.frs_star_navigation_bg);
        ze("");
        this.frE.getWindow().setFlags(1024, 1024);
    }

    public void bcu() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dUT.setLayoutParams(layoutParams);
        this.dUP.setBackgroundDrawable(null);
        this.dUR.setBackgroundDrawable(null);
        this.agA.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.frE.getWindow().clearFlags(1024);
    }

    public void hE(boolean z) {
        this.dVc = z;
    }

    public void a(DownloadCacheKey downloadCacheKey) {
        this.frG = downloadCacheKey;
        if (this.frH == null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bCs().d(downloadCacheKey);
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.frF, d, "LANDING_PAGE");
            this.frH = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
        }
        bCl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCl() {
        if (this.frG != null && this.frH != null) {
            com.baidu.tieba.ad.download.d.bCs().a(this.frG, this.frH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCm() {
        com.baidu.tieba.ad.download.d.bCs().b(this.frG, this.frH);
    }
}
