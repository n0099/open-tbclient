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
    private TbPageContext<?> alI;
    private x<bl> bkw;
    private com.baidu.tieba.frs.entelechy.view.c cnP;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cnQ;
    private com.baidu.adp.lib.e.b<TbImageView> cnR;
    private String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cnP = new com.baidu.tieba.frs.entelechy.view.c(this.alI, this.mPageId);
        this.cnP.setConstrainLayoutPool(this.cnQ);
        this.cnP.setConstrainImagePool(this.cnR);
        this.cnP.setForumName(this.mForumName);
        this.cnP.j(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cnP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Xc() == null) {
            return null;
        }
        aVar.Xc().a((com.baidu.tieba.card.a) blVar);
        aVar.Xc().a(this.bkw);
        com.baidu.tieba.frs.e.b.aiY().a(cvL, blVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
