package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View btH;
    private View bys;
    private TextView mTitle;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.btH = getView().findViewById(w.h.card_divider_top_margin);
        this.mTitle = (TextView) getView().findViewById(w.h.card_divider_tv);
        this.bys = getView().findViewById(w.h.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.i(this.mTitle, w.e.cp_cont_d);
            aq.k(this.bys, w.e.cp_bg_line_b);
            aq.k(this.btH, w.e.cp_bg_line_c);
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
                this.btH.setVisibility(0);
            } else {
                this.btH.setVisibility(8);
            }
            this.mTitle.setText(bVar.title);
            onChangeSkinType(null, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
