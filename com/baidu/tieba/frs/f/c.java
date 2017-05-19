package com.baidu.tieba.frs.f;

import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends y.a {
    public HeadPendantClickableView buV;
    public View cdW;
    public HeadImageView cdX;
    public TextView cdY;
    public TextView cdZ;
    public TextView cea;
    public TextView ceb;
    public LinearLayout cec;
    public LinearLayout ced;
    public LinearLayout cee;
    public LinearLayout cef;
    public LinearLayout ceg;
    public TbImageView ceh;
    public TbImageView cei;
    public TbImageView cej;
    public TbImageView cek;
    public TbImageView cel;
    public TbImageView cem;
    public TbImageView cen;
    public TbImageView ceo;
    public TbImageView cep;
    public TbImageView ceq;
    public TbImageView cer;
    public TbImageView ces;
    public TbImageView cet;
    public TbImageView ceu;
    private BdUniqueId mPageId;
    public View mRootView;
    public int mSkinType;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = bdUniqueId;
        this.mRootView = getView();
        this.cdW = this.mRootView.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.cdX = (HeadImageView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.cdX.setPageId(bdUniqueId);
        this.buV = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.buV.setPageId(bdUniqueId);
        this.cdX.setDefaultResource(17170445);
        this.cdX.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.cdX.setDefaultBgResource(w.e.cp_bg_line_e);
        this.cdX.setRadius(k.g(tbPageContext.getPageActivity(), w.f.ds70));
        if (this.buV.getHeadView() != null) {
            this.buV.getHeadView().setIsRound(true);
            this.buV.getHeadView().setDrawBorder(false);
            this.buV.getHeadView().setDefaultResource(17170445);
            this.buV.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.buV.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.buV.getHeadView().setRadius(k.g(tbPageContext.getPageActivity(), w.f.ds70));
        }
        this.buV.vY();
        if (this.buV.getPendantView() != null) {
            this.buV.getPendantView().setIsRound(true);
            this.buV.getPendantView().setDrawBorder(false);
        }
        this.cdY = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_username);
        this.cdZ = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_tips);
        this.cea = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_title);
        this.ceb = (TextView) this.mRootView.findViewById(w.h.frs_wefan_tv_date);
        int width = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(w.f.ds168);
        int i = width / 3;
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(w.f.ds3) + (width / 2);
        this.ceh = (TbImageView) this.mRootView.findViewById(w.h.frs_wefan_cover_image);
        a(this.ceh, width);
        this.cec = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_1);
        this.ced = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_2);
        this.cee = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_3);
        this.cef = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_4);
        this.ceg = (LinearLayout) this.mRootView.findViewById(w.h.frs_wefan_image_row_5);
        this.cei = (TbImageView) this.cec.getChildAt(0);
        this.cej = (TbImageView) this.cec.getChildAt(1);
        this.cek = (TbImageView) this.cec.getChildAt(2);
        this.cel = (TbImageView) this.ced.getChildAt(0);
        this.cem = (TbImageView) this.ced.getChildAt(1);
        this.cen = (TbImageView) this.ced.getChildAt(2);
        this.ceo = (TbImageView) this.cee.getChildAt(0);
        this.cep = (TbImageView) this.cee.getChildAt(1);
        this.ceq = (TbImageView) this.cee.getChildAt(2);
        this.cer = (TbImageView) this.cef.getChildAt(0);
        this.ces = (TbImageView) this.cef.getChildAt(1);
        this.cet = (TbImageView) this.ceg.getChildAt(0);
        this.ceu = (TbImageView) this.ceg.getChildAt(1);
        a(this.cei, i);
        a(this.cej, i);
        a(this.cek, i);
        a(this.cel, i);
        a(this.cem, i);
        a(this.cen, i);
        a(this.ceo, i);
        a(this.cep, i);
        a(this.ceq, i);
        a(this.cer, dimensionPixelSize);
        a(this.ces, dimensionPixelSize);
        a(this.cet, dimensionPixelSize);
        a(this.ceu, dimensionPixelSize);
    }

    private void a(TbImageView tbImageView, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        tbImageView.setPageId(this.mPageId);
        tbImageView.setLayoutParams(layoutParams);
    }
}
