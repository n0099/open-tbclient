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
    private BdListView iTZ;
    private OfficialBarTipListAdapter iUa;
    private OfficialBarTipActivity iUb;
    private boolean iUc;
    private RelativeLayout iUd;
    private TextView iUe;
    private boolean iUf;
    private TextView iUg;
    private View iUh;
    private TextView iUi;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.iUc = false;
        this.iUd = null;
        this.iUf = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.iUb = officialBarTipActivity;
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
        this.iUh = LayoutInflater.from(this.iUb.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.iUh.setVisibility(8);
        this.iUi = (TextView) this.iUh.findViewById(R.id.all_read);
        this.iUi.setVisibility(8);
        this.fbM = (TextView) this.iUh.findViewById(R.id.edit);
        this.fbM.setVisibility(0);
        this.iUh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iUh, (View.OnClickListener) null);
        this.fbM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.iUc) {
                    if (g.this.iUb.crw()) {
                        g.this.iUi.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.iUb.getLayoutMode().setNightMode(i == 1);
        this.iUb.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.iUb.getPageContext(), i);
        ao.setNavbarTitleColor(this.fbM, R.color.navi_op_text, R.color.navi_op_text_skin);
        ao.setNavbarTitleColor(this.iUi, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iUb.getPageContext(), i);
        }
        if (this.fsB != null) {
            this.fsB.onChangeSkinType(this.iUb.getPageContext(), i);
        }
        this.iUa.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.iTZ = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.iUa = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.iTZ.setAdapter((ListAdapter) this.iUa);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.mF(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.iUd = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.iUg = (TextView) this.iUd.findViewById(R.id.delete_txt);
        this.iUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.crt();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.iUe = (TextView) this.iUd.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.iUb.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ao.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.iUe.setText(this.iUb.getPageContext().getString(R.string.select_all));
        this.iUe.setCompoundDrawables(drawable, null, null, null);
        this.iUe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.iUf) {
                    g.this.pG(true);
                } else {
                    g.this.pG(false);
                }
            }
        });
    }

    public BdListView crz() {
        return this.iTZ;
    }

    public OfficialBarTipListAdapter crA() {
        return this.iUa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.iUd.setVisibility(0);
            this.iUa.pB(true);
            this.iUa.notifyDataSetChanged();
            if (officialBarTipActivity.cru()) {
                pF(true);
            } else {
                pF(false);
            }
            this.fbM.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.iUi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.iUb.crv();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.iUc = true;
            return;
        }
        this.iUd.setVisibility(8);
        this.iUi.setVisibility(8);
        this.iUa.pB(false);
        this.iUa.notifyDataSetChanged();
        this.fbM.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.iUc = false;
    }

    public void pF(boolean z) {
        if (z) {
            this.iUg.setAlpha(1.0f);
            this.iUg.setEnabled(true);
            return;
        }
        this.iUg.setAlpha(0.3f);
        this.iUg.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.iUa.setData(list);
        if (list != null && list.size() <= 0) {
            this.fbM.setVisibility(8);
        }
    }

    public void pG(boolean z) {
        int dimens = l.getDimens(this.iUb.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ao.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.iUe.setText(this.iUb.getPageContext().getString(R.string.cancel_select_all));
            this.iUe.setCompoundDrawables(drawable, null, null, null);
            pF(true);
            this.iUf = true;
            this.iUb.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ao.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.iUe.setText(this.iUb.getPageContext().getString(R.string.select_all));
        this.iUe.setCompoundDrawables(drawable2, null, null, null);
        pF(false);
        this.iUf = false;
        this.iUb.updateEditStatus(false);
    }
}
