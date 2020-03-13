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
    private BdTypeListView eko;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ekq;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b ekr;
    private PbListView elw;
    private i eug;
    private LinearLayout euh;
    private View eui;
    private LinearLayout euj;
    private com.baidu.tbadk.k.g euk;
    private a eul;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.h mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int Ni = -1;
    private BdUniqueId MO = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.euj = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.euh = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.eui = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.eul = new a(this.eui);
        this.eul.oQ(8);
        this.eko = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.MO);
        this.eko.setPullRefresh(this.mPullView);
        this.elw = new PbListView(this.mPageContext.getPageActivity());
        this.elw.createView();
        this.ekq = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.ekq.setFrom(2);
        this.ekr = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.ekr.setFrom(2);
        this.asF.add(this.ekq);
        this.asF.add(this.ekr);
        this.eko.addAdapters(this.asF);
    }

    public void oO(int i) {
        this.euh.setVisibility(i);
    }

    public void bdA() {
        if (this.elw != null && this.elw.getView().getParent() != null) {
            this.eko.removeFooterView(this.elw.getView());
        }
    }

    public void bcu() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.eko.setNextPage(this.elw);
            }
            this.elw.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.elw.endLoadData();
        }
    }

    public void oP(int i) {
        if (this.eul != null) {
            this.eul.oR(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Ni != i) {
            this.Ni = i;
        }
        if (this.eul != null) {
            this.eul.aMC();
        }
        if (this.euk != null) {
            this.euk.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.elw != null) {
            this.elw.changeSkin(i);
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
        this.eko.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.eko != null) {
            this.eko.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.eko;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.euk == null) {
                this.euk = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.euk != null) {
                this.euk.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.euk != null) {
            this.euk.dettachView(this.mRootView);
            this.euk = null;
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

    public void bcy() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.eko.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.eug = iVar;
        if (this.ekq != null) {
            this.ekq.b(this.eug);
        }
        if (this.ekr != null) {
            this.ekr.b(this.eug);
        }
    }

    public void onDestroy() {
        if (this.euk != null) {
            if (this.euk.getAttachedView() != null) {
                this.euk.dettachView(this.mRootView);
            }
            this.euk.release();
            this.euk = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((g.d) null);
            this.mPullView.a((g.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.eko != null) {
            this.eko.setOnSrollToBottomListener(null);
            this.eko.setOnScrollListener(null);
            this.eko.setRecyclerListener(null);
            this.eko = null;
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
            this.eul.bo(list);
        }
        this.ekq.m31if(z3);
        this.ekr.m32if(z3);
    }

    public void bn(List<String> list) {
        if (!v.isEmpty(list)) {
            this.eul.bo(list);
        }
    }

    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        private PopupWindow eun;
        private View euo;
        private TextView eup;
        private TextView euq;
        private LinearLayout eur;
        private List<String> eus;
        private String euu;
        private boolean eut = false;
        private a.InterfaceC0016a euv = new a.InterfaceC0016a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.euu;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.etD = true;
                        d.this.eug.a(cVar);
                        a.this.euq.setText(a.this.euu);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.euo = view;
            this.eup = (TextView) this.euo.findViewById(R.id.live_num);
            this.euq = (TextView) this.euo.findViewById(R.id.live_sort);
            this.euq.setVisibility(8);
            this.euq.setOnClickListener(this);
            aMC();
        }

        public void oQ(int i) {
            this.euo.setVisibility(i);
        }

        public void oR(int i) {
            if (this.eup != null) {
                this.eup.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.euo.setVisibility(0);
            }
        }

        private boolean bdB() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bo(List<String> list) {
            this.eus = list;
            if (!v.isEmpty(this.eus) && !this.eut) {
                this.eut = true;
                String str = this.eus.get(0);
                if (!StringUtils.isNull(str)) {
                    this.euq.setText(str);
                    this.euq.setVisibility(0);
                }
                this.eur = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.eur.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.eur, R.drawable.bg_ala_sub_list_sort_panel);
                this.eur.setClipChildren(true);
                this.eur.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.eus.size(); i++) {
                    this.eur.addView(makeTextView(this.eus.get(i)), layoutParams);
                    if (i != this.eus.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.eur.addView(view);
                    }
                }
                if (this.eun == null) {
                    this.eun = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.eun.setContentView(this.eur);
                    this.eun.setWidth(-2);
                    this.eun.setHeight(-2);
                    this.eun.setAnimationStyle(16973826);
                    this.eun.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.eun.setOutsideTouchable(true);
                    this.eun.setFocusable(true);
                    this.eun.setTouchable(true);
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

        private void bdC() {
            if (this.eun != null) {
                int[] iArr = new int[2];
                this.euq.getLocationOnScreen(iArr);
                int height = ((View) this.euq.getParent()).getHeight() - this.euq.getHeight();
                if (iArr[1] - this.eun.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eun, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eun, d.this.mRootView, 0, (iArr[0] - (this.euq.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.euq.getHeight());
                if (this.eun != null) {
                    this.eun.update();
                }
            }
        }

        public void aMC() {
            am.setViewTextColor(this.eup, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.euq, (int) R.color.cp_cont_d);
            this.euq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.euq) {
                bdC();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.eun != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eun, d.this.mPageContext.getPageActivity());
                }
                if (d.this.eug != null) {
                    this.euu = (String) view.getTag();
                    if (this.euu.contains("距离")) {
                        if (!bdB()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.fK().a(false, this.euv);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.euu;
                    cVar.etD = false;
                    d.this.eug.a(cVar);
                    this.euq.setText(this.euu);
                }
            }
        }
    }
}
