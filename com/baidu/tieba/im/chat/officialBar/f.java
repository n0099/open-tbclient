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
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView dgA;
    private NoNetworkView dwI;
    private BdListView gCo;
    private OfficialBarTipListAdapter gCp;
    private OfficialBarTipActivity gCq;
    private boolean gCr;
    private RelativeLayout gCs;
    private TextView gCt;
    private boolean gCu;
    private TextView gCv;
    private View gCw;
    private TextView gCx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.gCr = false;
        this.gCs = null;
        this.gCu = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gCq = officialBarTipActivity;
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
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gCw = LayoutInflater.from(this.gCq.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.gCx = (TextView) this.gCw.findViewById(R.id.all_read);
        this.gCx.setVisibility(8);
        this.dgA = (TextView) this.gCw.findViewById(R.id.edit);
        this.dgA.setVisibility(0);
        this.gCw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCw, (View.OnClickListener) null);
        this.dgA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gCr) {
                    if (f.this.gCq.byD()) {
                        f.this.gCx.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.gCq.getLayoutMode().setNightMode(i == 1);
        this.gCq.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gCq.getPageContext(), i);
        am.setNavbarTitleColor(this.dgA, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.gCx, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gCq.getPageContext(), i);
        }
        if (this.dwI != null) {
            this.dwI.onChangeSkinType(this.gCq.getPageContext(), i);
        }
        this.gCp.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.gCo = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.gCp = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.gCo.setAdapter((ListAdapter) this.gCp);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iL(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gCs = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.gCv = (TextView) this.gCs.findViewById(R.id.delete_txt);
        this.gCv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.byA();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gCt = (TextView) this.gCs.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.gCq.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.gCt.setText(this.gCq.getPageContext().getString(R.string.select_all));
        this.gCt.setCompoundDrawables(drawable, null, null, null);
        this.gCt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gCu) {
                    f.this.lJ(true);
                } else {
                    f.this.lJ(false);
                }
            }
        });
    }

    public BdListView byG() {
        return this.gCo;
    }

    public OfficialBarTipListAdapter byH() {
        return this.gCp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gCs.setVisibility(0);
            this.gCp.lE(true);
            this.gCp.notifyDataSetChanged();
            if (officialBarTipActivity.byB()) {
                lI(true);
            } else {
                lI(false);
            }
            this.dgA.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.gCx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gCq.byC();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.gCr = true;
            return;
        }
        this.gCs.setVisibility(8);
        this.gCx.setVisibility(8);
        this.gCp.lE(false);
        this.gCp.notifyDataSetChanged();
        this.dgA.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.gCr = false;
    }

    public void lI(boolean z) {
        if (z) {
            this.gCv.setAlpha(1.0f);
            this.gCv.setEnabled(true);
            return;
        }
        this.gCv.setAlpha(0.3f);
        this.gCv.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.gCp.setData(list);
        if (list != null && list.size() <= 0) {
            this.dgA.setVisibility(8);
        }
    }

    public void lJ(boolean z) {
        int dimens = l.getDimens(this.gCq.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.gCt.setText(this.gCq.getPageContext().getString(R.string.cancel_select_all));
            this.gCt.setCompoundDrawables(drawable, null, null, null);
            lI(true);
            this.gCu = true;
            this.gCq.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.gCt.setText(this.gCq.getPageContext().getString(R.string.select_all));
        this.gCt.setCompoundDrawables(drawable2, null, null, null);
        lI(false);
        this.gCu = false;
        this.gCq.updateEditStatus(false);
    }
}
