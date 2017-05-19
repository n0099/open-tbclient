package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements b {
    final /* synthetic */ RecommendFrsControlFragment ctq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.ctq = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void aq(int i, int i2) {
        boolean z;
        q qVar;
        int i3 = TbadkCoreApplication.isLogin() ? 1 : 0;
        z = this.ctq.cth;
        int i4 = z ? 0 : i3;
        qVar = this.ctq.ctd;
        qVar.d(1, i, 1, i2, i4);
        this.ctq.cth = false;
        if (com.baidu.adp.lib.util.i.gY()) {
            TiebaStatic.log(new as("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void u(int i, int i2, int i3) {
        q qVar;
        qVar = this.ctq.ctd;
        qVar.d(2, i2, i, i3, 0);
        if (com.baidu.adp.lib.util.i.gY()) {
            TiebaStatic.log(new as("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void i(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
        if (TbadkCoreApplication.isLogin() && !z) {
            return;
        }
        this.ctq.aQ(list);
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void ahc() {
        this.ctq.ahe();
    }
}
