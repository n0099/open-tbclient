package com.baidu.tieba.card.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View aSQ;
    private TextView aSZ;
    private View aWW;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.aSQ = getView().findViewById(u.g.card_divider_top_margin);
        this.aSZ = (TextView) getView().findViewById(u.g.card_divider_tv);
        this.aWW = getView().findViewById(u.g.bottom_line);
    }

    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.j((View) this.aSZ, u.d.cp_cont_d);
            av.l(this.aWW, u.d.cp_bg_line_b);
            av.l(this.aSQ, u.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_divider_view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.aVQ) {
                this.aSQ.setVisibility(0);
            } else {
                this.aSQ.setVisibility(8);
            }
            this.aSZ.setText(bVar.title);
            d(null, TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
