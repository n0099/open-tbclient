package com.baidu.tieba.frs.h;

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
    public HeadPendantClickableView bVL;
    public View cha;
    public HeadImageView chb;
    public TextView chc;
    public TextView chd;
    public TextView che;
    public TextView chf;
    public LinearLayout chg;
    public LinearLayout chh;
    public LinearLayout chi;
    public LinearLayout chj;
    public LinearLayout chk;
    public TbImageView chl;
    public TbImageView chm;
    public TbImageView chn;
    public TbImageView cho;
    public TbImageView chp;
    public TbImageView chq;
    public TbImageView chr;
    public TbImageView chs;
    public TbImageView cht;
    public TbImageView chu;
    public TbImageView chv;
    public TbImageView chw;
    public TbImageView chx;
    public TbImageView chy;
    public View mRootView;
    public int mSkinType;

    public c(BaseActivity baseActivity, View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = getView();
        this.cha = this.mRootView.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.chb = (HeadImageView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bVL = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.chb.setDefaultResource(17170445);
        this.chb.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.chb.setDefaultBgResource(w.e.cp_bg_line_e);
        this.chb.setRadius(k.g(baseActivity.getPageContext().getPageActivity(), w.f.ds70));
        if (this.bVL.getHeadView() != null) {
            this.bVL.getHeadView().setIsRound(true);
            this.bVL.getHeadView().setDrawBorder(false);
            this.bVL.getHeadView().setDefaultResource(17170445);
            this.bVL.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bVL.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bVL.getHeadView().setRadius(k.g(baseActivity.getPageContext().getPageActivity(), w.f.ds70));
        }
        this.bVL.wL();
        if (this.bVL.getPendantView() != null) {
            this.bVL.getPendantView().setIsRound(true);
            this.bVL.getPendantView().setDrawBorder(false);
        }
        this.chc = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_username);
        this.chd = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_tips);
        this.che = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_title);
        this.chf = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(w.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(w.f.ds3) + (width / 2);
        this.chl = (TbImageView) this.mRootView.findViewById(w.h.frs_wefan_cover_image);
        a(this.chl, width);
        this.chg = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_1);
        this.chh = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_2);
        this.chi = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_3);
        this.chj = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_4);
        this.chk = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_5);
        this.chm = (TbImageView) this.chg.getChildAt(0);
        this.chn = (TbImageView) this.chg.getChildAt(1);
        this.cho = (TbImageView) this.chg.getChildAt(2);
        this.chp = (TbImageView) this.chh.getChildAt(0);
        this.chq = (TbImageView) this.chh.getChildAt(1);
        this.chr = (TbImageView) this.chh.getChildAt(2);
        this.chs = (TbImageView) this.chi.getChildAt(0);
        this.cht = (TbImageView) this.chi.getChildAt(1);
        this.chu = (TbImageView) this.chi.getChildAt(2);
        this.chv = (TbImageView) this.chj.getChildAt(0);
        this.chw = (TbImageView) this.chj.getChildAt(1);
        this.chx = (TbImageView) this.chk.getChildAt(0);
        this.chy = (TbImageView) this.chk.getChildAt(1);
        a(this.chm, i);
        a(this.chn, i);
        a(this.cho, i);
        a(this.chp, i);
        a(this.chq, i);
        a(this.chr, i);
        a(this.chs, i);
        a(this.cht, i);
        a(this.chu, i);
        a(this.chv, dimensionPixelSize);
        a(this.chw, dimensionPixelSize);
        a(this.chx, dimensionPixelSize);
        a(this.chy, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }
}
