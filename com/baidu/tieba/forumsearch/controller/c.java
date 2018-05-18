package com.baidu.tieba.forumsearch.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c {
    public final View Th;
    public final TextView bPv;
    public final ImageView bwq;
    private final RelativeLayout cWZ;
    public final EditText cXa;
    public final ImageView cXb;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.Th = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.forum_search_main, (ViewGroup) null);
        this.cWZ = (RelativeLayout) this.Th.findViewById(d.g.search_area_root);
        this.bwq = (ImageView) this.Th.findViewById(d.g.search_bar_icon);
        this.cXa = (EditText) this.Th.findViewById(d.g.home_et_search);
        this.cXb = (ImageView) this.Th.findViewById(d.g.home_bt_search_del);
        this.cXa.setHint(d.k.search_bar_you_want_post_to_share);
        this.bPv = (TextView) this.Th.findViewById(d.g.home_bt_search_cancel_s);
        this.bPv.setText(tbPageContext.getString(d.k.cancel));
        this.mListView = (BdTypeListView) this.Th.findViewById(d.g.search_bar_list);
        aoA();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aoA() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWZ.getLayoutParams();
        layoutParams.height = l.e(this.mPageContext.getPageActivity(), d.e.ds88);
        int e = l.e(this.mPageContext.getPageActivity(), d.e.ds8);
        layoutParams.rightMargin = e;
        layoutParams.leftMargin = e;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.cWZ.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.a(this.bwq, d.f.icon_search, d.f.icon_search, d.f.icon_search, i);
            ak.c(this.bPv, d.C0126d.cp_link_tip_a, 1);
            ak.c(this.cXb, d.f.del_search_btn);
            if (i == 2) {
                this.cXa.setHintTextColor(ak.getColor(d.C0126d.s_navbar_title_color));
            } else {
                this.cXa.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
            }
            ak.b(this.cXa, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
