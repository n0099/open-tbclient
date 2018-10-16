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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private ImageView aiA;
    private ImageView aiB;
    private LinearLayout aiD;
    private TextView aiE;
    private View.OnClickListener aiF;
    private View aiG;
    private MorePopupWindow aiH;
    protected View aiI;
    private View aiJ;
    private View aiK;
    private int aiL;
    private int aiM;
    private TextView aiy;
    private View aiz;
    private AdBaseWebViewActivity bxv;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View aix = null;
    private ProgressBar mProgressBar = null;
    private boolean aiN = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.bxv = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bxv.setContentView(e.h.base_webview_activity);
        this.aix = this.bxv.findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) this.bxv.findViewById(e.g.view_navigation_bar);
        dE("");
        this.aiD = (LinearLayout) this.bxv.findViewById(e.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiD.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.aiD.setLayoutParams(layoutParams);
        this.aiE = (TextView) this.bxv.findViewById(e.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.bxv.findViewById(e.g.webview_progress);
        this.aiz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bxv != null) {
                    d.this.bxv.finish();
                }
            }
        });
        this.aiA = (ImageView) this.aiz.findViewById(e.g.widget_navi_back_button);
        this.aiA.setContentDescription(this.bxv.getResources().getString(e.j.close));
        this.aiG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.vN();
            }
        });
        this.aiB = (ImageView) this.aiG.findViewById(e.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.bxv.getPageContext().getPageActivity()).inflate(e.h.tb_webview_pop_more, (ViewGroup) null);
        this.aiH = new MorePopupWindow(this.bxv.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bxv.getPageContext().getResources().getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void vR() {
                d.this.vN();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void vS() {
            }
        });
        this.aiI = inflate.findViewById(e.g.webview_more_pop_item_share_friend_layout);
        this.aiI.setOnClickListener(this.bxv);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.bxv.getPageContext().getPageActivity())) {
            this.aiI.setVisibility(0);
        } else {
            this.aiI.setVisibility(8);
        }
        this.aiH.refresh();
        this.aiK = inflate.findViewById(e.g.webview_more_pop_item_open_browser_layout);
        this.aiK.setOnClickListener(this.bxv);
        this.aiJ = inflate.findViewById(e.g.webview_more_pop_item_copy_link_layout);
        this.aiJ.setOnClickListener(this.bxv);
        vG();
    }

    private void vG() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.bxv.getPageContext().getPageActivity(), e.C0175e.ds98);
        int i = l.s(this.bxv.getPageContext().getPageActivity()).heightPixels;
        this.aiL = (i - statusBarHeight) - h;
        this.aiM = i - statusBarHeight;
    }

    public boolean vI() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean vK() {
        try {
            this.aiD.addView(this.bxv.createWebView());
            this.aiE.setVisibility(8);
            if (!this.aiN) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.aiE.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.aiD.getLayoutParams().height = this.aiL;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.aiD.getLayoutParams().height = this.aiM;
        this.mNavigationBar.setVisibility(8);
    }

    public void aA(boolean z) {
        if (this.aiI != null) {
            if (z) {
                this.aiI.setVisibility(0);
            } else {
                this.aiI.setVisibility(8);
            }
            this.aiH.refresh();
        }
    }

    public void aB(boolean z) {
        if (this.aiG != null) {
            if (z) {
                this.aiG.setVisibility(0);
            } else {
                this.aiG.setVisibility(8);
            }
        }
    }

    public void vN() {
        this.aiH.showWindowInRightBottomOfHost();
    }

    public void vO() {
        com.baidu.adp.lib.g.g.a(this.aiH, this.bxv.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.aiE.setVisibility(8);
    }

    public void dE(String str) {
        this.aiy = this.mNavigationBar.setTitleText(str);
        al.b(this.aiy, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bxv.getPageContext().getPageActivity(), "share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.ax("obj_url", dVar.linkUrl);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bxv.getPageContext().getPageActivity(), dVar, true, vP())));
        }
    }

    private SparseArray<String> vP() {
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
            this.mNavigationBar.onChangeSkinType(this.bxv.getPageContext(), i);
        }
        if (this.aiH != null) {
            this.aiH.onChangeSkinType(this.bxv, i, al.getDrawable(e.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bxv.getPageContext(), i);
        }
        al.a(this.aiA, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        al.a(this.aiB, e.f.icon_more_bg_s, e.f.icon_more_bg_s, e.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aiD.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bxv.getPageContext().getPageActivity(), this.aix, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aA(null, this.bxv.getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bxv.getResources().getString(e.j.refresh), this.aiF)));
        }
        this.mNoDataView.onChangeSkinType(this.bxv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aiD.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aiF = onClickListener;
    }

    public void release() {
        if (this.aiD != null) {
            this.aiD.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aiH != null) {
            com.baidu.adp.lib.g.g.a(this.aiH, this.bxv.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiD.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.aiD.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.aiA, e.f.frs_star_navigation_bg);
        al.i(this.aiB, e.f.frs_star_navigation_bg);
        dE("");
        this.bxv.getWindow().setFlags(1024, 1024);
    }

    public void vQ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiD.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.aiD.setLayoutParams(layoutParams);
        this.aiA.setBackgroundDrawable(null);
        this.aiB.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bxv.getWindow().clearFlags(1024);
    }

    public void aD(boolean z) {
        this.aiN = z;
    }
}
