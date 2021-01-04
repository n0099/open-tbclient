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
/* loaded from: classes10.dex */
public class c {
    private BdTypeListView gAY;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gBa;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gBb;
    private PbListView gCf;
    private g gLf;
    private LinearLayout gLg;
    private View gLh;
    private LinearLayout gLi;
    private com.baidu.tbadk.l.g gLj;
    private a gLk;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private h refreshView;
    private final String LOCATION = "距离";
    private int akW = -1;
    private BdUniqueId ahE = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.gLi = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.gLg = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.gLh = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.gLk = new a(this.gLh);
        this.gLk.vu(8);
        this.gAY = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.ahE);
        this.gAY.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gBa = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.gBa.setFrom(2);
        this.gBb = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.gBb.setFrom(2);
        this.boM.add(this.gBa);
        this.boM.add(this.gBb);
        this.gAY.addAdapters(this.boM);
    }

    public void vs(int i) {
        this.gLg.setVisibility(i);
    }

    public void bVL() {
        if (this.gCf != null && this.gCf.getView().getParent() != null) {
            this.gAY.removeFooterView(this.gCf.getView());
        }
    }

    public void bUD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    public void vt(int i) {
        if (this.gLk != null) {
            this.gLk.vv(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.akW != i) {
            this.akW = i;
        }
        if (this.gLk != null) {
            this.gLk.bCO();
        }
        if (this.gLj != null) {
            this.gLj.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
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
        this.gAY.completePullRefresh();
    }

    public void setData(List<n> list) {
        if (list != null && !x.isEmpty(list) && this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gAY;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.gLj == null) {
                this.gLj = new com.baidu.tbadk.l.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.gLj != null) {
                this.gLj.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.mRootView);
            this.gLj = null;
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

    public void Zi() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.gAY.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(g gVar) {
        this.gLf = gVar;
        if (this.gBa != null) {
            this.gBa.b(this.gLf);
        }
        if (this.gBb != null) {
            this.gBb.b(this.gLf);
        }
    }

    public void onDestroy() {
        if (this.gLj != null) {
            if (this.gLj.getAttachedView() != null) {
                this.gLj.dettachView(this.mRootView);
            }
            this.gLj.release();
            this.gLj = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.gAY != null) {
            this.gAY.setOnSrollToBottomListener(null);
            this.gAY.setOnScrollListener(null);
            this.gAY.setRecyclerListener(null);
            this.gAY = null;
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
            this.gLk.cr(list);
        }
        this.gBa.mL(z3);
        this.gBb.mL(z3);
    }

    public void cq(List<String> list) {
        if (!x.isEmpty(list)) {
            this.gLk.cr(list);
        }
    }

    /* loaded from: classes10.dex */
    private class a implements View.OnClickListener {
        private PopupWindow gLm;
        private View gLn;
        private TextView gLo;
        private TextView gLp;
        private LinearLayout gLq;
        private List<String> gLr;
        private String gLt;
        private boolean gLs = false;
        private a.InterfaceC0015a gLu = new a.InterfaceC0015a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.c.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.gLt;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.gKC = true;
                        c.this.gLf.a(cVar);
                        a.this.gLp.setText(a.this.gLt);
                    }
                } else if (!StringUtils.isNull(str)) {
                    c.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.gLn = view;
            this.gLo = (TextView) this.gLn.findViewById(R.id.live_num);
            this.gLp = (TextView) this.gLn.findViewById(R.id.live_sort);
            this.gLp.setVisibility(8);
            this.gLp.setOnClickListener(this);
            bCO();
        }

        public void vu(int i) {
            this.gLn.setVisibility(i);
        }

        public void vv(int i) {
            if (this.gLo != null) {
                this.gLo.setText(c.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, at.numberUniformFormatExtra(i)));
                this.gLn.setVisibility(0);
            }
        }

        private boolean bVM() {
            return UtilHelper.isSystemLocationProviderEnabled(c.this.mPageContext.getPageActivity());
        }

        public void cr(List<String> list) {
            this.gLr = list;
            if (!x.isEmpty(this.gLr) && !this.gLs) {
                this.gLs = true;
                String str = this.gLr.get(0);
                if (!StringUtils.isNull(str)) {
                    this.gLp.setText(str);
                    this.gLp.setVisibility(0);
                }
                this.gLq = new LinearLayout(c.this.mPageContext.getPageActivity());
                this.gLq.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ao.setBackgroundResource(this.gLq, R.drawable.bg_ala_sub_list_sort_panel);
                this.gLq.setClipChildren(true);
                this.gLq.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), c.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.gLr.size(); i++) {
                    this.gLq.addView(makeTextView(this.gLr.get(i)), layoutParams);
                    if (i != this.gLr.size() - 1) {
                        View view = new View(c.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, c.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        ao.setBackgroundResource(view, R.color.CAM_X0204);
                        this.gLq.addView(view);
                    }
                }
                if (this.gLm == null) {
                    this.gLm = new PopupWindow(c.this.mPageContext.getPageActivity());
                    this.gLm.setContentView(this.gLq);
                    this.gLm.setWidth(-2);
                    this.gLm.setHeight(-2);
                    this.gLm.setAnimationStyle(16973826);
                    this.gLm.setBackgroundDrawable(c.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.gLm.setOutsideTouchable(true);
                    this.gLm.setFocusable(true);
                    this.gLm.setTouchable(true);
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

        private void bVN() {
            if (this.gLm != null) {
                int[] iArr = new int[2];
                this.gLp.getLocationOnScreen(iArr);
                int height = ((View) this.gLp.getParent()).getHeight() - this.gLp.getHeight();
                if (iArr[1] - this.gLm.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLm, c.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.gLm, c.this.mRootView, 0, (iArr[0] - (this.gLp.getWidth() / 2)) - c.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.gLp.getHeight());
                if (this.gLm != null) {
                    this.gLm.update();
                }
            }
        }

        public void bCO() {
            ao.setViewTextColor(this.gLo, R.color.CAM_X0109);
            ao.setViewTextColor(this.gLp, R.color.CAM_X0109);
            this.gLp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gLp) {
                bVN();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.gLm != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.gLm, c.this.mPageContext.getPageActivity());
                }
                if (c.this.gLf != null) {
                    this.gLt = (String) view.getTag();
                    if (this.gLt.contains("距离")) {
                        if (!bVM()) {
                            c.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.lI().a(false, this.gLu);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.gLt;
                    cVar.gKC = false;
                    c.this.gLf.a(cVar);
                    this.gLp.setText(this.gLt);
                }
            }
        }
    }
}
