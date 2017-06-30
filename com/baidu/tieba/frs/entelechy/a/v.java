package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.av;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<bm, com.baidu.tieba.card.b.a<av>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajP;
    private ci<bm> bgf;
    private av cgS;
    private String mForumName;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bgf = new w(this);
        this.ajP = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a<av> onCreateViewHolder(ViewGroup viewGroup) {
        this.cgS = new av(this.ajP, this.mPageId);
        this.cgS.j(this.mPageId);
        return new com.baidu.tieba.card.b.a<>(this.cgS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bm bmVar, com.baidu.tieba.card.b.a<av> aVar) {
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        aVar.Wp().t(bmVar);
        aVar.Wp().setForumName(this.mForumName);
        aVar.Wp().a(this.bgf);
        com.baidu.tieba.frs.d.b.aho().a(cnC, bmVar);
        if (bmVar != null) {
            bmVar.sp();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
