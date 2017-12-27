package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.g<be, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<be> cip;
    private com.baidu.tieba.frs.entelechy.view.c dCK;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dCL;
    private com.baidu.adp.lib.e.b<TbImageView> dCM;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.dCK = new com.baidu.tieba.frs.entelechy.view.c(this.mPageContext, this.mPageId);
        this.dCK.setConstrainLayoutPool(this.dCL);
        this.dCK.setConstrainImagePool(this.dCM);
        this.dCK.setForumName(this.mForumName);
        this.dCK.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.dCK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, be beVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> aVar) {
        if (aVar == null || aVar.akh() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.akh().ajD(), this.dwm);
        aVar.akh().a(beVar);
        aVar.akh().b(this.cip);
        com.baidu.tieba.frs.d.b.axH().a(dMh, beVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dCK != null) {
            this.dCK.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
