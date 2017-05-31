package com.baidu.tieba.frs.g;

import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends z.a {
    public HeadPendantClickableView bzC;
    public TbImageView ckA;
    public TbImageView ckB;
    public TbImageView ckC;
    public TbImageView ckD;
    public TbImageView ckE;
    public TbImageView ckF;
    public TbImageView ckG;
    public TbImageView ckH;
    public TbImageView ckI;
    public View ckk;
    public HeadImageView ckl;
    public TextView ckm;
    public TextView ckn;
    public TextView cko;
    public TextView ckp;
    public LinearLayout ckq;
    public LinearLayout ckr;
    public LinearLayout cks;
    public LinearLayout ckt;
    public LinearLayout cku;
    public TbImageView ckv;
    public TbImageView ckw;
    public TbImageView ckx;
    public TbImageView cky;
    public TbImageView ckz;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.ckk = this.mRootView.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.ckl = (HeadImageView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.ckl.setPageId(bdUniqueId);
        this.bzC = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.bzC.setPageId(bdUniqueId);
        this.ckl.setDefaultResource(17170445);
        this.ckl.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.ckl.setDefaultBgResource(w.e.cp_bg_line_e);
        this.ckl.setRadius(k.g(tbPageContext.getPageActivity(), w.f.ds70));
        if (this.bzC.getHeadView() != null) {
            this.bzC.getHeadView().setIsRound(true);
            this.bzC.getHeadView().setDrawBorder(false);
            this.bzC.getHeadView().setDefaultResource(17170445);
            this.bzC.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bzC.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bzC.getHeadView().setRadius(k.g(tbPageContext.getPageActivity(), w.f.ds70));
        }
        this.bzC.vV();
        if (this.bzC.getPendantView() != null) {
            this.bzC.getPendantView().setIsRound(true);
            this.bzC.getPendantView().setDrawBorder(false);
        }
        this.ckm = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_username);
        this.ckn = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_tips);
        this.cko = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_title);
        this.ckp = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(w.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(w.f.ds3) + (width / 2);
        this.ckv = (TbImageView) this.mRootView.findViewById(w.h.frs_wefan_cover_image);
        a(this.ckv, width);
        this.ckq = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_1);
        this.ckr = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_2);
        this.cks = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_3);
        this.ckt = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_4);
        this.cku = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_5);
        this.ckw = (TbImageView) this.ckq.getChildAt(0);
        this.ckx = (TbImageView) this.ckq.getChildAt(1);
        this.cky = (TbImageView) this.ckq.getChildAt(2);
        this.ckz = (TbImageView) this.ckr.getChildAt(0);
        this.ckA = (TbImageView) this.ckr.getChildAt(1);
        this.ckB = (TbImageView) this.ckr.getChildAt(2);
        this.ckC = (TbImageView) this.cks.getChildAt(0);
        this.ckD = (TbImageView) this.cks.getChildAt(1);
        this.ckE = (TbImageView) this.cks.getChildAt(2);
        this.ckF = (TbImageView) this.ckt.getChildAt(0);
        this.ckG = (TbImageView) this.ckt.getChildAt(1);
        this.ckH = (TbImageView) this.cku.getChildAt(0);
        this.ckI = (TbImageView) this.cku.getChildAt(1);
        a(this.ckw, i);
        a(this.ckx, i);
        a(this.cky, i);
        a(this.ckz, i);
        a(this.ckA, i);
        a(this.ckB, i);
        a(this.ckC, i);
        a(this.ckD, i);
        a(this.ckE, i);
        a(this.ckF, dimensionPixelSize);
        a(this.ckG, dimensionPixelSize);
        a(this.ckH, dimensionPixelSize);
        a(this.ckI, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
