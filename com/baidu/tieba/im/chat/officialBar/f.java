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
    private TextView cWm;
    private NoNetworkView dnM;
    private boolean gCA;
    private RelativeLayout gCB;
    private TextView gCC;
    private boolean gCD;
    private TextView gCE;
    private View gCF;
    private TextView gCG;
    private BdListView gCx;
    private OfficialBarTipListAdapter gCy;
    private OfficialBarTipActivity gCz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.gCA = false;
        this.gCB = null;
        this.gCD = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gCz = officialBarTipActivity;
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
        this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gCF = LayoutInflater.from(this.gCz.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.gCG = (TextView) this.gCF.findViewById(R.id.all_read);
        this.gCG.setVisibility(8);
        this.cWm = (TextView) this.gCF.findViewById(R.id.edit);
        this.cWm.setVisibility(0);
        this.gCF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCF, (View.OnClickListener) null);
        this.cWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gCA) {
                    if (f.this.gCz.bBf()) {
                        f.this.gCG.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.gCz.getLayoutMode().setNightMode(i == 1);
        this.gCz.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gCz.getPageContext(), i);
        am.e(this.cWm, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.e(this.gCG, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gCz.getPageContext(), i);
        }
        if (this.dnM != null) {
            this.dnM.onChangeSkinType(this.gCz.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.gCx = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.gCy = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.gCx.setAdapter((ListAdapter) this.gCy);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iN(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gCB = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.gCE = (TextView) this.gCB.findViewById(R.id.delete_txt);
        this.gCE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bBc();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gCC = (TextView) this.gCB.findViewById(R.id.select_all_txt);
        int g = l.g(this.gCz.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, g, g);
        this.gCC.setText(this.gCz.getPageContext().getString(R.string.select_all));
        this.gCC.setCompoundDrawables(drawable, null, null, null);
        this.gCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gCD) {
                    f.this.lS(true);
                } else {
                    f.this.lS(false);
                }
            }
        });
    }

    public BdListView bBh() {
        return this.gCx;
    }

    public OfficialBarTipListAdapter bBi() {
        return this.gCy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gCB.setVisibility(0);
            this.gCy.lN(true);
            this.gCy.notifyDataSetChanged();
            if (officialBarTipActivity.bBd()) {
                lR(true);
            } else {
                lR(false);
            }
            this.cWm.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.gCG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gCz.bBe();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.gCA = true;
            return;
        }
        this.gCB.setVisibility(8);
        this.gCG.setVisibility(8);
        this.gCy.lN(false);
        this.gCy.notifyDataSetChanged();
        this.cWm.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.gCA = false;
    }

    public void lR(boolean z) {
        if (z) {
            this.gCE.setAlpha(1.0f);
            this.gCE.setEnabled(true);
            return;
        }
        this.gCE.setAlpha(0.3f);
        this.gCE.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.gCy.setData(list);
        if (list != null && list.size() <= 0) {
            this.cWm.setVisibility(8);
        }
    }

    public void lS(boolean z) {
        int g = l.g(this.gCz.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, g, g);
            this.gCC.setText(this.gCz.getPageContext().getString(R.string.cancel_select_all));
            this.gCC.setCompoundDrawables(drawable, null, null, null);
            lR(true);
            this.gCD = true;
            this.gCz.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, g, g);
        this.gCC.setText(this.gCz.getPageContext().getString(R.string.select_all));
        this.gCC.setCompoundDrawables(drawable2, null, null, null);
        lR(false);
        this.gCD = false;
        this.gCz.updateEditStatus(false);
    }
}
