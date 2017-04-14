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
    private View Rr;
    private final TbPageContext<?> ajT;
    private View czp;
    private View czq;
    private TextView czr;
    private String czs;
    private e czt;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajT = tbPageContext;
        this.Rr = getView();
        this.czr = (TextView) this.Rr.findViewById(w.h.read_progress_bar_time);
        this.czp = this.Rr.findViewById(w.h.divider_line_under_homepage_read_progress);
        this.czq = this.Rr.findViewById(w.h.divider_line_under_homepage_read_time);
        this.czs = this.ajT.getResources().getString(w.l.read_here);
        this.Rr.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.i(this.czr, w.e.cp_link_tip_a);
            aq.j(this.Rr, w.g.addresslist_item_bg);
            aq.k(this.czp, w.e.cp_bg_line_c);
            aq.k(this.czq, w.e.cp_bg_line_c);
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
            this.czt = eVar;
            this.czr.setText(String.valueOf(au.r(eVar.mTimeStamp)) + this.czs);
            if (eVar.showBottomDivider) {
                this.czq.setVisibility(0);
            } else {
                this.czq.setVisibility(8);
            }
            onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
