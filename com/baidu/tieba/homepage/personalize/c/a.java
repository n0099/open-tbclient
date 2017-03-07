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
    private View QZ;
    private final TbPageContext<?> ajF;
    private View cAP;
    private View cAQ;
    private TextView cAR;
    private String cAS;
    private e cAT;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajF = tbPageContext;
        this.QZ = getView();
        this.cAR = (TextView) this.QZ.findViewById(w.h.read_progress_bar_time);
        this.cAP = this.QZ.findViewById(w.h.divider_line_under_homepage_read_progress);
        this.cAQ = this.QZ.findViewById(w.h.divider_line_under_homepage_read_time);
        this.cAS = this.ajF.getResources().getString(w.l.read_here);
        this.QZ.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.i((View) this.cAR, w.e.cp_link_tip_a);
            aq.j(this.QZ, w.g.addresslist_item_bg);
            aq.k(this.cAP, w.e.cp_bg_line_c);
            aq.k(this.cAQ, w.e.cp_bg_line_c);
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
            this.cAT = eVar;
            this.cAR.setText(String.valueOf(au.r(eVar.cAX)) + this.cAS);
            if (eVar.showBottomDivider) {
                this.cAQ.setVisibility(0);
            } else {
                this.cAQ.setVisibility(8);
            }
            onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
