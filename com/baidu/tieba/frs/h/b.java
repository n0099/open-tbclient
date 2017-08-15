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
    public HeadPendantClickableView bGv;
    public View cCD;
    public HeadImageView cCE;
    public TextView cCF;
    public TextView cCG;
    public TextView cCH;
    public TextView cCI;
    public LinearLayout cCJ;
    public LinearLayout cCK;
    public LinearLayout cCL;
    public LinearLayout cCM;
    public LinearLayout cCN;
    public TbImageView cCO;
    public TbImageView cCP;
    public TbImageView cCQ;
    public TbImageView cCR;
    public TbImageView cCS;
    public TbImageView cCT;
    public TbImageView cCU;
    public TbImageView cCV;
    public TbImageView cCW;
    public TbImageView cCX;
    public TbImageView cCY;
    public TbImageView cCZ;
    public TbImageView cDa;
    public TbImageView cDb;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public b(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.cCD = this.mRootView.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.cCE = (HeadImageView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.cCE.setPageId(bdUniqueId);
        this.bGv = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.bGv.setPageId(bdUniqueId);
        this.cCE.setDefaultResource(17170445);
        this.cCE.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cCE.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cCE.setRadius(k.g(tbPageContext.getPageActivity(), d.f.ds70));
        if (this.bGv.getHeadView() != null) {
            this.bGv.getHeadView().setIsRound(true);
            this.bGv.getHeadView().setDrawBorder(false);
            this.bGv.getHeadView().setDefaultResource(17170445);
            this.bGv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGv.getHeadView().setRadius(k.g(tbPageContext.getPageActivity(), d.f.ds70));
        }
        this.bGv.wD();
        if (this.bGv.getPendantView() != null) {
            this.bGv.getPendantView().setIsRound(true);
            this.bGv.getPendantView().setDrawBorder(false);
        }
        this.cCF = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_username);
        this.cCG = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_tips);
        this.cCH = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_title);
        this.cCI = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(d.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(d.f.ds3) + (width / 2);
        this.cCO = (TbImageView) this.mRootView.findViewById(d.h.frs_wefan_cover_image);
        a(this.cCO, width);
        this.cCJ = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_1);
        this.cCK = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_2);
        this.cCL = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_3);
        this.cCM = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_4);
        this.cCN = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_5);
        this.cCP = (TbImageView) this.cCJ.getChildAt(0);
        this.cCQ = (TbImageView) this.cCJ.getChildAt(1);
        this.cCR = (TbImageView) this.cCJ.getChildAt(2);
        this.cCS = (TbImageView) this.cCK.getChildAt(0);
        this.cCT = (TbImageView) this.cCK.getChildAt(1);
        this.cCU = (TbImageView) this.cCK.getChildAt(2);
        this.cCV = (TbImageView) this.cCL.getChildAt(0);
        this.cCW = (TbImageView) this.cCL.getChildAt(1);
        this.cCX = (TbImageView) this.cCL.getChildAt(2);
        this.cCY = (TbImageView) this.cCM.getChildAt(0);
        this.cCZ = (TbImageView) this.cCM.getChildAt(1);
        this.cDa = (TbImageView) this.cCN.getChildAt(0);
        this.cDb = (TbImageView) this.cCN.getChildAt(1);
        a(this.cCP, i);
        a(this.cCQ, i);
        a(this.cCR, i);
        a(this.cCS, i);
        a(this.cCT, i);
        a(this.cCU, i);
        a(this.cCV, i);
        a(this.cCW, i);
        a(this.cCX, i);
        a(this.cCY, dimensionPixelSize);
        a(this.cCZ, dimensionPixelSize);
        a(this.cDa, dimensionPixelSize);
        a(this.cDb, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
