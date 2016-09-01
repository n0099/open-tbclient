package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cc extends a<com.baidu.tieba.card.data.r> {
    private View baI;
    private String baK;
    private HeadImageView bbc;
    private TextView bbd;
    private TextView bbe;
    private TbImageView bbf;
    private TextView bbg;
    private com.baidu.tieba.card.data.r bbh;
    private int bbi;
    private String bbj;
    private String bbk;
    private View mRootView;

    public cc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbi = tbPageContext.getResources().getDimensionPixelSize(t.e.ds70);
        V(getView());
    }

    public void t(String str, String str2, String str3) {
        this.baK = str;
        this.bbj = str2;
        this.bbk = str3;
    }

    private void V(View view) {
        this.mRootView = view.findViewById(t.g.root_view);
        this.bbc = (HeadImageView) view.findViewById(t.g.promotion_head_img);
        this.bbd = (TextView) view.findViewById(t.g.promotion_name);
        this.bbe = (TextView) view.findViewById(t.g.promotion_desc);
        this.bbf = (TbImageView) view.findViewById(t.g.promotion_img);
        this.bbg = (TextView) view.findViewById(t.g.promotion_icon);
        this.baI = view.findViewById(t.g.top_line);
        this.bbc.setOnClickListener(this);
        this.bbd.setOnClickListener(this);
        this.bbg.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bbc.setDefaultResource(17170445);
        this.bbc.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.bbc.setDefaultBgResource(t.d.cp_bg_line_e);
        this.bbc.setRadius(this.bbi);
        this.bbf.setDrawBorder(true);
        this.bbf.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bbc || view == this.bbd || view == this.bbg) && !StringUtils.isNull(this.bbh.bcF)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(this.bbj).ab("obj_id", String.valueOf(this.bbh.bcD)));
            com.baidu.tbadk.core.util.bi.vx().c(getTbPageContext(), new String[]{this.bbh.bcF});
        } else if ((view == this.mRootView || view == this.bbe || view == this.bbf) && !StringUtils.isNull(this.bbh.bcI)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(this.bbk).ab("obj_id", String.valueOf(this.bbh.bcD)));
            com.baidu.tbadk.core.util.bi.vx().c(getTbPageContext(), new String[]{this.bbh.bcI});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(this.bbg, t.f.label_bg_gray);
            com.baidu.tbadk.core.util.av.k(this.baI, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.c(this.bbd, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.bbg, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.bbe, t.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.r rVar) {
        if (rVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bbh = rVar;
        this.bbc.c(rVar.bcE, 10, false);
        this.bbd.setText(UtilHelper.getFixedText(rVar.userName, 7, true));
        if (StringUtils.isNull(rVar.bcK)) {
            this.bbg.setVisibility(8);
        } else {
            this.bbg.setVisibility(0);
            this.bbg.setText(rVar.bcK);
        }
        this.bbe.setText(rVar.bcG);
        if (com.baidu.tbadk.core.l.oG().oM()) {
            this.bbf.setVisibility(0);
            this.bbf.c(rVar.bcH, 10, false);
            return;
        }
        this.bbf.setVisibility(8);
    }
}
