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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class c {
    public final TextView dmF;
    public final ImageView fHT;
    public final BdTypeListView fml;
    public final ImageView gKl;
    private final RelativeLayout hxN;
    public final EditText hxO;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.hxN = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.fHT = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.hxO = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.gKl = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.hxO.setHint(R.string.search_bar_you_want_post_to_share);
        this.dmF = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.dmF.setText(tbPageContext.getString(R.string.cancel));
        this.fml = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        bWL();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bWL() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hxN.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.hxN.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aWQ().a(this.fHT, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            an.setViewTextColor(this.dmF, R.color.cp_link_tip_a, 1);
            SvgManager.aWQ().a(this.gKl, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.hxO.setHintTextColor(an.getColor(R.color.s_navbar_title_color));
            } else {
                this.hxO.setHintTextColor(an.getColor(R.color.cp_cont_e));
            }
            an.setNavbarTitleColor(this.hxO, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
