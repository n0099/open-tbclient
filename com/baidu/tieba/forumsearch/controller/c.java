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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c {
    public final View aaV;
    public final ImageView bHe;
    public final TextView caP;
    private final RelativeLayout dkT;
    public final EditText dkU;
    public final ImageView dkV;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aaV = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.forum_search_main, (ViewGroup) null);
        this.dkT = (RelativeLayout) this.aaV.findViewById(d.g.search_area_root);
        this.bHe = (ImageView) this.aaV.findViewById(d.g.search_bar_icon);
        this.dkU = (EditText) this.aaV.findViewById(d.g.home_et_search);
        this.dkV = (ImageView) this.aaV.findViewById(d.g.home_bt_search_del);
        this.dkU.setHint(d.j.search_bar_you_want_post_to_share);
        this.caP = (TextView) this.aaV.findViewById(d.g.home_bt_search_cancel_s);
        this.caP.setText(tbPageContext.getString(d.j.cancel));
        this.mListView = (BdTypeListView) this.aaV.findViewById(d.g.search_bar_list);
        atu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void atu() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dkT.getLayoutParams();
        layoutParams.height = l.f(this.mPageContext.getPageActivity(), d.e.ds88);
        int f = l.f(this.mPageContext.getPageActivity(), d.e.ds8);
        layoutParams.rightMargin = f;
        layoutParams.leftMargin = f;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.dkT.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.a(this.bHe, d.f.icon_search, d.f.icon_search, d.f.icon_search, i);
            am.c(this.caP, d.C0140d.cp_link_tip_a, 1);
            am.c(this.dkV, d.f.del_search_btn);
            if (i == 2) {
                this.dkU.setHintTextColor(am.getColor(d.C0140d.s_navbar_title_color));
            } else {
                this.dkU.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
            }
            am.b(this.dkU, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
