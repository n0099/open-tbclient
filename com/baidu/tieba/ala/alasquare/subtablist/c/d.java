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
    private a dDA;
    private h dDv;
    private LinearLayout dDw;
    private View dDx;
    private LinearLayout dDy;
    private com.baidu.tbadk.m.g dDz;
    private BdTypeListView duK;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a duM;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b duN;
    private PbListView dvS;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private i mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private final String LOCATION = "距离";
    private int csg = -1;
    private BdUniqueId GX = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.dDy = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.dDw = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.dDx = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.dDA = new a(this.dDx);
        this.dDA.mp(8);
        this.duK = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.GX);
        this.duK.setPullRefresh(this.mPullView);
        this.dvS = new PbListView(this.mPageContext.getPageActivity());
        this.dvS.createView();
        this.duM = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.duM.setFrom(2);
        this.duN = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.duN.setFrom(2);
        this.agy.add(this.duM);
        this.agy.add(this.duN);
        this.duK.addAdapters(this.agy);
    }

    public void mn(int i) {
        this.dDw.setVisibility(i);
    }

    public void aKo() {
        if (this.dvS != null && this.dvS.getView().getParent() != null) {
            this.duK.removeFooterView(this.dvS.getView());
        }
    }

    public void aJi() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.duK.setNextPage(this.dvS);
            }
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.dvS.endLoadData();
        }
    }

    public void mo(int i) {
        if (this.dDA != null) {
            this.dDA.mq(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.csg != i) {
            this.csg = i;
        }
        if (this.dDA != null) {
            this.dDA.ask();
        }
        if (this.dDz != null) {
            this.dDz.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.dvS != null) {
            this.dvS.changeSkin(i);
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
        this.duK.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.duK != null) {
            this.duK.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.duK;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.dDz == null) {
                this.dDz = new com.baidu.tbadk.m.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.dDz != null) {
                this.dDz.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this.mRootView);
            this.dDz = null;
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

    public void aJm() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.duK.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(h hVar) {
        this.dDv = hVar;
        if (this.duM != null) {
            this.duM.b(this.dDv);
        }
        if (this.duN != null) {
            this.duN.b(this.dDv);
        }
    }

    public void onDestroy() {
        if (this.dDz != null) {
            if (this.dDz.getAttachedView() != null) {
                this.dDz.dettachView(this.mRootView);
            }
            this.dDz.release();
            this.dDz = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((h.d) null);
            this.mPullView.a((h.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.duK != null) {
            this.duK.setOnSrollToBottomListener(null);
            this.duK.setOnScrollListener(null);
            this.duK.setRecyclerListener(null);
            this.duK = null;
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
            this.dDA.bp(list);
        }
        this.duM.gJ(z3);
        this.duN.gJ(z3);
    }

    public void bo(List<String> list) {
        if (!v.isEmpty(list)) {
            this.dDA.bp(list);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements View.OnClickListener {
        private PopupWindow dDC;
        private View dDD;
        private TextView dDE;
        private TextView dDF;
        private LinearLayout dDG;
        private List<String> dDH;
        private String dDJ;
        private boolean dDI = false;
        private a.InterfaceC0015a dDK = new a.InterfaceC0015a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.dDJ;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.dCS = true;
                        d.this.dDv.a(cVar);
                        a.this.dDF.setText(a.this.dDJ);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.dDD = view;
            this.dDE = (TextView) this.dDD.findViewById(R.id.live_num);
            this.dDF = (TextView) this.dDD.findViewById(R.id.live_sort);
            this.dDF.setVisibility(8);
            this.dDF.setOnClickListener(this);
            ask();
        }

        public void mp(int i) {
            this.dDD.setVisibility(i);
        }

        public void mq(int i) {
            if (this.dDE != null) {
                this.dDE.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.dDD.setVisibility(0);
            }
        }

        private boolean aKp() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bp(List<String> list) {
            this.dDH = list;
            if (!v.isEmpty(this.dDH) && !this.dDI) {
                this.dDI = true;
                String str = this.dDH.get(0);
                if (!StringUtils.isNull(str)) {
                    this.dDF.setText(str);
                    this.dDF.setVisibility(0);
                }
                this.dDG = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.dDG.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.dDG, R.drawable.bg_ala_sub_list_sort_panel);
                this.dDG.setClipChildren(true);
                this.dDG.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.dDH.size(); i++) {
                    this.dDG.addView(makeTextView(this.dDH.get(i)), layoutParams);
                    if (i != this.dDH.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.dDG.addView(view);
                    }
                }
                if (this.dDC == null) {
                    this.dDC = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.dDC.setContentView(this.dDG);
                    this.dDC.setWidth(-2);
                    this.dDC.setHeight(-2);
                    this.dDC.setAnimationStyle(16973826);
                    this.dDC.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.dDC.setOutsideTouchable(true);
                    this.dDC.setFocusable(true);
                    this.dDC.setTouchable(true);
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

        private void aKq() {
            if (this.dDC != null) {
                int[] iArr = new int[2];
                this.dDF.getLocationOnScreen(iArr);
                int height = ((View) this.dDF.getParent()).getHeight() - this.dDF.getHeight();
                if (iArr[1] - this.dDC.getHeight() <= 50) {
                    com.baidu.adp.lib.g.g.dismissPopupWindow(this.dDC, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dDC, d.this.mRootView, 0, (iArr[0] - (this.dDF.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.dDF.getHeight());
                if (this.dDC != null) {
                    this.dDC.update();
                }
            }
        }

        public void ask() {
            am.setViewTextColor(this.dDE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dDF, (int) R.color.cp_cont_d);
            this.dDF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.dDF) {
                aKq();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.dDC != null) {
                    com.baidu.adp.lib.g.g.dismissPopupWindow(this.dDC, d.this.mPageContext.getPageActivity());
                }
                if (d.this.dDv != null) {
                    this.dDJ = (String) view.getTag();
                    if (this.dDJ.contains("距离")) {
                        if (!aKp()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.d.a.fw().a(false, this.dDK);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.dDJ;
                    cVar.dCS = false;
                    d.this.dDv.a(cVar);
                    this.dDF.setText(this.dDJ);
                }
            }
        }
    }
}
