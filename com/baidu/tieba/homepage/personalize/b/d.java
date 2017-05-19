package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    public BdUniqueId aLk;
    private o.a ajA;
    private TbPageContext<?> ajr;
    private com.baidu.tieba.card.p cvp;
    cd<com.baidu.tieba.card.data.k> cvq;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajA = null;
        this.cvq = new e(this);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cvp = new com.baidu.tieba.card.p(this.ajr);
        this.cvp.j(this.ajr.getUniqueId());
        return new a(this.cvp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.gN(i + 1);
        }
        aVar.cvs.onBindDataToView(kVar);
        aVar.cvs.setOnSubCardOnClickListenner(this.cvq);
        aVar.cvs.a(this.ajA);
        int i2 = 0;
        String str = "";
        if (kVar != null && kVar.JB() != null) {
            i2 = kVar.JB().rQ().live_type;
            str = kVar.JB().getTid();
        }
        TiebaStatic.log(new as("c11823").s("obj_type", i2).aa("tid", str));
        return aVar.getView();
    }

    public void setEventCallback(o.a aVar) {
        this.ajA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.p cvs;

        public a(com.baidu.tieba.card.p pVar) {
            super(pVar.getView());
            this.cvs = pVar;
        }
    }
}
