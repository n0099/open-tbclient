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
/* loaded from: classes11.dex */
public class c {
    public final ImageView eDV;
    public final BdTypeListView eko;
    public final ImageView fDe;
    private final RelativeLayout gmP;
    public final EditText gmQ;
    public final TextView mCancel;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.gmP = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.eDV = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.gmQ = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.fDe = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.gmQ.setHint(R.string.search_bar_you_want_post_to_share);
        this.mCancel = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.mCancel.setText(tbPageContext.getString(R.string.cancel));
        this.eko = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        bCN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bCN() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmP.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.gmP.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aGC().a(this.eDV, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.mCancel, R.color.cp_link_tip_a, 1);
            SvgManager.aGC().a(this.fDe, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.gmQ.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
            } else {
                this.gmQ.setHintTextColor(am.getColor(R.color.cp_cont_e));
            }
            am.setNavbarTitleColor(this.gmQ, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
