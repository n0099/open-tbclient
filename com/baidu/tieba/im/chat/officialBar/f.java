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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes13.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView eMZ;
    private NoNetworkView fci;
    private BdListView iwh;
    private OfficialBarTipListAdapter iwi;
    private OfficialBarTipActivity iwj;
    private boolean iwk;
    private RelativeLayout iwl;
    private TextView iwm;
    private boolean iwn;
    private TextView iwo;
    private View iwp;
    private TextView iwq;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.iwk = false;
        this.iwl = null;
        this.iwn = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.iwj = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
        this.fci = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.iwp = LayoutInflater.from(this.iwj.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.iwq = (TextView) this.iwp.findViewById(R.id.all_read);
        this.iwq.setVisibility(8);
        this.eMZ = (TextView) this.iwp.findViewById(R.id.edit);
        this.eMZ.setVisibility(0);
        this.iwp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iwp, (View.OnClickListener) null);
        this.eMZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.iwk) {
                    if (f.this.iwj.ckd()) {
                        f.this.iwq.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.iwj.getLayoutMode().setNightMode(i == 1);
        this.iwj.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.iwj.getPageContext(), i);
        am.setNavbarTitleColor(this.eMZ, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.iwq, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iwj.getPageContext(), i);
        }
        if (this.fci != null) {
            this.fci.onChangeSkinType(this.iwj.getPageContext(), i);
        }
        this.iwi.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.iwh = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.iwi = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.iwh.setAdapter((ListAdapter) this.iwi);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lV(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.iwl = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.iwo = (TextView) this.iwl.findViewById(R.id.delete_txt);
        this.iwo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cka();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.iwm = (TextView) this.iwl.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.iwj.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.iwm.setText(this.iwj.getPageContext().getString(R.string.select_all));
        this.iwm.setCompoundDrawables(drawable, null, null, null);
        this.iwm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.iwn) {
                    f.this.oR(true);
                } else {
                    f.this.oR(false);
                }
            }
        });
    }

    public BdListView ckg() {
        return this.iwh;
    }

    public OfficialBarTipListAdapter ckh() {
        return this.iwi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.iwl.setVisibility(0);
            this.iwi.oM(true);
            this.iwi.notifyDataSetChanged();
            if (officialBarTipActivity.ckb()) {
                oQ(true);
            } else {
                oQ(false);
            }
            this.eMZ.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.iwq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.iwj.ckc();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.iwk = true;
            return;
        }
        this.iwl.setVisibility(8);
        this.iwq.setVisibility(8);
        this.iwi.oM(false);
        this.iwi.notifyDataSetChanged();
        this.eMZ.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.iwk = false;
    }

    public void oQ(boolean z) {
        if (z) {
            this.iwo.setAlpha(1.0f);
            this.iwo.setEnabled(true);
            return;
        }
        this.iwo.setAlpha(0.3f);
        this.iwo.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.iwi.setData(list);
        if (list != null && list.size() <= 0) {
            this.eMZ.setVisibility(8);
        }
    }

    public void oR(boolean z) {
        int dimens = l.getDimens(this.iwj.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.iwm.setText(this.iwj.getPageContext().getString(R.string.cancel_select_all));
            this.iwm.setCompoundDrawables(drawable, null, null, null);
            oQ(true);
            this.iwn = true;
            this.iwj.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.iwm.setText(this.iwj.getPageContext().getString(R.string.select_all));
        this.iwm.setCompoundDrawables(drawable2, null, null, null);
        oQ(false);
        this.iwn = false;
        this.iwj.updateEditStatus(false);
    }
}
