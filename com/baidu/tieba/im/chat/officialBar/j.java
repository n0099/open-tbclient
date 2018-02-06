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
    private TextView bSg;
    private NoNetworkView cbj;
    private BdListView eyN;
    private OfficialBarTipListAdapter eyO;
    private OfficialBarTipActivity eyP;
    private boolean eyQ;
    private RelativeLayout eyR;
    private TextView eyS;
    private boolean eyT;
    private TextView eyU;
    private View eyV;
    private TextView eyW;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private ViewGroup mRootView;

    public j(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eyQ = false;
        this.eyR = null;
        this.eyT = false;
        officialBarTipActivity.setContentView(d.h.officialbar_msg_activity);
        this.eyP = officialBarTipActivity;
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
        this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.eyV = LayoutInflater.from(this.eyP.getBaseContext()).inflate(d.h.im_ba_btn, (ViewGroup) null);
        this.eyW = (TextView) this.eyV.findViewById(d.g.all_read);
        this.eyW.setVisibility(8);
        this.bSg = (TextView) this.eyV.findViewById(d.g.edit);
        this.bSg.setVisibility(0);
        this.eyV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eyV, (View.OnClickListener) null);
        this.bSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.this.eyQ) {
                    if (j.this.eyP.aGq()) {
                        j.this.eyW.setVisibility(0);
                    }
                    j.this.a(officialBarTipActivity, true);
                    return;
                }
                j.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eyP.getLayoutMode().aQ(i == 1);
        this.eyP.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eyP.getPageContext(), i);
        aj.d(this.bSg, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        aj.d(this.eyW, d.C0140d.navi_op_text, d.C0140d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eyP.getPageContext(), i);
        }
        if (this.cbj != null) {
            this.cbj.onChangeSkinType(this.eyP.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eyN = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.eyO = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eyN.setAdapter((ListAdapter) this.eyO);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gp(d.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eyR = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.eyU = (TextView) this.eyR.findViewById(d.g.delete_txt);
        this.eyU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aGn();
                j.this.a(officialBarTipActivity, false);
            }
        });
        this.eyS = (TextView) this.eyR.findViewById(d.g.select_all_txt);
        int t = l.t(this.eyP.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = aj.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, t, t);
        this.eyS.setText(this.eyP.getPageContext().getString(d.j.select_all));
        this.eyS.setCompoundDrawables(drawable, null, null, null);
        this.eyS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.this.eyT) {
                    j.this.hk(true);
                } else {
                    j.this.hk(false);
                }
            }
        });
    }

    public BdListView aGt() {
        return this.eyN;
    }

    public OfficialBarTipListAdapter aGu() {
        return this.eyO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eyR.setVisibility(0);
            this.eyO.hf(true);
            this.eyO.notifyDataSetChanged();
            if (officialBarTipActivity.aGo()) {
                hj(true);
            } else {
                hj(false);
            }
            this.bSg.setText(officialBarTipActivity.getPageContext().getString(d.j.cancel));
            this.eyW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.eyP.aGp();
                    j.this.a(officialBarTipActivity, false);
                }
            });
            this.eyQ = true;
            return;
        }
        this.eyR.setVisibility(8);
        this.eyW.setVisibility(8);
        this.eyO.hf(false);
        this.eyO.notifyDataSetChanged();
        this.bSg.setText(officialBarTipActivity.getPageContext().getString(d.j.edit));
        this.eyQ = false;
    }

    public void hj(boolean z) {
        if (z) {
            this.eyU.setAlpha(1.0f);
            this.eyU.setEnabled(true);
            return;
        }
        this.eyU.setAlpha(0.3f);
        this.eyU.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eyO.setData(list);
        if (list != null && list.size() <= 0) {
            this.bSg.setVisibility(8);
        }
    }

    public void hk(boolean z) {
        int t = l.t(this.eyP.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = aj.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, t, t);
            this.eyS.setText(this.eyP.getPageContext().getString(d.j.cancel_select_all));
            this.eyS.setCompoundDrawables(drawable, null, null, null);
            hj(true);
            this.eyT = true;
            this.eyP.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = aj.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, t, t);
        this.eyS.setText(this.eyP.getPageContext().getString(d.j.select_all));
        this.eyS.setCompoundDrawables(drawable2, null, null, null);
        hj(false);
        this.eyT = false;
        this.eyP.updateEditStatus(false);
    }
}
