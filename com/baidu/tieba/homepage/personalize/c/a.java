package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<e> {
    private final TbPageContext<?> FY;
    private View LW;
    private View czt;
    private View czu;
    private TextView czv;
    private String czw;
    private e czx;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.FY = tbPageContext;
        this.LW = getView();
        this.czv = (TextView) this.LW.findViewById(r.h.read_progress_bar_time);
        this.czt = this.LW.findViewById(r.h.divider_line_under_homepage_read_progress);
        this.czu = this.LW.findViewById(r.h.divider_line_under_homepage_read_time);
        this.czw = this.FY.getResources().getString(r.l.read_here);
        this.LW.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.i((View) this.czv, r.e.cp_link_tip_a);
            ap.j(this.LW, r.g.addresslist_item_bg);
            ap.k(this.czt, r.e.cp_bg_line_c);
            ap.k(this.czu, r.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(e eVar) {
        if (eVar != null) {
            this.czx = eVar;
            this.czv.setText(String.valueOf(at.s(eVar.czB)) + this.czw);
            if (eVar.showBottomDivider) {
                this.czu.setVisibility(0);
            } else {
                this.czu.setVisibility(8);
            }
            onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
