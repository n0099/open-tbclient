package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ce extends a<com.baidu.tieba.card.data.q> {
    private String bCA;
    private String bCB;
    private View bCa;
    private String bCc;
    private HeadImageView bCt;
    private TextView bCu;
    private TextView bCv;
    private TbImageView bCw;
    private TextView bCx;
    private com.baidu.tieba.card.data.q bCy;
    private int bCz;
    private View mRootView;

    public ce(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bCz = tbPageContext.getResources().getDimensionPixelSize(w.f.ds70);
        R(getView());
    }

    public void r(String str, String str2, String str3) {
        this.bCc = str;
        this.bCA = str2;
        this.bCB = str3;
    }

    private void R(View view) {
        this.mRootView = view.findViewById(w.h.root_view);
        this.bCt = (HeadImageView) view.findViewById(w.h.promotion_head_img);
        this.bCu = (TextView) view.findViewById(w.h.promotion_name);
        this.bCv = (TextView) view.findViewById(w.h.promotion_desc);
        this.bCw = (TbImageView) view.findViewById(w.h.promotion_img);
        this.bCx = (TextView) view.findViewById(w.h.promotion_icon);
        this.bCa = view.findViewById(w.h.top_line);
        this.bCt.setOnClickListener(this);
        this.bCu.setOnClickListener(this);
        this.bCx.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bCt.setDefaultResource(17170445);
        this.bCt.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bCt.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bCt.setRadius(this.bCz);
        this.bCw.setDrawBorder(true);
        this.bCw.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bCt || view == this.bCu || view == this.bCx) && !StringUtils.isNull(this.bCy.bEg)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.bCA).Z("obj_id", String.valueOf(this.bCy.bEe)));
            com.baidu.tbadk.core.util.bb.vy().c(Uc(), new String[]{this.bCy.bEg});
        } else if ((view == this.mRootView || view == this.bCv || view == this.bCw) && !StringUtils.isNull(this.bCy.bEj)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.bCB).Z("obj_id", String.valueOf(this.bCy.bEe)));
            com.baidu.tbadk.core.util.bb.vy().c(Uc(), new String[]{this.bCy.bEj});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.mRootView, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.j(this.bCx, w.g.label_bg_gray);
            com.baidu.tbadk.core.util.aq.j(this.bCa, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.c(this.bCu, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.bCx, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.bCv, w.e.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bCy = qVar;
        this.bCt.c(qVar.bEf, 10, false);
        this.bCu.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bEl)) {
            this.bCx.setVisibility(8);
        } else {
            this.bCx.setVisibility(0);
            this.bCx.setText(qVar.bEl);
        }
        this.bCv.setText(qVar.bEh);
        if (com.baidu.tbadk.core.r.oN().oT()) {
            this.bCw.setVisibility(0);
            this.bCw.c(qVar.bEi, 10, false);
            return;
        }
        this.bCw.setVisibility(8);
    }
}
