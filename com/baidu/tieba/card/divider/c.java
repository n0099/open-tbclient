package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View cDa;
    private View cDb;
    private TextView mTitle;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.cDa = getView().findViewById(f.g.card_divider_top_margin);
        this.mTitle = (TextView) getView().findViewById(f.g.card_divider_tv);
        this.cDb = getView().findViewById(f.g.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.h(this.mTitle, f.d.cp_cont_d);
            am.j(this.cDb, f.d.cp_bg_line_b);
            am.j(this.cDa, f.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_divider_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.needTopMargin) {
                this.cDa.setVisibility(0);
            } else {
                this.cDa.setVisibility(8);
            }
            this.mTitle.setText(bVar.title);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
