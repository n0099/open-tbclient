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
    public final TextView bIS;
    public final ImageView dKQ;
    public final BdTypeListView dvB;
    public final ImageView eFZ;
    private final RelativeLayout ftI;
    public final EditText ftJ;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.ftI = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.dKQ = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.ftJ = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.eFZ = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.ftJ.setHint(R.string.search_bar_you_want_post_to_share);
        this.bIS = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bIS.setText(tbPageContext.getString(R.string.cancel));
        this.dvB = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        biN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void biN() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ftI.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.ftI.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.amN().a(this.dKQ, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
            am.setViewTextColor(this.bIS, R.color.cp_link_tip_a, 1);
            SvgManager.amN().a(this.eFZ, R.drawable.icon_pure_search_empty_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.ftJ.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
            } else {
                this.ftJ.setHintTextColor(am.getColor(R.color.cp_cont_e));
            }
            am.setNavbarTitleColor(this.ftJ, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
