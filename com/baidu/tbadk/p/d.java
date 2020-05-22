package com.baidu.tbadk.p;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.b.e {
    public d(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.b.e
    public void b(int i, BdUniqueId bdUniqueId) {
        ReloginManager.aTQ().d(i, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b.e
    public void b(BdUniqueId bdUniqueId) {
        ReloginManager.aTQ().k(bdUniqueId);
    }
}
