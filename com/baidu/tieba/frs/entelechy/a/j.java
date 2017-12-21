package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.entelechy.view.k;
/* loaded from: classes.dex */
public class j extends e<bd, com.baidu.tieba.card.a.a<k>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<bd> buX;
    private k cNT;
    private boolean cNU;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cNU = false;
        this.buX = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cZc, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aqw().a(com.baidu.tieba.frs.e.c.cZc, bdVar, 7);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<k> onCreateViewHolder(ViewGroup viewGroup) {
        this.cNT = new k(this.mPageContext, this.mPageId);
        if (this.cNU) {
            this.cNT.fn(true);
        }
        this.cNT.k(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.cNT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<k> aVar) {
        if (aVar == null || aVar.acB() == null) {
            return null;
        }
        com.baidu.tieba.frs.d.a(aVar.acB().abX(), this.cGS);
        aVar.acB().a(bdVar);
        aVar.acB().setForumName(this.mForumName);
        aVar.acB().b(this.buX);
        com.baidu.tieba.frs.e.b.aqw().a(cZc, bdVar);
        if (bdVar != null) {
            bdVar.su();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void fk(boolean z) {
        this.cNU = z;
    }
}
