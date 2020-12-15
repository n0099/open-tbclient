package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.f.g, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private com.baidu.tieba.card.i jlX;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.f.g.iqH);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> c(ViewGroup viewGroup) {
        this.jlX = new com.baidu.tieba.card.i(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.jlX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.f.g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        if (aVar.csN() == null) {
            return null;
        }
        aVar.csN().a(gVar);
        aVar.csN().c(new ab<com.baidu.tieba.f.g>() { // from class: com.baidu.tieba.frs.gamerecommend.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.f.g gVar2) {
                TiebaStatic.log(new ar("c13047").al("obj_locate", 1).dY("fid", h.this.mForumId));
                bf.bua().a((TbPageContext) com.baidu.adp.base.i.J(view2.getContext()), new String[]{gVar2.ctG().score_url}, true);
            }
        });
        aVar.csN().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.csN().getView();
    }
}
