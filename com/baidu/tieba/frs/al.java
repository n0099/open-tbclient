package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes2.dex */
public interface al {
    com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z);

    com.baidu.adp.widget.ListView.a<? extends by, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z);

    k<ICardInfo, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);

    com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);
}
