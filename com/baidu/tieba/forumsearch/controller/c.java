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
    public final TextView bTh;
    public final ImageView eZs;
    public final ImageView gNu;
    public final BdTypeListView gpZ;
    private final RelativeLayout iQX;
    public final EditText iQY;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.iQX = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.gNu = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.iQY = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.eZs = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.iQY.setHint(R.string.search_bar_you_want_post_to_share);
        this.bTh = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.bTh.setText(tbPageContext.getString(R.string.cancel));
        this.gpZ = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        cAO();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cAO() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iQX.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.iQX.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.btW().a(this.gNu, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.bTh, R.color.CAM_X0302, 1);
            SvgManager.btW().a(this.eZs, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.iQY.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
            } else {
                this.iQY.setHintTextColor(ap.getColor(R.color.CAM_X0110));
            }
            ap.setNavbarTitleColor(this.iQY, R.color.CAM_X0105, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
