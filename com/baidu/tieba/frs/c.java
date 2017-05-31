package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.a;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements bv {
    public static final AtomicReference<bv> bTu = new AtomicReference<>(null);
    private static final bv bTv = new c();

    private c() {
    }

    public static bv ZH() {
        bv bvVar = bTu.get();
        return bvVar == null ? bTv : bvVar;
    }

    @Override // com.baidu.tieba.frs.bv
    public p<ICardInfo, ? extends z.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.bv
    public a<? extends com.baidu.tbadk.core.data.bl, ? extends z.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.bv
    public a<? extends com.baidu.tbadk.core.data.bl, ? extends z.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
