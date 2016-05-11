package com.baidu.tieba.card.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private TextView aOG;
    private View aOz;
    private View aSD;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.aOz = getView().findViewById(t.g.card_divider_top_margin);
        this.aOG = (TextView) getView().findViewById(t.g.card_divider_tv);
        this.aSD = getView().findViewById(t.g.bottom_line);
    }

    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            at.j((View) this.aOG, t.d.cp_cont_d);
            at.l(this.aSD, t.d.cp_bg_line_b);
            at.l(this.aOz, t.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_divider_view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.aRx) {
                this.aOz.setVisibility(0);
            } else {
                this.aOz.setVisibility(8);
            }
            this.aOG.setText(bVar.title);
            d(null, TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
