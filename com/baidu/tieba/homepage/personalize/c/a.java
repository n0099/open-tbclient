package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<e> {
    private final TbPageContext<?> Ea;
    private TextView csS;
    private String csT;
    private e csU;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Ea = tbPageContext;
        this.csS = (TextView) getView().findViewById(u.g.read_progress_bar_time);
        this.csT = this.Ea.getResources().getString(u.j.read_here);
        this.csS.setOnClickListener(new b(this));
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(this.csS, u.f.selector_read_progess_bar);
            av.j((View) this.csS, u.d.cp_link_tip_a);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_read_progress_bar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.csU = eVar;
            this.csS.setText(String.valueOf(ba.z(eVar.mTimeStamp)) + this.csT);
            d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
