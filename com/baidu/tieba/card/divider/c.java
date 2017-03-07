package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private TextView aSO;
    private View brx;
    private View bwi;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.brx = getView().findViewById(w.h.card_divider_top_margin);
        this.aSO = (TextView) getView().findViewById(w.h.card_divider_tv);
        this.bwi = getView().findViewById(w.h.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.i((View) this.aSO, w.e.cp_cont_d);
            aq.k(this.bwi, w.e.cp_bg_line_b);
            aq.k(this.brx, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_divider_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(b bVar) {
        if (bVar != null) {
            if (bVar.needTopMargin) {
                this.brx.setVisibility(0);
            } else {
                this.brx.setVisibility(8);
            }
            this.aSO.setText(bVar.title);
            onChangeSkinType(null, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
