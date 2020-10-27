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
    private BdTypeListView gcr;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gct;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gcu;
    private PbListView gdy;
    private LinearLayout gmA;
    private com.baidu.tbadk.k.g gmB;
    private a gmC;
    private i gmx;
    private LinearLayout gmy;
    private View gmz;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int ajq = -1;
    private BdUniqueId aiz = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.gmA = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.gmy = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.gmz = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.gmC = new a(this.gmz);
        this.gmC.tX(8);
        this.gcr = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aiz);
        this.gcr.setPullRefresh(this.mPullView);
        this.gdy = new PbListView(this.mPageContext.getPageActivity());
        this.gdy.createView();
        this.gct = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.gct.setFrom(2);
        this.gcu = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.gcu.setFrom(2);
        this.bje.add(this.gct);
        this.bje.add(this.gcu);
        this.gcr.addAdapters(this.bje);
    }

    public void tV(int i) {
        this.gmy.setVisibility(i);
    }

    public void bNC() {
        if (this.gdy != null && this.gdy.getView().getParent() != null) {
            this.gcr.removeFooterView(this.gdy.getView());
        }
    }

    public void bMw() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.gcr.setNextPage(this.gdy);
            }
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gdy.endLoadData();
        }
    }

    public void tW(int i) {
        if (this.gmC != null) {
            this.gmC.tY(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ajq != i) {
            this.ajq = i;
        }
        if (this.gmC != null) {
            this.gmC.bvf();
        }
        if (this.gmB != null) {
            this.gmB.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.gdy != null) {
            this.gdy.changeSkin(i);
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
        this.gcr.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !y.isEmpty(list) && this.gcr != null) {
            this.gcr.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gcr;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.gmB == null) {
                this.gmB = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.gmB != null) {
                this.gmB.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this.mRootView);
            this.gmB = null;
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

    public void TK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.gcr.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.gmx = iVar;
        if (this.gct != null) {
            this.gct.b(this.gmx);
        }
        if (this.gcu != null) {
            this.gcu.b(this.gmx);
        }
    }

    public void onDestroy() {
        if (this.gmB != null) {
            if (this.gmB.getAttachedView() != null) {
                this.gmB.dettachView(this.mRootView);
            }
            this.gmB.release();
            this.gmB = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.gcr != null) {
            this.gcr.setOnSrollToBottomListener(null);
            this.gcr.setOnScrollListener(null);
            this.gcr.setRecyclerListener(null);
            this.gcr = null;
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
            this.gmC.bZ(list);
        }
        this.gct.lJ(z3);
        this.gcu.lJ(z3);
    }

    public void bY(List<String> list) {
        if (!y.isEmpty(list)) {
            this.gmC.bZ(list);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements View.OnClickListener {
        private PopupWindow gmE;
        private View gmF;
        private TextView gmG;
        private TextView gmH;
        private LinearLayout gmI;
        private List<String> gmJ;
        private String gmL;
        private boolean gmK = false;
        private a.InterfaceC0020a gmM = new a.InterfaceC0020a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gmL;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.glU = true;
                        d.this.gmx.a(cVar);
                        a.this.gmH.setText(a.this.gmL);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.gmF = view;
            this.gmG = (TextView) this.gmF.findViewById(R.id.live_num);
            this.gmH = (TextView) this.gmF.findViewById(R.id.live_sort);
            this.gmH.setVisibility(8);
            this.gmH.setOnClickListener(this);
            bvf();
        }

        public void tX(int i) {
            this.gmF.setVisibility(i);
        }

        public void tY(int i) {
            if (this.gmG != null) {
                this.gmG.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, at.numberUniformFormatExtra(i)));
                this.gmF.setVisibility(0);
            }
        }

        private boolean bND() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bZ(List<String> list) {
            this.gmJ = list;
            if (!y.isEmpty(this.gmJ) && !this.gmK) {
                this.gmK = true;
                String str = this.gmJ.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gmH.setText(str);
                    this.gmH.setVisibility(0);
                }
                this.gmI = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.gmI.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.gmI, R.drawable.bg_ala_sub_list_sort_panel);
                this.gmI.setClipChildren(true);
                this.gmI.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gmJ.size(); i++) {
                    this.gmI.addView(makeTextView(this.gmJ.get(i)), layoutParams);
                    if (i != this.gmJ.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.gmI.addView(view);
                    }
                }
                if (this.gmE == null) {
                    this.gmE = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.gmE.setContentView(this.gmI);
                    this.gmE.setWidth(-2);
                    this.gmE.setHeight(-2);
                    this.gmE.setAnimationStyle(16973826);
                    this.gmE.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.gmE.setOutsideTouchable(true);
                    this.gmE.setFocusable(true);
                    this.gmE.setTouchable(true);
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

        private void bNE() {
            if (this.gmE != null) {
                int[] iArr = new int[2];
                this.gmH.getLocationOnScreen(iArr);
                int height = ((View) this.gmH.getParent()).getHeight() - this.gmH.getHeight();
                if (iArr[1] - this.gmE.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gmE, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gmE, d.this.mRootView, 0, (iArr[0] - (this.gmH.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gmH.getHeight());
                if (this.gmE != null) {
                    this.gmE.update();
                }
            }
        }

        public void bvf() {
            ap.setViewTextColor(this.gmG, R.color.cp_cont_d);
            ap.setViewTextColor(this.gmH, R.color.cp_cont_d);
            this.gmH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gmH) {
                bNE();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.gmE != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gmE, d.this.mPageContext.getPageActivity());
                }
                if (d.this.gmx != null) {
                    this.gmL = (String) view.getTag();
                    if (this.gmL.contains("距离")) {
                        if (!bND()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.mk().a(false, this.gmM);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gmL;
                    cVar.glU = false;
                    d.this.gmx.a(cVar);
                    this.gmH.setText(this.gmL);
                }
            }
        }
    }
}
