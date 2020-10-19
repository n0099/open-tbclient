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
    private BdTypeListView fSo;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fSq;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fSr;
    private PbListView fTv;
    private i gct;
    private LinearLayout gcu;
    private View gcv;
    private LinearLayout gcw;
    private com.baidu.tbadk.k.g gcx;
    private a gcy;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int ajp = -1;
    private BdUniqueId aiy = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.gcw = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.gcu = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.gcv = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.gcy = new a(this.gcv);
        this.gcy.tE(8);
        this.fSo = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aiy);
        this.fSo.setPullRefresh(this.mPullView);
        this.fTv = new PbListView(this.mPageContext.getPageActivity());
        this.fTv.createView();
        this.fSq = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.fSq.setFrom(2);
        this.fSr = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.fSr.setFrom(2);
        this.bhH.add(this.fSq);
        this.bhH.add(this.fSr);
        this.fSo.addAdapters(this.bhH);
    }

    public void tC(int i) {
        this.gcu.setVisibility(i);
    }

    public void bLa() {
        if (this.fTv != null && this.fTv.getView().getParent() != null) {
            this.fSo.removeFooterView(this.fTv.getView());
        }
    }

    public void bJU() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.fSo.setNextPage(this.fTv);
            }
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fTv.endLoadData();
        }
    }

    public void tD(int i) {
        if (this.gcy != null) {
            this.gcy.tF(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ajp != i) {
            this.ajp = i;
        }
        if (this.gcy != null) {
            this.gcy.btm();
        }
        if (this.gcx != null) {
            this.gcx.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.fTv != null) {
            this.fTv.changeSkin(i);
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
        this.fSo.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !y.isEmpty(list) && this.fSo != null) {
            this.fSo.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fSo;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.gcx == null) {
                this.gcx = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.gcx != null) {
                this.gcx.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this.mRootView);
            this.gcx = null;
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

    public void SK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.fSo.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.gct = iVar;
        if (this.fSq != null) {
            this.fSq.b(this.gct);
        }
        if (this.fSr != null) {
            this.fSr.b(this.gct);
        }
    }

    public void onDestroy() {
        if (this.gcx != null) {
            if (this.gcx.getAttachedView() != null) {
                this.gcx.dettachView(this.mRootView);
            }
            this.gcx.release();
            this.gcx = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.fSo != null) {
            this.fSo.setOnSrollToBottomListener(null);
            this.fSo.setOnScrollListener(null);
            this.fSo.setRecyclerListener(null);
            this.fSo = null;
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
            this.gcy.bP(list);
        }
        this.fSq.lr(z3);
        this.fSr.lr(z3);
    }

    public void bO(List<String> list) {
        if (!y.isEmpty(list)) {
            this.gcy.bP(list);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements View.OnClickListener {
        private PopupWindow gcA;
        private View gcB;
        private TextView gcC;
        private TextView gcD;
        private LinearLayout gcE;
        private List<String> gcF;
        private String gcH;
        private boolean gcG = false;
        private a.InterfaceC0020a gcI = new a.InterfaceC0020a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gcH;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.gbQ = true;
                        d.this.gct.a(cVar);
                        a.this.gcD.setText(a.this.gcH);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.gcB = view;
            this.gcC = (TextView) this.gcB.findViewById(R.id.live_num);
            this.gcD = (TextView) this.gcB.findViewById(R.id.live_sort);
            this.gcD.setVisibility(8);
            this.gcD.setOnClickListener(this);
            btm();
        }

        public void tE(int i) {
            this.gcB.setVisibility(i);
        }

        public void tF(int i) {
            if (this.gcC != null) {
                this.gcC.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, at.numberUniformFormatExtra(i)));
                this.gcB.setVisibility(0);
            }
        }

        private boolean bLb() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bP(List<String> list) {
            this.gcF = list;
            if (!y.isEmpty(this.gcF) && !this.gcG) {
                this.gcG = true;
                String str = this.gcF.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gcD.setText(str);
                    this.gcD.setVisibility(0);
                }
                this.gcE = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.gcE.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.gcE, R.drawable.bg_ala_sub_list_sort_panel);
                this.gcE.setClipChildren(true);
                this.gcE.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gcF.size(); i++) {
                    this.gcE.addView(makeTextView(this.gcF.get(i)), layoutParams);
                    if (i != this.gcF.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.gcE.addView(view);
                    }
                }
                if (this.gcA == null) {
                    this.gcA = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.gcA.setContentView(this.gcE);
                    this.gcA.setWidth(-2);
                    this.gcA.setHeight(-2);
                    this.gcA.setAnimationStyle(16973826);
                    this.gcA.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.gcA.setOutsideTouchable(true);
                    this.gcA.setFocusable(true);
                    this.gcA.setTouchable(true);
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

        private void bLc() {
            if (this.gcA != null) {
                int[] iArr = new int[2];
                this.gcD.getLocationOnScreen(iArr);
                int height = ((View) this.gcD.getParent()).getHeight() - this.gcD.getHeight();
                if (iArr[1] - this.gcA.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gcA, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gcA, d.this.mRootView, 0, (iArr[0] - (this.gcD.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gcD.getHeight());
                if (this.gcA != null) {
                    this.gcA.update();
                }
            }
        }

        public void btm() {
            ap.setViewTextColor(this.gcC, R.color.cp_cont_d);
            ap.setViewTextColor(this.gcD, R.color.cp_cont_d);
            this.gcD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gcD) {
                bLc();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.gcA != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gcA, d.this.mPageContext.getPageActivity());
                }
                if (d.this.gct != null) {
                    this.gcH = (String) view.getTag();
                    if (this.gcH.contains("距离")) {
                        if (!bLb()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.mk().a(false, this.gcI);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gcH;
                    cVar.gbQ = false;
                    d.this.gct.a(cVar);
                    this.gcD.setText(this.gcH);
                }
            }
        }
    }
}
