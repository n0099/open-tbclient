package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public class c implements ai {
    public static final AtomicReference<ai> gXn = new AtomicReference<>(null);
    private static final ai gXo = new c();

    private c() {
    }

    public static ai bNN() {
        ai aiVar = gXn.get();
        return aiVar == null ? gXo : aiVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public h<ICardInfo, ? extends y.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ai
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ai
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ai
    public com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
