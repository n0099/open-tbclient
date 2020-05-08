package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.graphics.drawable.Drawable;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private BdTypeListView eOj;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a eOl;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b eOm;
    private PbListView ePr;
    private i eYc;
    private LinearLayout eYd;
    private View eYe;
    private LinearLayout eYf;
    private com.baidu.tbadk.k.g eYg;
    private a eYh;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.h mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int afW = -1;
    private BdUniqueId afD = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.eYf = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.eYd = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.eYe = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.eYh = new a(this.eYe);
        this.eYh.pl(8);
        this.eOj = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.afD);
        this.eOj.setPullRefresh(this.mPullView);
        this.ePr = new PbListView(this.mPageContext.getPageActivity());
        this.ePr.createView();
        this.eOl = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.eOl.setFrom(2);
        this.eOm = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.eOm.setFrom(2);
        this.aMj.add(this.eOl);
        this.aMj.add(this.eOm);
        this.eOj.addAdapters(this.aMj);
    }

    public void pj(int i) {
        this.eYd.setVisibility(i);
    }

    public void bmu() {
        if (this.ePr != null && this.ePr.getView().getParent() != null) {
            this.eOj.removeFooterView(this.ePr.getView());
        }
    }

    public void bln() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.eOj.setNextPage(this.ePr);
            }
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.ePr.endLoadData();
        }
    }

    public void pk(int i) {
        if (this.eYh != null) {
            this.eYh.pm(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afW != i) {
            this.afW = i;
        }
        if (this.eYh != null) {
            this.eYh.aVb();
        }
        if (this.eYg != null) {
            this.eYg.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.ePr != null) {
            this.ePr.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void completePullRefresh() {
        this.eOj.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.eOj != null) {
            this.eOj.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.eOj;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.eYg == null) {
                this.eYg = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.eYg != null) {
                this.eYg.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this.mRootView);
            this.eYg = null;
        }
    }

    public void a(String str, View.OnClickListener onClickListener, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.refreshView.setLayoutMargin(this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
        this.refreshView.setSubText(str);
        this.refreshView.attachView(this.mRootView, false);
        if (z) {
            this.refreshView.showRefreshButton();
        } else {
            this.refreshView.hideRefreshButton();
        }
    }

    public void blr() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.eOj.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.eYc = iVar;
        if (this.eOl != null) {
            this.eOl.b(this.eYc);
        }
        if (this.eOm != null) {
            this.eOm.b(this.eYc);
        }
    }

    public void onDestroy() {
        if (this.eYg != null) {
            if (this.eYg.getAttachedView() != null) {
                this.eYg.dettachView(this.mRootView);
            }
            this.eYg.release();
            this.eYg = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((g.d) null);
            this.mPullView.a((g.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.eOj != null) {
            this.eOj.setOnSrollToBottomListener(null);
            this.eOj.setOnScrollListener(null);
            this.eOj.setRecyclerListener(null);
            this.eOj = null;
        }
    }

    public void a(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        if (z) {
            this.mNavigationBar = new NavigationBar(this.mPageContext.getPageActivity());
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.mPageContext.getPageActivity().finish();
                }
            });
            if (!StringUtils.isNull(str2)) {
                this.mNavigationBar.setCenterTextTitle(str2);
            } else if (!StringUtils.isNull(str)) {
                this.mNavigationBar.setCenterTextTitle(str);
            }
            this.mRootView.addView(this.mNavigationBar, 0, new LinearLayout.LayoutParams(-1, -2));
            am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (!v.isEmpty(list)) {
            this.eYh.by(list);
        }
        this.eOl.jh(z3);
        this.eOm.jh(z3);
    }

    public void bx(List<String> list) {
        if (!v.isEmpty(list)) {
            this.eYh.by(list);
        }
    }

    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        private PopupWindow eYj;
        private View eYk;
        private TextView eYl;
        private TextView eYm;
        private LinearLayout eYn;
        private List<String> eYo;
        private String eYq;
        private boolean eYp = false;
        private a.InterfaceC0018a eYr = new a.InterfaceC0018a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.eYq;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.eXz = true;
                        d.this.eYc.a(cVar);
                        a.this.eYm.setText(a.this.eYq);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.eYk = view;
            this.eYl = (TextView) this.eYk.findViewById(R.id.live_num);
            this.eYm = (TextView) this.eYk.findViewById(R.id.live_sort);
            this.eYm.setVisibility(8);
            this.eYm.setOnClickListener(this);
            aVb();
        }

        public void pl(int i) {
            this.eYk.setVisibility(i);
        }

        public void pm(int i) {
            if (this.eYl != null) {
                this.eYl.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.eYk.setVisibility(0);
            }
        }

        private boolean bmv() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void by(List<String> list) {
            this.eYo = list;
            if (!v.isEmpty(this.eYo) && !this.eYp) {
                this.eYp = true;
                String str = this.eYo.get(0);
                if (!StringUtils.isNull(str)) {
                    this.eYm.setText(str);
                    this.eYm.setVisibility(0);
                }
                this.eYn = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.eYn.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.eYn, R.drawable.bg_ala_sub_list_sort_panel);
                this.eYn.setClipChildren(true);
                this.eYn.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.eYo.size(); i++) {
                    this.eYn.addView(makeTextView(this.eYo.get(i)), layoutParams);
                    if (i != this.eYo.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.eYn.addView(view);
                    }
                }
                if (this.eYj == null) {
                    this.eYj = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.eYj.setContentView(this.eYn);
                    this.eYj.setWidth(-2);
                    this.eYj.setHeight(-2);
                    this.eYj.setAnimationStyle(16973826);
                    this.eYj.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.eYj.setOutsideTouchable(true);
                    this.eYj.setFocusable(true);
                    this.eYj.setTouchable(true);
                }
            }
        }

        private TextView makeTextView(String str) {
            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
            textView.setTextSize(0, d.this.mPageContext.getResources().getDimension(R.dimen.ds28));
            textView.setText(str);
            textView.setTag(str);
            textView.setGravity(17);
            am.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
            am.setViewTextColor(textView, (int) R.color.cp_cont_d);
            textView.setOnClickListener(this);
            return textView;
        }

        private void bmw() {
            if (this.eYj != null) {
                int[] iArr = new int[2];
                this.eYm.getLocationOnScreen(iArr);
                int height = ((View) this.eYm.getParent()).getHeight() - this.eYm.getHeight();
                if (iArr[1] - this.eYj.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eYj, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eYj, d.this.mRootView, 0, (iArr[0] - (this.eYm.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eYm.getHeight());
                if (this.eYj != null) {
                    this.eYj.update();
                }
            }
        }

        public void aVb() {
            am.setViewTextColor(this.eYl, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eYm, (int) R.color.cp_cont_d);
            this.eYm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.eYm) {
                bmw();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.eYj != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eYj, d.this.mPageContext.getPageActivity());
                }
                if (d.this.eYc != null) {
                    this.eYq = (String) view.getTag();
                    if (this.eYq.contains("距离")) {
                        if (!bmv()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.ko().a(false, this.eYr);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.eYq;
                    cVar.eXz = false;
                    d.this.eYc.a(cVar);
                    this.eYm.setText(this.eYq);
                }
            }
        }
    }
}
