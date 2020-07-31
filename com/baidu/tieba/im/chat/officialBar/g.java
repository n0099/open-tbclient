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
/* loaded from: classes20.dex */
public class g extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView fbM;
    private NoNetworkView fsB;
    private BdListView iTX;
    private OfficialBarTipListAdapter iTY;
    private OfficialBarTipActivity iTZ;
    private boolean iUa;
    private RelativeLayout iUb;
    private TextView iUc;
    private boolean iUd;
    private TextView iUe;
    private View iUf;
    private TextView iUg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.iUa = false;
        this.iUb = null;
        this.iUd = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.iTZ = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_forum_list));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
        this.fsB = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.iUf = LayoutInflater.from(this.iTZ.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.iUf.setVisibility(8);
        this.iUg = (TextView) this.iUf.findViewById(R.id.all_read);
        this.iUg.setVisibility(8);
        this.fbM = (TextView) this.iUf.findViewById(R.id.edit);
        this.fbM.setVisibility(0);
        this.iUf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iUf, (View.OnClickListener) null);
        this.fbM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.iUa) {
                    if (g.this.iTZ.crw()) {
                        g.this.iUg.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.iTZ.getLayoutMode().setNightMode(i == 1);
        this.iTZ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.iTZ.getPageContext(), i);
        ao.setNavbarTitleColor(this.fbM, R.color.navi_op_text, R.color.navi_op_text_skin);
        ao.setNavbarTitleColor(this.iUg, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iTZ.getPageContext(), i);
        }
        if (this.fsB != null) {
            this.fsB.onChangeSkinType(this.iTZ.getPageContext(), i);
        }
        this.iTY.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.iTX = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.iTY = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.iTX.setAdapter((ListAdapter) this.iTY);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.mF(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.iUb = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.iUe = (TextView) this.iUb.findViewById(R.id.delete_txt);
        this.iUe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.crt();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.iUc = (TextView) this.iUb.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.iTZ.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ao.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.iUc.setText(this.iTZ.getPageContext().getString(R.string.select_all));
        this.iUc.setCompoundDrawables(drawable, null, null, null);
        this.iUc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.iUd) {
                    g.this.pG(true);
                } else {
                    g.this.pG(false);
                }
            }
        });
    }

    public BdListView crz() {
        return this.iTX;
    }

    public OfficialBarTipListAdapter crA() {
        return this.iTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.iUb.setVisibility(0);
            this.iTY.pB(true);
            this.iTY.notifyDataSetChanged();
            if (officialBarTipActivity.cru()) {
                pF(true);
            } else {
                pF(false);
            }
            this.fbM.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.iUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.iTZ.crv();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.iUa = true;
            return;
        }
        this.iUb.setVisibility(8);
        this.iUg.setVisibility(8);
        this.iTY.pB(false);
        this.iTY.notifyDataSetChanged();
        this.fbM.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.iUa = false;
    }

    public void pF(boolean z) {
        if (z) {
            this.iUe.setAlpha(1.0f);
            this.iUe.setEnabled(true);
            return;
        }
        this.iUe.setAlpha(0.3f);
        this.iUe.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.iTY.setData(list);
        if (list != null && list.size() <= 0) {
            this.fbM.setVisibility(8);
        }
    }

    public void pG(boolean z) {
        int dimens = l.getDimens(this.iTZ.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ao.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.iUc.setText(this.iTZ.getPageContext().getString(R.string.cancel_select_all));
            this.iUc.setCompoundDrawables(drawable, null, null, null);
            pF(true);
            this.iUd = true;
            this.iTZ.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ao.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.iUc.setText(this.iTZ.getPageContext().getString(R.string.select_all));
        this.iUc.setCompoundDrawables(drawable2, null, null, null);
        pF(false);
        this.iUd = false;
        this.iTZ.updateEditStatus(false);
    }
}
