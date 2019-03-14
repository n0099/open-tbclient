package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View emA;
    private View emz;
    private TextView mTitle;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.emz = getView().findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) getView().findViewById(d.g.card_divider_tv);
        this.emA = getView().findViewById(d.g.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.mTitle, d.C0277d.cp_cont_d);
            al.l(this.emA, d.C0277d.cp_bg_line_b);
            al.l(this.emz, d.C0277d.cp_bg_line_c);
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
                this.emz.setVisibility(0);
            } else {
                this.emz.setVisibility(8);
            }
            this.mTitle.setText(bVar.title);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
