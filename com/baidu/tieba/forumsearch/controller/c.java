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
/* loaded from: classes3.dex */
public class c {
    public final View abp;
    public final ImageView bEt;
    public final TextView bXw;
    private final RelativeLayout dgm;
    public final EditText dgn;
    public final ImageView dgo;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.abp = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.forum_search_main, (ViewGroup) null);
        this.dgm = (RelativeLayout) this.abp.findViewById(d.g.search_area_root);
        this.bEt = (ImageView) this.abp.findViewById(d.g.search_bar_icon);
        this.dgn = (EditText) this.abp.findViewById(d.g.home_et_search);
        this.dgo = (ImageView) this.abp.findViewById(d.g.home_bt_search_del);
        this.dgn.setHint(d.k.search_bar_you_want_post_to_share);
        this.bXw = (TextView) this.abp.findViewById(d.g.home_bt_search_cancel_s);
        this.bXw.setText(tbPageContext.getString(d.k.cancel));
        this.mListView = (BdTypeListView) this.abp.findViewById(d.g.search_bar_list);
        asF();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void asF() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgm.getLayoutParams();
        layoutParams.height = l.e(this.mPageContext.getPageActivity(), d.e.ds88);
        int e = l.e(this.mPageContext.getPageActivity(), d.e.ds8);
        layoutParams.rightMargin = e;
        layoutParams.leftMargin = e;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.dgm.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.a(this.bEt, d.f.icon_search, d.f.icon_search, d.f.icon_search, i);
            al.c(this.bXw, d.C0141d.cp_link_tip_a, 1);
            al.c(this.dgo, d.f.del_search_btn);
            if (i == 2) {
                this.dgn.setHintTextColor(al.getColor(d.C0141d.s_navbar_title_color));
            } else {
                this.dgn.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
            }
            al.b(this.dgn, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
