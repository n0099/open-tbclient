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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private BdTypeListView fml;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fmn;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fmo;
    private PbListView fnt;
    private i fwk;
    private LinearLayout fwl;
    private View fwm;
    private LinearLayout fwn;
    private com.baidu.tbadk.k.g fwo;
    private a fwp;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private final String LOCATION = "距离";
    private int ahx = -1;
    private BdUniqueId agK = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.fwn = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.fwl = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.fwm = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.fwp = new a(this.fwm);
        this.fwp.qn(8);
        this.fml = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.agK);
        this.fml.setPullRefresh(this.mPullView);
        this.fnt = new PbListView(this.mPageContext.getPageActivity());
        this.fnt.createView();
        this.fmn = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.fmn.setFrom(2);
        this.fmo = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.fmo.setFrom(2);
        this.aUP.add(this.fmn);
        this.aUP.add(this.fmo);
        this.fml.addAdapters(this.aUP);
    }

    public void ql(int i) {
        this.fwl.setVisibility(i);
    }

    public void buQ() {
        if (this.fnt != null && this.fnt.getView().getParent() != null) {
            this.fml.removeFooterView(this.fnt.getView());
        }
    }

    public void btI() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.fml.setNextPage(this.fnt);
            }
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fnt.endLoadData();
        }
    }

    public void qm(int i) {
        if (this.fwp != null) {
            this.fwp.qo(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahx != i) {
            this.ahx = i;
        }
        if (this.fwp != null) {
            this.fwp.bdo();
        }
        if (this.fwo != null) {
            this.fwo.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.fnt != null) {
            this.fnt.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        an.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void completePullRefresh() {
        this.fml.completePullRefresh();
    }

    public void setData(List<q> list) {
        if (list != null && !w.isEmpty(list) && this.fml != null) {
            this.fml.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fml;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.fwo == null) {
                this.fwo = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.fwo != null) {
                this.fwo.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this.mRootView);
            this.fwo = null;
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

    public void btN() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.fml.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.fwk = iVar;
        if (this.fmn != null) {
            this.fmn.b(this.fwk);
        }
        if (this.fmo != null) {
            this.fmo.b(this.fwk);
        }
    }

    public void onDestroy() {
        if (this.fwo != null) {
            if (this.fwo.getAttachedView() != null) {
                this.fwo.dettachView(this.mRootView);
            }
            this.fwo.release();
            this.fwo = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.fml != null) {
            this.fml.setOnSrollToBottomListener(null);
            this.fml.setOnScrollListener(null);
            this.fml.setRecyclerListener(null);
            this.fml = null;
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
            an.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (!w.isEmpty(list)) {
            this.fwp.bC(list);
        }
        this.fmn.jN(z3);
        this.fmo.jN(z3);
    }

    public void bB(List<String> list) {
        if (!w.isEmpty(list)) {
            this.fwp.bC(list);
        }
    }

    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        private PopupWindow fwr;
        private View fws;
        private TextView fwt;
        private TextView fwu;
        private LinearLayout fwv;
        private List<String> fww;
        private String fwy;
        private boolean fwx = false;
        private a.InterfaceC0020a fwz = new a.InterfaceC0020a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.fwy;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.fvH = true;
                        d.this.fwk.a(cVar);
                        a.this.fwu.setText(a.this.fwy);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.fws = view;
            this.fwt = (TextView) this.fws.findViewById(R.id.live_num);
            this.fwu = (TextView) this.fws.findViewById(R.id.live_sort);
            this.fwu.setVisibility(8);
            this.fwu.setOnClickListener(this);
            bdo();
        }

        public void qn(int i) {
            this.fws.setVisibility(i);
        }

        public void qo(int i) {
            if (this.fwt != null) {
                this.fwt.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, ar.numberUniformFormatExtra(i)));
                this.fws.setVisibility(0);
            }
        }

        private boolean buR() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bC(List<String> list) {
            this.fww = list;
            if (!w.isEmpty(this.fww) && !this.fwx) {
                this.fwx = true;
                String str = this.fww.get(0);
                if (!StringUtils.isNull(str)) {
                    this.fwu.setText(str);
                    this.fwu.setVisibility(0);
                }
                this.fwv = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.fwv.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                an.setBackgroundResource(this.fwv, R.drawable.bg_ala_sub_list_sort_panel);
                this.fwv.setClipChildren(true);
                this.fwv.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.fww.size(); i++) {
                    this.fwv.addView(makeTextView(this.fww.get(i)), layoutParams);
                    if (i != this.fww.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        an.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.fwv.addView(view);
                    }
                }
                if (this.fwr == null) {
                    this.fwr = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.fwr.setContentView(this.fwv);
                    this.fwr.setWidth(-2);
                    this.fwr.setHeight(-2);
                    this.fwr.setAnimationStyle(16973826);
                    this.fwr.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.fwr.setOutsideTouchable(true);
                    this.fwr.setFocusable(true);
                    this.fwr.setTouchable(true);
                }
            }
        }

        private TextView makeTextView(String str) {
            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
            textView.setTextSize(0, d.this.mPageContext.getResources().getDimension(R.dimen.ds28));
            textView.setText(str);
            textView.setTag(str);
            textView.setGravity(17);
            an.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
            an.setViewTextColor(textView, (int) R.color.cp_cont_d);
            textView.setOnClickListener(this);
            return textView;
        }

        private void buS() {
            if (this.fwr != null) {
                int[] iArr = new int[2];
                this.fwu.getLocationOnScreen(iArr);
                int height = ((View) this.fwu.getParent()).getHeight() - this.fwu.getHeight();
                if (iArr[1] - this.fwr.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fwr, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fwr, d.this.mRootView, 0, (iArr[0] - (this.fwu.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.fwu.getHeight());
                if (this.fwr != null) {
                    this.fwr.update();
                }
            }
        }

        public void bdo() {
            an.setViewTextColor(this.fwt, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.fwu, (int) R.color.cp_cont_d);
            this.fwu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.fwu) {
                buS();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.fwr != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fwr, d.this.mPageContext.getPageActivity());
                }
                if (d.this.fwk != null) {
                    this.fwy = (String) view.getTag();
                    if (this.fwy.contains("距离")) {
                        if (!buR()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.kG().a(false, this.fwz);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.fwy;
                    cVar.fvH = false;
                    d.this.fwk.a(cVar);
                    this.fwu.setText(this.fwy);
                }
            }
        }
    }
}
