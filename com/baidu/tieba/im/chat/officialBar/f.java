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
    private TextView cMv;
    private NoNetworkView dbq;
    private BdListView gee;
    private OfficialBarTipListAdapter gef;
    private OfficialBarTipActivity geg;
    private boolean geh;
    private RelativeLayout gei;
    private TextView gej;
    private boolean gek;
    private TextView gel;
    private View gem;
    private TextView gen;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.geh = false;
        this.gei = null;
        this.gek = false;
        officialBarTipActivity.setContentView(d.h.officialbar_msg_activity);
        this.geg = officialBarTipActivity;
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
        this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.gem = LayoutInflater.from(this.geg.getBaseContext()).inflate(d.h.im_ba_btn, (ViewGroup) null);
        this.gen = (TextView) this.gem.findViewById(d.g.all_read);
        this.gen.setVisibility(8);
        this.cMv = (TextView) this.gem.findViewById(d.g.edit);
        this.cMv.setVisibility(0);
        this.gem = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gem, (View.OnClickListener) null);
        this.cMv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.geh) {
                    if (f.this.geg.bqx()) {
                        f.this.gen.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.geg.getLayoutMode().setNightMode(i == 1);
        this.geg.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.geg.getPageContext(), i);
        al.c(this.cMv, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        al.c(this.gen, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.geg.getPageContext(), i);
        }
        if (this.dbq != null) {
            this.dbq.onChangeSkinType(this.geg.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.gee = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.gef = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.gee.setAdapter((ListAdapter) this.gef);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hT(d.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gei = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.gel = (TextView) this.gei.findViewById(d.g.delete_txt);
        this.gel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bqu();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gej = (TextView) this.gei.findViewById(d.g.select_all_txt);
        int h = l.h(this.geg.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = al.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.gej.setText(this.geg.getPageContext().getString(d.j.select_all));
        this.gej.setCompoundDrawables(drawable, null, null, null);
        this.gej.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gek) {
                    f.this.kO(true);
                } else {
                    f.this.kO(false);
                }
            }
        });
    }

    public BdListView bqz() {
        return this.gee;
    }

    public OfficialBarTipListAdapter bqA() {
        return this.gef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gei.setVisibility(0);
            this.gef.kJ(true);
            this.gef.notifyDataSetChanged();
            if (officialBarTipActivity.bqv()) {
                kN(true);
            } else {
                kN(false);
            }
            this.cMv.setText(officialBarTipActivity.getPageContext().getString(d.j.cancel));
            this.gen.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.geg.bqw();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.geh = true;
            return;
        }
        this.gei.setVisibility(8);
        this.gen.setVisibility(8);
        this.gef.kJ(false);
        this.gef.notifyDataSetChanged();
        this.cMv.setText(officialBarTipActivity.getPageContext().getString(d.j.edit));
        this.geh = false;
    }

    public void kN(boolean z) {
        if (z) {
            this.gel.setAlpha(1.0f);
            this.gel.setEnabled(true);
            return;
        }
        this.gel.setAlpha(0.3f);
        this.gel.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.gef.setData(list);
        if (list != null && list.size() <= 0) {
            this.cMv.setVisibility(8);
        }
    }

    public void kO(boolean z) {
        int h = l.h(this.geg.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.gej.setText(this.geg.getPageContext().getString(d.j.cancel_select_all));
            this.gej.setCompoundDrawables(drawable, null, null, null);
            kN(true);
            this.gek = true;
            this.geg.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.gej.setText(this.geg.getPageContext().getString(d.j.select_all));
        this.gej.setCompoundDrawables(drawable2, null, null, null);
        kN(false);
        this.gek = false;
        this.geg.updateEditStatus(false);
    }
}
