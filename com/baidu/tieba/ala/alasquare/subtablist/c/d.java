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
    private BdTypeListView fCT;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fCV;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fCW;
    private PbListView fEa;
    private i fMN;
    private LinearLayout fMO;
    private View fMP;
    private LinearLayout fMQ;
    private com.baidu.tbadk.k.g fMR;
    private a fMS;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int aiD = -1;
    private BdUniqueId ahM = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.fMQ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.fMO = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.fMP = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.fMS = new a(this.fMP);
        this.fMS.sO(8);
        this.fCT = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ahM);
        this.fCT.setPullRefresh(this.mPullView);
        this.fEa = new PbListView(this.mPageContext.getPageActivity());
        this.fEa.createView();
        this.fCV = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.fCV.setFrom(2);
        this.fCW = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.fCW.setFrom(2);
        this.bbw.add(this.fCV);
        this.bbw.add(this.fCW);
        this.fCT.addAdapters(this.bbw);
    }

    public void sM(int i) {
        this.fMO.setVisibility(i);
    }

    public void bHa() {
        if (this.fEa != null && this.fEa.getView().getParent() != null) {
            this.fCT.removeFooterView(this.fEa.getView());
        }
    }

    public void bFS() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.fCT.setNextPage(this.fEa);
            }
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fEa.endLoadData();
        }
    }

    public void sN(int i) {
        if (this.fMS != null) {
            this.fMS.sP(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aiD != i) {
            this.aiD = i;
        }
        if (this.fMS != null) {
            this.fMS.bpI();
        }
        if (this.fMR != null) {
            this.fMR.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.fEa != null) {
            this.fEa.changeSkin(i);
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
        this.fCT.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !y.isEmpty(list) && this.fCT != null) {
            this.fCT.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fCT;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.fMR == null) {
                this.fMR = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.fMR != null) {
                this.fMR.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this.mRootView);
            this.fMR = null;
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

    public void bFX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.fCT.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.fMN = iVar;
        if (this.fCV != null) {
            this.fCV.b(this.fMN);
        }
        if (this.fCW != null) {
            this.fCW.b(this.fMN);
        }
    }

    public void onDestroy() {
        if (this.fMR != null) {
            if (this.fMR.getAttachedView() != null) {
                this.fMR.dettachView(this.mRootView);
            }
            this.fMR.release();
            this.fMR = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.fCT != null) {
            this.fCT.setOnSrollToBottomListener(null);
            this.fCT.setOnScrollListener(null);
            this.fCT.setRecyclerListener(null);
            this.fCT = null;
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
            this.fMS.bH(list);
        }
        this.fCV.kR(z3);
        this.fCW.kR(z3);
    }

    public void bG(List<String> list) {
        if (!y.isEmpty(list)) {
            this.fMS.bH(list);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements View.OnClickListener {
        private PopupWindow fMU;
        private View fMV;
        private TextView fMW;
        private TextView fMX;
        private LinearLayout fMY;
        private List<String> fMZ;
        private String fNb;
        private boolean fNa = false;
        private a.InterfaceC0018a fNc = new a.InterfaceC0018a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.fNb;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.fMk = true;
                        d.this.fMN.a(cVar);
                        a.this.fMX.setText(a.this.fNb);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.fMV = view;
            this.fMW = (TextView) this.fMV.findViewById(R.id.live_num);
            this.fMX = (TextView) this.fMV.findViewById(R.id.live_sort);
            this.fMX.setVisibility(8);
            this.fMX.setOnClickListener(this);
            bpI();
        }

        public void sO(int i) {
            this.fMV.setVisibility(i);
        }

        public void sP(int i) {
            if (this.fMW != null) {
                this.fMW.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, at.numberUniformFormatExtra(i)));
                this.fMV.setVisibility(0);
            }
        }

        private boolean bHb() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bH(List<String> list) {
            this.fMZ = list;
            if (!y.isEmpty(this.fMZ) && !this.fNa) {
                this.fNa = true;
                String str = this.fMZ.get(0);
                if (!StringUtils.isNull(str)) {
                    this.fMX.setText(str);
                    this.fMX.setVisibility(0);
                }
                this.fMY = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.fMY.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.fMY, R.drawable.bg_ala_sub_list_sort_panel);
                this.fMY.setClipChildren(true);
                this.fMY.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.fMZ.size(); i++) {
                    this.fMY.addView(makeTextView(this.fMZ.get(i)), layoutParams);
                    if (i != this.fMZ.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.fMY.addView(view);
                    }
                }
                if (this.fMU == null) {
                    this.fMU = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.fMU.setContentView(this.fMY);
                    this.fMU.setWidth(-2);
                    this.fMU.setHeight(-2);
                    this.fMU.setAnimationStyle(16973826);
                    this.fMU.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.fMU.setOutsideTouchable(true);
                    this.fMU.setFocusable(true);
                    this.fMU.setTouchable(true);
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

        private void bHc() {
            if (this.fMU != null) {
                int[] iArr = new int[2];
                this.fMX.getLocationOnScreen(iArr);
                int height = ((View) this.fMX.getParent()).getHeight() - this.fMX.getHeight();
                if (iArr[1] - this.fMU.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMU, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fMU, d.this.mRootView, 0, (iArr[0] - (this.fMX.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fMX.getHeight());
                if (this.fMU != null) {
                    this.fMU.update();
                }
            }
        }

        public void bpI() {
            ap.setViewTextColor(this.fMW, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.fMX, (int) R.color.cp_cont_d);
            this.fMX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.fMX) {
                bHc();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.fMU != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fMU, d.this.mPageContext.getPageActivity());
                }
                if (d.this.fMN != null) {
                    this.fNb = (String) view.getTag();
                    if (this.fNb.contains("距离")) {
                        if (!bHb()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.mf().a(false, this.fNc);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.fNb;
                    cVar.fMk = false;
                    d.this.fMN.a(cVar);
                    this.fMX.setText(this.fNb);
                }
            }
        }
    }
}
