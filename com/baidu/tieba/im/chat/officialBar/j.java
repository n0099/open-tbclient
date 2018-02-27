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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView bRT;
    private NoNetworkView caX;
    private BdListView eyB;
    private OfficialBarTipListAdapter eyC;
    private OfficialBarTipActivity eyD;
    private boolean eyE;
    private RelativeLayout eyF;
    private TextView eyG;
    private boolean eyH;
    private TextView eyI;
    private View eyJ;
    private TextView eyK;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private ViewGroup mRootView;

    public j(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eyE = false;
        this.eyF = null;
        this.eyH = false;
        officialBarTipActivity.setContentView(d.h.officialbar_msg_activity);
        this.eyD = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(d.j.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(d.g.root_view);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.eyJ = LayoutInflater.from(this.eyD.getBaseContext()).inflate(d.h.im_ba_btn, (ViewGroup) null);
        this.eyK = (TextView) this.eyJ.findViewById(d.g.all_read);
        this.eyK.setVisibility(8);
        this.bRT = (TextView) this.eyJ.findViewById(d.g.edit);
        this.bRT.setVisibility(0);
        this.eyJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eyJ, (View.OnClickListener) null);
        this.bRT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.this.eyE) {
                    if (j.this.eyD.aGp()) {
                        j.this.eyK.setVisibility(0);
                    }
                    j.this.a(officialBarTipActivity, true);
                    return;
                }
                j.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eyD.getLayoutMode().aQ(i == 1);
        this.eyD.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eyD.getPageContext(), i);
        aj.d(this.bRT, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        aj.d(this.eyK, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eyD.getPageContext(), i);
        }
        if (this.caX != null) {
            this.caX.onChangeSkinType(this.eyD.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eyB = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.eyC = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eyB.setAdapter((ListAdapter) this.eyC);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gp(d.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eyF = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.eyI = (TextView) this.eyF.findViewById(d.g.delete_txt);
        this.eyI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aGm();
                j.this.a(officialBarTipActivity, false);
            }
        });
        this.eyG = (TextView) this.eyF.findViewById(d.g.select_all_txt);
        int t = l.t(this.eyD.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = aj.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, t, t);
        this.eyG.setText(this.eyD.getPageContext().getString(d.j.select_all));
        this.eyG.setCompoundDrawables(drawable, null, null, null);
        this.eyG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.this.eyH) {
                    j.this.hk(true);
                } else {
                    j.this.hk(false);
                }
            }
        });
    }

    public BdListView aGs() {
        return this.eyB;
    }

    public OfficialBarTipListAdapter aGt() {
        return this.eyC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eyF.setVisibility(0);
            this.eyC.hf(true);
            this.eyC.notifyDataSetChanged();
            if (officialBarTipActivity.aGn()) {
                hj(true);
            } else {
                hj(false);
            }
            this.bRT.setText(officialBarTipActivity.getPageContext().getString(d.j.cancel));
            this.eyK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.eyD.aGo();
                    j.this.a(officialBarTipActivity, false);
                }
            });
            this.eyE = true;
            return;
        }
        this.eyF.setVisibility(8);
        this.eyK.setVisibility(8);
        this.eyC.hf(false);
        this.eyC.notifyDataSetChanged();
        this.bRT.setText(officialBarTipActivity.getPageContext().getString(d.j.edit));
        this.eyE = false;
    }

    public void hj(boolean z) {
        if (z) {
            this.eyI.setAlpha(1.0f);
            this.eyI.setEnabled(true);
            return;
        }
        this.eyI.setAlpha(0.3f);
        this.eyI.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eyC.setData(list);
        if (list != null && list.size() <= 0) {
            this.bRT.setVisibility(8);
        }
    }

    public void hk(boolean z) {
        int t = l.t(this.eyD.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = aj.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, t, t);
            this.eyG.setText(this.eyD.getPageContext().getString(d.j.cancel_select_all));
            this.eyG.setCompoundDrawables(drawable, null, null, null);
            hj(true);
            this.eyH = true;
            this.eyD.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = aj.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, t, t);
        this.eyG.setText(this.eyD.getPageContext().getString(d.j.select_all));
        this.eyG.setCompoundDrawables(drawable2, null, null, null);
        hj(false);
        this.eyH = false;
        this.eyD.updateEditStatus(false);
    }
}
