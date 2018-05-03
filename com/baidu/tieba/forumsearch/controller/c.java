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
    public final View Tl;
    public final TextView bOF;
    public final ImageView bvG;
    private final RelativeLayout cVS;
    public final EditText cVT;
    public final ImageView cVU;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.Tl = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.forum_search_main, (ViewGroup) null);
        this.cVS = (RelativeLayout) this.Tl.findViewById(d.g.search_area_root);
        this.bvG = (ImageView) this.Tl.findViewById(d.g.search_bar_icon);
        this.cVT = (EditText) this.Tl.findViewById(d.g.home_et_search);
        this.cVU = (ImageView) this.Tl.findViewById(d.g.home_bt_search_del);
        this.cVT.setHint(d.k.search_bar_you_want_post_to_share);
        this.bOF = (TextView) this.Tl.findViewById(d.g.home_bt_search_cancel_s);
        this.bOF.setText(tbPageContext.getString(d.k.cancel));
        this.mListView = (BdTypeListView) this.Tl.findViewById(d.g.search_bar_list);
        aoB();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aoB() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVS.getLayoutParams();
        layoutParams.height = l.e(this.mPageContext.getPageActivity(), d.e.ds88);
        int e = l.e(this.mPageContext.getPageActivity(), d.e.ds8);
        layoutParams.rightMargin = e;
        layoutParams.leftMargin = e;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.cVS.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.a(this.bvG, d.f.icon_search, d.f.icon_search, d.f.icon_search, i);
            ak.c(this.bOF, d.C0126d.cp_link_tip_a, 1);
            ak.c(this.cVU, d.f.del_search_btn);
            if (i == 2) {
                this.cVT.setHintTextColor(ak.getColor(d.C0126d.s_navbar_title_color));
            } else {
                this.cVT.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
            }
            ak.b(this.cVT, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
