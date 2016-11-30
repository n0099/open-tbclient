package com.baidu.tieba.frs.k;

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
    public TextView bCV;
    public HeadPendantClickableView caA;
    public TbImageView cnA;
    public TbImageView cnB;
    public TbImageView cnC;
    public TbImageView cnD;
    public View cnf;
    public HeadImageView cng;
    public TextView cnh;
    public TextView cni;
    public TextView cnj;
    public LinearLayout cnk;
    public LinearLayout cnl;
    public LinearLayout cnm;
    public LinearLayout cnn;
    public LinearLayout cno;
    public TbImageView cnp;
    public TbImageView cnq;
    public TbImageView cnr;
    public TbImageView cns;
    public TbImageView cnu;
    public TbImageView cnv;
    public TbImageView cnw;
    public TbImageView cnx;
    public TbImageView cny;
    public TbImageView cnz;
    public View mRootView;
    public int mSkinType;

    public c(BaseActivity baseActivity, View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = getView();
        this.cnf = this.mRootView.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.cng = (HeadImageView) this.mRootView.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.caA = (HeadPendantClickableView) this.mRootView.findViewById(r.g.card_home_page_normal_thread_user_pendant_header);
        this.cng.setDefaultResource(17170445);
        this.cng.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.cng.setDefaultBgResource(r.d.cp_bg_line_e);
        this.cng.setRadius(k.e(baseActivity.getPageContext().getPageActivity(), r.e.ds70));
        if (this.caA.getHeadView() != null) {
            this.caA.getHeadView().setIsRound(true);
            this.caA.getHeadView().setDrawBorder(false);
            this.caA.getHeadView().setDefaultResource(17170445);
            this.caA.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.caA.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.caA.getHeadView().setRadius(k.e(baseActivity.getPageContext().getPageActivity(), r.e.ds70));
        }
        this.caA.wo();
        if (this.caA.getPendantView() != null) {
            this.caA.getPendantView().setIsRound(true);
            this.caA.getPendantView().setDrawBorder(false);
        }
        this.bCV = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_username);
        this.cnh = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_tips);
        this.cni = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_title);
        this.cnj = (TextView) this.mRootView.findViewById(r.g.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(r.e.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(r.e.ds3) + (width / 2);
        this.cnp = (TbImageView) this.mRootView.findViewById(r.g.frs_wefan_cover_image);
        b(this.cnp, width);
        this.cnk = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_1);
        this.cnl = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_2);
        this.cnm = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_3);
        this.cnn = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_4);
        this.cno = (LinearLayout) this.mRootView.findViewById(r.g.frs_wefan_image_row_5);
        this.cnq = (TbImageView) this.cnk.getChildAt(0);
        this.cnr = (TbImageView) this.cnk.getChildAt(1);
        this.cns = (TbImageView) this.cnk.getChildAt(2);
        this.cnu = (TbImageView) this.cnl.getChildAt(0);
        this.cnv = (TbImageView) this.cnl.getChildAt(1);
        this.cnw = (TbImageView) this.cnl.getChildAt(2);
        this.cnx = (TbImageView) this.cnm.getChildAt(0);
        this.cny = (TbImageView) this.cnm.getChildAt(1);
        this.cnz = (TbImageView) this.cnm.getChildAt(2);
        this.cnA = (TbImageView) this.cnn.getChildAt(0);
        this.cnB = (TbImageView) this.cnn.getChildAt(1);
        this.cnC = (TbImageView) this.cno.getChildAt(0);
        this.cnD = (TbImageView) this.cno.getChildAt(1);
        b(this.cnq, i);
        b(this.cnr, i);
        b(this.cns, i);
        b(this.cnu, i);
        b(this.cnv, i);
        b(this.cnw, i);
        b(this.cnx, i);
        b(this.cny, i);
        b(this.cnz, i);
        b(this.cnA, dimensionPixelSize);
        b(this.cnB, dimensionPixelSize);
        b(this.cnC, dimensionPixelSize);
        b(this.cnD, dimensionPixelSize);
    }

    private void b(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }
}
