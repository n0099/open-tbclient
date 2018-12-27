package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View dbP;
    private View dbQ;
    private TextView mTitle;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.dbP = getView().findViewById(e.g.card_divider_top_margin);
        this.mTitle = (TextView) getView().findViewById(e.g.card_divider_tv);
        this.dbQ = getView().findViewById(e.g.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.mTitle, e.d.cp_cont_d);
            al.j(this.dbQ, e.d.cp_bg_line_b);
            al.j(this.dbP, e.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_divider_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.needTopMargin) {
                this.dbP.setVisibility(0);
            } else {
                this.dbP.setVisibility(8);
            }
            this.mTitle.setText(bVar.title);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
