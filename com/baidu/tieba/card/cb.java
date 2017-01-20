package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cb extends a<com.baidu.tieba.card.data.s> {
    private HeadImageView bnE;
    private TextView bnF;
    private TextView bnG;
    private TbImageView bnH;
    private TextView bnI;
    private com.baidu.tieba.card.data.s bnJ;
    private int bnK;
    private String bnL;
    private String bnM;
    private View bnl;
    private String bnn;
    private View mRootView;

    public cb(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bnK = tbPageContext.getResources().getDimensionPixelSize(r.f.ds70);
        Y(getView());
    }

    public void x(String str, String str2, String str3) {
        this.bnn = str;
        this.bnL = str2;
        this.bnM = str3;
    }

    private void Y(View view) {
        this.mRootView = view.findViewById(r.h.root_view);
        this.bnE = (HeadImageView) view.findViewById(r.h.promotion_head_img);
        this.bnF = (TextView) view.findViewById(r.h.promotion_name);
        this.bnG = (TextView) view.findViewById(r.h.promotion_desc);
        this.bnH = (TbImageView) view.findViewById(r.h.promotion_img);
        this.bnI = (TextView) view.findViewById(r.h.promotion_icon);
        this.bnl = view.findViewById(r.h.top_line);
        this.bnE.setOnClickListener(this);
        this.bnF.setOnClickListener(this);
        this.bnI.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bnE.setDefaultResource(17170445);
        this.bnE.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.bnE.setDefaultBgResource(r.e.cp_bg_line_e);
        this.bnE.setRadius(this.bnK);
        this.bnH.setDrawBorder(true);
        this.bnH.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bnE || view == this.bnF || view == this.bnI) && !StringUtils.isNull(this.bnJ.bpg)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(this.bnL).ab("obj_id", String.valueOf(this.bnJ.bpe)));
            com.baidu.tbadk.core.util.ba.vt().c(getTbPageContext(), new String[]{this.bnJ.bpg});
        } else if ((view == this.mRootView || view == this.bnG || view == this.bnH) && !StringUtils.isNull(this.bnJ.bpj)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(this.bnM).ab("obj_id", String.valueOf(this.bnJ.bpe)));
            com.baidu.tbadk.core.util.ba.vt().c(getTbPageContext(), new String[]{this.bnJ.bpj});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.j(this.mRootView, r.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.ap.j((View) this.bnI, r.g.label_bg_gray);
            com.baidu.tbadk.core.util.ap.j(this.bnl, r.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.ap.c(this.bnF, r.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ap.c(this.bnI, r.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.c(this.bnG, r.e.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_promotion_item;
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
        this.bnJ = sVar;
        this.bnE.c(sVar.bpf, 10, false);
        this.bnF.setText(UtilHelper.getFixedText(sVar.userName, 7, true));
        if (StringUtils.isNull(sVar.bpl)) {
            this.bnI.setVisibility(8);
        } else {
            this.bnI.setVisibility(0);
            this.bnI.setText(sVar.bpl);
        }
        this.bnG.setText(sVar.bph);
        if (com.baidu.tbadk.core.l.oC().oI()) {
            this.bnH.setVisibility(0);
            this.bnH.c(sVar.bpi, 10, false);
            return;
        }
        this.bnH.setVisibility(8);
    }
}
