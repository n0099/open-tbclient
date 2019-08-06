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
    public final ImageView dDZ;
    public final ImageView evF;
    private final RelativeLayout fsI;
    public final EditText fsJ;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.fsI = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.dDZ = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.fsJ = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.evF = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.fsJ.setHint(R.string.search_bar_you_want_post_to_share);
        this.bpI = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bpI.setText(tbPageContext.getString(R.string.cancel));
        this.mListView = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        bkW();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bkW() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsI.getLayoutParams();
        layoutParams.height = l.g(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int g = l.g(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g;
        layoutParams.leftMargin = g;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.fsI.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.a(this.dDZ, (int) R.drawable.icon_search, (int) R.drawable.icon_search, (int) R.drawable.icon_search, i);
            am.f(this.bpI, R.color.cp_link_tip_a, 1);
            am.c(this.evF, (int) R.drawable.del_search_btn);
            if (i == 2) {
                this.fsJ.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
            } else {
                this.fsJ.setHintTextColor(am.getColor(R.color.cp_cont_e));
            }
            am.e(this.fsJ, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
