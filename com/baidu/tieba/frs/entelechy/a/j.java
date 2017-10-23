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
public class j extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.a.a<k>> implements v, com.baidu.tieba.frs.f.c {
    private x<bh> bms;
    private k cwA;
    private boolean cwB;
    private String mForumName;
    private TbPageContext<?> mH;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cwB = false;
        this.bms = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 2);
                    } else {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 7);
                    }
                }
            }
        };
        this.mH = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<k> onCreateViewHolder(ViewGroup viewGroup) {
        this.cwA = new k(this.mH, this.mPageId);
        if (this.cwB) {
            this.cwA.eV(true);
        }
        this.cwA.k(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.cwA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<k> aVar) {
        if (aVar == null || aVar.Yn() == null) {
            return null;
        }
        aVar.Yn().a(bhVar);
        aVar.Yn().setForumName(this.mForumName);
        aVar.Yn().b(this.bms);
        com.baidu.tieba.frs.f.b.alt().a(cFQ, bhVar);
        if (bhVar != null) {
            bhVar.sm();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void eS(boolean z) {
        this.cwB = z;
    }
}
