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
    View.OnClickListener aed;
    private NavigationBar beE;
    AdapterView.OnItemClickListener bgp;
    private MyGiftListActivity bnF;
    private NoNetworkView bnP;
    private BdListView bnQ;
    private View bnR;
    private View bnS;
    private View bnT;
    private BdListView.e bnU;
    private TextView bnV;
    private TextView bnW;
    private TextView bnX;
    private String bnY;
    private String bnZ;
    private j boa;
    private RelativeLayout bob;
    private TextView boc;
    private View bod;
    private a boe;
    private View mFooterView;
    private boolean mIsHost;
    private List<GiftList> mList;
    private r mPullView;

    public m(MyGiftListActivity myGiftListActivity, BdListView.e eVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.mPullView = null;
        this.bgp = new n(this);
        this.aed = new o(this);
        this.bnF = myGiftListActivity;
        this.mIsHost = z;
        this.mList = new ArrayList();
        this.bnU = eVar;
        initView();
        QR();
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.bob.setVisibility(8);
        } else {
            this.bob.setVisibility(0);
        }
        this.boe = new a(this.bnF.getPageContext().getPageActivity());
    }

    private void initView() {
        this.bnF.setContentView(i.g.my_gift_list_activity);
        this.bnY = null;
        this.bnR = this.bnF.findViewById(i.f.root);
        this.bnQ = (BdListView) this.bnR.findViewById(i.f.list_view);
        this.beE = (NavigationBar) this.bnR.findViewById(i.f.navigation_bar);
        String format = String.format(this.bnF.getPageContext().getString(i.h.he_gift_title), this.bnF.QP());
        if (this.mIsHost) {
            this.beE.setTitleText(i.h.my_gift_list);
        } else {
            this.beE.setTitleText(format);
        }
        this.beE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bnP = (NoNetworkView) this.bnR.findViewById(i.f.no_networkview);
        this.bnS = LayoutInflater.from(this.bnF.getPageContext().getPageActivity()).inflate(i.g.my_gift_list_head, (ViewGroup) null, false);
        this.bnS.setVisibility(8);
        this.bnV = (TextView) this.bnS.findViewById(i.f.gift_total);
        this.bnW = (TextView) this.bnS.findViewById(i.f.dou_num);
        this.bnX = (TextView) this.bnS.findViewById(i.f.t_use);
        this.bnX.setOnClickListener(this.aed);
        this.mFooterView = LayoutInflater.from(this.bnF.getPageContext().getPageActivity()).inflate(i.g.my_gift_list_footer, (ViewGroup) null, false);
        this.bnT = this.mFooterView.findViewById(i.f.gift_footer_lay);
        if (this.mIsHost) {
            this.bnQ.addHeaderView(this.bnS);
        } else if (TbadkApplication.getInst().isGiftSwitchOn()) {
            this.mFooterView.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.d(this.bnF.getPageContext().getPageActivity(), i.d.ds156));
        }
        this.bnQ.addFooterView(this.mFooterView);
        this.boa = new j(this.bnF, this.mIsHost);
        this.bnQ.setAdapter((ListAdapter) this.boa);
        this.mPullView = new r(this.bnF.getPageContext());
        this.bnQ.setPullRefresh(this.mPullView);
        this.bnQ.setOnSrollToBottomListener(this.bnU);
        this.bnQ.setOnItemClickListener(this.bgp);
    }

    private void QR() {
        this.bob = (RelativeLayout) this.bnF.findViewById(i.f.gift_relation_ll);
        this.boc = (TextView) this.bnF.findViewById(i.f.gift_relation_text);
        this.boc.setOnClickListener(this.bnF.QN());
        this.bod = this.bnF.findViewById(i.f.his_gift_line);
        if (!this.mIsHost && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.bnQ.setOnScrollListener(new p(this));
        }
    }

    public View getFooterView() {
        return this.bnT;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0100: IGET  (r2v0 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.GetGiftMyList.DataRes) tbclient.GetGiftMyList.DataRes.total_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0115: IGET  (r2v1 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.GetGiftMyList.DataRes) tbclient.GetGiftMyList.DataRes.money java.lang.Integer)] */
    public void a(DataRes dataRes, boolean z) {
        this.bnS.setVisibility(0);
        if (dataRes == null || dataRes.gift_list == null || dataRes.gift_list.size() == 0) {
            if (this.mList.size() == 0) {
                this.bnV.setText("0");
                this.bnW.setText("0");
                this.boa.setData(null);
                this.mFooterView.setVisibility(8);
                this.bob.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) {
            this.bob.setVisibility(8);
        } else {
            this.bob.setVisibility(0);
        }
        if (dataRes.money_txt != null) {
            String str = "";
            if (!as.isEmpty(dataRes.money_txt.txt)) {
                str = String.valueOf(dataRes.money_txt.txt) + ">";
            }
            this.bnX.setText(str);
            this.bnY = dataRes.money_txt.url;
            this.bnZ = dataRes.money_txt.txt;
            if (TextUtils.isEmpty(dataRes.money_txt.txt) || TextUtils.isEmpty(this.bnY)) {
                this.bnX.setVisibility(8);
            }
        } else {
            this.bnX.setVisibility(8);
        }
        if (dataRes.total_num.intValue() < 0) {
            this.bnV.setText("0");
        } else {
            this.bnV.setText(new StringBuilder().append(dataRes.total_num).toString());
        }
        if (dataRes.money.intValue() < 0) {
            this.bnV.setText("0");
        } else {
            this.bnW.setText(new StringBuilder().append(dataRes.money).toString());
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
        this.boa.setData(this.mList);
    }

    public void onChangeSkinType(int i) {
        this.bnF.getLayoutMode().ad(i == 1);
        this.bnF.getLayoutMode().k(this.bnR);
        this.bnF.getLayoutMode().k(this.bnS);
        this.bnF.getLayoutMode().k(this.mFooterView);
        this.beE.onChangeSkinType(getPageContext(), i);
        this.bnP.onChangeSkinType(this.bnF.getPageContext(), i);
        this.mPullView.cN(i);
        if (this.boa != null) {
            this.boa.notifyDataSetChanged();
        }
    }

    public void QS() {
        this.bnQ.completePullRefresh();
    }

    public void b(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void h(NoNetworkView.a aVar) {
        this.bnP.a(aVar);
    }

    public void nx() {
        this.bnQ.setVisibility(0);
        this.bnQ.nx();
    }
}
