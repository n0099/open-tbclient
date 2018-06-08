package com.baidu.tieba.frs.worldcup.videotopic.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.worldcup.c;
/* loaded from: classes2.dex */
public class b extends f<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.worldcup.videotopic.c.a>> {
    private ab<bd> dGz;
    private String mForumId;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumId = "";
        this.dGz = new ab<bd>() { // from class: com.baidu.tieba.frs.worldcup.videotopic.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    c.b(bdVar, b.this.mForumId, 5);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.worldcup.videotopic.c.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.worldcup.videotopic.c.a aVar = new com.baidu.tieba.frs.worldcup.videotopic.c.a(this.mPageContext, this.mPageId);
        aVar.b(this.dGz);
        aVar.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.worldcup.videotopic.c.a> aVar) {
        if (aVar == null || aVar.ajG() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bdVar, aVar);
        aVar.ajG().b(this.dGz);
        aVar.ajG().a(bdVar);
        if (bdVar != null) {
            bdVar.wg();
        }
        return aVar.getView();
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }
}
