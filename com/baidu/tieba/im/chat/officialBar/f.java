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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.base.d<OfficialBarTipActivity> {
    private NoNetworkView gCe;
    private TextView gio;
    private TextView kAa;
    private boolean kAb;
    private TextView kAc;
    private View kAd;
    private TextView kAe;
    private BdListView kzV;
    private OfficialBarTipListAdapter kzW;
    private OfficialBarTipActivity kzX;
    private boolean kzY;
    private RelativeLayout kzZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.kzY = false;
        this.kzZ = null;
        this.kAb = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kzX = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_forum_list));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.kAd = LayoutInflater.from(this.kzX.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.kAd.setVisibility(8);
        this.kAe = (TextView) this.kAd.findViewById(R.id.all_read);
        this.kAe.setVisibility(8);
        this.gio = (TextView) this.kAd.findViewById(R.id.edit);
        this.gio.setVisibility(0);
        this.kAd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kAd, (View.OnClickListener) null);
        this.gio.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kzY) {
                    if (f.this.kzX.cWT()) {
                        f.this.kAe.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.kzX.getLayoutMode().setNightMode(i == 1);
        this.kzX.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kzX.getPageContext(), i);
        ao.setNavbarTitleColor(this.gio, R.color.navi_op_text, R.color.navi_op_text_skin);
        ao.setNavbarTitleColor(this.kAe, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kzX.getPageContext(), i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.kzX.getPageContext(), i);
        }
        this.kzW.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.kzV = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.kzW = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.kzV.setAdapter((ListAdapter) this.kzW);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ra(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.kzZ = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.kAc = (TextView) this.kzZ.findViewById(R.id.delete_txt);
        this.kAc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cWQ();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.kAa = (TextView) this.kzZ.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.kzX.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ao.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.kAa.setText(this.kzX.getPageContext().getString(R.string.select_all));
        this.kAa.setCompoundDrawables(drawable, null, null, null);
        this.kAa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kAb) {
                    f.this.sB(true);
                } else {
                    f.this.sB(false);
                }
            }
        });
    }

    public BdListView cWW() {
        return this.kzV;
    }

    public OfficialBarTipListAdapter cWX() {
        return this.kzW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.kzZ.setVisibility(0);
            this.kzW.sw(true);
            this.kzW.notifyDataSetChanged();
            if (officialBarTipActivity.cWR()) {
                sA(true);
            } else {
                sA(false);
            }
            this.gio.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.kAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.kzX.cWS();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.kzY = true;
            return;
        }
        this.kzZ.setVisibility(8);
        this.kAe.setVisibility(8);
        this.kzW.sw(false);
        this.kzW.notifyDataSetChanged();
        this.gio.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.kzY = false;
    }

    public void sA(boolean z) {
        if (z) {
            this.kAc.setAlpha(1.0f);
            this.kAc.setEnabled(true);
            return;
        }
        this.kAc.setAlpha(0.3f);
        this.kAc.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.kzW.setData(list);
        if (list != null && list.size() <= 0) {
            this.gio.setVisibility(8);
        }
    }

    public void sB(boolean z) {
        int dimens = l.getDimens(this.kzX.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ao.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.kAa.setText(this.kzX.getPageContext().getString(R.string.cancel_select_all));
            this.kAa.setCompoundDrawables(drawable, null, null, null);
            sA(true);
            this.kAb = true;
            this.kzX.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ao.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.kAa.setText(this.kzX.getPageContext().getString(R.string.select_all));
        this.kAa.setCompoundDrawables(drawable2, null, null, null);
        sA(false);
        this.kAb = false;
        this.kzX.updateEditStatus(false);
    }
}
