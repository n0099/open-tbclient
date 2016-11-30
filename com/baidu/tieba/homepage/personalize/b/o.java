package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    private TbPageContext<?> GO;
    public BdUniqueId bcf;
    private com.baidu.tieba.card.m cLN;
    private bz<com.baidu.tieba.card.data.k> cLO;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.k.RQ);
        this.cLO = new p(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a a(ViewGroup viewGroup) {
        this.cLN = new com.baidu.tieba.card.m(this.GO, this.bcf);
        return new a(this.cLN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        this.cLN = aVar.cLQ;
        aVar.cLQ.onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.cLQ.a(kVar);
        aVar.cLQ.setOnSubCardOnClickListenner(this.cLO);
        bx.Pl().a(new av("c11006"));
        return aVar.getView();
    }

    public void kp(int i) {
        if (this.cLN != null) {
            this.cLN.onChangeSkinType(this.GO, i);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.m cLQ;

        public a(com.baidu.tieba.card.m mVar) {
            super(mVar.getView());
            this.cLQ = mVar;
        }
    }
}
