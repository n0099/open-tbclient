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
/* loaded from: classes13.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private NoNetworkView ePq;
    private TextView eyo;
    private BdListView igL;
    private OfficialBarTipListAdapter igM;
    private OfficialBarTipActivity igN;
    private boolean igO;
    private RelativeLayout igP;
    private TextView igQ;
    private boolean igR;
    private TextView igS;
    private View igT;
    private TextView igU;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.igO = false;
        this.igP = null;
        this.igR = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.igN = officialBarTipActivity;
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
        this.ePq = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.igT = LayoutInflater.from(this.igN.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.igU = (TextView) this.igT.findViewById(R.id.all_read);
        this.igU.setVisibility(8);
        this.eyo = (TextView) this.igT.findViewById(R.id.edit);
        this.eyo.setVisibility(0);
        this.igT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.igT, (View.OnClickListener) null);
        this.eyo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.igO) {
                    if (f.this.igN.cdw()) {
                        f.this.igU.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.igN.getLayoutMode().setNightMode(i == 1);
        this.igN.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.igN.getPageContext(), i);
        am.setNavbarTitleColor(this.eyo, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.igU, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.igN.getPageContext(), i);
        }
        if (this.ePq != null) {
            this.ePq.onChangeSkinType(this.igN.getPageContext(), i);
        }
        this.igM.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.igL = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.igM = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.igL.setAdapter((ListAdapter) this.igM);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lr(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.igP = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.igS = (TextView) this.igP.findViewById(R.id.delete_txt);
        this.igS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cdt();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.igQ = (TextView) this.igP.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.igN.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.igQ.setText(this.igN.getPageContext().getString(R.string.select_all));
        this.igQ.setCompoundDrawables(drawable, null, null, null);
        this.igQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.igR) {
                    f.this.ov(true);
                } else {
                    f.this.ov(false);
                }
            }
        });
    }

    public BdListView cdz() {
        return this.igL;
    }

    public OfficialBarTipListAdapter cdA() {
        return this.igM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.igP.setVisibility(0);
            this.igM.oq(true);
            this.igM.notifyDataSetChanged();
            if (officialBarTipActivity.cdu()) {
                ou(true);
            } else {
                ou(false);
            }
            this.eyo.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.igU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.igN.cdv();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.igO = true;
            return;
        }
        this.igP.setVisibility(8);
        this.igU.setVisibility(8);
        this.igM.oq(false);
        this.igM.notifyDataSetChanged();
        this.eyo.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.igO = false;
    }

    public void ou(boolean z) {
        if (z) {
            this.igS.setAlpha(1.0f);
            this.igS.setEnabled(true);
            return;
        }
        this.igS.setAlpha(0.3f);
        this.igS.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.igM.setData(list);
        if (list != null && list.size() <= 0) {
            this.eyo.setVisibility(8);
        }
    }

    public void ov(boolean z) {
        int dimens = l.getDimens(this.igN.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.igQ.setText(this.igN.getPageContext().getString(R.string.cancel_select_all));
            this.igQ.setCompoundDrawables(drawable, null, null, null);
            ou(true);
            this.igR = true;
            this.igN.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.igQ.setText(this.igN.getPageContext().getString(R.string.select_all));
        this.igQ.setCompoundDrawables(drawable2, null, null, null);
        ou(false);
        this.igR = false;
        this.igN.updateEditStatus(false);
    }
}
