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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c {
    public final View aId;
    public final ImageView clF;
    public final TextView cyE;
    private final RelativeLayout dDj;
    public final EditText dDk;
    public final ImageView dDl;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aId = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.forum_search_main, (ViewGroup) null);
        this.dDj = (RelativeLayout) this.aId.findViewById(d.g.search_area_root);
        this.clF = (ImageView) this.aId.findViewById(d.g.search_bar_icon);
        this.dDk = (EditText) this.aId.findViewById(d.g.home_et_search);
        this.dDl = (ImageView) this.aId.findViewById(d.g.home_bt_search_del);
        this.dDk.setHint(d.j.search_bar_you_want_post_to_share);
        this.cyE = (TextView) this.aId.findViewById(d.g.home_bt_search_cancel_s);
        this.cyE.setText(tbPageContext.getString(d.j.cancel));
        this.mListView = (BdTypeListView) this.aId.findViewById(d.g.search_bar_list);
        aum();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aum() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dDj.getLayoutParams();
        layoutParams.height = l.t(this.mPageContext.getPageActivity(), d.e.ds88);
        int t = l.t(this.mPageContext.getPageActivity(), d.e.ds8);
        layoutParams.rightMargin = t;
        layoutParams.leftMargin = t;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.dDj.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.a(this.clF, d.f.icon_search, d.f.icon_search, d.f.icon_search, i);
            aj.e(this.cyE, d.C0140d.cp_link_tip_a, 1);
            aj.c(this.dDl, d.f.del_search_btn);
            if (i == 2) {
                this.dDk.setHintTextColor(aj.getColor(d.C0140d.s_navbar_title_color));
            } else {
                this.dDk.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
            }
            aj.d(this.dDk, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
