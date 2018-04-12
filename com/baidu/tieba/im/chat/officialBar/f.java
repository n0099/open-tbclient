package com.baidu.tieba.im.chat.officialBar;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView bca;
    private NoNetworkView bla;
    private boolean dTA;
    private TextView dTB;
    private View dTC;
    private TextView dTD;
    private BdListView dTu;
    private OfficialBarTipListAdapter dTv;
    private OfficialBarTipActivity dTw;
    private boolean dTx;
    private RelativeLayout dTy;
    private TextView dTz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.dTx = false;
        this.dTy = null;
        this.dTA = false;
        officialBarTipActivity.setContentView(d.i.officialbar_msg_activity);
        this.dTw = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(d.k.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(d.g.root_view);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.dTC = LayoutInflater.from(this.dTw.getBaseContext()).inflate(d.i.im_ba_btn, (ViewGroup) null);
        this.dTD = (TextView) this.dTC.findViewById(d.g.all_read);
        this.dTD.setVisibility(8);
        this.bca = (TextView) this.dTC.findViewById(d.g.edit);
        this.bca.setVisibility(0);
        this.dTC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dTC, (View.OnClickListener) null);
        this.bca.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!f.this.dTx) {
                    if (f.this.dTw.aBq()) {
                        f.this.dTD.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.dTw.getLayoutMode().setNightMode(i == 1);
        this.dTw.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.dTw.getPageContext(), i);
        ak.b(this.bca, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        ak.b(this.dTD, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dTw.getPageContext(), i);
        }
        if (this.bla != null) {
            this.bla.onChangeSkinType(this.dTw.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.dTu = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.dTv = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.dTu.setAdapter((ListAdapter) this.dTv);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dp(d.k.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.dTy = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.dTB = (TextView) this.dTy.findViewById(d.g.delete_txt);
        this.dTB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                officialBarTipActivity.aBn();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.dTz = (TextView) this.dTy.findViewById(d.g.select_all_txt);
        int e = l.e(this.dTw.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = ak.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, e, e);
        this.dTz.setText(this.dTw.getPageContext().getString(d.k.select_all));
        this.dTz.setCompoundDrawables(drawable, null, null, null);
        this.dTz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!f.this.dTA) {
                    f.this.gP(true);
                } else {
                    f.this.gP(false);
                }
            }
        });
    }

    public BdListView aBt() {
        return this.dTu;
    }

    public OfficialBarTipListAdapter aBu() {
        return this.dTv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.dTy.setVisibility(0);
            this.dTv.gK(true);
            this.dTv.notifyDataSetChanged();
            if (officialBarTipActivity.aBo()) {
                gO(true);
            } else {
                gO(false);
            }
            this.bca.setText(officialBarTipActivity.getPageContext().getString(d.k.cancel));
            this.dTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.dTw.aBp();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.dTx = true;
            return;
        }
        this.dTy.setVisibility(8);
        this.dTD.setVisibility(8);
        this.dTv.gK(false);
        this.dTv.notifyDataSetChanged();
        this.bca.setText(officialBarTipActivity.getPageContext().getString(d.k.edit));
        this.dTx = false;
    }

    public void gO(boolean z) {
        if (z) {
            this.dTB.setAlpha(1.0f);
            this.dTB.setEnabled(true);
            return;
        }
        this.dTB.setAlpha(0.3f);
        this.dTB.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.dTv.setData(list);
        if (list != null && list.size() <= 0) {
            this.bca.setVisibility(8);
        }
    }

    public void gP(boolean z) {
        int e = l.e(this.dTw.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = ak.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, e, e);
            this.dTz.setText(this.dTw.getPageContext().getString(d.k.cancel_select_all));
            this.dTz.setCompoundDrawables(drawable, null, null, null);
            gO(true);
            this.dTA = true;
            this.dTw.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ak.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, e, e);
        this.dTz.setText(this.dTw.getPageContext().getString(d.k.select_all));
        this.dTz.setCompoundDrawables(drawable2, null, null, null);
        gO(false);
        this.dTA = false;
        this.dTw.updateEditStatus(false);
    }
}
