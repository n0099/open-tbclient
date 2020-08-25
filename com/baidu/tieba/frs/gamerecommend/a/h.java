package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.g, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private com.baidu.tieba.card.i ijq;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.g.hqs);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> b(ViewGroup viewGroup) {
        this.ijq = new com.baidu.tieba.card.i(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.ijq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        if (aVar.ccE() == null) {
            return null;
        }
        aVar.ccE().a(gVar);
        aVar.ccE().c(new aa<com.baidu.tieba.e.g>() { // from class: com.baidu.tieba.frs.gamerecommend.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view2, com.baidu.tieba.e.g gVar2) {
                TiebaStatic.log(new aq("c13047").ai("obj_locate", 1).dD("fid", h.this.mForumId));
                be.bju().a((TbPageContext) com.baidu.adp.base.i.I(view2.getContext()), new String[]{gVar2.cdu().score_url}, true);
            }
        });
        aVar.ccE().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.ccE().getView();
    }
}
