package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements c {
    final /* synthetic */ RecommendFrsControlFragment cHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cHJ = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void t(int i, int i2, int i3) {
        q qVar;
        qVar = this.cHJ.cHw;
        qVar.a(1, true, i, i2, 1, i3);
        if (com.baidu.adp.lib.util.i.fZ()) {
            TiebaStatic.log(new av("c11032").s("obj_source", 1));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void j(int i, int i2, int i3, int i4) {
        q qVar;
        qVar = this.cHJ.cHw;
        qVar.a(2, false, i, i3, i2, i4);
        if (com.baidu.adp.lib.util.i.fZ()) {
            TiebaStatic.log(new av("c11032").s("obj_source", 2));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void bq(List<TagInfo> list) {
        this.cHJ.br(list);
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void anG() {
        this.cHJ.anJ();
    }
}
