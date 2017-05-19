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
public class bz extends a<com.baidu.tieba.card.data.q> {
    private HeadImageView bwI;
    private TextView bwJ;
    private TextView bwK;
    private TbImageView bwL;
    private TextView bwM;
    private com.baidu.tieba.card.data.q bwN;
    private int bwO;
    private String bwP;
    private String bwQ;
    private View bwq;
    private String bws;
    private View mRootView;

    public bz(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bwO = tbPageContext.getResources().getDimensionPixelSize(w.f.ds70);
        V(getView());
    }

    public void q(String str, String str2, String str3) {
        this.bws = str;
        this.bwP = str2;
        this.bwQ = str3;
    }

    private void V(View view) {
        this.mRootView = view.findViewById(w.h.root_view);
        this.bwI = (HeadImageView) view.findViewById(w.h.promotion_head_img);
        this.bwJ = (TextView) view.findViewById(w.h.promotion_name);
        this.bwK = (TextView) view.findViewById(w.h.promotion_desc);
        this.bwL = (TbImageView) view.findViewById(w.h.promotion_img);
        this.bwM = (TextView) view.findViewById(w.h.promotion_icon);
        this.bwq = view.findViewById(w.h.top_line);
        this.bwI.setOnClickListener(this);
        this.bwJ.setOnClickListener(this);
        this.bwM.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bwI.setDefaultResource(17170445);
        this.bwI.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bwI.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bwI.setRadius(this.bwO);
        this.bwL.setDrawBorder(true);
        this.bwL.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bwI || view == this.bwJ || view == this.bwM) && !StringUtils.isNull(this.bwN.byl)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.bwP).aa("obj_id", String.valueOf(this.bwN.byj)));
            com.baidu.tbadk.core.util.bb.vB().c(getTbPageContext(), new String[]{this.bwN.byl});
        } else if ((view == this.mRootView || view == this.bwK || view == this.bwL) && !StringUtils.isNull(this.bwN.byo)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.bwQ).aa("obj_id", String.valueOf(this.bwN.byj)));
            com.baidu.tbadk.core.util.bb.vB().c(getTbPageContext(), new String[]{this.bwN.byo});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.mRootView, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.j(this.bwM, w.g.label_bg_gray);
            com.baidu.tbadk.core.util.aq.j(this.bwq, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.c(this.bwJ, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.bwM, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.bwK, w.e.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bwN = qVar;
        this.bwI.c(qVar.byk, 10, false);
        this.bwJ.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.byq)) {
            this.bwM.setVisibility(8);
        } else {
            this.bwM.setVisibility(0);
            this.bwM.setText(qVar.byq);
        }
        this.bwK.setText(qVar.bym);
        if (com.baidu.tbadk.core.r.oV().pb()) {
            this.bwL.setVisibility(0);
            this.bwL.c(qVar.byn, 10, false);
            return;
        }
        this.bwL.setVisibility(8);
    }
}
