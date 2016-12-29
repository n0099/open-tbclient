package com.baidu.tieba.frs.i;

import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends y.a {
    public HeadPendantClickableView bGj;
    public LinearLayout bSA;
    public TbImageView bSB;
    public TbImageView bSC;
    public TbImageView bSD;
    public TbImageView bSE;
    public TbImageView bSF;
    public TbImageView bSG;
    public TbImageView bSH;
    public TbImageView bSI;
    public TbImageView bSJ;
    public TbImageView bSK;
    public TbImageView bSL;
    public TbImageView bSM;
    public TbImageView bSN;
    public TbImageView bSO;
    public View bSq;
    public HeadImageView bSr;
    public TextView bSs;
    public TextView bSt;
    public TextView bSu;
    public TextView bSv;
    public LinearLayout bSw;
    public LinearLayout bSx;
    public LinearLayout bSy;
    public LinearLayout bSz;
    public View mRootView;
    public int mSkinType;

    public c(BaseActivity baseActivity, View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = getView();
        this.bSq = this.mRootView.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.bSr = (HeadImageView) this.mRootView.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.bGj = (HeadPendantClickableView) this.mRootView.findViewById(r.g.card_home_page_normal_thread_user_pendant_header);
        this.bSr.setDefaultResource(17170445);
        this.bSr.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bSr.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bSr.setRadius(k.e(baseActivity.getPageContext().getPageActivity(), r.e.ds70));
        if (this.bGj.getHeadView() != null) {
            this.bGj.getHeadView().setIsRound(true);
            this.bGj.getHeadView().setDrawBorder(false);
            this.bGj.getHeadView().setDefaultResource(17170445);
            this.bGj.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bGj.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.bGj.getHeadView().setRadius(k.e(baseActivity.getPageContext().getPageActivity(), r.e.ds70));
        }
        this.bGj.vY();
        if (this.bGj.getPendantView() != null) {
            this.bGj.getPendantView().setIsRound(true);
            this.bGj.getPendantView().setDrawBorder(false);
        }
        this.bSs = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_username);
        this.bSt = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_tips);
        this.bSu = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_title);
        this.bSv = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(r.e.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(r.e.ds3) + (width / 2);
        this.bSB = (TbImageView) this.mRootView.findViewById(r.g.frs_wefan_cover_image);
        b(this.bSB, width);
        this.bSw = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_1);
        this.bSx = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_2);
        this.bSy = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_3);
        this.bSz = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_4);
        this.bSA = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_5);
        this.bSC = (TbImageView) this.bSw.getChildAt(0);
        this.bSD = (TbImageView) this.bSw.getChildAt(1);
        this.bSE = (TbImageView) this.bSw.getChildAt(2);
        this.bSF = (TbImageView) this.bSx.getChildAt(0);
        this.bSG = (TbImageView) this.bSx.getChildAt(1);
        this.bSH = (TbImageView) this.bSx.getChildAt(2);
        this.bSI = (TbImageView) this.bSy.getChildAt(0);
        this.bSJ = (TbImageView) this.bSy.getChildAt(1);
        this.bSK = (TbImageView) this.bSy.getChildAt(2);
        this.bSL = (TbImageView) this.bSz.getChildAt(0);
        this.bSM = (TbImageView) this.bSz.getChildAt(1);
        this.bSN = (TbImageView) this.bSA.getChildAt(0);
        this.bSO = (TbImageView) this.bSA.getChildAt(1);
        b(this.bSC, i);
        b(this.bSD, i);
        b(this.bSE, i);
        b(this.bSF, i);
        b(this.bSG, i);
        b(this.bSH, i);
        b(this.bSI, i);
        b(this.bSJ, i);
        b(this.bSK, i);
        b(this.bSL, dimensionPixelSize);
        b(this.bSM, dimensionPixelSize);
        b(this.bSN, dimensionPixelSize);
        b(this.bSO, dimensionPixelSize);
    }

    private void b(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }
}
