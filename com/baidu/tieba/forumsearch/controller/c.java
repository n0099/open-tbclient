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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c {
    public final View bBg;
    public final TextView boV;
    public final ImageView dAy;
    public final ImageView eqA;
    private final RelativeLayout fnk;
    public final EditText fnl;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bBg = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.fnk = (RelativeLayout) this.bBg.findViewById(R.id.search_area_root);
        this.dAy = (ImageView) this.bBg.findViewById(R.id.search_bar_icon);
        this.fnl = (EditText) this.bBg.findViewById(R.id.home_et_search);
        this.eqA = (ImageView) this.bBg.findViewById(R.id.home_bt_search_del);
        this.fnl.setHint(R.string.search_bar_you_want_post_to_share);
        this.boV = (TextView) this.bBg.findViewById(R.id.home_bt_search_cancel_s);
        this.boV.setText(tbPageContext.getString(R.string.cancel));
        this.mListView = (BdTypeListView) this.bBg.findViewById(R.id.search_bar_list);
        biN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void biN() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fnk.getLayoutParams();
        layoutParams.height = l.g(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int g = l.g(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g;
        layoutParams.leftMargin = g;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.fnk.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.a(this.dAy, (int) R.drawable.icon_search, (int) R.drawable.icon_search, (int) R.drawable.icon_search, i);
            al.f(this.boV, R.color.cp_link_tip_a, 1);
            al.c(this.eqA, (int) R.drawable.del_search_btn);
            if (i == 2) {
                this.fnl.setHintTextColor(al.getColor(R.color.s_navbar_title_color));
            } else {
                this.fnl.setHintTextColor(al.getColor(R.color.cp_cont_e));
            }
            al.e(this.fnl, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
