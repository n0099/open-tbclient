package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<e> {
    private View QK;
    private final TbPageContext<?> ajr;
    private View cwG;
    private View cwH;
    private TextView cwI;
    private String cwJ;
    private e cwK;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajr = tbPageContext;
        this.QK = getView();
        this.cwI = (TextView) this.QK.findViewById(w.h.read_progress_bar_time);
        this.cwG = this.QK.findViewById(w.h.divider_line_under_homepage_read_progress);
        this.cwH = this.QK.findViewById(w.h.divider_line_under_homepage_read_time);
        this.cwJ = this.ajr.getResources().getString(w.l.read_here);
        this.QK.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.i(this.cwI, w.e.cp_link_tip_a);
            aq.j(this.QK, w.g.addresslist_item_bg);
            aq.k(this.cwG, w.e.cp_bg_line_c);
            aq.k(this.cwH, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(e eVar) {
        if (eVar != null) {
            this.cwK = eVar;
            this.cwI.setText(String.valueOf(au.r(eVar.mTimeStamp)) + this.cwJ);
            if (eVar.showBottomDivider) {
                this.cwH.setVisibility(0);
            } else {
                this.cwH.setVisibility(8);
            }
            onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
