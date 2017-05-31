package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m>> {
    public BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    private com.baidu.tieba.card.m cBV;
    private ci<com.baidu.tieba.card.data.h> cBW;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.cBW = new t(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cBV = new com.baidu.tieba.card.m(this.ajh, this.aKZ);
        return new com.baidu.tieba.card.b.a(this.cBV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.b.a<com.baidu.tieba.card.m> aVar) {
        this.cBV = aVar.UY();
        aVar.UY().a(hVar);
        aVar.UY().a(this.cBW);
        aVar.UY().d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        cf.Uw().a(new as("c11006"));
        return aVar.getView();
    }

    public void kn(int i) {
        if (this.cBV != null) {
            this.cBV.d(this.ajh, i);
        }
    }
}
