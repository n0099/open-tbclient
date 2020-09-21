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
/* loaded from: classes25.dex */
public class g extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private NoNetworkView fHl;
    private TextView fqp;
    private BdListView jrH;
    private OfficialBarTipListAdapter jrI;
    private OfficialBarTipActivity jrJ;
    private boolean jrK;
    private RelativeLayout jrL;
    private TextView jrM;
    private boolean jrN;
    private TextView jrO;
    private View jrP;
    private TextView jrQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.jrK = false;
        this.jrL = null;
        this.jrN = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jrJ = officialBarTipActivity;
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
        this.fHl = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.jrP = LayoutInflater.from(this.jrJ.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.jrP.setVisibility(8);
        this.jrQ = (TextView) this.jrP.findViewById(R.id.all_read);
        this.jrQ.setVisibility(8);
        this.fqp = (TextView) this.jrP.findViewById(R.id.edit);
        this.fqp.setVisibility(0);
        this.jrP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jrP, (View.OnClickListener) null);
        this.fqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jrK) {
                    if (g.this.jrJ.cFV()) {
                        g.this.jrQ.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.jrJ.getLayoutMode().setNightMode(i == 1);
        this.jrJ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jrJ.getPageContext(), i);
        ap.setNavbarTitleColor(this.fqp, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.jrQ, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jrJ.getPageContext(), i);
        }
        if (this.fHl != null) {
            this.fHl.onChangeSkinType(this.jrJ.getPageContext(), i);
        }
        this.jrI.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.jrH = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.jrI = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.jrH.setAdapter((ListAdapter) this.jrI);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oW(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.jrL = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.jrO = (TextView) this.jrL.findViewById(R.id.delete_txt);
        this.jrO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cFS();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.jrM = (TextView) this.jrL.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.jrJ.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.jrM.setText(this.jrJ.getPageContext().getString(R.string.select_all));
        this.jrM.setCompoundDrawables(drawable, null, null, null);
        this.jrM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jrN) {
                    g.this.qw(true);
                } else {
                    g.this.qw(false);
                }
            }
        });
    }

    public BdListView cFY() {
        return this.jrH;
    }

    public OfficialBarTipListAdapter cFZ() {
        return this.jrI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.jrL.setVisibility(0);
            this.jrI.qr(true);
            this.jrI.notifyDataSetChanged();
            if (officialBarTipActivity.cFT()) {
                qv(true);
            } else {
                qv(false);
            }
            this.fqp.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.jrQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.jrJ.cFU();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.jrK = true;
            return;
        }
        this.jrL.setVisibility(8);
        this.jrQ.setVisibility(8);
        this.jrI.qr(false);
        this.jrI.notifyDataSetChanged();
        this.fqp.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.jrK = false;
    }

    public void qv(boolean z) {
        if (z) {
            this.jrO.setAlpha(1.0f);
            this.jrO.setEnabled(true);
            return;
        }
        this.jrO.setAlpha(0.3f);
        this.jrO.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.jrI.setData(list);
        if (list != null && list.size() <= 0) {
            this.fqp.setVisibility(8);
        }
    }

    public void qw(boolean z) {
        int dimens = l.getDimens(this.jrJ.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jrM.setText(this.jrJ.getPageContext().getString(R.string.cancel_select_all));
            this.jrM.setCompoundDrawables(drawable, null, null, null);
            qv(true);
            this.jrN = true;
            this.jrJ.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.jrM.setText(this.jrJ.getPageContext().getString(R.string.select_all));
        this.jrM.setCompoundDrawables(drawable2, null, null, null);
        qv(false);
        this.jrN = false;
        this.jrJ.updateEditStatus(false);
    }
}
