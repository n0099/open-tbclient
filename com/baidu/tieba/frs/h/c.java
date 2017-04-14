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
    public HeadPendantClickableView bTu;
    public View ceJ;
    public HeadImageView ceK;
    public TextView ceL;
    public TextView ceM;
    public TextView ceN;
    public TextView ceO;
    public LinearLayout ceP;
    public LinearLayout ceQ;
    public LinearLayout ceR;
    public LinearLayout ceS;
    public LinearLayout ceT;
    public TbImageView ceU;
    public TbImageView ceV;
    public TbImageView ceW;
    public TbImageView ceX;
    public TbImageView ceY;
    public TbImageView ceZ;
    public TbImageView cfa;
    public TbImageView cfb;
    public TbImageView cfc;
    public TbImageView cfd;
    public TbImageView cfe;
    public TbImageView cff;
    public TbImageView cfg;
    public TbImageView cfh;
    public View mRootView;
    public int mSkinType;

    public c(BaseActivity baseActivity, View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = getView();
        this.ceJ = this.mRootView.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.ceK = (HeadImageView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bTu = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.ceK.setDefaultResource(17170445);
        this.ceK.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.ceK.setDefaultBgResource(w.e.cp_bg_line_e);
        this.ceK.setRadius(k.g(baseActivity.getPageContext().getPageActivity(), w.f.ds70));
        if (this.bTu.getHeadView() != null) {
            this.bTu.getHeadView().setIsRound(true);
            this.bTu.getHeadView().setDrawBorder(false);
            this.bTu.getHeadView().setDefaultResource(17170445);
            this.bTu.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bTu.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bTu.getHeadView().setRadius(k.g(baseActivity.getPageContext().getPageActivity(), w.f.ds70));
        }
        this.bTu.wL();
        if (this.bTu.getPendantView() != null) {
            this.bTu.getPendantView().setIsRound(true);
            this.bTu.getPendantView().setDrawBorder(false);
        }
        this.ceL = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_username);
        this.ceM = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_tips);
        this.ceN = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_title);
        this.ceO = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(w.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(w.f.ds3) + (width / 2);
        this.ceU = (TbImageView) this.mRootView.findViewById(w.h.frs_wefan_cover_image);
        a(this.ceU, width);
        this.ceP = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_1);
        this.ceQ = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_2);
        this.ceR = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_3);
        this.ceS = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_4);
        this.ceT = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_5);
        this.ceV = (TbImageView) this.ceP.getChildAt(0);
        this.ceW = (TbImageView) this.ceP.getChildAt(1);
        this.ceX = (TbImageView) this.ceP.getChildAt(2);
        this.ceY = (TbImageView) this.ceQ.getChildAt(0);
        this.ceZ = (TbImageView) this.ceQ.getChildAt(1);
        this.cfa = (TbImageView) this.ceQ.getChildAt(2);
        this.cfb = (TbImageView) this.ceR.getChildAt(0);
        this.cfc = (TbImageView) this.ceR.getChildAt(1);
        this.cfd = (TbImageView) this.ceR.getChildAt(2);
        this.cfe = (TbImageView) this.ceS.getChildAt(0);
        this.cff = (TbImageView) this.ceS.getChildAt(1);
        this.cfg = (TbImageView) this.ceT.getChildAt(0);
        this.cfh = (TbImageView) this.ceT.getChildAt(1);
        a(this.ceV, i);
        a(this.ceW, i);
        a(this.ceX, i);
        a(this.ceY, i);
        a(this.ceZ, i);
        a(this.cfa, i);
        a(this.cfb, i);
        a(this.cfc, i);
        a(this.cfd, i);
        a(this.cfe, dimensionPixelSize);
        a(this.cff, dimensionPixelSize);
        a(this.cfg, dimensionPixelSize);
        a(this.cfh, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }
}
