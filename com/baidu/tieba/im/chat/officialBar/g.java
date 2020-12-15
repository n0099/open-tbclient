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
/* loaded from: classes26.dex */
public class g extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView fYH;
    private NoNetworkView grf;
    private BdListView knq;
    private OfficialBarTipListAdapter knr;
    private OfficialBarTipActivity kns;
    private boolean knt;
    private RelativeLayout knu;
    private TextView knv;
    private boolean knw;
    private TextView knx;
    private View kny;
    private TextView knz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.knt = false;
        this.knu = null;
        this.knw = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kns = officialBarTipActivity;
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
        this.grf = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.kny = LayoutInflater.from(this.kns.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.kny.setVisibility(8);
        this.knz = (TextView) this.kny.findViewById(R.id.all_read);
        this.knz.setVisibility(8);
        this.fYH = (TextView) this.kny.findViewById(R.id.edit);
        this.fYH.setVisibility(0);
        this.kny = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kny, (View.OnClickListener) null);
        this.fYH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.knt) {
                    if (g.this.kns.cUh()) {
                        g.this.knz.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.kns.getLayoutMode().setNightMode(i == 1);
        this.kns.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kns.getPageContext(), i);
        ap.setNavbarTitleColor(this.fYH, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.knz, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kns.getPageContext(), i);
        }
        if (this.grf != null) {
            this.grf.onChangeSkinType(this.kns.getPageContext(), i);
        }
        this.knr.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.knq = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.knr = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.knq.setAdapter((ListAdapter) this.knr);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.qP(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.knu = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.knx = (TextView) this.knu.findViewById(R.id.delete_txt);
        this.knx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cUe();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.knv = (TextView) this.knu.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.kns.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.knv.setText(this.kns.getPageContext().getString(R.string.select_all));
        this.knv.setCompoundDrawables(drawable, null, null, null);
        this.knv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.knw) {
                    g.this.si(true);
                } else {
                    g.this.si(false);
                }
            }
        });
    }

    public BdListView cUk() {
        return this.knq;
    }

    public OfficialBarTipListAdapter cUl() {
        return this.knr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.knu.setVisibility(0);
            this.knr.sd(true);
            this.knr.notifyDataSetChanged();
            if (officialBarTipActivity.cUf()) {
                sh(true);
            } else {
                sh(false);
            }
            this.fYH.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.knz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.kns.cUg();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.knt = true;
            return;
        }
        this.knu.setVisibility(8);
        this.knz.setVisibility(8);
        this.knr.sd(false);
        this.knr.notifyDataSetChanged();
        this.fYH.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.knt = false;
    }

    public void sh(boolean z) {
        if (z) {
            this.knx.setAlpha(1.0f);
            this.knx.setEnabled(true);
            return;
        }
        this.knx.setAlpha(0.3f);
        this.knx.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.knr.setData(list);
        if (list != null && list.size() <= 0) {
            this.fYH.setVisibility(8);
        }
    }

    public void si(boolean z) {
        int dimens = l.getDimens(this.kns.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.knv.setText(this.kns.getPageContext().getString(R.string.cancel_select_all));
            this.knv.setCompoundDrawables(drawable, null, null, null);
            sh(true);
            this.knw = true;
            this.kns.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.knv.setText(this.kns.getPageContext().getString(R.string.select_all));
        this.knv.setCompoundDrawables(drawable2, null, null, null);
        sh(false);
        this.knw = false;
        this.kns.updateEditStatus(false);
    }
}
