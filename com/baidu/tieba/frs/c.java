package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.a;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements di {
    public static final AtomicReference<di> bDn = new AtomicReference<>(null);
    private static final di bDo = new c();

    private c() {
    }

    public static di Vz() {
        di diVar = bDn.get();
        return diVar == null ? bDo : diVar;
    }

    @Override // com.baidu.tieba.frs.di
    public bj<ICardInfo, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.di
    public a<? extends com.baidu.tbadk.core.data.be, ? extends y.a> b(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.di
    public a<? extends com.baidu.tbadk.core.data.be, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
