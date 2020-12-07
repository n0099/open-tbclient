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
    private TextView fYF;
    private NoNetworkView grd;
    private BdListView kno;
    private OfficialBarTipListAdapter knp;
    private OfficialBarTipActivity knq;
    private boolean knr;
    private RelativeLayout kns;
    private TextView knt;
    private boolean knu;
    private TextView knv;
    private View knw;
    private TextView knx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.knr = false;
        this.kns = null;
        this.knu = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.knq = officialBarTipActivity;
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
        this.grd = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.knw = LayoutInflater.from(this.knq.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.knw.setVisibility(8);
        this.knx = (TextView) this.knw.findViewById(R.id.all_read);
        this.knx.setVisibility(8);
        this.fYF = (TextView) this.knw.findViewById(R.id.edit);
        this.fYF.setVisibility(0);
        this.knw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.knw, (View.OnClickListener) null);
        this.fYF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.knr) {
                    if (g.this.knq.cUg()) {
                        g.this.knx.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.knq.getLayoutMode().setNightMode(i == 1);
        this.knq.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.knq.getPageContext(), i);
        ap.setNavbarTitleColor(this.fYF, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.knx, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.knq.getPageContext(), i);
        }
        if (this.grd != null) {
            this.grd.onChangeSkinType(this.knq.getPageContext(), i);
        }
        this.knp.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.kno = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.knp = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.kno.setAdapter((ListAdapter) this.knp);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.qP(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.kns = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.knv = (TextView) this.kns.findViewById(R.id.delete_txt);
        this.knv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cUd();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.knt = (TextView) this.kns.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.knq.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.knt.setText(this.knq.getPageContext().getString(R.string.select_all));
        this.knt.setCompoundDrawables(drawable, null, null, null);
        this.knt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.knu) {
                    g.this.si(true);
                } else {
                    g.this.si(false);
                }
            }
        });
    }

    public BdListView cUj() {
        return this.kno;
    }

    public OfficialBarTipListAdapter cUk() {
        return this.knp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.kns.setVisibility(0);
            this.knp.sd(true);
            this.knp.notifyDataSetChanged();
            if (officialBarTipActivity.cUe()) {
                sh(true);
            } else {
                sh(false);
            }
            this.fYF.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.knx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.knq.cUf();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.knr = true;
            return;
        }
        this.kns.setVisibility(8);
        this.knx.setVisibility(8);
        this.knp.sd(false);
        this.knp.notifyDataSetChanged();
        this.fYF.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.knr = false;
    }

    public void sh(boolean z) {
        if (z) {
            this.knv.setAlpha(1.0f);
            this.knv.setEnabled(true);
            return;
        }
        this.knv.setAlpha(0.3f);
        this.knv.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.knp.setData(list);
        if (list != null && list.size() <= 0) {
            this.fYF.setVisibility(8);
        }
    }

    public void si(boolean z) {
        int dimens = l.getDimens(this.knq.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.knt.setText(this.knq.getPageContext().getString(R.string.cancel_select_all));
            this.knt.setCompoundDrawables(drawable, null, null, null);
            sh(true);
            this.knu = true;
            this.knq.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.knt.setText(this.knq.getPageContext().getString(R.string.select_all));
        this.knt.setCompoundDrawables(drawable2, null, null, null);
        sh(false);
        this.knu = false;
        this.knq.updateEditStatus(false);
    }
}
