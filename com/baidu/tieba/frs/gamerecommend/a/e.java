package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.g;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.d, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g>> {
    private aa iqg;
    private com.baidu.tieba.card.g iqq;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.d.hxx);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> c(ViewGroup viewGroup) {
        this.iqq = new com.baidu.tieba.card.g(this.mPageContext, this.mForumId);
        return new com.baidu.tieba.card.a.a<>(this.iqq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> aVar) {
        if (aVar.cfU() == null) {
            return null;
        }
        aVar.cfU().a(dVar);
        aVar.cfU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.cfU().a(new g.a() { // from class: com.baidu.tieba.frs.gamerecommend.a.e.1
            @Override // com.baidu.tieba.card.g.a
            public void b(View view2, com.baidu.tieba.card.data.b bVar) {
                if (e.this.iqg != null) {
                    e.this.iqg.a(view2, bVar);
                }
            }
        });
        return aVar.cfU().getView();
    }

    public void d(aa aaVar) {
        this.iqg = aaVar;
    }
}
