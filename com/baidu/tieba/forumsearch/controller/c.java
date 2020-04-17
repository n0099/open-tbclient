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
    public final TextView cWN;
    public final BdTypeListView eOe;
    public final ImageView fiM;
    private final RelativeLayout gWD;
    public final EditText gWE;
    public final ImageView giq;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.gWD = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.fiM = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.gWE = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.giq = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.gWE.setHint(R.string.search_bar_you_want_post_to_share);
        this.cWN = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.cWN.setText(tbPageContext.getString(R.string.cancel));
        this.eOe = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        bNt();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bNt() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gWD.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.gWD.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aOU().a(this.fiM, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.cWN, R.color.cp_link_tip_a, 1);
            SvgManager.aOU().a(this.giq, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.gWE.setHintTextColor(am.getColor(R.color.s_navbar_title_color));
            } else {
                this.gWE.setHintTextColor(am.getColor(R.color.cp_cont_e));
            }
            am.setNavbarTitleColor(this.gWE, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
