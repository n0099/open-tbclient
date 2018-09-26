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
    public final View adA;
    public final ImageView bMT;
    public final TextView cgD;
    private final RelativeLayout dqK;
    public final EditText dqL;
    public final ImageView dqM;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.adA = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.forum_search_main, (ViewGroup) null);
        this.dqK = (RelativeLayout) this.adA.findViewById(e.g.search_area_root);
        this.bMT = (ImageView) this.adA.findViewById(e.g.search_bar_icon);
        this.dqL = (EditText) this.adA.findViewById(e.g.home_et_search);
        this.dqM = (ImageView) this.adA.findViewById(e.g.home_bt_search_del);
        this.dqL.setHint(e.j.search_bar_you_want_post_to_share);
        this.cgD = (TextView) this.adA.findViewById(e.g.home_bt_search_cancel_s);
        this.cgD.setText(tbPageContext.getString(e.j.cancel));
        this.mListView = (BdTypeListView) this.adA.findViewById(e.g.search_bar_list);
        avh();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void avh() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqK.getLayoutParams();
        layoutParams.height = l.h(this.mPageContext.getPageActivity(), e.C0141e.ds88);
        int h = l.h(this.mPageContext.getPageActivity(), e.C0141e.ds8);
        layoutParams.rightMargin = h;
        layoutParams.leftMargin = h;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.dqK.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.a(this.bMT, e.f.icon_search, e.f.icon_search, e.f.icon_search, i);
            al.c(this.cgD, e.d.cp_link_tip_a, 1);
            al.c(this.dqM, e.f.del_search_btn);
            if (i == 2) {
                this.dqL.setHintTextColor(al.getColor(e.d.s_navbar_title_color));
            } else {
                this.dqL.setHintTextColor(al.getColor(e.d.cp_cont_e));
            }
            al.b(this.dqL, e.d.cp_cont_b, e.d.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
