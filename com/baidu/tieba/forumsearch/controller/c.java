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
    public final TextView biO;
    public final View btY;
    public final ImageView dpO;
    private final RelativeLayout eXp;
    public final EditText eXq;
    public final ImageView eXr;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.btY = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.forum_search_main, (ViewGroup) null);
        this.eXp = (RelativeLayout) this.btY.findViewById(d.g.search_area_root);
        this.dpO = (ImageView) this.btY.findViewById(d.g.search_bar_icon);
        this.eXq = (EditText) this.btY.findViewById(d.g.home_et_search);
        this.eXr = (ImageView) this.btY.findViewById(d.g.home_bt_search_del);
        this.eXq.setHint(d.j.search_bar_you_want_post_to_share);
        this.biO = (TextView) this.btY.findViewById(d.g.home_bt_search_cancel_s);
        this.biO.setText(tbPageContext.getString(d.j.cancel));
        this.mListView = (BdTypeListView) this.btY.findViewById(d.g.search_bar_list);
        bbw();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bbw() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXp.getLayoutParams();
        layoutParams.height = l.h(this.mPageContext.getPageActivity(), d.e.ds88);
        int h = l.h(this.mPageContext.getPageActivity(), d.e.ds8);
        layoutParams.rightMargin = h;
        layoutParams.leftMargin = h;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.eXp.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.a(this.dpO, d.f.icon_search, d.f.icon_search, d.f.icon_search, i);
            al.d(this.biO, d.C0277d.cp_link_tip_a, 1);
            al.c(this.eXr, d.f.del_search_btn);
            if (i == 2) {
                this.eXq.setHintTextColor(al.getColor(d.C0277d.s_navbar_title_color));
            } else {
                this.eXq.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
            }
            al.c(this.eXq, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
