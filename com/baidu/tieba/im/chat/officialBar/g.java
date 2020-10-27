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
    private TextView fKX;
    private NoNetworkView gdx;
    private BdListView jTd;
    private OfficialBarTipListAdapter jTe;
    private OfficialBarTipActivity jTf;
    private boolean jTg;
    private RelativeLayout jTh;
    private TextView jTi;
    private boolean jTj;
    private TextView jTk;
    private View jTl;
    private TextView jTm;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.jTg = false;
        this.jTh = null;
        this.jTj = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jTf = officialBarTipActivity;
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
        this.gdx = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.jTl = LayoutInflater.from(this.jTf.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.jTl.setVisibility(8);
        this.jTm = (TextView) this.jTl.findViewById(R.id.all_read);
        this.jTm.setVisibility(8);
        this.fKX = (TextView) this.jTl.findViewById(R.id.edit);
        this.fKX.setVisibility(0);
        this.jTl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jTl, (View.OnClickListener) null);
        this.fKX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jTg) {
                    if (g.this.jTf.cML()) {
                        g.this.jTm.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.jTf.getLayoutMode().setNightMode(i == 1);
        this.jTf.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jTf.getPageContext(), i);
        ap.setNavbarTitleColor(this.fKX, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.jTm, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jTf.getPageContext(), i);
        }
        if (this.gdx != null) {
            this.gdx.onChangeSkinType(this.jTf.getPageContext(), i);
        }
        this.jTe.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.jTd = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.jTe = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.jTd.setAdapter((ListAdapter) this.jTe);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pG(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.jTh = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.jTk = (TextView) this.jTh.findViewById(R.id.delete_txt);
        this.jTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cMI();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.jTi = (TextView) this.jTh.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.jTf.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.jTi.setText(this.jTf.getPageContext().getString(R.string.select_all));
        this.jTi.setCompoundDrawables(drawable, null, null, null);
        this.jTi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jTj) {
                    g.this.ru(true);
                } else {
                    g.this.ru(false);
                }
            }
        });
    }

    public BdListView cMO() {
        return this.jTd;
    }

    public OfficialBarTipListAdapter cMP() {
        return this.jTe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.jTh.setVisibility(0);
            this.jTe.rp(true);
            this.jTe.notifyDataSetChanged();
            if (officialBarTipActivity.cMJ()) {
                rt(true);
            } else {
                rt(false);
            }
            this.fKX.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.jTm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.jTf.cMK();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.jTg = true;
            return;
        }
        this.jTh.setVisibility(8);
        this.jTm.setVisibility(8);
        this.jTe.rp(false);
        this.jTe.notifyDataSetChanged();
        this.fKX.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.jTg = false;
    }

    public void rt(boolean z) {
        if (z) {
            this.jTk.setAlpha(1.0f);
            this.jTk.setEnabled(true);
            return;
        }
        this.jTk.setAlpha(0.3f);
        this.jTk.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.jTe.setData(list);
        if (list != null && list.size() <= 0) {
            this.fKX.setVisibility(8);
        }
    }

    public void ru(boolean z) {
        int dimens = l.getDimens(this.jTf.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jTi.setText(this.jTf.getPageContext().getString(R.string.cancel_select_all));
            this.jTi.setCompoundDrawables(drawable, null, null, null);
            rt(true);
            this.jTj = true;
            this.jTf.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.jTi.setText(this.jTf.getPageContext().getString(R.string.select_all));
        this.jTi.setCompoundDrawables(drawable2, null, null, null);
        rt(false);
        this.jTj = false;
        this.jTf.updateEditStatus(false);
    }
}
