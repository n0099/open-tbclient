package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<ax, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.h>> implements com.baidu.tieba.frs.e.c {
    private TbPageContext<?> alI;
    private x bkz;
    private com.baidu.tieba.frs.entelechy.view.h cnx;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bkz = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && c.this.cnx != null && c.this.cnx.getView() != null && c.this.cnx.coW != null && blVar != null && !StringUtils.isNull(blVar.getTid())) {
                    if (view.getId() == d.h.card_root_view) {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 1);
                    } else if (view.getId() == d.h.avatar) {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cvL, blVar.sd());
                    }
                }
            }
        };
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cnx = new com.baidu.tieba.frs.entelechy.view.h(this.alI, this.mPageId);
        this.cnx.i(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cnx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ax axVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Xc() == null) {
            return null;
        }
        aVar.Xc().a((com.baidu.tieba.card.a) axVar);
        aVar.Xc().a(this.bkz);
        com.baidu.tieba.frs.e.b.aiY().a(cvL, axVar);
        return aVar.getView();
    }
}
