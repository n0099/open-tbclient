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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView cMt;
    private NoNetworkView dbm;
    private TextView geA;
    private BdListView ger;
    private OfficialBarTipListAdapter ges;
    private OfficialBarTipActivity get;
    private boolean geu;
    private RelativeLayout gev;
    private TextView gew;
    private boolean gex;
    private TextView gey;
    private View gez;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.geu = false;
        this.gev = null;
        this.gex = false;
        officialBarTipActivity.setContentView(d.h.officialbar_msg_activity);
        this.get = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(d.j.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(d.g.root_view);
        this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.gez = LayoutInflater.from(this.get.getBaseContext()).inflate(d.h.im_ba_btn, (ViewGroup) null);
        this.geA = (TextView) this.gez.findViewById(d.g.all_read);
        this.geA.setVisibility(8);
        this.cMt = (TextView) this.gez.findViewById(d.g.edit);
        this.cMt.setVisibility(0);
        this.gez = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gez, (View.OnClickListener) null);
        this.cMt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.geu) {
                    if (f.this.get.bqA()) {
                        f.this.geA.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.get.getLayoutMode().setNightMode(i == 1);
        this.get.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.get.getPageContext(), i);
        al.c(this.cMt, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        al.c(this.geA, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.get.getPageContext(), i);
        }
        if (this.dbm != null) {
            this.dbm.onChangeSkinType(this.get.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.ger = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.ges = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.ger.setAdapter((ListAdapter) this.ges);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hU(d.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gev = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.gey = (TextView) this.gev.findViewById(d.g.delete_txt);
        this.gey.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bqx();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gew = (TextView) this.gev.findViewById(d.g.select_all_txt);
        int h = l.h(this.get.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = al.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.gew.setText(this.get.getPageContext().getString(d.j.select_all));
        this.gew.setCompoundDrawables(drawable, null, null, null);
        this.gew.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gex) {
                    f.this.kO(true);
                } else {
                    f.this.kO(false);
                }
            }
        });
    }

    public BdListView bqC() {
        return this.ger;
    }

    public OfficialBarTipListAdapter bqD() {
        return this.ges;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gev.setVisibility(0);
            this.ges.kJ(true);
            this.ges.notifyDataSetChanged();
            if (officialBarTipActivity.bqy()) {
                kN(true);
            } else {
                kN(false);
            }
            this.cMt.setText(officialBarTipActivity.getPageContext().getString(d.j.cancel));
            this.geA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.get.bqz();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.geu = true;
            return;
        }
        this.gev.setVisibility(8);
        this.geA.setVisibility(8);
        this.ges.kJ(false);
        this.ges.notifyDataSetChanged();
        this.cMt.setText(officialBarTipActivity.getPageContext().getString(d.j.edit));
        this.geu = false;
    }

    public void kN(boolean z) {
        if (z) {
            this.gey.setAlpha(1.0f);
            this.gey.setEnabled(true);
            return;
        }
        this.gey.setAlpha(0.3f);
        this.gey.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.ges.setData(list);
        if (list != null && list.size() <= 0) {
            this.cMt.setVisibility(8);
        }
    }

    public void kO(boolean z) {
        int h = l.h(this.get.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.gew.setText(this.get.getPageContext().getString(d.j.cancel_select_all));
            this.gew.setCompoundDrawables(drawable, null, null, null);
            kN(true);
            this.gex = true;
            this.get.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.gew.setText(this.get.getPageContext().getString(d.j.select_all));
        this.gew.setCompoundDrawables(drawable2, null, null, null);
        kN(false);
        this.gex = false;
        this.get.updateEditStatus(false);
    }
}
