package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId cwi;
    private com.baidu.tieba.card.i gcK;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.gem);
        this.mPageContext = tbPageContext;
        this.gcK = new com.baidu.tieba.card.i(this.mPageContext);
        this.gcK.o("c10714", "c10739", "c10712", "c10738");
        this.gcK.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cwi = bdUniqueId;
        if (this.gcK != null) {
            this.gcK.i(this.cwi);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aYs() == null) {
            return null;
        }
        aVar.aYs().a(bVar);
        com.baidu.tieba.card.t.aXP().b(new am("c10714").bT("obj_param3", com.baidu.tieba.card.n.aXH()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.gcK == null) {
            this.gcK = new com.baidu.tieba.card.i(this.mPageContext);
            this.gcK.i(this.cwi);
            this.gcK.o("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.gcK);
    }

    public void onChangeSkinType(int i) {
        if (this.gcK != null) {
            this.gcK.onChangeSkinType(this.mPageContext, i);
        }
    }
}
