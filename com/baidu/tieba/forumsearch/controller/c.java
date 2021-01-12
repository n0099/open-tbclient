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
/* loaded from: classes7.dex */
public class c {
    public final TextView bUf;
    public final ImageView fel;
    public final ImageView gUy;
    public final BdTypeListView gwr;
    private final RelativeLayout iYC;
    public final EditText iYD;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.iYC = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.gUy = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.iYD = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.fel = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.iYD.setHint(R.string.search_bar_you_want_post_to_share);
        this.bUf = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bUf.setText(tbPageContext.getString(R.string.cancel));
        this.gwr = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        czQ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void czQ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iYC.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.iYC.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bsx().a(this.gUy, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.bUf, R.color.CAM_X0302, 1);
            SvgManager.bsx().a(this.fel, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.iYD.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
            } else {
                this.iYD.setHintTextColor(ao.getColor(R.color.CAM_X0110));
            }
            ao.setNavbarTitleColor(this.iYD, R.color.CAM_X0105, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
