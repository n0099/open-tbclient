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
    private View Rt;
    private final TbPageContext<?> ajU;
    private View cBG;
    private View cBH;
    private TextView cBI;
    private String cBJ;
    private e cBK;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajU = tbPageContext;
        this.Rt = getView();
        this.cBI = (TextView) this.Rt.findViewById(w.h.read_progress_bar_time);
        this.cBG = this.Rt.findViewById(w.h.divider_line_under_homepage_read_progress);
        this.cBH = this.Rt.findViewById(w.h.divider_line_under_homepage_read_time);
        this.cBJ = this.ajU.getResources().getString(w.l.read_here);
        this.Rt.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.i(this.cBI, w.e.cp_link_tip_a);
            aq.j(this.Rt, w.g.addresslist_item_bg);
            aq.k(this.cBG, w.e.cp_bg_line_c);
            aq.k(this.cBH, w.e.cp_bg_line_c);
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
            this.cBK = eVar;
            this.cBI.setText(String.valueOf(au.r(eVar.mTimeStamp)) + this.cBJ);
            if (eVar.showBottomDivider) {
                this.cBH.setVisibility(0);
            } else {
                this.cBH.setVisibility(8);
            }
            onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
