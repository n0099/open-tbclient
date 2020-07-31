package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes16.dex */
public interface an {
    com.baidu.adp.widget.ListView.a<? extends bv, ? extends ad.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z);

    com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z);

    j<ICardInfo, ? extends ad.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);

    com.baidu.adp.widget.ListView.a<? extends bv, ? extends ad.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);
}
