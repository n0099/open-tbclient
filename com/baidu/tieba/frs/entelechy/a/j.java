package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.k;
/* loaded from: classes2.dex */
public class j extends com.baidu.tieba.frs.g<be, com.baidu.tieba.card.a.a<k>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<be> cip;
    private k dCU;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cip = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 2);
                    } else {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 7);
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<k> onCreateViewHolder(ViewGroup viewGroup) {
        this.dCU = new k(this.mPageContext, this.mPageId);
        this.dCU.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.dCU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, be beVar, com.baidu.tieba.card.a.a<k> aVar) {
        if (aVar == null || aVar.akh() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.akh().ajD(), this.dwm);
        aVar.akh().a(beVar);
        aVar.akh().setForumName(this.mForumName);
        aVar.akh().b(this.cip);
        com.baidu.tieba.frs.d.b.axH().a(dMh, beVar);
        if (beVar != null) {
            beVar.zW();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
