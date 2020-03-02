package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.g, com.baidu.tieba.card.a.a<com.baidu.tieba.card.h>> {
    private com.baidu.tieba.card.h gBN;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.g.fQq);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.h> b(ViewGroup viewGroup) {
        this.gBN = new com.baidu.tieba.card.h(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.gBN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.h> aVar) {
        if (aVar.bvK() == null) {
            return null;
        }
        aVar.bvK().a(gVar);
        aVar.bvK().c(new z<com.baidu.tieba.e.g>() { // from class: com.baidu.tieba.frs.gamerecommend.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view2, com.baidu.tieba.e.g gVar2) {
                TiebaStatic.log(new an("c13047").X("obj_locate", 1).cy("fid", h.this.mForumId));
                ba.aGG().a((TbPageContext) com.baidu.adp.base.i.ab(view2.getContext()), new String[]{gVar2.bwF().score_url}, true);
            }
        });
        aVar.bvK().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.bvK().getView();
    }
}
