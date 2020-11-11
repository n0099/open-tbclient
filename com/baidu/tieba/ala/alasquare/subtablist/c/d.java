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
    private BdTypeListView gih;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gij;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gik;
    private PbListView gjo;
    private i gsk;
    private LinearLayout gsl;
    private View gsm;
    private LinearLayout gsn;
    private com.baidu.tbadk.k.g gso;
    private a gsp;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int ajq = -1;
    private BdUniqueId aiz = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.gsn = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.gsl = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.gsm = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.gsp = new a(this.gsm);
        this.gsp.uh(8);
        this.gih = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aiz);
        this.gih.setPullRefresh(this.mPullView);
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.createView();
        this.gij = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.gij.setFrom(2);
        this.gik = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.gik.setFrom(2);
        this.bky.add(this.gij);
        this.bky.add(this.gik);
        this.gih.addAdapters(this.bky);
    }

    public void uf(int i) {
        this.gsl.setVisibility(i);
    }

    public void bQc() {
        if (this.gjo != null && this.gjo.getView().getParent() != null) {
            this.gih.removeFooterView(this.gjo.getView());
        }
    }

    public void bOW() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gih.setNextPage(this.gjo);
            }
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gjo.endLoadData();
        }
    }

    public void ug(int i) {
        if (this.gsp != null) {
            this.gsp.ui(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ajq != i) {
            this.ajq = i;
        }
        if (this.gsp != null) {
            this.gsp.bxE();
        }
        if (this.gso != null) {
            this.gso.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.gjo != null) {
            this.gjo.changeSkin(i);
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
        this.gih.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !y.isEmpty(list) && this.gih != null) {
            this.gih.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gih;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.gso == null) {
                this.gso = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.gso != null) {
                this.gso.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this.mRootView);
            this.gso = null;
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

    public void Wk() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.gih.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.gsk = iVar;
        if (this.gij != null) {
            this.gij.b(this.gsk);
        }
        if (this.gik != null) {
            this.gik.b(this.gsk);
        }
    }

    public void onDestroy() {
        if (this.gso != null) {
            if (this.gso.getAttachedView() != null) {
                this.gso.dettachView(this.mRootView);
            }
            this.gso.release();
            this.gso = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.gih != null) {
            this.gih.setOnSrollToBottomListener(null);
            this.gih.setOnScrollListener(null);
            this.gih.setRecyclerListener(null);
            this.gih = null;
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
            this.gsp.cg(list);
        }
        this.gij.lS(z3);
        this.gik.lS(z3);
    }

    public void cf(List<String> list) {
        if (!y.isEmpty(list)) {
            this.gsp.cg(list);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements View.OnClickListener {
        private PopupWindow gsr;
        private View gss;
        private TextView gst;
        private TextView gsu;
        private LinearLayout gsv;
        private List<String> gsw;
        private String gsy;
        private boolean gsx = false;
        private a.InterfaceC0020a gsz = new a.InterfaceC0020a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gsy;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.grH = true;
                        d.this.gsk.a(cVar);
                        a.this.gsu.setText(a.this.gsy);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.gss = view;
            this.gst = (TextView) this.gss.findViewById(R.id.live_num);
            this.gsu = (TextView) this.gss.findViewById(R.id.live_sort);
            this.gsu.setVisibility(8);
            this.gsu.setOnClickListener(this);
            bxE();
        }

        public void uh(int i) {
            this.gss.setVisibility(i);
        }

        public void ui(int i) {
            if (this.gst != null) {
                this.gst.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, at.numberUniformFormatExtra(i)));
                this.gss.setVisibility(0);
            }
        }

        private boolean bQd() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void cg(List<String> list) {
            this.gsw = list;
            if (!y.isEmpty(this.gsw) && !this.gsx) {
                this.gsx = true;
                String str = this.gsw.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gsu.setText(str);
                    this.gsu.setVisibility(0);
                }
                this.gsv = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.gsv.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.gsv, R.drawable.bg_ala_sub_list_sort_panel);
                this.gsv.setClipChildren(true);
                this.gsv.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gsw.size(); i++) {
                    this.gsv.addView(makeTextView(this.gsw.get(i)), layoutParams);
                    if (i != this.gsw.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.gsv.addView(view);
                    }
                }
                if (this.gsr == null) {
                    this.gsr = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.gsr.setContentView(this.gsv);
                    this.gsr.setWidth(-2);
                    this.gsr.setHeight(-2);
                    this.gsr.setAnimationStyle(16973826);
                    this.gsr.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.gsr.setOutsideTouchable(true);
                    this.gsr.setFocusable(true);
                    this.gsr.setTouchable(true);
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
            ap.setViewTextColor(textView, (int) R.color.cp_cont_d);
            textView.setOnClickListener(this);
            return textView;
        }

        private void bQe() {
            if (this.gsr != null) {
                int[] iArr = new int[2];
                this.gsu.getLocationOnScreen(iArr);
                int height = ((View) this.gsu.getParent()).getHeight() - this.gsu.getHeight();
                if (iArr[1] - this.gsr.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gsr, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gsr, d.this.mRootView, 0, (iArr[0] - (this.gsu.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gsu.getHeight());
                if (this.gsr != null) {
                    this.gsr.update();
                }
            }
        }

        public void bxE() {
            ap.setViewTextColor(this.gst, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gsu, (int) R.color.cp_cont_d);
            this.gsu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gsu) {
                bQe();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.gsr != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gsr, d.this.mPageContext.getPageActivity());
                }
                if (d.this.gsk != null) {
                    this.gsy = (String) view.getTag();
                    if (this.gsy.contains("距离")) {
                        if (!bQd()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.mk().a(false, this.gsz);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gsy;
                    cVar.grH = false;
                    d.this.gsk.a(cVar);
                    this.gsu.setText(this.gsy);
                }
            }
        }
    }
}
