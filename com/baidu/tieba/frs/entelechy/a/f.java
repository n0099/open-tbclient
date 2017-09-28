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
    private x<bh> bmG;
    private com.baidu.tieba.frs.entelechy.view.c cwC;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwD;
    private com.baidu.adp.lib.e.b<TbImageView> cwE;
    private String mForumName;
    private TbPageContext<?> mG;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cwC = new com.baidu.tieba.frs.entelechy.view.c(this.mG, this.mPageId);
        this.cwC.setConstrainLayoutPool(this.cwD);
        this.cwC.setConstrainImagePool(this.cwE);
        this.cwC.setForumName(this.mForumName);
        this.cwC.k(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cwC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Yr() == null) {
            return null;
        }
        aVar.Yr().a((com.baidu.tieba.card.a) bhVar);
        aVar.Yr().b(this.bmG);
        com.baidu.tieba.frs.f.b.aly().a(cGc, bhVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
