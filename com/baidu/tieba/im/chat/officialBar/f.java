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
    private NoNetworkView ePl;
    private TextView eyi;
    private BdListView igF;
    private OfficialBarTipListAdapter igG;
    private OfficialBarTipActivity igH;
    private boolean igI;
    private RelativeLayout igJ;
    private TextView igK;
    private boolean igL;
    private TextView igM;
    private View igN;
    private TextView igO;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.igI = false;
        this.igJ = null;
        this.igL = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.igH = officialBarTipActivity;
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
        this.ePl = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.igN = LayoutInflater.from(this.igH.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.igO = (TextView) this.igN.findViewById(R.id.all_read);
        this.igO.setVisibility(8);
        this.eyi = (TextView) this.igN.findViewById(R.id.edit);
        this.eyi.setVisibility(0);
        this.igN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.igN, (View.OnClickListener) null);
        this.eyi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.igI) {
                    if (f.this.igH.cdx()) {
                        f.this.igO.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.igH.getLayoutMode().setNightMode(i == 1);
        this.igH.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.igH.getPageContext(), i);
        am.setNavbarTitleColor(this.eyi, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.igO, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.igH.getPageContext(), i);
        }
        if (this.ePl != null) {
            this.ePl.onChangeSkinType(this.igH.getPageContext(), i);
        }
        this.igG.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.igF = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.igG = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.igF.setAdapter((ListAdapter) this.igG);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lr(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.igJ = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.igM = (TextView) this.igJ.findViewById(R.id.delete_txt);
        this.igM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cdu();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.igK = (TextView) this.igJ.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.igH.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.igK.setText(this.igH.getPageContext().getString(R.string.select_all));
        this.igK.setCompoundDrawables(drawable, null, null, null);
        this.igK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.igL) {
                    f.this.ov(true);
                } else {
                    f.this.ov(false);
                }
            }
        });
    }

    public BdListView cdA() {
        return this.igF;
    }

    public OfficialBarTipListAdapter cdB() {
        return this.igG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.igJ.setVisibility(0);
            this.igG.oq(true);
            this.igG.notifyDataSetChanged();
            if (officialBarTipActivity.cdv()) {
                ou(true);
            } else {
                ou(false);
            }
            this.eyi.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.igO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.igH.cdw();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.igI = true;
            return;
        }
        this.igJ.setVisibility(8);
        this.igO.setVisibility(8);
        this.igG.oq(false);
        this.igG.notifyDataSetChanged();
        this.eyi.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.igI = false;
    }

    public void ou(boolean z) {
        if (z) {
            this.igM.setAlpha(1.0f);
            this.igM.setEnabled(true);
            return;
        }
        this.igM.setAlpha(0.3f);
        this.igM.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.igG.setData(list);
        if (list != null && list.size() <= 0) {
            this.eyi.setVisibility(8);
        }
    }

    public void ov(boolean z) {
        int dimens = l.getDimens(this.igH.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.igK.setText(this.igH.getPageContext().getString(R.string.cancel_select_all));
            this.igK.setCompoundDrawables(drawable, null, null, null);
            ou(true);
            this.igL = true;
            this.igH.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.igK.setText(this.igH.getPageContext().getString(R.string.select_all));
        this.igK.setCompoundDrawables(drawable2, null, null, null);
        ou(false);
        this.igL = false;
        this.igH.updateEditStatus(false);
    }
}
