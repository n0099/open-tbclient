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
public class c extends com.baidu.adp.widget.ListView.a<av, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.h>> implements com.baidu.tieba.frs.e.c {
    private x bon;
    private com.baidu.tieba.frs.entelechy.view.h cDY;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bon = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && c.this.cDY != null && c.this.cDY.getView() != null && c.this.cDY.cFS != null && bhVar != null && !StringUtils.isNull(bhVar.getTid())) {
                    if (view.getId() == d.g.card_root_view) {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 1);
                    } else if (view.getId() == d.g.avatar) {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cPx, bhVar.rS());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cDY = new com.baidu.tieba.frs.entelechy.view.h(this.mPageContext, this.mPageId);
        this.cDY.h(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cDY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, av avVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.aaJ() == null) {
            return null;
        }
        aVar.aaJ().a((com.baidu.tieba.card.a) avVar);
        aVar.aaJ().b(this.bon);
        com.baidu.tieba.frs.e.b.aot().a(cPx, avVar);
        return aVar.getView();
    }
}
