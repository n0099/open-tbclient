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
/* loaded from: classes23.dex */
public class c {
    public final TextView bOb;
    public final ImageView gEv;
    public final BdTypeListView ghN;
    public final ImageView hRy;
    private final RelativeLayout iGd;
    public final EditText iGe;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.iGd = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.gEv = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.iGe = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.hRy = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.iGe.setHint(R.string.search_bar_you_want_post_to_share);
        this.bOb = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bOb.setText(tbPageContext.getString(R.string.cancel));
        this.ghN = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        cwy();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cwy() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iGd.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.iGd.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bqB().a(this.gEv, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.bOb, R.color.CAM_X0302, 1);
            SvgManager.bqB().a(this.hRy, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.iGe.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
            } else {
                this.iGe.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            }
            ap.setNavbarTitleColor(this.iGe, R.color.CAM_X0105, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
