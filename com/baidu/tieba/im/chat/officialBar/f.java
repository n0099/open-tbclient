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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView cUI;
    private NoNetworkView dlX;
    private View gvA;
    private TextView gvB;
    private BdListView gvs;
    private OfficialBarTipListAdapter gvt;
    private OfficialBarTipActivity gvu;
    private boolean gvv;
    private RelativeLayout gvw;
    private TextView gvx;
    private boolean gvy;
    private TextView gvz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.gvv = false;
        this.gvw = null;
        this.gvy = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gvu = officialBarTipActivity;
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
        this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gvA = LayoutInflater.from(this.gvu.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.gvB = (TextView) this.gvA.findViewById(R.id.all_read);
        this.gvB.setVisibility(8);
        this.cUI = (TextView) this.gvA.findViewById(R.id.edit);
        this.cUI.setVisibility(0);
        this.gvA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gvA, (View.OnClickListener) null);
        this.cUI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gvv) {
                    if (f.this.gvu.bym()) {
                        f.this.gvB.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.gvu.getLayoutMode().setNightMode(i == 1);
        this.gvu.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gvu.getPageContext(), i);
        al.e(this.cUI, R.color.navi_op_text, R.color.navi_op_text_skin);
        al.e(this.gvB, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gvu.getPageContext(), i);
        }
        if (this.dlX != null) {
            this.dlX.onChangeSkinType(this.gvu.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.gvs = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.gvt = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.gvs.setAdapter((ListAdapter) this.gvt);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iH(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gvw = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.gvz = (TextView) this.gvw.findViewById(R.id.delete_txt);
        this.gvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.byj();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gvx = (TextView) this.gvw.findViewById(R.id.select_all_txt);
        int g = l.g(this.gvu.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = al.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, g, g);
        this.gvx.setText(this.gvu.getPageContext().getString(R.string.select_all));
        this.gvx.setCompoundDrawables(drawable, null, null, null);
        this.gvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gvy) {
                    f.this.lD(true);
                } else {
                    f.this.lD(false);
                }
            }
        });
    }

    public BdListView byo() {
        return this.gvs;
    }

    public OfficialBarTipListAdapter byp() {
        return this.gvt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gvw.setVisibility(0);
            this.gvt.ly(true);
            this.gvt.notifyDataSetChanged();
            if (officialBarTipActivity.byk()) {
                lC(true);
            } else {
                lC(false);
            }
            this.cUI.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.gvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gvu.byl();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.gvv = true;
            return;
        }
        this.gvw.setVisibility(8);
        this.gvB.setVisibility(8);
        this.gvt.ly(false);
        this.gvt.notifyDataSetChanged();
        this.cUI.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.gvv = false;
    }

    public void lC(boolean z) {
        if (z) {
            this.gvz.setAlpha(1.0f);
            this.gvz.setEnabled(true);
            return;
        }
        this.gvz.setAlpha(0.3f);
        this.gvz.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.gvt.setData(list);
        if (list != null && list.size() <= 0) {
            this.cUI.setVisibility(8);
        }
    }

    public void lD(boolean z) {
        int g = l.g(this.gvu.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, g, g);
            this.gvx.setText(this.gvu.getPageContext().getString(R.string.cancel_select_all));
            this.gvx.setCompoundDrawables(drawable, null, null, null);
            lC(true);
            this.gvy = true;
            this.gvu.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, g, g);
        this.gvx.setText(this.gvu.getPageContext().getString(R.string.select_all));
        this.gvx.setCompoundDrawables(drawable2, null, null, null);
        lC(false);
        this.gvy = false;
        this.gvu.updateEditStatus(false);
    }
}
