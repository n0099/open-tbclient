package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements v, com.baidu.tieba.frs.f.c {
    private x<bh> bms;
    private com.baidu.tieba.frs.entelechy.view.c cwq;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwr;
    private com.baidu.adp.lib.e.b<TbImageView> cws;
    private String mForumName;
    private TbPageContext<?> mH;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cwq = new com.baidu.tieba.frs.entelechy.view.c(this.mH, this.mPageId);
        this.cwq.setConstrainLayoutPool(this.cwr);
        this.cwq.setConstrainImagePool(this.cws);
        this.cwq.setForumName(this.mForumName);
        this.cwq.k(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cwq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Yn() == null) {
            return null;
        }
        aVar.Yn().a((com.baidu.tieba.card.a) bhVar);
        aVar.Yn().b(this.bms);
        com.baidu.tieba.frs.f.b.alt().a(cFQ, bhVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
