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
    private TextView bAB;
    private NoNetworkView bOA;
    private BdListView eNA;
    private OfficialBarTipListAdapter eNB;
    private OfficialBarTipActivity eNC;
    private boolean eND;
    private RelativeLayout eNE;
    private TextView eNF;
    private boolean eNG;
    private TextView eNH;
    private View eNI;
    private TextView eNJ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eND = false;
        this.eNE = null;
        this.eNG = false;
        officialBarTipActivity.setContentView(e.h.officialbar_msg_activity);
        this.eNC = officialBarTipActivity;
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
        this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.eNI = LayoutInflater.from(this.eNC.getBaseContext()).inflate(e.h.im_ba_btn, (ViewGroup) null);
        this.eNJ = (TextView) this.eNI.findViewById(e.g.all_read);
        this.eNJ.setVisibility(8);
        this.bAB = (TextView) this.eNI.findViewById(e.g.edit);
        this.bAB.setVisibility(0);
        this.eNI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eNI, (View.OnClickListener) null);
        this.bAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eND) {
                    if (f.this.eNC.aPv()) {
                        f.this.eNJ.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eNC.getLayoutMode().setNightMode(i == 1);
        this.eNC.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eNC.getPageContext(), i);
        al.b(this.bAB, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.b(this.eNJ, e.d.navi_op_text, e.d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eNC.getPageContext(), i);
        }
        if (this.bOA != null) {
            this.bOA.onChangeSkinType(this.eNC.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eNA = (BdListView) officialBarTipActivity.findViewById(e.g.msg_list);
        this.eNB = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eNA.setAdapter((ListAdapter) this.eNB);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eq(e.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eNE = (RelativeLayout) officialBarTipActivity.findViewById(e.g.tip_footer);
        this.eNH = (TextView) this.eNE.findViewById(e.g.delete_txt);
        this.eNH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aPs();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.eNF = (TextView) this.eNE.findViewById(e.g.select_all_txt);
        int h = l.h(this.eNC.getPageContext().getPageActivity(), e.C0210e.ds40);
        Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.eNF.setText(this.eNC.getPageContext().getString(e.j.select_all));
        this.eNF.setCompoundDrawables(drawable, null, null, null);
        this.eNF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eNG) {
                    f.this.io(true);
                } else {
                    f.this.io(false);
                }
            }
        });
    }

    public BdListView aPx() {
        return this.eNA;
    }

    public OfficialBarTipListAdapter aPy() {
        return this.eNB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eNE.setVisibility(0);
            this.eNB.ij(true);
            this.eNB.notifyDataSetChanged();
            if (officialBarTipActivity.aPt()) {
                in(true);
            } else {
                in(false);
            }
            this.bAB.setText(officialBarTipActivity.getPageContext().getString(e.j.cancel));
            this.eNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.eNC.aPu();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.eND = true;
            return;
        }
        this.eNE.setVisibility(8);
        this.eNJ.setVisibility(8);
        this.eNB.ij(false);
        this.eNB.notifyDataSetChanged();
        this.bAB.setText(officialBarTipActivity.getPageContext().getString(e.j.edit));
        this.eND = false;
    }

    public void in(boolean z) {
        if (z) {
            this.eNH.setAlpha(1.0f);
            this.eNH.setEnabled(true);
            return;
        }
        this.eNH.setAlpha(0.3f);
        this.eNH.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eNB.setData(list);
        if (list != null && list.size() <= 0) {
            this.bAB.setVisibility(8);
        }
    }

    public void io(boolean z) {
        int h = l.h(this.eNC.getPageContext().getPageActivity(), e.C0210e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.eNF.setText(this.eNC.getPageContext().getString(e.j.cancel_select_all));
            this.eNF.setCompoundDrawables(drawable, null, null, null);
            in(true);
            this.eNG = true;
            this.eNC.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.eNF.setText(this.eNC.getPageContext().getString(e.j.select_all));
        this.eNF.setCompoundDrawables(drawable2, null, null, null);
        in(false);
        this.eNG = false;
        this.eNC.updateEditStatus(false);
    }
}
