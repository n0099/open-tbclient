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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView cXf;
    private NoNetworkView dpy;
    private BdListView gEo;
    private OfficialBarTipListAdapter gEp;
    private OfficialBarTipActivity gEq;
    private boolean gEr;
    private RelativeLayout gEs;
    private TextView gEt;
    private boolean gEu;
    private TextView gEv;
    private View gEw;
    private TextView gEx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.gEr = false;
        this.gEs = null;
        this.gEu = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gEq = officialBarTipActivity;
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
        this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gEw = LayoutInflater.from(this.gEq.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.gEx = (TextView) this.gEw.findViewById(R.id.all_read);
        this.gEx.setVisibility(8);
        this.cXf = (TextView) this.gEw.findViewById(R.id.edit);
        this.cXf.setVisibility(0);
        this.gEw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gEw, (View.OnClickListener) null);
        this.cXf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gEr) {
                    if (f.this.gEq.bBT()) {
                        f.this.gEx.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.gEq.getLayoutMode().setNightMode(i == 1);
        this.gEq.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gEq.getPageContext(), i);
        am.e(this.cXf, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.e(this.gEx, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gEq.getPageContext(), i);
        }
        if (this.dpy != null) {
            this.dpy.onChangeSkinType(this.gEq.getPageContext(), i);
        }
        this.gEp.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.gEo = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.gEp = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.gEo.setAdapter((ListAdapter) this.gEp);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iQ(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gEs = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.gEv = (TextView) this.gEs.findViewById(R.id.delete_txt);
        this.gEv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bBQ();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gEt = (TextView) this.gEs.findViewById(R.id.select_all_txt);
        int g = l.g(this.gEq.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, g, g);
        this.gEt.setText(this.gEq.getPageContext().getString(R.string.select_all));
        this.gEt.setCompoundDrawables(drawable, null, null, null);
        this.gEt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gEu) {
                    f.this.lV(true);
                } else {
                    f.this.lV(false);
                }
            }
        });
    }

    public BdListView bBV() {
        return this.gEo;
    }

    public OfficialBarTipListAdapter bBW() {
        return this.gEp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gEs.setVisibility(0);
            this.gEp.lQ(true);
            this.gEp.notifyDataSetChanged();
            if (officialBarTipActivity.bBR()) {
                lU(true);
            } else {
                lU(false);
            }
            this.cXf.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.gEx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gEq.bBS();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.gEr = true;
            return;
        }
        this.gEs.setVisibility(8);
        this.gEx.setVisibility(8);
        this.gEp.lQ(false);
        this.gEp.notifyDataSetChanged();
        this.cXf.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.gEr = false;
    }

    public void lU(boolean z) {
        if (z) {
            this.gEv.setAlpha(1.0f);
            this.gEv.setEnabled(true);
            return;
        }
        this.gEv.setAlpha(0.3f);
        this.gEv.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.gEp.setData(list);
        if (list != null && list.size() <= 0) {
            this.cXf.setVisibility(8);
        }
    }

    public void lV(boolean z) {
        int g = l.g(this.gEq.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, g, g);
            this.gEt.setText(this.gEq.getPageContext().getString(R.string.cancel_select_all));
            this.gEt.setCompoundDrawables(drawable, null, null, null);
            lU(true);
            this.gEu = true;
            this.gEq.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, g, g);
        this.gEt.setText(this.gEq.getPageContext().getString(R.string.select_all));
        this.gEt.setCompoundDrawables(drawable2, null, null, null);
        lU(false);
        this.gEu = false;
        this.gEq.updateEditStatus(false);
    }
}
