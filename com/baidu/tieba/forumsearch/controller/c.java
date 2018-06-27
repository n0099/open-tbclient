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
    public final View abt;
    public final ImageView bGp;
    public final TextView bZF;
    private final RelativeLayout did;
    public final EditText die;
    public final ImageView dif;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.abt = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.forum_search_main, (ViewGroup) null);
        this.did = (RelativeLayout) this.abt.findViewById(d.g.search_area_root);
        this.bGp = (ImageView) this.abt.findViewById(d.g.search_bar_icon);
        this.die = (EditText) this.abt.findViewById(d.g.home_et_search);
        this.dif = (ImageView) this.abt.findViewById(d.g.home_bt_search_del);
        this.die.setHint(d.k.search_bar_you_want_post_to_share);
        this.bZF = (TextView) this.abt.findViewById(d.g.home_bt_search_cancel_s);
        this.bZF.setText(tbPageContext.getString(d.k.cancel));
        this.mListView = (BdTypeListView) this.abt.findViewById(d.g.search_bar_list);
        asQ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void asQ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.did.getLayoutParams();
        layoutParams.height = l.e(this.mPageContext.getPageActivity(), d.e.ds88);
        int e = l.e(this.mPageContext.getPageActivity(), d.e.ds8);
        layoutParams.rightMargin = e;
        layoutParams.leftMargin = e;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.did.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.a(this.bGp, d.f.icon_search, d.f.icon_search, d.f.icon_search, i);
            am.c(this.bZF, d.C0142d.cp_link_tip_a, 1);
            am.c(this.dif, d.f.del_search_btn);
            if (i == 2) {
                this.die.setHintTextColor(am.getColor(d.C0142d.s_navbar_title_color));
            } else {
                this.die.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
            }
            am.b(this.die, d.C0142d.cp_cont_b, d.C0142d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
