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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView bmr;
    private NoNetworkView bvz;
    private RelativeLayout enA;
    private TextView enB;
    private boolean enC;
    private TextView enD;
    private View enE;
    private TextView enF;
    private BdListView enw;
    private OfficialBarTipListAdapter enx;
    private OfficialBarTipActivity eny;
    private boolean enz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.enz = false;
        this.enA = null;
        this.enC = false;
        officialBarTipActivity.setContentView(d.h.officialbar_msg_activity);
        this.eny = officialBarTipActivity;
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
        this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.enE = LayoutInflater.from(this.eny.getBaseContext()).inflate(d.h.im_ba_btn, (ViewGroup) null);
        this.enF = (TextView) this.enE.findViewById(d.g.all_read);
        this.enF.setVisibility(8);
        this.bmr = (TextView) this.enE.findViewById(d.g.edit);
        this.bmr.setVisibility(0);
        this.enE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.enE, (View.OnClickListener) null);
        this.bmr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.enz) {
                    if (f.this.eny.aHR()) {
                        f.this.enF.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eny.getLayoutMode().setNightMode(i == 1);
        this.eny.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eny.getPageContext(), i);
        am.b(this.bmr, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        am.b(this.enF, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eny.getPageContext(), i);
        }
        if (this.bvz != null) {
            this.bvz.onChangeSkinType(this.eny.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.enw = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.enx = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.enw.setAdapter((ListAdapter) this.enx);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.du(d.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.enA = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.enD = (TextView) this.enA.findViewById(d.g.delete_txt);
        this.enD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aHO();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.enB = (TextView) this.enA.findViewById(d.g.select_all_txt);
        int f = l.f(this.eny.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = am.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, f, f);
        this.enB.setText(this.eny.getPageContext().getString(d.j.select_all));
        this.enB.setCompoundDrawables(drawable, null, null, null);
        this.enB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.enC) {
                    f.this.hj(true);
                } else {
                    f.this.hj(false);
                }
            }
        });
    }

    public BdListView aHT() {
        return this.enw;
    }

    public OfficialBarTipListAdapter aHU() {
        return this.enx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.enA.setVisibility(0);
            this.enx.he(true);
            this.enx.notifyDataSetChanged();
            if (officialBarTipActivity.aHP()) {
                hi(true);
            } else {
                hi(false);
            }
            this.bmr.setText(officialBarTipActivity.getPageContext().getString(d.j.cancel));
            this.enF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.eny.aHQ();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.enz = true;
            return;
        }
        this.enA.setVisibility(8);
        this.enF.setVisibility(8);
        this.enx.he(false);
        this.enx.notifyDataSetChanged();
        this.bmr.setText(officialBarTipActivity.getPageContext().getString(d.j.edit));
        this.enz = false;
    }

    public void hi(boolean z) {
        if (z) {
            this.enD.setAlpha(1.0f);
            this.enD.setEnabled(true);
            return;
        }
        this.enD.setAlpha(0.3f);
        this.enD.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.enx.setData(list);
        if (list != null && list.size() <= 0) {
            this.bmr.setVisibility(8);
        }
    }

    public void hj(boolean z) {
        int f = l.f(this.eny.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, f, f);
            this.enB.setText(this.eny.getPageContext().getString(d.j.cancel_select_all));
            this.enB.setCompoundDrawables(drawable, null, null, null);
            hi(true);
            this.enC = true;
            this.eny.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, f, f);
        this.enB.setText(this.eny.getPageContext().getString(d.j.select_all));
        this.enB.setCompoundDrawables(drawable2, null, null, null);
        hi(false);
        this.enC = false;
        this.eny.updateEditStatus(false);
    }
}
