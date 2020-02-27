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
    private TextView dXI;
    private NoNetworkView elh;
    private BdListView hve;
    private OfficialBarTipListAdapter hvf;
    private OfficialBarTipActivity hvg;
    private boolean hvh;
    private RelativeLayout hvi;
    private TextView hvj;
    private boolean hvk;
    private TextView hvl;
    private View hvm;
    private TextView hvn;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.hvh = false;
        this.hvi = null;
        this.hvk = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hvg = officialBarTipActivity;
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
        this.elh = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.hvm = LayoutInflater.from(this.hvg.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.hvn = (TextView) this.hvm.findViewById(R.id.all_read);
        this.hvn.setVisibility(8);
        this.dXI = (TextView) this.hvm.findViewById(R.id.edit);
        this.dXI.setVisibility(0);
        this.hvm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hvm, (View.OnClickListener) null);
        this.dXI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hvh) {
                    if (f.this.hvg.bSD()) {
                        f.this.hvn.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.hvg.getLayoutMode().setNightMode(i == 1);
        this.hvg.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hvg.getPageContext(), i);
        am.setNavbarTitleColor(this.dXI, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.hvn, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hvg.getPageContext(), i);
        }
        if (this.elh != null) {
            this.elh.onChangeSkinType(this.hvg.getPageContext(), i);
        }
        this.hvf.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.hve = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.hvf = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.hve.setAdapter((ListAdapter) this.hvf);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lh(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.hvi = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.hvl = (TextView) this.hvi.findViewById(R.id.delete_txt);
        this.hvl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bSA();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.hvj = (TextView) this.hvi.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.hvg.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.hvj.setText(this.hvg.getPageContext().getString(R.string.select_all));
        this.hvj.setCompoundDrawables(drawable, null, null, null);
        this.hvj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hvk) {
                    f.this.nl(true);
                } else {
                    f.this.nl(false);
                }
            }
        });
    }

    public BdListView bSF() {
        return this.hve;
    }

    public OfficialBarTipListAdapter bSG() {
        return this.hvf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.hvi.setVisibility(0);
            this.hvf.ng(true);
            this.hvf.notifyDataSetChanged();
            if (officialBarTipActivity.bSB()) {
                nk(true);
            } else {
                nk(false);
            }
            this.dXI.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.hvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hvg.bSC();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.hvh = true;
            return;
        }
        this.hvi.setVisibility(8);
        this.hvn.setVisibility(8);
        this.hvf.ng(false);
        this.hvf.notifyDataSetChanged();
        this.dXI.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.hvh = false;
    }

    public void nk(boolean z) {
        if (z) {
            this.hvl.setAlpha(1.0f);
            this.hvl.setEnabled(true);
            return;
        }
        this.hvl.setAlpha(0.3f);
        this.hvl.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.hvf.setData(list);
        if (list != null && list.size() <= 0) {
            this.dXI.setVisibility(8);
        }
    }

    public void nl(boolean z) {
        int dimens = l.getDimens(this.hvg.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hvj.setText(this.hvg.getPageContext().getString(R.string.cancel_select_all));
            this.hvj.setCompoundDrawables(drawable, null, null, null);
            nk(true);
            this.hvk = true;
            this.hvg.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.hvj.setText(this.hvg.getPageContext().getString(R.string.select_all));
        this.hvj.setCompoundDrawables(drawable2, null, null, null);
        nk(false);
        this.hvk = false;
        this.hvg.updateEditStatus(false);
    }
}
