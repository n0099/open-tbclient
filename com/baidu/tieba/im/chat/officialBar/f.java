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
    private TextView cWf;
    private NoNetworkView dnF;
    private BdListView gBF;
    private OfficialBarTipListAdapter gBG;
    private OfficialBarTipActivity gBH;
    private boolean gBI;
    private RelativeLayout gBJ;
    private TextView gBK;
    private boolean gBL;
    private TextView gBM;
    private View gBN;
    private TextView gBO;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.gBI = false;
        this.gBJ = null;
        this.gBL = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gBH = officialBarTipActivity;
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
        this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gBN = LayoutInflater.from(this.gBH.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.gBO = (TextView) this.gBN.findViewById(R.id.all_read);
        this.gBO.setVisibility(8);
        this.cWf = (TextView) this.gBN.findViewById(R.id.edit);
        this.cWf.setVisibility(0);
        this.gBN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gBN, (View.OnClickListener) null);
        this.cWf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gBI) {
                    if (f.this.gBH.bAR()) {
                        f.this.gBO.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.gBH.getLayoutMode().setNightMode(i == 1);
        this.gBH.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gBH.getPageContext(), i);
        am.e(this.cWf, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.e(this.gBO, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gBH.getPageContext(), i);
        }
        if (this.dnF != null) {
            this.dnF.onChangeSkinType(this.gBH.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.gBF = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.gBG = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.gBF.setAdapter((ListAdapter) this.gBG);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iN(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gBJ = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.gBM = (TextView) this.gBJ.findViewById(R.id.delete_txt);
        this.gBM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bAO();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gBK = (TextView) this.gBJ.findViewById(R.id.select_all_txt);
        int g = l.g(this.gBH.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, g, g);
        this.gBK.setText(this.gBH.getPageContext().getString(R.string.select_all));
        this.gBK.setCompoundDrawables(drawable, null, null, null);
        this.gBK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gBL) {
                    f.this.lS(true);
                } else {
                    f.this.lS(false);
                }
            }
        });
    }

    public BdListView bAT() {
        return this.gBF;
    }

    public OfficialBarTipListAdapter bAU() {
        return this.gBG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gBJ.setVisibility(0);
            this.gBG.lN(true);
            this.gBG.notifyDataSetChanged();
            if (officialBarTipActivity.bAP()) {
                lR(true);
            } else {
                lR(false);
            }
            this.cWf.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.gBO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gBH.bAQ();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.gBI = true;
            return;
        }
        this.gBJ.setVisibility(8);
        this.gBO.setVisibility(8);
        this.gBG.lN(false);
        this.gBG.notifyDataSetChanged();
        this.cWf.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.gBI = false;
    }

    public void lR(boolean z) {
        if (z) {
            this.gBM.setAlpha(1.0f);
            this.gBM.setEnabled(true);
            return;
        }
        this.gBM.setAlpha(0.3f);
        this.gBM.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.gBG.setData(list);
        if (list != null && list.size() <= 0) {
            this.cWf.setVisibility(8);
        }
    }

    public void lS(boolean z) {
        int g = l.g(this.gBH.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, g, g);
            this.gBK.setText(this.gBH.getPageContext().getString(R.string.cancel_select_all));
            this.gBK.setCompoundDrawables(drawable, null, null, null);
            lR(true);
            this.gBL = true;
            this.gBH.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, g, g);
        this.gBK.setText(this.gBH.getPageContext().getString(R.string.select_all));
        this.gBK.setCompoundDrawables(drawable2, null, null, null);
        lR(false);
        this.gBL = false;
        this.gBH.updateEditStatus(false);
    }
}
