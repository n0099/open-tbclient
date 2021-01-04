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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c {
    public final TextView bYR;
    public final ImageView fiW;
    public final BdTypeListView gAY;
    public final ImageView gZe;
    private final RelativeLayout jdj;
    public final EditText jdk;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.jdj = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.gZe = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.jdk = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.fiW = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.jdk.setHint(R.string.search_bar_you_want_post_to_share);
        this.bYR = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bYR.setText(tbPageContext.getString(R.string.cancel));
        this.gAY = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        cDH();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cDH() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jdj.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.jdj.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bwq().a(this.gZe, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.bYR, R.color.CAM_X0302, 1);
            SvgManager.bwq().a(this.fiW, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.jdk.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
            } else {
                this.jdk.setHintTextColor(ao.getColor(R.color.CAM_X0110));
            }
            ao.setNavbarTitleColor(this.jdk, R.color.CAM_X0105, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
