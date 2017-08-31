package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.k;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<bj, com.baidu.tieba.card.a.a<k>> implements v, com.baidu.tieba.frs.f.c {
    private x<bj> bkW;
    private k cvm;
    private boolean cvn;
    private TbPageContext<?> mF;
    private String mForumName;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cvn = false;
        this.bkW = new x<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == d.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.f.b.alj().a(com.baidu.tieba.frs.f.c.cEr, bjVar, 2);
                    } else {
                        com.baidu.tieba.frs.f.b.alj().a(com.baidu.tieba.frs.f.c.cEr, bjVar, 7);
                    }
                }
            }
        };
        this.mF = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a<k> onCreateViewHolder(ViewGroup viewGroup) {
        this.cvm = new k(this.mF, this.mPageId);
        if (this.cvn) {
            this.cvm.ajo();
        }
        this.cvm.l(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.cvm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.tieba.card.a.a<k> aVar) {
        if (aVar == null || aVar.Yy() == null) {
            return null;
        }
        aVar.Yy().a(bjVar);
        aVar.Yy().setForumName(this.mForumName);
        aVar.Yy().b(this.bkW);
        com.baidu.tieba.frs.f.b.alj().a(cEr, bjVar);
        if (bjVar != null) {
            bjVar.sz();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void eZ(boolean z) {
        this.cvn = z;
    }
}
