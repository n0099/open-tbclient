package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.f;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.d, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f>> {
    private com.baidu.tieba.card.f gBF;
    private z gBv;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.d.fQk);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> b(ViewGroup viewGroup) {
        this.gBF = new com.baidu.tieba.card.f(this.mPageContext, this.mForumId);
        return new com.baidu.tieba.card.a.a<>(this.gBF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        if (aVar.bvK() == null) {
            return null;
        }
        aVar.bvK().a(dVar);
        aVar.bvK().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.bvK().a(new f.a() { // from class: com.baidu.tieba.frs.gamerecommend.a.e.1
            @Override // com.baidu.tieba.card.f.a
            public void b(View view2, com.baidu.tieba.card.data.b bVar) {
                if (e.this.gBv != null) {
                    e.this.gBv.a(view2, bVar);
                }
            }
        });
        return aVar.bvK().getView();
    }

    public void d(z zVar) {
        this.gBv = zVar;
    }
}
