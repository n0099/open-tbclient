package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId cxx;
    private com.baidu.tieba.card.i giW;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.gky);
        this.mPageContext = tbPageContext;
        this.giW = new com.baidu.tieba.card.i(this.mPageContext);
        this.giW.o("c10714", "c10739", "c10712", "c10738");
        this.giW.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cxx = bdUniqueId;
        if (this.giW != null) {
            this.giW.j(this.cxx);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.bar() == null) {
            return null;
        }
        aVar.bar().a(bVar);
        com.baidu.tieba.card.t.aZN().c(new an("c10714").bT("obj_param3", com.baidu.tieba.card.n.aZE()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.giW == null) {
            this.giW = new com.baidu.tieba.card.i(this.mPageContext);
            this.giW.j(this.cxx);
            this.giW.o("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.giW);
    }

    public void onChangeSkinType(int i) {
        if (this.giW != null) {
            this.giW.onChangeSkinType(this.mPageContext, i);
        }
    }
}
