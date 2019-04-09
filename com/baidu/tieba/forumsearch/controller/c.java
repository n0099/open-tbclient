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
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class c {
    public final TextView biS;
    public final View buc;
    public final ImageView dpS;
    private final RelativeLayout eXc;
    public final EditText eXd;
    public final ImageView eXe;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.buc = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.forum_search_main, (ViewGroup) null);
        this.eXc = (RelativeLayout) this.buc.findViewById(d.g.search_area_root);
        this.dpS = (ImageView) this.buc.findViewById(d.g.search_bar_icon);
        this.eXd = (EditText) this.buc.findViewById(d.g.home_et_search);
        this.eXe = (ImageView) this.buc.findViewById(d.g.home_bt_search_del);
        this.eXd.setHint(d.j.search_bar_you_want_post_to_share);
        this.biS = (TextView) this.buc.findViewById(d.g.home_bt_search_cancel_s);
        this.biS.setText(tbPageContext.getString(d.j.cancel));
        this.mListView = (BdTypeListView) this.buc.findViewById(d.g.search_bar_list);
        bbu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bbu() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXc.getLayoutParams();
        layoutParams.height = l.h(this.mPageContext.getPageActivity(), d.e.ds88);
        int h = l.h(this.mPageContext.getPageActivity(), d.e.ds8);
        layoutParams.rightMargin = h;
        layoutParams.leftMargin = h;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.eXc.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.a(this.dpS, d.f.icon_search, d.f.icon_search, d.f.icon_search, i);
            al.d(this.biS, d.C0277d.cp_link_tip_a, 1);
            al.c(this.eXe, d.f.del_search_btn);
            if (i == 2) {
                this.eXd.setHintTextColor(al.getColor(d.C0277d.s_navbar_title_color));
            } else {
                this.eXd.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            }
            al.c(this.eXd, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
