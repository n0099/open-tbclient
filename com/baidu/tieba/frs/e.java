package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public class e implements an {
    public static final AtomicReference<an> hyG = new AtomicReference<>(null);
    private static final an hyH = new e();

    private e() {
    }

    public static an bXm() {
        an anVar = hyG.get();
        return anVar == null ? hyH : anVar;
    }

    @Override // com.baidu.tieba.frs.an
    public j<ICardInfo, ? extends ad.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.an
    public com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.an
    public com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.an
    public com.baidu.adp.widget.ListView.a<? extends bt, ? extends ad.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
