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
    private TextView bBo;
    private NoNetworkView bPl;
    private BdListView eOm;
    private OfficialBarTipListAdapter eOn;
    private OfficialBarTipActivity eOo;
    private boolean eOp;
    private RelativeLayout eOq;
    private TextView eOr;
    private boolean eOs;
    private TextView eOt;
    private View eOu;
    private TextView eOv;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eOp = false;
        this.eOq = null;
        this.eOs = false;
        officialBarTipActivity.setContentView(e.h.officialbar_msg_activity);
        this.eOo = officialBarTipActivity;
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
        this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.eOu = LayoutInflater.from(this.eOo.getBaseContext()).inflate(e.h.im_ba_btn, (ViewGroup) null);
        this.eOv = (TextView) this.eOu.findViewById(e.g.all_read);
        this.eOv.setVisibility(8);
        this.bBo = (TextView) this.eOu.findViewById(e.g.edit);
        this.bBo.setVisibility(0);
        this.eOu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eOu, (View.OnClickListener) null);
        this.bBo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eOp) {
                    if (f.this.eOo.aPV()) {
                        f.this.eOv.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eOo.getLayoutMode().setNightMode(i == 1);
        this.eOo.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eOo.getPageContext(), i);
        al.b(this.bBo, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.b(this.eOv, e.d.navi_op_text, e.d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eOo.getPageContext(), i);
        }
        if (this.bPl != null) {
            this.bPl.onChangeSkinType(this.eOo.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eOm = (BdListView) officialBarTipActivity.findViewById(e.g.msg_list);
        this.eOn = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eOm.setAdapter((ListAdapter) this.eOn);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eq(e.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eOq = (RelativeLayout) officialBarTipActivity.findViewById(e.g.tip_footer);
        this.eOt = (TextView) this.eOq.findViewById(e.g.delete_txt);
        this.eOt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aPS();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.eOr = (TextView) this.eOq.findViewById(e.g.select_all_txt);
        int h = l.h(this.eOo.getPageContext().getPageActivity(), e.C0210e.ds40);
        Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.eOr.setText(this.eOo.getPageContext().getString(e.j.select_all));
        this.eOr.setCompoundDrawables(drawable, null, null, null);
        this.eOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eOs) {
                    f.this.io(true);
                } else {
                    f.this.io(false);
                }
            }
        });
    }

    public BdListView aPX() {
        return this.eOm;
    }

    public OfficialBarTipListAdapter aPY() {
        return this.eOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eOq.setVisibility(0);
            this.eOn.ij(true);
            this.eOn.notifyDataSetChanged();
            if (officialBarTipActivity.aPT()) {
                in(true);
            } else {
                in(false);
            }
            this.bBo.setText(officialBarTipActivity.getPageContext().getString(e.j.cancel));
            this.eOv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.eOo.aPU();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.eOp = true;
            return;
        }
        this.eOq.setVisibility(8);
        this.eOv.setVisibility(8);
        this.eOn.ij(false);
        this.eOn.notifyDataSetChanged();
        this.bBo.setText(officialBarTipActivity.getPageContext().getString(e.j.edit));
        this.eOp = false;
    }

    public void in(boolean z) {
        if (z) {
            this.eOt.setAlpha(1.0f);
            this.eOt.setEnabled(true);
            return;
        }
        this.eOt.setAlpha(0.3f);
        this.eOt.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eOn.setData(list);
        if (list != null && list.size() <= 0) {
            this.bBo.setVisibility(8);
        }
    }

    public void io(boolean z) {
        int h = l.h(this.eOo.getPageContext().getPageActivity(), e.C0210e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.eOr.setText(this.eOo.getPageContext().getString(e.j.cancel_select_all));
            this.eOr.setCompoundDrawables(drawable, null, null, null);
            in(true);
            this.eOs = true;
            this.eOo.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.eOr.setText(this.eOo.getPageContext().getString(e.j.select_all));
        this.eOr.setCompoundDrawables(drawable2, null, null, null);
        in(false);
        this.eOs = false;
        this.eOo.updateEditStatus(false);
    }
}
