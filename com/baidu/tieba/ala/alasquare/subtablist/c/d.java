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
    private BdTypeListView fbb;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fbd;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fbe;
    private PbListView fcj;
    private i fkX;
    private LinearLayout fkY;
    private View fkZ;
    private LinearLayout fla;
    private com.baidu.tbadk.k.g flb;
    private a flc;
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
        this.fla = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.fkY = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.fkZ = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.flc = new a(this.fkZ);
        this.flc.pO(8);
        this.fbb = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.afZ);
        this.fbb.setPullRefresh(this.mPullView);
        this.fcj = new PbListView(this.mPageContext.getPageActivity());
        this.fcj.createView();
        this.fbd = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.fbd.setFrom(2);
        this.fbe = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.fbe.setFrom(2);
        this.aSj.add(this.fbd);
        this.aSj.add(this.fbe);
        this.fbb.addAdapters(this.aSj);
    }

    public void pM(int i) {
        this.fkY.setVisibility(i);
    }

    public void brU() {
        if (this.fcj != null && this.fcj.getView().getParent() != null) {
            this.fbb.removeFooterView(this.fcj.getView());
        }
    }

    public void bqL() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.fbb.setNextPage(this.fcj);
            }
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fcj.endLoadData();
        }
    }

    public void pN(int i) {
        if (this.flc != null) {
            this.flc.pP(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agt != i) {
            this.agt = i;
        }
        if (this.flc != null) {
            this.flc.bbm();
        }
        if (this.flb != null) {
            this.flb.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.fcj != null) {
            this.fcj.changeSkin(i);
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
        this.fbb.completePullRefresh();
    }

    public void setData(List<o> list) {
        if (list != null && !v.isEmpty(list) && this.fbb != null) {
            this.fbb.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fbb;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.flb == null) {
                this.flb = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.flb != null) {
                this.flb.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this.mRootView);
            this.flb = null;
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

    public void bqQ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.fbb.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(i iVar) {
        this.fkX = iVar;
        if (this.fbd != null) {
            this.fbd.b(this.fkX);
        }
        if (this.fbe != null) {
            this.fbe.b(this.fkX);
        }
    }

    public void onDestroy() {
        if (this.flb != null) {
            if (this.flb.getAttachedView() != null) {
                this.flb.dettachView(this.mRootView);
            }
            this.flb.release();
            this.flb = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((f.d) null);
            this.mPullView.a((f.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.fbb != null) {
            this.fbb.setOnSrollToBottomListener(null);
            this.fbb.setOnScrollListener(null);
            this.fbb.setRecyclerListener(null);
            this.fbb = null;
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
            this.flc.bt(list);
        }
        this.fbd.jA(z3);
        this.fbe.jA(z3);
    }

    public void bs(List<String> list) {
        if (!v.isEmpty(list)) {
            this.flc.bt(list);
        }
    }

    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        private PopupWindow fle;
        private View flf;
        private TextView flg;
        private TextView flh;
        private LinearLayout fli;
        private List<String> flj;
        private String fll;
        private boolean flk = false;
        private a.InterfaceC0020a flm = new a.InterfaceC0020a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.fll;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.fku = true;
                        d.this.fkX.a(cVar);
                        a.this.flh.setText(a.this.fll);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.flf = view;
            this.flg = (TextView) this.flf.findViewById(R.id.live_num);
            this.flh = (TextView) this.flf.findViewById(R.id.live_sort);
            this.flh.setVisibility(8);
            this.flh.setOnClickListener(this);
            bbm();
        }

        public void pO(int i) {
            this.flf.setVisibility(i);
        }

        public void pP(int i) {
            if (this.flg != null) {
                this.flg.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.flf.setVisibility(0);
            }
        }

        private boolean brV() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bt(List<String> list) {
            this.flj = list;
            if (!v.isEmpty(this.flj) && !this.flk) {
                this.flk = true;
                String str = this.flj.get(0);
                if (!StringUtils.isNull(str)) {
                    this.flh.setText(str);
                    this.flh.setVisibility(0);
                }
                this.fli = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.fli.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.fli, R.drawable.bg_ala_sub_list_sort_panel);
                this.fli.setClipChildren(true);
                this.fli.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.flj.size(); i++) {
                    this.fli.addView(makeTextView(this.flj.get(i)), layoutParams);
                    if (i != this.flj.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.fli.addView(view);
                    }
                }
                if (this.fle == null) {
                    this.fle = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.fle.setContentView(this.fli);
                    this.fle.setWidth(-2);
                    this.fle.setHeight(-2);
                    this.fle.setAnimationStyle(16973826);
                    this.fle.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.fle.setOutsideTouchable(true);
                    this.fle.setFocusable(true);
                    this.fle.setTouchable(true);
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

        private void brW() {
            if (this.fle != null) {
                int[] iArr = new int[2];
                this.flh.getLocationOnScreen(iArr);
                int height = ((View) this.flh.getParent()).getHeight() - this.flh.getHeight();
                if (iArr[1] - this.fle.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fle, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.fle, d.this.mRootView, 0, (iArr[0] - (this.flh.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.flh.getHeight());
                if (this.fle != null) {
                    this.fle.update();
                }
            }
        }

        public void bbm() {
            am.setViewTextColor(this.flg, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.flh, (int) R.color.cp_cont_d);
            this.flh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.flh) {
                brW();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.fle != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.fle, d.this.mPageContext.getPageActivity());
                }
                if (d.this.fkX != null) {
                    this.fll = (String) view.getTag();
                    if (this.fll.contains("距离")) {
                        if (!brV()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.kq().a(false, this.flm);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.fll;
                    cVar.fku = false;
                    d.this.fkX.a(cVar);
                    this.flh.setText(this.fll);
                }
            }
        }
    }
}
