package com.baidu.tieba.gift.myGiftList;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetGiftMyList.DataRes;
import tbclient.GetGiftMyList.GiftList;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.f<MyGiftListActivity> {
    View.OnClickListener adY;
    private NavigationBar bdY;
    AdapterView.OnItemClickListener bfK;
    private a bnA;
    private MyGiftListActivity bnb;
    private NoNetworkView bnl;
    private BdListView bnm;
    private View bnn;
    private View bno;
    private View bnp;
    private BdListView.e bnq;
    private TextView bnr;
    private TextView bns;
    private TextView bnt;
    private String bnu;
    private String bnv;
    private j bnw;
    private RelativeLayout bnx;
    private TextView bny;
    private View bnz;
    private View mFooterView;
    private boolean mIsHost;
    private List<GiftList> mList;
    private r mPullView;

    public m(MyGiftListActivity myGiftListActivity, BdListView.e eVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.mPullView = null;
        this.bfK = new n(this);
        this.adY = new o(this);
        this.bnb = myGiftListActivity;
        this.mIsHost = z;
        this.mList = new ArrayList();
        this.bnq = eVar;
        initView();
        Qz();
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.bnx.setVisibility(8);
        } else {
            this.bnx.setVisibility(0);
        }
        this.bnA = new a(this.bnb.getPageContext().getPageActivity());
    }

    private void initView() {
        this.bnb.setContentView(i.g.my_gift_list_activity);
        this.bnu = null;
        this.bnn = this.bnb.findViewById(i.f.root);
        this.bnm = (BdListView) this.bnn.findViewById(i.f.list_view);
        this.bdY = (NavigationBar) this.bnn.findViewById(i.f.navigation_bar);
        String format = String.format(this.bnb.getPageContext().getString(i.h.he_gift_title), this.bnb.Qx());
        if (this.mIsHost) {
            this.bdY.setTitleText(i.h.my_gift_list);
        } else {
            this.bdY.setTitleText(format);
        }
        this.bdY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bnl = (NoNetworkView) this.bnn.findViewById(i.f.no_networkview);
        this.bno = LayoutInflater.from(this.bnb.getPageContext().getPageActivity()).inflate(i.g.my_gift_list_head, (ViewGroup) null, false);
        this.bno.setVisibility(8);
        this.bnr = (TextView) this.bno.findViewById(i.f.gift_total);
        this.bns = (TextView) this.bno.findViewById(i.f.dou_num);
        this.bnt = (TextView) this.bno.findViewById(i.f.t_use);
        this.bnt.setOnClickListener(this.adY);
        this.mFooterView = LayoutInflater.from(this.bnb.getPageContext().getPageActivity()).inflate(i.g.my_gift_list_footer, (ViewGroup) null, false);
        this.bnp = this.mFooterView.findViewById(i.f.gift_footer_lay);
        if (this.mIsHost) {
            this.bnm.addHeaderView(this.bno);
        } else if (TbadkApplication.getInst().isGiftSwitchOn()) {
            this.mFooterView.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.d(this.bnb.getPageContext().getPageActivity(), i.d.ds156));
        }
        this.bnm.addFooterView(this.mFooterView);
        this.bnw = new j(this.bnb, this.mIsHost);
        this.bnm.setAdapter((ListAdapter) this.bnw);
        this.mPullView = new r(this.bnb.getPageContext());
        this.bnm.setPullRefresh(this.mPullView);
        this.bnm.setOnSrollToBottomListener(this.bnq);
        this.bnm.setOnItemClickListener(this.bfK);
    }

    private void Qz() {
        this.bnx = (RelativeLayout) this.bnb.findViewById(i.f.gift_relation_ll);
        this.bny = (TextView) this.bnb.findViewById(i.f.gift_relation_text);
        this.bny.setOnClickListener(this.bnb.Qv());
        this.bnz = this.bnb.findViewById(i.f.his_gift_line);
        if (!this.mIsHost && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.bnm.setOnScrollListener(new p(this));
        }
    }

    public View getFooterView() {
        return this.bnp;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0100: IGET  (r2v0 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.GetGiftMyList.DataRes) tbclient.GetGiftMyList.DataRes.total_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0115: IGET  (r2v1 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.GetGiftMyList.DataRes) tbclient.GetGiftMyList.DataRes.money java.lang.Integer)] */
    public void a(DataRes dataRes, boolean z) {
        this.bno.setVisibility(0);
        if (dataRes == null || dataRes.gift_list == null || dataRes.gift_list.size() == 0) {
            if (this.mList.size() == 0) {
                this.bnr.setText("0");
                this.bns.setText("0");
                this.bnw.setData(null);
                this.mFooterView.setVisibility(8);
                this.bnx.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.bnx.setVisibility(8);
        } else {
            this.bnx.setVisibility(0);
        }
        if (dataRes.money_txt != null) {
            String str = "";
            if (!as.isEmpty(dataRes.money_txt.txt)) {
                str = String.valueOf(dataRes.money_txt.txt) + ">";
            }
            this.bnt.setText(str);
            this.bnu = dataRes.money_txt.url;
            this.bnv = dataRes.money_txt.txt;
            if (TextUtils.isEmpty(dataRes.money_txt.txt) || TextUtils.isEmpty(this.bnu)) {
                this.bnt.setVisibility(8);
            }
        } else {
            this.bnt.setVisibility(8);
        }
        if (dataRes.total_num.intValue() < 0) {
            this.bnr.setText("0");
        } else {
            this.bnr.setText(new StringBuilder().append(dataRes.total_num).toString());
        }
        if (dataRes.money.intValue() < 0) {
            this.bnr.setText("0");
        } else {
            this.bns.setText(new StringBuilder().append(dataRes.money).toString());
        }
        if (dataRes.page != null) {
            if (dataRes.page.has_more.intValue() == 1) {
                this.mFooterView.setVisibility(0);
            } else {
                this.mFooterView.setVisibility(8);
            }
        }
        if (dataRes.gift_list != null) {
            if (!z) {
                this.mList.clear();
                this.mList.addAll(dataRes.gift_list);
            } else {
                this.mList.addAll(dataRes.gift_list);
            }
        }
        this.bnw.setData(this.mList);
    }

    public void onChangeSkinType(int i) {
        this.bnb.getLayoutMode().ad(i == 1);
        this.bnb.getLayoutMode().k(this.bnn);
        this.bnb.getLayoutMode().k(this.bno);
        this.bnb.getLayoutMode().k(this.mFooterView);
        this.bdY.onChangeSkinType(getPageContext(), i);
        this.bnl.onChangeSkinType(this.bnb.getPageContext(), i);
        this.mPullView.cN(i);
        if (this.bnw != null) {
            this.bnw.notifyDataSetChanged();
        }
    }

    public void QA() {
        this.bnm.completePullRefresh();
    }

    public void b(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void h(NoNetworkView.a aVar) {
        this.bnl.a(aVar);
    }

    public void nw() {
        this.bnm.setVisibility(0);
        this.bnm.nw();
    }
}
