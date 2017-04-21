package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.cc;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.b.a<com.baidu.tieba.card.h>> {
    private TbPageContext<?> ajU;
    private BdUniqueId bbE;
    private com.baidu.tieba.card.h cAc;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cBj);
        this.ajU = tbPageContext;
        this.cAc = new com.baidu.tieba.card.h(this.ajU);
        this.cAc.k("c10714", "c10739", "c10712", "c10738");
        this.cAc.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bbE = bdUniqueId;
        if (this.cAc != null) {
            this.cAc.i(this.bbE);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar.UB() == null) {
            return null;
        }
        aVar.UB().onBindDataToView(bVar);
        cc.TV().a(new as("c10714").aa("obj_param3", at.TP()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cAc == null) {
            this.cAc = new com.baidu.tieba.card.h(this.ajU);
            this.cAc.i(this.bbE);
            this.cAc.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.b.a(this.cAc);
    }

    public void onChangeSkinType(int i) {
        if (this.cAc != null) {
            this.cAc.onChangeSkinType(this.ajU, i);
        }
    }
}
