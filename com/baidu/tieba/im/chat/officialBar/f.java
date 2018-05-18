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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView bcb;
    private NoNetworkView blp;
    private OfficialBarTipActivity dUA;
    private boolean dUB;
    private RelativeLayout dUC;
    private TextView dUD;
    private boolean dUE;
    private TextView dUF;
    private View dUG;
    private TextView dUH;
    private BdListView dUy;
    private OfficialBarTipListAdapter dUz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.dUB = false;
        this.dUC = null;
        this.dUE = false;
        officialBarTipActivity.setContentView(d.i.officialbar_msg_activity);
        this.dUA = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(d.k.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(d.g.root_view);
        this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.dUG = LayoutInflater.from(this.dUA.getBaseContext()).inflate(d.i.im_ba_btn, (ViewGroup) null);
        this.dUH = (TextView) this.dUG.findViewById(d.g.all_read);
        this.dUH.setVisibility(8);
        this.bcb = (TextView) this.dUG.findViewById(d.g.edit);
        this.bcb.setVisibility(0);
        this.dUG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dUG, (View.OnClickListener) null);
        this.bcb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!f.this.dUB) {
                    if (f.this.dUA.aBo()) {
                        f.this.dUH.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.dUA.getLayoutMode().setNightMode(i == 1);
        this.dUA.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.dUA.getPageContext(), i);
        ak.b(this.bcb, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        ak.b(this.dUH, d.C0126d.navi_op_text, d.C0126d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dUA.getPageContext(), i);
        }
        if (this.blp != null) {
            this.blp.onChangeSkinType(this.dUA.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.dUy = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.dUz = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.dUy.setAdapter((ListAdapter) this.dUz);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dp(d.k.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.dUC = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.dUF = (TextView) this.dUC.findViewById(d.g.delete_txt);
        this.dUF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                officialBarTipActivity.aBl();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.dUD = (TextView) this.dUC.findViewById(d.g.select_all_txt);
        int e = l.e(this.dUA.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = ak.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, e, e);
        this.dUD.setText(this.dUA.getPageContext().getString(d.k.select_all));
        this.dUD.setCompoundDrawables(drawable, null, null, null);
        this.dUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!f.this.dUE) {
                    f.this.gQ(true);
                } else {
                    f.this.gQ(false);
                }
            }
        });
    }

    public BdListView aBr() {
        return this.dUy;
    }

    public OfficialBarTipListAdapter aBs() {
        return this.dUz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.dUC.setVisibility(0);
            this.dUz.gL(true);
            this.dUz.notifyDataSetChanged();
            if (officialBarTipActivity.aBm()) {
                gP(true);
            } else {
                gP(false);
            }
            this.bcb.setText(officialBarTipActivity.getPageContext().getString(d.k.cancel));
            this.dUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.dUA.aBn();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.dUB = true;
            return;
        }
        this.dUC.setVisibility(8);
        this.dUH.setVisibility(8);
        this.dUz.gL(false);
        this.dUz.notifyDataSetChanged();
        this.bcb.setText(officialBarTipActivity.getPageContext().getString(d.k.edit));
        this.dUB = false;
    }

    public void gP(boolean z) {
        if (z) {
            this.dUF.setAlpha(1.0f);
            this.dUF.setEnabled(true);
            return;
        }
        this.dUF.setAlpha(0.3f);
        this.dUF.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.dUz.setData(list);
        if (list != null && list.size() <= 0) {
            this.bcb.setVisibility(8);
        }
    }

    public void gQ(boolean z) {
        int e = l.e(this.dUA.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = ak.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, e, e);
            this.dUD.setText(this.dUA.getPageContext().getString(d.k.cancel_select_all));
            this.dUD.setCompoundDrawables(drawable, null, null, null);
            gP(true);
            this.dUE = true;
            this.dUA.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ak.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, e, e);
        this.dUD.setText(this.dUA.getPageContext().getString(d.k.select_all));
        this.dUD.setCompoundDrawables(drawable2, null, null, null);
        gP(false);
        this.dUE = false;
        this.dUA.updateEditStatus(false);
    }
}
