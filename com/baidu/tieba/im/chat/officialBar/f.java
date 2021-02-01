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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.base.d<OfficialBarTipActivity> {
    private NoNetworkView gAh;
    private TextView gfU;
    private RelativeLayout kDA;
    private TextView kDB;
    private boolean kDC;
    private TextView kDD;
    private View kDE;
    private TextView kDF;
    private BdListView kDw;
    private OfficialBarTipListAdapter kDx;
    private OfficialBarTipActivity kDy;
    private boolean kDz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.kDz = false;
        this.kDA = null;
        this.kDC = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kDy = officialBarTipActivity;
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
        this.gAh = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.kDE = LayoutInflater.from(this.kDy.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.kDE.setVisibility(8);
        this.kDF = (TextView) this.kDE.findViewById(R.id.all_read);
        this.kDF.setVisibility(8);
        this.gfU = (TextView) this.kDE.findViewById(R.id.edit);
        this.gfU.setVisibility(0);
        this.kDE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kDE, (View.OnClickListener) null);
        this.gfU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kDz) {
                    if (f.this.kDy.cVa()) {
                        f.this.kDF.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.kDy.getLayoutMode().setNightMode(i == 1);
        this.kDy.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kDy.getPageContext(), i);
        ap.setNavbarTitleColor(this.gfU, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.kDF, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kDy.getPageContext(), i);
        }
        if (this.gAh != null) {
            this.gAh.onChangeSkinType(this.kDy.getPageContext(), i);
        }
        this.kDx.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.kDw = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.kDx = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.kDw.setAdapter((ListAdapter) this.kDx);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pz(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.kDA = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.kDD = (TextView) this.kDA.findViewById(R.id.delete_txt);
        this.kDD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cUX();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.kDB = (TextView) this.kDA.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.kDy.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.kDB.setText(this.kDy.getPageContext().getString(R.string.select_all));
        this.kDB.setCompoundDrawables(drawable, null, null, null);
        this.kDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kDC) {
                    f.this.sK(true);
                } else {
                    f.this.sK(false);
                }
            }
        });
    }

    public BdListView cVd() {
        return this.kDw;
    }

    public OfficialBarTipListAdapter cVe() {
        return this.kDx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.kDA.setVisibility(0);
            this.kDx.sF(true);
            this.kDx.notifyDataSetChanged();
            if (officialBarTipActivity.cUY()) {
                sJ(true);
            } else {
                sJ(false);
            }
            this.gfU.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.kDF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.kDy.cUZ();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.kDz = true;
            return;
        }
        this.kDA.setVisibility(8);
        this.kDF.setVisibility(8);
        this.kDx.sF(false);
        this.kDx.notifyDataSetChanged();
        this.gfU.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.kDz = false;
    }

    public void sJ(boolean z) {
        if (z) {
            this.kDD.setAlpha(1.0f);
            this.kDD.setEnabled(true);
            return;
        }
        this.kDD.setAlpha(0.3f);
        this.kDD.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.kDx.setData(list);
        if (list != null && list.size() <= 0) {
            this.gfU.setVisibility(8);
        }
    }

    public void sK(boolean z) {
        int dimens = l.getDimens(this.kDy.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.kDB.setText(this.kDy.getPageContext().getString(R.string.cancel_select_all));
            this.kDB.setCompoundDrawables(drawable, null, null, null);
            sJ(true);
            this.kDC = true;
            this.kDy.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.kDB.setText(this.kDy.getPageContext().getString(R.string.select_all));
        this.kDB.setCompoundDrawables(drawable2, null, null, null);
        sJ(false);
        this.kDC = false;
        this.kDy.updateEditStatus(false);
    }
}
