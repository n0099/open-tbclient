package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements c {
    final /* synthetic */ RecommendFrsControlFragment cCw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cCw = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void u(int i, int i2, int i3) {
        q qVar;
        qVar = this.cCw.cCj;
        qVar.a(1, true, i, i2, 1, i3);
        if (com.baidu.adp.lib.util.i.fZ()) {
            TiebaStatic.log(new ax("c11032").s("obj_source", 1));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void k(int i, int i2, int i3, int i4) {
        q qVar;
        qVar = this.cCw.cCj;
        qVar.a(2, false, i, i3, i2, i4);
        if (com.baidu.adp.lib.util.i.fZ()) {
            TiebaStatic.log(new ax("c11032").s("obj_source", 2));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void bo(List<TagInfo> list) {
        this.cCw.bp(list);
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void alL() {
        this.cCw.alO();
    }
}
