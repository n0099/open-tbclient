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
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c {
    public final TextView bpI;
    public final ImageView dDS;
    public final ImageView evy;
    private final RelativeLayout fsj;
    public final EditText fsk;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.fsj = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.dDS = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.fsk = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.evy = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.fsk.setHint(R.string.search_bar_you_want_post_to_share);
        this.bpI = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bpI.setText(tbPageContext.getString(R.string.cancel));
        this.mListView = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        bkP();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bkP() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsj.getLayoutParams();
        layoutParams.height = l.g(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int g = l.g(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g;
        layoutParams.leftMargin = g;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.fsj.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.a(this.dDS, (int) R.drawable.icon_search, (int) R.drawable.icon_search, (int) R.drawable.icon_search, i);
            am.f(this.bpI, R.color.cp_link_tip_a, 1);
            am.c(this.evy, (int) R.drawable.del_search_btn);
            if (i == 2) {
                this.fsk.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
            } else {
                this.fsk.setHintTextColor(am.getColor(R.color.cp_cont_e));
            }
            am.e(this.fsk, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
