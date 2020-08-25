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
/* loaded from: classes20.dex */
public class g extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private NoNetworkView fDV;
    private TextView fng;
    private BdListView jiX;
    private OfficialBarTipListAdapter jiY;
    private OfficialBarTipActivity jiZ;
    private boolean jja;
    private RelativeLayout jjb;
    private TextView jjc;
    private boolean jjd;
    private TextView jje;
    private View jjf;
    private TextView jjg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.jja = false;
        this.jjb = null;
        this.jjd = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jiZ = officialBarTipActivity;
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
        this.fDV = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.jjf = LayoutInflater.from(this.jiZ.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.jjf.setVisibility(8);
        this.jjg = (TextView) this.jjf.findViewById(R.id.all_read);
        this.jjg.setVisibility(8);
        this.fng = (TextView) this.jjf.findViewById(R.id.edit);
        this.fng.setVisibility(0);
        this.jjf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jjf, (View.OnClickListener) null);
        this.fng.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jja) {
                    if (g.this.jiZ.cCo()) {
                        g.this.jjg.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.jiZ.getLayoutMode().setNightMode(i == 1);
        this.jiZ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jiZ.getPageContext(), i);
        ap.setNavbarTitleColor(this.fng, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.jjg, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jiZ.getPageContext(), i);
        }
        if (this.fDV != null) {
            this.fDV.onChangeSkinType(this.jiZ.getPageContext(), i);
        }
        this.jiY.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.jiX = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.jiY = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.jiX.setAdapter((ListAdapter) this.jiY);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oK(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.jjb = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.jje = (TextView) this.jjb.findViewById(R.id.delete_txt);
        this.jje.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cCl();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.jjc = (TextView) this.jjb.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.jiZ.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.jjc.setText(this.jiZ.getPageContext().getString(R.string.select_all));
        this.jjc.setCompoundDrawables(drawable, null, null, null);
        this.jjc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jjd) {
                    g.this.qm(true);
                } else {
                    g.this.qm(false);
                }
            }
        });
    }

    public BdListView cCr() {
        return this.jiX;
    }

    public OfficialBarTipListAdapter cCs() {
        return this.jiY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.jjb.setVisibility(0);
            this.jiY.qh(true);
            this.jiY.notifyDataSetChanged();
            if (officialBarTipActivity.cCm()) {
                ql(true);
            } else {
                ql(false);
            }
            this.fng.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.jjg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.jiZ.cCn();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.jja = true;
            return;
        }
        this.jjb.setVisibility(8);
        this.jjg.setVisibility(8);
        this.jiY.qh(false);
        this.jiY.notifyDataSetChanged();
        this.fng.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.jja = false;
    }

    public void ql(boolean z) {
        if (z) {
            this.jje.setAlpha(1.0f);
            this.jje.setEnabled(true);
            return;
        }
        this.jje.setAlpha(0.3f);
        this.jje.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.jiY.setData(list);
        if (list != null && list.size() <= 0) {
            this.fng.setVisibility(8);
        }
    }

    public void qm(boolean z) {
        int dimens = l.getDimens(this.jiZ.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jjc.setText(this.jiZ.getPageContext().getString(R.string.cancel_select_all));
            this.jjc.setCompoundDrawables(drawable, null, null, null);
            ql(true);
            this.jjd = true;
            this.jiZ.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.jjc.setText(this.jiZ.getPageContext().getString(R.string.select_all));
        this.jjc.setCompoundDrawables(drawable2, null, null, null);
        ql(false);
        this.jjd = false;
        this.jiZ.updateEditStatus(false);
    }
}
