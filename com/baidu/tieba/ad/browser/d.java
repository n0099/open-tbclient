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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private TextView btZ;
    private View bua;
    private ImageView bub;
    private ImageView buc;
    private LinearLayout bue;
    private TextView bug;
    private View.OnClickListener bui;
    private View buj;
    private MorePopupWindow buk;
    protected View bul;
    private View bum;
    private View bun;
    private int buo;
    private int bup;
    private AdBaseWebViewActivity cNy;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View btY = null;
    private ProgressBar mProgressBar = null;
    private boolean buq = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.cNy = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cNy.setContentView(d.h.base_webview_activity);
        this.btY = this.cNy.findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) this.cNy.findViewById(d.g.view_navigation_bar);
        kP("");
        this.bue = (LinearLayout) this.cNy.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bue.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.bue.setLayoutParams(layoutParams);
        this.bug = (TextView) this.cNy.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.cNy.findViewById(d.g.webview_progress);
        this.bua = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cNy != null) {
                    d.this.cNy.finish();
                }
            }
        });
        this.bub = (ImageView) this.bua.findViewById(d.g.widget_navi_back_button);
        this.bub.setContentDescription(this.cNy.getResources().getString(d.j.close));
        this.buj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Qj();
            }
        });
        this.buc = (ImageView) this.buj.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.cNy.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.buk = new MorePopupWindow(this.cNy.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cNy.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VX() {
                d.this.Qj();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VY() {
            }
        });
        this.bul = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.bul.setOnClickListener(this.cNy);
        if (com.baidu.tbadk.coreExtra.c.e.dc(this.cNy.getPageContext().getPageActivity())) {
            this.bul.setVisibility(0);
        } else {
            this.bul.setVisibility(8);
        }
        this.buk.refresh();
        this.bun = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.bun.setOnClickListener(this.cNy);
        this.bum = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.bum.setOnClickListener(this.cNy);
        VO();
    }

    private void VO() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.cNy.getPageContext().getPageActivity(), d.e.ds98);
        int i = l.s(this.cNy.getPageContext().getPageActivity()).heightPixels;
        this.buo = (i - statusBarHeight) - h;
        this.bup = i - statusBarHeight;
    }

    public boolean VQ() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean VS() {
        try {
            this.bue.addView(this.cNy.createWebView());
            this.bug.setVisibility(8);
            if (!this.buq) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bug.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bue.getLayoutParams().height = this.buo;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.bue.getLayoutParams().height = this.bup;
        this.mNavigationBar.setVisibility(8);
    }

    public void db(boolean z) {
        if (this.bul != null) {
            if (z) {
                this.bul.setVisibility(0);
            } else {
                this.bul.setVisibility(8);
            }
            this.buk.refresh();
        }
    }

    public void dc(boolean z) {
        if (this.buj != null) {
            if (z) {
                this.buj.setVisibility(0);
            } else {
                this.buj.setVisibility(8);
            }
        }
    }

    public void Qj() {
        this.buk.showWindowInRightBottomOfHost();
    }

    public void Qk() {
        com.baidu.adp.lib.g.g.a(this.buk, this.cNy.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.bug.setVisibility(8);
    }

    public void kP(String str) {
        this.btZ = this.mNavigationBar.setTitleText(str);
        al.c(this.btZ, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.cNy.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bJ("obj_url", dVar.linkUrl);
            amVar.T("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.cNy.getPageContext().getPageActivity(), dVar, true, VV())));
        }
    }

    private SparseArray<String> VV() {
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
            this.mNavigationBar.onChangeSkinType(this.cNy.getPageContext(), i);
        }
        if (this.buk != null) {
            this.buk.onChangeSkinType(this.cNy, i, al.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cNy.getPageContext(), i);
        }
        al.a(this.bub, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        al.a(this.buc, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bue.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cNy.getPageContext().getPageActivity(), this.btY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.bM(null, this.cNy.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cNy.getResources().getString(d.j.refresh), this.bui)));
        }
        this.mNoDataView.onChangeSkinType(this.cNy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bue.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bui = onClickListener;
    }

    public void release() {
        if (this.bue != null) {
            this.bue.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.buk != null) {
            com.baidu.adp.lib.g.g.a(this.buk, this.cNy.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bue.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bue.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.bub, d.f.frs_star_navigation_bg);
        al.k(this.buc, d.f.frs_star_navigation_bg);
        kP("");
        this.cNy.getWindow().setFlags(1024, 1024);
    }

    public void VW() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bue.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.bue.setLayoutParams(layoutParams);
        this.bub.setBackgroundDrawable(null);
        this.buc.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.cNy.getWindow().clearFlags(1024);
    }

    public void de(boolean z) {
        this.buq = z;
    }
}
