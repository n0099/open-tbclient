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
    public HeadPendantClickableView bJv;
    public View cKN;
    public HeadImageView cKO;
    public TextView cKP;
    public TextView cKQ;
    public TextView cKR;
    public TextView cKS;
    public LinearLayout cKT;
    public LinearLayout cKU;
    public LinearLayout cKV;
    public LinearLayout cKW;
    public LinearLayout cKX;
    public TbImageView cKY;
    public TbImageView cKZ;
    public TbImageView cLa;
    public TbImageView cLb;
    public TbImageView cLc;
    public TbImageView cLd;
    public TbImageView cLe;
    public TbImageView cLf;
    public TbImageView cLg;
    public TbImageView cLh;
    public TbImageView cLi;
    public TbImageView cLj;
    public TbImageView cLk;
    public TbImageView cLl;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public b(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.cKN = this.mRootView.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.cKO = (HeadImageView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.cKO.setPageId(bdUniqueId);
        this.bJv = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.bJv.setPageId(bdUniqueId);
        this.cKO.setDefaultResource(17170445);
        this.cKO.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cKO.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cKO.setRadius(l.f(tbPageContext.getPageActivity(), d.f.ds70));
        if (this.bJv.getHeadView() != null) {
            this.bJv.getHeadView().setIsRound(true);
            this.bJv.getHeadView().setDrawBorder(false);
            this.bJv.getHeadView().setDefaultResource(17170445);
            this.bJv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJv.getHeadView().setRadius(l.f(tbPageContext.getPageActivity(), d.f.ds70));
        }
        this.bJv.wg();
        if (this.bJv.getPendantView() != null) {
            this.bJv.getPendantView().setIsRound(true);
            this.bJv.getPendantView().setDrawBorder(false);
        }
        this.cKP = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_username);
        this.cKQ = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_tips);
        this.cKR = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_title);
        this.cKS = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(d.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(d.f.ds3) + (width / 2);
        this.cKY = (TbImageView) this.mRootView.findViewById(d.h.frs_wefan_cover_image);
        a(this.cKY, width);
        this.cKT = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_1);
        this.cKU = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_2);
        this.cKV = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_3);
        this.cKW = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_4);
        this.cKX = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_5);
        this.cKZ = (TbImageView) this.cKT.getChildAt(0);
        this.cLa = (TbImageView) this.cKT.getChildAt(1);
        this.cLb = (TbImageView) this.cKT.getChildAt(2);
        this.cLc = (TbImageView) this.cKU.getChildAt(0);
        this.cLd = (TbImageView) this.cKU.getChildAt(1);
        this.cLe = (TbImageView) this.cKU.getChildAt(2);
        this.cLf = (TbImageView) this.cKV.getChildAt(0);
        this.cLg = (TbImageView) this.cKV.getChildAt(1);
        this.cLh = (TbImageView) this.cKV.getChildAt(2);
        this.cLi = (TbImageView) this.cKW.getChildAt(0);
        this.cLj = (TbImageView) this.cKW.getChildAt(1);
        this.cLk = (TbImageView) this.cKX.getChildAt(0);
        this.cLl = (TbImageView) this.cKX.getChildAt(1);
        a(this.cKZ, i);
        a(this.cLa, i);
        a(this.cLb, i);
        a(this.cLc, i);
        a(this.cLd, i);
        a(this.cLe, i);
        a(this.cLf, i);
        a(this.cLg, i);
        a(this.cLh, i);
        a(this.cLi, dimensionPixelSize);
        a(this.cLj, dimensionPixelSize);
        a(this.cLk, dimensionPixelSize);
        a(this.cLl, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
