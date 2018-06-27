package com.baidu.tbadk.m;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.a.e {
    public d(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.a.e
    public void b(int i, BdUniqueId bdUniqueId) {
        ReloginManager.yc().d(i, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a.e
    public void b(BdUniqueId bdUniqueId) {
        ReloginManager.yc().g(bdUniqueId);
    }
}
