package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, a> {
    private TbPageContext<?> ajT;
    private o.a akc;
    public BdUniqueId baI;
    private com.baidu.tieba.card.t cxO;
    cf<com.baidu.tieba.card.data.m> cxP;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akc = null;
        this.cxP = new e(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cxO = new com.baidu.tieba.card.t(this.ajT);
        this.cxO.SI();
        this.cxO.j(this.ajT.getUniqueId());
        return new a(this.cxO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gL(i + 1);
        }
        aVar.cxR.onBindDataToView(mVar);
        aVar.cxR.setOnSubCardOnClickListenner(this.cxP);
        aVar.cxR.a(this.akc);
        TiebaStatic.log("c11823");
        return aVar.getView();
    }

    public void setEventCallback(o.a aVar) {
        this.akc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.t cxR;

        public a(com.baidu.tieba.card.t tVar) {
            super(tVar.getView());
            this.cxR = tVar;
        }
    }
}
