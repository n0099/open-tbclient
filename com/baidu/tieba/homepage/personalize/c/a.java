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
    private View Qx;
    private final TbPageContext<?> ajh;
    private View cCY;
    private View cCZ;
    private TextView cDa;
    private String cDb;
    private e cDc;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajh = tbPageContext;
        this.Qx = getView();
        this.cDa = (TextView) this.Qx.findViewById(w.h.read_progress_bar_time);
        this.cCY = this.Qx.findViewById(w.h.divider_line_under_homepage_read_progress);
        this.cCZ = this.Qx.findViewById(w.h.divider_line_under_homepage_read_time);
        this.cDb = this.ajh.getResources().getString(w.l.read_here);
        this.Qx.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.i(this.cDa, w.e.cp_link_tip_a);
            aq.j(this.Qx, w.g.addresslist_item_bg);
            aq.k(this.cCY, w.e.cp_bg_line_c);
            aq.k(this.cCZ, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(e eVar) {
        if (eVar != null) {
            this.cDc = eVar;
            this.cDa.setText(String.valueOf(au.r(eVar.mTimeStamp)) + this.cDb);
            if (eVar.showBottomDivider) {
                this.cCZ.setVisibility(0);
            } else {
                this.cCZ.setVisibility(8);
            }
            d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
