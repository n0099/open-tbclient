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
    private x<bl> bkB;
    private com.baidu.adp.lib.e.b<TbImageView> coA;
    private com.baidu.tieba.frs.entelechy.view.c coy;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> coz;
    private String mForumName;
    private TbPageContext<?> oW;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.coy = new com.baidu.tieba.frs.entelechy.view.c(this.oW, this.mPageId);
        this.coy.setConstrainLayoutPool(this.coz);
        this.coy.setConstrainImagePool(this.coA);
        this.coy.setForumName(this.mForumName);
        this.coy.j(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.coy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Xv() == null) {
            return null;
        }
        aVar.Xv().a((com.baidu.tieba.card.a) blVar);
        aVar.Xv().b(this.bkB);
        com.baidu.tieba.frs.e.b.ajz().a(cxO, blVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
