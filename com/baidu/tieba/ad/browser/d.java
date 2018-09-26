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
    private TextView adB;
    private View adC;
    private ImageView adD;
    private ImageView adE;
    private LinearLayout adG;
    private TextView adH;
    private View.OnClickListener adI;
    private View adJ;
    private MorePopupWindow adK;
    protected View adL;
    private View adM;
    private View adN;
    private int adO;
    private int adP;
    private AdBaseWebViewActivity btp;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View adA = null;
    private ProgressBar mProgressBar = null;
    private boolean adQ = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.btp = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.btp.setContentView(e.h.base_webview_activity);
        this.adA = this.btp.findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) this.btp.findViewById(e.g.view_navigation_bar);
        m17do("");
        this.adG = (LinearLayout) this.btp.findViewById(e.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adG.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.adG.setLayoutParams(layoutParams);
        this.adH = (TextView) this.btp.findViewById(e.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.btp.findViewById(e.g.webview_progress);
        this.adC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.btp != null) {
                    d.this.btp.finish();
                }
            }
        });
        this.adD = (ImageView) this.adC.findViewById(e.g.widget_navi_back_button);
        this.adD.setContentDescription(this.btp.getResources().getString(e.j.close));
        this.adJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.tE();
            }
        });
        this.adE = (ImageView) this.adJ.findViewById(e.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.btp.getPageContext().getPageActivity()).inflate(e.h.tb_webview_pop_more, (ViewGroup) null);
        this.adK = new MorePopupWindow(this.btp.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.btp.getPageContext().getResources().getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void tI() {
                d.this.tE();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void tJ() {
            }
        });
        this.adL = inflate.findViewById(e.g.webview_more_pop_item_share_friend_layout);
        this.adL.setOnClickListener(this.btp);
        if (com.baidu.tbadk.coreExtra.c.e.bD(this.btp.getPageContext().getPageActivity())) {
            this.adL.setVisibility(0);
        } else {
            this.adL.setVisibility(8);
        }
        this.adK.refresh();
        this.adN = inflate.findViewById(e.g.webview_more_pop_item_open_browser_layout);
        this.adN.setOnClickListener(this.btp);
        this.adM = inflate.findViewById(e.g.webview_more_pop_item_copy_link_layout);
        this.adM.setOnClickListener(this.btp);
        tx();
    }

    private void tx() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.btp.getPageContext().getPageActivity(), e.C0141e.ds98);
        int i = l.s(this.btp.getPageContext().getPageActivity()).heightPixels;
        this.adO = (i - statusBarHeight) - h;
        this.adP = i - statusBarHeight;
    }

    public boolean tz() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean tB() {
        try {
            this.adG.addView(this.btp.createWebView());
            this.adH.setVisibility(8);
            if (!this.adQ) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.adH.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.adG.getLayoutParams().height = this.adO;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.adG.getLayoutParams().height = this.adP;
        this.mNavigationBar.setVisibility(8);
    }

    public void ap(boolean z) {
        if (this.adL != null) {
            if (z) {
                this.adL.setVisibility(0);
            } else {
                this.adL.setVisibility(8);
            }
            this.adK.refresh();
        }
    }

    public void aq(boolean z) {
        if (this.adJ != null) {
            if (z) {
                this.adJ.setVisibility(0);
            } else {
                this.adJ.setVisibility(8);
            }
        }
    }

    public void tE() {
        this.adK.showWindowInRightBottomOfHost();
    }

    public void tF() {
        com.baidu.adp.lib.g.g.a(this.adK, this.btp.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.adH.setVisibility(8);
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(String str) {
        this.adB = this.mNavigationBar.setTitleText(str);
        al.b(this.adB, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.btp.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.al("obj_url", dVar.linkUrl);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.btp.getPageContext().getPageActivity(), dVar, true, tG())));
        }
    }

    private SparseArray<String> tG() {
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
            this.mNavigationBar.onChangeSkinType(this.btp.getPageContext(), i);
        }
        if (this.adK != null) {
            this.adK.onChangeSkinType(this.btp, i, al.getDrawable(e.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.btp.getPageContext(), i);
        }
        al.a(this.adD, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        al.a(this.adE, e.f.icon_more_bg_s, e.f.icon_more_bg_s, e.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.adG.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.btp.getPageContext().getPageActivity(), this.adA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ao(null, this.btp.getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.btp.getResources().getString(e.j.refresh), this.adI)));
        }
        this.mNoDataView.onChangeSkinType(this.btp.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.adG.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.adI = onClickListener;
    }

    public void release() {
        if (this.adG != null) {
            this.adG.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.adK != null) {
            com.baidu.adp.lib.g.g.a(this.adK, this.btp.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adG.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.adG.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.adD, e.f.frs_star_navigation_bg);
        al.i(this.adE, e.f.frs_star_navigation_bg);
        m17do("");
        this.btp.getWindow().setFlags(1024, 1024);
    }

    public void tH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adG.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.adG.setLayoutParams(layoutParams);
        this.adD.setBackgroundDrawable(null);
        this.adE.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.btp.getWindow().clearFlags(1024);
    }

    public void as(boolean z) {
        this.adQ = z;
    }
}
