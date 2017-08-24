package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View bLl;
    private View bLm;
    private TextView mTitle;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.bLl = getView().findViewById(d.h.card_divider_top_margin);
        this.mTitle = (TextView) getView().findViewById(d.h.card_divider_tv);
        this.bLm = getView().findViewById(d.h.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.i(this.mTitle, d.e.cp_cont_d);
            ai.k(this.bLm, d.e.cp_bg_line_b);
            ai.k(this.bLl, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_divider_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.needTopMargin) {
                this.bLl.setVisibility(0);
            } else {
                this.bLl.setVisibility(8);
            }
            this.mTitle.setText(bVar.title);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
