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
/* loaded from: classes24.dex */
public class c {
    public final TextView dQH;
    public final BdTypeListView fSo;
    public final ImageView goV;
    public final ImageView hyF;
    private final RelativeLayout imV;
    public final EditText imW;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.imV = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.goV = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.imW = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.hyF = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.imW.setHint(R.string.search_bar_you_want_post_to_share);
        this.dQH = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.dQH.setText(tbPageContext.getString(R.string.cancel));
        this.fSo = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        crn();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void crn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.imV.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.imV.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bmU().a(this.goV, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.dQH, R.color.cp_link_tip_a, 1);
            SvgManager.bmU().a(this.hyF, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.imW.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
            } else {
                this.imW.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            }
            ap.setNavbarTitleColor(this.imW, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
