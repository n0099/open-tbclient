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
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private BdTypeListView faQ;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a faS;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b faT;
    private PbListView fbY;
    private i fkM;
    private LinearLayout fkN;
    private View fkO;
    private LinearLayout fkP;
    private com.baidu.tbadk.k.g fkQ;
    private a fkR;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int agt = -1;
    private BdUniqueId afZ = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.fkP = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.fkN = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.fkO = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.fkR = new a(this.fkO);
        this.fkR.pM(8);
        this.faQ = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.afZ);
        this.faQ.setPullRefresh(this.mPullView);
        this.fbY = new PbListView(this.mPageContext.getPageActivity());
        this.fbY.createView();
        this.faS = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.faS.setFrom(2);
        this.faT = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.faT.setFrom(2);
        this.aSj.add(this.faS);
        this.aSj.add(this.faT);
        this.faQ.addAdapters(this.aSj);
    }

    public void pK(int i) {
        this.fkN.setVisibility(i);
    }

    public void brS() {
        if (this.fbY != null && this.fbY.getView().getParent() != null) {
            this.faQ.removeFooterView(this.fbY.getView());
        }
    }

    public void bqJ() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.faQ.setNextPage(this.fbY);
            }
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fbY.endLoadData();
        }
    }

    public void pL(int i) {
        if (this.fkR != null) {
            this.fkR.pN(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agt != i) {
            this.agt = i;
        }
        if (this.fkR != null) {
            this.fkR.bbl();
        }
        if (this.fkQ != null) {
            this.fkQ.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.fbY != null) {
            this.fbY.changeSkin(i);
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
        this.faQ.completePullRefresh();
    }

    public void setData(List<o> list) {
        if (list != null && !v.isEmpty(list) && this.faQ != null) {
            this.faQ.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.faQ;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.fkQ == null) {
                this.fkQ = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.fkQ != null) {
                this.fkQ.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this.mRootView);
            this.fkQ = null;
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

    public void bqO() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.faQ.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.fkM = iVar;
        if (this.faS != null) {
            this.faS.b(this.fkM);
        }
        if (this.faT != null) {
            this.faT.b(this.fkM);
        }
    }

    public void onDestroy() {
        if (this.fkQ != null) {
            if (this.fkQ.getAttachedView() != null) {
                this.fkQ.dettachView(this.mRootView);
            }
            this.fkQ.release();
            this.fkQ = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.faQ != null) {
            this.faQ.setOnSrollToBottomListener(null);
            this.faQ.setOnScrollListener(null);
            this.faQ.setRecyclerListener(null);
            this.faQ = null;
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
            this.fkR.bt(list);
        }
        this.faS.jA(z3);
        this.faT.jA(z3);
    }

    public void bs(List<String> list) {
        if (!v.isEmpty(list)) {
            this.fkR.bt(list);
        }
    }

    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        private PopupWindow fkT;
        private View fkU;
        private TextView fkV;
        private TextView fkW;
        private LinearLayout fkX;
        private List<String> fkY;
        private String fla;
        private boolean fkZ = false;
        private a.InterfaceC0020a flb = new a.InterfaceC0020a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.fla;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.fkj = true;
                        d.this.fkM.a(cVar);
                        a.this.fkW.setText(a.this.fla);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.fkU = view;
            this.fkV = (TextView) this.fkU.findViewById(R.id.live_num);
            this.fkW = (TextView) this.fkU.findViewById(R.id.live_sort);
            this.fkW.setVisibility(8);
            this.fkW.setOnClickListener(this);
            bbl();
        }

        public void pM(int i) {
            this.fkU.setVisibility(i);
        }

        public void pN(int i) {
            if (this.fkV != null) {
                this.fkV.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.fkU.setVisibility(0);
            }
        }

        private boolean brT() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bt(List<String> list) {
            this.fkY = list;
            if (!v.isEmpty(this.fkY) && !this.fkZ) {
                this.fkZ = true;
                String str = this.fkY.get(0);
                if (!StringUtils.isNull(str)) {
                    this.fkW.setText(str);
                    this.fkW.setVisibility(0);
                }
                this.fkX = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.fkX.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.fkX, R.drawable.bg_ala_sub_list_sort_panel);
                this.fkX.setClipChildren(true);
                this.fkX.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.fkY.size(); i++) {
                    this.fkX.addView(makeTextView(this.fkY.get(i)), layoutParams);
                    if (i != this.fkY.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.fkX.addView(view);
                    }
                }
                if (this.fkT == null) {
                    this.fkT = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.fkT.setContentView(this.fkX);
                    this.fkT.setWidth(-2);
                    this.fkT.setHeight(-2);
                    this.fkT.setAnimationStyle(16973826);
                    this.fkT.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.fkT.setOutsideTouchable(true);
                    this.fkT.setFocusable(true);
                    this.fkT.setTouchable(true);
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

        private void brU() {
            if (this.fkT != null) {
                int[] iArr = new int[2];
                this.fkW.getLocationOnScreen(iArr);
                int height = ((View) this.fkW.getParent()).getHeight() - this.fkW.getHeight();
                if (iArr[1] - this.fkT.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fkT, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fkT, d.this.mRootView, 0, (iArr[0] - (this.fkW.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fkW.getHeight());
                if (this.fkT != null) {
                    this.fkT.update();
                }
            }
        }

        public void bbl() {
            am.setViewTextColor(this.fkV, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fkW, (int) R.color.cp_cont_d);
            this.fkW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.fkW) {
                brU();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.fkT != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fkT, d.this.mPageContext.getPageActivity());
                }
                if (d.this.fkM != null) {
                    this.fla = (String) view.getTag();
                    if (this.fla.contains("距离")) {
                        if (!brT()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.kq().a(false, this.flb);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.fla;
                    cVar.fkj = false;
                    d.this.fkM.a(cVar);
                    this.fkW.setText(this.fla);
                }
            }
        }
    }
}
