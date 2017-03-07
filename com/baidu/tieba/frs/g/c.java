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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends y.a {
    public HeadPendantClickableView bTG;
    public TbImageView cgA;
    public TbImageView cgB;
    public TbImageView cgC;
    public TbImageView cgD;
    public TbImageView cgE;
    public TbImageView cgF;
    public TbImageView cgG;
    public TbImageView cgH;
    public View cgj;
    public HeadImageView cgk;
    public TextView cgl;
    public TextView cgm;
    public TextView cgn;
    public TextView cgo;
    public LinearLayout cgp;
    public LinearLayout cgq;
    public LinearLayout cgr;
    public LinearLayout cgs;
    public LinearLayout cgt;
    public TbImageView cgu;
    public TbImageView cgv;
    public TbImageView cgw;
    public TbImageView cgx;
    public TbImageView cgy;
    public TbImageView cgz;
    public View mRootView;
    public int mSkinType;

    public c(BaseActivity baseActivity, View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = getView();
        this.cgj = this.mRootView.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.cgk = (HeadImageView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bTG = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.cgk.setDefaultResource(17170445);
        this.cgk.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.cgk.setDefaultBgResource(w.e.cp_bg_line_e);
        this.cgk.setRadius(k.g(baseActivity.getPageContext().getPageActivity(), w.f.ds70));
        if (this.bTG.getHeadView() != null) {
            this.bTG.getHeadView().setIsRound(true);
            this.bTG.getHeadView().setDrawBorder(false);
            this.bTG.getHeadView().setDefaultResource(17170445);
            this.bTG.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bTG.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bTG.getHeadView().setRadius(k.g(baseActivity.getPageContext().getPageActivity(), w.f.ds70));
        }
        this.bTG.wp();
        if (this.bTG.getPendantView() != null) {
            this.bTG.getPendantView().setIsRound(true);
            this.bTG.getPendantView().setDrawBorder(false);
        }
        this.cgl = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_username);
        this.cgm = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_tips);
        this.cgn = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_title);
        this.cgo = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(w.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(w.f.ds3) + (width / 2);
        this.cgu = (TbImageView) this.mRootView.findViewById(w.h.frs_wefan_cover_image);
        b(this.cgu, width);
        this.cgp = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_1);
        this.cgq = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_2);
        this.cgr = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_3);
        this.cgs = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_4);
        this.cgt = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_5);
        this.cgv = (TbImageView) this.cgp.getChildAt(0);
        this.cgw = (TbImageView) this.cgp.getChildAt(1);
        this.cgx = (TbImageView) this.cgp.getChildAt(2);
        this.cgy = (TbImageView) this.cgq.getChildAt(0);
        this.cgz = (TbImageView) this.cgq.getChildAt(1);
        this.cgA = (TbImageView) this.cgq.getChildAt(2);
        this.cgB = (TbImageView) this.cgr.getChildAt(0);
        this.cgC = (TbImageView) this.cgr.getChildAt(1);
        this.cgD = (TbImageView) this.cgr.getChildAt(2);
        this.cgE = (TbImageView) this.cgs.getChildAt(0);
        this.cgF = (TbImageView) this.cgs.getChildAt(1);
        this.cgG = (TbImageView) this.cgt.getChildAt(0);
        this.cgH = (TbImageView) this.cgt.getChildAt(1);
        b(this.cgv, i);
        b(this.cgw, i);
        b(this.cgx, i);
        b(this.cgy, i);
        b(this.cgz, i);
        b(this.cgA, i);
        b(this.cgB, i);
        b(this.cgC, i);
        b(this.cgD, i);
        b(this.cgE, dimensionPixelSize);
        b(this.cgF, dimensionPixelSize);
        b(this.cgG, dimensionPixelSize);
        b(this.cgH, dimensionPixelSize);
    }

    private void b(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }
}
