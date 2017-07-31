package com.baidu.tieba.frs.h;

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
    public HeadPendantClickableView bFM;
    public View cAG;
    public HeadImageView cAH;
    public TextView cAI;
    public TextView cAJ;
    public TextView cAK;
    public TextView cAL;
    public LinearLayout cAM;
    public LinearLayout cAN;
    public LinearLayout cAO;
    public LinearLayout cAP;
    public LinearLayout cAQ;
    public TbImageView cAR;
    public TbImageView cAS;
    public TbImageView cAT;
    public TbImageView cAU;
    public TbImageView cAV;
    public TbImageView cAW;
    public TbImageView cAX;
    public TbImageView cAY;
    public TbImageView cAZ;
    public TbImageView cBa;
    public TbImageView cBb;
    public TbImageView cBc;
    public TbImageView cBd;
    public TbImageView cBe;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public b(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.cAG = this.mRootView.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.cAH = (HeadImageView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.cAH.setPageId(bdUniqueId);
        this.bFM = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.bFM.setPageId(bdUniqueId);
        this.cAH.setDefaultResource(17170445);
        this.cAH.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cAH.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cAH.setRadius(k.g(tbPageContext.getPageActivity(), d.f.ds70));
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(k.g(tbPageContext.getPageActivity(), d.f.ds70));
        }
        this.bFM.wD();
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.cAI = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_username);
        this.cAJ = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_tips);
        this.cAK = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_title);
        this.cAL = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(d.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(d.f.ds3) + (width / 2);
        this.cAR = (TbImageView) this.mRootView.findViewById(d.h.frs_wefan_cover_image);
        a(this.cAR, width);
        this.cAM = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_1);
        this.cAN = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_2);
        this.cAO = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_3);
        this.cAP = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_4);
        this.cAQ = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_5);
        this.cAS = (TbImageView) this.cAM.getChildAt(0);
        this.cAT = (TbImageView) this.cAM.getChildAt(1);
        this.cAU = (TbImageView) this.cAM.getChildAt(2);
        this.cAV = (TbImageView) this.cAN.getChildAt(0);
        this.cAW = (TbImageView) this.cAN.getChildAt(1);
        this.cAX = (TbImageView) this.cAN.getChildAt(2);
        this.cAY = (TbImageView) this.cAO.getChildAt(0);
        this.cAZ = (TbImageView) this.cAO.getChildAt(1);
        this.cBa = (TbImageView) this.cAO.getChildAt(2);
        this.cBb = (TbImageView) this.cAP.getChildAt(0);
        this.cBc = (TbImageView) this.cAP.getChildAt(1);
        this.cBd = (TbImageView) this.cAQ.getChildAt(0);
        this.cBe = (TbImageView) this.cAQ.getChildAt(1);
        a(this.cAS, i);
        a(this.cAT, i);
        a(this.cAU, i);
        a(this.cAV, i);
        a(this.cAW, i);
        a(this.cAX, i);
        a(this.cAY, i);
        a(this.cAZ, i);
        a(this.cBa, i);
        a(this.cBb, dimensionPixelSize);
        a(this.cBc, dimensionPixelSize);
        a(this.cBd, dimensionPixelSize);
        a(this.cBe, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
