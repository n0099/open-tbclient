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
    private NoNetworkView bJX;
    private TextView bwq;
    private BdListView eCB;
    private OfficialBarTipListAdapter eCC;
    private OfficialBarTipActivity eCD;
    private boolean eCE;
    private RelativeLayout eCF;
    private TextView eCG;
    private boolean eCH;
    private TextView eCI;
    private View eCJ;
    private TextView eCK;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eCE = false;
        this.eCF = null;
        this.eCH = false;
        officialBarTipActivity.setContentView(e.h.officialbar_msg_activity);
        this.eCD = officialBarTipActivity;
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
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.eCJ = LayoutInflater.from(this.eCD.getBaseContext()).inflate(e.h.im_ba_btn, (ViewGroup) null);
        this.eCK = (TextView) this.eCJ.findViewById(e.g.all_read);
        this.eCK.setVisibility(8);
        this.bwq = (TextView) this.eCJ.findViewById(e.g.edit);
        this.bwq.setVisibility(0);
        this.eCJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eCJ, (View.OnClickListener) null);
        this.bwq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eCE) {
                    if (f.this.eCD.aNt()) {
                        f.this.eCK.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eCD.getLayoutMode().setNightMode(i == 1);
        this.eCD.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eCD.getPageContext(), i);
        al.b(this.bwq, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.b(this.eCK, e.d.navi_op_text, e.d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eCD.getPageContext(), i);
        }
        if (this.bJX != null) {
            this.bJX.onChangeSkinType(this.eCD.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eCB = (BdListView) officialBarTipActivity.findViewById(e.g.msg_list);
        this.eCC = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eCB.setAdapter((ListAdapter) this.eCC);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dO(e.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eCF = (RelativeLayout) officialBarTipActivity.findViewById(e.g.tip_footer);
        this.eCI = (TextView) this.eCF.findViewById(e.g.delete_txt);
        this.eCI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aNq();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.eCG = (TextView) this.eCF.findViewById(e.g.select_all_txt);
        int h = l.h(this.eCD.getPageContext().getPageActivity(), e.C0175e.ds40);
        Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.eCG.setText(this.eCD.getPageContext().getString(e.j.select_all));
        this.eCG.setCompoundDrawables(drawable, null, null, null);
        this.eCG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eCH) {
                    f.this.hZ(true);
                } else {
                    f.this.hZ(false);
                }
            }
        });
    }

    public BdListView aNv() {
        return this.eCB;
    }

    public OfficialBarTipListAdapter aNw() {
        return this.eCC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eCF.setVisibility(0);
            this.eCC.hU(true);
            this.eCC.notifyDataSetChanged();
            if (officialBarTipActivity.aNr()) {
                hY(true);
            } else {
                hY(false);
            }
            this.bwq.setText(officialBarTipActivity.getPageContext().getString(e.j.cancel));
            this.eCK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.eCD.aNs();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.eCE = true;
            return;
        }
        this.eCF.setVisibility(8);
        this.eCK.setVisibility(8);
        this.eCC.hU(false);
        this.eCC.notifyDataSetChanged();
        this.bwq.setText(officialBarTipActivity.getPageContext().getString(e.j.edit));
        this.eCE = false;
    }

    public void hY(boolean z) {
        if (z) {
            this.eCI.setAlpha(1.0f);
            this.eCI.setEnabled(true);
            return;
        }
        this.eCI.setAlpha(0.3f);
        this.eCI.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eCC.setData(list);
        if (list != null && list.size() <= 0) {
            this.bwq.setVisibility(8);
        }
    }

    public void hZ(boolean z) {
        int h = l.h(this.eCD.getPageContext().getPageActivity(), e.C0175e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.eCG.setText(this.eCD.getPageContext().getString(e.j.cancel_select_all));
            this.eCG.setCompoundDrawables(drawable, null, null, null);
            hY(true);
            this.eCH = true;
            this.eCD.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.eCG.setText(this.eCD.getPageContext().getString(e.j.select_all));
        this.eCG.setCompoundDrawables(drawable2, null, null, null);
        hY(false);
        this.eCH = false;
        this.eCD.updateEditStatus(false);
    }
}
