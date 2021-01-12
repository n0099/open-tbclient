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
/* loaded from: classes7.dex */
public class f extends com.baidu.adp.base.d<OfficialBarTipActivity> {
    private TextView gdF;
    private NoNetworkView gxx;
    private BdListView kvq;
    private OfficialBarTipListAdapter kvr;
    private OfficialBarTipActivity kvs;
    private boolean kvt;
    private RelativeLayout kvu;
    private TextView kvv;
    private boolean kvw;
    private TextView kvx;
    private View kvy;
    private TextView kvz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.kvt = false;
        this.kvu = null;
        this.kvw = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kvs = officialBarTipActivity;
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
        this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.kvy = LayoutInflater.from(this.kvs.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.kvy.setVisibility(8);
        this.kvz = (TextView) this.kvy.findViewById(R.id.all_read);
        this.kvz.setVisibility(8);
        this.gdF = (TextView) this.kvy.findViewById(R.id.edit);
        this.gdF.setVisibility(0);
        this.kvy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kvy, (View.OnClickListener) null);
        this.gdF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kvt) {
                    if (f.this.kvs.cTc()) {
                        f.this.kvz.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.kvs.getLayoutMode().setNightMode(i == 1);
        this.kvs.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kvs.getPageContext(), i);
        ao.setNavbarTitleColor(this.gdF, R.color.navi_op_text, R.color.navi_op_text_skin);
        ao.setNavbarTitleColor(this.kvz, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kvs.getPageContext(), i);
        }
        if (this.gxx != null) {
            this.gxx.onChangeSkinType(this.kvs.getPageContext(), i);
        }
        this.kvr.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.kvq = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.kvr = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.kvq.setAdapter((ListAdapter) this.kvr);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pu(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.kvu = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.kvx = (TextView) this.kvu.findViewById(R.id.delete_txt);
        this.kvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cSZ();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.kvv = (TextView) this.kvu.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.kvs.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ao.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.kvv.setText(this.kvs.getPageContext().getString(R.string.select_all));
        this.kvv.setCompoundDrawables(drawable, null, null, null);
        this.kvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kvw) {
                    f.this.sx(true);
                } else {
                    f.this.sx(false);
                }
            }
        });
    }

    public BdListView cTf() {
        return this.kvq;
    }

    public OfficialBarTipListAdapter cTg() {
        return this.kvr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.kvu.setVisibility(0);
            this.kvr.ss(true);
            this.kvr.notifyDataSetChanged();
            if (officialBarTipActivity.cTa()) {
                sw(true);
            } else {
                sw(false);
            }
            this.gdF.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.kvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.kvs.cTb();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.kvt = true;
            return;
        }
        this.kvu.setVisibility(8);
        this.kvz.setVisibility(8);
        this.kvr.ss(false);
        this.kvr.notifyDataSetChanged();
        this.gdF.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.kvt = false;
    }

    public void sw(boolean z) {
        if (z) {
            this.kvx.setAlpha(1.0f);
            this.kvx.setEnabled(true);
            return;
        }
        this.kvx.setAlpha(0.3f);
        this.kvx.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.kvr.setData(list);
        if (list != null && list.size() <= 0) {
            this.gdF.setVisibility(8);
        }
    }

    public void sx(boolean z) {
        int dimens = l.getDimens(this.kvs.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ao.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.kvv.setText(this.kvs.getPageContext().getString(R.string.cancel_select_all));
            this.kvv.setCompoundDrawables(drawable, null, null, null);
            sw(true);
            this.kvw = true;
            this.kvs.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ao.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.kvv.setText(this.kvs.getPageContext().getString(R.string.select_all));
        this.kvv.setCompoundDrawables(drawable2, null, null, null);
        sw(false);
        this.kvw = false;
        this.kvs.updateEditStatus(false);
    }
}
