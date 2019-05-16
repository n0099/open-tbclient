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
    private TextView cUH;
    private NoNetworkView dlW;
    private TextView gvA;
    private BdListView gvr;
    private OfficialBarTipListAdapter gvs;
    private OfficialBarTipActivity gvt;
    private boolean gvu;
    private RelativeLayout gvv;
    private TextView gvw;
    private boolean gvx;
    private TextView gvy;
    private View gvz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.gvu = false;
        this.gvv = null;
        this.gvx = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gvt = officialBarTipActivity;
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
        this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gvz = LayoutInflater.from(this.gvt.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.gvA = (TextView) this.gvz.findViewById(R.id.all_read);
        this.gvA.setVisibility(8);
        this.cUH = (TextView) this.gvz.findViewById(R.id.edit);
        this.cUH.setVisibility(0);
        this.gvz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gvz, (View.OnClickListener) null);
        this.cUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gvu) {
                    if (f.this.gvt.byj()) {
                        f.this.gvA.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.gvt.getLayoutMode().setNightMode(i == 1);
        this.gvt.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gvt.getPageContext(), i);
        al.e(this.cUH, R.color.navi_op_text, R.color.navi_op_text_skin);
        al.e(this.gvA, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gvt.getPageContext(), i);
        }
        if (this.dlW != null) {
            this.dlW.onChangeSkinType(this.gvt.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.gvr = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.gvs = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.gvr.setAdapter((ListAdapter) this.gvs);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iH(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gvv = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.gvy = (TextView) this.gvv.findViewById(R.id.delete_txt);
        this.gvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.byg();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gvw = (TextView) this.gvv.findViewById(R.id.select_all_txt);
        int g = l.g(this.gvt.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = al.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, g, g);
        this.gvw.setText(this.gvt.getPageContext().getString(R.string.select_all));
        this.gvw.setCompoundDrawables(drawable, null, null, null);
        this.gvw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gvx) {
                    f.this.lD(true);
                } else {
                    f.this.lD(false);
                }
            }
        });
    }

    public BdListView byl() {
        return this.gvr;
    }

    public OfficialBarTipListAdapter bym() {
        return this.gvs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gvv.setVisibility(0);
            this.gvs.ly(true);
            this.gvs.notifyDataSetChanged();
            if (officialBarTipActivity.byh()) {
                lC(true);
            } else {
                lC(false);
            }
            this.cUH.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.gvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gvt.byi();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.gvu = true;
            return;
        }
        this.gvv.setVisibility(8);
        this.gvA.setVisibility(8);
        this.gvs.ly(false);
        this.gvs.notifyDataSetChanged();
        this.cUH.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.gvu = false;
    }

    public void lC(boolean z) {
        if (z) {
            this.gvy.setAlpha(1.0f);
            this.gvy.setEnabled(true);
            return;
        }
        this.gvy.setAlpha(0.3f);
        this.gvy.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.gvs.setData(list);
        if (list != null && list.size() <= 0) {
            this.cUH.setVisibility(8);
        }
    }

    public void lD(boolean z) {
        int g = l.g(this.gvt.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, g, g);
            this.gvw.setText(this.gvt.getPageContext().getString(R.string.cancel_select_all));
            this.gvw.setCompoundDrawables(drawable, null, null, null);
            lC(true);
            this.gvx = true;
            this.gvt.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, g, g);
        this.gvw.setText(this.gvt.getPageContext().getString(R.string.select_all));
        this.gvw.setCompoundDrawables(drawable2, null, null, null);
        lC(false);
        this.gvx = false;
        this.gvt.updateEditStatus(false);
    }
}
