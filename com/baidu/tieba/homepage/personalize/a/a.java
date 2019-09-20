package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId cyA;
    private com.baidu.tieba.card.i glE;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.gng);
        this.mPageContext = tbPageContext;
        this.glE = new com.baidu.tieba.card.i(this.mPageContext);
        this.glE.p("c10714", "c10739", "c10712", "c10738");
        this.glE.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cyA = bdUniqueId;
        if (this.glE != null) {
            this.glE.j(this.cyA);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.baX() == null) {
            return null;
        }
        aVar.baX().a(bVar);
        com.baidu.tieba.card.t.bat().c(new an("c10714").bT("obj_param3", com.baidu.tieba.card.n.bak()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.glE == null) {
            this.glE = new com.baidu.tieba.card.i(this.mPageContext);
            this.glE.j(this.cyA);
            this.glE.p("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.glE);
    }

    public void onChangeSkinType(int i) {
        if (this.glE != null) {
            this.glE.onChangeSkinType(this.mPageContext, i);
        }
    }
}
