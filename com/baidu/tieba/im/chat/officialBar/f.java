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
    private TextView cUJ;
    private NoNetworkView dlX;
    private boolean gvA;
    private TextView gvB;
    private View gvC;
    private TextView gvD;
    private BdListView gvu;
    private OfficialBarTipListAdapter gvv;
    private OfficialBarTipActivity gvw;
    private boolean gvx;
    private RelativeLayout gvy;
    private TextView gvz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.gvx = false;
        this.gvy = null;
        this.gvA = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gvw = officialBarTipActivity;
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
        this.gvC = LayoutInflater.from(this.gvw.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.gvD = (TextView) this.gvC.findViewById(R.id.all_read);
        this.gvD.setVisibility(8);
        this.cUJ = (TextView) this.gvC.findViewById(R.id.edit);
        this.cUJ.setVisibility(0);
        this.gvC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gvC, (View.OnClickListener) null);
        this.cUJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gvx) {
                    if (f.this.gvw.byn()) {
                        f.this.gvD.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.gvw.getLayoutMode().setNightMode(i == 1);
        this.gvw.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gvw.getPageContext(), i);
        al.e(this.cUJ, R.color.navi_op_text, R.color.navi_op_text_skin);
        al.e(this.gvD, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gvw.getPageContext(), i);
        }
        if (this.dlX != null) {
            this.dlX.onChangeSkinType(this.gvw.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.gvu = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.gvv = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.gvu.setAdapter((ListAdapter) this.gvv);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iH(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gvy = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.gvB = (TextView) this.gvy.findViewById(R.id.delete_txt);
        this.gvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.byk();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gvz = (TextView) this.gvy.findViewById(R.id.select_all_txt);
        int g = l.g(this.gvw.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = al.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, g, g);
        this.gvz.setText(this.gvw.getPageContext().getString(R.string.select_all));
        this.gvz.setCompoundDrawables(drawable, null, null, null);
        this.gvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gvA) {
                    f.this.lE(true);
                } else {
                    f.this.lE(false);
                }
            }
        });
    }

    public BdListView byp() {
        return this.gvu;
    }

    public OfficialBarTipListAdapter byq() {
        return this.gvv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gvy.setVisibility(0);
            this.gvv.lz(true);
            this.gvv.notifyDataSetChanged();
            if (officialBarTipActivity.byl()) {
                lD(true);
            } else {
                lD(false);
            }
            this.cUJ.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.gvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gvw.bym();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.gvx = true;
            return;
        }
        this.gvy.setVisibility(8);
        this.gvD.setVisibility(8);
        this.gvv.lz(false);
        this.gvv.notifyDataSetChanged();
        this.cUJ.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.gvx = false;
    }

    public void lD(boolean z) {
        if (z) {
            this.gvB.setAlpha(1.0f);
            this.gvB.setEnabled(true);
            return;
        }
        this.gvB.setAlpha(0.3f);
        this.gvB.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.gvv.setData(list);
        if (list != null && list.size() <= 0) {
            this.cUJ.setVisibility(8);
        }
    }

    public void lE(boolean z) {
        int g = l.g(this.gvw.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = al.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, g, g);
            this.gvz.setText(this.gvw.getPageContext().getString(R.string.cancel_select_all));
            this.gvz.setCompoundDrawables(drawable, null, null, null);
            lD(true);
            this.gvA = true;
            this.gvw.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = al.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, g, g);
        this.gvz.setText(this.gvw.getPageContext().getString(R.string.select_all));
        this.gvz.setCompoundDrawables(drawable2, null, null, null);
        lD(false);
        this.gvA = false;
        this.gvw.updateEditStatus(false);
    }
}
