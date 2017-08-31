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
    private x bkZ;
    private com.baidu.tieba.frs.entelechy.view.h cuK;
    private TbPageContext<?> mF;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bkZ = new x<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bj bjVar) {
                if (view != null && c.this.cuK != null && c.this.cuK.getView() != null && c.this.cuK.cwk != null && bjVar != null && !StringUtils.isNull(bjVar.getTid())) {
                    if (view.getId() == d.h.card_root_view) {
                        com.baidu.tieba.frs.f.b.alj().a(com.baidu.tieba.frs.f.c.cEr, bjVar, 1);
                    } else if (view.getId() == d.h.avatar) {
                        com.baidu.tieba.frs.f.b.alj().a(com.baidu.tieba.frs.f.c.cEr, bjVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cEr, bjVar.rZ());
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
        this.cuK = new com.baidu.tieba.frs.entelechy.view.h(this.mF, this.mPageId);
        this.cuK.i(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cuK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ax axVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Yy() == null) {
            return null;
        }
        aVar.Yy().a((com.baidu.tieba.card.a) axVar);
        aVar.Yy().b(this.bkZ);
        com.baidu.tieba.frs.f.b.alj().a(cEr, axVar);
        return aVar.getView();
    }
}
