package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public interface af {
    com.baidu.adp.widget.ListView.a<? extends bl, ? extends j.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z);

    d<ICardInfo, ? extends j.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);

    com.baidu.adp.widget.ListView.a<? extends bl, ? extends j.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);
}
