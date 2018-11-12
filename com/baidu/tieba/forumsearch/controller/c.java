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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c {
    public final View ajk;
    public final ImageView bWj;
    private final RelativeLayout dAc;
    public final EditText dAd;
    public final ImageView dAe;
    public final TextView mCancel;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ajk = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.forum_search_main, (ViewGroup) null);
        this.dAc = (RelativeLayout) this.ajk.findViewById(e.g.search_area_root);
        this.bWj = (ImageView) this.ajk.findViewById(e.g.search_bar_icon);
        this.dAd = (EditText) this.ajk.findViewById(e.g.home_et_search);
        this.dAe = (ImageView) this.ajk.findViewById(e.g.home_bt_search_del);
        this.dAd.setHint(e.j.search_bar_you_want_post_to_share);
        this.mCancel = (TextView) this.ajk.findViewById(e.g.home_bt_search_cancel_s);
        this.mCancel.setText(tbPageContext.getString(e.j.cancel));
        this.mListView = (BdTypeListView) this.ajk.findViewById(e.g.search_bar_list);
        ayb();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayb() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dAc.getLayoutParams();
        layoutParams.height = l.h(this.mPageContext.getPageActivity(), e.C0200e.ds88);
        int h = l.h(this.mPageContext.getPageActivity(), e.C0200e.ds8);
        layoutParams.rightMargin = h;
        layoutParams.leftMargin = h;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.dAc.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.a(this.bWj, e.f.icon_search, e.f.icon_search, e.f.icon_search, i);
            al.c(this.mCancel, e.d.cp_link_tip_a, 1);
            al.c(this.dAe, e.f.del_search_btn);
            if (i == 2) {
                this.dAd.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
            } else {
                this.dAd.setHintTextColor(al.getColor(e.d.cp_cont_e));
            }
            al.b(this.dAd, e.d.cp_cont_b, e.d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
