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
    private NoNetworkView fDZ;
    private TextView fnk;
    private BdListView jjd;
    private OfficialBarTipListAdapter jje;
    private OfficialBarTipActivity jjf;
    private boolean jjg;
    private RelativeLayout jjh;
    private TextView jji;
    private boolean jjj;
    private TextView jjk;
    private View jjl;
    private TextView jjm;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.jjg = false;
        this.jjh = null;
        this.jjj = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jjf = officialBarTipActivity;
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
        this.fDZ = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.jjl = LayoutInflater.from(this.jjf.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.jjl.setVisibility(8);
        this.jjm = (TextView) this.jjl.findViewById(R.id.all_read);
        this.jjm.setVisibility(8);
        this.fnk = (TextView) this.jjl.findViewById(R.id.edit);
        this.fnk.setVisibility(0);
        this.jjl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jjl, (View.OnClickListener) null);
        this.fnk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jjg) {
                    if (g.this.jjf.cCp()) {
                        g.this.jjm.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.jjf.getLayoutMode().setNightMode(i == 1);
        this.jjf.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jjf.getPageContext(), i);
        ap.setNavbarTitleColor(this.fnk, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.jjm, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jjf.getPageContext(), i);
        }
        if (this.fDZ != null) {
            this.fDZ.onChangeSkinType(this.jjf.getPageContext(), i);
        }
        this.jje.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.jjd = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.jje = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.jjd.setAdapter((ListAdapter) this.jje);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oK(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.jjh = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.jjk = (TextView) this.jjh.findViewById(R.id.delete_txt);
        this.jjk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cCm();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.jji = (TextView) this.jjh.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.jjf.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.jji.setText(this.jjf.getPageContext().getString(R.string.select_all));
        this.jji.setCompoundDrawables(drawable, null, null, null);
        this.jji.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jjj) {
                    g.this.qo(true);
                } else {
                    g.this.qo(false);
                }
            }
        });
    }

    public BdListView cCs() {
        return this.jjd;
    }

    public OfficialBarTipListAdapter cCt() {
        return this.jje;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.jjh.setVisibility(0);
            this.jje.qj(true);
            this.jje.notifyDataSetChanged();
            if (officialBarTipActivity.cCn()) {
                qn(true);
            } else {
                qn(false);
            }
            this.fnk.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.jjm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.jjf.cCo();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.jjg = true;
            return;
        }
        this.jjh.setVisibility(8);
        this.jjm.setVisibility(8);
        this.jje.qj(false);
        this.jje.notifyDataSetChanged();
        this.fnk.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.jjg = false;
    }

    public void qn(boolean z) {
        if (z) {
            this.jjk.setAlpha(1.0f);
            this.jjk.setEnabled(true);
            return;
        }
        this.jjk.setAlpha(0.3f);
        this.jjk.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.jje.setData(list);
        if (list != null && list.size() <= 0) {
            this.fnk.setVisibility(8);
        }
    }

    public void qo(boolean z) {
        int dimens = l.getDimens(this.jjf.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jji.setText(this.jjf.getPageContext().getString(R.string.cancel_select_all));
            this.jji.setCompoundDrawables(drawable, null, null, null);
            qn(true);
            this.jjj = true;
            this.jjf.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.jji.setText(this.jjf.getPageContext().getString(R.string.select_all));
        this.jji.setCompoundDrawables(drawable2, null, null, null);
        qn(false);
        this.jjj = false;
        this.jjf.updateEditStatus(false);
    }
}
