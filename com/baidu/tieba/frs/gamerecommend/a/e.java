package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.g;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.d, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g>> {
    private com.baidu.tieba.card.g dsL;
    private String mForumId;
    private TbPageContext<?> mPageContext;
    private ab rY;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.d.cNZ);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> onCreateViewHolder(ViewGroup viewGroup) {
        this.dsL = new com.baidu.tieba.card.g(this.mPageContext, this.mForumId);
        return new com.baidu.tieba.card.a.a<>(this.dsL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> aVar) {
        if (aVar.ajG() == null) {
            return null;
        }
        aVar.ajG().a(dVar);
        aVar.ajG().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.ajG().a(new g.a() { // from class: com.baidu.tieba.frs.gamerecommend.a.e.1
            @Override // com.baidu.tieba.card.g.a
            public void b(View view2, com.baidu.tieba.card.data.b bVar) {
                if (e.this.rY != null) {
                    e.this.rY.a(view2, bVar);
                }
            }
        });
        return aVar.ajG().getView();
    }

    public void d(ab abVar) {
        this.rY = abVar;
    }
}
