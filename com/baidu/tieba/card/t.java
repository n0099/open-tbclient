package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends a<q> {
    private TbImageView bHA;
    private TextView bHB;
    private q bHC;
    private int bHD;
    private String bHE;
    private String bHF;
    private View bHa;
    private String bHc;
    private HeadImageView bHx;
    private TextView bHy;
    private TextView bHz;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHD = tbPageContext.getResources().getDimensionPixelSize(d.f.ds70);
        S(getView());
    }

    public void y(String str, String str2, String str3) {
        this.bHc = str;
        this.bHE = str2;
        this.bHF = str3;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(d.h.root_view);
        this.bHx = (HeadImageView) view.findViewById(d.h.promotion_head_img);
        this.bHy = (TextView) view.findViewById(d.h.promotion_name);
        this.bHz = (TextView) view.findViewById(d.h.promotion_desc);
        this.bHA = (TbImageView) view.findViewById(d.h.promotion_img);
        this.bHB = (TextView) view.findViewById(d.h.promotion_icon);
        this.bHa = view.findViewById(d.h.top_line);
        this.bHx.setOnClickListener(this);
        this.bHy.setOnClickListener(this);
        this.bHB.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bHx.setDefaultResource(17170445);
        this.bHx.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bHx.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bHx.setRadius(this.bHD);
        this.bHA.setDrawBorder(true);
        this.bHA.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bHx || view == this.bHy || view == this.bHB) && !StringUtils.isNull(this.bHC.bJk)) {
            TiebaStatic.log(new aj(this.bHE).aa("obj_id", String.valueOf(this.bHC.bJi)));
            at.vV().c(VY(), new String[]{this.bHC.bJk});
        } else if ((view == this.mRootView || view == this.bHz || view == this.bHA) && !StringUtils.isNull(this.bHC.bJn)) {
            TiebaStatic.log(new aj(this.bHF).aa("obj_id", String.valueOf(this.bHC.bJi)));
            at.vV().c(VY(), new String[]{this.bHC.bJn});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.g.addresslist_item_bg);
            ai.j(this.bHB, d.g.label_bg_gray);
            ai.j(this.bHa, d.e.cp_bg_line_b);
            ai.c(this.bHy, d.e.cp_cont_b, 1);
            ai.c(this.bHB, d.e.cp_cont_d, 1);
            ai.c(this.bHz, d.e.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bHC = qVar;
        this.bHx.c(qVar.bJj, 10, false);
        this.bHy.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bJp)) {
            this.bHB.setVisibility(8);
        } else {
            this.bHB.setVisibility(0);
            this.bHB.setText(qVar.bJp);
        }
        this.bHz.setText(qVar.bJl);
        if (com.baidu.tbadk.core.h.oN().oT()) {
            this.bHA.setVisibility(0);
            this.bHA.c(qVar.bJm, 10, false);
            return;
        }
        this.bHA.setVisibility(8);
    }
}
