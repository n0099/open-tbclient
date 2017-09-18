package com.baidu.tieba.frs.i;

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
    public HeadPendantClickableView bKh;
    public View cJN;
    public HeadImageView cJO;
    public TextView cJP;
    public TextView cJQ;
    public TextView cJR;
    public TextView cJS;
    public LinearLayout cJT;
    public LinearLayout cJU;
    public LinearLayout cJV;
    public LinearLayout cJW;
    public LinearLayout cJX;
    public TbImageView cJY;
    public TbImageView cJZ;
    public TbImageView cKa;
    public TbImageView cKb;
    public TbImageView cKc;
    public TbImageView cKd;
    public TbImageView cKe;
    public TbImageView cKf;
    public TbImageView cKg;
    public TbImageView cKh;
    public TbImageView cKi;
    public TbImageView cKj;
    public TbImageView cKk;
    public TbImageView cKl;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public b(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.cJN = this.mRootView.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.cJO = (HeadImageView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.cJO.setPageId(bdUniqueId);
        this.bKh = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.bKh.setPageId(bdUniqueId);
        this.cJO.setDefaultResource(17170445);
        this.cJO.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cJO.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cJO.setRadius(k.f(tbPageContext.getPageActivity(), d.f.ds70));
        if (this.bKh.getHeadView() != null) {
            this.bKh.getHeadView().setIsRound(true);
            this.bKh.getHeadView().setDrawBorder(false);
            this.bKh.getHeadView().setDefaultResource(17170445);
            this.bKh.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bKh.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bKh.getHeadView().setRadius(k.f(tbPageContext.getPageActivity(), d.f.ds70));
        }
        this.bKh.wB();
        if (this.bKh.getPendantView() != null) {
            this.bKh.getPendantView().setIsRound(true);
            this.bKh.getPendantView().setDrawBorder(false);
        }
        this.cJP = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_username);
        this.cJQ = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_tips);
        this.cJR = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_title);
        this.cJS = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(d.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(d.f.ds3) + (width / 2);
        this.cJY = (TbImageView) this.mRootView.findViewById(d.h.frs_wefan_cover_image);
        a(this.cJY, width);
        this.cJT = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_1);
        this.cJU = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_2);
        this.cJV = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_3);
        this.cJW = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_4);
        this.cJX = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_5);
        this.cJZ = (TbImageView) this.cJT.getChildAt(0);
        this.cKa = (TbImageView) this.cJT.getChildAt(1);
        this.cKb = (TbImageView) this.cJT.getChildAt(2);
        this.cKc = (TbImageView) this.cJU.getChildAt(0);
        this.cKd = (TbImageView) this.cJU.getChildAt(1);
        this.cKe = (TbImageView) this.cJU.getChildAt(2);
        this.cKf = (TbImageView) this.cJV.getChildAt(0);
        this.cKg = (TbImageView) this.cJV.getChildAt(1);
        this.cKh = (TbImageView) this.cJV.getChildAt(2);
        this.cKi = (TbImageView) this.cJW.getChildAt(0);
        this.cKj = (TbImageView) this.cJW.getChildAt(1);
        this.cKk = (TbImageView) this.cJX.getChildAt(0);
        this.cKl = (TbImageView) this.cJX.getChildAt(1);
        a(this.cJZ, i);
        a(this.cKa, i);
        a(this.cKb, i);
        a(this.cKc, i);
        a(this.cKd, i);
        a(this.cKe, i);
        a(this.cKf, i);
        a(this.cKg, i);
        a(this.cKh, i);
        a(this.cKi, dimensionPixelSize);
        a(this.cKj, dimensionPixelSize);
        a(this.cKk, dimensionPixelSize);
        a(this.cKl, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
