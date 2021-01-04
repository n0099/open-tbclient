package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes2.dex */
class az implements al {
    @Override // com.baidu.tieba.frs.al
    public k<ICardInfo, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.lego.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.al
    public com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == bz.eUW) {
            return new com.baidu.tieba.frs.entelechy.adapter.h(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.al
    public com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.x.nqn) {
            return new com.baidu.tieba.frs.entelechy.adapter.e(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == bz.eUO) {
            return new com.baidu.tieba.frs.entelechy.adapter.ag(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.al
    public com.baidu.adp.widget.ListView.a<? extends by, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new com.baidu.tieba.frs.entelechy.adapter.af(tbPageContext, bz.eUO, bdUniqueId, z);
    }
}
