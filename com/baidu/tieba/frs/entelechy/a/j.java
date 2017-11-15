package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.k;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.a.a<k>> implements v, com.baidu.tieba.frs.e.c {
    private x<bh> bok;
    private k cEA;
    private boolean cEB;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cEB = false;
        this.bok = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 7);
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
    /* renamed from: S */
    public com.baidu.tieba.card.a.a<k> onCreateViewHolder(ViewGroup viewGroup) {
        this.cEA = new k(this.mPageContext, this.mPageId);
        if (this.cEB) {
            this.cEA.eV(true);
        }
        this.cEA.k(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.cEA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<k> aVar) {
        if (aVar == null || aVar.aaJ() == null) {
            return null;
        }
        aVar.aaJ().a(bhVar);
        aVar.aaJ().setForumName(this.mForumName);
        aVar.aaJ().b(this.bok);
        com.baidu.tieba.frs.e.b.aot().a(cPx, bhVar);
        if (bhVar != null) {
            bhVar.st();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void eS(boolean z) {
        this.cEB = z;
    }
}
