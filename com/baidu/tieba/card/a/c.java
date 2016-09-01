package com.baidu.tieba.card.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View aXY;
    private TextView aYh;
    private View bcO;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.aXY = getView().findViewById(t.g.card_divider_top_margin);
        this.aYh = (TextView) getView().findViewById(t.g.card_divider_tv);
        this.bcO = getView().findViewById(t.g.bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.j((View) this.aYh, t.d.cp_cont_d);
            av.l(this.bcO, t.d.cp_bg_line_b);
            av.l(this.aXY, t.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_divider_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(b bVar) {
        if (bVar != null) {
            if (bVar.bbt) {
                this.aXY.setVisibility(0);
            } else {
                this.aXY.setVisibility(8);
            }
            this.aYh.setText(bVar.title);
            onChangeSkinType(null, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
