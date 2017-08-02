package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<bl, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements v, com.baidu.tieba.frs.f.c {
    private TbPageContext<?> ako;
    private x<bl> bjm;
    private com.baidu.tieba.frs.entelechy.view.c cmD;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cmE;
    private com.baidu.adp.lib.e.b<TbImageView> cmF;
    private String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cmD = new com.baidu.tieba.frs.entelechy.view.c(this.ako, this.mPageId);
        this.cmD.setConstrainLayoutPool(this.cmE);
        this.cmD.setConstrainImagePool(this.cmF);
        this.cmD.setForumName(this.mForumName);
        this.cmD.j(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cmD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.WX() == null) {
            return null;
        }
        aVar.WX().a((com.baidu.tieba.card.a) blVar);
        aVar.WX().a(this.bjm);
        com.baidu.tieba.frs.f.b.aiM().a(cut, blVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
