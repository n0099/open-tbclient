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
/* loaded from: classes7.dex */
public class c {
    public final TextView bZE;
    public final ImageView fhZ;
    public final BdTypeListView gAY;
    public final ImageView gZf;
    private final RelativeLayout jgg;
    public final EditText jgh;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.jgg = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.gZf = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.jgh = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.fhZ = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.jgh.setHint(R.string.search_bar_you_want_post_to_share);
        this.bZE = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bZE.setText(tbPageContext.getString(R.string.cancel));
        this.gAY = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        cBo();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cBo() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jgg.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.jgg.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bsU().a(this.gZf, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.bZE, R.color.CAM_X0302, 1);
            SvgManager.bsU().a(this.fhZ, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.jgh.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
            } else {
                this.jgh.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            }
            ap.setNavbarTitleColor(this.jgh, R.color.CAM_X0105, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
