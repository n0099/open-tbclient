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
    private TextView bAy;
    private NoNetworkView bOx;
    private BdListView eKJ;
    private OfficialBarTipListAdapter eKK;
    private OfficialBarTipActivity eKL;
    private boolean eKM;
    private RelativeLayout eKN;
    private TextView eKO;
    private boolean eKP;
    private TextView eKQ;
    private View eKR;
    private TextView eKS;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eKM = false;
        this.eKN = null;
        this.eKP = false;
        officialBarTipActivity.setContentView(e.h.officialbar_msg_activity);
        this.eKL = officialBarTipActivity;
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
        this.bOx = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.eKR = LayoutInflater.from(this.eKL.getBaseContext()).inflate(e.h.im_ba_btn, (ViewGroup) null);
        this.eKS = (TextView) this.eKR.findViewById(e.g.all_read);
        this.eKS.setVisibility(8);
        this.bAy = (TextView) this.eKR.findViewById(e.g.edit);
        this.bAy.setVisibility(0);
        this.eKR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eKR, (View.OnClickListener) null);
        this.bAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eKM) {
                    if (f.this.eKL.aOH()) {
                        f.this.eKS.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eKL.getLayoutMode().setNightMode(i == 1);
        this.eKL.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eKL.getPageContext(), i);
        al.b(this.bAy, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.b(this.eKS, e.d.navi_op_text, e.d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eKL.getPageContext(), i);
        }
        if (this.bOx != null) {
            this.bOx.onChangeSkinType(this.eKL.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eKJ = (BdListView) officialBarTipActivity.findViewById(e.g.msg_list);
        this.eKK = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eKJ.setAdapter((ListAdapter) this.eKK);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eq(e.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eKN = (RelativeLayout) officialBarTipActivity.findViewById(e.g.tip_footer);
        this.eKQ = (TextView) this.eKN.findViewById(e.g.delete_txt);
        this.eKQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aOE();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.eKO = (TextView) this.eKN.findViewById(e.g.select_all_txt);
        int h = l.h(this.eKL.getPageContext().getPageActivity(), e.C0210e.ds40);
        Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, h, h);
        this.eKO.setText(this.eKL.getPageContext().getString(e.j.select_all));
        this.eKO.setCompoundDrawables(drawable, null, null, null);
        this.eKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.eKP) {
                    f.this.il(true);
                } else {
                    f.this.il(false);
                }
            }
        });
    }

    public BdListView aOJ() {
        return this.eKJ;
    }

    public OfficialBarTipListAdapter aOK() {
        return this.eKK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eKN.setVisibility(0);
            this.eKK.ig(true);
            this.eKK.notifyDataSetChanged();
            if (officialBarTipActivity.aOF()) {
                ik(true);
            } else {
                ik(false);
            }
            this.bAy.setText(officialBarTipActivity.getPageContext().getString(e.j.cancel));
            this.eKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.eKL.aOG();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.eKM = true;
            return;
        }
        this.eKN.setVisibility(8);
        this.eKS.setVisibility(8);
        this.eKK.ig(false);
        this.eKK.notifyDataSetChanged();
        this.bAy.setText(officialBarTipActivity.getPageContext().getString(e.j.edit));
        this.eKM = false;
    }

    public void ik(boolean z) {
        if (z) {
            this.eKQ.setAlpha(1.0f);
            this.eKQ.setEnabled(true);
            return;
        }
        this.eKQ.setAlpha(0.3f);
        this.eKQ.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eKK.setData(list);
        if (list != null && list.size() <= 0) {
            this.bAy.setVisibility(8);
        }
    }

    public void il(boolean z) {
        int h = l.h(this.eKL.getPageContext().getPageActivity(), e.C0210e.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(e.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, h, h);
            this.eKO.setText(this.eKL.getPageContext().getString(e.j.cancel_select_all));
            this.eKO.setCompoundDrawables(drawable, null, null, null);
            ik(true);
            this.eKP = true;
            this.eKL.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, h, h);
        this.eKO.setText(this.eKL.getPageContext().getString(e.j.select_all));
        this.eKO.setCompoundDrawables(drawable2, null, null, null);
        ik(false);
        this.eKP = false;
        this.eKL.updateEditStatus(false);
    }
}
