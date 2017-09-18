package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<ax, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.h>> implements com.baidu.tieba.frs.f.c {
    private x bkY;
    private com.baidu.tieba.frs.entelechy.view.h cvC;
    private TbPageContext<?> mF;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bkY = new x<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bj bjVar) {
                if (view != null && c.this.cvC != null && c.this.cvC.getView() != null && c.this.cvC.cxc != null && bjVar != null && !StringUtils.isNull(bjVar.getTid())) {
                    if (view.getId() == d.h.card_root_view) {
                        com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 1);
                    } else if (view.getId() == d.h.avatar) {
                        com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cFj, bjVar.rZ());
                    }
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cvC = new com.baidu.tieba.frs.entelechy.view.h(this.mF, this.mPageId);
        this.cvC.i(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cvC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ax axVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.YJ() == null) {
            return null;
        }
        aVar.YJ().a((com.baidu.tieba.card.a) axVar);
        aVar.YJ().b(this.bkY);
        com.baidu.tieba.frs.f.b.alu().a(cFj, axVar);
        return aVar.getView();
    }
}
