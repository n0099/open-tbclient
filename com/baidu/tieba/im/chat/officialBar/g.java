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
    private TextView fCC;
    private NoNetworkView fTu;
    private BdListView jGE;
    private OfficialBarTipListAdapter jGF;
    private OfficialBarTipActivity jGG;
    private boolean jGH;
    private RelativeLayout jGI;
    private TextView jGJ;
    private boolean jGK;
    private TextView jGL;
    private View jGM;
    private TextView jGN;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.jGH = false;
        this.jGI = null;
        this.jGK = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jGG = officialBarTipActivity;
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
        this.fTu = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.jGM = LayoutInflater.from(this.jGG.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.jGM.setVisibility(8);
        this.jGN = (TextView) this.jGM.findViewById(R.id.all_read);
        this.jGN.setVisibility(8);
        this.fCC = (TextView) this.jGM.findViewById(R.id.edit);
        this.fCC.setVisibility(0);
        this.jGM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jGM, (View.OnClickListener) null);
        this.fCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jGH) {
                    if (g.this.jGG.cJE()) {
                        g.this.jGN.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.jGG.getLayoutMode().setNightMode(i == 1);
        this.jGG.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jGG.getPageContext(), i);
        ap.setNavbarTitleColor(this.fCC, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.jGN, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jGG.getPageContext(), i);
        }
        if (this.fTu != null) {
            this.fTu.onChangeSkinType(this.jGG.getPageContext(), i);
        }
        this.jGF.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.jGE = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.jGF = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.jGE.setAdapter((ListAdapter) this.jGF);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pv(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.jGI = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.jGL = (TextView) this.jGI.findViewById(R.id.delete_txt);
        this.jGL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cJB();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.jGJ = (TextView) this.jGI.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.jGG.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.jGJ.setText(this.jGG.getPageContext().getString(R.string.select_all));
        this.jGJ.setCompoundDrawables(drawable, null, null, null);
        this.jGJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jGK) {
                    g.this.rc(true);
                } else {
                    g.this.rc(false);
                }
            }
        });
    }

    public BdListView cJH() {
        return this.jGE;
    }

    public OfficialBarTipListAdapter cJI() {
        return this.jGF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.jGI.setVisibility(0);
            this.jGF.qX(true);
            this.jGF.notifyDataSetChanged();
            if (officialBarTipActivity.cJC()) {
                rb(true);
            } else {
                rb(false);
            }
            this.fCC.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.jGN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.jGG.cJD();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.jGH = true;
            return;
        }
        this.jGI.setVisibility(8);
        this.jGN.setVisibility(8);
        this.jGF.qX(false);
        this.jGF.notifyDataSetChanged();
        this.fCC.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.jGH = false;
    }

    public void rb(boolean z) {
        if (z) {
            this.jGL.setAlpha(1.0f);
            this.jGL.setEnabled(true);
            return;
        }
        this.jGL.setAlpha(0.3f);
        this.jGL.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.jGF.setData(list);
        if (list != null && list.size() <= 0) {
            this.fCC.setVisibility(8);
        }
    }

    public void rc(boolean z) {
        int dimens = l.getDimens(this.jGG.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jGJ.setText(this.jGG.getPageContext().getString(R.string.cancel_select_all));
            this.jGJ.setCompoundDrawables(drawable, null, null, null);
            rb(true);
            this.jGK = true;
            this.jGG.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.jGJ.setText(this.jGG.getPageContext().getString(R.string.select_all));
        this.jGJ.setCompoundDrawables(drawable2, null, null, null);
        rb(false);
        this.jGK = false;
        this.jGG.updateEditStatus(false);
    }
}
