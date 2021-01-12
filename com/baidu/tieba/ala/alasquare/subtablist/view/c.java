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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private LinearLayout gGA;
    private View gGB;
    private LinearLayout gGC;
    private com.baidu.tbadk.l.g gGD;
    private a gGE;
    private g gGz;
    private BdTypeListView gwr;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gwt;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gwu;
    private PbListView gxy;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private h refreshView;
    private final String LOCATION = "距离";
    private int akf = -1;
    private BdUniqueId agN = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.gGC = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.gGA = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.gGB = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.gGE = new a(this.gGB);
        this.gGE.tO(8);
        this.gwr = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agN);
        this.gwr.setPullRefresh(this.mPullView);
        this.gxy = new PbListView(this.mPageContext.getPageActivity());
        this.gxy.createView();
        this.gwt = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.gwt.setFrom(2);
        this.gwu = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.gwu.setFrom(2);
        this.bjZ.add(this.gwt);
        this.bjZ.add(this.gwu);
        this.gwr.addAdapters(this.bjZ);
    }

    public void tM(int i) {
        this.gGA.setVisibility(i);
    }

    public void bRU() {
        if (this.gxy != null && this.gxy.getView().getParent() != null) {
            this.gwr.removeFooterView(this.gxy.getView());
        }
    }

    public void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gxy.endLoadData();
        }
    }

    public void tN(int i) {
        if (this.gGE != null) {
            this.gGE.tP(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.akf != i) {
            this.akf = i;
        }
        if (this.gGE != null) {
            this.gGE.byV();
        }
        if (this.gGD != null) {
            this.gGD.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.gxy != null) {
            this.gxy.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void completePullRefresh() {
        this.gwr.completePullRefresh();
    }

    public void setData(List<n> list) {
        if (list != null && !x.isEmpty(list) && this.gwr != null) {
            this.gwr.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gwr;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.gGD == null) {
                this.gGD = new com.baidu.tbadk.l.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.gGD != null) {
                this.gGD.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.mRootView);
            this.gGD = null;
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

    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.gwr.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(g gVar) {
        this.gGz = gVar;
        if (this.gwt != null) {
            this.gwt.b(this.gGz);
        }
        if (this.gwu != null) {
            this.gwu.b(this.gGz);
        }
    }

    public void onDestroy() {
        if (this.gGD != null) {
            if (this.gGD.getAttachedView() != null) {
                this.gGD.dettachView(this.mRootView);
            }
            this.gGD.release();
            this.gGD = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.gwr != null) {
            this.gwr.setOnSrollToBottomListener(null);
            this.gwr.setOnScrollListener(null);
            this.gwr.setRecyclerListener(null);
            this.gwr = null;
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
            ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (!x.isEmpty(list)) {
            this.gGE.cr(list);
        }
        this.gwt.mH(z3);
        this.gwu.mH(z3);
    }

    public void cq(List<String> list) {
        if (!x.isEmpty(list)) {
            this.gGE.cr(list);
        }
    }

    /* loaded from: classes9.dex */
    private class a implements View.OnClickListener {
        private PopupWindow gGG;
        private View gGH;
        private TextView gGI;
        private TextView gGJ;
        private LinearLayout gGK;
        private List<String> gGL;
        private String gGN;
        private boolean gGM = false;
        private a.InterfaceC0015a gGO = new a.InterfaceC0015a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.c.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gGN;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.gFW = true;
                        c.this.gGz.a(cVar);
                        a.this.gGJ.setText(a.this.gGN);
                    }
                } else if (!StringUtils.isNull(str)) {
                    c.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.gGH = view;
            this.gGI = (TextView) this.gGH.findViewById(R.id.live_num);
            this.gGJ = (TextView) this.gGH.findViewById(R.id.live_sort);
            this.gGJ.setVisibility(8);
            this.gGJ.setOnClickListener(this);
            byV();
        }

        public void tO(int i) {
            this.gGH.setVisibility(i);
        }

        public void tP(int i) {
            if (this.gGI != null) {
                this.gGI.setText(c.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, at.numberUniformFormatExtra(i)));
                this.gGH.setVisibility(0);
            }
        }

        private boolean bRV() {
            return UtilHelper.isSystemLocationProviderEnabled(c.this.mPageContext.getPageActivity());
        }

        public void cr(List<String> list) {
            this.gGL = list;
            if (!x.isEmpty(this.gGL) && !this.gGM) {
                this.gGM = true;
                String str = this.gGL.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gGJ.setText(str);
                    this.gGJ.setVisibility(0);
                }
                this.gGK = new LinearLayout(c.this.mPageContext.getPageActivity());
                this.gGK.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ao.setBackgroundResource(this.gGK, R.drawable.bg_ala_sub_list_sort_panel);
                this.gGK.setClipChildren(true);
                this.gGK.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gGL.size(); i++) {
                    this.gGK.addView(makeTextView(this.gGL.get(i)), layoutParams);
                    if (i != this.gGL.size() - 1) {
                        View view = new View(c.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, c.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ao.setBackgroundResource(view, R.color.CAM_X0204);
                        this.gGK.addView(view);
                    }
                }
                if (this.gGG == null) {
                    this.gGG = new PopupWindow(c.this.mPageContext.getPageActivity());
                    this.gGG.setContentView(this.gGK);
                    this.gGG.setWidth(-2);
                    this.gGG.setHeight(-2);
                    this.gGG.setAnimationStyle(16973826);
                    this.gGG.setBackgroundDrawable(c.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.gGG.setOutsideTouchable(true);
                    this.gGG.setFocusable(true);
                    this.gGG.setTouchable(true);
                }
            }
        }

        private TextView makeTextView(String str) {
            TextView textView = new TextView(c.this.mPageContext.getPageActivity());
            textView.setTextSize(0, c.this.mPageContext.getResources().getDimension(R.dimen.ds28));
            textView.setText(str);
            textView.setTag(str);
            textView.setGravity(17);
            ao.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
            ao.setViewTextColor(textView, R.color.CAM_X0109);
            textView.setOnClickListener(this);
            return textView;
        }

        private void bRW() {
            if (this.gGG != null) {
                int[] iArr = new int[2];
                this.gGJ.getLocationOnScreen(iArr);
                int height = ((View) this.gGJ.getParent()).getHeight() - this.gGJ.getHeight();
                if (iArr[1] - this.gGG.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gGG, c.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gGG, c.this.mRootView, 0, (iArr[0] - (this.gGJ.getWidth() / 2)) - c.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gGJ.getHeight());
                if (this.gGG != null) {
                    this.gGG.update();
                }
            }
        }

        public void byV() {
            ao.setViewTextColor(this.gGI, R.color.CAM_X0109);
            ao.setViewTextColor(this.gGJ, R.color.CAM_X0109);
            this.gGJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gGJ) {
                bRW();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.gGG != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gGG, c.this.mPageContext.getPageActivity());
                }
                if (c.this.gGz != null) {
                    this.gGN = (String) view.getTag();
                    if (this.gGN.contains("距离")) {
                        if (!bRV()) {
                            c.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.lI().a(false, this.gGO);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gGN;
                    cVar.gFW = false;
                    c.this.gGz.a(cVar);
                    this.gGJ.setText(this.gGN);
                }
            }
        }
    }
}
