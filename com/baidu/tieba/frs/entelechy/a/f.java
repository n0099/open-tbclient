package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<bj, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements v, com.baidu.tieba.frs.f.c {
    private x<bj> bkW;
    private com.baidu.tieba.frs.entelechy.view.c cvc;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cvd;
    private com.baidu.adp.lib.e.b<TbImageView> cve;
    private TbPageContext<?> mF;
    private String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cvc = new com.baidu.tieba.frs.entelechy.view.c(this.mF, this.mPageId);
        this.cvc.setConstrainLayoutPool(this.cvd);
        this.cvc.setConstrainImagePool(this.cve);
        this.cvc.setForumName(this.mForumName);
        this.cvc.l(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cvc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Yy() == null) {
            return null;
        }
        aVar.Yy().a((com.baidu.tieba.card.a) bjVar);
        aVar.Yy().b(this.bkW);
        com.baidu.tieba.frs.f.b.alj().a(cEr, bjVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
