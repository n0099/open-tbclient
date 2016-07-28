package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bv extends a<com.baidu.tieba.card.a.r> {
    private View aSw;
    private TextView aVA;
    private TextView aVB;
    private TbImageView aVC;
    private TextView aVD;
    private com.baidu.tieba.card.a.r aVE;
    private int aVF;
    private String aVG;
    private String aVH;
    private String aVw;
    private HeadImageView aVz;
    private View mRootView;

    public bv(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aVF = tbPageContext.getResources().getDimensionPixelSize(u.e.ds70);
        S(getView());
    }

    public void u(String str, String str2, String str3) {
        this.aVw = str;
        this.aVG = str2;
        this.aVH = str3;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(u.g.root_view);
        this.aVz = (HeadImageView) view.findViewById(u.g.promotion_head_img);
        this.aVA = (TextView) view.findViewById(u.g.promotion_name);
        this.aVB = (TextView) view.findViewById(u.g.promotion_desc);
        this.aVC = (TbImageView) view.findViewById(u.g.promotion_img);
        this.aVD = (TextView) view.findViewById(u.g.promotion_icon);
        this.aSw = view.findViewById(u.g.top_line);
        this.aVz.setOnClickListener(this);
        this.aVA.setOnClickListener(this);
        this.aVD.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.aVz.setDefaultResource(17170445);
        this.aVz.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aVz.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aVz.setRadius(this.aVF);
        this.aVC.setDrawBorder(true);
        this.aVC.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.aVz || view == this.aVA || view == this.aVD) && !StringUtils.isNull(this.aVE.aWN)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(this.aVG).ab("obj_id", String.valueOf(this.aVE.aWL)));
            com.baidu.tbadk.core.util.bi.us().c(KM(), new String[]{this.aVE.aWN});
        } else if ((view == this.mRootView || view == this.aVB || view == this.aVC) && !StringUtils.isNull(this.aVE.aWQ)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(this.aVH).ab("obj_id", String.valueOf(this.aVE.aWL)));
            com.baidu.tbadk.core.util.bi.us().c(KM(), new String[]{this.aVE.aWQ});
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(this.aVD, u.f.label_bg_gray);
            com.baidu.tbadk.core.util.av.k(this.aSw, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.c(this.aVA, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aVD, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.aVB, u.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_promotion_item;
    }

    public void a(com.baidu.tieba.card.a.r rVar) {
        if (rVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aVE = rVar;
        this.aVz.c(rVar.aWM, 10, false);
        this.aVA.setText(UtilHelper.getFixedText(rVar.userName, 7, true));
        if (StringUtils.isNull(rVar.aWS)) {
            this.aVD.setVisibility(8);
        } else {
            this.aVD.setVisibility(0);
            this.aVD.setText(rVar.aWS);
        }
        this.aVB.setText(rVar.aWO);
        if (com.baidu.tbadk.core.l.nL().nR()) {
            this.aVC.setVisibility(0);
            this.aVC.c(rVar.aWP, 10, false);
            return;
        }
        this.aVC.setVisibility(8);
    }
}
