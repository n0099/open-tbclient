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
    private TextView blL;
    private NoNetworkView buT;
    private BdListView ejE;
    private OfficialBarTipListAdapter ejF;
    private OfficialBarTipActivity ejG;
    private boolean ejH;
    private RelativeLayout ejI;
    private TextView ejJ;
    private boolean ejK;
    private TextView ejL;
    private View ejM;
    private TextView ejN;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.ejH = false;
        this.ejI = null;
        this.ejK = false;
        officialBarTipActivity.setContentView(d.i.officialbar_msg_activity);
        this.ejG = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(d.k.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(d.g.root_view);
        this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.ejM = LayoutInflater.from(this.ejG.getBaseContext()).inflate(d.i.im_ba_btn, (ViewGroup) null);
        this.ejN = (TextView) this.ejM.findViewById(d.g.all_read);
        this.ejN.setVisibility(8);
        this.blL = (TextView) this.ejM.findViewById(d.g.edit);
        this.blL.setVisibility(0);
        this.ejM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ejM, (View.OnClickListener) null);
        this.blL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.ejH) {
                    if (f.this.ejG.aGR()) {
                        f.this.ejN.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.ejG.getLayoutMode().setNightMode(i == 1);
        this.ejG.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.ejG.getPageContext(), i);
        am.b(this.blL, d.C0142d.navi_op_text, d.C0142d.navi_op_text_skin);
        am.b(this.ejN, d.C0142d.navi_op_text, d.C0142d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ejG.getPageContext(), i);
        }
        if (this.buT != null) {
            this.buT.onChangeSkinType(this.ejG.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.ejE = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.ejF = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.ejE.setAdapter((ListAdapter) this.ejF);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ds(d.k.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.ejI = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.ejL = (TextView) this.ejI.findViewById(d.g.delete_txt);
        this.ejL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aGO();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.ejJ = (TextView) this.ejI.findViewById(d.g.select_all_txt);
        int e = l.e(this.ejG.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = am.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, e, e);
        this.ejJ.setText(this.ejG.getPageContext().getString(d.k.select_all));
        this.ejJ.setCompoundDrawables(drawable, null, null, null);
        this.ejJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.ejK) {
                    f.this.hg(true);
                } else {
                    f.this.hg(false);
                }
            }
        });
    }

    public BdListView aGT() {
        return this.ejE;
    }

    public OfficialBarTipListAdapter aGU() {
        return this.ejF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.ejI.setVisibility(0);
            this.ejF.hb(true);
            this.ejF.notifyDataSetChanged();
            if (officialBarTipActivity.aGP()) {
                hf(true);
            } else {
                hf(false);
            }
            this.blL.setText(officialBarTipActivity.getPageContext().getString(d.k.cancel));
            this.ejN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.ejG.aGQ();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.ejH = true;
            return;
        }
        this.ejI.setVisibility(8);
        this.ejN.setVisibility(8);
        this.ejF.hb(false);
        this.ejF.notifyDataSetChanged();
        this.blL.setText(officialBarTipActivity.getPageContext().getString(d.k.edit));
        this.ejH = false;
    }

    public void hf(boolean z) {
        if (z) {
            this.ejL.setAlpha(1.0f);
            this.ejL.setEnabled(true);
            return;
        }
        this.ejL.setAlpha(0.3f);
        this.ejL.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.ejF.setData(list);
        if (list != null && list.size() <= 0) {
            this.blL.setVisibility(8);
        }
    }

    public void hg(boolean z) {
        int e = l.e(this.ejG.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, e, e);
            this.ejJ.setText(this.ejG.getPageContext().getString(d.k.cancel_select_all));
            this.ejJ.setCompoundDrawables(drawable, null, null, null);
            hf(true);
            this.ejK = true;
            this.ejG.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, e, e);
        this.ejJ.setText(this.ejG.getPageContext().getString(d.k.select_all));
        this.ejJ.setCompoundDrawables(drawable2, null, null, null);
        hf(false);
        this.ejK = false;
        this.ejG.updateEditStatus(false);
    }
}
