package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<av, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.h>> implements com.baidu.tieba.frs.f.c {
    private x bmJ;
    private com.baidu.tieba.frs.entelechy.view.h cwk;
    private TbPageContext<?> mG;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bmJ = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && c.this.cwk != null && c.this.cwk.getView() != null && c.this.cwk.cxS != null && bhVar != null && !StringUtils.isNull(bhVar.getTid())) {
                    if (view.getId() == d.h.card_root_view) {
                        com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, 1);
                    } else if (view.getId() == d.h.avatar) {
                        com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cGc, bhVar.rT());
                    }
                }
            }
        };
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cwk = new com.baidu.tieba.frs.entelechy.view.h(this.mG, this.mPageId);
        this.cwk.h(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cwk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, av avVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Yr() == null) {
            return null;
        }
        aVar.Yr().a((com.baidu.tieba.card.a) avVar);
        aVar.Yr().b(this.bmJ);
        com.baidu.tieba.frs.f.b.aly().a(cGc, avVar);
        return aVar.getView();
    }
}
