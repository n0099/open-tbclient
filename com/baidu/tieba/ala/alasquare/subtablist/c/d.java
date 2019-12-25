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
    private int MA = -1;
    private BdUniqueId Mh = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private BdTypeListView efM;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a efO;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b efP;
    private PbListView egU;
    private h eou;
    private LinearLayout eov;
    private View eow;
    private LinearLayout eox;
    private com.baidu.tbadk.k.g eoy;
    private a eoz;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.h mPullView;
    private LinearLayout mRootView;
    private com.baidu.tbadk.k.h refreshView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.eox = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.eov = (LinearLayout) this.mRootView.findViewById(R.id.liveListLinearLayout);
        this.eow = this.mRootView.findViewById(R.id.sub_list_top_info);
        this.eoz = new a(this.eow);
        this.eoz.oy(8);
        this.efM = (BdTypeListView) this.mRootView.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.Mh);
        this.efM.setPullRefresh(this.mPullView);
        this.egU = new PbListView(this.mPageContext.getPageActivity());
        this.egU.createView();
        this.efO = new com.baidu.tieba.ala.alasquare.subtablist.a.a(this.mPageContext);
        this.efO.setFrom(2);
        this.efP = new com.baidu.tieba.ala.alasquare.subtablist.a.b(this.mPageContext);
        this.efP.setFrom(2);
        this.aoz.add(this.efO);
        this.aoz.add(this.efP);
        this.efM.addAdapters(this.aoz);
    }

    public void ow(int i) {
        this.eov.setVisibility(i);
    }

    public void baN() {
        if (this.egU != null && this.egU.getView().getParent() != null) {
            this.efM.removeFooterView(this.egU.getView());
        }
    }

    public void aZG() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.efM.setNextPage(this.egU);
            }
            this.egU.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.egU.endLoadData();
        }
    }

    public void ox(int i) {
        if (this.eoz != null) {
            this.eoz.oz(i);
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.MA != i) {
            this.MA = i;
        }
        if (this.eoz != null) {
            this.eoz.aJJ();
        }
        if (this.eoy != null) {
            this.eoy.onChangeSkinType();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(tbPageContext, i);
        }
        if (this.egU != null) {
            this.egU.changeSkin(i);
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
        this.efM.completePullRefresh();
    }

    public void setData(List<m> list) {
        if (list != null && !v.isEmpty(list) && this.efM != null) {
            this.efM.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.efM;
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            if (this.eoy == null) {
                this.eoy = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (this.eoy != null) {
                this.eoy.attachView(this.mRootView, true);
            }
        }
    }

    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this.mRootView);
            this.eoy = null;
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

    public void aZK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void b(BdListView.e eVar) {
        this.efM.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(h hVar) {
        this.eou = hVar;
        if (this.efO != null) {
            this.efO.b(this.eou);
        }
        if (this.efP != null) {
            this.efP.b(this.eou);
        }
    }

    public void onDestroy() {
        if (this.eoy != null) {
            if (this.eoy.getAttachedView() != null) {
                this.eoy.dettachView(this.mRootView);
            }
            this.eoy.release();
            this.eoy = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.a((g.d) null);
            this.mPullView.a((g.b) null);
            this.mPullView.release();
            this.mPullView = null;
        }
        if (this.efM != null) {
            this.efM.setOnSrollToBottomListener(null);
            this.efM.setOnScrollListener(null);
            this.efM.setRecyclerListener(null);
            this.efM = null;
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
            this.eoz.bo(list);
        }
        this.efO.hO(z3);
        this.efP.hO(z3);
    }

    public void bn(List<String> list) {
        if (!v.isEmpty(list)) {
            this.eoz.bo(list);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements View.OnClickListener {
        private PopupWindow eoB;
        private View eoC;
        private TextView eoD;
        private TextView eoE;
        private LinearLayout eoF;
        private List<String> eoG;
        private String eoI;
        private boolean eoH = false;
        private a.InterfaceC0016a eoJ = new a.InterfaceC0016a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.d.a.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude != 0.0d && longitude != 0.0d) {
                        com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                        cVar.type = a.this.eoI;
                        cVar.lat = String.valueOf(latitude);
                        cVar.lng = String.valueOf(longitude);
                        cVar.enQ = true;
                        d.this.eou.a(cVar);
                        a.this.eoE.setText(a.this.eoI);
                    }
                } else if (!StringUtils.isNull(str)) {
                    d.this.mPageContext.showToast(str);
                }
            }
        };

        public a(View view) {
            this.eoC = view;
            this.eoD = (TextView) this.eoC.findViewById(R.id.live_num);
            this.eoE = (TextView) this.eoC.findViewById(R.id.live_sort);
            this.eoE.setVisibility(8);
            this.eoE.setOnClickListener(this);
            aJJ();
        }

        public void oy(int i) {
            this.eoC.setVisibility(i);
        }

        public void oz(int i) {
            if (this.eoD != null) {
                this.eoD.setText(d.this.mPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_num, aq.numberUniformFormatExtra(i)));
                this.eoC.setVisibility(0);
            }
        }

        private boolean baO() {
            return UtilHelper.isSystemLocationProviderEnabled(d.this.mPageContext.getPageActivity());
        }

        public void bo(List<String> list) {
            this.eoG = list;
            if (!v.isEmpty(this.eoG) && !this.eoH) {
                this.eoH = true;
                String str = this.eoG.get(0);
                if (!StringUtils.isNull(str)) {
                    this.eoE.setText(str);
                    this.eoE.setVisibility(0);
                }
                this.eoF = new LinearLayout(d.this.mPageContext.getPageActivity());
                this.eoF.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                am.setBackgroundResource(this.eoF, R.drawable.bg_ala_sub_list_sort_panel);
                this.eoF.setClipChildren(true);
                this.eoF.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds176), d.this.mPageContext.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i = 0; i < this.eoG.size(); i++) {
                    this.eoF.addView(makeTextView(this.eoG.get(i)), layoutParams);
                    if (i != this.eoG.size() - 1) {
                        View view = new View(d.this.mPageContext.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        am.setBackgroundResource(view, R.color.cp_bg_line_c);
                        this.eoF.addView(view);
                    }
                }
                if (this.eoB == null) {
                    this.eoB = new PopupWindow(d.this.mPageContext.getPageActivity());
                    this.eoB.setContentView(this.eoF);
                    this.eoB.setWidth(-2);
                    this.eoB.setHeight(-2);
                    this.eoB.setAnimationStyle(16973826);
                    this.eoB.setBackgroundDrawable(d.this.mPageContext.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.eoB.setOutsideTouchable(true);
                    this.eoB.setFocusable(true);
                    this.eoB.setTouchable(true);
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

        private void baP() {
            if (this.eoB != null) {
                int[] iArr = new int[2];
                this.eoE.getLocationOnScreen(iArr);
                int height = ((View) this.eoE.getParent()).getHeight() - this.eoE.getHeight();
                if (iArr[1] - this.eoB.getHeight() <= 50) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eoB, d.this.mPageContext.getPageActivity());
                    return;
                }
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.eoB, d.this.mRootView, 0, (iArr[0] - (this.eoE.getWidth() / 2)) - d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24), height + iArr[1] + this.eoE.getHeight());
                if (this.eoB != null) {
                    this.eoB.update();
                }
            }
        }

        public void aJJ() {
            am.setViewTextColor(this.eoD, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eoE, (int) R.color.cp_cont_d);
            this.eoE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.eoE) {
                baP();
            } else if ((view instanceof TextView) && view.getTag() != null && (view.getTag() instanceof String) && !StringUtils.isNull((String) view.getTag())) {
                if (this.eoB != null) {
                    com.baidu.adp.lib.f.g.dismissPopupWindow(this.eoB, d.this.mPageContext.getPageActivity());
                }
                if (d.this.eou != null) {
                    this.eoI = (String) view.getTag();
                    if (this.eoI.contains("距离")) {
                        if (!baO()) {
                            d.this.mPageContext.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            com.baidu.adp.lib.c.a.fK().a(false, this.eoJ);
                            return;
                        }
                    }
                    com.baidu.tieba.ala.alasquare.subtablist.b.c cVar = new com.baidu.tieba.ala.alasquare.subtablist.b.c();
                    cVar.type = this.eoI;
                    cVar.enQ = false;
                    d.this.eou.a(cVar);
                    this.eoE.setText(this.eoI);
                }
            }
        }
    }
}
