package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.g, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private com.baidu.tieba.card.i hBn;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.g.gKL);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> b(ViewGroup viewGroup) {
        this.hBn = new com.baidu.tieba.card.i(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.hBn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        if (aVar.bLU() == null) {
            return null;
        }
        aVar.bLU().a(gVar);
        aVar.bLU().c(new aa<com.baidu.tieba.e.g>() { // from class: com.baidu.tieba.frs.gamerecommend.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view2, com.baidu.tieba.e.g gVar2) {
                TiebaStatic.log(new an("c13047").ag("obj_locate", 1).dh("fid", h.this.mForumId));
                ba.aUZ().a((TbPageContext) com.baidu.adp.base.i.G(view2.getContext()), new String[]{gVar2.bMP().score_url}, true);
            }
        });
        aVar.bLU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.bLU().getView();
    }
}
