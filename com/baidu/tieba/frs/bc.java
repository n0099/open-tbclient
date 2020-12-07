package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes22.dex */
class bc implements ao {
    @Override // com.baidu.tieba.frs.ao
    public k<ICardInfo, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.c.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.ao
    public com.baidu.adp.widget.ListView.a<? extends by, ? extends af.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == by.eLc) {
            return new com.baidu.tieba.frs.entelechy.a.h(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ao
    public com.baidu.adp.widget.ListView.a<? extends by, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.x.nkD) {
            return new com.baidu.tieba.frs.entelechy.a.f(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == by.eKU) {
            return new com.baidu.tieba.frs.entelechy.a.af(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ao
    public com.baidu.adp.widget.ListView.a<? extends bx, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.ae(tbPageContext, by.eKU, bdUniqueId, z);
    }
}
