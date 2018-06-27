package com.baidu.tieba.frs.worldcup.videotopic.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.worldcup.c;
/* loaded from: classes2.dex */
public class b extends h<bc, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.worldcup.videotopic.d.a>> {
    private ad<bc> dJS;
    private String mForumId;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumId = "";
        this.dJS = new ad<bc>() { // from class: com.baidu.tieba.frs.worldcup.videotopic.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null) {
                    c.b(bcVar, b.this.mForumId, 5);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.worldcup.videotopic.d.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.worldcup.videotopic.d.a aVar = new com.baidu.tieba.frs.worldcup.videotopic.d.a(this.mPageContext, this.mPageId);
        aVar.b(this.dJS);
        aVar.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bc bcVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.worldcup.videotopic.d.a> aVar) {
        if (aVar == null || aVar.aja() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bcVar, aVar);
        aVar.aja().b(this.dJS);
        aVar.aja().a(bcVar);
        if (bcVar != null) {
            bcVar.wq();
        }
        return aVar.getView();
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }
}
