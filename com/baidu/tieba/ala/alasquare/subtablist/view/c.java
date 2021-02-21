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
    private PbListView gAw;
    private LinearLayout gJA;
    private com.baidu.tbadk.l.g gJB;
    private a gJC;
    private g gJx;
    private LinearLayout gJy;
    private View gJz;
    private BdTypeListView gzp;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gzr;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gzs;
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
        this.gJA = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.gJy = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.gJz = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.gJC = new a(this.gJz);
        this.gJC.tU(8);
        this.gzp = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agC);
        this.gzp.setPullRefresh(this.mPullView);
        this.gAw = new PbListView(this.mPageContext.getPageActivity());
        this.gAw.createView();
        this.gzr = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.gzr.setFrom(2);
        this.gzs = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.gzs.setFrom(2);
        this.bns.add(this.gzr);
        this.bns.add(this.gzs);
        this.gzp.addAdapters(this.bns);
    }

    public void tS(int i) {
        this.gJy.setVisibility(i);
    }

    public void bSE() {
        if (this.gAw != null && this.gAw.getView().getParent() != null) {
            this.gzp.removeFooterView(this.gAw.getView());
        }
    }

    public void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gAw.endLoadData();
        }
    }

    public void tT(int i) {
        if (this.gJC != null) {
            this.gJC.tV(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ajU != i) {
            this.ajU = i;
        }
        if (this.gJC != null) {
            this.gJC.bzn();
        }
        if (this.gJB != null) {
            this.gJB.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.gAw != null) {
            this.gAw.changeSkin(i);
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
        this.gzp.completePullRefresh();
    }

    public void setData(List<n> list) {
        if (list != null && !y.isEmpty(list) && this.gzp != null) {
            this.gzp.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gzp;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.gJB == null) {
                this.gJB = new com.baidu.tbadk.l.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.gJB != null) {
                this.gJB.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.mRootView);
            this.gJB = null;
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
        this.gzp.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(g gVar) {
        this.gJx = gVar;
        if (this.gzr != null) {
            this.gzr.b(this.gJx);
        }
        if (this.gzs != null) {
            this.gzs.b(this.gJx);
        }
    }

    public void onDestroy() {
        if (this.gJB != null) {
            if (this.gJB.getAttachedView() != null) {
                this.gJB.dettachView(this.mRootView);
            }
            this.gJB.release();
            this.gJB = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.gzp != null) {
            this.gzp.setOnSrollToBottomListener(null);
            this.gzp.setOnScrollListener(null);
            this.gzp.setRecyclerListener(null);
            this.gzp = null;
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
            this.gJC.cm(list);
        }
        this.gzr.mL(z3);
        this.gzs.mL(z3);
    }

    public void cl(List<String> list) {
        if (!y.isEmpty(list)) {
            this.gJC.cm(list);
        }
    }

    /* loaded from: classes10.dex */
    private class a implements View.OnClickListener {
        private PopupWindow gJE;
        private View gJF;
        private TextView gJG;
        private TextView gJH;
        private LinearLayout gJI;
        private List<String> gJJ;
        private String gJL;
        private boolean gJK = false;
        private a.InterfaceC0015a gJM = new a.InterfaceC0015a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.c.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gJL;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.gIU = true;
                        c.this.gJx.a(cVar);
                        a.this.gJH.setText(a.this.gJL);
                    }
                } else if (!StringUtils.isNull(str)) {
                    c.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.gJF = view;
            this.gJG = (TextView) this.gJF.findViewById(R.id.live_num);
            this.gJH = (TextView) this.gJF.findViewById(R.id.live_sort);
            this.gJH.setVisibility(8);
            this.gJH.setOnClickListener(this);
            bzn();
        }

        public void tU(int i) {
            this.gJF.setVisibility(i);
        }

        public void tV(int i) {
            if (this.gJG != null) {
                this.gJG.setText(c.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, au.numberUniformFormatExtra(i)));
                this.gJF.setVisibility(0);
            }
        }

        private boolean bSF() {
            return UtilHelper.isSystemLocationProviderEnabled(c.this.mPageContext.getPageActivity());
        }

        public void cm(List<String> list) {
            this.gJJ = list;
            if (!y.isEmpty(this.gJJ) && !this.gJK) {
                this.gJK = true;
                String str = this.gJJ.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gJH.setText(str);
                    this.gJH.setVisibility(0);
                }
                this.gJI = new LinearLayout(c.this.mPageContext.getPageActivity());
                this.gJI.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ap.setBackgroundResource(this.gJI, R.drawable.bg_ala_sub_list_sort_panel);
                this.gJI.setClipChildren(true);
                this.gJI.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gJJ.size(); i++) {
                    this.gJI.addView(makeTextView(this.gJJ.get(i)), layoutParams);
                    if (i != this.gJJ.size() - 1) {
                        View view = new View(c.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, c.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ap.setBackgroundResource(view, R.color.CAM_X0204);
                        this.gJI.addView(view);
                    }
                }
                if (this.gJE == null) {
                    this.gJE = new PopupWindow(c.this.mPageContext.getPageActivity());
                    this.gJE.setContentView(this.gJI);
                    this.gJE.setWidth(-2);
                    this.gJE.setHeight(-2);
                    this.gJE.setAnimationStyle(16973826);
                    this.gJE.setBackgroundDrawable(c.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.gJE.setOutsideTouchable(true);
                    this.gJE.setFocusable(true);
                    this.gJE.setTouchable(true);
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

        private void bSG() {
            if (this.gJE != null) {
                int[] iArr = new int[2];
                this.gJH.getLocationOnScreen(iArr);
                int height = ((View) this.gJH.getParent()).getHeight() - this.gJH.getHeight();
                if (iArr[1] - this.gJE.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJE, c.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gJE, c.this.mRootView, 0, (iArr[0] - (this.gJH.getWidth() / 2)) - c.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gJH.getHeight());
                if (this.gJE != null) {
                    this.gJE.update();
                }
            }
        }

        public void bzn() {
            ap.setViewTextColor(this.gJG, R.color.CAM_X0109);
            ap.setViewTextColor(this.gJH, R.color.CAM_X0109);
            this.gJH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gJH) {
                bSG();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.gJE != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gJE, c.this.mPageContext.getPageActivity());
                }
                if (c.this.gJx != null) {
                    this.gJL = (String) view.getTag();
                    if (this.gJL.contains("距离")) {
                        if (!bSF()) {
                            c.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.lH().a(false, this.gJM);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gJL;
                    cVar.gIU = false;
                    c.this.gJx.a(cVar);
                    this.gJH.setText(this.gJL);
                }
            }
        }
    }
}
