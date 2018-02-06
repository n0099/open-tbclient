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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private TextView aIe;
    private View aIf;
    private ImageView aIg;
    private ImageView aIh;
    private LinearLayout aIj;
    private TextView aIk;
    private View.OnClickListener aIl;
    private View aIm;
    private MorePopupWindow aIn;
    protected View aIo;
    private View aIp;
    private View aIq;
    private int aIr;
    private int aIs;
    private AdBaseWebViewActivity bTm;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    protected View aId = null;
    private ProgressBar mProgressBar = null;
    private boolean aIt = true;

    public d(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.bTm = adBaseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bTm.setContentView(d.h.base_webview_activity);
        this.aId = this.bTm.findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) this.bTm.findViewById(d.g.view_navigation_bar);
        cF("");
        this.aIj = (LinearLayout) this.bTm.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aIj.setLayoutParams(layoutParams);
        this.aIk = (TextView) this.bTm.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.bTm.findViewById(d.g.webview_progress);
        this.aIf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bTm != null) {
                    d.this.bTm.finish();
                }
            }
        });
        this.aIg = (ImageView) this.aIf.findViewById(d.g.widget_navi_back_button);
        this.aIg.setContentDescription(this.bTm.getResources().getString(d.j.close));
        this.aIm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.wG();
            }
        });
        this.aIh = (ImageView) this.aIm.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.bTm.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.aIn = new MorePopupWindow(this.bTm.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bTm.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tieba.ad.browser.d.3
            @Override // com.baidu.tbadk.core.view.f.a
            public void wK() {
                d.this.wG();
            }

            @Override // com.baidu.tbadk.core.view.f.a
            public void wL() {
            }
        });
        this.aIo = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.aIo.setOnClickListener(this.bTm);
        if (com.baidu.tbadk.coreExtra.c.e.bc(this.bTm.getPageContext().getPageActivity())) {
            this.aIo.setVisibility(0);
        } else {
            this.aIo.setVisibility(8);
        }
        this.aIn.refresh();
        this.aIq = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.aIq.setOnClickListener(this.bTm);
        this.aIp = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.aIp.setOnClickListener(this.bTm);
        wB();
    }

    private void wB() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int t = l.t(this.bTm.getPageContext().getPageActivity(), d.e.ds98);
        int i = l.q(this.bTm.getPageContext().getPageActivity()).heightPixels;
        this.aIr = (i - statusBarHeight) - t;
        this.aIs = i - statusBarHeight;
    }

    public boolean wD() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public boolean wF() {
        try {
            this.aIj.addView(this.bTm.createWebView());
            this.aIk.setVisibility(8);
            if (!this.aIt) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.aIk.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.aIj.getLayoutParams().height = this.aIr;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.aIj.getLayoutParams().height = this.aIs;
        this.mNavigationBar.setVisibility(8);
    }

    public void aN(boolean z) {
        if (this.aIo != null) {
            if (z) {
                this.aIo.setVisibility(0);
            } else {
                this.aIo.setVisibility(8);
            }
            this.aIn.refresh();
        }
    }

    public void aO(boolean z) {
        if (this.aIm != null) {
            if (z) {
                this.aIm.setVisibility(0);
            } else {
                this.aIm.setVisibility(8);
            }
        }
    }

    public void wG() {
        this.aIn.showWindowInRightBottomOfHost();
    }

    public void wH() {
        com.baidu.adp.lib.g.g.a(this.aIn, this.bTm.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void hideCrashTip() {
        this.aIk.setVisibility(8);
    }

    public void cF(String str) {
        this.aIe = this.mNavigationBar.setTitleText(str);
        aj.d(this.aIe, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bTm.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ab("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bTm.getPageContext().getPageActivity(), dVar, true, wI())));
        }
    }

    private SparseArray<String> wI() {
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
            this.mNavigationBar.onChangeSkinType(this.bTm.getPageContext(), i);
        }
        if (this.aIn != null) {
            this.aIn.onChangeSkinType(this.bTm, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bTm.getPageContext(), i);
        }
        aj.a(this.aIg, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        aj.a(this.aIh, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aIj.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bTm.getPageContext().getPageActivity(), this.aId, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ae(null, this.bTm.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bTm.getResources().getString(d.j.refresh), this.aIl)));
        }
        this.mNoDataView.onChangeSkinType(this.bTm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aIj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIl = onClickListener;
    }

    public void release() {
        if (this.aIj != null) {
            this.aIj.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aIn != null) {
            com.baidu.adp.lib.g.g.a(this.aIn, this.bTm.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIj.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.aIj.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.s(this.aIg, d.f.frs_star_navigation_bg);
        aj.s(this.aIh, d.f.frs_star_navigation_bg);
        cF("");
        this.bTm.getWindow().setFlags(1024, 1024);
    }

    public void wJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aIj.setLayoutParams(layoutParams);
        this.aIg.setBackgroundDrawable(null);
        this.aIh.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bTm.getWindow().clearFlags(1024);
    }

    public void aP(boolean z) {
        this.aIt = z;
    }
}
