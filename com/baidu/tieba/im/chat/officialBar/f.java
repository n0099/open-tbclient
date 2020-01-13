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
/* loaded from: classes11.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView dTD;
    private NoNetworkView ehd;
    private BdListView htf;
    private OfficialBarTipListAdapter htg;
    private OfficialBarTipActivity hth;
    private boolean hti;
    private RelativeLayout htj;
    private TextView htk;
    private boolean htl;
    private TextView htm;
    private View htn;
    private TextView hto;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.hti = false;
        this.htj = null;
        this.htl = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hth = officialBarTipActivity;
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
        this.ehd = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.htn = LayoutInflater.from(this.hth.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.hto = (TextView) this.htn.findViewById(R.id.all_read);
        this.hto.setVisibility(8);
        this.dTD = (TextView) this.htn.findViewById(R.id.edit);
        this.dTD.setVisibility(0);
        this.htn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.htn, (View.OnClickListener) null);
        this.dTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hti) {
                    if (f.this.hth.bRc()) {
                        f.this.hto.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.hth.getLayoutMode().setNightMode(i == 1);
        this.hth.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hth.getPageContext(), i);
        am.setNavbarTitleColor(this.dTD, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.hto, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hth.getPageContext(), i);
        }
        if (this.ehd != null) {
            this.ehd.onChangeSkinType(this.hth.getPageContext(), i);
        }
        this.htg.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.htf = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.htg = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.htf.setAdapter((ListAdapter) this.htg);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.kQ(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.htj = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.htm = (TextView) this.htj.findViewById(R.id.delete_txt);
        this.htm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bQZ();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.htk = (TextView) this.htj.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.hth.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.htk.setText(this.hth.getPageContext().getString(R.string.select_all));
        this.htk.setCompoundDrawables(drawable, null, null, null);
        this.htk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.htl) {
                    f.this.nj(true);
                } else {
                    f.this.nj(false);
                }
            }
        });
    }

    public BdListView bRe() {
        return this.htf;
    }

    public OfficialBarTipListAdapter bRf() {
        return this.htg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.htj.setVisibility(0);
            this.htg.ne(true);
            this.htg.notifyDataSetChanged();
            if (officialBarTipActivity.bRa()) {
                ni(true);
            } else {
                ni(false);
            }
            this.dTD.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.hto.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hth.bRb();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.hti = true;
            return;
        }
        this.htj.setVisibility(8);
        this.hto.setVisibility(8);
        this.htg.ne(false);
        this.htg.notifyDataSetChanged();
        this.dTD.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.hti = false;
    }

    public void ni(boolean z) {
        if (z) {
            this.htm.setAlpha(1.0f);
            this.htm.setEnabled(true);
            return;
        }
        this.htm.setAlpha(0.3f);
        this.htm.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.htg.setData(list);
        if (list != null && list.size() <= 0) {
            this.dTD.setVisibility(8);
        }
    }

    public void nj(boolean z) {
        int dimens = l.getDimens(this.hth.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.htk.setText(this.hth.getPageContext().getString(R.string.cancel_select_all));
            this.htk.setCompoundDrawables(drawable, null, null, null);
            ni(true);
            this.htl = true;
            this.hth.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.htk.setText(this.hth.getPageContext().getString(R.string.select_all));
        this.htk.setCompoundDrawables(drawable2, null, null, null);
        ni(false);
        this.htl = false;
        this.hth.updateEditStatus(false);
    }
}
