package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.g;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.d, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g>> {
    private aa hAV;
    private com.baidu.tieba.card.g hBf;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.d.gKF);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> b(ViewGroup viewGroup) {
        this.hBf = new com.baidu.tieba.card.g(this.mPageContext, this.mForumId);
        return new com.baidu.tieba.card.a.a<>(this.hBf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> aVar) {
        if (aVar.bLU() == null) {
            return null;
        }
        aVar.bLU().a(dVar);
        aVar.bLU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.bLU().a(new g.a() { // from class: com.baidu.tieba.frs.gamerecommend.a.e.1
            @Override // com.baidu.tieba.card.g.a
            public void b(View view2, com.baidu.tieba.card.data.b bVar) {
                if (e.this.hAV != null) {
                    e.this.hAV.a(view2, bVar);
                }
            }
        });
        return aVar.bLU().getView();
    }

    public void d(aa aaVar) {
        this.hAV = aaVar;
    }
}
