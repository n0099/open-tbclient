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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c {
    public final TextView bqg;
    public final ImageView dFK;
    public final ImageView exp;
    private final RelativeLayout fuv;
    public final EditText fuw;
    public final BdTypeListView mListView;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.fuv = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.dFK = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.fuw = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.exp = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.fuw.setHint(R.string.search_bar_you_want_post_to_share);
        this.bqg = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bqg.setText(tbPageContext.getString(R.string.cancel));
        this.mListView = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        blH();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void blH() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fuv.getLayoutParams();
        layoutParams.height = l.g(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int g = l.g(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = g;
        layoutParams.leftMargin = g;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.fuv.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.ajv().a(this.dFK, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
            am.f(this.bqg, R.color.cp_link_tip_a, 1);
            SvgManager.ajv().a(this.exp, R.drawable.icon_pure_search_empty_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.fuw.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
            } else {
                this.fuw.setHintTextColor(am.getColor(R.color.cp_cont_e));
            }
            am.e(this.fuw, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
