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
import com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private TextView abA;
    private View.OnClickListener abB;
    private View abC;
    private MorePopupWindow abD;
    protected View abE;
    private View abF;
    private View abG;
    private int abH;
    private int abI;
    private TextView abu;
    private View abv;
    private ImageView abw;
    private ImageView abx;
    private LinearLayout abz;
    private AdBaseWebViewActivity bmR;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View abt = null;
    private ProgressBar mProgressBar = null;
    private boolean abJ = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.bmR = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bmR.setContentView(d.i.base_webview_activity);
        this.abt = this.bmR.findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) this.bmR.findViewById(d.g.view_navigation_bar);
        cY("");
        this.abz = (LinearLayout) this.bmR.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abz.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abz.setLayoutParams(layoutParams);
        this.abA = (TextView) this.bmR.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.bmR.findViewById(d.g.webview_progress);
        this.abv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bmR != null) {
                    d.this.bmR.finish();
                }
            }
        });
        this.abw = (ImageView) this.abv.findViewById(d.g.widget_navi_back_button);
        this.abw.setContentDescription(this.bmR.getResources().getString(d.k.close));
        this.abC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.sM();
            }
        });
        this.abx = (ImageView) this.abC.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.bmR.getPageContext().getPageActivity()).inflate(d.i.tb_webview_pop_more, (ViewGroup) null);
        this.abD = new MorePopupWindow(this.bmR.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bmR.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sQ() {
                d.this.sM();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sR() {
            }
        });
        this.abE = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.abE.setOnClickListener(this.bmR);
        if (com.baidu.tbadk.coreExtra.c.e.aX(this.bmR.getPageContext().getPageActivity())) {
            this.abE.setVisibility(0);
        } else {
            this.abE.setVisibility(8);
        }
        this.abD.refresh();
        this.abG = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.abG.setOnClickListener(this.bmR);
        this.abF = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.abF.setOnClickListener(this.bmR);
        sF();
    }

    private void sF() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int e = l.e(this.bmR.getPageContext().getPageActivity(), d.e.ds98);
        int i = l.p(this.bmR.getPageContext().getPageActivity()).heightPixels;
        this.abH = (i - statusBarHeight) - e;
        this.abI = i - statusBarHeight;
    }

    public boolean sH() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean sJ() {
        try {
            this.abz.addView(this.bmR.createWebView());
            this.abA.setVisibility(8);
            if (!this.abJ) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.abA.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.abz.getLayoutParams().height = this.abH;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.abz.getLayoutParams().height = this.abI;
        this.mNavigationBar.setVisibility(8);
    }

    public void aj(boolean z) {
        if (this.abE != null) {
            if (z) {
                this.abE.setVisibility(0);
            } else {
                this.abE.setVisibility(8);
            }
            this.abD.refresh();
        }
    }

    public void ak(boolean z) {
        if (this.abC != null) {
            if (z) {
                this.abC.setVisibility(0);
            } else {
                this.abC.setVisibility(8);
            }
        }
    }

    public void sM() {
        this.abD.showWindowInRightBottomOfHost();
    }

    public void sN() {
        com.baidu.adp.lib.g.g.a(this.abD, this.bmR.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.abA.setVisibility(8);
    }

    public void cY(String str) {
        this.abu = this.mNavigationBar.setTitleText(str);
        am.b(this.abu, d.C0142d.cp_cont_b, d.C0142d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bmR.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.ah("obj_url", dVar.linkUrl);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bmR.getPageContext().getPageActivity(), dVar, true, sO())));
        }
    }

    private SparseArray<String> sO() {
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
            this.mNavigationBar.onChangeSkinType(this.bmR.getPageContext(), i);
        }
        if (this.abD != null) {
            this.abD.onChangeSkinType(this.bmR, i, am.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bmR.getPageContext(), i);
        }
        am.a(this.abw, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        am.a(this.abx, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.abz.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bmR.getPageContext().getPageActivity(), this.abt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aj(null, this.bmR.getPageContext().getString(d.k.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bmR.getResources().getString(d.k.refresh), this.abB)));
        }
        this.mNoDataView.onChangeSkinType(this.bmR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.abz.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.abB = onClickListener;
    }

    public void release() {
        if (this.abz != null) {
            this.abz.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.abD != null) {
            com.baidu.adp.lib.g.g.a(this.abD, this.bmR.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abz.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.abz.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.i(this.abw, d.f.frs_star_navigation_bg);
        am.i(this.abx, d.f.frs_star_navigation_bg);
        cY("");
        this.bmR.getWindow().setFlags(1024, 1024);
    }

    public void sP() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abz.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abz.setLayoutParams(layoutParams);
        this.abw.setBackgroundDrawable(null);
        this.abx.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bmR.getWindow().clearFlags(1024);
    }

    public void am(boolean z) {
        this.abJ = z;
    }
}
