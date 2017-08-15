package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<bl, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements v, com.baidu.tieba.frs.e.c {
    private x<bl> bkA;
    private com.baidu.tieba.frs.entelechy.view.c cox;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> coy;
    private com.baidu.adp.lib.e.b<TbImageView> coz;
    private String mForumName;
    private TbPageContext<?> oV;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cox = new com.baidu.tieba.frs.entelechy.view.c(this.oV, this.mPageId);
        this.cox.setConstrainLayoutPool(this.coy);
        this.cox.setConstrainImagePool(this.coz);
        this.cox.setForumName(this.mForumName);
        this.cox.j(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cox);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Xy() == null) {
            return null;
        }
        aVar.Xy().a((com.baidu.tieba.card.a) blVar);
        aVar.Xy().b(this.bkA);
        com.baidu.tieba.frs.e.b.ajF().a(cxO, blVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
