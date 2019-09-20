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
    private TextView bCB;
    private View bCC;
    private ImageView bCD;
    private View bCE;
    private ImageView bCF;
    private ImageView bCG;
    private LinearLayout bCI;
    private TextView bCJ;
    private View.OnClickListener bCL;
    private View bCM;
    private MorePopupWindow bCN;
    protected View bCO;
    private View bCP;
    private View bCQ;
    private int bCR;
    private int bCS;
    private AdBaseWebViewActivity cYk;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean bCT = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.cYk = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cYk.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.cYk.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cYk.findViewById(R.id.view_navigation_bar);
        mg("");
        this.bCI = (LinearLayout) this.cYk.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCI.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bCI.setLayoutParams(layoutParams);
        this.bCJ = (TextView) this.cYk.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.cYk.findViewById(R.id.webview_progress);
        this.bCC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cYk != null && !d.this.cYk.webViewGoBack()) {
                    d.this.cYk.finish();
                }
            }
        });
        this.bCD = (ImageView) this.bCC.findViewById(R.id.widget_navi_back_button);
        this.bCD.setContentDescription(this.cYk.getResources().getString(R.string.back));
        this.bCE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cYk != null) {
                    d.this.cYk.finish();
                }
            }
        });
        this.bCF = (ImageView) this.bCE.findViewById(R.id.widget_navi_back_button);
        this.bCF.setContentDescription(this.cYk.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCF.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.cYk.getPageContext().getPageActivity(), R.dimen.ds4);
        this.bCF.setLayoutParams(layoutParams2);
        this.bCM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.UP();
            }
        });
        this.bCG = (ImageView) this.bCM.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.cYk.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bCN = new MorePopupWindow(this.cYk.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cYk.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void abD() {
                d.this.UP();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void abE() {
            }
        });
        this.bCO = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bCO.setOnClickListener(this.cYk);
        if (com.baidu.tbadk.coreExtra.c.f.cJ(this.cYk.getPageContext().getPageActivity())) {
            this.bCO.setVisibility(0);
        } else {
            this.bCO.setVisibility(8);
        }
        this.bCN.refresh();
        this.bCQ = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bCQ.setOnClickListener(this.cYk);
        this.bCP = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bCP.setOnClickListener(this.cYk);
        abu();
    }

    private void abu() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = l.g(this.cYk.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.v(this.cYk.getPageContext().getPageActivity()).heightPixels;
        this.bCR = (i - statusBarHeight) - g;
        this.bCS = i - statusBarHeight;
    }

    public boolean abw() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean aby() {
        try {
            this.bCI.addView(this.cYk.createWebView());
            this.bCJ.setVisibility(8);
            if (!this.bCT) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bCJ.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bCI.getLayoutParams().height = this.bCR;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.bCI.getLayoutParams().height = this.bCS;
        this.mNavigationBar.setVisibility(8);
    }

    public void dA(boolean z) {
        if (this.bCO != null) {
            if (z) {
                this.bCO.setVisibility(0);
            } else {
                this.bCO.setVisibility(8);
            }
            this.bCN.refresh();
        }
    }

    public void dB(boolean z) {
        if (this.bCM != null) {
            if (z) {
                this.bCM.setVisibility(0);
            } else {
                this.bCM.setVisibility(8);
            }
        }
    }

    public void UP() {
        this.bCN.showWindowInRightBottomOfHost();
    }

    public void UQ() {
        com.baidu.adp.lib.g.g.a(this.bCN, this.cYk.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.bCJ.setVisibility(8);
    }

    public void mg(String str) {
        this.bCB = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bCD != null && this.bCD.getVisibility() == 0 && this.bCF != null && this.bCF.getVisibility() == 0) {
            this.bCB.setMaxWidth(l.g(this.cYk.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.e(this.bCB, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.cYk.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.bT("obj_url", eVar.linkUrl);
            anVar.P("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.cYk.getPageContext().getPageActivity(), eVar, true, abB())));
        }
    }

    private SparseArray<String> abB() {
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
            this.mNavigationBar.onChangeSkinType(this.cYk.getPageContext(), i);
        }
        if (this.bCN != null) {
            this.bCN.onChangeSkinType(this.cYk, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cYk.getPageContext(), i);
        }
        am.a(this.bCD, (int) R.drawable.selector_web_topbar_return_black, (int) R.drawable.selector_web_topbar_return_white, i);
        am.a(this.bCF, (int) R.drawable.selector_web_topbar_close_black, (int) R.drawable.selector_web_topbar_close_white, i);
        am.a(this.bCG, (int) R.drawable.selector_web_topbar_more_black, (int) R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bCI.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cYk.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.bX(null, this.cYk.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cYk.getResources().getString(R.string.refresh), this.bCL)));
        }
        this.mNoDataView.onChangeSkinType(this.cYk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bCI.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCL = onClickListener;
    }

    public void release() {
        if (this.bCI != null) {
            this.bCI.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bCN != null) {
            com.baidu.adp.lib.g.g.a(this.bCN, this.cYk.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCI.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bCI.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.k(this.bCD, R.drawable.frs_star_navigation_bg);
        am.k(this.bCF, R.drawable.frs_star_navigation_bg);
        am.k(this.bCG, R.drawable.frs_star_navigation_bg);
        mg("");
        this.cYk.getWindow().setFlags(1024, 1024);
    }

    public void abC() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCI.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bCI.setLayoutParams(layoutParams);
        this.bCD.setBackgroundDrawable(null);
        this.bCF.setBackgroundDrawable(null);
        this.bCG.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.cYk.getWindow().clearFlags(1024);
    }

    public void dD(boolean z) {
        this.bCT = z;
    }
}
