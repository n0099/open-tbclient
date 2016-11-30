package com.baidu.tieba.homepage.personalize.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<e> {
    private final TbPageContext<?> GO;
    private View MM;
    private View cNj;
    private View cNk;
    private TextView cNl;
    private String cNm;
    private e cNn;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GO = tbPageContext;
        this.MM = getView();
        this.cNl = (TextView) this.MM.findViewById(r.g.read_progress_bar_time);
        this.cNj = this.MM.findViewById(r.g.divider_line_under_homepage_read_progress);
        this.cNk = this.MM.findViewById(r.g.divider_line_under_homepage_read_time);
        this.cNm = this.GO.getResources().getString(r.j.read_here);
        this.MM.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            at.j((View) this.cNl, r.d.cp_link_tip_a);
            at.k(this.MM, r.f.addresslist_item_bg);
            at.l(this.cNj, r.d.cp_bg_line_c);
            at.l(this.cNk, r.d.cp_bg_line_c);
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
            this.cNn = eVar;
            this.cNl.setText(String.valueOf(ax.t(eVar.mTimeStamp)) + this.cNm);
            if (eVar.showBottomDivider) {
                this.cNk.setVisibility(0);
            } else {
                this.cNk.setVisibility(8);
            }
            onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
