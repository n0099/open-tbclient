package com.baidu.tbadk.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.a.e;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public class b extends e {
    public b(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.a.e
    public void b(int i, BdUniqueId bdUniqueId) {
        ReloginManager.tm().d(i, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a.e
    public void b(BdUniqueId bdUniqueId) {
        ReloginManager.tm().g(bdUniqueId);
    }
}
