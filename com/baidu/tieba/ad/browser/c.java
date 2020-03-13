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
    private TextView cKS;
    private View cKT;
    private ImageView cKU;
    private ImageView cKV;
    private LinearLayout cKX;
    private TextView cKY;
    private View.OnClickListener cLa;
    private View cLb;
    private MorePopupWindow cLc;
    protected View cLd;
    private View cLe;
    private View cLf;
    private AdBaseWebViewActivity dZc;
    private int dZd;
    private int dZe;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean cLg = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dZc = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dZc.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.dZc.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dZc.findViewById(R.id.view_navigation_bar);
        so("");
        this.cKX = (LinearLayout) this.dZc.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKX.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKX.setLayoutParams(layoutParams);
        this.cKY = (TextView) this.dZc.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.dZc.findViewById(R.id.webview_progress);
        this.cKT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dZc != null && !c.this.dZc.webViewGoBack()) {
                    c.this.dZc.finish();
                }
            }
        });
        this.cKU = (ImageView) this.cKT.findViewById(R.id.widget_navi_back_button);
        this.cKU.setContentDescription(this.dZc.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dZc != null) {
                    c.this.dZc.finish();
                }
            }
        });
        this.cKV = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cKV.setContentDescription(this.dZc.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dZc.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cKV.setLayoutParams(layoutParams2);
        this.cLb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.arT();
            }
        });
        this.Lb = (ImageView) this.cLb.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.dZc.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cLc = new MorePopupWindow(this.dZc.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dZc.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azI() {
                c.this.arT();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azJ() {
            }
        });
        this.cLd = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cLd.setOnClickListener(this.dZc);
        if (com.baidu.tbadk.coreExtra.share.f.dU(this.dZc.getPageContext().getPageActivity())) {
            this.cLd.setVisibility(0);
        } else {
            this.cLd.setVisibility(8);
        }
        this.cLc.refresh();
        this.cLf = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cLf.setOnClickListener(this.dZc);
        this.cLe = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cLe.setOnClickListener(this.dZc);
        aYd();
    }

    private void aYd() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dZc.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dZc.getPageContext().getPageActivity()).heightPixels;
        this.dZd = (i - statusBarHeight) - dimens;
        this.dZe = i - statusBarHeight;
    }

    public boolean azB() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean azD() {
        try {
            this.cKX.addView(this.dZc.createWebView());
            this.cKY.setVisibility(8);
            if (!this.cLg) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cKY.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cKX.getLayoutParams().height = this.dZd;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cKX.getLayoutParams().height = this.dZe;
        this.mNavigationBar.setVisibility(8);
    }

    public void fp(boolean z) {
        if (this.cLd != null) {
            if (z) {
                this.cLd.setVisibility(0);
            } else {
                this.cLd.setVisibility(8);
            }
            this.cLc.refresh();
        }
    }

    public void fq(boolean z) {
        if (this.cLb != null) {
            if (z) {
                this.cLb.setVisibility(0);
            } else {
                this.cLb.setVisibility(8);
            }
        }
    }

    public void arT() {
        this.cLc.showWindowInRightBottomOfHost();
    }

    public void arU() {
        g.dismissPopupWindow(this.cLc, this.dZc.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.cKY.setVisibility(8);
    }

    public void so(String str) {
        this.cKS = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cKU != null && this.cKU.getVisibility() == 0 && this.cKV != null && this.cKV.getVisibility() == 0) {
            this.cKS.setMaxWidth(l.getDimens(this.dZc.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cKS, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dZc.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dZc.getPageContext().getPageActivity(), shareItem, true, azG())));
        }
    }

    private SparseArray<String> azG() {
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
            this.mNavigationBar.onChangeSkinType(this.dZc.getPageContext(), i);
        }
        if (this.cLc != null) {
            this.cLc.onChangeSkinType(this.dZc, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dZc.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cKU, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cKV, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.Lb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cKX.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dZc.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cA(null, this.dZc.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dZc.getResources().getString(R.string.refresh), this.cLa)));
        }
        this.mNoDataView.onChangeSkinType(this.dZc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cKX.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLa = onClickListener;
    }

    public void release() {
        if (this.cKX != null) {
            this.cKX.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLc != null) {
            g.dismissPopupWindow(this.cLc, this.dZc.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKX.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cKX.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cKU, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKV, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        so("");
        this.dZc.getWindow().setFlags(1024, 1024);
    }

    public void azH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKX.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKX.setLayoutParams(layoutParams);
        this.cKU.setBackgroundDrawable(null);
        this.cKV.setBackgroundDrawable(null);
        this.Lb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dZc.getWindow().clearFlags(1024);
    }

    public void fs(boolean z) {
        this.cLg = z;
    }
}
