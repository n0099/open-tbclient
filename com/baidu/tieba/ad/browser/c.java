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
    private ImageView aeb;
    protected View dkA;
    private View dkB;
    private View dkC;
    private TextView dko;
    private View dkp;
    private ImageView dkq;
    private View dkr;
    private ImageView dks;
    private LinearLayout dku;
    private TextView dkv;
    private View.OnClickListener dkx;
    private View dky;
    private MorePopupWindow dkz;
    private AdBaseWebViewActivity ezu;
    private int ezv;
    private int ezw;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean dkD = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.ezu = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.ezu.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.ezu.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.ezu.findViewById(R.id.view_navigation_bar);
        tF("");
        this.dku = (LinearLayout) this.ezu.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dku.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dku.setLayoutParams(layoutParams);
        this.dkv = (TextView) this.ezu.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.ezu.findViewById(R.id.webview_progress);
        this.dkp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ezu != null && !c.this.ezu.webViewGoBack()) {
                    c.this.ezu.finish();
                }
            }
        });
        this.dkq = (ImageView) this.dkp.findViewById(R.id.widget_navi_back_button);
        this.dkq.setContentDescription(this.ezu.getResources().getString(R.string.back));
        this.dkr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ezu != null) {
                    c.this.ezu.finish();
                }
            }
        });
        this.dks = (ImageView) this.dkr.findViewById(R.id.widget_navi_back_button);
        this.dks.setContentDescription(this.ezu.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dks.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.ezu.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dks.setLayoutParams(layoutParams2);
        this.dky = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aAh();
            }
        });
        this.aeb = (ImageView) this.dky.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.ezu.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dkz = new MorePopupWindow(this.ezu.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.ezu.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aHW() {
                c.this.aAh();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aHX() {
            }
        });
        this.dkA = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dkA.setOnClickListener(this.ezu);
        if (com.baidu.tbadk.coreExtra.share.f.dv(this.ezu.getPageContext().getPageActivity())) {
            this.dkA.setVisibility(0);
        } else {
            this.dkA.setVisibility(8);
        }
        this.dkz.refresh();
        this.dkC = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dkC.setOnClickListener(this.ezu);
        this.dkB = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dkB.setOnClickListener(this.ezu);
        bgk();
    }

    private void bgk() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.ezu.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.ezu.getPageContext().getPageActivity()).heightPixels;
        this.ezv = (i - statusBarHeight) - dimens;
        this.ezw = i - statusBarHeight;
    }

    public boolean aHP() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean aHR() {
        try {
            this.dku.addView(this.ezu.createWebView());
            this.dkv.setVisibility(8);
            if (!this.dkD) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dkv.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dku.getLayoutParams().height = this.ezv;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dku.getLayoutParams().height = this.ezw;
        this.mNavigationBar.setVisibility(8);
    }

    public void gn(boolean z) {
        if (this.dkA != null) {
            if (z) {
                this.dkA.setVisibility(0);
            } else {
                this.dkA.setVisibility(8);
            }
            this.dkz.refresh();
        }
    }

    public void go(boolean z) {
        if (this.dky != null) {
            if (z) {
                this.dky.setVisibility(0);
            } else {
                this.dky.setVisibility(8);
            }
        }
    }

    public void aAh() {
        this.dkz.showWindowInRightBottomOfHost();
    }

    public void aAi() {
        g.dismissPopupWindow(this.dkz, this.ezu.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.dkv.setVisibility(8);
    }

    public void tF(String str) {
        this.dko = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dkq != null && this.dkq.getVisibility() == 0 && this.dks != null && this.dks.getVisibility() == 0) {
            this.dko.setMaxWidth(l.getDimens(this.ezu.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.dko, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.ezu.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cI(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.af("obj_type", 0);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.ezu.getPageContext().getPageActivity(), shareItem, true, aHU())));
        }
    }

    private SparseArray<String> aHU() {
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
            this.mNavigationBar.onChangeSkinType(this.ezu.getPageContext(), i);
        }
        if (this.dkz != null) {
            this.dkz.onChangeSkinType(this.ezu, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ezu.getPageContext(), i);
        }
        am.setNavbarIconSrc(this.dkq, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        am.setNavbarIconSrc(this.dks, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        am.setNavbarIconSrc(this.aeb, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dku.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ezu.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.cK(null, this.ezu.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ezu.getResources().getString(R.string.refresh), this.dkx)));
        }
        this.mNoDataView.onChangeSkinType(this.ezu.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dku.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkx = onClickListener;
    }

    public void release() {
        if (this.dku != null) {
            this.dku.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dkz != null) {
            g.dismissPopupWindow(this.dkz, this.ezu.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dku.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dku.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.dkq, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.dks, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.aeb, R.drawable.frs_star_navigation_bg);
        tF("");
        this.ezu.getWindow().setFlags(1024, 1024);
    }

    public void aHV() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dku.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dku.setLayoutParams(layoutParams);
        this.dkq.setBackgroundDrawable(null);
        this.dks.setBackgroundDrawable(null);
        this.aeb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.ezu.getWindow().clearFlags(1024);
    }

    public void gq(boolean z) {
        this.dkD = z;
    }
}
