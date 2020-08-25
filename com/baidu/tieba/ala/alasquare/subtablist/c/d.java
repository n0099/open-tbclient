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
    private BdTypeListView fCP;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fCR;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fCS;
    private PbListView fDW;
    private i fMJ;
    private LinearLayout fMK;
    private View fML;
    private LinearLayout fMM;
    private com.baidu.tbadk.k.g fMN;
    private a fMO;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int aiB = -1;
    private BdUniqueId ahK = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.fMM = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.fMK = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.fML = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.fMO = new a(this.fML);
        this.fMO.sO(8);
        this.fCP = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ahK);
        this.fCP.setPullRefresh(this.mPullView);
        this.fDW = new PbListView(this.mPageContext.getPageActivity());
        this.fDW.createView();
        this.fCR = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.fCR.setFrom(2);
        this.fCS = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.fCS.setFrom(2);
        this.bbu.add(this.fCR);
        this.bbu.add(this.fCS);
        this.fCP.addAdapters(this.bbu);
    }

    public void sM(int i) {
        this.fMK.setVisibility(i);
    }

    public void bGZ() {
        if (this.fDW != null && this.fDW.getView().getParent() != null) {
            this.fCP.removeFooterView(this.fDW.getView());
        }
    }

    public void bFR() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.fCP.setNextPage(this.fDW);
            }
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fDW.endLoadData();
        }
    }

    public void sN(int i) {
        if (this.fMO != null) {
            this.fMO.sP(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aiB != i) {
            this.aiB = i;
        }
        if (this.fMO != null) {
            this.fMO.bpH();
        }
        if (this.fMN != null) {
            this.fMN.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.fDW != null) {
            this.fDW.changeSkin(i);
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
        this.fCP.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !y.isEmpty(list) && this.fCP != null) {
            this.fCP.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fCP;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.fMN == null) {
                this.fMN = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.fMN != null) {
                this.fMN.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this.mRootView);
            this.fMN = null;
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

    public void bFW() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.fCP.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.fMJ = iVar;
        if (this.fCR != null) {
            this.fCR.b(this.fMJ);
        }
        if (this.fCS != null) {
            this.fCS.b(this.fMJ);
        }
    }

    public void onDestroy() {
        if (this.fMN != null) {
            if (this.fMN.getAttachedView() != null) {
                this.fMN.dettachView(this.mRootView);
            }
            this.fMN.release();
            this.fMN = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.fCP != null) {
            this.fCP.setOnSrollToBottomListener(null);
            this.fCP.setOnScrollListener(null);
            this.fCP.setRecyclerListener(null);
            this.fCP = null;
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
            this.fMO.bH(list);
        }
        this.fCR.kP(z3);
        this.fCS.kP(z3);
    }

    public void bG(List<String> list) {
        if (!y.isEmpty(list)) {
            this.fMO.bH(list);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements View.OnClickListener {
        private PopupWindow fMQ;
        private View fMR;
        private TextView fMS;
        private TextView fMT;
        private LinearLayout fMU;
        private List<String> fMV;
        private String fMX;
        private boolean fMW = false;
        private a.InterfaceC0018a fMY = new a.InterfaceC0018a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.fMX;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.fMg = true;
                        d.this.fMJ.a(cVar);
                        a.this.fMT.setText(a.this.fMX);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.fMR = view;
            this.fMS = (TextView) this.fMR.findViewById(R.id.live_num);
            this.fMT = (TextView) this.fMR.findViewById(R.id.live_sort);
            this.fMT.setVisibility(8);
            this.fMT.setOnClickListener(this);
            bpH();
        }

        public void sO(int i) {
            this.fMR.setVisibility(i);
        }

        public void sP(int i) {
            if (this.fMS != null) {
                this.fMS.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, at.numberUniformFormatExtra(i)));
                this.fMR.setVisibility(0);
            }
        }

        private boolean bHa() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bH(List<String> list) {
            this.fMV = list;
            if (!y.isEmpty(this.fMV) && !this.fMW) {
                this.fMW = true;
                String str = this.fMV.get(0);
                if (!StringUtils.isNull(str)) {
                    this.fMT.setText(str);
                    this.fMT.setVisibility(0);
                }
                this.fMU = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.fMU.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.fMU, R.drawable.bg_ala_sub_list_sort_panel);
                this.fMU.setClipChildren(true);
                this.fMU.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.fMV.size(); i++) {
                    this.fMU.addView(makeTextView(this.fMV.get(i)), layoutParams);
                    if (i != this.fMV.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.fMU.addView(view);
                    }
                }
                if (this.fMQ == null) {
                    this.fMQ = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.fMQ.setContentView(this.fMU);
                    this.fMQ.setWidth(-2);
                    this.fMQ.setHeight(-2);
                    this.fMQ.setAnimationStyle(16973826);
                    this.fMQ.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.fMQ.setOutsideTouchable(true);
                    this.fMQ.setFocusable(true);
                    this.fMQ.setTouchable(true);
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
            ap.setViewTextColor(textView, (int) R.color.cp_cont_d);
            textView.setOnClickListener(this);
            return textView;
        }

        private void bHb() {
            if (this.fMQ != null) {
                int[] iArr = new int[2];
                this.fMT.getLocationOnScreen(iArr);
                int height = ((View) this.fMT.getParent()).getHeight() - this.fMT.getHeight();
                if (iArr[1] - this.fMQ.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMQ, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fMQ, d.this.mRootView, 0, (iArr[0] - (this.fMT.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fMT.getHeight());
                if (this.fMQ != null) {
                    this.fMQ.update();
                }
            }
        }

        public void bpH() {
            ap.setViewTextColor(this.fMS, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.fMT, (int) R.color.cp_cont_d);
            this.fMT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.fMT) {
                bHb();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.fMQ != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMQ, d.this.mPageContext.getPageActivity());
                }
                if (d.this.fMJ != null) {
                    this.fMX = (String) view.getTag();
                    if (this.fMX.contains("距离")) {
                        if (!bHa()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.mf().a(false, this.fMY);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.fMX;
                    cVar.fMg = false;
                    d.this.fMJ.a(cVar);
                    this.fMT.setText(this.fMX);
                }
            }
        }
    }
}
