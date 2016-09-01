package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<e> {
    private final TbPageContext<?> GM;
    private TextView cHh;
    private String cHi;
    private e cHj;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GM = tbPageContext;
        this.cHh = (TextView) getView().findViewById(t.g.read_progress_bar_time);
        this.cHi = this.GM.getResources().getString(t.j.read_here);
        this.cHh.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(this.cHh, t.f.selector_read_progess_bar);
            av.j((View) this.cHh, t.d.cp_link_tip_a);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(e eVar) {
        if (eVar != null) {
            this.cHj = eVar;
            this.cHh.setText(String.valueOf(ba.u(eVar.mTimeStamp)) + this.cHi);
            onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
