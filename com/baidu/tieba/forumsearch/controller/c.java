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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class c {
    public final TextView dCF;
    public final BdTypeListView fCT;
    public final ImageView fZq;
    private final RelativeLayout hQV;
    public final EditText hQW;
    public final ImageView hcL;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.hQV = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.fZq = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.hQW = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.hcL = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.hQW.setHint(R.string.search_bar_you_want_post_to_share);
        this.dCF = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.dCF.setText(tbPageContext.getString(R.string.cancel));
        this.fCT = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        ckC();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ckC() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hQV.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.hQV.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bjq().a(this.fZq, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.dCF, R.color.cp_link_tip_a, 1);
            SvgManager.bjq().a(this.hcL, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.hQW.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
            } else {
                this.hQW.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            }
            ap.setNavbarTitleColor(this.hQW, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
