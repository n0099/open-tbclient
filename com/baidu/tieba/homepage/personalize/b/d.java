package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private o.a akb;
    private com.baidu.tieba.card.t cJE;
    ci<com.baidu.tieba.card.data.k> cJF;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akb = null;
        this.cJF = new e(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cJE = new com.baidu.tieba.card.t(this.ajP);
        this.cJE.j(this.ajP.getUniqueId());
        return new a(this.cJE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.ho(i + 1);
        }
        aVar.cJH.a(kVar);
        aVar.cJH.a(this.cJF);
        aVar.cJH.a(this.akb);
        int i2 = 0;
        String str = "";
        if (kVar != null && kVar.Mv() != null) {
            i2 = kVar.Mv().rJ().live_type;
            str = kVar.Mv().getTid();
        }
        TiebaStatic.log(new au("c11823").r("obj_type", i2).Z("tid", str));
        return aVar.getView();
    }

    public void setEventCallback(o.a aVar) {
        this.akb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends z.a {
        public com.baidu.tieba.card.t cJH;

        public a(com.baidu.tieba.card.t tVar) {
            super(tVar.getView());
            this.cJH = tVar;
        }
    }
}
