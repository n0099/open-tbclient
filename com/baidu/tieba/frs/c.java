package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.a;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements bz {
    public static final AtomicReference<bz> bMv = new AtomicReference<>(null);
    private static final bz bMw = new c();

    private c() {
    }

    public static bz Yp() {
        bz bzVar = bMv.get();
        return bzVar == null ? bMw : bzVar;
    }

    @Override // com.baidu.tieba.frs.bz
    public at<ICardInfo, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.bz
    public a<? extends com.baidu.tbadk.core.data.bj, ? extends y.a> b(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.bz
    public a<? extends com.baidu.tbadk.core.data.bj, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
