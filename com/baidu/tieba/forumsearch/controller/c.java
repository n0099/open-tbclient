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
    public final View aix;
    public final ImageView bVv;
    public final TextView cpf;
    private final RelativeLayout dyL;
    public final EditText dyM;
    public final ImageView dyN;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aix = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.forum_search_main, (ViewGroup) null);
        this.dyL = (RelativeLayout) this.aix.findViewById(e.g.search_area_root);
        this.bVv = (ImageView) this.aix.findViewById(e.g.search_bar_icon);
        this.dyM = (EditText) this.aix.findViewById(e.g.home_et_search);
        this.dyN = (ImageView) this.aix.findViewById(e.g.home_bt_search_del);
        this.dyM.setHint(e.j.search_bar_you_want_post_to_share);
        this.cpf = (TextView) this.aix.findViewById(e.g.home_bt_search_cancel_s);
        this.cpf.setText(tbPageContext.getString(e.j.cancel));
        this.mListView = (BdTypeListView) this.aix.findViewById(e.g.search_bar_list);
        ayE();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayE() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyL.getLayoutParams();
        layoutParams.height = l.h(this.mPageContext.getPageActivity(), e.C0175e.ds88);
        int h = l.h(this.mPageContext.getPageActivity(), e.C0175e.ds8);
        layoutParams.rightMargin = h;
        layoutParams.leftMargin = h;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.dyL.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.a(this.bVv, e.f.icon_search, e.f.icon_search, e.f.icon_search, i);
            al.c(this.cpf, e.d.cp_link_tip_a, 1);
            al.c(this.dyN, e.f.del_search_btn);
            if (i == 2) {
                this.dyM.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
            } else {
                this.dyM.setHintTextColor(al.getColor(e.d.cp_cont_e));
            }
            al.b(this.dyM, e.d.cp_cont_b, e.d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
