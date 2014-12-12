package com.baidu.tbadk.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.a.e;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public class b extends e {
    public b(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.a.e
    public void a(int i, BdUniqueId bdUniqueId) {
        ReloginManager.ob().c(i, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a.e
    public void b(BdUniqueId bdUniqueId) {
        ReloginManager.ob().g(bdUniqueId);
    }
}
