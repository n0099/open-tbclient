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
    private TextView dTA;
    private BdListView dTr;
    private OfficialBarTipListAdapter dTs;
    private OfficialBarTipActivity dTt;
    private boolean dTu;
    private RelativeLayout dTv;
    private TextView dTw;
    private boolean dTx;
    private TextView dTy;
    private View dTz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.dTu = false;
        this.dTv = null;
        this.dTx = false;
        officialBarTipActivity.setContentView(d.i.officialbar_msg_activity);
        this.dTt = officialBarTipActivity;
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
        this.dTz = LayoutInflater.from(this.dTt.getBaseContext()).inflate(d.i.im_ba_btn, (ViewGroup) null);
        this.dTA = (TextView) this.dTz.findViewById(d.g.all_read);
        this.dTA.setVisibility(8);
        this.bca = (TextView) this.dTz.findViewById(d.g.edit);
        this.bca.setVisibility(0);
        this.dTz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dTz, (View.OnClickListener) null);
        this.bca.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!f.this.dTu) {
                    if (f.this.dTt.aBq()) {
                        f.this.dTA.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.dTt.getLayoutMode().setNightMode(i == 1);
        this.dTt.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.dTt.getPageContext(), i);
        ak.b(this.bca, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        ak.b(this.dTA, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dTt.getPageContext(), i);
        }
        if (this.bla != null) {
            this.bla.onChangeSkinType(this.dTt.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.dTr = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.dTs = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.dTr.setAdapter((ListAdapter) this.dTs);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.m16do(d.k.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.dTv = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.dTy = (TextView) this.dTv.findViewById(d.g.delete_txt);
        this.dTy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                officialBarTipActivity.aBn();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.dTw = (TextView) this.dTv.findViewById(d.g.select_all_txt);
        int e = l.e(this.dTt.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = ak.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, e, e);
        this.dTw.setText(this.dTt.getPageContext().getString(d.k.select_all));
        this.dTw.setCompoundDrawables(drawable, null, null, null);
        this.dTw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!f.this.dTx) {
                    f.this.gP(true);
                } else {
                    f.this.gP(false);
                }
            }
        });
    }

    public BdListView aBt() {
        return this.dTr;
    }

    public OfficialBarTipListAdapter aBu() {
        return this.dTs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.dTv.setVisibility(0);
            this.dTs.gK(true);
            this.dTs.notifyDataSetChanged();
            if (officialBarTipActivity.aBo()) {
                gO(true);
            } else {
                gO(false);
            }
            this.bca.setText(officialBarTipActivity.getPageContext().getString(d.k.cancel));
            this.dTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.dTt.aBp();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.dTu = true;
            return;
        }
        this.dTv.setVisibility(8);
        this.dTA.setVisibility(8);
        this.dTs.gK(false);
        this.dTs.notifyDataSetChanged();
        this.bca.setText(officialBarTipActivity.getPageContext().getString(d.k.edit));
        this.dTu = false;
    }

    public void gO(boolean z) {
        if (z) {
            this.dTy.setAlpha(1.0f);
            this.dTy.setEnabled(true);
            return;
        }
        this.dTy.setAlpha(0.3f);
        this.dTy.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.dTs.setData(list);
        if (list != null && list.size() <= 0) {
            this.bca.setVisibility(8);
        }
    }

    public void gP(boolean z) {
        int e = l.e(this.dTt.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = ak.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, e, e);
            this.dTw.setText(this.dTt.getPageContext().getString(d.k.cancel_select_all));
            this.dTw.setCompoundDrawables(drawable, null, null, null);
            gO(true);
            this.dTx = true;
            this.dTt.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ak.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, e, e);
        this.dTw.setText(this.dTt.getPageContext().getString(d.k.select_all));
        this.dTw.setCompoundDrawables(drawable2, null, null, null);
        gO(false);
        this.dTx = false;
        this.dTt.updateEditStatus(false);
    }
}
