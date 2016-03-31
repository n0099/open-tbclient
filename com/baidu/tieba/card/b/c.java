package com.baidu.tieba.card.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View aSa;
    private TextView aSh;
    private View aWJ;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.aSa = getView().findViewById(t.g.card_divider_top_margin);
        this.aSh = (TextView) getView().findViewById(t.g.card_divider_tv);
        this.aWJ = getView().findViewById(t.g.bottom_line);
    }

    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            at.j((View) this.aSh, t.d.cp_cont_d);
            at.l(this.aWJ, t.d.cp_bg_line_b);
            at.l(this.aSa, t.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_divider_view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.aVs) {
                this.aSa.setVisibility(0);
            } else {
                this.aSa.setVisibility(8);
            }
            this.aSh.setText(bVar.title);
            d(null, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
