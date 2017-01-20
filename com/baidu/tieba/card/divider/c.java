package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private TextView aNb;
    private View bkF;
    private View bpn;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.bkF = getView().findViewById(r.h.card_divider_top_margin);
        this.aNb = (TextView) getView().findViewById(r.h.card_divider_tv);
        this.bpn = getView().findViewById(r.h.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.i((View) this.aNb, r.e.cp_cont_d);
            ap.k(this.bpn, r.e.cp_bg_line_b);
            ap.k(this.bkF, r.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_divider_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(b bVar) {
        if (bVar != null) {
            if (bVar.needTopMargin) {
                this.bkF.setVisibility(0);
            } else {
                this.bkF.setVisibility(8);
            }
            this.aNb.setText(bVar.title);
            onChangeSkinType(null, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
