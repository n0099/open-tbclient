package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements c {
    final /* synthetic */ RecommendFrsControlFragment cBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cBR = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void s(int i, int i2, int i3) {
        q qVar;
        qVar = this.cBR.cBF;
        qVar.a(1, true, i, i2, 1, i3);
        if (com.baidu.adp.lib.util.i.fZ()) {
            TiebaStatic.log(new ay("c11032").s("obj_source", 1));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void j(int i, int i2, int i3, int i4) {
        q qVar;
        qVar = this.cBR.cBF;
        qVar.a(2, false, i, i3, i2, i4);
        if (com.baidu.adp.lib.util.i.fZ()) {
            TiebaStatic.log(new ay("c11032").s("obj_source", 2));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void bo(List<TagInfo> list) {
        this.cBR.bp(list);
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void alx() {
        this.cBR.alA();
    }
}
