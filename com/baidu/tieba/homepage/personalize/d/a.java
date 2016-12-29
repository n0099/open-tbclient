package com.baidu.tieba.homepage.personalize.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<e> {
    private final TbPageContext<?> GO;
    private View MJ;
    private View cso;
    private View csp;
    private TextView csq;
    private String csr;
    private e css;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GO = tbPageContext;
        this.MJ = getView();
        this.csq = (TextView) this.MJ.findViewById(r.g.read_progress_bar_time);
        this.cso = this.MJ.findViewById(r.g.divider_line_under_homepage_read_progress);
        this.csp = this.MJ.findViewById(r.g.divider_line_under_homepage_read_time);
        this.csr = this.GO.getResources().getString(r.j.read_here);
        this.MJ.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ar.j((View) this.csq, r.d.cp_link_tip_a);
            ar.k(this.MJ, r.f.addresslist_item_bg);
            ar.l(this.cso, r.d.cp_bg_line_c);
            ar.l(this.csp, r.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(e eVar) {
        if (eVar != null) {
            this.css = eVar;
            this.csq.setText(String.valueOf(av.t(eVar.csw)) + this.csr);
            if (eVar.showBottomDivider) {
                this.csp.setVisibility(0);
            } else {
                this.csp.setVisibility(8);
            }
            onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
