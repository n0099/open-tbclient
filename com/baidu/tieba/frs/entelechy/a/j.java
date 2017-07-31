package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.k;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<bl, com.baidu.tieba.card.a.a<k>> implements v, com.baidu.tieba.frs.e.c {
    private TbPageContext<?> alI;
    private x<bl> bkw;
    private k cnZ;
    private String mForumName;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkw = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 7);
                    }
                }
            }
        };
        this.alI = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<k> onCreateViewHolder(ViewGroup viewGroup) {
        this.cnZ = new k(this.alI, this.mPageId);
        this.cnZ.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.cnZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.a.a<k> aVar) {
        if (aVar == null || aVar.Xc() == null) {
            return null;
        }
        aVar.Xc().a(blVar);
        aVar.Xc().setForumName(this.mForumName);
        aVar.Xc().a(this.bkw);
        com.baidu.tieba.frs.e.b.aiY().a(cvL, blVar);
        if (blVar != null) {
            blVar.sD();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
