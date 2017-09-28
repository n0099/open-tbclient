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
    private x<bh> bmG;
    private k cwM;
    private boolean cwN;
    private String mForumName;
    private TbPageContext<?> mG;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cwN = false;
        this.bmG = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, 2);
                    } else {
                        com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, 7);
                    }
                }
            }
        };
        this.mG = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<k> onCreateViewHolder(ViewGroup viewGroup) {
        this.cwM = new k(this.mG, this.mPageId);
        if (this.cwN) {
            this.cwM.eW(true);
        }
        this.cwM.k(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.cwM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<k> aVar) {
        if (aVar == null || aVar.Yr() == null) {
            return null;
        }
        aVar.Yr().a(bhVar);
        aVar.Yr().setForumName(this.mForumName);
        aVar.Yr().b(this.bmG);
        com.baidu.tieba.frs.f.b.aly().a(cGc, bhVar);
        if (bhVar != null) {
            bhVar.st();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void eT(boolean z) {
        this.cwN = z;
    }
}
