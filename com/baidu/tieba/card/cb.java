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
    private HeadImageView buA;
    private TextView buB;
    private TextView buC;
    private TbImageView buD;
    private TextView buE;
    private com.baidu.tieba.card.data.s buF;
    private int buG;
    private String buH;
    private String buI;
    private View bug;
    private String bui;
    private View mRootView;

    public cb(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.buG = tbPageContext.getResources().getDimensionPixelSize(w.f.ds70);
        W(getView());
    }

    public void u(String str, String str2, String str3) {
        this.bui = str;
        this.buH = str2;
        this.buI = str3;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(w.h.root_view);
        this.buA = (HeadImageView) view.findViewById(w.h.promotion_head_img);
        this.buB = (TextView) view.findViewById(w.h.promotion_name);
        this.buC = (TextView) view.findViewById(w.h.promotion_desc);
        this.buD = (TbImageView) view.findViewById(w.h.promotion_img);
        this.buE = (TextView) view.findViewById(w.h.promotion_icon);
        this.bug = view.findViewById(w.h.top_line);
        this.buA.setOnClickListener(this);
        this.buB.setOnClickListener(this);
        this.buE.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.buA.setDefaultResource(17170445);
        this.buA.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.buA.setDefaultBgResource(w.e.cp_bg_line_e);
        this.buA.setRadius(this.buG);
        this.buD.setDrawBorder(true);
        this.buD.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.buA || view == this.buB || view == this.buE) && !StringUtils.isNull(this.buF.bwb)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.buH).Z("obj_id", String.valueOf(this.buF.bvZ)));
            com.baidu.tbadk.core.util.bb.vQ().c(getTbPageContext(), new String[]{this.buF.bwb});
        } else if ((view == this.mRootView || view == this.buC || view == this.buD) && !StringUtils.isNull(this.buF.bwe)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.buI).Z("obj_id", String.valueOf(this.buF.bvZ)));
            com.baidu.tbadk.core.util.bb.vQ().c(getTbPageContext(), new String[]{this.buF.bwe});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.mRootView, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.j(this.buE, w.g.label_bg_gray);
            com.baidu.tbadk.core.util.aq.j(this.bug, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.c(this.buB, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.buE, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.buC, w.e.cp_cont_b, 1);
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
        this.buF = sVar;
        this.buA.c(sVar.bwa, 10, false);
        this.buB.setText(UtilHelper.getFixedText(sVar.userName, 7, true));
        if (StringUtils.isNull(sVar.bwg)) {
            this.buE.setVisibility(8);
        } else {
            this.buE.setVisibility(0);
            this.buE.setText(sVar.bwg);
        }
        this.buC.setText(sVar.bwc);
        if (com.baidu.tbadk.core.l.oQ().oW()) {
            this.buD.setVisibility(0);
            this.buD.c(sVar.bwd, 10, false);
            return;
        }
        this.buD.setVisibility(8);
    }
}
