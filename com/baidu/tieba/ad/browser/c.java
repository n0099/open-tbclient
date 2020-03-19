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
    private TextView cLd;
    private View cLe;
    private ImageView cLf;
    private ImageView cLg;
    private LinearLayout cLi;
    private TextView cLj;
    private View.OnClickListener cLl;
    private View cLm;
    private MorePopupWindow cLn;
    protected View cLo;
    private View cLp;
    private View cLq;
    private AdBaseWebViewActivity dZs;
    private int dZt;
    private int dZu;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean cLr = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.dZs = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dZs.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.dZs.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dZs.findViewById(R.id.view_navigation_bar);
        so("");
        this.cLi = (LinearLayout) this.dZs.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cLi.setLayoutParams(layoutParams);
        this.cLj = (TextView) this.dZs.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.dZs.findViewById(R.id.webview_progress);
        this.cLe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dZs != null && !c.this.dZs.webViewGoBack()) {
                    c.this.dZs.finish();
                }
            }
        });
        this.cLf = (ImageView) this.cLe.findViewById(R.id.widget_navi_back_button);
        this.cLf.setContentDescription(this.dZs.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dZs != null) {
                    c.this.dZs.finish();
                }
            }
        });
        this.cLg = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cLg.setContentDescription(this.dZs.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cLg.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dZs.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cLg.setLayoutParams(layoutParams2);
        this.cLm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.arW();
            }
        });
        this.Lb = (ImageView) this.cLm.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.dZs.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cLn = new MorePopupWindow(this.dZs.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dZs.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azL() {
                c.this.arW();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azM() {
            }
        });
        this.cLo = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cLo.setOnClickListener(this.dZs);
        if (com.baidu.tbadk.coreExtra.share.f.dT(this.dZs.getPageContext().getPageActivity())) {
            this.cLo.setVisibility(0);
        } else {
            this.cLo.setVisibility(8);
        }
        this.cLn.refresh();
        this.cLq = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cLq.setOnClickListener(this.dZs);
        this.cLp = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cLp.setOnClickListener(this.dZs);
        aYh();
    }

    private void aYh() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.dZs.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.dZs.getPageContext().getPageActivity()).heightPixels;
        this.dZt = (i - statusBarHeight) - dimens;
        this.dZu = i - statusBarHeight;
    }

    public boolean azE() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean azG() {
        try {
            this.cLi.addView(this.dZs.createWebView());
            this.cLj.setVisibility(8);
            if (!this.cLr) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cLj.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cLi.getLayoutParams().height = this.dZt;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cLi.getLayoutParams().height = this.dZu;
        this.mNavigationBar.setVisibility(8);
    }

    public void fq(boolean z) {
        if (this.cLo != null) {
            if (z) {
                this.cLo.setVisibility(0);
            } else {
                this.cLo.setVisibility(8);
            }
            this.cLn.refresh();
        }
    }

    public void fr(boolean z) {
        if (this.cLm != null) {
            if (z) {
                this.cLm.setVisibility(0);
            } else {
                this.cLm.setVisibility(8);
            }
        }
    }

    public void arW() {
        this.cLn.showWindowInRightBottomOfHost();
    }

    public void arX() {
        g.dismissPopupWindow(this.cLn, this.dZs.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.cLj.setVisibility(8);
    }

    public void so(String str) {
        this.cLd = this.mNavigationBar.setCenterTextTitle(str);
        if (this.cLf != null && this.cLf.getVisibility() == 0 && this.cLg != null && this.cLg.getVisibility() == 0) {
            this.cLd.setMaxWidth(l.getDimens(this.dZs.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.cLd, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dZs.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cx(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dZs.getPageContext().getPageActivity(), shareItem, true, azJ())));
        }
    }

    private SparseArray<String> azJ() {
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
            this.mNavigationBar.onChangeSkinType(this.dZs.getPageContext(), i);
        }
        if (this.cLn != null) {
            this.cLn.onChangeSkinType(this.dZs, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dZs.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.cLf, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.cLg, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.Lb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cLi.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dZs.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cz(null, this.dZs.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dZs.getResources().getString(R.string.refresh), this.cLl)));
        }
        this.mNoDataView.onChangeSkinType(this.dZs.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cLi.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLl = onClickListener;
    }

    public void release() {
        if (this.cLi != null) {
            this.cLi.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLn != null) {
            g.dismissPopupWindow(this.cLn, this.dZs.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLi.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cLi.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.cLf, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cLg, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        so("");
        this.dZs.getWindow().setFlags(1024, 1024);
    }

    public void azK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cLi.setLayoutParams(layoutParams);
        this.cLf.setBackgroundDrawable(null);
        this.cLg.setBackgroundDrawable(null);
        this.Lb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.dZs.getWindow().clearFlags(1024);
    }

    public void ft(boolean z) {
        this.cLr = z;
    }
}
