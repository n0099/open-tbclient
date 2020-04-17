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
    private ImageView adY;
    private TextView dkk;
    private View dkl;
    private ImageView dkm;
    private View dkn;
    private ImageView dko;
    private LinearLayout dkq;
    private TextView dkr;
    private View.OnClickListener dkt;
    private View dku;
    private MorePopupWindow dkv;
    protected View dkw;
    private View dkx;
    private View dky;
    private AdBaseWebViewActivity ezp;
    private int ezq;
    private int ezr;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean dkz = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.ezp = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.ezp.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.ezp.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.ezp.findViewById(R.id.view_navigation_bar);
        tC("");
        this.dkq = (LinearLayout) this.ezp.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dkq.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dkq.setLayoutParams(layoutParams);
        this.dkr = (TextView) this.ezp.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.ezp.findViewById(R.id.webview_progress);
        this.dkl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ezp != null && !c.this.ezp.webViewGoBack()) {
                    c.this.ezp.finish();
                }
            }
        });
        this.dkm = (ImageView) this.dkl.findViewById(R.id.widget_navi_back_button);
        this.dkm.setContentDescription(this.ezp.getResources().getString(R.string.back));
        this.dkn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ezp != null) {
                    c.this.ezp.finish();
                }
            }
        });
        this.dko = (ImageView) this.dkn.findViewById(R.id.widget_navi_back_button);
        this.dko.setContentDescription(this.ezp.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dko.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.ezp.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dko.setLayoutParams(layoutParams2);
        this.dku = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aAh();
            }
        });
        this.adY = (ImageView) this.dku.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.ezp.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dkv = new MorePopupWindow(this.ezp.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.ezp.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aHY() {
                c.this.aAh();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aHZ() {
            }
        });
        this.dkw = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dkw.setOnClickListener(this.ezp);
        if (com.baidu.tbadk.coreExtra.share.f.dH(this.ezp.getPageContext().getPageActivity())) {
            this.dkw.setVisibility(0);
        } else {
            this.dkw.setVisibility(8);
        }
        this.dkv.refresh();
        this.dky = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dky.setOnClickListener(this.ezp);
        this.dkx = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dkx.setOnClickListener(this.ezp);
        bgm();
    }

    private void bgm() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.ezp.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.ezp.getPageContext().getPageActivity()).heightPixels;
        this.ezq = (i - statusBarHeight) - dimens;
        this.ezr = i - statusBarHeight;
    }

    public boolean aHR() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean aHT() {
        try {
            this.dkq.addView(this.ezp.createWebView());
            this.dkr.setVisibility(8);
            if (!this.dkz) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dkr.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dkq.getLayoutParams().height = this.ezq;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dkq.getLayoutParams().height = this.ezr;
        this.mNavigationBar.setVisibility(8);
    }

    public void gn(boolean z) {
        if (this.dkw != null) {
            if (z) {
                this.dkw.setVisibility(0);
            } else {
                this.dkw.setVisibility(8);
            }
            this.dkv.refresh();
        }
    }

    public void go(boolean z) {
        if (this.dku != null) {
            if (z) {
                this.dku.setVisibility(0);
            } else {
                this.dku.setVisibility(8);
            }
        }
    }

    public void aAh() {
        this.dkv.showWindowInRightBottomOfHost();
    }

    public void aAi() {
        g.dismissPopupWindow(this.dkv, this.ezp.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.dkr.setVisibility(8);
    }

    public void tC(String str) {
        this.dkk = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dkm != null && this.dkm.getVisibility() == 0 && this.dko != null && this.dko.getVisibility() == 0) {
            this.dkk.setMaxWidth(l.getDimens(this.ezp.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.dkk, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.ezp.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cI(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.af("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.ezp.getPageContext().getPageActivity(), shareItem, true, aHW())));
        }
    }

    private SparseArray<String> aHW() {
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
            this.mNavigationBar.onChangeSkinType(this.ezp.getPageContext(), i);
        }
        if (this.dkv != null) {
            this.dkv.onChangeSkinType(this.ezp, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ezp.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.dkm, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.dko, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.adY, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dkq.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ezp.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cK(null, this.ezp.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ezp.getResources().getString(R.string.refresh), this.dkt)));
        }
        this.mNoDataView.onChangeSkinType(this.ezp.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dkq.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkt = onClickListener;
    }

    public void release() {
        if (this.dkq != null) {
            this.dkq.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dkv != null) {
            g.dismissPopupWindow(this.dkv, this.ezp.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dkq.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dkq.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.dkm, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.dko, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.adY, R.drawable.frs_star_navigation_bg);
        tC("");
        this.ezp.getWindow().setFlags(1024, 1024);
    }

    public void aHX() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dkq.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dkq.setLayoutParams(layoutParams);
        this.dkm.setBackgroundDrawable(null);
        this.dko.setBackgroundDrawable(null);
        this.adY.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.ezp.getWindow().clearFlags(1024);
    }

    public void gq(boolean z) {
        this.dkz = z;
    }
}
