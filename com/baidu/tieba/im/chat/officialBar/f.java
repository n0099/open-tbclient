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
    private TextView bBp;
    private NoNetworkView bPm;
    private BdListView eOn;
    private OfficialBarTipListAdapter eOo;
    private OfficialBarTipActivity eOp;
    private boolean eOq;
    private RelativeLayout eOr;
    private TextView eOs;
    private boolean eOt;
    private TextView eOu;
    private View eOv;
    private TextView eOw;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eOq = false;
        this.eOr = null;
        this.eOt = false;
        officialBarTipActivity.setContentView(e.h.officialbar_msg_activity);
        this.eOp = officialBarTipActivity;
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
        this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.eOv = LayoutInflater.from(this.eOp.getBaseContext()).inflate(e.h.im_ba_btn, (ViewGroup) null);
        this.eOw = (TextView) this.eOv.findViewById(e.g.all_read);
        this.eOw.setVisibility(8);
        this.bBp = (TextView) this.eOv.findViewById(e.g.edit);
        this.bBp.setVisibility(0);
        this.eOv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eOv, (View.OnClickListener) null);
        this.bBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eOq) {
                    if (f.this.eOp.aPV()) {
                        f.this.eOw.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eOp.getLayoutMode().setNightMode(i == 1);
        this.eOp.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eOp.getPageContext(), i);
        al.b(this.bBp, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.b(this.eOw, e.d.navi_op_text, e.d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eOp.getPageContext(), i);
        }
        if (this.bPm != null) {
            this.bPm.onChangeSkinType(this.eOp.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eOn = (BdListView) officialBarTipActivity.findViewById(e.g.msg_list);
        this.eOo = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eOn.setAdapter((ListAdapter) this.eOo);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eq(e.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eOr = (RelativeLayout) officialBarTipActivity.findViewById(e.g.tip_footer);
        this.eOu = (TextView) this.eOr.findViewById(e.g.delete_txt);
        this.eOu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aPS();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.eOs = (TextView) this.eOr.findViewById(e.g.select_all_txt);
        int h = l.h(this.eOp.getPageContext().getPageActivity(), e.C0210e.ds40);
        Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.eOs.setText(this.eOp.getPageContext().getString(e.j.select_all));
        this.eOs.setCompoundDrawables(drawable, null, null, null);
        this.eOs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eOt) {
                    f.this.io(true);
                } else {
                    f.this.io(false);
                }
            }
        });
    }

    public BdListView aPX() {
        return this.eOn;
    }

    public OfficialBarTipListAdapter aPY() {
        return this.eOo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eOr.setVisibility(0);
            this.eOo.ij(true);
            this.eOo.notifyDataSetChanged();
            if (officialBarTipActivity.aPT()) {
                in(true);
            } else {
                in(false);
            }
            this.bBp.setText(officialBarTipActivity.getPageContext().getString(e.j.cancel));
            this.eOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.eOp.aPU();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.eOq = true;
            return;
        }
        this.eOr.setVisibility(8);
        this.eOw.setVisibility(8);
        this.eOo.ij(false);
        this.eOo.notifyDataSetChanged();
        this.bBp.setText(officialBarTipActivity.getPageContext().getString(e.j.edit));
        this.eOq = false;
    }

    public void in(boolean z) {
        if (z) {
            this.eOu.setAlpha(1.0f);
            this.eOu.setEnabled(true);
            return;
        }
        this.eOu.setAlpha(0.3f);
        this.eOu.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eOo.setData(list);
        if (list != null && list.size() <= 0) {
            this.bBp.setVisibility(8);
        }
    }

    public void io(boolean z) {
        int h = l.h(this.eOp.getPageContext().getPageActivity(), e.C0210e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.eOs.setText(this.eOp.getPageContext().getString(e.j.cancel_select_all));
            this.eOs.setCompoundDrawables(drawable, null, null, null);
            in(true);
            this.eOt = true;
            this.eOp.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.eOs.setText(this.eOp.getPageContext().getString(e.j.select_all));
        this.eOs.setCompoundDrawables(drawable2, null, null, null);
        in(false);
        this.eOt = false;
        this.eOp.updateEditStatus(false);
    }
}
