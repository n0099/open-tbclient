package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId cwh;
    private com.baidu.tieba.card.i gcH;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.gej);
        this.mPageContext = tbPageContext;
        this.gcH = new com.baidu.tieba.card.i(this.mPageContext);
        this.gcH.o("c10714", "c10739", "c10712", "c10738");
        this.gcH.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cwh = bdUniqueId;
        if (this.gcH != null) {
            this.gcH.i(this.cwh);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.aYp() == null) {
            return null;
        }
        aVar.aYp().a(bVar);
        com.baidu.tieba.card.t.aXM().b(new am("c10714").bT("obj_param3", com.baidu.tieba.card.n.aXE()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.gcH == null) {
            this.gcH = new com.baidu.tieba.card.i(this.mPageContext);
            this.gcH.i(this.cwh);
            this.gcH.o("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.gcH);
    }

    public void onChangeSkinType(int i) {
        if (this.gcH != null) {
            this.gcH.onChangeSkinType(this.mPageContext, i);
        }
    }
}
