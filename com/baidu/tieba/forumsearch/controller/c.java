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
    public final View aHS;
    public final ImageView clt;
    public final TextView cys;
    private final RelativeLayout dCX;
    public final EditText dCY;
    public final ImageView dCZ;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aHS = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.forum_search_main, (ViewGroup) null);
        this.dCX = (RelativeLayout) this.aHS.findViewById(d.g.search_area_root);
        this.clt = (ImageView) this.aHS.findViewById(d.g.search_bar_icon);
        this.dCY = (EditText) this.aHS.findViewById(d.g.home_et_search);
        this.dCZ = (ImageView) this.aHS.findViewById(d.g.home_bt_search_del);
        this.dCY.setHint(d.j.search_bar_you_want_post_to_share);
        this.cys = (TextView) this.aHS.findViewById(d.g.home_bt_search_cancel_s);
        this.cys.setText(tbPageContext.getString(d.j.cancel));
        this.mListView = (BdTypeListView) this.aHS.findViewById(d.g.search_bar_list);
        aul();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aul() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dCX.getLayoutParams();
        layoutParams.height = l.t(this.mPageContext.getPageActivity(), d.e.ds88);
        int t = l.t(this.mPageContext.getPageActivity(), d.e.ds8);
        layoutParams.rightMargin = t;
        layoutParams.leftMargin = t;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.dCX.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.a(this.clt, d.f.icon_search, d.f.icon_search, d.f.icon_search, i);
            aj.e(this.cys, d.C0141d.cp_link_tip_a, 1);
            aj.c(this.dCZ, d.f.del_search_btn);
            if (i == 2) {
                this.dCY.setHintTextColor(aj.getColor(d.C0141d.s_navbar_title_color));
            } else {
                this.dCY.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
            }
            aj.d(this.dCY, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
