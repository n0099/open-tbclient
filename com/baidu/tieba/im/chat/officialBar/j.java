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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView bRW;
    private NoNetworkView cba;
    private BdListView eyR;
    private OfficialBarTipListAdapter eyS;
    private OfficialBarTipActivity eyT;
    private boolean eyU;
    private RelativeLayout eyV;
    private TextView eyW;
    private boolean eyX;
    private TextView eyY;
    private View eyZ;
    private TextView eza;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private ViewGroup mRootView;

    public j(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.eyU = false;
        this.eyV = null;
        this.eyX = false;
        officialBarTipActivity.setContentView(d.h.officialbar_msg_activity);
        this.eyT = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(d.j.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(d.g.root_view);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.eyZ = LayoutInflater.from(this.eyT.getBaseContext()).inflate(d.h.im_ba_btn, (ViewGroup) null);
        this.eza = (TextView) this.eyZ.findViewById(d.g.all_read);
        this.eza.setVisibility(8);
        this.bRW = (TextView) this.eyZ.findViewById(d.g.edit);
        this.bRW.setVisibility(0);
        this.eyZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eyZ, (View.OnClickListener) null);
        this.bRW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.this.eyU) {
                    if (j.this.eyT.aGq()) {
                        j.this.eza.setVisibility(0);
                    }
                    j.this.a(officialBarTipActivity, true);
                    return;
                }
                j.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.eyT.getLayoutMode().aQ(i == 1);
        this.eyT.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eyT.getPageContext(), i);
        aj.d(this.bRW, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        aj.d(this.eza, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eyT.getPageContext(), i);
        }
        if (this.cba != null) {
            this.cba.onChangeSkinType(this.eyT.getPageContext(), i);
        }
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.eyR = (BdListView) officialBarTipActivity.findViewById(d.g.msg_list);
        this.eyS = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.eyR.setAdapter((ListAdapter) this.eyS);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gp(d.j.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.eyV = (RelativeLayout) officialBarTipActivity.findViewById(d.g.tip_footer);
        this.eyY = (TextView) this.eyV.findViewById(d.g.delete_txt);
        this.eyY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.aGn();
                j.this.a(officialBarTipActivity, false);
            }
        });
        this.eyW = (TextView) this.eyV.findViewById(d.g.select_all_txt);
        int t = l.t(this.eyT.getPageContext().getPageActivity(), d.e.ds40);
        Drawable drawable = aj.getDrawable(d.f.btn_bgb_choice_n);
        drawable.setBounds(0, 0, t, t);
        this.eyW.setText(this.eyT.getPageContext().getString(d.j.select_all));
        this.eyW.setCompoundDrawables(drawable, null, null, null);
        this.eyW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.this.eyX) {
                    j.this.hp(true);
                } else {
                    j.this.hp(false);
                }
            }
        });
    }

    public BdListView aGt() {
        return this.eyR;
    }

    public OfficialBarTipListAdapter aGu() {
        return this.eyS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.eyV.setVisibility(0);
            this.eyS.hk(true);
            this.eyS.notifyDataSetChanged();
            if (officialBarTipActivity.aGo()) {
                ho(true);
            } else {
                ho(false);
            }
            this.bRW.setText(officialBarTipActivity.getPageContext().getString(d.j.cancel));
            this.eza.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.eyT.aGp();
                    j.this.a(officialBarTipActivity, false);
                }
            });
            this.eyU = true;
            return;
        }
        this.eyV.setVisibility(8);
        this.eza.setVisibility(8);
        this.eyS.hk(false);
        this.eyS.notifyDataSetChanged();
        this.bRW.setText(officialBarTipActivity.getPageContext().getString(d.j.edit));
        this.eyU = false;
    }

    public void ho(boolean z) {
        if (z) {
            this.eyY.setAlpha(1.0f);
            this.eyY.setEnabled(true);
            return;
        }
        this.eyY.setAlpha(0.3f);
        this.eyY.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.eyS.setData(list);
        if (list != null && list.size() <= 0) {
            this.bRW.setVisibility(8);
        }
    }

    public void hp(boolean z) {
        int t = l.t(this.eyT.getPageContext().getPageActivity(), d.e.ds40);
        if (z) {
            Drawable drawable = aj.getDrawable(d.f.btn_bgb_choice_s);
            drawable.setBounds(0, 0, t, t);
            this.eyW.setText(this.eyT.getPageContext().getString(d.j.cancel_select_all));
            this.eyW.setCompoundDrawables(drawable, null, null, null);
            ho(true);
            this.eyX = true;
            this.eyT.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = aj.getDrawable(d.f.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, t, t);
        this.eyW.setText(this.eyT.getPageContext().getString(d.j.select_all));
        this.eyW.setCompoundDrawables(drawable2, null, null, null);
        ho(false);
        this.eyX = false;
        this.eyT.updateEditStatus(false);
    }
}
