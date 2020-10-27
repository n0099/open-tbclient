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
    public final TextView bKf;
    public final BdTypeListView gcr;
    public final ImageView gza;
    public final ImageView hLb;
    private final RelativeLayout izs;
    public final EditText izt;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.izs = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.gza = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.izt = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.hLb = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.izt.setHint(R.string.search_bar_you_want_post_to_share);
        this.bKf = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bKf.setText(tbPageContext.getString(R.string.cancel));
        this.gcr = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        cuu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cuu() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.izs.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.izs.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.boN().a(this.gza, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.bKf, R.color.cp_link_tip_a, 1);
            SvgManager.boN().a(this.hLb, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.izt.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
            } else {
                this.izt.setHintTextColor(ap.getColor(R.color.cp_cont_e));
            }
            ap.setNavbarTitleColor(this.izt, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
