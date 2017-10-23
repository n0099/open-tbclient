package com.baidu.tieba.frs.i;

import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends j.a {
    public HeadPendantClickableView bJj;
    public View cKB;
    public HeadImageView cKC;
    public TextView cKD;
    public TextView cKE;
    public TextView cKF;
    public TextView cKG;
    public LinearLayout cKH;
    public LinearLayout cKI;
    public LinearLayout cKJ;
    public LinearLayout cKK;
    public LinearLayout cKL;
    public TbImageView cKM;
    public TbImageView cKN;
    public TbImageView cKO;
    public TbImageView cKP;
    public TbImageView cKQ;
    public TbImageView cKR;
    public TbImageView cKS;
    public TbImageView cKT;
    public TbImageView cKU;
    public TbImageView cKV;
    public TbImageView cKW;
    public TbImageView cKX;
    public TbImageView cKY;
    public TbImageView cKZ;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public b(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.cKB = this.mRootView.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.cKC = (HeadImageView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.cKC.setPageId(bdUniqueId);
        this.bJj = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.bJj.setPageId(bdUniqueId);
        this.cKC.setDefaultResource(17170445);
        this.cKC.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cKC.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cKC.setRadius(l.f(tbPageContext.getPageActivity(), d.f.ds70));
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(l.f(tbPageContext.getPageActivity(), d.f.ds70));
        }
        this.bJj.vZ();
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.cKD = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_username);
        this.cKE = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_tips);
        this.cKF = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_title);
        this.cKG = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(d.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(d.f.ds3) + (width / 2);
        this.cKM = (TbImageView) this.mRootView.findViewById(d.h.frs_wefan_cover_image);
        a(this.cKM, width);
        this.cKH = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_1);
        this.cKI = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_2);
        this.cKJ = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_3);
        this.cKK = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_4);
        this.cKL = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_5);
        this.cKN = (TbImageView) this.cKH.getChildAt(0);
        this.cKO = (TbImageView) this.cKH.getChildAt(1);
        this.cKP = (TbImageView) this.cKH.getChildAt(2);
        this.cKQ = (TbImageView) this.cKI.getChildAt(0);
        this.cKR = (TbImageView) this.cKI.getChildAt(1);
        this.cKS = (TbImageView) this.cKI.getChildAt(2);
        this.cKT = (TbImageView) this.cKJ.getChildAt(0);
        this.cKU = (TbImageView) this.cKJ.getChildAt(1);
        this.cKV = (TbImageView) this.cKJ.getChildAt(2);
        this.cKW = (TbImageView) this.cKK.getChildAt(0);
        this.cKX = (TbImageView) this.cKK.getChildAt(1);
        this.cKY = (TbImageView) this.cKL.getChildAt(0);
        this.cKZ = (TbImageView) this.cKL.getChildAt(1);
        a(this.cKN, i);
        a(this.cKO, i);
        a(this.cKP, i);
        a(this.cKQ, i);
        a(this.cKR, i);
        a(this.cKS, i);
        a(this.cKT, i);
        a(this.cKU, i);
        a(this.cKV, i);
        a(this.cKW, dimensionPixelSize);
        a(this.cKX, dimensionPixelSize);
        a(this.cKY, dimensionPixelSize);
        a(this.cKZ, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
