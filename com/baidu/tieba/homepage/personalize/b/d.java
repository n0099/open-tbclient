package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    public BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    private o.a ajq;
    private com.baidu.tieba.card.t cBH;
    ci<com.baidu.tieba.card.data.k> cBI;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajq = null;
        this.cBI = new e(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cBH = new com.baidu.tieba.card.t(this.ajh);
        this.cBH.j(this.ajh.getUniqueId());
        return new a(this.cBH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.hl(i + 1);
        }
        aVar.cBK.a(kVar);
        aVar.cBK.a(this.cBI);
        aVar.cBK.a(this.ajq);
        int i2 = 0;
        String str = "";
        if (kVar != null && kVar.LH() != null) {
            i2 = kVar.LH().rM().live_type;
            str = kVar.LH().getTid();
        }
        TiebaStatic.log(new as("c11823").r("obj_type", i2).Z("tid", str));
        return aVar.getView();
    }

    public void setEventCallback(o.a aVar) {
        this.ajq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends z.a {
        public com.baidu.tieba.card.t cBK;

        public a(com.baidu.tieba.card.t tVar) {
            super(tVar.getView());
            this.cBK = tVar;
        }
    }
}
