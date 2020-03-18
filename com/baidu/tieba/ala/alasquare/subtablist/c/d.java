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
    private BdTypeListView ekE;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ekG;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b ekH;
    private PbListView elM;
    private i euC;
    private LinearLayout euD;
    private View euE;
    private LinearLayout euF;
    private com.baidu.tbadk.k.g euG;
    private a euH;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.h mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int Nj = -1;
    private BdUniqueId MP = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.euF = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.euD = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.euE = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.euH = new a(this.euE);
        this.euH.oS(8);
        this.ekE = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.MP);
        this.ekE.setPullRefresh(this.mPullView);
        this.elM = new PbListView(this.mPageContext.getPageActivity());
        this.elM.createView();
        this.ekG = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.ekG.setFrom(2);
        this.ekH = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.ekH.setFrom(2);
        this.asP.add(this.ekG);
        this.asP.add(this.ekH);
        this.ekE.addAdapters(this.asP);
    }

    public void oQ(int i) {
        this.euD.setVisibility(i);
    }

    public void bdF() {
        if (this.elM != null && this.elM.getView().getParent() != null) {
            this.ekE.removeFooterView(this.elM.getView());
        }
    }

    public void bcy() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.ekE.setNextPage(this.elM);
            }
            this.elM.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.elM.endLoadData();
        }
    }

    public void oR(int i) {
        if (this.euH != null) {
            this.euH.oT(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Nj != i) {
            this.Nj = i;
        }
        if (this.euH != null) {
            this.euH.aMG();
        }
        if (this.euG != null) {
            this.euG.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.elM != null) {
            this.elM.changeSkin(i);
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
        this.ekE.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.ekE != null) {
            this.ekE.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.ekE;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.euG == null) {
                this.euG = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.euG != null) {
                this.euG.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this.mRootView);
            this.euG = null;
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

    public void bcC() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.ekE.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.euC = iVar;
        if (this.ekG != null) {
            this.ekG.b(this.euC);
        }
        if (this.ekH != null) {
            this.ekH.b(this.euC);
        }
    }

    public void onDestroy() {
        if (this.euG != null) {
            if (this.euG.getAttachedView() != null) {
                this.euG.dettachView(this.mRootView);
            }
            this.euG.release();
            this.euG = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((g.d) null);
            this.mPullView.a((g.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.ekE != null) {
            this.ekE.setOnSrollToBottomListener(null);
            this.ekE.setOnScrollListener(null);
            this.ekE.setRecyclerListener(null);
            this.ekE = null;
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
            this.euH.bo(list);
        }
        this.ekG.ih(z3);
        this.ekH.ih(z3);
    }

    public void bn(List<String> list) {
        if (!v.isEmpty(list)) {
            this.euH.bo(list);
        }
    }

    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        private PopupWindow euJ;
        private View euK;
        private TextView euL;
        private TextView euM;
        private LinearLayout euN;
        private List<String> euO;
        private String euQ;
        private boolean euP = false;
        private a.InterfaceC0016a euR = new a.InterfaceC0016a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.euQ;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.etZ = true;
                        d.this.euC.a(cVar);
                        a.this.euM.setText(a.this.euQ);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.euK = view;
            this.euL = (TextView) this.euK.findViewById(R.id.live_num);
            this.euM = (TextView) this.euK.findViewById(R.id.live_sort);
            this.euM.setVisibility(8);
            this.euM.setOnClickListener(this);
            aMG();
        }

        public void oS(int i) {
            this.euK.setVisibility(i);
        }

        public void oT(int i) {
            if (this.euL != null) {
                this.euL.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.euK.setVisibility(0);
            }
        }

        private boolean bdG() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bo(List<String> list) {
            this.euO = list;
            if (!v.isEmpty(this.euO) && !this.euP) {
                this.euP = true;
                String str = this.euO.get(0);
                if (!StringUtils.isNull(str)) {
                    this.euM.setText(str);
                    this.euM.setVisibility(0);
                }
                this.euN = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.euN.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.euN, R.drawable.bg_ala_sub_list_sort_panel);
                this.euN.setClipChildren(true);
                this.euN.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.euO.size(); i++) {
                    this.euN.addView(makeTextView(this.euO.get(i)), layoutParams);
                    if (i != this.euO.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.euN.addView(view);
                    }
                }
                if (this.euJ == null) {
                    this.euJ = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.euJ.setContentView(this.euN);
                    this.euJ.setWidth(-2);
                    this.euJ.setHeight(-2);
                    this.euJ.setAnimationStyle(16973826);
                    this.euJ.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.euJ.setOutsideTouchable(true);
                    this.euJ.setFocusable(true);
                    this.euJ.setTouchable(true);
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

        private void bdH() {
            if (this.euJ != null) {
                int[] iArr = new int[2];
                this.euM.getLocationOnScreen(iArr);
                int height = ((View) this.euM.getParent()).getHeight() - this.euM.getHeight();
                if (iArr[1] - this.euJ.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.euJ, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.euJ, d.this.mRootView, 0, (iArr[0] - (this.euM.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.euM.getHeight());
                if (this.euJ != null) {
                    this.euJ.update();
                }
            }
        }

        public void aMG() {
            am.setViewTextColor(this.euL, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.euM, (int) R.color.cp_cont_d);
            this.euM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.euM) {
                bdH();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.euJ != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.euJ, d.this.mPageContext.getPageActivity());
                }
                if (d.this.euC != null) {
                    this.euQ = (String) view.getTag();
                    if (this.euQ.contains("距离")) {
                        if (!bdG()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.fK().a(false, this.euR);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.euQ;
                    cVar.etZ = false;
                    d.this.euC.a(cVar);
                    this.euM.setText(this.euQ);
                }
            }
        }
    }
}
