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
/* loaded from: classes9.dex */
public class c {
    public final BdTypeListView efW;
    public final ImageView ezA;
    public final ImageView fAr;
    public final EditText gkA;
    private final RelativeLayout gkz;
    public final TextView mCancel;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.gkz = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.ezA = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.gkA = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.fAr = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.gkA.setHint(R.string.search_bar_you_want_post_to_share);
        this.mCancel = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.mCancel.setText(tbPageContext.getString(R.string.cancel));
        this.efW = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        bBi();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bBi() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gkz.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.gkz.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aEp().a(this.ezA, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.mCancel, R.color.cp_link_tip_a, 1);
            SvgManager.aEp().a(this.fAr, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.gkA.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
            } else {
                this.gkA.setHintTextColor(am.getColor(R.color.cp_cont_e));
            }
            am.setNavbarTitleColor(this.gkA, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
