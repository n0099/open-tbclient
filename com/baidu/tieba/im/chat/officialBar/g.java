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
    private TextView fQw;
    private NoNetworkView giU;
    private BdListView jZJ;
    private OfficialBarTipListAdapter jZK;
    private OfficialBarTipActivity jZL;
    private boolean jZM;
    private RelativeLayout jZN;
    private TextView jZO;
    private boolean jZP;
    private TextView jZQ;
    private View jZR;
    private TextView jZS;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public g(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.jZM = false;
        this.jZN = null;
        this.jZP = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jZL = officialBarTipActivity;
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
        this.giU = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.jZR = LayoutInflater.from(this.jZL.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.jZR.setVisibility(8);
        this.jZS = (TextView) this.jZR.findViewById(R.id.all_read);
        this.jZS.setVisibility(8);
        this.fQw = (TextView) this.jZR.findViewById(R.id.edit);
        this.fQw.setVisibility(0);
        this.jZR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jZR, (View.OnClickListener) null);
        this.fQw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jZM) {
                    if (g.this.jZL.cOS()) {
                        g.this.jZS.setVisibility(0);
                    }
                    g.this.a(officialBarTipActivity, true);
                    return;
                }
                g.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.jZL.getLayoutMode().setNightMode(i == 1);
        this.jZL.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jZL.getPageContext(), i);
        ap.setNavbarTitleColor(this.fQw, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.jZS, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jZL.getPageContext(), i);
        }
        if (this.giU != null) {
            this.giU.onChangeSkinType(this.jZL.getPageContext(), i);
        }
        this.jZK.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.jZJ = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.jZK = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.jZJ.setAdapter((ListAdapter) this.jZK);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.qo(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.jZN = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.jZQ = (TextView) this.jZN.findViewById(R.id.delete_txt);
        this.jZQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cOP();
                g.this.a(officialBarTipActivity, false);
            }
        });
        this.jZO = (TextView) this.jZN.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.jZL.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.jZO.setText(this.jZL.getPageContext().getString(R.string.select_all));
        this.jZO.setCompoundDrawables(drawable, null, null, null);
        this.jZO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.jZP) {
                    g.this.rG(true);
                } else {
                    g.this.rG(false);
                }
            }
        });
    }

    public BdListView cOV() {
        return this.jZJ;
    }

    public OfficialBarTipListAdapter cOW() {
        return this.jZK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.jZN.setVisibility(0);
            this.jZK.rB(true);
            this.jZK.notifyDataSetChanged();
            if (officialBarTipActivity.cOQ()) {
                rF(true);
            } else {
                rF(false);
            }
            this.fQw.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.jZS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.g.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.jZL.cOR();
                    g.this.a(officialBarTipActivity, false);
                }
            });
            this.jZM = true;
            return;
        }
        this.jZN.setVisibility(8);
        this.jZS.setVisibility(8);
        this.jZK.rB(false);
        this.jZK.notifyDataSetChanged();
        this.fQw.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.jZM = false;
    }

    public void rF(boolean z) {
        if (z) {
            this.jZQ.setAlpha(1.0f);
            this.jZQ.setEnabled(true);
            return;
        }
        this.jZQ.setAlpha(0.3f);
        this.jZQ.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.jZK.setData(list);
        if (list != null && list.size() <= 0) {
            this.fQw.setVisibility(8);
        }
    }

    public void rG(boolean z) {
        int dimens = l.getDimens(this.jZL.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jZO.setText(this.jZL.getPageContext().getString(R.string.cancel_select_all));
            this.jZO.setCompoundDrawables(drawable, null, null, null);
            rF(true);
            this.jZP = true;
            this.jZL.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.jZO.setText(this.jZL.getPageContext().getString(R.string.select_all));
        this.jZO.setCompoundDrawables(drawable2, null, null, null);
        rF(false);
        this.jZP = false;
        this.jZL.updateEditStatus(false);
    }
}
