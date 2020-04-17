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
    private BdTypeListView eOe;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a eOg;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b eOh;
    private PbListView ePm;
    private i eXX;
    private LinearLayout eXY;
    private View eXZ;
    private LinearLayout eYa;
    private com.baidu.tbadk.k.g eYb;
    private a eYc;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.h mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int afT = -1;
    private BdUniqueId afA = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.eYa = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.eXY = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.eXZ = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.eYc = new a(this.eXZ);
        this.eYc.pl(8);
        this.eOe = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.afA);
        this.eOe.setPullRefresh(this.mPullView);
        this.ePm = new PbListView(this.mPageContext.getPageActivity());
        this.ePm.createView();
        this.eOg = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.eOg.setFrom(2);
        this.eOh = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.eOh.setFrom(2);
        this.aMd.add(this.eOg);
        this.aMd.add(this.eOh);
        this.eOe.addAdapters(this.aMd);
    }

    public void pj(int i) {
        this.eXY.setVisibility(i);
    }

    public void bmw() {
        if (this.ePm != null && this.ePm.getView().getParent() != null) {
            this.eOe.removeFooterView(this.ePm.getView());
        }
    }

    public void blp() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.eOe.setNextPage(this.ePm);
            }
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.ePm.endLoadData();
        }
    }

    public void pk(int i) {
        if (this.eYc != null) {
            this.eYc.pm(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afT != i) {
            this.afT = i;
        }
        if (this.eYc != null) {
            this.eYc.aVd();
        }
        if (this.eYb != null) {
            this.eYb.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.ePm != null) {
            this.ePm.changeSkin(i);
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
        this.eOe.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.eOe != null) {
            this.eOe.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.eOe;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.eYb == null) {
                this.eYb = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.eYb != null) {
                this.eYb.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this.mRootView);
            this.eYb = null;
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

    public void blt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.eOe.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.eXX = iVar;
        if (this.eOg != null) {
            this.eOg.b(this.eXX);
        }
        if (this.eOh != null) {
            this.eOh.b(this.eXX);
        }
    }

    public void onDestroy() {
        if (this.eYb != null) {
            if (this.eYb.getAttachedView() != null) {
                this.eYb.dettachView(this.mRootView);
            }
            this.eYb.release();
            this.eYb = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((g.d) null);
            this.mPullView.a((g.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.eOe != null) {
            this.eOe.setOnSrollToBottomListener(null);
            this.eOe.setOnScrollListener(null);
            this.eOe.setRecyclerListener(null);
            this.eOe = null;
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
            this.eYc.by(list);
        }
        this.eOg.jh(z3);
        this.eOh.jh(z3);
    }

    public void bx(List<String> list) {
        if (!v.isEmpty(list)) {
            this.eYc.by(list);
        }
    }

    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        private PopupWindow eYe;
        private View eYf;
        private TextView eYg;
        private TextView eYh;
        private LinearLayout eYi;
        private List<String> eYj;
        private String eYl;
        private boolean eYk = false;
        private a.InterfaceC0018a eYm = new a.InterfaceC0018a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.eYl;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.eXu = true;
                        d.this.eXX.a(cVar);
                        a.this.eYh.setText(a.this.eYl);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.eYf = view;
            this.eYg = (TextView) this.eYf.findViewById(R.id.live_num);
            this.eYh = (TextView) this.eYf.findViewById(R.id.live_sort);
            this.eYh.setVisibility(8);
            this.eYh.setOnClickListener(this);
            aVd();
        }

        public void pl(int i) {
            this.eYf.setVisibility(i);
        }

        public void pm(int i) {
            if (this.eYg != null) {
                this.eYg.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.eYf.setVisibility(0);
            }
        }

        private boolean bmx() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void by(List<String> list) {
            this.eYj = list;
            if (!v.isEmpty(this.eYj) && !this.eYk) {
                this.eYk = true;
                String str = this.eYj.get(0);
                if (!StringUtils.isNull(str)) {
                    this.eYh.setText(str);
                    this.eYh.setVisibility(0);
                }
                this.eYi = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.eYi.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.eYi, R.drawable.bg_ala_sub_list_sort_panel);
                this.eYi.setClipChildren(true);
                this.eYi.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.eYj.size(); i++) {
                    this.eYi.addView(makeTextView(this.eYj.get(i)), layoutParams);
                    if (i != this.eYj.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.eYi.addView(view);
                    }
                }
                if (this.eYe == null) {
                    this.eYe = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.eYe.setContentView(this.eYi);
                    this.eYe.setWidth(-2);
                    this.eYe.setHeight(-2);
                    this.eYe.setAnimationStyle(16973826);
                    this.eYe.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.eYe.setOutsideTouchable(true);
                    this.eYe.setFocusable(true);
                    this.eYe.setTouchable(true);
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

        private void bmy() {
            if (this.eYe != null) {
                int[] iArr = new int[2];
                this.eYh.getLocationOnScreen(iArr);
                int height = ((View) this.eYh.getParent()).getHeight() - this.eYh.getHeight();
                if (iArr[1] - this.eYe.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eYe, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eYe, d.this.mRootView, 0, (iArr[0] - (this.eYh.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eYh.getHeight());
                if (this.eYe != null) {
                    this.eYe.update();
                }
            }
        }

        public void aVd() {
            am.setViewTextColor(this.eYg, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eYh, (int) R.color.cp_cont_d);
            this.eYh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.eYh) {
                bmy();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.eYe != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eYe, d.this.mPageContext.getPageActivity());
                }
                if (d.this.eXX != null) {
                    this.eYl = (String) view.getTag();
                    if (this.eYl.contains("距离")) {
                        if (!bmx()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.ko().a(false, this.eYm);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.eYl;
                    cVar.eXu = false;
                    d.this.eXX.a(cVar);
                    this.eYh.setText(this.eYl);
                }
            }
        }
    }
}
