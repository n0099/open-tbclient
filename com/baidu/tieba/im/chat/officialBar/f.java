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
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView dTu;
    private NoNetworkView egT;
    private BdListView hpC;
    private OfficialBarTipListAdapter hpD;
    private OfficialBarTipActivity hpE;
    private boolean hpF;
    private RelativeLayout hpG;
    private TextView hpH;
    private boolean hpI;
    private TextView hpJ;
    private View hpK;
    private TextView hpL;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.hpF = false;
        this.hpG = null;
        this.hpI = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hpE = officialBarTipActivity;
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
        this.egT = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.hpK = LayoutInflater.from(this.hpE.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.hpL = (TextView) this.hpK.findViewById(R.id.all_read);
        this.hpL.setVisibility(8);
        this.dTu = (TextView) this.hpK.findViewById(R.id.edit);
        this.dTu.setVisibility(0);
        this.hpK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hpK, (View.OnClickListener) null);
        this.dTu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hpF) {
                    if (f.this.hpE.bPT()) {
                        f.this.hpL.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.hpE.getLayoutMode().setNightMode(i == 1);
        this.hpE.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hpE.getPageContext(), i);
        am.setNavbarTitleColor(this.dTu, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.hpL, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hpE.getPageContext(), i);
        }
        if (this.egT != null) {
            this.egT.onChangeSkinType(this.hpE.getPageContext(), i);
        }
        this.hpD.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.hpC = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.hpD = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.hpC.setAdapter((ListAdapter) this.hpD);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.kQ(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.hpG = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.hpJ = (TextView) this.hpG.findViewById(R.id.delete_txt);
        this.hpJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bPQ();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.hpH = (TextView) this.hpG.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.hpE.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.hpH.setText(this.hpE.getPageContext().getString(R.string.select_all));
        this.hpH.setCompoundDrawables(drawable, null, null, null);
        this.hpH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hpI) {
                    f.this.mX(true);
                } else {
                    f.this.mX(false);
                }
            }
        });
    }

    public BdListView bPV() {
        return this.hpC;
    }

    public OfficialBarTipListAdapter bPW() {
        return this.hpD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.hpG.setVisibility(0);
            this.hpD.mS(true);
            this.hpD.notifyDataSetChanged();
            if (officialBarTipActivity.bPR()) {
                mW(true);
            } else {
                mW(false);
            }
            this.dTu.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.hpL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hpE.bPS();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.hpF = true;
            return;
        }
        this.hpG.setVisibility(8);
        this.hpL.setVisibility(8);
        this.hpD.mS(false);
        this.hpD.notifyDataSetChanged();
        this.dTu.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.hpF = false;
    }

    public void mW(boolean z) {
        if (z) {
            this.hpJ.setAlpha(1.0f);
            this.hpJ.setEnabled(true);
            return;
        }
        this.hpJ.setAlpha(0.3f);
        this.hpJ.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.hpD.setData(list);
        if (list != null && list.size() <= 0) {
            this.dTu.setVisibility(8);
        }
    }

    public void mX(boolean z) {
        int dimens = l.getDimens(this.hpE.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hpH.setText(this.hpE.getPageContext().getString(R.string.cancel_select_all));
            this.hpH.setCompoundDrawables(drawable, null, null, null);
            mW(true);
            this.hpI = true;
            this.hpE.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.hpH.setText(this.hpE.getPageContext().getString(R.string.select_all));
        this.hpH.setCompoundDrawables(drawable2, null, null, null);
        mW(false);
        this.hpI = false;
        this.hpE.updateEditStatus(false);
    }
}
