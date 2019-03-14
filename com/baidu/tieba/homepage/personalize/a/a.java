package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId cnX;
    private com.baidu.tieba.card.i fLL;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.fNn);
        this.mPageContext = tbPageContext;
        this.fLL = new com.baidu.tieba.card.i(this.mPageContext);
        this.fLL.o("c10714", "c10739", "c10712", "c10738");
        this.fLL.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cnX = bdUniqueId;
        if (this.fLL != null) {
            this.fLL.i(this.cnX);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aRi() == null) {
            return null;
        }
        aVar.aRi().a(bVar);
        com.baidu.tieba.card.t.aQF().b(new am("c10714").bJ("obj_param3", com.baidu.tieba.card.n.aQx()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.fLL == null) {
            this.fLL = new com.baidu.tieba.card.i(this.mPageContext);
            this.fLL.i(this.cnX);
            this.fLL.o("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.fLL);
    }

    public void onChangeSkinType(int i) {
        if (this.fLL != null) {
            this.fLL.onChangeSkinType(this.mPageContext, i);
        }
    }
}
