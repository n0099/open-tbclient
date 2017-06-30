package com.baidu.tieba.frs.g;

import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends z.a {
    public HeadPendantClickableView bAv;
    public View csb;
    public HeadImageView csc;
    public TextView csd;
    public TextView cse;
    public TextView csf;
    public TextView csg;
    public LinearLayout csh;
    public LinearLayout csi;
    public LinearLayout csj;
    public LinearLayout csk;
    public LinearLayout csl;
    public TbImageView csm;
    public TbImageView csn;
    public TbImageView cso;
    public TbImageView csp;
    public TbImageView csq;
    public TbImageView csr;
    public TbImageView css;
    public TbImageView cst;
    public TbImageView csu;
    public TbImageView csv;
    public TbImageView csw;
    public TbImageView csx;
    public TbImageView csy;
    public TbImageView csz;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.csb = this.mRootView.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.csc = (HeadImageView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.csc.setPageId(bdUniqueId);
        this.bAv = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.bAv.setPageId(bdUniqueId);
        this.csc.setDefaultResource(17170445);
        this.csc.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.csc.setDefaultBgResource(w.e.cp_bg_line_e);
        this.csc.setRadius(k.g(tbPageContext.getPageActivity(), w.f.ds70));
        if (this.bAv.getHeadView() != null) {
            this.bAv.getHeadView().setIsRound(true);
            this.bAv.getHeadView().setDrawBorder(false);
            this.bAv.getHeadView().setDefaultResource(17170445);
            this.bAv.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bAv.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bAv.getHeadView().setRadius(k.g(tbPageContext.getPageActivity(), w.f.ds70));
        }
        this.bAv.wm();
        if (this.bAv.getPendantView() != null) {
            this.bAv.getPendantView().setIsRound(true);
            this.bAv.getPendantView().setDrawBorder(false);
        }
        this.csd = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_username);
        this.cse = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_tips);
        this.csf = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_title);
        this.csg = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(w.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(w.f.ds3) + (width / 2);
        this.csm = (TbImageView) this.mRootView.findViewById(w.h.frs_wefan_cover_image);
        a(this.csm, width);
        this.csh = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_1);
        this.csi = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_2);
        this.csj = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_3);
        this.csk = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_4);
        this.csl = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_5);
        this.csn = (TbImageView) this.csh.getChildAt(0);
        this.cso = (TbImageView) this.csh.getChildAt(1);
        this.csp = (TbImageView) this.csh.getChildAt(2);
        this.csq = (TbImageView) this.csi.getChildAt(0);
        this.csr = (TbImageView) this.csi.getChildAt(1);
        this.css = (TbImageView) this.csi.getChildAt(2);
        this.cst = (TbImageView) this.csj.getChildAt(0);
        this.csu = (TbImageView) this.csj.getChildAt(1);
        this.csv = (TbImageView) this.csj.getChildAt(2);
        this.csw = (TbImageView) this.csk.getChildAt(0);
        this.csx = (TbImageView) this.csk.getChildAt(1);
        this.csy = (TbImageView) this.csl.getChildAt(0);
        this.csz = (TbImageView) this.csl.getChildAt(1);
        a(this.csn, i);
        a(this.cso, i);
        a(this.csp, i);
        a(this.csq, i);
        a(this.csr, i);
        a(this.css, i);
        a(this.cst, i);
        a(this.csu, i);
        a(this.csv, i);
        a(this.csw, dimensionPixelSize);
        a(this.csx, dimensionPixelSize);
        a(this.csy, dimensionPixelSize);
        a(this.csz, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
