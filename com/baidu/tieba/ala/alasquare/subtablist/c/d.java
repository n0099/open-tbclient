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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private i gAa;
    private LinearLayout gAb;
    private View gAc;
    private LinearLayout gAd;
    private com.baidu.tbadk.l.g gAe;
    private a gAf;
    private BdTypeListView gpX;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gpZ;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gqa;
    private PbListView gre;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.l.h refreshView;
    private final String LOCATION = "距离";
    private int aku = -1;
    private BdUniqueId ajD = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.gAd = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.gAb = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.gAc = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.gAf = new a(this.gAc);
        this.gAf.vj(8);
        this.gpX = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ajD);
        this.gpX.setPullRefresh(this.mPullView);
        this.gre = new PbListView(this.mPageContext.getPageActivity());
        this.gre.createView();
        this.gpZ = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.gpZ.setFrom(2);
        this.gqa = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.gqa.setFrom(2);
        this.bnf.add(this.gpZ);
        this.bnf.add(this.gqa);
        this.gpX.addAdapters(this.bnf);
    }

    public void vh(int i) {
        this.gAb.setVisibility(i);
    }

    public void bTg() {
        if (this.gre != null && this.gre.getView().getParent() != null) {
            this.gpX.removeFooterView(this.gre.getView());
        }
    }

    public void bSa() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.gpX.setNextPage(this.gre);
            }
            this.gre.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gre.endLoadData();
        }
    }

    public void vi(int i) {
        if (this.gAf != null) {
            this.gAf.vk(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aku != i) {
            this.aku = i;
        }
        if (this.gAf != null) {
            this.gAf.bAu();
        }
        if (this.gAe != null) {
            this.gAe.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.gre != null) {
            this.gre.changeSkin(i);
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
        this.gpX.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !y.isEmpty(list) && this.gpX != null) {
            this.gpX.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gpX;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.gAe == null) {
                this.gAe = new com.baidu.tbadk.l.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.gAe != null) {
                this.gAe.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this.mRootView);
            this.gAe = null;
        }
    }

    public void a(String str, View.OnClickListener onClickListener, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.l.h(this.mPageContext.getPageActivity(), onClickListener);
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

    public void Yb() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.gpX.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.gAa = iVar;
        if (this.gpZ != null) {
            this.gpZ.b(this.gAa);
        }
        if (this.gqa != null) {
            this.gqa.b(this.gAa);
        }
    }

    public void onDestroy() {
        if (this.gAe != null) {
            if (this.gAe.getAttachedView() != null) {
                this.gAe.dettachView(this.mRootView);
            }
            this.gAe.release();
            this.gAe = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.gpX != null) {
            this.gpX.setOnSrollToBottomListener(null);
            this.gpX.setOnScrollListener(null);
            this.gpX.setRecyclerListener(null);
            this.gpX = null;
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
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (!y.isEmpty(list)) {
            this.gAf.ck(list);
        }
        this.gpZ.mo(z3);
        this.gqa.mo(z3);
    }

    public void cj(List<String> list) {
        if (!y.isEmpty(list)) {
            this.gAf.ck(list);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements View.OnClickListener {
        private PopupWindow gAh;
        private View gAi;
        private TextView gAj;
        private TextView gAk;
        private LinearLayout gAl;
        private List<String> gAm;
        private String gAo;
        private boolean gAn = false;
        private a.InterfaceC0020a gAp = new a.InterfaceC0020a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gAo;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.gzx = true;
                        d.this.gAa.a(cVar);
                        a.this.gAk.setText(a.this.gAo);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.gAi = view;
            this.gAj = (TextView) this.gAi.findViewById(R.id.live_num);
            this.gAk = (TextView) this.gAi.findViewById(R.id.live_sort);
            this.gAk.setVisibility(8);
            this.gAk.setOnClickListener(this);
            bAu();
        }

        public void vj(int i) {
            this.gAi.setVisibility(i);
        }

        public void vk(int i) {
            if (this.gAj != null) {
                this.gAj.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, au.numberUniformFormatExtra(i)));
                this.gAi.setVisibility(0);
            }
        }

        private boolean bTh() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void ck(List<String> list) {
            this.gAm = list;
            if (!y.isEmpty(this.gAm) && !this.gAn) {
                this.gAn = true;
                String str = this.gAm.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gAk.setText(str);
                    this.gAk.setVisibility(0);
                }
                this.gAl = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.gAl.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.gAl, R.drawable.bg_ala_sub_list_sort_panel);
                this.gAl.setClipChildren(true);
                this.gAl.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gAm.size(); i++) {
                    this.gAl.addView(makeTextView(this.gAm.get(i)), layoutParams);
                    if (i != this.gAm.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.CAM_X0204);
                        this.gAl.addView(view);
                    }
                }
                if (this.gAh == null) {
                    this.gAh = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.gAh.setContentView(this.gAl);
                    this.gAh.setWidth(-2);
                    this.gAh.setHeight(-2);
                    this.gAh.setAnimationStyle(16973826);
                    this.gAh.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.gAh.setOutsideTouchable(true);
                    this.gAh.setFocusable(true);
                    this.gAh.setTouchable(true);
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
            ap.setViewTextColor(textView, R.color.CAM_X0109);
            textView.setOnClickListener(this);
            return textView;
        }

        private void bTi() {
            if (this.gAh != null) {
                int[] iArr = new int[2];
                this.gAk.getLocationOnScreen(iArr);
                int height = ((View) this.gAk.getParent()).getHeight() - this.gAk.getHeight();
                if (iArr[1] - this.gAh.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAh, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gAh, d.this.mRootView, 0, (iArr[0] - (this.gAk.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gAk.getHeight());
                if (this.gAh != null) {
                    this.gAh.update();
                }
            }
        }

        public void bAu() {
            ap.setViewTextColor(this.gAj, R.color.CAM_X0109);
            ap.setViewTextColor(this.gAk, R.color.CAM_X0109);
            this.gAk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gAk) {
                bTi();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.gAh != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gAh, d.this.mPageContext.getPageActivity());
                }
                if (d.this.gAa != null) {
                    this.gAo = (String) view.getTag();
                    if (this.gAo.contains("距离")) {
                        if (!bTh()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.mk().a(false, this.gAp);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gAo;
                    cVar.gzx = false;
                    d.this.gAa.a(cVar);
                    this.gAk.setText(this.gAo);
                }
            }
        }
    }
}
