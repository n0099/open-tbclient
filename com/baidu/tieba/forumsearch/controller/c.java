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
/* loaded from: classes18.dex */
public class c {
    public final TextView dsB;
    public final ImageView fNo;
    public final BdTypeListView frv;
    public final ImageView gPR;
    private final RelativeLayout hDB;
    public final EditText hDC;
    private TbPageContext mPageContext;
    public final View mRoot;
    private int mSkinType = 3;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mRoot = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.hDB = (RelativeLayout) this.mRoot.findViewById(R.id.search_area_root);
        this.fNo = (ImageView) this.mRoot.findViewById(R.id.search_bar_icon);
        this.hDC = (EditText) this.mRoot.findViewById(R.id.home_et_search);
        this.gPR = (ImageView) this.mRoot.findViewById(R.id.home_bt_search_del);
        this.hDC.setHint(R.string.search_bar_you_want_post_to_share);
        this.dsB = (TextView) this.mRoot.findViewById(R.id.home_bt_search_cancel_s);
        this.dsB.setText(tbPageContext.getString(R.string.cancel));
        this.frv = (BdTypeListView) this.mRoot.findViewById(R.id.search_bar_list);
        caf();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void caf() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hDB.getLayoutParams();
        layoutParams.height = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds88);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds8);
        layoutParams.rightMargin = dimens;
        layoutParams.leftMargin = dimens;
        int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
        if (immersiveStickyBarHeight > 0) {
            layoutParams.topMargin = immersiveStickyBarHeight;
        }
        this.hDB.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.baR().a(this.fNo, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.dsB, R.color.cp_link_tip_a, 1);
            SvgManager.baR().a(this.gPR, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (i == 2) {
                this.hDC.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
            } else {
                this.hDC.setHintTextColor(ao.getColor(R.color.cp_cont_e));
            }
            ao.setNavbarTitleColor(this.hDC, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.mSkinType = i;
        }
    }
}
