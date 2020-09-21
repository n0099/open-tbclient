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
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private final String LOCATION = "距离";
    private int aiX = -1;
    private BdUniqueId aih = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private BdTypeListView fGf;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fGh;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fGi;
    private PbListView fHm;
    private i fQb;
    private LinearLayout fQc;
    private View fQd;
    private LinearLayout fQe;
    private com.baidu.tbadk.k.g fQf;
    private a fQg;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.fQe = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.fQc = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.fQd = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.fQg = new a(this.fQd);
        this.fQg.tg(8);
        this.fGf = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aih);
        this.fGf.setPullRefresh(this.mPullView);
        this.fHm = new PbListView(this.mPageContext.getPageActivity());
        this.fHm.createView();
        this.fGh = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.fGh.setFrom(2);
        this.fGi = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.fGi.setFrom(2);
        this.bdV.add(this.fGh);
        this.bdV.add(this.fGi);
        this.fGf.addAdapters(this.bdV);
    }

    public void te(int i) {
        this.fQc.setVisibility(i);
    }

    public void bIq() {
        if (this.fHm != null && this.fHm.getView().getParent() != null) {
            this.fGf.removeFooterView(this.fHm.getView());
        }
    }

    public void bHi() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.fGf.setNextPage(this.fHm);
            }
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fHm.endLoadData();
        }
    }

    public void tf(int i) {
        if (this.fQg != null) {
            this.fQg.th(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aiX != i) {
            this.aiX = i;
        }
        if (this.fQg != null) {
            this.fQg.bqC();
        }
        if (this.fQf != null) {
            this.fQf.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.fHm != null) {
            this.fHm.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void completePullRefresh() {
        this.fGf.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !y.isEmpty(list) && this.fGf != null) {
            this.fGf.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fGf;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.fQf == null) {
                this.fQf = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.fQf != null) {
                this.fQf.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this.mRootView);
            this.fQf = null;
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

    public void bHn() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.fGf.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.fQb = iVar;
        if (this.fGh != null) {
            this.fGh.b(this.fQb);
        }
        if (this.fGi != null) {
            this.fGi.b(this.fQb);
        }
    }

    public void onDestroy() {
        if (this.fQf != null) {
            if (this.fQf.getAttachedView() != null) {
                this.fQf.dettachView(this.mRootView);
            }
            this.fQf.release();
            this.fQf = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.fGf != null) {
            this.fGf.setOnSrollToBottomListener(null);
            this.fGf.setOnScrollListener(null);
            this.fGf.setRecyclerListener(null);
            this.fGf = null;
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
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (!y.isEmpty(list)) {
            this.fQg.bM(list);
        }
        this.fGh.kT(z3);
        this.fGi.kT(z3);
    }

    public void bL(List<String> list) {
        if (!y.isEmpty(list)) {
            this.fQg.bM(list);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements View.OnClickListener {
        private PopupWindow fQi;
        private View fQj;
        private TextView fQk;
        private TextView fQl;
        private LinearLayout fQm;
        private List<String> fQn;
        private String fQp;
        private boolean fQo = false;
        private a.InterfaceC0019a fQq = new a.InterfaceC0019a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0019a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.fQp;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.fPy = true;
                        d.this.fQb.a(cVar);
                        a.this.fQl.setText(a.this.fQp);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.fQj = view;
            this.fQk = (TextView) this.fQj.findViewById(R.id.live_num);
            this.fQl = (TextView) this.fQj.findViewById(R.id.live_sort);
            this.fQl.setVisibility(8);
            this.fQl.setOnClickListener(this);
            bqC();
        }

        public void tg(int i) {
            this.fQj.setVisibility(i);
        }

        public void th(int i) {
            if (this.fQk != null) {
                this.fQk.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, at.numberUniformFormatExtra(i)));
                this.fQj.setVisibility(0);
            }
        }

        private boolean bIr() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bM(List<String> list) {
            this.fQn = list;
            if (!y.isEmpty(this.fQn) && !this.fQo) {
                this.fQo = true;
                String str = this.fQn.get(0);
                if (!StringUtils.isNull(str)) {
                    this.fQl.setText(str);
                    this.fQl.setVisibility(0);
                }
                this.fQm = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.fQm.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.fQm, R.drawable.bg_ala_sub_list_sort_panel);
                this.fQm.setClipChildren(true);
                this.fQm.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.fQn.size(); i++) {
                    this.fQm.addView(makeTextView(this.fQn.get(i)), layoutParams);
                    if (i != this.fQn.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.fQm.addView(view);
                    }
                }
                if (this.fQi == null) {
                    this.fQi = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.fQi.setContentView(this.fQm);
                    this.fQi.setWidth(-2);
                    this.fQi.setHeight(-2);
                    this.fQi.setAnimationStyle(16973826);
                    this.fQi.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.fQi.setOutsideTouchable(true);
                    this.fQi.setFocusable(true);
                    this.fQi.setTouchable(true);
                }
            }
        }

        private TextView makeTextView(String str) {
            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
            textView.setTextSize(0, d.this.mPageContext.getResources().getDimension(R.dimen.ds28));
            textView.setText(str);
            textView.setTag(str);
            textView.setGravity(17);
            ap.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
            ap.setViewTextColor(textView, R.color.cp_cont_d);
            textView.setOnClickListener(this);
            return textView;
        }

        private void bIs() {
            if (this.fQi != null) {
                int[] iArr = new int[2];
                this.fQl.getLocationOnScreen(iArr);
                int height = ((View) this.fQl.getParent()).getHeight() - this.fQl.getHeight();
                if (iArr[1] - this.fQi.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fQi, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fQi, d.this.mRootView, 0, (iArr[0] - (this.fQl.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fQl.getHeight());
                if (this.fQi != null) {
                    this.fQi.update();
                }
            }
        }

        public void bqC() {
            ap.setViewTextColor(this.fQk, R.color.cp_cont_d);
            ap.setViewTextColor(this.fQl, R.color.cp_cont_d);
            this.fQl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.fQl) {
                bIs();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.fQi != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fQi, d.this.mPageContext.getPageActivity());
                }
                if (d.this.fQb != null) {
                    this.fQp = (String) view.getTag();
                    if (this.fQp.contains("距离")) {
                        if (!bIr()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.mj().a(false, this.fQq);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.fQp;
                    cVar.fPy = false;
                    d.this.fQb.a(cVar);
                    this.fQl.setText(this.fQp);
                }
            }
        }
    }
}
