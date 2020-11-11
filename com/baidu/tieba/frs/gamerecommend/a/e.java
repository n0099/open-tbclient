package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.g;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.d, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g>> {
    private com.baidu.tieba.card.g iXC;
    private ab iXs;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.d.ieQ);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> c(ViewGroup viewGroup) {
        this.iXC = new com.baidu.tieba.card.g(this.mPageContext, this.mForumId);
        return new com.baidu.tieba.card.a.a<>(this.iXC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.g> aVar) {
        if (aVar.coY() == null) {
            return null;
        }
        aVar.coY().a(dVar);
        aVar.coY().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.coY().a(new g.a() { // from class: com.baidu.tieba.frs.gamerecommend.a.e.1
            @Override // com.baidu.tieba.card.g.a
            public void b(View view2, com.baidu.tieba.card.data.b bVar) {
                if (e.this.iXs != null) {
                    e.this.iXs.a(view2, bVar);
                }
            }
        });
        return aVar.coY().getView();
    }

    public void d(ab abVar) {
        this.iXs = abVar;
    }
}
