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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private i fBr;
    private LinearLayout fBs;
    private View fBt;
    private LinearLayout fBu;
    private com.baidu.tbadk.k.g fBv;
    private a fBw;
    private BdTypeListView frv;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a frx;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fry;
    private PbListView fsC;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int aho = -1;
    private BdUniqueId agB = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.fBu = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.fBs = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.fBt = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.fBw = new a(this.fBt);
        this.fBw.qC(8);
        this.frv = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agB);
        this.frv.setPullRefresh(this.mPullView);
        this.fsC = new PbListView(this.mPageContext.getPageActivity());
        this.fsC.createView();
        this.frx = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.frx.setFrom(2);
        this.fry = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.fry.setFrom(2);
        this.aWf.add(this.frx);
        this.aWf.add(this.fry);
        this.frv.addAdapters(this.aWf);
    }

    public void qA(int i) {
        this.fBs.setVisibility(i);
    }

    public void bya() {
        if (this.fsC != null && this.fsC.getView().getParent() != null) {
            this.frv.removeFooterView(this.fsC.getView());
        }
    }

    public void bwS() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.frv.setNextPage(this.fsC);
            }
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fsC.endLoadData();
        }
    }

    public void qB(int i) {
        if (this.fBw != null) {
            this.fBw.qD(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aho != i) {
            this.aho = i;
        }
        if (this.fBw != null) {
            this.fBw.bgV();
        }
        if (this.fBv != null) {
            this.fBv.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.fsC != null) {
            this.fsC.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void completePullRefresh() {
        this.frv.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !x.isEmpty(list) && this.frv != null) {
            this.frv.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.frv;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.fBv == null) {
                this.fBv = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.fBv != null) {
                this.fBv.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.mRootView);
            this.fBv = null;
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

    public void bwX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.frv.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.fBr = iVar;
        if (this.frx != null) {
            this.frx.b(this.fBr);
        }
        if (this.fry != null) {
            this.fry.b(this.fBr);
        }
    }

    public void onDestroy() {
        if (this.fBv != null) {
            if (this.fBv.getAttachedView() != null) {
                this.fBv.dettachView(this.mRootView);
            }
            this.fBv.release();
            this.fBv = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.frv != null) {
            this.frv.setOnSrollToBottomListener(null);
            this.frv.setOnScrollListener(null);
            this.frv.setRecyclerListener(null);
            this.frv = null;
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
            ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (!x.isEmpty(list)) {
            this.fBw.bG(list);
        }
        this.frx.kr(z3);
        this.fry.kr(z3);
    }

    public void bF(List<String> list) {
        if (!x.isEmpty(list)) {
            this.fBw.bG(list);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements View.OnClickListener {
        private TextView fBA;
        private TextView fBB;
        private LinearLayout fBC;
        private List<String> fBD;
        private String fBF;
        private PopupWindow fBy;
        private View fBz;
        private boolean fBE = false;
        private a.InterfaceC0021a fBG = new a.InterfaceC0021a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0021a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.fBF;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.fAO = true;
                        d.this.fBr.a(cVar);
                        a.this.fBB.setText(a.this.fBF);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.fBz = view;
            this.fBA = (TextView) this.fBz.findViewById(R.id.live_num);
            this.fBB = (TextView) this.fBz.findViewById(R.id.live_sort);
            this.fBB.setVisibility(8);
            this.fBB.setOnClickListener(this);
            bgV();
        }

        public void qC(int i) {
            this.fBz.setVisibility(i);
        }

        public void qD(int i) {
            if (this.fBA != null) {
                this.fBA.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, as.numberUniformFormatExtra(i)));
                this.fBz.setVisibility(0);
            }
        }

        private boolean byb() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bG(List<String> list) {
            this.fBD = list;
            if (!x.isEmpty(this.fBD) && !this.fBE) {
                this.fBE = true;
                String str = this.fBD.get(0);
                if (!StringUtils.isNull(str)) {
                    this.fBB.setText(str);
                    this.fBB.setVisibility(0);
                }
                this.fBC = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.fBC.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ao.setBackgroundResource(this.fBC, R.drawable.bg_ala_sub_list_sort_panel);
                this.fBC.setClipChildren(true);
                this.fBC.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.fBD.size(); i++) {
                    this.fBC.addView(makeTextView(this.fBD.get(i)), layoutParams);
                    if (i != this.fBD.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ao.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.fBC.addView(view);
                    }
                }
                if (this.fBy == null) {
                    this.fBy = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.fBy.setContentView(this.fBC);
                    this.fBy.setWidth(-2);
                    this.fBy.setHeight(-2);
                    this.fBy.setAnimationStyle(16973826);
                    this.fBy.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.fBy.setOutsideTouchable(true);
                    this.fBy.setFocusable(true);
                    this.fBy.setTouchable(true);
                }
            }
        }

        private TextView makeTextView(String str) {
            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
            textView.setTextSize(0, d.this.mPageContext.getResources().getDimension(R.dimen.ds28));
            textView.setText(str);
            textView.setTag(str);
            textView.setGravity(17);
            ao.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
            ao.setViewTextColor(textView, R.color.cp_cont_d);
            textView.setOnClickListener(this);
            return textView;
        }

        private void byc() {
            if (this.fBy != null) {
                int[] iArr = new int[2];
                this.fBB.getLocationOnScreen(iArr);
                int height = ((View) this.fBB.getParent()).getHeight() - this.fBB.getHeight();
                if (iArr[1] - this.fBy.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fBy, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fBy, d.this.mRootView, 0, (iArr[0] - (this.fBB.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fBB.getHeight());
                if (this.fBy != null) {
                    this.fBy.update();
                }
            }
        }

        public void bgV() {
            ao.setViewTextColor(this.fBA, R.color.cp_cont_d);
            ao.setViewTextColor(this.fBB, R.color.cp_cont_d);
            this.fBB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.fBB) {
                byc();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.fBy != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fBy, d.this.mPageContext.getPageActivity());
                }
                if (d.this.fBr != null) {
                    this.fBF = (String) view.getTag();
                    if (this.fBF.contains("距离")) {
                        if (!byb()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.kG().a(false, this.fBG);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.fBF;
                    cVar.fAO = false;
                    d.this.fBr.a(cVar);
                    this.fBB.setText(this.fBF);
                }
            }
        }
    }
}
