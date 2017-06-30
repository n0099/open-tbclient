package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<e> {
    private View Qr;
    private final TbPageContext<?> ajP;
    private View cKV;
    private View cKW;
    private TextView cKX;
    private String cKY;
    private e cKZ;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajP = tbPageContext;
        this.Qr = getView();
        this.cKX = (TextView) this.Qr.findViewById(w.h.read_progress_bar_time);
        this.cKV = this.Qr.findViewById(w.h.divider_line_under_homepage_read_progress);
        this.cKW = this.Qr.findViewById(w.h.divider_line_under_homepage_read_time);
        this.cKY = this.ajP.getResources().getString(w.l.read_here);
        this.Qr.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.i(this.cKX, w.e.cp_link_tip_a);
            as.j(this.Qr, w.g.addresslist_item_bg);
            as.k(this.cKV, w.e.cp_bg_line_c);
            as.k(this.cKW, w.e.cp_bg_line_c);
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
            this.cKZ = eVar;
            this.cKX.setText(String.valueOf(aw.r(eVar.mTimeStamp)) + this.cKY);
            if (eVar.showBottomDivider) {
                this.cKW.setVisibility(0);
            } else {
                this.cKW.setVisibility(8);
            }
            d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
