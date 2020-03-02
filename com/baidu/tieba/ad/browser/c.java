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
    private TextView cKR;
    private View cKS;
    private ImageView cKT;
    private ImageView cKU;
    private LinearLayout cKW;
    private TextView cKX;
    private View.OnClickListener cKZ;
    private View cLa;
    private MorePopupWindow cLb;
    protected View cLc;
    private View cLd;
    private View cLe;
    private AdBaseWebViewActivity dYP;
    private int dYQ;
    private int dYR;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean cLf = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dYP = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dYP.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.dYP.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dYP.findViewById(R.id.view_navigation_bar);
        so("");
        this.cKW = (LinearLayout) this.dYP.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKW.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKW.setLayoutParams(layoutParams);
        this.cKX = (TextView) this.dYP.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.dYP.findViewById(R.id.webview_progress);
        this.cKS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dYP != null && !c.this.dYP.webViewGoBack()) {
                    c.this.dYP.finish();
                }
            }
        });
        this.cKT = (ImageView) this.cKS.findViewById(R.id.widget_navi_back_button);
        this.cKT.setContentDescription(this.dYP.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dYP != null) {
                    c.this.dYP.finish();
                }
            }
        });
        this.cKU = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cKU.setContentDescription(this.dYP.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKU.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dYP.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cKU.setLayoutParams(layoutParams2);
        this.cLa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.arT();
            }
        });
        this.Lb = (ImageView) this.cLa.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.dYP.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cLb = new MorePopupWindow(this.dYP.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dYP.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azI() {
                c.this.arT();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azJ() {
            }
        });
        this.cLc = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cLc.setOnClickListener(this.dYP);
        if (com.baidu.tbadk.coreExtra.share.f.dU(this.dYP.getPageContext().getPageActivity())) {
            this.cLc.setVisibility(0);
        } else {
            this.cLc.setVisibility(8);
        }
        this.cLb.refresh();
        this.cLe = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cLe.setOnClickListener(this.dYP);
        this.cLd = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cLd.setOnClickListener(this.dYP);
        aYc();
    }

    private void aYc() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dYP.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dYP.getPageContext().getPageActivity()).heightPixels;
        this.dYQ = (i - statusBarHeight) - dimens;
        this.dYR = i - statusBarHeight;
    }

    public boolean azB() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean azD() {
        try {
            this.cKW.addView(this.dYP.createWebView());
            this.cKX.setVisibility(8);
            if (!this.cLf) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cKX.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cKW.getLayoutParams().height = this.dYQ;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cKW.getLayoutParams().height = this.dYR;
        this.mNavigationBar.setVisibility(8);
    }

    public void fp(boolean z) {
        if (this.cLc != null) {
            if (z) {
                this.cLc.setVisibility(0);
            } else {
                this.cLc.setVisibility(8);
            }
            this.cLb.refresh();
        }
    }

    public void fq(boolean z) {
        if (this.cLa != null) {
            if (z) {
                this.cLa.setVisibility(0);
            } else {
                this.cLa.setVisibility(8);
            }
        }
    }

    public void arT() {
        this.cLb.showWindowInRightBottomOfHost();
    }

    public void arU() {
        g.dismissPopupWindow(this.cLb, this.dYP.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.cKX.setVisibility(8);
    }

    public void so(String str) {
        this.cKR = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cKT != null && this.cKT.getVisibility() == 0 && this.cKU != null && this.cKU.getVisibility() == 0) {
            this.cKR.setMaxWidth(l.getDimens(this.dYP.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cKR, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dYP.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dYP.getPageContext().getPageActivity(), shareItem, true, azG())));
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
            this.mNavigationBar.onChangeSkinType(this.dYP.getPageContext(), i);
        }
        if (this.cLb != null) {
            this.cLb.onChangeSkinType(this.dYP, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dYP.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cKT, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cKU, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.Lb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cKW.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dYP.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cA(null, this.dYP.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dYP.getResources().getString(R.string.refresh), this.cKZ)));
        }
        this.mNoDataView.onChangeSkinType(this.dYP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cKW.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKZ = onClickListener;
    }

    public void release() {
        if (this.cKW != null) {
            this.cKW.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLb != null) {
            g.dismissPopupWindow(this.cLb, this.dYP.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKW.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cKW.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cKT, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKU, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        so("");
        this.dYP.getWindow().setFlags(1024, 1024);
    }

    public void azH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKW.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKW.setLayoutParams(layoutParams);
        this.cKT.setBackgroundDrawable(null);
        this.cKU.setBackgroundDrawable(null);
        this.Lb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dYP.getWindow().clearFlags(1024);
    }

    public void fs(boolean z) {
        this.cLf = z;
    }
}
