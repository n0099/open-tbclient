package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, a> {
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private com.baidu.tieba.card.t cxS;
    cf<com.baidu.tieba.card.data.m> cxT;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cxT = new e(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cxS = new com.baidu.tieba.card.t(this.FY);
        this.cxS.j(this.FY.getUniqueId());
        return new a(this.cxS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gL(i + 1);
        }
        aVar.cxV.onBindDataToView(mVar);
        aVar.cxV.setOnSubCardOnClickListenner(this.cxT);
        TiebaStatic.log("c11823");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.t cxV;

        public a(com.baidu.tieba.card.t tVar) {
            super(tVar.getView());
            this.cxV = tVar;
        }
    }
}
