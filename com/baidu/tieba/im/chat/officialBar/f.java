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
    private NoNetworkView bBq;
    private TextView bsj;
    private BdListView euM;
    private OfficialBarTipListAdapter euN;
    private OfficialBarTipActivity euO;
    private boolean euP;
    private RelativeLayout euQ;
    private TextView euR;
    private boolean euS;
    private TextView euT;
    private View euU;
    private TextView euV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.euP = false;
        this.euQ = null;
        this.euS = false;
        officialBarTipActivity.setContentView(e.h.officialbar_msg_activity);
        this.euO = officialBarTipActivity;
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
        this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.euU = LayoutInflater.from(this.euO.getBaseContext()).inflate(e.h.im_ba_btn, (ViewGroup) null);
        this.euV = (TextView) this.euU.findViewById(e.g.all_read);
        this.euV.setVisibility(8);
        this.bsj = (TextView) this.euU.findViewById(e.g.edit);
        this.bsj.setVisibility(0);
        this.euU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.euU, (View.OnClickListener) null);
        this.bsj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.euP) {
                    if (f.this.euO.aKd()) {
                        f.this.euV.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.euO.getLayoutMode().setNightMode(i == 1);
        this.euO.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.euO.getPageContext(), i);
        al.b(this.bsj, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.b(this.euV, e.d.navi_op_text, e.d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.euO.getPageContext(), i);
        }
        if (this.bBq != null) {
            this.bBq.onChangeSkinType(this.euO.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.euM = (BdListView) officialBarTipActivity.findViewById(e.g.msg_list);
        this.euN = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.euM.setAdapter((ListAdapter) this.euN);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dE(e.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.euQ = (RelativeLayout) officialBarTipActivity.findViewById(e.g.tip_footer);
        this.euT = (TextView) this.euQ.findViewById(e.g.delete_txt);
        this.euT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aKa();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.euR = (TextView) this.euQ.findViewById(e.g.select_all_txt);
        int h = l.h(this.euO.getPageContext().getPageActivity(), e.C0141e.ds40);
        Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.euR.setText(this.euO.getPageContext().getString(e.j.select_all));
        this.euR.setCompoundDrawables(drawable, null, null, null);
        this.euR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.euS) {
                    f.this.hH(true);
                } else {
                    f.this.hH(false);
                }
            }
        });
    }

    public BdListView aKf() {
        return this.euM;
    }

    public OfficialBarTipListAdapter aKg() {
        return this.euN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.euQ.setVisibility(0);
            this.euN.hC(true);
            this.euN.notifyDataSetChanged();
            if (officialBarTipActivity.aKb()) {
                hG(true);
            } else {
                hG(false);
            }
            this.bsj.setText(officialBarTipActivity.getPageContext().getString(e.j.cancel));
            this.euV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.euO.aKc();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.euP = true;
            return;
        }
        this.euQ.setVisibility(8);
        this.euV.setVisibility(8);
        this.euN.hC(false);
        this.euN.notifyDataSetChanged();
        this.bsj.setText(officialBarTipActivity.getPageContext().getString(e.j.edit));
        this.euP = false;
    }

    public void hG(boolean z) {
        if (z) {
            this.euT.setAlpha(1.0f);
            this.euT.setEnabled(true);
            return;
        }
        this.euT.setAlpha(0.3f);
        this.euT.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.euN.setData(list);
        if (list != null && list.size() <= 0) {
            this.bsj.setVisibility(8);
        }
    }

    public void hH(boolean z) {
        int h = l.h(this.euO.getPageContext().getPageActivity(), e.C0141e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.euR.setText(this.euO.getPageContext().getString(e.j.cancel_select_all));
            this.euR.setCompoundDrawables(drawable, null, null, null);
            hG(true);
            this.euS = true;
            this.euO.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.euR.setText(this.euO.getPageContext().getString(e.j.select_all));
        this.euR.setCompoundDrawables(drawable2, null, null, null);
        hG(false);
        this.euS = false;
        this.euO.updateEditStatus(false);
    }
}
