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
    private BdListView eCA;
    private OfficialBarTipListAdapter eCB;
    private OfficialBarTipActivity eCC;
    private boolean eCD;
    private RelativeLayout eCE;
    private TextView eCF;
    private boolean eCG;
    private TextView eCH;
    private View eCI;
    private TextView eCJ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eCD = false;
        this.eCE = null;
        this.eCG = false;
        officialBarTipActivity.setContentView(e.h.officialbar_msg_activity);
        this.eCC = officialBarTipActivity;
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
        this.eCI = LayoutInflater.from(this.eCC.getBaseContext()).inflate(e.h.im_ba_btn, (ViewGroup) null);
        this.eCJ = (TextView) this.eCI.findViewById(e.g.all_read);
        this.eCJ.setVisibility(8);
        this.bwq = (TextView) this.eCI.findViewById(e.g.edit);
        this.bwq.setVisibility(0);
        this.eCI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eCI, (View.OnClickListener) null);
        this.bwq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eCD) {
                    if (f.this.eCC.aNt()) {
                        f.this.eCJ.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eCC.getLayoutMode().setNightMode(i == 1);
        this.eCC.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eCC.getPageContext(), i);
        al.b(this.bwq, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.b(this.eCJ, e.d.navi_op_text, e.d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eCC.getPageContext(), i);
        }
        if (this.bJX != null) {
            this.bJX.onChangeSkinType(this.eCC.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eCA = (BdListView) officialBarTipActivity.findViewById(e.g.msg_list);
        this.eCB = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eCA.setAdapter((ListAdapter) this.eCB);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dO(e.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eCE = (RelativeLayout) officialBarTipActivity.findViewById(e.g.tip_footer);
        this.eCH = (TextView) this.eCE.findViewById(e.g.delete_txt);
        this.eCH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aNq();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.eCF = (TextView) this.eCE.findViewById(e.g.select_all_txt);
        int h = l.h(this.eCC.getPageContext().getPageActivity(), e.C0175e.ds40);
        Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.eCF.setText(this.eCC.getPageContext().getString(e.j.select_all));
        this.eCF.setCompoundDrawables(drawable, null, null, null);
        this.eCF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eCG) {
                    f.this.hZ(true);
                } else {
                    f.this.hZ(false);
                }
            }
        });
    }

    public BdListView aNv() {
        return this.eCA;
    }

    public OfficialBarTipListAdapter aNw() {
        return this.eCB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eCE.setVisibility(0);
            this.eCB.hU(true);
            this.eCB.notifyDataSetChanged();
            if (officialBarTipActivity.aNr()) {
                hY(true);
            } else {
                hY(false);
            }
            this.bwq.setText(officialBarTipActivity.getPageContext().getString(e.j.cancel));
            this.eCJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.eCC.aNs();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.eCD = true;
            return;
        }
        this.eCE.setVisibility(8);
        this.eCJ.setVisibility(8);
        this.eCB.hU(false);
        this.eCB.notifyDataSetChanged();
        this.bwq.setText(officialBarTipActivity.getPageContext().getString(e.j.edit));
        this.eCD = false;
    }

    public void hY(boolean z) {
        if (z) {
            this.eCH.setAlpha(1.0f);
            this.eCH.setEnabled(true);
            return;
        }
        this.eCH.setAlpha(0.3f);
        this.eCH.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eCB.setData(list);
        if (list != null && list.size() <= 0) {
            this.bwq.setVisibility(8);
        }
    }

    public void hZ(boolean z) {
        int h = l.h(this.eCC.getPageContext().getPageActivity(), e.C0175e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.eCF.setText(this.eCC.getPageContext().getString(e.j.cancel_select_all));
            this.eCF.setCompoundDrawables(drawable, null, null, null);
            hY(true);
            this.eCG = true;
            this.eCC.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.eCF.setText(this.eCC.getPageContext().getString(e.j.select_all));
        this.eCF.setCompoundDrawables(drawable2, null, null, null);
        hY(false);
        this.eCG = false;
        this.eCC.updateEditStatus(false);
    }
}
