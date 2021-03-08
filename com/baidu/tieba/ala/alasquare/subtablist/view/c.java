package com.baidu.tieba.ala.alasquare.subtablist.view;

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
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView gAY;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gBa;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gBb;
    private PbListView gCf;
    private g gLg;
    private LinearLayout gLh;
    private View gLi;
    private LinearLayout gLj;
    private com.baidu.tbadk.l.g gLk;
    private a gLl;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private h refreshView;
    private final String LOCATION = "距离";
    private int aln = -1;
    private BdUniqueId ahU = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.gLj = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.gLh = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.gLi = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.gLl = new a(this.gLi);
        this.gLl.tW(8);
        this.gAY = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ahU);
        this.gAY.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gBa = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.gBa.setFrom(2);
        this.gBb = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.gBb.setFrom(2);
        this.boS.add(this.gBa);
        this.boS.add(this.gBb);
        this.gAY.addAdapters(this.boS);
    }

    public void tU(int i) {
        this.gLh.setVisibility(i);
    }

    public void bSK() {
        if (this.gCf != null && this.gCf.getView().getParent() != null) {
            this.gAY.removeFooterView(this.gCf.getView());
        }
    }

    public void bRD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    public void tV(int i) {
        if (this.gLl != null) {
            this.gLl.tX(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aln != i) {
            this.aln = i;
        }
        if (this.gLl != null) {
            this.gLl.bzq();
        }
        if (this.gLk != null) {
            this.gLk.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void completePullRefresh() {
        this.gAY.completePullRefresh();
    }

    public void setData(List<n> list) {
        if (list != null && !y.isEmpty(list) && this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gAY;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.gLk == null) {
                this.gLk = new com.baidu.tbadk.l.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.gLk != null) {
                this.gLk.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.mRootView);
            this.gLk = null;
        }
    }

    public void a(String str, View.OnClickListener onClickListener, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
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

    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.gAY.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(g gVar) {
        this.gLg = gVar;
        if (this.gBa != null) {
            this.gBa.b(this.gLg);
        }
        if (this.gBb != null) {
            this.gBb.b(this.gLg);
        }
    }

    public void onDestroy() {
        if (this.gLk != null) {
            if (this.gLk.getAttachedView() != null) {
                this.gLk.dettachView(this.mRootView);
            }
            this.gLk.release();
            this.gLk = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.gAY != null) {
            this.gAY.setOnSrollToBottomListener(null);
            this.gAY.setOnScrollListener(null);
            this.gAY.setRecyclerListener(null);
            this.gAY = null;
        }
    }

    public void a(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        if (z) {
            this.mNavigationBar = new NavigationBar(this.mPageContext.getPageActivity());
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mPageContext.getPageActivity().finish();
                }
            });
            if (!StringUtils.isNull(str2)) {
                this.mNavigationBar.setCenterTextTitle(str2);
            } else if (!StringUtils.isNull(str)) {
                this.mNavigationBar.setCenterTextTitle(str);
            }
            this.mRootView.addView(this.mNavigationBar, 0, new LinearLayout.LayoutParams(-1, -2));
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (!y.isEmpty(list)) {
            this.gLl.cm(list);
        }
        this.gBa.mL(z3);
        this.gBb.mL(z3);
    }

    public void cl(List<String> list) {
        if (!y.isEmpty(list)) {
            this.gLl.cm(list);
        }
    }

    /* loaded from: classes9.dex */
    private class a implements View.OnClickListener {
        private PopupWindow gLn;
        private View gLo;
        private TextView gLp;
        private TextView gLq;
        private LinearLayout gLr;
        private List<String> gLs;
        private String gLu;
        private boolean gLt = false;
        private a.InterfaceC0021a gLv = new a.InterfaceC0021a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.c.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0021a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gLu;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.gKD = true;
                        c.this.gLg.a(cVar);
                        a.this.gLq.setText(a.this.gLu);
                    }
                } else if (!StringUtils.isNull(str)) {
                    c.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.gLo = view;
            this.gLp = (TextView) this.gLo.findViewById(R.id.live_num);
            this.gLq = (TextView) this.gLo.findViewById(R.id.live_sort);
            this.gLq.setVisibility(8);
            this.gLq.setOnClickListener(this);
            bzq();
        }

        public void tW(int i) {
            this.gLo.setVisibility(i);
        }

        public void tX(int i) {
            if (this.gLp != null) {
                this.gLp.setText(c.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, au.numberUniformFormatExtra(i)));
                this.gLo.setVisibility(0);
            }
        }

        private boolean bSL() {
            return UtilHelper.isSystemLocationProviderEnabled(c.this.mPageContext.getPageActivity());
        }

        public void cm(List<String> list) {
            this.gLs = list;
            if (!y.isEmpty(this.gLs) && !this.gLt) {
                this.gLt = true;
                String str = this.gLs.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gLq.setText(str);
                    this.gLq.setVisibility(0);
                }
                this.gLr = new LinearLayout(c.this.mPageContext.getPageActivity());
                this.gLr.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.gLr, R.drawable.bg_ala_sub_list_sort_panel);
                this.gLr.setClipChildren(true);
                this.gLr.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gLs.size(); i++) {
                    this.gLr.addView(makeTextView(this.gLs.get(i)), layoutParams);
                    if (i != this.gLs.size() - 1) {
                        View view = new View(c.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, c.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.CAM_X0204);
                        this.gLr.addView(view);
                    }
                }
                if (this.gLn == null) {
                    this.gLn = new PopupWindow(c.this.mPageContext.getPageActivity());
                    this.gLn.setContentView(this.gLr);
                    this.gLn.setWidth(-2);
                    this.gLn.setHeight(-2);
                    this.gLn.setAnimationStyle(16973826);
                    this.gLn.setBackgroundDrawable(c.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.gLn.setOutsideTouchable(true);
                    this.gLn.setFocusable(true);
                    this.gLn.setTouchable(true);
                }
            }
        }

        private TextView makeTextView(String str) {
            TextView textView = new TextView(c.this.mPageContext.getPageActivity());
            textView.setTextSize(0, c.this.mPageContext.getResources().getDimension(R.dimen.ds28));
            textView.setText(str);
            textView.setTag(str);
            textView.setGravity(17);
            ap.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
            ap.setViewTextColor(textView, R.color.CAM_X0109);
            textView.setOnClickListener(this);
            return textView;
        }

        private void bSM() {
            if (this.gLn != null) {
                int[] iArr = new int[2];
                this.gLq.getLocationOnScreen(iArr);
                int height = ((View) this.gLq.getParent()).getHeight() - this.gLq.getHeight();
                if (iArr[1] - this.gLn.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLn, c.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gLn, c.this.mRootView, 0, (iArr[0] - (this.gLq.getWidth() / 2)) - c.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gLq.getHeight());
                if (this.gLn != null) {
                    this.gLn.update();
                }
            }
        }

        public void bzq() {
            ap.setViewTextColor(this.gLp, R.color.CAM_X0109);
            ap.setViewTextColor(this.gLq, R.color.CAM_X0109);
            this.gLq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gLq) {
                bSM();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.gLn != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLn, c.this.mPageContext.getPageActivity());
                }
                if (c.this.gLg != null) {
                    this.gLu = (String) view.getTag();
                    if (this.gLu.contains("距离")) {
                        if (!bSL()) {
                            c.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.lH().a(false, this.gLv);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gLu;
                    cVar.gKD = false;
                    c.this.gLg.a(cVar);
                    this.gLq.setText(this.gLu);
                }
            }
        }
    }
}
