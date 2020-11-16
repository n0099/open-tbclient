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
/* loaded from: classes4.dex */
public class d {
    private BdTypeListView ghN;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ghP;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b ghQ;
    private PbListView giV;
    private i grR;
    private LinearLayout grS;
    private View grT;
    private LinearLayout grU;
    private com.baidu.tbadk.k.g grV;
    private a grW;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int ajv = -1;
    private BdUniqueId aiE = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.grU = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.grS = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.grT = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.grW = new a(this.grT);
        this.grW.uF(8);
        this.ghN = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.aiE);
        this.ghN.setPullRefresh(this.mPullView);
        this.giV = new PbListView(this.mPageContext.getPageActivity());
        this.giV.createView();
        this.ghP = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.ghP.setFrom(2);
        this.ghQ = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.ghQ.setFrom(2);
        this.biN.add(this.ghP);
        this.biN.add(this.ghQ);
        this.ghN.addAdapters(this.biN);
    }

    public void uD(int i) {
        this.grS.setVisibility(i);
    }

    public void bPv() {
        if (this.giV != null && this.giV.getView().getParent() != null) {
            this.ghN.removeFooterView(this.giV.getView());
        }
    }

    public void bOp() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.ghN.setNextPage(this.giV);
            }
            this.giV.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.giV.endLoadData();
        }
    }

    public void uE(int i) {
        if (this.grW != null) {
            this.grW.uG(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ajv != i) {
            this.ajv = i;
        }
        if (this.grW != null) {
            this.grW.bwU();
        }
        if (this.grV != null) {
            this.grV.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.giV != null) {
            this.giV.changeSkin(i);
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
        this.ghN.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !y.isEmpty(list) && this.ghN != null) {
            this.ghN.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.ghN;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.grV == null) {
                this.grV = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.grV != null) {
                this.grV.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this.mRootView);
            this.grV = null;
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

    public void VB() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.ghN.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.grR = iVar;
        if (this.ghP != null) {
            this.ghP.b(this.grR);
        }
        if (this.ghQ != null) {
            this.ghQ.b(this.grR);
        }
    }

    public void onDestroy() {
        if (this.grV != null) {
            if (this.grV.getAttachedView() != null) {
                this.grV.dettachView(this.mRootView);
            }
            this.grV.release();
            this.grV = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.ghN != null) {
            this.ghN.setOnSrollToBottomListener(null);
            this.ghN.setOnScrollListener(null);
            this.ghN.setRecyclerListener(null);
            this.ghN = null;
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
            this.grW.cg(list);
        }
        this.ghP.lT(z3);
        this.ghQ.lT(z3);
    }

    public void cf(List<String> list) {
        if (!y.isEmpty(list)) {
            this.grW.cg(list);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements View.OnClickListener {
        private PopupWindow grY;
        private View grZ;
        private TextView gsa;
        private TextView gsb;
        private LinearLayout gsc;
        private List<String> gsd;
        private String gsf;
        private boolean gse = false;
        private a.InterfaceC0020a gsg = new a.InterfaceC0020a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gsf;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.gro = true;
                        d.this.grR.a(cVar);
                        a.this.gsb.setText(a.this.gsf);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.grZ = view;
            this.gsa = (TextView) this.grZ.findViewById(R.id.live_num);
            this.gsb = (TextView) this.grZ.findViewById(R.id.live_sort);
            this.gsb.setVisibility(8);
            this.gsb.setOnClickListener(this);
            bwU();
        }

        public void uF(int i) {
            this.grZ.setVisibility(i);
        }

        public void uG(int i) {
            if (this.gsa != null) {
                this.gsa.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, au.numberUniformFormatExtra(i)));
                this.grZ.setVisibility(0);
            }
        }

        private boolean bPw() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void cg(List<String> list) {
            this.gsd = list;
            if (!y.isEmpty(this.gsd) && !this.gse) {
                this.gse = true;
                String str = this.gsd.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gsb.setText(str);
                    this.gsb.setVisibility(0);
                }
                this.gsc = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.gsc.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.gsc, R.drawable.bg_ala_sub_list_sort_panel);
                this.gsc.setClipChildren(true);
                this.gsc.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gsd.size(); i++) {
                    this.gsc.addView(makeTextView(this.gsd.get(i)), layoutParams);
                    if (i != this.gsd.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.CAM_X0204);
                        this.gsc.addView(view);
                    }
                }
                if (this.grY == null) {
                    this.grY = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.grY.setContentView(this.gsc);
                    this.grY.setWidth(-2);
                    this.grY.setHeight(-2);
                    this.grY.setAnimationStyle(16973826);
                    this.grY.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.grY.setOutsideTouchable(true);
                    this.grY.setFocusable(true);
                    this.grY.setTouchable(true);
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

        private void bPx() {
            if (this.grY != null) {
                int[] iArr = new int[2];
                this.gsb.getLocationOnScreen(iArr);
                int height = ((View) this.gsb.getParent()).getHeight() - this.gsb.getHeight();
                if (iArr[1] - this.grY.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.grY, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.grY, d.this.mRootView, 0, (iArr[0] - (this.gsb.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gsb.getHeight());
                if (this.grY != null) {
                    this.grY.update();
                }
            }
        }

        public void bwU() {
            ap.setViewTextColor(this.gsa, R.color.CAM_X0109);
            ap.setViewTextColor(this.gsb, R.color.CAM_X0109);
            this.gsb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gsb) {
                bPx();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.grY != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.grY, d.this.mPageContext.getPageActivity());
                }
                if (d.this.grR != null) {
                    this.gsf = (String) view.getTag();
                    if (this.gsf.contains("距离")) {
                        if (!bPw()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.mk().a(false, this.gsg);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gsf;
                    cVar.gro = false;
                    d.this.grR.a(cVar);
                    this.gsb.setText(this.gsf);
                }
            }
        }
    }
}
