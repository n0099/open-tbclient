package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes4.dex */
class ao implements ad {
    @Override // com.baidu.tieba.frs.ad
    public h<ICardInfo, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.c.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.ad
    public com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == bh.bLi) {
            return new com.baidu.tieba.frs.entelechy.a.c(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ad
    public com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.u.jfa) {
            return new com.baidu.tieba.frs.entelechy.a.b(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == bh.bLa) {
            return new com.baidu.tieba.frs.entelechy.a.u(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ad
    public com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.t(tbPageContext, bh.bLa, bdUniqueId, z);
    }
}
