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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
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
    private int TA;
    private TextView Tm;
    private View Tn;
    private ImageView To;
    private ImageView Tp;
    private LinearLayout Tr;
    private TextView Ts;
    private View.OnClickListener Tt;
    private View Tu;
    private MorePopupWindow Tv;
    protected View Tw;
    private View Tx;
    private View Ty;
    private int Tz;
    private AdBaseWebViewActivity bdh;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View Tl = null;
    private ProgressBar mProgressBar = null;
    private boolean TB = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.bdh = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bdh.setContentView(d.i.base_webview_activity);
        this.Tl = this.bdh.findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) this.bdh.findViewById(d.g.view_navigation_bar);
        cx("");
        this.Tr = (LinearLayout) this.bdh.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Tr.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Tr.setLayoutParams(layoutParams);
        this.Ts = (TextView) this.bdh.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.bdh.findViewById(d.g.webview_progress);
        this.Tn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.bdh != null) {
                    d.this.bdh.finish();
                }
            }
        });
        this.To = (ImageView) this.Tn.findViewById(d.g.widget_navi_back_button);
        this.To.setContentDescription(this.bdh.getResources().getString(d.k.close));
        this.Tu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.pq();
            }
        });
        this.Tp = (ImageView) this.Tu.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.bdh.getPageContext().getPageActivity()).inflate(d.i.tb_webview_pop_more, (ViewGroup) null);
        this.Tv = new MorePopupWindow(this.bdh.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bdh.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void pu() {
                d.this.pq();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void pv() {
            }
        });
        this.Tw = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.Tw.setOnClickListener(this.bdh);
        if (com.baidu.tbadk.coreExtra.c.e.aN(this.bdh.getPageContext().getPageActivity())) {
            this.Tw.setVisibility(0);
        } else {
            this.Tw.setVisibility(8);
        }
        this.Tv.refresh();
        this.Ty = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.Ty.setOnClickListener(this.bdh);
        this.Tx = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.Tx.setOnClickListener(this.bdh);
        pl();
    }

    private void pl() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int e = l.e(this.bdh.getPageContext().getPageActivity(), d.e.ds98);
        int i = l.q(this.bdh.getPageContext().getPageActivity()).heightPixels;
        this.Tz = (i - statusBarHeight) - e;
        this.TA = i - statusBarHeight;
    }

    public boolean pn() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean pp() {
        try {
            this.Tr.addView(this.bdh.createWebView());
            this.Ts.setVisibility(8);
            if (!this.TB) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Ts.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Tr.getLayoutParams().height = this.Tz;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Tr.getLayoutParams().height = this.TA;
        this.mNavigationBar.setVisibility(8);
    }

    public void ag(boolean z) {
        if (this.Tw != null) {
            if (z) {
                this.Tw.setVisibility(0);
            } else {
                this.Tw.setVisibility(8);
            }
            this.Tv.refresh();
        }
    }

    public void ah(boolean z) {
        if (this.Tu != null) {
            if (z) {
                this.Tu.setVisibility(0);
            } else {
                this.Tu.setVisibility(8);
            }
        }
    }

    public void pq() {
        this.Tv.showWindowInRightBottomOfHost();
    }

    public void pr() {
        com.baidu.adp.lib.g.g.a(this.Tv, this.bdh.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.Ts.setVisibility(8);
    }

    public void cx(String str) {
        this.Tm = this.mNavigationBar.setTitleText(str);
        ak.b(this.Tm, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bdh.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            al alVar = new al("c10898");
            alVar.ac("obj_url", dVar.linkUrl);
            TiebaStatic.log(alVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bdh.getPageContext().getPageActivity(), dVar, true, ps())));
        }
    }

    private SparseArray<String> ps() {
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
            this.mNavigationBar.onChangeSkinType(this.bdh.getPageContext(), i);
        }
        if (this.Tv != null) {
            this.Tv.onChangeSkinType(this.bdh, i, ak.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bdh.getPageContext(), i);
        }
        ak.a(this.To, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        ak.a(this.Tp, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Tr.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bdh.getPageContext().getPageActivity(), this.Tl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.bdh.getPageContext().getString(d.k.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bdh.getResources().getString(d.k.refresh), this.Tt)));
        }
        this.mNoDataView.onChangeSkinType(this.bdh.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Tr.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.Tt = onClickListener;
    }

    public void release() {
        if (this.Tr != null) {
            this.Tr.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Tv != null) {
            com.baidu.adp.lib.g.g.a(this.Tv, this.bdh.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Tr.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Tr.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ak.i(this.To, d.f.frs_star_navigation_bg);
        ak.i(this.Tp, d.f.frs_star_navigation_bg);
        cx("");
        this.bdh.getWindow().setFlags(1024, 1024);
    }

    public void pt() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Tr.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Tr.setLayoutParams(layoutParams);
        this.To.setBackgroundDrawable(null);
        this.Tp.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bdh.getWindow().clearFlags(1024);
    }

    public void ai(boolean z) {
        this.TB = z;
    }
}
