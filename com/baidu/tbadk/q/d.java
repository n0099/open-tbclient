package com.baidu.tbadk.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.b.e {
    public d(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.b.e
    public void b(int i, BdUniqueId bdUniqueId) {
        ReloginManager.brp().d(i, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b.e
    public void b(BdUniqueId bdUniqueId) {
        ReloginManager.brp().k(bdUniqueId);
    }
}
