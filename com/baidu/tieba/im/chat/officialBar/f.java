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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView bkm;
    private NoNetworkView btu;
    private BdListView efL;
    private OfficialBarTipListAdapter efM;
    private OfficialBarTipActivity efN;
    private boolean efO;
    private RelativeLayout efP;
    private TextView efQ;
    private boolean efR;
    private TextView efS;
    private View efT;
    private TextView efU;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.efO = false;
        this.efP = null;
        this.efR = false;
        officialBarTipActivity.setContentView(d.i.officialbar_msg_activity);
        this.efN = officialBarTipActivity;
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
        this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.efT = LayoutInflater.from(this.efN.getBaseContext()).inflate(d.i.im_ba_btn, (ViewGroup) null);
        this.efU = (TextView) this.efT.findViewById(d.g.all_read);
        this.efU.setVisibility(8);
        this.bkm = (TextView) this.efT.findViewById(d.g.edit);
        this.bkm.setVisibility(0);
        this.efT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.efT, (View.OnClickListener) null);
        this.bkm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.efO) {
                    if (f.this.efN.aGj()) {
                        f.this.efU.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.efN.getLayoutMode().setNightMode(i == 1);
        this.efN.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.efN.getPageContext(), i);
        al.b(this.bkm, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        al.b(this.efU, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.efN.getPageContext(), i);
        }
        if (this.btu != null) {
            this.btu.onChangeSkinType(this.efN.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.efL = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.efM = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.efL.setAdapter((ListAdapter) this.efM);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dr(d.k.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.efP = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.efS = (TextView) this.efP.findViewById(d.g.delete_txt);
        this.efS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aGg();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.efQ = (TextView) this.efP.findViewById(d.g.select_all_txt);
        int e = l.e(this.efN.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = al.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, e, e);
        this.efQ.setText(this.efN.getPageContext().getString(d.k.select_all));
        this.efQ.setCompoundDrawables(drawable, null, null, null);
        this.efQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.efR) {
                    f.this.gW(true);
                } else {
                    f.this.gW(false);
                }
            }
        });
    }

    public BdListView aGm() {
        return this.efL;
    }

    public OfficialBarTipListAdapter aGn() {
        return this.efM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.efP.setVisibility(0);
            this.efM.gR(true);
            this.efM.notifyDataSetChanged();
            if (officialBarTipActivity.aGh()) {
                gV(true);
            } else {
                gV(false);
            }
            this.bkm.setText(officialBarTipActivity.getPageContext().getString(d.k.cancel));
            this.efU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.efN.aGi();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.efO = true;
            return;
        }
        this.efP.setVisibility(8);
        this.efU.setVisibility(8);
        this.efM.gR(false);
        this.efM.notifyDataSetChanged();
        this.bkm.setText(officialBarTipActivity.getPageContext().getString(d.k.edit));
        this.efO = false;
    }

    public void gV(boolean z) {
        if (z) {
            this.efS.setAlpha(1.0f);
            this.efS.setEnabled(true);
            return;
        }
        this.efS.setAlpha(0.3f);
        this.efS.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.efM.setData(list);
        if (list != null && list.size() <= 0) {
            this.bkm.setVisibility(8);
        }
    }

    public void gW(boolean z) {
        int e = l.e(this.efN.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, e, e);
            this.efQ.setText(this.efN.getPageContext().getString(d.k.cancel_select_all));
            this.efQ.setCompoundDrawables(drawable, null, null, null);
            gV(true);
            this.efR = true;
            this.efN.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, e, e);
        this.efQ.setText(this.efN.getPageContext().getString(d.k.select_all));
        this.efQ.setCompoundDrawables(drawable2, null, null, null);
        gV(false);
        this.efR = false;
        this.efN.updateEditStatus(false);
    }
}
