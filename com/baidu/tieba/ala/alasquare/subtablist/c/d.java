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
/* loaded from: classes2.dex */
public class d {
    private final String LOCATION = "距离";
    private int MH = -1;
    private BdUniqueId Mm = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private BdTypeListView efW;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a efY;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b efZ;
    private PbListView ehe;
    private i epH;
    private LinearLayout epI;
    private View epJ;
    private LinearLayout epK;
    private com.baidu.tbadk.k.g epL;
    private a epM;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.h mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.epK = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.epI = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.epJ = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.epM = new a(this.epJ);
        this.epM.oz(8);
        this.efW = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.Mm);
        this.efW.setPullRefresh(this.mPullView);
        this.ehe = new PbListView(this.mPageContext.getPageActivity());
        this.ehe.createView();
        this.efY = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.efY.setFrom(2);
        this.efZ = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.efZ.setFrom(2);
        this.apl.add(this.efY);
        this.apl.add(this.efZ);
        this.efW.addAdapters(this.apl);
    }

    public void ox(int i) {
        this.epI.setVisibility(i);
    }

    public void bbi() {
        if (this.ehe != null && this.ehe.getView().getParent() != null) {
            this.efW.removeFooterView(this.ehe.getView());
        }
    }

    public void bab() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.efW.setNextPage(this.ehe);
            }
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.ehe.endLoadData();
        }
    }

    public void oy(int i) {
        if (this.epM != null) {
            this.epM.oA(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.MH != i) {
            this.MH = i;
        }
        if (this.epM != null) {
            this.epM.aKd();
        }
        if (this.epL != null) {
            this.epL.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.ehe != null) {
            this.ehe.changeSkin(i);
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
        this.efW.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.efW != null) {
            this.efW.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.efW;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.epL == null) {
                this.epL = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.epL != null) {
                this.epL.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this.mRootView);
            this.epL = null;
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

    public void baf() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.efW.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.epH = iVar;
        if (this.efY != null) {
            this.efY.b(this.epH);
        }
        if (this.efZ != null) {
            this.efZ.b(this.epH);
        }
    }

    public void onDestroy() {
        if (this.epL != null) {
            if (this.epL.getAttachedView() != null) {
                this.epL.dettachView(this.mRootView);
            }
            this.epL.release();
            this.epL = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((g.d) null);
            this.mPullView.a((g.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.efW != null) {
            this.efW.setOnSrollToBottomListener(null);
            this.efW.setOnScrollListener(null);
            this.efW.setRecyclerListener(null);
            this.efW = null;
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
            this.epM.bo(list);
        }
        this.efY.hY(z3);
        this.efZ.hY(z3);
    }

    public void bn(List<String> list) {
        if (!v.isEmpty(list)) {
            this.epM.bo(list);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements View.OnClickListener {
        private PopupWindow epO;
        private View epP;
        private TextView epQ;
        private TextView epR;
        private LinearLayout epS;
        private List<String> epT;
        private String epV;
        private boolean epU = false;
        private a.InterfaceC0016a epW = new a.InterfaceC0016a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.epV;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.epe = true;
                        d.this.epH.a(cVar);
                        a.this.epR.setText(a.this.epV);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.epP = view;
            this.epQ = (TextView) this.epP.findViewById(R.id.live_num);
            this.epR = (TextView) this.epP.findViewById(R.id.live_sort);
            this.epR.setVisibility(8);
            this.epR.setOnClickListener(this);
            aKd();
        }

        public void oz(int i) {
            this.epP.setVisibility(i);
        }

        public void oA(int i) {
            if (this.epQ != null) {
                this.epQ.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.epP.setVisibility(0);
            }
        }

        private boolean bbj() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bo(List<String> list) {
            this.epT = list;
            if (!v.isEmpty(this.epT) && !this.epU) {
                this.epU = true;
                String str = this.epT.get(0);
                if (!StringUtils.isNull(str)) {
                    this.epR.setText(str);
                    this.epR.setVisibility(0);
                }
                this.epS = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.epS.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.epS, R.drawable.bg_ala_sub_list_sort_panel);
                this.epS.setClipChildren(true);
                this.epS.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.epT.size(); i++) {
                    this.epS.addView(makeTextView(this.epT.get(i)), layoutParams);
                    if (i != this.epT.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.epS.addView(view);
                    }
                }
                if (this.epO == null) {
                    this.epO = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.epO.setContentView(this.epS);
                    this.epO.setWidth(-2);
                    this.epO.setHeight(-2);
                    this.epO.setAnimationStyle(16973826);
                    this.epO.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.epO.setOutsideTouchable(true);
                    this.epO.setFocusable(true);
                    this.epO.setTouchable(true);
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

        private void bbk() {
            if (this.epO != null) {
                int[] iArr = new int[2];
                this.epR.getLocationOnScreen(iArr);
                int height = ((View) this.epR.getParent()).getHeight() - this.epR.getHeight();
                if (iArr[1] - this.epO.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.epO, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.epO, d.this.mRootView, 0, (iArr[0] - (this.epR.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.epR.getHeight());
                if (this.epO != null) {
                    this.epO.update();
                }
            }
        }

        public void aKd() {
            am.setViewTextColor(this.epQ, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.epR, (int) R.color.cp_cont_d);
            this.epR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.epR) {
                bbk();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.epO != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.epO, d.this.mPageContext.getPageActivity());
                }
                if (d.this.epH != null) {
                    this.epV = (String) view.getTag();
                    if (this.epV.contains("距离")) {
                        if (!bbj()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.fK().a(false, this.epW);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.epV;
                    cVar.epe = false;
                    d.this.epH.a(cVar);
                    this.epR.setText(this.epV);
                }
            }
        }
    }
}
