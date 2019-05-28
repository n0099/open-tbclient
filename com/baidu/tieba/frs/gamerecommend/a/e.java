package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.f;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.d, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f>> {
    private com.baidu.tieba.card.f fCb;
    private String mForumId;
    private TbPageContext<?> mPageContext;
    private ab sF;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.d.eNj);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> onCreateViewHolder(ViewGroup viewGroup) {
        this.fCb = new com.baidu.tieba.card.f(this.mPageContext, this.mForumId);
        return new com.baidu.tieba.card.a.a<>(this.fCb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        if (aVar.aYs() == null) {
            return null;
        }
        aVar.aYs().a(dVar);
        aVar.aYs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.aYs().a(new f.a() { // from class: com.baidu.tieba.frs.gamerecommend.a.e.1
            @Override // com.baidu.tieba.card.f.a
            public void b(View view2, com.baidu.tieba.card.data.b bVar) {
                if (e.this.sF != null) {
                    e.this.sF.a(view2, bVar);
                }
            }
        });
        return aVar.aYs().getView();
    }

    public void e(ab abVar) {
        this.sF = abVar;
    }
}
