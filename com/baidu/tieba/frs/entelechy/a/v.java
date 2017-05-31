package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.av;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<bl, com.baidu.tieba.card.b.a<av>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajh;
    private av bYJ;
    private ci<bl> bdm;
    private String mForumName;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bdm = new w(this);
        this.ajh = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a<av> onCreateViewHolder(ViewGroup viewGroup) {
        this.bYJ = new av(this.ajh, this.mPageId);
        this.bYJ.j(this.mPageId);
        return new com.baidu.tieba.card.b.a<>(this.bYJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.b.a<av> aVar) {
        if (aVar == null || aVar.UY() == null) {
            return null;
        }
        aVar.UY().r(blVar);
        aVar.UY().setForumName(this.mForumName);
        aVar.UY().a(this.bdm);
        com.baidu.tieba.frs.d.b.adw().a(cfm, blVar);
        if (blVar != null) {
            blVar.ss();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
