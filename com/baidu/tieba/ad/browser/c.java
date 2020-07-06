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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
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
    private ImageView afe;
    private LinearLayout dDA;
    private TextView dDB;
    private View.OnClickListener dDD;
    private View dDE;
    private MorePopupWindow dDF;
    protected View dDG;
    private View dDH;
    private View dDI;
    private TextView dDu;
    private View dDv;
    private ImageView dDw;
    private View dDx;
    private ImageView dDy;
    private AdBaseWebViewActivity eYq;
    private int eYr;
    private int eYs;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;
    private boolean dDJ = true;

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.eYq = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.eYq.setContentView(R.layout.base_webview_activity);
        this.mRoot = this.eYq.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.eYq.findViewById(R.id.view_navigation_bar);
        vv("");
        this.dDA = (LinearLayout) this.eYq.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDA.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dDA.setLayoutParams(layoutParams);
        this.dDB = (TextView) this.eYq.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.eYq.findViewById(R.id.webview_progress);
        this.dDv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eYq != null && !c.this.eYq.webViewGoBack()) {
                    c.this.eYq.finish();
                }
            }
        });
        this.dDw = (ImageView) this.dDv.findViewById(R.id.widget_navi_back_button);
        this.dDw.setContentDescription(this.eYq.getResources().getString(R.string.back));
        this.dDx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eYq != null) {
                    c.this.eYq.finish();
                }
            }
        });
        this.dDy = (ImageView) this.dDx.findViewById(R.id.widget_navi_back_button);
        this.dDy.setContentDescription(this.eYq.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dDy.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.eYq.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dDy.setLayoutParams(layoutParams2);
        this.dDE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aFf();
            }
        });
        this.afe = (ImageView) this.dDE.findViewById(R.id.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.eYq.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dDF = new MorePopupWindow(this.eYq.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.eYq.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.c.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aPq() {
                c.this.aFf();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aPr() {
            }
        });
        this.dDG = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dDG.setOnClickListener(this.eYq);
        if (com.baidu.tbadk.coreExtra.share.f.dN(this.eYq.getPageContext().getPageActivity())) {
            this.dDG.setVisibility(0);
        } else {
            this.dDG.setVisibility(8);
        }
        this.dDF.refresh();
        this.dDI = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dDI.setOnClickListener(this.eYq);
        this.dDH = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dDH.setOnClickListener(this.eYq);
        boX();
    }

    private void boX() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.eYq.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.getScreenSize(this.eYq.getPageContext().getPageActivity()).heightPixels;
        this.eYr = (i - statusBarHeight) - dimens;
        this.eYs = i - statusBarHeight;
    }

    public boolean aPh() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean aPj() {
        try {
            this.dDA.addView(this.eYq.createWebView());
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
            this.dDA.getLayoutParams().height = this.eYr;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dDA.getLayoutParams().height = this.eYs;
        this.mNavigationBar.setVisibility(8);
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

    public void aFf() {
        this.dDF.showWindowInRightBottomOfHost();
    }

    public void aFg() {
        g.dismissPopupWindow(this.dDF, this.eYq.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.dDB.setVisibility(8);
    }

    public void vv(String str) {
        this.dDu = this.mNavigationBar.setCenterTextTitle(str);
        if (this.dDw != null && this.dDw.getVisibility() == 0 && this.dDy != null && this.dDy.getVisibility() == 0) {
            this.dDu.setMaxWidth(l.getDimens(this.eYq.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        an.setNavbarTitleColor(this.dDu, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.eYq.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ao aoVar = new ao(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aoVar.dk(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aoVar.ag("obj_type", 0);
            TiebaStatic.log(aoVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.eYq.getPageContext().getPageActivity(), shareItem, true, aPm())));
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
            this.mNavigationBar.onChangeSkinType(this.eYq.getPageContext(), i);
        }
        if (this.dDF != null) {
            this.dDF.onChangeSkinType(this.eYq, i, an.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eYq.getPageContext(), i);
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
            this.mNoDataView = NoDataViewFactory.a(this.eYq.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.dm(null, this.eYq.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eYq.getResources().getString(R.string.refresh), this.dDD)));
        }
        this.mNoDataView.onChangeSkinType(this.eYq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
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
            g.dismissPopupWindow(this.dDF, this.eYq.getPageContext().getPageActivity());
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
        this.eYq.getWindow().setFlags(1024, 1024);
    }

    public void aPo() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDA.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dDA.setLayoutParams(layoutParams);
        this.dDw.setBackgroundDrawable(null);
        this.dDy.setBackgroundDrawable(null);
        this.afe.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.eYq.getWindow().clearFlags(1024);
    }

    public void gP(boolean z) {
        this.dDJ = z;
    }
}
