package com.baidu.tieba.card.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private TextView aOH;
    private View bbL;
    private View bgh;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.bbL = getView().findViewById(r.g.card_divider_top_margin);
        this.aOH = (TextView) getView().findViewById(r.g.card_divider_tv);
        this.bgh = getView().findViewById(r.g.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            at.j((View) this.aOH, r.d.cp_cont_d);
            at.l(this.bgh, r.d.cp_bg_line_b);
            at.l(this.bbL, r.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_divider_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(b bVar) {
        if (bVar != null) {
            if (bVar.needTopMargin) {
                this.bbL.setVisibility(0);
            } else {
                this.bbL.setVisibility(8);
            }
            this.aOH.setText(bVar.title);
            onChangeSkinType(null, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
