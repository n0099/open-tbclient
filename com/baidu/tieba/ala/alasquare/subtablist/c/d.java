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
    private BdTypeListView ekb;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ekd;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b eke;
    private PbListView elj;
    private i etT;
    private LinearLayout etU;
    private View etV;
    private LinearLayout etW;
    private com.baidu.tbadk.k.g etX;
    private a etY;
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
        this.etW = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.etU = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.etV = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.etY = new a(this.etV);
        this.etY.oQ(8);
        this.ekb = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.MO);
        this.ekb.setPullRefresh(this.mPullView);
        this.elj = new PbListView(this.mPageContext.getPageActivity());
        this.elj.createView();
        this.ekd = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.ekd.setFrom(2);
        this.eke = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.eke.setFrom(2);
        this.asE.add(this.ekd);
        this.asE.add(this.eke);
        this.ekb.addAdapters(this.asE);
    }

    public void oO(int i) {
        this.etU.setVisibility(i);
    }

    public void bdz() {
        if (this.elj != null && this.elj.getView().getParent() != null) {
            this.ekb.removeFooterView(this.elj.getView());
        }
    }

    public void bct() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.ekb.setNextPage(this.elj);
            }
            this.elj.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.elj.endLoadData();
        }
    }

    public void oP(int i) {
        if (this.etY != null) {
            this.etY.oR(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Ni != i) {
            this.Ni = i;
        }
        if (this.etY != null) {
            this.etY.aMB();
        }
        if (this.etX != null) {
            this.etX.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.elj != null) {
            this.elj.changeSkin(i);
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
        this.ekb.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.ekb != null) {
            this.ekb.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.ekb;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.etX == null) {
                this.etX = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.etX != null) {
                this.etX.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this.mRootView);
            this.etX = null;
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

    public void bcx() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.ekb.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.etT = iVar;
        if (this.ekd != null) {
            this.ekd.b(this.etT);
        }
        if (this.eke != null) {
            this.eke.b(this.etT);
        }
    }

    public void onDestroy() {
        if (this.etX != null) {
            if (this.etX.getAttachedView() != null) {
                this.etX.dettachView(this.mRootView);
            }
            this.etX.release();
            this.etX = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((g.d) null);
            this.mPullView.a((g.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.ekb != null) {
            this.ekb.setOnSrollToBottomListener(null);
            this.ekb.setOnScrollListener(null);
            this.ekb.setRecyclerListener(null);
            this.ekb = null;
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
            this.etY.bo(list);
        }
        this.ekd.m31if(z3);
        this.eke.m32if(z3);
    }

    public void bn(List<String> list) {
        if (!v.isEmpty(list)) {
            this.etY.bo(list);
        }
    }

    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        private PopupWindow eua;
        private View eub;
        private TextView euc;
        private TextView eud;
        private LinearLayout eue;
        private List<String> euf;
        private String euh;
        private boolean eug = false;
        private a.InterfaceC0016a eui = new a.InterfaceC0016a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.euh;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.etq = true;
                        d.this.etT.a(cVar);
                        a.this.eud.setText(a.this.euh);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.eub = view;
            this.euc = (TextView) this.eub.findViewById(R.id.live_num);
            this.eud = (TextView) this.eub.findViewById(R.id.live_sort);
            this.eud.setVisibility(8);
            this.eud.setOnClickListener(this);
            aMB();
        }

        public void oQ(int i) {
            this.eub.setVisibility(i);
        }

        public void oR(int i) {
            if (this.euc != null) {
                this.euc.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.eub.setVisibility(0);
            }
        }

        private boolean bdA() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bo(List<String> list) {
            this.euf = list;
            if (!v.isEmpty(this.euf) && !this.eug) {
                this.eug = true;
                String str = this.euf.get(0);
                if (!StringUtils.isNull(str)) {
                    this.eud.setText(str);
                    this.eud.setVisibility(0);
                }
                this.eue = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.eue.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.eue, R.drawable.bg_ala_sub_list_sort_panel);
                this.eue.setClipChildren(true);
                this.eue.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.euf.size(); i++) {
                    this.eue.addView(makeTextView(this.euf.get(i)), layoutParams);
                    if (i != this.euf.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.eue.addView(view);
                    }
                }
                if (this.eua == null) {
                    this.eua = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.eua.setContentView(this.eue);
                    this.eua.setWidth(-2);
                    this.eua.setHeight(-2);
                    this.eua.setAnimationStyle(16973826);
                    this.eua.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.eua.setOutsideTouchable(true);
                    this.eua.setFocusable(true);
                    this.eua.setTouchable(true);
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

        private void bdB() {
            if (this.eua != null) {
                int[] iArr = new int[2];
                this.eud.getLocationOnScreen(iArr);
                int height = ((View) this.eud.getParent()).getHeight() - this.eud.getHeight();
                if (iArr[1] - this.eua.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eua, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eua, d.this.mRootView, 0, (iArr[0] - (this.eud.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eud.getHeight());
                if (this.eua != null) {
                    this.eua.update();
                }
            }
        }

        public void aMB() {
            am.setViewTextColor(this.euc, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eud, (int) R.color.cp_cont_d);
            this.eud.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.eud) {
                bdB();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.eua != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eua, d.this.mPageContext.getPageActivity());
                }
                if (d.this.etT != null) {
                    this.euh = (String) view.getTag();
                    if (this.euh.contains("距离")) {
                        if (!bdA()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.fK().a(false, this.eui);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.euh;
                    cVar.etq = false;
                    d.this.etT.a(cVar);
                    this.eud.setText(this.euh);
                }
            }
        }
    }
}
