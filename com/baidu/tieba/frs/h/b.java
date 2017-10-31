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
    public HeadPendantClickableView bQP;
    public View cTM;
    public HeadImageView cTN;
    public TextView cTO;
    public TextView cTP;
    public TextView cTQ;
    public TextView cTR;
    public LinearLayout cTS;
    public LinearLayout cTT;
    public LinearLayout cTU;
    public LinearLayout cTV;
    public LinearLayout cTW;
    public TbImageView cTX;
    public TbImageView cTY;
    public TbImageView cTZ;
    public TbImageView cUa;
    public TbImageView cUb;
    public TbImageView cUc;
    public TbImageView cUd;
    public TbImageView cUe;
    public TbImageView cUf;
    public TbImageView cUg;
    public TbImageView cUh;
    public TbImageView cUi;
    public TbImageView cUj;
    public TbImageView cUk;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public b(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.cTM = this.mRootView.findViewById(d.g.card_home_page_normal_thread_top_line);
        this.cTN = (HeadImageView) this.mRootView.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.cTN.setPageId(bdUniqueId);
        this.bQP = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.bQP.setPageId(bdUniqueId);
        this.cTN.setDefaultResource(17170445);
        this.cTN.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cTN.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cTN.setRadius(l.f(tbPageContext.getPageActivity(), d.e.ds70));
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(l.f(tbPageContext.getPageActivity(), d.e.ds70));
        }
        this.bQP.wg();
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.cTO = (TextView) this.mRootView.findViewById(d.g.frs_wefan_tv_username);
        this.cTP = (TextView) this.mRootView.findViewById(d.g.frs_wefan_tv_tips);
        this.cTQ = (TextView) this.mRootView.findViewById(d.g.frs_wefan_tv_title);
        this.cTR = (TextView) this.mRootView.findViewById(d.g.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(d.e.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(d.e.ds3) + (width / 2);
        this.cTX = (TbImageView) this.mRootView.findViewById(d.g.frs_wefan_cover_image);
        a(this.cTX, width);
        this.cTS = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_1);
        this.cTT = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_2);
        this.cTU = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_3);
        this.cTV = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_4);
        this.cTW = (LinearLayout) this.mRootView.findViewById(d.g.frs_wefan_image_row_5);
        this.cTY = (TbImageView) this.cTS.getChildAt(0);
        this.cTZ = (TbImageView) this.cTS.getChildAt(1);
        this.cUa = (TbImageView) this.cTS.getChildAt(2);
        this.cUb = (TbImageView) this.cTT.getChildAt(0);
        this.cUc = (TbImageView) this.cTT.getChildAt(1);
        this.cUd = (TbImageView) this.cTT.getChildAt(2);
        this.cUe = (TbImageView) this.cTU.getChildAt(0);
        this.cUf = (TbImageView) this.cTU.getChildAt(1);
        this.cUg = (TbImageView) this.cTU.getChildAt(2);
        this.cUh = (TbImageView) this.cTV.getChildAt(0);
        this.cUi = (TbImageView) this.cTV.getChildAt(1);
        this.cUj = (TbImageView) this.cTW.getChildAt(0);
        this.cUk = (TbImageView) this.cTW.getChildAt(1);
        a(this.cTY, i);
        a(this.cTZ, i);
        a(this.cUa, i);
        a(this.cUb, i);
        a(this.cUc, i);
        a(this.cUd, i);
        a(this.cUe, i);
        a(this.cUf, i);
        a(this.cUg, i);
        a(this.cUh, dimensionPixelSize);
        a(this.cUi, dimensionPixelSize);
        a(this.cUj, dimensionPixelSize);
        a(this.cUk, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
