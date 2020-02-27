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
    private BdTypeListView eka;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ekc;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b ekd;
    private PbListView eli;
    private i etS;
    private LinearLayout etT;
    private View etU;
    private LinearLayout etV;
    private com.baidu.tbadk.k.g etW;
    private a etX;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.h mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int Ni = -1;
    private BdUniqueId MO = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.etV = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.etT = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.etU = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.etX = new a(this.etU);
        this.etX.oQ(8);
        this.eka = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.MO);
        this.eka.setPullRefresh(this.mPullView);
        this.eli = new PbListView(this.mPageContext.getPageActivity());
        this.eli.createView();
        this.ekc = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.ekc.setFrom(2);
        this.ekd = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.ekd.setFrom(2);
        this.asE.add(this.ekc);
        this.asE.add(this.ekd);
        this.eka.addAdapters(this.asE);
    }

    public void oO(int i) {
        this.etT.setVisibility(i);
    }

    public void bdx() {
        if (this.eli != null && this.eli.getView().getParent() != null) {
            this.eka.removeFooterView(this.eli.getView());
        }
    }

    public void bcr() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.eka.setNextPage(this.eli);
            }
            this.eli.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.eli.endLoadData();
        }
    }

    public void oP(int i) {
        if (this.etX != null) {
            this.etX.oR(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Ni != i) {
            this.Ni = i;
        }
        if (this.etX != null) {
            this.etX.aMz();
        }
        if (this.etW != null) {
            this.etW.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.eli != null) {
            this.eli.changeSkin(i);
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
        this.eka.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.eka != null) {
            this.eka.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.eka;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.etW == null) {
                this.etW = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.etW != null) {
                this.etW.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this.mRootView);
            this.etW = null;
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

    public void bcv() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.eka.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.etS = iVar;
        if (this.ekc != null) {
            this.ekc.b(this.etS);
        }
        if (this.ekd != null) {
            this.ekd.b(this.etS);
        }
    }

    public void onDestroy() {
        if (this.etW != null) {
            if (this.etW.getAttachedView() != null) {
                this.etW.dettachView(this.mRootView);
            }
            this.etW.release();
            this.etW = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((g.d) null);
            this.mPullView.a((g.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.eka != null) {
            this.eka.setOnSrollToBottomListener(null);
            this.eka.setOnScrollListener(null);
            this.eka.setRecyclerListener(null);
            this.eka = null;
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
            this.etX.bo(list);
        }
        this.ekc.m31if(z3);
        this.ekd.m32if(z3);
    }

    public void bn(List<String> list) {
        if (!v.isEmpty(list)) {
            this.etX.bo(list);
        }
    }

    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        private PopupWindow etZ;
        private View eua;
        private TextView eub;
        private TextView euc;
        private LinearLayout eud;
        private List<String> eue;
        private String eug;
        private boolean euf = false;
        private a.InterfaceC0016a euh = new a.InterfaceC0016a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.eug;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.etp = true;
                        d.this.etS.a(cVar);
                        a.this.euc.setText(a.this.eug);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.eua = view;
            this.eub = (TextView) this.eua.findViewById(R.id.live_num);
            this.euc = (TextView) this.eua.findViewById(R.id.live_sort);
            this.euc.setVisibility(8);
            this.euc.setOnClickListener(this);
            aMz();
        }

        public void oQ(int i) {
            this.eua.setVisibility(i);
        }

        public void oR(int i) {
            if (this.eub != null) {
                this.eub.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.eua.setVisibility(0);
            }
        }

        private boolean bdy() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bo(List<String> list) {
            this.eue = list;
            if (!v.isEmpty(this.eue) && !this.euf) {
                this.euf = true;
                String str = this.eue.get(0);
                if (!StringUtils.isNull(str)) {
                    this.euc.setText(str);
                    this.euc.setVisibility(0);
                }
                this.eud = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.eud.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.eud, R.drawable.bg_ala_sub_list_sort_panel);
                this.eud.setClipChildren(true);
                this.eud.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.eue.size(); i++) {
                    this.eud.addView(makeTextView(this.eue.get(i)), layoutParams);
                    if (i != this.eue.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.eud.addView(view);
                    }
                }
                if (this.etZ == null) {
                    this.etZ = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.etZ.setContentView(this.eud);
                    this.etZ.setWidth(-2);
                    this.etZ.setHeight(-2);
                    this.etZ.setAnimationStyle(16973826);
                    this.etZ.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.etZ.setOutsideTouchable(true);
                    this.etZ.setFocusable(true);
                    this.etZ.setTouchable(true);
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

        private void bdz() {
            if (this.etZ != null) {
                int[] iArr = new int[2];
                this.euc.getLocationOnScreen(iArr);
                int height = ((View) this.euc.getParent()).getHeight() - this.euc.getHeight();
                if (iArr[1] - this.etZ.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.etZ, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.etZ, d.this.mRootView, 0, (iArr[0] - (this.euc.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.euc.getHeight());
                if (this.etZ != null) {
                    this.etZ.update();
                }
            }
        }

        public void aMz() {
            am.setViewTextColor(this.eub, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.euc, (int) R.color.cp_cont_d);
            this.euc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.euc) {
                bdz();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.etZ != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.etZ, d.this.mPageContext.getPageActivity());
                }
                if (d.this.etS != null) {
                    this.eug = (String) view.getTag();
                    if (this.eug.contains("距离")) {
                        if (!bdy()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.fK().a(false, this.euh);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.eug;
                    cVar.etp = false;
                    d.this.etS.a(cVar);
                    this.euc.setText(this.eug);
                }
            }
        }
    }
}
