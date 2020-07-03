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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes13.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView eXl;
    private NoNetworkView fns;
    private BdListView iNm;
    private OfficialBarTipListAdapter iNn;
    private OfficialBarTipActivity iNo;
    private boolean iNp;
    private RelativeLayout iNq;
    private TextView iNr;
    private boolean iNs;
    private TextView iNt;
    private View iNu;
    private TextView iNv;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.iNp = false;
        this.iNq = null;
        this.iNs = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.iNo = officialBarTipActivity;
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
        this.fns = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.iNu = LayoutInflater.from(this.iNo.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.iNv = (TextView) this.iNu.findViewById(R.id.all_read);
        this.iNv.setVisibility(8);
        this.eXl = (TextView) this.iNu.findViewById(R.id.edit);
        this.eXl.setVisibility(0);
        this.iNu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iNu, (View.OnClickListener) null);
        this.eXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.iNp) {
                    if (f.this.iNo.cnS()) {
                        f.this.iNv.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.iNo.getLayoutMode().setNightMode(i == 1);
        this.iNo.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.iNo.getPageContext(), i);
        an.setNavbarTitleColor(this.eXl, R.color.navi_op_text, R.color.navi_op_text_skin);
        an.setNavbarTitleColor(this.iNv, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iNo.getPageContext(), i);
        }
        if (this.fns != null) {
            this.fns.onChangeSkinType(this.iNo.getPageContext(), i);
        }
        this.iNn.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.iNm = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.iNn = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.iNm.setAdapter((ListAdapter) this.iNn);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.mm(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.iNq = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.iNt = (TextView) this.iNq.findViewById(R.id.delete_txt);
        this.iNt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cnP();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.iNr = (TextView) this.iNq.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.iNo.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = an.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.iNr.setText(this.iNo.getPageContext().getString(R.string.select_all));
        this.iNr.setCompoundDrawables(drawable, null, null, null);
        this.iNr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.iNs) {
                    f.this.pb(true);
                } else {
                    f.this.pb(false);
                }
            }
        });
    }

    public BdListView cnV() {
        return this.iNm;
    }

    public OfficialBarTipListAdapter cnW() {
        return this.iNn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.iNq.setVisibility(0);
            this.iNn.oW(true);
            this.iNn.notifyDataSetChanged();
            if (officialBarTipActivity.cnQ()) {
                pa(true);
            } else {
                pa(false);
            }
            this.eXl.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.iNv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.iNo.cnR();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.iNp = true;
            return;
        }
        this.iNq.setVisibility(8);
        this.iNv.setVisibility(8);
        this.iNn.oW(false);
        this.iNn.notifyDataSetChanged();
        this.eXl.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.iNp = false;
    }

    public void pa(boolean z) {
        if (z) {
            this.iNt.setAlpha(1.0f);
            this.iNt.setEnabled(true);
            return;
        }
        this.iNt.setAlpha(0.3f);
        this.iNt.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.iNn.setData(list);
        if (list != null && list.size() <= 0) {
            this.eXl.setVisibility(8);
        }
    }

    public void pb(boolean z) {
        int dimens = l.getDimens(this.iNo.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = an.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.iNr.setText(this.iNo.getPageContext().getString(R.string.cancel_select_all));
            this.iNr.setCompoundDrawables(drawable, null, null, null);
            pa(true);
            this.iNs = true;
            this.iNo.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = an.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.iNr.setText(this.iNo.getPageContext().getString(R.string.select_all));
        this.iNr.setCompoundDrawables(drawable2, null, null, null);
        pa(false);
        this.iNs = false;
        this.iNo.updateEditStatus(false);
    }
}
