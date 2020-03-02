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
    private TextView dXJ;
    private NoNetworkView eli;
    private BdListView hvg;
    private OfficialBarTipListAdapter hvh;
    private OfficialBarTipActivity hvi;
    private boolean hvj;
    private RelativeLayout hvk;
    private TextView hvl;
    private boolean hvm;
    private TextView hvn;
    private View hvo;
    private TextView hvp;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.hvj = false;
        this.hvk = null;
        this.hvm = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hvi = officialBarTipActivity;
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
        this.eli = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.hvo = LayoutInflater.from(this.hvi.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.hvp = (TextView) this.hvo.findViewById(R.id.all_read);
        this.hvp.setVisibility(8);
        this.dXJ = (TextView) this.hvo.findViewById(R.id.edit);
        this.dXJ.setVisibility(0);
        this.hvo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hvo, (View.OnClickListener) null);
        this.dXJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hvj) {
                    if (f.this.hvi.bSF()) {
                        f.this.hvp.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.hvi.getLayoutMode().setNightMode(i == 1);
        this.hvi.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hvi.getPageContext(), i);
        am.setNavbarTitleColor(this.dXJ, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.hvp, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hvi.getPageContext(), i);
        }
        if (this.eli != null) {
            this.eli.onChangeSkinType(this.hvi.getPageContext(), i);
        }
        this.hvh.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.hvg = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.hvh = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.hvg.setAdapter((ListAdapter) this.hvh);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lh(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.hvk = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.hvn = (TextView) this.hvk.findViewById(R.id.delete_txt);
        this.hvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bSC();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.hvl = (TextView) this.hvk.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.hvi.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.hvl.setText(this.hvi.getPageContext().getString(R.string.select_all));
        this.hvl.setCompoundDrawables(drawable, null, null, null);
        this.hvl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hvm) {
                    f.this.nl(true);
                } else {
                    f.this.nl(false);
                }
            }
        });
    }

    public BdListView bSH() {
        return this.hvg;
    }

    public OfficialBarTipListAdapter bSI() {
        return this.hvh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.hvk.setVisibility(0);
            this.hvh.ng(true);
            this.hvh.notifyDataSetChanged();
            if (officialBarTipActivity.bSD()) {
                nk(true);
            } else {
                nk(false);
            }
            this.dXJ.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.hvp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hvi.bSE();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.hvj = true;
            return;
        }
        this.hvk.setVisibility(8);
        this.hvp.setVisibility(8);
        this.hvh.ng(false);
        this.hvh.notifyDataSetChanged();
        this.dXJ.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.hvj = false;
    }

    public void nk(boolean z) {
        if (z) {
            this.hvn.setAlpha(1.0f);
            this.hvn.setEnabled(true);
            return;
        }
        this.hvn.setAlpha(0.3f);
        this.hvn.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.hvh.setData(list);
        if (list != null && list.size() <= 0) {
            this.dXJ.setVisibility(8);
        }
    }

    public void nl(boolean z) {
        int dimens = l.getDimens(this.hvi.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hvl.setText(this.hvi.getPageContext().getString(R.string.cancel_select_all));
            this.hvl.setCompoundDrawables(drawable, null, null, null);
            nk(true);
            this.hvm = true;
            this.hvi.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.hvl.setText(this.hvi.getPageContext().getString(R.string.select_all));
        this.hvl.setCompoundDrawables(drawable2, null, null, null);
        nk(false);
        this.hvm = false;
        this.hvi.updateEditStatus(false);
    }
}
