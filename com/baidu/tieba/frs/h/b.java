package com.baidu.tieba.frs.h;

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
    public HeadPendantClickableView bRc;
    public TbImageView cUA;
    public TbImageView cUB;
    public TbImageView cUC;
    public TbImageView cUD;
    public TbImageView cUE;
    public View cUg;
    public HeadImageView cUh;
    public TextView cUi;
    public TextView cUj;
    public TextView cUk;
    public TextView cUl;
    public LinearLayout cUm;
    public LinearLayout cUn;
    public LinearLayout cUo;
    public LinearLayout cUp;
    public LinearLayout cUq;
    public TbImageView cUr;
    public TbImageView cUs;
    public TbImageView cUt;
    public TbImageView cUu;
    public TbImageView cUv;
    public TbImageView cUw;
    public TbImageView cUx;
    public TbImageView cUy;
    public TbImageView cUz;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public b(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.cUg = this.mRootView.findViewById(d.g.card_home_page_normal_thread_top_line);
        this.cUh = (HeadImageView) this.mRootView.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.cUh.setPageId(bdUniqueId);
        this.bRc = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.bRc.setPageId(bdUniqueId);
        this.cUh.setDefaultResource(17170445);
        this.cUh.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cUh.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cUh.setRadius(l.f(tbPageContext.getPageActivity(), d.e.ds70));
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(l.f(tbPageContext.getPageActivity(), d.e.ds70));
        }
        this.bRc.wg();
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.cUi = (TextView) this.mRootView.findViewById(d.g.frs_wefan_tv_username);
        this.cUj = (TextView) this.mRootView.findViewById(d.g.frs_wefan_tv_tips);
        this.cUk = (TextView) this.mRootView.findViewById(d.g.frs_wefan_tv_title);
        this.cUl = (TextView) this.mRootView.findViewById(d.g.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(d.e.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(d.e.ds3) + (width / 2);
        this.cUr = (TbImageView) this.mRootView.findViewById(d.g.frs_wefan_cover_image);
        a(this.cUr, width);
        this.cUm = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_1);
        this.cUn = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_2);
        this.cUo = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_3);
        this.cUp = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_4);
        this.cUq = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_5);
        this.cUs = (TbImageView) this.cUm.getChildAt(0);
        this.cUt = (TbImageView) this.cUm.getChildAt(1);
        this.cUu = (TbImageView) this.cUm.getChildAt(2);
        this.cUv = (TbImageView) this.cUn.getChildAt(0);
        this.cUw = (TbImageView) this.cUn.getChildAt(1);
        this.cUx = (TbImageView) this.cUn.getChildAt(2);
        this.cUy = (TbImageView) this.cUo.getChildAt(0);
        this.cUz = (TbImageView) this.cUo.getChildAt(1);
        this.cUA = (TbImageView) this.cUo.getChildAt(2);
        this.cUB = (TbImageView) this.cUp.getChildAt(0);
        this.cUC = (TbImageView) this.cUp.getChildAt(1);
        this.cUD = (TbImageView) this.cUq.getChildAt(0);
        this.cUE = (TbImageView) this.cUq.getChildAt(1);
        a(this.cUs, i);
        a(this.cUt, i);
        a(this.cUu, i);
        a(this.cUv, i);
        a(this.cUw, i);
        a(this.cUx, i);
        a(this.cUy, i);
        a(this.cUz, i);
        a(this.cUA, i);
        a(this.cUB, dimensionPixelSize);
        a(this.cUC, dimensionPixelSize);
        a(this.cUD, dimensionPixelSize);
        a(this.cUE, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
