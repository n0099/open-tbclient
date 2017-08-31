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
    public HeadPendantClickableView bJq;
    public View cIT;
    public HeadImageView cIU;
    public TextView cIV;
    public TextView cIW;
    public TextView cIX;
    public TextView cIY;
    public LinearLayout cIZ;
    public LinearLayout cJa;
    public LinearLayout cJb;
    public LinearLayout cJc;
    public LinearLayout cJd;
    public TbImageView cJe;
    public TbImageView cJf;
    public TbImageView cJg;
    public TbImageView cJh;
    public TbImageView cJi;
    public TbImageView cJj;
    public TbImageView cJk;
    public TbImageView cJl;
    public TbImageView cJm;
    public TbImageView cJn;
    public TbImageView cJo;
    public TbImageView cJp;
    public TbImageView cJq;
    public TbImageView cJr;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public b(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.cIT = this.mRootView.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.cIU = (HeadImageView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.cIU.setPageId(bdUniqueId);
        this.bJq = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.bJq.setPageId(bdUniqueId);
        this.cIU.setDefaultResource(17170445);
        this.cIU.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cIU.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cIU.setRadius(k.g(tbPageContext.getPageActivity(), d.f.ds70));
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(k.g(tbPageContext.getPageActivity(), d.f.ds70));
        }
        this.bJq.wB();
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.cIV = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_username);
        this.cIW = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_tips);
        this.cIX = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_title);
        this.cIY = (TextView) this.mRootView.findViewById(d.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(d.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(d.f.ds3) + (width / 2);
        this.cJe = (TbImageView) this.mRootView.findViewById(d.h.frs_wefan_cover_image);
        a(this.cJe, width);
        this.cIZ = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_1);
        this.cJa = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_2);
        this.cJb = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_3);
        this.cJc = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_4);
        this.cJd = (LinearLayout) this.mRootView.findViewById(d.h.frs_wefan_image_row_5);
        this.cJf = (TbImageView) this.cIZ.getChildAt(0);
        this.cJg = (TbImageView) this.cIZ.getChildAt(1);
        this.cJh = (TbImageView) this.cIZ.getChildAt(2);
        this.cJi = (TbImageView) this.cJa.getChildAt(0);
        this.cJj = (TbImageView) this.cJa.getChildAt(1);
        this.cJk = (TbImageView) this.cJa.getChildAt(2);
        this.cJl = (TbImageView) this.cJb.getChildAt(0);
        this.cJm = (TbImageView) this.cJb.getChildAt(1);
        this.cJn = (TbImageView) this.cJb.getChildAt(2);
        this.cJo = (TbImageView) this.cJc.getChildAt(0);
        this.cJp = (TbImageView) this.cJc.getChildAt(1);
        this.cJq = (TbImageView) this.cJd.getChildAt(0);
        this.cJr = (TbImageView) this.cJd.getChildAt(1);
        a(this.cJf, i);
        a(this.cJg, i);
        a(this.cJh, i);
        a(this.cJi, i);
        a(this.cJj, i);
        a(this.cJk, i);
        a(this.cJl, i);
        a(this.cJm, i);
        a(this.cJn, i);
        a(this.cJo, dimensionPixelSize);
        a(this.cJp, dimensionPixelSize);
        a(this.cJq, dimensionPixelSize);
        a(this.cJr, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
