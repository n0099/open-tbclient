package com.baidu.tieba.frs.i;

import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends j.a {
    public HeadPendantClickableView bEC;
    public TbImageView czA;
    public TbImageView czB;
    public TbImageView czC;
    public TbImageView czD;
    public TbImageView czE;
    public TbImageView czF;
    public TbImageView czG;
    public TbImageView czH;
    public TbImageView czI;
    public TbImageView czJ;
    public View czl;
    public HeadImageView czm;
    public TextView czn;
    public TextView czo;
    public TextView czp;
    public TextView czq;
    public LinearLayout czr;
    public LinearLayout czs;
    public LinearLayout czt;
    public LinearLayout czu;
    public LinearLayout czv;
    public TbImageView czw;
    public TbImageView czx;
    public TbImageView czy;
    public TbImageView czz;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public b(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.czl = this.mRootView.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.czm = (HeadImageView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.czm.setPageId(bdUniqueId);
        this.bEC = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.bEC.setPageId(bdUniqueId);
        this.czm.setDefaultResource(17170445);
        this.czm.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.czm.setDefaultBgResource(d.e.cp_bg_line_e);
        this.czm.setRadius(k.g(tbPageContext.getPageActivity(), d.f.ds70));
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(k.g(tbPageContext.getPageActivity(), d.f.ds70));
        }
        this.bEC.wt();
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.czn = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_username);
        this.czo = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_tips);
        this.czp = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_title);
        this.czq = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(d.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(d.f.ds3) + (width / 2);
        this.czw = (TbImageView) this.mRootView.findViewById(d.h.frs_wefan_cover_image);
        a(this.czw, width);
        this.czr = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_1);
        this.czs = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_2);
        this.czt = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_3);
        this.czu = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_4);
        this.czv = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_5);
        this.czx = (TbImageView) this.czr.getChildAt(0);
        this.czy = (TbImageView) this.czr.getChildAt(1);
        this.czz = (TbImageView) this.czr.getChildAt(2);
        this.czA = (TbImageView) this.czs.getChildAt(0);
        this.czB = (TbImageView) this.czs.getChildAt(1);
        this.czC = (TbImageView) this.czs.getChildAt(2);
        this.czD = (TbImageView) this.czt.getChildAt(0);
        this.czE = (TbImageView) this.czt.getChildAt(1);
        this.czF = (TbImageView) this.czt.getChildAt(2);
        this.czG = (TbImageView) this.czu.getChildAt(0);
        this.czH = (TbImageView) this.czu.getChildAt(1);
        this.czI = (TbImageView) this.czv.getChildAt(0);
        this.czJ = (TbImageView) this.czv.getChildAt(1);
        a(this.czx, i);
        a(this.czy, i);
        a(this.czz, i);
        a(this.czA, i);
        a(this.czB, i);
        a(this.czC, i);
        a(this.czD, i);
        a(this.czE, i);
        a(this.czF, i);
        a(this.czG, dimensionPixelSize);
        a(this.czH, dimensionPixelSize);
        a(this.czI, dimensionPixelSize);
        a(this.czJ, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
