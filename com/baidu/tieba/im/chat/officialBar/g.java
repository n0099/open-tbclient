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
    private TextView fQN;
    private NoNetworkView gjn;
    private BdListView jYZ;
    private OfficialBarTipListAdapter jZa;
    private OfficialBarTipActivity jZb;
    private boolean jZc;
    private RelativeLayout jZd;
    private TextView jZe;
    private boolean jZf;
    private TextView jZg;
    private View jZh;
    private TextView jZi;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.jZc = false;
        this.jZd = null;
        this.jZf = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jZb = officialBarTipActivity;
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
        this.gjn = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.jZh = LayoutInflater.from(this.jZb.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.jZh.setVisibility(8);
        this.jZi = (TextView) this.jZh.findViewById(R.id.all_read);
        this.jZi.setVisibility(8);
        this.fQN = (TextView) this.jZh.findViewById(R.id.edit);
        this.fQN.setVisibility(0);
        this.jZh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jZh, (View.OnClickListener) null);
        this.fQN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jZc) {
                    if (g.this.jZb.cPm()) {
                        g.this.jZi.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.jZb.getLayoutMode().setNightMode(i == 1);
        this.jZb.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jZb.getPageContext(), i);
        ap.setNavbarTitleColor(this.fQN, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.jZi, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jZb.getPageContext(), i);
        }
        if (this.gjn != null) {
            this.gjn.onChangeSkinType(this.jZb.getPageContext(), i);
        }
        this.jZa.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.jYZ = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.jZa = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.jYZ.setAdapter((ListAdapter) this.jZa);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pQ(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.jZd = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.jZg = (TextView) this.jZd.findViewById(R.id.delete_txt);
        this.jZg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cPj();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.jZe = (TextView) this.jZd.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.jZb.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.jZe.setText(this.jZb.getPageContext().getString(R.string.select_all));
        this.jZe.setCompoundDrawables(drawable, null, null, null);
        this.jZe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jZf) {
                    g.this.rD(true);
                } else {
                    g.this.rD(false);
                }
            }
        });
    }

    public BdListView cPp() {
        return this.jYZ;
    }

    public OfficialBarTipListAdapter cPq() {
        return this.jZa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.jZd.setVisibility(0);
            this.jZa.ry(true);
            this.jZa.notifyDataSetChanged();
            if (officialBarTipActivity.cPk()) {
                rC(true);
            } else {
                rC(false);
            }
            this.fQN.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.jZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.jZb.cPl();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.jZc = true;
            return;
        }
        this.jZd.setVisibility(8);
        this.jZi.setVisibility(8);
        this.jZa.ry(false);
        this.jZa.notifyDataSetChanged();
        this.fQN.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.jZc = false;
    }

    public void rC(boolean z) {
        if (z) {
            this.jZg.setAlpha(1.0f);
            this.jZg.setEnabled(true);
            return;
        }
        this.jZg.setAlpha(0.3f);
        this.jZg.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.jZa.setData(list);
        if (list != null && list.size() <= 0) {
            this.fQN.setVisibility(8);
        }
    }

    public void rD(boolean z) {
        int dimens = l.getDimens(this.jZb.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jZe.setText(this.jZb.getPageContext().getString(R.string.cancel_select_all));
            this.jZe.setCompoundDrawables(drawable, null, null, null);
            rC(true);
            this.jZf = true;
            this.jZb.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.jZe.setText(this.jZb.getPageContext().getString(R.string.select_all));
        this.jZe.setCompoundDrawables(drawable2, null, null, null);
        rC(false);
        this.jZf = false;
        this.jZb.updateEditStatus(false);
    }
}
