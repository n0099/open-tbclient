package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View bVU;
    private View bVV;
    private TextView mTitle;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.bVU = getView().findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) getView().findViewById(d.g.card_divider_tv);
        this.bVV = getView().findViewById(d.g.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.mTitle, d.C0080d.cp_cont_d);
            aj.k(this.bVV, d.C0080d.cp_bg_line_b);
            aj.k(this.bVU, d.C0080d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_divider_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.needTopMargin) {
                this.bVU.setVisibility(0);
            } else {
                this.bVU.setVisibility(8);
            }
            this.mTitle.setText(bVar.title);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
