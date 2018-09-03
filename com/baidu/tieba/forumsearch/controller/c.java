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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c {
    public final View aaW;
    public final ImageView bHe;
    public final TextView caN;
    private final RelativeLayout dkR;
    public final EditText dkS;
    public final ImageView dkT;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aaW = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(f.h.forum_search_main, (ViewGroup) null);
        this.dkR = (RelativeLayout) this.aaW.findViewById(f.g.search_area_root);
        this.bHe = (ImageView) this.aaW.findViewById(f.g.search_bar_icon);
        this.dkS = (EditText) this.aaW.findViewById(f.g.home_et_search);
        this.dkT = (ImageView) this.aaW.findViewById(f.g.home_bt_search_del);
        this.dkS.setHint(f.j.search_bar_you_want_post_to_share);
        this.caN = (TextView) this.aaW.findViewById(f.g.home_bt_search_cancel_s);
        this.caN.setText(tbPageContext.getString(f.j.cancel));
        this.mListView = (BdTypeListView) this.aaW.findViewById(f.g.search_bar_list);
        att();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void att() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dkR.getLayoutParams();
        layoutParams.height = l.f(this.mPageContext.getPageActivity(), f.e.ds88);
        int f = l.f(this.mPageContext.getPageActivity(), f.e.ds8);
        layoutParams.rightMargin = f;
        layoutParams.leftMargin = f;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.dkR.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.a(this.bHe, f.C0146f.icon_search, f.C0146f.icon_search, f.C0146f.icon_search, i);
            am.c(this.caN, f.d.cp_link_tip_a, 1);
            am.c(this.dkT, f.C0146f.del_search_btn);
            if (i == 2) {
                this.dkS.setHintTextColor(am.getColor(f.d.s_navbar_title_color));
            } else {
                this.dkS.setHintTextColor(am.getColor(f.d.cp_cont_e));
            }
            am.b(this.dkS, f.d.cp_cont_b, f.d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
