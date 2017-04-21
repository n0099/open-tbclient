package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, a> {
    private TbPageContext<?> ajU;
    private o.a akd;
    public BdUniqueId bbE;
    private com.baidu.tieba.card.t cAf;
    cf<com.baidu.tieba.card.data.m> cAg;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akd = null;
        this.cAg = new e(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cAf = new com.baidu.tieba.card.t(this.ajU);
        this.cAf.TK();
        this.cAf.j(this.ajU.getUniqueId());
        return new a(this.cAf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gR(i + 1);
        }
        aVar.cAi.onBindDataToView(mVar);
        aVar.cAi.setOnSubCardOnClickListenner(this.cAg);
        aVar.cAi.a(this.akd);
        int i2 = 0;
        String str = "";
        if (mVar != null && mVar.Kn() != null) {
            i2 = mVar.Kn().sG().live_type;
            str = mVar.Kn().getTid();
        }
        TiebaStatic.log(new as("c11823").s("obj_type", i2).aa("tid", str));
        return aVar.getView();
    }

    public void setEventCallback(o.a aVar) {
        this.akd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.t cAi;

        public a(com.baidu.tieba.card.t tVar) {
            super(tVar.getView());
            this.cAi = tVar;
        }
    }
}
