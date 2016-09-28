package com.baidu.tieba.frs.j;

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
    public TextView bAa;
    public HeadPendantClickableView bXk;
    public View chY;
    public HeadImageView chZ;
    public TextView cia;
    public TextView cib;
    public TextView cic;
    public LinearLayout cie;
    public LinearLayout cif;
    public LinearLayout cig;
    public LinearLayout cih;
    public LinearLayout cii;
    public TbImageView cij;
    public TbImageView cik;
    public TbImageView cil;
    public TbImageView cim;
    public TbImageView cin;
    public TbImageView cio;
    public TbImageView cip;
    public TbImageView ciq;
    public TbImageView cir;
    public TbImageView cis;
    public TbImageView cit;
    public TbImageView ciu;
    public TbImageView civ;
    public TbImageView ciw;
    public View mRootView;
    public int mSkinType;

    public c(BaseActivity baseActivity, View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = getView();
        this.chY = this.mRootView.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.chZ = (HeadImageView) this.mRootView.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.bXk = (HeadPendantClickableView) this.mRootView.findViewById(r.g.card_home_page_normal_thread_user_pendant_header);
        this.chZ.setDefaultResource(17170445);
        this.chZ.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.chZ.setDefaultBgResource(r.d.cp_bg_line_e);
        this.chZ.setRadius(k.e(baseActivity.getPageContext().getPageActivity(), r.e.ds70));
        if (this.bXk.getHeadView() != null) {
            this.bXk.getHeadView().setIsRound(true);
            this.bXk.getHeadView().setDrawBorder(false);
            this.bXk.getHeadView().setDefaultResource(17170445);
            this.bXk.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bXk.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.bXk.getHeadView().setRadius(k.e(baseActivity.getPageContext().getPageActivity(), r.e.ds70));
        }
        this.bXk.wk();
        if (this.bXk.getPendantView() != null) {
            this.bXk.getPendantView().setIsRound(true);
            this.bXk.getPendantView().setDrawBorder(false);
        }
        this.bAa = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_username);
        this.cia = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_tips);
        this.cib = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_title);
        this.cic = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(r.e.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(r.e.ds3) + (width / 2);
        this.cij = (TbImageView) this.mRootView.findViewById(r.g.frs_wefan_cover_image);
        b(this.cij, width);
        this.cie = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_1);
        this.cif = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_2);
        this.cig = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_3);
        this.cih = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_4);
        this.cii = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_5);
        this.cik = (TbImageView) this.cie.getChildAt(0);
        this.cil = (TbImageView) this.cie.getChildAt(1);
        this.cim = (TbImageView) this.cie.getChildAt(2);
        this.cin = (TbImageView) this.cif.getChildAt(0);
        this.cio = (TbImageView) this.cif.getChildAt(1);
        this.cip = (TbImageView) this.cif.getChildAt(2);
        this.ciq = (TbImageView) this.cig.getChildAt(0);
        this.cir = (TbImageView) this.cig.getChildAt(1);
        this.cis = (TbImageView) this.cig.getChildAt(2);
        this.cit = (TbImageView) this.cih.getChildAt(0);
        this.ciu = (TbImageView) this.cih.getChildAt(1);
        this.civ = (TbImageView) this.cii.getChildAt(0);
        this.ciw = (TbImageView) this.cii.getChildAt(1);
        b(this.cik, i);
        b(this.cil, i);
        b(this.cim, i);
        b(this.cin, i);
        b(this.cio, i);
        b(this.cip, i);
        b(this.ciq, i);
        b(this.cir, i);
        b(this.cis, i);
        b(this.cit, dimensionPixelSize);
        b(this.ciu, dimensionPixelSize);
        b(this.civ, dimensionPixelSize);
        b(this.ciw, dimensionPixelSize);
    }

    private void b(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }
}
