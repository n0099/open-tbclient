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
    private TbPageContext<?> ajF;
    private o.a ajO;
    public BdUniqueId baP;
    private com.baidu.tieba.card.t czo;
    cf<com.baidu.tieba.card.data.m> czp;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajO = null;
        this.czp = new e(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.czo = new com.baidu.tieba.card.t(this.ajF);
        this.czo.Sk();
        this.czo.j(this.ajF.getUniqueId());
        return new a(this.czo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gI(i + 1);
        }
        aVar.czr.onBindDataToView(mVar);
        aVar.czr.setOnSubCardOnClickListenner(this.czp);
        aVar.czr.a(this.ajO);
        TiebaStatic.log("c11823");
        return aVar.getView();
    }

    public void setEventCallback(o.a aVar) {
        this.ajO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.t czr;

        public a(com.baidu.tieba.card.t tVar) {
            super(tVar.getView());
            this.czr = tVar;
        }
    }
}
