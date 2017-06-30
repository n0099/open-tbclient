package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements b {
    final /* synthetic */ RecommendFrsControlFragment cHu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cHu = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void aw(int i, int i2) {
        boolean z;
        q qVar;
        int i3 = TbadkCoreApplication.isLogin() ? 1 : 0;
        z = this.cHu.cHl;
        int i4 = z ? 0 : i3;
        qVar = this.cHu.cHh;
        qVar.d(1, i, 1, i2, i4);
        this.cHu.cHl = false;
        if (com.baidu.adp.lib.util.i.gX()) {
            TiebaStatic.log(new au("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void v(int i, int i2, int i3) {
        q qVar;
        qVar = this.cHu.cHh;
        qVar.d(2, i2, i, i3, 0);
        if (com.baidu.adp.lib.util.i.gX()) {
            TiebaStatic.log(new au("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void j(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
        if (TbadkCoreApplication.isLogin() && !z) {
            return;
        }
        this.cHu.aZ(list);
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void amc() {
        this.cHu.ame();
    }
}
