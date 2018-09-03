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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView bmv;
    private NoNetworkView bvB;
    private View enA;
    private TextView enB;
    private BdListView ens;
    private OfficialBarTipListAdapter ent;
    private OfficialBarTipActivity enu;
    private boolean env;
    private RelativeLayout enw;
    private TextView enx;
    private boolean eny;
    private TextView enz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.env = false;
        this.enw = null;
        this.eny = false;
        officialBarTipActivity.setContentView(f.h.officialbar_msg_activity);
        this.enu = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(f.j.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(f.g.root_view);
        this.bvB = (NoNetworkView) this.mRootView.findViewById(f.g.no_network_view);
        this.enA = LayoutInflater.from(this.enu.getBaseContext()).inflate(f.h.im_ba_btn, (ViewGroup) null);
        this.enB = (TextView) this.enA.findViewById(f.g.all_read);
        this.enB.setVisibility(8);
        this.bmv = (TextView) this.enA.findViewById(f.g.edit);
        this.bmv.setVisibility(0);
        this.enA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.enA, (View.OnClickListener) null);
        this.bmv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.env) {
                    if (f.this.enu.aHO()) {
                        f.this.enB.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.enu.getLayoutMode().setNightMode(i == 1);
        this.enu.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.enu.getPageContext(), i);
        am.b(this.bmv, f.d.navi_op_text, f.d.navi_op_text_skin);
        am.b(this.enB, f.d.navi_op_text, f.d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.enu.getPageContext(), i);
        }
        if (this.bvB != null) {
            this.bvB.onChangeSkinType(this.enu.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.ens = (BdListView) officialBarTipActivity.findViewById(f.g.msg_list);
        this.ent = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.ens.setAdapter((ListAdapter) this.ent);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dt(f.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.enw = (RelativeLayout) officialBarTipActivity.findViewById(f.g.tip_footer);
        this.enz = (TextView) this.enw.findViewById(f.g.delete_txt);
        this.enz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aHL();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.enx = (TextView) this.enw.findViewById(f.g.select_all_txt);
        int f = l.f(this.enu.getPageContext().getPageActivity(), f.e.ds40);
        Drawable drawable = am.getDrawable(f.C0146f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, f, f);
        this.enx.setText(this.enu.getPageContext().getString(f.j.select_all));
        this.enx.setCompoundDrawables(drawable, null, null, null);
        this.enx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eny) {
                    f.this.hj(true);
                } else {
                    f.this.hj(false);
                }
            }
        });
    }

    public BdListView aHQ() {
        return this.ens;
    }

    public OfficialBarTipListAdapter aHR() {
        return this.ent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.enw.setVisibility(0);
            this.ent.he(true);
            this.ent.notifyDataSetChanged();
            if (officialBarTipActivity.aHM()) {
                hi(true);
            } else {
                hi(false);
            }
            this.bmv.setText(officialBarTipActivity.getPageContext().getString(f.j.cancel));
            this.enB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.enu.aHN();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.env = true;
            return;
        }
        this.enw.setVisibility(8);
        this.enB.setVisibility(8);
        this.ent.he(false);
        this.ent.notifyDataSetChanged();
        this.bmv.setText(officialBarTipActivity.getPageContext().getString(f.j.edit));
        this.env = false;
    }

    public void hi(boolean z) {
        if (z) {
            this.enz.setAlpha(1.0f);
            this.enz.setEnabled(true);
            return;
        }
        this.enz.setAlpha(0.3f);
        this.enz.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.ent.setData(list);
        if (list != null && list.size() <= 0) {
            this.bmv.setVisibility(8);
        }
    }

    public void hj(boolean z) {
        int f = l.f(this.enu.getPageContext().getPageActivity(), f.e.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(f.C0146f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, f, f);
            this.enx.setText(this.enu.getPageContext().getString(f.j.cancel_select_all));
            this.enx.setCompoundDrawables(drawable, null, null, null);
            hi(true);
            this.eny = true;
            this.enu.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(f.C0146f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, f, f);
        this.enx.setText(this.enu.getPageContext().getString(f.j.select_all));
        this.enx.setCompoundDrawables(drawable2, null, null, null);
        hi(false);
        this.eny = false;
        this.enu.updateEditStatus(false);
    }
}
