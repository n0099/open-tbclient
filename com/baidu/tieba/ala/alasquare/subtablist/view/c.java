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
/* loaded from: classes10.dex */
public class c {
    private PbListView gAi;
    private g gJj;
    private LinearLayout gJk;
    private View gJl;
    private LinearLayout gJm;
    private com.baidu.tbadk.l.g gJn;
    private a gJo;
    private BdTypeListView gzb;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gzd;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gze;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private h refreshView;
    private final String LOCATION = "距离";
    private int ajU = -1;
    private BdUniqueId agC = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.gJm = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.gJk = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.gJl = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.gJo = new a(this.gJl);
        this.gJo.tU(8);
        this.gzb = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agC);
        this.gzb.setPullRefresh(this.mPullView);
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.createView();
        this.gzd = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.gzd.setFrom(2);
        this.gze = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.gze.setFrom(2);
        this.bns.add(this.gzd);
        this.bns.add(this.gze);
        this.gzb.addAdapters(this.bns);
    }

    public void tS(int i) {
        this.gJk.setVisibility(i);
    }

    public void bSx() {
        if (this.gAi != null && this.gAi.getView().getParent() != null) {
            this.gzb.removeFooterView(this.gAi.getView());
        }
    }

    public void bRq() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gAi.endLoadData();
        }
    }

    public void tT(int i) {
        if (this.gJo != null) {
            this.gJo.tV(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ajU != i) {
            this.ajU = i;
        }
        if (this.gJo != null) {
            this.gJo.bzn();
        }
        if (this.gJn != null) {
            this.gJn.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.gAi != null) {
            this.gAi.changeSkin(i);
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
        this.gzb.completePullRefresh();
    }

    public void setData(List<n> list) {
        if (list != null && !y.isEmpty(list) && this.gzb != null) {
            this.gzb.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gzb;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.gJn == null) {
                this.gJn = new com.baidu.tbadk.l.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.gJn != null) {
                this.gJn.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.mRootView);
            this.gJn = null;
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

    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.gzb.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(g gVar) {
        this.gJj = gVar;
        if (this.gzd != null) {
            this.gzd.b(this.gJj);
        }
        if (this.gze != null) {
            this.gze.b(this.gJj);
        }
    }

    public void onDestroy() {
        if (this.gJn != null) {
            if (this.gJn.getAttachedView() != null) {
                this.gJn.dettachView(this.mRootView);
            }
            this.gJn.release();
            this.gJn = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.gzb != null) {
            this.gzb.setOnSrollToBottomListener(null);
            this.gzb.setOnScrollListener(null);
            this.gzb.setRecyclerListener(null);
            this.gzb = null;
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
            this.gJo.cm(list);
        }
        this.gzd.mL(z3);
        this.gze.mL(z3);
    }

    public void cl(List<String> list) {
        if (!y.isEmpty(list)) {
            this.gJo.cm(list);
        }
    }

    /* loaded from: classes10.dex */
    private class a implements View.OnClickListener {
        private PopupWindow gJq;
        private View gJr;
        private TextView gJs;
        private TextView gJt;
        private LinearLayout gJu;
        private List<String> gJv;
        private String gJx;
        private boolean gJw = false;
        private a.InterfaceC0015a gJy = new a.InterfaceC0015a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.c.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gJx;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.gIG = true;
                        c.this.gJj.a(cVar);
                        a.this.gJt.setText(a.this.gJx);
                    }
                } else if (!StringUtils.isNull(str)) {
                    c.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.gJr = view;
            this.gJs = (TextView) this.gJr.findViewById(R.id.live_num);
            this.gJt = (TextView) this.gJr.findViewById(R.id.live_sort);
            this.gJt.setVisibility(8);
            this.gJt.setOnClickListener(this);
            bzn();
        }

        public void tU(int i) {
            this.gJr.setVisibility(i);
        }

        public void tV(int i) {
            if (this.gJs != null) {
                this.gJs.setText(c.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, au.numberUniformFormatExtra(i)));
                this.gJr.setVisibility(0);
            }
        }

        private boolean bSy() {
            return UtilHelper.isSystemLocationProviderEnabled(c.this.mPageContext.getPageActivity());
        }

        public void cm(List<String> list) {
            this.gJv = list;
            if (!y.isEmpty(this.gJv) && !this.gJw) {
                this.gJw = true;
                String str = this.gJv.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gJt.setText(str);
                    this.gJt.setVisibility(0);
                }
                this.gJu = new LinearLayout(c.this.mPageContext.getPageActivity());
                this.gJu.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.gJu, R.drawable.bg_ala_sub_list_sort_panel);
                this.gJu.setClipChildren(true);
                this.gJu.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gJv.size(); i++) {
                    this.gJu.addView(makeTextView(this.gJv.get(i)), layoutParams);
                    if (i != this.gJv.size() - 1) {
                        View view = new View(c.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, c.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.CAM_X0204);
                        this.gJu.addView(view);
                    }
                }
                if (this.gJq == null) {
                    this.gJq = new PopupWindow(c.this.mPageContext.getPageActivity());
                    this.gJq.setContentView(this.gJu);
                    this.gJq.setWidth(-2);
                    this.gJq.setHeight(-2);
                    this.gJq.setAnimationStyle(16973826);
                    this.gJq.setBackgroundDrawable(c.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.gJq.setOutsideTouchable(true);
                    this.gJq.setFocusable(true);
                    this.gJq.setTouchable(true);
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

        private void bSz() {
            if (this.gJq != null) {
                int[] iArr = new int[2];
                this.gJt.getLocationOnScreen(iArr);
                int height = ((View) this.gJt.getParent()).getHeight() - this.gJt.getHeight();
                if (iArr[1] - this.gJq.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJq, c.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gJq, c.this.mRootView, 0, (iArr[0] - (this.gJt.getWidth() / 2)) - c.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gJt.getHeight());
                if (this.gJq != null) {
                    this.gJq.update();
                }
            }
        }

        public void bzn() {
            ap.setViewTextColor(this.gJs, R.color.CAM_X0109);
            ap.setViewTextColor(this.gJt, R.color.CAM_X0109);
            this.gJt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gJt) {
                bSz();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.gJq != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJq, c.this.mPageContext.getPageActivity());
                }
                if (c.this.gJj != null) {
                    this.gJx = (String) view.getTag();
                    if (this.gJx.contains("距离")) {
                        if (!bSy()) {
                            c.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.lH().a(false, this.gJy);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gJx;
                    cVar.gIG = false;
                    c.this.gJj.a(cVar);
                    this.gJt.setText(this.gJx);
                }
            }
        }
    }
}
