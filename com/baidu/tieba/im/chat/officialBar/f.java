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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private NoNetworkView bKI;
    private TextView bxb;
    private BdListView eDU;
    private OfficialBarTipListAdapter eDV;
    private OfficialBarTipActivity eDW;
    private boolean eDX;
    private RelativeLayout eDY;
    private TextView eDZ;
    private boolean eEa;
    private TextView eEb;
    private View eEc;
    private TextView eEd;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eDX = false;
        this.eDY = null;
        this.eEa = false;
        officialBarTipActivity.setContentView(e.h.officialbar_msg_activity);
        this.eDW = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(e.j.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(e.g.root_view);
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.eEc = LayoutInflater.from(this.eDW.getBaseContext()).inflate(e.h.im_ba_btn, (ViewGroup) null);
        this.eEd = (TextView) this.eEc.findViewById(e.g.all_read);
        this.eEd.setVisibility(8);
        this.bxb = (TextView) this.eEc.findViewById(e.g.edit);
        this.bxb.setVisibility(0);
        this.eEc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eEc, (View.OnClickListener) null);
        this.bxb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eDX) {
                    if (f.this.eDW.aMQ()) {
                        f.this.eEd.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eDW.getLayoutMode().setNightMode(i == 1);
        this.eDW.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eDW.getPageContext(), i);
        al.b(this.bxb, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.b(this.eEd, e.d.navi_op_text, e.d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eDW.getPageContext(), i);
        }
        if (this.bKI != null) {
            this.bKI.onChangeSkinType(this.eDW.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eDU = (BdListView) officialBarTipActivity.findViewById(e.g.msg_list);
        this.eDV = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eDU.setAdapter((ListAdapter) this.eDV);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ec(e.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eDY = (RelativeLayout) officialBarTipActivity.findViewById(e.g.tip_footer);
        this.eEb = (TextView) this.eDY.findViewById(e.g.delete_txt);
        this.eEb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aMN();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.eDZ = (TextView) this.eDY.findViewById(e.g.select_all_txt);
        int h = l.h(this.eDW.getPageContext().getPageActivity(), e.C0200e.ds40);
        Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.eDZ.setText(this.eDW.getPageContext().getString(e.j.select_all));
        this.eDZ.setCompoundDrawables(drawable, null, null, null);
        this.eDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eEa) {
                    f.this.ii(true);
                } else {
                    f.this.ii(false);
                }
            }
        });
    }

    public BdListView aMS() {
        return this.eDU;
    }

    public OfficialBarTipListAdapter aMT() {
        return this.eDV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eDY.setVisibility(0);
            this.eDV.id(true);
            this.eDV.notifyDataSetChanged();
            if (officialBarTipActivity.aMO()) {
                ih(true);
            } else {
                ih(false);
            }
            this.bxb.setText(officialBarTipActivity.getPageContext().getString(e.j.cancel));
            this.eEd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.eDW.aMP();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.eDX = true;
            return;
        }
        this.eDY.setVisibility(8);
        this.eEd.setVisibility(8);
        this.eDV.id(false);
        this.eDV.notifyDataSetChanged();
        this.bxb.setText(officialBarTipActivity.getPageContext().getString(e.j.edit));
        this.eDX = false;
    }

    public void ih(boolean z) {
        if (z) {
            this.eEb.setAlpha(1.0f);
            this.eEb.setEnabled(true);
            return;
        }
        this.eEb.setAlpha(0.3f);
        this.eEb.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eDV.setData(list);
        if (list != null && list.size() <= 0) {
            this.bxb.setVisibility(8);
        }
    }

    public void ii(boolean z) {
        int h = l.h(this.eDW.getPageContext().getPageActivity(), e.C0200e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.eDZ.setText(this.eDW.getPageContext().getString(e.j.cancel_select_all));
            this.eDZ.setCompoundDrawables(drawable, null, null, null);
            ih(true);
            this.eEa = true;
            this.eDW.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.eDZ.setText(this.eDW.getPageContext().getString(e.j.select_all));
        this.eDZ.setCompoundDrawables(drawable2, null, null, null);
        ih(false);
        this.eEa = false;
        this.eDW.updateEditStatus(false);
    }
}
