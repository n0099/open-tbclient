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
public class cb extends a<com.baidu.tieba.card.data.s> {
    private HeadImageView bwJ;
    private TextView bwK;
    private TextView bwL;
    private TbImageView bwM;
    private TextView bwN;
    private com.baidu.tieba.card.data.s bwO;
    private int bwP;
    private String bwQ;
    private String bwR;
    private View bwq;
    private String bws;
    private View mRootView;

    public cb(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bwP = tbPageContext.getResources().getDimensionPixelSize(w.f.ds70);
        W(getView());
    }

    public void q(String str, String str2, String str3) {
        this.bws = str;
        this.bwQ = str2;
        this.bwR = str3;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(w.h.root_view);
        this.bwJ = (HeadImageView) view.findViewById(w.h.promotion_head_img);
        this.bwK = (TextView) view.findViewById(w.h.promotion_name);
        this.bwL = (TextView) view.findViewById(w.h.promotion_desc);
        this.bwM = (TbImageView) view.findViewById(w.h.promotion_img);
        this.bwN = (TextView) view.findViewById(w.h.promotion_icon);
        this.bwq = view.findViewById(w.h.top_line);
        this.bwJ.setOnClickListener(this);
        this.bwK.setOnClickListener(this);
        this.bwN.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bwJ.setDefaultResource(17170445);
        this.bwJ.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bwJ.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bwJ.setRadius(this.bwP);
        this.bwM.setDrawBorder(true);
        this.bwM.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bwJ || view == this.bwK || view == this.bwN) && !StringUtils.isNull(this.bwO.byl)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.bwQ).aa("obj_id", String.valueOf(this.bwO.byj)));
            com.baidu.tbadk.core.util.bb.wn().c(getTbPageContext(), new String[]{this.bwO.byl});
        } else if ((view == this.mRootView || view == this.bwL || view == this.bwM) && !StringUtils.isNull(this.bwO.byo)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.bwR).aa("obj_id", String.valueOf(this.bwO.byj)));
            com.baidu.tbadk.core.util.bb.wn().c(getTbPageContext(), new String[]{this.bwO.byo});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.mRootView, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.j(this.bwN, w.g.label_bg_gray);
            com.baidu.tbadk.core.util.aq.j(this.bwq, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.c(this.bwK, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.bwN, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.bwL, w.e.cp_cont_b, 1);
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
    public void onBindDataToView(com.baidu.tieba.card.data.s sVar) {
        if (sVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bwO = sVar;
        this.bwJ.c(sVar.byk, 10, false);
        this.bwK.setText(UtilHelper.getFixedText(sVar.userName, 7, true));
        if (StringUtils.isNull(sVar.byq)) {
            this.bwN.setVisibility(8);
        } else {
            this.bwN.setVisibility(0);
            this.bwN.setText(sVar.byq);
        }
        this.bwL.setText(sVar.bym);
        if (com.baidu.tbadk.core.q.po().pu()) {
            this.bwM.setVisibility(0);
            this.bwM.c(sVar.byn, 10, false);
            return;
        }
        this.bwM.setVisibility(8);
    }
}
