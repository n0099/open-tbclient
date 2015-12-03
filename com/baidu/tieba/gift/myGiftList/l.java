package com.baidu.tieba.gift.myGiftList;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<MyGiftListActivity> {
    private View.OnClickListener afa;
    private NavigationBar bli;
    private AdapterView.OnItemClickListener bmU;
    private MyGiftListActivity bwC;
    private NoNetworkView bwN;
    private BdListView bwO;
    private View bwP;
    private View bwQ;
    private View bwR;
    private BdListView.e bwS;
    private TextView bwT;
    private TextView bwU;
    private TextView bwV;
    private TextView bwW;
    private String bwX;
    private String bwY;
    private h bwZ;
    private RelativeLayout bxa;
    private TextView bxb;
    private View bxc;
    private View mFooterView;
    private boolean mIsHost;
    private s mPullView;

    public l(MyGiftListActivity myGiftListActivity, BdListView.e eVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.mPullView = null;
        this.bmU = new m(this);
        this.afa = new n(this);
        this.bwC = myGiftListActivity;
        this.mIsHost = z;
        this.bwS = eVar;
        initView();
        Tw();
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.bxa.setVisibility(8);
        } else {
            this.bxa.setVisibility(0);
        }
    }

    private void initView() {
        this.bwC.setContentView(n.g.my_gift_list_activity);
        this.bwX = null;
        this.bwP = this.bwC.findViewById(n.f.root);
        this.bwO = (BdListView) this.bwP.findViewById(n.f.list_view);
        this.bli = (NavigationBar) this.bwP.findViewById(n.f.navigation_bar);
        String format = String.format(this.bwC.getPageContext().getString(n.i.he_gift_title), this.bwC.Tv());
        if (this.mIsHost) {
            this.bli.setTitleText(n.i.my_gift_list);
        } else {
            this.bli.setTitleText(format);
        }
        this.bli.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bwN = (NoNetworkView) this.bwP.findViewById(n.f.no_networkview);
        this.bwQ = LayoutInflater.from(this.bwC.getPageContext().getPageActivity()).inflate(n.g.my_gift_list_head, (ViewGroup) null, false);
        this.bwQ.setVisibility(8);
        this.bwT = (TextView) this.bwQ.findViewById(n.f.textview_gift_number);
        this.bwU = (TextView) this.bwQ.findViewById(n.f.textview_tdou_number);
        this.bwV = (TextView) this.bwQ.findViewById(n.f.view_left_tdou_tip);
        this.bwW = (TextView) this.bwQ.findViewById(n.f.view_get_tdou);
        this.bwV.setOnClickListener(this.afa);
        this.bwW.setOnClickListener(this.afa);
        this.mFooterView = LayoutInflater.from(this.bwC.getPageContext().getPageActivity()).inflate(n.g.my_gift_list_footer, (ViewGroup) null, false);
        this.bwR = this.mFooterView.findViewById(n.f.gift_footer_lay);
        if (this.mIsHost) {
            this.bwO.addHeaderView(this.bwQ);
        } else if (TbadkApplication.getInst().isGiftSwitchOn()) {
            this.mFooterView.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.d(this.bwC.getPageContext().getPageActivity(), n.d.ds156));
        }
        this.bwO.addFooterView(this.mFooterView);
        this.bwZ = new h(this.bwC, this.mIsHost);
        this.bwO.setAdapter((ListAdapter) this.bwZ);
        this.mPullView = new s(this.bwC.getPageContext());
        this.bwO.setPullRefresh(this.mPullView);
        this.bwO.setOnSrollToBottomListener(this.bwS);
        this.bwO.setOnItemClickListener(this.bmU);
    }

    private void Tw() {
        this.bxa = (RelativeLayout) this.bwC.findViewById(n.f.gift_relation_ll);
        this.bxb = (TextView) this.bwC.findViewById(n.f.gift_relation_text);
        this.bxb.setOnClickListener(this.bwC.Tt());
        this.bxc = this.bwC.findViewById(n.f.his_gift_line);
        if (!this.mIsHost && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.bwO.setOnScrollListener(new o(this));
        }
    }

    public View getFooterView() {
        return this.bwR;
    }

    public void b(a aVar) {
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.bxa.setVisibility(8);
        } else {
            this.bxa.setVisibility(0);
        }
        c(aVar);
        d(aVar);
    }

    private void c(a aVar) {
        if (aVar == null || !this.mIsHost) {
            this.bwQ.setVisibility(8);
            return;
        }
        this.bwQ.setVisibility(0);
        if (aVar.Ts() == null || StringUtils.isNull(aVar.Ts().bwp)) {
            this.bwV.setVisibility(8);
        } else {
            this.bwV.setText(aVar.Ts().bwp);
            this.bwX = aVar.Ts().bwq;
            this.bwY = aVar.Ts().bwp;
        }
        this.bwT.setText(f(n.e.icon_gift_my_gift, aVar.Tp()));
        this.bwU.setText(f(n.e.icon_gift_my_tdou, aVar.Tq()));
    }

    private SpannableString f(int i, long j) {
        String str = String.valueOf("[icon]") + ax.A(j);
        SpannableString spannableString = new SpannableString(str);
        Drawable x = as.x(0, i);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), n.d.ds30);
        x.setBounds(0, 0, d, d);
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(x);
        fVar.eU(com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), n.d.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", fVar);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.d(this.bwC.getPageContext().getPageActivity(), n.d.fontsize22));
        UtilHelper.setSpan(spannableString, str, this.bwC.getResources().getString(n.i.unit_wan), absoluteSizeSpan);
        UtilHelper.setSpan(spannableString, str, this.bwC.getResources().getString(n.i.unit_yi), absoluteSizeSpan);
        return spannableString;
    }

    private void d(a aVar) {
        if (aVar == null || aVar.getGiftList() == null || aVar.getGiftList().size() <= 0) {
            this.mFooterView.setVisibility(8);
            this.bxa.setVisibility(8);
            this.bwZ.setData(null);
            return;
        }
        if (aVar.Tr() != null) {
            if (aVar.Tr().hasMore == 1) {
                this.mFooterView.setVisibility(0);
            } else {
                this.mFooterView.setVisibility(8);
            }
        }
        this.bwZ.setData(aVar.getGiftList());
    }

    public void onChangeSkinType(int i) {
        this.bwC.getLayoutMode().af(i == 1);
        this.bwC.getLayoutMode().k(this.bwP);
        this.bwC.getLayoutMode().k(this.bwQ);
        this.bwC.getLayoutMode().k(this.mFooterView);
        this.bli.onChangeSkinType(getPageContext(), i);
        this.bwN.onChangeSkinType(this.bwC.getPageContext(), i);
        this.mPullView.cV(i);
        if (this.bwZ != null) {
            this.bwZ.notifyDataSetChanged();
        }
    }

    public void Tx() {
        this.bwO.completePullRefresh();
    }

    public void b(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void g(NoNetworkView.a aVar) {
        this.bwN.a(aVar);
    }

    public void nD() {
        this.bwO.setVisibility(0);
        this.bwO.nD();
    }
}
