package com.baidu.tieba.frs.worldcup.videotopic.insertcard;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.f;
/* loaded from: classes2.dex */
public class d extends f<com.baidu.tieba.frs.worldcup.talkball.b.f, a> {
    private String mForumId;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumId = "";
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(new com.baidu.tieba.frs.worldcup.videotopic.insertcard.a(this.mPageContext, this.mPageId));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.worldcup.talkball.b.f fVar, a aVar) {
        super.onFillViewHolder(i, view, viewGroup, fVar, aVar);
        if (aVar == null || aVar.dGX == null) {
            return null;
        }
        if (fVar != null) {
            aVar.dGX.setForumId(this.mForumId);
            aVar.dGX.a(fVar);
        }
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        private com.baidu.tieba.frs.worldcup.videotopic.insertcard.a dGX;

        public a(com.baidu.tieba.frs.worldcup.videotopic.insertcard.a aVar) {
            super(aVar.getView());
            this.dGX = aVar;
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }
}
