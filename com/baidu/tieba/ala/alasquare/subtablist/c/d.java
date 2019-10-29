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
import com.baidu.adp.lib.d.a;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private h dEm;
    private LinearLayout dEn;
    private View dEo;
    private LinearLayout dEp;
    private com.baidu.tbadk.m.g dEq;
    private a dEr;
    private BdTypeListView dvB;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a dvD;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b dvE;
    private PbListView dwJ;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private i mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private final String LOCATION = "距离";
    private int csX = -1;
    private BdUniqueId Hx = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.dEp = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.dEn = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.dEo = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.dEr = new a(this.dEo);
        this.dEr.mq(8);
        this.dvB = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.Hx);
        this.dvB.setPullRefresh(this.mPullView);
        this.dwJ = new PbListView(this.mPageContext.getPageActivity());
        this.dwJ.createView();
        this.dvD = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.dvD.setFrom(2);
        this.dvE = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.dvE.setFrom(2);
        this.agQ.add(this.dvD);
        this.agQ.add(this.dvE);
        this.dvB.addAdapters(this.agQ);
    }

    public void mo(int i) {
        this.dEn.setVisibility(i);
    }

    public void aKq() {
        if (this.dwJ != null && this.dwJ.getView().getParent() != null) {
            this.dvB.removeFooterView(this.dwJ.getView());
        }
    }

    public void aJk() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dvB.setNextPage(this.dwJ);
            }
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.dwJ.endLoadData();
        }
    }

    public void mp(int i) {
        if (this.dEr != null) {
            this.dEr.mr(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.csX != i) {
            this.csX = i;
        }
        if (this.dEr != null) {
            this.dEr.asm();
        }
        if (this.dEq != null) {
            this.dEq.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.dwJ != null) {
            this.dwJ.changeSkin(i);
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
        this.dvB.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.dvB != null) {
            this.dvB.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.dvB;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.dEq == null) {
                this.dEq = new com.baidu.tbadk.m.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.dEq != null) {
                this.dEq.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this.mRootView);
            this.dEq = null;
        }
    }

    public void a(String str, View.OnClickListener onClickListener, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), onClickListener);
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

    public void aJo() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.dvB.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(h hVar) {
        this.dEm = hVar;
        if (this.dvD != null) {
            this.dvD.b(this.dEm);
        }
        if (this.dvE != null) {
            this.dvE.b(this.dEm);
        }
    }

    public void onDestroy() {
        if (this.dEq != null) {
            if (this.dEq.getAttachedView() != null) {
                this.dEq.dettachView(this.mRootView);
            }
            this.dEq.release();
            this.dEq = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((h.d) null);
            this.mPullView.a((h.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.dvB != null) {
            this.dvB.setOnSrollToBottomListener(null);
            this.dvB.setOnScrollListener(null);
            this.dvB.setRecyclerListener(null);
            this.dvB = null;
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
            this.dEr.bp(list);
        }
        this.dvD.gJ(z3);
        this.dvE.gJ(z3);
    }

    public void bo(List<String> list) {
        if (!v.isEmpty(list)) {
            this.dEr.bp(list);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements View.OnClickListener {
        private String dEA;
        private PopupWindow dEt;
        private View dEu;
        private TextView dEv;
        private TextView dEw;
        private LinearLayout dEx;
        private List<String> dEy;
        private boolean dEz = false;
        private a.InterfaceC0015a dEB = new a.InterfaceC0015a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.dEA;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.dDJ = true;
                        d.this.dEm.a(cVar);
                        a.this.dEw.setText(a.this.dEA);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.dEu = view;
            this.dEv = (TextView) this.dEu.findViewById(R.id.live_num);
            this.dEw = (TextView) this.dEu.findViewById(R.id.live_sort);
            this.dEw.setVisibility(8);
            this.dEw.setOnClickListener(this);
            asm();
        }

        public void mq(int i) {
            this.dEu.setVisibility(i);
        }

        public void mr(int i) {
            if (this.dEv != null) {
                this.dEv.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.dEu.setVisibility(0);
            }
        }

        private boolean aKr() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bp(List<String> list) {
            this.dEy = list;
            if (!v.isEmpty(this.dEy) && !this.dEz) {
                this.dEz = true;
                String str = this.dEy.get(0);
                if (!StringUtils.isNull(str)) {
                    this.dEw.setText(str);
                    this.dEw.setVisibility(0);
                }
                this.dEx = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.dEx.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.dEx, R.drawable.bg_ala_sub_list_sort_panel);
                this.dEx.setClipChildren(true);
                this.dEx.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.dEy.size(); i++) {
                    this.dEx.addView(makeTextView(this.dEy.get(i)), layoutParams);
                    if (i != this.dEy.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.dEx.addView(view);
                    }
                }
                if (this.dEt == null) {
                    this.dEt = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.dEt.setContentView(this.dEx);
                    this.dEt.setWidth(-2);
                    this.dEt.setHeight(-2);
                    this.dEt.setAnimationStyle(16973826);
                    this.dEt.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.dEt.setOutsideTouchable(true);
                    this.dEt.setFocusable(true);
                    this.dEt.setTouchable(true);
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

        private void aKs() {
            if (this.dEt != null) {
                int[] iArr = new int[2];
                this.dEw.getLocationOnScreen(iArr);
                int height = ((View) this.dEw.getParent()).getHeight() - this.dEw.getHeight();
                if (iArr[1] - this.dEt.getHeight() <= 50) {
                    com.baidu.adp.lib.g.g.dismissPopupWindow(this.dEt, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dEt, d.this.mRootView, 0, (iArr[0] - (this.dEw.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.dEw.getHeight());
                if (this.dEt != null) {
                    this.dEt.update();
                }
            }
        }

        public void asm() {
            am.setViewTextColor(this.dEv, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dEw, (int) R.color.cp_cont_d);
            this.dEw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.dEw) {
                aKs();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.dEt != null) {
                    com.baidu.adp.lib.g.g.dismissPopupWindow(this.dEt, d.this.mPageContext.getPageActivity());
                }
                if (d.this.dEm != null) {
                    this.dEA = (String) view.getTag();
                    if (this.dEA.contains("距离")) {
                        if (!aKr()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.d.a.fw().a(false, this.dEB);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.dEA;
                    cVar.dDJ = false;
                    d.this.dEm.a(cVar);
                    this.dEw.setText(this.dEA);
                }
            }
        }
    }
}
