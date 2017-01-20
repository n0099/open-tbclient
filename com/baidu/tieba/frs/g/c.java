package com.baidu.tieba.frs.g;

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
    public HeadPendantClickableView bMy;
    public View bYN;
    public HeadImageView bYO;
    public TextView bYP;
    public TextView bYQ;
    public TextView bYR;
    public TextView bYS;
    public LinearLayout bYT;
    public LinearLayout bYU;
    public LinearLayout bYV;
    public LinearLayout bYW;
    public LinearLayout bYX;
    public TbImageView bYY;
    public TbImageView bYZ;
    public TbImageView bZa;
    public TbImageView bZb;
    public TbImageView bZc;
    public TbImageView bZd;
    public TbImageView bZe;
    public TbImageView bZf;
    public TbImageView bZg;
    public TbImageView bZh;
    public TbImageView bZi;
    public TbImageView bZj;
    public TbImageView bZk;
    public TbImageView bZl;
    public View mRootView;
    public int mSkinType;

    public c(BaseActivity baseActivity, View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = getView();
        this.bYN = this.mRootView.findViewById(r.h.card_home_page_normal_thread_top_line);
        this.bYO = (HeadImageView) this.mRootView.findViewById(r.h.card_home_page_normal_thread_user_header);
        this.bMy = (HeadPendantClickableView) this.mRootView.findViewById(r.h.card_home_page_normal_thread_user_pendant_header);
        this.bYO.setDefaultResource(17170445);
        this.bYO.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.bYO.setDefaultBgResource(r.e.cp_bg_line_e);
        this.bYO.setRadius(k.e(baseActivity.getPageContext().getPageActivity(), r.f.ds70));
        if (this.bMy.getHeadView() != null) {
            this.bMy.getHeadView().setIsRound(true);
            this.bMy.getHeadView().setDrawBorder(false);
            this.bMy.getHeadView().setDefaultResource(17170445);
            this.bMy.getHeadView().setDefaultErrorResource(r.g.icon_default_avatar100);
            this.bMy.getHeadView().setDefaultBgResource(r.e.cp_bg_line_e);
            this.bMy.getHeadView().setRadius(k.e(baseActivity.getPageContext().getPageActivity(), r.f.ds70));
        }
        this.bMy.vS();
        if (this.bMy.getPendantView() != null) {
            this.bMy.getPendantView().setIsRound(true);
            this.bMy.getPendantView().setDrawBorder(false);
        }
        this.bYP = (TextView) this.mRootView.findViewById(r.h.frs_wefan_tv_username);
        this.bYQ = (TextView) this.mRootView.findViewById(r.h.frs_wefan_tv_tips);
        this.bYR = (TextView) this.mRootView.findViewById(r.h.frs_wefan_tv_title);
        this.bYS = (TextView) this.mRootView.findViewById(r.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(r.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(r.f.ds3) + (width / 2);
        this.bYY = (TbImageView) this.mRootView.findViewById(r.h.frs_wefan_cover_image);
        b(this.bYY, width);
        this.bYT = (LinearLayout) this.mRootView.findViewById(r.h.frs_wefan_image_row_1);
        this.bYU = (LinearLayout) this.mRootView.findViewById(r.h.frs_wefan_image_row_2);
        this.bYV = (LinearLayout) this.mRootView.findViewById(r.h.frs_wefan_image_row_3);
        this.bYW = (LinearLayout) this.mRootView.findViewById(r.h.frs_wefan_image_row_4);
        this.bYX = (LinearLayout) this.mRootView.findViewById(r.h.frs_wefan_image_row_5);
        this.bYZ = (TbImageView) this.bYT.getChildAt(0);
        this.bZa = (TbImageView) this.bYT.getChildAt(1);
        this.bZb = (TbImageView) this.bYT.getChildAt(2);
        this.bZc = (TbImageView) this.bYU.getChildAt(0);
        this.bZd = (TbImageView) this.bYU.getChildAt(1);
        this.bZe = (TbImageView) this.bYU.getChildAt(2);
        this.bZf = (TbImageView) this.bYV.getChildAt(0);
        this.bZg = (TbImageView) this.bYV.getChildAt(1);
        this.bZh = (TbImageView) this.bYV.getChildAt(2);
        this.bZi = (TbImageView) this.bYW.getChildAt(0);
        this.bZj = (TbImageView) this.bYW.getChildAt(1);
        this.bZk = (TbImageView) this.bYX.getChildAt(0);
        this.bZl = (TbImageView) this.bYX.getChildAt(1);
        b(this.bYZ, i);
        b(this.bZa, i);
        b(this.bZb, i);
        b(this.bZc, i);
        b(this.bZd, i);
        b(this.bZe, i);
        b(this.bZf, i);
        b(this.bZg, i);
        b(this.bZh, i);
        b(this.bZi, dimensionPixelSize);
        b(this.bZj, dimensionPixelSize);
        b(this.bZk, dimensionPixelSize);
        b(this.bZl, dimensionPixelSize);
    }

    private void b(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }
}
